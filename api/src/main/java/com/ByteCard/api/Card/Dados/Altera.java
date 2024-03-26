package com.ByteCard.api.Card.Dados;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Altera(
        @NotNull
        BigDecimal limiteAlterado
) {
}
