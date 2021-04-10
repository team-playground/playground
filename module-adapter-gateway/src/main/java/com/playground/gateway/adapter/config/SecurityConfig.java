package com.playground.gateway.adapter.config;

import com.playground.common.application.port.TokenProvider;
import com.playground.gateway.application.port.CustomOAuth2UseCase;
import com.playground.gateway.application.port.UserFindUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final OAuth2SuccessHandler successHandler;
    private final CustomOAuth2UseCase oAuth2UserService;
    private final TokenProvider tokenProvider;
    private final UserFindUseCase userFindUseCase;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                        .antMatchers("/token/**").permitAll()
                        .anyRequest().authenticated()
                .and()
                    .oauth2Login().loginPage("/token/auth")
                    .successHandler(successHandler)
                    .userInfoEndpoint().userService(oAuth2UserService);

        http.addFilterBefore(new JwtAuthFilter(userFindUseCase, tokenProvider), UsernamePasswordAuthenticationFilter.class);
    }
}
