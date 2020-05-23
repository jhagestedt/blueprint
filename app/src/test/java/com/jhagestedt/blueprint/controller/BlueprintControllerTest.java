package com.jhagestedt.blueprint.controller;

import com.jhagestedt.blueprint.BlueprintApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = BlueprintApplication.class)
public class BlueprintControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnNotFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/api/v1/blueprint/abc")
      .accept(MediaType.APPLICATION_JSON_VALUE)
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  public void shouldReturnUnsupportedMediaType() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/api/v1/blueprint/abc")
    )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    mockMvc.perform(MockMvcRequestBuilders
      .get("/api/v1/blueprint/abc")
      .accept(MediaType.APPLICATION_ATOM_XML_VALUE)
      .contentType(MediaType.APPLICATION_ATOM_XML_VALUE)
    )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
  }

}
