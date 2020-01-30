<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ge.icfp.util.StaticDataFactory,com.ge.icfp.model.NameValue,java.util.List" %>
<% String servletContextUrl = request.getContextPath(); 
   int size = 0;
%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/masterdata" prefix="masterdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
   <script type="text/javascript" >
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	
	</script>
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | New Financing Request</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<style>
    .attach-btn { background-image:url(../img/btn_attach.gif); width: 60px; height: 26px; margin: 0; padding: 0; border: none; cursor: pointer; }
    </style>
   
   	<%@include file="../common/includeCssScripts.jsp" %>
	

<script src="${context}/js/newFundingRequest.js" type="text/javascript"></script>

<script>

//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>

<script src="${context}/js/newRCAFundingRequest.js" type="text/javascript"></script>
  </head>

  <body >
   <html:form action="/fundingRequest/newFundingRequest.do"  styleId="fundingRequestForm" method="post" onsubmit="submitFunction()"   enctype="multipart/form-data">
     
      <html:hidden property="page" value="2"/>
      <html:hidden name="dealRequestForm" property="cloneFlag" />
      <%String hasEBoard = null; %>
      
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">New Financing Request</li>
		</ul>
         <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong><font color="green">${requestScope.UpdateMessage}</font></strong> 
        </div>
		<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.DeleteMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong><font color="green">${requestScope.DeleteMessage}</font></strong> 
        </div>
		<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.successMsg ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong><font color="green">${requestScope.successMsg}</font></strong> 
        </div>
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="01a._RCA_-_New_Funding_Request-add_a_leg.html"  class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
        <div id="validationsRequired" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
         
         <logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            		<strong>Please fix the following fields highlighted in red.</strong> 
            		<logic:messagesPresent property="ruleErrors">
            			<strong><html:errors property="ruleErrors" /></strong>
            		</logic:messagesPresent>
            		<logic:messagesPresent property="LegErrors">
            			<strong><html:errors property="LegErrors" /></strong>
            		</logic:messagesPresent>
        	   </div>
         </logic:messagesPresent>    
         
        <h1 class="page-title span12">New Financing Request</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.fourBlocker.newFundingRequest" />
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
	    <c:if test="${sessionScope.section eq 'myRequests'}">
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</c:if>	
		<div class="form-mod">
			<h2 class="span12">Project Summary</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
					<c:set var="userNameDetails" value="${userDetails:fullName(',','-')}" />
					<c:set var="userTitle" value="${userDetails:title('-')}" />
						<p><b><bean:message key="label.fundingRequest.transactionowner" /></b><br />
						    <c:out value="${userNameDetails}" />
						   </p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right highlighted">
				<div class="form-row"></br></br>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.fundingRequest.dealID" /></b></p>
						<p> <html:text  name="dealRequestForm"  tabindex="1" property="uniqueId" readonly="true"  maxlength="20"   /></p>
					 	<html:hidden name="dealRequestForm" property="dealSeqId"  />
						
						    
					</div>
				</div><!-- end of block -->
				<div class="span5 right"> 
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.dealName" /></label>
						  <logic:messagesPresent property="dealName">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <html:text  name="dealRequestForm"   tabindex="1" property="dealName"  styleId="dealName" maxlength="100"   />
						  	
	             	</div>
				</div> <!-- end of block -->
			</div> 
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.dealCategory" /></label>
						 <logic:messagesPresent property="dealCategoryId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:select name="dealRequestForm"  tabindex="2" property="dealCategoryId"  styleClass="check">
   							<html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="dealCategories" value="ID" label="name"/>						   
						</html:select>
					</div>
				</div> <!-- end of block -->
			</div> 
			<div class="row">
				<div class="span5">
					<div class="form-row autosize-container2">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.dealRationale" /></label>
						<logic:messagesPresent property="dealRationale">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <div class="char-count dealRationaleChar" style="margin-left:-10px;">2500</div>
						 <html:textarea  name="dealRequestForm"  styleClass="xlarge autosize2 messageinput"  property="dealRationale"   styleId="dealRationaleId" tabindex="3" onblur="scriptInjection(this);" ></html:textarea>
					</div>
						 
						

				</div> <!-- end of block -->
				
			</div>
        </div><!-- end of form form-mod -->
		
		<div class="form-mod">
			<h2 class="span12"><bean:message key="label.fundingRequest.transactionSummaryandOwner" /></h2>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.securitytype" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.securityType" />"></span></label>
						
						<logic:messagesPresent property="securityCategoryId">
							<div class="radio-container req-error">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="securityCategoryId">
	               				 <div class="radio-container">
	                    </logic:messagesNotPresent>
						<label class="radio">
							<html:radio name="dealRequestForm"   tabindex="4" property="securityCategoryId"  value="1" ></html:radio> Secured
						</label>
						<label class="radio">
							<html:radio name="dealRequestForm"  tabindex="4" property="securityCategoryId" value="2" ></html:radio> Unsecured
						</label>
						</div>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.derivates" /></label>
						<c:set var="getDerivativesRequestsFlag" value="${deal:getDerivativesRequestsFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getDerivativesRequestsFlag eq 'Yes'}">
							    <label ><bean:message key="label.addLeg.yes" /></label>
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="derivativesNeededFlag"  value="1" />
							  </c:when>
							  <c:when test="${getDerivativesRequestsFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="derivativesNeededFlag"  value="0" />
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
					
					
					
				</div> <!-- end of block -->
			</div>
		<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.impairmenthistory" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.impairmentHistory" />"></span>
						</label>
						 
						 <logic:messagesPresent property="impairmentHistoryFlag">
							<div class="radio-container conditional-radio req-error">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="impairmentHistoryFlag">
	               				 <div class="radio-container conditional-radio">
	                     </logic:messagesNotPresent>
							<label class="radio">
								 <html:radio name="dealRequestForm"   styleClass="condition" tabindex="8"  property="impairmentHistoryFlag" value="true" ></html:radio> Yes 
							</label>
							<div id="impairmentCommentID" class="autosize-container conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.impairmentcomment" /></label>
									<logic:messagesPresent property="impairmentComment">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
						  				<div class="char-count" >
									  <label id="impairmentCommentDivID"><bean:message key="label.fundingRequest.impairmentcommentMaxSize" /></label>
									</div> <!-- fix positions -->
									 <html:textarea name="dealRequestForm"    styleClass="xlarge autosize messageinput"  styleId="impairmentCommentID" property="impairmentComment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
								</div>
							</div>
							
							<label class="radio">
								 <html:radio name="dealRequestForm"   tabindex="8"  styleId="isImpairmentHistoryNoID" property="impairmentHistoryFlag" value="false" ></html:radio> No
							</label>
							
						
						</div>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.equityInfusion"/></label>
						<c:set var="getEquityInfusionsDividendsFlag" value="${deal:getEquityInfusionsDividendsFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getEquityInfusionsDividendsFlag eq 'Yes'}">
							    <label ><bean:message key="label.addLeg.yes" /></label>
							    <html:hidden styleId="equityInfusionsDividendsFlagID" name="dealRequestForm"  property="equityInfusionsDividendsFlag" value="1" />
							  </c:when>
							  <c:when test="${getEquityInfusionsDividendsFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="equityInfusionsDividendsFlagID" name="dealRequestForm"  property="equityInfusionsDividendsFlag" value="0" />
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
					
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.financialstatementsdate" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.finStatementDateGeOneYear" />"></span>
						</label>
						
						<logic:messagesPresent property="finSttmntDtAboveOneYrFlag">
							     <div class="radio-container conditional-radio req-error">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="finSttmntDtAboveOneYrFlag">
	               				 <div class="radio-container conditional-radio">
	                     </logic:messagesNotPresent>
							<label class="radio">
								 <html:radio name="dealRequestForm"   tabindex="10"  styleClass="condition" property="finSttmntDtAboveOneYrFlag" value="true" ></html:radio> Yes 
							</label>
							<div id="lastDateofFinancialStmtDivID" class="conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.latestdateoffinancialstatement" /></label>
									<logic:messagesPresent property="latestDtOfFinSttmnt">
										<span  class="help-block error" ><bean:message key="invalidFinancialStmtDate" /></span>
						  			</logic:messagesPresent>
									<logic:messagesPresent property="latestDtOfFinSttmnt">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
						  			<logic:messagesPresent property="latestDtOfFinSttmntCurrDateValidation">
										<span  class="help-block error" ><bean:message key="latestDtOfFinSttmntValidation" /></span>
									</logic:messagesPresent>
						  			<html:text name="dealRequestForm"  readonly="true" styleId="lastDateofFinancialStmtID"  property="latestDtOfFinSttmnt"  styleClass="span3 requestdatepicker-field" maxlength="10"   />
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
									
								</div>
							</div>
							<label class="radio">
								<html:radio name="dealRequestForm"   tabindex="10" styleId="isFinancialStatementDateID" property="finSttmntDtAboveOneYrFlag" value="false" ></html:radio> No
							</label>
							
						</div>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.prudentiallyRegulatedLegalEntity"/></label>
						
						<c:set var="getPrudentialEntityFlag" value="${deal:getPrudentialEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrudentialEntityFlag eq 'Yes'}">
							    <label ><bean:message key="label.addLeg.yes" /></label>
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="1" />
							  </c:when>
							  <c:when test="${getPrudentialEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="0" />
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
						
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.principleLegalEntity" /></label>
						<c:set var="getPrincipalEntityFlag" value="${deal:getPrincipalEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrincipalEntityFlag eq 'Yes'}">
							    <label ><bean:message key="label.addLeg.yes" /></label>
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="1"/>
							  </c:when>
							  <c:when test="${getPrincipalEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="0"/>
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
					
					
				</div> <!-- end of block -->
				
			
			</div>
			
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.nonStandardLegalAgreement" /></label>
						<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${nonStandardDocsFlag eq 'Yes'}">
						    <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="1" />
						  </c:when>
						  <c:when test="${nonStandardDocsFlag eq 'No'}">
						    <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.addLeg.no" /></label>
						     <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="0" />
						  </c:when>
						  <c:otherwise>
						  <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
					</div>
					
						
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.subordinateddebt"/></label>
						<c:set var="subOrdinateDebtFlag" value="${deal:getSubOrdinateDebtFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${subOrdinateDebtFlag eq 'Yes'}">
						    <label ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden styleId="isSubOrdinateDebtID" name="dealRequestForm" property="subordinatedDebtFlag" value="1"/>
						  </c:when>
						  <c:when test="${subOrdinateDebtFlag eq 'No'}">
						    <label  ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden styleId="isSubOrdinateDebtID" name="dealRequestForm" property="subordinatedDebtFlag" value="0"/>
						  </c:when>
						  <c:otherwise>
						  <label><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
						
					</div>
					
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.crossborder" /></label>
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
						  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
						    <label ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="crossBorderFlag" value="1" />
						  </c:when>
						  <c:when test="${getCrossBorderFlagValue eq 'No'}">
						    <label ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="crossBorderFlag" value="0" />
						  </c:when>
						  <c:otherwise>
						  <label ><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
						
					</div>
					
				</div> <!-- end of block -->
			</div>
			
        </div><!-- end of form form-mod -->
		<div class="form-mod">
			<h2 class="span12"><bean:message key="label.fundingRequest.transactionPriority"/></h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>
							<bean:message key="label.fundingRequest.priority" />
							<span class="ttip info" data-original-title="<bean:message key="label.fundingRequestTooltip.priority" />"></span>
						</label>
						<logic:messagesPresent property="priorityId">
							     <div class="radio-container conditional-radio-tri req-error">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="priorityId">
	               				 <div class="radio-container conditional-radio-tri">
	                     </logic:messagesNotPresent>
						
							<label class="radio">
							    <html:radio name="dealRequestForm" tabindex="14" styleClass="condition" styleId="isPriorityHigh" property="priorityId" value="1"  ></html:radio>  
								<span><bean:message key="label.fundingRequest.priorityHigh"/></span>
							</label>
							<div id="priorityCommentHighID" class="autosize-container conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									<logic:messagesPresent property="priorityComment">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
									<div class="char-count">
									<label id="highPriorityLabelID" class="char-count-label">
									<bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									<textarea class="xlarge autosize messageinput" name="textpriorityComment" cols="100" rows="5" onblur="scriptInjection(this);"></textarea>
									
								</div>
							</div>
							<label class="radio">
								<html:radio name="dealRequestForm"  tabindex="14" styleClass="condition" property="priorityId" styleId="isPriorityMedium" value="2" ></html:radio> 
		                        <span><bean:message key="label.fundingRequest.priorityMedium"/></span>
							</label>
							<div  id="priorityCommentMediumID" class="autosize-container conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									<logic:messagesPresent property="priorityComment">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
									<div class="char-count">
									<label id="mediumPriorityLabelID" class="char-count-label">
									 <bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									<textarea class="xlarge autosize messageinput" name="textpriorityComment" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</div>
							<label class="radio">
								 <html:radio name="dealRequestForm"  tabindex="14" styleClass="condition" property="priorityId" styleId="isPriorityLow" value="3" ></html:radio> 
		                    	 <span><bean:message key="label.fundingRequest.priorityLow"/></span>
							</label>
							<div  id="priorityCommentLowID" class="autosize-container conditional-container">
								<div class="form-row">
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									
									<div class="char-count">
									<label id="lowPriorityLabelID" class="char-count-label">
									 <bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									  <textarea class="xlarge autosize messageinput" name="textpriorityComment" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</div>
							 <html:hidden  name="dealRequestForm" property="priorityComment" />
						</div>
						 
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.regionResponsibilty"  /></label>
						  <logic:messagesPresent property="responsibleRegionId">
							<span class="req-error" >a</span>
						   </logic:messagesPresent>
	                       
	                       <html:select name="dealRequestForm"  tabindex="15"  property="responsibleRegionId"  styleClass="check">
	   							<html:option value="">Select...</html:option>
	   						<html:optionsCollection name="com.ge.icfp.StaticData" property="regionResponsibility" value="ID" label="name"/>	
   						   </html:select>
						</div>
					</div>
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>
							<bean:message key="label.fundingRequest.valueDate" />
							<span class="ttip info" data-original-title="<bean:message key="label.fundingRequestTooltip.valueDate" />"></span>
						</label>
						<logic:messagesPresent property="valueDt">
								<span  class="help-block error"><bean:message key="invalidValueDate" /></span>
						 </logic:messagesPresent>
						<logic:messagesPresent property="valueDt">
							<span class="req-error" >a</span>
						</logic:messagesPresent>
						<logic:messagesPresent property="valueDateValidation">
							<span  class="help-block error"><bean:message key="valueDateValidation" /></span>
						</logic:messagesPresent>
						<logic:messagesPresent property="dayOfTheWeek">
							<span  class="help-block error"><bean:message key="dayOfTheWeek" /></span>
						</logic:messagesPresent>
						<html:text name="dealRequestForm"  readonly="true"  property="valueDt"  styleClass="span3 requestdatepicker-field" maxlength="10"   />
						<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
					</div>
			     </div><!-- end of block -->
				
				</div> <!-- end of block -->
			</div>
	
	<div class="form-mod" style="width:100%;">
	<h2 id="legTable"><bean:message key="heading.transactionLegs" /></h2>
	 
	<div class="row">
			<div class="span2">
				<div class="form-row">
					<div class="left">
						<span class="required">*</span>
						<label>Select Product</label>
						<span  class="help-block error" id="productTypefailed" style="display:none;">Please select Product Type</span>
						
						<html:select name="dealRequestForm" property="legTypeId" styleClass="span2" styleId="productType">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="productTypes" value="ID" label="name"/>
						</html:select>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
					</div>
					
				</div>
			</div>
			<div class="span3" id="eventTypesDiv">
				<div class="form-row">
					<div class="left">
						<label>Select Event</label>
						
						<html:select name="dealRequestForm" property="eventTypeId" styleClass="span3" styleId="eventType" >
							<html:option value="">Select..</html:option>
							<html:option value="">New Transaction</html:option>
							<html:optionsCollection name="dealRequestForm" property="eventTypes" label="value" value="key"/> 
						
						</html:select>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
					</div>
					
				</div>
			</div>
			<div class="span2">
				<div class="form-row">
					<div>	
				  		<%if(size<=0){ %>
	                		<span style="display:none;" class="error">&nbsp;&nbsp;&nbsp;&nbsp;Please add atleast one leg. </span>				
				   		<%} %>
				   		<label>&nbsp;</label>
						<div class="table-btn">
					  		<logic:messagesPresent property="legSize">
					    		<span class="req-error" >a</span>
					   		</logic:messagesPresent>
						 		
						 		<input type="button" value="Add a Leg..." class="btn" onclick="javascript:addLeg();" id="addLegButtonID">
						 		
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
	</div> 
	<div class="autosize-container" style="overflow-x: auto;">
		<div>
		<input type="hidden" name="legLen"  id="legLen" value="0" />
		
		<c:set var="numberoflegs" value="${deal:getTotalNumberofLegs(pageContext.request)}" />
		<input type="hidden" name="numberoflegs"  id="numberoflegs" value="${numberoflegs}" />
			<label><bean:message key="label.transactionLegs.noOfLegs" /><%--  ${fourBlockerForm.deal.numberOfTransactions}  --%>
				<c:out value="${numberoflegs}" /> </label> 
			<table
				class="table table-striped table-bordered sortable no-bottom table-nested">
				<thead>
					  <tr>
						<th rowspan="2"></th>
						<th rowspan="2" colspan="2">Action</th>
						<th rowspan="2">Trade ID</th>
						<th rowspan="2">Leg #</th>
						<th rowspan="2">Product Type</th>
						<th rowspan="2">Event</th>
						<th rowspan="2">Term <span class="small">in months</span></th>
						<th colspan="3" class="nosort">Lender/Provider</th>
						<th colspan="3" class="nosort">Borrower/Recipient</th>
						<th colspan="2" class="nosort">Original Currency</th>
						<th rowspan="2">USD Equivalent</th>
						<th rowspan="2">Derivatives</th>
						
					  </tr>
					  <tr>
						<th>Legal Entity GOLD ID</th>
						<th>CDR</th>
						<th>Country</th>
						<th>Legal Entity GOLD ID</th>
						<th>CDR</th>
						<th>Country</th>
						<th>Currency</th>
						<th>Amount</th>

					  </tr>
					</thead>
								
					<tbody>
					
		
					
					<c:set var="legList" value="${deal:fetchLegs(pageContext.request)}" />
					
					<c:if test="${legList == null || numberoflegs==0}"> 
					
					
				
					<tr>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						<td> -</td>
						
					  </tr>
					</c:if>
					<c:set var="rowCounter" value="1"></c:set>
					<c:if test="${legList != null}"> 
					<c:forEach var="legDetailsId" items="${legList}" >
					
						<c:set var="isImmediateDrawdown" value="false"/>
						<c:if test="${legDetailsId.transactionEventType eq 'Immediate Drawdown'}">
							<c:set var="isImmediateDrawdown" value="true"/>
						</c:if>
					
						<tr id='dealLeg'${legDetailsId.legNumber}>
						<c:choose>
          					<c:when test="${legDetailsId.derivatives eq 'Yes' and not isImmediateDrawdown}">
								<td><a href="#" data-nested="<c:out value="nested${rowCounter}"></c:out>" class="exp"></a></td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<%-- <td>-</td> --%>
						<td>
							<c:if test="${deal:getTotalNumberofLegs(pageContext.request) == 1}">-</c:if>
							<c:if test="${not isImmediateDrawdown and deal:getTotalNumberofLegs(pageContext.request) != 1}">
								<c:if test="${sessionScope.section ne 'myRequests' or deal.action eq 'Draft' or deal.action eq 'DRAFT'}">
								<a href="#deleteConfirm${legDetailsId.legNumber}" class="delete-leg modal-confirm" title="Delete this Leg" data-toggle="modal" >Delete</a>
								</c:if>
							</c:if>
						</td>
						
						<td>
							 <c:if test="${not isImmediateDrawdown}">
								<a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Edit this leg" onclick="javascript:modifyLeg(${legDetailsId.legNumber});"></a>
									
							</c:if>
						</td>
						
						
						<td>${not empty legDetailsId.transactionId ? legDetailsId.transactionId : '-'}</td>
						<c:choose>
						<c:when test="${not empty legDetailsId.legSeqId}">
						<td>${legDetailsId.legSeqId}</td>
						</c:when>
						<c:otherwise><td>-</td></c:otherwise>
						</c:choose>
						<td>${legDetailsId.productType}</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.transactionEventType}">
									-
								</c:when>
								<c:otherwise>
									<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
										<c:if test="${deal:getIncreaseOrDecrease(legDetailsId.legNumber,pageContext.request) eq 1}">Amendment - Facility Increase</c:if>
										<c:if test="${deal:getIncreaseOrDecrease(legDetailsId.legNumber,pageContext.request) eq 2}">Amendment - Facility Decrease</c:if>
									</c:if>
									<c:if test="${legDetailsId.transactionEventTypeId != 5}">
										${legDetailsId.transactionEventType}
									</c:if>
									<c:if test="${isImmediateDrawdown}">
										 for Leg #${legDetailsId.drawDown}
									</c:if>
								</c:otherwise>								
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.termsInMths }">
									-
								</c:when>								
								<c:otherwise>
									${legDetailsId.termsInMths}
								</c:otherwise>
							</c:choose>
						</td>
						<c:if test="${empty legDetailsId.lenderLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderLegalEntity}"> 
							<td>${legDetailsId.lenderLegalEntity}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.lenderCDR}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderCDR}"> 
							<td>${legDetailsId.lenderCDR}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.lenderCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderCountry}"> 
							<td>${legDetailsId.lenderCountry}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerLegalEntity}"> 
							<td>${legDetailsId.borrowerLegalEntity}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerCDR}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerCDR}"> 
							<td>${legDetailsId.borrowerCDR}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerCountry}"> 
							<td>${legDetailsId.borrowerCountry}</td>
						</c:if>
						
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.originalCurrency}">
									-
								</c:when>
								<c:otherwise>
									${legDetailsId.originalCurrency}
								</c:otherwise>
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${isImmediateDrawdown}">
									${deal:getImmediateDrawdownAmount(rowCounter, pageContext.request)}
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${empty legDetailsId.transactionEventType}">
											${legDetailsId.originalAmount}
										</c:when>
										<c:otherwise>
											<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
												<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legDetailsId.legNumber, pageContext.request)}" scope="page"/>
												
												<c:if test="${empty day2legSummaryVO.facilityIncDecAmt}">-</c:if>
												<c:if test="${not empty day2legSummaryVO.facilityIncDecAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecAmt}" /></c:if>	
											</c:if>
											<c:if test="${legDetailsId.transactionEventTypeId != 5}">
												${legDetailsId.originalAmount}	
											</c:if>
										</c:otherwise>								
									</c:choose>	
								</c:otherwise>
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.transactionEventType}">
									<c:choose>
										<c:when test="${empty legDetailsId.usdEquivalent}">
											-
										</c:when>	
										<c:otherwise>
											${legDetailsId.usdEquivalent}
										</c:otherwise>
									</c:choose>	
								</c:when>
								<c:otherwise>
									<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
										<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legDetailsId.legNumber, pageContext.request)}" scope="page"/>
										
										<c:if test="${empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}">-</c:if>
										<c:if test="${not empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecUSDEquivalentAmt}" /></c:if>	
									</c:if>
									<c:if test="${legDetailsId.transactionEventTypeId != 5}">
										<c:choose>
											<c:when test="${empty legDetailsId.usdEquivalent}">
												-
											</c:when>	
											<c:otherwise>
												${legDetailsId.usdEquivalent}
											</c:otherwise>
										</c:choose>	
									</c:if>
								</c:otherwise>								
							</c:choose>	
						</td>		
						<td>
						<c:choose>
						<c:when test="${isImmediateDrawdown}">
							-
						</c:when>
						<c:when test="${legDetailsId.productType eq 'EQUITY'}">
							<bean:message key="label.addLeg.no" />
							<c:set var="eBoardARFlagValue" scope="request" value="yes" />
						</c:when>
						<c:otherwise>
						<c:set var="eBoardARFlagValue" scope="request" value="no" />
							${legDetailsId.derivatives}
						</c:otherwise>
						</c:choose>
						</td>
						
				      
					</tr>
					<div class="modal hide fade deleteConfirm" id="deleteConfirm${legDetailsId.legNumber}" >
						<div class="modal-header" >
							<a class="close" data-dismiss="modal">X</a>
							<h3>Delete this Leg</h3>
						</div>
						<div class="modal-body" style="margin-top:-15px;">
							<div class="row">
								<p><b>Are you sure you want to Delete?</b><br>
							</p>
							</div>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn right btn-success" data-dismiss="modal" id="delete-legBtn" onclick="javascript:removeLeg(${legDetailsId.legNumber},${legDetailsId.legSeqId});">Yes, Delete this Leg</a>
							<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
						</div>
					</div>
					 <c:set var="rowCounter" value="${rowCounter + 1}"></c:set>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		
		
		<c:set var="rowCounter1" value="1"></c:set>
		<c:forEach var="legDetailsId1" items="${legList}" >
			<c:set var="isImmediateDrawdownDerivative" value="false"/>
			<c:if test="${legDetailsId1.transactionEventType eq 'Immediate Drawdown'}">
				<c:set var="isImmediateDrawdownDerivative" value="true"/>
			</c:if>
			<c:choose>
          		<c:when test="${legDetailsId1.derivatives eq 'Yes' and not isImmediateDrawdownDerivative}">
				<table
					class="table table-striped table-bordered sortable no-bottom nested"
					id="<c:out value="nested${rowCounter1}"></c:out>">
					<thead>
						<tr>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.itemNo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeName" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeType" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyOne" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyTwo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.hedgeDesg" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.taxDesg" /></th>
						</tr>
						<tr>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
						</tr>
					</thead>
					<tbody>
					<c:set var="derivativeList" value="${deal:fetchDerivatives(legDetailsId1.legNumber,pageContext)}" />
					<c:forEach var="derivativesSummaryId" items="${derivativeList}" >
						<tr>
							<td>${derivativesSummaryId.derivativeNumber} </td>
							<td>${derivativesSummaryId.internalOrExternal }</td>
							<td>${derivativesSummaryId.derivativeType }</td>
							<td>${derivativesSummaryId.currency1 }</td>
							<td>${derivativesSummaryId.derivativeAmount1 }</td>
							<td>${derivativesSummaryId.fixedOrFloat1 }</td>
							<td>${derivativesSummaryId.currency2 }</td>
							<td>${derivativesSummaryId.derivativeAmount2 }</td>
							<td>${derivativesSummaryId.fixedOrFloat2 }</td>
							<td>${derivativesSummaryId.hedgeDesigation }</td>
							<td>${derivativesSummaryId.taxDesigation }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<c:set var="rowCounter1" value="${rowCounter1 + 1}"></c:set>
		</c:forEach>
	</div>

</div><!-- end of form form-mod -->
		
	<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<%@ include file="../common/inc/exceptionDetails.jsp"%>
				</c:when>
				<c:otherwise>
				</c:otherwise>
		</c:choose>
        <!-- starts uploads-->
        <c:if test="${sessionScope.section eq 'myTasks' and deal.WFStage eq 'REREQUST'}">
        	<jsp:include page="../common/inc/viewAdditionalApprovers.jsp">
        		<jsp:param value="Yes" name="nonFourBlocker"/>
        	</jsp:include>
			<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
				<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
			</c:if>
			<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
		
			<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
        	<%@ include file="../common/inc/dealTeam.jsp"%>
        </c:if>
        <c:if test="${sessionScope.section eq 'myRequests'}">
          <c:if test="${not empty deal.WFStage and (deal.WFStage ne 'INITIATION' and deal.WFStage ne 'PLERIVEW')}">
        	<jsp:include page="../common/inc/viewAdditionalApprovers.jsp">
        		<jsp:param value="Yes" name="nonFourBlocker"/>
        	</jsp:include>
			<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
				<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
			</c:if>
			<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
		
			<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
        	<%@ include file="../common/inc/dealTeam.jsp"%>
        	</c:if>
        </c:if>
        
   <c:choose> 
    <c:when test="${not empty deal.WFStage and (deal.WFStage ne 'INITIATION')}">
    <%@ include file="../common/inc/actionLog.jsp"%>
	</c:when> 
	<c:otherwise>
	</c:otherwise>
  </c:choose> 
  <c:choose> 
    <c:when test="${not empty deal.WFStage and (deal.WFStage ne 'INITIATION')}">
    <jsp:include page="../common/inc/commentsLog.jsp" > 
       <jsp:param value="fundingRequest/newFundingRequest" name="path"/>
       <jsp:param value="load" name="method"/>
       <jsp:param value="New Financing Request" name="origin"/>	
	</jsp:include>
	</c:when> 
	<c:otherwise>
	</c:otherwise>
</c:choose>
  <div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						
						<label><bean:message key="label.fundingRequest.comments" /></label>
						<logic:messagesPresent property="comments">
							<span class="req-error" >a</span>
			  			</logic:messagesPresent>
						<div class="char-count">
						<label id="commentsID"><bean:message key="label.fundingRequest.impairmentcommentMaxSize" /></label>
						</div> <!-- fix positions -->
						  <html:textarea name="dealRequestForm"  tabindex="20" styleClass="xlarge autosize messageinput" property="comments" cols="100" rows="5" onblur="scriptInjection(this);" ></html:textarea>
						 	
						</div>
				</div> <!-- end of block -->
			</div>
        
         <jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        </jsp:include> 
         
    
        <!-- end uploads -->
       
    <c:choose> 
      <c:when test="${not empty deal.WFStage and (deal.WFStage ne 'INITIATION')}">
       <jsp:include page="../common/inc/auditLog.jsp" > 
           <jsp:param value="fundingRequest/newFundingRequest" name="path"/>
           <jsp:param value="load" name="method"/>
           <jsp:param value="New Financing Request" name="origin"/>	
	   </jsp:include>
	  </c:when> 
	 <c:otherwise>
	 </c:otherwise>
    </c:choose>
			
		<div class="span8 right btn-container">
		<c:if test="${sessionScope.section eq 'myTasks'}">
			<c:choose>
					<c:when test="${deal.WFStage eq 'REREQUST'}">
					<a href="#resubmitModelID" class="btn right btn-success modal-confirm" data-toggle="modal" >Resubmit Request</a>
					<a href="#withdrawModelID" class="btn right modal-confirm" data-toggle="modal" >Withdraw Request</a>
				    <a href="#saveDraftModelID" class="btn right modal-confirm" data-toggle="modal" >Save Draft</a>
					</c:when>
					 <c:otherwise>
					 <a href="#submitConfirmModelID" class="btn right btn-success modal-confirm" data-toggle="modal" >Submit Request</a>
					 <a href="#saveDraftModelID" class="btn right modal-confirm" data-toggle="modal" >Save Draft</a>
					 </c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${sessionScope.section eq 'myRequests'}">
			<c:choose>
					<c:when test="${empty deal.WFStage}">
					<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT'}"> 
					<a href="#submitConfirmModelID" class="btn right btn-success modal-confirm" data-toggle="modal" >Submit Request</a>
					<a href="#saveDraftModelID" class="btn right modal-confirm" data-toggle="modal" >Save Draft</a>
					</c:if>
					<c:if test="${empty deal.action}"> 
					<a href="#submitConfirmModelID" class="btn right btn-success modal-confirm" data-toggle="modal" >Submit Request</a>
					<a href="#saveDraftModelID" class="btn right modal-confirm" data-toggle="modal" >Save Draft</a>
					</c:if>
					</c:when>
					<c:when test="${deal.WFStage eq 'REREQUST'}">
					<a href="#resubmitModelID" class="btn right btn-success modal-confirm" data-toggle="modal" >Resubmit Request</a>
					<a href="#withdrawModelID" class="btn right modal-confirm" data-toggle="modal" >Withdraw Request</a>
				    <a href="#saveDraftModelID" class="btn right modal-confirm" data-toggle="modal" >Save Draft</a>
					</c:when>
			</c:choose>
		</c:if>
			
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
				
		</div>
		
   <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Financing Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/homePage.do" class="btn right btn-success">Yes, cancel the request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
	
	<%@include  file="../common/submitConfirm.jsp" %>
	<%@include  file="../common/saveDraft.jsp" %>
	<%@include  file="../common/withDraw.jsp" %>
	<%@include  file="../common/resubmit.jsp" %>
	
	<input type="hidden"  id="legNumber" name="legNumber" >
  </html:form>

  </body>
</html>

 