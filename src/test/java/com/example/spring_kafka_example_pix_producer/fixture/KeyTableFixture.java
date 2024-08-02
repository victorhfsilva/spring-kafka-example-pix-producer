package com.example.spring_kafka_example_pix_producer.fixture;

import com.example.spring_kafka_example_pix_producer.model.KeyTable;

public interface KeyTableFixture {
    static KeyTable defaultBuilder(){
        return builder().build();
    }
    private static KeyTable.KeyTableBuilder builder() {
        return KeyTable.builder().id(1)
                .keyValue("pix01");
    }
}
