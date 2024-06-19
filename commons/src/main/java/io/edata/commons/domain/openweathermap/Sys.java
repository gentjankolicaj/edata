package io.edata.commons.domain.openweathermap;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("sys")
public class Sys implements Serializable {

  private Long type;
  private Long id;
  private Float message;
  private String country;
  private Long sunrise;
  private Long sunset;
}
