//package com.fot.HosatalManagment.securityconfiguration;
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//public class Configuration extends WebSecurityConfiguration {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/public/**").permitAll() // Configure your URL patterns and access permissions here
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") // Configure your login page URL here
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//}
