package com.delnero.kafkaproducer.service;

import com.delnero.kafkaproducer.model.Pizza;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String send(Pizza pizza) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(pizza);
        kafkaTemplate.send(orderTopic, orderAsMessage);

        log.info("pizza produced {}", orderAsMessage);

        return "message sent";
    }
}
