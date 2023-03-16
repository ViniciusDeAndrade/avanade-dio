package br.com.avanade.dio.apis.repository;

import br.com.avanade.dio.apis.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    Optional<ClientModel> getByEmail(String username);
}
