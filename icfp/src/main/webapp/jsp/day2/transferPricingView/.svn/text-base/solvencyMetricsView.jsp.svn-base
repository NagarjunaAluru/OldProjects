<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata"
	prefix="staticdata"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="transferPricingInfo"
	value="${deal:getTransferPricing(param.id, pageContext.request)}" />
<c:set var="solvencyMatrixList"
	value="${staticdata:getSolvencyMatrixList(pageContext)}" />
<div class="form-mod">
	<h2 class="span12 collapsible">Solvency Metrics</h2>
	<div class="row">
		<div class="span12">
			<table class="table1 table-striped1 table-bordered1 sortable no-bottom table-nested">
				<thead>
					<tr>
						<th rowspan="2">Solvency metrics</th>
						<th rowspan="2">Pre Transaction</th>
						<th rowspan="2">Post Transaction</th>
						<th colspan="3" class="nosort">Fund Co/Hold Co/Op Co
							Thresholds</th>
						<th rowspan="2">Assessment</th>
						<th rowspan="2">Rationale - required only if threshold
							breached</th>
					</tr>
					<tr>
						<th>Pass</th>
						<th>Conditional Pass</th>
						<th>Weak Performer</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>Debt&nbsp;to&nbsp;Equity&nbsp;Ratio&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtToEquityRatio" />"></span></td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[0].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[0].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[0].preTransaction}" /></c:if>
						</td>
						<td> 
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[0].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[0].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[0].postTransaction}" /></c:if>
							<input type="hidden" id="derPostTransactionID" value='${transferPricingInfo.solvencyMetrics[0].postTransaction}'/>
						</td>	
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[0].pass}
					  	  <input type="hidden" id="smpass0id" value='${solvencyMatrixList[0].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[0].conditionalPass}
					 	<input type="hidden" id="smconditionalPass0id" value='${solvencyMatrixList[0].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[0].weakPerformer}
					 	<input type="hidden" id="smweakPerformer0id" value='${solvencyMatrixList[0].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics0TdID" ></td>
						  
						<td>
						    <div class="form-row autosize-container" style="margin-left:-5px;margin-right:10px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[0].comment}</textarea>
						    </div>	
						</td>	 	  	  
						 
					</tr>
					<tr>
						<td>Debt&nbsp;Ratio&nbsp;(Gearing&nbsp;Ratio)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtRatio" />"></span></td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[1].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[1].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[1].preTransaction}" /></c:if>
						</td>
						<td>
						  <c:if test="${empty transferPricingInfo.solvencyMetrics[1].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[1].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[1].postTransaction}" /></c:if>
							
							<input type="hidden" id="drPostTransactionID" value='${transferPricingInfo.solvencyMetrics[1].postTransaction}'/>
						</td>	
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[1].pass}
					  	  <input type="hidden" id="smpass1id" value='${solvencyMatrixList[1].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[1].conditionalPass}
					 	<input type="hidden" id="smconditionalPass1id" value='${solvencyMatrixList[1].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[1].weakPerformer}
					 	<input type="hidden" id="smweakPerformer1id" value='${solvencyMatrixList[1].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics1TdID"> </td>
						<td>
						   <div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[1].comment}</textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td>Interest&nbsp;Coverage&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.interestCoverage"/>"></span></td>
						<td>
						   <c:if test="${empty transferPricingInfo.solvencyMetrics[2].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[2].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[2].preTransaction}" /></c:if>
						</td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[2].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[2].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[2].postTransaction}" /></c:if>
							<input type="hidden" id="icPostTransactionID" value='${transferPricingInfo.solvencyMetrics[2].postTransaction}'/>
							</td>
							
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[2].pass}
					  	 <input type="hidden" id="smpass2id" value='${solvencyMatrixList[2].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[2].conditionalPass}
					 	<input type="hidden" id="smconditionalPass2id" value='${solvencyMatrixList[2].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[2].weakPerformer}
					 	<input type="hidden" id="smweakPerformer2id" value='${solvencyMatrixList[2].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics2TdID"></td>
						<td>
						<div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[2].comment}</textarea>
						 </div>
					   </td>
					</tr>
					<tr>
						<td>Adjusted&nbsp;Current&nbsp;Ratio&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.adjustedCurrentRatio"/>"></span></td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[3].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[3].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[3].preTransaction}" /></c:if>
						</td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[3].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[3].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[3].postTransaction}" /></c:if>
							
							<input type="hidden" id="acrPostTransactionID" value='${transferPricingInfo.solvencyMetrics[3].postTransaction}'/>
							</td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[3].pass}
					  	 <input type="hidden" id="smpass3id" value='${solvencyMatrixList[3].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[3].conditionalPass}
					 	<input type="hidden" id="smconditionalPass3id" value='${solvencyMatrixList[3].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[3].weakPerformer}
					 	<input type="hidden" id="smweakPerformer3id" value='${solvencyMatrixList[3].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics3TdID"></td>
						<td>
						  <div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[3].comment}</textarea>
						 </div>
						</td>
					</tr>
					<tr>
						<td>Positive&nbsp;Equity&nbsp;(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveEquity"/>"></span></td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[4].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[4].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[4].preTransaction}" /></c:if>
						</td>
						<td>
							<c:if test="${empty transferPricingInfo.solvencyMetrics[4].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[4].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[4].postTransaction}" /></c:if>
							<input type="hidden" id="pePostTransactionID" value='${transferPricingInfo.solvencyMetrics[4].postTransaction}'/>
							</td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[4].pass}
					  	 <input type="hidden" id="smpass4id" value='${solvencyMatrixList[4].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[4].conditionalPass}
					 		<input type="hidden" id="smconditionalPass4id" value='${solvencyMatrixList[4].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[4].weakPerformer}
					 	<input type="hidden" id="smweakPerformer4id" value='${solvencyMatrixList[4].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics4TdID"></td>
						<td>
						  <div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[4].comment}</textarea>
							</div>
						</td>
								
					</tr>
					<tr>
						<td>Positive&nbsp;Share&nbsp;Capital&nbsp;(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveShareCapital"/>"></span></td>
						<td>
						    <c:if test="${empty transferPricingInfo.solvencyMetrics[5].preTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[5].preTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[5].preTransaction}" /></c:if>
						</td>
						<td>
							<c:if test="${empty transferPricingInfo.solvencyMetrics[5].postTransaction}">-</c:if>
							<c:if test="${not empty transferPricingInfo.solvencyMetrics[5].postTransaction}"><fmt:formatNumber value="${transferPricingInfo.solvencyMetrics[5].postTransaction}" /></c:if>
							<input type="hidden" id="pscPostTransactionID" value='${transferPricingInfo.solvencyMetrics[5].postTransaction}'/>
							</td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					  	${solvencyMatrixList[5].pass}
					  	 <input type="hidden" id="smpass5id" value='${solvencyMatrixList[5].pass}'/>
					 	</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[5].conditionalPass}
					 	<input type="hidden" id="smconditionalPass5id" value='${solvencyMatrixList[5].conditionalPass}'/>
					    </c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${not empty solvencyMatrixList}">
					 	${solvencyMatrixList[5].weakPerformer}
					 	<input type="hidden" id="smweakPerformer5id" value='${solvencyMatrixList[5].weakPerformer}'/>
						</c:when>
							</c:choose></td>
						<td id="solvencyMetrics5TdID"></td>
						<td>
						  <div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[5].comment}</textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="6">Borrower Insolvent</td>
						<td id="solvencyMetrics6TdID">${deal:getSolvencyMetricsAssessment(param.id, pageContext.request)[6]}
						 <input type="hidden" name="smradioS6"  id="smradioS6" value='${deal:getSolvencyMetricsAssessment(requestScope.legNumber, pageContext.request)[6]}'/>
						</td>


						<td>
						   <div class="form-row autosize-container" style="margin-left:-5px;">
							<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div> 
							<textarea readonly="readonly"
								id="derCommentsID" tabindex="20"
								class="span3 xlarge autosize messageinput" cols="100" rows="5" onblur="scriptInjection(this);">${transferPricingInfo.solvencyMetrics[6].comment}</textarea>
							</div>
						 </td>
						   
					</tr>
				</tbody>
			</table>
			<div>
		     <p><bean:message key="solvencyMatrix.comment" /></p>
			</div>
		</div>
	</div>
</div>
