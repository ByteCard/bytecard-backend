package com.ByteCard.api.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record DadosCompra(
        @NotNull
        BigDecimal numberCard,
        @NotNull
        CategoriaCompra categoriaCompra,
        @NotNull
        BigDecimal valor,
        @NotNull
        String estabelecimento) {
}
