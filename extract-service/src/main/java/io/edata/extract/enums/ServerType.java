package io.edata.extract.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerType {

  HTTP("http://"), TCP("tcp://");

  private final String name;

}
