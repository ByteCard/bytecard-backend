package com.ByteCard.api.Compra.Dados;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCompra(
        @NotNull
        Long numberCard,
        @NotNull
        CategoriaCompra categoriaCompra,
        @NotNull
        BigDecimal valor,
        @NotNull
        String estabelecimento


) {
}
