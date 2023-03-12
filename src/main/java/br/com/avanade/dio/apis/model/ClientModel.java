package br.com.avanade.dio.apis.model;

import br.com.avanade.dio.apis.dto.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class ClientModel {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientModel(
        String name,
        String cpf,
        String email,
        LocalDate birthDate

    ) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;

        var lt = LocalDateTime.now();
        createdAt = lt;
        updatedAt = lt;
    }

    public ClientDTO toDto() {
        return new ClientDTO(id, name, cpf, email, birthDate);
    }
}
