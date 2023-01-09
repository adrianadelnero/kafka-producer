package com.delnero.kafkaproducer.component;

import com.delnero.kafkaproducer.model.Crust;
import com.delnero.kafkaproducer.model.Pizza;
import com.delnero.kafkaproducer.model.Toppings;
import com.delnero.kafkaproducer.service.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class SchedulerComponent {

    @Autowired
    KafkaProducer kafkaProducer;

    private double count = 0;

    @Scheduled(fixedRate = 40000)
    public void sendMessage() throws JsonProcessingException {
        count++;
        Pizza pizza = Pizza.builder()
                .amount(count)
                .crust(Crust.THIN_CRUST)
                .toppings(Arrays.asList(Toppings.CHEESE, Toppings.PEPPERONI))
                .build();
        kafkaProducer.send(pizza);
        log.info("sent pizza scheduler {}", count);
    }
}
