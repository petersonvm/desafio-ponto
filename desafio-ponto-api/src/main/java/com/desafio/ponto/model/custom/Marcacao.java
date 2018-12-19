package com.desafio.ponto.model.custom;

import java.util.Date;

public class Marcacao {
	
	private Date data;
	private boolean marcacaoValida;  
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isMarcacaoValida() {
		return marcacaoValida;
	}
	public void setMarcacaoValida(boolean marcacaoValida) {
		this.marcacaoValida = marcacaoValida;
	}


}
