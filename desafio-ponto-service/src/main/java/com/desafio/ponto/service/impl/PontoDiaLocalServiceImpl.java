/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.desafio.ponto.service.impl;

import com.desafio.ponto.exception.PontoDiaExistenteException;
import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.model.impl.PontoDiaImpl;
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.PontoDiaLocalServiceBaseImpl;
import com.desafio.ponto.service.persistence.PontoDiaPK;
import com.desafio.ponto.service.util.DateUtils;
import com.desafio.ponto.service.util.StatusPonto;
import com.liferay.portal.kernel.exception.PortalException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * The implementation of the ponto dia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.desafio.ponto.service.PontoDiaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoDiaLocalServiceBaseImpl
 * @see com.desafio.ponto.service.PontoDiaLocalServiceUtil
 */
public class PontoDiaLocalServiceImpl extends PontoDiaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.desafio.ponto.service.PontoDiaLocalServiceUtil} to access the ponto dia local service.
	 */

	private static long VAL_DIV_MIN = 60000; 

	public PontoDia gravarPonto(long pis, Date dataHora) throws PontoDiaExistenteException {

		try {
			getPontoDia(pis, dataHora);
			throw new PontoDiaExistenteException();
		} catch (PortalException e) {
			PontoDia pontoDia = new PontoDiaImpl();
			pontoDia.setPis(pis);
			pontoDia.setData(DateUtils.atStartOfDay(dataHora).getTime());
			pontoDia.setHoras_Trabalhadas(0);
			SimpleDateFormat fmt = new SimpleDateFormat("MM/yyyy");			
			String competencia = fmt.format(dataHora);			
			pontoDia.setCompetencia(competencia );
			pontoDia.setStatus(StatusPonto.NOVO);

			PontoDiaLocalServiceUtil.addPontoDia(pontoDia);
			return pontoDia;
		}

	}

	public PontoDia getPontoDia(long pis, Date dataHora) throws PortalException {

		long data = DateUtils.atStartOfDay(dataHora).getTime();
		PontoDiaPK pontoDiaPK = new PontoDiaPK(pis, data);
		return PontoDiaLocalServiceUtil.getPontoDia(pontoDiaPK);
	}


	public PontoDia calcularHorasTrabalhadas(PontoDia pontoDia) {	

		List<PontoMarcacoes> marcacoesDia = PontoMarcacoesLocalServiceUtil.findByPisDia(pontoDia.getPis(), pontoDia.getData());
		Stack<PontoMarcacoes> pilha = new Stack<>();

		double fatorDia = getFatorDia(pontoDia);



		if(marcacoesDia.size() > 0) {
			for (PontoMarcacoes pontoMarcacoes : marcacoesDia) {
				pilha.push(pontoMarcacoes);
			}

			while(!pilha.isEmpty()) {
				PontoMarcacoes entrada = pilha.pop();
				PontoMarcacoes saida = null;
				if(!pilha.isEmpty()) {
					saida = pilha.pop();

					double minutos = 0;

					if(checkHorarioDiferenciado(entrada, saida)) {
						minutos  = getMinutosEntradaSaidaDiferenciado(saida, entrada);
					}else {
						minutos = getMinutosEntradaSaida(saida, entrada);
					}

					double horasTrabalhadas = (pontoDia.getHoras_Trabalhadas() + (minutos*fatorDia));

					pontoDia.setHoras_Trabalhadas(horasTrabalhadas); 
					pontoDia.setStatus(StatusPonto.OK);
				}else {
					pontoDia.setStatus(StatusPonto.MARCACOES_INCOMPLETA);

				}
			}
		}

		return pontoDia;
	}


	public PontoDia calcularIntervalos(PontoDia pontoDia) {

		boolean intervaloOk = true;

		if(pontoDia.getHoras_Trabalhadas() == 0) {
			pontoDia = calcularHorasTrabalhadas(pontoDia);
		}

		List<PontoMarcacoes> marcacoesDia = PontoMarcacoesLocalServiceUtil.findByPisDia(pontoDia.getPis(), pontoDia.getData());
		Stack<PontoMarcacoes> pilha = new Stack<>();

		if(marcacoesDia.size() > 0) {
			for (PontoMarcacoes pontoMarcacoes : marcacoesDia) {
				pilha.push(pontoMarcacoes);
			}

			while(!pilha.isEmpty()) {
				PontoMarcacoes entrada = pilha.pop();
				PontoMarcacoes saida = null;
				if(!pilha.isEmpty()) {
					saida = pilha.pop();
					double minutos = getMinutosEntradaSaida(saida, entrada);
					try {

						if(minutos > 240 && minutos < 360) {
							PontoMarcacoes novaEntrada = pilha.pop();
							double difMinutos  =  getMinutosEntradaSaida(novaEntrada, saida);
							pilha.push(novaEntrada);
							if(difMinutos < 15) {
								intervaloOk = false;
								break;
							}

						}

						if(minutos >= 360) {
							PontoMarcacoes novaEntrada = pilha.pop();
							double difMinutos  =  getMinutosEntradaSaida(novaEntrada, saida);
							pilha.push(novaEntrada);
							if(difMinutos < 60) {
								intervaloOk = false;
								break;
							}

						}

					}catch (EmptyStackException e) {
						intervaloOk = false;
						break;
					}
				}
			}

			if(!intervaloOk) {
				pontoDia.setStatus(StatusPonto.INTERVALO_NAO_RESPEITADO);
			}
		}
		return pontoDia;
	}
	
	public List<PontoDia> findByPisCompetencia(long pis, String competencia){
		return pontoDiaPersistence.findByFindByCompetencia(pis, competencia);
	}



	private double getMinutosEntradaSaidaDiferenciado(PontoMarcacoes saida, PontoMarcacoes entrada) {

		double  minutos = 0;
		Date dtEntrada = new Date(entrada.getDataHora());
		Date dtSaida = new Date(saida.getDataHora());

		if(DateUtils.isAfterTenPM(dtEntrada) || (DateUtils.isBeforeSixAM(dtSaida))) {
			minutos = getMinutosEntradaSaida(saida, entrada);
			minutos *= 1.2;
		}else {
			if(!DateUtils.isAfterTenPM(dtEntrada)) {
				Date dtTenPM = DateUtils.getCalendarTenPM(dtEntrada).getTime();
				minutos = ((dtSaida.getTime() - (dtTenPM.getTime() )/VAL_DIV_MIN)*1.2);
				minutos += ((dtTenPM.getTime() - dtEntrada.getTime())/VAL_DIV_MIN);
			}

			if(!DateUtils.isBeforeSixAM(dtSaida)) {
				Date dtSixAm = DateUtils.getCalendarTenPM(dtSaida).getTime();
				minutos += ((dtSixAm.getTime() - dtSaida.getTime())/VAL_DIV_MIN);
				minutos = ((dtSaida.getTime() - (dtSixAm.getTime() )/VAL_DIV_MIN)*1.2);
			}

		}

		return minutos;
	}

	private boolean checkHorarioDiferenciado(PontoMarcacoes entrada, PontoMarcacoes saida) {
		boolean  diferenciado = false;
		Date dtEntrada = new Date(entrada.getDataHora());
		Date dtSaida = new Date(saida.getDataHora());

		diferenciado = (DateUtils.isBetweenTenAndMidnight(dtEntrada) || DateUtils.isBetweenMidnightAndSix(dtEntrada));
		if(!diferenciado) {
			diferenciado = (DateUtils.isBetweenTenAndMidnight(dtSaida) || DateUtils.isBetweenMidnightAndSix(dtSaida));
		}

		return diferenciado;
	}

	private double getMinutosEntradaSaida(PontoMarcacoes ponto1, PontoMarcacoes ponto2) {
		double minutos  = (((ponto1.getDataHora() - ponto2.getDataHora())/VAL_DIV_MIN));
		if(minutos < 0) {
			minutos *= -1;
		}
		return minutos;
	}

	private double getFatorDia(PontoDia pontoDia) {
		double fator = 1;
		Date data = new Date(pontoDia.getData());
		if(DateUtils.isSaturday(data)) {
			fator = 1.5; 
		}else {
			if(DateUtils.isSunday(data)) {
				fator = 2;
			}
		}

		return fator;
	}
}