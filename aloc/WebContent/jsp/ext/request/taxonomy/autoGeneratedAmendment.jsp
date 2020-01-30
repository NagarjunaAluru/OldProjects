<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.amendment.pageTitle"/> </title>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/ext/public/css/common/amendment.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/amendment.js"	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>
</head>

<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<div id="mainPage" style="width: 100%;">
		<h1 class="page-title span12">
			<s:text name="label.autoAmendment.trAnalyst.pageTitle"></s:text>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:text name="label.autoAmendment.trAnalyst.subTitle" />
		</p>
		<hr class="page-title-hr">
		<s:hidden name="validationSuccess" id="autoAmendmentvalidationId"/>
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
			<div class="form-mod">
        	<c:choose>
        		<c:when test="${taxonomyViewType eq 'OPENREQUEST'}">
        			<c:set var="myReqClass" value="active"></c:set>
        			<c:set var="myReqTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'issuer'}">
        			<c:set var="myIssuerClass" value="active"></c:set>
        			<c:set var="myIssuerTab" value="active in"></c:set>
        		</c:when>
        	</c:choose>
			
			<s:url action="RequestorAtmtTaxonomy.action" namespace="/ext" escapeAmp="false" var="requestURL" />
			
			<s:url action="IssuerTaxonomy.action" namespace="/ext" escapeAmp="false" var="issuerURL" >
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="cancelTaxonomy.action" namespace="/ext" var="cancelLinkURL"/>
			
			<ul class="nav nav-tabs nav-tabsapm tabs">
				<li class="${myReqClass}"><a href="<s:property value="requestURL" />"><s:text name="label.request.requestDetails"/></a></li>		
				
				<c:if test="${requestDetails.WFDetails.WFStageID eq 10 || requestDetails.WFDetails.WFStageID eq 14 || requestDetails.WFDetails.WFStageID eq 15}">
					<li class="${myIssuerClass}"><a href="<s:property value="issuerURL"/>"><s:text name="label.request.issuance"/></a></li>
				</c:if>
			</ul>
			
			<div class="tab-content" id="myTabContent">
				<div id="1" class="tab-pane fade ${myReqTab}">
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
						<s:textfield name="requestDetails.amendment.expiryDate.revisedExpiryDate" readonly="true" cssClass="date" id="expiryDt" theme="aloc"/>
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
						cssClass="span2" id="autoAmountIncDec" theme="aloc" readonly="true"></s:textfield>
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
			              <s:radio theme="aloc" cssClass="radio" 
							name="requestDetails.amendment.infoTransPlatFormSelection" 
							list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}" 
							value="%{requestDetails.amendment.infoTransPlatFormSelection}" disabled="true"
							/>    
							<s:hidden name="requestDetails.amendment.infoTransPlatFormSelection" value="%{requestDetails.amendment.infoTransPlatFormSelection}" id="infoTransPlatFormSelection"/>
					</div>           
				</div>
			</div>
		</div>
		<div class="clear"></div>
						<input type="hidden" name="returnToPage" value="${returnToPage}">
						<s:url action="cancelTaxonomy.action" namespace="/ext" var="cancelBtnlURL"/>
						<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
				</div><!-- Fist Tab End -->
			
				<div id="2" class="tab-pane fade ${myIssuerTab}">
					<jsp:include page="/jsp/ext/request/taxonomy/issuerReadOnly.jsp">
						<jsp:param name="includeScripts" value="false" />
       				</jsp:include>
				</div>
			</div><!--  Main form-mod End  -->
		  </div>
			
		<div class="clear"></div>	
		   
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
</div>
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
	
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
</body>
</html>