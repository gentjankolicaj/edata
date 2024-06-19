package io.edata.transform.yaml;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class HttpServerConfigYaml {

  private int port;
  private SocketConfigYaml socket;
  private List<HttpPathConfigYaml> paths;

}
