package com.delnero.kafkaproducer.service;

import com.delnero.kafkaproducer.model.Pizza;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PizzaService {

    private final KafkaProducer producer;

    @Autowired
    public PizzaService(KafkaProducer producer) {
        this.producer = producer;
    }

    public String createOrder(Pizza pizza) throws JsonProcessingException {
        return producer.send(pizza);
    }
}
