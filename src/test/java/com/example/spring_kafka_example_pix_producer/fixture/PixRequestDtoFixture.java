package com.example.spring_kafka_example_pix_producer.fixture;

import com.example.spring_kafka_example_pix_producer.model.Pix;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;

public interface PixRequestDtoFixture {

    static PixRequestDto defaultBuilder(){
        return builder().build();
    }

    private static PixRequestDto.PixRequestDtoBuilder builder(){
        return PixRequestDto.builder().originKey("pix-123")
                .destinyKey("pix-321")
                .pixValue(24.5);
    }
}
