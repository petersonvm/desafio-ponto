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
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.PontoEletronicoServiceBaseImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The implementation of the ponto eletronico remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.desafio.ponto.service.PontoEletronicoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoEletronicoServiceBaseImpl
 * @see com.desafio.ponto.service.PontoEletronicoServiceUtil
 */
public class PontoEletronicoServiceImpl extends PontoEletronicoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.desafio.ponto.service.PontoEletronicoServiceUtil} to access the ponto eletronico remote service.
	 */
	
	public String gravarMarcacao() {
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");    

			Date data;
			try {
				data = fmt.parse("20/12/2018 09:00");
				//PontoMarcacoesLocalServiceUtil.gravarMarcacao(1234567890, data);
				PontoDiaLocalServiceUtil.gravarPonto(1234567890, data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return "ParseException";
//			} catch (MarcacaoExistenteException e) {
//				// TODO Auto-generated catch block
//				return "MarcacaoExistenteException";
			} catch (PontoDiaExistenteException e) {
				// TODO Auto-generated catch block
				return "PontoDiaExistenteException";
			}
			
		return "Ok";
		
	}
	
}