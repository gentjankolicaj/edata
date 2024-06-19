package io.edata.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SocketConfigYaml {

  private int timeout;
  private boolean tcpDelay;
}
