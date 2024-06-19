package io.edata.load.service;

import io.edata.commons.domain.User;
import io.edata.load.command.UserCmd;
import io.edata.load.dto.UserDTO;
import java.util.List;

public interface UserService {

  List<UserDTO> getAllDTO();

  List<UserCmd> getAllCommand();

  UserDTO saveDTO(UserDTO userDTO);

  UserCmd saveCommand(UserCmd userCmd);

  UserDTO updateDTO(UserDTO userDTO);

  UserCmd updateCommand(UserCmd userCmd);


  UserDTO getByIdDTO(Long id);

  UserCmd getByIdCommand(Long id);

  User getById(Long id);

  void deleteDTO(UserDTO userDTO);

  void deleteCommand(UserCmd userCmd);


  UserDTO getByEmailAndPasswordDTO(String email, String password);

  UserCmd getByEmailAndPasswordCommand(String email, String password);

  User getByUsername(String username);


}
