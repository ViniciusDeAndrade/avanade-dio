package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signIn")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public void auth(@RequestBody LoginForm form) {
        var token = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword());
        var auth = authenticationManager.authenticate(token);
    }




}
