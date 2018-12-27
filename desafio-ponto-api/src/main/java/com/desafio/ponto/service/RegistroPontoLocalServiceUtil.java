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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RegistroPonto. This utility wraps
 * {@link com.desafio.ponto.service.impl.RegistroPontoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Peterson Morais
 * @see RegistroPontoLocalService
 * @see com.desafio.ponto.service.base.RegistroPontoLocalServiceBaseImpl
 * @see com.desafio.ponto.service.impl.RegistroPontoLocalServiceImpl
 * @generated
 */
@ProviderType
public class RegistroPontoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.desafio.ponto.service.impl.RegistroPontoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.desafio.ponto.model.custom.RegistroPonto consultarPonto(
		long companyId, long pis, String dia) {
		return getService().consultarPonto(companyId, pis, dia);
	}

	public static com.desafio.ponto.model.custom.RegistroPonto consultarPontoCompetencia(
		long companyId, long pis, String competencia) {
		return getService()
				   .consultarPontoCompetencia(companyId, pis, competencia);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String importarPontos(long companyId, long pis, String batidas) {
		return getService().importarPontos(companyId, pis, batidas);
	}

	public static String registraPonto(long companyId, long pis, String data) {
		return getService().registraPonto(companyId, pis, data);
	}

	public static RegistroPontoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistroPontoLocalService, RegistroPontoLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistroPontoLocalService.class);

		ServiceTracker<RegistroPontoLocalService, RegistroPontoLocalService> serviceTracker =
			new ServiceTracker<RegistroPontoLocalService, RegistroPontoLocalService>(bundle.getBundleContext(),
				RegistroPontoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}