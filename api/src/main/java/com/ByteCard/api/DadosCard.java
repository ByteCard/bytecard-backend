package com.ByteCard.api.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCard(
        @NotNull
        BigDecimal numberCard,
        @NotNull
        String clientCpf) {
}
