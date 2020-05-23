package com.jhagestedt.blueprint;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Schema(
  description = "The blueprint request data."
)
@Getter
@ToString
@EqualsAndHashCode
public class BlueprintRequest {

  @NotBlank
  private String data;

  public BlueprintRequest setData(String data) {
    this.data = data;
    return this;
  }
}
