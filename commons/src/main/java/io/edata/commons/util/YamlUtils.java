package io.edata.commons.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.File;
import java.io.IOException;

public class YamlUtils {

  private static final ObjectMapper YAML_OBJECT_MAPPER = createObjectMapper();

  private YamlUtils() {
  }

  private static ObjectMapper createObjectMapper() {
    return new ObjectMapper(new YAMLFactory()).registerModules(new JavaTimeModule(),
        new ParameterNamesModule());
  }

  public static <T> T read(String file, Class<T> clazz) throws IOException {
    return YAML_OBJECT_MAPPER.readValue(
        Thread.currentThread().getContextClassLoader().getResource(file), clazz);
  }

  public static void write(String file, Object obj) throws IOException {
    YAML_OBJECT_MAPPER.writeValue(new File(file), obj);
  }
}
