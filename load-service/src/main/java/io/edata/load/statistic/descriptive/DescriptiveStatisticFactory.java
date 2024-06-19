package io.edata.load.statistic.descriptive;

import io.edata.load.statistic.core.AbstractStatisticFactory;
import io.edata.load.statistic.core.BasicOperations;
import io.edata.load.statistic.core.Item;
import io.edata.load.statistic.core.StatisticFactoryType;
import java.util.List;

public class DescriptiveStatisticFactory extends AbstractStatisticFactory {


  public Float getMean(List<Item> itemList) {
    Float totalSum = BasicOperations.getSum(itemList);
    return totalSum / itemList.size();
  }

  public Float getMedian(List<Item> itemList) {
    return BasicOperations.getMedian(itemList);
  }

  public Float getMode(List<Item> itemList) {
    return null;
  }

  @Override
  public StatisticFactoryType getFactoryType() {
    return StatisticFactoryType.DESCRIPTIVE;
  }

}
