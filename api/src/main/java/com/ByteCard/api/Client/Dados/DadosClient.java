package com.ByteCard.api.Client.Dados;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record DadosClient(
        @NotNull
        String cpf,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotNull
        BigDecimal telephone) {
}
