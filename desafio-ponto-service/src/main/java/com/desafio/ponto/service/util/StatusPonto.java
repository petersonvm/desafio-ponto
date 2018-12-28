package com.desafio.ponto.service.util;

/**
 * Classe os status do registro de ponto e marcação.
 * 
 * @author Peterson Morais
 */
public class StatusPonto {
	
	/**
	 * Representa um registro de ponto novo. 
	 */
	public static int NOVO = 0;
	/**
	 * Representa um registro de ponto completo e com o intervalo respeitado. 
	 */
	public static int OK = 1;
	/**
	 * Representa um registro de ponto inclompleto, quando esta faltando uma saida para um entrada ou vice-versa. 
	 */
	public static int MARCACOES_INCOMPLETA = 2;
	
	/**
	 * Representa um registro de ponto inclompleto, quando o intervalo minimo não foi respeitado. 
	 */
	public static int INTERVALO_NAO_RESPEITADO = 3;

	
	/**
	 *  Retorna uma string referente ao um status
	 *
	 * @param  key  o valor int de um status
	 * @return A string referente ao um status
	 */
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