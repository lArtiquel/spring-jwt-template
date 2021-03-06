package com.jwt.templates.arti_tsv.config;

import com.jwt.templates.arti_tsv.security.AuthenticationProviderImpl;
import com.jwt.templates.arti_tsv.security.jwt.JwtAuthenticationFailureHandler;
import com.jwt.templates.arti_tsv.security.jwt.JwtAuthenticationFilter;
import com.jwt.templates.arti_tsv.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security Configuration class extends {@code WebSecurityConfigurerAdapter}
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.config.permitAllRoutes}")
    private String[] permitAllRoutes;

    /** Service used to fetch UserDetails */
    private UserDetailsServiceImpl userDetailsService;
    /** Used to commence http request properly */
    private JwtAuthenticationFailureHandler unauthorizedHandler;
    /** Jwt authentication filter */
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, JwtAuthenticationFailureHandler unauthorizedHandler,
                             JwtAuthenticationFilter jwtAuthFilter) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtAuthFilter = jwtAuthFilter;

    }

    /**
     * Create BCrypt password encoder bean.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Create custom authentication provider bean.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new AuthenticationProviderImpl(userDetailsService, passwordEncoder());
    }

    /** Configure authentication manager (provide custom authentication provider). */
    @Override
    protected void configure(AuthenticationManagerBuilder authManager) throws Exception {
        authManager.authenticationProvider(authenticationProvider());
    }

    /** Create authentication manager bean. */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    /** Configure WebSecurity */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // any static resources here
//        web.ignoring().antMatchers(HttpMethod.GET, "/**");
//    }

    /** Configure HttpSecurity */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()   // adds the Spring-provided CorsFilter to the application context which bypasses the authorization checks for OPTIONS requests.
                .csrf().disable()   // disable CSRF token checks on server
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(permitAllRoutes).permitAll()
                .antMatchers("/api/board/user").hasRole("USER")
                .antMatchers("/api/board/admin").hasRole("ADMIN");
    }

}
