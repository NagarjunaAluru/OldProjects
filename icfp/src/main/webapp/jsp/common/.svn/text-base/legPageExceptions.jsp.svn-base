<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>

<c:set var="mode" value="${fn:toUpperCase(param.mode)}" />

<div class="${(mode == 'EDIT') ? 'exceptions-conditional' : ''} attachments-mod" id="${(mode == 'EDIT') ? 'exceptionDiv' : 'exceptionDivView'}">
	<c:set var="exceptionList" value="${deal:getExceptions(param.legIndex, pageContext.request)}" />
	<c:set var="attachmentPermissions" value="${atmtfunctions:getLegAttachmentPermissions(10, param.legIndex, pageContext.request)}" />
	<input type="hidden" id="exceptionLegIndex" name="exceptionLegIndex" value="${param.legIndex}" />
	<c:choose>
		<c:when test="${mode eq 'EDIT' and not empty exceptionList}">
			<input type="hidden" id="newExceptionIndex" name="newExceptionIndex" value="${fn:length(exceptionList) + 1}" />
		</c:when>
		<c:when test="${mode eq 'EDIT' and empty exceptionList}">
			<input type="hidden" id="newExceptionIndex" name="newExceptionIndex" value="2" />
		</c:when>
	</c:choose>
	
	
	<h2 class="span12">Exceptions</h2>
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered ${(mode == 'EDIT') ? 'exceptions exceptions-nested exception-validation' : ''}">
				<thead>
				  <tr>
				  	<c:if test="${mode eq 'EDIT'}">
				  		<th colspan="1">Actions</th>
				  	</c:if>
					<th>Standard Terms &amp; Conditions</th>
					<th>Exception Requested</th>
					<th>Rationale for Exception</th>
					<th>Exception Timeline</th>
					<th>Remediation Timeline</th>
				  </tr>
				</thead>
				
				<tbody>
					<c:if test="${not empty exceptionList}">
						<c:forEach var="exceptionDetails" items="${exceptionList}" varStatus="exceptionStatus">
							<tr>
								<c:if test="${mode eq 'EDIT'}">
									<td rowspan="3">
										<input type="hidden" name="exceptionIndex" value="${exceptionStatus.count}" />
										<a href="javascript:void(0);" id="deleteException" title="Delete this exception" class="deleteException-tr delete-tr">X</a>
									</td>	
								</c:if>
								
										
								<td>
									<div class="form-row autosize-container small">
										<span class="required">*</span>
										<label>Terms &amp; Conditions</label>
										<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<select  name="standardTermsConditionsId" class="span2 request-exp">
													<option value="">Select..</option>
													<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].termsAndConditions}" var="option">
														<c:choose>
															<c:when test="${exceptionDetails.standardTermsConditionsId == option.ID}">
																<option value="${option.ID}" selected='selected'>${option.name}</option>
															</c:when>
															<c:otherwise>
																<option value="${option.ID}">${option.name}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</c:when>
											<c:otherwise>
												<select  name="standardTermsConditionsId" class="span2 request-exp" disabled="disabled">
													<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].termsAndConditions}" var="option">
														<c:choose>
															<c:when test="${exceptionDetails.standardTermsConditionsId == option.ID}">
																<option value="${option.ID}" selected='selected'>${option.name}</option>
															</c:when>
															<c:otherwise>
																<option value="${option.ID}">${option.name}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
								
								<td>
									<div class="form-row autosize-container small">
										<span class="required">*</span>
										<label>Exceptions</label>
										<div class="char-count">500</div>
										<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<textarea class="span4 autosize messageinput request-exp" name="requestedException" rows="4" onblur="scriptInjection(this);">${exceptionDetails.requestedException}</textarea>
											</c:when>
											<c:otherwise>
												<textarea class="span4 autosize messageinput request-exp" name="requestedException" rows="4" onblur="scriptInjection(this);" disabled="disabled">${exceptionDetails.requestedException}</textarea>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
								
								<td>
									<div class="form-row autosize-container small">
										<span class="required">*</span>
										<label>Impact</label>
										<div class="char-count">500</div> 
										<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<textarea class="span4 autosize messageinput request-exp" name="rationaleForExceptionImpact" rows="4" onblur="scriptInjection(this);">${exceptionDetails.rationaleForExceptionImpact}</textarea>
											</c:when>
											<c:otherwise>
												<textarea class="span4 autosize messageinput request-exp" name="rationaleForExceptionImpact" rows="4" onblur="scriptInjection(this);" disabled="disabled">${exceptionDetails.rationaleForExceptionImpact}</textarea>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="form-row autosize-container small">
										<label>Potential alternatives</label>
										<div class="char-count">500</div>
										<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<textarea class="span4 autosize messageinput " name="rationaleForExceptionPotentialAlternatives" rows="4" onblur="scriptInjection(this);">${exceptionDetails.rationaleForExceptionPotentialAlternatives}</textarea>
											</c:when>
											<c:otherwise>
												<textarea class="span4 autosize messageinput " name="rationaleForExceptionPotentialAlternatives" rows="4" onblur="scriptInjection(this);" disabled="disabled">${exceptionDetails.rationaleForExceptionPotentialAlternatives}</textarea>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
										
								<td>
									<div class="form-row autosize-container small">
										<span class="required">*</span>
										<label>Timeline</label>
										<div id="exceptRadioDiv" class="radio-container">
											<label class="radio">
												<c:choose>
													<c:when test="${exceptionDetails.exceptionTimelineId eq 1}">
														<c:choose>
															<c:when test="${mode eq 'EDIT'}">
																<input type="radio" name="exceptionTimelineId[${exceptionStatus.count}]" value="1" checked="checked">
															</c:when>
															<c:otherwise>
																<input type="radio" value="1" checked="checked" disabled="disabled">
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${mode eq 'EDIT'}">
																<input type="radio" name="exceptionTimelineId[${exceptionStatus.count}]" value="1">
															</c:when>
															<c:otherwise>
																<input type="radio" value="1" disabled="disabled">
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
												Permanent
											</label>  
											<label class="radio">
												<c:choose>
													<c:when test="${exceptionDetails.exceptionTimelineId eq 2}">
														<c:choose>
															<c:when test="${mode eq 'EDIT'}">
																<input type="radio" name="exceptionTimelineId[${exceptionStatus.count}]" value="2" checked="checked">
															</c:when>
															<c:otherwise>
																<input type="radio" value="2" checked="checked" disabled="disabled">
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${mode eq 'EDIT'}">
																<input type="radio" name="exceptionTimelineId[${exceptionStatus.count}]" value="2">
															</c:when>
															<c:otherwise>
																<input type="radio" value="2" disabled="disabled">
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
												Temporary
											</label>
										</div>
									</div>
								</td>
										
								<td>
									<div class="form-row autosize-container small">
										<span class="required">*</span>
										<label>Comments</label>
										<div class="char-count">500</div>
										<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<textarea class="span4 autosize messageinput request-exp" name="remediationTimelineComments" rows="4" onblur="scriptInjection(this);">${exceptionDetails.remediationTimelineComments}</textarea>
											</c:when>
											<c:otherwise>
												<textarea class="span4 autosize messageinput request-exp" name="remediationTimelineComments" rows="4" onblur="scriptInjection(this);" disabled="disabled">${exceptionDetails.remediationTimelineComments}</textarea>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="form-row autosize-container small">
										<c:if test="${exceptionDetails.exceptionTimelineId eq 2}">
											<span class="required">*</span>
										</c:if>
	                                  	<label>Estimated Timeframe</label>
	                                  	<c:choose>
											<c:when test="${mode eq 'EDIT'}">
												<input type="text" name="remediationTimeline" class="left span16 requestdatepicker-field request-exp" value="${exceptionDetails.remediationTimeline}"/>
											</c:when>
											<c:otherwise>
												<input type="text" name="remediationTimeline" class="left span16 requestdatepicker-field request-exp" value="${exceptionDetails.remediationTimeline}" disabled="disabled"/>
											</c:otherwise>
										</c:choose>
	                                    <span class="help-block clear right">MM/DD/YYYY</span>
									</div>
								</td>
							</tr>
							
							<tr class="attachment-nested">
								<td colspan="3">
									Document
								</td>
								<td colspan="4">
									Attach new<br>
									<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
								</td>
							</tr>
							
							<tr>
								<td colspan=3>
									<div class="icfpAttachmentArea">
										<c:forEach var="attachment" items="${exceptionDetails.attachments}">
											<div class="icfpAttachment">
												<c:if test="${attachmentPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${attachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${attachment.geFileId}' class='attachment-link'>${attachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</div>
								</td>
								
								<td colspan='4'>
									<c:choose>
										<c:when test="${attachmentPermissions.editable}">
											<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=10&legIndex=${param.legIndex}&exceptionIndex=${exceptionStatus.count}" />
										</c:when>
										<c:otherwise>
											<input type='file' name='attachmentFile' disabled="disabled" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					
					
					<c:if test="${mode eq 'EDIT' and empty exceptionList}">
						<tr>
							<td rowspan="3">
								<input type="hidden"  id="exceptionIndex" name="exceptionIndex" value="1"/>
								<a href="javascript:void(0);" id="deleteException" title="Delete this exception" class="deleteException-tr delete-tr">X</a>
							</td>
							
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Terms &amp; Conditions</label>
									<select  name="standardTermsConditionsId" class="span2 request-exp">
										<option value="">Select..</option>
										<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].termsAndConditions}" var="option">
											<option value="${option.ID}">${option.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
								
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Exceptions</label>
									<div class="char-count">500</div>
									<textarea class="span4 autosize messageinput request-exp" name="requestedException" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</td>
								
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Impact</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput request-exp" name="rationaleForExceptionImpact" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
								
								<div class="form-row autosize-container small">
									<label>Potential alternatives</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput " name="rationaleForExceptionPotentialAlternatives" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</td>
								
							<td>	
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Timeline</label>
									<div id="exceptRadioDiv" class="radio-container">
										<label class="radio">
											<input type="radio" name="exceptionTimelineId[1]" value="1">
											Permanent
										</label>
										<label class="radio">
											<input type="radio" name="exceptionTimelineId[1]" value="2">
											Temporary
										</label>
									</div>
								</div>
							</td>
								
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Comments</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput request-exp" name="remediationTimelineComments" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
								
								<div class="form-row">
	                            	<span class="required">*</span>
	                                <label>Estimated Timeframe</label>
	                                <!-- <span class="request-exp" id="" >a</span> -->
	                                <input type="text" name="remediationTimeline" class="left span16 requestdatepicker-field request-exp"/>                                   
	                                    <span class="help-block clear right">MM/DD/YYYY</span>
	                          	</div>                                	
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								Document
							</td>
							<td colspan="4">
								Attach new<br>
								<span class="small">Preferred file types: .ppt, .pptx, .doc, .docx, .zip, .xls .xlsx</span>
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								<div class="icfpAttachmentArea">
								</div>
							</td>
							<td colspan="4">
								<input type='file' class="icfpFileupload" name='attachmentFile' renderStyle='replace' data-url="${pageContext.request.contextPath}/attachmentAction.do?command=upload&type=10&legIndex=${param.legIndex}&exceptionIndex=1" />
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			
			
			<c:if test="${mode eq 'EDIT'}">
		 		<a href="javascript:void(0)" class="left add-exception" >Add additional exception</a>
		 	</c:if> 
		</div>
	</div> 
</div><!-- end of form form-mod -->