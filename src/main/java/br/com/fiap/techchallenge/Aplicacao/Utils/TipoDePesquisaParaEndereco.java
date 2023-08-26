package br.com.fiap.techchallenge.Aplicacao.Utils;

public enum TipoDePesquisaParaEndereco {
	BAIRRO("bairro"),
	CIDADE("cidade"),
	RUA("rua"),
	ESTADO("estado");

	private String nome;

	TipoDePesquisaParaEndereco(String nome) {
		System.out.println("nome >> " + nome);
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
