package io.gentjankolicaj.app.edata.load.security;

import io.edata.commons.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails extends User implements UserDetails {

  public CustomUserDetails() {
  }

  public CustomUserDetails(final User user) {
    super.setId(user.getId());
    super.setUsername(user.getUsername());
    super.setPassword(user.getPassword());
    super.setEmail(user.getEmail());
    super.setFirstName(user.getFirstName());
    super.setLastName(user.getLastName());
    super.setGender(user.getGender());
    super.setBirthday(user.getBirthday());
    super.setBirthplace(user.getBirthplace());
    super.setRights(user.getRights());
    super.setUpdatedDate(user.getUpdatedDate());
    super.setCreatedDate(user.getCreatedDate());


  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
    return grantedAuthorityList;

  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
