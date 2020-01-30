<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	
		<td>--</td>
		<td><s:radio theme="aloc" cssClass="radio poleStatus" id="poleStatusId"
				list="#{'Enabled':'Enabled','Disabled':'Disabled'}"
	      		name="poleNameManagements[%{#parameters['poleId']}].poleStatus"/>
	      	<div style="color: red;">
	      		<s:fielderror fieldName="poleNameMgmt.poleStatus"></s:fielderror>
	    	</div>
	    </td>
		<td>
			<div style="color: red;">
	      		<s:fielderror fieldName="poleNameMgmt.poleName"></s:fielderror>
	    	</div>
			<s:textfield name="poleNameManagements[%{#parameters['poleId']}].poleName" theme="aloc"
					maxlength="100" cssClass="poleName" />
			<div style="height:10px;"></div>
	    	<div style="color: red;">
	      		<s:fielderror fieldName="selectedCountriesCodes"></s:fielderror>
	    	</div>	
	    	<div style="color: red;">
	      		<s:actionerror></s:actionerror>
	    	</div>		
			<dl>
				<dt></dt>
				<dd>
					<s:select id="countries%{#parameters['curIndex']}"
						list="availableCountries"
						listKey="key" listValue="value"
						name="selectedCountries"
						multiple="true" cssClass="multi0select" />
				</dd>
			</dl>								
		</td>
		<td class="hide">
			<s:textfield name="%{#parameters['poleId']}" cssClass="poleId"/>
		</td>	
		<td class="hide poleErrorId"> <s:property value="%{errorPole}"/></td>
		<td class="hide">
			<s:textfield name="%{#parameters['curIndex']}" 
					cssClass="curIndex"/>
		</td>
		<script src="${pageContext.request.contextPath}/js/admin/poleNameMgmt.js" type="text/javascript"></script>
							