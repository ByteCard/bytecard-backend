package com.ByteCard.api.Compra.Dados;

import java.util.List;

public record RelatorioCliente(
        List<CompraMaiorValor> compraMaiorValors,
        List<ComproNada> comproNada,
        List<RelatoiroDeCompra> comproMais) {

}
