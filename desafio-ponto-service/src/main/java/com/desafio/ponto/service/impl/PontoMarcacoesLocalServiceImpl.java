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

import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.model.impl.PontoMarcacoesImpl;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.PontoMarcacoesLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the ponto marcacoes local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.desafio.ponto.service.PontoMarcacoesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoMarcacoesLocalServiceBaseImpl
 * @see com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil
 */
public class PontoMarcacoesLocalServiceImpl
	extends PontoMarcacoesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil} to access the ponto marcacoes local service.
	 */
	
	
	public PontoMarcacoes registrarMarcacao(long pis, Date dataMarcacao) {
		PontoMarcacoes pMarcacao = new PontoMarcacoesImpl();
		
		pMarcacao.setPis(pis);
		pMarcacao.setDataHora(dataMarcacao.getTime());
		pMarcacao.setMarcacao_valida(true);
		
		PontoMarcacoesLocalServiceUtil.addPontoMarcacoes(pMarcacao);
		
		return pMarcacao;
		
	}
}