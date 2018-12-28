package com.desafio.ponto.model.custom;

import com.liferay.portal.kernel.json.JSON;

/**
 * Classe que representa uma Marcac�o de ponto, � composta das seguintes informa��o Data da marcac�o,
 * lista de marca��es realizadas no dia e o Status da marca��o.
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
	 * Retorna a data da marca��o.
	 *
	 * @return A data da marca��o
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
	 * Retorna o status da marca��o.
	 *
	 * @return O status da marca��o
	 */	
	@JSON(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
