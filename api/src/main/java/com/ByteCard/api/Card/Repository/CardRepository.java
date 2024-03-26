package com.ByteCard.api.Card.Repository;

import com.ByteCard.api.Card.Card;
import com.ByteCard.api.Client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Long> {
    Page<Card> findAllBystatusTrue(Pageable pageable);

    Page<Card> findAllBystatusFalse(Pageable pageable);

    @Query(value = "SELECT * FROM cartao  where Numero_cartao = ?1",nativeQuery = true)
    Card CARD(long numberCard);
    @Query(value = "SELECT * FROM cartao  where Numero_cartao = ?1",nativeQuery = true)
    Optional<Card> CARDExis(long numberCard);
    @Query(value = "SELECT * FROM cartao where cpf_client = ?1 ",nativeQuery = true)
    List<Card> CARDS(String cpf);
}
