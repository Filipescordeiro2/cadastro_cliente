package Cadastro.com.cliente.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome_cliente")
    private String Nome;
    @Column(name = "sobrenome_cliente")
    private String Sobrenome;
    @Column(name = "telefone_cliente")
    private String Telefone;
    @Column(name = "celular_cliente")
    private String Celular;
    @Column(name = "data_de_nascimento_cliente")
    private LocalDate DataDeNascimento;
    @CPF
    @Column(name = "cpf_cliente")
    private String CPF;
    @Email
    private String email;
    @Column(name = "sexo_cliente")
    private String Sexo;
    private LocalDate DataCadastro;

}
