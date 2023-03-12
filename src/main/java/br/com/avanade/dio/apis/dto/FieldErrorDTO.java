package br.com.avanade.dio.apis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldErrorDTO {
    private String field, message;
}
