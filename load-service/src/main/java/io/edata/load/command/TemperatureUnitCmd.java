package io.gentjankolicaj.app.edata.load.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureUnitCmd {

  @NotNull
  private String unitCode;
  @NotNull
  private String unitName;
  @NotNull
  private String unitDescription;
}
