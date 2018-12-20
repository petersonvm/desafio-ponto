package com.desafio.ponto.model.custom;

import java.util.List;

public class RegistroPonto {
	
	private long pis;
	private String nome;
	private List<Marcacoes> marcacoes;
	private int totalHorasTrabalhadas;
	
	
	public long getPis() {
		return pis;
	}
	public void setPis(long pis) {
		this.pis = pis;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Marcacoes> getMarcacoes() {
		return marcacoes;
	}
	public void setMarcacoes(List<Marcacoes> marcacoes) {
		this.marcacoes = marcacoes;
	}
	public int getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}
	public void setTotalHorasTrabalhadas(int totalHorasTrabalhadas) {
		this.totalHorasTrabalhadas = totalHorasTrabalhadas;
	}
	

	


}
