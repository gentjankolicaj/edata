package io.edata.load.command;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryCmd {

  @NotNull
  private String countryName;

  @NotNull
  private String phonePrefix;

  @NotNull
  private String isoCodes;

  private List<LanguageCmd> languagesCommand;

}
