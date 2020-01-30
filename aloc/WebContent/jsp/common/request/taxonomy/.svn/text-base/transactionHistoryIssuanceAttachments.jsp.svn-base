<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/date.js"></script>
<script src="${pageContext.request.contextPath}/js/requestor/issuance.js" type="text/javascript"></script>
<div style="color: red;">
	<s:fielderror fieldName="requestDetailsBO.attachmentBOList.attachments" />		
</div>
<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
	<div class="row">
		<div class="span12">		
				<s:select headerKey="" key="label.request.suretyName" list="requestDetails.feesDetails.suretyNames" headerValue="Select..."
					listKey="suretyId" listValue="suretyName" id="suretyFeeNameId" name="requestDetails.feesDetails.surityId" theme="aloc"/>
				<s:hidden name="requestDetails.feesDetails.surityName" id="suretyFeeName" value="%{requestDetails.feesDetails.surityName}"/>			
		</div>
	</div>
</c:if>	
<table class="table table-striped table-bordered sortable attachment" id="attachmentsTableId">
	<thead>
		<tr>
			<th colspan="1"><s:text name="label.request.actions" /></th>
			<th colspan="1"><s:text name="label.request.documentType" /></th>
			<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '5')}">
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
				<th colspan="1"><s:text name="label.request.cefNo" /><br />
				<s:text name="label.request.No" /><span class="ttip info"
					data-original-title="Enter the reference number which the bank will use on an ongoing basis to identify this undertaking."></span></th>
			</c:if>
			<c:if test="${(requestDetails.instrumentTypeId eq '6')}">
				<th colspan="1"><s:text name="label.request.suretyRider"/><br />
				<s:text name="label.request.RefNo" /><span class="ttip info" data-original-title="Enter the reference number which the broker will use on an ongoing basis to identify this undertaking."></span></th>
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
					<s:text name="label.request.issuanceDate" /><span class="ttip info"
					data-original-title="Enter the actual date of the rider issued"></span></th>
			</c:if>
			<th colspan="1"><s:text name="label.request.issuanceDescription" /></th>
			<th colspan="1"><s:text name="label.request.document" /></th> 
		</tr>
	</thead>
	<tbody>
		<c:set var="isIndirect" value="false"></c:set>
		<s:if test="%{requestDetails.bidReplyDetails.issuanceTypeFlag eq 'Indirect'}">
				<c:set var="isIndirect" value="true"></c:set>
		</s:if>
		<s:set var="atmtIndex" value="0"></s:set>			
		  <s:if test="%{requestDetailsBO.attachmentBOList != null && requestDetailsBO.attachmentBOList.size>0}">    
			<s:iterator value="requestDetailsBO.attachmentBOList" status="atmtBOItrStatus">
			<s:if test="%{issuanceDocType != null && issuanceDocType != ''}">					
			<s:set var="attachmentIndex" value="%{#atmtBOItrStatus.index}"></s:set>  			
				<tr>
					<td>
						<div class="alocDeleteAttachmentContainer">
							<div class="alocDeleteAttachment${attachmentIndex}"> 
								<p style="padding: 10px 0 0 10px;">
									<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
									<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess"> 									
									<a href='javascript:void(0)'
										onclick="javascript:deleteIssuanceAttachment(<s:property value="model.geFileId"/>,3,<s:property value="#atmtBOItrStatus.index"/>)">
											<s:text name="label.request.clear" />
									</a>
									</hwfs:checkComponentPermission>
									<hwfs:checkComponentPermission name="BankBrokerReadOnly" domainName="BusinessAccess">
										<s:text name="label.request.clear" />
									</hwfs:checkComponentPermission>
									</s:if>
									<s:elseif test="%{issuanceDesc !=null && issuanceDesc != ''}">
										<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
											<a href='javascript:void(0)'
											onclick="javascript:clearAllData(<s:property value="#atmtBOItrStatus.index"/>)">
												<s:text name="label.request.clear" />
											</a>
										</hwfs:checkComponentPermission>
										<hwfs:checkComponentPermission name="BankBrokerReadOnly" domainName="BusinessAccess">
											<s:text name="label.request.clear" />
										</hwfs:checkComponentPermission>
									</s:elseif>
									<s:else>
										<s:text name="label.request.clear" />
									</s:else> 
								</p>
							</div>
						</div>
					</td>
					<td>
					<c:if test="${isIndirect}">
						<s:if test="#atmtBOItrStatus.index == 0">
							<c:if test="${requestDetailsBO.attachmentBOList[0].issuanceDocType eq '2'}">	
								<s:label><s:text name="label.request.bankIssuance" /></s:label>									
								<s:hidden name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocType" value="2"/>
							</c:if>
						</s:if>
						<s:if test="#atmtBOItrStatus.index == 1">
							<c:if test="${requestDetailsBO.attachmentBOList[1].issuanceDocType eq '3'}">								
								<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
									<s:label><s:text name="label.request.suretyBond" /></s:label>
									<s:hidden  name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocType" value="3"/>
								 </c:if>
							</c:if>
							<c:if test="${requestDetailsBO.attachmentBOList[1].issuanceDocType eq '1'}">	
								<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
									<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>							
									<s:hidden  name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocType" value="1"/>
								 </c:if>
							</c:if>						
						</s:if>
					</c:if>
					<c:if test="${empty isIndirect or isIndirect ne true}">
						<s:if test="#atmtBOItrStatus.index == 0">
							<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
								<s:label><s:text name="label.request.suretyBond" /></s:label>
								<s:hidden  name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocType" value="3"/>
						    </c:if>	
							<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
								<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>							
								<s:hidden  name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocType" value="1"/>
						 	</c:if>						
						</s:if>
					</c:if>
					</td>
					<td>
						<c:if test="${(requestDetails.instrumentTypeId eq '5') || (requestDetails.instrumentTypeId eq '6')}">
							<s:if test="#atmtBOItrStatus.index == 0">
								<c:if test="${requestDetails.instrumentTypeId eq '5'}">
								<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber}" readonly="true"/>
								</c:if>
								<c:if test="${requestDetails.instrumentTypeId eq '6'}">
								<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber}" readonly="true"/>
								</c:if>
							</s:if>
							<s:if test="#atmtBOItrStatus.index == 1">
								<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceBankRefNo" id="issuanceBankRefNo%{#atmtBOItrStatus.index}" maxlength="20"/>
							</s:if>
						</c:if>
						<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '3')  || (requestDetails.instrumentTypeId eq '4')}">
							<s:if test="#atmtBOItrStatus.index == 0">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceBankRefNo" id="issuanceBankRefNo%{#atmtBOItrStatus.index}" readonly="true"/>
							</s:if>
							<s:if test="#atmtBOItrStatus.index == 1">
								<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceBankRefNo" id="issuanceBankRefNo%{#atmtBOItrStatus.index}" maxlength="20"/>
							</s:if>
						</c:if>
					</td>
					<td width="350"><s:textfield id="issuanceDate%{#atmtBOItrStatus.index}" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDate" cssClass="span1d date" />
						<p>
							<s:text name="label.request.dateFormat" />
						</p>
					</td>
					<td>
					<s:textarea id="issuanceDesc%{#atmtBOItrStatus.index}" style="resize: none; overflow-y: hidden;" cssClass="autosize1 messageinput" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDesc" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter${attachmentIndex}">100</div> <!-- fix positions -->
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
					<td>
						<div class="alocAttachmentContainer">
							<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
							<p>
								<input type="file" class="alocFileupload" name="fileUpload"	data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&index=<s:property value="%{#atmtBOItrStatus.index}"/>" />
							</p>
							</hwfs:checkComponentPermission>
							<div class="alocAttachment${attachmentIndex}">
								<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
									<s:url id="fileDownload" action="download.action" namespace="/int/atmt">
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
						<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
						 <a href="javascript:;" class="need${attachmentIndex} copypasteDiv" id="linkHideId${attachmentIndex}"><img src="${pageContext.request.contextPath}/img/arrw.png"/>
						<s:text name="label.request.copyPaste" />						
						<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
							<s:hidden id="copyPasteDocModalConditionId%{#atmtBOItrStatus.index}" name="copyPasteDocModalConditionId" value="1" />
						</s:if>
						<s:else>
							<s:hidden id="copyPasteDocModalConditionId%{#atmtBOItrStatus.index}" name="copyPasteDocModalConditionId" value="0" />  
						</s:else>	
						<s:hidden id="copyPasteTypeId%{#atmtBOItrStatus.index}" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId%{#atmtBOItrStatus.index}" name="copyPasteGeLibFileId" value="%{model.geFileId}" />
						</a>
						</hwfs:checkComponentPermission> 
					</td>
				</tr>
				<tr class="hide copydoc<s:property value="%{#atmtBOItrStatus.index}"/>"> 				
					<td colspan="6">
					<c:if test="${isIndirect}">
						<c:if test="${requestDetailsBO.attachmentBOList[0].issuanceDocType eq '2'}">	
							<s:if test="#atmtBOItrStatus.index == 0">
								<s:label><s:text name="label.request.bankIssuance" /></s:label>							 											
							</s:if>
						</c:if>
						<s:if test="#atmtBOItrStatus.index == 1">
							<c:if test="${requestDetailsBO.attachmentBOList[1].issuanceDocType eq '3'}">	
								<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
									<s:label><s:text name="label.request.suretyBond" /></s:label>						 
								 </c:if>
							</c:if>
							<c:if test="${requestDetailsBO.attachmentBOList[1].issuanceDocType eq '1'}">	
								<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
									<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>						
								 </c:if>
							</c:if>										 										 		
						</s:if>
					</c:if>
					<c:if test="${empty isIndirect or isIndirect ne true}">
						<s:if test="#atmtBOItrStatus.index == 0">
							<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
								<s:label><s:text name="label.request.suretyBond" /></s:label>						 
							 </c:if>	
							<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
								<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>						
						    </c:if>										 										 		
						</s:if>
					</c:if>
					<s:textarea cssClass="autosize10K messageinput"  theme="aloc" id="issuanceDocument%{#atmtBOItrStatus.index}" cssStyle="width: 850px;" name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDocument" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
						<div class="clear"></div>
						<div class="textareaCounter10K counter10K${attachmentIndex}">80,000</div> <!-- fix positions -->
						<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
				</tr>
				</s:if>
			</s:iterator>
			
			<s:if test="%{requestDetailsBO.attachmentBOList.size==1}">		
			<c:if test="${isIndirect}">
				<s:set var="atmtIndex" value="1"></s:set> 			
			<tr>
				<td>
					<div class="alocDeleteAttachmentContainer">
						<div class="alocDeleteAttachment1">
							<p style="padding: 10px 0 0 10px;">
							<s:text name="label.request.clear" />
							</p>
						</div>
					</div>
				</td>
				<td><p>								
					<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
						<s:label><s:text name="label.request.suretyBond" /></s:label>
						<s:hidden  name="requestDetailsBO.attachmentBOList[1].issuanceDocType" value="3"/>
					 </c:if>
					 <c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
						<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>							
						<s:hidden  name="requestDetailsBO.attachmentBOList[1].issuanceDocType" value="1"/>
					 </c:if>									
					</p>
				</td>
				<td>
				<s:textfield cssClass="span1a" id="issuanceBankRefNo1" name="requestDetailsBO.attachmentBOList[1].issuanceBankRefNo" theme="aloc" maxlength="20"/> 
				<td width="350" ><s:textfield id="issuanceDate1"  name="requestDetailsBO.attachmentBOList[1].issuanceDate" theme="aloc" cssClass="date span1d"/>
					<p><s:text name="label.request.dateFormat" /></p>
				</td>
				<td><s:textarea cssClass="autosize1 messageinput"	id="issuanceDesc1" name="requestDetailsBO.attachmentBOList[1].issuanceDesc" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
					<div class="clear"></div>
					<div class="textareaCounter1 counter1">100</div>
					<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
				</td>
				<td>
					<div class="alocAttachmentContainer">
					<p><input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&formatId=&index=1"/></p>
					<div class="alocAttachment1"></div>	
					</div>
					<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
					 <a href="javascript:;" class="need1 copypasteDiv" id="linkHideId1"><img src="${pageContext.request.contextPath}/img/arrw.png" /><s:text name="label.request.copyPaste" />							
						<s:hidden id="copyPasteDocModalConditionId1" name="copyPasteDocModalConditionId" value="1" />	
						<s:hidden id="copyPasteTypeId1" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId1" name="copyPasteGeLibFileId" value="" />
					</a>
					</hwfs:checkComponentPermission>
				</td>
			</tr>
			<tr class="hide copydoc1">
				<td colspan="6">				
					<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
							<s:label><s:text name="label.request.suretyBond" /></s:label>						 
					</c:if>	
					<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
						<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>						
				    </c:if>	
					<s:textarea cssClass="autosize10K messageinput" id="issuanceDocument1" theme="aloc" style="width: 850px;" name="requestDetailsBO.attachmentBOList[1].issuanceDocument" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
					<div class="clear"></div>
					<div class="textareaCounter10K counter10K1">80,000</div> <!-- fix positions -->
					<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
			</tr>
			</c:if>	
			</s:if>
		</s:if>
		<s:else>			
			<c:if test="${isIndirect}">				 
				<tr>
					<td>
					<div class="alocDeleteAttachmentContainer">
							<div class="alocDeleteAttachment0">
								<p style="padding: 10px 0 0 10px;">
									<s:text name="label.request.clear" />
								</p>
							</div>
					</div>						
					</td>
					<td>
						<p>
							<s:label><s:text name="label.request.bankIssuance" /></s:label>	
					 		<s:hidden  name="requestDetailsBO.attachmentBOList[0].issuanceDocType" value="2"/>						
						</p>
					</td>
					<td>
						<c:if test="${(requestDetails.instrumentTypeId eq '5')}">
							<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" value="%{requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber}" readonly="true"/>
						</c:if>
						<c:if test="${requestDetails.instrumentTypeId eq '6'}">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber}" readonly="true"/>
						</c:if>
						<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '3')  || (requestDetails.instrumentTypeId eq '4')}">
							<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" readonly="true" />
						</c:if>
					</td>
					<td width="350"><s:textfield id="issuanceDate0" name="requestDetailsBO.attachmentBOList[0].issuanceDate" cssClass="span1d date"/>
						<p>
							<s:text name="label.request.dateFormat" /> 
						</p>
					</td>
					<td><s:textarea style="resize: none; overflow-y: hidden;"
							cssClass="autosize1 messageinput" id="issuanceDesc0" 
							name="requestDetailsBO.attachmentBOList[0].issuanceDesc" cols="50"
							rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter0">100</div> <!-- fix positions -->
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
							<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
							<p>
								<input type="file" class="alocFileupload" name="fileUpload"
									data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&index=0" />
							</p>
							</hwfs:checkComponentPermission>
							<div class="alocAttachment0"></div>
						</div>
						<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess"> 
						<a href="javascript:;" class="need0 copypasteDiv" id="linkHideId0"><img src="${pageContext.request.contextPath}/img/arrw.png"/><s:text name="label.request.copyPaste" />
							<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="0" />
							<s:hidden id="copyPasteTypeId0" name="copyPasteTypeId" value="3" />
							<s:hidden id="copyPasteGeLibFileId0" name="copyPasteGeLibFileId" value="" />
						</a>
						</hwfs:checkComponentPermission>
					</td>
				</tr>
				<tr class="hide copydoc0">
					<td colspan="6"><s:label><s:text name="label.request.bankIssuance" /></s:label>													 					
					<s:textarea	cssClass="autosize10K messageinput " id="issuanceDocument0" cssStyle="width: 850px;" theme="aloc"
							name="requestDetailsBO.attachmentBOList[0].issuanceDocument" 	cols="150" rows="20"
							onKeyPress="return imposeMaxLength(this, 79999);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter10K counter10K0">80,000</div> <!-- fix positions -->
						<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
				  </td>
				</tr>
				<tr>
					<td>
						<div class="alocDeleteAttachmentContainer">
								<div class="alocDeleteAttachment1">
									<p style="padding: 10px 0 0 10px;">
										<s:text name="label.request.clear" />
									</p>
								</div>
							</div>
					</td>
					<td><p>
					 <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
							 <s:label><s:text name="label.request.suretyBond" /></s:label>
							 <s:hidden  name="requestDetailsBO.attachmentBOList[1].issuanceDocType" value="3"/>
					 </c:if>						 
					 <c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4') || (requestDetails.instrumentTypeId eq '5')}">
						 	<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>	
						 	<s:hidden  name="requestDetailsBO.attachmentBOList[1].issuanceDocType" value="1"/>
					</c:if>						 
					</p>
					</td>
					<td>
					<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '3')|| (requestDetails.instrumentTypeId eq '4') || (requestDetails.instrumentTypeId eq '5') || (requestDetails.instrumentTypeId eq '6')}">
						<s:textfield cssClass="span1a" id="issuanceBankRefNo1" name="requestDetailsBO.attachmentBOList[1].issuanceBankRefNo" theme="aloc" maxlength="20"/> 
					</c:if>				
					<td width="350" ><s:textfield id="issuanceDate1" name="requestDetailsBO.attachmentBOList[1].issuanceDate" theme="aloc" cssClass="date span1d"/>
						<p><s:text name="label.request.dateFormat" /></p>
					</td>
					<td><s:textarea cssClass="autosize1 messageinput" id="issuanceDesc1" name="requestDetailsBO.attachmentBOList[1].issuanceDesc" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter1">100</div>
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
						<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
						<p><input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&formatId=&index=1"/></p>
						</hwfs:checkComponentPermission>
						<div class="alocAttachment1"></div>	
						</div>
						<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
						 <a href="javascript:;" class="need1 copypasteDiv" id="linkHideId1"><img src="${pageContext.request.contextPath}/img/arrw.png" /><s:text name="label.request.copyPaste" />
							<s:hidden id="copyPasteDocModalConditionId1" name="copyPasteDocModalConditionId" value="1" />	
							<s:hidden id="copyPasteTypeId1" name="copyPasteTypeId" value="3" />
							<s:hidden id="copyPasteGeLibFileId1" name="copyPasteGeLibFileId" value="" />
						</a>
						</hwfs:checkComponentPermission>
					</td>
				</tr>
				<tr class="hide copydoc1">
					<td colspan="6">				
						<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
							 <s:label><s:text name="label.request.suretyBond" /></s:label>					
						 </c:if>	
						 <c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4') || (requestDetails.instrumentTypeId eq '5')}">
							<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>	
						 </c:if>
						<s:textarea cssClass="autosize10K messageinput" id="issuanceDocument1" theme="aloc" style="width: 850px;" name="requestDetailsBO.attachmentBOList[1].issuanceDocument" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
						<div class="clear"></div>
						<div class="textareaCounter10K counter10K1">80,000</div> <!-- fix positions -->
						<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
				</tr>
			</c:if>
			<c:if test="${empty isIndirect or isIndirect ne true}">					
			<tr>
				<td>
					<div class="alocDeleteAttachmentContainer">
							<div class="alocDeleteAttachment0">
								<p style="padding: 10px 0 0 10px;">
									<s:text name="label.request.clear" />
								</p>
							</div>
						</div>
				</td>
				<td><p>
				 <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
					 <s:label><s:text name="label.request.suretyBond" /></s:label>
					 <s:hidden  name="requestDetailsBO.attachmentBOList[0].issuanceDocType" value="3"/>
				 </c:if>						 
				 <c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4') || (requestDetails.instrumentTypeId eq '5')}">
				 	<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>	
				 	<s:hidden  name="requestDetailsBO.attachmentBOList[0].issuanceDocType" value="1"/>
				 </c:if>						 
				</p>
				</td>
				<td>
				<c:if test="${(requestDetails.instrumentTypeId eq '5')}">
					<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" value="%{requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber}" readonly="true"/>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '6'}">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber}" readonly="true"/>
						</c:if>
				<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '3')  || (requestDetails.instrumentTypeId eq '4')}">
					<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" theme="aloc" readonly="true"/> 
				</c:if>	
				</td>				
				<td width="350" ><s:textfield id="issuanceDate0" name="requestDetailsBO.attachmentBOList[0].issuanceDate" theme="aloc" cssClass="date span1d"/>
					<p><s:text name="label.request.dateFormat" /></p>
				</td>
				<td><s:textarea cssClass="autosize1 messageinput" id="issuanceDesc0" name="requestDetailsBO.attachmentBOList[0].issuanceDesc" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
					<div class="clear"></div>
					<div class="textareaCounter1 counter0">100</div>
					<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
				</td>
				<td>
					<div class="alocAttachmentContainer">
					<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
					<p><input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&formatId=&index=0"/></p>
					</hwfs:checkComponentPermission>
					<div class="alocAttachment0"></div>	
					</div>
					<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
					 <a href="javascript:;" class="need0 copypasteDiv" id="linkHideId0"><img src="${pageContext.request.contextPath}/img/arrw.png" /><s:text name="label.request.copyPaste" />							
						<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="0" />	
						<s:hidden id="copyPasteTypeId0" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId0" name="copyPasteGeLibFileId" value="" />
					</a>
					</hwfs:checkComponentPermission>
				</td>
			</tr>
			<tr class="hide copydoc0">
				<td colspan="6">				
					<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
						 <s:label><s:text name="label.request.suretyBond" /></s:label>					
					 </c:if>	
					 <c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4') || (requestDetails.instrumentTypeId eq '5')}">
						<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>	
					 </c:if>
					<s:textarea cssClass="autosize10K messageinput" id="issuanceDocument0" theme="aloc" style="width: 850px;" name="requestDetailsBO.attachmentBOList[0].issuanceDocument" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
					<div class="clear"></div>
					<div class="textareaCounter10K counter10K0">80,000</div> <!-- fix positions -->
					<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
			</tr>
			</c:if>
		</s:else>
	</tbody>
</table>

