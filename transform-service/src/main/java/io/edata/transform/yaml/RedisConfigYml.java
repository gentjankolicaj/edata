package io.edata.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RedisConfigYml {

  private String host;
  private int port;
  private String password;
  private boolean useSSL;
  private String databaseNumber;
  private int defaultTimeout;
}
