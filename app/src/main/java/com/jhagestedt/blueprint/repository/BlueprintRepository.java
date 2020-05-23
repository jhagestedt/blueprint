package com.jhagestedt.blueprint.repository;

import com.jhagestedt.blueprint.domain.BlueprintEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlueprintRepository extends JpaRepository<BlueprintEntity, Long> {

  Optional<BlueprintEntity> findByKey(String key);
}
