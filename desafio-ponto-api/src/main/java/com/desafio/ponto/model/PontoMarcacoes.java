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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PontoMarcacoes service. Represents a row in the &quot;ponto_marcacao&quot; database table, with each column mapped to a property of this class.
 *
 * @author Peterson Morais
 * @see PontoMarcacoesModel
 * @see com.desafio.ponto.model.impl.PontoMarcacoesImpl
 * @see com.desafio.ponto.model.impl.PontoMarcacoesModelImpl
 * @generated
 */
@ImplementationClassName("com.desafio.ponto.model.impl.PontoMarcacoesImpl")
@ProviderType
public interface PontoMarcacoes extends PontoMarcacoesModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.desafio.ponto.model.impl.PontoMarcacoesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PontoMarcacoes, Long> PIS_ACCESSOR = new Accessor<PontoMarcacoes, Long>() {
			@Override
			public Long get(PontoMarcacoes pontoMarcacoes) {
				return pontoMarcacoes.getPis();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PontoMarcacoes> getTypeClass() {
				return PontoMarcacoes.class;
			}
		};

	public static final Accessor<PontoMarcacoes, Long> DATA_HORA_ACCESSOR = new Accessor<PontoMarcacoes, Long>() {
			@Override
			public Long get(PontoMarcacoes pontoMarcacoes) {
				return pontoMarcacoes.getDataHora();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PontoMarcacoes> getTypeClass() {
				return PontoMarcacoes.class;
			}
		};
}