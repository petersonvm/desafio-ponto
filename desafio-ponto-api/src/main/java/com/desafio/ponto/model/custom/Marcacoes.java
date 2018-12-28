package com.desafio.ponto.model.custom;

import com.liferay.portal.kernel.json.JSON;

/**
 * Classe que representa uma Marcacão de ponto, é composta das seguintes informação Data da marcacão,
 * lista de marcações realizadas no dia e o Status da marcação.
 * 
 * @author Peterson Morais
 * 
 */


import java.util.List;

public class Marcacoes {
	
	private String data;
	private List<String> batidas;
	private double horasTrabalhadas;
	private String status; 

	/**
	 * Retorna a data da marcação.
	 *
	 * @return A data da marcação
	 */
	@JSON(name="Data")
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Retorna a lista de batidas.
	 *
	 * @return A lista de batidas
	 */	
	@JSON(name="Batidas")
	public List<String> getBatidas() {
		return batidas;
	}
	public void setBatidas(List<String> batidas) {
		this.batidas = batidas;
	}
	
	
	/**
	 * Retorna a quantidade de horas trabalhadas.
	 *
	 * @return A quantidade de horas trabalhadas.
	 */		
	@JSON(name="HorasTrabalhadas")
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = (horasTrabalhadas/60);
	}
	
	/**
	 * Retorna o status da marcação.
	 *
	 * @return O status da marcação
	 */	
	@JSON(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
