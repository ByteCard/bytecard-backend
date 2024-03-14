package com.ByteCard.api.Compra;

import com.ByteCard.api.Card.Card;
import com.ByteCard.api.Client.Client;
import com.ByteCard.api.Compra.Dados.CategoriaCompra;
import com.ByteCard.api.Compra.Dados.DadosCompra;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "compra")
public class Compra {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "data_compra")
    private LocalDateTime date;
    @Column(name = "estabelecimento")
    private String estabelecimento;
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaCompra categoriaCompra;
    @Column(name = "Numero_cartao")
    private Long numeroCard;
    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client clientId;
    @ManyToOne
    @JoinColumn(name = "Cartao_id")
    private Card cardId;
    public Compra(DadosCompra compra, Client client , Card card){
        this.valor = compra.valor().abs();
        this.date = LocalDateTime.now();
        this.estabelecimento =compra.estabelecimento();
        this.categoriaCompra = compra.categoriaCompra();
        this.numeroCard = compra.numberCard();
        this.clientId = client;
        this.cardId =card;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", valor=" + valor +
                ", date=" + date +
                ", estabelecimento='" + estabelecimento + '\'' +
                ", categoriaCompra=" + categoriaCompra +
                ", numeroCard=" + numeroCard +
                ", clientId=" + clientId +
                ", cardId=" + cardId +
                '}';
    }
}
