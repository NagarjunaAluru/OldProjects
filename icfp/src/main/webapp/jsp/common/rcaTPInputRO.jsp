<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/> 
<% String servletContextUrl = request.getContextPath();  %>
<script src="<%=servletContextUrl%>/js/rcaTransferPricingInput.js" type="text/javascript"></script>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

<c:set var="transferPricingInfo"
	value="${deal:getTransferPricing(param.id, pageContext.request)}" />
<c:set var="rateInformation"
	value="${deal:getInterest(param.id, pageContext.request)}" />
<c:choose>
	<c:when test="${param.pType ne 'CPA'}">
		<%@ include file="../common/inc/transactionSummary.jsp"%>

		<jsp:include page="../common/inc/detailSummary.jsp">
			<jsp:param value="transferPricing" name="page" />
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
				<jsp:param value="true" name="readOnly" />
			</jsp:include>
		</c:if>
		<jsp:include page="../common/inc/transactionLegDetails.jsp">
			<jsp:param value="transferPricing" name="path" />
			<jsp:param value="${param.id}" name="id" />
		</jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="../common/inc/cpaRequestDetailInput.jsp">
			<jsp:param value="${param.page}" name="page" />
		</jsp:include>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${(not empty param.pType and param.pType ne 'EQUITY') or requestScope.legType ne '2'}">
		<c:if test="${param.pType ne 'CPA'}">
		<div class="form-mod">
			<h2 class="span12">Fees</h2>
			<div class="row">
				<c:if test="${param.pType eq 'RCA'}">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Commitment Fee Applicable</b><br />
							${not empty deal:getCommitmentFee(param.id, pageContext.request) ? deal:getCommitmentFee(param.id, pageContext.request) : '-'}
						</p>
					</div>
				</div>
				</c:if>
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>Guarantee Fee Applicable?</b><br />
							${not empty deal:getGuaranteeFee(param.id, pageContext.request) ? deal:getGuaranteeFee(param.id, pageContext.request) : '-'}
						</p>
					</div>
				</div>
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Guarantee Agreement Attached?</b><br />
							${not empty deal:getGuaranteeAgreement(param.id, pageContext.request) ? deal:getGuaranteeAgreement(param.id, pageContext.request) : '-'}
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:if
					test="${param.pType eq 'RCA' and deal:getCommitmentFee(param.id, pageContext.request) eq 'Yes'}">
					<div class="span5">
						<div class="form-row">
							<p>
								<b>Commitment Fee Rate</b><br />
								${not empty deal:getCommitmentFeeRate(param.id, pageContext.request) ? deal:getCommitmentFeeRate(param.id, pageContext.request) : '-'}
							</p>
						</div>
					</div>
				</c:if>
				<c:if
					test="${deal:getGuaranteeFee(param.id, pageContext.request) eq 'Yes'}">
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>Guarantee Fee Rate</b><br />
								${not empty deal:getGuaranteeFeeRate(param.id, pageContext.request) ? deal:getGuaranteeFeeRate(param.id, pageContext.request) : '-'}
							</p>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		</c:if>
		<div class="form-mod">
			<h3 class="span12">Model Type</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Model Type</b><br /> 
							${not empty transferPricingInfo.modelType ? transferPricingInfo.modelType : '-'}
						</p>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${transferPricingInfo.modelTypeId eq 1}">
			<div class="form-mod mDrivers" id="Other">
				<h3 class="span12">Model Drivers - Statutory Financials</h3>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p>
								<b>Total Debt (USD)</b><br /> 
								<c:if test="${empty transferPricingInfo.totalDebt}">-</c:if>
								<c:if test="${not empty transferPricingInfo.totalDebt}"><fmt:formatNumber value="${transferPricingInfo.totalDebt}" /></c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row input-append">
							<p>
								<b>Total Debt/Total Capital</b><br />
								${transferPricingInfo.totalDebtCaptialRatio} %
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p>
								<b>Total Capital (USD)</b><br />
								<c:if test="${empty transferPricingInfo.totalCapital}">-</c:if>
								<c:if test="${not empty transferPricingInfo.totalCapital}"><fmt:formatNumber value="${transferPricingInfo.totalCapital}" /></c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row input-append">
							<p>
								<b>Net Charge-off/Receivables</b><br />
								${transferPricingInfo.netChargeOffReceivables} %
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p>
								<b>Net Income (USD)</b><br /> 
								<c:if test="${empty transferPricingInfo.netIncome}">-</c:if>
								<c:if test="${not empty transferPricingInfo.netIncome}"><fmt:formatNumber value="${transferPricingInfo.netIncome}" /></c:if>
							</p>
						</div>
					</div>
					<div class="span5 right">
						<div class="form-row input-append">
							<p>
								<b>Net Interest Margin</b><br />
								${transferPricingInfo.netInterestMargin} %
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row input-append">
							<p>
								<b>Return on Avg. Assets</b><br />
								${transferPricingInfo.returnOnAvgAssets} %
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<div class="clear"></div>
		<c:if test="${transferPricingInfo.modelTypeId ne 1}">
			<div class="alert fade in alert-success" id="mDriversAlert">
				<a href="#" data-dismiss="alert" class="close">X</a> <strong>See
					Pricing Attachment</strong>
			</div>
		</c:if>
		<div class="form-mod">
			<h3 class="span12">Scores</h3>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Model Score</b><br /> 
							${not empty transferPricingInfo.modelScore ? transferPricingInfo.modelScore : '-'}
						</p>
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>S&amp;P Rating</b><br /> 
						${not empty transferPricingInfo.SPRating ? transferPricingInfo.SPRating : '-'}
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Range</b><br /> 
							 ${not empty transferPricingInfo.range ? transferPricingInfo.range : '-'}
						</p>
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>Final Rating</b><br />
							 ${not empty transferPricingInfo.finalRating ? transferPricingInfo.finalRating : '-'}
						</p>
					</div>
				</div>
			</div>
		
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Sovereign Constraint</b><br />
							${not empty deal:getSovereignConstraint(param.id, pageContext.request) ? deal:getSovereignConstraint(param.id, pageContext.request) : '-'}
						</p>
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>Qualitative Notches</b><br />
							${not empty transferPricingInfo.qualitativeNotches ? transferPricingInfo.qualitativeNotches : '-'}
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>S&amp;P Numerical Rating</b><br />
							${not empty transferPricingInfo.SPNumericalRating ? transferPricingInfo.SPNumericalRating : '-'}
						</p>
					</div>
				</div>
			</div>
		</div>
 	 <input type="hidden"  id="fundHoldOperationId" value='${deal:getTPFundHoldOperationId(param.id, pageContext.request)}' />
		<%@ include file="inc/solvencyMetricsView.jsp"%>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${(not empty param.pType and param.pType ne 'EQUITY') or requestScope.legType ne '2'}">
		<c:if test="${param.pType ne 'CPA'}">
		<div class="form-mod">
			<h2 class="span12">Pricing Information</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Interest Type</b><br />
							<c:if test="${rateInformation.interestTypeId eq 1}">
								Fixed
							</c:if>
							<c:if test="${rateInformation.interestTypeId eq 2}">
								Float
							</c:if>
							<c:if test="${rateInformation.interestTypeId ne 1 and rateInformation.interestTypeId ne 2}">
								-
							</c:if>
						</p>
					</div>
				</div>
			</div>

			<c:if test="${rateInformation.interestTypeId eq 1}">
				<div class="fixed-container">
					<h3 class="span12">Fixed</h3>
					<div class="row">
						<div class="span5">
							<div class="form-row">
								<p>
									<b>Base Fixed Rate</b><br /> 
									${not empty rateInformation.baseFixedRate ? rateInformation.baseFixedRate : '-'}
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${rateInformation.interestTypeId eq 2}">
				<div class="float-container">
					<h3 class="span12">Float</h3>
					<div class="row">
						<div class="span5">
							<div class="form-row">
								<p>
									<b>Floating Rate Index</b><br />
									${not empty rateInformation.floatingRateIndex ? rateInformation.floatingRateIndex : '-'}
								</p>
							</div>
						</div>
						<!-- end of block -->
						<div class="span5 right">
							<div class="form-row">
								<span class="required">*</span>
								<p>
									<b>Index Term</b><br />
									${not empty rateInformation.floatingRateIndexTerm ? rateInformation.floatingRateIndexTerm : '-'}
								</p>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</div>
			</c:if>
			<div>
				<div class="row">
					<div class="span5 ">
							<div class="form-row">
								<p>
									<b>Minimum Spread (bps)</b><br /> 
									${not empty rateInformation.minSpread ? rateInformation.minSpread : '-'}
								</p>
							</div>
						</div>
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>Maximum Spread (bps)</b><br /> 
								${not empty rateInformation.maxSpread ? rateInformation.maxSpread : '-'}
							</p>
						</div>
					</div>
					
				</div>
			</div>

			<div class="row">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Transfer Pricing Summary</label>
						<div class="char-count">1000</div>
						<textarea readonly="readonly"
							class="xlarge autosize messageinput ttt" cols="100" rows="10" onblur="scriptInjection(this);">${transferPricingInfo.TPSummary}</textarea>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		</c:if>
	</c:when>
</c:choose> 
<c:set var="nonStandardDocsFlag"
	value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
<c:choose>
	<c:when test="${nonStandardDocsFlag eq 'Yes'}">
		<c:if test="${fn:length(legSummaryVO.exceptions) >0 }">
			<jsp:include page="/jsp/common/legPageExceptions.jsp">
				<jsp:param value="view" name="mode"/>
				<jsp:param value="${legNumber}" name="legIndex"/>      	
			</jsp:include>
		</c:if>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${param.pType ne 'EQUITY'}">
<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
	<jsp:param name="factor" value="Transfer Pricing Risk" />
</jsp:include>
</c:when>
</c:choose>

<div class="form-mod">
	<jsp:include page="../common/inc/commentsLog.jsp">
		<jsp:param name="formName" value="fourBlockerForm" />
		<jsp:param value="${param.path}" name="path"/>
		<jsp:param value="${param.origin}" name="origin"/>
		<jsp:param value="${param.source }" name="source"/>
		<jsp:param value="${param.name}" name="name"/>
		<jsp:param value="${param.method}" name="method"/>
		<jsp:param value="${param.id}" name="legNumber"/>
		<jsp:param value="${param.sourcePage}" name="sourcePage"/>
		<jsp:param value="${true}" name="isReadOnly"/>
	</jsp:include>
</div>

<c:choose>
	<c:when test="${param.pType ne 'CPA'}">
		  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		  <jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
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
	<jsp:param name="formName" value="ICFPLegRequestForm" />
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