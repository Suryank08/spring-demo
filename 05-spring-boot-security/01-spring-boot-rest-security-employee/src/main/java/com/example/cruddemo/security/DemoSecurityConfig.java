package com.example.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager useDetailsManager() {
//        UserDetails suryank = User.builder().username("suryank").password("{noop}suryank").roles("ADMIN").build();
//        UserDetails aditi = User.builder().username("aditi").password("{noop}aditi").roles("MANAGER").build();
//        UserDetails mausa = User.builder().username("mausa").password("{noop}mausa").roles("EMPLOYEE").build();
//        return new InMemoryUserDetailsManager(suryank, aditi, mausa);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //use HTTP basic configuration
        http.httpBasic(Customizer.withDefaults());
        //disabe Cross Site Request Forgery(CSRF)
        // in genral, not required for stateless REST APIs that uses POST,PUT,DELETE and/pr PATCH
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }

/***********
    ///used for default Users(as users) and Authorities(as authorities) table name in database in postgres

    /*users table must contains same as typed here no change default---> username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled` tinyint NOT NULL,
    PRIMARY KEY (`username`)*/

 /**********
    /* authorities table must contains by default-->
    CREATE TABLE `authorities` (
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`username`)
REFERENCES `users` (`username`)
     */

//    @Bean
////add support for JDBC.. no more hardcoded users:-)
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    /*****************
    //BETTER APPOROACH
    //Custom users and authorities tabel names as memebers and roles in this exmaple
    ********** */
 @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
     JdbcUserDetailsManager theUserDetails=new JdbcUserDetailsManager(dataSource);
     theUserDetails.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=? ");
     theUserDetails.setAuthoritiesByUsernameQuery("select user_id ,role from roles where user_id=?");
   return  theUserDetails;
 }


     }
