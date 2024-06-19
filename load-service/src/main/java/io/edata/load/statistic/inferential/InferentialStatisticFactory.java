package io.gentjankolicaj.app.edata.load.statistic.inferential;

import io.gentjankolicaj.app.edata.load.statistic.core.AbstractStatisticFactory;
import io.gentjankolicaj.app.edata.load.statistic.core.StatisticFactoryType;

public class InferentialStatisticFactory extends AbstractStatisticFactory {


  @Override
  public StatisticFactoryType getFactoryType() {
    return StatisticFactoryType.INFERENTIAL;
  }

}
