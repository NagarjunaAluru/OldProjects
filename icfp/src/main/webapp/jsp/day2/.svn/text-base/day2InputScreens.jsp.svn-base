<%@page import="com.ge.icfp.common.helper.CurrentDealManager"%>
<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page errorPage="../common/error.jsp"%>

<%@ page import="org.apache.struts.action.DynaActionForm"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib uri="http://ge.com/icfp/taglibs/userInformation"  prefix="userDetails"%>

<t:common />
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>ICF</title>

		<% String servletContextUrl = request.getContextPath();%>
	<script>
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';	
	</script>
	
	<%@include file="../common/includeCssScripts.jsp"%>
	<script src="${pageContext.request.contextPath}/js/rcaTransferPricingInput.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/cpaRequest.js" type="text/javascript"></script>

	</head>

<body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp"%>
		
		<c:set var="legNumber" value="${requestScope.legNumber}" />
		<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
		<c:set var="actionId" value="${requestScope.actionId}" />
		<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />
		<c:set var="productType" value="${legSummary.legTypeId}" />
		<c:set var="foMethod" value="${(actionId eq 2) ? 'openLeg' : 'viewInputScreens'}" />
		<c:set var="source" value="${param.source}" />
		<c:if test="${empty source}">
			<c:set var="source" value="${requestScope.source}"/>
		</c:if>
		<c:set var="name"><t:getSection source='${source}'></t:getSection></c:set>
	
		<c:choose>
			<c:when test="${actionId eq 1}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');"><bean:message key="label.addLeg.newFinancingRequest" /></a> <span class="divider">/</span></li>
					<li class="active">
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			<c:when test="${productType != '3' && actionId eq 2}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes">Front Office</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			<c:when test="${productType eq 3 && actionId eq 2}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a  href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" >Front Office</a> <span class="divider">/</span></li>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 3}">
				<ul class="breadcrumb">
					<li><a href="<%= servletContextUrl%>/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a  href="${context}/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" >Transfer Pricing</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 4}">
				<ul class="breadcrumb">
					<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${context}/cashManagement/cashManagement.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Cash Management</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 5}">
				<ul class="breadcrumb">
					<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${context}/treasuryLegal/treasuryLegal.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Treasury Legal</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 6}">
				<ul class="breadcrumb">
					<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${context}/treasuryTax/treasuryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Treasury Tax</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 7}">
				<ul class="breadcrumb">
					<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${context}/middleOffice/middleOffice.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Middle Office</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 10}">
				<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
				<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewView.do?command=executeInbox"><bean:message key="heading.pipelineInbox.pageTitle"/></a><span class="divider">/</span></li>
				<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&source=${param.sourcePage}">Pipeline Review</a> <span class="divider">/</span></li>
	      		<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
				<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
			</ul>
			</c:when>	
			
			<c:when test="${actionId eq 11}">
				<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/searchResults.do?command=returnToSearchResults">Home</a> <span class="divider">/</span></li>
				<li><a href="${pageContext.request.contextPath}/searchResults.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a><span class="divider">/</span></li>
	      		<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
				<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
			</ul>
			</c:when>	
			
			<c:when test="${actionId eq 31 || actionId eq 32 || actionId eq 33 || actionId eq 34 || actionId eq 35 || actionId eq 36 || actionId eq 37 || actionId eq 38 || actionId eq 39}">
				<ul class="breadcrumb">
					<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li>
						<a href="${context}/${source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
					</li>
					<li class="active">${legSummary.transactionEventType}</li>
				</ul>
			</c:when>
			<c:when test="${actionId eq 51}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes">Front Office</a> <span class="divider">/</span></li>
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}</c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}</c:if>
				</ul>
			</c:when>
			<%-- TODO Add BreadCrumb for other actions --%>

		</c:choose> 
		<c:set var="legPageName" value=""></c:set>
		<h1 class="page-title span12">
			<c:choose>
				<c:when test="${actionId eq 1 || actionId eq 2 || actionId eq 51}">
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}<c:set var="legPageName" value="Amendment: ${legSummary.transactionEventType}"/></c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}<c:set var="legPageName" value="${legSummary.transactionEventType}"/></c:if>
				</c:when>
				<c:when test="${!(actionId eq 1 || actionId eq 2)}">
					<c:if test="${eventType eq 6}">Amendment: ${legSummary.transactionEventType}: Summary<c:set var="legPageName" value="Amendment: ${legSummary.transactionEventType} : Summary"/></c:if>
					<c:if test="${eventType!=6}">${legSummary.transactionEventType}: Summary<c:set var="legPageName" value="${legSummary.transactionEventType} : Summary"/></c:if>
				</c:when>
			</c:choose>
		</h1>
		
		<p class="span12 left clear dashdesc">
			Complete 
			<c:if test="${eventType eq 3 || eventType eq 7 || eventType eq 8 || eventType eq 9 || eventType eq 10 || eventType eq 11}">${legSummary.transactionEventType}</c:if>
			<c:if test="${eventType eq 4}">Extension</c:if>
			<c:if test="${eventType eq 5}">Increase/Decrease</c:if>
			<c:if test="${eventType eq 6}">Amendment</c:if>
			 details below. <span class="required-fields"><span>*</span>= Required</span>
		</p>
		
		<c:choose>
			<%-- Requestor level Add/Modify leg --%>
			<%-- <c:when test="${empty sessionScope.deal.WFStageId}">
				<jsp:include page="day2Requestor.jsp">
					<jsp:param name="actionId" value="${actionId}"/>
				</jsp:include>
			</c:when> --%>
			
			<%-- Pipeline--%>
			<%--<c:when test="${actionId eq 10}">
				<jsp:include page="day2ViewLeg.jsp" />
			</c:when>--%>
			<%-- Requester Add new leg for four events which is not required for all tabs--%>
			<c:when test="${(actionId eq 1 || actionId eq 51) && (eventType eq 7 || eventType eq 8 || eventType eq 5)}">
				<jsp:include page="day2Requestor.jsp">
					<jsp:param name="actionId" value="${actionId}"/>
				</jsp:include>
			</c:when>
			
			<%-- FrontOffice Add new leg --%>
			<%--<c:when test="${(empty legSummary.legSeqId) && actionId eq 2}">
				<jsp:include page="day2FrontOffice.jsp">
					<jsp:param name="actionId" value="${actionId}"/>
				</jsp:include>
			</c:when>--%>
			
			<%-- Show all tabs --%>
			<c:otherwise>

				<c:set var="stageName"
				 value="${deal:getCurrentWorkflowStage(pageContext.request)}"/>

				<c:if test="${stageName eq 'CERTFYFO'}">
					<c:set var="isTCFOStage" value="true" scope="request"/>			
				</c:if>		

				<c:if test="${stageName eq 'CERTFYCM'}">
					<c:set var="isTCCMStage" value="true" scope="request"/>			
				</c:if>		
				
				<c:if test="${not isTCFOStage and not isTCCMStage}">
					<c:if test="${actionId eq 1 or actionId ge 9}">
						<c:set var="firstActive" value="active in"/> 
					</c:if>
				</c:if>

				<c:if test="${isTCFOStage or actionId eq 2}">
					<c:set var="foActive" value="active in"/>
				</c:if>	
				
				<c:if test="${isTCCMStage or actionId eq 4}">
					<c:set var="cmActive" value="active in"/>
				</c:if>
				<div class="form-mod">
					<ul class="nav nav-tabs tabs">
						<li class="${firstActive}">
							<a data-toggle="tab" href="#1">Requestor</a>
						</li>
						<li class="${foActive}">
							<a data-toggle="tab" href="#2">Front Office</a>
						</li>
						<li class="${(actionId eq 3) ? 'active' : ''}"><a data-toggle="tab" href="#3">Transfer Pricing</a></li>
						<li class="${cmActive}">
							<a data-toggle="tab" href="#4">Cash Management</a>
						</li>
						<li class="${(actionId eq 5) ? 'active' : ''}"><a data-toggle="tab" href="#5">Treasury Legal</a></li>
						<li class="${(actionId eq 6) ? 'active' : ''}"><a data-toggle="tab" href="#6">Treasury Tax</a></li>
						<li class="${(actionId eq 7) ? 'active' : ''}"><a data-toggle="tab" href="#7">Middle Office</a></li>
						<c:if test="${productType eq 3}">
							<li class="${(actionId eq 8) ? 'active' : ''}"><a data-toggle="tab" href="#8">Regulatory/Jurisdictional Reviews</a></li>
						</c:if>	
					</ul>
					<div class="tab-content" id="myTabContent">
					
						<div id="1" class="tab-pane fade ${firstActive}">
							<c:choose>
								<c:when test="${actionId eq 1}">
										<jsp:include page="day2Requestor.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>

								<script src="<%= servletContextUrl%>/js/downloadAttachmentFile.js" type="text/javascript"></script>
										<jsp:include page="day2ViewLeg.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- END OF TAB 1 -->
 
						<div id="2" class="tab-pane fade ${foActive}">
							<c:choose>
								<c:when test="${actionId eq 2}">
										<jsp:include page="day2FrontOffice.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
								
									    <jsp:include page="day2ViewFOLeg.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include> 
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 2 -->
						<div id="3" class="tab-pane fade${(actionId eq 3) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 3}">
										 <jsp:include page="day2TransferPricing.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
										<jsp:include page="day2ViewTransferPricingLeg.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 3 -->
						
						<div id="4" class="tab-pane fade ${cmActive}">
							<c:choose>
								<c:when test="${actionId eq 4}">
										<jsp:include page="day2CashManagement.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
										<jsp:include page="day2ViewCashManagementLeg.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include>
								</c:otherwise>
								
							</c:choose>
						</div>
						<!-- end of TAB 4 -->
						
						<div id="5" class="tab-pane fade${(actionId eq 5) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 5}">
										<jsp:include page="day2TreasuryLegal.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
										<jsp:include page="day2TreasuryLegalView.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 5 -->
						
						<div id="6" class="tab-pane fade${(actionId eq 6) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 6}">
										<jsp:include page="day2TreasuryTax.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
										<jsp:include page="day2TreasuryTaxView.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 6 -->
						
						<div id="7" class="tab-pane fade${(actionId eq 7) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 7}">
										<jsp:include page="day2MiddleOffice.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
										</jsp:include>
								</c:when>
								<c:otherwise>
										<jsp:include page="day2MiddleOfficeView.jsp">
											<jsp:param name="actionId" value="${actionId}"/>
											<jsp:param value="${source}" name="path"/>
											<jsp:param value="${name}" name="origin"/>
											<jsp:param value="${foMethod}" name="method"/>
											<jsp:param value="${legPageName}" name="name"/>
											<jsp:param value="${source}" name="source"/>
											<jsp:param value="${param.sourcePage}" name="sourcePage"/>
											<jsp:param value="${requestScope.legNumber}" name="id"/>
									     </jsp:include>
									
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 7 -->
						
						<div id="8" class="tab-pane fade${(actionId eq 8) ? ' active in' : ''}">
							<jsp:include page="day2CountryTax.jsp">
									<jsp:param name="actionId" value="${actionId}"/>
							</jsp:include>
						</div>
						<!-- end of TAB 8 -->
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

		<div class="modal hide fade" id="lookup">
			<div class="modal-header">
				<a class="close" href="javascript:closeLookUpModal()">X</a>
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
				<a href="#" class="btn right btn-success saveSelectEntity">Save selection</a>
				<a class="btn-link right cancel" href="javascript:closeLookUpModal()">Cancel</a>
			</div>
		</div>

	<%@include file="../common/footerSection.jsp" %>


</body>
</html>



