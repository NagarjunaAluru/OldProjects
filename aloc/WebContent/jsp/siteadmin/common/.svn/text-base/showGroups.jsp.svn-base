<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

		 <s:hidden value="%{siteAdmin.delegationConfiguration.comments}" id="createGrpSuccess"></s:hidden>
		<s:url action="deleteGroup" id="deleteGroup" />
         <div class="form-row">&nbsp;</div>
		 		<div class="span12">
				                	<label><s:text name="label.siteAdmin.groupNames" /> </label>
				                    
				                     <s:if test="%{siteAdmin == null || siteAdmin.delegationConfiguration == null || siteAdmin.delegationConfiguration.approvalGroupConfiguration == null}">
	                                	<s:select list="#{}" 
	                                		listKey="groupId" 
											listValue="groupName" 
											id="selectedGroupName" 
											name="delegates"
											headerKey=""
											headerValue="Select..."
											cssClass="selectedGroupName"
										/> 
	                                </s:if>
	                                <s:else>
	                                	<s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}"
											listKey="groupId" 
											listValue="groupName" 
											id="selectedGroupName" 
											name="delegates"
											headerKey=""
											headerValue="Select..."
											cssClass="selectedGroupName"
											onchange="getApprovers();"
										/> 
	                                </s:else>&nbsp;&nbsp;&nbsp;
	                                <sj:a href="%{deleteGroup}" formIds="createDelegateConfigForm" onBeforeTopics="deleteGroupValCheck" 
										onCompleteTopics="afterGroupDeletion" targets="delegationSection" replaceTarget="true" cssClass="btn-primary" 
			                    		indicator="groupProcess">
			                    		<s:text name="label.siteAdmin.deleteGroup" />
			                    	</sj:a> &nbsp;&nbsp;
			                    	 <img alt="Loading..." id="groupProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                                
				</div>
				
