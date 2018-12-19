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

import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.model.impl.PontoDiaImpl;
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.base.PontoDiaLocalServiceBaseImpl;

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
	
	public PontoDia registarPonto(long pis, Date dataPonto) {
		PontoDia pontoDia = new PontoDiaImpl();
		pontoDia.setPis(pis);
		pontoDia.setData(dataPonto.getTime());
		pontoDia.setHoras_Extras(this.calcularHorasExtras(pis, dataPonto));
		pontoDia.setHoras_Trabalhadas(this.calcularHorasTrabalhadas(pis, dataPonto));
		pontoDia.setHoras_Negativas(this.calcularHorasNegativas(pis, dataPonto));
		
		PontoDiaLocalServiceUtil.updatePontoDia(pontoDia);
		
		return pontoDia;
		
	}

	private int calcularHorasNegativas(long pis, Date dataPonto) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int calcularHorasTrabalhadas(long pis, Date dataPonto) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int calcularHorasExtras(long pis, Date dataPonto) {
		// TODO Auto-generated method stub
		return 0;
	}
}