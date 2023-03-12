package br.com.avanade.dio.apis.service;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.form.ClientForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientService {

    @Transactional
    ClientDTO createClient(ClientForm client);

    ClientDTO getClient(int id);

    List<ClientDTO> getClients();
}
