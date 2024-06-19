package io.edata.commons.domain;

import jakarta.persistence.Column;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("pressureUnit")
public class PressureUnit implements Serializable {

  @Id
  @Column(name = "unitCode")
  private String unitCode;

  @Column(name = "unitName")
  private String unitName;

  @Column(name = "unitDescription")
  private String unitDescription;
}
