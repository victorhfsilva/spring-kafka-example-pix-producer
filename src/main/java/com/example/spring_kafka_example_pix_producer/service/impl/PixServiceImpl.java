package com.example.spring_kafka_example_pix_producer.service.impl;

import com.example.spring_kafka_example_pix_producer.mapper.PixMapper;
import com.example.spring_kafka_example_pix_producer.model.Pix;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_producer.repository.PixRepository;
import com.example.spring_kafka_example_pix_producer.service.PixService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PixServiceImpl implements PixService {

    private final PixRepository repository;

    private final PixMapper mapper;

    private final KafkaTemplate<String, PixResponseDto> kafkaTemplate;

    private static final String TOPIC = "pix-topic";

    @Override
    public PixResponseDto savePix(PixRequestDto pixRequestDto) {
        Pix pix = mapper.map(pixRequestDto);

        pix.setIdentifier(UUID.randomUUID().toString());
        pix.setPaymentDate(LocalDateTime.now());
        pix.setStatus(Pix.PixStatus.EM_PROCESSAMENTO);

        PixResponseDto pixResponseDto = mapper.map(pix);

        repository.save(pix);
        kafkaTemplate.send(TOPIC, pix.getIdentifier(), pixResponseDto);

        return pixResponseDto;
    }
}
