# uaa 
本示例认证和授权服务放在一起了
@EnableResourceServer 启用资源服务注解
@EnableAuthorizationServer 启用授权服务注解

# 测试

# 流程解析

最后，代码的一个执行流程捋一捋：

1, 首先我们去访问 order 的 http://localhost:8083/orderSystem/order/list 接口，
但是这个接口是需要登录才能访问的，因此我们的请求被拦截下来，拦截下来之后，系统会给我们重定向到 order 的 /login 接口，这是让我们去登录。
![doc\image\img.png](.\\doc\\image\\img.png)

2, 当我们去访问 order 的登录接口时，由于我们配置了 @EnableOAuth2Sso 注解，
这个操作会再次被拦截下来，单点登录拦截器会根据我们在 application.properties 中的配置，自动发起请求去获取授权码：
![doc\image\img_1.png](.\doc\image\img_1.png)

3, 发送的请求是请求 uaa 服务上的东西，这次请求当然也避免不了要先登录，所以再次重定向到 uaa 的登录页面，也就是大家看到的统一认证中心。
![doc\image\img_3.png](.\doc\image\img_3.png)
4, 在统一认真中心我们完成登录功能，登录完成之后，会继续执行第二步的请求，这个时候就可以成功获取到授权码了。
![doc\image\img_4.png](.\doc\image\img_4.png)
5, 获取到授权码之后，这个时候会重定向到我们 order 的 login 页面，但是实际上我们的order其实是没有登录页面的，所以这个操作依然会被拦截，
此时拦截到的地址包含有授权码，拿着授权码，在 OAuth2ClientAuthenticationProcessingFilter 类中向 uaa 发起请求，就能拿到 access_token 了。


6, 在拿到 access_token 之后，接下来在向我们配置的 user-info-uri 地址发送请求，获取登录用户信息，
拿到用户信息之后，在 order 上自己再走一遍 Spring Security 登录流程，这就 OK 了。
