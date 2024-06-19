package io.edata.commons.validator.core;

public interface MyRequestDataValidator<T1, T2> {

  boolean validateFirst(T1 requestData);

  boolean validateSecond(T2 requestData);
}
