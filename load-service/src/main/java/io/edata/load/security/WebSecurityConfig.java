package io.gentjankolicaj.app.edata.load.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//In this class we config security details
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Autowired
  private CustomAuthenticationProvider customAuthenticationProvider;


  //config my customAuthenticationProvider
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(customAuthenticationProvider);

  }


  //Configuration for resource authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();

    http.authorizeRequests()
        .antMatchers("/h2-console/").permitAll()
        .antMatchers("/help").permitAll()
        .antMatchers("/contact").permitAll()
        .antMatchers("/about").permitAll()
        .antMatchers("/home").permitAll()
        .antMatchers("/sign").permitAll()
        .antMatchers("/user/**").authenticated()
        .antMatchers("/api/**").permitAll()
        .and()
        .formLogin().loginPage("/sign/").permitAll();
  }
}
