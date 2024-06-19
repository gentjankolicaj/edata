package io.edata.load.command.nasa.power;

import io.edata.load.command.PressureUnitCmd;
import io.edata.load.statistic.core.Attribute;
import io.edata.load.statistic.core.Item;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerPressureCmd implements Item {

  @NotNull
  private Long id;


  @NotNull
  private Float value;

  @NotNull
  private PressureUnitCmd pressureUnitCmd;

  @NotNull
  private LocalDate date;

  @Override
  public Attribute getAttribute() {
    Attribute attribute = new Attribute();
    attribute.setName("Pressure");
    attribute.setValue(this.value);
    return attribute;
  }
}
