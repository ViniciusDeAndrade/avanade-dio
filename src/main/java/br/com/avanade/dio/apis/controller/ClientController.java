package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ClientDTO getClient() {
        return null;
    }

    @GetMapping
    public List<ClientDTO> getClients() {
        return null;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientForm clientForm) {
        return null;
    }
}
