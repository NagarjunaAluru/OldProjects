<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

        
	<c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
		<c:if test="${requestDetails.siteTypeName eq 'Industrial Business'}">
		<h2 class="acc_triggerExtra"><s:text name="label.request.applicant" /></h2><hr class="h2-hr">
		<br/>
        <div class="row lastrow">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.applicant" />&nbsp;<s:text name="label.request.nameAndAddress" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
					 <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2'}">	
						 <s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" /><br />
							<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
								<s:property /><br />
						   </s:iterator>
		                   <s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
							<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
							<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /><br />
							<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
						</c:if>
						<c:if test="${requestDetails.instrumentTypeId eq '5'}">
						
						     <s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" /><br />
							 <s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address">
								<s:property /><br />
						    </s:iterator>
		                    <s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" />
							<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
							<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /><br />
							<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" />
						</c:if>
					</p>
				</div>
			</div>
		</div>
       </c:if>
        <c:if test="${requestDetails.siteTypeName eq 'Financial Business'}"> 
           <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2'}">	
           	<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
        	<h2 class="acc_triggerExtra"><s:text name="label.request.triPartyApplicant" /></h2><hr class="h2-hr">
        	<br/>	
            <div class="row lastrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.triPartyApplicant" />&nbsp;<s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.triPartyApplicant.name" /><br />
								<s:iterator value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property /><br />
								</s:iterator>
								<s:property value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" /><br />
								<s:property value="requestDetails.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
			</s:if>
			<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || !requestDetails.transactionParties.triPartyRequestFlag}">
			      <h2 class="acc_triggerExtra"><s:text name="label.request.applicant" /></h2><hr class="h2-hr">
				<br/>
		        <div class="row lastrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" /><br />
								<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
									<s:property /><br />
								</s:iterator>
								<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
								<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
								<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /><br />
								<s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
							</p>
						</div>
					</div>
		      </div>
		     	</s:if>
		   </c:if> 
		     <c:if test="${requestDetails.instrumentTypeId eq '5'}">	
           	<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
        	<h2 class="acc_triggerExtra"><s:text name="label.request.triPartyApplicant" /></h2><hr class="h2-hr">
        	<br/>	
            <div class="row lastrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.triPartyApplicant" />&nbsp;<s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.name" /> <br />
								<s:iterator value="requestDetails.amendment.transactionParties.triPartyApplicant.address">
									<s:property /><br />
								</s:iterator>
								<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.city" />
								<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" />
								<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" /><br />
								<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
			</s:if>
			<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || !requestDetails.transactionParties.triPartyRequestFlag}">
			      <h2 class="acc_triggerExtra"><s:text name="label.request.applicant" /></h2><hr class="h2-hr">
				<br/>
		        <div class="row lastrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.applicant" />&nbsp;<s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" /><br />
								<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address">
									<s:property /><br />
								</s:iterator>
								<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" />
								<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
								<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /><br />
								<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" />
							</p>
						</div>
					</div>
		      </div>
		</s:if>
		   </c:if>  	 	
        </c:if>  
    </c:if>
    
    <c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}">
    	<h2 class="acc_triggerExtra"><s:text name="label.request.principal" /></h2><hr class="h2-hr">
		<br/>
	    <div class="row lastrow">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.principal" />&nbsp;<s:text name="label.request.common.nameAddress" />: </label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
				   <c:if test="${requestDetails.instrumentTypeId eq '3'}">
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.name" /></p>
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.address[0]" /></p>
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.address[1]" /></p>
					<p class="padding40">
						<s:property value="requestDetails.principal.addressDtls.city" />
						<s:property value="requestDetails.principal.addressDtls.city" />
						<s:property value="requestDetails.principal.addressDtls.ZIPPostalCode" />
					</p>
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.country" /></p>
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.countryOfInc" /></p>
					<p class="padding40"><s:property value="requestDetails.principal.addressDtls.stateOfInc" /></p>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '6'}">
				    <p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.name" /></p>
					<p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.address[0]" /></p>
					<p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.address[1]" /></p>
					<p class="padding40">
						<s:property value="requestDetails.rider.principal.addressDtls.city" />
						<s:property value="requestDetails.rider.principal.addressDtls.city" />
						<s:property value="requestDetails.rider.principal.addressDtls.ZIPPostalCode" />
					</p>
					<p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.country" /></p>
					<p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.countryOfInc" /></p>
					<p class="padding40"><s:property value="requestDetails.rider.principal.addressDtls.stateOfInc" /></p>
				</c:if>
					
				</div>
			</div>
		</div>
	</c:if>
