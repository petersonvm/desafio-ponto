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

import com.desafio.ponto.model.PontoDia;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ponto dia service. This utility wraps {@link com.desafio.ponto.service.persistence.impl.PontoDiaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see PontoDiaPersistence
 * @see com.desafio.ponto.service.persistence.impl.PontoDiaPersistenceImpl
 * @generated
 */
@ProviderType
public class PontoDiaUtil {
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
	public static void clearCache(PontoDia pontoDia) {
		getPersistence().clearCache(pontoDia);
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
	public static List<PontoDia> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PontoDia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PontoDia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PontoDia> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PontoDia update(PontoDia pontoDia) {
		return getPersistence().update(pontoDia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PontoDia update(PontoDia pontoDia,
		ServiceContext serviceContext) {
		return getPersistence().update(pontoDia, serviceContext);
	}

	/**
	* Returns all the ponto dias where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @return the matching ponto dias
	*/
	public static List<PontoDia> findByFindByCompetencia(String Competencia) {
		return getPersistence().findByFindByCompetencia(Competencia);
	}

	/**
	* Returns a range of all the ponto dias where Competencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Competencia the competencia
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @return the range of matching ponto dias
	*/
	public static List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end) {
		return getPersistence().findByFindByCompetencia(Competencia, start, end);
	}

	/**
	* Returns an ordered range of all the ponto dias where Competencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Competencia the competencia
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ponto dias
	*/
	public static List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end, OrderByComparator<PontoDia> orderByComparator) {
		return getPersistence()
				   .findByFindByCompetencia(Competencia, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ponto dias where Competencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Competencia the competencia
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ponto dias
	*/
	public static List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end, OrderByComparator<PontoDia> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFindByCompetencia(Competencia, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ponto dia in the ordered set where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto dia
	* @throws NoSuchPontoDiaException if a matching ponto dia could not be found
	*/
	public static PontoDia findByFindByCompetencia_First(String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws com.desafio.ponto.exception.NoSuchPontoDiaException {
		return getPersistence()
				   .findByFindByCompetencia_First(Competencia, orderByComparator);
	}

	/**
	* Returns the first ponto dia in the ordered set where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto dia, or <code>null</code> if a matching ponto dia could not be found
	*/
	public static PontoDia fetchByFindByCompetencia_First(String Competencia,
		OrderByComparator<PontoDia> orderByComparator) {
		return getPersistence()
				   .fetchByFindByCompetencia_First(Competencia,
			orderByComparator);
	}

	/**
	* Returns the last ponto dia in the ordered set where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto dia
	* @throws NoSuchPontoDiaException if a matching ponto dia could not be found
	*/
	public static PontoDia findByFindByCompetencia_Last(String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws com.desafio.ponto.exception.NoSuchPontoDiaException {
		return getPersistence()
				   .findByFindByCompetencia_Last(Competencia, orderByComparator);
	}

	/**
	* Returns the last ponto dia in the ordered set where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto dia, or <code>null</code> if a matching ponto dia could not be found
	*/
	public static PontoDia fetchByFindByCompetencia_Last(String Competencia,
		OrderByComparator<PontoDia> orderByComparator) {
		return getPersistence()
				   .fetchByFindByCompetencia_Last(Competencia, orderByComparator);
	}

	/**
	* Returns the ponto dias before and after the current ponto dia in the ordered set where Competencia = &#63;.
	*
	* @param pontoDiaPK the primary key of the current ponto dia
	* @param Competencia the competencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ponto dia
	* @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	*/
	public static PontoDia[] findByFindByCompetencia_PrevAndNext(
		PontoDiaPK pontoDiaPK, String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws com.desafio.ponto.exception.NoSuchPontoDiaException {
		return getPersistence()
				   .findByFindByCompetencia_PrevAndNext(pontoDiaPK,
			Competencia, orderByComparator);
	}

	/**
	* Removes all the ponto dias where Competencia = &#63; from the database.
	*
	* @param Competencia the competencia
	*/
	public static void removeByFindByCompetencia(String Competencia) {
		getPersistence().removeByFindByCompetencia(Competencia);
	}

	/**
	* Returns the number of ponto dias where Competencia = &#63;.
	*
	* @param Competencia the competencia
	* @return the number of matching ponto dias
	*/
	public static int countByFindByCompetencia(String Competencia) {
		return getPersistence().countByFindByCompetencia(Competencia);
	}

	/**
	* Caches the ponto dia in the entity cache if it is enabled.
	*
	* @param pontoDia the ponto dia
	*/
	public static void cacheResult(PontoDia pontoDia) {
		getPersistence().cacheResult(pontoDia);
	}

	/**
	* Caches the ponto dias in the entity cache if it is enabled.
	*
	* @param pontoDias the ponto dias
	*/
	public static void cacheResult(List<PontoDia> pontoDias) {
		getPersistence().cacheResult(pontoDias);
	}

	/**
	* Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	*
	* @param pontoDiaPK the primary key for the new ponto dia
	* @return the new ponto dia
	*/
	public static PontoDia create(PontoDiaPK pontoDiaPK) {
		return getPersistence().create(pontoDiaPK);
	}

	/**
	* Removes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia that was removed
	* @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	*/
	public static PontoDia remove(PontoDiaPK pontoDiaPK)
		throws com.desafio.ponto.exception.NoSuchPontoDiaException {
		return getPersistence().remove(pontoDiaPK);
	}

	public static PontoDia updateImpl(PontoDia pontoDia) {
		return getPersistence().updateImpl(pontoDia);
	}

	/**
	* Returns the ponto dia with the primary key or throws a {@link NoSuchPontoDiaException} if it could not be found.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia
	* @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	*/
	public static PontoDia findByPrimaryKey(PontoDiaPK pontoDiaPK)
		throws com.desafio.ponto.exception.NoSuchPontoDiaException {
		return getPersistence().findByPrimaryKey(pontoDiaPK);
	}

	/**
	* Returns the ponto dia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia, or <code>null</code> if a ponto dia with the primary key could not be found
	*/
	public static PontoDia fetchByPrimaryKey(PontoDiaPK pontoDiaPK) {
		return getPersistence().fetchByPrimaryKey(pontoDiaPK);
	}

	public static java.util.Map<java.io.Serializable, PontoDia> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ponto dias.
	*
	* @return the ponto dias
	*/
	public static List<PontoDia> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ponto dias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @return the range of ponto dias
	*/
	public static List<PontoDia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ponto dias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ponto dias
	*/
	public static List<PontoDia> findAll(int start, int end,
		OrderByComparator<PontoDia> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ponto dias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoDiaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ponto dias
	* @param end the upper bound of the range of ponto dias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ponto dias
	*/
	public static List<PontoDia> findAll(int start, int end,
		OrderByComparator<PontoDia> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ponto dias from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ponto dias.
	*
	* @return the number of ponto dias
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PontoDiaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PontoDiaPersistence, PontoDiaPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PontoDiaPersistence.class);

		ServiceTracker<PontoDiaPersistence, PontoDiaPersistence> serviceTracker = new ServiceTracker<PontoDiaPersistence, PontoDiaPersistence>(bundle.getBundleContext(),
				PontoDiaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}