package com.ByteCard.api.Client.Dados;

import jakarta.validation.constraints.Email;

import java.math.BigDecimal;
import java.math.BigInteger;

public record DadosAlteraCliente(
        String cpf,
        String name,
        @Email
        String email,
        BigDecimal telephone ) {
}
