package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.form.LoginForm;
import br.com.avanade.dio.apis.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("{id}")
    public ClientDTO getClient() {
        return null;
    }

    @GetMapping
    public List<ClientDTO> getClients() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientForm clientForm) {
        return null;
    }

    /**
     *
     * @param form
     * @return
     */
    @PostMapping("/signIn")
    public ResponseEntity createUser(@RequestBody LoginForm form) {
        var client = service.createClient(form);
        return ResponseEntity.ok().body(client);
    }
}
