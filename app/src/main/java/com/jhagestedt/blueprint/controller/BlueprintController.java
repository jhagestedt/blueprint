package com.jhagestedt.blueprint.controller;

import com.jhagestedt.blueprint.BlueprintRequest;
import com.jhagestedt.blueprint.BlueprintResponse;
import com.jhagestedt.blueprint.api.BlueprintApi;
import com.jhagestedt.blueprint.service.BlueprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BlueprintController implements BlueprintApi {

  private final BlueprintService blueprintService;

  @Override
  public ResponseEntity<BlueprintResponse> create(BlueprintRequest request) {
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(blueprintService.create(request));
  }

  @Override
  public ResponseEntity<BlueprintResponse> get(String key) {
    return ResponseEntity.ok(blueprintService.get(key));
  }
}
