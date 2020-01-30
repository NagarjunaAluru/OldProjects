<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>

    <h2 class="span12"><c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if></h2>
        <div class="clear"></div>
		<div class="row">
				<div class="span12">        
		<div class="form-mod entitylookup">
			<div id="1a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label><span class="conditional-lender"></span>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select class="span14 cpa-search-id entity-filtername" id="lenderSearchId" disabled="disabled">
									<option value="CDR" disabled="disabled"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD" disabled="disabled"><bean:message key="label.adLeg.goldId" /></option>
								</select>
							
								<input type="text" disabled="disabled" />
								
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE" id="searchByLenderGoldId">Search</a>
								<label class="checkbox info-checkbox pending ">
									<c:if test="${legSummaryVO.entitySetupFlag eq 'Y'}">
										<input type="checkbox" checked="checked" disabled="disabled" />
									</c:if>
									<c:if test="${legSummaryVO.entitySetupFlag != 'Y'}">
										<input type="checkbox" disabled="disabled" />
									</c:if>
									Legal Entity Setup Pending
								</label>
							</div>
						</div>
					</div> 
					
					<c:if test="${legSummaryVO.entitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCDR}">${legSummaryVO.lenderCDR}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLegalEntity}">${legSummaryVO.lenderLegalEntity}</c:if>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLEName}">${legSummaryVO.lenderLEName}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCountry}">${legSummaryVO.lenderCountry}</c:if>
								</div>
							</div>
						</div>
					</c:if>
						<div>
						<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
										 a Regulated Entity?</b></p>

									<div class="radio-container">
										<c:if test="${legSummaryVO.lenderRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.lenderRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									 a Principal Entity?</b></p>
									
									<div class="radio-container">
										<c:if test="${legSummaryVO.lenderPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.lenderPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
									
								</div>
							</div>
						</div>
					</div> 
				</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<input type="text" disabled="disabled" />
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.lenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderCapital}">${legSummaryVO.lenderCapital}</c:if>
					</div>
				</div> 
			</div>
			
			<div class="ME">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<c:if test="${not empty legSummaryVO.lenderMEName}">${legSummaryVO.lenderMEName}</c:if>
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
						<input type="text" disabled="disabled" />
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<c:if test="${empty legSummaryVO.lenderBusinessSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderBusinessSegment}">${legSummaryVO.lenderBusinessSegment}</c:if>
					</div>
				</div>
			</div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<c:if test="${empty legSummaryVO.lenderTCode}">-</c:if>
							<c:if test="${not empty legSummaryVO.lenderTCode}">${legSummaryVO.lenderTCode}</c:if>
						</div>
					</div>
				</div>
			            
		<div class="row">
			<div class="span5 right">
				<div class="form-row">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
					 <select disabled="disabled" class="span2">
						<option disabled="disabled" value="">${legSummaryVO.lenderFCHC}</option>
 					</select>  
				</div>
			</div> <!-- end of block -->
		</div>

		</div><!-- end of form form-mod -->
        </div></div>
        
        
       <h2 class="span12"><c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if></h2>
        <div class="clear"></div>
		<div class="row">
				<div class="span12">        
		<div class="form-mod entitylookup">
			<div id="1a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label><c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select class="span14 cpa-search-id entity-filtername" id="lenderSearchId" disabled="disabled">
									<option value="CDR" disabled="disabled"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD" disabled="disabled"><bean:message key="label.adLeg.goldId" /></option>
								</select>
							
								<input type="text" disabled="disabled" />
								
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE" id="searchByLenderGoldId">Search</a>
								<label class="checkbox info-checkbox pending ">
									<c:if test="${legSummaryVO.borEntitySetupFlag eq 'Y'}">
										<input type="checkbox" checked="checked" disabled="disabled" />
									</c:if>
									<c:if test="${legSummaryVO.borEntitySetupFlag != 'Y'}">
										<input type="checkbox" disabled="disabled" />
									</c:if>
									Legal Entity Setup Pending
								</label>
							</div>
						</div>
					</div> 
					  	<c:if test="${legSummaryVO.borEntitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCDR}">${legSummaryVO.borrowerCDR}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">${legSummaryVO.borrowerLegalEntity}</c:if>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLEName}">${legSummaryVO.borrowerLEName}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.borrowerCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCountry}">${legSummaryVO.borrowerCountry}</c:if>
								</div>
							</div>
						</div>
						</c:if>
						
						<div>
						<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Regulated Entity?</b></p>

									<div class="radio-container">
										<c:if test="${legSummaryVO.borrowerRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.borrowerRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Principal Entity?</b></p>
									
									<div class="radio-container">
										<c:if test="${legSummaryVO.borrowerPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.borrowerPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
									
								</div>
							</div>
						</div>
					</div> 
				</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<input type="text" disabled="disabled" />
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.borrowerCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerCapital}">${legSummaryVO.borrowerCapital}</c:if>
					</div>
				</div> 
			</div>
			
			<div class="ME">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<c:if test="${not empty legSummaryVO.borrowerMEName}">${legSummaryVO.borrowerMEName}</c:if>
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
						<input type="text" disabled="disabled" />
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<c:if test="${empty legSummaryVO.borrowerBusSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerBusSegment}">${legSummaryVO.borrowerBusSegment}</c:if>
					</div>
				</div>
			</div>
			
        <div id="lenderTreasuryDetails">
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<c:if test="${empty legSummaryVO.borrowerTCode}">-</c:if>
							<c:if test="${not empty legSummaryVO.borrowerTCode}">${legSummaryVO.borrowerTCode}</c:if>
						</div>
					</div>
				</div>
		</div>
			            
		<div class="row">
			<div class="span5 right">
				<div class="form-row">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
					 <select disabled="disabled" class="span2">
						<option disabled="disabled" value="">${legSummaryVO.borrowerFCHC}</option>
 					</select>  
				</div>
			</div> <!-- end of block -->
		</div>

		</div><!-- end of form form-mod -->
        </div></div>
                
