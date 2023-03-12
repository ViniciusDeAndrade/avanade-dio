package br.com.avanade.dio.apis.repository;

import br.com.avanade.dio.apis.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
}
