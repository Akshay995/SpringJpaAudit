package com.codeusingjava.bootstrap;

import com.codeusingjava.model.Items;
import com.codeusingjava.service.ItemsService;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//spring annotation
@Configuration
public class DefaultProductsLoader implements CommandLineRunner {

    @Autowired
    Faker faker;
    @Autowired
    ItemsService service;

    @Override
    public void run(String... args) {
        final List<Items> itemss = createItemsList();
        service.saveAll(itemss);
    }

    //create the items list
    private List<Items> createItemsList() {
        final List<Items> itemss = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            itemss.add(create());
        }

        return itemss;
    }

    //create the items
    private Items create() {
        return Items.builder()
                .itemsName(faker.commerce().productName())
                .material(faker.commerce().material())
                .price(faker.commerce().price())
                .promotionCode(faker.commerce().promotionCode())    
                .build();  
    }  
}
