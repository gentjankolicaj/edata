package io.edata.transform.http.handler;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;

@Slf4j
public class PingRequestHandler implements HttpRequestHandler {

  @Override
  public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context)
      throws HttpException, IOException {
    log.info("HttpRequest received.{}", request);
    response.setCode(200);
    response.setEntity(new StringEntity("Successful request."));
  }
}
