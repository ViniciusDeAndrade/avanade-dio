package br.com.avanade.dio.apis.model;

import br.com.avanade.dio.apis.dto.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class ClientModel implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;

    private String password;
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

    public ClientModel(String email, String password) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public ClientDTO toDto() {
        return new ClientDTO(id, name, cpf, email, birthDate);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
