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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PontoMarcacoes}.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoMarcacoes
 * @generated
 */
@ProviderType
public class PontoMarcacoesWrapper implements PontoMarcacoes,
	ModelWrapper<PontoMarcacoes> {
	public PontoMarcacoesWrapper(PontoMarcacoes pontoMarcacoes) {
		_pontoMarcacoes = pontoMarcacoes;
	}

	@Override
	public Class<?> getModelClass() {
		return PontoMarcacoes.class;
	}

	@Override
	public String getModelClassName() {
		return PontoMarcacoes.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Pis", getPis());
		attributes.put("Data", getData());
		attributes.put("DataHora", getDataHora());
		attributes.put("DataReferencia", getDataReferencia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Pis = (Long)attributes.get("Pis");

		if (Pis != null) {
			setPis(Pis);
		}

		Long Data = (Long)attributes.get("Data");

		if (Data != null) {
			setData(Data);
		}

		Long DataHora = (Long)attributes.get("DataHora");

		if (DataHora != null) {
			setDataHora(DataHora);
		}

		Long DataReferencia = (Long)attributes.get("DataReferencia");

		if (DataReferencia != null) {
			setDataReferencia(DataReferencia);
		}
	}

	@Override
	public Object clone() {
		return new PontoMarcacoesWrapper((PontoMarcacoes)_pontoMarcacoes.clone());
	}

	@Override
	public int compareTo(PontoMarcacoes pontoMarcacoes) {
		return _pontoMarcacoes.compareTo(pontoMarcacoes);
	}

	/**
	* Returns the data of this ponto marcacoes.
	*
	* @return the data of this ponto marcacoes
	*/
	@Override
	public long getData() {
		return _pontoMarcacoes.getData();
	}

	/**
	* Returns the data hora of this ponto marcacoes.
	*
	* @return the data hora of this ponto marcacoes
	*/
	@Override
	public long getDataHora() {
		return _pontoMarcacoes.getDataHora();
	}

	/**
	* Returns the data referencia of this ponto marcacoes.
	*
	* @return the data referencia of this ponto marcacoes
	*/
	@Override
	public long getDataReferencia() {
		return _pontoMarcacoes.getDataReferencia();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pontoMarcacoes.getExpandoBridge();
	}

	/**
	* Returns the pis of this ponto marcacoes.
	*
	* @return the pis of this ponto marcacoes
	*/
	@Override
	public long getPis() {
		return _pontoMarcacoes.getPis();
	}

	/**
	* Returns the primary key of this ponto marcacoes.
	*
	* @return the primary key of this ponto marcacoes
	*/
	@Override
	public com.desafio.ponto.service.persistence.PontoMarcacoesPK getPrimaryKey() {
		return _pontoMarcacoes.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pontoMarcacoes.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _pontoMarcacoes.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pontoMarcacoes.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pontoMarcacoes.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pontoMarcacoes.isNew();
	}

	@Override
	public void persist() {
		_pontoMarcacoes.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pontoMarcacoes.setCachedModel(cachedModel);
	}

	/**
	* Sets the data of this ponto marcacoes.
	*
	* @param Data the data of this ponto marcacoes
	*/
	@Override
	public void setData(long Data) {
		_pontoMarcacoes.setData(Data);
	}

	/**
	* Sets the data hora of this ponto marcacoes.
	*
	* @param DataHora the data hora of this ponto marcacoes
	*/
	@Override
	public void setDataHora(long DataHora) {
		_pontoMarcacoes.setDataHora(DataHora);
	}

	/**
	* Sets the data referencia of this ponto marcacoes.
	*
	* @param DataReferencia the data referencia of this ponto marcacoes
	*/
	@Override
	public void setDataReferencia(long DataReferencia) {
		_pontoMarcacoes.setDataReferencia(DataReferencia);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pontoMarcacoes.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pontoMarcacoes.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pontoMarcacoes.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_pontoMarcacoes.setNew(n);
	}

	/**
	* Sets the pis of this ponto marcacoes.
	*
	* @param Pis the pis of this ponto marcacoes
	*/
	@Override
	public void setPis(long Pis) {
		_pontoMarcacoes.setPis(Pis);
	}

	/**
	* Sets the primary key of this ponto marcacoes.
	*
	* @param primaryKey the primary key of this ponto marcacoes
	*/
	@Override
	public void setPrimaryKey(
		com.desafio.ponto.service.persistence.PontoMarcacoesPK primaryKey) {
		_pontoMarcacoes.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pontoMarcacoes.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PontoMarcacoes> toCacheModel() {
		return _pontoMarcacoes.toCacheModel();
	}

	@Override
	public PontoMarcacoes toEscapedModel() {
		return new PontoMarcacoesWrapper(_pontoMarcacoes.toEscapedModel());
	}

	@Override
	public String toString() {
		return _pontoMarcacoes.toString();
	}

	@Override
	public PontoMarcacoes toUnescapedModel() {
		return new PontoMarcacoesWrapper(_pontoMarcacoes.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _pontoMarcacoes.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoMarcacoesWrapper)) {
			return false;
		}

		PontoMarcacoesWrapper pontoMarcacoesWrapper = (PontoMarcacoesWrapper)obj;

		if (Objects.equals(_pontoMarcacoes,
					pontoMarcacoesWrapper._pontoMarcacoes)) {
			return true;
		}

		return false;
	}

	@Override
	public PontoMarcacoes getWrappedModel() {
		return _pontoMarcacoes;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pontoMarcacoes.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pontoMarcacoes.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pontoMarcacoes.resetOriginalValues();
	}

	private final PontoMarcacoes _pontoMarcacoes;
}