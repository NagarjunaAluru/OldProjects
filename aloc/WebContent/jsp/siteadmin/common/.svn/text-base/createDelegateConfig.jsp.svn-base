<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	
	<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
			onloadDelegateConfigRowEach();
			decimalAmountZero();
		</script>
	</c:if>
	
	<p class="required-fields fifth"><s:text  name="label.common.siteAdmin.allFieldsAreRequired"/></p>
	
	<div id="siteMsg" style="margin-top:0px!important;" class="hide groupUpdate-success">
		<div class="sucessMsg">
	    	<a href="javascript:;" class="right successclose" style="font-size: 20px; margin-right:5px;">X</a><s:text name="label.treasuryAdminPortal.success" />
		</div>
	    <div class="sucessContent"><span class="delegateSuccess"></span></div>
	</div>
	
	<div class="row hide groupName-invalid" style="margin-top:0px!important;">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead">
					<p class="erroricon"><s:text name="label.eas.common.error" /></p>
					<a href="javascript:;" class="right failureClose" style="font-size: 20px; margin-right:10px; margin-top: -25px;">X</a>
				</div>
				<div class="errorContent">
					<p>
						<span class="groupInvalid"></span>
					</p>
				</div>
			</div>
		</div>
	</div>
            
    <div class="form-row form-mod">
		<div class="row">
			<div class="span12">                
				<h3><s:text  name="label.siteAdmin.approvalGroupConfiguration"/></h3>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="groupName" key="Group Name" theme="aloc" maxlength="40" id="saveGroup"/> &nbsp;
					<s:url action="createGroup" id="createGroup" />
						<sj:a href="%{createGroup}" formIds="createDelegateConfigForm" onBeforeTopics="saveGroupValCheck" 
							onCompleteTopics="afterSaveGroup" targets="showGroups" replaceTarget="true" cssClass="btn-primary" 
                    		indicator="processDelegation">
                    		<s:text  name="label.siteAdmin.saveGroup"/>
                    	</sj:a>
						<img alt="Loading..." id="processDelegation" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 25px;width: 25px;"><br/>
						<span class="groupName-error hide" style="color: #AE2C2C;"></span>
						
						<div class="row"></div>
						<div class="row" id="showGroups">
							<jsp:include page="/jsp/siteadmin/common/showGroups.jsp" />
						</div>
			            <span class="approverAdd-error hide" style="color: #AE2C2C;"></span>
			            <span class="approverRemove-error hide" style="color: #AE2C2C;"></span>
			            <span class="groupRemove-error hide" style="color: #AE2C2C;"></span>
			            
			            <div class="row curDelErrorDiv hide">
							<div class="span12">
								<div class="errorbox">
									<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
										<div class="errorContent">
										<p><span class="curDelError"></span></p>
										</div>
								</div>
							</div>
						</div>
			            
			            <%-- <span class="curDelError hide" style="color: #AE2C2C;"></span> --%>
			            <s:hidden name="siteOrBusinessSite" value="site" />
						<div id="SelectedApp"></div>
                
						<div class="row" id="saveApprovers">
							<div class="span12">                
								<a href="javascript:;" class="btn-primary left saveDelApprovers"><s:text  name="label.common.siteAdmin.save"/></a>
								<img alt="Loading..." id="saveProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">       
							</div>
						</div>
				</div>                
		</div>                
	</div>                
	 <s:if test="fieldErrors.size > 0">
	<s:hidden name="delegationErrors" id="delegationErrors" value="available"/>
	</s:if>
	 <s:if test="fieldErrors.size == 0">
	<s:hidden name="delegationErrors" id="delegationErrors"/>
	</s:if>
	<%-- <div style="color: #AE2C2C;">
		<s:fielderror></s:fielderror>
	</div>
	 --%>
	 <s:if test="hasActionErrors()">
		<div class="row">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">
							<s:text name="label.eas.common.error" />
						</p>
					</div>
					<div class="errorContent">
						<p>
							<s:actionerror/>
						</p>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	            
	<jsp:include page="/jsp/siteadmin/common/siteDelegateConfig.jsp">
		<jsp:param name="includeScripts" value="false" />
	</jsp:include>