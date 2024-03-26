package com.ByteCard.api.Compra.Dados;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosPesquiRelatorio(BigDecimal numberCard,
                                   @NotNull
                                   LocalDate date) {
}
