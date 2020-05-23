package com.jhagestedt.blueprint.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Autowired
  private BuildProperties buildProperties;

  /**
   * Configure the OpenApi bean.
   *
   * @return the OpenApi bean.
   */
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
      .info(new Info()
        .title(buildProperties.getName())
        .version(buildProperties.getVersion())
        .license(new License()
          .name("Apache 2.0")
          .url("http://www.apache.org/licenses/LICENSE-2.0")));
  }
}
