package com.ByteCard.api.controller;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cartao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_cartao",unique = true)
    private BigDecimal numberCard;
    @Column(name = "validade")
    private LocalDate date;
    @Column(name = "cvv" )
    private Integer cvv;
    @Column(name = "limite")
    private BigDecimal limit;
    @Column(name ="status" )
    private boolean status;
    @Column(name ="cpf_client" )
    private String clientCpf;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client_id;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", numberCard=" + numberCard +
                ", date=" + date +
                ", cvv=" + cvv +
                ", limit=" + limit +
                ", status=" + status +
                ", clientCpf='" + clientCpf + '\'' +
                ", client_id=" + client_id +
                '}';
    }
}
