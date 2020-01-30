<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	
		<td>--</td>
		<td><s:radio theme="aloc" cssClass="radio suretyStatus"
				list="#{'true':'Enabled','false':'Disabled'}" id="suretyStatusId"
	      		name="suretyList.suretyMasters[%{#parameters['curIndex']}].suretyStatus"/>
	   	<div style="color: red;">
	      	<s:fielderror fieldName="suretyMaster.suretyStatus"></s:fielderror>
	    </div>
	    </td>
				
		<td><s:textarea cssClass="autosize1 messageinput suretyName" theme="aloc" name="suretyList.suretyMasters[%{#parameters['curIndex']}].suretyName" 
			   onKeyPress="return imposeMaxLength(this, 99);"></s:textarea>
			    <div class="clear"></div>
                <div class="counter"><s:property value="%{suretyNameLength}"/></div> <!-- fix positions -->
                <div class="counterTxt"><p class="guidance"><s:text name="label.reimbursementAgreementManagement.charleft" /></p></div>
				<div class="clear"></div>

		<div style="color: red;">
			<s:fielderror fieldName="suretyMaster.suretyName"></s:fielderror>
		</div>								
		</td>
		<td class="hide">
			<s:textfield name="suretyList.suretyMasters[%{#parameters['curIndex']}].suretyId" 
					cssClass="suretyId"/>
		</td>	
		<td class="hide">
			<s:textfield name="%{#parameters['curIndex']}" 
					cssClass="curIndex"/>
		</td>
		<td class="hide suretyErrorId"> <s:property value="%{errorSurety}"/></td>
		<script src="${pageContext.request.contextPath}/js/admin/suretyNameMgmt.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/common/site.js" type="text/javascript"></script>
							