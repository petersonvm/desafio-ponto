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

package com.desafio.ponto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Peterson Morais
 * @generated
 */
@ProviderType
public class PontoMarcacoesPK implements Comparable<PontoMarcacoesPK>,
	Serializable {
	public long Pis;
	public long DataHora;

	public PontoMarcacoesPK() {
	}

	public PontoMarcacoesPK(long Pis, long DataHora) {
		this.Pis = Pis;
		this.DataHora = DataHora;
	}

	public long getPis() {
		return Pis;
	}

	public void setPis(long Pis) {
		this.Pis = Pis;
	}

	public long getDataHora() {
		return DataHora;
	}

	public void setDataHora(long DataHora) {
		this.DataHora = DataHora;
	}

	@Override
	public int compareTo(PontoMarcacoesPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (Pis < pk.Pis) {
			value = -1;
		}
		else if (Pis > pk.Pis) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (DataHora < pk.DataHora) {
			value = -1;
		}
		else if (DataHora > pk.DataHora) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoMarcacoesPK)) {
			return false;
		}

		PontoMarcacoesPK pk = (PontoMarcacoesPK)obj;

		if ((Pis == pk.Pis) && (DataHora == pk.DataHora)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, Pis);
		hashCode = HashUtil.hash(hashCode, DataHora);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("Pis=");

		sb.append(Pis);
		sb.append(", DataHora=");

		sb.append(DataHora);

		sb.append("}");

		return sb.toString();
	}
}