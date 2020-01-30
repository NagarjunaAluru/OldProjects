<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ page errorPage="common/error.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/> 
<% String servletContextUrl = request.getContextPath(); %>
<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1"; 
} else {
	legLenforJS ="0";
}

%>

<script type="text/javascript" >
var legLen = '<%=legLenforJS%>';

</script>
<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>
	
	<script src="<%=servletContextUrl%>/js/addRCALeg.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/commonLeg.js" type="text/javascript"></script>
	
	<script>
	function addDerivative(){
		var legRequestForm = document.getElementById('ICFPLegRequestForm');
		action = legRequestForm.action;
		action = action + '?command=addDerivatives';
		legRequestForm.action = action;
		legRequestForm.submit();
	}
	function displayResult(x)
	{
	x.rowIndex/3;
	}
	
	</script>
	<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	
	
	<script>
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>

		<c:if test="${not empty sessionScope.currentDate}">
				<c:set var="requestFrmtDt" value="${sessionScope.currentDate}"/>
		</c:if>
		<c:if test="${not empty sessionScope.valueDate}">
				<c:set var="valueDate" value="${sessionScope.valueDate}"/>
		</c:if>
		<div id="validateFlag" class="alert fade in alert-danger hide">
            <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
            <strong><bean:message key="label.addLeg.pleaseFixErrors" /></strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong><font color="green">${requestScope.UpdateMessage}</font></strong> 
        </div>
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.atmtError}</strong> 
        </div>
        
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong><bean:message key="label.addLeg.successTransactionMessage"/></strong> 
			<a href="#" class="btn-link"><bean:message key="label.addLeg.addAnotherLeg" /></a> |
			<a href="#legTable" class="btn-link"><bean:message key="label.addleg.goToTable" /></a>
        </div>
        
		<form action="${context}/RCALegRequest.do" id="ICFPLegRequestForm" method="post" autocomplete="off" enctype="multipart/form-data" >
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		<input type="hidden"  id="todayDateID" value="${requestFrmtDt}"/>	
		<input type="hidden"  id="valueDateID" value="${valueDate}"/>		
		<div class="form-mod entitylookup">
		<%@ include file="common/inc/newTransactionSummary.jsp"%>	
			<h2 class="span12"><bean:message key="label.addLeg.details" /></h2>
			<h3><span class="conditional-lender"></span></h3>
			
				<div id="1" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label><span class="conditional-lender"></span>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="lenderInfofailed" style="display:none;">Please enter <span class="conditional-lender"></span> </span>
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;"><bean:message key="label.adLeg.invalidValue" /> </span>
								<span  class="help-block error duplicate" id="lenderDiffFailed" style="display:none;"><span class="conditional-lender"></span> & <span class="conditional-borrower"></span> must be different</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="lenderSearchId">
									<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
								</select>
								
							
								<input type="text" maxlength="9" class="span3 entity-filtervalue" id="lenderOrProvider" style="text-transform:uppercase"/>
								
								<span id="lenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a class="btn entity-lookup" type="submit" data-cmd="getLE">Search</a>
								<label class="checkbox info-checkbox pending ">
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.lenderEntity.entitySetupFlag" value="Y" styleClass="" styleId="lenderEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right clear-conditional-results" href="#" type="submit" onclick="javascript:clearLenderDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					  <div id="lenderGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" /></p>
									</logic:notEmpty>
									   <html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" styleClass="leName"/>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.country" /></p>
									</logic:notEmpty>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.country" styleClass="country"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd" styleId="lenderLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" styleId="LEGoldId" styleClass="leGoldId"/>
						</div>
						
						<div id="lenderPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b><span class="condition-lenderReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="lenderRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" disabled="disabled" styleId="regulatedEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" disabled="disabled" styleId="regulatedEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-lenderPrn required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="lenderPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" disabled="disabled" styleId="princplEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" disabled="disabled" styleId="princplEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					
					</div> 
				</div>
			<div class="row MESearch">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
						
						<a href="#1" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1" class="btn-link clear-conditional-results">Clear results</a>

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
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" >
								<div id="LenderSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="LenderSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" styleClass="capitalIndustrial" />
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" /></p>
						<input class="meValue" id="selectedLenderMgmtEntity" type="hidden" name="legSummary.lenderEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" />"/>
					</div>					
				</div>		
				</div>			
			</div>

			<div class="row">
				<div class="span6">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block invalid error" id="lenderTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" maxlength="20" id="lenderTreasuryCode" class="span3" style="text-transform:uppercase" />
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						<a class="btn addtcode alwaysone" type="submit" 
							data-assign="legSummary.lenderTCodeEntity.treasuryCode">
							Search
						</a>
						<a class="btn-link clear-conditional-results" id="clearLenderTreasury" href="#" type="submit">
							<bean:message key="label.addLeg.clearResults" />
						</a>
					</div>
				</div> <!-- end of block -->
				<div id="lenBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="lenBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" >
								<div id="lenBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="lenBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<input type="hidden" name="legSummary.lenderEntity.businessSegment" class="businessSegment" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" />">
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row conditional-row" id="lenderTreasuryDetails">
				
				<div class="span5 highlighted">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" 
						styleId="lenderTreasuryGoldId"/> 
					</div>
				</div>

			</div>	
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="ICFPLegRequestForm" property="legSummary.lenderEntity.fundHoldOperationId" styleClass="span2" styleId="selectedFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
		</div><!-- end of form form-mod -->
		
		
		
		<div class="form-mod entitylookup">
		<h3><span class="conditional-borrower"></span></h3>
			
				<div id="1a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label><span class="conditional-borrower"></span>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="borrowerInfofailed" style="display:none;">Please enter <span class="conditional-borrower"></span> </span>
								<span  class="help-block notfound error" id="borrowerInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error duplicate" id="borrowerGoldIdInvalid" style="display:none;"><span class="conditional-lender"></span> & <span class="conditional-borrower"></span> must be different</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="borrowerSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" maxlength="9" class="span3 entity-filtervalue" data-cmd="getLE" id="borrowerOrRecipient" style="text-transform:uppercase"/>
								<span id="borrowerInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1a" class="btn entity-lookup" data-cmd="getLE" type="submit">Search</a>
								<label class="checkbox info-checkbox pending">
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.borrowerEntity.entitySetupFlag" value = "Y" styleClass="" styleId="borrowerEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right clear-conditional-results" href="#" type="submit"onclick="javascript:clearBorrowerDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="borrowerGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" >
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" styleClass="leName"/>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country" styleClass="country"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd" styleId="borrowerLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" styleId="borLEGoldId" styleClass="leGoldId" />
						</div>
						
						<div id="borrowerPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row">
									<p><b><span class="condition-borrowerReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="borrowerRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" disabled="disabled" styleId="borRegulatedEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" disabled="disabled" styleId="borRegulatedEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-borrowerPrn required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="borrowerPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" styleId="borPrincplEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" styleId="borPrincplEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					
					</div> 
						
				</div>
				
			
			<div class="row MESearch">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span>	</label>
						<span  class="help-block error" id="borrowerMgmtfailed" style="display:none;">Please select Management Entity </span>
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
						
 						<span id="borrowerMgmtfailedBar" class="req-error" style="display:none;">error</span>

 						<a href="#1a" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1a" class="btn-link clear-conditional-results">Clear results</a>
					</div>
				</div> <!-- end of block -->
				<div  id="borrowerCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="borrowerCapfailed" style="display:none;">Please select Capital or Industrial</span>
						<div class="radio-container" id="borrowerCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<div id="BorrowerSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="BorrowerSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
							<input type="hidden" name="legSummary.borrowerEntity.capitalIndust" class="capitalIndustrial">
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" styleId="borrowerCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
				
			</div>
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" /></p>
						<input class="meValue" id="selectedBorrowerMgmtEntity" type="hidden" name="legSummary.borrowerEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" />"/>
					</div>					
				</div>		
				</div>			
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block invalid error" id="borrowerTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" class="span3" data-provide="typeahead"  id="borrowerTreasuryCode" style="text-transform:uppercase"/>
						<span id="borrowerTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						<a class="btn addtcode alwaysone" type="submit" data-assign="legSummary.borrowerTCodeEntity.treasuryCode">Search</a>
						<a class="btn-link right clear-conditional-results" id="clearBorrowerTCode" href="#" type="submit" ><bean:message key="label.addLeg.clearResults"/></a>
					</div>
				</div> <!-- end of block -->
				
				<div id="borBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="borBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" >
								<div id="borBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="borBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
								<input type="hidden" name="legSummary.borrowerEntity.businessSegment" class="businessSegment" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" />">
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div id="borrowerTreasuryDetails" class="row conditional-row">
				<div class="span5 highlighted">					
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" styleId="borrowerTreasuryGoldId" />
					</div>					
				</div>
				
			</div>
			
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="ICFPLegRequestForm" property="legSummary.borrowerEntity.fundHoldOperationId" styleClass="span2" styleId="selectedBorFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
		</div><!-- end of form form-mod -->
		
		<div class="form-mod">
		<h3 class="span12">Product Details</h3>
		
		<c:choose>
		<c:when test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 2}">
			<%-- ProductType 2 is for Equity --%> 
			<%@include file="fundingRequest/equityProductDetail.jsp" %>
		</c:when>
		<c:otherwise>
			<%@include file="fundingRequest/rcaProductDetail.jsp" %>	
		</c:otherwise>
		</c:choose>
			
		<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="edit" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
		
		<div id="othersDescriptionComments">
			<h3 class="span12" >Description</h3>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<div class="autosize-container1">
								<span class="required">*</span>
                           		<label>&nbsp;</label>
                            	<div class="char-count otherDescChar" style="margin-left:-10px;">1000</div>
                            	<html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="description"  styleId="otherDesc" tabindex="3" rows="1"  onblur="scriptInjection(this);"></html:textarea>
                            	<span id="otherDesBar" class="req-error" style="display:none;">error</span>
                        	</div>
						</div>	
						</div>
						</div>
						</div>
		</div>	
					
		  <!-- starts uploads-->
         <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        	</jsp:include>  
      	  <!-- end uploads -->
        
		
		
		<div class="span8 right btn-container">
	
		<c:if test="${sessionScope.section eq 'myTasks'}">
			<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal');">
			<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');">
		</c:if>
		<c:if test="${sessionScope.section eq 'myRequests'}">
			<c:choose>
					<c:when test="${empty deal.WFStage}">
					<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT'}"> 
					<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal');">
					<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');">
					</c:if>
					<c:if test="${empty deal.action}"> 
					<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal');">
					<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');">
					</c:if>
					</c:when>
			</c:choose>
		</c:if>
		
		<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>
		</div>
		<input type="hidden" id="actionId" value="${actionId}">
		</form>
   <hr>
   
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the leg</a>
		</div>
	</div>
	
	<div class="modal hide fade" id="lookup">
		<div class="modal-header">
			<a class="close" href="javascript:closeLookUpModal()">X</a>
			<h3>Lookup Results</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Select one to save.</strong> 
        	</div>
			<div class="form-row autosize-container">
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:void(0);" class="btn right btn-success saveSelectEntity">Save selection</a>
			<a class="btn-link right cancel" href="javascript:closeLookUpModal()">Cancel</a>
		</div>
	</div>
  

