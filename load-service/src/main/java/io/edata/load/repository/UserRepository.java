package io.gentjankolicaj.app.edata.load.repository;

import io.edata.commons.domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findUserByUsername(String username);

  Optional<User> findUserByEmailAndPassword(String email, String password);


}
