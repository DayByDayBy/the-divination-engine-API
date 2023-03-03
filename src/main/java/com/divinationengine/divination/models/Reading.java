package com.divinationengine.divination.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties({"reading"})
    @OneToMany(mappedBy = "reading", cascade = CascadeType.ALL)
    private List<CardInReading> cardReadings;

    public Reading() {
    }

    public Reading(List<CardInReading> cardReadings) {
        this.cardReadings = cardReadings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CardInReading> getCardReadings() {
        return cardReadings;
    }

    public void setCardReadings(List<CardInReading> cardReadings) {
        this.cardReadings = cardReadings;
        this.cardReadings.forEach(cr -> cr.setReading(this));
    }
}

