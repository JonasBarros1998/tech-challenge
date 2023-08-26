package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Infra.Repository.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarEletrodomesticos {

	EletrodomesticoRepository eletrodomesticoRepository;

	@Autowired
	public GerenciarEletrodomesticos(EletrodomesticoRepository eletrodomesticoRepository) {
		this.eletrodomesticoRepository = eletrodomesticoRepository;
	}



}
