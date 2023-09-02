package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.EletrodomesticosUsuarios;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;

import java.util.List;
import java.util.UUID;

public class UsuarioDTO {

	private String email;

	private UUID id;

	public static List<Usuario> converterDeUsuarioDTOParaUsuario(List<UsuarioDTO> usuariosDTO) {
		return usuariosDTO.stream().map((usuario) -> new Usuario(usuario.getEmail(), usuario.getId())).toList();
	}

	public static Usuario converterDeUsuarioDTOParaUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getEmail());
	}

	public String getEmail() {
		return email;
	}

	public UUID getId() {
		return id;
	}
}


