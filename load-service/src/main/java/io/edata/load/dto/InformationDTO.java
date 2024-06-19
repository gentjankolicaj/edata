package io.gentjankolicaj.app.edata.load.dto;

import io.edata.commons.enums.InformationScope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationDTO {

  private Long id;

  private LanguageDTO languageDTO;

  private InformationScope informationScope;

  private String field;

  private String subject;

  private String message;

  private String title;

  private String tip;
}
