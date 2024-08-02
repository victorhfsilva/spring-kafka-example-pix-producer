package com.example.spring_kafka_example_pix_producer.service;

import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;

public interface PixService {
    PixResponseDto savePix(PixRequestDto pixDto);
}
