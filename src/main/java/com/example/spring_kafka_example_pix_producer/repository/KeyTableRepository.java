package com.example.spring_kafka_example_pix_producer.repository;

import com.example.spring_kafka_example_pix_producer.model.KeyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTableRepository extends JpaRepository<KeyTable, Integer> {
}
