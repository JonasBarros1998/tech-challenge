package br.com.fiap.techchallenge.Dominio.Entidades;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 200, nullable = false)
	private String email;

	@ManyToMany(mappedBy = "usuario", cascade = CascadeType.DETACH)
	private List<Eletrodomestico> usuario;

	public Usuario(String email, UUID id) {
		this.email = email;
		this.id = id;
	}

	public Usuario(String email) {
		this.email = email;
	}

	public Usuario(UUID id) {
		this.id = id;
	}

	public Usuario() {}

	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}


	public List<Eletrodomestico> getUsuario() {
		return this.usuario;
	}

}
