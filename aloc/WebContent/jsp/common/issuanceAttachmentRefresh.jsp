<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
		<s:if test="%{requestDetails.bidReplyDetails.issuanceTypeFlag == null || requestDetails.bidReplyDetails.issuanceTypeFlag != 'Indirect'}">
			
				<tr>
					<td>
						<div class="alocDeleteAttachmentContainer">
							<div class="alocDeleteAttachment0"> 
								<p style="padding: 10px 0 0 10px;">
									<s:if test="%{requestDetailsBO.attachmentBOList[0].model.geFileId !=null && requestDetailsBO.attachmentBOList[0].model.geFileId !=0}"> 									
									<a href='javascript:void(0)'
										onclick="javascript:deleteIssuanceAttachment(<s:property value="requestDetailsBO.attachmentBOList[0].model.geFileId"/>,3,<s:property value="0"/>)">
											<s:text name="label.request.clear" />
									</a>
									</s:if>
									<s:else>
											<s:text name="label.request.clear" /> 
									</s:else> 
								</p>
							</div>
						</div>
					</td>
					<td>
						<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
							<s:label><s:text name="label.request.suretyBond" /></s:label>
							<s:hidden  name="requestDetailsBO.attachmentBOList[0].issuanceDocType" value="3"/>
					    </c:if>	
						<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
							<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>							
							<s:hidden  name="requestDetailsBO.attachmentBOList[0].issuanceDocType" value="1"/>
					 	</c:if>						
					</td>
					<td>
						<c:if test="${(requestDetails.instrumentTypeId eq '5')}">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber}" readonly="true"/>
						</c:if>
						<c:if test="${requestDetails.instrumentTypeId eq '6'}">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" value="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber}" readonly="true"/>
						</c:if>
						<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '3')  || (requestDetails.instrumentTypeId eq '4')}">
							<s:textfield cssClass="span1a" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" id="issuanceBankRefNo0" maxlength="20"/>
						</c:if>
					</td>
					<td width="350">
						<s:textfield id="issuanceDate0" name="requestDetailsBO.attachmentBOList[0].issuanceDate" cssClass="span1d date" />
						<p>
							<s:text name="label.request.dateFormat" />
						</p>
					</td>
					<td>
						<s:textarea id="issuanceDesc0" style="resize: none; overflow-y: hidden;" cssClass="autosize1 messageinput" name="requestDetailsBO.attachmentBOList[0].issuanceDesc" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter0">100</div> <!-- fix positions -->
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
							<p>
								<input type="file" class="alocFileupload" name="fileUpload"	data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&index=<s:property value="0"/>" />
							</p>
							<div class="alocAttachment0">
								<s:if test="%{requestDetailsBO.attachmentBOList[0].model.geFileId !=null && requestDetailsBO.attachmentBOList[0].model.geFileId !=0}">
									<s:url id="fileDownload" action="download.action" namespace="/int/atmt">
										<s:param name="geLibFileId" value="requestDetailsBO.attachmentBOList[0].model.geFileId" />
										<s:param name="typeId" value="3" />
										<s:param name="index" value="0" />
									</s:url>
									
									<s:a href="%{fileDownload}">
										<s:property value="requestDetailsBO.attachmentBOList[0].model.attachmentOriginalName" />
									</s:a>
								</s:if>
							</div>
						</div> <a href="javascript:;" class="need0 copypasteDiv" id="linkHideId0"><img src="${pageContext.request.contextPath}/img/arrw.png"/>
						<s:text name="label.request.copyPaste" />						
						<s:if test="%{requestDetailsBO.attachmentBOList[0].model.geFileId !=null && requestDetailsBO.attachmentBOList[0].model.geFileId !=0}">
							<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="1" />
						</s:if>
						<s:else>
							<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="0" />  
						</s:else>	
						<s:hidden id="copyPasteTypeId0" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId0" name="copyPasteGeLibFileId" value="%{requestDetailsBO.attachmentBOList[0].model.geFileId}" />
						</a> 
					</td>
				</tr>
				<tr class="hide copydoc<s:property value="0"/>"> 				
					<td colspan="6">
					
						<c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6')}">
							<s:label><s:text name="label.request.suretyBond" /></s:label>						 
						 </c:if>	
						<c:if test="${(requestDetails.instrumentTypeId eq '1') || (requestDetails.instrumentTypeId eq '2') || (requestDetails.instrumentTypeId eq '4')  || (requestDetails.instrumentTypeId eq '5')}">
							<s:label><s:text name="label.request.benificiaryIssuance" /></s:label>						
					    </c:if>										 										 		
					<s:textarea cssClass="autosize10K messageinput"  theme="aloc" id="issuanceDocument0" cssStyle="width: 850px;" name="requestDetailsBO.attachmentBOList[0].issuanceDocument" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
						<div class="clear"></div>
						<div class="textareaCounter10K counter10K0">80,000</div> <!-- fix positions -->
						<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
				</tr>
		</s:if>
		
		<s:elseif test="%{requestDetails.bidReplyDetails.issuanceTypeFlag eq 'Indirect'}">
			<s:if test="%{requestDetailsBO.attachmentBOList.size > 0}">
				<s:if test="%{requestDetailsBO.attachmentBOList[0].model.issuanceDocTypeId == 2}">
					<s:set var="bankToBank" value="%{requestDetailsBO.attachmentBOList[0]}"></s:set>
					
					<s:if test="%{requestDetailsBO.attachmentBOList.size == 2}">
						<s:set var="issuenceToBen" value="%{requestDetailsBO.attachmentBOList[1]}"></s:set>
					</s:if>
				</s:if>
				<s:else>
					<s:if test="%{requestDetailsBO.attachmentBOList[0].model.issuanceDocTypeId == 1}">
					<s:set var="issuenceToBen" value="%{requestDetailsBO.attachmentBOList[0]}"></s:set>
					
					<s:if test="%{requestDetailsBO.attachmentBOList.size == 2}">
						<s:set var="bankToBank" value="%{requestDetailsBO.attachmentBOList[1]}"></s:set>
					</s:if>
					</s:if>
				</s:else>
			</s:if>

		  	
		  	<tr>
				<td>
					<div class="alocDeleteAttachmentContainer">
							<div class="alocDeleteAttachment0">
								<p style="padding: 10px 0 0 10px;">
									<s:if test="%{#bankToBank.model.geFileId !=null && #bankToBank.model.geFileId !=0}"> 									
									<a href='javascript:void(0)'
										onclick="javascript:deleteIssuanceAttachment(<s:property value="#bankToBank.model.geFileId"/>,3,<s:property value="0"/>)">
											<s:text name="label.request.clear" />
									</a>
									</s:if>
									<s:else>
											<s:text name="label.request.clear" /> 
									</s:else> 
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
						<c:if test="${requestDetails.instrumentTypeId eq '5'}">
							<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" value="%{requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber}" readonly="true"/>
						</c:if>
						<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">
							<s:textfield cssClass="span1a" id="issuanceBankRefNo0" name="requestDetailsBO.attachmentBOList[0].issuanceBankRefNo" value="%{#bankToBank.model.issuanceBankRefNo}" maxlength="20"/>
						</c:if>
					</td>
					<td width="350"><s:textfield id="issuanceDate0" name="requestDetailsBO.attachmentBOList[0].issuanceDate" value="%{#bankToBank.model.issuanceDate}" cssClass="span1d date"/>
						<p>
							<s:text name="label.request.dateFormat" /> 
						</p>
					</td>
					<td>
						<s:textarea style="resize: none; overflow-y: hidden;"
							cssClass="autosize1 messageinput" id="issuanceDesc0" 
							name="requestDetailsBO.attachmentBOList[0].issuanceDesc" value="%{#bankToBank.model.issuanceDesc}" cols="50"
							rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter0">100</div> <!-- fix positions -->
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
							<p>
								<input type="file" class="alocFileupload" name="fileUpload"
									data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&index=0" />
							</p>
							<div class="alocAttachment0">
							<s:if test="%{#bankToBank.model.geFileId !=null && #bankToBank.model.geFileId !=0}">
									<s:url id="fileDownload" action="download.action" namespace="/int/atmt">
										<s:param name="geLibFileId" value="#bankToBank.model.geFileId" />
										<s:param name="typeId" value="3" />
										<s:param name="index" value="0" />
									</s:url>
									<s:a href="%{fileDownload}">
										<s:property value="#bankToBank.model.attachmentOriginalName" />
									</s:a>
							</s:if>
							</div>
						</div> 
						
						<a href="javascript:;" class="need0 copypasteDiv" id="linkHideId0"><img src="${pageContext.request.contextPath}/img/arrw.png"/><s:text name="label.request.copyPaste" />
						
						<s:if test="%{#bankToBank.model.geFileId !=null && #bankToBank.model.geFileId !=0}">
							<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="1" />
						</s:if>
						<s:else>
							<s:hidden id="copyPasteDocModalConditionId0" name="copyPasteDocModalConditionId" value="0" />  
						</s:else>	
						<s:hidden id="copyPasteTypeId0" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId0" name="copyPasteGeLibFileId" value="%{#bankToBank.model.geFileId}" />
						</a>
					</td>
				</tr>
				<tr class="hide copydoc0">
					<td colspan="6"><s:label><s:text name="label.request.bankIssuance" /></s:label>													 					
					<s:textarea	cssClass="autosize10K messageinput " id="issuanceDocument0" cssStyle="width: 850px;" theme="aloc"
							name="requestDetailsBO.attachmentBOList[0].issuanceDocument" value="%{#bankToBank.model.issuanceDocument}"	cols="150" rows="20"
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
										<s:if test="%{#issuenceToBen.model.geFileId !=null && #issuenceToBen.model.geFileId !=0}"> 									
										<a href='javascript:void(0)'
											onclick="javascript:deleteIssuanceAttachment(<s:property value="#issuenceToBen.model.geFileId"/>,3,<s:property value="1"/>)">
												<s:text name="label.request.clear" />
										</a>
										</s:if>
										<s:else>
												<s:text name="label.request.clear" /> 
										</s:else> 
									</p>
									
								</div>
							</div>
					</td>
					<td>
						<p>
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
							<s:textfield cssClass="span1a" id="issuanceBankRefNo1" name="requestDetailsBO.attachmentBOList[1].issuanceBankRefNo" value="%{#issuenceToBen.model.issuanceBankRefNo}" theme="aloc" maxlength="20"/> 
						</c:if>	
					</td>			
					<td width="350" ><s:textfield id="issuanceDate1" name="requestDetailsBO.attachmentBOList[1].issuanceDate" value="%{#issuenceToBen.model.issuanceDate}" theme="aloc" cssClass="date span1d"/>
						<p><s:text name="label.request.dateFormat" /></p>
					</td>
					<td>
						<s:textarea cssClass="autosize1 messageinput" id="issuanceDesc1" name="requestDetailsBO.attachmentBOList[1].issuanceDesc" value="%{#issuenceToBen.model.issuanceDesc}" cols="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						<div class="clear"></div>
						<div class="textareaCounter1 counter1">100</div>
						<div class="counterTxt1"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
						<p><input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=3&formatId=&index=1"/></p>
						<div class="alocAttachment1">
						<s:if test="%{#issuenceToBen.model.geFileId !=null && #issuenceToBen.model.geFileId !=0}">
								<s:url id="fileDownload" action="download.action" namespace="/int/atmt">
									<s:param name="geLibFileId" value="#issuenceToBen.model.geFileId" />
									<s:param name="typeId" value="3" />
									<s:param name="index" value="1" />
								</s:url>
								<s:a href="%{fileDownload}">
									<s:property value="#issuenceToBen.model.attachmentOriginalName" />
								</s:a>
						</s:if>
						</div>
						</div>
						
						 <a href="javascript:;" class="need1 copypasteDiv" id="linkHideId1"><img src="${pageContext.request.contextPath}/img/arrw.png" /><s:text name="label.request.copyPaste" />							
							<s:if test="%{#issuenceToBen.model.geFileId !=null && #issuenceToBen.model.geFileId !=0}">
							<s:hidden id="copyPasteDocModalConditionId1" name="copyPasteDocModalConditionId" value="1" />
							</s:if>
							<s:else>
								<s:hidden id="copyPasteDocModalConditionId1" name="copyPasteDocModalConditionId" value="0" />  
							</s:else>	
						<s:hidden id="copyPasteTypeId1" name="copyPasteTypeId" value="3" />
						<s:hidden id="copyPasteGeLibFileId1" name="copyPasteGeLibFileId" value="%{#issuenceToBen.model.geFileId}" />
						</a>
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
						<s:textarea cssClass="autosize10K messageinput" id="issuanceDocument1" theme="aloc" style="width: 850px;" name="requestDetailsBO.attachmentBOList[1].issuanceDocument" value="%{#issuenceToBen.model.issuanceDocument}" cols="300" rows="20" onKeyPress="return imposeMaxLength(this, 79999);" />
						<div class="clear"></div>
						<div class="textareaCounter10K counter10K1">80,000</div> <!-- fix positions -->
						<div class="counterTxt10k"><p class="guidance"><s:text  name="label.request.characters"/></p></div></td>
				</tr>
		</s:elseif>

	</tbody>
</table>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>   	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/date.js"></script>	