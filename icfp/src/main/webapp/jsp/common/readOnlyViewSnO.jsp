<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="hwf-securitytag"  prefix="security"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.productType}" />

<c:if test="${(sessionScope.deal.WFStage eq 'CERTFYCM') 
				or (sessionScope.deal.WFStage eq 'CERTFYFO')}">
	<c:set var="isTCStage" value="true"/>			
</c:if>				

<c:if test="${isTCStage and (FOactive eq 'active in')}">
	<c:if test="${param.page eq 'frontOffice'}">		
		<jsp:include page="inc/fromToEntity.jsp"></jsp:include>
	</c:if>
</c:if>

<c:if test="${isTCStage and (CMactive eq 'active in')}">
	<c:if test="${param.page eq 'cashManagement'}">		
		<jsp:include page="inc/fromToEntity.jsp"></jsp:include>
	</c:if>
</c:if>


<c:choose>
	<c:when test="${productType ne 'CPA'}">
		<%@ include file="../common/inc/transactionSummary.jsp"%>

		<jsp:include page="../common/inc/detailSummary.jsp">
			<jsp:param value="cashManagement" name="page" />
		</jsp:include>
		
		<c:choose>
			<c:when test="${legSummaryVO.legTypeId eq 4}">
			<h2 class="span12">Description</h2>
			<div class="form-mod">
			 	<div class="row">
					<div class="span12">
						<div class="form-row autosize-container">
							<span class="required"></span>
							${deal:getOtherDescription(pageContext.request)}
							</div>
					</div> <!-- end of block -->
				</div>
			</div>
			</c:when>
	 </c:choose>
		
		<c:if test="${legSummaryVO.productType eq 'EQUITY'}">
			<jsp:include page="../common/inc/equityDetails.jsp">
				<jsp:param value="true" name="readOnly"/>
			</jsp:include>
		</c:if>

		<jsp:include page="../common/inc/transactionLegDetails.jsp" />
		<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					 <jsp:include page="/jsp/common/legPageExceptions.jsp">
						<jsp:param value="view" name="mode"/>
						<jsp:param value="${legNumber}" name="legIndex"/>      	
				      </jsp:include>
				</c:when>
				<c:otherwise>
				</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<jsp:include page="../common/inc/cpaRequestDetailInput.jsp">
			<jsp:param value="${param.page}" name="page" />
		</jsp:include>
		<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					 <jsp:include page="/jsp/common/legPageExceptions.jsp">
						<jsp:param value="view" name="mode"/>
						<jsp:param value="${legNumber}" name="legIndex"/>      	
				      </jsp:include>
				</c:when>
				<c:otherwise>
				</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${productType ne 'CPA'}">
		<c:if test="${param.page eq 'frontOffice' and param.pType ne 'EQUITY'}">
			<%@ include file="inc/frontOfficeLegView.jsp"%>
			<%@ include file="inc/otherConsideration.jsp" %>
		</c:if>
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>

<c:if test="${param.page eq 'cashManagement'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Operational Risk - Initial" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'treasuryLegal'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Legal Risk" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'treasuryTax'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Tax Risk" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'middleOffice'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Operational Risk - Ongoing" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'frontOffice'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk" />
	</jsp:include>
</c:if>

<c:if test="${param.page eq 'countryTax'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Regulatory/Jurisdictional Reviews Risk" />
	</jsp:include>
</c:if>

<div class="form-mod">
	<jsp:include page="../common/inc/commentsLog.jsp">
		<jsp:param name="formName" value="fourBlockerForm" />
		<jsp:param value="${param.path}" name="path"/>
		<jsp:param value="${param.origin}" name="origin"/>
		<jsp:param value="${param.source}" name="source"/>
		<jsp:param value="${param.name}" name="name"/>
		<jsp:param value="${param.method}" name="method"/>
		<jsp:param value="${param.id}" name="legNumber"/>
		<jsp:param value="${param.sourcePage}" name="sourcePage"/>
		<jsp:param value="${param.pType}" name="pType"/>
		<jsp:param value="${true}" name="isReadOnly"/>
	</jsp:include>
</div>
<c:choose>
	<c:when test="${productType ne 'CPA'}">
		  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
	</c:when>
	<c:otherwise>
		  <jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
	</c:otherwise>
</c:choose>
<jsp:include page="../common/inc/auditLog.jsp">
	<jsp:param name="formName" value="fourBlockerForm" />
	<jsp:param value="${param.path}" name="path"/>
	<jsp:param value="${param.origin}" name="origin"/>
	<jsp:param value="${param.source}" name="source"/>
	<jsp:param value="${param.name}" name="name"/>
	<jsp:param value="${param.method}" name="method"/>
	<jsp:param value="${param.id}" name="legNumber"/>
	<jsp:param value="${param.sourcePage}" name="sourcePage"/>
	<jsp:param value="${true}" name="isReadOnly"/>
</jsp:include>
<div class="span8 right btn-container">
	<jsp:include page="../day1CancelReadOnlyTabs.jsp" />		
</div>