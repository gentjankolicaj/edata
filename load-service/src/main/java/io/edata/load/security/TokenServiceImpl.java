package io.gentjankolicaj.app.edata.load.security;

import io.edata.commons.domain.User;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class TokenServiceImpl implements TokenService {

  //todo: I need to inject appropriate components to receive assigned tokens from third party

  @Override
  public List<CustomToken> getTokens(String username, String password) {
    return null;
  }

  @Override
  public List<CustomToken> getTokens(String username, String email, String password) {
    return null;
  }

  @Override
  public List<CustomToken> getTokens(User user) {
    return null;
  }
}
