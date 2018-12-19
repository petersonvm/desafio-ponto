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
 * Provides a wrapper for {@link PontoDiaLocalService}.
 *
 * @author Peterson Morais
 * @see PontoDiaLocalService
 * @generated
 */
@ProviderType
public class PontoDiaLocalServiceWrapper implements PontoDiaLocalService,
	ServiceWrapper<PontoDiaLocalService> {
	public PontoDiaLocalServiceWrapper(
		PontoDiaLocalService pontoDiaLocalService) {
		_pontoDiaLocalService = pontoDiaLocalService;
	}

	/**
	* Adds the ponto dia to the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was added
	*/
	@Override
	public com.desafio.ponto.model.PontoDia addPontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return _pontoDiaLocalService.addPontoDia(pontoDia);
	}

	/**
	* Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	*
	* @param pontoDiaPK the primary key for the new ponto dia
	* @return the new ponto dia
	*/
	@Override
	public com.desafio.ponto.model.PontoDia createPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK) {
		return _pontoDiaLocalService.createPontoDia(pontoDiaPK);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoDiaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ponto dia from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was removed
	*/
	@Override
	public com.desafio.ponto.model.PontoDia deletePontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return _pontoDiaLocalService.deletePontoDia(pontoDia);
	}

	/**
	* Deletes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia that was removed
	* @throws PortalException if a ponto dia with the primary key could not be found
	*/
	@Override
	public com.desafio.ponto.model.PontoDia deletePontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoDiaLocalService.deletePontoDia(pontoDiaPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pontoDiaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pontoDiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _pontoDiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _pontoDiaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pontoDiaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _pontoDiaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.desafio.ponto.model.PontoDia fetchPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK) {
		return _pontoDiaLocalService.fetchPontoDia(pontoDiaPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pontoDiaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pontoDiaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _pontoDiaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoDiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ponto dia with the primary key.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia
	* @throws PortalException if a ponto dia with the primary key could not be found
	*/
	@Override
	public com.desafio.ponto.model.PontoDia getPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoDiaLocalService.getPontoDia(pontoDiaPK);
	}

	/**
	* Returns a range of all the ponto dias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @return the range of ponto dias
	*/
	@Override
	public java.util.List<com.desafio.ponto.model.PontoDia> getPontoDias(
		int start, int end) {
		return _pontoDiaLocalService.getPontoDias(start, end);
	}

	/**
	* Returns the number of ponto dias.
	*
	* @return the number of ponto dias
	*/
	@Override
	public int getPontoDiasCount() {
		return _pontoDiaLocalService.getPontoDiasCount();
	}

	@Override
	public com.desafio.ponto.model.PontoDia registarPonto(long pis,
		java.util.Date dataPonto) {
		return _pontoDiaLocalService.registarPonto(pis, dataPonto);
	}

	/**
	* Updates the ponto dia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was updated
	*/
	@Override
	public com.desafio.ponto.model.PontoDia updatePontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return _pontoDiaLocalService.updatePontoDia(pontoDia);
	}

	@Override
	public PontoDiaLocalService getWrappedService() {
		return _pontoDiaLocalService;
	}

	@Override
	public void setWrappedService(PontoDiaLocalService pontoDiaLocalService) {
		_pontoDiaLocalService = pontoDiaLocalService;
	}

	private PontoDiaLocalService _pontoDiaLocalService;
}