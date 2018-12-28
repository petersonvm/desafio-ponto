package com.desafio.ponto.test;

import com.desafio.ponto.model.custom.RegistroPonto;
import com.desafio.ponto.service.RegistroPontoLocalServiceUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RegistroPontoServiceTest extends TestCase {

	private String dia = "26/12/2018";
	private long companyId = 20099;
	private long pis = 1234567890;
	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();	
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test 
	public void testCompetencia()throws Exception{
		RegistroPonto ponto = RegistroPontoLocalServiceUtil.consultarPonto(companyId, pis, dia);
		assertEquals("12/2018", ponto.getCompetencia());
	}
	
}
