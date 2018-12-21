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
import com.desafio.ponto.model.PontoDiaModel;
import com.desafio.ponto.service.persistence.PontoDiaPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PontoDia service. Represents a row in the &quot;ponto_dia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PontoDiaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PontoDiaImpl}.
 * </p>
 *
 * @author Peterson Morais
 * @see PontoDiaImpl
 * @see PontoDia
 * @see PontoDiaModel
 * @generated
 */
@ProviderType
public class PontoDiaModelImpl extends BaseModelImpl<PontoDia>
	implements PontoDiaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ponto dia model instance should use the {@link PontoDia} interface instead.
	 */
	public static final String TABLE_NAME = "ponto_dia";
	public static final Object[][] TABLE_COLUMNS = {
			{ "Pis", Types.BIGINT },
			{ "Data", Types.BIGINT },
			{ "Competencia", Types.VARCHAR },
			{ "Horas_Trabalhadas", Types.DOUBLE },
			{ "Status", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("Pis", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Data", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Competencia", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Horas_Trabalhadas", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("Status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table ponto_dia (Pis LONG not null,Data LONG not null,Competencia VARCHAR(75) null,Horas_Trabalhadas DOUBLE,Status INTEGER,primary key (Pis, Data))";
	public static final String TABLE_SQL_DROP = "drop table ponto_dia";
	public static final String ORDER_BY_JPQL = " ORDER BY pontoDia.id.Pis ASC, pontoDia.id.Data ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ponto_dia.Pis ASC, ponto_dia.Data ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.desafio.ponto.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.desafio.ponto.model.PontoDia"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.desafio.ponto.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.desafio.ponto.model.PontoDia"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.desafio.ponto.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.desafio.ponto.model.PontoDia"),
			true);
	public static final long COMPETENCIA_COLUMN_BITMASK = 1L;
	public static final long PIS_COLUMN_BITMASK = 2L;
	public static final long DATA_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.desafio.ponto.service.util.ServiceProps.get(
				"lock.expiration.time.com.desafio.ponto.model.PontoDia"));

	public PontoDiaModelImpl() {
	}

	@Override
	public PontoDiaPK getPrimaryKey() {
		return new PontoDiaPK(_Pis, _Data);
	}

	@Override
	public void setPrimaryKey(PontoDiaPK primaryKey) {
		setPis(primaryKey.Pis);
		setData(primaryKey.Data);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new PontoDiaPK(_Pis, _Data);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((PontoDiaPK)primaryKeyObj);
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
		attributes.put("Status", getStatus());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		Double Horas_Trabalhadas = (Double)attributes.get("Horas_Trabalhadas");

		if (Horas_Trabalhadas != null) {
			setHoras_Trabalhadas(Horas_Trabalhadas);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}
	}

	@Override
	public long getPis() {
		return _Pis;
	}

	@Override
	public void setPis(long Pis) {
		_Pis = Pis;
	}

	@Override
	public long getData() {
		return _Data;
	}

	@Override
	public void setData(long Data) {
		_Data = Data;
	}

	@Override
	public String getCompetencia() {
		if (_Competencia == null) {
			return "";
		}
		else {
			return _Competencia;
		}
	}

	@Override
	public void setCompetencia(String Competencia) {
		_columnBitmask |= COMPETENCIA_COLUMN_BITMASK;

		if (_originalCompetencia == null) {
			_originalCompetencia = _Competencia;
		}

		_Competencia = Competencia;
	}

	public String getOriginalCompetencia() {
		return GetterUtil.getString(_originalCompetencia);
	}

	@Override
	public double getHoras_Trabalhadas() {
		return _Horas_Trabalhadas;
	}

	@Override
	public void setHoras_Trabalhadas(double Horas_Trabalhadas) {
		_Horas_Trabalhadas = Horas_Trabalhadas;
	}

	@Override
	public int getStatus() {
		return _Status;
	}

	@Override
	public void setStatus(int Status) {
		_Status = Status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public PontoDia toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PontoDia)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PontoDiaImpl pontoDiaImpl = new PontoDiaImpl();

		pontoDiaImpl.setPis(getPis());
		pontoDiaImpl.setData(getData());
		pontoDiaImpl.setCompetencia(getCompetencia());
		pontoDiaImpl.setHoras_Trabalhadas(getHoras_Trabalhadas());
		pontoDiaImpl.setStatus(getStatus());

		pontoDiaImpl.resetOriginalValues();

		return pontoDiaImpl;
	}

	@Override
	public int compareTo(PontoDia pontoDia) {
		PontoDiaPK primaryKey = pontoDia.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PontoDia)) {
			return false;
		}

		PontoDia pontoDia = (PontoDia)obj;

		PontoDiaPK primaryKey = pontoDia.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PontoDiaModelImpl pontoDiaModelImpl = this;

		pontoDiaModelImpl._originalCompetencia = pontoDiaModelImpl._Competencia;

		pontoDiaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PontoDia> toCacheModel() {
		PontoDiaCacheModel pontoDiaCacheModel = new PontoDiaCacheModel();

		pontoDiaCacheModel.pontoDiaPK = getPrimaryKey();

		pontoDiaCacheModel.Pis = getPis();

		pontoDiaCacheModel.Data = getData();

		pontoDiaCacheModel.Competencia = getCompetencia();

		String Competencia = pontoDiaCacheModel.Competencia;

		if ((Competencia != null) && (Competencia.length() == 0)) {
			pontoDiaCacheModel.Competencia = null;
		}

		pontoDiaCacheModel.Horas_Trabalhadas = getHoras_Trabalhadas();

		pontoDiaCacheModel.Status = getStatus();

		return pontoDiaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{Pis=");
		sb.append(getPis());
		sb.append(", Data=");
		sb.append(getData());
		sb.append(", Competencia=");
		sb.append(getCompetencia());
		sb.append(", Horas_Trabalhadas=");
		sb.append(getHoras_Trabalhadas());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.desafio.ponto.model.PontoDia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Pis</column-name><column-value><![CDATA[");
		sb.append(getPis());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Competencia</column-name><column-value><![CDATA[");
		sb.append(getCompetencia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Horas_Trabalhadas</column-name><column-value><![CDATA[");
		sb.append(getHoras_Trabalhadas());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PontoDia.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PontoDia.class, ModelWrapper.class
		};
	private long _Pis;
	private long _Data;
	private String _Competencia;
	private String _originalCompetencia;
	private double _Horas_Trabalhadas;
	private int _Status;
	private long _columnBitmask;
	private PontoDia _escapedModel;
}