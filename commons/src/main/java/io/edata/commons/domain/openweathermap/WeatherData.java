package io.edata.commons.domain.openweathermap;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("weatherData")
public class WeatherData implements Serializable {

  private Coord coord;
  private List<Weather> weather;
  private String base;
  private Main main;
  private Long visibility;
  private Wind wind;
  private Clouds clouds;
  private Long dt;
  private Sys sys;
  private Long id;
  private String name;
  private Long cod;
}
