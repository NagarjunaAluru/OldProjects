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
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
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
	<script src="<%=servletContextUrl%>/js/newFundingRequest.js" type="text/javascript"></script>

	<script>

//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';

</script>
<script type="text/javascript" src="<%=servletContextUrl%>/js/newFundingRequestWlegs.js">
</script>
  </head>

  <body >
   <html:form action="/fundingRequest/newFundingRequest.do"  styleId="fundingRequestForm" method="post" onsubmit="submitFunction()"   enctype="multipart/form-data">
    
      <html:hidden property="page" value="2"/>
      
      
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">New Financing Request</li>
		</ul>

		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="01a._RCA_-_New_Funding_Request-add_a_leg.html"  class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
        <div class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
         <logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
        	   </div>
		       
         </logic:messagesPresent>
         ${requestScope.successMsg}
        <h1 class="page-title span12">New Financing Request</h1>
		<p class="span12 left clear dashdesc">To begin a new financing request, please complete the Transaction Summary below.
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
	    	
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
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.fundingRequest.transactionownertitle" /></b><br />
						</p>
						<c:out value="${userTitle}" />
					</div>
				</div><!-- end of block -->
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
						 <html:text  name="dealRequestForm"   tabindex="1" property="dealName"  styleId="dealName" maxlength="20"   />
						  	
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
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.dealRationale" /></label>
						<logic:messagesPresent property="dealRationale">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <div class="char-count"> 
						 <label id="dealRationaleSizeID"><bean:message key="label.fundingRequest.impairmentcommentMaxSize" /></label>
						 </div> <!-- fix positions -->
						 <html:textarea  name="dealRequestForm"  styleClass="xlarge autosize messageinput"  property="dealRationale"   tabindex="3" cols="100" rows="5"  ></html:textarea>
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
						<label><bean:message key="label.fundingRequest.securitytype" /></label>
						
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
						<label><bean:message key="label.fundingRequest.crossborder" />
							<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
						</label>
					
						  <logic:messagesPresent property="crossBorderFlag">
							<div class="radio-container req-error">
						  </logic:messagesPresent>
						   <logic:messagesNotPresent property="crossBorderFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<label class="radio">
								  <html:radio  name="dealRequestForm" styleId="crossBorderFlagID"  tabindex="6" property="crossBorderFlag" value="1" ></html:radio> Yes 
							</label>
							<label class="radio">
								  <html:radio name="dealRequestForm"  styleId="crossBorderFlagID"  tabindex="6" property="crossBorderFlag" value="0" ></html:radio> 	No
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
						<label><bean:message key="label.fundingRequest.impairmenthistory" />
							<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
						</label>
						 
						 <logic:messagesPresent property="impairmentHistoryFlag">
							<div class="radio-container conditional-radio req-error">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="impairmentHistoryFlag">
	               				 <div class="radio-container conditional-radio">
	                     </logic:messagesNotPresent>
							<label class="radio">
								 <html:radio name="dealRequestForm"   styleClass="condition" tabindex="8"  property="impairmentHistoryFlag" value="1" ></html:radio> Yes 
							</label>
							<div id="impairmentCommentID" class="autosize-container conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.impairmentcomment" /></label>
									<div class="char-count" >
									  <label id="impairmentCommentDivID"><bean:message key="label.fundingRequest.impairmentcommentMaxSize" /></label>
									</div> <!-- fix positions -->
									<logic:messagesPresent property="impairmentComment">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
									 <html:textarea name="dealRequestForm"    styleClass="xlarge autosize messageinput"  styleId="impairmentCommentID" property="impairmentComment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
								</div>
							</div>
							
							<label class="radio">
								 <html:radio name="dealRequestForm"   tabindex="8"  styleId="isImpairmentHistoryNoID" property="impairmentHistoryFlag" value="0" ></html:radio> No
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
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.financialstatementsdate" />
							<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
						</label>
						
						<logic:messagesPresent property="finSttmntDtAboveOneYrFlag">
							     <div class="radio-container conditional-radio req-error">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="finSttmntDtAboveOneYrFlag">
	               				 <div class="radio-container conditional-radio">
	                     </logic:messagesNotPresent>
							<label class="radio">
								 <html:radio name="dealRequestForm"   tabindex="10"  styleClass="condition" property="finSttmntDtAboveOneYrFlag" value="1" ></html:radio> Yes 
							</label>
							<div id="lastDateofFinancialStmtDivID" class="conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.latestdateoffinancialstatement" /></label>
									<logic:messagesPresent property="latestDtOfFinSttmnt">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
						  			<logic:messagesPresent property="latestDtOfFinSttmntCurrDateValidation">
										<span  class="help-block error" ><bean:message key="latestDtOfFinSttmntValidation" /></span>
									</logic:messagesPresent>
									<html:text name="dealRequestForm"  styleId="lastDateofFinancialStmtID"  property="latestDtOfFinSttmnt"  styleClass="span3 date" maxlength="10"   />
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
									
								</div>
							</div>
							<label class="radio">
								<html:radio name="dealRequestForm"   tabindex="10" styleId="isFinancialStatementDateID" property="finSttmntDtAboveOneYrFlag" value="0" ></html:radio> No
							</label>
							
						</div>
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
									<logic:messagesPresent property="priorityComment">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
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
	   							<html:option value="1" ><span>Americas</span> </html:option>
	   							<html:option value="2" ><span>Europe</span> </html:option>
	   							<html:option value="3" ><span>Asia</span> </html:option>
   						   </html:select>
						</div>
					</div>
				
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>
							<bean:message key="label.fundingRequest.valueDate" />
							<span class="ttip info" data-original-title="<bean:message key="label.fundingRequestTooltip.valueDate" />"></span>
						</label>
						<logic:messagesPresent property="valueDt">
							<span class="req-error" >a</span>
						</logic:messagesPresent>
						<logic:messagesPresent property="valueDateValidation">
							<span  class="help-block error"><bean:message key="valueDateValidation" /></span>
						</logic:messagesPresent>
						<logic:messagesPresent property="dayOfTheWeek">
							<span  class="help-block error"><bean:message key="dayOfTheWeek" /></span>
						</logic:messagesPresent>
						<html:text name="dealRequestForm"   property="valueDt"  styleClass="span3 date" maxlength="10"   />
						<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
					</div>
			     </div><!-- end of block -->
            </div><!-- end of form form-mod -->
	<div class="form-mod">
	<h2 class="span12 collapsible" id="legTable"><bean:message key="heading.transactionLegs" /></h2>
	 
	<div class="row">
				<div class="span9">
				  <%if(size<=0){ %>
	                <span style="display:none;" class="error">&nbsp;&nbsp;&nbsp;&nbsp;Please add atleast one leg. </span>				
				   <%} %>
					<div class="table-btn">
					  <logic:messagesPresent property="fundingRequest.legs">
					    <span class="req-error" >a</span>
					   </logic:messagesPresent>
						  <span class="required">*</span>
						<button type="submit" name="command" value="addLeg" tabindex="18" class="btn">Add a Leg...</button>

						
					<!--		<html:submit property="command" tabindex="18" styleClass="btn" title="Add a leg..." value="addLeg"/>  
						<a class="btn"  href="<%=servletContextUrl%>/fundingRequest/newFundingRequest.do?command=addLeg">Add a leg...</a> -->

					</div>
				</div> <!-- end of block -->
	</div> 
	<div class="form-row autosize-container">
		<div>
		<input type="hidden" name="legLen"  id="legLen" value="0" />
		<c:set var="numberoflegs" value="${deal:getTotalNumberofLegs(pageContext.request)}" />
			<label><bean:message key="label.transactionLegs.noOfLegs" /><%--  ${fourBlockerForm.deal.numberOfTransactions}  --%>
				<c:out value="${numberoflegs}" /> </label>
			<table
				class="table table-striped table-bordered sortable no-bottom table-nested">
				<thead>
					  <tr>
						<th rowspan="2"></th>
						<th rowspan="2" colspan="2">Action</th>
						<th rowspan="2">Leg #</th>
						<th rowspan="2">Product Type</th>
						<th rowspan="2">Term <span class="small">in months</span></th>
						<th colspan="2" class="nosort">Lender/Provider</th>
						<th colspan="2" class="nosort">Borrower/Recipient</th>
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
					  </tr>
					</c:if>
					<c:set var="rowCounter" value="1"></c:set>
					<c:if test="${legList != null}"> 
					<c:forEach var="legDetailsId" items="${legList}" >
						<tr>
						<c:choose>
          					<c:when test="${legDetailsId.derivatives eq 'Yes'}">
								<td><a href="#" data-nested="<c:out value="nested${rowCounter}"></c:out>" class="exp"></a></td>
								<c:set var="rowCounter" value="${rowCounter + 1}"></c:set>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<%-- <td>-</td> --%>
						
						
						<td><a href="javascript:void(0);" id="deleteLeg" title="Delete this leg" class="delete-tr" onclick="javascript:removeLeg(this);">X</a></td>
						<td><a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Edit this leg" onclick="javascript:modifyLeg(${legDetailsId.legNumber});"></a></td>
						<td>${legDetailsId.legNumber}</td>
						<td>${legDetailsId.productType}</td>
						<td>${legDetailsId.termsInMths}</td>
						<td>${legDetailsId.lenderLegalEntity}</td>
						<td>${legDetailsId.lenderCountry}</td>
						<td>${legDetailsId.borrowerLegalEntity}</td>
						<td>${legDetailsId.borrowerCountry}</td>
						<td>${legDetailsId.originalCurrency}</td>
						<td>${legDetailsId.originalAmount}</td>
						<td>${legDetailsId.usdEquivalent}</td>
						<td>${legDetailsId.derivatives}</td>
						<td>${legDetailsId.existing}</td>
					</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		
		
		<c:set var="rowCounter1" value="1"></c:set>
		<c:forEach var="legDetailsId1" items="${legList}" >
			<c:choose>
          		<c:when test="${legDetailsId1.derivatives eq 'Yes'}">
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
				<c:set var="rowCounter1" value="${rowCounter1 + 1}"></c:set>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>

</div><!-- end of form form-mod -->
		
	
       		  
		<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
			<jsp:param name="mode" value="edit" />
		</jsp:include>  
		<!-- end uploads -->
        
		<div class="form-mod">
			<h2 class="span12 ">Comments</h2>
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
						  <html:textarea name="dealRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="comments" cols="100" rows="5" onblur="scriptInjection(this);" ></html:textarea>
						 	
						</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
		<div class="span8 right btn-container">
			    <html:submit property="command" tabindex="21" styleId="createRequestID" styleClass="btn right btn-success" > Create Request </html:submit>
				<html:submit property="command" tabindex="21" styleId="saveasdraftID" styleClass="btn right" >Save as Draft </html:submit>
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>

		</div>
		
   <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Funding Request</h3>
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
	
	

	
	<input type="hidden"  id="legNumber" name="legNumber" >
  </html:form>
  </body>
</html>

 