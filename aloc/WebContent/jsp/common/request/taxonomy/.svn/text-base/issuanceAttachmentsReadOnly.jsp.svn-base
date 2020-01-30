<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/requestor/issuance.js" type="text/javascript"></script>
<c:if
	test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
	<div class="row">		
		<div class="span2b">
			<div class="form-row">
				<label><s:text name="label.request.suretyName" /></label>
			</div>
		</div>
		<div class="span5 left">
			<p class="padding40"> <s:property value="requestDetails.feesDetails.surityName"/> </p> 
		</div>		
	</div>
</c:if>
<table class="table table-striped table-bordered sortable attachment" id="attachmentsReadOnlyTableId">
	<thead>
		<tr>
			<th colspan="1"><s:text name="label.request.actions" /></th>
			<th colspan="1"><s:text name="label.request.documentType" /></th>
			<c:if
				test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '5')}">
				<th colspan="1"><s:text name="label.amendment.bankRefNo" /><span
					class="ttip info"
					data-original-title="Enter the reference number which the bank will use on an ongoing basis to identify this undertaking."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '3')}">
				<th colspan="1"><s:text name="label.request.suretyBond" /><br />
					<s:text name="label.request.RefNo" />&nbsp;<span class="ttip info"
					data-original-title="Enter the reference number which the broker will use on an ongoing basis to identify this undertaking."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '4')}">
				<th colspan="1"><s:text name="label.request.cefNo" /><br /> <s:text
						name="label.request.No" /><span class="ttip info"
					data-original-title="Enter the reference number which the bank will use on an ongoing basis to identify this undertaking."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '6')}">
				<th colspan="1"><s:text name="label.request.suretyRider" /><br />
					<s:text name="label.request.RefNo" /><span class="ttip info"
					data-original-title="Enter the reference number which the broker will use on an ongoing basis to identify this undertaking."></span></th>
			</c:if>
			<c:if
				test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2')}">
				<th colspan="1"><s:text name="label.request.issuanceDate" /><span
					class="ttip info"
					data-original-title="Enter actual date of issuance, not the date of the upload to the system."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '3')}">
				<th colspan="1"><s:text
						name="label.request.suretyBondIssuanceDate" />&nbsp;<span
					class="ttip info"
					data-original-title="Enter actual date of issuance, not the date of the upload to the system."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '4')}">
				<th colspan="1"><s:text name="label.request.confirmationDate" /><span
					class="ttip info"
					data-original-title="Enter actual date the bank is confirming the letter of credit, not the date of the upload to the system."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '5')}">
				<th colspan="1"><s:text
						name="label.request.amendmentIssuanceDate" /><span
					class="ttip info"
					data-original-title="Enter the actual date of the amendment issued"></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '6')}">
				<th colspan="1"><s:text name="label.request.suretyRider" /><br />
					<s:text name="label.request.issuanceDate" /><span
					class="ttip info"
					data-original-title="Enter the actual date of the rider issued"></span></th>
			</c:if>
			<th colspan="1"><s:text name="label.request.issuanceDescription" /></th>
			<th colspan="1"><s:text name="label.request.document" /></th>
		</tr>
	</thead>
	<tbody>
		<s:if test="%{requestDetails.issunaceDocTypes != null && requestDetails.issunaceDocTypes.size>0}">
			<s:iterator value="requestDetails.issunaceDocTypes" status="issuanceDocStatus">
			<c:if test="${issuerDocTypeId eq '2'}">
			<s:set var="atmtIndex" value="1"></s:set>
					<tr>
						<td>
							<div class="alocDeleteAttachmentContainer">
								<div class="alocDeleteAttachment">
									<p style="padding: 10px 0 0 10px;">
										<s:text name="label.request.clear" />
									</p>
								</div>
							</div>
						</td>
						<td><s:property value="issuerDocTypeName" /></td>
						<td><s:textfield cssClass="span1a"
								name="referenceNum"
								readonly="true" /></td>
						<td width="70"><s:textfield cssClass="span1a"
										name="issueDt"
										readonly="true" />
						<td><s:textarea style="resize: none; overflow-y: hidden;"
								cssClass="autosize1 messageinput" readonly="true"
								name="issuanceDesc" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="6">
							<s:textarea cssClass="autosize10K messageinput" theme="aloc" style="width: 900px;" readonly="true" name="issuanceDocument" cols="300" rows="20" />
						</td>
					</tr>
				</c:if>
			</s:iterator>
		</s:if>
		<s:if test="%{requestDetailsBO.attachmentBOList != null && requestDetailsBO.attachmentBOList.size>0}">
		<s:set var="atmtIndex" value="0"></s:set>
			<s:iterator value="requestDetailsBO.attachmentBOList" status="atmtBOItrStatus">
			<s:if test="%{issuanceDocType != null && issuanceDocType != ''}">					
				<c:if test="${model.attachmentTypeId eq '3'}">
					<tr>
						<td>
							<div class="alocDeleteAttachmentContainer">
								<div class="alocDeleteAttachment">
									<p style="padding: 10px 0 0 10px;">
										<s:text name="label.request.clear" />
									</p>
								</div>
							</div>
						</td>
						<td><c:if
								test="${model.issuanceDocTypeId eq '1'}">
								<s:label>
									<s:text name="label.request.benificiaryIssuance" />
								</s:label>
							</c:if> <c:if
								test="${model.issuanceDocTypeId eq '2'}">
								<s:label>
									<s:text name="label.request.bankIssuance" />
								</s:label>
							</c:if> <c:if
								test="${model.issuanceDocTypeId eq '3'}">
								<s:label>
									<s:text name="label.request.suretyBond" />
								</s:label>
							</c:if></td>
						<td><s:textfield cssClass="span2a"
								name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].model.issuanceBankRefNo"
								readonly="true" /></td>
						<td  width="70"><s:property value="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].model.issuanceDate" />
										<s:textfield cssClass="span1a"
										name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].model.issuanceDate" readonly="true"/>
						<td><s:textarea style="resize: none; overflow-y: hidden;"
								cssClass="autosize1 messageinput" readonly="true"
								name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].model.issuanceDesc" />
								<s:property value="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].model.issuanceDate"/> 
						</td>
						<td>
							<div class="alocAttachmentContainer">
								<div class="alocAttachment">
									<s:if test="%{model.geFileId!= null && model.geFileId !=0}">
										<s:url id="fileDownload" action="download.action"
											namespace="/int/atmt">
											<s:param name="geLibFileId" value="model.geFileId" />
											<s:param name="typeId" value="3" />
											<s:param name="index" value="%{#atmtBOItrStatus.index}" />
										</s:url>
										<s:a href="%{fileDownload}">
											<s:property value="model.attachmentOriginalName" />
										</s:a>
									</s:if>
								</div>
							</div>
						</td>
					</tr>
					<tr class="copydoc<s:property value="%{#atmtIndex}"/>">
						<td colspan="6"><s:if test="#atmtIndex == 1">
								<c:if
									test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
									<s:label>
										<s:text name="label.request.suretyBond" />
									</s:label>
								</c:if>
								<c:if
									test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
									<s:label>
										<s:text name="label.request.benificiaryIssuance" />
									</s:label>
								</c:if>
							</s:if> <s:if test="#atmtIndex == 0">
								<s:label>
									<s:text name="label.request.bankIssuance" />
								</s:label>
							</s:if> <s:textarea cssClass="autosize10K messageinput" readonly="true"
								cssStyle="width: 850px;"
								name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocument"
								cols="300" rows="20" /></td>
					</tr>
					<s:set var="atmtIndex" value="1"></s:set>
				</c:if>
				</s:if>
			</s:iterator>
		</s:if>
		<s:if test="%{requestDetails.issunaceDocTypes != null && requestDetails.issunaceDocTypes.size>0}">
			<s:iterator value="requestDetails.issunaceDocTypes" status="issuanceDocStatus">
			<c:if test="${issuerDocTypeId ne '2'}">
			<s:set var="atmtIndex" value="1"></s:set>
					<tr>
						<td>
							<div class="alocDeleteAttachmentContainer">
								<div class="alocDeleteAttachment">
									<p style="padding: 10px 0 0 10px;">
										<s:text name="label.request.clear" />
									</p>
								</div>
							</div>
						</td>
						<td><s:property value="issuerDocTypeName" /></td>
						<td><s:textfield cssClass="span1a"
								name="referenceNum"
								readonly="true" /></td>
						<td width="70"><s:textfield cssClass="span1a"
										name="issueDt"
										readonly="true" />
						<td><s:textarea style="resize: none; overflow-y: hidden;"
								cssClass="autosize1 messageinput" readonly="true"
								name="issuanceDesc" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="6">
							<s:textarea cssClass="autosize10K messageinput" theme="aloc" style="width: 900px;" readonly="true" name="issuanceDocument" cols="300" rows="20" />
						</td>
					</tr>
				</c:if>
			</s:iterator>
		</s:if>
	</tbody>
</table>
