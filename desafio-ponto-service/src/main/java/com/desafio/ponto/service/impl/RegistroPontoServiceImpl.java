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
	
	/**
	 *  Persiste no SGBD as informação referentes a um Registro de Ponto. 
	 *
	 * @param  companyId 	long companyId 
	 * @param  pis  		long PIS do funcionario
	 * @param  data 		String que representa a data e hora do registro do ponto deve ser enviada no formato "dd/MM/yyyy HH:mm".
	 * @see com.desafio.ponto.service.RegistroPontoLocalServiceUtil
	 * @return      		A String "sucessful" para sucesso ou o nome da exeção que foi levantada	
	 */
	public String registraPonto(long companyId,long pis , String data) {
		return RegistroPontoLocalServiceUtil.registraPonto(companyId,pis, data);
	}
	
	/**
	 *  Retorna um objeto que representa a classe RegistroPonto com dados referentes a uma competencia (mês). 
	 *
	 * @param  companyId 	long companyId 
	 * @param  pis  		long PIS do funcionario
	 * @param  dia 			String que representa a competencia do registro do ponto deve ser enviada no formato "MM/yyyy".
	 * @see com.desafio.ponto.service.RegistroPontoLocalServiceUtil
	 * @return      		Um objeto da entidade RegistroPonto	
	 */
	public RegistroPonto consultarPontoCompetencia(long companyId, long pis, String competencia) {
		return RegistroPontoLocalServiceUtil.consultarPontoCompetencia(companyId, pis, competencia);
	}
	/**
	 *  Retorna um objeto que representa a classe RegistroPonto com dados referente apenas 1 dia. 
	 *
	 * @param  companyId 	long companyId 
	 * @param  pis  		long PIS do funcionario
	 * @param  dia 			String que representa a data e hora do registro do ponto deve ser enviada no formato "dd/MM/yyyy HH:mm".
	 * @see com.desafio.ponto.service.RegistroPontoLocalServiceUtil
	 * @return      		Um objeto da entidade RegistroPonto	
	 */
	public RegistroPonto consultarPonto(long companyId, long pis, String dia) {
		return RegistroPontoLocalServiceUtil.consultarPonto(companyId, pis, dia);
	}
	
	/**
	 *  Responsável pela imporção em lote das batidas de um funcionario.
	 *
	 * @param  companyId 	long companyId 
	 * @param  pis  		long PIS do funcionario
	 * @param  batidas 		String que representa um JSON com as batidas de um funcionario.
	 * @see com.desafio.ponto.service.RegistroPontoLocalServiceUtil
	 * @return      		A String "sucessful" para sucesso ou o nome da exeção que foi levantada.		
	 */
	public String importarPontos(long companyId, long pis , String batidas) {
		return RegistroPontoLocalServiceUtil.importarPontos(companyId, pis, batidas);
	}

}