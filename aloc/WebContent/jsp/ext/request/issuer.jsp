<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
    
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<c:if test="${requestDetails.instrumentTypeId eq '1'}">
		<title><s:text name="label.request.issuerBankGuarantee" /></title>
	</c:if>
	<c:if test="${requestDetails.instrumentTypeId eq '2'}">
		<title><s:text name="label.request.issuerStandbyLetterofCredit" /></title>	
	</c:if>
	<c:if test="${requestDetails.instrumentTypeId eq '3'}">
	<title><s:text name="label.request.issuerSuretyBond" /></title>
	</c:if>
	<c:if test="${requestDetails.instrumentTypeId eq '4'}">
	<title><s:text name="label.request.issuerConfirmationofDloc" /></title>
	</c:if>
	<c:if test="${requestDetails.instrumentTypeId eq '5'}">
	<title><s:text name="label.request.issuerAmendment" /></title>
	</c:if>
	<c:if test="${requestDetails.instrumentTypeId eq '6'}">
	<title><s:text name="label.request.issuerSuretyRider" /></title>
	</c:if>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/ext/public/css/common/issuance.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ext/public/requestor/bidReply.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/issuance.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			jQuery('#issuerSubmitForm').preventDoubleSubmit();
	});
    </script> 
 </head>

<body>
	
   <div class="container main">
	 <%@include  file="/jsp/ext/common/headerSection.jsp" %>
	 <div id="mainPage">
		<c:if test="${requestDetails.instrumentTypeId eq '1'}">
			<h1 class="page-title span12"><s:text name="label.request.issuerBankGuarantee" /></h1>
				<p class="span12 left clear dashdesc"><!--The below bid response has been provided for Treasury review.--></p>
		<hr class="page-title-hr">
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '2'}">
			<h1 class="page-title span12"><s:text name="label.request.issuerStandbyLetterofCredit" /></h1>
				<p class="span12 left clear dashdesc"><!--The below bid response has been provided for Treasury review.--></p>
		<hr class="page-title-hr">
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '3'}">
			<h1 class="page-title span12"><s:text name="label.request.issuerSuretyBond" /></h1>
			 <p class="span12 left clear dashdesc">
		<hr class="page-title-hr">
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '4'}">
		      <h1 class="page-title span12"><s:text name="label.request.issuerConfirmationofDloc" /></h1>
				<p class="span12 left clear dashdesc"><s:text name="label.request.yourBankHasBeenAwardedTheConfirmation" /><br /> </p>
				<p class="span12 left clear dashdesc"></p>
				<p class="span12 left clear dashdesc"><s:text name="label.request.pleaseBeReminded" /></p>
				<hr class="page-title-hr">
			</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '5'}">
			<h1 class="page-title span12"><s:text name="label.request.issuerAmendment" /></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.request.theRequestInfo" /></p>
			<hr class="page-title-hr">
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '6'}">
			<h1 class="page-title span12"><s:text name="label.request.issuerSuretyRider" /></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.request.theRequestBelowForSuretyRiders" /></p>
		<hr class="page-title-hr">
		</c:if>
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
	    <s:hidden name="errorShow" id="errorShowId"/>
		<div class="row hide" id="issuerPageLevelErrorDivId">
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
		<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">
			   <div class="form-mod">
			        <div class="row">
						<div class="span12 request-summary">
							<div class="row lastrow">
								<div class="span10">
									<p class="heading"><s:text name="label.request.requestSummary" /> - <span><s:text name="label.request.alocRecNo" /></span>&nbsp;<s:property value="requestDetails.alocRecordId"/></p>
								</div>
							</div>				
						</div>
					</div>							
					<div class="row">
						<div class="span12">
							<div class="errorbox">
								<div class="noteHead"><p class="noteicon"><s:text name="label.request.notification" /></p></div>
								<div class="noteContent">
										<p><s:text name="label.request.yourBankHasBeenAwarded"/></p>
										<p><s:text name="label.request.beforeNoon" /> :<s:text name="label.request.geRequestsThatTheBankIssue" /></p>
										<p><s:text name="label.request.afterNoon" /> :<s:text name="label.request.issuanceIsExpected" /></p>
										<p><s:text name="label.request.afterIssuance" /> :<s:text name="label.request.bGdocumentationIsRequested" /></p>
								</div>
							</div>
						</div>
					</div>
								
		      </div><!-- end of form form-mod -->
	  </c:if>
	  <c:if test="${requestDetails.instrumentTypeId eq '3'}">
	        <div class="form-mod">
	             <div class="highlighted">
	                  <div class="row">
			                <div class="span12">
				                <p><s:text name="label.request.theFollowingTransaction" /></p>
								<div class="row">
					                 <div class="span1b">
					                 <p><br /></p>
					                 </div>
									 <div class="span1b">
					                  <p><br /><b><s:text name="label.request.note" />:</b></p>
					                </div>
									<div class="span3 wbg">
										<label><s:text name="label.request.beforeNoon" /> </label>
										<p><s:text name="label.request.geRequestsThatTheBankIssue" /></p>
									</div>
									<div class="span3 wbg">
										<label><s:text name="label.request.afterNoon" /></label>
										<p><s:text name="label.request.issuanceIsExpected" /></p>
									</div>
									<div class="span3 wbg">
										<label><s:text name="label.request.afterIssuance" /></label>
										<p><s:text name="label.request.bGdocumentationIsRequested" /></p>
									</div>
				               </div>
			            </div>
		           </div>
		     </div>
	      </div>   
	  </c:if>
	  <c:if test="${requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
	  <div class="form-mod">		
		<div class="row">
			<div class="span12 request-summary">
				<p class="heading"><s:text name="label.request.requestSummary" />  -  <span><s:text name="label.request.alocRecNo" /> </span><s:property value="requestDetails.alocRecordId"/></p>
				<c:if test="${requestDetails.instrumentTypeId eq '5'}">
					<div class="row lastrow">
						<div class="amdspan2a"><div class="right"><label><s:text name="label.apm.bankRefNumber" />:</label></div></div>
						<div class="span3a left"><s:if test="%{requestDetails.winningBankDetails.competingBankDetails!=null && requestDetails.winningBankDetails.competingBankDetails.size>0}">
						 <s:property value="requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber"/>
						</s:if></div>
						<div class="amdspan2a"><div class="right"><label><s:text name="label.amendment.seqNo" /></label></div></div>
						<div class="amdspan3a left"><s:property value="requestDetails.amendment.amendmentRequestId"/></div>
					</div>
					<s:if test="%{requestDetails.winningBankDetails.competingBankDetails!=null && requestDetails.winningBankDetails.competingBankDetails.size>1}">
						<div class="row lastrow">
							<div class="amdspan2a"><div class="right"><label><s:text name="label.request.bankIssuance" />:</label></div></div>
							<div class="amdspan3a left"><s:property value="requestDetails.winningBankDetails.competingBankDetails[1].bankReferenceNumber"/></div>
						</div>
				    </s:if>
					<div class="row lastrow">
						<div class="amdspan2a"><div class="right"><label><s:text name="label.request.benificiaryIssuance" />:</label></div></div>
						<div class="amdspan3a left"><s:if test="%{requestDetails.winningBankDetails.competingBankDetails!=null && requestDetails.winningBankDetails.competingBankDetails.size>0}">
						<s:property value="requestDetails.winningBankDetails.competingBankDetails[0].bankReferenceNumber"/></s:if></div>
					</div>		
				</c:if>	
				<c:if test="${requestDetails.instrumentTypeId eq '6'}">
					<div class="row lastrow">
						<div class="amdspan2a"><div class="right"><label><s:text name="label.request.suretyRefNO" />:</label></div></div>
						<div class="span3a left"><s:property value="requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber"/></div>
						<div class="amdspan2a"><div class="right"><label><s:text name="label.rider.seqNo" /></label></div></div>
						<div class="amdspan3a left"><s:property value="requestDetails.rider.riderRequestId"/></div>
					</div>	
				</c:if>		
			</div>
		</div>
	</div>
 </c:if>
 <s:hidden name="errorShow" id="errorShowId"/>	
				<div class="row hide" id="issuancePageLevelErrorDivId">
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
<div class="form-mod">
	<div class="row">
		 <div class="span12">
			   <div class="form-row">
					<h2><s:text name="label.request.notification.wantTo"/></h2><hr class="h2-hr">
					<br/>
					<div class="radio-container uploadOrDownLoad">
					      <s:radio id="downloadId" cssClass="radio download-condition"
								name="issuerRadioOption" list="#{'download':'Download documentation'}" theme="aloc" />
							<s:radio id="uploadId" cssClass="radio upload-condition"
								name="issuerRadioOption" list="#{'uploaddoc':'Upload documentation'}"
								theme="aloc" />
				     </div>
			  </div>
		</div>
	</div>	
		
   <div class="row downloadDiv">
        <div class="span12">
		      <div class="form-row">
			       <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2'}">
						 <h3><s:text name="label.request.downloadDocumentation" />
						 <p><s:text name="label.request.selectDocumentsToDownload" /></p></h3>
				 </c:if>
				 <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4'}">
				        <h3 class="dashdesc"><s:text name="label.request.alocRecNo" /> <s:property value="requestDetails.alocRecordId"/> -<s:text name="label.request.downloadDocumentation" /></h2><hr class="h2-hr">
		         </c:if>
		         <c:if test="${requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
				      <h3 class="dashdesc" style="margin-left:10px!important;"><s:text name="label.request.alocRecNo" />:&nbsp;<s:property value="requestDetails.alocRecordId"/>&nbsp;- &nbsp;<s:text name="label.request.downloadDocumentation" /></h2><hr class="h2-hr">
		        </c:if>
	        </div>
		</div>	
   </div>
</div>
	
	<div class="clear"></div>
		<div class="row graybg1 downloadDiv" style="margin-left:-10px;">
		  <s:form id="downloadRequestPDFFormId" action="downloadRequestPDF" namespace="/ext/approver" onsubmit="return validateAttachment();">
		  <input type="hidden" name="issuerRadioOption" id="issuerRadioOptionId">
		   <input type="hidden" name="optionsRadiosp" id="optionsRadiospId">
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
							<img src="${pageContext.request.contextPath}/ext/public/img/pdf.png" width="50px" height="59px" />
							<label class="checkbox">
                                 <input type="checkbox" name=""  id="selectall"/><s:text name="label.request.downloadAll" /><br />
                            </label>
						</div>
					</div>
			        <div class="span9a left whitebg1  downloadDiv">
						<div class="form-row">
								<div class="span2 left">
								<img src="${pageContext.request.contextPath}/ext/public/img/pdf.png" width="50px" height="59px"/>
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
									<img src="${pageContext.request.contextPath}/ext/public/img/memo.png" width="50px" height="59px" />
									<br/>
									<label class="checkbox">
	                                        <input type="checkbox" name="downloadDocs" class="case" value="CSVApplication" /><s:text name="label.request.applicationinCsv" />
	                                </label>
									</div>
								</c:if>
								<c:if test="${issuerDownloadAtmts}">	
									<c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '4'  || requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
										<div class="span1a left">
										<img src="${pageContext.request.contextPath}/ext/public/img/attach.png" width="50px" height="59px" />
										<br/>
										<label class="checkbox">
		                                        <input type="checkbox" name="downloadDocs" id="applicationAttachments" value="Attachments" class="case" /> <s:text name="label.request.applicationAttachments" />
		                                </label>
										</div>
									</c:if>
								</c:if>
							   <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '4'}">
									<div class="span2 left">
									<img src="${pageContext.request.contextPath}/ext/public/img/memo.png" width="50px" height="59px"/>
									<br/>
									<label class="checkbox">
											<input type="checkbox" name="downloadDocs" id="BidReply" value="BidMemo BidReply" class="case" /><s:text name="label.request.bidMemoAndBidReply" />&nbsp;<s:text name="label.request.inPdf" />
	                                </label>
									</div>
								</c:if>
								<c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4'}">
									<div class="span1a left">
									      <img src="${pageContext.request.contextPath}/ext/public/img/format.png" width="50px" height="59px" />
									      <br/>
									        <label class="checkbox">
	                                           <input type="checkbox" name="downloadDocs" id="Format" value="Format" class="case" /> <s:text name="label.request.bglocSectionName.7" />&nbsp;<s:text name="label.request.ofInstrument" />
	                                       </label>
									</div>
							  </c:if>	
							  <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '6'}">
								  <div class="span2 left">
									<img src="${pageContext.request.contextPath}/ext/public/img/pdf.png" width="50px" height="59px"/>
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
								 <s:submit key="label.request.Download" cssClass="btn dwn" />
							</div>
						</div>
					</div>
				</div>		
		</s:form>
  </div>
    <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
		<div class="row">
				<div class="span12 request-summary glanceDiv">
				<div style="padding:5px;">
					<div class="row lastrow">
						<div class="span12">
							<p class="heading"><s:text name="label.request.atAGlance"/></p>
							<p><s:text name="label.request.approvarsList"/></p>
						</div>
					</div>
					<s:if test="%{requestDetails.delegationApprovers.approverLevels != null || requestDetails.delegationApprovers.approverLevels.isNotEmpty()}">	
						<s:iterator value="requestDetails.delegationApprovers.approverLevels">	
							   <div class="row lastrow">
								<div class="span1">
									<p><s:text name="label.request.approver" /></p>
								</div>
								<div class="span3">
									<p> <s:property value="lastName"/> ,<s:property value="firstName"/>,</p>
								</div>
								<div class="span2">
									<p><s:date name="approvedDate" format="MMM dd, yyyy - HH:mm aa"/></p>
								</div>
							</div>
						</s:iterator>
					</s:if>
				</div>
				</div>
			</div>
		</c:if>
	</div>
	
 	
   
   <!-- Including Documentation.jsp  -->
   <s:form id="issuerSubmitForm" action="issuerSubmit" namespace="/ext/approver" onsubmit="return validateIssuer();"> 
   <div class="row smallrow hide" id="issuerCommentsId">
       			<div class="span12">
  		   			<h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
  		   			<hr class="page-title-hr">
           			<label><s:text name="label.request.commentsOptional" /></label>
					<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
					cssClass="autosize messageinput" id="tdcomments" required="false"/>
           			<div class="clear"></div>
           			<div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
           			<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
       			</div>
   			</div>       
   <input type="hidden" name="actionType" id="actionTypeId">
   <input type="hidden" name="issuerRadioOption" id="issuerRadioOption">
    <c:choose>
   		<c:when  test="${requestDetails.instrumentTypeId == '5'}">
   			<s:hidden name="amendmentOrRiderRequestId" id="requestId" value="%{requestDetails.amendment.amendmentRequestId}"/> 
   		</c:when>
   		<c:when  test="${requestDetails.instrumentTypeId == '6'}">
   			<s:hidden name="amendmentOrRiderRequestId" id="requestId" value="%{requestDetails.rider.riderRequestId}"/> 
   		</c:when>
   		<c:otherwise>
   			<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/> 
   		</c:otherwise>
   </c:choose>
   <div class="form-mod labelList">
        <c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6'}">
			<h3 class="span12"><s:text name="label.request.ableToComplete"/></h3>
		</c:if>
		<div class="row">	  
		   <div class="span12">
			   <jsp:include page="/jsp/ext/request/common/documentation.jsp"/>
		  </div>
		</div>
   </div> 
   </s:form>
   </div> 
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
</body>
</html>