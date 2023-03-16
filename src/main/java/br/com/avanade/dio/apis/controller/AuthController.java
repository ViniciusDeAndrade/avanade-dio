package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signIn")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void nada(@RequestBody LoginForm form) {
        var token = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getSenha());
        var auth = authenticationManager.authenticate(token);
    }




}
