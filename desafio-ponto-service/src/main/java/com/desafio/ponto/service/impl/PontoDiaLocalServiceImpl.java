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
import com.desafio.ponto.model.impl.PontoDiaImpl;
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.base.PontoDiaLocalServiceBaseImpl;
import com.desafio.ponto.service.persistence.PontoDiaPK;
import com.desafio.ponto.service.util.DateUtils;
import com.liferay.portal.kernel.exception.PortalException;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public PontoDia gravarPonto(long pis, Date dataHora) throws PontoDiaExistenteException {
		long data = DateUtils.atStartOfDay(dataHora).getTime();
		PontoDiaPK pontoDiaPK = new PontoDiaPK(pis, data);
		
		try {
			PontoDiaLocalServiceUtil.getPontoDia(pontoDiaPK);
			throw new PontoDiaExistenteException();
		} catch (PortalException e) {
			PontoDia pontoDia = new PontoDiaImpl();
			pontoDia.setPis(pis);
			pontoDia.setData(data);
			pontoDia.setHoras_Trabalhadas(0);
			SimpleDateFormat fmt = new SimpleDateFormat("MM/yyyy");			
			String competencia = fmt.format(dataHora);			
			pontoDia.setCompetencia(competencia );
			
			
			PontoDiaLocalServiceUtil.addPontoDia(pontoDia);
			return pontoDia;
		}
		
		
		
	}
}