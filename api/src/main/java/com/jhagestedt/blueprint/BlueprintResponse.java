package com.jhagestedt.blueprint;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Schema(
  description = "The blueprint response data."
)
@Getter
@ToString
@EqualsAndHashCode
public class BlueprintResponse {

  @NotBlank
  private String key;
  @NotBlank
  private String data;

  public BlueprintResponse setKey(String key) {
    this.key = key;
    return this;
  }

  public BlueprintResponse setData(String data) {
    this.data = data;
    return this;
  }
}
