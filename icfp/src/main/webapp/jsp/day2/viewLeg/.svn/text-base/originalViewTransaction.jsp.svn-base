<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>

<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

	<div>
			<h2 class="span12">Original Transaction Details</h2>
            <div class="clear"></div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Product Type</label>
							<div class="radio-container">
								<input type="text" value="${legSummaryVO.productType}" disabled="disabled" />
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right ">
						<div class="form-row">
							<span class="required">*</span>
							<label>Trade ID / Loan Model ID</label>
							<input type="text" value="${legSummaryVO.transactionId}" disabled="disabled" />
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Terms (in months)</label>
							<input type="text" value="${legSummaryVO.termsInMths}" disabled="disabled" />
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Is Transaction Hedged</label>
								<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 1}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 0}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Non Standard Legal Agreement(s)</label>
								<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 1}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 0}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>				
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
							<input type="text" value="${legSummaryVO.dayOneCCY}" disabled="disabled" />
						</div>
					</div> <!-- end of block -->
				</div>
				
					<div class="row">
						<div class="span5 right">
							<div class="form-row">
								<span class="required">*</span>
								<label>Principal / Facility Amount</label>
								<input type="text" value="<fmt:formatNumber value="${legSummaryVO.dayOneCCYAmount}" />" disabled="disabled" />
							</div>
						</div><!-- end of block -->
					
					</div> 
					
				<div class="row">
					<div class="span5 right">
							<div class="form-row">
								<label>USD Equivalent</label>
	                         	 <c:if test="${empty legSummaryVO.dayOneUSD}">
								<p>-</p>
								</c:if>
								<c:if test="${not empty legSummaryVO.dayOneUSD}">
									<p><fmt:formatNumber value="${legSummaryVO.dayOneUSD}" /></p>
								</c:if>
							</div>
						</div> <!-- end of block -->
				</div>
				
		</div>