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

import com.desafio.ponto.model.custom.RegistroPonto;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the remote service interface for RegistroPonto. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Peterson Morais
 * @see RegistroPontoServiceUtil
 * @see com.desafio.ponto.service.base.RegistroPontoServiceBaseImpl
 * @see com.desafio.ponto.service.impl.RegistroPontoServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=desafioponto", "json.web.service.context.path=RegistroPonto"}, service = RegistroPontoService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RegistroPontoService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistroPontoServiceUtil} to access the registro ponto remote service. Add custom service methods to {@link com.desafio.ponto.service.impl.RegistroPontoServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public RegistroPonto consultarPonto(long companyId, long pis, String dia);

	public RegistroPonto consultarPontoCompetencia(long companyId, long pis,
		String competencia);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	public String importarPontos(long companyId, long pis, String batidas);

	public String registraPonto(long companyId, long pis, String data);
}