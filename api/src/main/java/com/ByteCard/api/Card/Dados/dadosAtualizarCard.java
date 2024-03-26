package com.ByteCard.api.Card.Dados;

import com.ByteCard.api.Card.Card;

import java.math.BigDecimal;
import java.time.LocalDate;

public record dadosAtualizarCard(
        BigDecimal numberCard,
        BigDecimal Limit,
        LocalDate validade,
        String nameCliente,
        String cpf

) {
    public dadosAtualizarCard(Card card){
        this(card.getNumberCard(),card.getLimit(),card.getDate(),card.getClientID().getName(),card.getClientCpf());
    }
}
