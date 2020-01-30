<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.common.siteAdmin.businessSiteAdmin" /></title>
    <meta name="description" content="">
    <meta name="author" content="">
    
    <%@include file="../common/siteIncludeScripts.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/siteAdmin/businessSiteAdmin.js"></script>
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<h1 class="page-title span12"><s:text name="label.common.siteAdmin.businessSiteAdmin" /></h1>
        <p class="span12 left clear dashdesc"><s:text name="label.optionalInstructionSentence.businessAdmin1" /><br>
        <s:text name="label.optionalInstructionSentence.businessAdmin2" /></p>
        <hr class="page-title-hr">
        <img alt="Loading..." id="getSitesProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 30px;width: 20px;">
         <div class="form-row" id="siteNameDiv">
            <s:select list="#{}" 
				listKey="id" 
				listValue="name" 
				id="selectSiteNameDeleg" 
				key="label.siteAdmin.sitePrefixName"
				theme="aloc"
				cssStyle="width: 270px;"
			/>
			<img alt="Loading..." id="delegProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	      </div>
        <br />
		
		<div id="create">
				
		</div>
		
	</div>
	
	<%@include  file="../common/footerSection.jsp" %>
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>