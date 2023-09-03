package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.EficienciaEnergetica;
import br.com.fiap.techchallenge.Dominio.Entidades.Eletrodomestico;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EletrodomesticoDTO {

	@NotEmpty
	private String nome;

	@NotEmpty
	private String modelo;

	@NotNull
	@PositiveOrZero(message = "deve ser maior que 0")
	private BigDecimal potencia;

	@NotNull
	@PositiveOrZero(message = "deve ser maior que 0")
	private BigDecimal volts;

	@NotEmpty
	private String marca;

	@Valid
	@NotNull
	private EficienciaEnergeticaDTO eficienciaEnergetica;

	@Valid
	private List<UsuarioDTO> usuarios;

	private LocalDate dataCadastro;

	public EletrodomesticoDTO(
		String nome,
		String modelo,
		BigDecimal potencia,
		BigDecimal volts,
		String marca,
		EficienciaEnergeticaDTO eficienciaEnergetica,
		List<UsuarioDTO> usuarios
	) {
		this.nome = nome;
		this.modelo = modelo;
		this.potencia = potencia;
		this.volts = volts;
		this.marca = marca;
		this.eficienciaEnergetica = eficienciaEnergetica;
		this.usuarios = usuarios;
	}

	private static EficienciaEnergeticaDTO converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(EficienciaEnergetica eficienciaEnergetica) {
		return new EficienciaEnergeticaDTO(
			eficienciaEnergetica.getConsumoEnergetico(),
			eficienciaEnergetica.getClassificacao(),
			eficienciaEnergetica.getPorcentagemDeEconomia()
		);
	}

	public String getNome() {
		return nome;
	}

	public String getModelo() {
		return modelo;
	}

	public BigDecimal getPotencia() {
		return potencia;
	}

	public BigDecimal getVolts() {
		return volts;
	}

	public String getMarca() {
		return marca;
	}

	public EficienciaEnergeticaDTO getEficienciaEnergetica() {
		return eficienciaEnergetica;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public String getDataDeCadastro() {
		return LocalDate.now().toString();
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
			eletrodomesticoDTO.getNome(),
			eletrodomesticoDTO.getModelo(),
			eletrodomesticoDTO.getPotencia(),
			eletrodomesticoDTO.getVolts(),
			eletrodomesticoDTO.getMarca(),
			converterDeEficienciaEnergeticaDTOParaEficiencieEnergetica(eletrodomesticoDTO.getEficienciaEnergetica())
		);


		if(eletrodomesticoDTO.usuarios.size() > 0) {
			eletrodomesticoDTO.getUsuarios().stream().forEach((usuario) -> {
				eletrodomestico.addUsuario(new Usuario(usuario.id()));
			});
		}

		return eletrodomestico;

	}

	public static List<EletrodomesticoDTO> converterDeEletrodomesticoParaEletrodomesticoDTO(List<Eletrodomestico> eletrodomesticos) {
		return eletrodomesticos.stream().map((eletrodomestico) -> new EletrodomesticoDTO(
			eletrodomestico.getNome(),
			eletrodomestico.getModelo(),
			eletrodomestico.getPotencia(),
			eletrodomestico.getVolts(),
			eletrodomestico.getMarca(),
			converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(eletrodomestico.getEficienciaEnergetica()),
			null
		)).toList();
	}

	public static EletrodomesticoDTO converterDeEletrodomesticoParaEletrodomesticoDTO(Eletrodomestico eletrodomestico) {
    return new EletrodomesticoDTO(
			eletrodomestico.getNome(),
			eletrodomestico.getModelo(),
			eletrodomestico.getPotencia(),
			eletrodomestico.getVolts(),
			eletrodomestico.getMarca(),
			converterDeEficienciaEnergeticaParaEficiencieEnergeticaDTO(eletrodomestico.getEficienciaEnergetica()),
			null
    );
	}

}
