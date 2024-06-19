package io.gentjankolicaj.app.edata.load.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

  private Long roleId;

  private String role;

  private List<UserDTO> usersDTO;
}
