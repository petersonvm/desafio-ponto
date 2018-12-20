package com.desafio.ponto.model.custom;

import java.util.Date;
import java.util.List;

public class Marcacoes {
	
	private Date data;
	private List<String> batidas;
	private int horasTrabalhadas;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<String> getBatidas() {
		return batidas;
	}
	public void setBatidas(List<String> batidas) {
		this.batidas = batidas;
	}
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	

	
	

}
