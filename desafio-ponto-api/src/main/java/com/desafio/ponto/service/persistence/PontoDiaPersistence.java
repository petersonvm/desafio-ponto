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

import com.desafio.ponto.exception.NoSuchPontoDiaException;
import com.desafio.ponto.model.PontoDia;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the ponto dia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.persistence.impl.PontoDiaPersistenceImpl
 * @see PontoDiaUtil
 * @generated
 */
@ProviderType
public interface PontoDiaPersistence extends BasePersistence<PontoDia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PontoDiaUtil} to access the ponto dia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ponto dia in the entity cache if it is enabled.
	*
	* @param pontoDia the ponto dia
	*/
	public void cacheResult(PontoDia pontoDia);

	/**
	* Caches the ponto dias in the entity cache if it is enabled.
	*
	* @param pontoDias the ponto dias
	*/
	public void cacheResult(java.util.List<PontoDia> pontoDias);

	/**
	* Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	*
	* @param pontoDiaPK the primary key for the new ponto dia
	* @return the new ponto dia
	*/
	public PontoDia create(PontoDiaPK pontoDiaPK);

	/**
	* Removes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia that was removed
	* @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	*/
	public PontoDia remove(PontoDiaPK pontoDiaPK)
		throws NoSuchPontoDiaException;

	public PontoDia updateImpl(PontoDia pontoDia);

	/**
	* Returns the ponto dia with the primary key or throws a {@link NoSuchPontoDiaException} if it could not be found.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia
	* @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	*/
	public PontoDia findByPrimaryKey(PontoDiaPK pontoDiaPK)
		throws NoSuchPontoDiaException;

	/**
	* Returns the ponto dia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pontoDiaPK the primary key of the ponto dia
	* @return the ponto dia, or <code>null</code> if a ponto dia with the primary key could not be found
	*/
	public PontoDia fetchByPrimaryKey(PontoDiaPK pontoDiaPK);

	@Override
	public java.util.Map<java.io.Serializable, PontoDia> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ponto dias.
	*
	* @return the ponto dias
	*/
	public java.util.List<PontoDia> findAll();

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
	public java.util.List<PontoDia> findAll(int start, int end);

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
	public java.util.List<PontoDia> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoDia> orderByComparator);

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
	public java.util.List<PontoDia> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoDia> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ponto dias from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ponto dias.
	*
	* @return the number of ponto dias
	*/
	public int countAll();

	public java.util.Set<String> getCompoundPKColumnNames();
}