<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>

<s:if test="%{requestDetailsList.size>0}">
		<div class="row">
				<div class="span12">
				<h3><s:text name="label.request.bundledTransactions"/></h3>
				<table class="table table-striped table-bordered sortable" id="taxonomyBundleTrans">
					<thead>
					  <tr>
                      	<th colspan="1"><s:text name="label.request.alocRecNo"/></th>
						<th><s:text name="label.request.bundleID"/></th>
						<th><s:text name="label.request.beneficiaryObligee"/></th>
						<th><s:text name="label.request.applicantPrincipal"/></th>
						<th><s:text name="label.request.requestor"/></th>
						<th><s:text name="label.request.requestDate"/></th>
						<th><s:text name="label.request.instrumentAmount"/></th>
						<th><s:text name="label.request.currency"/></th>
					  </tr>
					</thead>
					<tbody>
					<s:iterator value="requestDetailsList" status="stat">
					  <tr>
						<td><p><s:if test="%{alocRecordId==null}">-</s:if><s:else><s:property value="alocRecordId"/></s:else></p></td>
						<td><p><s:if test="%{bundleDetails==null || bundleDetails.bundleId==null }">-</s:if><s:else><s:property value="bundleDetails.bundleId"/></s:else></p></td>
						<td>
							<s:if test="%{instrumentTypeId == 4}">
								<p><s:property value="beneficiaryDetails.addressDtls.name"/></p>
								<s:iterator value="beneficiaryDetails.addressDtls.address">
									<p><s:property/> </p>
								</s:iterator>
								<p><s:property value="beneficiaryDetails.addressDtls.city"/>
									<s:property value="beneficiaryDetails.addressDtls.stateProvince"/>
									<s:property value="beneficiaryDetails.addressDtls.ZIPPostalCode"/>
								</p>
								<p><s:property value="beneficiaryDetails.addressDtls.country"/></p>
							</s:if>
							<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
								<p><s:property value="transactionParties.customer.addressDtls.name"/></p>
								<s:iterator value="transactionParties.customer.addressDtls.address">
									<p><s:property/> </p>
								</s:iterator>
								<p><s:property value="transactionParties.customer.addressDtls.city"/>
								 <s:property value="transactionParties.customer.addressDtls.stateProvince"/> 
								 <s:property value="transactionParties.customer.addressDtls.ZIPPostalCode"/>
								 </p>
								<p><s:property value="transactionParties.customer.addressDtls.country"/></p>
							</s:if>
						</td>
						<td>
							<s:if test="%{instrumentTypeId == 4}">
								<p><s:property value="applicantDetails.addressDtls.name"/></p>
								<s:iterator value="applicantDetails.addressDtls.address">
									<p><s:property/> </p>
								</s:iterator>
								<p><s:property value="applicantDetails.addressDtls.city"/>
									<s:property value="applicantDetails.addressDtls.stateProvince"/>
									<s:property value="applicantDetails.addressDtls.ZIPPostalCode"/>
								</p>
								<p><s:property value="applicantDetails.addressDtls.country"/></p>
							</s:if>
							<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
								<p><s:property value="transactionParties.tpApplicantDetails.addressDtls.name" /></p>
								<s:iterator	value="transactionParties.tpApplicantDetails.addressDtls.address">
									<p><s:property/> </p>
								</s:iterator>
								<p>
									<s:property	value="transactionParties.tpApplicantDetails.addressDtls.city" />
									<s:property	value="transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
									<s:property	value="transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
								</p>
								<p>	<s:property	value="transactionParties.tpApplicantDetails.addressDtls.country" />
								</p>
							</s:if>
						</td>
						<td>
							<s:property value="requestorLName" />,<br />
                       		<s:property value="requestorFName" />
						</td>

						<td>
							<p><s:if test="%{lastSaveTime==null}">-</s:if><s:else><s:property value="lastSaveTime"/></s:else></p>
						</td>
						
						<td>
						<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
                        		<s:property value="instrumentDetails.instrumentAmt" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 4}">
                        		<s:property value="transactionDetails.docLCAmt" />
                        	</s:if>
                        </td>
                        		
						<td>
							<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
                        		<s:property value="instrumentDetails.instrumentCurrencyId" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 4}">
                        		<s:property value="transactionDetails.docLCCurId" />
                        	</s:if>
						</td>
					  </tr>
					  </s:iterator>
					</tbody>
				  </table>
				</div>
			</div>
	</s:if>
	<s:else>
		<div class="row highlighted">
			<div class="span12">
			    <p><s:text name="label.request.bundleTransactionDesc"/></p>
			</div>
		</div>
	</s:else>
