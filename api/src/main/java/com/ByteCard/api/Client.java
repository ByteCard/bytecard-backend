package com.ByteCard.api.controller;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email",length = 100)
    private String email;
    @Column(name = "telefone")
    private BigDecimal telephone;

    public Client(DadosClient dados){
      this.name = dados.name();
      this.cpf = dados.cpf();
      this.email = dados.email();
      this.telephone = dados.telephone();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
