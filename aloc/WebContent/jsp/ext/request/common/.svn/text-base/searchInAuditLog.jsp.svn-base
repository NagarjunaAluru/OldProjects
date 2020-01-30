<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<div class="row">
	           	  <s:form name="searchForm" id="searchActionForm" action="auditandActionSearch" namespace="/ext/approver">
	           	    <s:hidden id="logType" name="logType" value="audit" />
	           	    <s:hidden id="requestId" name="requestId" value="%{requestDetails.requestId}" />
	           	    <s:hidden id="stageName" name="stageName" value="%{requestDetails.WFDetails.WFStage}" />
	           	    <c:if test="${not empty taxonomyViewType}">
		              <s:hidden name="dashboardViewType" value="ALLREQUESTS" />
		              <s:hidden name="taxonomyViewType" value="%{taxonomyViewType}" />
	           		</c:if>
	           	     <div class="span2">
	           	        <label><s:text name="label.request.transactionHistoryLog.tableHeader.1"/></label>
							 <s:textfield name="fromDate" id="fromDate" cssClass="date startDate"/>
							<p><s:text name="label.request.searchDateFormat"/></p>
						</div>
	           	        <div class="span1">
			             	<label>&nbsp;</label>
							to
						</div>
								    
					    <div class="span2">
							<label>&nbsp;</label>
							 <s:textfield name="toDate" id="toDate" cssClass="date startDate"/>
							<p><s:text name="label.request.searchDateFormat"/></p>
						</div>
						<div class="span2">
							 <label><s:text name="label.request.auditLog.tableHeader.4"/></label>
							<s:select id="searchCriteriaValue" list="requestDetails.drawDownValues.attributeChangeds" headerKey="-1" headerValue="All attributes"
									name="searchCriteriaValue" cssStyle="width: 130px;"/>
						</div>
						 <div class="span3">
						 	<label><s:text name="label.request.auditLog.tableHeader.8"/></label>
				 			<sj:autocompleter  id="searchCriteriaText" name="searchCriteriaText" list="requestDetails.drawDownValues.actionTakenBies" listKey="ssoId" listValue="firstName+' '+lastName"/>
						</div>
						<s:url action="auditandActionSearch.action" var="actionSearchURL" namespace="/ext/approver" encode="true" escapeAmp="false"/>
						 <div class="span1">
						    <label>&nbsp;</label>
							<a style="margin-left:10px;" class="btn-secondary lookupAction conditional-btn" href="<s:property value="#actionSearchURL" />">
									<s:text name="label.dashboard.search"/>
							</a>
					    </div>	  
						 <div class="span1">
						      <label>&nbsp;</label>
							<img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" 
									style="height: 20px; display:none">		
						 </div>        
				</s:form>
				<%--  <sj:submit formIds="searchForm" value="Search" cssClass="btn" style="margin-left:10px;" /> --%>
</div>
<script src="${pageContext.request.contextPath}/ext/public/js/requestor/auditLog.js" type="text/javascript"></script>	          
	  
			
	