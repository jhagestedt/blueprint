package com.jhagestedt.blueprint;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "blueprint")
public class BlueprintEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @NotBlank
  @Column(name = "key")
  private String key;

  @NotBlank
  @Column(name = "data")
  private String data;

  @NotNull
  @Column(name = "salt")
  private Integer salt;

  @NotNull
  @Column(name = "pepper")
  private Integer pepper;

  public BlueprintEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public BlueprintEntity setKey(String key) {
    this.key = key;
    return this;
  }

  public BlueprintEntity setData(String data) {
    this.data = data;
    return this;
  }

  public BlueprintEntity setSalt(Integer salt) {
    this.salt = salt;
    return this;
  }

  public BlueprintEntity setPepper(Integer pepper) {
    this.pepper = pepper;
    return this;
  }
}
