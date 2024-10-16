package Cadastro.com.cliente.Service;

import Cadastro.com.cliente.DTO.ClienteDTO;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    ClienteDTO salvarCliente(ClienteDTO clienteDTO);
}
