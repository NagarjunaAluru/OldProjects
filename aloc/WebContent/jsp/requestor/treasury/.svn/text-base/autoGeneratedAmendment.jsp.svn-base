<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../common/includeCommonScripts.jsp"%>
<title><s:text name="label.amendment.pageTitle" /></title>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/amendment.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
</head>
<body>
<div class="container main">
	<jsp:include page="../../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<div id="mainPage" style="width: 100%;">
		<s:form id="submitAutoAmendmentFormID" action="submitAutoAmendment">
		<h1 class="page-title span12">
			<s:text name="label.autoAmendment.trAnalyst.pageTitle"></s:text>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:text name="label.autoAmendment.trAnalyst.subTitle" />
		</p>
		<hr class="page-title-hr">
		<s:hidden name="validationSuccess" id="autoAmendmentvalidationId"/>
			<div class="row hide" id="pageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon">Error</p></div>
					<div class="errorContent">
							<p><s:fielderror/></p>
							<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>
		<div class="form-mod">		
			<div class="row">
				<div class="span12 request-summary">
					<p class="heading"><s:text name="label.request.requestSummary" /> - <span>
						<c:out value="${requestDetails.alocRecordId}"/></p>
					<div class="row">
						<div class="span1ab"><div class="right"><s:label key="label.request.requestorName" /></div></div>
						<div class="span2 left"><s:property value="requestDetails.requestSummary.requestor.lastName"/>,
							 <s:property value="requestDetails.requestSummary.requestor.firstName"/></div>
					
						<div class="span2a"><div class="right"><s:label key="label.amendment.seqNo" /></div></div>
						<div class="span1a left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
						
						<div class="span2a"><div class="right"><s:label key="label.amendment.bankRefNo" /></div></div>
						<div class="span1a left"><s:property value="requestDetails.amendment.bankReferenceNumber" /></div>
					</div>				
				</div>
			</div>
		</div>

		<s:set name="isEditMode" value="editMode" />
		<!-- Including Expiry date  -->
		<div class="form-mod">
			<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
			</h2><hr class="h2-hr">
			<div id="expirationDatesPanel" class="section_panel">
				<div class="row">
			        <div class="span20 left">
			           	<s:label key="label.amendment.currExpDate"/>
						<s:textfield name="requestDetails.amendment.expiryDate.revisedExpiryDate" cssClass="date" id="expiryDt" theme="aloc"/>
						<p>DD MMM YYYY</p>
			        </div>
			    </div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- Including transaction parties  -->
		<div class="form-mod">
			<h2 id="transactionParties" class="section_flip">
				<a href="javascript:;"> <s:text	name="label.request.bglocSectionName.1" />
				</a>
			</h2><hr class="h2-hr">
			<div id="transactionPartiesPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/amendment/autoAmendmentTriParty.jsp" />
			</div>
		</div>
		<div class="clear"></div>
			
		<!-- Including Instrument Amount changes -->
		<div class="form-mod">
			<h2 id="instrumentAmountChanges" class="section_flip">
				<a href="javascript:;"><s:text name="label.amendment.trAnalyst.instrumentAmountChanges" /></a>
			</h2><hr class="h2-hr">
			<div id="instrumentAmountChangesPanel" class="section_panel">
				<div class="row smallrow">
                     <div class="span3b">
						<div class="form-row">
							<label><span class="IncOrDec"></span></label>
			            </div>
			        </div>
					<div class="span2 left">
						<s:textfield name="requestDetails.amendment.amendmentInstrumentAmountCurr.amtOfIncreaseOrDecrease"
						cssClass="span2 bigDecimal" id="autoAmountIncDec" theme="aloc"></s:textfield>
			        </div> <!-- end of block -->
					<div class="span3 left">
						<p class="padding40"><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt"/></p>
						<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt" id="revisedInstrumentAmt"/>
			        </div> <!-- end of block -->
			        <s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.operation" id="instrumentOperationId"/>
			        <s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.originalInstrumentAmt" id="originalInstrumentAmt"/>
			    </div>    
			</div>
		</div>
		<div class="clear"></div>   
		
		<div class="row smallrow">
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
        
	   <!-- Including Information transmission platform -->
		<div class="form-mod">
			<h2 id="informationTransmission" class="section_flip">
				<a href="javascript:;"> <s:text name="label.amendment.trAnalyst.infoTransmissionPlatform" />
				</a>
			</h2><hr class="h2-hr">
			<div id="informationTransmissionPanel" class="section_panel">
				<div class="row">
					<div class="span20 left">
				       	<p><s:text name="label.amendment.trAnalyst.selectTheMethod"/></p>
				       	<br /><br />
				       	<p><s:text name="label.request.note"/>:<s:text name="label.amendment.trAnalyst.choiceInfo"/></p>
			         </div>
				</div>
				<div class="row">
					<div class="span20 left">
						<c:if test="${requestDetails.amendment.infoTransPlatFormSelection eq 'ALOC'}" >
			              <s:radio theme="aloc" cssClass="radio" 
							name="requestDetails.amendment.infoTransPlatFormSelection" 
							list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}" 
							value="%{requestDetails.amendment.infoTransPlatFormSelection}" disabled="true"
							/>    
							<s:hidden name="requestDetails.amendment.infoTransPlatFormSelection" value="%{requestDetails.amendment.infoTransPlatFormSelection}" id="infoTransPlatFormSelection"/>
						</c:if>   
						<c:if test="${requestDetails.amendment.infoTransPlatFormSelection eq 'SWIFT'}" >
						 <s:radio theme="aloc" cssClass="radio" 
							name="requestDetails.amendment.infoTransPlatFormSelection" 
							list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}" 
							value="%{requestDetails.amendment.infoTransPlatFormSelection}"
							/>    
						</c:if>      
					</div>           
				</div>
			</div>
		</div>
		<div class="clear"></div>
		
		<!-- buttons starts -->
		<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
		<input type="hidden" name="actionType" id="actionTypeId">
		<hwfs:checkComponentPermission name="DefaultViewTreasuryAccess" domainName="BusinessAccess">
		<div class="form-mod">
			<div class="row">
				<div class="span12">
					<nav> 
					    <ul>
					        <li class="navLi"><a class="navLink" href="#tab1" id="nav-auto-submit" ><s:text name="label.request.Submit"/></a></li>
					        <li id="li4" class="navLi bigli"><a href="#tab4" class="navLink biglink" id="nav-auto-amddeleteAmendment">
					        	<s:text name="label.amendment.deleteAutoAmendment"/></a></li>
					        <li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal">
					        	<s:text name="label.request.exitRequest" /></a></li>
					    </ul>
					</nav>
				</div>
			</div>
		</div>
		</hwfs:checkComponentPermission>
		<div class="clear"></div>
		</s:form>		
	</div>
</div>
<%@include file="../../common/footerSection.jsp"%>
<!-- Exit Request Modal -->
	<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<p><s:text name="label.request.popUpMsg"/></p>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.continue"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>
		</div>
	</div>
<!-- Delete Modal Modal -->
	<div class="modal hide fade" id="deleteAutoAmendment">
        <div class="modal-header">
            <a class="close" data-dismiss="modal">X</a>
            <h3><s:text name="label.amendment.delete"/><span></span></h3>
        </div>
        <div class="modal-body" style="min-height: auto;">
        
        <p><s:text name="label.amendment.amdDel"/></p>
		<p><b><s:text name="label.request.alocReferenceNumber"/></b>: <s:property value="requestDetails.amendment.amendmentRequestId"/></p>
			<h3><s:text name="label.request.thisActionCannotbeUndone"/></h3>
        </div>
        <div class="modal-footer">
            <a href="#" id="deleteAutoAmendmentId" class="btn left" data-dismiss="modal"><s:text name="label.request.delete"/></a>
            <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel"/></a>
        </div>
	</div>
</body>
</html>