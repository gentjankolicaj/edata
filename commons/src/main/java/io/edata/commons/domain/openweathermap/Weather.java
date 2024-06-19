package io.edata.commons.domain.openweathermap;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("weather")
public class Weather implements Serializable {

  private Long id;
  private String main;
  private String description;
  private String icon;
}
