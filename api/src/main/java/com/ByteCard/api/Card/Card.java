package com.ByteCard.api.Card;

import com.ByteCard.api.Card.Dados.Altera;
import com.ByteCard.api.Client.Client;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private Client clientID;

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
                ", client_id=" + clientID +
                '}';
    }

    public void ativarCancelar() {
       this.status =true;
    }
    public void cancelar() {

        this.status =false;
    }

    public void atualizarLimite(Altera altera) {
        if(altera.limiteAlterado() != null) {
            this.limit = altera.limiteAlterado().abs();
        }
    }

    public void alteraDados(String cpf) {
        if(cpf != null &&cpf.length()>2) {
            this.clientCpf = cpf;
        }
    }
}
