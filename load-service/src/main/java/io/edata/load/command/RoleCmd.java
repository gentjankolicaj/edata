package io.edata.load.command;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCmd {

  private Long roleId;
  private String role;
  private List<UserCmd> usersCommand;
}
