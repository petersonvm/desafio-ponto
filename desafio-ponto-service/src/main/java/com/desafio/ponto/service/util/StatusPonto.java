package com.desafio.ponto.service.util;

public class StatusPonto {    
	public static int NOVO = 0;
	public static int OK = 1; 
	public static int MARCACOES_INCOMPLETA = 2;
	public static int INTERVALO_NAO_RESPEITADO = 3;

	public static String getStatus(int key) {
		switch (key) {
		case 0:
			return "NOVO";
		case 1:
			return "OK";
		case 2:
			return "MARCACOES_INCOMPLETA";
		case 3:
			return "INTERVALO_NAO_RESPEITADO";	
		default:
			return "INDEFINIDO";
		}
	}
}