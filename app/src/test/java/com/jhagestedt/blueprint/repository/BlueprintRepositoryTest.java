package com.jhagestedt.blueprint.repository;

import com.jhagestedt.blueprint.BlueprintApplication;
import com.jhagestedt.blueprint.domain.BlueprintEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BlueprintApplication.class)
public class BlueprintRepositoryTest {

  @Autowired
  private BlueprintRepository blueprintRepository;

  @Test
  public void createAndFindByKey() {
    // data
    String key = UUID.randomUUID().toString();
    String data = UUID.randomUUID().toString();
    // create
    BlueprintEntity create = blueprintRepository.save(new BlueprintEntity()
      .setKey(key)
      .setData(data)
      .setSalt(0)
      .setPepper(0)
    );
    Assert.assertNotNull(create);
    Assert.assertEquals(key, create.getKey());
    // find
    Optional<BlueprintEntity> find = blueprintRepository.findByKey(key);
    Assert.assertTrue(find.isPresent());
    Assert.assertEquals(key, find.get().getKey());
    Assert.assertNotNull(find.get().getCreatedAt());
    Assert.assertNotNull(find.get().getUpdatedAt());
  }
}
