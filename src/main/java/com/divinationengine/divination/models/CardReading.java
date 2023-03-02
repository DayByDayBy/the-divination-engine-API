package com.divinationengine.divination.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table (name = "card_readings")
public class CardReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @JsonIgnoreProperties({"cardReadings"})
    @ManyToOne
    @JoinColumn(name = "reading_id", nullable = false)
    private Reading reading;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;
    @Column (nullable = false)
    private int position;
    @Column(nullable = false)
    private boolean reversed;

    public CardReading() {
    }

    public CardReading(Long id, Reading reading, Card card, int position, boolean reversed) {
        this.id = id;
        this.reading = reading;
        this.card = card;
        this.position = position;
        this.reversed = reversed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isReversed() {
        return reversed;
    }
    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }
}
