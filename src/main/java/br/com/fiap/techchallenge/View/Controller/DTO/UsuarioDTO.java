package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.domain.Entidades.Usuario;

public record UsuarioDTO(
	String email,
	String senha
) {

	public static Usuario converterDeUsuarioDTOParaUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(
			usuarioDTO.email(),
			usuarioDTO.senha()
		);
	}

}


