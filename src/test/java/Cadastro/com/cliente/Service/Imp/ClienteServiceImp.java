package Cadastro.com.cliente.Service.Imp;

import Cadastro.com.cliente.DTO.AtualizarCelularDTO;
import Cadastro.com.cliente.DTO.ClienteDTO;
import Cadastro.com.cliente.Entity.ClienteEntity;
import Cadastro.com.cliente.Respository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteServiceImpTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImp clienteServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarCliente() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("John");
        clienteDTO.setSobrenome("Doe");

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome("John");
        clienteEntity.setSobrenome("Doe");
        clienteEntity.setDataCadastro(LocalDate.now());

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        ClienteDTO result = clienteServiceImp.salvarCliente(clienteDTO);

        assertNotNull(result);
        assertEquals("John", result.getNome());
        assertEquals("Doe", result.getSobrenome());
    }

    @Test
    void testListarTodosClientes() {
        ClienteDTO filtro = new ClienteDTO();
        filtro.setNome("John");

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome("John");

        when(clienteRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(clienteEntity));

        List<ClienteDTO> result = clienteServiceImp.listarTodosClientes(filtro);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("John", result.get(0).getNome());
    }

    @Test
    void testDeletarCliente() {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteEntity));

        clienteServiceImp.deletarCliente(1L);

        verify(clienteRepository, times(1)).delete(clienteEntity);
    }

    @Test
    void testDeletarClienteNotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> clienteServiceImp.deletarCliente(1L));
    }

    @Test
    void testAtualizarCelular() {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        clienteEntity.setCelular("123456789");

        AtualizarCelularDTO dto = new AtualizarCelularDTO();
        dto.setNovoCelular("987654321");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteEntity));

        clienteServiceImp.atualizarCelular(1L, dto);

        assertEquals("987654321", clienteEntity.getCelular());
        verify(clienteRepository, times(1)).save(clienteEntity);
    }

    @Test
    void testAtualizarCelularNotFound() {
        AtualizarCelularDTO dto = new AtualizarCelularDTO();
        dto.setNovoCelular("987654321");

        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> clienteServiceImp.atualizarCelular(1L, dto));
    }
}