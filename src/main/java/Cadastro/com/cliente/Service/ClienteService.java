package Cadastro.com.cliente.Service;

import Cadastro.com.cliente.DTO.AtualizarCelularDTO;
import Cadastro.com.cliente.DTO.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    ClienteDTO salvarCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> listarTodosClientes(ClienteDTO filtro);
    void deletarCliente(Long id);
    void atualizarCelular(Long id, AtualizarCelularDTO dto);

}
