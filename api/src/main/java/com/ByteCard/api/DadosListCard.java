package com.ByteCard.api.controller;

import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListCard(BigDecimal numberCard,
                            String name,
                            LocalDate date ,
                            BigDecimal limit) {

    public DadosListCard(Card card){
        this(card.getNumberCard(),card.getClient_id().getName(),card.getDate(),card.getLimit());

    }
}
