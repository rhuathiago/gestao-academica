package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Login não pode ser vazio")
    private String login;

    @NotNull
    private Integer matricula;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Senha não pode ser vazia")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", columnDefinition = "VARCHAR(255)")
    private TipoDeUsuario tipoDeUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (TipoDeUsuario tipo : TipoDeUsuario.values()) {
            if (verificaTipoDeUsuario(tipo)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + tipo.name()));
            }
        }

        return authorities;
    }

    private boolean verificaTipoDeUsuario(TipoDeUsuario tipo) {
        return tipoDeUsuario == tipo;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
