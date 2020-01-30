<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ge.icfp.util.Utils"%>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>
<%@page import="com.ge.icfp.util.StaticDataFactory,com.ge.icfp.util.MasterDataFactory" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib tagdir="/WEB-INF/tags/attachments" prefix="atmt" %>

<%@ page errorPage="common/error.jsp" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Add a Derivative</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <script>
    //Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
    </script>
    <%@include file="common/includeCssScripts.jsp" %>
	<script src="<%=servletContextUrl%>/js/addDerivative.js" type="text/javascript"></script>
	<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />	
	<c:set var="actionId" value="${requestScope.actionId}" />
	
		

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js">
</script>

	
  </head>





	
  <body>
	<div class="container main">
		<%@include file="common/headerSection.jsp" %> 
		<ul class="breadcrumb">
		<c:choose>
		
		   <c:when test="${actionId eq 2}">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes">Front Office</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">
					 <li><a  href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=openLeg&modify=true&legNumber=${legNumber}" >Amendment: ${legSummary.transactionEventType}</a><span class="divider">/</span></li>
					</c:if>
					<c:if test="${eventType!=6}">
					 <li><a  href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=openLeg&modify=true&legNumber=${legNumber}" >${legSummary.transactionEventType}</a><span class="divider">/</span></li>
					</c:if>
			</c:when>
			<c:otherwise>
				<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
				<li><a href="<%=servletContextUrl%>/RCALegRequest.do?command=redirectFundingRequest">Funding Request</a> <span class="divider">/</span></li>
				<li><a href="<%=servletContextUrl%>/derivativeRequest.do?command=redirectAddLeg&legNumber=<bean:write name="derivativesRequestForm" property="legNumber" />&derivativeNumber=<bean:write name="derivativesRequestForm" property="derivativeNumber" />">Add a Leg</a> <span class="divider">/</span></li>
			</c:otherwise>
			   
		</c:choose>
		 <logic:notEqual scope="session" name="addOrModifyDerivative" value="modify">
	    			<li class="active">Add a Derivative</li>
				</logic:notEqual>
				<logic:equal scope="session" name="addOrModifyDerivative" value="modify">
					<li class="active">Modify a Derivative</li>
				</logic:equal>
			</ul>
		
		
		
		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        <logic:notEqual scope="session" name="addOrModifyDerivative" value="modify">
		  
    		<h1 class="page-title span10">Add a Derivative</h1>
		</logic:notEqual>
		<logic:equal scope="session" name="addOrModifyDerivative" value="modify">
			<h1 class="page-title span10">Modify a Derivative</h1>
		</logic:equal>
        
		<p class="span12 left clear dashdesc"><bean:message key="label.addADerivative.newFunding" />
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
		<form action="<%=servletContextUrl%>/derivativeRequest.do" name="derivativesRequestForm" autocomplete="off" 
					id="fundingRequestForm" method="post"   enctype="multipart/form-data">
		<div class="form-mod">
				<h2 class="span12">Details</h2>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<span class="required">*</span>
							
							<label>Internal or External
							   <span class="ttip info" data-original-title="<bean:message key="label.fundingRequest.InternalToolTip" />"></span>
						   </label>
							<span  class="help-block error" id="internalOrExternalIdErrorSpan" style="display:none;"></span>
							<div class="radio-container" id="internalOrExternalIdErrorDiv">
								<label class="radio">
									<html:radio name="derivativesRequestForm" tabindex="11"  styleClass="condition" styleId="internalOrExternalId" property="internalOrExternal" value="Y" /> 
									Internal
								</label>
								<label class="radio">
									<html:radio name="derivativesRequestForm" tabindex="11"  styleClass="condition" styleId="internalOrExternalId" property="internalOrExternal" value="N" />
									External
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<!-- <span class="required">*</span> -->
							<label>Hedge Desigation - U.S. GAAP</label>
							 <html:select name="derivativesRequestForm" tabindex="12" styleId="hedgeDesigationId" property="hedgeDesignationId"  styleClass="span3 hedgeDesignation-select">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="hedgeDesignation" >
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="hedgeDesignation" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							<span id="hedgeDesigationIdErrorSpan" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<span class="required">*</span>
							<label>Derivative Type</label>
							<html:select name="derivativesRequestForm" tabindex="13" property="derivativeTypeId"  styleId="derivativeTypeId" styleClass="span2 derivative-select">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="derivativeTypes">
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="derivativeTypes" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							<span id="derivativeTypeIdErrorSpan" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right contractClass">
						<div class="form-row">
							<!-- <span class="required">*</span> -->
							<label>Contract Class</label>
							 <html:select name="derivativesRequestForm" tabindex="17" property="contractClassId" styleId="contractClassId" styleClass="span3">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="contractClass">
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="contractClass" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>	
							<span id="contractClassIdErrorSpan" class="req-error" style="display:none;">error</span>				
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
				
					<div id="termDiv" class="span15">
						<div class="form-row">
							<div id="termMandatoryDiv"></div>
							<label>
								<bean:message key="label.addLeg.term" /> 
								<span class="small"><bean:message key="label.addLeg.inMonths" /></span>
							</label>
							<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
							<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
							<html:text name="derivativesRequestForm"  styleClass="span1" styleId="termInMonths" property="termInMonths" maxlength="5" />						   
							<span id="termValidateBar" class="req-error" style="display:none;">error</span>
						</div>
					 </div>
				
					<div class="span15 right hedgeProgram">
							<div class="form-row">
								<!-- <span class="required">*</span> -->
								<label>Hedge Program</label>
								 <html:select name="derivativesRequestForm" tabindex="14" property="hedgeProgramId" styleId="hedgeProgramId" styleClass="span3">
									<html:option value="">Select</html:option>
									<logic:notEmpty name="com.ge.icfp.StaticData"  property="hedgePrograms">
										<html:optionsCollection name="com.ge.icfp.StaticData"  property="hedgePrograms" value="ID" label="name"/>
									</logic:notEmpty>
								</html:select>
								<span id="hedgeProgramIdErrorSpan" class="req-error" style="display:none;">error</span>
							</div>
						</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label>Tax Desigation</label>
							 <html:select name="derivativesRequestForm" tabindex="20" property="taxDesignationId" styleId="taxDesigationId" styleClass="span4">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="taxDesignation">
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="taxDesignation" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							<span id="taxDesigationIdErrorSpan" class="req-error" style="display:none;">error</span>
					    </div>
					</div> <!-- end of block -->
					
					<div class="span15 right">
						<div class="form-row">
							<label>Manual Trade Request Workflow ID</label>
							<html:text name="derivativesRequestForm"  styleClass="span3" styleId="tradeRequestWorkID" property="tradeRequestWorkflowId" maxlength="50"/>
						</div>

					</div> <!-- end of block -->
				</div>
			<!-- 	////  lender start -->
			<div class="span15">
			<div class="form-mod entitylookup">
			<h2 >Counterparty 1 </h2>
				<div id="1" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<label><span class="conditional-lender"></span></label>
								<span  class="help-block error" id="lenderInfofailed" style="display:none;">Please enter <span class="conditional-lender"></span> </span>
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;"><bean:message key="label.adLeg.invalidValue" /> </span>
								<span  class="help-block error" id="lenderDiffFailed" style="display:none;"><span class="conditional-lender"></span> & <span class="conditional-borrower"></span> must be different</span>
								<span class="help-block error" id="firstCounterErrorMess" style="display:none;">Please enter different value</span>
								<select class="span2 cpa-search-id entity-filtername" id="lenderSearchId">
									<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
								</select>
								
								<input type="text" maxlength="9" class="span2 entity-filtervalue" id="lenderOrProvider" style="text-transform:uppercase"/>
								
								<span id="lenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE">Search</a>
							</div>
							<div class="form-row">
								<label class="checkbox info-checkbox pending">
									<html:checkbox name="derivativesRequestForm" property="counterPartyInfos[0].entity.entitySetupFlag" value="Y" styleClass="" styleId="lenderEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link" href="#" id="part1Clear" type="submit" onclick="javascript:clearCounterPart1();"><bean:message key="label.addLeg.clearResults" /></a>
							</div>
						</div> <!-- end of block -->
					</div> 
				<!-- 	  <div id="lenderGoldIdDetails" class="conditional-row">  -->
				<div id="lenderGoldIdDetails" class="conditional-row"> 
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[0].entity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[0].entity.CDRCd">
										<p class="cdrCd"><bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEName">
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEName">
										<p class="leName"><bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEName" /></p>
									</logic:notEmpty>
									   <html:hidden name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEName" styleId="cPart1LEName" styleClass="leName"/>
								</div>
							</div><!-- end of block -->
						 </div>
						 <div class="row highlighted">	
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEGoldId">
										<p class="leGoldId"><bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						 <div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="derivativesRequestForm" property="counterPartyInfos[0].entity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[0].entity.country">
										<p class="country"><bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.country" /></p>
									</logic:notEmpty>
										<html:hidden name="derivativesRequestForm" property="counterPartyInfos[0].entity.country" styleClass="country"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[0].entity.CDRCd" styleId="lenderLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[0].entity.LEGoldId" styleId="LEGoldId" styleClass="leGoldId"/>
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[0].entity.leTypeId" styleId="lenderLeTypeId" value="1" />
						</div>
				</div>
			<div class="row" id="counterPartyME1Id">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						<input type="text" maxlength="20" name="counterPrty[0].entity.MEName"  class="span2"  id="selectedLenderMgmtEntity" style="text-transform:uppercase"/>
 						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
 						<input type="button" name="Search" class="me-lookup"   value="Search" />
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="ME conditional-row">
			<div class="row highlighted" id="showDivMEDetailsID1">
				<div class="span5">
					<div class="form-row">
				  <p><bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.MEName" /></p>
					<input id="selectedLenderMgmtEntity" type="hidden" name="counterPartyInfos[0].entity.MEName" id="meName1" value="<bean:write name="derivativesRequestForm" property="counterPartyInfos[0].entity.MEName" />"/>
					</div>
				</div>
			</div>
			</div>		
			
		</div><!-- end of form form-mod -->
		</div>		
			<!-- 	///// lender ends -->
			<!--  ///// borrower start -->
		<div class="span15 right">
			<div class="form-mod entitylookup">
			<h2>Counterparty 2 </h2>
				<div id="1a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<label><span class="conditional-borrower"></span></label>
								<span  class="help-block error" id="borrowerInfofailed" style="display:none;">Please enter <span class="conditional-borrower"></span> </span>
								<span  class="help-block notfound error" id="borrowerInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="borrowerGoldIdInvalid" style="display:none;"><span class="conditional-lender"></span> & <span class="conditional-borrower"></span> must be different</span>
								<span class="help-block error" id="secondCounterErrorMess" style="display:none;">Please enter different value</span>
								<select class="span2 cpa-search-id entity-filtername" id="borrowerSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" maxlength="9" class="span2 entity-filtervalue"  id="borrowerOrRecipient" style="text-transform:uppercase"/>
								<span id="borrowerInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1a" class="btn entity-lookup" type="submit" data-cmd="getLE">Search</a>
								
							</div>
							<div class="form-row">
							<label class="checkbox info-checkbox pending">
									<html:checkbox name="derivativesRequestForm" property="counterPartyInfos[1].entity.entitySetupFlag" value = "Y" styleClass="" styleId="borrowerEntitySetupFlag"/>
									Legal Entity Setup Pending
							</label>
							<a class="btn-link" href="#" id="part2Clear" type="submit"onclick="javascript:clearCounterPart2();"><bean:message key="label.addLeg.clearResults" /></a>
							</div>
						</div> <!-- end of block -->
					</div> 
				<!-- 	<div id="borrowerGoldIdDetails" class="conditional-row"> -->
					<div id="borrowerGoldIdDetails" class="conditional-row" >
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[1].entity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[1].entity.CDRCd">
										<p class="cdrCd"><bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEName" >
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEName">
										<p class="leName"><bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEName" styleId="borLEName" styleClass="leName"/>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEGoldId">
										<p class="leGoldId"><bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="derivativesRequestForm" property="counterPartyInfos[1].entity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="derivativesRequestForm" property="counterPartyInfos[1].entity.country">
										<p class="country"><bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="derivativesRequestForm" property="counterPartyInfos[1].entity.country" styleClass="country"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[1].entity.CDRCd" styleId="borrowerLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[1].entity.LEGoldId" styleId="borLEGoldId" styleClass="leGoldId" />
						<html:hidden name="derivativesRequestForm" property="counterPartyInfos[1].entity.leTypeId" styleId="borLeTypeId" value="2" />
						</div>
				</div>
				
			
			<div class="row">	
							<div class="span5">
									<div class="form-row">
									
										<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
										<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
										<input type="text" maxlength="20" name="counterPty[1].entity.MEName" class="span2"  id="selectedBorrowerMgmtEntity" style="text-transform:uppercase"/>
				 						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
				 						<input type="button" class="me-lookup" name="Search" value="Search"  />
									</div>
							</div> <!-- end of block -->
						</div>
			<div class="ME conditional-row">
			<div class="row highlighted" id="showDivMEDetailsID2">
				<div class="span5">
					<div class="form-row">
					  <p><bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.MEName" /></p>
						<input type="hidden" name="counterPartyInfos[1].entity.MEName" id="meName2" value="<bean:write name="derivativesRequestForm" property="counterPartyInfos[1].entity.MEName" />"/>
					</div>
				</div><!-- end of block -->
			</div>				
		 </div>

		</div><!-- end of form form-mod -->
		</div>
			
			
			<!--  ///// borrower ends -->
			<div class="clear">
			</div>	
				<div class="row">
					<div class="span15">
					<h2>Currency 1</h2>
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency </label>
							<span id="currency1IdErrorSpan" class="req-error" style="display:none;">error</span>
							<input type="text" id="currency1Id" tabindex="15" name="counterPartyInfos[0].currencyPair" value="<bean:write name="derivativesRequestForm" property="currency1Name"/>"
						class="span1 left dual-selects" data-provide="typeahead" 
						data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
						
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
					<h2>Currency 2</h2>
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency </label>
							<span id="currency2IdErrorSpan" class="req-error" style="display:none;">error</span>							
							<input type="text" id="currency2Id" tabindex="16" name="counterPartyInfos[1].currencyPair" value="<bean:write name="derivativesRequestForm" property="currency2Name"/>"
						class="span1 left dual-selects" data-provide="typeahead" 
						data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
						</div>
					</div> <!-- end of block -->
				</div>
				
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span> -->
								<label>Amount</label>
								<span  class="help-block invalid error" id="counterParty1AmtID" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="derivativeAmount1IdMessageSpan" style="display:none;">Decimal number(Max 9 digits)</span>
								
								<input type="text"  name="counterPartyInfos[0].amt" maxlength="30" tabindex="18" class="span1 dual-selects currencynoconversion" id="derivativeAmount1Id" 
							onchange="javascript:commaAmount1();" value="<fmt:formatNumber  value="${sessionScope.derivativesRequestForm.map.counterPartyInfos[0].amt}" />"/>
							
								<span class="req-error" style="display:none;">error</span>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Amount</label>
								<span  class="help-block invalid error" id="counterParty2AmtID" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="derivativeAmount2IdMessageSpan" style="display:none;">Decimal number(Max 9 digits)</span>
								
								<input type="text"  name="counterPartyInfos[1].amt" maxlength="30" tabindex="19" class="span1 dual-selects currencynoconversion" id="derivativeAmount2Id" 
							onchange="javascript:commaAmount2();" value="<fmt:formatNumber  value="${sessionScope.derivativesRequestForm.map.counterPartyInfos[1].amt}" />"/>
							
								<span class="req-error" style="display:none;">error</span>
							</div>
						</div>
					</div> <!-- end of block -->
					
				
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
						
							<label>Fixed or Float</label>
							<span  class="help-block error" id="fixedOrFloatRadio1IdErrorSpan" style="display:none;"></span>
							<div class="radio-container conditional-radio-tri" id="FixOrFloat1Div">
								<label class="radio">
								    <html:radio name="derivativesRequestForm" tabindex="21" styleId="fixedOrFloatRadio1Id" styleClass="condition" property="fixedOrFloat1" onclick="showRateInfo()" value="Y" />
									Fixed
								</label>
								<div  id="fixedRateDivID1"  >
									<div class="form-row">
											<!-- <span class="required">*</span>-->
											<label>Fixed Rate</label>
											<span  class="help-block invalid error" style="display:none;">Invalid value </span>
											<span  class="help-block error" id="fixedFixedRateId1MessageSpan" style="display:none;">Numeric Percentage(Max 100)</span>
												<html:text name="derivativesRequestForm"  tabindex="1" property="counterPartyInfos[0].fixedRateValue" styleId="fixedFixedRateId1" styleClass="span1 dual-selects fixedRatevalidate" maxlength="8"/>
											<span class="req-error" style="display:none;">error</span>	
									</div>
								</div>
								<label class="radio">
								    <html:radio name="derivativesRequestForm" tabindex="22" styleId="fixedOrFloatRadio1Id" styleClass="condition" property="fixedOrFloat1" onclick="showRateInfo()"  value="N" />								
									Float
								</label>
								<div id="floatRateDivID1">
									<div class="form-row">
										<!-- <span class="required">*</span>-->
										<label>Index </label>
										 <html:select name="derivativesRequestForm" tabindex="23" property="counterPartyInfos[0].index" styleId="floatFixedRateId1" onchange="getIndexTermDetails('counterParty1')"  styleClass="span3 ">
											<html:option value="">Select</html:option>
											<logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
												<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
											</logic:notEmpty>
										</html:select>
										<span id="floatFixedRateId1ErrorSpan" class="req-error" style="display:none;">error</span>
									</div>
									<div  id="indexTermDivID1">
										<div class="form-row">
											
											<label>Index Term</label>
											
											<logic:messagesPresent property="counterPartyInfos[0].indexTerm">
														<span class="req-error" >a</span>
										 	</logic:messagesPresent>
										     <html:select name="derivativesRequestForm"  property="counterPartyInfos[0].indexTerm"  styleId="floatingRateIndexTermID" styleClass="span3">
											      <html:option value="">Select..</html:option>
											     <html:optionsCollection name="derivativesRequestForm" property="firstCurrencyIndexTermMap" label="value" value="key"/> 
											</html:select>
										</div>
									</div>  <!-- end of block -->
									 
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label>Fixed or Float</label>
							<span  class="help-block error" id="fixedOrFloatRadio2IdErrorSpan" style="display:none;"></span>
							<div  id="FixOrFloat2Div">
								<label class="radio">
								    <html:radio name="derivativesRequestForm" tabindex="22" styleId="fixedOrFloatRadio2Id"  styleClass="condition" property="fixedOrFloat2" onclick="showRateInfo()" value="Y" />								
									Fixed
								</label>
								<div  id="fixedRateDivID2">
									<div class="form-row">
											<!-- <span class="required">*</span>-->
											<label>Fixed Rate</label>
											<span  class="help-block invalid error" style="display:none;">Invalid value </span>
											<span  class="help-block error" id="fixedFixedRateId2MessageSpan" style="display:none;">Numeric Percentage(Max 100)</span>
												<html:text name="derivativesRequestForm"  tabindex="24" property="counterPartyInfos[1].fixedRateValue" styleId="fixedFixedRateId2" styleClass="span1 dual-selects fixedRatevalidate" maxlength="8"/>
											<span class="req-error" style="display:none;">error</span>											
									</div>
								</div>
								<label class="radio">
								    <html:radio name="derivativesRequestForm" tabindex="11" styleId="fixedOrFloatRadio2Id" styleClass="condition" property="fixedOrFloat2"  onclick="showRateInfo()" value="N" /> 
									Float
								</label>
								<div id="floatRateDivID2">
									<div class="form-row">
										<!-- <span class="required">*</span>-->
										<label>Index </label>
										 <html:select name="derivativesRequestForm" tabindex="25" property="counterPartyInfos[1].index" styleId="floatFixedRateId2"  onchange="getIndexTermDetails('counterParty2')"  styleClass="span3">
											<html:option value="">Select</html:option>
											<logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
												<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
											</logic:notEmpty>
										</html:select>
										<span id="floatFixedRateId2ErrorSpan" class="req-error" style="display:none;">error</span>
									</div>
									<div  id="indexTermDivID2">
										<div class="form-row">
											
											<label>Index Term</label>
											
											<logic:messagesPresent property="counterPartyInfos[1].indexTerm">
														<span class="req-error" >a</span>
										 	</logic:messagesPresent>
										     <html:select name="derivativesRequestForm"  property="counterPartyInfos[1].indexTerm"  styleId="floatingRateIndexTermID" styleClass="span3">
											      <html:option value="">Select..</html:option>
											     <html:optionsCollection name="derivativesRequestForm" property="secondCurrencyIndexTermMap" label="value" value="key"/> 
											</html:select>
										</div>
									</div>  <!-- end of block -->
								</div>
								
							</div>
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Spread (bps)</label>
								<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="spread1IdMessageSpan" style="display:none;">Decimal number(Max 100)</span>
								<html:text name="derivativesRequestForm"  tabindex="26" property="counterPartyInfos[0].spread" styleId="spread1Id" styleClass="span1 dual-selects spreadvalidate" maxlength="8"/>
								<span class="req-error" style="display:none;">error</span>								
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Spread (bps)</label>
								<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="spread2IdMessageSpan" style="display:none;">Decimal number(Max 100)</span>
								<html:text name="derivativesRequestForm"  tabindex="27" property="counterPartyInfos[1].spread" styleId="spread2Id" styleClass="span1 dual-selects spreadvalidate" maxlength="8"/>
								<span class="req-error" style="display:none;">error</span>								
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label>Day Count</label>
							<span id="dayCount1IdErrorSpan" class="req-error" style="display:none;">error</span>
							 <html:select name="derivativesRequestForm" tabindex="28" property="counterPartyInfos[0].dayCountId" styleId="dayCount1Id" styleClass="span2 left ">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="dayCounts">
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="dayCounts" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label>Day Count</label>
							<span id="dayCount2IdErrorSpan" class="req-error" style="display:none;">error</span>
							 <html:select name="derivativesRequestForm" tabindex="29" property="counterPartyInfos[1].dayCountId" styleId="dayCount2Id" styleClass="span2 left ">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="dayCounts">
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="dayCounts" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label class="nowrap">Interest Reset Frequency</label>
							<span id="interstFrequency1IdErrorSpan" class="req-error" style="display:none;">error</span>
							 <html:select name="derivativesRequestForm" tabindex="30" property="counterPartyInfos[0].interestResetFreqId" styleId="interstFrequency1Id" styleClass="span2 left ">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="interestResetFreqs" >
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="interestResetFreqs" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label class="nowrap">Interest Reset Frequency</label>
							<span id="interstFrequency2IdErrorSpan" class="req-error" style="display:none;">error</span>
							 <html:select name="derivativesRequestForm" tabindex="31" property="counterPartyInfos[1].interestResetFreqId" styleId="interstFrequency2Id"  styleClass="span2 left ">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="com.ge.icfp.StaticData"  property="interestResetFreqs"> 
									<html:optionsCollection name="com.ge.icfp.StaticData"  property="interestResetFreqs" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
						</div>
					</div> <!-- end of block -->
				</div>
		</div><!-- end of form form-mod -->
		
		
		<%@taglib tagdir="/WEB-INF/tags/attachments" prefix="atmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>
<div class="form-mod attachments-mod">
	<h2 class="span12 collapsible">Attachments</h2>
		
		<atmt:derivativeAttachments>
			<jsp:attribute name="mode">edit</jsp:attribute>
			<jsp:attribute name="legIndex"><bean:write name="derivativesRequestForm" property="legNumber" /></jsp:attribute>
			<jsp:attribute name="derivativeIndex"><bean:write name="derivativesRequestForm" property="derivativeNumber" /></jsp:attribute>
		</atmt:derivativeAttachments>
		
        </div>
        <div class="modal hide fade" id="lookup">
		<div class="modal-header">
			<a class="close" href="javascript:closeLookUpModal()">X</a>
			<h3>Lookup Results</h3>
		</div>
		<div class="modal-body" >
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
	
	
        <div class="span8 right btn-container">
          <input type="button" value="Save" class="btn right btn-success" onclick="javascript:saveDerivative();" tabindex="32">
        <c:choose>
            <c:when test="${actionId eq 2}">
				<a href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=openLeg&modify=true&legNumber=${legNumber}" class="btn-link right cancel" >Cancel</a>
			</c:when>
			<c:otherwise>
			  <a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" tabindex="34">Cancel</a>
			</c:otherwise>
		</c:choose>	
			<!-- <a href="javascript:redirectToLeg('?command=openLeg');" class="btn-link right cancel">Close window</a> -->	
		</div>
		<html:hidden name="derivativesRequestForm" property="legNumber" styleId="legNumberId" />
		<html:hidden name="derivativesRequestForm" property="derivativeNumber" styleId="derivativeNumberId" />
		<input type="hidden" name="actionId" value='${actionId}'/>
		</form>
	<hr>
    
	<%@include  file="common/footerSection.jsp" %>
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Derivative</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/derivativeRequest.do?command=cancelDerivative" class="btn right btn-success">Yes, cancel the Derivative</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Derivative</a>
		</div>
	</div>
	
	
	
</div>	
  </body>
</html>

