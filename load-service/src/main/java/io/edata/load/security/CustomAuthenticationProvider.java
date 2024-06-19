package io.edata.load.security;

import io.edata.commons.domain.User;
import io.edata.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


  @Autowired
  private UserService userService;


  @Autowired
  private TokenService tokenService;


  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;

    User user = userService.getByUsername(token.getName());

    CustomUserDetails customUserDetails = new CustomUserDetails(user);

    if ((user == null) || (!user.getPassword().equals(token.getCredentials().toString())
        || (!user.getUsername().equals(token.getName())))) {
      throw new BadCredentialsException("Credentials are invalid");
    } else {
      return new CustomAuthenticationToken(customUserDetails, customUserDetails.getPassword(),
          customUserDetails.getAuthorities(), user.getEmail());
    }


  }

  @Override
  public boolean supports(Class<?> aClass) {
    return aClass.equals(CustomAuthenticationToken.class);
  }
}
