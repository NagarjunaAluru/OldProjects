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

	 <div>
			<h2 class="span12">Assignment Details</h2>
			<div class="clear"></div>		
			<div class="row highlighted">
				<div class="span5">
				<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		            <label>New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
							 or <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
					</label>
									
		            <c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq true}">New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
					</c:if>
		            <c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq false}">New <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if></c:if> 
		          </div>
       		 </div>
       </div>
        
	
	
	<c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq true}">
						<div class="row">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderCDR}">${legSummaryVO.newLenderCDR}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderLegalEntity}">${legSummaryVO.newLenderLegalEntity}</c:if>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderLEName}">${legSummaryVO.newLenderLEName}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderCountry}">${legSummaryVO.newLenderCountry}</c:if>
							</div><!-- end of block -->
						</div>
						
						<div class="row ">
							<div class="span5">
								<p><b>Is <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
										 a Regulated Entity?</b></p>
									<c:if test="${not empty legSummaryVO.newLenderRegulated}">${legSummaryVO.newLenderRegulated}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									 a Principal Entity?</b></p>
									<c:if test="${not empty legSummaryVO.newLenderPrincipal}">${legSummaryVO.newLenderPrincipal}</c:if>
							</div><!-- end of block -->
						</div>
					
			
			<div class="row highlighted">
				<div class="span5">
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<c:if test="${empty legSummaryVO.newLenderMEName}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderMEName}">${legSummaryVO.newLenderMEName}</c:if>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" /></label>
						<c:if test="${empty legSummaryVO.newLenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderCapital}">${legSummaryVO.newLenderCapital}</c:if>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row">
				<div class="span5 right">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.newLenderBusinessSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderBusinessSegment}">${legSummaryVO.newLenderBusinessSegment}</c:if>
				</div> <!-- end of block -->
				<div class="span5">
						<label><bean:message key="label.addLeg.treasuryCode" /></label>
						<c:if test="${empty legSummaryVO.newLenderTCode}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderTCode}">${legSummaryVO.newLenderTCode}</c:if>
				</div> <!-- end of block -->
			</div>
                              
		<div class="row highlighted">
			
			<div class="span5 right">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						<c:if test="${empty legSummaryVO.newLenderFCHC}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderFCHC}">${legSummaryVO.newLenderFCHC}</c:if>
			</div> <!-- end of block -->
		</div><!-- end of form form-mod -->
       </c:if>    
        
        <c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq false}">
     				  <div class="row">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerCDR}">${legSummaryVO.newBorrowerCDR}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerLegalEntity}">${legSummaryVO.newBorrowerLegalEntity}</c:if>
							</div><!-- end of block -->
						</div>
						<div class="row highlighted">
							<div class="span5">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerLEName}">${legSummaryVO.newBorrowerLEName}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerCountry}">${legSummaryVO.newBorrowerCountry}</c:if>
							</div><!-- end of block -->
						</div>
						
						<div class="row ">
							<div class="span5">
								<p><b>Is
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Regulated Entity?</b></p>

									<c:if test="${not empty legSummaryVO.newBorrowerRegulated}">${legSummaryVO.newBorrowerRegulated}</c:if>
							</div><!-- end of block -->
							<div class="span5 right">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Principal Entity?</b></p>
									
									<c:if test="${not empty legSummaryVO.newBorrowerPrincipal}">${legSummaryVO.newBorrowerPrincipal}</c:if>
							</div><!-- end of block -->
						</div>
					
			
			<div class="row highlighted">
				<div class="span5">
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<c:if test="${empty legSummaryVO.newBorrowerMEName}">-</c:if>
						<c:if test="${not empty legSummaryVO.newBorrowerMEName}">${legSummaryVO.newBorrowerMEName}</c:if>
				</div> <!-- end of block -->
				<div class="span5 right">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" /></label>
						<c:if test="${empty legSummaryVO.newBorrowerCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.newBorrowerCapital}">${legSummaryVO.newBorrowerCapital}</c:if>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row">
				<div class="span5 right">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.newBorrowerBusSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.newBorrowerBusSegment}">${legSummaryVO.newBorrowerBusSegment}</c:if>
				</div> <!-- end of block -->
				<div class="span5">
						<label><bean:message key="label.addLeg.treasuryCode" /></label>
						<c:if test="${empty legSummaryVO.newBorrowerTCode}">-</c:if>
						<c:if test="${not empty legSummaryVO.newBorrowerTCode}">${legSummaryVO.newBorrowerTCode}</c:if>
				</div> <!-- end of block -->
			</div>
                              
		<div class="row highlighted">
			
			<div class="span5 right">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						<c:if test="${empty legSummaryVO.newBorrowerFCHC}">-</c:if>
						<c:if test="${not empty legSummaryVO.newBorrowerFCHC}">${legSummaryVO.newBorrowerFCHC}</c:if>
			</div> <!-- end of block -->
		</div><!-- end of form form-mod -->
       </c:if>
        
