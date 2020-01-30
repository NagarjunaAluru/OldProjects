<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
		<s:if test="%{#isEditMode==false}" >
			
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" /></p>
						<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.name" /></p>
						<s:iterator value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		
	</s:if>
	
				
	
	
	
	
