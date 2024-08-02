package com.example.spring_kafka_example_pix_producer.controller;

import com.example.spring_kafka_example_pix_producer.fixture.KeyTableDtoFixture;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;
import com.example.spring_kafka_example_pix_producer.service.KeyTableService;
import com.example.spring_kafka_example_pix_producer.service.impl.KeyTableServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KeyTableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private KeyController keyController;

    @MockBean
    private KeyTableServiceImpl keyTableService;

    @Test
    void saveKeyTest() throws Exception {
        KeyTableDto keyTable = KeyTableDtoFixture.defaultBuilder();

        String keyTableJson = objectMapper.writeValueAsString(keyTable);

        when(keyTableService.save(any(KeyTableDto.class))).thenReturn(keyTable);

        mockMvc.perform(MockMvcRequestBuilders.post("/key")
                .contentType("application/json")
                .content(keyTableJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.keyValue").value(keyTable.getKeyValue()));
    }
}
