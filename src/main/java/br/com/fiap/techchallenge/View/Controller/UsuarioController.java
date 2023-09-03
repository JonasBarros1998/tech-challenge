package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarUsuarios;
import br.com.fiap.techchallenge.View.Controller.DTO.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	GerenciarUsuarios gerenciarUsuarios;

	@Autowired
	public UsuarioController(GerenciarUsuarios gerenciarUsuarios) {
		this.gerenciarUsuarios = gerenciarUsuarios;
	}
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		var usuario = this.gerenciarUsuarios.salvar(usuarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
}
