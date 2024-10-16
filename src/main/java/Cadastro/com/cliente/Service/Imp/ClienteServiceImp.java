package Cadastro.com.cliente.Service.Imp;

import Cadastro.com.cliente.DTO.ClienteDTO;
import Cadastro.com.cliente.Entity.ClienteEntity;
import Cadastro.com.cliente.Respository.ClienteRepository;
import Cadastro.com.cliente.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
