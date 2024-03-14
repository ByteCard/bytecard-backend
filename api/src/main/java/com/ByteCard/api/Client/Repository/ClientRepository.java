package com.ByteCard.api.Client.Repository;

import com.ByteCard.api.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query(value = "SELECT * FROM cliente where cpf = ?1",nativeQuery = true)
    Client CLIENT(String cpf);
    @Query(value = "SELECT * FROM cliente",nativeQuery = true)
    List<Client> CLIENT();


    List<Client> findAllByAtivoTrue();
}
