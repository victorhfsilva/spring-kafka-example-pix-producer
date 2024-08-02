package com.example.spring_kafka_example_pix_producer.service.impl;

import com.example.spring_kafka_example_pix_producer.mapper.KeyTableMapper;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;
import com.example.spring_kafka_example_pix_producer.repository.KeyTableRepository;
import com.example.spring_kafka_example_pix_producer.service.KeyTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KeyTableServiceImpl implements KeyTableService {

    private KeyTableRepository repository;

    private KeyTableMapper mapper;

    @Override
    public KeyTableDto save(KeyTableDto keyTable) {
        repository.save(mapper.map(keyTable));
        return keyTable;
    }

}
