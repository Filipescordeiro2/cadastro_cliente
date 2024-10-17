package Cadastro.com.cliente.Service.Imp;

import Cadastro.com.cliente.DTO.AtualizarCelularDTO;
import Cadastro.com.cliente.DTO.ClienteDTO;
import Cadastro.com.cliente.Entity.ClienteEntity;
import Cadastro.com.cliente.Respository.ClienteRepository;
import Cadastro.com.cliente.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {
        ClienteEntity cliente = fromDTO(clienteDTO);
        cliente.setDataCadastro(LocalDate.now());
        ClienteEntity clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);
    }

    @Override
    public List<ClienteDTO> listarTodosClientes(ClienteDTO filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        ClienteEntity clienteFiltro = fromDTO(filtro);
        Example<ClienteEntity> example = Example.of(clienteFiltro, matcher);

        List<ClienteEntity> clientesList = clienteRepository.findAll(example);
        return clientesList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return cliente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @Override
    public void atualizarCelular(Long id, AtualizarCelularDTO dto) {
        ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Atualiza o telefone diretamente (texto puro)
        cliente.setCelular(dto.getNovoCelular());

        // Salva o cliente com a nova senha
        clienteRepository.save(cliente);
    }


    private ClienteDTO toDTO(ClienteEntity cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setSobrenome(cliente.getSobrenome());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setCelular(cliente.getCelular());
        clienteDTO.setDataDeNascimento(cliente.getDataDeNascimento());
        clienteDTO.setCPF(cliente.getCPF());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setSexo(cliente.getSexo());

        return clienteDTO;
    }

    private ClienteEntity fromDTO(ClienteDTO clienteDTO) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setDataDeNascimento(clienteDTO.getDataDeNascimento());
        cliente.setCPF(clienteDTO.getCPF());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSexo(clienteDTO.getSexo());

        return cliente;
    }
}
