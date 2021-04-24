package com.project.config;


import com.project.Monitorix;
import com.project.service.MonitorixUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private MonitorixUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/registration").not().fullyAuthenticated()
                .antMatchers("/api/test").permitAll()
                .antMatchers("/api/monitoring").permitAll()
                .antMatchers("/api/monitoringLin").permitAll()
                .antMatchers("/api/user_agent").permitAll()
                .antMatchers("/api/user_agent/triggers").permitAll()
                .antMatchers("/api/user_agent/triggers/**").permitAll()
                .antMatchers("/api/user_agent/**").permitAll()

                .antMatchers("/api/user_agent/triggers/**").permitAll()
//                .antMatchers("/api/user_agent/download").permitAll()
//                .antMatchers("/api/user_agent/download/*").permitAll()
                .antMatchers("/scr/info").permitAll()
                .antMatchers("/scr/index").permitAll()
                .antMatchers("/scr/linux").permitAll()
                .antMatchers("/scr/test").permitAll()
                .antMatchers("/scr/trigger").permitAll()
                .antMatchers("/scr/triggerLin").permitAll()

//                .antMatchers("/api/test/download").permitAll()
//                .antMatchers("/api/test/upload").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        http.cors();


    }







    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
