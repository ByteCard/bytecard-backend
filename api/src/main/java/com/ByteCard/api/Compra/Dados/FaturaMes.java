package com.ByteCard.api.Compra.Dados;

import com.ByteCard.api.Compra.Dados.FaturaDados;

import java.math.BigDecimal;
import java.util.List;

public record FaturaMes(
        List<FaturaDados> faturaDados,
        BigDecimal valorTotal

) {
}
