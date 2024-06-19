package io.edata.load.command.nasa.power;


import io.edata.load.command.TemperatureUnitCmd;
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
public class PowerTemperatureCmd implements Item {

  @NotNull
  private Long id;

  @NotNull
  private Float value;

  @NotNull
  private TemperatureUnitCmd temperatureUnitCmd;

  @NotNull
  private LocalDate date;

  @NotNull
  private String url;


  @Override
  public Attribute getAttribute() {
    Attribute attribute = new Attribute();
    attribute.setName("Temperature");
    attribute.setValue(this.value);
    return attribute;
  }
}
