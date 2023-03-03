package com.divinationengine.divination.controller;


import com.divinationengine.divination.repository.CardRepository;
import com.divinationengine.divination.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardInReadingController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    CardRepository cardRepository;




}

