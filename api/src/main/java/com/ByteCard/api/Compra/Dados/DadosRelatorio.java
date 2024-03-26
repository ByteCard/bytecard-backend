package com.ByteCard.api.Compra.Dados;

import java.math.BigDecimal;
import java.util.List;

public record DadosRelatorio(
       List<DadosCategoriaRelatorio> dadosCategoriaRelatorios,
       BigDecimal valorTotalGasto

) {

}
