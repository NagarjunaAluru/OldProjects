<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.blockbucmgmt.screenName" /></title>

<%@include file="../common/includeCommonScripts.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/admin/blockBUCMgmt.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css"
	type="text/css" rel="stylesheet" /> 
<link href="${pageContext.request.contextPath}/css/common/buc-mgmt.css"
	type="text/css" rel="stylesheet" />        
</head>
<body>
<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
	    <h1 class="page-title span12"><s:text name="label.blockbucmgmt.screenName" /></h1>
        <p class="span12 left clear dashdesc"><s:text name="label.blockbucmgmt.optionalInstructionSentence" /></p>	
        <hr class="page-title-hr">	
		<div class="form-mod" id="blockBUCFormDiv">	
		<s:form id="searchBUCADNForm" namespace="/int/admin">
		<div class="row">
			<div class="form-row">
			    <div class="span3">
                    <s:textfield key="label.blockbucmgmt.businessUnitCode" name="searchBUCText" id="searchBUCText" maxlength="6" cssClass="span1" theme="aloc">
					</s:textfield>
                    <p class="optional"><s:text name="label.blockbucmgmt.bucadnlength" /></p>
				</div>
		        <div class="span3">
                    <s:textfield key="label.blockbucmgmt.accountingdistributionnumber" name="searchADNText" id="searchADNText" maxlength="23" cssClass="span3" theme="aloc">
					</s:textfield>
				</div>
			</div>
		</div>
				
		<div class="row">
			<div class="span3 left">
				<div class="form-row">		
					<s:submit action="searchBUC" value="Search" cssClass="btn-secondary searchBUCADN" onclick="searchBlockBUC()" />	
					<s:submit action="resetSearchBUC" value="Reset" cssClass="btn-secondary resetBUCADN" onclick="resetBlockBUC()" />		
					<img alt="Loading..." id="bucSearchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none">
         		</div>
			</div>
			<div class="span3 left">
					<div class="form-row">
						<a href="javascript:;" class="left addBUCBlock add"><s:text name="label.blockbucmgmt.bucBlock" /></a>&nbsp;&nbsp;
						<img alt="Loading..." id="addBUCBlockIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none"> 
					</div>
			  </div>
		</div>
	</s:form>
		
	<div class="simple_overlay" id="mies1" style="position: fixed; top: 2.0px;"> 
		<s:form id="blockBUCForm" action="blockBUC" namespace="/int/admin">
			<div class="details">
			  <div class="blockBUCRecord">
	    		<jsp:include page="blockBUCRecord.jsp" />
	    	  </div>
	    		<div class="row">
				<div class="span4 btn-container">
						<s:submit key="label.blockbucmgmt.save" cssClass="btn-secondary" />
						<a href="javascript:;" class="btn-tertiary cancel" id="cancelbtn"><s:text name="label.blockbucmgmt.cancel"/></a>
						<img alt="Loading..." id="bucadnBlockIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
								style="height: 20px; display:none">                  
			    </div>
			</div>
	    	</div>
	    </s:form>
    </div>		
     
	<jsp:include page="blockBUCADNSelection.jsp" />
</div>
	<s:hidden id="errorBUCId" name="errorBUC" value="%{errorBUC}" />
	 <div class="clear"></div>
	<div class="highlighted">
     	<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
     </div>	
</div>	
	
<!-- UnBlock Selected BUC POPUP WINDOW -->
<div class="modal hide fade" id="unblockSelBUCADN">
        <div class="modal-header">
            <a class="close" data-dismiss="modal">X</a>
            <h3><s:text	name="label.blockbucmgmt.unblock"/></h3>
        </div>
        <div class="modal-body">
        	<jsp:include page="unBlockBUCADN.jsp" />
        </div>
        <div class="modal-footer">
        	<sj:submit formIds="unBlockBUCForm" value="Unblock" cssClass="left btn-primary" />
        	<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>
        </div>
</div> 	
</div>	
	<%@include file="../common/footerSection.jsp"%>	
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />	

   </body>
</html>
	