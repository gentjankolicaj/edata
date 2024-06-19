package io.edata.load.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderCmd {

  M("M"), F("F"), O("O");

  private final String value;

}
