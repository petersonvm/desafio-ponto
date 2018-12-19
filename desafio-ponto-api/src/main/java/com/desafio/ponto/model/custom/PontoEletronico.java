package com.desafio.ponto.model.custom;

import java.util.List;

public class PontoEletronico {
	
	
	private long pis;
    private String nome;
    private List<RegistroPonto> registrosPontos;    
    
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
	public List<RegistroPonto> getRegistrosPontos() {
		return registrosPontos;
	}
	public void setRegistrosPontos(List<RegistroPonto> registrosPontos) {
		this.registrosPontos = registrosPontos;
	}
    

	
	
	

}
