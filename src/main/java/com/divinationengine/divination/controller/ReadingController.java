package com.divinationengine.divination.controller;

import com.divinationengine.divination.models.Card;
import com.divinationengine.divination.models.CardReading;
import com.divinationengine.divination.models.Reading;
import com.divinationengine.divination.repository.CardRepository;
import com.divinationengine.divination.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReadingController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    CardRepository cardRepository;

    // 1. create a controller method to be able to generate a new reading, probably a getmapping
    // 2. inside method generate 3 or 10 cards as appropriate
    // 3. create a new reading instance
    // 4. create a new CardReading instance per card created, with a position and reversed property to link reading with card
    // 5. add the list of CardReadings to the reading instance
    // 6. send back in the response body the reading instance





    @GetMapping("/reading/3")
    public ResponseEntity<List<Card>> get3Cards(){
        List<Card> threeCards = cardRepository.findRandomCardsOfCount(3);
        return new ResponseEntity<>(threeCards, HttpStatus.OK);
    }

    @GetMapping("/reading/10")
    public ResponseEntity<List<Card>> get10Cards(){
        List<Card> tenCards = cardRepository.findRandomCardsOfCount(10);
        return new ResponseEntity<>(tenCards, HttpStatus.OK);
    }

    @GetMapping(value = "/readings")
    public ResponseEntity<List<Reading>> getAllReadings() {
        return new ResponseEntity<>(readingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/readings/{id}")
    public ResponseEntity getReading(@PathVariable Long id) {
        return new ResponseEntity<>(readingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/readings")
    public ResponseEntity<Reading> postReading(@RequestBody Reading reading){

        System.out.println(reading.getCardReadings().get(0).getCard());
        readingRepository.save(reading);

        return new ResponseEntity<>(reading, HttpStatus.CREATED);
    }

    @DeleteMapping(value= "/readings/{id}")
    public ResponseEntity<Reading> deleteReading(@PathVariable Long id){
        Optional<Reading> readingToDelete = readingRepository.findById(id);
        readingRepository.delete(readingToDelete.get());
        return new ResponseEntity<>(readingToDelete.get(), HttpStatus.OK);
    }



}