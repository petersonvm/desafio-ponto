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

package com.desafio.ponto.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.exception.NoSuchPontoDiaException;
import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.model.impl.PontoDiaImpl;
import com.desafio.ponto.model.impl.PontoDiaModelImpl;
import com.desafio.ponto.service.persistence.PontoDiaPK;
import com.desafio.ponto.service.persistence.PontoDiaPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the ponto dia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see PontoDiaPersistence
 * @see com.desafio.ponto.service.persistence.PontoDiaUtil
 * @generated
 */
@ProviderType
public class PontoDiaPersistenceImpl extends BasePersistenceImpl<PontoDia>
	implements PontoDiaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PontoDiaUtil} to access the ponto dia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PontoDiaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, PontoDiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, PontoDiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PontoDiaPersistenceImpl() {
		setModelClass(PontoDia.class);
	}

	/**
	 * Caches the ponto dia in the entity cache if it is enabled.
	 *
	 * @param pontoDia the ponto dia
	 */
	@Override
	public void cacheResult(PontoDia pontoDia) {
		entityCache.putResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaImpl.class, pontoDia.getPrimaryKey(), pontoDia);

		pontoDia.resetOriginalValues();
	}

	/**
	 * Caches the ponto dias in the entity cache if it is enabled.
	 *
	 * @param pontoDias the ponto dias
	 */
	@Override
	public void cacheResult(List<PontoDia> pontoDias) {
		for (PontoDia pontoDia : pontoDias) {
			if (entityCache.getResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
						PontoDiaImpl.class, pontoDia.getPrimaryKey()) == null) {
				cacheResult(pontoDia);
			}
			else {
				pontoDia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ponto dias.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PontoDiaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ponto dia.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PontoDia pontoDia) {
		entityCache.removeResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaImpl.class, pontoDia.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PontoDia> pontoDias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PontoDia pontoDia : pontoDias) {
			entityCache.removeResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
				PontoDiaImpl.class, pontoDia.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	 *
	 * @param pontoDiaPK the primary key for the new ponto dia
	 * @return the new ponto dia
	 */
	@Override
	public PontoDia create(PontoDiaPK pontoDiaPK) {
		PontoDia pontoDia = new PontoDiaImpl();

		pontoDia.setNew(true);
		pontoDia.setPrimaryKey(pontoDiaPK);

		return pontoDia;
	}

	/**
	 * Removes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pontoDiaPK the primary key of the ponto dia
	 * @return the ponto dia that was removed
	 * @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia remove(PontoDiaPK pontoDiaPK)
		throws NoSuchPontoDiaException {
		return remove((Serializable)pontoDiaPK);
	}

	/**
	 * Removes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ponto dia
	 * @return the ponto dia that was removed
	 * @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia remove(Serializable primaryKey)
		throws NoSuchPontoDiaException {
		Session session = null;

		try {
			session = openSession();

			PontoDia pontoDia = (PontoDia)session.get(PontoDiaImpl.class,
					primaryKey);

			if (pontoDia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPontoDiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pontoDia);
		}
		catch (NoSuchPontoDiaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PontoDia removeImpl(PontoDia pontoDia) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pontoDia)) {
				pontoDia = (PontoDia)session.get(PontoDiaImpl.class,
						pontoDia.getPrimaryKeyObj());
			}

			if (pontoDia != null) {
				session.delete(pontoDia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pontoDia != null) {
			clearCache(pontoDia);
		}

		return pontoDia;
	}

	@Override
	public PontoDia updateImpl(PontoDia pontoDia) {
		boolean isNew = pontoDia.isNew();

		Session session = null;

		try {
			session = openSession();

			if (pontoDia.isNew()) {
				session.save(pontoDia);

				pontoDia.setNew(false);
			}
			else {
				pontoDia = (PontoDia)session.merge(pontoDia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaImpl.class, pontoDia.getPrimaryKey(), pontoDia, false);

		pontoDia.resetOriginalValues();

		return pontoDia;
	}

	/**
	 * Returns the ponto dia with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ponto dia
	 * @return the ponto dia
	 * @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPontoDiaException {
		PontoDia pontoDia = fetchByPrimaryKey(primaryKey);

		if (pontoDia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPontoDiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pontoDia;
	}

	/**
	 * Returns the ponto dia with the primary key or throws a {@link NoSuchPontoDiaException} if it could not be found.
	 *
	 * @param pontoDiaPK the primary key of the ponto dia
	 * @return the ponto dia
	 * @throws NoSuchPontoDiaException if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia findByPrimaryKey(PontoDiaPK pontoDiaPK)
		throws NoSuchPontoDiaException {
		return findByPrimaryKey((Serializable)pontoDiaPK);
	}

	/**
	 * Returns the ponto dia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ponto dia
	 * @return the ponto dia, or <code>null</code> if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
				PontoDiaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PontoDia pontoDia = (PontoDia)serializable;

		if (pontoDia == null) {
			Session session = null;

			try {
				session = openSession();

				pontoDia = (PontoDia)session.get(PontoDiaImpl.class, primaryKey);

				if (pontoDia != null) {
					cacheResult(pontoDia);
				}
				else {
					entityCache.putResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
						PontoDiaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
					PontoDiaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pontoDia;
	}

	/**
	 * Returns the ponto dia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pontoDiaPK the primary key of the ponto dia
	 * @return the ponto dia, or <code>null</code> if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia fetchByPrimaryKey(PontoDiaPK pontoDiaPK) {
		return fetchByPrimaryKey((Serializable)pontoDiaPK);
	}

	@Override
	public Map<Serializable, PontoDia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PontoDia> map = new HashMap<Serializable, PontoDia>();

		for (Serializable primaryKey : primaryKeys) {
			PontoDia pontoDia = fetchByPrimaryKey(primaryKey);

			if (pontoDia != null) {
				map.put(primaryKey, pontoDia);
			}
		}

		return map;
	}

	/**
	 * Returns all the ponto dias.
	 *
	 * @return the ponto dias
	 */
	@Override
	public List<PontoDia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PontoDia> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PontoDia> findAll(int start, int end,
		OrderByComparator<PontoDia> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PontoDia> findAll(int start, int end,
		OrderByComparator<PontoDia> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PontoDia> list = null;

		if (retrieveFromCache) {
			list = (List<PontoDia>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PONTODIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PONTODIA;

				if (pagination) {
					sql = sql.concat(PontoDiaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PontoDia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PontoDia>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ponto dias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PontoDia pontoDia : findAll()) {
			remove(pontoDia);
		}
	}

	/**
	 * Returns the number of ponto dias.
	 *
	 * @return the number of ponto dias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PONTODIA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PontoDiaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ponto dia persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PontoDiaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PONTODIA = "SELECT pontoDia FROM PontoDia pontoDia";
	private static final String _SQL_COUNT_PONTODIA = "SELECT COUNT(pontoDia) FROM PontoDia pontoDia";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pontoDia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PontoDia exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PontoDiaPersistenceImpl.class);
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(new String[] {
				"Pis", "Data"
			});
}