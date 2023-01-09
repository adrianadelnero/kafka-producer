package com.delnero.kafkaproducer.controller;

import com.delnero.kafkaproducer.model.Pizza;
import com.delnero.kafkaproducer.service.PizzaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public String createOrder(@RequestBody Pizza pizza) throws JsonProcessingException {
        log.info("Received pizza order {}", pizza);
        return pizzaService.createOrder(pizza);
    }
}
