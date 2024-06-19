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
public class CountryDTO {

  private String countryName;

  private String phonePrefix;

  private String isoCodes;

  private List<LanguageDTO> languagesDTO;

}
