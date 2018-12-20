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
 * This class is a wrapper for {@link PontoDia}.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoDia
 * @generated
 */
@ProviderType
public class PontoDiaWrapper implements PontoDia, ModelWrapper<PontoDia> {
	public PontoDiaWrapper(PontoDia pontoDia) {
		_pontoDia = pontoDia;
	}

	@Override
	public Class<?> getModelClass() {
		return PontoDia.class;
	}

	@Override
	public String getModelClassName() {
		return PontoDia.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Pis", getPis());
		attributes.put("Data", getData());
		attributes.put("Competencia", getCompetencia());
		attributes.put("Horas_Trabalhadas", getHoras_Trabalhadas());

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

		String Competencia = (String)attributes.get("Competencia");

		if (Competencia != null) {
			setCompetencia(Competencia);
		}

		Integer Horas_Trabalhadas = (Integer)attributes.get("Horas_Trabalhadas");

		if (Horas_Trabalhadas != null) {
			setHoras_Trabalhadas(Horas_Trabalhadas);
		}
	}

	@Override
	public Object clone() {
		return new PontoDiaWrapper((PontoDia)_pontoDia.clone());
	}

	@Override
	public int compareTo(PontoDia pontoDia) {
		return _pontoDia.compareTo(pontoDia);
	}

	/**
	* Returns the competencia of this ponto dia.
	*
	* @return the competencia of this ponto dia
	*/
	@Override
	public String getCompetencia() {
		return _pontoDia.getCompetencia();
	}

	/**
	* Returns the data of this ponto dia.
	*
	* @return the data of this ponto dia
	*/
	@Override
	public long getData() {
		return _pontoDia.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pontoDia.getExpandoBridge();
	}

	/**
	* Returns the horas_ trabalhadas of this ponto dia.
	*
	* @return the horas_ trabalhadas of this ponto dia
	*/
	@Override
	public int getHoras_Trabalhadas() {
		return _pontoDia.getHoras_Trabalhadas();
	}

	/**
	* Returns the pis of this ponto dia.
	*
	* @return the pis of this ponto dia
	*/
	@Override
	public long getPis() {
		return _pontoDia.getPis();
	}

	/**
	* Returns the primary key of this ponto dia.
	*
	* @return the primary key of this ponto dia
	*/
	@Override
	public com.desafio.ponto.service.persistence.PontoDiaPK getPrimaryKey() {
		return _pontoDia.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pontoDia.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _pontoDia.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pontoDia.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pontoDia.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pontoDia.isNew();
	}

	@Override
	public void persist() {
		_pontoDia.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pontoDia.setCachedModel(cachedModel);
	}

	/**
	* Sets the competencia of this ponto dia.
	*
	* @param Competencia the competencia of this ponto dia
	*/
	@Override
	public void setCompetencia(String Competencia) {
		_pontoDia.setCompetencia(Competencia);
	}

	/**
	* Sets the data of this ponto dia.
	*
	* @param Data the data of this ponto dia
	*/
	@Override
	public void setData(long Data) {
		_pontoDia.setData(Data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pontoDia.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pontoDia.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pontoDia.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the horas_ trabalhadas of this ponto dia.
	*
	* @param Horas_Trabalhadas the horas_ trabalhadas of this ponto dia
	*/
	@Override
	public void setHoras_Trabalhadas(int Horas_Trabalhadas) {
		_pontoDia.setHoras_Trabalhadas(Horas_Trabalhadas);
	}

	@Override
	public void setNew(boolean n) {
		_pontoDia.setNew(n);
	}

	/**
	* Sets the pis of this ponto dia.
	*
	* @param Pis the pis of this ponto dia
	*/
	@Override
	public void setPis(long Pis) {
		_pontoDia.setPis(Pis);
	}

	/**
	* Sets the primary key of this ponto dia.
	*
	* @param primaryKey the primary key of this ponto dia
	*/
	@Override
	public void setPrimaryKey(
		com.desafio.ponto.service.persistence.PontoDiaPK primaryKey) {
		_pontoDia.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pontoDia.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PontoDia> toCacheModel() {
		return _pontoDia.toCacheModel();
	}

	@Override
	public PontoDia toEscapedModel() {
		return new PontoDiaWrapper(_pontoDia.toEscapedModel());
	}

	@Override
	public String toString() {
		return _pontoDia.toString();
	}

	@Override
	public PontoDia toUnescapedModel() {
		return new PontoDiaWrapper(_pontoDia.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _pontoDia.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoDiaWrapper)) {
			return false;
		}

		PontoDiaWrapper pontoDiaWrapper = (PontoDiaWrapper)obj;

		if (Objects.equals(_pontoDia, pontoDiaWrapper._pontoDia)) {
			return true;
		}

		return false;
	}

	@Override
	public PontoDia getWrappedModel() {
		return _pontoDia;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pontoDia.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pontoDia.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pontoDia.resetOriginalValues();
	}

	private final PontoDia _pontoDia;
}