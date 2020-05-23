package com.jhagestedt.blueprint.properties;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "blueprint")
public class BlueprintProperties {

  @NotBlank
  private Integer salt;
  @NotBlank
  private Integer pepper;
}
