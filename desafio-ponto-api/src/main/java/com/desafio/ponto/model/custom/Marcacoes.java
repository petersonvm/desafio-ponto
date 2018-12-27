package com.desafio.ponto.model.custom;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

public class Marcacoes {
	
	private String data;
	private List<String> batidas;
	private double horasTrabalhadas;
	private String status; 
	
	@JSON(name="Data")
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@JSON(name="Batidas")
	public List<String> getBatidas() {
		return batidas;
	}
	public void setBatidas(List<String> batidas) {
		this.batidas = batidas;
	}
	@JSON(name="HorasTrabalhadas")
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = (horasTrabalhadas/60);
	}
	@JSON(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
