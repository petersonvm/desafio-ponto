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

import com.desafio.ponto.exception.NoSuchPontoMarcacoesException;
import com.desafio.ponto.model.PontoMarcacoes;
import com.desafio.ponto.model.impl.PontoMarcacoesImpl;
import com.desafio.ponto.model.impl.PontoMarcacoesModelImpl;
import com.desafio.ponto.service.persistence.PontoMarcacoesPK;
import com.desafio.ponto.service.persistence.PontoMarcacoesPersistence;

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
 * The persistence implementation for the ponto marcacoes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peterson Morais
 * @see PontoMarcacoesPersistence
 * @see com.desafio.ponto.service.persistence.PontoMarcacoesUtil
 * @generated
 */
@ProviderType
public class PontoMarcacoesPersistenceImpl extends BasePersistenceImpl<PontoMarcacoes>
	implements PontoMarcacoesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PontoMarcacoesUtil} to access the ponto marcacoes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PontoMarcacoesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesModelImpl.FINDER_CACHE_ENABLED,
			PontoMarcacoesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesModelImpl.FINDER_CACHE_ENABLED,
			PontoMarcacoesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PontoMarcacoesPersistenceImpl() {
		setModelClass(PontoMarcacoes.class);
	}

	/**
	 * Caches the ponto marcacoes in the entity cache if it is enabled.
	 *
	 * @param pontoMarcacoes the ponto marcacoes
	 */
	@Override
	public void cacheResult(PontoMarcacoes pontoMarcacoes) {
		entityCache.putResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesImpl.class, pontoMarcacoes.getPrimaryKey(),
			pontoMarcacoes);

		pontoMarcacoes.resetOriginalValues();
	}

	/**
	 * Caches the ponto marcacoeses in the entity cache if it is enabled.
	 *
	 * @param pontoMarcacoeses the ponto marcacoeses
	 */
	@Override
	public void cacheResult(List<PontoMarcacoes> pontoMarcacoeses) {
		for (PontoMarcacoes pontoMarcacoes : pontoMarcacoeses) {
			if (entityCache.getResult(
						PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
						PontoMarcacoesImpl.class, pontoMarcacoes.getPrimaryKey()) == null) {
				cacheResult(pontoMarcacoes);
			}
			else {
				pontoMarcacoes.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ponto marcacoeses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PontoMarcacoesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ponto marcacoes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PontoMarcacoes pontoMarcacoes) {
		entityCache.removeResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesImpl.class, pontoMarcacoes.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PontoMarcacoes> pontoMarcacoeses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PontoMarcacoes pontoMarcacoes : pontoMarcacoeses) {
			entityCache.removeResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
				PontoMarcacoesImpl.class, pontoMarcacoes.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ponto marcacoes with the primary key. Does not add the ponto marcacoes to the database.
	 *
	 * @param pontoMarcacoesPK the primary key for the new ponto marcacoes
	 * @return the new ponto marcacoes
	 */
	@Override
	public PontoMarcacoes create(PontoMarcacoesPK pontoMarcacoesPK) {
		PontoMarcacoes pontoMarcacoes = new PontoMarcacoesImpl();

		pontoMarcacoes.setNew(true);
		pontoMarcacoes.setPrimaryKey(pontoMarcacoesPK);

		return pontoMarcacoes;
	}

	/**
	 * Removes the ponto marcacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pontoMarcacoesPK the primary key of the ponto marcacoes
	 * @return the ponto marcacoes that was removed
	 * @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes remove(PontoMarcacoesPK pontoMarcacoesPK)
		throws NoSuchPontoMarcacoesException {
		return remove((Serializable)pontoMarcacoesPK);
	}

	/**
	 * Removes the ponto marcacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ponto marcacoes
	 * @return the ponto marcacoes that was removed
	 * @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes remove(Serializable primaryKey)
		throws NoSuchPontoMarcacoesException {
		Session session = null;

		try {
			session = openSession();

			PontoMarcacoes pontoMarcacoes = (PontoMarcacoes)session.get(PontoMarcacoesImpl.class,
					primaryKey);

			if (pontoMarcacoes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPontoMarcacoesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pontoMarcacoes);
		}
		catch (NoSuchPontoMarcacoesException nsee) {
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
	protected PontoMarcacoes removeImpl(PontoMarcacoes pontoMarcacoes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pontoMarcacoes)) {
				pontoMarcacoes = (PontoMarcacoes)session.get(PontoMarcacoesImpl.class,
						pontoMarcacoes.getPrimaryKeyObj());
			}

			if (pontoMarcacoes != null) {
				session.delete(pontoMarcacoes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pontoMarcacoes != null) {
			clearCache(pontoMarcacoes);
		}

		return pontoMarcacoes;
	}

	@Override
	public PontoMarcacoes updateImpl(PontoMarcacoes pontoMarcacoes) {
		boolean isNew = pontoMarcacoes.isNew();

		Session session = null;

		try {
			session = openSession();

			if (pontoMarcacoes.isNew()) {
				session.save(pontoMarcacoes);

				pontoMarcacoes.setNew(false);
			}
			else {
				pontoMarcacoes = (PontoMarcacoes)session.merge(pontoMarcacoes);
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

		entityCache.putResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
			PontoMarcacoesImpl.class, pontoMarcacoes.getPrimaryKey(),
			pontoMarcacoes, false);

		pontoMarcacoes.resetOriginalValues();

		return pontoMarcacoes;
	}

	/**
	 * Returns the ponto marcacoes with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ponto marcacoes
	 * @return the ponto marcacoes
	 * @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPontoMarcacoesException {
		PontoMarcacoes pontoMarcacoes = fetchByPrimaryKey(primaryKey);

		if (pontoMarcacoes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPontoMarcacoesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pontoMarcacoes;
	}

	/**
	 * Returns the ponto marcacoes with the primary key or throws a {@link NoSuchPontoMarcacoesException} if it could not be found.
	 *
	 * @param pontoMarcacoesPK the primary key of the ponto marcacoes
	 * @return the ponto marcacoes
	 * @throws NoSuchPontoMarcacoesException if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes findByPrimaryKey(PontoMarcacoesPK pontoMarcacoesPK)
		throws NoSuchPontoMarcacoesException {
		return findByPrimaryKey((Serializable)pontoMarcacoesPK);
	}

	/**
	 * Returns the ponto marcacoes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ponto marcacoes
	 * @return the ponto marcacoes, or <code>null</code> if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
				PontoMarcacoesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PontoMarcacoes pontoMarcacoes = (PontoMarcacoes)serializable;

		if (pontoMarcacoes == null) {
			Session session = null;

			try {
				session = openSession();

				pontoMarcacoes = (PontoMarcacoes)session.get(PontoMarcacoesImpl.class,
						primaryKey);

				if (pontoMarcacoes != null) {
					cacheResult(pontoMarcacoes);
				}
				else {
					entityCache.putResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
						PontoMarcacoesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PontoMarcacoesModelImpl.ENTITY_CACHE_ENABLED,
					PontoMarcacoesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pontoMarcacoes;
	}

	/**
	 * Returns the ponto marcacoes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pontoMarcacoesPK the primary key of the ponto marcacoes
	 * @return the ponto marcacoes, or <code>null</code> if a ponto marcacoes with the primary key could not be found
	 */
	@Override
	public PontoMarcacoes fetchByPrimaryKey(PontoMarcacoesPK pontoMarcacoesPK) {
		return fetchByPrimaryKey((Serializable)pontoMarcacoesPK);
	}

	@Override
	public Map<Serializable, PontoMarcacoes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PontoMarcacoes> map = new HashMap<Serializable, PontoMarcacoes>();

		for (Serializable primaryKey : primaryKeys) {
			PontoMarcacoes pontoMarcacoes = fetchByPrimaryKey(primaryKey);

			if (pontoMarcacoes != null) {
				map.put(primaryKey, pontoMarcacoes);
			}
		}

		return map;
	}

	/**
	 * Returns all the ponto marcacoeses.
	 *
	 * @return the ponto marcacoeses
	 */
	@Override
	public List<PontoMarcacoes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PontoMarcacoes> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PontoMarcacoes> findAll(int start, int end,
		OrderByComparator<PontoMarcacoes> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PontoMarcacoes> findAll(int start, int end,
		OrderByComparator<PontoMarcacoes> orderByComparator,
		boolean retrieveFromCache) {
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

		List<PontoMarcacoes> list = null;

		if (retrieveFromCache) {
			list = (List<PontoMarcacoes>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PONTOMARCACOES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PONTOMARCACOES;

				if (pagination) {
					sql = sql.concat(PontoMarcacoesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PontoMarcacoes>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PontoMarcacoes>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the ponto marcacoeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PontoMarcacoes pontoMarcacoes : findAll()) {
			remove(pontoMarcacoes);
		}
	}

	/**
	 * Returns the number of ponto marcacoeses.
	 *
	 * @return the number of ponto marcacoeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PONTOMARCACOES);

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
		return PontoMarcacoesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ponto marcacoes persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PontoMarcacoesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PONTOMARCACOES = "SELECT pontoMarcacoes FROM PontoMarcacoes pontoMarcacoes";
	private static final String _SQL_COUNT_PONTOMARCACOES = "SELECT COUNT(pontoMarcacoes) FROM PontoMarcacoes pontoMarcacoes";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pontoMarcacoes.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PontoMarcacoes exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PontoMarcacoesPersistenceImpl.class);
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(new String[] {
				"Pis", "DataHora"
			});
}