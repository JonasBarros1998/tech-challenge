package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.domain.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> { }
