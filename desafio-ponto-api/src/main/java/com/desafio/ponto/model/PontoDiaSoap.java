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
 * This class is used by SOAP remote services.
 *
 * @author Peterson Morais
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
		soapModel.setStatus(model.getStatus());

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

	public double getHoras_Trabalhadas() {
		return _Horas_Trabalhadas;
	}

	public void setHoras_Trabalhadas(double Horas_Trabalhadas) {
		_Horas_Trabalhadas = Horas_Trabalhadas;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	private long _Pis;
	private long _Data;
	private String _Competencia;
	private double _Horas_Trabalhadas;
	private int _Status;
}