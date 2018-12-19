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

import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.service.persistence.PontoMarcacoesPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PontoMarcacoes in entity cache.
 *
 * @author Peterson Morais
 * @see PontoMarcacoes
 * @generated
 */
@ProviderType
public class PontoMarcacoesCacheModel implements CacheModel<PontoMarcacoes>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoMarcacoesCacheModel)) {
			return false;
		}

		PontoMarcacoesCacheModel pontoMarcacoesCacheModel = (PontoMarcacoesCacheModel)obj;

		if (pontoMarcacoesPK.equals(pontoMarcacoesCacheModel.pontoMarcacoesPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pontoMarcacoesPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{Pis=");
		sb.append(Pis);
		sb.append(", DataHora=");
		sb.append(DataHora);
		sb.append(", Marcacao_valida=");
		sb.append(Marcacao_valida);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PontoMarcacoes toEntityModel() {
		PontoMarcacoesImpl pontoMarcacoesImpl = new PontoMarcacoesImpl();

		pontoMarcacoesImpl.setPis(Pis);
		pontoMarcacoesImpl.setDataHora(DataHora);
		pontoMarcacoesImpl.setMarcacao_valida(Marcacao_valida);

		pontoMarcacoesImpl.resetOriginalValues();

		return pontoMarcacoesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Pis = objectInput.readLong();

		DataHora = objectInput.readLong();

		Marcacao_valida = objectInput.readBoolean();

		pontoMarcacoesPK = new PontoMarcacoesPK(Pis, DataHora);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(Pis);

		objectOutput.writeLong(DataHora);

		objectOutput.writeBoolean(Marcacao_valida);
	}

	public long Pis;
	public long DataHora;
	public boolean Marcacao_valida;
	public transient PontoMarcacoesPK pontoMarcacoesPK;
}