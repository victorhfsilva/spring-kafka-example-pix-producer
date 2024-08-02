package com.example.spring_kafka_example_pix_producer.controller;

import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_producer.service.KeyTableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/key")
@AllArgsConstructor
public class KeyController {

    private KeyTableService keyTableService;

    @PostMapping
    public ResponseEntity<KeyTableDto> saveKey(@RequestBody KeyTableDto keyTableDto) {
        KeyTableDto keyTableResponse = keyTableService.save(keyTableDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyTableResponse);
    }

}
