package org.cedacri.spring.cedintlibra.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.authorizeHttpRequests((requests) -> requests
                .anyRequest().authenticated()
        )
                .formLogin((form) -> form.loginPage("/libra/login").permitAll()
                        .usernameParameter("login")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/libra/home", true)
                )
                .logout((logout) -> logout.permitAll()
                        .logoutUrl("/libra/logout")
                        .logoutSuccessUrl("/libra/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build() ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordUtil();
    }
}
