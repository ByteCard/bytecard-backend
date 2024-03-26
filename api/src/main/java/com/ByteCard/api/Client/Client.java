package com.ByteCard.api.Client;

import com.ByteCard.api.Client.Dados.DadosClient;
import com.ByteCard.api.Client.Dados.DadosAlteraCliente;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "ativo")
    private Boolean ativo;

    public Client(DadosClient dados){
      this.ativo = true;
      this.name = dados.name();
      this.cpf = dados.cpf();
      this.email = dados.email();
      this.telephone = dados.telephone();
    }

    public void desativandoClient(){
        this.ativo = false;
        // e ver que em fatura em aberto
        // não poder criar cartão se cliente tiver desativado
        // para excluir totalmente depois de um tempo
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", ativo=" + ativo +
                '}';
    }

    public void alteraDados(DadosAlteraCliente cliente) {
        if(cliente.cpf() != null && cliente.cpf().length()>2){
            this.cpf =cliente.cpf();
        }
        if(cliente.name() !=null&&cliente.name().length()>2){
            this.name = cliente.name();
        }
        if(cliente.email() !=null&&cliente.email().length()>2){
            this.email = cliente.email();
        }
        if(cliente.telephone() !=null&&cliente.telephone().toString().length()>2){
            this.telephone = cliente.telephone();
        }


    }
}
