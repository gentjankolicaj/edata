package io.edata.commons.domain;


import io.edata.commons.enums.InformationScope;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@RedisHash("information")
public class Information implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "language")
  private Language language;

  @Column(name = "scope")
  @Enumerated(EnumType.STRING)
  private InformationScope informationScope;

  @Column(name = "field")
  private String field;

  @Column(name = "subject")
  private String subject;

  @Column(name = "message")
  private String message;

  @Column(name = "title")
  private String title;

  @Column(name = "tip")
  private String tip;


}
