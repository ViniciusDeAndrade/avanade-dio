package br.com.avanade.dio.apis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;


}
