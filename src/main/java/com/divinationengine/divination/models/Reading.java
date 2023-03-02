package com.divinationengine.divination.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "readings")
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonBackReference
    @OneToMany(mappedBy = "reading", cascade = CascadeType.ALL)
    private List<CardReading> cardReadings;

    public Reading() {
    }

    public Reading(List<CardReading> cardReadings) {
        this.cardReadings = cardReadings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CardReading> getCardReadings() {
        return cardReadings;
    }

    public void setCardReadings(List<CardReading> cardReadings) {

        this.cardReadings = cardReadings;
        this.cardReadings.forEach(cr -> cr.setReading(this) );
    }
}

