<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
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
	
	
	
	<script src="<%=servletContextUrl%>/js/newCPAFundingRequest.js" type="text/javascript"></script>
	
<script>

<%String regionCode = (String)session.getAttribute("regionLabel"); %>

<%String countryLabel = (String)session.getAttribute("countryLabel"); %>

<%String currencyLabel = (String)session.getAttribute("currencyLabel"); %>
	
</script>
	

  </head>

  <body >
   <html:form action="/fundingRequest/newCPAFundingRequest.do"  styleId="fundingRequestForm" method="post" onsubmit="submitFunction()"   enctype="multipart/form-data">
    
      <html:hidden property="page" value="2"/>
      <html:hidden name="dealRequestForm" property="cloneFlag" />
     <input type="hidden" name="legLen"  id="legLen" value="0" /> 
      
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
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="01a._RCA_-_New_Funding_Request-add_a_leg.html"  class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
        <div  id="validationsRequired" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
         <logic:messagesPresent >
		       <div  id="validationsRequired" class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
            	<logic:messagesPresent property="LegErrors">
            			<strong><html:errors property="LegErrors" /></strong>
            	</logic:messagesPresent>
        	   </div>
         </logic:messagesPresent>
         <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.successMsg ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.successMsg}</strong>
        </div>
        <h1 class="page-title span12">New Cash Pool Agreement Request</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.cpa.newFundingRequest" />
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
						<p><b><bean:message key="label.cpaFundingRequest.reqId" /></b></p>
						<p> <html:text  name="dealRequestForm"  tabindex="1" property="uniqueId" readonly="true"  maxlength="20"   /></p>
					 	<html:hidden name="dealRequestForm" property="dealSeqId"  />
						
						    
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.cpaFundingRequest.description" /></label>
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
						<label><bean:message key="label.cpaFundingRequest.reqCategory" /></label>
						 <logic:messagesPresent property="dealCategoryId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:select name="dealRequestForm"  tabindex="2" property="dealCategoryId"  styleClass="check">
   							<html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="dealCategories" value="ID" label="name"/>						   
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row autosize-container2">
						<span class="required">*</span>
						<label><bean:message key="label.cpaFundingRequest.reqRationale" /></label>
						<logic:messagesPresent property="dealRationale">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <div class="char-count dealCPARationaleChar" style="margin-left:-10px;">2500</div>
						 <html:textarea  name="dealRequestForm"  styleClass="xlarge autosize2 messageinput"  property="dealRationale"   styleId="dealRationaleId" tabindex="3" onblur="scriptInjection(this);"></html:textarea>
					</div>
				</div> <!-- end of block -->
			</div> 
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Vault Request ID</label>
						<logic:messagesPresent property="vaultId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="dealRequestForm"  readonly="true" property="vaultId"  maxlength="50"  value='${sessionScope.vaultRequestID}' />
					</div>
				</div>
			</div>
        </div><!-- end of form form-mod -->
		
		<div class="form-mod">
			<h2 class="span12"><bean:message key="label.fundingRequest.transactionSummaryandOwner" /></h2>
				
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
								 <html:radio name="dealRequestForm"   tabindex="8"  styleId="isImpairmentHistoryNoID" property="impairmentHistoryFlag" value="false" ></html:radio> No
							</label>
						 </div>	
						
						</div>
					</div>
				
				
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
			</div> <!--row end -->
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
									<html:text name="dealRequestForm" readonly="true"  styleId="lastDateofFinancialStmtID"  property="latestDtOfFinSttmnt"  styleClass="span3 requestdatepicker-field" maxlength="10"   />
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
						<c:set var="nonStandardDocsFlag" value="${deal:getCPANonStandardDocsFlag(pageContext.request)}" />
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
			    </div>
			 </div>  
			 
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
							<label><bean:message key="label.fundingRequest.crossborder" /></label>
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
						  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
						    <label ><bean:message key="label.addLeg.yes" /></label>
						     <html:hidden  name="dealRequestForm"   property="crossBorderFlag" value="1" />
						  </c:when>
						  <c:when test="${getCrossBorderFlagValue eq 'No'}">
						    <label  ><bean:message key="label.addLeg.no" /></label>
						    <html:hidden  name="dealRequestForm"   property="crossBorderFlag" value="0" />
						  </c:when>
						  <c:otherwise>
						  <label><bean:message key="label.newRequests.data" /></label>
						  <html:hidden  name="dealRequestForm"   property="crossBorderFlag" value="0" />
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
	   							<html:option value="1" ><span>Americas</span> </html:option>
	   							<html:option value="2" ><span>Europe</span> </html:option>
	   							<html:option value="3" ><span>Asia</span> </html:option>
   						   </html:select>
						</div>
					</div>
			</div> <!-- end of block -->
			
			<div class="row">	
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
			</div>	
			</div>

	<div class="form-mod" style="width:100%;">
	<h2  id="legTable"><bean:message key="heading.requestDetails" /></h2>
	<div class="row">
	  <div class="span2">
	  <div class="left">
	   <%if(size<=0){ %>
	                <span style="display:none;" class="error">&nbsp;&nbsp;&nbsp;&nbsp;Please add atleast one leg. </span>				
				   <%} %>
		<input type="hidden" name="legLen"  id="legLen" value="0" />
		<c:set var="numberoflegs" scope="page"  value="${deal:getTotalNumberofLegs(pageContext.request)}" />
			
						<!-- <span class="required">*</span> -->
						<label>Select Product</label>
						<span  class="help-block error" id="productTypefailed" style="display:none;">Please select Product Type</span>
						
						<html:select name="dealRequestForm" property="legTypeId" styleClass="span2" styleId="productType" disabled="true">
							<html:option value="3">CPA</html:option>
						</html:select>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
						
		
		
	  </div>
	  </div>
	  
	  <div class="span3" id="eventTypesDiv" style="margin-top:-5px;margin-left:-3px;">
	  <div class="left">
	  <label>Select Event</label>
						<c:if test ="${numberoflegs eq 1}">     
							<html:select name="dealRequestForm" property="eventTypeId" styleClass="span3" styleId="eventTypeId" disabled="true">
							<html:option value="">Select..</html:option>
							 <html:optionsCollection name="dealRequestForm" property="eventTypes" label="value" value="key"/> 
						</html:select>
						</c:if>
						<c:if test ="${numberoflegs eq 0}"> 
							<html:select name="dealRequestForm" property="eventTypeId" styleClass="span3" styleId="eventTypeId" >
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="dealRequestForm" property="eventTypes" label="value" value="key"/> 
						</html:select>
						</c:if>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>		
		
	  </div>
	  </div>
	  <div class="span3" id="addLegDivID">
	  <div class="left">
	  <label>&nbsp;</label>
			<logic:messagesPresent property="legSize">
		    		<span class="req-error" >a</span>
		   	</logic:messagesPresent>
					    <c:if test ="${numberoflegs eq 1}"> 
					  <button type="submit" name="command" disabled="disabled" value="addCPALeg" tabindex="18" class="btn">Add Request Details</button>
					  </c:if>
					  <c:if test ="${numberoflegs eq 0}"> 
					  <button type="submit" name="command" value="addCPALeg" tabindex="18" class="btn">Add Request Details</button>
					  </c:if>
						
	  </div>
	  </div>
	</div>
	<div class="autosize-container" style="overflow-x: auto;">

			<table
				class="table table-striped table-bordered sortable no-bottom table-nested" >
				<thead>
					  <tr>
						<th class="header" rowspan="2"></th>
						<th class="header" rowspan="2" colspan="2">Action</th>
						<th class="header" rowspan="2">Leg <br>#</th>
						<th class="header" rowspan="2">Product Type</th>
						<th class="header" rowspan="2">Inhouse Bank ID</th>
						<th colspan="4" class="nosort header">Participant</th>
						<th colspan="4" class="nosort header">Pool Leader</th>
						<th class="header" rowspan="2">Bank Name</th>
					  </tr>
					  <tr>
					    <th>Legal Entity<br>GOLD ID</th>
						<th>CDR</th>
						<th>Country</th>
						<th width="50px">ME</th>
						<th>Legal Entity<br>GOLD ID</th>
						<th>CDR</th>
						<th>Country</th>
						<th width="50px">ME</th>
						
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
						<td>-</td>
						<td>-</td>
						<td><a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Modify Request Details" onclick="javascript:modifyCPALeg(this);"></a></td>
						<c:choose>
						<c:when test="${not empty legDetailsId.legSeqId}">
						<td>${legDetailsId.legSeqId}</td>
						</c:when>
						<c:otherwise><td>-</td></c:otherwise>
						</c:choose>
						<td>${legDetailsId.product}</td>
						<c:if test="${empty legDetailsId.subLedgerTransactionId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.subLedgerTransactionId}"> 
							<td>${legDetailsId.subLedgerTransactionId}</td>
						</c:if>		
						<c:if test="${empty legDetailsId.participantGoldId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.participantGoldId}"> 
							<td>${legDetailsId.participantGoldId}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.CDRCd}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.CDRCd}">
							<td>${legDetailsId.participant.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.country}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.country}">
							<td>${legDetailsId.participant.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.MEName}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.MEName}">
							<td>${legDetailsId.participant.MEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolGoldId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.poolGoldId}"> 
							<td>${legDetailsId.poolGoldId}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.CDRCd}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.CDRCd}">
							<td>${legDetailsId.poolLeader.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.country}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.country}">
							<td>${legDetailsId.poolLeader.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.MEName}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.MEName}">
							<td>${legDetailsId.poolLeader.MEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeaderBankName}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.poolLeaderBankName}"> 
							<td>${legDetailsId.poolLeaderBankName}</td>
						</c:if>
						
					</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
	</div>
	</div><!-- end of form form-mod -->

     <input type="hidden" name="legSize" id="legSizeID"  value="${numberoflegs}"/>

	<c:if test="${legList != null}"> 
	<c:forEach var="legDetailsId" items="${legList}" >
	<div class="form-mod">
			<h2 class="span12">Cash Pool Details</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Cash Pool Name</b></p>
						<p>
						<c:if test="${!empty legDetailsId.cashPoolName}"> 
							<td>${legDetailsId.cashPoolName}</td>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Cash Pool Country</b></p>
						<p>
						<c:if test="${!empty legDetailsId.cashPoolCountry}"> 
							<td>${legDetailsId.cashPoolCountry}</td>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Cash Pool Region</b></p>
						<p>
						 <c:if test="${empty legDetailsId.cashPoolRegion}">
							<td>-</td>
						 </c:if>
						 <c:if test="${!empty legDetailsId.cashPoolRegion}"> 
							<td>${legDetailsId.cashPoolRegion}</td>
						 </c:if>
						
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Cash Pool Currency</b></p>
						<p>
						<c:if test="${empty legDetailsId.dealCurrency}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.dealCurrency}"> 
							<td>${legDetailsId.dealCurrency}</td>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
		</div>
		</c:forEach>
		</c:if>
		
		<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<%@ include file="../common/inc/exceptionDetails.jsp"%>
				</c:when>
				<c:otherwise>
				</c:otherwise>
		</c:choose>
	
        <!-- starts uploads-->
        
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
       <jsp:param value="New Cash Pool Agreement Request" name="origin"/>
       <jsp:param value="load" name="method"/>	
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
						  <html:textarea name="dealRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="comments" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
						 	
						</div>
				</div> <!-- end of block -->
			</div>
   
  		<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/cpaDealPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        </jsp:include> 
		 <!-- end uploads -->
    
        <!-- end uploads -->
    <c:choose> 
     <c:when test="${not empty deal.WFStage and (deal.WFStage ne 'INITIATION')}">
     <jsp:include page="../common/inc/auditLog.jsp" > 
       <jsp:param value="fundingRequest/newFundingRequest" name="path"/>
       <jsp:param value="New Cash Pool Agreement Request" name="origin"/>
       <jsp:param value="load" name="method"/>	
	 </jsp:include>
	 </c:when> 
	 <c:otherwise>
	 </c:otherwise>
   </c:choose>
    
        <!-- end uploads -->
       
        
		
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
	
	<%@include  file="../common/submitConfirm.jsp" %>
	<%@include  file="../common/saveDraft.jsp" %>
	<%@include  file="../common/withDraw.jsp" %>
	<%@include  file="../common/resubmit.jsp" %>
	
	<c:if test="${numberoflegs eq fn:toUpperCase('0')}">
<input type="hidden"  id="legNumber" name="legNumber" >
   </c:if>
	<c:if test="${numberoflegs eq fn:toUpperCase('1')}">
	<input type="hidden"  id="legNumber" name="legNumber" value="1">
	</c:if>
  </html:form>

  </body>
</html>

 