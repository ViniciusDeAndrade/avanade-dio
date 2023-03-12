package br.com.avanade.dio.apis.dto;

import br.com.avanade.dio.apis.controller.ClientController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@AllArgsConstructor
@Relation(collectionRelation = "clientes")
public class ClientDTO extends RepresentationModel<ClientDTO> {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;

    public ClientDTO buildLink() {
        this.add(
                linkTo(
                        methodOn(ClientController.class).getClient(id)
                ).withSelfRel()
        );


        return this;
    }
}
