package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("{id}")
    public ClientDTO getClient(@PathVariable("id") int id) {
        return service.getClient(id);
    }

    @GetMapping
    public CollectionModel<ClientDTO> getClients() {
        var model = CollectionModel.of(service.getClients());
        model.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ClientController.class).getClients()
            ).withSelfRel()
        );
        return model;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientForm clientForm) {
        return ResponseEntity.ok(
            service.createClient(clientForm)
        );
    }
}
