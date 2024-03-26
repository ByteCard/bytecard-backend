package com.ByteCard.api.Card.controller;

import com.ByteCard.api.Card.Card;
import com.ByteCard.api.Card.Dados.*;
import com.ByteCard.api.Card.Repository.CardRepository;
import com.ByteCard.api.Card.Services.Cardrandom;
import com.ByteCard.api.Card.Services.Validacao;
import com.ByteCard.api.Client.Client;
import com.ByteCard.api.Client.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController

@CrossOrigin("*")
@RequestMapping("cartao")
public class CardController {
    @Autowired
    private CardRepository repository;
    @Autowired
    private ClientRepository repositoryClient;
    @GetMapping
    public Page<DadosListCard> cardList(@PageableDefault(size = 10,sort = {"numberCard"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListCard::new);
        //size=1&page=3;
    }
    @GetMapping("cardAtivo")
    public Page<DadosListCard> cardListAtivo(@PageableDefault(size = 10,sort = {"numberCard"}) Pageable pageable){
        return repository.findAllBystatusTrue(pageable).map(DadosListCard::new);
        //size=1&page=3;
    }

    @PostMapping
    @Transactional
    @RequestMapping("cadastro")
    public String card(@RequestBody @Valid DadosCadastroCard card){
        //colocar com lista de dois elementos cpf e id
        if (Validacao.validacao(card.cpf())) {
            if(repositoryClient.CLIENTE(card.cpf()).isPresent()) {
                Client client = repositoryClient.CLIENT(card.cpf());
            if(client.getAtivo()) {
                BigDecimal numberCard = BigDecimal.valueOf(Cardrandom.numbersCard());
                LocalDate date = LocalDate.now().plusYears(4).plusMonths(6);
                Integer cvv = Integer.valueOf(Cardrandom.numbercvv());
                repository.save(new Card(null, numberCard, date, cvv, card.limit().abs(), false, card.cpf(), client));
                return "CARTÃO CADASTRADO";
            }else {
                return "CLIENTE EXCLUIDO";
            }
            }else{
                return "CLIENTE NÃO EXISTE";
            }
        }else {
            return "CARTÃO NÃO CADASTRADO";
        }
    }

    @GetMapping
    @RequestMapping("desativado")
    public Page<DadosListCard> cardListDesativado(@PageableDefault(size = 10,sort = {"numberCard"}) Pageable pageable){
        return repository.findAllBystatusFalse(pageable).map(DadosListCard::new);
        //size=1&page=3;
    }
    @GetMapping
    @RequestMapping("pesquisa")
    public DadosListCard cardpesquisa(@RequestBody DadosPesquisaCard card){
        List<DadosListCard> cards = repository.findAll().stream().map(DadosListCard::new).toList();
        DadosListCard cardre = null;
        for(DadosListCard cardPes:cards){
            if(cardPes.numberCard().equals(card.numberCard())&&cardPes.cpf().equals(card.cpf())){
                cardre = cardPes ;
            }
        }
        return cardre;
    }

    @PutMapping
    @Transactional
    @RequestMapping("/{number:[0-9]+}")
    public String ativarCard(@PathVariable("number") long numberCard){
        System.out.println(numberCard);
        Card card = repository.CARD(numberCard);
        if(card != null ){
            card.ativarCancelar();
            return "ATIVO";
        }else {
            return "ERRO";
        }

    }
    @PutMapping
    @Transactional
    @RequestMapping("/alteraLimite/{number:[0-9]+}")
    public dadosAtualizarCard alteraLimite(@PathVariable("number") long numbercard, @RequestBody @Valid Altera altera){

        if(repository.CARD(numbercard)!=null) {
            Card card = repository.CARD(numbercard);
            card.atualizarLimite(altera);
            return new dadosAtualizarCard(repository.CARD(numbercard));

        }else{
            return null;
        }

    }

    @DeleteMapping("/{d}")
    @Transactional
    public void excluir(@PathVariable long id){
        repository.deleteById(id);
    }
    @DeleteMapping("/desativaCard/{number:[0-9]+}")
    @Transactional
    public String cancelar(@PathVariable("number") long numbercard){
        Card card =repository.CARD(numbercard);
        if(card != null){
            card.cancelar();
            return "cancelado";

        }else{
            return "ERRO";
        }
    }
}
