package com.ByteCard.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public class ComprasController {
    @PostMapping
    public void compras(@RequestBody @Valid DadosCompra compra){

        System.out.println(compra);
    }
}
