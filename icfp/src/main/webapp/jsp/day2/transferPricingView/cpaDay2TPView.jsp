<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<% String servletContextUrl = request.getContextPath();  %>
<script src="<%=servletContextUrl%>/js/rcaTransferPricingInput.js" type="text/javascript"></script>

<c:set var="transferPricingInfo"
	value="${deal:getTransferPricing(param.id, pageContext.request)}" />
<c:set var="rateInformation"
	value="${deal:getInterest(param.id, pageContext.request)}" />
	
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
	