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

import com.desafio.ponto.model.custom.RegistroPonto;
import com.desafio.ponto.service.RegistroPontoLocalServiceUtil;
import com.desafio.ponto.service.base.RegistroPontoServiceBaseImpl;

/**
 * The implementation of the registro ponto remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.desafio.ponto.service.RegistroPontoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peterson Morais
 * @see RegistroPontoServiceBaseImpl
 * @see com.desafio.ponto.service.RegistroPontoServiceUtil
 */
public class RegistroPontoServiceImpl extends RegistroPontoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.desafio.ponto.service.RegistroPontoServiceUtil} to access the registro ponto remote service.
	 */
	
	public String registraPonto(long companyId,long pis , String data) {
		return RegistroPontoLocalServiceUtil.registraPonto(companyId,pis, data);
	}
	
	
	public RegistroPonto consultarPontoCompetencia(long companyId, long pis, String competencia) {
		return RegistroPontoLocalServiceUtil.consultarPontoCompetencia(companyId, pis, competencia);
	}
	
	public RegistroPonto consultarPonto(long companyId, long pis, String dia) {
		return RegistroPontoLocalServiceUtil.consultarPonto(companyId, pis, dia);
	}
	
	
	public String importarPontos(long companyId, long pis , String batidas) {
		return RegistroPontoLocalServiceUtil.importarPontos(companyId, pis, batidas);
	}

}