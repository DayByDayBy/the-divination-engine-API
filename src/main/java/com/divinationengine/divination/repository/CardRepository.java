package com.divinationengine.divination.repository;

import com.divinationengine.divination.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "SELECT * FROM cards ORDER BY random() LIMIT ?1", nativeQuery = true)
    List<Card> findRandomCardsOfCount(int count);
}



