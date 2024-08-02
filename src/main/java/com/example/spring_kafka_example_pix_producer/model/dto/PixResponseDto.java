package com.example.spring_kafka_example_pix_producer.model.dto;

import com.example.spring_kafka_example_pix_producer.model.Pix;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PixResponseDto {
    private String identifier;
    private String originKey;
    private String destinyKey;
    private Double pixValue;
    private LocalDateTime paymentDate;
    private Pix.PixStatus status;
}
