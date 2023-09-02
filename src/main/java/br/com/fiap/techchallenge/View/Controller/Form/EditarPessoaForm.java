package br.com.fiap.techchallenge.View.Controller.Form;

import java.time.LocalDate;
import java.util.UUID;

public class EditarPessoaForm {
	private UUID id;
	private String nome;
	private LocalDate nascimento;
	private String genero;
	private String cpf;
	private GrauParentesco grauParentesco;

	// Construtor vazio (necessário para desserialização)
	public EditarPessoaForm() {
	}

	public EditarPessoaForm(String nome, LocalDate nascimento, String genero, String cpf, GrauParentesco grauParentesco) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.cpf = cpf;
		this.grauParentesco = grauParentesco;
	}

	// Construtor sem o campo grauParentesco
	public EditarPessoaForm(String nome, LocalDate nascimento, String genero, String cpf) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.cpf = cpf;
		this.grauParentesco = null;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}


	public String getGenero() {
		return genero;
	}

	public String getCpf() {
		return cpf;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public UUID getId() {
		return this.id;
	}
}
