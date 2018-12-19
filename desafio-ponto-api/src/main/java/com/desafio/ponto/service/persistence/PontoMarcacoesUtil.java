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

package com.desafio.ponto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.model.PontoMarcacoes;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ponto marcacoes service. This utility wraps {@link com.desafio.ponto.service.persistence.impl.PontoMarcacoesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see PontoMarcacoesPersistence
 * @see com.desafio.ponto.service.persistence.impl.PontoMarcacoesPersistenceImpl
 * @generated
 */
@ProviderType
public class PontoMarcacoesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PontoMarcacoes pontoMarcacoes) {
		getPersistence().clearCache(pontoMarcacoes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PontoMarcacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PontoMarcacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PontoMarcacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PontoMarcacoes> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PontoMarcacoes update(PontoMarcacoes pontoMarcacoes) {
		return getPersistence().update(pontoMarcacoes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PontoMarcacoes update(PontoMarcacoes pontoMarcacoes,
		ServiceContext serviceContext) {
		return getPersistence().update(pontoMarcacoes, serviceContext);
	}

	/**
	* Caches the ponto marcacoes in the entity cache if it is enabled.
	*
	* @param pontoMarcacoes the ponto marcacoes
	*/
	public static void cacheResult(PontoMarcacoes pontoMarcacoes) {
		getPersistence().cacheResult(pontoMarcacoes);
	}

	/**
	* Caches the ponto marcacoeses in the entity cache if it is enabled.
	*
	* @param pontoMarcacoeses the ponto marcacoeses
	*/
	public static void cacheResult(List<PontoMarcacoes> pontoMarcacoeses) {
		getPersistence().cacheResult(pontoMarcacoeses);
	}

	/**
	* Creates a new ponto marcacoes with the primary key. Does not add the ponto marcacoes to the database.
	*
	* @param pontoMarcacoesPK the primary key for the new ponto marcacoes
	* @return the new ponto marcacoes
	*/
	public static PontoMarcacoes create(PontoMarcacoesPK pontoMarcacoesPK) {
		return getPersistence().create(pontoMarcacoesPK);
	}

	/**
	* Removes the ponto marcacoes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes that was removed
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public static PontoMarcacoes remove(PontoMarcacoesPK pontoMarcacoesPK)
		throws com.desafio.ponto.exception.NoSuchPontoMarcacoesException {
		return getPersistence().remove(pontoMarcacoesPK);
	}

	public static PontoMarcacoes updateImpl(PontoMarcacoes pontoMarcacoes) {
		return getPersistence().updateImpl(pontoMarcacoes);
	}

	/**
	* Returns the ponto marcacoes with the primary key or throws a {@link NoSuchPontoMarcacoesException} if it could not be found.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public static PontoMarcacoes findByPrimaryKey(
		PontoMarcacoesPK pontoMarcacoesPK)
		throws com.desafio.ponto.exception.NoSuchPontoMarcacoesException {
		return getPersistence().findByPrimaryKey(pontoMarcacoesPK);
	}

	/**
	* Returns the ponto marcacoes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes, or <code>null</code> if a ponto marcacoes with the primary key could not be found
	*/
	public static PontoMarcacoes fetchByPrimaryKey(
		PontoMarcacoesPK pontoMarcacoesPK) {
		return getPersistence().fetchByPrimaryKey(pontoMarcacoesPK);
	}

	public static java.util.Map<java.io.Serializable, PontoMarcacoes> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ponto marcacoeses.
	*
	* @return the ponto marcacoeses
	*/
	public static List<PontoMarcacoes> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ponto marcacoeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @return the range of ponto marcacoeses
	*/
	public static List<PontoMarcacoes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ponto marcacoeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ponto marcacoeses
	*/
	public static List<PontoMarcacoes> findAll(int start, int end,
		OrderByComparator<PontoMarcacoes> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ponto marcacoeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ponto marcacoeses
	*/
	public static List<PontoMarcacoes> findAll(int start, int end,
		OrderByComparator<PontoMarcacoes> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ponto marcacoeses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ponto marcacoeses.
	*
	* @return the number of ponto marcacoeses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PontoMarcacoesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PontoMarcacoesPersistence, PontoMarcacoesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PontoMarcacoesPersistence.class);

		ServiceTracker<PontoMarcacoesPersistence, PontoMarcacoesPersistence> serviceTracker =
			new ServiceTracker<PontoMarcacoesPersistence, PontoMarcacoesPersistence>(bundle.getBundleContext(),
				PontoMarcacoesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}