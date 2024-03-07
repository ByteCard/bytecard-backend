package com.ByteCard.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
