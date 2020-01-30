<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    
		<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
		<title><s:text name="label.request.feeHistory" /></title>
		<script src="${pageContext.request.contextPath}/ext/public/js/ext/apm.js" type="text/javascript"></script>
		<style type="text/css">
			h1 { color:#666!important; font-size:26px!important; font-weight:bold!important;}
		</style>
	</head>

	<body>
	<div class="container main">
		
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
	
		<h1 class="page-title span12"><s:text name="label.request.feeHistory" /> </h1>
		<p class="span12 left clear dashdesc"><s:label key="label.request.reviewPreviouslyPaidFees" /> </p>
		<hr class="page-title-hr">
		<jsp:include page="basicSearchInFeeHistory.jsp" />
		
		<div class="row">
				<div class="span4 right">
					Default view:&nbsp;&nbsp;
					<select id="defViewType">
						<option value="topLevel">Top Level Summary</option>
						<option value="domestic">Top Level + Domestic</option>
						<option value="foreign">Top Level + Foreign</option>
						<option value="full">Full Summary</option>
					</select>
				</div>
			</div>
			
		<jsp:include page="feeHistorySummaryDet.jsp">
			<jsp:param name="includeScripts" value="false" />
	    </jsp:include>
	</div>
		<%@include  file="/jsp/ext/common/footerSection.jsp" %>
	</body>
</html>