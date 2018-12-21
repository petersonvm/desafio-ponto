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

import com.desafio.ponto.exception.NoSuchPontoMarcacoesException;
import com.desafio.ponto.model.PontoMarcacoes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the ponto marcacoes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.persistence.impl.PontoMarcacoesPersistenceImpl
 * @see PontoMarcacoesUtil
 * @generated
 */
@ProviderType
public interface PontoMarcacoesPersistence extends BasePersistence<PontoMarcacoes> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PontoMarcacoesUtil} to access the ponto marcacoes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ponto marcacoeses where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @return the matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByPisData(long Pis,
		long Data);

	/**
	* Returns a range of all the ponto marcacoeses where Pis = &#63; and Data = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param Data the data
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @return the range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByPisData(long Pis,
		long Data, int start, int end);

	/**
	* Returns an ordered range of all the ponto marcacoeses where Pis = &#63; and Data = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param Data the data
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByPisData(long Pis,
		long Data, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns an ordered range of all the ponto marcacoeses where Pis = &#63; and Data = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param Data the data
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByPisData(long Pis,
		long Data, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ponto marcacoes in the ordered set where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes findByFindByPisData_First(long Pis, long Data,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Returns the first ponto marcacoes in the ordered set where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto marcacoes, or <code>null</code> if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes fetchByFindByPisData_First(long Pis, long Data,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns the last ponto marcacoes in the ordered set where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes findByFindByPisData_Last(long Pis, long Data,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Returns the last ponto marcacoes in the ordered set where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto marcacoes, or <code>null</code> if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes fetchByFindByPisData_Last(long Pis, long Data,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns the ponto marcacoeses before and after the current ponto marcacoes in the ordered set where Pis = &#63; and Data = &#63;.
	*
	* @param pontoMarcacoesPK the primary key of the current ponto marcacoes
	* @param Pis the pis
	* @param Data the data
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public PontoMarcacoes[] findByFindByPisData_PrevAndNext(
		PontoMarcacoesPK pontoMarcacoesPK, long Pis, long Data,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Removes all the ponto marcacoeses where Pis = &#63; and Data = &#63; from the database.
	*
	* @param Pis the pis
	* @param Data the data
	*/
	public void removeByFindByPisData(long Pis, long Data);

	/**
	* Returns the number of ponto marcacoeses where Pis = &#63; and Data = &#63;.
	*
	* @param Pis the pis
	* @param Data the data
	* @return the number of matching ponto marcacoeses
	*/
	public int countByFindByPisData(long Pis, long Data);

	/**
	* Returns all the ponto marcacoeses where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @return the matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByReferencia(long Pis,
		long DataReferencia);

	/**
	* Returns a range of all the ponto marcacoeses where Pis = &#63; and DataReferencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @return the range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByReferencia(long Pis,
		long DataReferencia, int start, int end);

	/**
	* Returns an ordered range of all the ponto marcacoeses where Pis = &#63; and DataReferencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByReferencia(long Pis,
		long DataReferencia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns an ordered range of all the ponto marcacoeses where Pis = &#63; and DataReferencia = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PontoMarcacoesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param start the lower bound of the range of ponto marcacoeses
	* @param end the upper bound of the range of ponto marcacoeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findByFindByReferencia(long Pis,
		long DataReferencia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ponto marcacoes in the ordered set where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes findByFindByReferencia_First(long Pis,
		long DataReferencia,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Returns the first ponto marcacoes in the ordered set where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ponto marcacoes, or <code>null</code> if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes fetchByFindByReferencia_First(long Pis,
		long DataReferencia,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns the last ponto marcacoes in the ordered set where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes findByFindByReferencia_Last(long Pis,
		long DataReferencia,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Returns the last ponto marcacoes in the ordered set where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ponto marcacoes, or <code>null</code> if a matching ponto marcacoes could not be found
	*/
	public PontoMarcacoes fetchByFindByReferencia_Last(long Pis,
		long DataReferencia,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

	/**
	* Returns the ponto marcacoeses before and after the current ponto marcacoes in the ordered set where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param pontoMarcacoesPK the primary key of the current ponto marcacoes
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public PontoMarcacoes[] findByFindByReferencia_PrevAndNext(
		PontoMarcacoesPK pontoMarcacoesPK, long Pis, long DataReferencia,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator)
		throws NoSuchPontoMarcacoesException;

	/**
	* Removes all the ponto marcacoeses where Pis = &#63; and DataReferencia = &#63; from the database.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	*/
	public void removeByFindByReferencia(long Pis, long DataReferencia);

	/**
	* Returns the number of ponto marcacoeses where Pis = &#63; and DataReferencia = &#63;.
	*
	* @param Pis the pis
	* @param DataReferencia the data referencia
	* @return the number of matching ponto marcacoeses
	*/
	public int countByFindByReferencia(long Pis, long DataReferencia);

	/**
	* Caches the ponto marcacoes in the entity cache if it is enabled.
	*
	* @param pontoMarcacoes the ponto marcacoes
	*/
	public void cacheResult(PontoMarcacoes pontoMarcacoes);

	/**
	* Caches the ponto marcacoeses in the entity cache if it is enabled.
	*
	* @param pontoMarcacoeses the ponto marcacoeses
	*/
	public void cacheResult(java.util.List<PontoMarcacoes> pontoMarcacoeses);

	/**
	* Creates a new ponto marcacoes with the primary key. Does not add the ponto marcacoes to the database.
	*
	* @param pontoMarcacoesPK the primary key for the new ponto marcacoes
	* @return the new ponto marcacoes
	*/
	public PontoMarcacoes create(PontoMarcacoesPK pontoMarcacoesPK);

	/**
	* Removes the ponto marcacoes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes that was removed
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public PontoMarcacoes remove(PontoMarcacoesPK pontoMarcacoesPK)
		throws NoSuchPontoMarcacoesException;

	public PontoMarcacoes updateImpl(PontoMarcacoes pontoMarcacoes);

	/**
	* Returns the ponto marcacoes with the primary key or throws a {@link NoSuchPontoMarcacoesException} if it could not be found.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes
	* @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	*/
	public PontoMarcacoes findByPrimaryKey(PontoMarcacoesPK pontoMarcacoesPK)
		throws NoSuchPontoMarcacoesException;

	/**
	* Returns the ponto marcacoes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pontoMarcacoesPK the primary key of the ponto marcacoes
	* @return the ponto marcacoes, or <code>null</code> if a ponto marcacoes with the primary key could not be found
	*/
	public PontoMarcacoes fetchByPrimaryKey(PontoMarcacoesPK pontoMarcacoesPK);

	@Override
	public java.util.Map<java.io.Serializable, PontoMarcacoes> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ponto marcacoeses.
	*
	* @return the ponto marcacoeses
	*/
	public java.util.List<PontoMarcacoes> findAll();

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
	public java.util.List<PontoMarcacoes> findAll(int start, int end);

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
	public java.util.List<PontoMarcacoes> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator);

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
	public java.util.List<PontoMarcacoes> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PontoMarcacoes> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ponto marcacoeses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ponto marcacoeses.
	*
	* @return the number of ponto marcacoeses
	*/
	public int countAll();

	public java.util.Set<String> getCompoundPKColumnNames();
}