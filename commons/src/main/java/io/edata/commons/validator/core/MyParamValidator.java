package io.edata.commons.validator.core;

public interface MyParamValidator<T1, T2, T3, T4> {

  boolean validateFirst(T1 requestData);

  boolean validateSecond(T2 requestData);

  boolean validateThird(T3 requestData);

  boolean validateFourth(T4 requestData);
}
