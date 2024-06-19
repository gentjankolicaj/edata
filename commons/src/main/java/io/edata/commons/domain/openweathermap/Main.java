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
@RedisHash("main")
public class Main implements Serializable {

  private Float temp;
  private Float pressure;
  private Float humidity;
  private Float tempMin;
  private Float tempMax;
}
