package io.gentjankolicaj.app.edata.load.service;

import io.edata.commons.domain.User;
import io.gentjankolicaj.app.edata.load.command.UserCmd;
import io.gentjankolicaj.app.edata.load.dto.UserDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.exception.resource.UserNotFoundException;
import io.gentjankolicaj.app.edata.load.mapper.UserCustomMapper;
import io.gentjankolicaj.app.edata.load.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  //todo: implementing not implemented methods from datalayer

  private final UserRepository userRepository;
  private final UserCustomMapper userMapper;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, UserCustomMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public List<UserDTO> getAllDTO() {
    List<UserDTO> list = new ArrayList<>();
    Iterable<User> iterable = userRepository.findAll();
    for (User temp : iterable) {
      list.add(userMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<UserCmd> getAllCommand() {
    List<UserCmd> list = new ArrayList<>();
    Iterable<User> iterable = userRepository.findAll();
    for (User temp : iterable) {
      list.add(userMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public UserDTO saveDTO(UserDTO userDTO) {
    if (userDTO == null) {
      throw new NullReferenceException("User not saved.Reference passed is null !!!");
    } else {
      User savedUser = userRepository.save(userMapper.dtoToSource(userDTO));
      return userMapper.sourceToDto(savedUser);
    }
  }

  @Override
  public UserCmd saveCommand(UserCmd userCmd) {
    if (userCmd == null) {
      throw new NullReferenceException("User not saved.Reference passed is null !!!");
    } else {
      User savedUser = userRepository.save(userMapper.commandToSource(userCmd));
      return userMapper.sourceToCommand(savedUser);
    }
  }

  @Override
  public UserDTO updateDTO(UserDTO userDTO) {
    if (userDTO == null) {
      throw new NullReferenceException("User not updated.Reference passed is null !!!.");
    } else {
      User newUser = userMapper.dtoToSource(userDTO);
      Optional<User> optional = userRepository.findById(newUser.getId());
      if (!optional.isPresent()) {
        User savedUser = userRepository.save(newUser);
        return userMapper.sourceToDto(savedUser);
      } else {
        User actual = optional.get();
        actual.setUsername(newUser.getUsername());
        actual.setPassword(newUser.getPassword());
        actual.setEmail(newUser.getEmail());
        actual.setFirstName(newUser.getFirstName());
        actual.setLastName(newUser.getLastName());
        actual.setGender(newUser.getGender());
        actual.setBirthday(newUser.getBirthday());
        actual.setBirthplace(newUser.getBirthplace());
        actual.setRights(newUser.getRights());
        actual.setCountry(newUser.getCountry());
        actual.setCreatedDate(newUser.getCreatedDate());
        actual.setUpdatedDate(newUser.getUpdatedDate());
        return userMapper.sourceToDto(actual);
      }
    }
  }

  @Override
  public UserCmd updateCommand(UserCmd userCmd) {
    if (userCmd == null) {
      throw new NullReferenceException("User not updated.Reference passed is null !!!.");
    } else {
      User newUser = userMapper.commandToSource(userCmd);
      Optional<User> optional = userRepository.findById(newUser.getId());
      if (!optional.isPresent()) {
        User savedUser = userRepository.save(newUser);
        return userMapper.sourceToCommand(savedUser);
      } else {
        User actual = optional.get();
        actual.setUsername(newUser.getUsername());
        actual.setPassword(newUser.getPassword());
        actual.setEmail(newUser.getEmail());
        actual.setFirstName(newUser.getFirstName());
        actual.setLastName(newUser.getLastName());
        actual.setGender(newUser.getGender());
        actual.setBirthday(newUser.getBirthday());
        actual.setBirthplace(newUser.getBirthplace());
        actual.setRights(newUser.getRights());
        actual.setCountry(newUser.getCountry());
        actual.setCreatedDate(newUser.getCreatedDate());
        actual.setUpdatedDate(newUser.getUpdatedDate());
        return userMapper.sourceToCommand(actual);
      }
    }
  }

  @Override
  public UserDTO getByIdDTO(Long id) {
    if (id == null) {
      throw new NullIdException("User id is null.");
    } else {
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with id " + id + " not found.");
      } else {
        return userMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public UserCmd getByIdCommand(Long id) {
    if (id == null) {
      throw new NullIdException("User id is null.");
    } else {
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with id " + id + " not found.");
      } else {
        return userMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public User getById(Long id) {
    if (id == null) {
      throw new NullIdException("User id is null.");
    } else {
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with id " + id + " not found.");
      } else {
        return optional.get();
      }
    }
  }

  @Override
  public void deleteDTO(UserDTO userDTO) {
    if (userDTO == null) {
      throw new NullReferenceException("User not deleted.Reference passed is null !!!");
    } else {
      User user = userMapper.dtoToSource(userDTO);
      userRepository.delete(user);
    }
  }

  @Override
  public void deleteCommand(UserCmd userCmd) {
    if (userCmd == null) {
      throw new NullReferenceException("User not deleted.Reference passed is null !!!");
    } else {
      User user = userMapper.commandToSource(userCmd);
      userRepository.delete(user);
    }
  }

  @Override
  public UserDTO getByEmailAndPasswordDTO(String email, String password) {
    if (email == null || password == null) {
      throw new NullIdException("User email or password null");
    } else {
      Optional<User> optional = userRepository.findUserByEmailAndPassword(email, password);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with email " + email + " not found.");
      } else {
        return userMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public UserCmd getByEmailAndPasswordCommand(String email, String password) {
    if (email == null || password == null) {
      throw new NullIdException("User email or password null");
    } else {
      Optional<User> optional = userRepository.findUserByEmailAndPassword(email, password);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with email " + email + " not found.");
      } else {
        return userMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public User getByUsername(String username) {
    if (username == null) {
      throw new NullReferenceException("Username is null.Reference passed is null !!!.");
    } else {
      Optional<User> optional = userRepository.findUserByUsername(username);
      if (!optional.isPresent()) {
        throw new UserNotFoundException("User with username " + username + " not found.");
      } else {
        return optional.get();
      }
    }
  }


}
