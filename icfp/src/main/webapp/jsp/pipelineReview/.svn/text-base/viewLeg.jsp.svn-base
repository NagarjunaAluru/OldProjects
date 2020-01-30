<%@ page import="com.ge.icfp.util.Utils"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ page errorPage="../common/error.jsp" %>

<t:common/>

<% String servletContextUrl = request.getContextPath(); 
%>
<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1";
} else {
	legLenforJS ="0";
}

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | View a Leg</title>
    <meta name="description" content="">
    <meta name="author" content="">
<script type="text/javascript" >
var legLen = '<%=legLenforJS%>';
</script>
   	<%@include file="../common/includeCssScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/addRCALeg.js" type="text/javascript"></script>
	<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>
	<script src="${pageContext.request.contextPath}/js/commonLeg.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pipelineReview/viewLeg.js">
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-typeahead.js" type="text/javascript"></script>
	
	
	<script>

//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';

</script>
	
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewView.do?command=executeInbox"><bean:message key="heading.pipelineInbox.pageTitle"/></a><span class="divider">/</span></li>
			<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail">Pipeline Review</a> <span class="divider">/</span></li>
      		<li class="active">View Leg</li>
		</ul>
		
		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="#" class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
		<h1 class="page-title span10">View Leg</h1>
		
		<p class="span12 left clear dashdesc">
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
		
	<form action="${context}/pipelineReview/pipelineReviewDealLeg.do" id="ICFPLegRequestForm" method="post" autocomplete="off" enctype="multipart/form-data" >
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		<div class="form-mod">
			<%@ include file="../common/inc/newTransactionSummary.jsp"%>
			<h2 class="span12"><bean:message key="label.addLeg.details" /></h2>
			<h3><span class="conditional-lender"></span></h3>
			
				<div id="1" class="tab-pane fade active in">
					
					  <div id="lenderGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.country" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.isLenderOrProviderARegulatedEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" >
										<logic:equal name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.isLenderOrProviderAPrincipalEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" >
										<logic:equal name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
					</div> 
				</div>
				
									
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" name="legSummary.lenderEntity.MEName" disabled="disabled" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" />" class="span2 typeahead ajax" data-cmd="getME" id="selectedLenderMgmtEntity"/>
						
						<%-- <html:select name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" styleClass="span2 conditional-select" styleId="selectedLenderMgmtEntity">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.MasterData" property="mgmtEntities" value="name" label="name"/>						   
						</html:select>  --%>
						
 						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="lenderCapfailed" style="display:none;">Please select Capital or Industrial </span>
						<div class="radio-container" id="lenderCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" >
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" >
								<div id="LenderSetUpFlagTDiv" style="display: none;">
									<p>-</p>
								</div>
								<div id="LenderSetUpFlagFDiv" style="display: none;">
									<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" />
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div id="lenderTreasuryDetails">
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" /></p>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
		</div><!-- end of form form-mod -->
		<div class="form-mod">
		<h3><bean:message key="label.addLeg.borrowerOrRecipient" /></h3>
			<%-- <ul class="nav nav-tabs tabs" >
				<li class="active"><a data-toggle="tab" href="#1a"><bean:message key="label.addLeg.search" /></a></li>
			</ul> --%>
			<div class="tab-content" id="">
				<div id="1a" class="tab-pane fade active in">
					
					<div id="borrowerGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.isBorrowerOrRecipientARegulatedEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag">
										<logic:equal name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.isBorrowerorRecipientAPrincipalEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag">
										<logic:equal name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
					</div>
				</div>
				
			</div>
			
			<div class="row">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="borrowerMgmtfailed" style="display:none;">Please select Management Entity </span>
						<input type="text" name="legSummary.borrowerEntity.MEName" disabled="disabled" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" />" class="span2 typeahead"  data-cmd="getME" id="selectedBorrowerMgmtEntity"/>
						<%-- <html:select name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" styleClass="span2 conditional-select" styleId="selectedBorrowerMgmtEntity">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.MasterData" property="mgmtEntities" value="ID" label="name"/>	
 						</html:select> --%>
 						<span id="borrowerMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div  id="borrowerCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="borrowerCapfailed" style="display:none;">Please select Capital or Industrial</span>
						<div class="radio-container" id="borrowerCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<div id="BorrowerSetUpFlagTDiv" style="display: none;">
									<p>-</p>
								</div>
								<div id="BorrowerSetUpFlagFDiv" style="display: none;">
									<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" styleId="borrowerCapOrIndustrial" />
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div id="borrowerTreasuryDetails">
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
							<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" /></p>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
			
		</div><!-- end of form form-mod -->
		<div class="form-mod">
		<h3 class="span12">Product Details</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.productType" /></label>
						<span  class="help-block error" id="productTypefailed" style="display:none;">Please select Product Type</span>
						
						<html:select name="ICFPLegRequestForm" property="legSummary.legTypeId" styleClass="span2" styleId="productType" disabled="true">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="productTypes" value="ID" label="name"/>
						</html:select>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="formOfEquityDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Form of Equity</label>
						<html:select name="ICFPLegRequestForm" property="equityFormId" styleClass="span2" styleId="equityFormId" disabled="true">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="formOfEquity" value="ID" label="name"/>
						</html:select>
						<span id="equityFormValidate" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<c:choose>
				<c:when test="${sessionScope.ICFPLegRequestForm.map['equityFormId'] != 4}">
					
			<div id="allProductTypeDiv" class="product-type-all">
				<h3 class="span12">Equity Details</h3>
				<div class="row">
					<div class="span12">
					 <table class="table table-striped table-bordered equity-validation">
						<thead>
						  <tr>
							<th class="header" style="width:35px;">Action</th>
							<th class="header">Share type</th>
							<th class="header">Number of shares</th>
							<th class="header">Par value per share</th>
						  </tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
							 <logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
				
						  <tr>
							<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:select name="equityDetails" property="shareTypeId" styleClass="span2 request-equity" styleId="shareTypeId" disabled="true">
										<html:option value="">Select..</html:option>
										<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
									</html:select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="numberOfShares" styleClass="span2 request-equity" styleId="numberOfShares" disabled="true"/>
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="shareValue" styleClass="span2 request-equity" styleId="shareValue" disabled="true"/>
								</div>
							</td>

						  </tr>
						 	</logic:iterate>
						</c:when>
						
						<c:otherwise>
						  <tr>
						  <td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<select name="shareTypeId" class="span2 request-equity" disabled="disabled">
										<option value="">Select...</option>
										<option value="1">Preferred</option>
										<option value="2">Cumulative Preferred</option>
										<option value="3">Common</option>
									</select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="numberOfShares" type="text" class="span2 request-equity" disabled="disabled">
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="shareValue" type="text" class="span2 request-equity" disabled="disabled">
								</div>
							</td>
						  </tr>
						</c:otherwise>
						</c:choose>
						</tbody>
					  </table>
					  <a class="left add" href="#">Add additional share type</a>
					</div>
				</div>
			</div>
			</c:when>
			<c:when test="${sessionScope.ICFPLegRequestForm.map['equityFormId'] == 4}">
			<div id="debtProductTypeDiv" class="product-type-debtfields">
				<h3 class="span12">Equity Details</h3>
				<div class="row">
					<div class="span12">
					 <table class="table table-striped table-bordered equity-validation">
						<thead>
						  <tr>
							<th class="header" style="width:35px;">Action</th>
							<th class="header">Debt terms</th>
							<th class="header">Share type</th>
							<th class="header">Number of shares</th>
							<th class="header">Par value per share</th>
						  </tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
						<logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
				
						  <tr>
							<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="debtTerms" styleClass="span2" styleId="numberOfShares" disabled="true"/>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:select name="equityDetails" property="shareTypeId" styleClass="span2" styleId="shareTypeId" disabled="true">
										<html:option value="">Select..</html:option>
										<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
									</html:select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="numberOfShares" styleClass="span2" styleId="numberOfShares" disabled="true" />
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="shareValue" styleClass="span2" styleId="shareValue" disabled="true" />
								</div>
							</td>

						  </tr>
						  	</logic:iterate>
						</c:when>
						
						<c:otherwise>
						<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="debtTerms" type="text" class="span2" disabled="disabled">
								</div>
							</td>
							<td>
								<div class="form-row">
									<select name="shareTypeId" class="span2" disabled="disabled">
										<option value="">Select...</option>
										<option value="1">Preferred</option>
										<option value="2">Cumulative Preferred</option>
										<option value="3">Common</option>
									</select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="numberOfShares" type="text" class="span2" disabled="disabled">
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="shareValue" type="text" class="span2" disabled="disabled">
								</div>
							</td>
						</c:otherwise>
						</c:choose>
						</tbody>
					  </table>
					  <a class="left add" href="#">Add additional share type</a>
					</div>
				</div> 
			</div> 
			</c:when>
			</c:choose>
			<div id="termDiv" class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.term" /> <span class="small"><bean:message key="label.addLeg.inMonths" /></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="8" styleClass="span1" styleId="termInMonths" disabled="true"/>
						<span id="termValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div id="commenstDiv" class="row comment-container product-type-comments" style="display:none;">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Description</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2" rows="1" data-max="500" disabled="disabled"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="row">
				<div id="subordinateDiv" style="display:none;">
						<div class="span5 conditional-select-rca">
							<div class="form-row">
								<span class="required">*</span>
								<label>Subordinated Debt</label>
								<span  class="help-block error" id="subordinatedfailed" style="display:none;">Please select Subordinated Debt</span>
								<div id ="subordinatedDiv" class="radio-container">
									<span id="subordinatedfailed"></span>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="true" disabled="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="false" disabled="true"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div>
							</div>
						</div> <!-- end of block -->
					</div>
					<div  class="span5 right">
					<div id="dealcurrencyDiv" class="form-row">
							<span class="required">*</span>
							<label><bean:message key="label.addLeg.dealCurrency" /></label>
							<span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select Deal currency </span>
							
							<input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							class="span2" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" disabled="disabled">
							
							 <%--  <html:select name="ICFPLegRequestForm" property="legSummary.originalCCY" styleId="originalCCY" styleClass="span2">
								<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
								<html:optionsCollection name="com.ge.icfp.MasterData" property="dealCurrencies" value="id" label="name"/>	
							</html:select> --%>
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
					</div>
					</div>
			</div>
			<div class="row">
				
				<div id="amountDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.amount" />
							<span data-original-title="<bean:message key="tooltip.addLeg.amount" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Amount</span>
						<span  class="help-block error" id="originalCCYAmountValidateNumber" style="display:none;">Invalid value </span>
						<html:text name="ICFPLegRequestForm" maxlength="9" property="legSummary.originalCCYAmount" styleClass="span2" styleId="originalCCYAmount" disabled="true"/>
						<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div>
				<div class="row">
					<div id="existDiv" class="span5" style="display:none;">
						<div class="form-row">
							<span class="required">*</span>
							<label><bean:message key="label.addLeg.isThisAnExisting" /> <span class="conditional-type-variable"></span>?</label>
							<span  class="help-block error" id="existingfailed" style="display:none;">Please select Is this an existing</span>
							<div id="existingDiv" class="radio-container">
								<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right" id="usdEquiDiv" style="display:none;">
					<div class="form-row">
							<p><b>USD equivalent</b></p>
							<p><bean:write name="ICFPLegRequestForm" property="legSummary.USDEquivalent"/></p>
						</div>
					</div><!-- end of block -->
				</div>
				<div id="derDiv" class="row" style="display:none;">
					<div id="derDivEquity" class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Are there Derivatives?</label>
							<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Are there Derivatives?</span>
							<div id="derivativDiv" class="radio-container derivativesConditional">
								<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="true" styleClass="condition" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div id="doubleLeverageDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<span class="required">*</span>
							<label>Double Leverage</label>
							<div id="doubleLeverage" class="radio-container">
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="true" disabled="true"/>
									Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="false" disabled="true"/>
									No
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row" id="derivatives-table" style="display:none;">
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<span id="derFlagValidate" class="req-error" style="display:none;">error</span>
								<input type="button" value="Add A Derivative" tabindex="18" class="btn" disabled="disabled">
								
							</div>
						</div> <!-- end of block -->
					</div>
					<c:set var="DerExistsFlag" value="0" />
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2" colspan="2">Action</th>
							<th rowspan="2">Item No.</th>
							<th rowspan="2">Derivatives</th>
							<th rowspan="2">Derivative Type</th>
							<th colspan="3" class="nosort">Currency 1</th>
							<th colspan="3" class="nosort">Currency 2</th>
							<th rowspan="2">Hedge Designation</th>
							<th rowspan="2">Tax Designation</th>
						  </tr>
						  <tr>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
						  </tr>
						</thead>
						<tbody>
						<c:set var="derivativeDetailsVOList" value="${deal:fetchDerivatives(legNumber, pageContext)}" />
						<c:choose>
							<c:when test="${not empty derivativeDetailsVOList}">
								<c:forEach var="derivative" items="${derivativeDetailsVOList}">
									<tr>
										<td></td>
										<td></td>
										<td id="itemNoId">${derivative.derivativeNumber}</td>
										<c:set var="DerExistsFlag" value="${derivative.derivativeNumber}" />
										<td>${derivative.internalOrExternal}</td>
										<td>${derivative.derivativeType}</td>
										<td>${derivative.currency1}</td>
										<td>${derivative.derivativeAmount1}</td>
										<td>${derivative.fixedOrFloat1}</td>
										<td>${derivative.currency2}</td>
										<td>${derivative.derivativeAmount2}</td>
										<td>${derivative.fixedOrFloat2}</td>
										<td>${derivative.hedgeDesigation}</td>
										<td>${derivative.taxDesigation}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>	
							</c:otherwise>
						</c:choose>
						
						</tbody>
					  </table>
					</div>
				</div> 
			</div> 
			<div class="conditional-type-equity">
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Are there Derivatives?</label>
							<div class="radio-container">
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios" class="derivativesModal" disabled="disabled">
									Yes
								</label>
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios" disabled="disabled">
									No
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row" id="derivatives-table">
					<div class="span12">
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2">Item No.</th>
							<th rowspan="2">Derivatives</th>
							<th rowspan="2">Derivatives Type</th>
							<th colspan="3" class="nosort">Currency 1</th>
							<th colspan="3" class="nosort">Currency 2</th>
							<th rowspan="2" class="nosort">Hedge Designation</th>
							<th rowspan="2" class="nosort">Tax Designation</th>
						  </tr>
						  <tr>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>						
						  </tr>
						</tbody>
					  </table>
					</div>
				</div> 
			</div> 
			
			 <div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Non-standard Legal Agreement(s)</label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<%-- <label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="nonStandardAgreementsFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label> --%>
							
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="legSummary.nonStandardAgreementsFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
					</div>
				</div>
				<div id="eBoardEligibleDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<p><b>eBoardroom eligible</b></p>
							<logic:equal name="ICFPLegRequestForm" property="eBoardApprovalRequiredFlag" value="true">
								<p>Yes</p>
							</logic:equal>
							<logic:equal name="ICFPLegRequestForm" property="eBoardApprovalRequiredFlag" value="false">
								<p>No</p>
							</logic:equal>
						</div>
					</div> <!-- end of block -->
			</div>
			 <div class="row">
			<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Cross border</label>
						<span  class="help-block error" id="crossBorderFailed" style="display:none;">Please select Cross border</span>
						<div id="crossBorderDiv" class="radio-container">
							<span id="crossBorderFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="crossBorderFlagId" property="crossBorderFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="crossBorderFlagId" property="crossBorderFlag" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>

					</div>
				</div> <!-- end of block -->
				</div>
			
		<div class="exceptions-conditional attachments-mod" id="exceptionDiv">
		
			<h3 class="span12">Exceptions</h3>
			<div class="row">
				<div class="span12">
				  <table class="table table-striped table-bordered sortable exceptions exceptions-nested exception-validation">
					<thead>
					  <tr>
						<th colspan="1">Actions</th>
						<th>Standard Terms &amp; Conditions</th>
						<th>Request Exception</th>
						<th>Date Rational for Exception</th>
						<th>Exception Timeline</th>
						<th>Remediation Timeline</th>
					  </tr>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['legSummary'].map['exceptionRequestForms']}">
							 <logic:iterate name="ICFPLegRequestForm" property="legSummary.exceptionRequestForms" id="exceptionDetails" indexId="i">
								<tr>
									<td rowspan="3">
									<html:hidden name="ICFPLegRequestForm" styleId="exceptionTimelineIdTemp" property="exceptionTimelineIdTemp"/>
									<html:hidden name="ICFPLegRequestForm" styleId="exceptionIndex" property="exceptionIndex" value="${i + 1}"/>
									
									</td>
									
									
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Terms &amp; Conditions</label>
											<html:select name="exceptionDetails" styleId="standardTerms" property="standardTermsConditions" styleClass="span2 request-exp" disabled="true">
												<html:option value="">Select..</html:option>
												<html:option value="1">Standard</html:option>
												<html:option value="2">Regular</html:option>
												<html:option value="3">Legal</html:option>
											</html:select>
										</div>
									</td>
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Exceptions</label>
											<div class="char-count">500</div>
											<html:textarea name="exceptionDetails" styleId="requestException" property="requestedException" 
											styleClass="span4 autosize messageinput request-exp" rows="4" disabled="true" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="requestedException"/>
											</html:textarea>
											
										</div>
									</td>
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Impact</label>
											<div class="char-count">500</div> 
											<html:textarea name="exceptionDetails" styleId="exceptionImpact" property="rationaleForExceptionImpact" 
											styleClass="span4 autosize messageinput request-exp" rows="4" disabled="true" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="rationaleForExceptionImpact"/>
											</html:textarea>
										</div>
										<div class="form-row autosize-container small">
											<label>Potential alternatives</label>
											<div class="char-count">500</div> 
											<html:textarea name="exceptionDetails" styleId="exceptionPotential" property="rationaleForExceptionPotentialAlternatives" 
											styleClass="span4 autosize messageinput " rows="4" disabled="true" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="rationaleForExceptionPotentialAlternatives"/>
											</html:textarea>
										</div>
									</td>
									
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Timeline</label>
											<div class="radio-container">
													<label class="radio">
														<html:radio name="exceptionDetails" property="exceptionTimelineId"  onclick="javascript:changeValue( this,  '1');" styleId="exceptionTimelineId" value="Y" indexed="true" disabled="true"/>
														Permanent
													</label>  
													<label class="radio">
														<html:radio name="exceptionDetails" property="exceptionTimelineId"  onclick="javascript:changeValue( this,  '0');" styleId="exceptionTimelineId" value="N" indexed="true" disabled="true"/>
														Temporary
													</label>
											</div>
										</div>
									</td>
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Comments</label>
											<div class="char-count">500</div> 
											<html:textarea name="exceptionDetails" styleId="remediationComments" property="remediationTimelineComments" 
											styleClass="span4 autosize messageinput request-exp" rows="4" disabled="true" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="remediationTimelineComments"/>
											</html:textarea>
										</div>
										<div class="form-row autosize-container small">
										<span class="required">*</span>
											<label>Timeframe</label>
											
											<html:text name="exceptionDetails" styleId="remediationTimeFrame" property="remediationTimeline" styleClass="span2 request-exp" disabled="true">
											    <bean:write name='exceptionDetails' property="remediationTimeline"/>
											</html:text>
										</div>
									</td>
									</tr><tr class="attachment-nested">
									<td colspan="3">
										Document
									</td>
									<td colspan="4">
										Attach new<br>
										<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
									</td>
								</tr>
								
								<tr class="attachment-nested2 multi"  >
									<td colspan="3" class="attachment-uploaded">
									<div id='Exceptions_Documents'>
									
				<c:set var="exptIndex" value="<%=String.valueOf(i+1)%>" />
					<%
					String exptIndex = (String)pageContext.getAttribute("exptIndex");
					
					%>

				</div>
									</td>	
									<td colspan="4">
								<div id='field10'>
								<input type='file' id='exceptionDocument' name='exceptionDocument'  class='input-file10' disabled="disabled"/>
		 						</div>
									</td>
								</tr>
							
							</logic:iterate>
						</c:when>
						
						
					</c:choose>
					 </tbody>
				  </table>
				 
				</div>
			</div> 
			
        </div><!-- end of form form-mod -->
		
	
		 
		    <!-- attachments rca start of block -->
		  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		  	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
       	 </jsp:include>  
		    <!-- need to add param for the form to differentiate -->
		
		
		
		<div class="span8 right btn-container">
		
		
		<!-- <input disabled="disabled" type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal');">
		<input disabled="disabled" type="button" value="Save and add another Leg" class="btn right" onclick="javascript:validate('?command=saveAndAddAnotherLeg');">
		 -->
		
	<!--	<button type="submit" name="command" value="saveAndReturnToDeal"  class="btn right btn-success" >Save and return to Deal</button>
	 	<html:button styleClass="btn right" property="command" onclick="javascript:validate();">Save and add another Leg</html:button> 
		<button type="button" name="command" class="btn right" value="saveAndAddAnotherLeg" onclick="javascript:validate();">Save and add another Leg</button> 
	 -->	
		
		<!-- 	<html:submit property="command" styleClass="btn right btn-success" value="saveAndReturnToDeal" />
			<html:submit property="command" styleClass="btn right" value="saveAndAddAnotherLeg"/>  
			<a href="javascript:window.history.back();" class="btn-link right cancel">Cancel</a>
		-->
		
		<!-- <input disabled="disabled" type="button" value="Save as draft" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');"> -->
		<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
		<!-- <a class="btn-link right cancel"  onclick="history.back();">Cancel</a> -->
			
		</div>
		</form>
   <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
    <div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
		</div>
      </div>
  
  </body>
</html>

