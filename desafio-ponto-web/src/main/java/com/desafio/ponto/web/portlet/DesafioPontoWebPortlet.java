package com.desafio.ponto.web.portlet;

import com.desafio.ponto.service.RegistroPontoLocalServiceUtil;
import com.desafio.ponto.service.util.DateUtils;
import com.desafio.ponto.web.constants.DesafioPontoWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author peterson.v.de.morais
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Desafio Ponto",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DesafioPontoWebPortletKeys.DesafioPontoWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DesafioPontoWebPortlet extends MVCPortlet {
	
	
	@ProcessAction(name="doRegistrarPonto")
	public void doLogin(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long pis = ParamUtil.getLong(actionRequest, "pis");
		Date data = new Date();
		RegistroPontoLocalServiceUtil.registraPonto(companyId, pis, DateUtils.readableDateHour(data));
	}
}