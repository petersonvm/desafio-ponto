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

import com.desafio.ponto.exception.MarcacaoExistenteException;
import com.desafio.ponto.exception.PontoDiaExistenteException;
import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.RegistroPontoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The implementation of the registro ponto local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.desafio.ponto.service.RegistroPontoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Peterson Morais
 * @see RegistroPontoLocalServiceBaseImpl
 * @see com.desafio.ponto.service.RegistroPontoLocalServiceUtil
 */
public class RegistroPontoLocalServiceImpl
extends RegistroPontoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.desafio.ponto.service.RegistroPontoLocalServiceUtil} to access the registro ponto local service.
	 */


	public String registraPonto(long pis , String data) {

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataHora;
		try {
			dataHora = dataFormatada.parse(data);

			PontoDia pontoDia = getOrCreatePontoDia(pis, dataHora);	 

//			registrarMarcacao(pis, dataHora);
			pontoDia.setHoras_Trabalhadas(0);
			atualizarPontoDia(pontoDia);

		} catch (ParseException e1) {
			return "ParseException";
//		} catch (MarcacaoExistenteException e) {
//			return "MarcacaoExistenteException";
		}


		return "sucessful";
	}

	private void atualizarPontoDia(PontoDia pontoDia) {

		PontoDiaLocalServiceUtil.calcularHorasTrabalhadas(pontoDia);
		PontoDiaLocalServiceUtil.calcularIntervalos(pontoDia);
		PontoDiaLocalServiceUtil.updatePontoDia(pontoDia);
	}



	private PontoDia getOrCreatePontoDia(long pis, Date dataHora) {
		PontoDia pontoDia = null;
		try {
			pontoDia = PontoDiaLocalServiceUtil.gravarPonto(pis, dataHora);
		} catch (PontoDiaExistenteException e) {
			try {
				pontoDia = PontoDiaLocalServiceUtil.getPontoDia(pis, dataHora);
			} catch (PortalException e1) {}
		}

		return pontoDia;
	}


	private PontoMarcacoes registrarMarcacao(long pis, Date dataHora) throws MarcacaoExistenteException {
		PontoMarcacoes marcacoes = PontoMarcacoesLocalServiceUtil.gravarMarcacao(pis, dataHora);
		return marcacoes;
	}




}