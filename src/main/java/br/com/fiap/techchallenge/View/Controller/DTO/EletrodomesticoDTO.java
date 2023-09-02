package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.EficienciaEnergetica;
import br.com.fiap.techchallenge.Dominio.Entidades.Eletrodomestico;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record EletrodomesticoDTO (
	@NotEmpty
	String nome,

	@NotEmpty
	String modelo,

	@NotNull
	@PositiveOrZero(message = "deve ser maior que 0")
	BigDecimal potencia,

	@NotNull
	@PositiveOrZero(message = "deve ser maior que 0")
	BigDecimal volts,

	@NotEmpty
	String marca,

	@Valid
	EficienciaEnergeticaDTO eficienciaEnergetica,

	@Valid
	List<UsuarioDTO> usuarios
) {

	public String getDataDeCadastro() {
		return LocalDate.now().toString();
	}

	private static EficienciaEnergeticaDTO converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(EficienciaEnergetica eficienciaEnergetica) {
		return new EficienciaEnergeticaDTO(
			eficienciaEnergetica.getConsumoEnergetico(),
			eficienciaEnergetica.getClassificacao(),
			eficienciaEnergetica.getPorcentagemDeEconomia()
		);
	}

	private static EficienciaEnergetica converterDeEficienciaEnergeticaDTOParaEficiencieEnergetica(EficienciaEnergeticaDTO eficienciaEnergetica) {
		return new EficienciaEnergetica(
			eficienciaEnergetica.consumoEnergetico(),
			eficienciaEnergetica.classificacao(),
			eficienciaEnergetica.porcentagemDeEconomia()
		);
	}

	public static Eletrodomestico converterDeEletrodomesticoDTOParaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
		var eletrodomestico = new Eletrodomestico(
			eletrodomesticoDTO.nome(),
			eletrodomesticoDTO.modelo(),
			eletrodomesticoDTO.potencia(),
			eletrodomesticoDTO.volts(),
			eletrodomesticoDTO.marca(),
			converterDeEficienciaEnergeticaDTOParaEficiencieEnergetica(eletrodomesticoDTO.eficienciaEnergetica)
		);


		if(eletrodomesticoDTO.usuarios.size() > 0) {
			eletrodomesticoDTO.usuarios().stream().forEach((usuario) -> {
				eletrodomestico.addUsuario(new Usuario(usuario.getEmail(), usuario.getId()));
			});
		}

		return eletrodomestico;

	}

	/*
	public static List<EletrodomesticoDTO> converterDeEletrodomesticoParaEletrodomesticoDTO(List<Eletrodomestico> eletrodomesticos) {
		return eletrodomesticos.stream().map((eletrodomestico) -> new EletrodomesticoDTO(
			eletrodomestico.getNome(),
			eletrodomestico.getModelo(),
			eletrodomestico.getPotencia(),
			eletrodomestico.getVolts(),
			eletrodomestico.getMarca(),
			converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(eletrodomestico.getEficienciaEnergetica()),
		)).toList();

	}*/

	/*
	public static EletrodomesticoDTO converterDeEletrodomesticoParaEletrodomesticoDTO(Eletrodomestico eletrodomestico) {
		return new EletrodomesticoDTO(
			eletrodomestico.getNome(),
			eletrodomestico.getModelo(),
			eletrodomestico.getPotencia(),
			eletrodomestico.getVolts(),
			eletrodomestico.getMarca(),
			converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(eletrodomestico.getEficienciaEnergetica())
			//UsuarioDTO.converterDeUsuarioParaUsuarioDTO(eletrodomestico.getEletrodomesticosDosUsuarios())
		);
	}*/

}
