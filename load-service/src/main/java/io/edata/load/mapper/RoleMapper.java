package io.gentjankolicaj.app.edata.load.mapper;

import io.edata.commons.domain.Role;
import io.gentjankolicaj.app.edata.load.command.RoleCmd;
import io.gentjankolicaj.app.edata.load.dto.RoleDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

  RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

  @Mapping(source = "roleId", target = "roleId")
  @Mapping(source = "role", target = "role")
  RoleDTO sourceToDto(Role source);

  @Mapping(source = "roleId", target = "roleId")
  @Mapping(source = "role", target = "role")
  RoleCmd sourceToCommand(Role source);

  @Mapping(source = "roleId", target = "roleId")
  @Mapping(source = "role", target = "role")
  Role dtoToSource(RoleDTO dto);

  @Mapping(source = "roleId", target = "roleId")
  @Mapping(source = "role", target = "role")
  Role commandToSource(RoleCmd command);

  List<RoleDTO> sourceToDto(List<Role> source);

  List<RoleCmd> sourceToCommand(List<Role> source);
}
