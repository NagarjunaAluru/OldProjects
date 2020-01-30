<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="/jsp/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.fxRateHistory"/>
		<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
		 <s:text name="label.request.and"/> <s:text name="label.request.currencySetup"/>
		</hwfs:checkComponentPermission></title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/others/jquery-zyear.js" type="text/javascript"></script>
	
</head>

<body>
	
	<div class="container main">
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<h1 class="page-title span12"><s:text name="label.request.fxRateHistory"/>
		<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
		 <s:text name="label.request.and"/> <s:text name="label.request.currencySetup"/>
		</hwfs:checkComponentPermission>
		</h1>
		<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.apmFXRateHistoryAndCurrency"/> </p>
        <hr class="page-title-hr">
   <div class="clear"></div>
   
   <div class="form-mod">
   
   		<c:choose>
        	<c:when test="${fxRateViewType eq 'FXRATEHISTORY'}">
        		<c:set var="myFXClass" value="active"></c:set>
        		<c:set var="myFXTab" value="active in"></c:set>
        	</c:when>
        	<c:when test="${fxRateViewType eq 'CURRENCYSETUP'}">
        		<c:set var="myCurrencyClass" value="active"></c:set>
        		<c:set var="myCurrencyTab" value="active in"></c:set>
        	</c:when>
        </c:choose>
   		
   		<s:url action="getCurrencySetUpDetails.action" namespace="/int/apm"	var="currencySetupURL" />
   		<s:url action="getYearlist.action" namespace="/int/apm" var="apmFXRateHistoryURL"/> 
      
		<ul class="nav nav-tabs tabs span12" >
			<li class="${myFXClass}"><a href="<s:property value="apmFXRateHistoryURL"/>"><s:text name="label.request.fxRateHistory"/> </a></li>
			<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
			<li class="${myCurrencyClass}"><a href="<s:property value="currencySetupURL" />"><s:text name="label.request.currencySetup"/></a></li>
			</hwfs:checkComponentPermission>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div id="11" class="tab-pane fade ${myFXTab}">
				<jsp:include page="/jsp/common/request/apm/fxRateHistory.jsp" />
			</div>
			<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
			<div id="22" class="tab-pane fade ${myCurrencyTab} currencySetupCls">
				<jsp:include page="/jsp/common/request/apm/currencySetup.jsp" />
			</div>
			</hwfs:checkComponentPermission>
		</div>
	</div>
			
</div>	
</div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
	
	
</body>
</html>