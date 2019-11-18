package com.glodon.easyshow.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomWebSecurityConfigureAdapter
 * @Description 自定义WebSecurity
 * @Author fanwd
 * @Date 2019/11/4 22:50
 **/
@Component
public class CustomWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic()
//                .and()
//                // 关闭csrf
//                .csrf().disable()
//                // 关闭session
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
