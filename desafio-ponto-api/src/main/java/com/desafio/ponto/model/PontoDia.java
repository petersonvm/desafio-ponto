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
 * The extended model interface for the PontoDia service. Represents a row in the &quot;ponto_dia&quot; database table, with each column mapped to a property of this class.
 *
 * @author Peterson Morais
 * @see PontoDiaModel
 * @see com.desafio.ponto.model.impl.PontoDiaImpl
 * @see com.desafio.ponto.model.impl.PontoDiaModelImpl
 * @generated
 */
@ImplementationClassName("com.desafio.ponto.model.impl.PontoDiaImpl")
@ProviderType
public interface PontoDia extends PontoDiaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.desafio.ponto.model.impl.PontoDiaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PontoDia, Long> PIS_ACCESSOR = new Accessor<PontoDia, Long>() {
			@Override
			public Long get(PontoDia pontoDia) {
				return pontoDia.getPis();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PontoDia> getTypeClass() {
				return PontoDia.class;
			}
		};

	public static final Accessor<PontoDia, Long> DATA_ACCESSOR = new Accessor<PontoDia, Long>() {
			@Override
			public Long get(PontoDia pontoDia) {
				return pontoDia.getData();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PontoDia> getTypeClass() {
				return PontoDia.class;
			}
		};
}