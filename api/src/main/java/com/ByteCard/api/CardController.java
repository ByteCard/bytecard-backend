package com.ByteCard.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartao")
public class CardController {
    @Autowired
    private CardRepository repository;

    @PostMapping
    @Transactional
    public void card(@RequestBody @Valid DadosCard infos){
        System.out.println(infos);
        /*
        repository.save(new Card());
        System.out.println(card);

         */
    }
    @GetMapping
    public List<DadosListCard> cardList(){
        return repository.findAll().stream().map(DadosListCard::new).toList();

    }
}
