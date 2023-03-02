package com.divinationengine.divination.controller;

import com.divinationengine.divination.models.Card;
import com.divinationengine.divination.models.CardReading;
import com.divinationengine.divination.models.Reading;
import com.divinationengine.divination.repository.CardRepository;
import com.divinationengine.divination.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardReadingController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    CardRepository cardRepository;




}

