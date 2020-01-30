<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyBondCreateBidMemo" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>

<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
<link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.bank.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/bankSel.js"></script>
</head>

<body>
	<div class="container main" id="mainDiv">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
		
		<h1 class="page-title span12"><s:text name="label.request.suretyBondCreateBidMemo" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.suretyBondBidMemoDesc" /></p>
		<hr class="page-title-hr">
		<div class="clear"></div>
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
		<s:hidden name="errorShow" id="errorShowId"/>
		<div class="row hide" id="pageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon">Error</p></div>
					<div class="errorContent">
							<p><s:fielderror/></p>
							<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>
		
		<s:if test="hasActionErrors()">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
							<div class="errorContent">
							<p><s:actionerror/></p>
							</div>
					</div>
				</div>
			</div>
		</s:if>
		
		<div class="clear"> </div>
		
		<div class="form-mod">
			<jsp:include page="suretyBondBidRequestSummary.jsp"/>	
		</div>
		
	<div class="clear"> </div>
	
	<s:form id="suretyBidMemoForm" namespace="/int/approver" >
		<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/>
		<jsp:include page="/jsp/common/request/suretyBondBidMemo.jsp">
			<jsp:param name="includeScripts" value="false" />
		</jsp:include>
		
		<div class="clear"> </div>
		<jsp:include page="/jsp/common/request/bankSelectionDetails.jsp" >
			<jsp:param name="includeScripts" value="false" />
			<jsp:param name="suretBond" value="true" />
		</jsp:include>
	</s:form>
	
	<div class="clear"> </div>
	
	</div>
	 <div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../../common/footerSection.jsp"%>
</body>
</html>
