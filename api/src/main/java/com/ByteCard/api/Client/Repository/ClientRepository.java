package com.ByteCard.api.Client.Repository;

import com.ByteCard.api.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query(value = "SELECT * FROM cliente where cpf = ?1  and ativo = 1",nativeQuery = true)
    Client CLIENT(String cpf);
    @Query(value = "SELECT * FROM cliente where cpf = ?1  and ativo = 1",nativeQuery = true)
    Optional<Client> CLIENTE(String cpf);
    @Query(value = "SELECT * FROM cliente",nativeQuery = true)
    List<Client> CLIENT();


    List<Client> findAllByAtivoTrue();
}
