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
    
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.fxRateHistory" /></title>
	<script src="${pageContext.request.contextPath}/ext/public/js/others/jquery-zyear.js" type="text/javascript"></script>
</head>

<body>
	
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<div id="mainPage"><h1 class="page-title span12"><s:text name="label.request.fxRateHistory"/></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.apmFXRateHistoryAndCurrency"/> </p>
        <hr class="page-title-hr">
   <div class="clear"></div>
   
   <div class="form-mod">
   
        		<c:set var="myFXClass" value="active"></c:set>
        		<c:set var="myFXTab" value="active in"></c:set>
   		
   		<s:url action="getYearlist.action" namespace="/ext/apm" var="apmFXRateHistoryURL"/> 
      
		<ul class="nav nav-tabs tabs span12" >
			<li class="${myFXClass}"><a href="<s:property value="apmFXRateHistoryURL"/>"><s:text name="label.request.fxRateHistory"/> </a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div id="11" class="tab-pane fade ${myFXTab}">
				<jsp:include page="/jsp/ext/apm/fxRateHistory.jsp" />
			</div>
		</div>
	</div>
			
			
</div>	
</div>
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
</body>
</html>