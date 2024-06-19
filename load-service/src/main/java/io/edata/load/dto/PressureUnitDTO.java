package io.gentjankolicaj.app.edata.load.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PressureUnitDTO {

  private String unitCode;

  private String unitName;

  private String unitDescription;
}
