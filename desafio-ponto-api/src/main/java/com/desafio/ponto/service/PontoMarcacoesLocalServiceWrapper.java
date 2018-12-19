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
 * Provides a wrapper for {@link PontoMarcacoesLocalService}.
 *
 * @author Peterson Morais
 * @see PontoMarcacoesLocalService
 * @generated
 */
@ProviderType
public class PontoMarcacoesLocalServiceWrapper
	implements PontoMarcacoesLocalService,
		ServiceWrapper<PontoMarcacoesLocalService> {
	public PontoMarcacoesLocalServiceWrapper(
		PontoMarcacoesLocalService pontoMarcacoesLocalService) {
		_pontoMarcacoesLocalService = pontoMarcacoesLocalService;
	}

	/**
	* Adds the ponto marcacoes to the database. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoes the ponto marcacoes
	* @return the ponto marcacoes that was added
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes addPontoMarcacoes(
		com.desafio.ponto.model.PontoMarcacoes pontoMarcacoes) {
		return _pontoMarcacoesLocalService.addPontoMarcacoes(pontoMarcacoes);
	}

	/**
	* Creates a new ponto marcacoes with the primary key. Does not add the ponto marcacoes to the database.
	*
	* @param pontoMarcacoesPK the primary key for the new ponto marcacoes
	* @return the new ponto marcacoes
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes createPontoMarcacoes(
		com.desafio.ponto.service.persistence.PontoMarcacoesPK pontoMarcacoesPK) {
		return _pontoMarcacoesLocalService.createPontoMarcacoes(pontoMarcacoesPK);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoMarcacoesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ponto marcacoes from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoes the ponto marcacoes
	* @return the ponto marcacoes that was removed
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes deletePontoMarcacoes(
		com.desafio.ponto.model.PontoMarcacoes pontoMarcacoes) {
		return _pontoMarcacoesLocalService.deletePontoMarcacoes(pontoMarcacoes);
	}

	/**
	* Deletes the ponto marcacoes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes that was removed
	* @throws PortalException if a ponto marcacoes with the primary key could not be found
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes deletePontoMarcacoes(
		com.desafio.ponto.service.persistence.PontoMarcacoesPK pontoMarcacoesPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoMarcacoesLocalService.deletePontoMarcacoes(pontoMarcacoesPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pontoMarcacoesLocalService.dynamicQuery();
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
		return _pontoMarcacoesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pontoMarcacoesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pontoMarcacoesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _pontoMarcacoesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _pontoMarcacoesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.desafio.ponto.model.PontoMarcacoes fetchPontoMarcacoes(
		com.desafio.ponto.service.persistence.PontoMarcacoesPK pontoMarcacoesPK) {
		return _pontoMarcacoesLocalService.fetchPontoMarcacoes(pontoMarcacoesPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pontoMarcacoesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pontoMarcacoesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _pontoMarcacoesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoMarcacoesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ponto marcacoes with the primary key.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes
	* @throws PortalException if a ponto marcacoes with the primary key could not be found
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes getPontoMarcacoes(
		com.desafio.ponto.service.persistence.PontoMarcacoesPK pontoMarcacoesPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pontoMarcacoesLocalService.getPontoMarcacoes(pontoMarcacoesPK);
	}

	/**
	* Returns a range of all the ponto marcacoeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.desafio.ponto.model.impl.PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @return the range of ponto marcacoeses
	*/
	@Override
	public java.util.List<com.desafio.ponto.model.PontoMarcacoes> getPontoMarcacoeses(
		int start, int end) {
		return _pontoMarcacoesLocalService.getPontoMarcacoeses(start, end);
	}

	/**
	* Returns the number of ponto marcacoeses.
	*
	* @return the number of ponto marcacoeses
	*/
	@Override
	public int getPontoMarcacoesesCount() {
		return _pontoMarcacoesLocalService.getPontoMarcacoesesCount();
	}

	@Override
	public com.desafio.ponto.model.PontoMarcacoes registrarMarcacao(long pis,
		java.util.Date dataMarcacao) {
		return _pontoMarcacoesLocalService.registrarMarcacao(pis, dataMarcacao);
	}

	/**
	* Updates the ponto marcacoes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoes the ponto marcacoes
	* @return the ponto marcacoes that was updated
	*/
	@Override
	public com.desafio.ponto.model.PontoMarcacoes updatePontoMarcacoes(
		com.desafio.ponto.model.PontoMarcacoes pontoMarcacoes) {
		return _pontoMarcacoesLocalService.updatePontoMarcacoes(pontoMarcacoes);
	}

	@Override
	public PontoMarcacoesLocalService getWrappedService() {
		return _pontoMarcacoesLocalService;
	}

	@Override
	public void setWrappedService(
		PontoMarcacoesLocalService pontoMarcacoesLocalService) {
		_pontoMarcacoesLocalService = pontoMarcacoesLocalService;
	}

	private PontoMarcacoesLocalService _pontoMarcacoesLocalService;
}