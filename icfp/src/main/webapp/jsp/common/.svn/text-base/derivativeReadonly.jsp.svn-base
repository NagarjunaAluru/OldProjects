
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ge.icfp.util.Utils"%>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
    <c:set var="legNumber" value="${requestScope.legNumber}" />
    <c:set var="derivative" value="${deal:getDerivative(requestScope.legNumber, requestScope.deriativesSeqId, pageContext)}"  />
    <c:set var="derivativeFlag" value="${requestScope.viewDerivative}"/>
   
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | View a Derivative</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <script>
    //Defining the global variable, so this variable can be used by other javascript library included in this JSP 
    var contextURL = '<%=servletContextUrl%>';
    </script>
    <c:set var="actionId" value="${requestScope.actionId}" />
	<c:set var="source" value="${param.source}" />
	
    <%@include file="../common/includeCssScripts.jsp" %>
    <script src="<%=servletContextUrl%>/js/viewDerivative.js" type="text/javascript"></script>	
  </head>
  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<jsp:include page="../day1Breadsrums.jsp">
		  <jsp:param value="${requestScope.legNumber}" name="id"/>
		  <jsp:param value="${derivativeFlag}" name="derivativeFlag"/>
		  <jsp:param value="${param.source}" name="sourcePage"/>
		</jsp:include>
		 
		  
    		<h1 class="page-title span10">View Derivative</h1>
        
		<p class="span12 left clear dashdesc"><bean:message key="label.addADerivative.newFunding" />
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
	
		<div class="form-mod">
				<h2 class="span12">Details</h2>
					<div class="row">
					<div class="span15">
						<div class="form-row">
							<input type="hidden" name="legNumber" value='${legNumber}' id="legNumberId"/>
							<input type="hidden" name="deriativesSeqId" value='${requestScope.deriativesSeqId}'/>
							<label>Internal or External</label>
							<div class="radio-container" id="internalOrExternalIdErrorDiv">
							<c:if test="${empty derivative.internalOrExternal }">-</c:if>
						    <c:if test="${not empty derivative.internalOrExternal }">${derivative.internalOrExternal }</c:if>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<label>Hedge Designation - U.S. GAAP</label>
							<c:if test="${empty derivative.hedgeDesigation }">-</c:if>
						    <c:if test="${not empty derivative.hedgeDesigation }">${derivative.hedgeDesigation }</c:if>
						    <input type="hidden" name="hedgeDesigationId" value='${derivative.hedgeDesigationId}' id="hedgeDesigationId"/>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row" >
					<div class="span15">
						<div class="form-row">
							<label>Derivative Type</label>
							<c:if test="${empty derivative.derivativeType }">-</c:if>
						    <c:if test="${not empty derivative.derivativeType }">${derivative.derivativeType }</c:if>
						    <input type="hidden" name="derivativeTypeId" value='${derivative.derivativeTypeId}' id="derivativeTypeId"/>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right contractClass">
						<div class="form-row">
							<label>Contract Class</label>
							<c:if test="${empty derivative.contractClass }">-</c:if>
						    <c:if test="${not empty derivative.contractClass }">${derivative.contractClass }</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div id="termDiv" class="span15">
						<div class="form-row">
							<div id="termMandatoryDiv"></div>
							<label>
								<bean:message key="label.addLeg.term" /> 
							</label>
							<c:if test="${empty derivative.termInMonths }">-</c:if>
						    <c:if test="${not empty derivative.termInMonths }">${derivative.termInMonths }</c:if>
						</div>
					 </div>
				
					 <div class="span15 right hedgeProgram">
							<div class="form-row">
								<label>Hedge Program</label>
								<c:if test="${empty derivative.hedgeProgram }">-</c:if>
						        <c:if test="${not empty derivative.hedgeProgram }">${derivative.hedgeProgram }</c:if>
						        <input type="hidden" name="hedgeProgramId" value='${derivative.hedgeProgramId}' id="hedgeProgramId"/>
							</div>
					 </div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<label>Tax Designation</label>
							<c:if test="${empty derivative.taxDesigation }">-</c:if>
						    <c:if test="${not empty derivative.taxDesigation }">${derivative.taxDesigation }</c:if>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<label>Manual Trade Request Workflow ID</label>
							<c:if test="${empty derivative.tradeRequestWorkflowId }">-</c:if>
						    <c:if test="${not empty derivative.tradeRequestWorkflowId }">${derivative.tradeRequestWorkflowId }</c:if>
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
								<select class="span2 cpa-search-id entity-filtername"  disabled="disabled" id="lenderSearchId">
									<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
								</select>
								
								<input type="text" maxlength="9" class="span2 entity-filtervalue" id="lenderOrProvider" disabled="disabled"  value='${derivative.counterPartyInfo1.entity.CDRCd }'   style="text-transform:uppercase"/>
							</div>
							<div class="form-row">
								<label class="checkbox info-checkbox pending">
								  <input type="checkbox" name="entitySetupFlag" value='${derivative.counterPartyInfo1.entity.entitySetupFlag}' id="lenderEntitySetupFlag"/>
								   Legal Entity Setup Pending
								</label>
							</div>
						</div> <!-- end of block -->
					</div> 
				<!-- 	  <div id="lenderGoldIdDetai	ls" class="conditional-row">  -->
				<div id="lenderGoldIdDetails" > 
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty derivative.counterPartyInfo1.entity.CDRCd }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo1.entity.CDRCd }">${derivative.counterPartyInfo1.entity.CDRCd }</c:if>
						    	</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty derivative.counterPartyInfo1.entity.LEName }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo1.entity.LEName }">${derivative.counterPartyInfo1.entity.LEName }</c:if>
								</div>
							</div><!-- end of block -->
						 </div>
						 <div class="row highlighted">	
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty derivative.counterPartyInfo1.entity.LEGoldId }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo1.entity.LEGoldId }">${derivative.counterPartyInfo1.entity.LEGoldId }</c:if>
						    	</div>
							</div><!-- end of block -->
						</div>
						 <div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty derivative.counterPartyInfo1.entity.country }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo1.entity.country }">${derivative.counterPartyInfo1.entity.country }</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						</div>
				
						<div class="row highlighted" id="counterPartyME1Id">
							<div class="span5">
								<div class="form-row">
									<label><bean:message key="label.addLeg.managementEntity" /></label>
									<c:if test="${empty derivative.counterPartyInfo1.entity.MEName }">-</c:if>
									<c:if test="${not empty derivative.counterPartyInfo1.entity.MEName }">${derivative.counterPartyInfo1.entity.MEName }</c:if>
								</div>
							</div> <!-- end of block -->
						</div>
						<input type="hidden" name="counterPartyInfo1.entity.CDRCd" value="${derivative.counterPartyInfo1.entity.CDRCd }" id="lenderLegalEntityGoldId"/>
						<input type="hidden" name="counterPartyInfo1.entity.LEGoldId" value="${derivative.counterPartyInfo1.entity.LEGoldId}" id="LEGoldId"/>
						<input type="hidden" name="counterPartyInfo1.entity.leTypeId" value="${derivative.counterPartyInfo1.entity.leTypeId}" id="lenderLeTypeId"/>
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
								<select class="span2 cpa-search-id entity-filtername" disabled="disabled" id="borrowerSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								<input type="text" maxlength="9" class="span2 entity-filtervalue"  id="borrowerOrRecipient"  disabled="disabled"  value='${derivative.counterPartyInfo2.entity.CDRCd }' style="text-transform:uppercase"/>
							</div>
							<div class="form-row">
							<label class="checkbox info-checkbox pending">
							 <input type="checkbox" name="borrowerEntitySetup" value='${derivative.counterPartyInfo2.entity.entitySetupFlag}' id="borrowerEntitySetupFlag"/>
							  Legal Entity Setup Pending
							</label>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="borrowerGoldIdDetails" >
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<c:if test="${empty derivative.counterPartyInfo2.entity.CDRCd }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo2.entity.CDRCd }">${derivative.counterPartyInfo2.entity.CDRCd }</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<c:if test="${empty derivative.counterPartyInfo2.entity.LEName }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo2.entity.LEName }">${derivative.counterPartyInfo2.entity.LEName}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<c:if test="${empty derivative.counterPartyInfo2.entity.LEGoldId }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo2.entity.LEGoldId }">${derivative.counterPartyInfo2.entity.LEGoldId}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<c:if test="${empty derivative.counterPartyInfo2.entity.country }">-</c:if>
						            <c:if test="${not empty derivative.counterPartyInfo2.entity.country}">${derivative.counterPartyInfo2.entity.country}</c:if>
						        </div>
							</div><!-- end of block -->
						</div>
				</div>
	           <div class="row highlighted">	
					<div class="span5">
							<div class="form-row">
								<label><bean:message key="label.addLeg.managementEntity" /></label>
								<c:if test="${empty derivative.counterPartyInfo2.entity.MEName}">-</c:if>
				                <c:if test="${not empty derivative.counterPartyInfo2.entity.MEName}">${derivative.counterPartyInfo2.entity.MEName}</c:if>
							</div>
					</div> <!-- end of block -->
				</div>
				<input type="hidden" name="counterPartyInfo2.entity.CDRCd" value="${derivative.counterPartyInfo2.entity.CDRCd }" id="borrowerLegalEntityGoldId"/>
				<input type="hidden" name="counterPartyInfo2.entity.LEGoldId" value="${derivative.counterPartyInfo2.entity.LEGoldId}" id="borLEGoldId"/>
				<input type="hidden" name="counterPartyInfo2.entity.leTypeId" value="${derivative.counterPartyInfo2.entity.leTypeId}" id="borLeTypeId"/>
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
							<c:if test="${empty derivative.currency1}">-</c:if>
				            <c:if test="${not empty derivative.currency1}">${derivative.currency1}</c:if>
				         </div>
					</div> <!-- end of block -->
					<div class="span15 right">
					<h2>Currency 2</h2>
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency </label>
							<c:if test="${empty derivative.currency2}">-</c:if>
				            <c:if test="${not empty derivative.currency1}">${derivative.currency2}</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				
				<div class="row highlighted">
					<div class="span15">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span> -->
								<label>Amount</label>
								<c:if test="${empty derivative.derivativeAmount1}">-</c:if>
				                <c:if test="${not empty derivative.derivativeAmount1}">${derivative.derivativeAmount1}</c:if>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Amount</label>
								<c:if test="${empty derivative.derivativeAmount2}">-</c:if>
				                <c:if test="${not empty derivative.derivativeAmount2}">${derivative.derivativeAmount2}</c:if>
							</div>
						</div>
					</div> <!-- end of block -->
					
				
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
						
							<label>Fixed or Float</label>
							<div class="radio-container conditional-radio-tri" id="FixOrFloat1Div">
								<label class="radio">
								<c:if test="${empty derivative.fixedOrFloat1}">
								  <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id" />
								</c:if>
								<c:if test="${not empty derivative.fixedOrFloat1}">
								  <c:if test="${derivative.fixedOrFloat1 == 'Fixed'}">
								      <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id"  checked="checked"  />Fixed
								      <div  id="fixedRateDivID1"  >
										<div class="form-row">
												<label>Fixed Rate</label>
												<c:if test="${empty  derivative.counterPartyInfo1.fixedRateValue}">-</c:if>
				                                <c:if test="${not empty derivative.counterPartyInfo1.fixedRateValue}">${derivative.counterPartyInfo1.fixedRateValue}</c:if>
										</div>
								     </div>
								  </c:if>
								  <c:if test="${derivative.fixedOrFloat1 != 'Fixed'}">
								     <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id" />Fixed
								  </c:if>
								</c:if>
								</label>
								
								<label class="radio">
								
								<c:if test="${empty derivative.fixedOrFloat1}">
								  <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id" />Float
								</c:if>
								<c:if test="${not empty derivative.fixedOrFloat1}">
								  <c:if test="${derivative.fixedOrFloat1 == 'Float'}">
								     <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id"  checked="checked"  />Float
								     <div id="floatRateDivID1">
										<div class="form-row">
											<label>Index </label>
											    <c:if test="${empty  derivative.counterPartyInfo1.index}">-</c:if>
				                                <c:if test="${not empty derivative.counterPartyInfo1.index}">${derivative.counterPartyInfo1.index}</c:if>
										</div>
										<div  id="indexTermDivID1">
											<div class="form-row">
												<label>Index Term</label>
												  <c:if test="${empty  derivative.counterPartyInfo1.indexTerm}">-</c:if>
				                                  <c:if test="${not empty derivative.counterPartyInfo1.indexTerm}">${derivative.counterPartyInfo1.indexTerm}</c:if>
											</div>
										</div>  <!-- end of block -->
								     </div>
								  </c:if>
								  <c:if test="${derivative.fixedOrFloat1 != 'Float'}">
								     <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id" />Float
								  </c:if>
								 </c:if> 
								 
								</label>
								
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
								    <c:if test="${empty derivative.fixedOrFloat2}">
									  <input type="radio" name="fixedOrFloat2"  disabled="disabled" id="fixedOrFloatRadio2Id" />
									</c:if>
									<c:if test="${not empty derivative.fixedOrFloat2}">
									  <c:if test="${derivative.fixedOrFloat2 == 'Fixed'}">
									      <input type="radio" name="fixedOrFloat2"  disabled="disabled" id="fixedOrFloatRadio2Id"  checked="checked"  />Fixed
									      <div  id="fixedRateDivID2"  >
											<div class="form-row">
													<label>Fixed Rate</label>
													<c:if test="${empty  derivative.counterPartyInfo2.fixedRateValue}">-</c:if>
					                                <c:if test="${not empty derivative.counterPartyInfo2.fixedRateValue}">${derivative.counterPartyInfo2.fixedRateValue}</c:if>
											</div>
									     </div>
									  </c:if>
									  <c:if test="${derivative.fixedOrFloat2 != 'Fixed'}">
									     <input type="radio" name="fixedOrFloat1"  disabled="disabled" id="fixedOrFloatRadio1Id" />Fixed
									  </c:if>
									</c:if>
								</label>
								
								<label class="radio">
								   <c:if test="${empty derivative.fixedOrFloat2}">
									  <input type="radio" name="fixedOrFloat2"  disabled="disabled" id="fixedOrFloatRadio2Id" />Float
									</c:if>
									<c:if test="${not empty derivative.fixedOrFloat2}">
									  <c:if test="${derivative.fixedOrFloat2 == 'Float'}">
									     <input type="radio" name="fixedOrFloat2"  disabled="disabled" id="fixedOrFloatRadio2Id"  checked="checked"  />Float
									     <div id="floatRateDivID2">
											<div class="form-row">
												<label>Index </label>
												    <c:if test="${empty  derivative.counterPartyInfo2.index}">-</c:if>
					                                <c:if test="${not empty derivative.counterPartyInfo2.index}">${derivative.counterPartyInfo2.index}</c:if>
											</div>
											<div  id="indexTermDivID2">
												<div class="form-row">
													<label>Index Term</label>
													  <c:if test="${empty  derivative.counterPartyInfo2.indexTerm}">-</c:if>
					                                  <c:if test="${not empty derivative.counterPartyInfo2.indexTerm}">${derivative.counterPartyInfo2.indexTerm}</c:if>
												</div>
											</div>  <!-- end of block -->
									     </div>
									  </c:if>
									  <c:if test="${derivative.fixedOrFloat2 != 'Float'}">
									     <input type="radio" name="fixedOrFloat2"  disabled="disabled" id="fixedOrFloatRadio2Id" />Float
									  </c:if>
									 </c:if> 
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row highlighted">
					<div class="span15">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Spread (bps)</label>
								 <c:if test="${empty  derivative.counterPartyInfo1.spread}">-</c:if>
				                 <c:if test="${not empty derivative.counterPartyInfo1.spread}">${derivative.counterPartyInfo1.spread}</c:if>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<div class="left">
								<!-- <span class="required">*</span>-->
								<label>Spread (bps)</label>
								<c:if test="${empty  derivative.counterPartyInfo2.spread}">-</c:if>
				                 <c:if test="${not empty derivative.counterPartyInfo2.spread}">${derivative.counterPartyInfo2.spread}</c:if>
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span15">
						<div class="form-row">
							<label>Day Count</label>
							 <c:if test="${empty  derivative.counterPartyInfo1.dayCount}">-</c:if>
				             <c:if test="${not empty derivative.counterPartyInfo1.dayCount}">${derivative.counterPartyInfo1.dayCount}</c:if>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
							<!-- <span class="required">*</span>-->
							<label>Day Count</label>
							<c:if test="${empty  derivative.counterPartyInfo2.dayCount}">-</c:if>
				             <c:if test="${not empty derivative.counterPartyInfo2.dayCount}">${derivative.counterPartyInfo2.dayCount}</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row highlighted">
					<div class="span15">
						<div class="form-row">
							
							<label class="nowrap">Interest Reset Frequency</label>
							 <c:if test="${empty  derivative.counterPartyInfo1.interestResetFreq}">-</c:if>
				             <c:if test="${not empty derivative.counterPartyInfo1.interestResetFreq}">${derivative.counterPartyInfo1.interestResetFreq}</c:if>
						</div>
					</div> <!-- end of block -->
					<div class="span15 right">
						<div class="form-row">
						
							<label class="nowrap">Interest Reset Frequency</label>
							 <c:if test="${empty  derivative.counterPartyInfo2.interestResetFreq}">-</c:if>
				             <c:if test="${not empty derivative.counterPartyInfo2.interestResetFreq}">${derivative.counterPartyInfo2.interestResetFreq}</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				
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
				<div style="height:100px;">
				    <div class="right btn-container">
					   <jsp:include page="../derivativeViewCancel.jsp">
						  <jsp:param value="${requestScope.legNumber}" name="id"/>
						  <jsp:param value="${derivativeFlag}" name="derivativeFlag"/>
						  <jsp:param value="${param.source}" name="sourcePage"/>
					   </jsp:include>
		            </div>
				</div>
				<input type="hidden" name="derivativeNumber" value='${derivativeNumber}' id="derivativeNumberId"/>
				
				
		</div><!-- end of form form-mod -->
		
		
    
	<%@include  file="../common/footerSection.jsp" %>

	
	
</div>	
  </body>
</html>

