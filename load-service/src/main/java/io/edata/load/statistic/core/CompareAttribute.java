package io.edata.load.statistic.core;

import java.util.Comparator;

public class CompareAttribute implements Comparator<Attribute> {

  @Override
  public int compare(Attribute o1, Attribute o2) {
    return (int) (o1.getValue() - o2.getValue());
  }
}
