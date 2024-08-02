package com.example.spring_kafka_example_pix_producer.mapper;

import com.example.spring_kafka_example_pix_producer.model.Pix;
import com.example.spring_kafka_example_pix_producer.model.dto.PixRequestDto;
import com.example.spring_kafka_example_pix_producer.model.dto.PixResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PixMapper {
    PixResponseDto map(Pix pix);
    Pix map(PixRequestDto pixDto);

}
