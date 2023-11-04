package com.fot.HosatalManagment.configuration;

import com.fot.HosatalManagment.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Autowired
    private CustomUserDetailsService userDetailsService;



    @Bean
    AuthenticationManager authenticationProvider() throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        AuthenticationManager authenticationManager = new ProviderManager(provider);
        return authenticationManager;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/student/viewallstudent").permitAll();
                    auth.requestMatchers("/student/register").permitAll();
                    auth.requestMatchers("/rooms/all").permitAll();
                    auth.requestMatchers("/student/login").permitAll();
                    auth.requestMatchers("/hostels/{hostelName}").permitAll();
                    auth.requestMatchers("/student/findstudent/{registrationNumber}").hasAuthority("ADMIN");
                    auth.requestMatchers("/user").hasAuthority("USER");
                    auth.requestMatchers("/register").hasAuthority("STUDENT");
                    auth.requestMatchers("/admin").hasAuthority("ADMIN");
                })
                .httpBasic(withDefaults())
                .authenticationManager(authenticationProvider())
                .build();
    }


}
