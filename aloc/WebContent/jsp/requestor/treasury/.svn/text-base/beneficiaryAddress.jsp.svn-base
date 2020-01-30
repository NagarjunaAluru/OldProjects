<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

        
	<c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}">	
	
		<h2 class="acc_triggerExtra"><s:text name="label.request.obligee" /></h2><hr class="h2-hr">
			<br/>
            	<div class="row lastrow">
				    <div class="span3">
			            <div class="form-row">
							<label><s:text name="label.request.obligee" />&nbsp;<s:text name="label.request.common.nameAddress" />:</label>
							</div>
						</div>
						<div class="span5 left ">
							<div class="form-row">
							   <c:if test="${requestDetails.instrumentTypeId eq '3'}"> 
									<p class="padding40"><s:property value="requestDetails.obligee.addressDtls.name" /></p>
									<s:iterator value="requestDetails.obligee.addressDtls.address">
										<p class="padding40"><s:property /><br />
								   </s:iterator>
									<p class="padding40"><s:property value="requestDetails.obligee.addressDtls.city" />
									<s:property value="requestDetails.obligee.addressDtls.stateProvince" />
									<s:property value="requestDetails.obligee.addressDtls.ZIPPostalCode" /></p>
									<p class="padding40"><s:property value="requestDetails.obligee.addressDtls.country" /></p>
								</c:if>
								 <c:if test="${requestDetails.instrumentTypeId eq '6'}"> 
									<p class="padding40"><s:property value="requestDetails.rider.obligee.addressDtls.name" /></p>
									<s:iterator value="requestDetails.rider.obligee.addressDtls.address">
										<p class="padding40"><s:property /><br />
								   </s:iterator>
									<p class="padding40"><s:property value="requestDetails.rider.obligee.addressDtls.city" />
									<s:property value="requestDetails.rider.obligee.addressDtls.stateProvince" />
									<s:property value="requestDetails.rider.obligee.addressDtls.ZIPPostalCode" /></p>
									<p class="padding40"><s:property value="rrequestDetails.rider.obligee.addressDtls.country" /></p>
								</c:if>
							</div>
						</div>
				</div>
  </c:if> 
    
    <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">			
		<h2 class="acc_triggerExtra"><s:text name="label.request.beneficiary" /></h2><hr class="h2-hr">
		<br/>
            	<div class="row lastrow">
					
				    <div class="span3">
					    <div class="form-row">
						  <label><s:text name="label.request.beneficiary" />&nbsp;<s:text name="label.request.common.nameAddress" /> :</label> 
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
					       <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">	
						    	<p class="padding40"><s:property value="requestDetails.transactionParties.customer.addressDtls.name"/></p>
						    	<s:iterator value="requestDetails.transactionParties.customer.addressDtls.address">
										<p class="padding40"><s:property /><br />
								</s:iterator>
								<p class="padding40"><s:property value="requestDetails.transactionParties.customer.addressDtls.city"/>
								 <s:property value="requestDetails.transactionParties.customer.addressDtls.stateProvince"/> 
								 <s:property value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode"/>
								 </p>
								<p class="padding40"><s:property value="requestDetails.transactionParties.customer.addressDtls.country"/></p>
						 </c:if> 
						 <c:if test="${requestDetails.instrumentTypeId eq '5'}">	
						            <p class="padding40"><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.name"/></p>
						            <s:iterator value="requestDetails.amendment.transactionParties.customer.addressDtls.address">
										<p class="padding40"><s:property /><br />
								    </s:iterator>
								    <p class="padding40"><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.city"/>
								    <s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince"/> 
								    <s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode"/>
								 </p>
								<p class="padding40"><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.country"/></p>
						 </c:if> 
					</div>
				    </div>
			    </div>
     </c:if> 
    
