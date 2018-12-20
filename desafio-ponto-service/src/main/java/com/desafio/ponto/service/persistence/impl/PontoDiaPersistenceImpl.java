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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYCOMPETENCIA =
		new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, PontoDiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByCompetencia",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA =
		new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, PontoDiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFindByCompetencia", new String[] { String.class.getName() },
			PontoDiaModelImpl.COMPETENCIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYCOMPETENCIA = new FinderPath(PontoDiaModelImpl.ENTITY_CACHE_ENABLED,
			PontoDiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindByCompetencia", new String[] { String.class.getName() });

	/**
	 * Returns all the ponto dias where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @return the matching ponto dias
	 */
	@Override
	public List<PontoDia> findByFindByCompetencia(String Competencia) {
		return findByFindByCompetencia(Competencia, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end) {
		return findByFindByCompetencia(Competencia, start, end, null);
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
	@Override
	public List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end, OrderByComparator<PontoDia> orderByComparator) {
		return findByFindByCompetencia(Competencia, start, end,
			orderByComparator, true);
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
	@Override
	public List<PontoDia> findByFindByCompetencia(String Competencia,
		int start, int end, OrderByComparator<PontoDia> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA;
			finderArgs = new Object[] { Competencia };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYCOMPETENCIA;
			finderArgs = new Object[] { Competencia, start, end, orderByComparator };
		}

		List<PontoDia> list = null;

		if (retrieveFromCache) {
			list = (List<PontoDia>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PontoDia pontoDia : list) {
					if (!Objects.equals(Competencia, pontoDia.getCompetencia())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PONTODIA_WHERE);

			boolean bindCompetencia = false;

			if (Competencia == null) {
				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_1);
			}
			else if (Competencia.equals("")) {
				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_3);
			}
			else {
				bindCompetencia = true;

				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PontoDiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompetencia) {
					qPos.add(Competencia);
				}

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
	 * Returns the first ponto dia in the ordered set where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ponto dia
	 * @throws NoSuchPontoDiaException if a matching ponto dia could not be found
	 */
	@Override
	public PontoDia findByFindByCompetencia_First(String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws NoSuchPontoDiaException {
		PontoDia pontoDia = fetchByFindByCompetencia_First(Competencia,
				orderByComparator);

		if (pontoDia != null) {
			return pontoDia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Competencia=");
		msg.append(Competencia);

		msg.append("}");

		throw new NoSuchPontoDiaException(msg.toString());
	}

	/**
	 * Returns the first ponto dia in the ordered set where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ponto dia, or <code>null</code> if a matching ponto dia could not be found
	 */
	@Override
	public PontoDia fetchByFindByCompetencia_First(String Competencia,
		OrderByComparator<PontoDia> orderByComparator) {
		List<PontoDia> list = findByFindByCompetencia(Competencia, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ponto dia in the ordered set where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ponto dia
	 * @throws NoSuchPontoDiaException if a matching ponto dia could not be found
	 */
	@Override
	public PontoDia findByFindByCompetencia_Last(String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws NoSuchPontoDiaException {
		PontoDia pontoDia = fetchByFindByCompetencia_Last(Competencia,
				orderByComparator);

		if (pontoDia != null) {
			return pontoDia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Competencia=");
		msg.append(Competencia);

		msg.append("}");

		throw new NoSuchPontoDiaException(msg.toString());
	}

	/**
	 * Returns the last ponto dia in the ordered set where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ponto dia, or <code>null</code> if a matching ponto dia could not be found
	 */
	@Override
	public PontoDia fetchByFindByCompetencia_Last(String Competencia,
		OrderByComparator<PontoDia> orderByComparator) {
		int count = countByFindByCompetencia(Competencia);

		if (count == 0) {
			return null;
		}

		List<PontoDia> list = findByFindByCompetencia(Competencia, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PontoDia[] findByFindByCompetencia_PrevAndNext(
		PontoDiaPK pontoDiaPK, String Competencia,
		OrderByComparator<PontoDia> orderByComparator)
		throws NoSuchPontoDiaException {
		PontoDia pontoDia = findByPrimaryKey(pontoDiaPK);

		Session session = null;

		try {
			session = openSession();

			PontoDia[] array = new PontoDiaImpl[3];

			array[0] = getByFindByCompetencia_PrevAndNext(session, pontoDia,
					Competencia, orderByComparator, true);

			array[1] = pontoDia;

			array[2] = getByFindByCompetencia_PrevAndNext(session, pontoDia,
					Competencia, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PontoDia getByFindByCompetencia_PrevAndNext(Session session,
		PontoDia pontoDia, String Competencia,
		OrderByComparator<PontoDia> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PONTODIA_WHERE);

		boolean bindCompetencia = false;

		if (Competencia == null) {
			query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_1);
		}
		else if (Competencia.equals("")) {
			query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_3);
		}
		else {
			bindCompetencia = true;

			query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PontoDiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCompetencia) {
			qPos.add(Competencia);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pontoDia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PontoDia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ponto dias where Competencia = &#63; from the database.
	 *
	 * @param Competencia the competencia
	 */
	@Override
	public void removeByFindByCompetencia(String Competencia) {
		for (PontoDia pontoDia : findByFindByCompetencia(Competencia,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pontoDia);
		}
	}

	/**
	 * Returns the number of ponto dias where Competencia = &#63;.
	 *
	 * @param Competencia the competencia
	 * @return the number of matching ponto dias
	 */
	@Override
	public int countByFindByCompetencia(String Competencia) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYCOMPETENCIA;

		Object[] finderArgs = new Object[] { Competencia };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PONTODIA_WHERE);

			boolean bindCompetencia = false;

			if (Competencia == null) {
				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_1);
			}
			else if (Competencia.equals("")) {
				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_3);
			}
			else {
				bindCompetencia = true;

				query.append(_FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompetencia) {
					qPos.add(Competencia);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_1 = "pontoDia.Competencia IS NULL";
	private static final String _FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_2 = "pontoDia.Competencia = ?";
	private static final String _FINDER_COLUMN_FINDBYCOMPETENCIA_COMPETENCIA_3 = "(pontoDia.Competencia IS NULL OR pontoDia.Competencia = '')";

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

		if (!(pontoDia instanceof PontoDiaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pontoDia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pontoDia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pontoDia proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PontoDia implementation " +
				pontoDia.getClass());
		}

		PontoDiaModelImpl pontoDiaModelImpl = (PontoDiaModelImpl)pontoDia;

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

		if (!PontoDiaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { pontoDiaModelImpl.getCompetencia() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYCOMPETENCIA,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((pontoDiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pontoDiaModelImpl.getOriginalCompetencia()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYCOMPETENCIA,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA,
					args);

				args = new Object[] { pontoDiaModelImpl.getCompetencia() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYCOMPETENCIA,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPETENCIA,
					args);
			}
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
	private static final String _SQL_SELECT_PONTODIA_WHERE = "SELECT pontoDia FROM PontoDia pontoDia WHERE ";
	private static final String _SQL_COUNT_PONTODIA = "SELECT COUNT(pontoDia) FROM PontoDia pontoDia";
	private static final String _SQL_COUNT_PONTODIA_WHERE = "SELECT COUNT(pontoDia) FROM PontoDia pontoDia WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pontoDia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PontoDia exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PontoDia exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PontoDiaPersistenceImpl.class);
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(new String[] {
				"Pis", "Data"
			});
}