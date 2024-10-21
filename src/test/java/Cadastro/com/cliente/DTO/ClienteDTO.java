package Cadastro.com.cliente.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {


    private Long Id;
    private String Nome;
    private String Sobrenome;
    private String Telefone;
    private String Celular;
    private LocalDate DataDeNascimento;

    @CPF
    @Column(name = "cpf_cliente")
    private String CPF;
    @Email
    private String email;
    private String Sexo;

}
