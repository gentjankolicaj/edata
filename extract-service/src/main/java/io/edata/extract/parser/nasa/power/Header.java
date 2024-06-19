package io.edata.extract.parser.nasa.power;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Header {

  private String apiVersion;
  private String title;
  private Date startDate;
  private Date endDate;

}
