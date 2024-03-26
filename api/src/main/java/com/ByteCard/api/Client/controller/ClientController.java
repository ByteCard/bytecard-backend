package com.ByteCard.api.Client.controller;

import com.ByteCard.api.Card.Card;
import com.ByteCard.api.Card.Repository.CardRepository;
import com.ByteCard.api.Card.Services.Cardrandom;
import com.ByteCard.api.Client.Client;
import com.ByteCard.api.Client.Dados.DadosAlteraCliente;
import com.ByteCard.api.Client.Repository.ClientRepository;
import com.ByteCard.api.Client.Dados.DadosClient;
import com.ByteCard.api.Client.Dados.DadosListClient;
import com.ByteCard.api.Client.Services.ValidacaoClient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private CardRepository repositoryCard;

    @GetMapping
    public List<DadosListClient> clientsTelaPrincipal(){
        return repository.findAllByAtivoTrue().stream().map(DadosListClient::new).sorted((Comparator.comparing(o -> o.name().toUpperCase()))).toList();

    }




    @RequestMapping("cadastra")
    @PostMapping
    @Transactional
    public String cadastroClient(@RequestBody @Valid DadosClient dados){
       /* if(ValidacaoClient.validacao(dados)){
           Client clients =  repository.CLIENT(dados.cpf());

            if(clients.getCpf().equals(dados.cpf())){
                return "ESSE CLIENTE JA EXISTE";
            }else {

                Client client = new Client(dados);
                repository.save(client);
                Integer cvv = Integer.valueOf(Cardrandom.numbercvv());
                BigDecimal numberCard = BigDecimal.valueOf(Cardrandom.numbersCard());
                LocalDate date = LocalDate.now().plusYears(4).plusMonths(6);
                Card card = new Card(null, numberCard, date, cvv, BigDecimal.ZERO, false, dados.cpf(), client);
                repositoryCard.save(card);
                return "Cliente cadastrado com sucesso";
            }
        }else {
            return "CLIENTE NÃO CADASTRADO";
        }

        */
        if(ValidacaoClient.validacao(dados)){
            if(repository.CLIENTE(dados.cpf()).isEmpty()){
                Client clients = repository.CLIENTE(dados.cpf()).orElse(new Client(dados));
                repository.save(clients);
                Integer cvv = Integer.valueOf(Cardrandom.numbercvv());
                BigDecimal numberCard = BigDecimal.valueOf(Cardrandom.numbersCard());
                LocalDate date = LocalDate.now().plusYears(4).plusMonths(6);
                Card card = new Card(null, numberCard, date, cvv, BigDecimal.ZERO, false, dados.cpf(), clients);
                repositoryCard.save(card);
                return "Cliente cadastrado com sucesso";
            }else{
                return "Cliente JA CADASTRADO";
            }
        }else {
            return "CLIENTE NÃO CADASTRADO";
        }


    }






    @GetMapping("pesquisaClient/{cpf}")
    public Client pesquisaCliente(@PathVariable("cpf") String cpf){
        return  repository.CLIENT(cpf);
    }


    @DeleteMapping("/{cpf}")
    @Transactional
    public String excluirClient(@PathVariable("cpf") String cpf){
        Client client = repository.CLIENT(cpf);
        if(client == null){
            return "CLINTE NÃO EXISTE";
        }else{
            client.desativandoClient();
            List<Card> card = repositoryCard.CARDS(cpf);
            for(Card card1: card){
                card1.cancelar();
            }
            return "CLIENTE EXCLUIDO COM SUCESSO";
        }
    }


    @PutMapping("/altera/{cpf}")
    @Transactional
    public String alteraCliente(@PathVariable("cpf")String cpf,@RequestBody DadosAlteraCliente cliente){
        Client client =  this.repository.CLIENT(cpf);
        if(client != null) {
            client.alteraDados(cliente);
            List<Card> cards = this.repositoryCard.CARDS(cpf);
            for (Card card : cards) {
                card.alteraDados(cliente.cpf());
            }
            return "ALTERADO COM SUCESSO";
        }else {
            return "ERRO NA HORA DA ALTERAÇÃO";
        }
    }




}
