package com.divinationengine.divination.controller;

import com.divinationengine.divination.models.Card;
import com.divinationengine.divination.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @GetMapping(value = "/cards")
    public ResponseEntity<List<Card>> getAllCards() {
        return new ResponseEntity<>(cardRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/cards/{id}")
    public ResponseEntity getCard(@PathVariable Long id) {
        return new ResponseEntity<>(cardRepository.findById(id), HttpStatus.OK);
    }

}