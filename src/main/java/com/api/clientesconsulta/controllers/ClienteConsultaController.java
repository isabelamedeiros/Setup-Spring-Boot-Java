package com.api.clientesconsulta.controllers;

import com.api.clientesconsulta.dtos.ClienteConsultaDto;
import com.api.clientesconsulta.models.CadastroModel;
import com.api.clientesconsulta.services.ClienteConsultaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //api rest
@CrossOrigin(origins = "*", maxAge = 3600) //
@RequestMapping("/cliente")
public class ClienteConsultaController {

    //criar ponto de injeçao do service
    final ClienteConsultaService clienteConsultaService;

    //gera um construtor
    public ClienteConsultaController(ClienteConsultaService clienteConsultaService) {
        this.clienteConsultaService = clienteConsultaService;
    }

    //salvar um registro = POST
    @PostMapping //pode adicionar uma uri
    //metodo publico com retorno responseentity recebendo o clienteconsulta. para receber como json: @requestbody
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteConsultaDto clienteConsultaDto) {

        if (clienteConsultaService.existsByXxxxNumber(clienteConsultaDto.getXxxxNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Numero está em uso!");
        }

            CadastroModel cadastroModel = new CadastroModel();
            //convertendo dto em model
            BeanUtils.copyProperties(clienteConsultaDto, cadastroModel);
            cadastroModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteConsultaService.save(cadastroModel));
        }

        //GET
    @GetMapping
    public ResponseEntity<List<CadastroModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteConsultaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneClientes(@PathVariable(value = "id") UUID id){
        Optional<CadastroModel> cadastroModelOptional = clienteConsultaService.findById(id);
        if(!cadastroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastroModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id){
        Optional<CadastroModel> cadastroModelOptional = clienteConsultaService.findById(id);
        if(!cadastroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        clienteConsultaService.delete(cadastroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClientes(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClienteConsultaDto clienteConsultaDto){
        Optional<CadastroModel> cadastroModelOptional = clienteConsultaService.findById(id);
        if(!cadastroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        CadastroModel cadastroModel = cadastroModelOptional.get();
        cadastroModel.getXxxxNumber(clienteConsultaDto.getXxxxNumber());
        return ResponseEntity.status(HttpStatus.OK).body(clienteConsultaService.save(cadastroModel));

    }
}