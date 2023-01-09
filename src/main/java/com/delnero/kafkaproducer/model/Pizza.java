package com.delnero.kafkaproducer.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import java.util.List;

@Data
@Value
@Builder
public class Pizza {

    Crust crust;
    List<Toppings> toppings;
    String item;
    Double amount;
}
