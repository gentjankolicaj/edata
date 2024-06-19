package io.edata.load;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.edata.load.command.nasa.power.PowerPressureCmd;
import io.edata.load.statistic.core.FactoryCreator;
import io.edata.load.statistic.core.Item;
import io.edata.load.statistic.core.StatisticFactoryType;
import io.edata.load.statistic.descriptive.DescriptiveStatisticFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class DescriptiveStatisticFactoryTest {

  private static final float[] testValues = {1f, 2.32453f, -30f, 0.234f, -15.5f, 100f};

  @Test
  public void getMean() {

    //This impl is ok
    DescriptiveStatisticFactory factory = (DescriptiveStatisticFactory) FactoryCreator.getFactory(
        StatisticFactoryType.DESCRIPTIVE);

    Float actualMedian = actualMean(testValues);
    Float expecteMedian = factory.getMean(getTestItems());

    assertEquals(actualMedian.floatValue(), expecteMedian.floatValue());

  }

  @Test
  public void getMedian() {
    //todo: I need to look into statistics to remind concepts to finish impl accordingly
    float actualMedian = actualMedian(testValues);

  }

  @Test
  public void getMode() {
  }

  @Test
  public void getFactoryType() {
  }

  public List<Item> getTestItems() {
    PowerPressureCmd o1 = new PowerPressureCmd();
    o1.setValue(testValues[0]);
    PowerPressureCmd o2 = new PowerPressureCmd();
    o2.setValue(testValues[1]);
    PowerPressureCmd o3 = new PowerPressureCmd();
    o3.setValue(testValues[2]);
    PowerPressureCmd o4 = new PowerPressureCmd();
    o4.setValue(testValues[3]);
    PowerPressureCmd o5 = new PowerPressureCmd();
    o5.setValue(testValues[4]);
    PowerPressureCmd o6 = new PowerPressureCmd();
    o6.setValue(testValues[5]);
    List<Item> list = new ArrayList<>();
    list.add(o1);
    list.add(o2);
    list.add(o3);
    list.add(o4);
    list.add(o5);
    list.add(o6);
    return list;
  }

  private float actualMean(float[] array) {
    float total = 0f;
    for (float temp : array) {
      total += temp;
    }
    return total / array.length;
  }

  private float actualMedian(float[] array) {
    Arrays.sort(array);
    return array[array.length / 2];
  }
}