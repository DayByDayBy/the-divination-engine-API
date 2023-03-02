package com.divinationengine.divination.components;


import com.divinationengine.divination.models.Card;
import com.divinationengine.divination.repository.CardRepository;
import com.divinationengine.divination.repository.ReadingRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

//@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ReadingRepository readingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Card> cards = objectMapper.readValue(new File("src/main/resources/jsonFromAPI.json"),
                new TypeReference<List<Card>>(){});
//        System.out.println(cards);

                 cardRepository.saveAll(cards);

        System.out.println(cardRepository.findRandomCardsOfCount(3));

    }



}
