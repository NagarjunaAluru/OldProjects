<%@ attribute name="mode" required="false"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.fileupload.js"></script>

<h3>Deal Attachments</h3>

<div class="row">
	<div class="span12">
		<table class="table table-striped table-bordered no-bottom">
			<thead>
				<tr>
					<th class="legCol1">Type</th>
					<th>Documents</th>
					<th class="legCol3">Comments</th>
					<th class="legCol4">Attach<br /> <span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span></th>
				</tr>
			</thead>

			<tbody>
				<c:set var="dealAttachmentTypeComments" value="${atmtfunctions:getAllDealAttachmentTypeComments(pageContext.request)}" />
				
				<c:set var="cashMapAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(1, pageContext.request)}" />
				<c:if test="${cashMapAtmtPermissions.viewable}">
					<tr>
						<td>
							 <logic:messagesPresent property="error.atmt.type1.deal">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${cashMapAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Cash Map(s) <span class="ttip info" data-original-title="<bean:message key="tooltip.attachments.cashMap" />"></span>
						</td>
	
						<td>
							<div id='Cash_Map' class="icfpAttachmentArea">
								<c:set var="cashMapAttachmentsList" value="${atmtfunctions:getDealAttachments(1, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty cashMapAttachmentsList}">
										<c:forEach var="cashMapAttachment" items="${cashMapAttachmentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && cashMapAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${cashMapAttachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${cashMapAttachment.geFileId}' class='attachment-link'>${cashMapAttachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && cashMapAtmtPermissions.editable}">
									<c:if test="${cashMapAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtCommentType"  value="1" />
									<textarea class="span3" name="atmtComment" id="atmtCommentType1" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${dealAttachmentTypeComments[1]}</textarea>
								</c:when>
								<c:otherwise>
									${dealAttachmentTypeComments[1]}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && cashMapAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=1" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>
				
				<c:set var="structuredAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(2, pageContext.request)}" />
				<c:if test="${structuredAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type2.deal">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${structuredAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Structure Diagram(s)
						</td>
						
						<td>
							<div id='Structured_Diagram' class="icfpAttachmentArea">
								<c:set var="structuredAttachmentsList" value="${atmtfunctions:getDealAttachments(2, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty structuredAttachmentsList}">
										<c:forEach var="structuredAttachment" items="${structuredAttachmentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && structuredAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${structuredAttachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${structuredAttachment.geFileId}' class='attachment-link'>${structuredAttachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${not empty mode && mode == 'edit' && structuredAtmtPermissions.editable}">
									<c:if test="${structuredAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtCommentType"  value="2" />
									<textarea class="span3" name="atmtComment" id="atmtCommentType2" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${dealAttachmentTypeComments[2]}</textarea>
								</c:when>
								<c:otherwise>
									${dealAttachmentTypeComments[2]}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${not empty mode && mode == 'edit' && structuredAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=2" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:if>

				
				<c:set var="equityPitchAtmtPermissions" value="${atmtfunctions:getAttachmentPermissions(11, pageContext.request)}" />	
				<c:if test="${equityPitchAtmtPermissions.viewable}">
					<tr>
						<td>
							<logic:messagesPresent property="error.atmt.type11.deal">
								<span class="req-error" >-</span>
						  	</logic:messagesPresent>
							<c:if test="${equityPitchAtmtPermissions.mandatory}">
								&nbsp;<span class="required">*</span>&nbsp;
							</c:if>
							Equity Pitch
						</td>
	
						<td>
							<div id="Equity_Pitch" class="icfpAttachmentArea">
								<c:set var="equityPitchAttachmentsList" value="${atmtfunctions:getDealAttachments(11, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty equityPitchAttachmentsList}">
										<c:forEach var="equityPitchAttachment" items="${equityPitchAttachmentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && equityPitchAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${equityPitchAttachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${equityPitchAttachment.geFileId}' class='attachment-link'>${equityPitchAttachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${not empty mode && mode == 'edit' && equityPitchAtmtPermissions.editable}">
									<c:if test="${equityPitchAtmtPermissions.mandatory}">
										<span class="required">*</span>
									</c:if>
									<b>Comment if no attachment</b> 
									<input type="hidden" name="atmtCommentType"  value="11" />
									<textarea class="span3" name="atmtComment" id="atmtCommentType11" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;">${dealAttachmentTypeComments[11]}</textarea>
								</c:when>
								<c:otherwise>
									${dealAttachmentTypeComments[11]}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${not empty mode && mode == 'edit' && equityPitchAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=11" />
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
