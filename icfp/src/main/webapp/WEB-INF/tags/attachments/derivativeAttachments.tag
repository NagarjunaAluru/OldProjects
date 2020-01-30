<%@ attribute name="mode" required="false"%>
<%@ attribute name="legIndex" required="true"%>
<%@ attribute name="derivativeIndex" required="true"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.fileupload.js"></script>

<div class="row">
	<div class="span12">
	 	<table class="table table-striped table-bordered no-bottom">
			<thead>
		  		<tr>
					<th class="legCol1">Type</th>
					<th>Documents</th>
				<!-- 	<th class="legCol3">Comments</th> -->
					<th class="legCol4">Attach<br />
						<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
					</th>
		  		</tr>
			</thead>
			<tbody>
				<c:set var="derivativeAtmtPermissions" value="${atmtfunctions:getLegAttachmentPermissions(9, legIndex, pageContext.request)}" />
				<c:if test="${derivativeAtmtPermissions.viewable}">
					<tr>
						<td>
							<c:if test="${derivativeAtmtPermissions.mandatory}">
								<span class="required">*</span>
							</c:if>
							Derivative Attachments
						</td>
	
						<td>
							<div class="icfpAttachmentArea">
								<c:set var="derivativeAttachmentsList" value="${atmtfunctions:getDerivativeAttachments(derivativeIndex, legIndex, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty derivativeAttachmentsList}">
										<c:forEach var="derivativeAttachment" items="${derivativeAttachmentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && derivativeAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${derivativeAttachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${derivativeAttachment.geFileId}' class='attachment-link'>${derivativeAttachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
						</td>
						
						<%--<td>
						 	<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && derivativeAtmtPermissions.editable}">
									<b><span class="required">*</span> Comment if no attachment</b> 
									<input type="hidden" name="atmtCommentType"  value="1" />
									<textarea class="span3" name="atmtComment" id="atmtCommentType1" tabindex="3" cols="35" rows="2" onkeyup="limit(this,500,'count1');" onkeydown="limit(this,500,'count1');" onblur="scriptInjection(this);limit(this,500,'count1');"
										onfocus="limit(this,500,'count1');" style="overflow: hidden;"></textarea>
								</c:when>
								<c:otherwise>
									-
								</c:otherwise>
							</c:choose>
						</td> --%>
						
						<td>
							<c:choose>
								<c:when test="${(not empty mode) && mode == 'edit' && derivativeAtmtPermissions.editable}">
									<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=9&legIndex=${legIndex}&derivativeIndex=${derivativeIndex}" />
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