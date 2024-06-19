package io.edata.commons.domain.nasa.power;


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
@RedisHash("nasaPowerIdentifier")
public class Identifier implements Serializable {

  @Id
  @Column(name = "identifier")
  private String identifier;

}
