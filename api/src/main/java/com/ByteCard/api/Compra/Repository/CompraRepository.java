package com.ByteCard.api.Compra.Repository;

import com.ByteCard.api.Compra.Compra;
import com.ByteCard.api.Compra.Dados.CompraMaiorValor;
import com.ByteCard.api.Compra.Dados.ComproNada;
import com.ByteCard.api.Compra.Dados.DadosCategoriaRelatorio;
import com.ByteCard.api.Compra.Dados.RelatoiroDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra,Long> {
    @Query(value = "SELECT categoria, SUM(valor) as total FROM Compra  where date_format(data_compra,'%Y-%m') <=>?1 AND Numero_cartao = ?2 group by categoria ",nativeQuery = true)
    List<DadosCategoriaRelatorio> COMPRAS(String date, BigDecimal cartao);

    @Query(value = "select  cliente.nome, cliente.cpf,count(compra.valor) as quantidade from  Cliente  join compra on cliente.id = compra.Client_id join cartao on cartao.id = compra.Cartao_id where  date_format(data_compra,'%Y-%m') <=> ?1 group by cliente.nome ,cliente.cpf order by quantidade desc",nativeQuery = true)
    List<RelatoiroDeCompra> RELATOIRO_DE_COMPRAS(String date);
    @Query(value = "select  cliente.nome, cliente.cpf,max(compra.valor) as valor from Cliente  join compra on cliente.id = compra.Client_id join cartao on cartao.id = compra.Cartao_id where date_format(data_compra,'%Y-%m') <=>?1   group by cliente.nome, cliente.cpf order by valor desc",nativeQuery = true)
    List<CompraMaiorValor> COMPRA_MAIOR_VALORS(String date);
    @Query(value = "SELECT cliente.nome,cartao.numero_cartao as numeroCartao ,cliente.cpf FROM cliente LEFT JOIN cartao ON cliente.id = cartao.id_cliente LEFT JOIN compra ON cartao.id = compra.Cartao_id where compra.id is null ",nativeQuery = true)
    List<ComproNada> ComproNada();
    @Query(value = "SELECT * FROM compra where Numero_cartao = ?1 AND date_format(data_compra,'%Y-%m') <=>?2",nativeQuery = true)
    List<Compra> COMPRASLIST(Long numberCard,String date);



}
