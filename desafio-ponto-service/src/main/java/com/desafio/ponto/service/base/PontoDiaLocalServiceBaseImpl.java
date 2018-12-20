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

package com.desafio.ponto.service.base;

import aQute.bnd.annotation.ProviderType;

import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.service.PontoDiaLocalService;
import com.desafio.ponto.service.persistence.PontoDiaPK;
import com.desafio.ponto.service.persistence.PontoDiaPersistence;
import com.desafio.ponto.service.persistence.PontoMarcacoesPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ponto dia local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.desafio.ponto.service.impl.PontoDiaLocalServiceImpl}.
 * </p>
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.impl.PontoDiaLocalServiceImpl
 * @see com.desafio.ponto.service.PontoDiaLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class PontoDiaLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PontoDiaLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.desafio.ponto.service.PontoDiaLocalServiceUtil} to access the ponto dia local service.
	 */

	/**
	 * Adds the ponto dia to the database. Also notifies the appropriate model listeners.
	 *
	 * @param pontoDia the ponto dia
	 * @return the ponto dia that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PontoDia addPontoDia(PontoDia pontoDia) {
		pontoDia.setNew(true);

		return pontoDiaPersistence.update(pontoDia);
	}

	/**
	 * Creates a new ponto dia with the primary key. Does not add the ponto dia to the database.
	 *
	 * @param pontoDiaPK the primary key for the new ponto dia
	 * @return the new ponto dia
	 */
	@Override
	@Transactional(enabled = false)
	public PontoDia createPontoDia(PontoDiaPK pontoDiaPK) {
		return pontoDiaPersistence.create(pontoDiaPK);
	}

	/**
	 * Deletes the ponto dia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pontoDiaPK the primary key of the ponto dia
	 * @return the ponto dia that was removed
	 * @throws PortalException if a ponto dia with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PontoDia deletePontoDia(PontoDiaPK pontoDiaPK)
		throws PortalException {
		return pontoDiaPersistence.remove(pontoDiaPK);
	}

	/**
	 * Deletes the ponto dia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pontoDia the ponto dia
	 * @return the ponto dia that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PontoDia deletePontoDia(PontoDia pontoDia) {
		return pontoDiaPersistence.remove(pontoDia);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PontoDia.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return pontoDiaPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return pontoDiaPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return pontoDiaPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return pontoDiaPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return pontoDiaPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public PontoDia fetchPontoDia(PontoDiaPK pontoDiaPK) {
		return pontoDiaPersistence.fetchByPrimaryKey(pontoDiaPK);
	}

	/**
	 * Returns the ponto dia with the primary key.
	 *
	 * @param pontoDiaPK the primary key of the ponto dia
	 * @return the ponto dia
	 * @throws PortalException if a ponto dia with the primary key could not be found
	 */
	@Override
	public PontoDia getPontoDia(PontoDiaPK pontoDiaPK)
		throws PortalException {
		return pontoDiaPersistence.findByPrimaryKey(pontoDiaPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(pontoDiaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PontoDia.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.Pis");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(pontoDiaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PontoDia.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.Pis");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(pontoDiaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PontoDia.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.Pis");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return pontoDiaLocalService.deletePontoDia((PontoDia)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return pontoDiaPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<PontoDia> getPontoDias(int start, int end) {
		return pontoDiaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ponto dias.
	 *
	 * @return the number of ponto dias
	 */
	@Override
	public int getPontoDiasCount() {
		return pontoDiaPersistence.countAll();
	}

	/**
	 * Updates the ponto dia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param pontoDia the ponto dia
	 * @return the ponto dia that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PontoDia updatePontoDia(PontoDia pontoDia) {
		return pontoDiaPersistence.update(pontoDia);
	}

	/**
	 * Returns the ponto dia local service.
	 *
	 * @return the ponto dia local service
	 */
	public PontoDiaLocalService getPontoDiaLocalService() {
		return pontoDiaLocalService;
	}

	/**
	 * Sets the ponto dia local service.
	 *
	 * @param pontoDiaLocalService the ponto dia local service
	 */
	public void setPontoDiaLocalService(
		PontoDiaLocalService pontoDiaLocalService) {
		this.pontoDiaLocalService = pontoDiaLocalService;
	}

	/**
	 * Returns the ponto dia persistence.
	 *
	 * @return the ponto dia persistence
	 */
	public PontoDiaPersistence getPontoDiaPersistence() {
		return pontoDiaPersistence;
	}

	/**
	 * Sets the ponto dia persistence.
	 *
	 * @param pontoDiaPersistence the ponto dia persistence
	 */
	public void setPontoDiaPersistence(PontoDiaPersistence pontoDiaPersistence) {
		this.pontoDiaPersistence = pontoDiaPersistence;
	}

	/**
	 * Returns the ponto eletronico local service.
	 *
	 * @return the ponto eletronico local service
	 */
	public com.desafio.ponto.service.PontoEletronicoLocalService getPontoEletronicoLocalService() {
		return pontoEletronicoLocalService;
	}

	/**
	 * Sets the ponto eletronico local service.
	 *
	 * @param pontoEletronicoLocalService the ponto eletronico local service
	 */
	public void setPontoEletronicoLocalService(
		com.desafio.ponto.service.PontoEletronicoLocalService pontoEletronicoLocalService) {
		this.pontoEletronicoLocalService = pontoEletronicoLocalService;
	}

	/**
	 * Returns the ponto marcacoes local service.
	 *
	 * @return the ponto marcacoes local service
	 */
	public com.desafio.ponto.service.PontoMarcacoesLocalService getPontoMarcacoesLocalService() {
		return pontoMarcacoesLocalService;
	}

	/**
	 * Sets the ponto marcacoes local service.
	 *
	 * @param pontoMarcacoesLocalService the ponto marcacoes local service
	 */
	public void setPontoMarcacoesLocalService(
		com.desafio.ponto.service.PontoMarcacoesLocalService pontoMarcacoesLocalService) {
		this.pontoMarcacoesLocalService = pontoMarcacoesLocalService;
	}

	/**
	 * Returns the ponto marcacoes persistence.
	 *
	 * @return the ponto marcacoes persistence
	 */
	public PontoMarcacoesPersistence getPontoMarcacoesPersistence() {
		return pontoMarcacoesPersistence;
	}

	/**
	 * Sets the ponto marcacoes persistence.
	 *
	 * @param pontoMarcacoesPersistence the ponto marcacoes persistence
	 */
	public void setPontoMarcacoesPersistence(
		PontoMarcacoesPersistence pontoMarcacoesPersistence) {
		this.pontoMarcacoesPersistence = pontoMarcacoesPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.desafio.ponto.model.PontoDia",
			pontoDiaLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.desafio.ponto.model.PontoDia");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PontoDiaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PontoDia.class;
	}

	protected String getModelClassName() {
		return PontoDia.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = pontoDiaPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PontoDiaLocalService.class)
	protected PontoDiaLocalService pontoDiaLocalService;
	@BeanReference(type = PontoDiaPersistence.class)
	protected PontoDiaPersistence pontoDiaPersistence;
	@BeanReference(type = com.desafio.ponto.service.PontoEletronicoLocalService.class)
	protected com.desafio.ponto.service.PontoEletronicoLocalService pontoEletronicoLocalService;
	@BeanReference(type = com.desafio.ponto.service.PontoMarcacoesLocalService.class)
	protected com.desafio.ponto.service.PontoMarcacoesLocalService pontoMarcacoesLocalService;
	@BeanReference(type = PontoMarcacoesPersistence.class)
	protected PontoMarcacoesPersistence pontoMarcacoesPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}