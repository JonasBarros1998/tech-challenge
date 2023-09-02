package br.com.fiap.techchallenge.Dominio.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class EletrodomesticosUsuarios implements Serializable {

	//@Id
	UUID id;

	//@ManyToOne
	//@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	//@ManyToOne
	//@JoinColumn(name = "eletrodomestico_id")
	private Eletrodomestico eletrodomestico ;

	public EletrodomesticosUsuarios() {}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Eletrodomestico getEletrodomestico() {
		return this.eletrodomestico;
	}

	public UUID getId() {
		return id;
	}

}
