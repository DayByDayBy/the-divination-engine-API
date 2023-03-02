package com.divinationengine.divination.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cards")

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "card")
    private List<CardReading> cardReadings;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private CardType type;

    @Column(name="suit")
    private String suit;

    @Column(name = "name_short")
    private String nameShort;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "intValue")
    private Integer intValue;

    @Column(name = "meaning_up", columnDefinition="TEXT")
    private String meaningUp;

    @Column(name = "meaning_rev", columnDefinition="TEXT")
    private String meaningRev;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    public Card(CardType type,
                     String suit,
                     String nameShort,
                     String name,
                     String value,
                     Integer intValue,
                     String meaningUp,
                     String meaningRev,
                     String description,
    List<CardReading> cardReadings) {
        this.type = type;
        this.nameShort = nameShort;
        this.suit = suit;
        this.name = name;
        this.value = value;
        this.intValue = intValue;
        this.meaningUp = meaningUp;
        this.meaningRev = meaningRev;
        this.description = description;
        this.cardReadings = cardReadings;
    }

    public Card(){
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getMeaningUp() {
        return meaningUp;
    }

    public void setMeaningUp(String meaningUp) {
        this.meaningUp = meaningUp;
    }

    public String getMeaningRev() {
        return meaningRev;
    }

    public void setMeaningRev(String meaningRev) {
        this.meaningRev = meaningRev;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CardReading> getCardReadings() {
        return cardReadings;
    }

    public void setCardReadings(List<CardReading> cardReadings) {
        this.cardReadings = cardReadings;
    }
}





