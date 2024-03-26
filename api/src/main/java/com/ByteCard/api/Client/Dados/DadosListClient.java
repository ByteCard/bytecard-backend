package com.ByteCard.api.Client.Dados;

import com.ByteCard.api.Client.Client;

import java.math.BigDecimal;

public record DadosListClient(Long id,

                              String cpf,

                              String name,

                              String email,

                              BigDecimal telephone) {
    public DadosListClient(Client client){
        this(client.getId(), client.getCpf(), client.getName(), client.getEmail(),client.getTelephone());
    }
}
