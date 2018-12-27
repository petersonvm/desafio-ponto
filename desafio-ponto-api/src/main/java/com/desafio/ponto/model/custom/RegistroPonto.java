package com.desafio.ponto.model.custom;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

public class RegistroPonto {
	
	private long pis;
	private String nome;
	private String competencia;
	private List<Marcacoes> marcacoes;
	private double totalHorasTrabalhadas;
	
	@JSON(name="PIS")
	public long getPis() {
		return pis;
	}
	public void setPis(long pis) {
		this.pis = pis;
	}
	@JSON(name="Funcionario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@JSON(name="Competencia")
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	@JSON(name="Marcacoes")
	public List<Marcacoes> getMarcacoes() {
		return marcacoes;
	}
	public void setMarcacoes(List<Marcacoes> marcacoes) {
		this.marcacoes = marcacoes;
	}
	
	@JSON(name="TotalHorasTrabalhadas")
	public double getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}
	public void setTotalHorasTrabalhadas(double totalHorasTrabalhadas) {
		this.totalHorasTrabalhadas = (totalHorasTrabalhadas/60);
	}
	
	


	


}
