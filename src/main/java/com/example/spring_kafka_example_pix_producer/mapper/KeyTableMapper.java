package com.example.spring_kafka_example_pix_producer.mapper;

import com.example.spring_kafka_example_pix_producer.model.KeyTable;
import com.example.spring_kafka_example_pix_producer.model.dto.KeyTableDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeyTableMapper {
    KeyTable map(KeyTableDto keyTableDto);
    KeyTableDto map(KeyTable keyTable);
}
