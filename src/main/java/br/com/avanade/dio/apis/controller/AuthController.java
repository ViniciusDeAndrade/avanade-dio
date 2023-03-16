package br.com.avanade.dio.apis.controller;

import br.com.avanade.dio.apis.form.LoginForm;
import br.com.avanade.dio.apis.model.ClientModel;
import br.com.avanade.dio.apis.service.ClientService;
import br.com.avanade.dio.apis.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity auth(@RequestBody LoginForm form) {
        var authToken = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword());
        var auth = authenticationManager.authenticate(authToken);

        var dto = tokenService.getToken((ClientModel) auth.getPrincipal());
        return ResponseEntity.ok(Map.of("token",dto));
    }

    @PostMapping("newUser")
    public ResponseEntity createNewUser(@RequestBody LoginForm form) {
        clientService.createClient(form);
        return auth(form);
    }




}
