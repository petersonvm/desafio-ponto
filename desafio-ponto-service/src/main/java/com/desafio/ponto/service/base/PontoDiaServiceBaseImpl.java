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

import com.desafio.ponto.model.PontoDia;
import com.desafio.ponto.service.PontoDiaService;
import com.desafio.ponto.service.persistence.PontoDiaPersistence;
import com.desafio.ponto.service.persistence.PontoMarcacoesPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ponto dia remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.desafio.ponto.service.impl.PontoDiaServiceImpl}.
 * </p>
 *
 * @author Peterson Morais
 * @see com.desafio.ponto.service.impl.PontoDiaServiceImpl
 * @see com.desafio.ponto.service.PontoDiaServiceUtil
 * @generated
 */
public abstract class PontoDiaServiceBaseImpl extends BaseServiceImpl
	implements PontoDiaService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.desafio.ponto.service.PontoDiaServiceUtil} to access the ponto dia remote service.
	 */

	/**
	 * Returns the ponto dia local service.
	 *
	 * @return the ponto dia local service
	 */
	public com.desafio.ponto.service.PontoDiaLocalService getPontoDiaLocalService() {
		return pontoDiaLocalService;
	}

	/**
	 * Sets the ponto dia local service.
	 *
	 * @param pontoDiaLocalService the ponto dia local service
	 */
	public void setPontoDiaLocalService(
		com.desafio.ponto.service.PontoDiaLocalService pontoDiaLocalService) {
		this.pontoDiaLocalService = pontoDiaLocalService;
	}

	/**
	 * Returns the ponto dia remote service.
	 *
	 * @return the ponto dia remote service
	 */
	public PontoDiaService getPontoDiaService() {
		return pontoDiaService;
	}

	/**
	 * Sets the ponto dia remote service.
	 *
	 * @param pontoDiaService the ponto dia remote service
	 */
	public void setPontoDiaService(PontoDiaService pontoDiaService) {
		this.pontoDiaService = pontoDiaService;
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
	 * Returns the ponto eletronico remote service.
	 *
	 * @return the ponto eletronico remote service
	 */
	public com.desafio.ponto.service.PontoEletronicoService getPontoEletronicoService() {
		return pontoEletronicoService;
	}

	/**
	 * Sets the ponto eletronico remote service.
	 *
	 * @param pontoEletronicoService the ponto eletronico remote service
	 */
	public void setPontoEletronicoService(
		com.desafio.ponto.service.PontoEletronicoService pontoEletronicoService) {
		this.pontoEletronicoService = pontoEletronicoService;
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
	 * Returns the ponto marcacoes remote service.
	 *
	 * @return the ponto marcacoes remote service
	 */
	public com.desafio.ponto.service.PontoMarcacoesService getPontoMarcacoesService() {
		return pontoMarcacoesService;
	}

	/**
	 * Sets the ponto marcacoes remote service.
	 *
	 * @param pontoMarcacoesService the ponto marcacoes remote service
	 */
	public void setPontoMarcacoesService(
		com.desafio.ponto.service.PontoMarcacoesService pontoMarcacoesService) {
		this.pontoMarcacoesService = pontoMarcacoesService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PontoDiaService.class.getName();
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

	@BeanReference(type = com.desafio.ponto.service.PontoDiaLocalService.class)
	protected com.desafio.ponto.service.PontoDiaLocalService pontoDiaLocalService;
	@BeanReference(type = PontoDiaService.class)
	protected PontoDiaService pontoDiaService;
	@BeanReference(type = PontoDiaPersistence.class)
	protected PontoDiaPersistence pontoDiaPersistence;
	@BeanReference(type = com.desafio.ponto.service.PontoEletronicoLocalService.class)
	protected com.desafio.ponto.service.PontoEletronicoLocalService pontoEletronicoLocalService;
	@BeanReference(type = com.desafio.ponto.service.PontoEletronicoService.class)
	protected com.desafio.ponto.service.PontoEletronicoService pontoEletronicoService;
	@BeanReference(type = com.desafio.ponto.service.PontoMarcacoesLocalService.class)
	protected com.desafio.ponto.service.PontoMarcacoesLocalService pontoMarcacoesLocalService;
	@BeanReference(type = com.desafio.ponto.service.PontoMarcacoesService.class)
	protected com.desafio.ponto.service.PontoMarcacoesService pontoMarcacoesService;
	@BeanReference(type = PontoMarcacoesPersistence.class)
	protected PontoMarcacoesPersistence pontoMarcacoesPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}