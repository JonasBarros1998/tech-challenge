package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 200, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String senha;

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {}
}
