package br.com.avanade.dio.apis.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginForm {
    private String email, password;
}
