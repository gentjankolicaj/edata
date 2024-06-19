package io.edata.commons.enums.nasa.power;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataParameters {

  T2M("T2M"), T10M("T10M"), PS("PS");

  private String value;

}
