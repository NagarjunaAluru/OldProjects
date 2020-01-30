<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<t:common></t:common>
<title>ICF | All Leg Screens</title>
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<%@include file="../common/includeCssScripts.jsp" %>


<!-- DIV PRINT -->
<script type="text/javascript" src="${context}/js/common/allInputScreens.js"></script>
<script src="${context}/js/cpaRequest.js" type="text/javascript"></script>
</head>

<c:set var="showSave" value="false" scope="request"/>

<body>
	<div class="container main">
		<%@include file="headerSection.jsp" %>

		<c:set var="legSummaryVO" 
		value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>

		<c:set var="source" value="${param.source}" />
		<c:if test="${empty source}">
			<c:set var="source" value="${requestScope.source}"/>
		</c:if>
		<c:set var="actionId" value="${requestScope.actionId}" />
		<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />
		<c:set var="productType" value="${legSummary.legTypeId}" />
		<ul class="breadcrumb">
			<c:choose>
				<c:when test="${source eq 'searchResults'}">
				<li><a href="${context}/searchResults.do?command=returnToSearchResults">Home</a> <span class="divider">/</span></li>
				</c:when>
				<c:otherwise>
				<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${source eq 'searchResults'}">
				<li>
					<a href="${context}/${source}.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>
				</c:when>
				<c:when test="${source eq 'pipelineReview/pipelineReviewDeal'}">
				<li>
					<a href="${context}/pipelineReview/pipelineReviewView.do?command=executeInbox"><t:getSection source="pipelineReview"></t:getSection></a> <span class="divider">/</span>
				</li>
				<li>
					<a href="${context}/${source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>	
				</c:when>
				<c:when test="${source eq 'pipelineReviewCPALeg'}">
				<li>
					<a href="${context}/pipelineReview/pipelineReviewView.do?command=executeInbox"><t:getSection source="pipelineReview"></t:getSection></a> <span class="divider">/</span>
				</li>
				<li>
					<a href="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>	
				</c:when>
				<c:otherwise>
				<li>
					<a href="${context}/${source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>
				</c:otherwise>
			</c:choose>
			<li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
		</ul>
		
		<div class="alert fade in alert-danger hide" style="display: none">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>

		<h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
		<div class="clear"></div>
		<form method="post" id="legSummary" 
			  action="${context}/transactionCapture/transactionCaptureLeg.do" 
			  enctype="multipart/form-data">
			
			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="FrontOffice">
				<c:set var="FOactive" value="active in" scope="request"/>
			</security:hasRoles>

			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="CashManagment">
				<c:set var="CMactive" value="active in" scope="request"/>
			</security:hasRoles>

			<c:if test="${empty FOactive and empty CMactive}">
		    	<c:set var="firstActive" value="active in"/>
		    </c:if>	
					
			<div class="form-mod">
				<ul class="nav nav-tabs tabs">
					<li class="${firstActive}"><a data-toggle="tab" href="#1">Requestor</a></li>
					<li class="${FOactive}">
						<a data-toggle="tab" href="#2">Front Office</a>
					</li>
					<li><a data-toggle="tab" href="#3">Transfer Pricing</a></li>
					<li class="${CMactive}">
						<a data-toggle="tab" href="#4">Cash Management</a>
					</li>
					<li><a data-toggle="tab" href="#5">Treasury Legal</a></li>
					<li><a data-toggle="tab" href="#6">Treasury Tax</a></li>
					<li><a data-toggle="tab" href="#7">Middle Office</a></li>
					<c:if test="${param.pType eq 'CPA'}">
						<li><a data-toggle="tab" href="#8">Regulatory/Jurisdictional Reviews</a></li>
					</c:if>
				</ul>
				<c:set var="name"><t:getSection source='${source}'></t:getSection></c:set>

				
				<div class="tab-content" id="myTabContent">
					<div id="1" class="tab-pane fade ${firstActive}">
						
						<jsp:include page="/jsp/day1ViewRequestor.jsp" >
							<jsp:param value="${requestScope.legNumber}" name="id"/>
							<jsp:param value="false" name="isSno"/>
							<jsp:param value="true" name="derivativeViewFlag"/>
						</jsp:include>   
					</div>
					<div id="2" class="tab-pane fade ${FOactive}">
						
						
						<jsp:include page="readOnlyView.jsp" >
							<jsp:param value="frontOffice" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>
					</div>
					<!-- END OF TAB 1 -->


					<div id="3" class="tab-pane fade">
												
						<jsp:include page="rcaTPInputRO.jsp" >
							<jsp:param value="transferPricing" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>

					</div>
					<!-- end of TAB 2 -->
					<div id="4" class="tab-pane fade ${CMactive}">
						<jsp:include page="readOnlyView.jsp" >
							<jsp:param value="cashManagement" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>
					
					</div>
					<!-- END OF TAB 3 -->

					<div id="5" class="tab-pane fade">
						<jsp:include page="readOnlyView.jsp" >
							<jsp:param value="treasuryLegal" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>

					</div>
					<!-- END OF TAB 4 -->

					<div id="6" class="tab-pane fade">

						<jsp:include page="readOnlyView.jsp" >
							<jsp:param value="treasuryTax" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>

					</div>
					<!-- END OF TAB 5 -->

					<div id="7" class="tab-pane fade">

						<jsp:include page="readOnlyView.jsp" >
							<jsp:param value="middleOffice" name="page"/>
							<jsp:param value="${source}" name="path"/>
							<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
							<jsp:param value="viewInputScreens" name="method"/>
							<jsp:param value="${name}" name="origin"/>
							<jsp:param value="${source}" name="source"/>
							<jsp:param value="${requestScope.legNumber}" name="id"/>
						</jsp:include>
					</div>
					
					<!-- END OF TAB 6 -->
					<c:if test="${param.pType eq 'CPA'}">
						<div id="8" class="tab-pane fade">
							<jsp:include page="readOnlyView.jsp" >
								<jsp:param value="countryTax" name="page"/>
								<jsp:param value="${source}" name="path"/>
								<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
								<jsp:param value="viewInputScreens" name="method"/>
								<jsp:param value="${name}" name="origin"/>
								<jsp:param value="${source}" name="source"/>
								<jsp:param value="${requestScope.legNumber}" name="id"/>
							</jsp:include>
						</div>
					</c:if> 
					<!-- END OF TAB 7 -->
					
					
					
				</div> <!--  END of TAB -->
					
					
					<c:set var="url" value="${context}/${source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}"/>


					<c:if test="${source eq 'searchResults'}">
						<c:set value="${context}/${source}.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}&section=myTasks"
						target="url"/>
					</c:if>

					<c:if test="${source eq 'pipelineReview/pipelineReviewDeal'}">
						<c:set value="${context}/${source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"
						target="url"/>
					</c:if>

					<c:if test="${source eq 'pipelineReviewCPALeg'}">
						<c:set value="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"
						target="url"/>
					</c:if>
					<div class="span12 btn-container" style="margin-left:-10px!important;">						
											
						<c:if test="${showSave}">
							<c:set var="showNextLeg"
							 value="${requestScope.proceedtoNextLeg ne 'yes'}" />
							<div class="span3 right submit-box">
							<div class="form-row" style="margin-bottom:15px;">
								<div class="radio-container conditional-required">

									<c:if test="${showNextLeg}">
										<label class="radio">
											<input type="radio" name="command" value="saveNextLeg" class="condition">
											Save and go to next Leg
										</label>
									</c:if>
										
									<label class="radio">
										<input type="radio" name="command" value="saveLeg" class="condition">
										<c:choose>
										<c:when test="${param.pType eq 'CPA'}">
										Save and return to request
										</c:when>
										<c:otherwise>
										Save and return to deal
										</c:otherwise>
										</c:choose>
									</label>									
								</div>
							</div>

							<button id="saveLegInput" class="btn btn-success btn-large">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</button>	
							
						</div>

							<c:choose>
								<c:when test="${showNextLeg}">
									<c:set var="margin" value="85px"/>
								</c:when>
								<c:otherwise>
									<c:set var="margin" value="60px" />
								</c:otherwise>
							</c:choose>

							<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:${margin};">Cancel</a>
							<input type="hidden" name="forward" value="sucessCMFO"/>
						</c:if>

						<c:if test="${not showSave}">	
							<c:choose>
								<c:when test="${source eq 'searchResults'}">
									<a href="${context}/${source}.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single">Cancel</a>
								</c:when>
								<c:when test="${source eq 'pipelineReview/pipelineReviewDeal'}">
									<a href="${context}/${source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single">Cancel</a>
								</c:when>
								<c:when test="${source eq 'pipelineReviewCPALeg'}">
									<a href="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single">Cancel</a>
								</c:when>
								<c:otherwise>
									<a href="${context}/${source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single">Cancel</a>
								</c:otherwise>
							</c:choose>
						</c:if>				
				</div>
			</div>
			
			<c:set var="legNumberVal" value="${param.id}" />
			<c:if test="${empty legNumberVal}">
				<c:set var="legNumberVal" value="${requestScope.legNumber}"/>
			</c:if>

			<c:set var="legSeqVal" value="${legSummaryVO.legSeqId}"/>
			<c:if test="${empty legSeqVal}">
				<c:set var="legSeqval" value="${requestScope.legSeqId}"/>
			</c:if>
			
			<c:set var="pTypeVal" value="${param.pType}"/>
			<c:if test="${empty pTypeVal}">
				<c:set var="pTypeVal" value="${requestScope.pType}"/>
			</c:if>	
			<input type="hidden" name="legNumber" value="${legNumberVal}">
			<input type="hidden" name="legSeqId" value="${legSeqval}" />
			<input type="hidden" name="pType" value="${pTypeVal}"/> 
			<input type="hidden" name="source" value="${source}"/>
		</form>
		
	</div>

	
<div class="modal hide fade" id="lookup">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>Lookup Results</h3>
	</div>
	<div class="modal-body">
		<div class="alert fade in alert-danger hide">
        	<a href="#" data-dismiss="alert" class="close">X</a>
        	<strong>Select one to save.</strong> 
    	</div>
		<div class="form-row autosize-container">
		</div>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0);" class="btn right btn-success saveSelectEntity">Save selection</a>
		<a href="javascript:closeLookup();" class="btn-link right cancel">Cancel</a>
	</div>
</div>

<div class="modal hide fade" id="confirm">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>Cancel Leg</h3>
	</div>
	<div class="modal-body" style="margin-top:-16px;">
		<div class="row">
			<p><b>Are you sure you want to cancel?</b><br>
		Any changes you have made will be lost
		</p>
		</div>
	</div>
	<div class="modal-footer">
		<a href="${url}" class="btn right btn-success">Yes, cancel the Leg</a>
		<a class="btn-link right cancel" data-dismiss="modal">No, take me back to the leg</a>
	</div>
</div>

	<%@include  file="../common/footerSection.jsp" %>
	
</body>
</html>