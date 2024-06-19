package io.edata.load.command;

import io.edata.commons.enums.InformationScope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationCmd {

  private Long id;

  private LanguageCmd languageCmd;

  private InformationScope informationScope;

  private String field;

  private String subject;

  private String message;

  private String title;

  private String tip;

}
