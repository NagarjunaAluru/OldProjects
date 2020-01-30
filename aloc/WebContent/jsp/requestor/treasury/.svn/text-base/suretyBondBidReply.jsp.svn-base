<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%@include file="../../common/includeCommonScripts.jsp"%>
<title><s:property value="requestDetails.instrumentType" /> - <s:text name="label.request.bidReply" /></title>

<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
	
<script src="${pageContext.request.contextPath}/js/requestor/bidReply.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container main">
	<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<div id="mainPage" style="width: 100%;">	
	<h1 class="page-title span12"><s:text name="label.request.suretyBondBidReply"/></h1>
	<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.suretybondBidReply"/></p>
	<hr class="page-title-hr">
	<s:form id="bgSuretyReplyForm" action="sbBidReply" namespace="/int/approver" >
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
		 <!-- REQUEST SUMMARY -->
		<jsp:include page="suretyBondBidRequestSummary.jsp"/>	
	</div><!-- end of form form-mod -->

		<div class="form-mod" id="suretyBidDetails">
				<h2 id="suretyBidMemoDetails" class="section_flip section_blue">
					<a href="javascript:;"> <s:text name="label.request.bgBidResponseRequired"></s:text>
					</a>
				</h2><hr class="h2-hr">
				<div id="suretyBidMemoDetailsPanel" class="section_panel">
					<jsp:include page="suretyBondBidSection.jsp">
						<jsp:param name="sectionId" value="request.section.suretyBidDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
		</div>
		
		<div class="form-mod">
				<h2 id="suretyCommentsDetails" class="section_flip section_blue">
					<a href="javascript:;"> <s:text name="label.request.comments"></s:text>
					</a>
				</h2><hr class="h2-hr">
				<div id="suretyCommentsDetailsPanel" class="section_panel">
					<jsp:include page="suretyBondBidSection.jsp">
						<jsp:param name="sectionId" value="request.section.suretyCommentsDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
		</div>
		
		<div class="form-mod">
				<h2 id="suretyPrincipalDetails" class="section_flip section_blue">
					<a href="javascript:;"> <s:text name="label.request.principal"></s:text>
					</a>
				</h2><hr class="h2-hr">
				<div id="suretyPrincipalDetailsPanel" class="section_panel">
					<jsp:include page="suretyBondBidSection.jsp">
						<jsp:param name="sectionId" value="request.section.suretyPrincipalDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
		</div>
		
		<div class="form-mod">
				<h2 id="suretyObligeeDetails" class="section_flip section_blue">
					<a href="javascript:;"> <s:text name="label.request.obligee"></s:text>
					</a>
				</h2><hr class="h2-hr">
				<div id="suretyObligeeDetailsPanel" class="section_panel">
					<jsp:include page="suretyBondBidSection.jsp">
						<jsp:param name="sectionId" value="request.section.suretyObligeeDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
		</div>		
		
		<div class="form-mod">
					<h2 id="bidOtionSelection" class="section_flip section_blue">
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
				<div class="hide bidDiv" id="bidDiv">
				
				<div class="form-mod">	
					<h2 id="bidReplyDetails" class="section_flip section_blue">
						<a href="javascript:;"> <s:text name="label.request.fees"></s:text><span class="ttip info" 
						data-original-title="<s:text name="label.request.tooltip.suretyFeeDetail"/>"></span></a>
					</h2><hr class="h2-hr">
					
					<div id="bidReplyDetailsPanel" class="section_panel">
						<jsp:include page="suretyBondBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.bidReplyDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>					
				</div>
				
				<div class="hide bidOptDiv" id="bidOptDiv">
				<div class="form-mod">	
					<h2 id="optingOutComments" class="section_flip section_blue">
						<a href="javascript:;"> <s:text name="label.request.optingOutComments"></s:text></a>
					</h2><hr class="h2-hr">
					
					<div id="optingOutCommentsPanel" class="section_panel">
						<jsp:include page="suretyBondBidSection.jsp">
							<jsp:param name="sectionId" value="request.section.optingOutComments" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>	
				
				</div>
			</div>
				<s:if test="(requestDetails.bundleDetails != null && requestDetails.bundleDetails.bundleId!=null)">
				<div class="row highlighted">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 10px;">
								<s:text name="label.request.bidReplyBundleDesc">
								<s:param>
									<s:property value="requestDetails.bundleDetails.bundleId"/>
								</s:param>
								</s:text>
							</p>
						</div>
					</div>
					<!-- end of block -->
				</div>
				</s:if>
				<div class="clear"></div>
				<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="(bidFlag != 'Bid' && bidFlag != 'Opt-Out')">
				<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
					<jsp:include page="bidReplySubmit.jsp">
						<jsp:param name="suretBond" value="true" />
					</jsp:include>
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
	<%@include  file="../../common/footerSection.jsp" %>
	
</body>
</html>