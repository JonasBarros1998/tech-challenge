package br.com.fiap.techchallenge.View.Controller.DTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AdicionarUsuarioAoEletrodomesticoDTO(
	@NotNull
	UUID usuario
) {}
