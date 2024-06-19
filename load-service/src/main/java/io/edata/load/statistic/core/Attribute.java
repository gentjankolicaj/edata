package io.edata.load.statistic.core;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attribute implements Comparator {

  private String name;
  private Float value;


  @Override
  public int compare(Object o1, Object o2) {
    return 0;
  }
}
