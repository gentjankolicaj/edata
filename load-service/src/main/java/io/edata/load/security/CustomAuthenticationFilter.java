package io.edata.load.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * I didn't register this class as component because of :
 * https://stackoverflow.com/questions/34233856/spring-security-authenticationmanager-must-be-specified-for-custom-filter
 * More details are needed to be read when implementing customAuthenticationFilters at spring
 * security
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {

    String username = super.obtainUsername(request);
    String password = super.obtainPassword(request);
    String email = request.getParameter("email");

    //Create my customAuthenticationToken
    CustomAuthenticationToken customAuthenticationToken = new CustomAuthenticationToken(username,
        password, email);

    //Save references globally
    super.setDetails(request, customAuthenticationToken);

    /**
     * I call method authenticate from authenticationManager,by calling this method
     * authenticationManager to calls authenticate method of an implemented authentication provider
     *
     */
    return this.getAuthenticationManager().authenticate(customAuthenticationToken);
  }
}
