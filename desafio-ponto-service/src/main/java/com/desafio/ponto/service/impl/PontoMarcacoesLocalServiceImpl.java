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
import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.model.impl.PontoMarcacoesImpl;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.PontoMarcacoesLocalServiceBaseImpl;
import com.desafio.ponto.service.persistence.PontoMarcacoesPK;
import com.desafio.ponto.service.util.DateUtils;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

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

	public PontoMarcacoes gravarMarcacao(long pis, Date dataHora) throws MarcacaoExistenteException {

		try {
			this.getPontoMarcacoes(pis, dataHora);
			throw new MarcacaoExistenteException();
		} catch (PortalException e) {
			PontoMarcacoes marcacao = new PontoMarcacoesImpl();
			marcacao.setPis(pis);
			marcacao.setData(DateUtils.atStartOfDay(dataHora).getTime());
			marcacao.setDataReferencia(DateUtils.atStartOfDay(dataHora).getTime());
			marcacao.setDataHora(dataHora.getTime());
			PontoMarcacoesLocalServiceUtil.addPontoMarcacoes(marcacao);
			return marcacao;
		}

	}
	
	public PontoMarcacoes getPontoMarcacoes(long pis, Date dataHora) throws PortalException {
		long data = DateUtils.atStartOfDay(dataHora).getTime();
		PontoMarcacoesPK pontoMarcacoesPK = new PontoMarcacoesPK(pis, data, dataHora.getTime());		
		return PontoMarcacoesLocalServiceUtil.getPontoMarcacoes(pontoMarcacoesPK);
	}
	
	
	public List<PontoMarcacoes> findByPisDia(long pis, Date dataHora){
		return pontoMarcacoesPersistence.findByFindByPisData(pis, dataHora.getTime(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<PontoMarcacoes> findByPisDia(long pis, long dataHora){
		return pontoMarcacoesPersistence.findByFindByPisData(pis, dataHora, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	}
}
	