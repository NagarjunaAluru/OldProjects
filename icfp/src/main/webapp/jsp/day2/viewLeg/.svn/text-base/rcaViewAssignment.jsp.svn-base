<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>

		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="originalViewTransaction.jsp" />
		<jsp:include page="originalViewLenderBorrower.jsp" />
                
			<h2 class="span12">Assignment Details</h2>
            <div class="clear"></div>
            
        <div class="row">
			<div class="span5">
				<div class="form-row">
				<span class="required">*</span>
	            <label>New  <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
							 or <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
				</label>
	      	<div class="radio-container">
				<c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq true}">
	                <label class="radio"> <input type="radio" checked disabled=disabled/>New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if> </label>
                   	<label class="radio"> <input type="radio"  disabled=disabled/> New <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if> </label>
                </c:if>
                <c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq false}">
                   	<label class="radio"> <input type="radio" disabled=disabled /> New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if> </label>
                   	<label class="radio"> <input type="radio" checked disabled=disabled /> New <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if> </label>
                </c:if>	
            </div>
               
      		 </div>     
        	</div>
        </div>


		<c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq true}">

        <h2 class="span12">New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
											<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if></h2>
        <div class="clear"></div>
		<div class="form-mod">
			<div id="2a" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>New <c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select disabled="disabled" class="span14">
									<option value="CDR" disabled="disabled"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD" disabled="disabled"><bean:message key="label.adLeg.goldId" /></option>
								</select>
							
								<input type="text" disabled="disabled" />
								
								<a href="#1" class="btn" type="submit">Search</a>
								<label class="checkbox info-checkbox pending ">
								
									<c:if test="${legSummaryVO.newLenderEntitySetupFlag eq 'Y'}">
										<input type="checkbox" checked="checked" disabled="disabled" />
									</c:if>
									<c:if test="${legSummaryVO.newLenderEntitySetupFlag != 'Y'}">
										<input type="checkbox" disabled="disabled" />
									</c:if>
									Legal Entity Setup Pending
								</label>
							</div>
						</div> <!-- end of block -->
					</div> 
					  <c:if test="${legSummaryVO.newLenderEntitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderCDR}">${legSummaryVO.newLenderCDR}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderLegalEntity}">${legSummaryVO.newLenderLegalEntity}</c:if>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderLEName}">${legSummaryVO.newLenderLEName}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.newLenderCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.newLenderCountry}">${legSummaryVO.newLenderCountry}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						</c:if>
						
						<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
										 a Regulated Entity?</b></p>
										 
									<c:if test="${legSummaryVO.newLenderRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
		                            <c:if test="${legSummaryVO.newLenderRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
									</c:if>
									
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
									
									<c:if test="${legSummaryVO.newLenderPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
									</c:if>
		                            <c:if test="${legSummaryVO.newLenderPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
									</div>
							</div><!-- end of block -->
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
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.newLenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderCapital}">${legSummaryVO.newLenderCapital}</c:if>
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div>
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">
						<c:if test="${empty legSummaryVO.newLenderMEName}">-</c:if>						
						<c:if test="${not empty legSummaryVO.newLenderMEName}">${legSummaryVO.newLenderMEName}</c:if>
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
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label>Business Segment</label>
						<c:if test="${empty legSummaryVO.newLenderBusinessSegment}">-</c:if>
						<c:if test="${not empty legSummaryVO.newLenderBusinessSegment}">${legSummaryVO.newLenderBusinessSegment}</c:if>
					</div>
				</div>
			</div>
         <div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<c:if test="${empty legSummaryVO.newLenderTCode}">-</c:if>
							<c:if test="${not empty legSummaryVO.newLenderTCode}">${legSummaryVO.newLenderTCode}</c:if>
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
							<c:if test="${empty legSummaryVO.newLenderFCHC}">--Select--</c:if>
							<c:if test="${not empty legSummaryVO.newLenderFCHC}">${legSummaryVO.newLenderFCHC}</c:if></option>
	 				</select>  
	 				  
				</div>
			</div> <!-- end of block -->
		</div>
        </c:if>

		
        
   		<c:if test="${day2legSummaryVO.isNewLenderOrBorrowerFlag eq false}">
        
		<h2 class="span12">New <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if></h2>
        <div class="clear"></div>
			<div id="2b" class="tab-pane fade active in">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>New <c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								
								<select disabled="disabled" class="span14">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" disabled="disabled"/>
								<a href="#1a" class="btn" type="submit">Search</a>
								<label class="checkbox info-checkbox pending">
									<c:if test="${legSummaryVO.newBorEntitySetupFlag eq 'Y'}">
										<input type="checkbox" checked="checked" disabled="disabled" />
									</c:if>
									<c:if test="${legSummaryVO.newBorEntitySetupFlag != 'Y'}">
										<input type="checkbox" disabled="disabled" />
									</c:if>
									Legal Entity Setup Pending
								</label>
							</div>
						</div> <!-- end of block -->
					</div> 
						<c:if test="${legSummaryVO.newBorEntitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerCDR}">${legSummaryVO.newBorrowerCDR}</c:if>
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerLegalEntity}">${legSummaryVO.newBorrowerLegalEntity}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerLEName}">${legSummaryVO.newBorrowerLEName}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<c:if test="${empty legSummaryVO.newBorrowerCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.newBorrowerCountry}">${legSummaryVO.newBorrowerCountry}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						</c:if>
						
				<div>
						<div class="row ">
							<div class="span5">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Regulated Entity?</b></p>

									<c:if test="${legSummaryVO.newBorrowerRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
		                            <c:if test="${legSummaryVO.newBorrowerRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>	
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
									
									<c:if test="${legSummaryVO.newBorrowerPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
		                            <c:if test="${legSummaryVO.newBorrowerPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>	
									</div>
								</div>
							</div>
						</div>
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
						<div class="radio-container">
							<c:if test="${empty legSummaryVO.newBorrowerCapital}">-</c:if>
							<c:if test="${not empty legSummaryVO.newBorrowerCapital}">${legSummaryVO.newBorrowerCapital}</c:if>
						</div>
					</div>
				</div>
			</div>
			
			<div>
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">
						<c:if test="${empty legSummaryVO.newBorrowerMEName}">-</c:if>						
						<c:if test="${not empty legSummaryVO.newBorrowerMEName}">${legSummaryVO.newBorrowerMEName}</c:if>
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
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label>Business Segment</label>
						<div class="radio-container">
							<c:if test="${empty legSummaryVO.newBorrowerBusSegment}">-</c:if>
							<c:if test="${not empty legSummaryVO.newBorrowerBusSegment}">${legSummaryVO.newBorrowerBusSegment}</c:if>
						</div>
					</div>
				</div>
			</div>
			
			 <div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
								<c:if test="${empty legSummaryVO.newBorrowerTCode}">-</c:if>
								<c:if test="${not empty legSummaryVO.newBorrowerTCode}">${legSummaryVO.newBorrowerTCode}</c:if>
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
							<c:if test="${empty legSummaryVO.newBorrowerFCHC}">--Select--</c:if>
							<c:if test="${not empty legSummaryVO.newBorrowerFCHC}">${legSummaryVO.newBorrowerFCHC}</c:if></option>
	 					</select>
					</div>
				</div> <!-- end of block -->
			</div>
        
        </c:if>       
			


			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
							<input type="text" disabled="disabled" value="${legSummaryVO.originalCurrency}"/>
						</div>
					</div> <!-- end of block --> 
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Principal Amount</label>
							<input type="text" disabled="disabled" value="${legSummaryVO.originalAmount}" />
							</div>
					</div> <!-- end of block -->                                       
				</div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Accrued Interest Amount</label>
                            <input type="text" disabled="disabled" value="<fmt:formatNumber value="${legSummaryVO.accruedInterestAmt}" />"/> 
						</div>
					</div> <!-- end of block -->
                    
					<div class="span5 right">
						<div class="form-row">
							<label>USD Equivalent</label>
							<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
							<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Fees</label>
                           <input type="text" disabled="disabled" value="<fmt:formatNumber value="${legSummaryVO.fees}" />"/> 
                            
						</div>
					</div> <!-- end of block -->
					                   
				</div> 
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>P&amp;L Amount from Lender/Provider perspective</label>
                            <input type="text" disabled="disabled" value="<fmt:formatNumber value="${day2legSummaryVO.pandLAmount}" />"/>  
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Original Legal Agreement Attached</label>
									<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">
			                            <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                           	</c:if>
		                            <c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">
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
                            <span class="required">*</span>
							<label>Request Derivatives</label>
							<div class="radio-container">
							<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
			                    <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
		                    <c:if test="${legSummaryVO.derivatives eq 'No'}">
		                        <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
						</div>
					</div> <!-- end of block -->

				</div>
				
				<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
				<div class="row">
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<input type="button" disabled="disabled" value="Add a Derivative" tabindex="18" class="btn">
								
							</div>
						</div> <!-- end of block -->
					</div>
					<c:set var="DerExistsFlag" value="0" />
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2" colspan="2">Action</th>
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
									<tr id='dealDeriv'${derivative.derivativeNumber}>
									   <td id='dealDeriv'${derivative.deriativesSeqId}>
		   		                       <td><a title="View this leg" href="${pageContext.request.contextPath}/derivativeRequest.do?command=openDerivative&view=true&derivativeNumber=${derivative.derivativeNumber}&legNumber=${requestScope.legNumber}&actionId=${actionId}&source=${param.source}" class="view-file"></a>  </td>
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
									<div class="modal hide fade" id="derID">
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
                             
        </div><!-- FORM MODE ENDS HERE --> 
        
		<jsp:include page="viewSettlementDetails.jsp" />
		<jsp:include page="otherViewConsiderations.jsp" />
                
		 				  <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="legIndex" value="${legNumber}" />
			<jsp:param name="mode" value="edit" />
		</jsp:include>  
		<!-- end uploads -->
	<jsp:include page="../../day2CancelReadOnlyTabs.jsp" />	

	
