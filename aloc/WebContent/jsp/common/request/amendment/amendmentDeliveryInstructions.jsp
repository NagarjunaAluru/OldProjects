<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${param.pageSection == 'Current'}">
	<div class="acc_container">
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<s:label key="label.request.deliverType" />
				</div>
			</div>
			<div class="span5 left">
				<p>
					<s:if test="%{requestDetails.amendment.deliveryInstructions.deliveryType}">
						<s:text name="label.request.inPersonPickUp" />
					</s:if>
					<s:else>
						<s:text name="label.request.physicalDelivery" />
					</s:else>
					
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label><s:text  name="label.request.sendElectronicCopyToMyself"/>:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:if test="%{requestDetails.amendment.deliveryInstructions.ecopyMyself}">
						<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
						<s:text name="label.request.common.no" />
					</s:else>
				
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label><s:text  name="label.request.sendElectronicCopyToOtherGERecipient"/>:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:if test="%{requestDetails.amendment.deliveryInstructions.ecopyOtherGEPerson}">
							<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
							<s:text name="label.request.common.no" />
					</s:else>
					
				</p>
			</div>
			<!-- end of block -->
		</div>
		<c:if
			test="${requestDetails.amendment.deliveryInstructions.ecopyOtherGEPerson}">
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<s:label key="label.request.recipient" />
					</div>
				</div>
				<div class="span3 left">
					<s:if test="%{requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId != null && requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId != ''}">
						<p>
						<s:property	value="requestDetails.amendment.deliveryInstructions.recipient.recipientLastName" />
						, <s:property value="requestDetails.amendment.deliveryInstructions.recipient.recipientFirstName" />
						- <s:property value="requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId" />
					</p>
					</s:if>
				</div>
				<!-- end of block -->
			</div>
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<s:label key="label.request.geRecipientEmail" />
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.amendment.deliveryInstructions.recipient.recipientEmail" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</c:if>
		
		<s:if test="%{requestDetails.amendment.deliveryInstructions.deliveryType == 'false' && requestDetails.amendment.deliveryInstructions.usePreviousAddress !=null }"> 
				<div class="row smallrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label> 
						</div>	
					</div>
					<div class="span3 left">
						<div class="form-row">
							<p>
								<s:if test="%{requestDetails.amendment.deliveryInstructions.usePreviousAddress == 'TransactionParties'}">
									<s:text name="label.request.transactionParties"/>
								</s:if>
								<s:if test="%{requestDetails.amendment.deliveryInstructions.usePreviousAddress == 'CustomerBeneficiary'}">
									<s:text name="label.request.customerBeneficiary"/>
								</s:if>
							</p>
						</div>
					</div>
				</div>
				</s:if>
		
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label><s:text  name="label.request.companyName"/>:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.amendment.deliveryInstructions.companyName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Recipient's first name:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.amendment.deliveryInstructions.firstName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Recipient's last name:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.amendment.deliveryInstructions.lastName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Title:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<c:if test="${empty requestDetails.amendment.deliveryInstructions.title}">-</c:if>
                	<c:if test="${not empty requestDetails.amendment.deliveryInstructions.title}">
                		<s:property value="requestDetails.amendment.deliveryInstructions.title"/>
                	</c:if>
				</p>
			</div>
			<!-- end of block -->
		</div>
		<s:if test="%{requestDetails.amendment.deliveryInstructions.deliveryType == 'false' }"> 
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<label>Address:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.amendment.deliveryInstructions.address1" />
					</p>
					<p>
						<s:property
							value="requestDetails.amendment.deliveryInstructions.address2" />
					</p>
					<p>
						<s:property
							value="requestDetails.amendment.deliveryInstructions.city" />
						<s:property
							value="requestDetails.amendment.deliveryInstructions.stateProvince" />
						<s:property value="requestDetails.amendment.deliveryInstructions.ZIPPostalcode" />
					</p>
					<p>
						<s:property
							value="requestDetails.amendment.deliveryInstructions.country" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</s:if>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Phone number:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.amendment.deliveryInstructions.phoneNo" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Is the delivery or pick up by:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.amendment.deliveryInstructions.deliveryDesignationFlag" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Special instructions:</label>
				</div>
			</div>
			<div class="span3 left" >
				<p style="word-wrap: break-word;">
					<s:property
						value="requestDetails.amendment.deliveryInstructions.specialInstructions" />
				</p>
			</div>
			<!-- end of block -->
		</div>
	</div>
</c:if>
<c:if test="${param.pageSection == 'Previous'}">
	<div class="acc_container">
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<s:label key="label.request.deliverType" />
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.deliveryType}">
						<s:text name="label.request.inPersonPickUp" />
					</s:if>
					<s:else>
						<s:text name="label.request.physicalDelivery" />
					</s:else>
					
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<s:label key="label.request.sendElectronicCopyToMyself" />
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.ecopyMyself}">
						<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
						<s:text name="label.request.common.no" />
					</s:else>
					
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<s:label key="label.request.sendElectronicCopyToOtherGERecipient" />
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.ecopyOtherGEPerson}">
							<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
							<s:text name="label.request.common.no" />
					</s:else>
				</p>
			</div>
			<!-- end of block -->
		</div>
		<c:if
			test="${requestDetails.previousAmendment.deliveryInstructions.ecopyOtherGEPerson}">
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<s:label key="label.request.recipient" />
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.previousAmendment.deliveryInstructions.recipient.recipientLastName" />
						,
						<s:property
							value="requestDetails.previousAmendment.deliveryInstructions.recipient.recipientFirstName" />
						-
						<s:property
							value="requestDetails.previousAmendment.deliveryInstructions.recipient.recipientSsoId" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<s:label key="label.request.geRecipientEmail" />
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.previousAmendment.deliveryInstructions.recipient.recipientEmail" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</c:if>
		<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.deliveryType == 'false' && requestDetails.previousAmendment.deliveryInstructions.usePreviousAddress !=null }"> 
				<div class="row smallrow">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label> 
						</div>	
					</div>
					<div class="span3 left">
						<div class="form-row">
							<p>
								<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.usePreviousAddress == 'TransactionParties'}">
									<s:text name="label.request.transactionParties"/>
								</s:if>
								<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.usePreviousAddress == 'CustomerBeneficiary'}">
									<s:text name="label.request.customerBeneficiary"/>
								</s:if>
							</p>
						</div>
					</div>
				</div>
				</s:if>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<s:label key="label.request.companyName" />
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.companyName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Recipient's first name:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.firstName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Recipient's last name:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.lastName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Title:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<c:if test="${empty requestDetails.previousAmendment.deliveryInstructions.title}">-</c:if>
                	<c:if test="${not empty requestDetails.previousAmendment.deliveryInstructions.title}">
                		<s:property value="requestDetails.previousAmendment.deliveryInstructions.title"/>
                	</c:if>
					
				</p>
			</div>
			<!-- end of block -->
		</div>
		<s:if test="%{requestDetails.previousAmendment.deliveryInstructions.deliveryType == 'false' }"> 
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Address:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.address1" />
				</p>
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.address2" />
				</p>
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.city" />
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.stateProvince" />
					<s:property value="requestDetails.previousAmendment.deliveryInstructions.ZIPPostalcode" />
				</p>
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.country" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		</s:if>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Phone number:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.phoneNo" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Is the delivery or pick up by:</label>
				</div>
			</div>
			<div class="span3 left">
				<p>
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.deliveryDesignationFlag" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row smallrow">
			<div class="span3">
				<div class="form-row">
					<label>Special instructions:</label>
				</div>
			</div>
			<div class="span3 left">
				<p style="word-wrap: break-word;">
					<s:property
						value="requestDetails.previousAmendment.deliveryInstructions.specialInstructions" />
				</p>
			</div>
			<!-- end of block -->
		</div>
	</div>
</c:if>

