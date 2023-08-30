package br.com.fiap.techchallenge.View.Controller.Saida;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;

import java.util.List;

public record ConsultarEndereco(
	Endereco endereco,
	List<Cliente> clientes
) { }
