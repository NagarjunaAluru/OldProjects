<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/common/issuance.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/issuance.js" type="text/javascript"></script>
	
		<div class="clear"></div>
			<c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>	
			</c:if>
			<c:if test="${not empty requestScope.successMsg}" >
				<div id="siteMsg">
		            <div class="sucessMsg">
		            	<a href="javascript:;" class="right successclose" style="margin-right:5px;">X</a>Success
		            </div>
		            <div class="sucessContent"><s:property value="#request.successMsg" /></div>
		        </div>
  			</c:if>
	     <s:if test="fieldErrors.size > 0">
				<div class="row">
					<div class="span12">
						<div class="errorbox">
							<div class="errorHead">
								<p class="erroricon">Error</p>
							</div>
							<div class="errorContent">
								<p>
									<s:fielderror/>
								</p>
								<p>&nbsp;</p>
							</div>
						</div>
					</div>
				</div>
			</s:if>	
	<div class="form-mod">		
	   <div class="row">
	        <div class="span12">
			      <div class="form-row">
				       <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2'}">
							 <h3><s:text name="label.request.downloadDocumentation" />
							 <p><s:text name="label.request.selectDocumentsToDownload" /></p></h3>
					 </c:if>
					 <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4'}">
					        <h3 class="dashdesc"><s:text name="label.request.alocRecNo" /> <s:property value="requestDetails.alocRecordId"/> -<s:text name="label.request.downloadDocumentation" /></h3>
			         </c:if>
			         <c:if test="${requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
					      <h3 class="dashdesc" style="margin-left:10px!important;"><s:text name="label.request.alocRecNo" />:&nbsp;<s:property value="requestDetails.alocRecordId"/>&nbsp;- &nbsp;<s:text name="label.request.downloadDocumentation" /></h3>
			        </c:if>
		        </div>
			</div>	
	   </div>
	</div>
	
	<div class="clear"></div>
		<div class="row graybg1" style="margin-left:-10px;">
		  <s:form id="downloadRequestPDFFormId" action="taxonomyDownloadRequestPDF" namespace="/int/approver" onsubmit="return validateAttachment();">
		   <s:hidden name="issuerRadioOption" id="issuerRadioOptionId"/>
		   <s:hidden name="optionsRadiosp" id="optionsRadiospId"/>
		   <s:hidden name="taxonomyViewType" id="taxonomyViewType"/>
		   <div class="span12">
		         <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4' || requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
							<div class="row">
								<div class="span12">
									<p><s:text name="label.request.selectDocumentsToDownload" /></p>
								</div>
							</div>
					</c:if>
				<div class="row">
					<div class="span12">
					</div>
				</div>
				<div class="row">
					<div class="span2 grbg">
						<div class="form-row">
							<img src="${pageContext.request.contextPath}/img/pdf.png" width="50px" height="59px" />
							<label class="checkbox">
                                 <input type="checkbox" name=""  id="selectall"/><s:text name="label.request.downloadAll" /><br />
                            </label>
						</div>
					</div>
			        <div class="span9a left whitebg1">
						<div class="form-row">
								<div class="span2 left">
								<img src="${pageContext.request.contextPath}/img/pdf.png" width="50px" height="59px"/>
								<br/>
								<label class="checkbox">
								    <input type="checkbox" name="downloadDocs" id="application" value="Application" class="case" />
									<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">
											<s:text name="label.request.applicationAndReimbursement" />
									</c:if>
									<c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '6'|| requestDetails.instrumentTypeId eq '4' }">
											<s:text name="label.request.applicationPdf" />
									</c:if>
									<c:if test="${requestDetails.instrumentTypeId eq '5'}"><s:text name="label.request.application" /></c:if>
                                </label>
								</div>
								<c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '6'}">
									<div class="span2a left">
									<img src="${pageContext.request.contextPath}/img/memo.png" width="50px" height="59px" />
									<br/>
									<label class="checkbox">
	                                        <input type="checkbox" name="downloadDocs" value="CSVApplication" class="case" /><s:text name="label.request.applicationinCsv" />
	                                </label>
									</div>
								</c:if>
								<c:if test="${issuerDownloadAtmts}">
									<c:if test="${not empty requestDetails.instrumentTypeId}">
										<div class="span1a left">
										<img src="${pageContext.request.contextPath}/img/attach.png" width="50px" height="59px" />
										<br/>
										<label class="checkbox">
		                                        <input type="checkbox" name="downloadDocs" id="applicationAttachments" value="Attachments" class="case" /> <s:text name="label.request.applicationAttachments" />
		                                </label>
										</div>
									</c:if>
								</c:if>
							   <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '4'}">
									<div class="span2 left">
									<img src="${pageContext.request.contextPath}/img/memo.png" width="50px" height="59px"/>
									<br/>
									<label class="checkbox">
											<input type="checkbox" name="downloadDocs" id="BidReply" value="BidMemo BidReply" class="case" /><s:text name="label.request.bidMemoAndBidReply" />&nbsp;<s:text name="label.request.inPdf" />
	                                </label>
									</div>
								</c:if>
								<c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4'}">
									<div class="span1a left">
									      <img src="${pageContext.request.contextPath}/img/format.png" width="50px" height="59px" />
									      <br/>
									        <label class="checkbox">
	                                           <input type="checkbox" name="downloadDocs" id="Format" value="Format" class="case" /> <s:text name="label.request.bglocSectionName.7" />&nbsp;<s:text name="label.request.ofInstrument" />
	                                       </label>
									</div>
							  </c:if>	
							  <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '6'}">
								  <div class="span2 left">
									<img src="${pageContext.request.contextPath}/img/pdf.png" width="50px" height="59px"/>
									<br/>
									<label class="checkbox">
											<input type="checkbox" name="downloadDocs" id="TreasuryApprover" value="TreasuryApprover" class="case" /> <s:text name="label.request.Treasury" />&nbsp;<s:text name="label.request.approvalInformation" />
	                                </label>
									</div>	
							 </c:if>					
						</div>
					</div>
				</div>
					<hr style="border-top: 1px solid #999; margin-right:30px;" />
					<div class="row">
						<div class="span12">
							<div class="form-row">
								 <s:submit key="label.request.Download" cssClass="btn dwn1" />
							</div>
						</div>
					</div>
				</div>		
		</s:form>
  </div>	
   
   <!-- Including Documentation.jsp  -->
   <s:form id="issuerSubmitForm" action="issuerSave" namespace="/int/approver"> 
	<s:hidden id="taxonomyViewType" name="taxonomyViewType" ></s:hidden>
	<s:hidden id="actionTypeId" name="actionType" value="22" />
	<input type="hidden" name="returnToPage" value="${returnToPage}">
	<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
   <div class="form-mod">
		<div class="row">	  
		   <div class="span12">
			   <jsp:include page="instrumentDocumentationReadOnly.jsp"/>
		  </div>
		</div>
   </div> 
   <div class="clear"></div>
	    <div class="highlighted">
	    	<hwfs:checkComponentPermission name="TransactionsHistoryAccess" domainName="BusinessAccess">
		    	<s:submit key="label.request.common.save"  cssClass="btn"></s:submit>
		    </hwfs:checkComponentPermission>
		    <a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
	    </div>
   </s:form>
	<div class="modal hide fade" id="completeIssuanceRequest">
	<s:hidden id="completeIssuanceTextAreaId" name="completeIssuanceTextAreaId" value=""/>
	<s:hidden id="issuanceGeLibFileId" name="issuanceGeLibFileId" value="" />
	<s:hidden id="issuanceTypeId" name="issuanceTypeId" value="" />
	<s:hidden id="issuanceIndexId" name="issuanceIndexId" value="" />
			<div class="modal-header"> 
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.request.thisActionCannotbeUndone"/> </span></h3>
			</div>
			<div class="modal-body">		
			<p><s:text name="label.request.issuanceTextAreaConfirm"/></p>
	           
	           <h3><s:text name="label.request.thisActionCannotbeUndone"/></h3>
			</div>
			<div class="modal-footer">
			<hwfs:checkComponentPermission name="TransactionsHistoryAccess" domainName="BusinessAccess">
			<a data-dismiss="modal" href="javascript:void(0);" onclick="openTextareaSection()" class="left btn-primary">
				  <s:text name="label.request.continue"/>
		    </a>
		    </hwfs:checkComponentPermission>			    
		    <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>					  		
			</div>
	</div>
	<div class="modal hide fade" id="atmtConfirmModal">
	<s:hidden id="modelGeLibFileId" name="modelGeLibFileId" value="" />
	<s:hidden id="modelTypeId" name="modelTypeId" value="" />
	<s:hidden id="modalIndexId" name="modalIndexId" value="" />
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.attachment.attachmentConfirm"/></span></h3>
			</div>
			<div class="modal-body">
				<p><s:text name="label.attachment.attachmentDataClear"/></p>
			</div>
			<div class="modal-footer">
				<hwfs:checkComponentPermission name="TransactionsHistoryAccess" domainName="BusinessAccess">
				<a data-dismiss="modal" href="javascript:void(0);" onclick="issuanceAtmtdeleteConfirm();" class="left btn-primary"  id="saveSelectionlb">
					 <s:text name="label.attachment.attachmentDeleteMessage"/>
					</a>
				</hwfs:checkComponentPermission>		
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
			</div>			
	</div>
	<div class="modal hide fade" id="attachmentErrorModal"  style="top:200px;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.attachment.attachmentError"/></span></h3>
			</div>
			<div class="modal-body">
				<p></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
			</div>			
	</div> 