package com.example.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("webapp").secret("secret") //客户端 id/secret
                .authorizedGrantTypes("authorization code") //授权妈模式
                .scopes("user_info")
                .autoApprove(true) //自动审批
                .accessTokenValiditySeconds(3600); //有效期1hour
    }
}

