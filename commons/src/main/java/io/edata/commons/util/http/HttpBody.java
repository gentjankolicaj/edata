package io.edata.commons.util.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HttpBody<D> {

  HttpBodyType type;
  D data;

}
