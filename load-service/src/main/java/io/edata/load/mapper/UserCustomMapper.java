package io.gentjankolicaj.app.edata.load.mapper;

import io.edata.commons.domain.User;
import io.gentjankolicaj.app.edata.load.command.UserCmd;
import io.gentjankolicaj.app.edata.load.dto.UserDTO;
import io.gentjankolicaj.app.edata.load.mapper.core.CustomMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCustomMapper implements CustomMapper<User, UserDTO, UserCmd> {

  private final CountryMapper countryMapper;
  private final GenderCustomMapper genderMapper;
  private final RoleMapper roleMapper;

  @Autowired
  public UserCustomMapper(GenderCustomMapper genderMapper) {
    this.countryMapper = CountryMapper.INSTANCE;
    this.genderMapper = genderMapper;
    this.roleMapper = RoleMapper.INSTANCE;
  }

  @Override
  public UserDTO sourceToDto(User source) {
    if (source == null) {
      return null;
    } else {
      UserDTO userDTO = new UserDTO();
      userDTO.setId(source.getId());
      userDTO.setUsername(source.getUsername());
      userDTO.setPassword(source.getPassword());
      userDTO.setEmail(source.getEmail());
      userDTO.setFirstName(source.getFirstName());
      userDTO.setLastName(source.getLastName());
      userDTO.setGenderDTO(genderMapper.sourceToDto(source.getGender()));
      userDTO.setBirthday(source.getBirthday());
      userDTO.setBirthplace(source.getBirthplace());
      userDTO.setCountryDTO(countryMapper.sourceToDto(source.getCountry()));
      userDTO.setRights(source.getRights());
      userDTO.setUpdatedDate(source.getUpdatedDate());
      userDTO.setCreatedDate(source.getCreatedDate());
      return userDTO;
    }
  }

  @Override
  public UserCmd sourceToCommand(User source) {
    if (source == null) {
      return null;
    } else {
      UserCmd userCmd = new UserCmd();
      userCmd.setId(source.getId());
      userCmd.setUsername(source.getUsername());
      userCmd.setPassword(source.getPassword());
      userCmd.setEmail(source.getEmail());
      userCmd.setFirstName(source.getFirstName());
      userCmd.setLastName(source.getLastName());
      userCmd.setGenderCmd(genderMapper.sourceToCommand(source.getGender()));
      userCmd.setBirthday(source.getBirthday());
      userCmd.setBirthplace(source.getBirthplace());
      userCmd.setCountryCmd(countryMapper.sourceToCommand(source.getCountry()));
      userCmd.setRights(source.getRights());
      userCmd.setUpdatedDate(source.getUpdatedDate());
      userCmd.setCreatedDate(source.getCreatedDate());
      return userCmd;
    }
  }

  @Override
  public User dtoToSource(UserDTO dto) {
    if (dto == null) {
      return null;
    } else {
      User user = new User();
      user.setId(dto.getId());
      user.setUsername(dto.getUsername());
      user.setPassword(dto.getPassword());
      user.setEmail(dto.getEmail());
      user.setFirstName(dto.getFirstName());
      user.setLastName(dto.getLastName());
      user.setGender(genderMapper.dtoToSource(dto.getGenderDTO()));
      user.setBirthday(dto.getBirthday());
      user.setBirthplace(dto.getBirthplace());
      user.setCountry(countryMapper.dtoToSource(dto.getCountryDTO()));
      user.setRights(dto.getRights());
      user.setUpdatedDate(dto.getUpdatedDate());
      user.setCreatedDate(dto.getCreatedDate());
      return user;
    }
  }

  @Override
  public User commandToSource(UserCmd command) {
    if (command == null) {
      return null;
    } else {
      User user = new User();
      user.setId(command.getId());
      user.setUsername(command.getUsername());
      user.setPassword(command.getPassword());
      user.setEmail(command.getEmail());
      user.setLastName(command.getLastName());
      user.setFirstName(command.getFirstName());
      user.setGender(genderMapper.commandToSource(command.getGenderCmd()));
      user.setBirthplace(command.getBirthplace());
      user.setBirthday(command.getBirthday());
      user.setCountry(countryMapper.commandToSource(command.getCountryCmd()));
      user.setRights(command.getRights());
      user.setUpdatedDate(command.getUpdatedDate());
      user.setCreatedDate(command.getCreatedDate());
      return user;
    }
  }

  @Override
  public List<UserDTO> sourceToDto(List<User> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<UserDTO> tempList = new ArrayList<>(source.size());
      for (User temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }

  }

  @Override
  public List<UserCmd> sourceToCommand(List<User> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<UserCmd> tempList = new ArrayList<>(source.size());
      for (User temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }
}
