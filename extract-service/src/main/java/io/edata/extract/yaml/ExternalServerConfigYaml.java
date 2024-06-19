package io.edata.extract.yaml;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalServerConfigYaml {

  private String name;
  private String host;
  private List<HttpPathConfigYaml> paths;
}
