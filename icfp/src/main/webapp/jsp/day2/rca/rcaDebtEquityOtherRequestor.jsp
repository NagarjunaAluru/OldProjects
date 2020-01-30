<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>

<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1"; 
} else {
	legLenforJS ="0";
}

%>



<script src="<%=servletContextUrl%>/js/rcaRequestor.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

	<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" id="legNumberID" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		
		<jsp:include page="originalTransactionOptional.jsp">
			<jsp:param name="productType" value="${param.productType}"/>
		</jsp:include>
		
		<jsp:include page="originalLenderBorrower.jsp" />
                
		<div class="form-mod">
			<h2 class="span12">Description</h2>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
							<label>Currency</label>
                            <span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select currency </span>
							<span  class="help-block error" id="originalCCYInvalid" style="display:none;">Invalid currency </span>
							<input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							class="span2 originalCCY" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
							
 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block --> 
				
				<div class="span5 right">
						<div class="form-row">
							<label>Amount</label>
                            <span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Prinicipal Amount</span>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<input type="text"  name="legSummary.originalCCYAmount" maxlength="30" class="span2 currency" id="originalCCYAmount" 
								data-for="originalCCY" data-replace="usdEquiDiv" 
								value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
								
							<span class="req-error" style="display:none;">error</span> 
							<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span> 
							</div>
					</div> <!-- end of block -->
			</div>
			
			<div class="row">
				<div class="span5 right"  id="usdEquiDiv">
					<div class="form-row">
						<label>USD Equivalent</label>
						<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
						<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
							   <p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
							</c:if>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<c:if test="${param.productType eq '2'}">
				<div class="row">
					<div id="eBoardEligibleDiv" class="span5 right">
						<div class="form-row">
							<p><b>eBoardroom eligible</b></p>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag == null}"> 
								<p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag != null && sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag eq false}">
								<p>No</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag != null && sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag eq true}"> 
								<p>Yes</p>
							</c:if>
						</div>
					</div><!-- end of block -->
				</div>
				<html:hidden  name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="productType"/>
			</c:if>
				
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<div class="autosize-container1">
                           		<label>&nbsp;</label>
                            	<div class="char-count" style="margin-left:-10px;">1000</div>
                            	<html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="dayTwoOperations.correction.debtEquityOtherComments"  styleId="debtEquityOtherComments" tabindex="3" rows="1"  onblur="scriptInjection(this);"></html:textarea>
                            	<span id="commentsBar" class="req-error" style="display:none;">error</span>
                        	</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<c:if test="${param.productType ne '2'}">
					<div class="row">
						<div class="span5">
							<div class="form-row">
	
	                            <span class="required">*</span>
								<label>Request Derivatives</label>
								<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Request Derivatives</span>
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
					</div>
				</c:if>				
		</div><!-- end of form form-mod -->
        
		<jsp:include page="rcaDerivativesCommon.jsp" />	

		<c:if test="${param.productType ne '2'}">
			<jsp:include page="termsAndConditions.jsp" />
		</c:if>
		
		<jsp:include page="otherConsiderations.jsp" />
        
                
				 <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->
        

		<div class="span12 right btn-container" style="margin-left: -20px;">
			<c:if test="${sessionScope.section eq 'myTasks'}">
				<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateDebtEquity('?command=saveAndReturnToDeal','${param.productType}');">
           		<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
			</c:if>
			<c:if test="${sessionScope.section eq 'myRequests'}">
				<c:choose>
						<c:when test="${empty deal.WFStage}">
						<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT' || empty deal.action}"> 
							<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateDebtEquity('?command=saveAndReturnToDeal','${param.productType}');">
            				<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
						</c:if>
						</c:when>
				</c:choose>
			</c:if>
			
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>            
		</div>
		
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
		
		<input type="hidden" id="actionId" value="${actionId}">
</html:form>

