<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<p class="required-fields third"><s:text name="label.common.siteAdmin.allFieldsAreRequired" /></p>
<s:if test="hasActionMessages()">
	<div id="siteMsg" style="margin-top:0px!important;">
		<div class="sucessMsg">
	    	<a href="javascript:;" class="right successclose" style="font-size: 20px; margin-right:5px;">X</a><s:text name="label.treasuryAdminPortal.success" />
		</div>
	    <div class="sucessContent"><s:actionmessage/></div>
	</div>
</s:if>  
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield key="label.siteAdmin.customSiteField" required="false" name="siteAdmin.customizedSiteReferences.siteCustoms[0]" theme="aloc" maxlength="100"/>
				<div class="form-row">
					<s:checkbox name="siteAdmin.customizedSiteReferences.siteRequiredFlag" style="margin-top: 5px;" theme="aloc-TransactionParties" cssClass="checkbox" id="requestCheck" />  <s:label key="label.siteAdmin.makeThisARequiredField"/>
                </div>	
				<s:if test="((siteAdmin.customizedSiteReferences != null && siteAdmin.customizedSiteReferences.siteCustoms.size > 1) || (customFieldAddIndex == 1))">
					<s:url action="removeCustomField" id="removeCustomField1">
						<s:param name="customFieldRemoveIndex" value="1" />
					</s:url>
					<s:textfield key="label.siteAdmin.customSiteField" label="Custom Site Field 2" required="false" name="siteAdmin.customizedSiteReferences.siteCustoms[1]" theme="aloc" maxlength="100"/> 
					&nbsp;<sj:a href="%{removeCustomField1}" indicator="removeCustomProcess" formIds="customizedSiteForm" onBeforeTopics="ignoreParentSites" targets="customizedSiteSection" replaceTarget="true"><s:text name="label.siteAdmin.removeSiteCustom" /></sj:a>
					<img alt="Loading..." id="removeCustomProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:if>
                    	
				<s:if test="((siteAdmin.customizedSiteReferences != null && siteAdmin.customizedSiteReferences.siteCustoms.size > 2) || customFieldAddIndex == 2)">
					<s:url action="removeCustomField" id="removeCustomField2">
						<s:param name="customFieldRemoveIndex" value="2" />
					</s:url>
					<s:textfield key="label.siteAdmin.customSiteFieldThree" required="false" name="siteAdmin.customizedSiteReferences.siteCustoms[2]" theme="aloc" maxlength="100"/> 
					&nbsp;<sj:a href="%{removeCustomField2}" indicator="removeCustom1Process" formIds="customizedSiteForm" onBeforeTopics="ignoreParentSites" targets="customizedSiteSection" replaceTarget="true"><s:text name="label.siteAdmin.removeSiteCustom" /></sj:a>
					<img alt="Loading..." id="removeCustom1Process" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:if>
						
				<s:if test="((customFieldAddIndex == null || customFieldAddIndex < 2) && (siteAdmin.customizedSiteReferences == null || siteAdmin.customizedSiteReferences.siteCustoms.size < 3))">
						<div style="height:8px;"></div>			
						<s:url action="addCustomField" id="addAdditionalField" />
						<sj:a href="%{addAdditionalField}" onBeforeTopics="ignoreParentSites" indicator="addAdditionalProcess" formIds="customizedSiteForm" targets="customizedSiteSection" replaceTarget="true" cssClass="add-custom"><s:text  name="label.siteAdmin.addAdditionalSiteCustom"/></sj:a>
						<img alt="Loading..." id="addAdditionalProcess" align="absmiddle" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:if>
			</div>
		</div><!-- end of block -->
	</div>
	<s:hidden name="ignoreParentSites" value="%{ignoreParentSites}" cssClass="ignoreParentSites"/>
