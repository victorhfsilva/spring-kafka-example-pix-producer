package com.example.spring_kafka_example_pix_producer.service;

import com.example.spring_kafka_example_pix_producer.fixture.PixFixture;
import com.example.spring_kafka_example_pix_producer.fixture.PixRequestDtoFixture;
import com.example.spring_kafka_example_pix_producer.fixture.PixResponseDtoFixture;
import com.example.spring_kafka_example_pix_producer.mapper.PixMapper;
import com.example.spring_kafka_example_pix_producer.model.Pix;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_producer.repository.PixRepository;
import com.example.spring_kafka_example_pix_producer.service.impl.PixServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PixServiceTest {

    @InjectMocks
    private PixServiceImpl pixService;

    @Mock
    private PixRepository repository;

    @Mock
    private PixMapper mapper;

    @Mock
    private KafkaTemplate<String, PixResponseDto> kafkaTemplate;

    @Test
    void savePixTest() {
        PixRequestDto pixRequest = PixRequestDtoFixture.defaultBuilder();
        Pix pix = PixFixture.defaultBuilder();
        PixResponseDto expectedPixResponse = PixResponseDtoFixture.defaultBuilder();

        when(mapper.map(pixRequest)).thenReturn(pix);
        when(mapper.map(any(Pix.class))).thenReturn(expectedPixResponse);

        PixResponseDto actualPixResponse = pixService.savePix(pixRequest);

        verify(repository).save(any(Pix.class));
        verify(kafkaTemplate).send(anyString(), anyString(), eq(expectedPixResponse));
        assertEquals(expectedPixResponse, actualPixResponse);
    }

}
