<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

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

	<html:form action="${actionId eq 51 ? 'frontoffice':''}/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" id="legNumberID" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
	
		<div class="row">
					<div class="span5">
						<div class="form-row">
            <span class="required">*</span>
            <label>Choose Activity</label>
 			<div id="facilityDiv" class="radio-container">
				<label class="radio">
					<html:radio name="ICFPLegRequestForm" property="dayTwoOperations.facilityIncreaseDecrease.facilityTypeId" styleId="facilityType" value="1"  onclick="javascript:facIncrease();" />
					Facility Increase
				</label>
				<label class="radio">
				<html:radio name="ICFPLegRequestForm" property="dayTwoOperations.facilityIncreaseDecrease.facilityTypeId" styleId="facilityType" value="2" onclick="javascript:facDecrease();"/>
					Facility Decrease
				</label>
				</div>               
       	 </div>  
       	 </div>
       	 </div> 
        
				
		<div>
			<h2 class="span12">Original Transaction Details</h2>
            <div class="clear"></div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Product Type</label>
							<div class="radio-container">
								<html:text name="ICFPLegRequestForm" property="legSummary.productType" styleId="productType" readonly="true"/>
								<html:hidden name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="legTypeId" />
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right ">
						<div class="form-row">
							<span class="required">*</span>
							<label>Facility ID</label>
							<html:text name="ICFPLegRequestForm" property="legSummary.transactionId" styleId="transactionId" maxlength="50"/>
							<span id="transactionIdBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Terms (in months)
								<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
							</label>
							<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="9" styleClass="span1" styleId="termInMonths" />
							<span id="terminMonthsBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Is Transaction Hedged</label>
                            <div id="transHedgedDiv" class="radio-container">
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.isHedgedFlag" styleId="isHedgedFlag"  value="1"/>
									<bean:message key="label.addLeg.yes" />
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" property="legSummary.isHedgedFlag" styleId="isHedgedFlag" value="0"/>
									<bean:message key="label.addLeg.no" />
								</label>
							</div>        
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Non Standard Legal Agreement(s)</label>
                            <div id="originalLegalAgreementDiv" class="radio-container">
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.originalLegalAgreementsFlag" styleId="originalLegalAgreementsFlag"  value="1"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag" styleId="originalLegalAgreementsFlag" value="0"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>                               
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
							<input type="text" id="dayOneCCY" name="legSummary.dayOneCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.dayOneCCY"/>"
							class="span2 dayOneCurrency" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
							
	 						<span id="dayOneCCYBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
				</div>
				
					<div class="row">
						<div class="span5 right">
							<div class="form-row">
								<span class="required">*</span>
								<label>Principal / Facility Amount</label>
								<span  class="help-block invalid error" style="display:none;">Invalid value </span>
            					<input type="text"  name="legSummary.dayOneCCYAmount" maxlength="30" class="span2 currency" id="dayOneCCYAmount" 
								id="dayOneCCYAmount" data-for="dayOneCurrency" data-replace="transactionUsdEquiDiv" data-whichfacility="transaction"
								value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneCCYAmount}" />"/>
            					<span class="req-error" style="display:none;">error</span>
            					<span id="dayOneAmtBar" class="req-error" style="display:none;">error</span>
							</div>
						</div><!-- end of block -->
					
					</div> 
					
				<div class="row" id="transactionUsdEquiDiv">
					<div class="span5 right">
							<div class="form-row">
								<label>USD Equivalent</label>
	                           <html:hidden  name="ICFPLegRequestForm" property="legSummary.dayOneUSDEquivalent" styleId="dayOneUSDEquivalent"/>
								<span id="dayOneUsdBar" class="req-error" style="display:none;">error</span>
								<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent eq '0.00'}">
									<p>-</p>
								</c:if>
								<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent != '0.00'}">
									<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent}</p>
								</c:if>
							</div>
						</div> <!-- end of block -->
				</div>
					
				
				
		</div><!-- end of form form-mod -->
		<jsp:include page="originalLenderBorrower.jsp" />
		
		 <div id="facilityDecreaseDetails" style="display:none;">
		<div class="form-mod">
			<h2 class="span12"><span class="facilityIncreaseDecrease"></span></h2>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
                            <input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							class="span2 facilityCurrency" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Facility <span class="incDec"></span> Amount</label>
							<span class="help-block invalid error" style="display:none;">error</span> 	
							<input type="text"  name="dayTwoOperations.facilityIncreaseDecrease.facilityIncDecAmt" maxlength="30" 
							class="span2 currency"  data-for="facilityCurrency" data-replace="usdEquiFacDiv" id="facilityIncDecAmt"
							data-whichfacility="facIncUsd"
								value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecAmt}" />"/>
							<span class="req-error" style="display:none;">error</span>
							<span id="facilityIncDecAmtBar" class="req-error" style="display:none;">error</span> 	 	
						</div>
					</div> <!-- end of block -->
				</div>
				
				<div class="row">
					<div class="span5 right" id="usdEquiFacDiv">
						<div class="form-row">
							<label>USD Equivalent</label>
                            <html:hidden  name="ICFPLegRequestForm" property="dayTwoOperations.facilityIncreaseDecrease.facilityIncDecUSDEquivalentAmt" styleId="facilityIncDecUSDEquivalentAmt"/>
                            <span id="usdFacValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecUSDEquivalentAmt eq null || 
								sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecUSDEquivalentAmt eq '0.00' || 
								sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecUSDEquivalentAmt eq ''}">
							   <p>-</p>
							</c:if>
							
							<c:if test="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecUSDEquivalentAmt != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.facilityIncDecUSDEquivalentAmt}</p>
							</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Current Facility Amount</label>
							<span class="help-block invalid error" style="display:none;">error</span> 	
							
							<input type="text" name="legSummary.originalCCYAmount" maxlength="30" 
							class="span2 currency" data-for="facilityCurrency"
							data-whichfacility="currencyUsd" id="currencyAmt" data-replace="usdEquiDiv"						
								value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
							<span class="req-error" style="display:none;">error</span> 
							<span id="currencyFacilityAmteBar" class="req-error" style="display:none;">error</span> 
							
						</div>
					</div> <!-- end of block -->
                    
					<div class="span5 right " id="AmendedDiv">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Amended Facility Amount</label>
							<span class="help-block invalid error" style="display:none;">error</span> 	
							<input type="text"  name="dayTwoOperations.facilityIncreaseDecrease.amendedFacilityAmt" maxlength="30" readonly="readonly"
							class="span2" id="amendedFacilityAmt" 
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedFacilityAmt}" />"/>
							
							<span class="req-error" style="display:none;">error</span> 
							<span id="amendedFacilityAmtBar" class="req-error" style="display:none;">error</span> 
						</div>
					</div> <!-- end of block -->
            </div>
			<div class="row">
					<div class="span5" id="usdEquiDiv">
						<div class="form-row">
							<label>USD Equivalent</label>
                            <html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="currencyUSDEquivalentAmt"/>
                            <span id="usdValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00' || 
							sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq ''}">
							   <p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
							</c:if>
						</div>
					</div> <!-- end of block -->
                    
					<div class="span5 right"  id="usdEquiAmendDiv">
						<div class="form-row">
							<label>USD Equivalent</label>
							<html:hidden  name="ICFPLegRequestForm" property="dayTwoOperations.facilityIncreaseDecrease.amendedUSDEquivalentAmt" styleId="amendedUSDEquivalentAmt"/>
							<span id="usdAmendValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedUSDEquivalentAmt eq '0.00' ||
							  sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedUSDEquivalentAmt eq null ||
							  sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedUSDEquivalentAmt eq ''}">
							   <p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedUSDEquivalentAmt != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.facilityIncreaseDecrease.map.amendedUSDEquivalentAmt}</p>
							</c:if>
						</div>
					</div> <!-- end of block -->
            </div>            
			
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
					<div class="span5 right">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Original Legal Agreement Attached</label>
								<div id="originalAgmtDiv" class="radio-container ">
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="false"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div> 
						</div>
					</div> <!-- end of block -->             				
		</div><!-- end of form form-mod -->
		</div>
		
        
		<div class="form-mod" id="derivativesTableDiv">
			<jsp:include page="rcaDerivativesCommon.jsp" />	
        </div>
       </div>
		
		
		<jsp:include page="termsAndConditions.jsp" />
		<jsp:include page="otherConsiderations.jsp" />
                
				<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->
		
		<c:choose>
		<c:when test="${actionId eq 51}">
			<jsp:include page="/jsp/day2/common/saveButton.jsp">
				<jsp:param name="eventTypeId" value="5"/>
			</jsp:include>
		</c:when>
		<c:otherwise>

		<div class="span12 right btn-container" style="margin-left: -20px;">
			<c:if test="${sessionScope.section eq 'myTasks'}">
				<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateAmendIncreaseDecrease('?command=saveAndReturnToDeal');">
           		<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
			</c:if>
			<c:if test="${sessionScope.section eq 'myRequests'}">
				<c:choose>
						<c:when test="${empty deal.WFStage}">
						<c:if test="${deal.action eq 'Draft'  || deal.action eq 'DRAFT' || empty deal.action}"> 
							<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateAmendIncreaseDecrease('?command=saveAndReturnToDeal');">
           					<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
						</c:if>
						</c:when>
				</c:choose>
			</c:if>
			
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>            
		</div>
		
		</c:otherwise>       
	</c:choose>
		
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
		
		<input type="hidden" id="actionId" value="${actionId}">
</html:form>

