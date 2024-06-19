package io.edata.commons.validator;

import io.edata.commons.exception.BadQueryParamsException;
import io.edata.commons.validator.core.MyParamValidator;
import java.util.ArrayList;
import java.util.List;

public class UrlParamValidator implements
    MyParamValidator<String, String[], List<String>, ArrayList<String>> {

  @Override
  public boolean validateFirst(String requestData) {
    return requestData != null && !requestData.equals("");
  }

  @Override
  public boolean validateSecond(String... requestData) {
    for (String data : requestData) {
      if (data == null || data.equals("")) {
        throw new BadQueryParamsException("One of the url params is null or empty.");
      }

    }
    return true;
  }

  @Override
  public boolean validateThird(List<String> requestData) {
    return false;
  }

  @Override
  public boolean validateFourth(ArrayList<String> requestData) {
    return false;
  }
}
