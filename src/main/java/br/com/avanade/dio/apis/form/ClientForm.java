package br.com.avanade.dio.apis.form;

import br.com.avanade.dio.apis.model.ClientModel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientForm {
    @NotNull
    private String name;

    private String cpf;

    private String email;

    private LocalDate birthDate;

    public ClientModel toModel() {
        return new ClientModel(name, cpf, email, birthDate);
    }
}
