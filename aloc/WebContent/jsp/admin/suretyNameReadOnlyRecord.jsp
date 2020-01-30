<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

		<td><img class="actionImg editSuretyName" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="%{#parameters['curIndex']}"/>">
		<img alt="Loading..." class="editSuretyProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">			
		</td>
		<td>
			<s:if test="%{suretyMaster.suretyStatus}">
        		<s:text name="label.suretynamemgmt.enabled" />
        	</s:if>
        	<s:else>
        		<s:text name="label.suretynamemgmt.disabled" />
        	</s:else>
		<td class="suretyName" style="word-wrap: break-word;">
		<div style="width: 600px; overflow: auto;"><s:property value="suretyMaster.suretyName"/></div></td>
			
		<td class="suretyId hide">
				<s:property value="suretyMaster.suretyId"/>
		</td>
		
		<td class="hide"><s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
		<td class="hide suretyErrorId"> <s:property value="%{errorSurety}"/></td>
								
		<script src="${pageContext.request.contextPath}/js/admin/suretyNameMgmt.js" type="text/javascript"></script>