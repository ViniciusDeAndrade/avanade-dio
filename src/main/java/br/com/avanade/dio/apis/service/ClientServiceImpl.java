package br.com.avanade.dio.apis.service;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.exception.ApplicationException;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.model.ClientModel;
import br.com.avanade.dio.apis.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public ClientDTO createClient(ClientForm client) {
        return repository.save(client.toModel()).toDto();
    }

    @Override
    public ClientDTO getClient(int id) throws ApplicationException {
        var clientOp = repository.findById(id);
        if(clientOp.isPresent()) return clientOp.get().toDto();
        throw new ApplicationException("client.not.found");
    }

    @Override
    public List<ClientDTO> getClients() {
        return repository.findAll().stream().map(ClientModel::toDto).toList();
    }
}
