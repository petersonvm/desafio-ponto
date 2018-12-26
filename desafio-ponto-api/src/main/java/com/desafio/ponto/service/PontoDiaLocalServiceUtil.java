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
 * Provides the local service utility for PontoDia. This utility wraps
 * {@link com.desafio.ponto.service.impl.PontoDiaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Peterson Morais
 * @see PontoDiaLocalService
 * @see com.desafio.ponto.service.base.PontoDiaLocalServiceBaseImpl
 * @see com.desafio.ponto.service.impl.PontoDiaLocalServiceImpl
 * @generated
 */
@ProviderType
public class PontoDiaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.desafio.ponto.service.impl.PontoDiaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ponto dia to the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was added
	*/
	public static com.desafio.ponto.model.PontoDia addPontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return getService().addPontoDia(pontoDia);
	}

	public static com.desafio.ponto.model.PontoDia calcularHorasTrabalhadas(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return getService().calcularHorasTrabalhadas(pontoDia);
	}

	public static com.desafio.ponto.model.PontoDia calcularIntervalos(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return getService().calcularIntervalos(pontoDia);
	}

	/**
	* Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	*
	* @param pontoDiaPK the primary key for the new ponto dia
	* @return the new ponto dia
	*/
	public static com.desafio.ponto.model.PontoDia createPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK) {
		return getService().createPontoDia(pontoDiaPK);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ponto dia from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was removed
	*/
	public static com.desafio.ponto.model.PontoDia deletePontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return getService().deletePontoDia(pontoDia);
	}

	/**
	* Deletes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia that was removed
	* @throws PortalException if a ponto dia with the primary key could not be found
	*/
	public static com.desafio.ponto.model.PontoDia deletePontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePontoDia(pontoDiaPK);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.desafio.ponto.model.PontoDia fetchPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK) {
		return getService().fetchPontoDia(pontoDiaPK);
	}

	public static java.util.List<com.desafio.ponto.model.PontoDia> findByPisCompetencia(
		long pis, String competencia) {
		return getService().findByPisCompetencia(pis, competencia);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.desafio.ponto.model.PontoDia getPontoDia(long pis,
		java.util.Date dataHora)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPontoDia(pis, dataHora);
	}

	/**
	* Returns the ponto dia with the primary key.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia
	* @throws PortalException if a ponto dia with the primary key could not be found
	*/
	public static com.desafio.ponto.model.PontoDia getPontoDia(
		com.desafio.ponto.service.persistence.PontoDiaPK pontoDiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPontoDia(pontoDiaPK);
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
	public static java.util.List<com.desafio.ponto.model.PontoDia> getPontoDias(
		int start, int end) {
		return getService().getPontoDias(start, end);
	}

	/**
	* Returns the number of ponto dias.
	*
	* @return the number of ponto dias
	*/
	public static int getPontoDiasCount() {
		return getService().getPontoDiasCount();
	}

	public static com.desafio.ponto.model.PontoDia gravarPonto(long pis,
		java.util.Date dataHora)
		throws com.desafio.ponto.exception.PontoDiaExistenteException {
		return getService().gravarPonto(pis, dataHora);
	}

	/**
	* Updates the ponto dia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pontoDia the ponto dia
	* @return the ponto dia that was updated
	*/
	public static com.desafio.ponto.model.PontoDia updatePontoDia(
		com.desafio.ponto.model.PontoDia pontoDia) {
		return getService().updatePontoDia(pontoDia);
	}

	public static PontoDiaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PontoDiaLocalService, PontoDiaLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PontoDiaLocalService.class);

		ServiceTracker<PontoDiaLocalService, PontoDiaLocalService> serviceTracker =
			new ServiceTracker<PontoDiaLocalService, PontoDiaLocalService>(bundle.getBundleContext(),
				PontoDiaLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}