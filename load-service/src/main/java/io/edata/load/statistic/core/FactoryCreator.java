package io.edata.load.statistic.core;

import io.edata.load.statistic.descriptive.DescriptiveStatisticFactory;
import io.edata.load.statistic.inferential.InferentialStatisticFactory;

public class FactoryCreator {

  public static AbstractStatisticFactory getFactory(StatisticFactoryType type) {
    if (type.equals(StatisticFactoryType.DESCRIPTIVE)) {
      return new DescriptiveStatisticFactory();
    } else if (type.equals(StatisticFactoryType.INFERENTIAL)) {
      return new InferentialStatisticFactory();
    } else {
      return null;
    }
  }
}
