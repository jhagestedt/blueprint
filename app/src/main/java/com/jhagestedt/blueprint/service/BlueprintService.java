package com.jhagestedt.blueprint.service;

import com.jhagestedt.blueprint.BlueprintRequest;
import com.jhagestedt.blueprint.BlueprintResponse;
import com.jhagestedt.blueprint.domain.BlueprintEntity;
import com.jhagestedt.blueprint.exception.BlueprintException;
import com.jhagestedt.blueprint.properties.BlueprintProperties;
import com.jhagestedt.blueprint.repository.BlueprintRepository;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlueprintService {

  @Autowired
  private BlueprintRepository blueprintRepository;
  @Autowired
  private BlueprintProperties blueprintProperties;

  /**
   * Create a blueprint model.
   *
   * @param request the blueprint request model
   * @return the blueprint response model
   */
  public BlueprintResponse create(BlueprintRequest request) {
    try {
      final BlueprintEntity entity = blueprintRepository.save(new BlueprintEntity()
        .setKey(UUID.randomUUID().toString())
        .setData(request.getData())
        .setSalt(blueprintProperties.getSalt())
        .setPepper(blueprintProperties.getPepper())
      );
      return new BlueprintResponse()
        .setKey(entity.getKey())
        .setData(entity.getData());
    } catch (Exception e) {
      log.warn("create() {}", e.getMessage());
      throw new BlueprintException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occurred.");
    }
  }

  /**
   * Get a blueprint model by it's key.
   *
   * @param key the key
   * @return the blueprint response model
   */
  public BlueprintResponse get(String key) {
    try {
      return blueprintRepository.findByKey(key)
        .map(entity -> new BlueprintResponse()
          .setKey(entity.getKey())
          .setData(entity.getData())
        )
        .orElseThrow(() -> new BlueprintException(HttpStatus.NOT_FOUND, "Blueprint not found."));
    } catch (BlueprintException e) {
      throw e;
    } catch (Exception e) {
      log.warn("get() {}", e.getMessage());
      throw new BlueprintException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occurred.");
    }
  }
}
