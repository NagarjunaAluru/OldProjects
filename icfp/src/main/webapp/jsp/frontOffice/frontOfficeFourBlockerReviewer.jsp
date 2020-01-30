<%@ page errorPage="../common/error.jsp" %>
<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ge.icfp.util.StaticDataFactory,com.ge.icfp.model.NameValue,java.util.List" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<% String servletContextUrl = request.getContextPath(); 
   int tsize = 0;
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
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <script type="text/javascript" >

//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Front Office</title>
    <meta name="description" content="">
    <meta name="author" content="">

   	<%@include file="../common/includeCssScripts.jsp" %>
	<script src="<%=servletContextUrl%>/js/FOFourblocker.js" type="text/javascript"></script>
	<style>
    .attach-btn { background-image:url(../img/btn_attach.gif); width: 60px; height: 26px; margin: 0; padding: 0; border: none; cursor: pointer; }
    .submit-box .btn-link{ left: -300px; position: absolute;bottom:18px;}
	.submit-box .initiate{ left: -240px; position: absolute;bottom:18px;}
    </style>	
	<script>
		
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
  </head>
  <body>
   <html:form action="/frontoffice/fourBlocker.do"  styleId="fundingRequestForm" method="post" onsubmit="submitFunction()"   enctype="multipart/form-data">
     
   <html:hidden property="page" value="2"/>
   <div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Front Office</li>
		</ul>
	
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
         <div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" id="topErrorDiv">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.saveMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.saveMessage}</strong> 
        </div>       		       
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
        </div>    
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.DeleteMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.DeleteMessage}</strong>
        </div>   
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.ErrorMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.ErrorMessage}</strong>
        </div>		       
        <h1 class="page-title span12">Front Office</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.reviewer.frontOffice" />
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</p>
		<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">
			<c:if test="${actionSection.groupName eq 'Requestor' and actionSection.decision eq 'Submit'}">
				<c:set var="reqInitiation" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'Pipeline Review'}">
				<c:set var="plReview" value="${actionSection.actionDt}"></c:set>
			</c:if>
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>
		</jsp:include>
		<span class="required-fields"><span>*</span> = Required</span>
		<div class="form-mod">
			<h2 class="span12">Project Summary</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
					<c:set var="userNameDetails" value="${userDetails:fullName(',','-')}" />
					<c:set var="userTitle" value="${userDetails:title('-')}" />
						<p><b><bean:message key="label.fundingRequest.transactionowner" /></b><br/>
						    <c:out value="${sessionScope.deal.firstName}" />,<c:out value="${sessionScope.deal.lastName}" />
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
						<c:choose>
							<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
			 				 	<p><b><bean:message key="label.fundingRequest.requestID" /></b></p>
							</c:when>
							<c:otherwise>
			   					<p><b><bean:message key="label.fundingRequest.dealID" /></b></p>
							</c:otherwise>
						</c:choose>
						<p>${deal.uniqueId}</p>
						<input type="hidden"  name="dealSeqId" value="${sessionScope.deal.dealSeqId}" id="dealSeqId" />
					</div>
				</div><!-- end of block -->
				<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
			  				<label><bean:message key="label.fundingRequest.description" /></label>
						<span id="dealNameErrorSpan" class="req-error" style="display:none;">error</span>						  						  
						  <logic:messagesPresent property="dealName">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text property="fourBlocker.projectSummary.dealName" value="${sessionScope.deal.dealName}" tabindex="1" styleId="dealName" maxlength="100" />
	             	</div>
				</div> <!-- end of block -->
				</c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			</div> 
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<c:choose>
							<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
			  					<label><bean:message key="label.fundingRequest.requestCategory" /></label>
							</c:when>
							<c:otherwise>
			 					<label><bean:message key="label.fundingRequest.dealCategory" /></label>
							</c:otherwise>
						</c:choose>
						 <logic:messagesPresent property="dealCategoryId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:select tabindex="2" property="fourBlocker.projectSummary.dealCategory" 
							value="${sessionScope.deal.dealCategoryId}" styleClass="check" styleId="dealCategoryId">
   							<html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="dealCategories" value="ID" label="name"/>						   
						</html:select>
						<span id="dealCategoryIdErrorSpan" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			
			<%-- <c:choose>
			  <c:when test="${ empty requestScope.isCPA && requestScope.isCPA ne true}">
			  <div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
			  					<label><bean:message key="label.fundingRequest.dealName" /></label>
						<span id="dealNameErrorSpan" class="req-error" style="display:none;">error</span>						  						  
						  <logic:messagesPresent property="dealName">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text property="fourBlocker.projectSummary.dealName" value="${sessionScope.deal.dealName}" tabindex="1" styleId="dealName" maxlength="100" />
	             	</div>
				</div>
			  </c:when>
			  <c:otherwise></c:otherwise>
			
			</c:choose> --%>
			
			    <c:choose>
			    <c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<div class="span5 right">
					<div class="form-row autosize-container2 conditional-container">
						<span class="required">*</span>
			  				<label><bean:message key="label.fundingRequest.requestRationale" /></label>
						<logic:messagesPresent property="dealRationale">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <div class="char-count dealRationaleChar" style="margin-left:-10px;">2500</div>
						 <html:textarea styleClass="xlarge autosize2 messageinput" property="fourBlocker.projectSummary.dealRationale" value="${sessionScope.deal.dealRationale}"  styleId="dealRationaleId" onblur="scriptInjection(this);"/>
					<span id="dealRationaleIdErrorSpan" class="req-error" style="display:none;">error</span>
				  </div>
				</div> <!-- end of block -->
				</c:when>
				<c:otherwise>
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
			  					<label><bean:message key="label.fundingRequest.dealName" /></label>
						<span id="dealNameErrorSpan" class="req-error" style="display:none;">error</span>						  						  
						  <logic:messagesPresent property="dealName">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text property="fourBlocker.projectSummary.dealName" value="${sessionScope.deal.dealName}" tabindex="1" styleId="dealName" maxlength="100" />
	             	</div>
				</div>
				</c:otherwise>
				</c:choose>
			</div>
		<c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
							<p><b><bean:message key="cpafundingRequest.VaultRequestID" /></b></p>
						<c:choose>
          					<c:when test="${empty sessionScope.deal.vaultId}">
								<input type="text" name="vaultId" readonly="readonly" class="span3" value="--">
							</c:when>
							<c:otherwise>
								<input type="text" name="vaultId"  readonly="readonly" class="span3" value='${sessionScope.deal.vaultId}'>
							</c:otherwise>
						</c:choose>	
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			</c:when>
			<c:otherwise>
			<div class="row">
			  <div class="span5">
					<div class="form-row autosize-container2">
						<span class="required">*</span>
			  					<label><bean:message key="label.fundingRequest.dealRationale" /></label>
						<logic:messagesPresent property="dealRationale">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <div class="char-count dealRationaleChar" style="margin-left:-10px;">2500</div>
						 <html:textarea styleClass="xlarge autosize2 messageinput" property="fourBlocker.projectSummary.dealRationale" value="${sessionScope.deal.dealRationale}"  styleId="dealRationaleId" onblur="scriptInjection(this);"/>
					  <span id="dealRationaleIdErrorSpan" class="req-error" style="display:none;">error</span>
					</div>
					
				</div>
			</div>
			</c:otherwise>
		</c:choose>
			
			
        </div><!-- end of form form-mod -->
		
		 <c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
		    <div class="form-mod">
				<h2 class="span12"><bean:message key="label.fundingRequest.transactionSummaryandOwner" /></h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.impairmenthistory" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.impairmentHistory" />"></span>
							<span  class="help-block error" id="impairmentHistoryIdErrorSpan" style="display:none;"></span>
						</label>
						 <logic:messagesPresent property="impairmentHistoryFlag">
							<div class="radio-container conditional-radio req-error" id="impairmentHistoryIdErrorDiv">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="impairmentHistoryFlag">
	               				 <div class="radio-container conditional-radio" id="impairmentHistoryIdErrorDiv">
	                     </logic:messagesNotPresent>
	                     <c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tSummaryOwner'].map}" property="impairmentHistory" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
							<label class="radio">
								 <html:radio name="updateStatusForm"   styleClass="condition" tabindex="8"  property="fourBlocker.tSummaryOwner.impairmentHistory" value="Yes" styleId="impairmentHistoryId"></html:radio> Yes 
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
									 <html:textarea styleClass="xlarge autosize messageinput"  styleId="impairmentCommentID" property="fourBlocker.tSummaryOwner.impairmentComments" value="${sessionScope.deal.impairmentComment}" cols="100" rows="5" onblur="scriptInjection(this);" />
								</div>
							</div>
							<label class="radio">
								 <html:radio name="updateStatusForm"   tabindex="8"  property="fourBlocker.tSummaryOwner.impairmentHistory" value="No" styleId="impairmentHistoryNoId"></html:radio> No
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
							    <html:hidden styleId="prudentiallyID" property="fourBlocker.tSummaryOwner.prudentiallyRegulatedLegalEntity" value="1" />
							  </c:when>
							  <c:when test="${getPrudentialEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="prudentiallyID" property="fourBlocker.tSummaryOwner.prudentiallyRegulatedLegalEntity" value="0" />
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
							<span  class="help-block error" id="financialStatementIdErrorSpan" style="display:none;"></span>
						</label>
						<logic:messagesPresent property="finSttmntDtAboveOneYrFlag">
							     <div class="radio-container conditional-radio req-error" id="financialStatementIdErrorDiv">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="finSttmntDtAboveOneYrFlag" >
	               				 <div class="radio-container conditional-radio" id="financialStatementIdErrorDiv">
	                     </logic:messagesNotPresent>
							<label class="radio">
								<c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tSummaryOwner'].map}" property="financialStatementFlag" value="${deal:getFinalStatement(pageContext.request)}" />
								<html:radio name="updateStatusForm" tabindex="10"  styleClass="condition" property="fourBlocker.tSummaryOwner.financialStatementFlag" value="1" styleId="isFinancialStatementDateID"></html:radio> Yes 
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
									<c:set var="lastFSDt" value="" />
									<c:if  test="${not empty sessionScope.deal.latestDtOfFinSttmnt}">
									<c:set var="lastFSDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.latestDtOfFinSttmnt, 'MM/dd/yyyy')}" />
									</c:if>
									<html:text styleId="lastDateofFinancialStmtID"  readonly="true" property="fourBlocker.tSummaryOwner.latestDateOfFinancialStatement"  styleClass="span3 datepicker-field" maxlength="10"   value="${lastFSDt}" />
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
									
								</div>
							</div>
							<label class="radio">
								<html:radio name="updateStatusForm" tabindex="10" styleId="isFinancialStatementDateID" property="fourBlocker.tSummaryOwner.financialStatementFlag" value="0" ></html:radio> No
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
							    <html:hidden styleId="principalID" property="fourBlocker.tSummaryOwner.principalLegalEntity"  value="1"/>
							  </c:when>
							  <c:when test="${getPrincipalEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="principalID" property="fourBlocker.tSummaryOwner.principalLegalEntity"  value="0"/>
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
						    <html:hidden styleId="nonStandardDocsFlagID" property="fourBlocker.tSummaryOwner.nonStandardLegalAgreement" value="1" />
						  </c:when>
						  <c:when test="${nonStandardDocsFlag eq 'No'}">
						    <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.addLeg.no" /></label>
						     <html:hidden styleId="nonStandardDocsFlagID" property="fourBlocker.tSummaryOwner.nonStandardLegalAgreement" value="0" />
						  </c:when>
						  <c:otherwise>
						  <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.pipelineReviewDeal.crossBorder"/></label>
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
						  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
						    <label ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="1" />
						  </c:when>
						  <c:when test="${getCrossBorderFlagValue eq 'No'}">
						    <label  ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="0" />
						  </c:when>
						  <c:otherwise>
						  <label><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
					</div>
			</div>
        </div><!-- end of form form-mod -->
	</c:when>
         <c:otherwise>
		  <div class="form-mod">
			<h2 class="span12"><bean:message key="label.fundingRequest.transactionSummaryandOwner" /></h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.fundingRequest.securitytype" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.securityType" />"></span></label>
						<span  class="help-block error" id="securityTypeIdErrorSpan" style="display:none;"></span>
						<logic:messagesPresent property="securityCategoryId">
							<div class="radio-container req-error" id="securityTypeIdErrorDiv">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="securityCategoryId" >
	               				 <div class="radio-container" id="securityTypeIdErrorDiv">
	                    </logic:messagesNotPresent>
	                    <c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tSummaryOwner'].map}" property="securityType" value="${sessionScope.deal.securityCategoryId}" />
						<label class="radio">
							<html:radio name="updateStatusForm" tabindex="4" property="fourBlocker.tSummaryOwner.securityType"  value="1" styleId="securityTypeId"></html:radio> Secured
						</label>
						<label class="radio">
							<html:radio name="updateStatusForm"  tabindex="4" property="fourBlocker.tSummaryOwner.securityType" value="2" styleId="securityTypeId"></html:radio> Unsecured
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
							    <html:hidden  styleId="derivativesFlagID" property="fourBlocker.tSummaryOwner.derivatives"  value="1" />
							  </c:when>
							  <c:when test="${getDerivativesRequestsFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden  styleId="derivativesFlagID" property="fourBlocker.tSummaryOwner.derivatives"  value="0" />
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
							<span  class="help-block error" id="impairmentHistoryIdErrorSpan" style="display:none;"></span>
						</label>
						 <logic:messagesPresent property="impairmentHistoryFlag">
							<div class="radio-container conditional-radio req-error" id="impairmentHistoryIdErrorDiv">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="impairmentHistoryFlag">
	               				 <div class="radio-container conditional-radio" id="impairmentHistoryIdErrorDiv">
	                     </logic:messagesNotPresent>
	                     <c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tSummaryOwner'].map}" property="impairmentHistory" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
							<label class="radio">
								 <html:radio name="updateStatusForm"   styleClass="condition" tabindex="8"  property="fourBlocker.tSummaryOwner.impairmentHistory" value="Yes" styleId="impairmentHistoryId"></html:radio> Yes 
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
									 <html:textarea styleClass="xlarge autosize messageinput"  styleId="impairmentCommentID" property="fourBlocker.tSummaryOwner.impairmentComments" value="${sessionScope.deal.impairmentComment}" cols="100" rows="5"  onblur="scriptInjection(this);"/>
								</div>
							</div>
							<label class="radio">
								 <html:radio name="updateStatusForm"   tabindex="8"  property="fourBlocker.tSummaryOwner.impairmentHistory" value="No" styleId="impairmentHistoryId"></html:radio> No
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
							    <html:hidden styleId="equityInfusionsDividendsFlagID" property="fourBlocker.tSummaryOwner.equityInfusionDividends" value="1" />
							  </c:when>
							  <c:when test="${getEquityInfusionsDividendsFlag eq 'No'}">
							    <label><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="equityInfusionsDividendsFlagID" property="fourBlocker.tSummaryOwner.equityInfusionDividends" value="0" />
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
							<span  class="help-block error" id="financialStatementIdErrorSpan" style="display:none;"></span>
						</label>
						<logic:messagesPresent property="finSttmntDtAboveOneYrFlag">
							     <div class="radio-container conditional-radio req-error" id="financialStatementIdErrorDiv">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="finSttmntDtAboveOneYrFlag" >
	               				 <div class="radio-container conditional-radio" id="financialStatementIdErrorDiv">
	                     </logic:messagesNotPresent>
							<label class="radio">
								<c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tSummaryOwner'].map}" property="financialStatementFlag" value="${deal:getFinalStatement(pageContext.request)}" />
								<html:radio name="updateStatusForm" tabindex="10"  styleClass="condition" property="fourBlocker.tSummaryOwner.financialStatementFlag" value="1" styleId="isFinancialStatementDateID"></html:radio> Yes 
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
									<c:set var="lastFSDt" value="" />
									<c:if  test="${not empty sessionScope.deal.latestDtOfFinSttmnt}">
										<c:set var="lastFSDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.latestDtOfFinSttmnt, 'MM/dd/yyyy')}" />
									</c:if>
									<html:text styleId="lastDateofFinancialStmtID" readonly="true"  property="fourBlocker.tSummaryOwner.latestDateOfFinancialStatement"  styleClass="span3 datepicker-field" maxlength="10"   value="${lastFSDt}" />
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
									
								</div>
							</div>
							<label class="radio">
								<html:radio name="updateStatusForm" tabindex="10" styleId="isFinancialStatementDateID" property="fourBlocker.tSummaryOwner.financialStatementFlag" value="0" ></html:radio> No
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
							    <html:hidden styleId="prudentiallyID" property="fourBlocker.tSummaryOwner.prudentiallyRegulatedLegalEntity" value="1" />
							  </c:when>
							  <c:when test="${getPrudentialEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="prudentiallyID" property="fourBlocker.tSummaryOwner.prudentiallyRegulatedLegalEntity" value="0" />
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
				</div> <!-- end of block -->
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.principleLegalEntity" /></label>
						<c:set var="getPrincipalEntityFlag" value="${deal:getPrincipalEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrincipalEntityFlag eq 'Yes'}">
							    <label ><bean:message key="label.addLeg.yes" /></label>
							    <html:hidden styleId="principalID" property="fourBlocker.tSummaryOwner.principalLegalEntity"  value="1"/>
							  </c:when>
							  <c:when test="${getPrincipalEntityFlag eq 'No'}">
							    <label ><bean:message key="label.addLeg.no" /></label>
							    <html:hidden styleId="principalID" property="fourBlocker.tSummaryOwner.principalLegalEntity"  value="0"/>
							  </c:when>
							  <c:otherwise>
							  <label ><bean:message key="label.newRequests.data" /></label>
							  </c:otherwise>
							</c:choose>
					</div>
				</div> <!-- end of block -->
			</div>
			<c:set var="requestFrmtDt" value="" />
			<c:if test="${not empty sessionScope.deal.requestDt}">
				<c:set var="requestFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.requestDt, 'MM/dd/yyyy')}" />
			</c:if>
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.fundingRequest.nonStandardLegalAgreement" /></label>
						<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${nonStandardDocsFlag eq 'Yes'}">
						    <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden styleId="nonStandardDocsFlagID" property="fourBlocker.tSummaryOwner.nonStandardLegalAgreement" value="1" />
						  </c:when>
						  <c:when test="${nonStandardDocsFlag eq 'No'}">
						    <label id="nonStandardLegalAgreementLabelID" ><bean:message key="label.addLeg.no" /></label>
						     <html:hidden styleId="nonStandardDocsFlagID" property="fourBlocker.tSummaryOwner.nonStandardLegalAgreement" value="0" />
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
						    <html:hidden styleId="isSubOrdinateDebtID" property="fourBlocker.tSummaryOwner.subordinatedDebt" value="1"/>
						  </c:when>
						  <c:when test="${subOrdinateDebtFlag eq 'No'}">
						    <label  ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden styleId="isSubOrdinateDebtID" property="fourBlocker.tSummaryOwner.subordinatedDebt" value="0"/>
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
						<label><bean:message key="label.pipelineReviewDeal.crossBorder"/></label>
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
						  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
						    <label ><bean:message key="label.addLeg.yes" /></label>
						    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="1" />
						  </c:when>
						  <c:when test="${getCrossBorderFlagValue eq 'No'}">
						    <label  ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="0" />
						  </c:when>
						  <c:otherwise>
						  <label><bean:message key="label.newRequests.data" /></label>
						  </c:otherwise>
						</c:choose>
					</div>
			</div> <!-- end of block -->
				
			</div>
        </div><!-- end of form form-mod -->
		 </c:otherwise>
    </c:choose>
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
						<span  class="help-block error" id="priorityIdErrorSpan" style="display:none;"></span>
						<logic:messagesPresent property="priorityId">
							     <div class="radio-container conditional-radio-tri req-error" id="priorityIdErrorDiv">
						 </logic:messagesPresent>
						 <logic:messagesNotPresent property="priorityId">
	               				 <div class="radio-container conditional-radio-tri" id="priorityIdErrorDiv">
	                     </logic:messagesNotPresent>
							<c:set target="${sessionScope.updateStatusForm.map['fourBlocker'].map['tPriorityTimings'].map}" property="priority" value="${sessionScope.deal.priorityId}" />
							<label class="radio">
							    <html:radio tabindex="14" styleClass="condition" styleId="isPriority" name="updateStatusForm" property="fourBlocker.tPriorityTimings.priority" value="1"  ></html:radio>  
								<span><bean:message key="label.fundingRequest.priorityHigh"/></span>
							</label>
							<div id="priorityCommentHighID" class="autosize-container conditional-container">
								<div class="form-row" id="firstDivID">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									
									<span class="req-error" id="firstspamCommentID" style="display:none;">a</span> 
						  			
									<div class="char-count">
									<label id="highPriorityLabelID" class="char-count-label">
									<bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									
									
									<textarea class="xlarge autosize messageinput" name="textpriorityComment" onblur="scriptInjection(this);" id="firstCommentID" cols="100" rows="5"></textarea>
								</div>
							</div>
							<label class="radio">
								<html:radio tabindex="14" styleClass="condition" name="updateStatusForm" property="fourBlocker.tPriorityTimings.priority" styleId="isPriority" value="2" ></html:radio> 
		                        <span><bean:message key="label.fundingRequest.priorityMedium"/></span>
							</label>
							<div  id="priorityCommentMediumID" class="autosize-container conditional-container">
								<div class="form-row" id="secondDivID">
									<span class="required">*</span>
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									<span class="req-error" id="secondspamCommentID" style="display:none;">a</span>
									<div class="char-count">
									<label id="mediumPriorityLabelID" class="char-count-label">
									 <bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									
									<textarea class="xlarge autosize messageinput" name="textpriorityComment" id="secondCommentID" cols="100" rows="5" onblur="scriptInjection(this);"></textarea>
								</div>
							</div>
							<label class="radio">
								 <html:radio tabindex="14" styleClass="condition" name="updateStatusForm" property="fourBlocker.tPriorityTimings.priority" styleId="isPriority" value="3" ></html:radio> 
		                    	 <span><bean:message key="label.fundingRequest.priorityLow"/></span>
							</label>
							<div  id="priorityCommentLowID" class="autosize-container conditional-container">
								<div class="form-row" id="thirdDivID">
									<label><bean:message key="label.fundingRequest.priorityComment" /></label>
									<span class="req-error" id="thirdspamCommentID" style="display:none;">a</span>
									<div class="char-count">
									<label id="lowPriorityLabelID" class="char-count-label">
									 <bean:message key="label.fundingRequest.impairmentcommentMaxSize"/>
									</label>
									</div> <!-- fix positions -->
									
									<textarea class="xlarge autosize messageinput" name="textpriorityComment" id="thirdCommentID" cols="100" rows="5" onblur="scriptInjection(this);"></textarea>
								</div>
							</div>
							<html:hidden  name="dealRequestForm" property="priorityComment" />
							<html:hidden  property="fourBlocker.tPriorityTimings.priorityComments"  styleId="priorityCommentID" value="${sessionScope.deal.priorityComment}" />
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
	                       <html:select tabindex="15"  name="updateStatusForm" property="fourBlocker.tPriorityTimings.regionResponsibility" value="${sessionScope.deal.responsibleRegionId}"  styleClass="check"  styleId="regionResponsibilityId">
	   							<html:option value="">Select...</html:option>
	   							<html:option value="1" ><span>Americas</span> </html:option>
	   							<html:option value="2" ><span>Europe</span> </html:option>
	   							<html:option value="3" ><span>Asia</span> </html:option>
   						   </html:select>
   						   <span id="regionResponsibilityIdErrorSpan" class="req-error" style="display:none;">error</span>
						</div>
					</div>
				</div> <!-- end of block -->
			<div class="row">
			<c:set var="requestFrmtDt" value="" />
			<c:if test="${not empty sessionScope.deal.requestDt}">
				<c:set var="requestFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.requestDt, 'MM/dd/yyyy')}" />
			</c:if>
				<div class="span5">
					<div class="form-row">
						<p><b>Request Date</b><br />
							<c:choose>
							<c:when test="${requestFrmtDt eq '//'}">
								-
							</c:when>
							<c:otherwise>
								<label>
								${requestFrmtDt}
								</label>
							</c:otherwise>
						</c:choose></p>
					</div>
				</div><!-- end of block -->
            </div><!-- end of form form-mod -->
           <div class="row">
             
            <div class="span5 right">
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
						<c:set var="valueFrmtDt" value="" />
						<c:if  test="${not empty sessionScope.deal.valueDt}">
						<c:set var="valueFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.valueDt, 'MM/dd/yyyy')}" />
						</c:if>
						<span id="valueDtIdErrorSpan" class="req-error" style="display:none;">error</span>
						<logic:messagesPresent property="valueDateInPipeLineReview">
							<span  class="help-block error" ><bean:message key="valueDateInPipeLineReview" /></span>
						</logic:messagesPresent>
						<html:text property="fourBlocker.tPriorityTimings.valueDt"  readonly="true" styleClass="span3 datepicker-field" maxlength="10"  value="${valueFrmtDt}" styleId="valueDtId"/>
						<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
					</div>
			     </div><!-- end of block -->
			    </div>
	        <c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<jsp:include page="../common/inc/cpaRequestDetails.jsp">
						<jsp:param value="cpafrontOffice" name="path"/>
					</jsp:include>
					<jsp:include page="../common/inc/cashPoolDetails.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/inc/transactionLegs.jsp">
			            <jsp:param value="frontOffice" name="path"/>
		            </jsp:include>
				</c:otherwise>
			</c:choose>
<!-- end of form form-mod -->
	 <!-- starts exceptions-->
            <c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<%@ include file="../common/inc/exceptionDetails.jsp"%>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
        
    
        <!-- end exceptions -->
        <jsp:include page="../common/inc/editAdditionalApprovers.jsp">
			<jsp:param value="frontOffice" name="path"/>
		</jsp:include>
			<c:choose>
				<c:when test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
					<jsp:include page="businessApprovers.jsp">
						<jsp:param value="frontOffice" name="path"/>
					</jsp:include>
				</c:when>
				<c:otherwise>
			    </c:otherwise>
			</c:choose>
		
		
	    
    		<!-- Including decision page -->
    		<%@ include file="../common/inc/dealTeam.jsp"%>
	 		<jsp:include page="../common/inc/actionLog.jsp">
				<jsp:param name="formName" value="dealRequestForm"/>			
			</jsp:include>
			<div class="form-mod">
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="frontoffice/fourBlocker" name="path"/>
				<jsp:param value="Front Office" name="name"/>	
				<jsp:param value="load" name="method"/>
				<jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>	
			</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="dealComments"	rows="4" id="dealCommentsId" onblur="scriptInjection(this);">${sessionScope.deal.comments}</textarea>
							<span class="req-error" id="dCommentsError1">error</span> 
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
			
			<!-- starts uploads-->
	        <c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaDealPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
				<!-- end uploads -->
				</c:when>
				<c:otherwise>
				<!-- starts uploads-->
				<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
					<jsp:param name="mode" value="edit" />
				</jsp:include> 
				<!-- end uploads -->
					
			    </c:otherwise>
			</c:choose>
	        <!-- end uploads -->
			
			<jsp:include page="../common/inc/auditLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="frontoffice/fourBlocker" name="path"/>
				<jsp:param value="Front Office" name="name"/>
				<jsp:param value="load" name="method"/>
				<jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>
			</jsp:include>
						
 			<div class="span12 right btn-container">
				<div class="span3 right submit-box">
					<div class="form-row" id="actionsId">
						<div class="radio-container">
							<c:if test="${sessionScope.section eq 'myTasks'}">

							<label class="radio">
								<input type="radio" value="affirm" name="submitDealFB" id="affirmRadioId">
								Inputs Completed
							</label>
							<label class="radio">
								<input type="radio"  value="sendBack" name="submitDealFB" >
								Send back
							</label>
							<label class="radio">
								<input type="radio" value="reject" class="rejectRequestF"  name="submitDealFB">
								Reject
							</label>
							<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AssignReviewer">
							<label class="radio" id="assignReviewerButton">
								<input type="radio" class="assignReviewer" value="assignAReviewer" name="submitDealFB">
								Assign a reviewer
							</label>
							</security:hasRoles>
							</c:if>
							<input type="hidden" name="actionId" id="actionID" >
							<input type="hidden" name="forwardPage" id="forwardPageId"> 
							<input type="hidden" name="roleId" value="6">
							<input type="hidden" name="approveReject" id="approveRejectId">
							<input type="hidden" name="WFId" value="${param.WFId}">
							<input type="hidden" name="WFStage" value="${param.WFStage}">
							<input type="hidden" name="queueName" value="${param.queueName}">
							<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
							<label class="radio" id="assignReviewerButton">
								<input type="radio" class="assignReviewer" value="assignAReviewer" name="submitDealFB">
								Assign a reviewer
							</label>
							</c:if>
						<input type="hidden" name="acctionComments" id="actionCommentsID">
						<input type="hidden" name="comments" id="commentsID">
						</div>
					</div>
					<div id="actionButton">
						<a class="btn btn-success btn-large" id="submit" href="#">Submit</a>
					</div>
				</div>
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div id="alignBtn">
					<a class="btn right save-btn single" id="saveAction" href="#" >Save</a>
					<a href="javascript:getApprovers()"  class="spaceBtn initiate btn right cancel" 
						data-toggle="button" data-loading-text="loading...">Initiate S&O reaffirmation</a>
					<a href="#confirm" class="btn-link right cancel modal-confirm spaceBtn" data-toggle="modal" >Cancel</a>
				</div>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
					<a href="#confirm" class="btn-link right cancel modal-confirm spaceBtn" data-toggle="modal" >Cancel</a>
				</c:if>
			</div>
   	<hr>
	<%@include  file="../common/footerSection.jsp" %>
	<div class="modal hide fade" id="sendback">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<div class="span5">
					<p>To send back to Requester, please enter your comment below</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="sendbackComments" onblur="scriptInjection(this);"></textarea>
						<span class="req-error" id="sbCommentsError1">error</span> 
						<span style="color: red" id="errorComents"></span>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="sendBack">Send back</a> 
			<a href="#"	class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="rejectRequestF">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Reject</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to reject this Request? <br />This action can not be undone.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span class="req-error" id="rejectCommentsErrorBar">error</span> 
						<div class="char-count">
							<label id="rejectRequestCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="rejectRequestComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" data-dismiss="modal"  id="reject">Reject this request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	
	
	
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Funding Request</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
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
 	<input type="hidden"  name="isCPA" value="${requestScope.isCPA}" id="isCPA" />	
 	<input type="hidden"  name="foAffirmFlag" value="${deal:getFOAffirmFlag(pageContext.request)}" id="foAffirmFlagId" />
	<input type="hidden"  id="legNumber" name="legNumber" >
	
	<div class="modal hide fade" id="reaffirmApproversId">
		<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Assign Re-affirmation Approvers<span></span></h3>
			</div>
			<div class="modal-body">
			</div>
			<div class="modal-footer">
				<a href="#" class="btn right btn-success" id="reaffirmationId" onclick="javascript:submitReaffirm();" >Assign Reaffirm Approvers</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
	 <div class="modal hide fade" id="assignReviewerpopup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Assign Reviewer</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to Assign this request to <span id="lastfirstnames"></span> ? </b><br>
			Note: Any change made on the deal page prior to assigning a reviewer will not get saved.
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn right btn-success" data-toggle="modal" onclick="assignMember()">Yes, Assign a Reviewer</button>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
      </div>
      
      <div class="modal hide fade" id="inputsCompletedModalID">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			      <h3>Inputs completed for Request</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to Submit Financing Request?</b><br>  </p>
			</div>
		</div>
		<div class="modal-footer">
		        <a href="#" class="btn right btn-success" onclick="inputsCompleted()">Yes, submit the request</a>
			    <a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
	
      <!-- Assign a Reviewer Popup -->
	<%@ include file="../common/inc/assignReviewer.jsp"%>
	
	<div class="modal hide fade" id="saveDataModelID">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Save Financing Request</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to Save Financing Request?</b><br>
			    </p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" onclick="saveData()">Yes, save the request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
  </html:form>
  </body>
</html>

 