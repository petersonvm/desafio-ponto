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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link RegistroPontoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Peterson Morais
 * @see RegistroPontoServiceSoap
 * @see HttpPrincipal
 * @see RegistroPontoServiceUtil
 * @generated
 */
@ProviderType
public class RegistroPontoServiceHttp {
	public static String registraPonto(HttpPrincipal httpPrincipal,
		long companyId, long pis, String data) {
		try {
			MethodKey methodKey = new MethodKey(RegistroPontoServiceUtil.class,
					"registraPonto", _registraPontoParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, pis, data);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.desafio.ponto.model.custom.RegistroPonto consultarPontoCompetencia(
		HttpPrincipal httpPrincipal, long companyId, long pis,
		String competencia) {
		try {
			MethodKey methodKey = new MethodKey(RegistroPontoServiceUtil.class,
					"consultarPontoCompetencia",
					_consultarPontoCompetenciaParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, pis, competencia);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.desafio.ponto.model.custom.RegistroPonto)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.desafio.ponto.model.custom.RegistroPonto consultarPonto(
		HttpPrincipal httpPrincipal, long companyId, long pis, String dia) {
		try {
			MethodKey methodKey = new MethodKey(RegistroPontoServiceUtil.class,
					"consultarPonto", _consultarPontoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, pis, dia);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.desafio.ponto.model.custom.RegistroPonto)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static String importarPontos(HttpPrincipal httpPrincipal,
		long companyId, long pis, String batidas) {
		try {
			MethodKey methodKey = new MethodKey(RegistroPontoServiceUtil.class,
					"importarPontos", _importarPontosParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, pis, batidas);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RegistroPontoServiceHttp.class);
	private static final Class<?>[] _registraPontoParameterTypes0 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _consultarPontoCompetenciaParameterTypes1 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _consultarPontoParameterTypes2 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _importarPontosParameterTypes3 = new Class[] {
			long.class, long.class, String.class
		};
}