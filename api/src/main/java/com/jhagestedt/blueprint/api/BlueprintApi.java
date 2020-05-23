package com.jhagestedt.blueprint.api;

import com.jhagestedt.blueprint.BlueprintRequest;
import com.jhagestedt.blueprint.BlueprintResponse;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BlueprintApi {

  @Operation(
    description = "The blueprint create operation."
  )
  @PostMapping(
    value = "/api/v1/blueprint",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  ResponseEntity<BlueprintResponse> create(
    @RequestBody @Valid BlueprintRequest request
  );

  @Operation(
    description = "The blueprint get operation."
  )
  @GetMapping(
    value = "/api/v1/blueprint/{key}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  ResponseEntity<BlueprintResponse> get(
    @PathVariable(name = "key") @NotBlank String key
  );
}
