package io.gentjankolicaj.app.edata.load.command;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCmd {

  private String language;
  private List<CountryCmd> countriesCommand;

}
