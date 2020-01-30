<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.changeRequestOwnership.title" /></title>

<%@include file="../common/includeCommonScripts.jsp"%>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin/changeRequestOwnership.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
</head>
<body>
<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
	    <h1 class="page-title span12"><s:text name="label.changeRequestOwnership.title" /></h1>
        <p class="span12 left clear dashdesc"><s:text name="label.changeRequestOwnership.content" /></p>
        <hr class="page-title-hr">
        <c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>	
		</c:if>
			
			<div class="form-mod">
			<s:form id="currentRequestorSearchForm">
			<div class="row">
					
			<c:if test="${empty requestorTrasactionsReply.currentRequestor.currentRequestorSso}">
				<c:set var="BusinessShowClass" value="display: none;"/>
			</c:if>
			<c:if test="${not empty requestorTrasactionsReply.currentRequestor.currentRequestorSso}">
				<s:set var="personNameSelected" value="%{'Yes'}"></s:set>
				<c:set var="BusinessShowClass" value="display: block;"/>
			</c:if>
			
			<div class="span12">
				<h2><s:text name="label.changeRequestOwnership.step1"/></h2><hr class="h2-hr">
	                <div class="row">
	                    <div class="span12">
	                    <div class="form-row">
	                    <br>
					<s:label key="label.changeRequestOwnership.currentRequestor"></s:label>
					<s:textfield name="requestorName" cssClass="span3 lookup-filterValue" id="requestorNameId" theme="aloc" 
					maxlength="50"/>
					<s:url action="RequestorDetailsLookup" namespace="/int" var="getRequestorDetailsURL" escapeAmp="false" encode="true">
						<s:param name="requestorType">currentRequestor</s:param> 
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getRequestorDetailsURL"/>" ><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="requestorSSOIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<br />
					<s:text name="label.changeRequestOwnership.lookupComment" />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="BusinessShow" style="${BusinessShowClass}">
			<s:hidden name="personNameSelection" id="personNameSelectionId" value="%{#personNameSelected}" cssClass="requiredField"/>
			<s:hidden id="personNameReqCount" value="%{#personNameSelected}"/>
			<div class="row">
			<div class="span7">
			<div class="row">
				<div class="span1">
								<div class="form-row">
									<s:label key="label.changeRequestOwnership.Name"/>
								</div>
							</div>
							<div class="span5 left">	
								<div class="form-row">
									<p><s:property value="requestorTrasactionsReply.currentRequestor.currentRequestorLastName"/>, <s:property value="requestorTrasactionsReply.currentRequestor.currentRequestorFirstName"/></p>
									<s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorLastName" id="currentRequestorLName"></s:hidden>
									<s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorFirstName" id="currentRequestorFName"></s:hidden>
								</div>
							</div>
					</div>
						<div class="row">
							<div class="span1">
								<div class="form-row">
									<s:label key="label.changeRequestOwnership.SSO"/>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p><s:property value="requestorTrasactionsReply.currentRequestor.currentRequestorSso"/></p>
									<s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorSso" id="currentRequestorSSO"></s:hidden>
								</div>
							</div>
						</div>
					</div>
					</div>
		</div>
			
			<div class="row">
            	<div class="span12">
			    	<div class="form-row">
                    	<label class="optional"><s:text name="label.changeRequestOwnership.businessSiteName"/></label>
						<sj:autocompleter id="businessSiteCodeId" list="businessSitesList" name="selBusinessSiteCd" 
						    cssClass="span3 businessSiteCode" listKey="ID" listValue="name" 
							theme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestorTrasactionsReply.requestorBusinessSite" id="businessSiteId" cssClass="autoCompleterName"></s:hidden>
			        </div>
			    </div> 
			</div> 
				
			<div class="row">
            	<div class="span12">
			    	<div class="form-row">
			    	    <s:url action="searchSelOwnerRequestDetails" namespace="/int/admin" var="searchSelOwnerRequestDetailsURL" escapeAmp="false" encode="true">
						</s:url>
                    	<a class="btn-secondary searchSelOwnerRequests" href="<s:property value="#searchSelOwnerRequestDetailsURL" />" >
								<s:text name="label.changeRequestOwnership.search"/>
						</a>
                    	<img alt="Loading..." id="searchSelOwnerRequestsIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none">
			        </div>
			   	</div>
			</div>
			<s:hidden name="errorShow" id="errorShowId"/>
			</s:form>
				
			<div class="searchSelOwnerRequestsDiv hide">
				<jsp:include page="selectNewRequestOwnership.jsp" />
			</div> 
		</div> 
       	</div>
	<div id="lookupDiv" style="width: 100%;">
	</div> 	
</div>	
	<%@include file="../common/footerSection.jsp"%>	
   </body>
</html>
	