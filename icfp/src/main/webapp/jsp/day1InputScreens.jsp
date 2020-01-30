<%@page import="com.ge.icfp.common.helper.CurrentDealManager"%>
<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page errorPage="../common/error.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts.action.DynaActionForm"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/userInformation"  prefix="userDetails"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

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
	
	<%@include file="common/includeCssScripts.jsp"%>
	<script src="${pageContext.request.contextPath}/js/closeModalPopUps.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/cpaRequest.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<%@include file="/jsp/common/headerSection.jsp"%>
		
		<c:set var="legNumber" value="${requestScope.legNumber}" />
		<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
		<c:set var="actionId" value="${requestScope.actionId}" />
		<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />
		<c:set var="productType" value="${legSummary.legTypeId}" />
		<c:set var="foMethod" value="${(actionId eq 2) ? 'openLeg' : 'viewInputScreens'}" />
		<c:set var="source" value="${param.source}" />
		<c:set var="name"><t:getSection source='${source}'></t:getSection></c:set>
		<jsp:include page="day1Breadsrums.jsp" />
		
		<%--<c:choose>
			<c:when test="${(empty legSummary.legSeqId) && actionId eq 2}">
				<jsp:include page="/jsp/frontOffice/addLeg.jsp">
					<jsp:param name="actionId" value="${actionId}"/>
				</jsp:include>
			</c:when>
			
			 Show all tabs 
			<c:otherwise> --%>
			
				<div class="form-mod">
					<ul class="nav nav-tabs tabs">
						<li class="${(actionId eq 1 || actionId ge 9) ? 'active' : ''}"><a data-toggle="tab" href="#1">Requestor</a></li>
						<li class="${(actionId eq 2) ? 'active' : ''}"><a data-toggle="tab" href="#2">Front Office</a></li>
						<li class="${(actionId eq 3) ? 'active' : ''}"><a data-toggle="tab" href="#3">Transfer Pricing</a></li>
						<li class="${(actionId eq 4) ? 'active' : ''}"><a data-toggle="tab" href="#4">Cash Management</a></li>
						<li class="${(actionId eq 5) ? 'active' : ''}"><a data-toggle="tab" href="#5">Treasury Legal</a></li>
						<li class="${(actionId eq 6) ? 'active' : ''}"><a data-toggle="tab" href="#6">Treasury Tax</a></li>
						<li class="${(actionId eq 7) ? 'active' : ''}"><a data-toggle="tab" href="#7">Middle Office</a></li>
						<c:if test="${productType eq 3}">
							<li class="${(actionId eq 8) ? 'active' : ''}"><a data-toggle="tab" href="#8">Regulatory/Jurisdictional Reviews</a></li>
						</c:if>	
					</ul>
					<div class="tab-content" id="myTabContent">
					
						<div id="1" class="tab-pane fade${(actionId eq 1 || actionId ge 9) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 1}">
									<jsp:include page="day1Requestor.jsp" >
									   <jsp:param value="${actionId}" name="actionId"/>
									</jsp:include>
								</c:when>
								<c:otherwise>
									<jsp:include page="day1ViewRequestor.jsp" >
										<jsp:param value="${requestScope.legNumber}" name="id"/>
										<jsp:param value="${actionId}" name="actionId"/>
									</jsp:include>   
								</c:otherwise>
							</c:choose>
						</div>
						<!-- END OF TAB 1 -->
 
						<div id="2" class="tab-pane fade${(actionId eq 2) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 2}">
									<jsp:include page="day1FrontOffice.jsp" >
										<jsp:param value="${requestScope.legNumber}" name="id"/>
										<jsp:param value="frontOffice" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
										<jsp:param value="${source}" name="source"/>
										<jsp:param value="${requestScope.legNumber}" name="id"/>
									</jsp:include>  
								</c:when>
								<c:otherwise>
									 <jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="frontOffice" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
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
									<jsp:include page="day1TransferPricing.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/rcaTPInputRO.jsp" >
										<jsp:param value="transferPricing" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${source}" name="source"/>
										<jsp:param value="${param.sourcePage}" name="sourcePage"/>
										<jsp:param value="${requestScope.legNumber}" name="id"/>
									</jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 3 -->
						
						<div id="4" class="tab-pane fade${(actionId eq 4) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 4}">
									<jsp:include page="/jsp/cashManagement/cashManagement-Input.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="cashManagement" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
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
									<jsp:include page="/jsp/treasurylegal/treasuryLegalInput.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="treasuryLegal" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
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
									<jsp:include page="/jsp/treasuryTax/RCATreasuryTaxInput.jsp" />	
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="treasuryTax" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
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
									<jsp:include page="/jsp/middleOffice/middleOfficeInput.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="middleOffice" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
										<jsp:param value="${source}" name="source"/>
										<jsp:param value="${param.sourcePage}" name="sourcePage"/>
										<jsp:param value="${requestScope.legNumber}" name="id"/>
									</jsp:include>									
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 7 -->
						
						<div id="8" class="tab-pane fade${(actionId eq 8) ? ' active in' : ''}">
							<c:choose>
								<c:when test="${actionId eq 8}">
									<jsp:include page="/jsp/cpa/countryTax/countryTaxInput.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="/jsp/common/readOnlyViewSnO.jsp" >
										<jsp:param value="countryTax" name="page"/>
										<jsp:param value="${source}" name="path"/>
										<jsp:param value="${name}" name="origin"/>
										<jsp:param value="${foMethod}" name="method"/>
										<jsp:param value="Leg ${legSummary.legSeqId}: Summary" name="name"/>
										<jsp:param value="${source}" name="source"/>
										<jsp:param value="${param.sourcePage}" name="sourcePage"/>
										<jsp:param value="${requestScope.legNumber}" name="id"/>
									</jsp:include>									
								</c:otherwise>
							</c:choose>
						</div>
						<!-- end of TAB 8 -->
					</div>
				</div>
		<%--	</c:otherwise>
		</c:choose> --%>
	</div>
	<%@include file="/jsp/common/footerSection.jsp" %>
</body>
</html>