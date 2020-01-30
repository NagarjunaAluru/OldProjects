<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/> 
<t:common/>

<div class="form-mod">
<%String hasEBoard = null;%>
	<h2 class="span12 collapsible" id="legTable"><bean:message key="heading.transactionLegs" /></h2>
	<c:set var="fetchedlegs" value="${deal:fetchLegs(pageContext.request)}"></c:set>

	<div class="row" style="width:940px">
		<div class="span12" style="overflow-x: auto;">
				<c:choose>
          				<c:when test="${param.path == 'fundingRequest/newFundingRequest'}">
							<div class="row">
							<div class="span9">
								<div class="table-btn">
									<span class="required">*</span>
									<button type="submit" name="command" value="addLeg" tabindex="18" class="btn">Add a Leg...</button>
								</div>
								
							</div> <!-- end of block -->
						</div> 
						</c:when>
						
					<c:when test="${param.path == 'frontOffice'}">
					
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<div class="left">
										<span class="required">*</span>
										<label>Select Product</label>
				
									<html:select name="updateStatusForm" property="legTypeId" styleClass="span2" styleId="productType">
									<html:option value="">Select..</html:option>
									<html:optionsCollection name="com.ge.icfp.StaticData" property="productTypes" value="ID" label="name"/>
									</html:select>
									<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
									</div>
					
								</div>
							</div>
							
				<div class="span3" id="eventTypesDiv">
				<div class="form-row">
					<div class="left">
						<label>Select Event</label>
						
						<html:select name="updateStatusForm" property="eventTypeId" styleClass="span3" styleId="eventType" >
							<html:option value="">Select..</html:option>
							<html:option value="">New Transaction</html:option>
							<html:optionsCollection name="updateStatusForm" property="eventTypes" label="value" value="key"/> 
													
						</html:select>
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
					</div>
					
				</div>
			</div>
							
							<div class="span2" style="margin-top:5px;">
							<div class="table-btn">
								<label>&nbsp;</label>
								<input type="button" value="Add a Leg..." class="btn" onclick="javascript:addLeg();" id="addLegButtonID">
							</div>
							</div>
							
							<div class="span13 right">
							<div class="table-btn">
								<label>&nbsp;</label>
															
								<a id="spotRates" class="btn right" href="javascript:void(0)">Refresh Spot Rates</a>
							
								<label class="last-updated">
								<c:if test="${!empty requestScope.currentTime}" >
								 Last Updated: ${requestScope.currentTime} 
								</c:if>
								<%-- <c:out value="${requestScope.currentTime}" /> --%>
								
								</label>
							</div>
							</div>
							
						</div> 
						
						
						</c:when>
				<c:otherwise>
				</c:otherwise>
				</c:choose>
				<label><bean:message key="label.transactionLegs.noOfLegs" />
				${fn:length(fetchedlegs)} </label>
			<table id="transactionLegsTable" 
				class="table table-striped table-bordered sortable no-bottom table-nested">
				
				<thead>
					<tr>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.blank" /></th>
						<c:choose>
          					<c:when test="${param.path == 'frontOffice'}">
							<th rowspan="2" colspan="2"><bean:message key = "columnHeader.transactionLegs.action" /></th>	
							</c:when>
							<c:otherwise>
							<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.action" /></th>
							</c:otherwise>
						</c:choose>
						<th rowspan="2">Trade ID</th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.legNo" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.productType" /></th>
						<th rowspan="2">Event</th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.term" /></th>
						<th colspan="3" class="nosort"><bean:message key = "columnHeader.transactionLegs.lender" /></th>
						<th colspan="3" class="nosort"><bean:message key = "columnHeader.transactionLegs.borrower" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.origCurr" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.usdEquivalent" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.derivatives" /></th>
					</tr>
					<tr>
						<th>Legal Entity GOLD ID</th>
						<th>CDR</th>
						<th><bean:message key = "columnHeader.transactionLegs.country" /></th>
						<th>Legal Entity GOLD ID</th>
						<th>CDR</th>
						<th><bean:message key = "columnHeader.transactionLegs.country" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.currency" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.amount" /></th>

					</tr>
				</thead>
				<tbody>
					<c:set var="rowCounter" value="1"></c:set>
					<c:forEach var="legDetailsId" items="${fetchedlegs}" >
						
						<c:set var="isImmediateDrawdown" value="false"/>
						<c:if test="${legDetailsId.transactionEventType eq 'Immediate Drawdown'}">
							<c:set var="isImmediateDrawdown" value="true"/>
						</c:if>
						
						<tr>
						<c:choose>
          					<c:when test="${legDetailsId.derivatives eq 'Yes' and not isImmediateDrawdown}">
								<td><a href="#" data-nested="<c:out value="nested${rowCounter}"></c:out>" class="exp"></a></td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
										
						<c:choose>
							<c:when test="${param.path == 'pipelineReviewDealLeg'}">
								<td>
								<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" onClick="javascript:submitFormAtViewLeg('${legDetailsId.legNumber}', '${legDetailsId.productType}')" class="view-file"></a>
								</c:if>
								<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'frontOffice'}">
							<td>
							<c:if test="${deal:getTotalNumberofLegs(pageContext.request) == 1}">-</c:if>
							<c:if test="${not isImmediateDrawdown and deal:getTotalNumberofLegs(pageContext.request) != 1}">
								<a href="#deleteConfirm${legDetailsId.legNumber}" class="delete-leg modal-confirm" title="Delete this Leg" data-toggle="modal" >Delete</a>
								
							</c:if>
						    </td>
						    <td>
						    
							<c:if test="${not isImmediateDrawdown}">
								<a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Edit this leg" onclick="javascript:modifyLeg(${legDetailsId.legNumber},'${legDetailsId.productType}');"></a>
									
							</c:if>
							<c:if test="${isImmediateDrawdown}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
							</td>
				   		    </c:when>
				   		    <c:when test="${param.path eq 'riskUnderwriting/riskUnderwriting'}">
				   		    	<td>
				   		    	<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
				   		    	<a title="View this leg" onClick="javascript:submitFormAtViewLeg('${legDetailsId.legNumber}', '${legDetailsId.productType}')" class="view-file"></a>
				   		    	</c:if>
				   		    	<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
				   		    	</td>
				   		    </c:when>
							<c:when test="${param.path eq 'idagEag/idagEag' or param.path eq 'tesg/tesg' or param.path eq 'equityBusinessCFO' or param.path eq 'equityBusinessApprover'}">
								<td>
								<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=viewInputScreens&source=${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.productType}" class="view-file"></a>
								</c:if>
								<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'transactionCaptureFOCMFourBlocker' or param.path == 'transactionCaptureARFourBlocker' or param.path == 'transactionCaptureManagerFourBlocker'}">
								<td>
								<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" onClick="javascript:submitFormAtViewLeg('${legDetailsId.legNumber}', '${legDetailsId.productType}')" class="view-file"></a>
								</c:if>
								<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'searchResults'}">
								<td>
								<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=viewInputScreens&source=search/${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.productType}" class="view-file"></a>
								</c:if>
								<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'transactionCaptureMOFourBlocker'}">
								<td>
								<c:if test="${not isImmediateDrawdown}">
								<a title="View this leg" href="${context}/transactionCapture/${param.path}.do?command=legDetails&id=${legDetailsId.legNumber}&pType=${legDetailsId.productType}" class="view-file"></a>  
								</c:if>
								<c:if test="${isImmediateDrawdown}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:otherwise>
								<td>
								<c:if test="${not isImmediateDrawdown and not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=legDetails&source=${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.productType}" class="view-file"></a>  
								</c:if>
								<c:if test="${isImmediateDrawdown or deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop${rowCounter}" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:otherwise>
						</c:choose>
						<td>${not empty legDetailsId.transactionId ? legDetailsId.transactionId : '-'}</td>
						<td>${legDetailsId.legSeqId}</td>
						<td>${legDetailsId.productType}</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.transactionEventType}">
									-
								</c:when>
								<c:otherwise>
									<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
										<c:if test="${deal:getIncreaseOrDecrease(legDetailsId.legNumber,pageContext.request) eq 1}">Amendment - Facility Increase</c:if>
										<c:if test="${deal:getIncreaseOrDecrease(legDetailsId.legNumber,pageContext.request) eq 2}">Amendment - Facility Decrease</c:if>
									</c:if>
									<c:if test="${legDetailsId.transactionEventTypeId != 5}">
										${legDetailsId.transactionEventType}
									</c:if>
									<c:if test="${isImmediateDrawdown}">
										 for Leg #${legDetailsId.drawDown}
									</c:if>
								</c:otherwise>								
							</c:choose>									
						</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.termsInMths }">
									-
								</c:when>								
								<c:otherwise>
									${legDetailsId.termsInMths}
								</c:otherwise>
							</c:choose>
						</td>
						<c:if test="${empty legDetailsId.lenderLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderLegalEntity}"> 
							<td>${legDetailsId.lenderLegalEntity}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.lenderCDR}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderCDR}"> 
							<td>${legDetailsId.lenderCDR}</td>
						</c:if>
						<c:if test="${empty legDetailsId.lenderCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.lenderCountry}"> 
							<td>${legDetailsId.lenderCountry}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerLegalEntity}"> 
							<td>${legDetailsId.borrowerLegalEntity}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerCDR}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerCDR}"> 
							<td>${legDetailsId.borrowerCDR}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.borrowerCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.borrowerCountry}"> 
							<td>${legDetailsId.borrowerCountry}</td>
						</c:if>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.originalCurrency}">
									-
								</c:when>
								<c:otherwise>
									${legDetailsId.originalCurrency}
								</c:otherwise>
							</c:choose>							
						</td>
							<td>
							<c:choose>
								<c:when test="${isImmediateDrawdown}">
									${deal:getImmediateDrawdownAmount(rowCounter, pageContext.request)}
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${empty legDetailsId.transactionEventType}">
											${legDetailsId.originalAmount}
										</c:when>
										<c:otherwise>
											<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
												<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legDetailsId.legNumber, pageContext.request)}" scope="page"/>
												
												<c:if test="${empty day2legSummaryVO.facilityIncDecAmt}">-</c:if>
												<c:if test="${not empty day2legSummaryVO.facilityIncDecAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecAmt}" /></c:if>	
											</c:if>
											<c:if test="${legDetailsId.transactionEventTypeId != 5}">
												${legDetailsId.originalAmount}	
											</c:if>
										</c:otherwise>								
									</c:choose>	
								</c:otherwise>
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${empty legDetailsId.transactionEventType}">
									<c:choose>
										<c:when test="${empty legDetailsId.usdEquivalent}">
											-
										</c:when>	
										<c:otherwise>
											${legDetailsId.usdEquivalent}
										</c:otherwise>
									</c:choose>	
								</c:when>
								<c:otherwise>
									<c:if test="${legDetailsId.transactionEventTypeId eq 5}">
										<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legDetailsId.legNumber, pageContext.request)}" scope="page"/>
										
										<c:if test="${empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}">-</c:if>
										<c:if test="${not empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecUSDEquivalentAmt}" /></c:if>	
									</c:if>
									<c:if test="${legDetailsId.transactionEventTypeId != 5}">
										<c:choose>
											<c:when test="${empty legDetailsId.usdEquivalent}">
												-
											</c:when>	
											<c:otherwise>
												${legDetailsId.usdEquivalent}
											</c:otherwise>
										</c:choose>	
									</c:if>
								</c:otherwise>								
							</c:choose>	
						</td>						
						<td>
						<c:choose>
						<c:when test="${isImmediateDrawdown}">
							-
						</c:when>
						<c:when test="${legDetailsId.productType eq 'EQUITY'}">
							<bean:message key="label.addLeg.no" />
							<c:set var="eBoardARFlagValue" scope="request" value="yes" />
						</c:when>
						<c:otherwise>
						<c:set var="eBoardARFlagValue" scope="request" value="no" />
							${legDetailsId.derivatives}
						</c:otherwise>
						</c:choose>
						</td>
						
						<c:set var="rowCounter" value="${rowCounter + 1}"></c:set>
						
					
					</tr>
					<div class="modal hide fade deleteConfirm" id="deleteConfirm${legDetailsId.legNumber}">
						<div class="modal-header" >
							<a class="close" data-dismiss="modal">X</a>
							<h3>Delete this Leg</h3>
						</div>
						<div class="modal-body" style="margin-top:-15px;">
							<div class="row">
								<p><b>Are you sure you want to Delete?</b><br>
							</p>
							</div>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn right btn-success" data-dismiss="modal" id="delete-legBtn" onclick="javascript:removeLeg(${legDetailsId.legNumber},${legDetailsId.legSeqId});">Yes, Delete this Leg</a>
							<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
						</div>
					</div>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:set var="rowCounter1" value="1"></c:set>
		<c:forEach var="legDetailsId1" items="${fetchedlegs}" >
			<c:set var="isImmediateDrawdownDerivative" value="false"/>
			<c:if test="${legDetailsId1.transactionEventType eq 'Immediate Drawdown'}">
				<c:set var="isImmediateDrawdownDerivative" value="true"/>
			</c:if>
			<c:choose>
          		<c:when test="${legDetailsId1.derivatives eq 'Yes' and not isImmediateDrawdownDerivative}">
				<table
					class="table table-striped table-bordered sortable no-bottom nested"
					id="<c:out value="nested${rowCounter1}"></c:out>">
					<thead>
						<tr>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.itemNo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeName" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeType" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyOne" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyTwo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.hedgeDesg" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.taxDesg" /></th>
						</tr>
						<tr>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="derivativesSummaryId" items="${legDetailsId1.derivativeDetailsVOList}" varStatus="counter">
						<tr>
							<td>${counter.count} </td>
							<td>${derivativesSummaryId.internalOrExternal }</td>
							<td>${derivativesSummaryId.derivativeType }</td>
							<td>${derivativesSummaryId.currency1 }</td>
							<td>${derivativesSummaryId.derivativeAmount1 }</td>
							<td>${derivativesSummaryId.fixedOrFloat1 }</td>
							<td>${derivativesSummaryId.currency2 }</td>
							<td>${derivativesSummaryId.derivativeAmount2 }</td>
							<td>${derivativesSummaryId.fixedOrFloat2 }</td>
							<td>${derivativesSummaryId.hedgeDesigation }</td>
							<td>${derivativesSummaryId.taxDesigation }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<c:set var="rowCounter1" value="${rowCounter1 + 1}"></c:set>
		</c:forEach>
		
		
	</div>

</div>
	<c:set var="rowCounter2" value="1"></c:set>
	<c:forEach var="eachLegDetail" items="${fetchedlegs}" >
		<c:set var="isImmediateDrawdownPopup" value="false"/>
		<c:if test="${eachLegDetail.transactionEventType eq 'Immediate Drawdown'}">
			<c:set var="isImmediateDrawdownPopup" value="true"/>
		</c:if>
		<c:if test="${isImmediateDrawdownPopup or deal:hideLegView(eachLegDetail.legNumber,pageContext.request)}">
		<div id="pop${rowCounter2}" class="modal hide fade popmodal">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>View Leg</h3>
			</div>
			<div class="modal-body" style="overflow-y: auto; height: 300px;">
			<table class="table table-bordered" >
				<tbody>
					<tr><td>Leg #</td><td>${eachLegDetail.legSeqId}</td></tr>
					<tr><td>Product Type</td><td>${eachLegDetail.productType}</td></tr>
					<tr><td>Event</td><td>
					<c:choose>
						<c:when test="${empty eachLegDetail.transactionEventType}">
							-
						</c:when>
						<c:otherwise>
							<c:if test="${eachLegDetail.transactionEventTypeId eq 5}">
								<c:if test="${deal:getIncreaseOrDecrease(eachLegDetail.legNumber,pageContext.request) eq 1}">Amendment - Facility Increase</c:if>
								<c:if test="${deal:getIncreaseOrDecrease(eachLegDetail.legNumber,pageContext.request) eq 2}">Amendment - Facility Decrease</c:if>
							</c:if>
							<c:if test="${eachLegDetail.transactionEventTypeId != 5}">
								${eachLegDetail.transactionEventType}
							</c:if>
							<c:if test="${isImmediateDrawdown}">
								 for Leg #${eachLegDetail.drawDown}
							</c:if>
						</c:otherwise>
					</c:choose>
					</td></tr>
					<c:choose>
					<c:when test="${eachLegDetail.productType eq 'EQUITY'}">
						<tr><td>Form of Equity</td><td>${deal:getEquityFormId(param.id, pageContext.request)}</td></tr>
					</c:when>
					<c:otherwise>
						<tr><td>Term <span class=small>in months</span></td><td>${not empty eachLegDetail.termsInMths ? eachLegDetail.termsInMths : '-'}</td></tr>
					</c:otherwise>
					</c:choose>
					<tr><td>Currency</td><td>${not empty eachLegDetail.originalCurrency ? eachLegDetail.originalCurrency : '-'}</td></tr>
					<c:if test="${isImmediateDrawdownPopup}">
					<tr><td>Amount</td><td>${deal:getImmediateDrawdownAmount(rowCounter2, pageContext.request)}</td></tr>
					<tr><td>USD Equivalent</td><td>${not empty eachLegDetail.usdEquivalent ? eachLegDetail.usdEquivalent : '-'}</td></tr>
					</c:if>
					<c:if test="${not isImmediateDrawdownPopup}">
					<tr><td>Amount</td><td>${not empty eachLegDetail.originalAmount ? eachLegDetail.originalAmount : '-'}</td></tr>
					<tr><td>USD Equivalent</td><td>${not empty eachLegDetail.usdEquivalent ? eachLegDetail.usdEquivalent : '-'}</td></tr>
					</c:if>
					
					<tr><td>Lender/Provider Legal Entity Setup Pending</td><td>${eachLegDetail.lenderLegalEntitySetupFlag}</td></tr>
					<tr><td>Is Lender/Provider a Regulated Entity</td><td>${eachLegDetail.lenderRequlatedEntity}</td></tr>
					<tr><td>Is Lender/Provider a Principal Entity</td><td>${eachLegDetail.lenderPrincipalEntity}</td></tr>
					<tr><td>Lender/Provider Treasury Code</td><td>${not empty eachLegDetail.lenderTCode ? eachLegDetail.lenderTCode : '-'}</td></tr>
					<tr><td>Lender/Provider Funding Company/Holding Company/Operating Company</td><td>${not empty eachLegDetail.lenderFCHC ? eachLegDetail.lenderFCHC : '-'}</td></tr>
					
					<tr><td>Lender/Provider LE Gold Id</td><td>${not empty eachLegDetail.lenderLegalEntity ? eachLegDetail.lenderLegalEntity : '-'}</td></tr>
					<tr><td>Lender/Provider CDR</td><td>${not empty eachLegDetail.lenderCDR ? eachLegDetail.lenderCDR : '-'}</td></tr>
					<tr><td>Lender/Provider Country</td><td>${not empty eachLegDetail.lenderCountry ? eachLegDetail.lenderCountry : '-'}</td></tr>
					<tr><td>Lender/Provider LE Name</td><td>${not empty eachLegDetail.lenderLEName ? eachLegDetail.lenderLEName : '-'}</td></tr>
					<tr><td>Lender/Provider ME</td><td>${not empty eachLegDetail.lenderMEName ? eachLegDetail.lenderMEName : '-'}</td></tr>
					<tr><td>Lender/Provider Capital</td><td>${not empty eachLegDetail.lenderCapital ? eachLegDetail.lenderCapital : '-'}</td></tr>
					<tr><td>Lender/Provider BusinessSegment</td><td>${not empty eachLegDetail.lenderBusinessSegment ? eachLegDetail.lenderBusinessSegment : '-'}</td></tr>
					
					<tr><td>Borrower/Recipient Legal Entity Setup Pending</td><td>${eachLegDetail.borrowerLegalEntitySetupFlag}</td></tr>
					<tr><td>Is Borrower/Recipient a Regulated Entity</td><td>${eachLegDetail.borrowerRequlatedEntity}</td></tr>
					<tr><td>Is Borrower/Recipient a Principal Entity</td><td>${eachLegDetail.borrowerPrincipalEntity}</td></tr>
					<tr><td>Borrower/Recipient Treasury Code</td><td>${not empty eachLegDetail.borrowerTCode ? eachLegDetail.borrowerTCode : '-'}</td></tr>
					<tr><td>Borrower/Recipient Funding Company/Holding Company/Operating Company</td><td>${not empty eachLegDetail.borrowerFCHC ? eachLegDetail.borrowerFCHC : '-'}</td></tr>
					
					<tr><td>Borrower/Recipient LE Gold Id</td><td>${not empty eachLegDetail.borrowerLegalEntity ? eachLegDetail.borrowerLegalEntity : '-'}</td></tr>
					<tr><td>Borrower/Recipient CDR</td><td>${not empty eachLegDetail.borrowerCDR ? eachLegDetail.borrowerCDR : '-'}</td></tr>
					<tr><td>Borrower/Recipient Country</td><td>${not empty eachLegDetail.borrowerCountry ? eachLegDetail.borrowerCountry : '-'}</td></tr>
					<tr><td>Borrower/Recipient LE Name</td><td>${not empty eachLegDetail.borrowerLEName ? eachLegDetail.borrowerLEName : '-'}</td></tr>
					<tr><td>Borrower/Recipient ME</td><td>${not empty eachLegDetail.borrowerMEName ? eachLegDetail.borrowerMEName : '-'}</td></tr>
					<tr><td>Borrower/Recipient Capital</td><td>${not empty eachLegDetail.borrowerCapital ? eachLegDetail.borrowerCapital : '-'}</td></tr>
					<tr><td>Borrower/Recipient BusinessSegment</td><td>${not empty eachLegDetail.borrowerBusSegment ? eachLegDetail.borrowerBusSegment : '-'}</td></tr>
					
					<tr><td>Is transaction hedged</td><td>${eachLegDetail.isTransactionHedged}</td></tr>
					<tr><td>Non Standard Legal Agrements</td><td>${eachLegDetail.nonStandardLegalAgrements}</td></tr>
					<tr><td>DrawDown Notice Attached</td><td>${eachLegDetail.drawDownNoticeAttached}</td></tr>
					<tr><td>Facility Decrease Amount</td><td>${eachLegDetail.facilityIncDecAmt}</td></tr>
					<tr><td>Facility Decrease USD Equivalent</td><td>${eachLegDetail.facilityIncDecUSDEquivalentAmt}</td></tr>
					<tr><td>Amended Facility Amount</td><td>${eachLegDetail.amendedUSDEquivalentAmt}</td></tr>
					
					
					<c:if test="${eachLegDetail.transactionEventTypeId eq 6 or eachLegDetail.transactionEventTypeId eq 10}">
					<tr><td>Currency</td><td>${not empty eachLegDetail.originalCurrency ? eachLegDetail.originalCurrency : '-'}</td></tr>
					<tr><td>Principal / Facility Amount</td><td>${not empty eachLegDetail.originalAmount ? eachLegDetail.originalAmount : '-'}</td></tr>
					<tr><td>USD Equivalent</td><td>${not empty eachLegDetail.usdEquivalent ? eachLegDetail.usdEquivalent : '-'}</td></tr>
					</c:if>
					
					<c:if test="${!(eachLegDetail.transactionEventTypeId eq 6 and eachLegDetail.transactionEventTypeId eq 10)}">
					<tr><td>Currency</td><td>${not empty eachLegDetail.dayOneCCY ? eachLegDetail.dayOneCCY : '-'}</td></tr>
					<tr><td>Principal / Facility Amount</td><td>${not empty eachLegDetail.dayOneCCYAmount1 ? eachLegDetail.dayOneCCYAmount1 : '-'}</td></tr>
					<tr><td>USD Equivalent</td><td>${not empty eachLegDetail.dayOneUSD1 ? eachLegDetail.dayOneUSD1 : '-'}</td></tr>
					</c:if>
					
					<tr><td>Trade ID / Loan Model ID</td><td>${not empty eachLegDetail.transactionId ? eachLegDetail.transactionId : '-'}</td></tr>
					<tr><td>Accrued Interest Amount</td><td>${not empty eachLegDetail.accruedInterestAmt1 ? eachLegDetail.accruedInterestAmt1 : '-'}</td></tr>
					<c:if test="${isImmediateDrawdownPopup}">
					<tr><td>Derivatives</td><td>-</td></tr>
					</c:if>
					<c:if test="${not isImmediateDrawdownPopup}">
					<tr><td>Derivatives</td><td>${eachLegDetail.derivatives}</td></tr>
					</c:if>
				</tbody>
			</table>
			</div>
			<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			</div>
		</div>
		</c:if>
		<c:set var="rowCounter2" value="${rowCounter2 + 1}"></c:set>
	</c:forEach>
	<script type="text/javascript" src="${context}/js/common/transactionLegs.js">
	
	</script>