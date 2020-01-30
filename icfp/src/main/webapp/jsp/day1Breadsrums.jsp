<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<% String servletContextUrl = request.getContextPath();%>
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<c:choose>
		   <c:when test="${productType != '3' && actionId eq 1}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');"><bean:message key="label.addLeg.newFinancingRequest" /></a> <span class="divider">/</span></li>
					<logic:notEqual scope="session" name="addOrModifyFlag" value="modify">
		    			<li class="active"><bean:message key="label.addLeg.addALeg" /></li>
					</logic:notEqual>
					<logic:equal scope="session" name="addOrModifyFlag" value="modify">
						<li class="active"><bean:message key="label.addLeg.modifyLeg" /></li>
					</logic:equal>
				</ul>
				<logic:notEqual scope="session" name="addOrModifyFlag" value="modify">
		    		<h1 class="page-title span10"><bean:message key="label.addLeg.addLeg" /></h1>
				</logic:notEqual>
				<logic:equal scope="session" name="addOrModifyFlag" value="modify">
					<h1 class="page-title span10"><bean:message key="label.addLeg.modifyLeg" /></h1>
				</logic:equal>
			</c:when>
			
			<c:when test="${productType eq 3 && actionId eq 1}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');">New Financing Request</a> <span class="divider">/</span></li>
					<logic:notEqual scope="session" name="addOrModifyReq" value="modify">
		    			<li class="active">Add Request Details</li>
					</logic:notEqual>
					<logic:equal scope="session" name="addOrModifyReq" value="modify">
						<li class="active">Modify Request Details</li>
					</logic:equal>
				</ul>
				<logic:notEqual scope="session" name="addOrModifyReq" value="modify">
	    			<h1 class="page-title span12">Add Request Details</h1>
				</logic:notEqual>
				<logic:equal scope="session" name="addOrModifyReq" value="modify">
					<h1 class="page-title span12">Modify Request Details</h1>
				</logic:equal>
			</c:when>
			
			<c:when test="${productType != '3' && actionId eq 2}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="<%=servletContextUrl%>/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes');">Front Office</a> <span class="divider">/</span></li>
					  </c:when>
					  <c:otherwise>
					      <li><a href="javascript:redirectFundingRequest('?command=redirectFundingRequest&isFrontOffice=Yes');">Front Office</a> <span class="divider">/</span></li>
					  </c:otherwise>
					</c:choose>
					
					
					<logic:notEqual scope="session" name="addOrModifyFlag" value="modify">
		    			<li class="active"><bean:message key="label.addLeg.addALeg" /></li>
					</logic:notEqual>
					<logic:equal scope="session" name="addOrModifyFlag" value="modify">
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a  href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=openLeg&modify=true&legNumber=${legNumber}" >Modify a Leg</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Modify a Leg</li>
					  </c:otherwise>
					</c:choose>
						
					</logic:equal>
				</ul>
				<logic:notEqual scope="session" name="addOrModifyFlag" value="modify">
		    		<h1 class="page-title span10">Add a Leg</h1>
				</logic:notEqual>
				<logic:equal scope="session" name="addOrModifyFlag" value="modify">
				<c:choose>
				  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
				  </c:when>
				  <c:otherwise>
				       <h1 class="page-title span10">Modify a Leg</h1>
				  </c:otherwise>
				</c:choose>
				</logic:equal>
			</c:when>
			
			<c:when test="${productType eq 3 && actionId eq 2}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a  href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" >Front Office</a> <span class="divider">/</span></li>
					<logic:notEqual scope="session" name="addOrModifyReq" value="modify">
		    			<li class="active">Add Request Details</li>
					</logic:notEqual>
					<logic:equal scope="session" name="addOrModifyReq" value="modify">
						<li class="active">Modify Request Details</li>
					</logic:equal>
				</ul>
				<logic:notEqual scope="session" name="addOrModifyReq" value="modify">
	    			<h1 class="page-title span12">Add Request Details</h1>
				</logic:notEqual>
				<logic:equal scope="session" name="addOrModifyReq" value="modify">
					<h1 class="page-title span12">Modify Request Details</h1>
				</logic:equal>
			</c:when>
			
			
			<c:when test="${actionId eq 3}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a  href="${pageContext.request.contextPath}/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" >Transfer Pricing</a> <span class="divider">/</span></li>
					
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/transferPricing/transferPricing.do?command=legDetails&id=${legNumber}&pType=${productType}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
					
					
					
				</ul>
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				            <h1 class="page-title span10">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
				
				
				
			</c:when>
			
			<c:when test="${actionId eq 4}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/cashManagement/cashManagement.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Cash Management</a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/cashManagement/cashManagement.do?command=legDetails&id=${legNumber}&pType=${productType}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
				</ul>
				
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				            <h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
			  </c:when>
			
			<c:when test="${actionId eq 5}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/treasuryLegal/treasuryLegal.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Treasury Legal</a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/treasuryLegal/treasuryLegal.do?command=legDetails&id=${legNumber}&pType=${productType}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
				</ul>
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				           <h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
				
			</c:when>
			
			<c:when test="${actionId eq 6}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/treasuryTax/treasuryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Treasury Tax</a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/treasuryTax/treasuryTax.do?command=legDetails&id=${legNumber}&pType=${productType}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
				</ul>
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				           <h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
			</c:when>
		
			<c:when test="${actionId eq 7}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/middleOffice/middleOffice.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Middle Office</a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/middleOffice/middleOffice.do?command=legDetails&id=${legNumber}&pType=${productType}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					       <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
				</ul>
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				            <h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
			</c:when>
			
			<c:when test="${actionId eq 8}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/countryTax/countryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Regulatory/Jurisdictional Reviews</a> <span class="divider">/</span></li>
					<li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
				</ul>
				<h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
			</c:when>
			
			<c:when test="${actionId eq 10}">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewView.do?command=executeInbox"><bean:message key="heading.pipelineInbox.pageTitle"/></a><span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&source=${param.sourcePage}">Pipeline Review</a> <span class="divider">/</span></li>
					<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					    <li><a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=viewInputScreens&id=${legNumber}&pType=${productType}&source=${param.source}" >Leg ${legSummaryVO.legSeqId}: Summary</a><span class="divider">/</span></li>
					    <li class="active">View Derivative<span class="divider"></span></li>
					  </c:when>
					  <c:otherwise>
					      <li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
					  </c:otherwise>
					</c:choose>
				</ul>
				<c:choose>
					  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
					  </c:when>
					  <c:otherwise>
				           <h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
					  </c:otherwise>
				</c:choose>
				
				
				
			</c:when>	
			<c:when test="${actionId eq 11}">
				<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/searchResults.do?command=returnToSearchResults">Home</a> <span class="divider">/</span></li>
				<li><a href="${pageContext.request.contextPath}/searchResults.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}">Search Details</a><span class="divider">/</span></li>
	      		<li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
			</ul>
			<h1 class="page-title span12">Leg ${legSummaryVO.legSeqId}: Summary</h1>
			</c:when>
			<c:when test="${(not empty param.derivativeFlag && param.derivativeFlag eq 'yes') && (actionId eq 31 || actionId eq 32 || actionId eq 33 || actionId eq 34 || actionId eq 35 || actionId eq 36 || actionId eq 37 || actionId eq 39) }">
					<ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
						<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.source}&id=${legNumber}&pType=${productType}"><t:getSection source="${param.source}"></t:getSection> </a><span class="divider">/</span></li>
						<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=viewInputScreens&source=${param.source}&id=${legNumber}&pType=${productType}">${legSummary.transactionEventType} </a><span class="divider">/</span></li>
						<li class="active">View Derivative<span class="divider"></span></li>
					</ul>
			</c:when>
			<c:when test="${(not empty param.derivativeFlag && param.derivativeFlag eq 'yes') && (actionId eq 38) }">
					<ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/homePage.do">Home</a> <span class="divider">/</span></li>
						<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.source}&id=${legNumber}&pType=${productType}"><t:getSection source="${param.source}"></t:getSection> </a><span class="divider">/</span></li>
						<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=legDetails&id=${legNumber}&pType=${productType}">${legSummary.transactionEventType} </a><span class="divider">/</span></li>
						<li class="active">View Derivative<span class="divider"></span></li>
					</ul>
			</c:when>
			<%-- This is for view derivative --%>
			<c:when test="${not empty param.derivativeFlag && param.derivativeFlag eq 'yes' && actionId eq 9999 }">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/homePage.do"><bean:message key="label.addLeg.home" /></a> <span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.source}&id=${legNumber}&pType=${productType}"><t:getSection source="${param.source}"></t:getSection> </a><span class="divider">/</span></li>
					<li><a href="${pageContext.request.contextPath}/${param.source}.do?command=viewInputScreens&source=${param.source}&id=${legNumber}&pType=${productType}">Leg ${legSummaryVO.legSeqId}: Summary </a><span class="divider">/</span></li>
					<li class="active">View Derivative<span class="divider"></span></li>
				</ul>
			</c:when>
		</c:choose> 
		
		<c:choose>
		  <c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
		  </c:when>
		  <c:otherwise>
					  			  
			<p class="span12 left clear dashdesc">
				<c:choose>
					<c:when test="${productType != '3' && (actionId eq 1 || actionId eq 2)}">
						<bean:message key="label.addLeg.newFunding" />
						<span class="required-fields"><span>*</span>= Required</span>
					</c:when>
					
					<c:when test="${productType eq 3 && (actionId eq 1 || actionId eq 2)}">
						<bean:message key="label.addARequest.cpa" />
						<span class="required-fields"><span>*</span>= Required</span>
					</c:when>
					
					<c:when test="${actionId eq 1 || actionId eq 4 || actionId eq 5 || actionId eq 6 || actionId eq 7 || actionId eq 10}">
						<bean:message key="label.input.middleOffice" />.
						<span class="required-fields"><span>*</span>= Required</span>
					</c:when>
					
					<c:when test="${actionId eq 8}">
						<bean:message key="label.input.countryTax" />
						<span class="required-fields"><span>*</span> = Required</span>
					</c:when>
					
					<c:otherwise>
						<bean:message key="label.addLeg.newFunding" />
						<span class="required-fields"><span>*</span>= Required</span>
					</c:otherwise>
				</c:choose>
			</p>
		</c:otherwise>
		</c:choose>