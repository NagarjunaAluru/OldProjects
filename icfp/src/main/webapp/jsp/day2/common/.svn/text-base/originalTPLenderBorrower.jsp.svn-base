<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
    <h2 class="span12">	<c:if test="${legSummaryVO.legTypeId eq 1}">Original Lender </c:if>
						<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Original Provider</c:if>
						<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Receiver</c:if>
						<c:if test="${legSummaryVO.legTypeId eq 6}">Original Purchaser </c:if>
						<c:if test="${legSummaryVO.legTypeId eq 5}">Original Lender </c:if>
						<c:if test="${legSummaryVO.legTypeId eq 4}">Original Lender </c:if></h2>
						<div class="clear"></div>		
						<div class="row highlighted">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCDR}">${legSummaryVO.lenderCDR}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLegalEntity}">${legSummaryVO.lenderLegalEntity}</c:if>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLEName}">${legSummaryVO.lenderLEName}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCountry}">${legSummaryVO.lenderCountry}</c:if>
							</div><!-- end of block -->
						</div>
						
						<div class="row highlighted">
							<div class="span5">
								<p><b>Is <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Provider</c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Receiver</c:if>
										<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
										 a Regulated Entity?</b></p>
									<c:if test="${not empty legSummaryVO.lenderRegulated}">${legSummaryVO.lenderRegulated}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Provider</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Receiver</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									 a Principal Entity?</b></p>
									<c:if test="${not empty legSummaryVO.lenderPrincipal}">${legSummaryVO.lenderPrincipal}</c:if>
							</div><!-- end of block -->
						</div>
					
			
			<div class="row">
				<div class="span5">
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<c:if test="${empty legSummaryVO.lenderMEName}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderMEName}">${legSummaryVO.lenderMEName}</c:if>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" /></label>
						<c:if test="${empty legSummaryVO.lenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderCapital}">${legSummaryVO.lenderCapital}</c:if>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row highlighted">
				<div class="span5 right">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.lenderBusinessSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderBusinessSegment}">${legSummaryVO.lenderBusinessSegment}</c:if>
				</div> <!-- end of block -->
				<div class="span5">
						<label><bean:message key="label.addLeg.treasuryCode" /></label>
						<c:if test="${empty legSummaryVO.lenderTCode}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderTCode}">${legSummaryVO.lenderTCode}</c:if>
				</div> <!-- end of block -->
			</div>
                              
		<div class="row">
			
			<div class="span5 right">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						<c:if test="${empty legSummaryVO.lenderFCHC}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderFCHC}">${legSummaryVO.lenderFCHC}</c:if>
			</div> <!-- end of block -->
		</div><!-- end of form form-mod -->
        
        <h2 class="span12"><c:if test="${legSummaryVO.legTypeId eq 1}"> Original Borrower </c:if>
        					<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Original Recipient</c:if>
							<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Payer</c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Original Issuer </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Original Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Original Borrower </c:if></h2>
						<div class="clear"></div>		
						<div class="row highlighted">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCDR}">${legSummaryVO.borrowerCDR}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">${legSummaryVO.borrowerLegalEntity}</c:if>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLEName}">${legSummaryVO.borrowerLEName}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCountry}">${legSummaryVO.borrowerCountry}</c:if>
							</div><!-- end of block -->
						</div>
						
						<div class="row highlighted">
							<div class="span5">
								<p><b>Is
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Recipient</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Payer</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Regulated Entity?</b></p>

									<c:if test="${not empty legSummaryVO.borrowerRegulated}">${legSummaryVO.borrowerRegulated}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 11}">Recipient</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2 && legSummaryVO.transactionEventTypeId eq 12}">Payer</c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Principal Entity?</b></p>
									
									<c:if test="${not empty legSummaryVO.borrowerPrincipal}">${legSummaryVO.borrowerPrincipal}</c:if>
							</div><!-- end of block -->
						</div>
					
			
			<div class="row">
				<div class="span5">
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<c:if test="${empty legSummaryVO.borrowerMEName}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerMEName}">${legSummaryVO.borrowerMEName}</c:if>
				</div> <!-- end of block -->
				<div class="span5 right">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" /></label>
						<c:if test="${empty legSummaryVO.borrowerCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerCapital}">${legSummaryVO.borrowerCapital}</c:if>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row highlighted">
				<div class="span5 right">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.borrowerBusSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerBusSegment}">${legSummaryVO.borrowerBusSegment}</c:if>
				</div> <!-- end of block -->
				<div class="span5">
						<label><bean:message key="label.addLeg.treasuryCode" /></label>
						<c:if test="${empty legSummaryVO.borrowerTCode}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerTCode}">${legSummaryVO.borrowerTCode}</c:if>
				</div> <!-- end of block -->
			</div>
                              
		<div class="row">
			
			<div class="span5 right">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						<c:if test="${empty legSummaryVO.borrowerFCHC}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerFCHC}">${legSummaryVO.borrowerFCHC}</c:if>
			</div> <!-- end of block -->
		</div><!-- end of form form-mod -->
        
