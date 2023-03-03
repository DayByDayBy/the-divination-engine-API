package com.divinationengine.divination.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CardType {
    @JsonProperty("major")
    major,
    @JsonProperty("minor")
    minor

}
