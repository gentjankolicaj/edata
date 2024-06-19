package io.edata.load.command;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCmd {

  @NotNull
  private Long id;

  @NotNull
  private List<RoleCmd> rolesCommand;

  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private String email;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;

  @NotNull
  private GenderCmd genderCmd;

  private Date birthday;

  private String birthplace;

  @NotNull
  private CountryCmd countryCmd;

  @NotNull
  private String rights;

  private Date createdDate;

  private Date updatedDate;
}
