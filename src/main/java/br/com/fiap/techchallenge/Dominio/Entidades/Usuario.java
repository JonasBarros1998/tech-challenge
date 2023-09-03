package br.com.fiap.techchallenge.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@JsonManagedReference
	private List<Eletrodomestico> eletrodomesticos;

	@OneToOne(cascade = CascadeType.DETACH, mappedBy = "usuario")
	Cliente usuario;

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
		return this.eletrodomesticos;
	}


	public Cliente getCliente() {
		return this.usuario;
	}

}
