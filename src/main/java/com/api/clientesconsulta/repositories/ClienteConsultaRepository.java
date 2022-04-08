package com.api.clientesconsulta.repositories;

import com.api.clientesconsulta.models.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//estender o jpa do Spring Data -> passa o model e o identificador, jparepository ja possui metodos para trabalhar com dados
@Repository // para transaçoes com base de dados
public interface ClienteConsultaRepository extends JpaRepository<CadastroModel, UUID> {

    boolean existsByXxxxNumber(String xxxxNumber);
}
