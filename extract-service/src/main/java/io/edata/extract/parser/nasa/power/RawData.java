package io.edata.extract.parser.nasa.power;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawData {

  private LocalDate date;
  private Float value;
  private String url;
  private Header header;
  private ParameterInformation parameterInformation;

}
