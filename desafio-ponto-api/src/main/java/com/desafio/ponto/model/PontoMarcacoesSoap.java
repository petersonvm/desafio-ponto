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

package com.desafio.ponto.model;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.service.persistence.PontoMarcacoesPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.desafio.ponto.service.http.PontoMarcacoesServiceSoap}.
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.http.PontoMarcacoesServiceSoap
 * @generated
 */
@ProviderType
public class PontoMarcacoesSoap implements Serializable {
	public static PontoMarcacoesSoap toSoapModel(PontoMarcacoes model) {
		PontoMarcacoesSoap soapModel = new PontoMarcacoesSoap();

		soapModel.setPis(model.getPis());
		soapModel.setDataHora(model.getDataHora());
		soapModel.setMarcacao_valida(model.isMarcacao_valida());

		return soapModel;
	}

	public static PontoMarcacoesSoap[] toSoapModels(PontoMarcacoes[] models) {
		PontoMarcacoesSoap[] soapModels = new PontoMarcacoesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PontoMarcacoesSoap[][] toSoapModels(PontoMarcacoes[][] models) {
		PontoMarcacoesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PontoMarcacoesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PontoMarcacoesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PontoMarcacoesSoap[] toSoapModels(List<PontoMarcacoes> models) {
		List<PontoMarcacoesSoap> soapModels = new ArrayList<PontoMarcacoesSoap>(models.size());

		for (PontoMarcacoes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PontoMarcacoesSoap[soapModels.size()]);
	}

	public PontoMarcacoesSoap() {
	}

	public PontoMarcacoesPK getPrimaryKey() {
		return new PontoMarcacoesPK(_Pis, _DataHora);
	}

	public void setPrimaryKey(PontoMarcacoesPK pk) {
		setPis(pk.Pis);
		setDataHora(pk.DataHora);
	}

	public long getPis() {
		return _Pis;
	}

	public void setPis(long Pis) {
		_Pis = Pis;
	}

	public long getDataHora() {
		return _DataHora;
	}

	public void setDataHora(long DataHora) {
		_DataHora = DataHora;
	}

	public boolean getMarcacao_valida() {
		return _Marcacao_valida;
	}

	public boolean isMarcacao_valida() {
		return _Marcacao_valida;
	}

	public void setMarcacao_valida(boolean Marcacao_valida) {
		_Marcacao_valida = Marcacao_valida;
	}

	private long _Pis;
	private long _DataHora;
	private boolean _Marcacao_valida;
}