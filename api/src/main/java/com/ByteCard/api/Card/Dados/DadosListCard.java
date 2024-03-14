package com.ByteCard.api.Card.Dados;

import com.ByteCard.api.Card.Card;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListCard(
        Long id,
        BigDecimal numberCard,
        String cpf,
        String name,
        LocalDate date ,
        BigDecimal limit,
        boolean status,
        Long idCliente) {

    public DadosListCard(Card card){
        this(card.getId(), card.getNumberCard(), card.getClientCpf(),card.getClientID().getName(),card.getDate(),card.getLimit(), card.isStatus(),card.getClientID().getId());

    }
}
