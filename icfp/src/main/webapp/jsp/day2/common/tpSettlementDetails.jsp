<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>

   <h2>Settlement Details</h2>
				<div class="clear"></div>
				<div class="row highlighted">
					<div class="span5">
							<label>Gross Settlement amount</label>
							<c:if test="${not empty legSummaryVO.grossSettlementAmt}"><fmt:formatNumber value="${legSummaryVO.grossSettlementAmt}" /></c:if>
					</div> <!-- end of block -->
				</div>
						<div class="row">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.payorCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorCDR}">${legSummaryVO.payorCDR}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.payorLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorLegalEntity}">${legSummaryVO.payorLegalEntity}</c:if>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.payorLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorLEName}">${legSummaryVO.payorLEName}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.payorCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorCountry}">${legSummaryVO.payorCountry}</c:if>
							</div><!-- end of block -->
						</div>
						
						<div class="row ">
							<div class="span5">
								<p><b>Is Payor a Regulated Entity?</b></p>
									<c:if test="${not empty legSummaryVO.payorRegulated}">${legSummaryVO.payorRegulated}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b>Is Payor a Principal Entity?</b></p>
									<c:if test="${not empty legSummaryVO.payorPrincipal}">${legSummaryVO.payorPrincipal}</c:if>
							</div><!-- end of block -->
						</div>
					
			
			<div class="row highlighted">
				<div class="span5">
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<c:if test="${empty legSummaryVO.payorMEName}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorMEName}">${legSummaryVO.payorMEName}</c:if>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" /></label>
						<c:if test="${empty legSummaryVO.payorCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorCapital}">${legSummaryVO.payorCapital}</c:if>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row">
				<div class="span5 right">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.payorBusSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorBusSegment}">${legSummaryVO.payorBusSegment}</c:if>
				</div> <!-- end of block -->
				<div class="span5">
						<label><bean:message key="label.addLeg.treasuryCode" /></label>
						<c:if test="${empty legSummaryVO.payorTCode}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorTCode}">${legSummaryVO.payorTCode}</c:if>
				</div> <!-- end of block -->
			</div>
                              
		<div class="row highlighted">
			
			<div class="span5 right">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						<c:if test="${empty legSummaryVO.payorFCHC}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorFCHC}">${legSummaryVO.payorFCHC}</c:if>
			</div> <!-- end of block -->
		</div><!-- end of form form-mod -->
        
    
        
