package io.edata.load.statistic.core;

import io.edata.load.statistic.core.exception.AttributeException;
import io.edata.load.statistic.core.exception.ItemException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicOperations {

  private static final Float globalMinThreshold = Float.MIN_VALUE;
  private static final Float globalMaxThreshold = Float.MAX_VALUE;

  public static Float getMaxValue(List<Item> itemList) {
    if (itemList == null || itemList.size() == 0) {
      throw new ItemException("Item list is null or empty !!!");
    } else {
      Float tempValue = globalMinThreshold;
      for (Item tempItem : itemList) {
        if (tempItem.getAttribute() == null) {
          throw new AttributeException("Attribute list is null!!!");
        } else {
          Float val = tempItem.getAttribute().getValue();
          if (val != null && val > tempValue) {
            tempValue = val;
          }
        }
      }

      return tempValue;
    }

  }

  public static Float getSum(List<Item> itemList) {
    if (itemList == null || itemList.size() == 0) {
      throw new ItemException("Item list is null or empty !!!");
    } else {
      Float tempValue = 0f;
      for (Item tempItem : itemList) {
        if (tempItem.getAttribute() == null) {
          throw new AttributeException("Attribute list is null or empty !!!");
        } else {

          Float val = tempItem.getAttribute().getValue();
          if (val != null) {
            tempValue += val;
          }
        }
      }

      return tempValue;
    }

  }

  public static Float getMinValue(List<Item> itemList) {
    if (itemList == null || itemList.size() == 0) {
      throw new ItemException("Item list is null or empty !!!");
    } else {
      Float tempValue = globalMaxThreshold;
      for (Item tempItem : itemList) {
        if (tempItem.getAttribute() == null) {
          throw new AttributeException("Attribute list is null or empty !!!");
        } else {
          Float val = tempItem.getAttribute().getValue();
          if (val != null && val < tempValue) {
            tempValue = val;
          }
        }
      }

      return tempValue;
    }
  }


  public static List<Attribute> getAttributeList(List<Item> itemList) {
    List<Attribute> attributeList = new ArrayList<>();
    if (itemList == null || itemList.size() == 0) {
      throw new ItemException("Item list is null or empty !!!");
    } else {
      for (Item item : itemList) {
        attributeList.add(item.getAttribute());
      }
      return attributeList;
    }
  }

  public static Float getMedian(List<Item> itemList) {
    List<Attribute> attributeList = getAttributeList(itemList);
    Collections.sort(attributeList, new CompareAttribute());
    int size = attributeList.size();
    if (size % 2 == 0) {
      int index = size / 2 - 1;
      Attribute selectedAttribute = attributeList.get(index);
      return selectedAttribute.getValue();
    } else {
      int index = (size - 1) / 2;
      Attribute selectedAttribute = attributeList.get(index);
      return selectedAttribute.getValue();
    }
  }


}
