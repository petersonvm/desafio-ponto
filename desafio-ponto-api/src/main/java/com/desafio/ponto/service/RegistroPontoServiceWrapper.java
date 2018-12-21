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
 * Provides a wrapper for {@link RegistroPontoService}.
 *
 * @author Peterson Morais
 * @see RegistroPontoService
 * @generated
 */
@ProviderType
public class RegistroPontoServiceWrapper implements RegistroPontoService,
	ServiceWrapper<RegistroPontoService> {
	public RegistroPontoServiceWrapper(
		RegistroPontoService registroPontoService) {
		_registroPontoService = registroPontoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _registroPontoService.getOSGiServiceIdentifier();
	}

	@Override
	public String registraPonto(long pis, String data) {
		return _registroPontoService.registraPonto(pis, data);
	}

	@Override
	public RegistroPontoService getWrappedService() {
		return _registroPontoService;
	}

	@Override
	public void setWrappedService(RegistroPontoService registroPontoService) {
		_registroPontoService = registroPontoService;
	}

	private RegistroPontoService _registroPontoService;
}