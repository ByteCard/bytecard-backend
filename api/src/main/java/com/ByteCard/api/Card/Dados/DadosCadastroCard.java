package com.ByteCard.api.Card.Dados;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroCard(
        @NotBlank
        String cpf,
        @NotNull
        BigDecimal limit) {
}
