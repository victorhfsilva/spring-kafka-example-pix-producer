package com.example.spring_kafka_example_pix_producer.fixture;

import com.example.spring_kafka_example_pix_producer.model.KeyTable;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;

public interface KeyTableDtoFixture {
    static KeyTableDto defaultBuilder(){
        return builder().build();
    }
    private static KeyTableDto.KeyTableDtoBuilder builder() {
        return KeyTableDto.builder().keyValue("pix01");
    }
}