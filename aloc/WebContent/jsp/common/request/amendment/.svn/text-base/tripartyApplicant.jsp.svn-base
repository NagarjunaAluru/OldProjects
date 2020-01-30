<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==false}" >
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Tri-Party Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.name" /></p>
						<s:iterator	value="requestDetails.amendment.transactionParties.triPartyApplicant.address[0]">
						<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.city" /> 
						<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" /> 
						<s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Tri-Party Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.name" /></p>
						<s:iterator	value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.address">
						<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.city" /> 
						<s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.stateProvince" /> 
						<s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		
	</s:if>
