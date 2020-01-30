<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<%@ page errorPage="../common/error.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Add a Request</title>
    <meta name="description" content="">
    <meta name="author" content="">
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
					
<script>
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>

  	<%@include file="../common/includeCssScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/cpaRequest.js" type="text/javascript"></script>

	
	<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/pipelineReview/viewCPALeg.js"></script>

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
            <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="#" class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
		<h1 class="page-title span12">Request Details</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.addARequest.cpa" />
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
		<html:form action="/CPALegRequest.do"  styleId="cpaLegRequestForm"  method="post"  enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.cpaLegRequestForm.map['legNumber']}" />
		<input type="hidden" name="legNumber" id="legNumber" value="<bean:write name="cpaLegRequestForm" property="legNumber" />" />
		<div class="form-mod">
			<h2 class="span12">Details</h2>
			<h3>Participant</h3>
			
			<div class="tab-content" id="">
				<div id="1" class="tab-pane fade active in">
					
					<div id="participantDetailsDiv" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd">
										<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId">
										<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName">
										<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="cpaLegRequestForm" property="cpaSummary.participantEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.country">
										<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.country" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addCPALeg.isParticipantRegulatedEntity" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" >
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addCPALeg.isParticipantPrincipalEntity" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" >
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd" styleId="lenderLegalEntityGoldId" />
					</div>
				</div>
									
			</div>
			<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd" styleId="lenderLegalEntityGoldId" />
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Management Entity</label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" maxlength="20" name="cpaSummary.participantEntity.MEName" value="<bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.MEName" />" class="span2 typeahead ajax" data-cmd="getME" id="selectedLenderMgmtEntity" style="text-transform:uppercase" disabled="disabled"/>
						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<div class="radio-container" id="lenderCap">
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" >
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" >
								<div id="LenderSetUpFlagTDiv" style="display: none;">
									<p>-</p>
								</div>
								<div id="LenderSetUpFlagFDiv" style="display: none;">
									<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" />
					</div>
				</div><!-- end of block -->
				
			</div>
			
			<div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<p>
							<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
									<logic:iterate id="lenderTreasuryCode" name="cpaLegRequestForm" property="cpaSummary.participantTCodeEntities">
	                          			${lenderTreasuryCode}<br>
	                       			</logic:iterate>
                       			</c:if>
							</p>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
		</div><!-- end of form form-mod -->

		<div class="form-mod">
		<h3 class="span12">Pool Leader</h3>
		
			<div class="leader-search-results">
				<div class="row">
					<div class="span12">
						<label>Results [N]</label>
						<table class="table table-striped table-bordered no-bottom">
							<thead>
							  <tr>
								<th style="width:10px;"></th>
								<th>Cash Pool Name</th>
								<th>CDR Code</th>
								<th>Legal Entity Gold ID</th>
								<th>Legal Entity Name</th>
								<th>Is Lender/Provider a Regulated Entity ?</th>
								<th>Is Lender/Provider a Principal Entity ?</th>
								<th>Country</th>
								<th>Capital or Industrial</th>
							  </tr>
							</thead>
							<tbody id="cashPoolID">
							<logic:present name="cashPools" scope="request" >
								<logic:iterate id="cashPool" name="cashPools" scope="request" indexId="i">
									<tr>
										<td><input type="radio" name="cashPoolOptions" id="optionsRadiosID" value="${cashPool.cashPoolName}"></td>
										<td>${cashPool.cashPoolName}</td>
										<td>${cashPool.CDRCode}</td>
										<td>${cashPool.LEGoldID}</td>
										<td>${cashPool.legalEntity}</td>
										<td>${cashPool.regulatedEntity}</td>
										<td>${cashPool.principalEntity}</td>
										<td>${cashPool.country}</td>
										<td>${cashPool.capitalIndustrial}</td>
									</tr>
								</logic:iterate>
							</logic:present>
							</tbody>
						</table>
					</div>
					<div class="span4 right leader-btn-container" >
						<div class="form-row">
							<a type="submit" class="btn right leader-save-selection" id="saveSelectionId">Save selection</a>
							<a type="submit" href="#" class="btn-link right leader-clear">Clear results</a>
						</div>
					</div> <!-- end of block -->
				</div>
			</div>
			
			
			
			<div class="leader-saved-results" id="poolLeaderIdDetails" >
			
			<input type="hidden" name="region" id="regionID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.region"/>'/>
			<input type="hidden" name="country" id="countryID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.country"/>'/>
			<input type="hidden" name="currencyCd" id="currencyCdID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.currencyCd"/>'/>
	
			
			<a class="btn-link right clear-conditional-results" href="#" type="submit" onclick="javascript:clearLenderDetails();"><bean:message key="label.addLeg.clearResults" /></a>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b>Cash Pool Name</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" />
					<div class="span5 right">
						<div class="form-row">
							<p><b>Legal Entity Gold ID</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId" />
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p><b>CDR code</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd"/></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd" />
					<div class="span5 right">
						<div class="form-row">
							<p><b>Country</b></p>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country">
								<p id="cashPoolNameId"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country" />
				</div>
				<div class="row highlighted">
					<div class="span5 right">
						<div class="form-row">
							<p><b>Legal Entity Name</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId" />
					<div class="span5">
						<div class="form-row">
							<p><b>Is Pool/Leader a regulated Entity?</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" >
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" >
								<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" value="true">
									<p>Yes</p>
								</logic:equal>
								<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" value="false">
									<p>No</p>
								</logic:equal>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" />
				</div>	
				<div class="row">
					<div class="span5 right">
						<div class="form-row">
							<p><b>Is Pool/Leader  a principal Entity?</b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" >
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" value="true">
											<p>Yes</p>
										</logic:equal>
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" value="false">
											<p>No</p>
										</logic:equal>
									</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" />
				
					<div class="span5">
						<div class="form-row">
							<label>Management Entity</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName" />
				</div>
				<div class="row">
					<div class="span5 right">
						<div class="form-row">
							<label>Capital or Industrial</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.leType">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.leType">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.leType" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.leType" />
				
					<div class="span5">
						<div class="form-row">
							<label>Bank Name</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd" />
				</div>
				<div class="row">
					<div class="span5 right">
						<div class="form-row">
							<label><bean:message key="label.addLeg.treasuryCode" />
							</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCodes">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" />
					<div>
					</div>
				</div>
				<h3>Rate Information</h3>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b>Interest Rate Index</b></p>
							<p>-</p>
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p><b>Index Term</b></p>
							<p>-</p>
						</div>
					</div><!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p><b>Deposit Spread (bps)</b></p>
							<p>-</p>
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p><b>Borrowing Spread (bps)</b></p>
							<p>-</p>
						</div>
					</div><!-- end of block -->
				</div>
			
			</div>
		</div> <!-- end of form mod -->
			

		<div class="form-mod">
		<h3 class="span12">Other Considerations</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Non-standard Legal Agreement(s)</label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="nonStandardAgreementsFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
						</div>
					</div>
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Cross Border</label>
						<span  class="help-block error" id="crossBorderFlagFailed" style="display:none;">Please select</span>
						<div id="crossBoarderDiv" class="radio-container">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="crossBorderFlagId" property="crossBorderFlag" value="true" disabled="true"/>
								Yes
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlagId" value="false" disabled="true"/>
								No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
				
			</div>
			</div>
		<div class="exceptions-conditional attachments-mod" id="exceptionDiv">
		
			<h3 class="span12">Exceptions</h3>
			<div class="row">
				<div class="span12">
				  <table class="table table-striped table-bordered exceptions exceptions-nested exception-validation">
					<thead>
					  <tr>
						<th colspan="1">Actions</th>
						<th>Standard Terms &amp; Conditions</th>
						<th>Exception Requested</th>
						<th>Rationale for Exception</th>
						<th>Exception Timeline</th>
						<th>Remediation Timeline</th>
					  </tr>
					</thead>
					<tbody>
				<c:choose>
						<c:when test="${not empty sessionScope.cpaLegRequestForm.map['cpaSummary'].map['exceptionRequestForms']}">
							 <logic:iterate name="cpaLegRequestForm" property="cpaSummary.exceptionRequestForms" id="exceptionDetails" indexId="i">
								<tr>
									<td rowspan="3">
									<html:hidden name="cpaLegRequestForm" styleId="exceptionTimelineIdTemp" property="exceptionTimelineIdTemp"/>
									<html:hidden name="cpaLegRequestForm" styleId="exceptionIndex" property="exceptionIndex" value="${i + 1}"/>
								
									</td>
									
									
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Terms &amp; Conditions</label>
											<html:select name="exceptionDetails" styleId="standardTerms" property="standardTermsConditions" styleClass="span2 request-exp">
												<html:option value="">Select..</html:option>
												<html:option value="1">Interest Settlement</html:option>
												<html:option value="2">Dates</html:option>
												<html:option value="3">Rates</html:option>
												<html:option value="4">Others</html:option>
											</html:select>
										</div>
									</td>
									<td>
										<div class="form-row autosize-container small">
											<span class="required">*</span>
											<label>Exceptions</label>
											<div class="char-count">500</div>
											<html:textarea name="exceptionDetails" styleId="requestException" property="requestedException" 
											styleClass="span4 autosize messageinput request-exp" rows="4" onblur="scriptInjection(this);">
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
											styleClass="span4 autosize messageinput request-exp" rows="4" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="rationaleForExceptionImpact"/>
											</html:textarea>
										</div>
										<div class="form-row autosize-container small">
											<label>Potential alternatives</label>
											<div class="char-count">500</div> 
											<html:textarea name="exceptionDetails" styleId="exceptionPotential" property="rationaleForExceptionPotentialAlternatives" 
											styleClass="span4 autosize messageinput " rows="4" onblur="scriptInjection(this);">
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
														<html:radio name="exceptionDetails" property="exceptionTimelineId"  onclick="javascript:changeValue( this,  '1');" styleId="exceptionTimelineId" value="Y" indexed="true" />
														Permanent
													</label>  
													<label class="radio">
														<html:radio name="exceptionDetails" property="exceptionTimelineId"  onclick="javascript:changeValue( this,  '2');" styleId="exceptionTimelineId" value="N" indexed="true"/>
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
											styleClass="span4 autosize messageinput request-exp" rows="4" onblur="scriptInjection(this);">
											<bean:write name='exceptionDetails' property="remediationTimelineComments"/>
											</html:textarea>
										</div>
										<div class="form-row autosize-container small">
										<span class="required">*</span>
											<label>Estimated Timeframe</label>
											
											<html:text name="exceptionDetails" styleId="remediationTimeFrame" property="remediationTimeline" styleClass="span2 request-exp" >
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

		
		
				<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
		</jsp:include> 
		<!-- end uploads -->
		
		
		
		<div class="span8 right btn-container">
			<input type="hidden" name="productType" value="CPA"/>
			<!-- <input type="button" value="Save and return to Request" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal&productType=CPA');">
			<input type="button" value="Save" class="btn right" onclick="javascript:validate('?command=saveAsDraft&productType=CPA');"> -->
			<a class="btn-link right cancel"  href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail">Cancel</a>
		</div>
		</html:form>
   <hr>
    </div>
	<%@include  file="../../jsp/common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="derivatives">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Add a Derivatives</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<span class="required">*</span>
							<label>Derivatives?</label>
							<div class="radio-container">
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios">
									Internal
								</label>
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios">
									External
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span4 right">
						<div class="form-row">
							<label>Hedge Designation  - U.S. GAAP</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<span class="required">*</span>
							<label>Derivative type</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							  </select>
						</div>
					</div> <!-- end of block -->
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Hedge program</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							  </select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency Pair</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Contract class</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					
				</div>
				
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<span class="required">*</span>
								<label>Amount</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<label>Amount</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Tax Designation </label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Fix or Float</label>
							<div class="radio-container conditional-radio-tri">
								<label class="radio">
									<input type="radio"value="High" name="optionsRadios" class="condition">
									Fixed
								</label>
								<div class="conditional-container">
									<div class="form-row">
											<span class="required">*</span>
											<label>Amount</label>
											<input type="text" class="span1 dual-selects"> 
									</div>
								</div>
								<label class="radio">
									<input type="radio"value="Medium" name="optionsRadios" class="condition">
									Float
								</label>
								<div class="conditional-container">
									<div class="form-row">
										<span class="required">*</span>
										<label>Index 1</label>
										<select class="span2 dual-selects">
											<option>Select...</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select> 
									</div>
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Fix or Float</label>
							<div class="radio-container conditional-radio-tri">
								<label class="radio">
									<input type="radio"value="High" name="optionsRadios" class="condition">
									Fixed
								</label>
								<div class="conditional-container">
									<div class="form-row">
											<span class="required">*</span>
											<label>Amount</label>
											<input type="text" class="span1 dual-selects"> 
									</div>
								</div>
								<label class="radio">
									<input type="radio"value="Medium" name="optionsRadios" class="condition">
									Float
								</label>
								<div class="conditional-container">
									<div class="form-row">
										<span class="required">*</span>
										<label>Index 2</label>
										<select class="span2 dual-selects">
											<option>Select...</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select> 
									</div>
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<span class="required">*</span>
								<label>Spread (bps)</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<label>&nbsp;</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Day count</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label class="nowrap">Interest reset frequency</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				
			</div>
			
			
			<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="saveDerivative" data-dismiss="modal">Save</a>
			<a href="#" class="btn right">Save and add new Derivative</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>			</div>
	</div>
	<div class="modal hide fade" id="attach">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Attach <span></span></h3>
			</div>
			<div class="modal-body">
			<form>
			<p>Add a document to <span></span>.</p>
				<h2><span class="required required-td">*</span>1. Select a Leg to attach a document</h2>
				<div class="row">
					<div class="span9">
						 <table class="table table-striped table-bordered sortable no-bottom">
							<thead>
							  <tr>
								<th rowspan="2">Select</th>
								<th rowspan="2">Leg #</th>
								<th rowspan="2">Product Type</th>
								<th rowspan="2">Term <span class="small">in months</span></th>
								<th colspan="2" class="nosort">Participant</th>
								<th colspan="2" class="nosort">Borrower</th>
								<th colspan="2" class="nosort">Original Currency</th>
								<th rowspan="2">USD Equivalent</th>
								<th rowspan="2">Derivatives</th>
								<th rowspan="2">Existing</th>
							  </tr>
							  <tr>
								<th>Legal Entity</th>
								<th>Country</th>
								<th>Legal Entity</th>
								<th>Country</th>
								<th>Currency</th>
								<th>Amount</th>

							  </tr>
							</thead>
							<tbody>
							  <tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>1</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>2</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>3</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>5</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>4</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr>
							</tbody>
						  </table>
						  <label class="checkbox apply-to-all" >
					<input type="checkbox" class="" id="optionsCheckbox" value="option1">
					Apply this Attachment to all Legs
				</label>
				</div><!-- end of block -->
				
				</div>
				<h2><span class="required required-td">*</span>2. Attachment document</h2>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<input type="file" id="fileInput" class="input-file-attach" >
						</div>
					</div> <!-- end of block -->

				</div>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#derivatives-table" class="btn right btn-success" id="saveAttachment" data-dismiss="modal">Save</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
  
  </body>
</html>

