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
 * Provides the remote service utility for RegistroPonto. This utility wraps
 * {@link com.desafio.ponto.service.impl.RegistroPontoServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Peterson Morais
 * @see RegistroPontoService
 * @see com.desafio.ponto.service.base.RegistroPontoServiceBaseImpl
 * @see com.desafio.ponto.service.impl.RegistroPontoServiceImpl
 * @generated
 */
@ProviderType
public class RegistroPontoServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.desafio.ponto.service.impl.RegistroPontoServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String registraPonto(long pis, String data) {
		return getService().registraPonto(pis, data);
	}

	public static RegistroPontoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistroPontoService, RegistroPontoService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistroPontoService.class);

		ServiceTracker<RegistroPontoService, RegistroPontoService> serviceTracker =
			new ServiceTracker<RegistroPontoService, RegistroPontoService>(bundle.getBundleContext(),
				RegistroPontoService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}