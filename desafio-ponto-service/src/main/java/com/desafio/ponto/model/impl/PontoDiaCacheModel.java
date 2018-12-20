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

package com.desafio.ponto.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.service.persistence.PontoDiaPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PontoDia in entity cache.
 *
 * @author Peterson Morais
 * @see PontoDia
 * @generated
 */
@ProviderType
public class PontoDiaCacheModel implements CacheModel<PontoDia>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoDiaCacheModel)) {
			return false;
		}

		PontoDiaCacheModel pontoDiaCacheModel = (PontoDiaCacheModel)obj;

		if (pontoDiaPK.equals(pontoDiaCacheModel.pontoDiaPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pontoDiaPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{Pis=");
		sb.append(Pis);
		sb.append(", Data=");
		sb.append(Data);
		sb.append(", Competencia=");
		sb.append(Competencia);
		sb.append(", Horas_Trabalhadas=");
		sb.append(Horas_Trabalhadas);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PontoDia toEntityModel() {
		PontoDiaImpl pontoDiaImpl = new PontoDiaImpl();

		pontoDiaImpl.setPis(Pis);
		pontoDiaImpl.setData(Data);

		if (Competencia == null) {
			pontoDiaImpl.setCompetencia("");
		}
		else {
			pontoDiaImpl.setCompetencia(Competencia);
		}

		pontoDiaImpl.setHoras_Trabalhadas(Horas_Trabalhadas);

		pontoDiaImpl.resetOriginalValues();

		return pontoDiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Pis = objectInput.readLong();

		Data = objectInput.readLong();
		Competencia = objectInput.readUTF();

		Horas_Trabalhadas = objectInput.readInt();

		pontoDiaPK = new PontoDiaPK(Pis, Data);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(Pis);

		objectOutput.writeLong(Data);

		if (Competencia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Competencia);
		}

		objectOutput.writeInt(Horas_Trabalhadas);
	}

	public long Pis;
	public long Data;
	public String Competencia;
	public int Horas_Trabalhadas;
	public transient PontoDiaPK pontoDiaPK;
}