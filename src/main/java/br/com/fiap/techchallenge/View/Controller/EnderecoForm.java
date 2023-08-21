package br.com.fiap.techchallenge.View.Controller;

public record EnderecoForm(
	String rua,
	String numero,
	String bairro,
	String cidade,
	String estado,
	String cep
) {}
