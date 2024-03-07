package com.ByteCard.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cadastro_cliente")
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private CardRepository repositoryCard;
    @PostMapping
    @Transactional
    public void cadastroClient(@RequestBody @Valid DadosClient dados){
        Client client = new Client(dados);
        repository.save(client);
        Integer cvv = Integer.valueOf(Cardrandom.numbersS(2));
        Card card = new Card(null, BigDecimal.valueOf(Cardrandom.numbers(15)), LocalDate.now().plusYears(4).plusMonths(6),cvv,BigDecimal.ZERO,false,dados.cpf(),client);
        repositoryCard.save(card);
    }
    @GetMapping
    public List<DadosListClient> clients(){
        return repository.findAll().stream().map(DadosListClient::new).toList();

    }


}
