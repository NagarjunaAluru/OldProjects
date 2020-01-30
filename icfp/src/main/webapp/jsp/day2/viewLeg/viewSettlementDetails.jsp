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

		
		<h2>Settlement Details</h2>
        <div class="clear"></div>
			
		<div class="form-mod">

				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Gross Settlement amount</label>
							<div class="radio-container" >
								<c:if test="${empty legSummaryVO.grossSettlementAmt}">-</c:if>
								<c:if test="${not empty legSummaryVO.grossSettlementAmt}"><fmt:formatNumber value="${legSummaryVO.grossSettlementAmt}" /></c:if>
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>Payor
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select disabled="disabled" class="span14">
									<option value="CDR" disabled="disabled">CDR</option>
									<option value="GOLD" disabled="disabled">Gold ID</option>
								</select>
								
								<input type="text" disabled="disabled" />
								<a href="#1a" class="btn" type="submit">Search</a>
								<label class="checkbox info-checkbox pending">
									<c:if test="${legSummaryVO.payorEntitySetupFlag eq 'Y'}">
										<input type="checkbox" checked="checked" disabled="disabled" />
									</c:if>
									<c:if test="${legSummaryVO.payorEntitySetupFlag != 'Y'}">
										<input type="checkbox" disabled="disabled" />
									</c:if>
									Legal Entity Setup Pending
								</label>
							</div>
						</div> <!-- end of block -->
					</div> 
					<c:if test="${legSummaryVO.payorEntitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<c:if test="${empty legSummaryVO.payorCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorCDR}">${legSummaryVO.payorCDR}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<c:if test="${empty legSummaryVO.payorLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorLegalEntity}">${legSummaryVO.payorLegalEntity}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<c:if test="${empty legSummaryVO.payorLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorLEName}">${legSummaryVO.payorLEName}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<c:if test="${empty legSummaryVO.payorCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.payorCountry}">${legSummaryVO.payorCountry}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						</c:if>
						
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b>Is Payor a Regulated Entity?</b></p>

										<c:if test="${legSummaryVO.payorRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.payorRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>	
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is Payor a Principal Entity?</b></p>
									
									<c:if test="${legSummaryVO.payorPrincipal eq 'Yes'}">
			                            <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                <label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
		                            <c:if test="${legSummaryVO.payorPrincipal eq 'No'}">
		                                <label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
			
			<div class="row">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<input type="text" disabled="disabled" />

					</div>
				</div>
				<div class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.payorCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorCapital}">${legSummaryVO.payorCapital}</c:if>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div>
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">
						<c:if test="${empty legSummaryVO.payorMEName}">-</c:if>						
						<c:if test="${not empty legSummaryVO.payorMEName}">${legSummaryVO.payorMEName}</c:if>
					</div>					
				</div>		
				</div>			
			</div>
			
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<input type="text" disabled="disabled"/>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<c:if test="${empty legSummaryVO.payorBusSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.payorBusSegment}">${legSummaryVO.payorBusSegment}</c:if>
					</div>
				</div> <!-- end of block -->
			</div>
			
			  <div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
								<c:if test="${empty legSummaryVO.payorTCode}">-</c:if>
								<c:if test="${not empty legSummaryVO.payorTCode}">${legSummaryVO.payorTCode}</c:if>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
			
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <select disabled="disabled" class="span2">
							 <option disabled="disabled" value="">
							<c:if test="${empty legSummaryVO.payorFCHC}">--Select--</c:if>
							<c:if test="${not empty legSummaryVO.payorFCHC}">${legSummaryVO.payorFCHC}</c:if></option>
	 					</select>  
					</div>
				</div> <!-- end of block -->
			
			</div>
          
