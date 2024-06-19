package io.edata.load.statistic.inferential;

import io.edata.load.statistic.core.AbstractStatisticFactory;
import io.edata.load.statistic.core.StatisticFactoryType;

public class InferentialStatisticFactory extends AbstractStatisticFactory {


  @Override
  public StatisticFactoryType getFactoryType() {
    return StatisticFactoryType.INFERENTIAL;
  }

}
