package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Infra.Repository.UsuarioRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.UsuarioDTO;
import br.com.fiap.techchallenge.domain.Entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarUsuarios {

	UsuarioRepository usuarioRepository;

	@Autowired
	public GerenciarUsuarios(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = UsuarioDTO.converterDeUsuarioDTOParaUsuario(usuarioDTO);
		this.usuarioRepository.save(usuario);
	}

}
