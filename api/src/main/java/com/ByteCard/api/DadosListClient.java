package com.ByteCard.api.controller;

import java.math.BigDecimal;

public record DadosListClient(String cpf, String name, String email, BigDecimal telephone) {
    public DadosListClient(Client client){
        this(client.getCpf(), client.getName(), client.getEmail(),client.getTelephone());
    }
}
