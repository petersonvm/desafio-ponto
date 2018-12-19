package com.desafio.ponto.model.custom;

import java.util.List;

public class RegistroPonto {
	
	private String competencia;
	private List<Marcacao> marcacoes;
	private int horasTrabalhadas;
	private int horasExtras;
	private int horasNegativas;
	
	
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public List<Marcacao> getMarcacoes() {
		return marcacoes;
	}
	public void setMarcacoes(List<Marcacao> marcacoes) {
		this.marcacoes = marcacoes;
	}
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public int getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	public int getHorasNegativas() {
		return horasNegativas;
	}
	public void setHorasNegativas(int horasNegativas) {
		this.horasNegativas = horasNegativas;
	}
	
	
}
