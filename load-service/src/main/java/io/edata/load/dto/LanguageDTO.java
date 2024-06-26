package io.edata.load.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

  private String language;

  private List<CountryDTO> countriesDTO;
}
