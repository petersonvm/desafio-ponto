package com.desafio.ponto.model.custom;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

/**
 * Classe que representa um Registro de Ponto , é composto das seguintes informação  Pis do funcionario, Nome do funionario , Mes de competencia 
 * lista de marcações realziadas na competencia e o total de horas trabalhadas na competencia.
 * 
 * @author Peterson Morais
 * @see Marcacoes
 */
public class RegistroPonto {
	
	private long pis;
	private String nome;
	private String competencia;
	private List<Marcacoes> marcacoes;
	private double totalHorasTrabalhadas;
	
	/**
	 * Retorna o numero PIS do funcionario.
	 *
	 * @return O numero PIS do funcionario
	 */		
	@JSON(name="PIS")
	public long getPis() {
		return pis;
	}
	public void setPis(long pis) {
		this.pis = pis;
	}
	
	/**
	 * Retorna nome do funcionario.
	 *
	 * @return O nome do funcionario
	 */		
	@JSON(name="Funcionario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna a competencia do registro de ponto.
	 *
	 * @return A competencia do registro de ponto
	 */	
	@JSON(name="Competencia")
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	
	/**
	 * Retorna a lista de marcacões.
	 *
	 * @return A lista de marcacões.
	 */	
	@JSON(name="Marcacoes")
	public List<Marcacoes> getMarcacoes() {
		return marcacoes;
	}
	public void setMarcacoes(List<Marcacoes> marcacoes) {
		this.marcacoes = marcacoes;
	}
	
	/**
	 * Retorna a quantidade de horas trabalhadas.
	 *
	 * @return A quantidade de horas trabalhadas.
	 */	
	@JSON(name="TotalHorasTrabalhadas")
	public double getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}
	public void setTotalHorasTrabalhadas(double totalHorasTrabalhadas) {
		this.totalHorasTrabalhadas = (totalHorasTrabalhadas/60);
	}
	
	


	


}
