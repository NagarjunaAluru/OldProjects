<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
		<c:set var="actionId" value="${requestScope.actionId}" />
		<c:set var="legNumber" value="${requestScope.legNumber}" />
        <c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
        <c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
        
		<%@ include file="/jsp/common/inc/newTransactionSummary.jsp"%>
			
		<h2 class="span12"><c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if></h2>
        <div class="clear"></div>
		<div class="row">
				<div class="span12">        
		<div class="form-mod">
			<div id="1a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label><c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}">  Purchaser </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select class="span14" disabled="disabled">
									<option value="CDR" disabled="disabled"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD" disabled="disabled"><bean:message key="label.adLeg.goldId" /></option>
								</select>
							
								<input type="text" disabled="disabled" />
								
								<a href="#1" class="btn" type="submit">Search</a>
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
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.lenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderCapital}">${legSummaryVO.lenderCapital}</c:if>
					</div>
				</div> 
			</div>
			
			<div>
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
						<option disabled="disabled" value="">
						<c:if test="${empty legSummaryVO.lenderFCHC}">--Select--</c:if>
						<c:if test="${not empty legSummaryVO.lenderFCHC}">${legSummaryVO.lenderFCHC}</c:if>
						</option>
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
		<div class="form-mod">
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
								
								<select class="span14" disabled="disabled">
									<option value="CDR" disabled="disabled"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD" disabled="disabled"><bean:message key="label.adLeg.goldId" /></option>
								</select>
							
								<input type="text" disabled="disabled" />
								
								<a href="#1" class="btn" type="submit">Search</a>
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
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.borrowerCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerCapital}">${legSummaryVO.borrowerCapital}</c:if>
					</div>
				</div> 
			</div>
			
			<div>
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
			
        <div>
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
						<option disabled="disabled">
						<c:if test="${empty legSummaryVO.borrowerFCHC}">--Select--</c:if>
						<c:if test="${not empty legSummaryVO.borrowerFCHC}">${legSummaryVO.borrowerFCHC}</c:if>
						</option>
 					</select>  
				</div>
			</div> <!-- end of block -->
		</div>

		</div><!-- end of form form-mod -->
        </div></div>
        
        <h3 class="span12">Product Details</h3>
        <c:choose>
        <c:when test="${legSummaryVO.legTypeId ne 2}">

			<div class="row">
			 <div class="span5">
			 	<span class="required">*</span>
				<label><bean:message key="label.addLeg.productType" /></label>
					${legSummaryVO.productType}
				</div>
			
			  <div  class="span5 right">
				<span class="required">*</span>
				<label><bean:message key="label.addLeg.dealCurrency" /></label>
				<input type="text" disabled="disabled" value="${legSummaryVO.originalCurrency}"/>
			   </div>
			</div>
			
			<div class="row">
			 <div class="span5">
					<span class="required">*</span>
						<label><bean:message key="label.addLeg.term" /> 
						<span class="small"><bean:message key="label.addLeg.inMonths" /></span></label>
					<input type="text" value="${legSummaryVO.termsInMths}" disabled="disabled" />
			 </div>
			 
			 <div class="span5 right">
				<span class="required">*</span>
				 <label> <bean:message key="label.addLeg.amount" />
				  <span data-original-title="<bean:message key="label.fundingRequestaddLegTooltip.amount" />" class="ttip info"></span></label>
				<input type="text" disabled="disabled" value="${legSummaryVO.originalAmount}" />
			 </div>
			  
			</div>
			
			<div class="row">
			 
			 <div class="span5">
			 <div class="form-row">
				<span class="required">*</span>
				<label>Subordinated Debt</label>
				<span  class="help-block error" id="subordinatedfailed" style="display:none;">Please select Subordinated Debt</span>
				 <c:if test="${legSummaryVO.isSubordinatedDebt eq true}">
	                   <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                 </c:if>
                 <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">
                       <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                </c:if>
			 </div>
			 </div>
			 
			 <div class="span5 right">
			  <div class="form-row">
				<p><b>USD equivalent</b></p>
							<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
							<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
			   </div>
			 </div>
									
			</div>
			
			<div class="row">
			
			 <div class="span5">
			  <div class="form-row">
				<div><span class="required">*</span></div>
				<label>Cross Border</label>
				<c:choose>
					<c:when test="${empty deal:getLegCrossBorderFlagValue(legNumber, pageContext.request)}">
						<c:out value="-" />
					</c:when>
					<c:when test="${deal:getLegCrossBorderFlagValue(legNumber, pageContext.request) eq true}">
						<label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                 		<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
					</c:when>
					<c:when test="${deal:getLegCrossBorderFlagValue(legNumber, pageContext.request) eq false}">
						<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                 	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
					</c:when>
				</c:choose>
			   </div>
			 </div>
			 <c:if test="${legSummaryVO.legTypeId eq 6 }">
				 <div class="span5 right">
				  <div class="form-row">
					<p><b>Issue Price %</b></p>
						<c:if test="${empty legSummaryVO.issuePrice }">-</c:if>
						<c:if test="${not empty legSummaryVO.issuePrice }">${legSummaryVO.issuePrice }</c:if>
				   </div>
				 </div>
			 </c:if>
			 
			 
			</div>
			
			<div class="row">
			 <div class="span5">
				<div class="form-row">
				<div id="derMandatoryDiv"><span class="required">*</span></div>
				<label>Are there Derivatives?</label>
				<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Are there Derivatives?</span>
				<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
			                    <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
		                    <c:if test="${legSummaryVO.derivatives eq 'No'}">
		                        <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
			   </div>
			 </div>
			 <c:if test="${legSummaryVO.legTypeId eq 6 }">
				 <div class="span5 right">
				  <div class="form-row">
					<p><b>Agent/Dealer Commission %</b></p>
						<c:if test="${empty legSummaryVO.agentDealerCommission }">-</c:if>
						<c:if test="${not empty legSummaryVO.agentDealerCommission }">${legSummaryVO.agentDealerCommission }</c:if>
				   </div>
				 </div>
			 </c:if>
			</div>
				
			<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
				<div class="row">
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<input type="button" disabled="disabled" value="Add a Derivative" tabindex="18" class="btn" onclick="javascript:addDerivatives('?command=addDerivatives');">
								
							</div>
						</div> <!-- end of block -->
					</div>
					<c:set var="DerExistsFlag" value="0" />
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2">Action</th>
							<th rowspan="2">Item No.</th>
							<th rowspan="2">Derivatives</th>
							<th rowspan="2">Derivative Type</th>
							<th colspan="3" class="nosort">Currency 1</th>
							<th colspan="3" class="nosort">Currency 2</th>
							<th rowspan="2">Hedge Designation</th>
							<th rowspan="2">Tax Designation</th>
						  </tr>
						  <tr>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
						  </tr>
						</thead>
						<tbody>
						<c:set var="derivativeDetailsVOList" value="${deal:fetchDerivatives(requestScope.legNumber, pageContext)}" />
						<c:choose>
							<c:when test="${not empty derivativeDetailsVOList}">
								<c:forEach var="derivative" items="${derivativeDetailsVOList}">
									<tr id='dealDeriv'${derivative.deriativesSeqId}>
		   		                       <td><a title="View this leg" href="${context}/derivativeRequest.do?command=openDerivative&view=true&derivativeNumber=${derivative.derivativeNumber}&legNumber=${requestScope.legNumber}&actionId=${actionId}&source=${param.source}&derivativeViewFlag=${param.derivativeViewFlag}" class="view-file"></a>  </td>
										<td id="itemNoId">${derivative.derivativeNumber}</td>
										<c:set var="DerExistsFlag" value="${derivative.derivativeNumber}" />
										<td>${derivative.internalOrExternal}</td>
										<td>${derivative.derivativeType}</td>
										<td>${derivative.currency1}</td>
										<td>${derivative.derivativeAmount1}</td>
										<td>${derivative.fixedOrFloat1}</td>
										<td>${derivative.currency2}</td>
										<td>${derivative.derivativeAmount2}</td>
										<td>${derivative.fixedOrFloat2}</td>
										<td>${derivative.hedgeDesigation}</td>
										<td>${derivative.taxDesigation}</td>
									</tr>
									<div class="modal hide fade" id="derDeleteConfirm">
										<div class="modal-header" >
											<a class="close" data-dismiss="modal">X</a>
											<h3>Delete this Derivative</h3>
										</div>
										<div class="modal-body" style="margin-top:-15px;">
											<div class="row">
												<p><b>Are you sure you want to Delete?</b><br>
											</p>
											</div>
										</div>
										<div class="modal-footer">
											<a href="#" class="btn right btn-success" data-dismiss="modal" id="delete-legBtn" onclick="javascript:deleteDerivative(${derivative.derivativeNumber});">Yes, Delete this Derivative</a>
											<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>	
							</c:otherwise>
						</c:choose>
						
						</tbody>
					  </table>
					  <input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
					</div>
				</div> 
				</c:if>
			
			<div class="row">
				
				<div class="span5">
				<div class="form-row">
					<label>Non-standard Legal Agreement(s)</label>
					<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">
									 <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq false}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
					</div>
				</div>		
				
				 <c:if test="${legSummaryVO.legTypeId eq 6 }">
				 <div class="span5 right">
				  <div class="form-row">
					<p><b>Net Proceeds</b></p>
								<c:if test="${empty legSummaryVO.netProceedsAmt }">-</c:if>
								<c:if test="${not empty legSummaryVO.netProceedsAmt}">${legSummaryVO.netProceedsAmt }</c:if>
				   </div>
				 </div>
			 </c:if>
				
			</div>
        </c:when>
        
        <c:otherwise>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.productType" /></label>
						${legSummaryVO.productType}
					</div>
				</div> 
				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Form of Equity</label>
						<c:if test="${empty deal:getEquityFormId(requestScope.legNumber, pageContext.request)}">Select..</c:if>
						<c:if test="${not empty deal:getEquityFormId(requestScope.legNumber, pageContext.request)}">${deal:getEquityFormId(requestScope.legNumber, pageContext.request)}</c:if>
					</div>
				</div>
			</div>
			
			<c:if test="${not empty deal:getEquityFormId(requestScope.legNumber, pageContext.request)}">
				<div>
				<h3 class="span12">Equity Details</h3>
				<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered equity-validation">
					<thead>
					  <tr>
						<th class="header" style="width:35px;">Action</th>
						<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
							<th class="header">Debt terms</th>
						</c:if>
						<th class="header">Share type</th>
						<th class="header">Number of shares</th>
						<th class="header">Par value per share</th>
					  </tr>
					</thead>
					<tbody>	
					<c:forEach var="shareInfo" items="${deal:getShareInfoList((requestScope.legNumber), pageContext.request)}" varStatus="itemNo">
						<tr>
							  <td>-</td>
							  <c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
							  	<td>${shareInfo.debtTerms}</td>
							  </c:if>
							  <td>${shareInfo.shareType}</td>
							  <td><fmt:formatNumber value="${shareInfo.numberOfShares}" /></td>
							  <td><fmt:formatNumber value="${shareInfo.shareValue}" /></td>
					    </tr>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
			</c:if>
					
			<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Other'}">	
			<div class="row">
				<div class="span5">
						<h3 class="span12">Description</h3>
                             ${deal:getOtherEquityComments(requestScope.legNumber, pageContext.request)}
				</div> <!-- end of block -->
			</div>
			</c:if>
			
			<div class="row">
			 
			 <div class="span5">
			 <div class="form-row">
				<span class="required">*</span>
				<label>Subordinated Debt</label>
				<c:if test="${legSummaryVO.isSubordinatedDebt eq true}">
	                   <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                 </c:if>
                 <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">
                       <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                </c:if>
			 </div>
			 </div>
			 
			 <div  class="span5 right">
				<div class="form-row">
				<span class="required">*</span>
				<label><bean:message key="label.addLeg.dealCurrency" /></label>
				<input type="text" disabled="disabled" value="${legSummaryVO.originalCurrency}"/>
			   </div>
			  </div> 
									
			</div>
			
			<div class="row">
			
			 <div  class="span5">	
			 <div class="form-row">
				<span class="required">*</span>
				<label>Double Leverage</label>
				<div class="radio-container">
				<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq true}">
	                   <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                 </c:if>
                 <c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq false}">
                       <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                       <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                </c:if>
				</div>
			 </div>
			 </div>
			 
			 <div class="span5 right">
				<div class="form-row">
				<span class="required">*</span>
				<label>
				  <bean:message key="label.addLeg.amount" />
				  <span data-original-title="<bean:message key="label.fundingRequestaddLegTooltip.amount" />" class="ttip info"></span>
				</label>
				<input type="text" disabled="disabled" value="${legSummaryVO.originalAmount}" /> 
			   </div>
			 </div>
			
			</div>
			
			<div class="row">
			
			 <div class="span5">
			  <div class="form-row">
				<span class="required">*</span>
				<label>Cross Border</label>
				<c:choose>
					<c:when test="${empty deal:getLegCrossBorderFlagValue(legNumber, pageContext.request)}">
						<c:out value="-" />
					</c:when>
					<c:when test="${deal:getLegCrossBorderFlagValue(legNumber, pageContext.request) eq true}">
						<label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                 		<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
					</c:when>
					<c:when test="${deal:getLegCrossBorderFlagValue(legNumber, pageContext.request) eq false}">
						<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                 	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
					</c:when>
				</c:choose>
			   </div>
			 </div>
			 
			 <div class="span5 right">
			  <div class="form-row">
				<p><b>USD equivalent</b></p>
				<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
				<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
			  </div>
			 </div>
			
			</div>
			  
			 
			
			<div class="row">
			
			<div class="span5">
				<div class="form-row">
					<div><span class="required">*</span></div>
					<label>Non-standard Legal Agreement(s)</label>
						<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">
						 <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                             	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                             </c:if>
                             <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq false}">
                             	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                             	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                             </c:if>
				</div>
			 </div>	
			 <div class="span5 right">
									<div class="form-row">
										<b>eBoardroom Eligible</b><br />  ${deal:getEBoardApprovalRequiredFlag(requestScope.legNumber, pageContext.request)}
									</div>
								</div><!-- end of block -->
			 
			</div>				
        </c:otherwise>
        </c:choose>
			
			
		
		<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">  
		 <jsp:include page="/jsp/common/legPageExceptions.jsp">
			<jsp:param value="view" name="mode"/>
			<jsp:param value="${legNumber}" name="legIndex"/>      	
	      </jsp:include>
	 	</c:if>
		<c:choose>
		<c:when test="${legSummaryVO.legTypeId eq 4}">
			<h3 class="span12">Description</h3>
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
	  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
		   
