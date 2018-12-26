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
import com.desafio.ponto.exception.PisDuplicadoException;
import com.desafio.ponto.exception.PisNaoVinculadoException;
import com.desafio.ponto.exception.PontoDiaExistenteException;
import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.model.custom.Marcacoes;
import com.desafio.ponto.model.custom.RegistroPonto;
import com.desafio.ponto.service.PontoDiaLocalServiceUtil;
import com.desafio.ponto.service.PontoMarcacoesLocalServiceUtil;
import com.desafio.ponto.service.base.RegistroPontoLocalServiceBaseImpl;
import com.desafio.ponto.service.util.DateUtils;
import com.desafio.ponto.service.util.StatusPonto;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


	public String registraPonto(long companyId, long pis , String data) {	
	

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataHora;
		try {
			
			this.getUserByPis(companyId, pis);
			dataHora = dataFormatada.parse(data);
			PontoDia pontoDia = getOrCreatePontoDia(pis, dataHora);	 

			registrarMarcacao(pis, dataHora);
			pontoDia.setHoras_Trabalhadas(0);
			atualizarPontoDia(pontoDia);

		} catch (ParseException e1) {
			return "ParseException";
		} catch (MarcacaoExistenteException e) {
			return "MarcacaoExistenteException";
		} catch (PisNaoVinculadoException e) {
			return "PisNaoVinculadoException";
		} catch (PisDuplicadoException e) {
			return "PisDuplicadoException";
		} catch (PortalException e) {
			e.printStackTrace();
			return "PortalException";
		}


		return "sucessful";
	}
	
	public RegistroPonto consultarPonto(long companyId, long pis, String competencia) {
		RegistroPonto ponto  = new RegistroPonto();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		double totalHorasTrabalhadas = 0;
		try {
			User user = this.getUserByPis(companyId, pis);
			ponto.setPis(pis);
			ponto.setNome(user.getFullName()); 
			ponto.setCompetencia(competencia);
		    sdf.parse(competencia);
			List<Marcacoes> marcacoes = new ArrayList<>();
			List<PontoDia> pontoDiaList = PontoDiaLocalServiceUtil.findByPisCompetencia(pis, competencia);
			for (PontoDia pontoDia : pontoDiaList) {
				Marcacoes marcacao = new Marcacoes();
				marcacao.setHorasTrabalhadas(pontoDia.getHoras_Trabalhadas());
				totalHorasTrabalhadas += pontoDia.getHoras_Trabalhadas();
				marcacao.setData(DateUtils.readableDate(new Date(pontoDia.getData())));
				marcacao.setStatus(StatusPonto.getStatus(pontoDia.getStatus()));
				List<PontoMarcacoes> pontoMarcacoesDia = PontoMarcacoesLocalServiceUtil.findByPisDia(pis, pontoDia.getData());
				List<String> batidas = new ArrayList<>();
				for (PontoMarcacoes pontoMarcacoes : pontoMarcacoesDia) {
					batidas.add(DateUtils.readableHour(new Date(pontoMarcacoes.getDataHora())));
				}
				marcacao.setBatidas(batidas);
				marcacoes.add(marcacao);
			}
			ponto.setTotalHorasTrabalhadas(totalHorasTrabalhadas);
			ponto.setMarcacoes(marcacoes);
		} catch (PortalException | PisNaoVinculadoException | PisDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return ponto;
	}
	
	
	public String importarPontos(long companyId, long pis , String batidas) {
		
		try {
			JSONArray batidasArray =JSONFactoryUtil.createJSONObject(batidas).getJSONArray("batidas");
			for (Object batida : batidasArray) {
				String retorno = this.registraPonto(companyId,pis,(String)batida);
				if(!retorno.equals("sucessful")) {
					return retorno;
				}
			}
			
		} catch (PortalException e) {
			return "PortalException : "+e.getMessage();
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
	
	private User getUserByPis (long companyId, long pis) throws PisNaoVinculadoException, PisDuplicadoException, PortalException {
		User user = null;
		

            ExpandoColumn column = ExpandoColumnLocalServiceUtil.getDefaultTableColumn(companyId, User.class.getName(), "Pis");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, PortalClassLoaderUtil.getClassLoader())
                    .add(PropertyFactoryUtil.forName("columnId").eq(GetterUtil.getLong(column.getColumnId())))
                    .add(PropertyFactoryUtil.forName("data").eq(pis+"")).add(PropertyFactoryUtil.forName("classNameId")
                    .eq(GetterUtil.getLong(ClassNameLocalServiceUtil.getClassNameId(User.class.getName()))));
            
            List<Object> expandoValueList = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);
            
            if (expandoValueList.size() > 1) {
            	throw new PisDuplicadoException();
            } else if (expandoValueList== null || expandoValueList.isEmpty()) {
            	throw new PisNaoVinculadoException();
            } else {
            	ExpandoValue expandoValue = (ExpandoValue) expandoValueList.get(0);            	
            	if (expandoValue.getClassPK() > 0L) {
                    user = UserLocalServiceUtil.getUser(expandoValue.getClassPK());
                }
            }     

        
        return user;
	}




}