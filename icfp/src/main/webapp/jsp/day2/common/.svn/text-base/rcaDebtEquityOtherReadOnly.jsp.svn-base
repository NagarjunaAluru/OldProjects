<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%	String servletContextUrl = request.getContextPath();%>

		
		<jsp:include page="../common/originalTPTransactionDetails.jsp">
			<jsp:param name="productType" value="${param.productType}"/>
		</jsp:include>
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
         
			<h2 class="span12">Description</h2>
			<div class="clear"></div>
			
			<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<label>Currency</label>
							${legSummaryVO.originalCurrency}
						</div>
					</div> <!-- end of block --> 
					<div class="span5 right">
						<div class="form-row">
							<label>Amount</label>
							${legSummaryVO.originalAmount}
							</div>
					</div> <!-- end of block -->                                        
			</div>
			<div class="row">
					<div class="span5 right">
						<div class="form-row">
							<label>USD Equivalent</label>
							<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
							<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
						</div>
					</div> <!-- end of block -->
			</div>
			<c:if test="${legSummaryVO.legTypeId eq 2}">
			 <div class="row highlighted">
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>eBoardroom Eligible</b><br />  ${deal:getEBoardApprovalRequiredFlag(requestScope.legNumber, pageContext.request)}
							</p>
						</div>
					</div>
			</div>
			</c:if>
			
			<div class="clear"></div>
			
			<c:if test="${legSummaryVO.legTypeId eq 2}">
				<div class="row">
			</c:if>
			<c:if test="${legSummaryVO.legTypeId ne 2}">
				<div class="row highlighted">
			</c:if>
				<div class="span5">
					<c:if test="${empty day2legSummaryVO.debtEquityOtherComments}">-</c:if>
					<c:if test="${not empty day2legSummaryVO.debtEquityOtherComments}">${day2legSummaryVO.debtEquityOtherComments}</c:if>
				</div>
			</div>
			
			<c:if test="${legSummaryVO.legTypeId ne 2}">
				<div class="row">
					<div class="span5">
							<label>Request Derivatives</label>
								<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>                               
					</div>
				</div>
				
				<jsp:include page="../common/derivativesDetails.jsp" />
			</c:if>
		<c:if test="${param.productType ne '2'}">
			<jsp:include page="../common/tpTermsAndConditions.jsp" />
		</c:if>
		<jsp:include page="../common/otherTPConsiderations.jsp" />
		
		<c:if test="${legSummaryVO.legTypeId eq 2}">
		<h3 class="span12">Description</h3>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">1000</div>
							<textarea readonly="readonly" class="xlarge autosize messageinput" name="otherEquityComments"	rows="4" id="dealCommentsId" data-max="1000">${deal:getOtherEquityComments(requestScope.legNumber, pageContext.request)}</textarea>
						</div>
				</div> <!-- end of block -->
			</div>
		</c:if>
			