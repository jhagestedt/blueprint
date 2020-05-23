package com.jhagestedt.blueprint.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Value("${spring.application.name}")
  private String name;
  @Value("${spring.application.version}")
  private String version;

  /**
   * Configure the OpenApi bean.
   *
   * @return the OpenApi bean.
   */
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
      .info(new Info()
        .title(name)
        .version(version)
        .license(new License()
          .name("Apache 2.0")
          .url("http://www.apache.org/licenses/LICENSE-2.0")));
  }
}
