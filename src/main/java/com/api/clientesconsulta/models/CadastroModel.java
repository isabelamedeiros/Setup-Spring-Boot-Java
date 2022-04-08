package com.api.clientesconsulta.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "xxxx") //xxxx = nome da tabela que vai ser gerada na base de dados
public class CadastroModel implements Serializable { //serializable: conversoes
    private static final long serialVersionUID = 1L; //controle das conversoes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //id é gerado automaticamente
    private UUID id; //identificador do tipo uuid

    @Column(nullable = false, unique = true, length = 10) //nao pode ser nulo, campo unico, limitado a 10 caracteres
    private String xxxxNumber;

    @Column(nullable = false) //data
    private LocalDateTime registrationDate;

    //gerar metodos getters e setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getXxxxNumber(String xxxxNumber) {
        return this.xxxxNumber;
    }

    public void setXxxxNumber(String xxxxNumber) {
        this.xxxxNumber = xxxxNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

}
