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

package com.desafio.ponto.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistroPontoLocalService}.
 *
 * @author Peterson Morais
 * @see RegistroPontoLocalService
 * @generated
 */
@ProviderType
public class RegistroPontoLocalServiceWrapper
	implements RegistroPontoLocalService,
		ServiceWrapper<RegistroPontoLocalService> {
	public RegistroPontoLocalServiceWrapper(
		RegistroPontoLocalService registroPontoLocalService) {
		_registroPontoLocalService = registroPontoLocalService;
	}

	@Override
	public com.desafio.ponto.model.custom.RegistroPonto consultarPonto(
		long companyId, long pis, String competencia) {
		return _registroPontoLocalService.consultarPonto(companyId, pis,
			competencia);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _registroPontoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String importarPontos(long companyId, long pis, String batidas) {
		return _registroPontoLocalService.importarPontos(companyId, pis, batidas);
	}

	@Override
	public String registraPonto(long companyId, long pis, String data) {
		return _registroPontoLocalService.registraPonto(companyId, pis, data);
	}

	@Override
	public RegistroPontoLocalService getWrappedService() {
		return _registroPontoLocalService;
	}

	@Override
	public void setWrappedService(
		RegistroPontoLocalService registroPontoLocalService) {
		_registroPontoLocalService = registroPontoLocalService;
	}

	private RegistroPontoLocalService _registroPontoLocalService;
}