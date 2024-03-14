package com.ByteCard.api.Compra.controller;

import com.ByteCard.api.Card.Card;
import com.ByteCard.api.Card.Repository.CardRepository;
import com.ByteCard.api.Client.Client;
import com.ByteCard.api.Client.Repository.ClientRepository;
import com.ByteCard.api.Compra.Compra;
import com.ByteCard.api.Compra.Dados.*;
import com.ByteCard.api.Compra.Repository.CompraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("compras")
public class ComprasController {
    @Autowired
    private CompraRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CardRepository cardRepository;
    @PostMapping
    @Transactional
    public String compras(@RequestBody @Valid DadosCompra compra){
        Card card = cardRepository.CARD(compra.numberCard());
        Client client = clientRepository.getReferenceById(card.getClientID().getId());
        Compra compra1 = new Compra(compra,client,card);


        if(card.isStatus()&&compra.estabelecimento().length()>=5){
           repository.save(compra1);
           return "Compra Realizada com sucesso";
       }else{
           return "COMPRA NÃO REALIZADA";
       }
    }

    @GetMapping
    @RequestMapping("fatura")
    public FaturaMes fatura(@RequestBody  Dadoslist dadosfatura){
        List<FaturaDados> dados = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String mesfatura = dadosfatura.date().format(formatter);
        System.out.println(mesfatura);
        for (Compra compra:repository.COMPRASLIST(dadosfatura.numberCard(),mesfatura)){
            FaturaDados faturaDados = new FaturaDados(compra);
            dados.add(faturaDados);
            valorTotal = valorTotal.add(compra.getValor());
        }
        /*

        String diaCompra = compra.getDate().format(formatter);
        String mesfatura = dadosfatura.date().format(formatter);
        date_format(data_compra,'%Y-%m') >='2024-04'
         */

        return new FaturaMes(dados,valorTotal);
    }

    @GetMapping
    @RequestMapping("/categoria")
    public DadosRelatorio relatorioCategoria(@RequestBody DadosPesquiRelatorio dados){
        BigDecimal valorTotal = BigDecimal.ZERO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String mesfatura = dados.date().format(formatter);
        for(DadosCategoriaRelatorio dadosCategoriaRelatorio:repository.COMPRAS(mesfatura,dados.numberCard())){
            valorTotal = valorTotal.add(dadosCategoriaRelatorio.getTotal());


        }


        return new DadosRelatorio(repository.COMPRAS(mesfatura,dados.numberCard()),valorTotal);

    }
    @GetMapping
    @RequestMapping("relatorio")
    public RelatorioCliente relatorio(@RequestBody DadosPesquiRelatorio dados){
        int comparando =  LocalDate.now().compareTo(dados.date());
        System.out.println(comparando);
        if(comparando >=0){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            String mesfatura = dados.date().format(formatter);
            return new RelatorioCliente(repository.COMPRA_MAIOR_VALORS(mesfatura),repository.ComproNada(),repository.RELATOIRO_DE_COMPRAS(mesfatura));

        }else{
            return null;
        }
    }

}
