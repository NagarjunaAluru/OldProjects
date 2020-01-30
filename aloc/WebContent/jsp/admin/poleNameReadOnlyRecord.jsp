<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<td><img class="actionImg editPoleName" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="%{#parameters['curIndex']}"/>_<s:property value="poleNameMgmt.poleId" />">
			<img alt="Loading..." class="editPoleProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">			
		</td>
		<td class="poleStatus">
			 <s:property value="poleNameMgmt.poleStatus"/>
	    </td>
		<td class="poleName">
			<s:property value="poleNameMgmt.poleName"/>
		</td>	
				
		<td class="poleId hide">
				<s:text name="poleNameMgmt.poleId"/>
		</td>		
		<td class="hide"><s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
		<td class="hide poleErrorId"> <s:property value="%{errorPole}"/></td>
								
		<script src="${pageContext.request.contextPath}/js/admin/poleNameMgmt.js" type="text/javascript"></script>