package com.example.spring_kafka_example_pix_producer.service;

import com.example.spring_kafka_example_pix_producer.fixture.KeyTableDtoFixture;
import com.example.spring_kafka_example_pix_producer.fixture.KeyTableFixture;
import com.example.spring_kafka_example_pix_producer.mapper.KeyTableMapper;
import com.example.spring_kafka_example_pix_producer.model.KeyTable;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;
import com.example.spring_kafka_example_pix_producer.repository.KeyTableRepository;
import com.example.spring_kafka_example_pix_producer.service.impl.KeyTableServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KeyTableServiceTest {

    @InjectMocks
    private KeyTableServiceImpl keyTableService;

    @Mock
    private KeyTableRepository repository;

    @Mock
    private KeyTableMapper mapper;

    @Test
    void saveKeyTable() {
        KeyTable keyTable = KeyTableFixture.defaultBuilder();
        KeyTableDto expectedKeyTableDto = KeyTableDtoFixture.defaultBuilder();

        when(mapper.map(expectedKeyTableDto)).thenReturn(keyTable);

        KeyTableDto actualKeyTableDto = keyTableService.save(expectedKeyTableDto);

        verify(repository).save(any(KeyTable.class));
        assertEquals(actualKeyTableDto, expectedKeyTableDto);
    }

}
