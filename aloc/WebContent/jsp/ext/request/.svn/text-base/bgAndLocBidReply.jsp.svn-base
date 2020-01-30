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
<script src="${pageContext.request.contextPath}/ext/public/js/requestor/lookup.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/ext/public/js/requestor/bidReply.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:property value="requestDetails.instrumentType" />
				<s:text name="label.request.bidReplyTitle"></s:text>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.bidReplyDescription" />
			</p>
			<hr class="page-title-hr">
			<s:form id="bgBankReplyForm" action="bidReply" namespace="/ext/approver" >
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
							<s:fielderror>
								<s:param>requestDetails.bidOrOptFlag</s:param>
								<s:param>requestDetails.bidReplyDetails.bidExpirationDate</s:param>
								<s:param>bidHours</s:param>
								<s:param>bidMinutes</s:param>
								<s:param>requestDetails.bidReplyDetails.issuanceTypeFlag</s:param>
								<s:param>requestDetails.bidReplyDetails.notes</s:param>
								<s:param>requestDetails.issuingBankDetails.USExpirationDate</s:param>
								<s:param>requestDetails.actionDetails.reasonForOptingOut</s:param>
								<s:param>requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag</s:param>
								<s:param>requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.reasonForRejection</s:param>
								<s:param>bankName</s:param>
								<s:param>bankCountryCd</s:param>
								<s:param>bankCity</s:param>
								<s:param>requestDetails.bidReplyDetails.issuanceTypeFlag</s:param>
								<s:param>requestDetails.pricingDetails.allInCommissionsId</s:param>
								<s:param>allInCommissionsValue</s:param>
								<s:param>localCommissionsValue</s:param>
							</s:fielderror>
							</p>
						<p>&nbsp;</p>
						</div>
					</div>
				</div>
			</div>	
			
			<div class="clear"></div>
			 <!-- REQUEST SUMMARY -->
				<jsp:include page="/jsp/requestor/treasury/bgAndLocBidRequestSummary.jsp"/>	
				
			<h3 class="dashdesc marginZero"><s:text name="label.request.bgBidResponseRequired" /></h3>
   			<!-- REQUEST SUMMARY -->
			<div id="requestSummary">
        			<s:text name="label.request.bidDetailsDesc1" /><br>
           			<s:text name="label.request.bidDetailsDesc2" />
           			<p>&nbsp;</p>
        
				<div class="clear"></div>
        
        		<div class="leftBoxRS">
           		<div class="row smallrow">
                <div class="span2">
                    <s:label key="label.request.expirationDateC"/>
                </div>
                <div class="span2 marginZero right">
                    <s:property value="requestDetails.bidmemoDetails.expirationDateTime"/>
                </div>            
            </div>
		</div><!-- leftBox ends here -->
        
        <div class="midBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <s:label key="label.request.expirationTimeC"/>
                </div>
                <div class="span2 marginZero right">
                    <s:property value="hours"/>:<s:property value="minutes"/> <s:property value="period"/> <s:date name="requestDetails.bidmemoDetails.expirationDateTime" format=" zzz"/>
                </div>            
            </div>
        </div><!-- midBox ends here -->
        
        <div class="clear"></div>
			<p>&nbsp;</p>
        	<span style="font-size: 14px;"><s:text name="label.request.emailNotifyDesc"></s:text></span><br>
        	<s:text name="label.request.transactionQuoteDesc"></s:text><br>
            <s:text name="label.request.bidDeclineDesc"></s:text>

		<div class="clear"></div>        
    </div><!-- requestSummary ends here -->
				
			<%-- Transaction parties section --%>				
				<div class="form-mod">
					<h2 id="transactionParties" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.bglocSectionName.1"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="transactionPartiesPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.transactionParties" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
			<%-- Instrument details section --%>	
				<div class="form-mod">
					<h2 id="instrumentDetails" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.bglocSectionName.3"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="instrumentDetailsPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.instrumentDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
			
			 <!-- Including Standby Letter of Credit Conditions  -->
  			 <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
				<div class="form-mod">
					<h2 id="standbyLocConditions" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.bglocSectionName.5"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="standbyLocConditionsPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.standbyLocConditions" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				</c:if>
				<div class="clear"></div>
				
				<c:if test="${requestDetails.issuingBankSelectionFlag eq 'Y'}">
		    		<jsp:include page="/jsp/common/request/issuingBankSelection.jsp"/>   
		   			<div class="clear"></div>
	   			</c:if>	
	   			
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
					<h2 id="bidOtionSelection" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.bidSelectionSection"></s:text></a>
					</h2><hr class="h2-hr">

					<div id="bidOtionSelectionPanel" class="section_panel">
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
					<h2 id="bidReplyDetails" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.bidReplyDetailSection"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="bidReplyDetailsPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.bidReplyDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				<div class="form-mod">	
					<h2 id="issuingBankBranch" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.issuingBankBranch"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="issuingBankBranchPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.issuingBankBranch" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
				
				<s:if test="%{!requestDetails.additionalInstrumentDetails.requestForProposal}">
					<div class="form-mod">	
						<h2 id="pricingDetails" class="section_flip">
							<a href="javascript:;"> <s:text name="label.request.pricingDetails"></s:text></a>
						</h2><hr class="h2-hr">
						
						<div id="pricingDetailsPanel" class="section_panel">
							<jsp:include page="bgAndLocBidSection.jsp">
								<jsp:param name="sectionId" value="request.section.pricingDetails" />
								<jsp:param name="includeScripts" value="false" />
							</jsp:include>
						</div>
					</div>
				</s:if>
				
				<s:if test="%{requestDetails.additionalInstrumentDetails.requestForProposal}">
					<div class="form-mod">	
						<h2 id="preAgreedPricingDetails" class="section_flip">
							<a href="javascript:;"> <s:text name="label.request.preAgreedPricingDetails"></s:text></a>
						</h2><hr class="h2-hr">
						
						<div id="preAgreedPricingDetailsPanel" class="section_panel">
							<jsp:include page="bgAndLocBidSection.jsp">
								<jsp:param name="sectionId" value="request.section.preAgreedPricingDetails" />
								<jsp:param name="includeScripts" value="false" />
							</jsp:include>
						</div>
					</div>
				</s:if>
					
				</div>
				
				<div class="hide bidOptDiv" id="bidOptDiv">
				<div class="form-mod">	
					<h2 id="optingOutComments" class="section_flip">
						<a href="javascript:;"> <s:text name="label.request.optingOutComments"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="optingOutCommentsPanel" class="section_panel">
						<jsp:include page="bgAndLocBidSection.jsp">
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