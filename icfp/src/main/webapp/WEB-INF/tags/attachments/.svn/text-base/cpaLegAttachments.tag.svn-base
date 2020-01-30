<%@ attribute name="mode" required="false"%>
<%@ attribute name="legIndex" required="false"%>
<%@ attribute name="showUWFile" required="false"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.fileupload.js"></script>

<c:if test="${empty legIndex}">
	<c:set var="legIndex" value="1"/>
</c:if>

<h3>Leg Attachments</h3>
<div class="row">
	<div class="span12">
	 	<table class="table table-striped table-bordered no-bottom">
			<thead>
		  		<tr>
					<th class="legCol1">Type</th>
					<th>Documents</th>
					<th class="legCol3">Comments</th>
					<th class="legCol4">Attach<br />
						<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
					</th>
		  		</tr>
			</thead>
			<tbody>
				<c:set var="legAttachmentTypeComments" value="${atmtfunctions:getLegAllAttachmentTypeComments(legIndex, pageContext.request)}" />
				
				<%-- Rendering Legal Agreements --%>
				<c:set var="legalAgAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(3, legIndex, pageContext.request)}" />
				<c:if test="${legalAgAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type3.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${legalAgAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							Legal Agreements(s)
						</td>
							
						<td>
							<div id="Legal_Agreements" class="icfpAttachmentArea">
								<c:set var="legalAgreementsList" value="${atmtfunctions:getLegAttachments(3, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty legalAgreementsList}">
										<c:forEach var="legalAgreement" items="${legalAgreementsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && legalAgAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${legalAgreement.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${legalAgreement.geFileId}' class='attachment-link'>${legalAgreement.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && legalAgAtmtPermissions.editable}">
									<c:if test="${legalAgAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="3" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[3]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[3]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && legalAgAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=3&legIndex=${legIndex}" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>	
				
				
				<%-- Consolidated Financial Statements --%>	
				<c:set var="csfAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(4, legIndex, pageContext.request)}" />
				<c:if test="${csfAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type4.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${csfAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if> 
							Consolidated Financial Statements
						</td>
							
						<td>
							<div id="Consolidated_Financial_Statements" class="icfpAttachmentArea">
								<c:set var="financialStatementsList" value="${atmtfunctions:getLegAttachments(4, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty financialStatementsList}">
										<c:forEach var="financialStatement" items="${financialStatementsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && csfAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${financialStatement.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${financialStatement.geFileId}' class='attachment-link'>${financialStatement.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && csfAtmtPermissions.editable}">
									<c:if test="${csfAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="4" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[4]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[4]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && csfAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=4&legIndex=${legIndex}" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>
				
				<%-- Corporate Governance Documents --%>	
				<c:set var="cgdAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(5, legIndex, pageContext.request)}" />
				<c:if test="${cgdAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type5.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${cgdAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Corporate Governance Documents<span class="ttip info" data-original-title="<bean:message key="tooltip.attachmetns.corporateGovDoc" />"></span>
						</td>
							
						<td>
							<div id="Corporate_Governance_Documents" class="icfpAttachmentArea">
								<c:set var="corporateGovernanceList" value="${atmtfunctions:getLegAttachments(5, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty corporateGovernanceList}">
										<c:forEach var="corporageGovernance" items="${corporateGovernanceList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && cgdAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${corporageGovernance.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${corporageGovernance.geFileId}' class='attachment-link'>${corporageGovernance.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && cgdAtmtPermissions.editable}">
									<c:if test="${cgdAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="5" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[5]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[5]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && cgdAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=5&legIndex=${legIndex}" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>
				
				<%-- Transfer Pricing Attachment(s) --%>	
				<c:set var="tpAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(8, legIndex, pageContext.request)}" />
				<c:if test="${tpAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type8.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${tpAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Transfer Pricing Attachment(s)
						</td>
							
						<td>
							<div id="Transfer_Pricing" class="icfpAttachmentArea">
								<c:set var="transferPricingList" value="${atmtfunctions:getLegAttachments(8, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty transferPricingList}">
										<c:forEach var="transferPricing" items="${transferPricingList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && tpAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${transferPricing.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${transferPricing.geFileId}' class='attachment-link'>${transferPricing.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && tpAtmtPermissions.editable}">
									<c:if test="${tpAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="8" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[8]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[8]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && tpAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=8&legIndex=${legIndex}" />
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
				<th >Documents</th>
				<th class="legCol3">Comments</th>
				<th class="legCol4">Attach<br />
					<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
				</th> 
			  </tr>
			</thead>
			<tbody>
				
				<%-- Under Writing File --%>
				<c:set var="uwAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(21, pageContext.request)}" />
				<c:if test="${showUWFile == true && uwAtmtPermissions.viewable}">
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

<%-- Journal Entries --%>
				<c:set var="journalAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(7, legIndex, pageContext.request)}" />
				<c:if test="${journalAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type7.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${journalAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Journal Entries
						</td>
							
						<td>
							<div id="Journal_Entries" class="icfpAttachmentArea">
								<c:set var="journalDocumentsList" value="${atmtfunctions:getLegAttachments(7, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty journalDocumentsList}">
										<c:forEach var="journalDocument" items="${journalDocumentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && journalAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${journalDocument.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${journalDocument.geFileId}' class='attachment-link'>${journalDocument.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && journalAtmtPermissions.editable}">
									<c:if test="${journalAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="7" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[7]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[7]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && journalAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile'  data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=7&legIndex=${legIndex}" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>
				
				<%-- Other Documents --%>
				<c:set var="otherAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(6, legIndex, pageContext.request)}" />
				<c:if test="${otherAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type6.leg${legIndex}">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${otherAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Other Documents
						</td>
							
						<td>
							<div id="Other_Documents" class="icfpAttachmentArea">
								<c:set var="otherDocumentsList" value="${atmtfunctions:getLegAttachments(6, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty otherDocumentsList}">
										<c:forEach var="otherDocument" items="${otherDocumentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && otherAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${otherDocument.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${otherDocument.geFileId}' class='attachment-link'>${otherDocument.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && otherAtmtPermissions.editable}">
									<c:if test="${otherAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtLegNumber" value="${legIndex}" />
									<input type="hidden" name="atmtLegCommentType"  value="6" />
									<textarea class="span3" name="atmtLegComment" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${legAttachmentTypeComments[6]}</textarea>
								</c:when>
								<c:otherwise>
									${legAttachmentTypeComments[6]}
								</c:otherwise>
							</c:choose>
						</td>
	
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && otherAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=6&legIndex=${legIndex}" />
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