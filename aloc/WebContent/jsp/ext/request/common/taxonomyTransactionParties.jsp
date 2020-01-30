<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

	<c:if test="${empty param.modelId or (not empty param.modelId and param.modelId eq '')}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<p>
								<s:text name="label.request.selectedSite" />
							</p>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.siteName" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
		
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<label><s:text name="label.request.instrumentPurpose" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurpose" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<label><s:text name="label.request.otherFees.other" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurposeOther" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
	
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span22">
					<div class="form-row">
						<p>
							<s:text name="label.request.isTriPartyRequest" />
						</p>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span22">
					<div class="form-row">
						<p>
							<s:text name="label.request.privateLabel" />
						</p>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.privateLabelFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
		<h3>
			<s:text name="label.request.triPartyApplicant" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span12">
				<div class="row" style="margin-bottom: 0px;">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.name" />
								<br />
								<s:iterator value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" />
								<br />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
	
			</div>
		</div>
		</s:if>
		</c:if>
	
		<h3>
			<s:text name="label.request.applicant" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityNameC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.leName" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityGOLDIdC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.leGoldId" />
					</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.businessContactPerson" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" />
						,
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" />
						<br />
						<s:iterator	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
	
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
						<br />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.geApplicantReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="geRefSize"	value="requestDetails.transactionParties.tpApplicantDetails.refDetails.size" />
		<s:if test="#geRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text name="label.request.geApplicantReference" />
											<s:property value="#stat.count" />:</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		
					<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.buc" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.buUnit"/>
						</p>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.adn" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.accDist" />
						</p>
					</div>
				</div>
			</div>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoNo" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property	value="requestDetails.transactionParties.tpApplicantDetails.csoNo" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoDate" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property	value="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt" />
								</p>
							</div>
						</div>
					</div>
					<div class="row" style="margin-bottom: 0px;">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoCretified" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">Yes</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		<h3>
			<s:text name="label.request.customer" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" />
					</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.name" />
						<br />
						<s:iterator	value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.city" />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.stateProvince" />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" />
						<br />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.customerReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.customer.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="customerRefSize" value="requestDetails.transactionParties.customer.refDetails.size" />
		<s:if test="#customerRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.customer.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text name="label.request.customerReference" />
											<s:property value="#stat.count" />:</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
			<s:if test="%{requestDetails.transactionParties.requiresEdits}">
				<div class="row">
					<div class="span44">
						<div class="form-row">
							<label> <s:text name="label.request.Sendbacknotes" /> :
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property	value="requestDetails.transactionParties.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</s:if>
		</c:if>
