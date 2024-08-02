package com.example.spring_kafka_example_pix_producer.fixture;

import com.example.spring_kafka_example_pix_producer.model.Pix;

import java.time.LocalDateTime;

public interface PixFixture {
    static Pix defaultBuilder(){
        return builder().build();
    }

    private static Pix.PixBuilder builder(){
        return Pix.builder().originKey("pix-123")
                .destinyKey("pix-321")
                .pixValue(24.5);
    }

}
