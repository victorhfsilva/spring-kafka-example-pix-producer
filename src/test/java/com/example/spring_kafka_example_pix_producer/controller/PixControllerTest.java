package com.example.spring_kafka_example_pix_producer.controller;

import com.example.spring_kafka_example_pix_producer.fixture.PixRequestDtoFixture;
import com.example.spring_kafka_example_pix_producer.fixture.PixResponseDtoFixture;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_producer.service.impl.PixServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PixControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private PixController pixController;

    @MockBean
    private PixServiceImpl pixService;

    @Test
    void savePixTest() throws Exception {
        PixRequestDto pixRequest = PixRequestDtoFixture.defaultBuilder();
        PixResponseDto pixResponse = PixResponseDtoFixture.defaultBuilder();

        String pixRequestJson = objectMapper.writeValueAsString(pixRequest);

        when(pixService.savePix(any(PixRequestDto.class))).thenReturn(pixResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/pix")
                .contentType("application/json")
                .content(pixRequestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.identifier").value(pixResponse.getIdentifier()))
                .andExpect(jsonPath("$.originKey").value(pixResponse.getOriginKey()))
                .andExpect(jsonPath("$.destinyKey").value(pixResponse.getDestinyKey()))
                .andExpect(jsonPath("$.pixValue").value(pixResponse.getPixValue()))
                .andExpect(jsonPath("$.status").value(pixResponse.getStatus().toString()));
    }
}
