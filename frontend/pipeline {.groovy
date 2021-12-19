pipeline {
  agent {
    node {
      label 'maven'
    }

  }
  stages {
    stage('clone code') {
      agent none
      steps {
        container('base') {
          git(credentialsId: 'cvicse-gitlab', url: 'http://192.168.128.6/cvicse-scm/yueli.git', changelog: true, poll: false)
        }

      }
    }



    stage('build & push') {
      parallel {
        stage('front-end build & push') {
          agent none
          steps {
            container('maven') {
              sh '''cd  front-end
                docker build -f Dockerfile -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER .
                '''
             
              withCredentials([usernamePassword(credentialsId : 'ali-registry' ,passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,)]) {
                sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
                sh 'docker push  $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER'
                
              }

            }

          }
        }
        

      }
    }

   

  }
  environment {
    DOCKER_CREDENTIAL_ID = 'cvicse'
    GITHUB_CREDENTIAL_ID = '192.168.128.6'
    KUBECONFIG_CREDENTIAL_ID = 'demo-kubeconfig'
    REGISTRY = 'registry.cn-hangzhou.aliyuncs.com'
    DOCKERHUB_NAMESPACE = 'cvicse'
    GITHUB_ACCOUNT = 'liu_zyong@cvicse.com'
    APP_NAME = 'front-end'
    APP_NAME1 = 'backend-flow'
    APP_NAME2 = 'backend-mongodb'
    APP_NAME3 = 'frontend-yueli'
  }
  parameters {
    string(name: 'TAG_NAME', defaultValue: '', description: '')
  }
}