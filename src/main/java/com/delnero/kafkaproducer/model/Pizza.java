package com.delnero.kafkaproducer.model;

import lombok.Data;
import lombok.Value;
import java.util.List;

@Data
@Value
public class Pizza {

    Crust crust;
    List<Toppings> toppings;
    String item;
    Double amount;
}
