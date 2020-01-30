<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
<title><s:property value="requestDetails.instrumentType" /> -
	<s:text name="label.request.bidReplyTitle" /></title>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/bidReply.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/lookup.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/site.js" type="text/javascript"></script>
	
</head>

<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:text name="label.request.dLocBidReplyTitle" />
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.optionalSentence.dLocBidReply" />
			</p>
			<hr class="page-title-hr">
			<s:form id="dLocBidReplyForm" action="dlocBidReply" namespace="/ext/approver" >
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
				
				<div class="row hide" id="bidReplyPageLevelErrorDivId">
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
					<div class="span12 request-summary">
						<p class="heading"><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/>&nbsp;&nbsp;<strong><s:property value="requestDetails.alocRecordId"/></strong></p>
						<div class="row lastrow">
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].addressDetails}">
							<div class="span1ab"><div class="right">
										<b><s:property value="name"/>:</b><br/></div></div>
							<div class="span5 left"><s:iterator value="address">
											<s:property/>
										</s:iterator><br/>
										<s:property value="city"/>, 
										<s:property value="stateProvinceCd"/>&nbsp;&nbsp;
										<s:property value="ZIPPostalCode"/><br/></div>
									</s:iterator>
						</div>
						
						<s:if test="%{requestDetails.bundleDetails.bundleId != null }">
							<div class="row">
								<div class="span1ab"><div class="right"><label><s:text name="label.request.bundleID"/>:</label></div></div>
								<div class="span5 left"><s:property value="requestDetails.bundleDetails.bundleId"/></div>
							</div>	
						</s:if>			
					</div>
				</div>
			</div><!-- end of form form-mod -->
			
			<div class="clear"></div>
				
			<%-- Bid memo details section --%>
				<div class="form-mod">
					<h2 id="dLocBidMemoDetails" class="section_flip section_blue">
						<a href="javascript:;"> <s:text name="label.request.bidMemoDetails"></s:text>
						</a>
					</h2><hr class="h2-hr">
					<div id="dLocBidMemoDetailsPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.bidMemoDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
			<%-- Issuing Bank section --%>				
				<div class="form-mod">
					<h2 id="dLocIssuingBank" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.issuingBank" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocIssuingBankPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.issuingBank" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
				
			<%-- Applicant details section --%>	
				<div class="form-mod">
					<h2 id="dLocApplicant" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.applicant" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocApplicantPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.applicant" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
			
			<%-- Beneficiary sections --%>	
				<div class="form-mod">
					<h2 id="dLocBeneficiary" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.beneficiary" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocBeneficiaryPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.beneficiary" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
				
				<%-- Instrument Details sections --%>	
				<div class="form-mod">
					<h2 id="dLocInstrumentDetails" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.instrumentTransactionDetails" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocInstrumentDetailsPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.instrumentDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
				
				<%-- Payment Schedule sections --%>
				<div class="form-mod">
					<h2 id="dLocPaymentSchedule" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.paymentSchedule" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocPaymentSchedulePanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.paymentSchedule" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
				<!-- Including Format   -->
				  
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="/jsp/ext/request/common/format.jsp" >
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>						
											
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
				
				<div class="form-mod">
					<h2 id="dLocBidOtionSelection" class="section_flip section_blue">
						<a href="javascript:;"> <s:text name="label.request.bidSelectionSection"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocBidOtionSelectionPanel" class="section_panel">
						<div class="row lastrow">
							<div class="span12">
								<div class="form-row">
									<div class="radio-container intrest-type-condition1">
										<c:choose>
										<c:when test="${empty bidFlag or (not empty bidFlag and bidFlag eq '')}">
											<s:radio cssClass="radio"
												name="requestDetails.bidOrOptFlag"
												key="label.request.bidOptionQuestion" theme="aloc"
												id="bidOption"
												list="#{'Bid':'Bid','Optout':'Opt out'}"
												value="%{requestDetails.bidOrOptFlag}"  />
										</c:when>
										<c:otherwise>
											<s:radio cssClass="radio"
												name="requestDetails.bidOrOptFlag"
												key="label.request.bidOptionQuestion" theme="aloc"
												id="bidOption"
												list="#{'Bid':'Bid','Optout':'Opt out'}"
												value="%{requestDetails.bidOrOptFlag}"  disabled="true"/>
										</c:otherwise>
									  </c:choose>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="clear"></div>
					
				<div class="hide bidDiv" id="bidDiv">
				<div class="form-mod">	
					<h2 id="dLocConformationFees" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.conformationFees" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocConformationFeesPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.conformationFees" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<div class="clear"></div>
				<div class="form-mod">	
					<h2 id="dLocPraposedBankBranch" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.praposedBankBranch" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocPraposedBankBranchPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.praposedBankBranch" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>	
				
				<div class="clear"></div>
							
				<div class="form-mod">	
					<h2 id="dLocIndicativePricing" class="section_flip section_blue">
						<a href="javascript:;"><s:text name="label.request.indicativePricingInformationCompletedBy" /></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocIndicativePricingPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.indicativePricingInformation" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>						
				</div>
				<div class="clear"></div>
				<div class="hide bidOptDiv" id="bidOptDiv">
				<div class="form-mod">	
					<h2 id="dLocOptingOutComments" class="section_flip section_blue">
						<a href="javascript:;"> <s:text name="label.request.optingOutComments"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="dLocOptingOutCommentsPanel" class="section_panel">
						<jsp:include page="dLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.optingOutComments" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>	
				
				</div>
			</div>
				<div class="clear"></div>
				<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="(bidFlag != 'Bid' && bidFlag != 'Opt-Out')">
				<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
					<jsp:include page="/jsp/requestor/treasury/bidReplySubmit.jsp" />
				</hwfs:checkComponentPermission>
				</s:if>
				
				<hwfs:checkComponentPermission name="BankBrokerReadOnly" domainName="BusinessAccess">
					<div class="row smallrow highlighted">
						<div class="span12">
							<div class="form-row" style="margin-left: 0px;">
								<s:url id="homePageURL" action="cancel"/>
								<s:a href="%{homePageURL}" key="label.request.common.cancel" cssClass="btn-tertiary cancel" >
									<s:text name="label.request.common.cancel"></s:text>
								</s:a>
							</div>
						</div>
					</div>
			    </hwfs:checkComponentPermission>
			</s:form>
		</div>
		
		<div id="lookupDiv" style="width: 100%;">
		</div>
		
	</div>
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
	
</body>
</html>