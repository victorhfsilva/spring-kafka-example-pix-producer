package com.example.spring_kafka_example_pix_producer.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PixRequestDto {
    private String originKey;
    private String destinyKey;
    private Double pixValue;
}
