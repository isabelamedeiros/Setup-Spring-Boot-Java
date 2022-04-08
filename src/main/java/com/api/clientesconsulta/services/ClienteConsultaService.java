package com.api.clientesconsulta.services;

import com.api.clientesconsulta.models.CadastroModel;
import com.api.clientesconsulta.repositories.ClienteConsultaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//camada entre controller e repository e para regras de negocio
@Service
public class ClienteConsultaService {

    //ponto de injeçao do repository, pois precisa acionar o repository
    //controller aciona o service e o service o repository

//    @Autowired //vai precisar injetar ClienteConsultaRepository
//    ClienteConsultaRepository clienteConsultaRepository;

//    criando via construtor:
    final ClienteConsultaRepository clienteConsultaRepository;

    public ClienteConsultaService(ClienteConsultaRepository clienteConsultaRepository){
        this.clienteConsultaRepository = clienteConsultaRepository;
    }

    @Transactional //garante rollback
    public CadastroModel save(CadastroModel cadastroModel) {
        return clienteConsultaRepository.save(cadastroModel);
    }

    public boolean existsByXxxxNumber(String xxxxNumber) {
        return clienteConsultaRepository.existsByXxxxNumber(xxxxNumber);
    }

    public List<CadastroModel> findAll() {
        return clienteConsultaRepository.findAll();
    }

    public Optional<CadastroModel> findById(UUID id) {
        return clienteConsultaRepository.findById(id);
    }

    @Transactional
    public void delete(CadastroModel cadastroModel) {
        clienteConsultaRepository.delete(cadastroModel);
    }
}
