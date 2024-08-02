package com.example.spring_kafka_example_pix_producer.service;

import com.example.spring_kafka_example_pix_producer.model.KeyTable;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;

public interface KeyTableService {
    KeyTableDto save(KeyTableDto keyTable);
}
