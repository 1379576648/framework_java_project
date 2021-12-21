//package com.trkj.framework.config;
//
//import com.netflix.discovery.converters.Auto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author 13795
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String pwd = passwordEncoder.encode("123");
//        System.out.println(pwd);
//        auth.inMemoryAuthentication().withUser("daXiong").password(pwd).roles("admin");
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //自定义自己编写的登录页面
//        http.formLogin().loginPage("/login.html")
//                //设置登录访问路径
//                .loginProcessingUrl("/user/login")
//                //登录后跳转路径
//                .defaultSuccessUrl("/index")
//                //允许向所有用户授予基于表单的登录相关的所有URL的访问权限
//                .permitAll()
//                .and().authorizeRequests()
//                //设置这些路径直接可以访问
//                .antMatchers("/", "/hello", "/user/login").permitAll()
//                //尚未匹配的任何URL 要求对用户进行身份验证
//                .anyRequest().authenticated()
//                .and().csrf().disable();
//        super.configure(http);
//    }
//}
