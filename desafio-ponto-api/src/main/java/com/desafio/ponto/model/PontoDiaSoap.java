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

import com.desafio.ponto.service.persistence.PontoDiaPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.desafio.ponto.service.http.PontoDiaServiceSoap}.
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.http.PontoDiaServiceSoap
 * @generated
 */
@ProviderType
public class PontoDiaSoap implements Serializable {
	public static PontoDiaSoap toSoapModel(PontoDia model) {
		PontoDiaSoap soapModel = new PontoDiaSoap();

		soapModel.setPis(model.getPis());
		soapModel.setData(model.getData());
		soapModel.setCompetencia(model.getCompetencia());
		soapModel.setHoras_Trabalhadas(model.getHoras_Trabalhadas());
		soapModel.setHoras_Extras(model.getHoras_Extras());
		soapModel.setHoras_Negativas(model.getHoras_Negativas());

		return soapModel;
	}

	public static PontoDiaSoap[] toSoapModels(PontoDia[] models) {
		PontoDiaSoap[] soapModels = new PontoDiaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PontoDiaSoap[][] toSoapModels(PontoDia[][] models) {
		PontoDiaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PontoDiaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PontoDiaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PontoDiaSoap[] toSoapModels(List<PontoDia> models) {
		List<PontoDiaSoap> soapModels = new ArrayList<PontoDiaSoap>(models.size());

		for (PontoDia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PontoDiaSoap[soapModels.size()]);
	}

	public PontoDiaSoap() {
	}

	public PontoDiaPK getPrimaryKey() {
		return new PontoDiaPK(_Pis, _Data);
	}

	public void setPrimaryKey(PontoDiaPK pk) {
		setPis(pk.Pis);
		setData(pk.Data);
	}

	public long getPis() {
		return _Pis;
	}

	public void setPis(long Pis) {
		_Pis = Pis;
	}

	public long getData() {
		return _Data;
	}

	public void setData(long Data) {
		_Data = Data;
	}

	public String getCompetencia() {
		return _Competencia;
	}

	public void setCompetencia(String Competencia) {
		_Competencia = Competencia;
	}

	public int getHoras_Trabalhadas() {
		return _Horas_Trabalhadas;
	}

	public void setHoras_Trabalhadas(int Horas_Trabalhadas) {
		_Horas_Trabalhadas = Horas_Trabalhadas;
	}

	public int getHoras_Extras() {
		return _Horas_Extras;
	}

	public void setHoras_Extras(int Horas_Extras) {
		_Horas_Extras = Horas_Extras;
	}

	public int getHoras_Negativas() {
		return _Horas_Negativas;
	}

	public void setHoras_Negativas(int Horas_Negativas) {
		_Horas_Negativas = Horas_Negativas;
	}

	private long _Pis;
	private long _Data;
	private String _Competencia;
	private int _Horas_Trabalhadas;
	private int _Horas_Extras;
	private int _Horas_Negativas;
}