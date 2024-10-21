package Cadastro.com.cliente.Controller;


import Cadastro.com.cliente.DTO.AtualizarCelularDTO;
import Cadastro.com.cliente.DTO.ClienteDTO;
import Cadastro.com.cliente.Service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        return clienteService.salvarCliente(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> buscarClientePorParametro(ClienteDTO filtro){
        return clienteService.listarTodosClientes(filtro);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }

    @PatchMapping("/{id}/Celular")
    public ResponseEntity<Void> atualizarCelular(@PathVariable Long id, @Valid @RequestBody AtualizarCelularDTO dto) {
        clienteService.atualizarCelular(id, dto);
        return ResponseEntity.noContent().build();
    }


}
