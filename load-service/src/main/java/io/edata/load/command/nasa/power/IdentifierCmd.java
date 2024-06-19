package io.gentjankolicaj.app.edata.load.command.nasa.power;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierCmd {

  @NotNull
  private String identifier;

}
