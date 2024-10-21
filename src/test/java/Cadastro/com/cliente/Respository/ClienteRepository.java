package Cadastro.com.cliente.Respository;

import Cadastro.com.cliente.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {


}
