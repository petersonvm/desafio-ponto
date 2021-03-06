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

package com.desafio.ponto.service.http;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.service.RegistroPontoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link RegistroPontoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Peterson Morais
 * @see RegistroPontoServiceHttp
 * @see RegistroPontoServiceUtil
 * @generated
 */
@ProviderType
public class RegistroPontoServiceSoap {
	public static String registraPonto(long companyId, long pis, String data)
		throws RemoteException {
		try {
			String returnValue = RegistroPontoServiceUtil.registraPonto(companyId,
					pis, data);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.desafio.ponto.model.custom.RegistroPonto consultarPontoCompetencia(
		long companyId, long pis, String competencia) throws RemoteException {
		try {
			com.desafio.ponto.model.custom.RegistroPonto returnValue = RegistroPontoServiceUtil.consultarPontoCompetencia(companyId,
					pis, competencia);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.desafio.ponto.model.custom.RegistroPonto consultarPonto(
		long companyId, long pis, String dia) throws RemoteException {
		try {
			com.desafio.ponto.model.custom.RegistroPonto returnValue = RegistroPontoServiceUtil.consultarPonto(companyId,
					pis, dia);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static String importarPontos(long companyId, long pis, String batidas)
		throws RemoteException {
		try {
			String returnValue = RegistroPontoServiceUtil.importarPontos(companyId,
					pis, batidas);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RegistroPontoServiceSoap.class);
}