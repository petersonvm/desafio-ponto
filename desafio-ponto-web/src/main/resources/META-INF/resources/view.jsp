<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%>

<%
// To set today's date as default for the calendar.
	Calendar today = Calendar.getInstance();
%>

<portlet:actionURL name="doRegistrarPonto" var="doRegistrarPontoURL" />

<p>
	<b><liferay-ui:message key="desafiopontoweb.caption" /></b>
</p>



<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn()%>">

		<aui:form action="<%=doRegistrarPontoURL%>" method="post"
			name="pontoform">
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>

					<aui:col>
							<aui:row> 
								<liferay-ui:message key="desafiopontoweb.funcionario" /><%=user.getFullName()%>
							</aui:row>
							<aui:row> 
								<liferay-ui:message key="desafiopontoweb.pis" /><%=user.getExpandoBridge().getAttribute("Pis")%>
							</aui:row>
					</aui:col>
					<br>
					<aui:button name="registarPonto" value="desafiopontoweb.submit" type="submit" />
					<aui:input name="pis" required="true" value="<%=user.getExpandoBridge().getAttribute("Pis")%>" type="hidden"></aui:input>
				</aui:fieldset>
			</aui:fieldset-group>
		</aui:form>
		
		
		<p>
			<b><liferay-ui:message key="desafiopontoweb.lista.marcacoes" /></b>
		</p>

		<aui:col>
			<aui:row> 
				<liferay-ui:input-date name="dataPesquisa"
				 dayValue="<%= today.get(Calendar.DAY_OF_MONTH) %>" dayParam="dtDay"
        		 monthValue="<%= today.get(Calendar.MONTH) %>" monthParam="dtMonth"
        		 yearValue="<%= today.get(Calendar.YEAR) %>" yearParam="dtYear" />
				 <aui:button name="btPesquisar" value="Pesquisar" onClick="pesquisar();" />
			</aui:row>
		</aui:col>
		<br>
		<div class="resultado">
		</div>
			
	</c:when>
	<c:otherwise>
		Voce precisa estar logado.
	</c:otherwise>
</c:choose>

<script> 
	function pesquisar(){
		var data = formatDatePattern($('#<portlet:namespace/>dataPesquisa').val());
		var pis = $('#<portlet:namespace/>pis').val();
		Liferay.Service(
				  '/desafioponto.registroponto/consultar-ponto',
				  {
				    companyId: themeDisplay.getCompanyId(),
				    pis: pis,
				    competencia: data
				  },
				  function(obj) {
					  popularGrid(obj);
				  }
				);

	}
	
	function popularGrid(result){
		$('.resultado').empty();
		$('.resultado').append('<p><b><liferay-ui:message key="desafiopontoweb.lista.competencia" /></b>'+result.Competencia+'</p>');
		$('.resultado').append('<b><liferay-ui:message key="desafiopontoweb.lista.marcacoes" /></b><br/>');
		for (var mc in result.Marcacoes) {
		     var marcacao = result.Marcacoes[mc];
		     $('.resultado').append('<b><liferay-ui:message key="desafiopontoweb.lista.data" /></b>'+marcacao.Data+'<br/>');
		     $('.resultado').append('<b><liferay-ui:message key="desafiopontoweb.lista.status" /></b>'+marcacao.Status+'<br/>');
		     $('.resultado').append('<b><liferay-ui:message key="desafiopontoweb.lista.batidas" /></b><br/>');
		     var batidas = result.Marcacoes[mc].Batidas;
		     $('.resultado').append('<p>');
		     for (var bt in batidas) {
		    	 var batida = batidas[bt];
		    	 $('.resultado').append('<li>'+batida+'</li>');
		     }
		     $('.resultado').append('</p>');
		     $('.resultado').append('<b><liferay-ui:message key="desafiopontoweb.lista.horas"/></b>'+Math.round(marcacao.HorasTrabalhadas)+'<br/>');
		}
		$('.resultado').append('<p><b><liferay-ui:message key="desafiopontoweb.lista.horastrabalhadas"/></b>'+Math.round(result.TotalHorasTrabalhadas)+'</p><br><br>');

	}
	
    function formatDatePattern(dt){

        var dtVal = dt.split("/");
        var dateSwitched;
        if (Liferay.ThemeDisplay.getLanguageId() === 'en_US'){
          dateSwitched = dtVal[0] + "/" + dtVal[2];
        }else{
          dateSwitched = dtVal[1] + "/" + dtVal[2];
        }


        return dateSwitched;
    }

</script>