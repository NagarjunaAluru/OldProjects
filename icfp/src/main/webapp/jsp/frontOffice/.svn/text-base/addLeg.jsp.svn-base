<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page errorPage="../common/error.jsp" %>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<t:common/>
 
<% String servletContextUrl = request.getContextPath(); 
%>
    <title>ICF | Add a Leg</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 	var contextURL = '<%=servletContextUrl%>';</script>
	<script src="<%=servletContextUrl%>/js/addDerivative.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/addFOLeg.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/commonLeg.js" type="text/javascript"></script>	
	<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="${context}/js/frontoffice/addLeg.js"></script>	
	<script>
	
	$(document).ready(function() {
	   // Show Next Leg navigation if it's not last leg
       var lastLegVar = '<%=request.getAttribute("proceedtoNextLeg")%>';
  	   if(lastLegVar=='yes')
 		   {
 		   $('#reviewNextLegID').show();
 		   }else {
 			   $('#reviewNextLegID').hide();
 		   } 
	});	
	
	</script>	
	<script>
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
		<div class="clear"></div>
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
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
        </div>
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
      	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
		<html:form action="/frontoffice/RCALegRequest.do" styleId="ICFPLegRequestForm" enctype="multipart/form-data" >
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<c:if test="${not empty sessionScope.currentDate}">
				<c:set var="requestFrmtDt" value="${sessionScope.currentDate}"/>
		</c:if>
		<c:if test="${not empty sessionScope.valueDate}">
				<c:set var="valueDate" value="${sessionScope.valueDate}"/>
		</c:if>
		
		<input type="hidden"  id="valueDateID" value="${valueDate}"/>
		<input type="hidden"  id="todayDateID" value="${requestFrmtDt}"/>	
		<input type="hidden"  id="legNumberID" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber"/>" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		<input type="hidden"  id="noOfLegsId" name="noOfLegs" value="${requestScope.noOfLegs}"/>
		<div class="form-mod entitylookup">
		<%@ include file="../common/inc/newTransactionSummary.jsp"%>	
			<h2 class="span12">Details</h2>
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
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error duplicate" id="lenderDiffFailed" style="display:none;"><span class="conditional-lender"></span> & <span class="conditional-borrower"></span> must be different</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="lenderSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								<input type="text"  maxlength="9" class="span3 entity-filtervalue" data-cmd="getLE" id="lenderOrProvider" style="text-transform:uppercase"/>
								<span id="lenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1" class="btn  entity-lookup" type="submit" data-cmd="getLE">Search</a>
								<label class="checkbox info-checkbox pending ">
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.lenderEntity.entitySetupFlag" styleClass="" styleId="lenderEntitySetupFlag" value="Y"/>
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
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleId="regulatedEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleId="regulatedEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag"/>
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
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" styleId="princplEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" styleId="princplEntityFlag2" value="false"/>
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
 						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>

 						<a href="#1" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1" class="btn-link clear-conditional-results">Clear results</a>

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
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
				
				
			</div>

			<div class="row highlighted ME conditional-row">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" /></p>
						<input class="meValue" id="selectedLenderMgmtEntity" type="hidden" name="legSummary.lenderEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" />"/>
					</div>					
				</div>		
			</div>			

			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block invalid error" id="lenderTreasuryInvalid" style="display:none;"></span>
						<input type="text" maxlength="20" name="legSummary.lenderTCodeEntity.treasuryCode" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" />" id="lenderTreasuryCode" class="span2" data-provide="typeahead" style="text-transform:uppercase" data-source=""/>
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
							<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" styleClass="businessSegment"/>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row conditional-row" id="lenderTreasuryDetails">
				
				<div class="span5 highlighted">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" styleId="lenderTreasuryGoldId" />
					</div>
				</div><!-- end of block -->
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
		<div class="form-mod  entitylookup">
		<h3><span class="conditional-borrower"></span></h3>
				<div id="1a" class="tab-pane fade active in">
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
								
								<select class="span14 cpa-search-id  entity-filtername" id="borrowerSearchId">
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
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd" styleId="borrowerLegalEntityGoldId" styleClass="cdrCd"/>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" styleId="borLEGoldId" styleClass="leGoldId"/>
						</div>
						
						<div id="borrowerPEorMEDiv">
						<div class="row ">
							<div class="span7">
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
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" styleId="borRegulatedEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" styleId="borRegulatedEntityFlag2" value="false"/>
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
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="borrowerMgmtfailed" style="display:none;">Please select Management Entity </span>
						<input type="text" class="span2 meinput"  style="text-transform:uppercase" maxlength="20"/>
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
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" styleId="borrowerCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
				
			</div>

			<div class="row highlighted ME conditional-row">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" /></p>
						<input class="meValue" id="selectedBorrowerMgmtEntity" type="hidden" name="legSummary.borrowerEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" />"/>
					</div>					
				</div>		
			</div>			

			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block invalid error" id="borrowerTreasuryInvalid" style="display:none;"></span>
						<input type="text" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" />" maxlength="20" class="span2" data-provide="typeahead"  id="borrowerTreasuryCode" style="text-transform:uppercase"/>
						<span id="borrowerTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						<a class="btn addtcode alwaysone" type="submit" data-assign="legSummary.borrowerTCodeEntity.treasuryCode">Search</a>
						<a class="btn-link clear-conditional-results" id="clearBorrowerTCode" href="#" type="submit" ><bean:message key="label.addLeg.clearResults"/></a>
						
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
							<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" styleClass="businessSegment"/>
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
				</div><!-- end of block -->
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
		<h2 class="span12">Product Details</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.productType" /></label>
						
						<bean:write name="ICFPLegRequestForm" property="legSummary.productType" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="productType" />
					</div>
				</div> <!-- end of block -->
				<div id="formOfEquityDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Form of Equity</label>
						<html:select name="ICFPLegRequestForm" property="equityFormId" styleClass="span2 form-of-equity" styleId="equityFormId">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="formOfEquity" value="ID" label="name"/>
						</html:select>
						<span id="equityFormValidate" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
				<div id="allProductTypeDiv" class="product-type-all"  style="display:none;">
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
											<html:select name="equityDetails" property="shareTypeId" styleClass="span2 request-equity" styleId="shareTypeId">
												<html:option value="">Select..</html:option>
												<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
											</html:select>
										</div>
									</td>
									<td>
										<div class="form-row">
											<span class="required">*</span>
											<html:text name="equityDetails" property="numberOfShares" styleClass="span2 request-noOfShares" styleId="numberOfShares" maxlength="9"/>
										</div>
									</td><td>
										<div class="form-row">
											<span class="required">*</span>
											<html:text name="equityDetails" property="shareValue" styleClass="span2 request-sharevalue" styleId="shareValue" maxlength="9"/>
											 <html:hidden name="equityDetails" property="sharePrfId"/>
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
											<select name="shareTypeId" class="span2 request-equity">
												<option value="">Select..</option>
												<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
													<option value="${option.ID}">${option.name}</option>
												</c:forEach>
											</select>
										</div>
									</td>
									<td>
										<div class="form-row">
											<span class="required">*</span>
											<input name="numberOfShares" type="text" class="span2 request-noOfShares" maxlength="9">
										</div>
									</td><td>
										<div class="form-row">
											<span class="required">*</span>
											<input name="shareValue" type="text" class="span2 request-sharevalue" maxlength="9">
											<input name="sharePrfId" type="hidden" value="">
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
					
						<div id="debtProductTypeDiv" class="product-type-debtfields" style="display:none;">
				<h3 class="span12">Equity Details</h3>
				<div class="row">
					<div class="span12">
					 <table class="table table-striped table-bordered equityDebt-validation">
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
				
						  <tr id="debTr1">
							<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="debtTerms" styleClass="span2 requestDebt-equity" styleId="numberOfShares" maxlength="20"/>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:select name="equityDetails" property="shareTypeId" styleClass="span2 requestDebt-equity" styleId="shareTypeId">
										<html:option value="">Select..</html:option>
										<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
									</html:select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="numberOfShares" styleClass="span2 requestDebt-noOfShares" styleId="numberOfShares" maxlength="9"/>
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="shareValue" styleClass="span2 requestDebt-sharevalue" styleId="shareValue" maxlength="9"/>
									 <html:hidden name="equityDetails" property="sharePrfId" />
								</div>
							</td>

						  </tr>
						  	</logic:iterate>
						</c:when>
						
						<c:otherwise>
						<tr class="debTr2" id="debTr2">
						<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="debtTerms" type="text" class="span2 requestDebt-equity" maxlength="20">
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<select name="shareTypeId" class="span2 requestDebt-equity">
										<option value="">Select..</option>
										<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
											<option value="${option.ID}">${option.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="numberOfShares" type="text" class="span2 requestDebt-noOfShares" maxlength="9">
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="shareValue" type="text" class="span2 requestDebt-sharevalue" maxlength="9">
									<input name="sharePrfId" type="hidden" value="">
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
						
			<div id="termDiv" class="row">
				<div class="span5">
					<div class="form-row">
						<div id="termMandatoryDiv"><span class="required">*</span></div>
						<label><bean:message key="label.addLeg.term" /> <span class="small"><bean:message key="label.addLeg.inMonths" /></span>
						<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="8" styleClass="span1" styleId="termInMonths" />
						<span id="termValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div id="commenstDiv">
			<h3 class="span12">Description</h3>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<div class="autosize-container1">
                           		<label>&nbsp;</label>
                            	<div class="char-count otherEquityChar" style="margin-left:-10px;">1000</div>
                            	<html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="otherEquityComments"  styleId="equityDescriptionID" tabindex="3" rows="1"  onblur="scriptInjection(this);"></html:textarea>
                            	<span id="equityDescBar" class="req-error" style="display:none;">error</span>
                        	</div>
						</div>
					</div> <!-- end of block -->
				</div>
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
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="false"/>
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
							<input type="text" id="originalCCY" name="legSummary.originalCCY"
							 value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							 class="span2 amount" data-provide="typeahead" 
							 data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
					</div>
					</div>
			</div>
			<div class="row">

				<div id="amountDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.amount" />
							<span data-original-title="<bean:message key="label.fundingRequestaddLegTooltip.amount" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Amount</span>
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
	
						 <input type="text"  name="legSummary.originalCCYAmount" id="originalCCYAmount"
							maxlength="30" class="span2 currency" data-for="amount"
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
						<span class="req-error" style="display:none;">error</span>  
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
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right" id="usdEquiDiv">
					<div class="form-row">
							<p><b>USD equivalent</b></p>
							<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
							<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
								<p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
							</c:if>
						</div>
					</div><!-- end of block -->
				</div>
				<!-- start Bond leg new fields -->
			<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 6}" >
				<div class="row">
					<div style="display:none;">
						<div class="span5 conditional-select-rca">
						</div> <!-- end of block -->
					</div>
					<div  class="span5 right">
						<div class="form-row">
							<label>Issue Price %</label>
							<html:text name="ICFPLegRequestForm" maxlength="6" styleId="issuePriceID"  property="legSummary.issuePrice"  styleClass="span1" />
							<span id="issuePricefailedBar" class="req-error" style="display:none;">error</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div style="display:none;">
						<div class="span5 conditional-select-rca">
						</div> <!-- end of block -->
					</div>
					<div  class="span5 right">
						<div class="form-row">
							<label>Agent/Dealer Commission %</label>
							<html:text name="ICFPLegRequestForm" maxlength="6" styleId="agentDealerCommissionID"  property="legSummary.agentDealerCommission"  styleClass="span1" />
							<span id="agentDealerCommissionfailedBar" class="req-error" style="display:none;">error</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div  style="display:none;">
						<div class="span5 conditional-select-rca">
						</div> <!-- end of block -->
					</div>
					<div  class="span5 right">
						<div class="form-row">
							<label>Net Proceeds</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<html:text name="ICFPLegRequestForm" maxlength="25" styleId="netProceedsID"  property="legSummary.netProceedsAmt"  styleClass="span2 currencynegnoconversion" />
							<span id="netProceedsIfailedBar" class="req-error" style="display:none;">error</span>
						</div>
					</div>
				</div>
			</c:if>
				<!-- end Bond led new fields  -->
				<div id="derDiv" class="row" style="display:none;">
					<div id="derDivEquity" class="span5" style="display:none;">
						<div class="form-row">
							<div id="derMandatoryDiv"><span class="required">*</span></div>
							<label>Are there Derivatives?</label>
							<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Are there Derivatives?</span>
							<div id="derivativDiv" class="radio-container derivativesConditional">
								<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="true" styleClass="condition"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="false"/>
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
									<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="true"/>
									Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="false"/>
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
								<input type="button" value="Add a Derivative" tabindex="18" class="btn" onclick="javascript:addDerivatives('?command=addDerivatives');">
								

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
									<tr id='dealDeriv'${derivative.derivativeNumber}>
										<td><a href="javascript:void(0);" id="deleteDerivative" title="Delete this derivative" class="delete-tr" onclick="javascript:deleteDerivative(this);">X</a></td>
										<td><a href="javascript:void(0);" id="edit-derivative" class="edit-leg ttip" data-original-title="Edit this derivative" onclick="javascript:modifyDerivative(this);"></a></td>
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
		<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId ne 2}" >	
		<div id="formOfRCALegDiv">	
		<div class="form-mod">
			<h2 class="span12 collapsible">Terms and Conditions</h2>
			<div class="clear"></div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Currency</b><br/>
							<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Principal amount</b><br />
							<bean:write name="ICFPLegRequestForm" property="legSummary.USDEquivalent"/></p>
					</div>
				</div><!-- end of block -->
			</div> 
			
			
			<div class="row" id="immediateDrawDownID">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Immediate drawdown applicable</label>
						<span  class="help-block error" id="immediateDrawdownFailed" style="display:none;">Please select Immediate drawdown applicable</span>
						<div id="immediateDrawdownDiv" class="radio-container immediate-Drawdown-condition">
							<span id="immediateDrawdownFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="immediate-Drawdown-yes-condition" styleId="isImmediateDrawDown" property="immdtDrdownApplicableFlag" value="true"/>
								Yes
							</label>
							<div id="immdtDrdownAmtDiv" class="form-row immdtDrdownAmt-container" style="display:block;">
								<div class="form-row">
									<span class="required">*</span>
									<label>Immediate drawdown amount</label>
									
									<span  class="help-block invalid error" style="display:none;">Invalid value </span>
									<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 1}" >
									<input type="text"  name="immdtDrdownAmt" maxlength="30" class="span2 currencynoconversion" id="immediateDrawDownAmt" value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.immdtDrdownAmt}" />" />
									</c:if>
									
									<span class="req-error" style="display:none;">error</span>
									<span id="immdtDrdownAmtfailedBar" class="req-error" style="display:none;">error</span>
									
								</div>
								<div class="form-row">
									<span class="required">*</span>
									<label>Immediate Drawdown Value Date</label>
									<span id="drawdownvalueDtErrorID" class="help-block error" style="display:none;"><bean:message key="immDrawDownDateValidation" /></span>
							        <span id="drawdownvalueDtTodayID" class="help-block error" style="display:none;"><bean:message key="immDrawDownDateValidationForTodayDate" /></span>
									<html:text name="ICFPLegRequestForm"  styleId="immediateDrawdownValueDateID"  property="drdownValueDt"  readonly="true"  styleClass="span3 datepicker-field" maxlength="10"   />
									<span id="drdownValueDtfailedBar" class="req-error" style="display:none;">error</span>
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
								</div>
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="immediateDrawdown-condition" styleId="isImmediateDrawDown" property="immdtDrdownApplicableFlag" value="false"/>
								 No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>	
		
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required" id="interestTypeStar">*</span>
						<label>Interest type</label>
						<span  class="help-block error" id="interestFailed" style="display:none;">Please select Interest Type</span>
						<div id="interestTypeDiv" class="radio-container intrest-type-condition">
							<span id="interestFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="fixedOrFloatRadioId" styleClass="fixed-condition" property="rateInformation.interestTypeId" value="1" onclick="javascript:fixedClick();"/>
								Fixed
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="fixedOrFloatRadioId" styleClass="float-condition" property="rateInformation.interestTypeId" value="2" onclick="javascript:floatClick();"/>
								Float
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
		<div class="form-mod fixed-container" style="display:block;">
			<h3 class="span12">Fixed</h3>
			<div class="row">
				<div class="span5 ">
					<div class="form-row">
						<span class="required">*</span>
						<label>Base fixed rate %</label>
						
						<input type="text" name="rateInformation.baseFixedRate" id="baseFixedRateID" class="span1"
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.rateInformation.map.baseFixedRate}" />"/>
					
						<span id="baseFixedRatefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Spread (bps)</label>
						<span  class="help-block invalid error" id="fixedSpread" style="display:none;">Invalid value </span>
						<span  class="help-block error" id="fixedSpreadIDFailed" style="display:none;">Spread must be between <bean:write name="ICFPLegRequestForm" property="rateInformation.minSpread"/> and <bean:write name="ICFPLegRequestForm" property="rateInformation.maxSpread"/></span>
						<html:text name="ICFPLegRequestForm" maxlength="8" styleId="fixedSpreadID"  property="rateInformation.spread"  styleClass="span1 dual-selects spreadvalidate" />
						<span id="fixedSpreadfailedBar" class="req-error" style="display:none;">error</span>						
					</div>
				</div> <!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" styleId="fixedMinSpreadID" property="rateInformation.minSpread" />
				<html:hidden name="ICFPLegRequestForm" styleId="fixedMaxSpreadID" property="rateInformation.maxSpread" />
			</div>
		</div><!-- end of form form-mod -->
		<div class="form-mod float-container" style="display:block;">
			<h3 class="span12">Float</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Float Rate Index</label>
						<span  class="help-block error" id="floatRatefailed" style="display:none;">Please select Float Rate</span>
						 <html:select name="ICFPLegRequestForm" property="rateInformation.floatingRateIndex" styleId="floatRateIndexId" styleClass="span3" onchange="getFOIndexTermDetails()">
							<html:option value="">Select</html:option>
							<logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
								<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
							</logic:notEmpty>
						</html:select>
						<span id="floatRatefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Spread (bps)</label>
						<span  class="help-block invalid error" id="floatSpread" style="display:none;">Invalid value </span>
						<span  class="help-block error" id="floatSpreadIDFailed" style="display:none;">Spread must be between <bean:write name="ICFPLegRequestForm" property="rateInformation.minSpread"/> and <bean:write name="ICFPLegRequestForm" property="rateInformation.maxSpread"/></span>
						<html:text name="ICFPLegRequestForm" maxlength="8" styleId="floatSpreadID"  property="rateInformation.spread"  styleClass="span1 dual-selects spreadvalidate" />
						<span id="floatSpreadfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" styleId="floatMinSpreadID" property="rateInformation.minSpread" />
				<html:hidden name="ICFPLegRequestForm" styleId="floatMaxSpreadID" property="rateInformation.maxSpread" />
			</div>
			<div class="row" id="indexTermDivID">
					
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Float Rate Index term</label>
						<!-- need to change -->
						<span  class="help-block error" id="floatRateTermfailed" style="display:none;">Please select Float Rate Index term</span>
						 <html:select name="ICFPLegRequestForm" property="rateInformation.floatingRateIndexTerm" styleId="floatRateIndexTermId" styleClass="span2">
							    <html:option value="">Select..</html:option>
								<html:optionsCollection name="ICFPLegRequestForm" property="indexTermMap" label="value" value="key"/>
						</html:select>
						<span id="floatRateTermfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
					
			</div>
			
		</div><!-- end of form form-mod -->
		
		<div class="form-mod">
			<h3 class="span12">Fees and Withholding</h3>
			<div class="row">
				<div class="span5" id="commitmentFeeDiv">
					<div class="form-row">
						<label>Commitment fee applicable<span class="ttip info" data-original-title="<bean:message key="label.tooltip.commitmentFee" />"></span></label>
						<span  class="help-block error" id="commitmentFeeApplicableFailed" style="display:none;">Please select Commitment Fee Applicable</span>
						<div id="commitmentFeeApplicableDiv" class="radio-container">
							<span id="commitmentFeeApplicableFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="commitmentFeeApplicableFlagId" property="commitmentFeeApplicableFlag" value="true" disabled="true" />
								<bean:message key="label.addLeg.yes" />
							</label>
							<div class="form-row conditional-container input-append" id="commitmentFeeRateDivID">
								<div class="form-row" >
									<span class="required">*</span>
									<label>Commitment Fee Rate</label>
									<logic:messagesPresent property="commitmentFeeRate">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
						  				<input type="text" name="commitmentFeeRate" id="commitmentFeeRateID" maxlength="9" 
						  				disabled="disabled" class="span1" 
						  				value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.commitmentFeeRate}" />" 
						  				/>									 	
									<span class="add-on">%</span>
								</div>
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="commitmentFeeApplicableFlagId" property="commitmentFeeApplicableFlag" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Withholding tax applicable<span class="ttip info" data-original-title="<bean:message key="label.tooltip.withholdingFee" />"></span></label>
						<span  class="help-block error" id="withhldngTaxApplicableFailed" style="display:none;">Please select Commitment Fee Applicable</span>
						<div id="withhldngTaxApplicableDiv" class="radio-container">
							<span id="withhldngTaxApplicableFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="withhldngTaxApplicableFlagId" property="withhldngTaxApplicableFlag" value="true" />
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="withhldngTaxApplicableFlagId" property="withhldngTaxApplicableFlag" value="false" />
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Guarantee fee applicable<span class="ttip info" data-original-title="<bean:message key="label.tooltip.guaranteeFee" />"></span></label>
						<span  class="help-block error" id="guaranteeFeeApplicableFailed" style="display:none;">Please select Commitment Fee Applicable</span>
						<div id="guaranteeFeeApplicableDiv" class="radio-container">
							<span id="guaranteeFeeApplicableFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="guaranteeFeeApplicableFlagId" property="guaranteeFeeApplicableFlag"  onclick="showGuarantorInfo()" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<div class="form-row conditional-container input-append" id="guaranteeFeeRateDivID">
								<div class="form-row" >
									<span class="required">*</span>
									<label>Guarantee  fee rate</label>
									<logic:messagesPresent property="guaranteeFeeRate">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
						  			<input type="text" name="guaranteeFeeRate" id="guaranteeFeeRateID" class="span1"
						  			  disabled="disabled" maxlength="9"
						  			  value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.guaranteeFeeRate}" />"/>
									<span class="add-on">%</span>
								</div>
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="guaranteeFeeApplicableFlagId" property="guaranteeFeeApplicableFlag"  onclick="showGuarantorInfo()" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			
			
				<div class="span5 right" id="OtherFeeDiv">
					<div class="form-row">
						
						<label>Other fees</label>
						<span  class="help-block error" id="otherfeesFailed" style="display:none;">Please select Other fees</span>
						<div id="otherfeesDiv" class="radio-container otherfees-condition">
							<span id="otherfeesFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="otherfees-yes-condition" styleId="isOtherfees" property="otherFeeFlag" value="true"/>
								Yes
							</label>
							<div id="otherfeesAmtDiv" class="form-row otherfeesAmt-container" style="display:block;">
								
								<div class="form-row">
									<span class="required">*</span>
									<label>Currency</label>
									<span  class="help-block error" id="otherFeeCCYValidate" style="display:none;">Please select Other fee currency </span>
									<input type="text" id="otherFeeCCY" name="otherFeeCCY" value="<bean:write name="ICFPLegRequestForm" property="otherFeeCCY"/>"
									class="span2" data-provide="typeahead" 
									data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
	 								<span id="otherFeeCCYValidateBar" class="req-error" style="display:none;">error</span>
								</div>
									
								  <div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.addLeg.amount" /></label>
									<span  class="help-block error" id="otherFeeAmtValidate" style="display:none;">Please enter Amount</span>
									<span  class="help-block invalid error" style="display:none;">Invalid value </span>
									<input type="text"  name="legSummary.fees" maxlength="30" class="span2 currencynoconversion" id="otherFeeAmt" value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.fees}" />"/> 
									<span id="otherFeeAmtValidateBar" class="req-error" style="display:none;">error</span>
								 </div>
														
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="otherfees-condition" styleId="isOtherfees" property="otherFeeFlag" value="false"/>
								 No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>	<!-- Other fee start -->
			
			
			
		</div><!-- end of form form-mod -->
		<div id="guaranteedivid" class="form-mod entitylookup" >
			<h3 class="span12"><bean:message key="label.addLeg.guarantorInfo" /></h3>
			<div class="row">
				<div class="span9">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.guarantorLegalEntityCDRCode" /></label>
							<span  class="help-block error" id="guarantorInfofailed" style="display:none;">Please enter Legal Entity CDR Code</span>
							<span  class="help-block error" id="guarantorInfoInvalid" style="display:none;">Invalid value </span>
							<input type="text" name="legSummary.guarantorEntity.CDRCd" value="<bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.CDRCd" />" maxlength="9" class="span3" data-cmd="getLECDR" id="guarantorInfo" style="text-transform:uppercase"/>
							<span id="guarantorInfofailedBar" class="req-error" style="display:none;">error</span>
							<input type="hidden" class="entity-filtername" value="CDR"/>							
							<a id="searchByLegalEntityCDRCode" class="btn" type="submit"><bean:message key="label.search" /></a>
					</div>
				</div> <!-- end of block -->
			</div>
			 <html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.leTypeId" />
			<div id="guarantorGoldIdDetails" class="conditional-row"><!-- guarantor changes start -->
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEName" styleClass="leName"/>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.guarantorGoldId" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEGoldId" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.LEGoldId" styleClass="leGoldId" />
									
								</div>
							</div><!-- end of block -->
						</div>
						
			
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.guarantorPrincipalEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.princplEntityFlag" >
	                                    <p>-</p>
                                    </logic:empty>
                                    <logic:notEmpty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.princplEntityFlag" >
                                       <logic:equal name="ICFPLegRequestForm" property="legSummary.guarantorEntity.princplEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.guarantorEntity.princplEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
                                   </logic:notEmpty>
                                   <html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.princplEntityFlag" styleClass="princplEntityFlag"/>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.guarantorregulatedEntity" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.regulatedEntityFlag" >
	                                    <p>-</p>
                                    </logic:empty>
                                    <logic:notEmpty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.regulatedEntityFlag" >
                                       <logic:equal name="ICFPLegRequestForm" property="legSummary.guarantorEntity.regulatedEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.guarantorEntity.regulatedEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
                                   </logic:notEmpty>
                                   <html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag"/>
								</div>
							</div><!-- end of block -->
						</div>
					<html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.capitalIndustrial" styleClass="capitalIndustrial"/>
					<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.guarantorEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.guarantorEntity.country">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.guarantorEntity.country" styleClass="country"/>
								</div>
					</div><!-- end of block -->	
			</div><!-- guarantor changes end -->
			
			
			<div class="row MESearch">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="guarantorMgmtfailed" style="display:none;">Please select Management Entity </span>
						<input type="text" class="span2 meinput"  style="text-transform:uppercase" maxlength="20"/>
 						<span id="guarantorMgmtfailedBar" class="req-error" style="display:none;">error</span>

 						<a href="#1b" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1b" class="btn-link clear-conditional-results">Clear results</a>
					</div>
				</div> <!-- end of block -->
					
				
			</div>

			<div class="row highlighted ME conditional-row">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.MEName" /></p>
						<input class="meValue" id="selectedGuarantorMgmtEntity" type="hidden" name="legSummary.guarantorEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.guarantorEntity.MEName" />"/>
					</div>					
				</div>		
			</div>			
			
			
			
		 </div>
		</div>
		</c:if>
			<div class="form-mod">
			<h2 class="span12">Other Considerations</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>

						<label>Cross border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></label>

						<span  class="help-block error" id="crossBorderFailed" style="display:none;">Please select Cross border</span>
						<div id="crossBorderDiv" class="radio-container">
							<span id="crossBorderFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="crossBorderFlagId" property="crossBorderFlag" value="true" />
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="crossBorderFlagId" property="crossBorderFlag" value="false" />
								<bean:message key="label.addLeg.no" />
							</label>
						</div>

					</div>
				</div> <!-- end of block -->
				 <!-- end of block -->
			</div>
			 <div class="row">
					<div class="span5">
					<div class="form-row">
						<div id="excepMandatoryDiv"><span class="required">*</span></div>
						<label>Non-standard Legal Agreement(s)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="legSummary.nonStandardAgreementsFlag" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
						</div>
					</div>
					 <!-- end of block -->
					
					<div id="eBoardEligibleDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<p><b>eBoardroom eligible</b></p>
							<c:if test="${requestScope.eBoardARFlagValue == null}"> 
								<p>-</p>
							</c:if>
							<c:if test="${requestScope.eBoardARFlagValue != null && requestScope.eBoardARFlagValue eq 'No'}">
								<p>${requestScope.eBoardARFlagValue}</p>
							</c:if>
							<c:if test="${requestScope.eBoardARFlagValue != null && requestScope.eBoardARFlagValue eq 'Yes'}"> 
								<p>${requestScope.eBoardARFlagValue}</p>
							</c:if>
						</div>
					</div><!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
     
      
		<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="edit" name="mode"/>
		<jsp:param value="${param.id}" name="legIndex"/>      	
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
		
		  <!-- starts uploads-->
        
       <jsp:include page="qualitativeAssessment.jsp">
				<jsp:param name="factors" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk"/>			
		</jsp:include>
		
       <div class="form-mod">			
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="dealRequestForm"/>
				<jsp:param value="frontoffice/fourBlocker" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId} : Summary" name="name"/>
			    <jsp:param value="openLeg" name="method"/>
			    <jsp:param value="Front Office" name="origin"/>
			    <jsp:param value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" name="legNumber"/>			
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<html:textarea name="ICFPLegRequestForm" styleId="requestException" property="legSummary.comments" styleClass="xlarge autosize messageinput" rows="1" onblur="scriptInjection(this);"/>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        	</jsp:include>  
      	
		<jsp:include page="../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>
			<jsp:param value="frontoffice/fourBlocker" name="path"/>
		    <jsp:param value="Leg ${legSummaryVO.legSeqId} : Summary" name="name"/>
			<jsp:param value="openLeg" name="method"/>
			<jsp:param value="Front Office" name="origin"/>
			<jsp:param value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" name="legNumber"/>			
		</jsp:include>
        
        <input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
        <!-- end uploads -->
		<!-- ------------- -->
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID">
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
						</div>
					</div>
					
					<input type="button" class="btn btn-success btn-large" onclick="javascript:submitActionFORCALeg(this);"
					value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
					
				</div>
				
				<c:choose>
					<c:when test="${requestScope.nextLeg ne 'false'}">
						<input type="button" value="Save" class="btn right" style="margin-top: 85px;" onclick="javascript:saveAsDraft('?command=saveAsDraft&isFrontOffice=Yes');">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="button" value="Save" style="margin-top: 60px;" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft&isFrontOffice=Yes');">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:if>				
			</div>
		<!-- --------------- -->
		<input type="hidden" id="actionId" value="${actionId}">
		</html:form>
   <hr>
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
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
			<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the leg</a>
		</div>
	</div>
	 	<div class="modal hide fade" id="lookup">
		<div class="modal-header">
			<a class="close" href="javascript:closeLookUpModal()">X</a>
			<h3>Lookup Results</h3>
		</div>
		<div class="modal-body">
			<div class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Select one to save.</strong> 
        	</div>
			<div class="form-row autosize-container">
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success saveSelectEntity">Save selection</a>
			<a class="btn-link right cancel" href="javascript:closeLookUpModal()">Cancel</a>
		</div>
	</div>
