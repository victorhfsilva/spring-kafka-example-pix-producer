package com.example.spring_kafka_example_pix_producer.controller;

import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_producer.service.PixService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
@AllArgsConstructor
public class PixController {

    private final PixService pixService;

    @PostMapping
    public ResponseEntity<PixResponseDto> savePix(@RequestBody PixRequestDto pixDto) {
        PixResponseDto pixResponse = pixService.savePix(pixDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pixResponse);
    }

}
