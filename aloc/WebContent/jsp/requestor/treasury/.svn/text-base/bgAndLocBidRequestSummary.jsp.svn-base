<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="requestSummary">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/><strong>&nbsp;&nbsp;<s:property value="requestDetails.alocRecordId"/></strong></p>
        </div>
		<div class="clear"></div>
        
        <div class="leftBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.applicant"/></label>
                </div>
                <div class="span2 marginZero right">
                	<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name"/><br />
                	<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[0]"/><br />
                	<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[1]"/><br />
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city"/>,
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince"/>
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode"/><br />
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country"/>
                </div>            
            </div>

            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.CountryOfIssuance"/></label>
                </div>
                <div class="span2 marginZero right">
                    <s:property value="requestDetails.instrumentDetails.issuanceCountry"/>
                </div>            
            </div>            

            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.ExpirationDate"/></label>
                </div>
                <div class="span2 marginZero right">
                    <s:date name="requestDetails.instrumentDetails.expiryDt" format="dd MMM yyyy"/>
                </div>            
            </div> 
		</div><!-- leftBox ends here -->
        
        <div class="midBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.beneficiary"/></label>
                </div>
                <div class="span2 marginZero right">
                  <s:property value="requestDetails.transactionParties.customer.addressDtls.name"/><br />
				  <s:property value="requestDetails.transactionParties.customer.addressDtls.address[0]"/><br />
				  <s:property value="requestDetails.transactionParties.customer.addressDtls.address[1]"/><br />
				  <s:property value="requestDetails.transactionParties.customer.addressDtls.city"/>,
				  <s:property value="requestDetails.transactionParties.customer.addressDtls.stateProvince"/>
				  <s:property value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode"/><br />
			      <s:property value="requestDetails.transactionParties.customer.addressDtls.country"/>
                </div>            
            </div>

            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.instrumentCurrency"/></label>
                </div>
                <div class="span2 marginZero right">
                   <s:property value="requestDetails.instrumentDetails.instrumentCurrency"/>
                </div>            
            </div>            

            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.EconomicexpirationDate"/></label>
                </div>
                <div class="span2 marginZero right">
                	<s:date name="requestDetails.instrumentDetails.econoExpiryDt" format="dd MMM yyyy"/>
                </div>            
            </div> 
            
        </div><!-- midBox ends here -->
                
        <div class="rightBoxRS">
        <c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
			
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.triPartyApplicant"/></label>
                </div>
                <div class="span2 marginZero right">
                    <s:property value="requestDetails.transactionParties.triPartyApplicant.name"/><br />
					<s:property value="requestDetails.transactionParties.triPartyApplicant.address[0]"/><br />
					<s:property value="requestDetails.transactionParties.triPartyApplicant.address[1]"/><br />
					<s:property value="requestDetails.transactionParties.triPartyApplicant.city"/>,
					<s:property value="requestDetails.transactionParties.triPartyApplicant.stateProvince"/>
					<s:property value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode"/><br />
					<s:property value="requestDetails.transactionParties.triPartyApplicant.country"/>
                </div>            
            </div>
         </s:if>
		</c:if>
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.instrumentAmount"/></label>
                </div>
                <div class="span2 marginZero right">
                	<s:property value="requestDetails.instrumentDetails.instrumentAmt"/>
                </div>            
            </div>            
            
        </div><!-- rightBox ends here -->
        
        <div class="clear"></div>
    </div><!-- requestSummary ends here -->
