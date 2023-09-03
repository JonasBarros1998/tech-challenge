package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.EletrodomesticosUsuarios;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;

import java.util.List;
import java.util.UUID;

public record UsuarioDTO(
	String email,
	UUID id
) {

	public static Usuario converterDeUsuarioDTOParaUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.email());
	}

	public static UsuarioDTO converterDeUsuarioParaUsuarioDTO(Usuario usuario) {
		return new UsuarioDTO(usuario.getEmail(), usuario.getId());
	}
}


