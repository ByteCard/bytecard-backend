package com.ByteCard.api.Compra.Dados;

import com.ByteCard.api.Compra.Compra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FaturaDados(
        Long id,
        Long numberCard,
        String cpf,
        LocalDateTime date,
        String estabelecimento,
        CategoriaCompra categoriaCompra,
        BigDecimal valor,
        String name


) {
    public FaturaDados(Compra compra){
        this(compra.getId(), compra.getNumeroCard(), compra.getClientId().getCpf(),compra.getDate(), compra.getEstabelecimento(), compra.getCategoriaCompra(),compra.getValor(),compra.getClientId().getName());

    }

}
