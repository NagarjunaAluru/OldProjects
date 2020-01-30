<%@ attribute name="mode" required="false"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<h3>Leg Attachments</h3>
<div class="row">
	<div class="span12">
	 	<table class="table table-bordered no-bottom">
			<thead>
		  		<tr>
					<th class="legCol1">Type</th>
					<th class="legCol2">Documents</th>
					<th class="legCol3">Comments</th>
					<th class="legCol4">Attach<br />
						<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
					</th>
		  		</tr>
			</thead>
			<tbody>
				<c:set var="attachmentLegs" value="${atmtfunctions:getLegSummaryVOs(pageContext.request)}"/>
				<c:set var="allLegsAllAttachmentTypeComments" value="${atmtfunctions:getAllLegsAllAttachmentTypeComments(pageContext.request)}" />
				
				<%-- Rendering Legal Agreements --%>
				<c:set var="legalAgAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(3, pageContext.request)}" />
				<c:if test="${legalAgAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type3.leg">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${legalAgAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							<span class="attachmentTypeName">Legal Agreements(s)</span>
						</td>
						
						<c:choose>
							<c:when test="${not empty attachmentLegs}">
								<td colspan="2">
									<div id="icfpMultiLegAttachmentArea3">
										<table class="table no-bottom">
											<c:forEach var="legDetails" items="${attachmentLegs}">
												<tr>
													<td>
														<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
															<c:set var="legalAgreementsList" value="${atmtfunctions:getLegAttachments(3, legDetails.legNumber, pageContext.request)}" />
															<c:choose>
																<c:when test="${not empty legalAgreementsList}">
																	<c:forEach var="legalAgreement" items="${legalAgreementsList}">
																		<div class="icfpAttachment">
																			<c:if test="${(not empty mode) && mode == 'edit' && legalAgAtmtPermissions.deletable}">
																				<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${legalAgreement.geFileId}')">
																					<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																				</a> &nbsp;
																			</c:if>
																			Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																			<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${legalAgreement.geFileId}' class='attachment-link'>${legalAgreement.origAttachmentName} </a>
																		</div>
																	</c:forEach>
																</c:when>
																<c:otherwise>-</c:otherwise>
															</c:choose>
														</div>
													</td>
													
													<td style="width:253px">
														<c:choose>
															<c:when test="${(not empty mode) && mode == 'edit' && legalAgAtmtPermissions.editable}">
																<c:if test="${legalAgAtmtPermissions.mandatory}">
																	<span class="required">*</span>
																</c:if>
																<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp; Comment if no attachment</b> 
																<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																<input type="hidden" name="atmtLegCommentType"  value="3" />
																<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																	onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][3]}</textarea>
															</c:when>
															<c:otherwise>
																${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][3]}
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
	
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) && (not empty mode) && mode == 'edit' && legalAgAtmtPermissions.editable}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(3)" renderStyle="replace">Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
				
				
				<%-- Consolidated Financial Statements --%>
				<c:set var="csfAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(4, pageContext.request)}" />
				<c:if test="${csfAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type4.leg">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${csfAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							<span class="attachmentTypeName">Consolidated Financial Statements</span>
						</td>
						
						<c:choose>
							<c:when test="${not empty attachmentLegs}">
								<td colspan="2">
									<div id="icfpMultiLegAttachmentArea4">
										<table style="width:100%;margin:0px;padding:0px;">
											<c:forEach var="legDetails" items="${attachmentLegs}">
												<tr>
													<td>
														<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
															<c:set var="financialStatementsList" value="${atmtfunctions:getLegAttachments(4, legDetails.legNumber, pageContext.request)}" />
															<c:choose>
																<c:when test="${not empty financialStatementsList}">
																	<c:forEach var="financialStatement" items="${financialStatementsList}">
																		<div class="icfpAttachment">
																			<c:if test="${(not empty mode) && mode == 'edit' && csfAtmtPermissions.deletable}">
																				<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${financialStatement.geFileId}')">
																					<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																				</a> &nbsp;
																			</c:if>
																			Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																			<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${financialStatement.geFileId}' class='attachment-link'>${financialStatement.origAttachmentName} </a>
																		</div>
																	</c:forEach>
																</c:when>
																<c:otherwise>-</c:otherwise>
															</c:choose>
														</div>
													</td>
													
													<td style="width:253px">
														<c:choose>
															<c:when test="${(not empty mode) && mode == 'edit' && csfAtmtPermissions.editable}">
																<c:if test="${csfAtmtPermissions.mandatory}">
																	<span class="required">*</span>
																</c:if>
																<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;Comment if no attachment</b> 
																<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																<input type="hidden" name="atmtLegCommentType"  value="4" />
																<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																	onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][4]}</textarea>
															</c:when>
															<c:otherwise>
																${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][4]}
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) && (not empty mode) && mode == 'edit' && csfAtmtPermissions.editable}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(4)" renderStyle="replace">Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
				
				
				<%-- Corporate Governance Documents --%>
				<c:set var="cgdAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(5, pageContext.request)}" />
				<c:if test="${cgdAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type5.leg">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${cgdAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							<span class="attachmentTypeName">Corporate Governance Documents<span class="ttip info" data-original-title="<bean:message key="tooltip.attachmetns.corporateGovDoc" />"></span></span>
						</td>
						
						<c:choose>
							<c:when test="${not empty attachmentLegs}">
								<td colspan="2">
									<div id="icfpMultiLegAttachmentArea5">
										<table style="width:100%;margin:0px;padding:0px;">
											<c:forEach var="legDetails" items="${attachmentLegs}">
												<tr>
													<td>
														<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
															<c:set var="corporateGovernanceList" value="${atmtfunctions:getLegAttachments(5, legDetails.legNumber, pageContext.request)}" />
															<c:choose>
																<c:when test="${not empty corporateGovernanceList}">
																	<c:forEach var="corporageGovernance" items="${corporateGovernanceList}">
																		<div class="icfpAttachment">
																			<c:if test="${(not empty mode) && mode == 'edit' && cgdAtmtPermissions.deletable}">
																				<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${corporageGovernance.geFileId}')">
																					<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																				</a> &nbsp;
																			</c:if>
																			Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																			<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${corporageGovernance.geFileId}' class='attachment-link'>${corporageGovernance.origAttachmentName} </a>
																		</div>
																	</c:forEach>
																</c:when>
																<c:otherwise>-</c:otherwise>
															</c:choose>
														</div>
													</td>
													
													<td style="width:253px">
														<c:choose>
															<c:when test="${(not empty mode) && mode == 'edit' && cgdAtmtPermissions.editable}">
																<c:if test="${cgdAtmtPermissions.mandatory}">
																	<span class="required">*</span>
																</c:if>
																<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;Comment if no attachment</b> 
																<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																<input type="hidden" name="atmtLegCommentType"  value="5" />
																<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																	onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][5]}</textarea>
															</c:when>
															<c:otherwise>
																${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][5]}
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) && (not empty mode) && mode == 'edit' && cgdAtmtPermissions.editable}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(5)" renderStyle="replace">Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
				
					<%-- Transfer Pricing Attachment(s) --%>
					<c:set var="tpAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(8, pageContext.request)}" />
					<c:if test="${tpAtmtPermissions.viewable}">
						<tr>
							<td>
								<logic:messagesPresent property="error.atmt.type8.leg">
									<span class="req-error" >-</span>
							  	</logic:messagesPresent>
								<c:if test="${tpAtmtPermissions.mandatory}">
									&nbsp;<span class="required">*</span>&nbsp;
								</c:if>
								<span class="attachmentTypeName">Transfer Pricing Attachment(s)</span>
							</td>
							
							<c:choose>
								<c:when test="${not empty attachmentLegs}">
									<td colspan="2">
										<div id="icfpMultiLegAttachmentArea8">
											<table style="width:100%;margin:0px;padding:0px;">
												<c:forEach var="legDetails" items="${attachmentLegs}">
													<tr>
														<td>
															<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
																<c:set var="transferPricingList" value="${atmtfunctions:getLegAttachments(8, legDetails.legNumber, pageContext.request)}" />
																<c:choose>
																	<c:when test="${not empty transferPricingList}">
																		<c:forEach var="transferPricing" items="${transferPricingList}">
																			<div class="icfpAttachment">
																				<c:if test="${(not empty mode) && mode == 'edit' && tpAtmtPermissions.deletable}">
																					<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${transferPricing.geFileId}')">
																						<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																					</a> &nbsp;
																				</c:if>
																				Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																				<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${transferPricing.geFileId}' class='attachment-link'>${transferPricing.origAttachmentName} </a>
																			</div>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>-</c:otherwise>
																</c:choose>
															</div>
														</td>
															
														<td style="width:253px">
															<c:choose>
																<c:when test="${(not empty mode) && mode == 'edit' && tpAtmtPermissions.editable}">
																	<c:if test="${tpAtmtPermissions.mandatory}">
																		<span class="required">*</span>
																	</c:if>
																	<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;Comment if no attachment</b> 
																	<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																	<input type="hidden" name="atmtLegCommentType"  value="8" />
																	<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																		onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][8]}</textarea>
																</c:when>
																<c:otherwise>
																	${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][8]}
																</c:otherwise>
															</c:choose>
														</td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>-</td>
									<td>-</td>
								</c:otherwise>
							</c:choose>
							
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) && (not empty mode) && mode == 'edit' && tpAtmtPermissions.editable}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(8)" renderStyle="replace">Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:if>
			</tbody>
		</table>
	</div>
</div>


<%-- Additional Attachments --%>
<h3>Additional Attachments</h3>
<div class="row">
	<div class="span12">
	 	<table class="table table-striped table-bordered no-bottom">
			<thead>
			  <tr>
				<th class="legCol1">Type</th>
				<th class="legCol2">Documents</th>
				<th class="legCol3">Comments</th>
				<th class="legCol4">Attach<br />
					<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
				</th> 
			  </tr>
			</thead>
			<tbody>
				<%-- Journal Entries --%>
				<c:set var="journaAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(7, pageContext.request)}" />
				<c:if test="${journaAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type7.leg">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${journaAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							<span class="attachmentTypeName">Journal Entries</span>
						</td>
						
						<c:choose>
							<c:when test="${not empty attachmentLegs}">
								<td colspan="2">
									<div id="icfpMultiLegAttachmentArea7">
										<table style="width:100%;margin:0px;padding:0px;">
											<c:forEach var="legDetails" items="${attachmentLegs}">
												<tr>
													<td>
														<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
															<c:set var="journalEntriesList" value="${atmtfunctions:getLegAttachments(7, legDetails.legNumber, pageContext.request)}" />
															<c:choose>
																<c:when test="${not empty journalEntriesList}">
																	<c:forEach var="journalEntrie" items="${journalEntriesList}">
																		<div class="icfpAttachment">
																			<c:if test="${(not empty mode) && mode == 'edit' && journaAtmtPermissions.deletable}">
																				<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${journalEntrie.geFileId}')">
																					<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																				</a> &nbsp;
																			</c:if>
																			Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																			<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${journalEntrie.geFileId}' class='attachment-link'>${journalEntrie.origAttachmentName} </a>
																		</div>
																	</c:forEach>
																</c:when>
																<c:otherwise>-</c:otherwise>
															</c:choose>
														</div>
													</td>
													
													<td style="width:253px">
														<c:choose>
															<c:when test="${(not empty mode) && mode == 'edit' && journaAtmtPermissions.editable}">
																<c:if test="${journaAtmtPermissions.mandatory}">
																	<span class="required">*</span>
																</c:if>
																<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;Comment if no attachment</b> 
																<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																<input type="hidden" name="atmtLegCommentType"  value="7" />
																<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																	onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][7]}</textarea>
															</c:when>
															<c:otherwise>
																${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][7]}
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
							
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) && (not empty mode) && mode == 'edit' && journaAtmtPermissions.editable}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(7)" >Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
				
				
				<%-- Under Writing File --%>
				<c:set var="uwAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(21, pageContext.request)}" />
				<c:if test="${uwAtmtPermissions.viewable}">
					<tr>
						<td>
							<c:if test="${uwAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							Underwriting File
						</td>
						
						<td>
							<a href='${pageContext.request.contextPath}/attachmentAction.do?command=downloadUnderWritingFile&type=21' class='attachment-link'>${atmtfunctions:getUnderWritingFileName(pageContext.request)}</a>
						</td>
						
						<td></td>
						
						<td></td>
					</tr>
				</c:if>
				
				<%-- Other Documents --%>
				<c:set var="otherAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(6, pageContext.request)}" />
				<c:if test="${otherAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type6.leg">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${otherAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							<span class="attachmentTypeName">Other Documents</span>
						</td>
						
						<c:choose>
							<c:when test="${not empty attachmentLegs}">
								<td colspan="2">
									<div id="icfpMultiLegAttachmentArea6">
										<table style="width:100%;margin:0px;padding:0px;">
											<c:forEach var="legDetails" items="${attachmentLegs}">
												<tr>
													<td>
														<div class="icfpLegAttachmentArea" id="icfpLegAttachmentArea${legDetails.legNumber}">
															<c:set var="otherDocumentsList" value="${atmtfunctions:getLegAttachments(6, legDetails.legNumber, pageContext.request)}" />
															<c:choose>
																<c:when test="${not empty otherDocumentsList}">
																	<c:forEach var="otherDocument" items="${otherDocumentsList}">
																		<div class="icfpAttachment">
																			<c:if test="${(not empty mode) && mode == 'edit' && otherAtmtPermissions.deletable}">
																				<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${otherDocument.geFileId}')">
																					<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
																				</a> &nbsp;
																			</c:if>
																			Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;
																			<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${otherDocument.geFileId}' class='attachment-link'>${otherDocument.origAttachmentName} </a>
																		</div>
																	</c:forEach>
																</c:when>
																<c:otherwise>-</c:otherwise>
															</c:choose>
														</div>
													</td>
													
													<td style="width:253px">
														<c:choose>
															<c:when test="${(not empty mode) && mode == 'edit' && otherAtmtPermissions.editable}">
																<c:if test="${otherAtmtPermissions.mandatory}">
																	<span class="required">*</span>
																</c:if>
																<b>Leg &nbsp; ${legDetails.legSeqId} &nbsp; - &nbsp;Comment if no attachment</b> 
																<input type="hidden" name="atmtLegNumber" value="${legDetails.legNumber}" />
																<input type="hidden" name="atmtLegCommentType"  value="6" />
																<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
																	onfocus="limit(this,500,'count1');" style="overflow: hidden;">${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][6]}</textarea>
															</c:when>
															<c:otherwise>
																${allLegsAllAttachmentTypeComments[atmtfunctions:toLong(legDetails.legNumber)][6]}
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
	
						<td>
							<c:choose>
								<c:when test="${(not empty attachmentLegs) &&(((not empty mode) && mode == 'edit' && otherAtmtPermissions.editable) or (otherAtmtPermissions.dealPermissions.closed))}">
									<a href="#" class="btn attach" onclick="javascript:showMultiLegAttachmentModal(6)" renderStyle="append">Add...</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</div>		

<%-- Leg selection modal --%>
<div class="modal hide fade" id="multiLegAttachmentModal">
	<div class="modal-header">
		<a class="close" href="#" onclick="javascript:closeMultiLegAttachmentModal()">X</a>
		
		<h3> Attach <span class="attachmentTypeName"></span> </h3>
	</div>
	
	<div class="modal-body"> 
		<p> Add a document to  <span class="attachmentTypeName"></span></p>
		
		<h2>1. Select a Leg to attach a document</h2>
		
		<div class="row">
			<div class="span9">
				 <table class="table table-striped table-bordered sortable no-bottom" style="font-size:10px">
					<thead>
					  <tr>
						<th rowspan="2">Select</th>
						<th rowspan="2">Leg #</th>
						<th rowspan="2">Product Type</th>
						<th rowspan="2">Term <span class="small">in months</span></th>
						<th colspan="2" class="nosort">Lender/Provider</th>
						<th colspan="2" class="nosort">Borrower/Recipient</th>
						<th colspan="2" class="nosort">Original Currency</th>
						<th rowspan="2">USD Equivalent</th>
						<th rowspan="2">Derivatives</th>
					  </tr>
					  <tr>
						<th>Legal Entity</th>
						<th>Country</th>
						<th>Legal Entity</th>
						<th>Country</th>
						<th>Currency</th>
						<th>Amount</th>
	
					  </tr>
					</thead>
						
					<tbody>
						<c:forEach var="legDetails" items="${attachmentLegs}" varStatus="status">
							<tr>
								<td><input type='checkbox' value='${legDetails.legNumber}' name='selectedLegForAttachment'></td>
								<td>${legDetails.legSeqId}</td>
								<td>${legDetails.productType}</td>
								<td>${legDetails.termsInMths}</td>
								<td>${legDetails.lenderLegalEntity}</td>
								<td>${legDetails.lenderCountry}</td>
								<td>${legDetails.borrowerLegalEntity}</td>
								<td>${legDetails.borrowerCountry}</td>
								<td>${legDetails.originalCurrency}</td>
								<td>${legDetails.originalAmount}</td>
								<td>${legDetails.usdEquivalent}</td>
								<td>${legDetails.derivatives}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<label class="checkbox apply-to-all">
			<input type="checkbox" name="applyAttachmentToAllLegs" value="true">Apply this Attachment to all Legs
		</label>
		
		<h2>2. Attachment document</h2>
		<div class="row">
			<div class="span4">
				<div class="form-row">
		 			<div id='field3'>
		 				<input type='file' id="multiLegAttachmentFile" name='attachmentFile'  class='input-file3' data-url='' renderStyle=''/>
		 			</div>
				</div>
			</div> <!-- end of block -->
		</div>
	</div>
	
	<div class="modal-footer">
		<a class="btn right btn-success" id="multiLegAttachmentSubmit">Save</a>
		<a href="#" class="btn-link right cancel" onclick="javascript:closeMultiLegAttachmentModal()">Close window</a>
	</div>
</div>