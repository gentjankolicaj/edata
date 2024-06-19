package io.gentjankolicaj.app.edata.load.dto.nasa.power;

import io.gentjankolicaj.app.edata.load.dto.PressureUnitDTO;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerPressureDTO {

  private Long id;


  private Float value;

  private PressureUnitDTO pressureUnitDTO;

  private LocalDate date;


}
