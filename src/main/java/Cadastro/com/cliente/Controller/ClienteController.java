package Cadastro.com.cliente.Controller;


import Cadastro.com.cliente.DTO.ClienteDTO;
import Cadastro.com.cliente.Service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
