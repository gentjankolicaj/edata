package io.gentjankolicaj.app.edata.load.statistic.core;

import io.gentjankolicaj.app.edata.load.statistic.descriptive.DescriptiveStatisticFactory;
import io.gentjankolicaj.app.edata.load.statistic.inferential.InferentialStatisticFactory;

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
