<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="apmQuickView">
		<div class="leftColNB">
			<h3><s:text name="label.request.requestSummary" /></h3>
                           <div class="left-col-nb"><s:text name="label.request.instrumentCurrency" /></div>
                           <div class="right-col-nb"><s:if test="%{requestDetails.instrumentDetails.instrumentCurrency!=null &&
                           requestDetails.instrumentDetails.instrumentCurrency!=''}">
                           <s:property value="requestDetails.instrumentDetails.instrumentCurrency" /></s:if><s:else> - </s:else></div>
                           <div class="clear"></div>
                           <div class="left-col-nb"><s:text name="label.request.instrumentAmount"/></div>
                           <div class="right-col-nb"><s:if test="%{requestDetails.instrumentDetails.instrumentAmt!=null
                           && requestDetails.instrumentDetails.instrumentAmt!=''}">
                           <s:property value="requestDetails.instrumentDetails.instrumentAmt" /></s:if><s:else> - </s:else></div>
                           <div class="clear"></div>  
                           <div class="left-col-nb"><s:text name="label.request.ExpirationDate"/></div>
                           <div class="right-col-nb"><s:if test="%{requestDetails.instrumentDetails.expiryDt!=null
                           && requestDetails.instrumentDetails.expiryDt!=''}">
                           <s:property value="requestDetails.instrumentDetails.expiryDt" /></s:if><s:else> - </s:else></div>
                           <div class="clear"></div>                                                               
                       	<p>&nbsp;</p>
                           
             <h3><s:text name="label.request.winner"/> - <s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName" /></h3>
			             <div class="left-col-nb"><s:text name="label.amendment.bankRefNo"/></div>
			             <div class="right-col-nb"><s:if test="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber!=null
			             && requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber != ''}">
			             <s:property value="requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber" /></s:if><s:else> - </s:else></div>
			             <div class="clear"></div>
			             <div class="left-col-nb"><s:text name="label.request.issuingBankReference"/></div>
			             <!-- Todo: Need to map once fields place holder confirmed -->
			             <div class="right-col-nb"> - </div>
			             <div class="clear"></div>  
			             <div class="left-col-nb"><s:text name="label.request.issuingBankReferenceNumber"/></div>
			             <div class="right-col-nb"> - </div>
			             <div class="clear"></div>                                                               
			         	<p>&nbsp;</p>
		</div>

		<div class="rightColNB">
			<h3><s:text name="label.request.bglocSectionName.1" /></h3>
                           <div class="left-col-nb"> <s:text name="label.request.applicant" /> </div>
                           <div class="right-col-nb">&nbsp; <s:property value="requestDetails.applicantDetails.addressDtls.name" /><br>
                           <s:iterator value="requestDetails.applicantDetails.addressDtls.address">
							&nbsp; <s:property/><br>
						   </s:iterator><br>
						   &nbsp; <s:property value="requestDetails.applicantDetails.addressDtls.city" /> 
						   &nbsp; <s:property value="requestDetails.applicantDetails.addressDtls.stateProvince" /> 
						   &nbsp; <s:property value="requestDetails.applicantDetails.addressDtls.ZIPPostalCode"/><br>
						   &nbsp; <s:property value="requestDetails.applicantDetails.addressDtls.country" /></div>
                           <div class="clear"></div>
                           <div class="left-col-nb"> <s:text name="label.apm.triPartyApplicant" /> </div>
                           <div class="right-col-nb">&nbsp; <s:property value="requestDetails.transactionParties.triPartyApplicant.name" /><br>
                           <s:iterator value="requestDetails.transactionParties.triPartyApplicant.address">
							&nbsp; <s:property /><br>
						   </s:iterator><br>
						   &nbsp; <s:property value="requestDetails.transactionParties.triPartyApplicant.city" /> 
						   &nbsp; <s:property value="requestDetails.transactionParties.triPartyApplicant.stateProvince" /> 
						   &nbsp; <s:property value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" /><br>
						   &nbsp; <s:property value="requestDetails.transactionParties.triPartyApplicant.country" /></div>
                           <div class="clear"></div>  
                           <div class="left-col-nb"> <s:text name="label.request.customerOnly" /> </div>
                           <div class="right-col-nb">&nbsp; <s:property value="requestDetails.transactionParties.customer.addressDtls.name"/><br>
                           <s:iterator value="requestDetails.transactionParties.customer.addressDtls.address">
							&nbsp; <s:property/><br>
						   </s:iterator><br>
							&nbsp; <s:property value="requestDetails.transactionParties.customer.addressDtls.city"/>
							&nbsp; <s:property value="requestDetails.transactionParties.customer.addressDtls.stateProvince"/> 
							&nbsp; <s:property value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode"/><br>
							&nbsp; <s:property value="requestDetails.transactionParties.customer.addressDtls.country"/></div>
                           <div class="clear"></div>                                                               
                       	   <p>&nbsp;</p>
   		</div>
       <div class="clear"></div>
     </div>
