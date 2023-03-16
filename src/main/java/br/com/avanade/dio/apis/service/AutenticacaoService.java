package br.com.avanade.dio.apis.service;

import br.com.avanade.dio.apis.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var clientOp = repository.findByEmail(username);
        if(clientOp.isPresent()) return clientOp.get();

        throw new RuntimeException("client.not.found");
    }
}
