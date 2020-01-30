<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
		<div class="form-mod">
			<h3 class="span12">Model Type</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Model Type</label> 
						 <logic:messagesPresent property="TPLegRequest.modelTypeId">
							<span class="req-error" >a</span>
						   </logic:messagesPresent>
						<html:select name="cpaLegRequestForm" styleId="me-conditional-select"  property="TPLegRequest.modelTypeId"  onchange="resetModelValues()" styleClass="check">
	   							<html:option value="">Select...</html:option>
	   							<html:optionsCollection name="com.ge.icfp.StaticData" property="modelTypes" value="ID" label="name"/>
   						   </html:select>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
        <html:hidden  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.fundHoldOperationId"  styleId="fundHoldOperationId" />
        <div class="form-mod mDrivers" id="Other">
			<h3 class="span12">Model Drivers - Statutory Financials</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Total Debt (USD)</label>
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
						<logic:messagesPresent property="TPLegRequest.totalDebt">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text  name="cpaLegRequestForm" styleClass="span2 currencynoconversion"   property="TPLegRequest.totalDebt"  styleId="totalDebtUSDID"  maxlength="25"   />
						   <span class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Total Debt/Total Capital</label>
						<logic:messagesPresent property="TPLegRequest.totalDebtCaptialRatio">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.totalDebtCaptialRatio"  styleId="totalDebtTotalCapitalID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Total Capital (USD)</label>
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
						<logic:messagesPresent property="TPLegRequest.totalCapital">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span2 currencynoconversion"   property="TPLegRequest.totalCapital"  styleId="totalCapitalUSDID"  maxlength="25"   />
						<span class="req-error" style="display:none;">error</span> 
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Charge-off/Receivables</label>
						<logic:messagesPresent property="TPLegRequest.netChargeOffReceivables">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.netChargeOffReceivables"  styleId="netChangeOffID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Net Income (USD)</label>
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
						<logic:messagesPresent property="TPLegRequest.netIncome">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span2 currencynegnoconversion"   property="TPLegRequest.netIncome"  styleId="netIncomeUSDID"  maxlength="25"   />
						<span class="req-error" style="display:none;">error</span>  
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Interest Margin</label>
						<logic:messagesPresent property="TPLegRequest.netInterestMargin">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.netInterestMargin"  styleId="netInterestMarginID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row input-append">
						
						<label>Return on Avg. Assets</label>
						<logic:messagesPresent property="TPLegRequest.returnOnAvgAssets">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.returnOnAvgAssets"  styleId="returnOnAvgAssetsID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
        
         <div class="clear"></div>
		<div class="alert fade in alert-success" id="mDriversAlert" >
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>See Pricing Attachment</strong> 
        </div>
        
		<div class="form-mod">
			<h3 class="span12">Scores</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Model Score</label>
						<logic:messagesPresent property="TPLegRequest.modelScoreId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="cpaLegRequestForm"  property="TPLegRequest.modelScoreId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="modelScores" value="ID" label="name"/>
						</html:select>
					</div>
						
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>S&P Rating</label>
						<logic:messagesPresent property="TPLegRequest.SPRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <html:select name="cpaLegRequestForm"  property="TPLegRequest.SPRatingId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="SNPRatings" value="ID" label="name"/>
						 </html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Range</label>
						  <logic:messagesPresent property="TPLegRequest.rangeId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="cpaLegRequestForm"  property="TPLegRequest.rangeId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="ranges" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Final Rating</label>
						<logic:messagesPresent property="TPLegRequest.finalRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="cpaLegRequestForm"  property="TPLegRequest.finalRatingId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="finalRating" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Sovereign Constraint</label>
						
	               		 <div class="radio-container">
	                    
							<label class="radio">
								<html:radio name="cpaLegRequestForm"  property="TPLegRequest.sovereignConstraintFlag"  value="true" ></html:radio> Yes
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm"  property="TPLegRequest.sovereignConstraintFlag"  value="false" ></html:radio> No
							</label>
						</div>
					</div>
					
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Qualitative Notches</label>
						<logic:messagesPresent property="TPLegRequest.qualitativeNotches">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.qualitativeNotches"  styleId="qualitativeNotchesID"  maxlength="20"   />
					</div>
					
				</div> <!-- end of block -->
				
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>S&P Numerical Rating</label>
						<logic:messagesPresent property="TPLegRequest.SPNumericalRating">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" styleClass="span1"   property="TPLegRequest.SPNumericalRating"  styleId="spNumericalRatingID"  maxlength="6"   />
					</div>
					
				</div> <!-- end of block -->
			</div>
		</div>
		<div class="form-mod">
		<c:set var="solvencyMatrixList" value="${staticdata:getSolvencyMatrixList(pageContext)}" />
			<h2 class="span12 collapsible">Solvency Metrics</h2>
			<div class="row">
				<div class="span12">
				  <table class="table1 table-striped1 table-bordered1 sortable no-bottom table-nested">
					<thead>
					  <tr>
						<th rowspan="2">Solvency metrics</th>
						<th rowspan="2">Pre Transaction</th>
						<th rowspan="2">Post Transaction</th>
						<th colspan="3" class="nosort">Fund Co/Hold Co/Op Co Thresholds</th>
						<th rowspan="2">Assessment</th>
						<th rowspan="2">Rationale - required only if threshold breached</th>
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
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[0].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[0].preTransaction"  styleId="derPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[0].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
							   <html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[0].postTransaction"  onchange="solvencyCalc(0,'${solvencyMatrixList[0].pass}','${solvencyMatrixList[0].conditionalPass}','${solvencyMatrixList[0].weakPerformer}',false)"  styleId="derPostTransactionID"  maxlength="10"   />    
							</div>
						</td>
						
						<td>
							<div class="form-row">
							<c:choose>
							<c:when test="${not empty solvencyMatrixList}">
							  ${solvencyMatrixList[0].pass}
							  <input type="hidden" id="smpass0id" value='${solvencyMatrixList[0].pass}'/>
							 </c:when>
							 </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
							  <c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	  ${solvencyMatrixList[0].conditionalPass}
							 	    <input type="hidden" id="smconditionalPass0id" value='${solvencyMatrixList[0].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[0].fundThreshold"  value="7"   />
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[0].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer0id" value='${solvencyMatrixList[0].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>                                             
						<td  id="solvencyMetrics0TdID">
						 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].assessmentFlag"  styleId="smradioS0" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq0">*</span>
								<logic:messagesPresent property="solvencyMetrics0comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<html:textarea styleId="derCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[0].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].solvencyMetricId"    value="1"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].solvencyMetricOpcode"     />	
					  </tr> <tr>
						<td>Debt&nbsp;Ratio&nbsp;(Gearing&nbsp;Ratio)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtRatio" />"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[1].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[1].preTransaction"  styleId="drPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[1].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[1].postTransaction" onchange="solvencyCalc(1,'${solvencyMatrixList[1].pass}','${solvencyMatrixList[1].conditionalPass}','${solvencyMatrixList[1].weakPerformer}',false)"  styleId="drPostTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].pass}
							 	    <input type="hidden" id="smpass1id" value='${solvencyMatrixList[1].pass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].conditionalPass}
							 	      <input type="hidden" id="smconditionalPass1id" value='${solvencyMatrixList[1].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[1].fundThreshold"  value="7"   />
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer1id" value='${solvencyMatrixList[1].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>  
						<td  id="solvencyMetrics1TdID">
							 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].assessmentFlag"  styleId="smradioS1" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq1">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics1comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="drCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[1].comment" cols="100" rows="5"  onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].solvencyMetricId"    value="2"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Interest&nbsp;Coverage&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.interestCoverage"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[2].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[2].preTransaction"  styleId="icPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[2].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[2].postTransaction" onchange="solvencyCalc(2,'${solvencyMatrixList[2].pass}','${solvencyMatrixList[2].conditionalPass}','${solvencyMatrixList[2].weakPerformer}',false)" styleId="icPostTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].pass}
							 	    <input type="hidden" id="smpass2id" value='${solvencyMatrixList[2].pass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].conditionalPass}
							 	      <input type="hidden" id="smconditionalPass2id" value='${solvencyMatrixList[2].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer2id" value='${solvencyMatrixList[2].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[2].fundThreshold"  value="7"   />
						</td>  
						<td  id="solvencyMetrics2TdID">
							 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].assessmentFlag"  styleId="smradioS2" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq2">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics2comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="icCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[2].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].solvencyMetricId"    value="3"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Adjusted&nbsp;Current&nbsp;Ratio&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.adjustedCurrentRatio"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[3].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[3].preTransaction"  styleId="acrPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
									
									<logic:messagesPresent property="TPLegRequest.solvencyMetrics[3].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[3].postTransaction" onchange="solvencyCalc(3,'${solvencyMatrixList[3].pass}','${solvencyMatrixList[3].conditionalPass}','${solvencyMatrixList[3].weakPerformer},false')"  styleId="acrPostTransactionID"  maxlength="10"   />  
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].pass}
							 	    <input type="hidden" id="smpass3id" value='${solvencyMatrixList[3].pass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].conditionalPass}
							 	      <input type="hidden" id="smconditionalPass3id" value='${solvencyMatrixList[3].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer3id" value='${solvencyMatrixList[3].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[3].fundThreshold"  value="7"   />
						</td>  
						<td  id="solvencyMetrics3TdID">
							 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].assessmentFlag"  styleId="smradioS3" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq3">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics3comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="acrCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[3].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].solvencyMetricId"    value="4"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].solvencyMetricOpcode"     />			
					  </tr> <tr>
						<td>Positive&nbsp;Equity&nbsp;(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveEquity"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[4].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[4].preTransaction"  styleId="pePreTransactionID"  maxlength="25"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[4].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[4].postTransaction" onchange="solvencyCalc(4,'${solvencyMatrixList[4].pass}','${solvencyMatrixList[4].conditionalPass}','${solvencyMatrixList[4].weakPerformer}',false)" styleId="pePostTransactionID"  maxlength="25"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].pass}
							 	    <input type="hidden" id="smpass4id" value='${solvencyMatrixList[4].pass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].conditionalPass}
							 	      <input type="hidden" id="smconditionalPass4id" value='${solvencyMatrixList[4].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer4id" value='${solvencyMatrixList[4].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[4].fundThreshold"  value="7"   />
						</td>  
						<td  id="solvencyMetrics4TdID">
							 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].assessmentFlag"  styleId="smradioS4" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq4">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics4comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="peCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[4].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].solvencyMetricId"    value="5"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Positive&nbsp;Share&nbsp;Capital&nbsp;(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveShareCapital"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[5].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[5].preTransaction"  styleId="pscPreTransactionID"  maxlength="25"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[5].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="cpaLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[5].postTransaction"   onchange="solvencyCalc(5,'${solvencyMatrixList[5].pass}','${solvencyMatrixList[5].conditionalPass}','${solvencyMatrixList[5].weakPerformer}',false)"  styleId="pscPostTransactionID"  maxlength="25"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].pass}
							 	    <input type="hidden" id="smpass5id" value='${solvencyMatrixList[5].pass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].conditionalPass}
							 	      <input type="hidden" id="smconditionalPass5id" value='${solvencyMatrixList[5].conditionalPass}'/>
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].weakPerformer}
							 	      <input type="hidden" id="smweakPerformer5id" value='${solvencyMatrixList[5].weakPerformer}'/>
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="cpaLegRequestForm"    property="TPLegRequest.solvencyMetrics[5].fundThreshold"  value="7"   />
							
						</td>  
						<td  id="solvencyMetrics5TdID">
						 <html:hidden  name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].assessmentFlag"  styleId="smradioS5" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq5">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics5comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:textarea styleId="pscCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[5].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].solvencyMetricId"    value="6"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].solvencyMetricOpcode"     />
					  </tr> <tr>
						<td colspan="6">Borrower Insolvent</td>
						<td  id="solvencyMetrics6TdID">
							<logic:messagesPresent property="TPLegRequest.solvencyMetrics[6].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="TPLegRequest.solvencyMetrics[6].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							
								<label class="radio">
									<html:radio name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].assessmentFlag"  value="true" styleId="smradioS6"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].assessmentFlag"  value="false" styleId="smradioH6"></html:radio> No
								</label>
							</div>
						</td>
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].preTransaction"   value="7"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].postTransaction"  value="7"  />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].fundThreshold"    value="7"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].solvencyMetricId"    value="7"   />
						<html:hidden name="cpaLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].solvencyMetricOpcode"     />
						
						<td>
							<div class="form-row autosize-container">
							    <span class="required" id="commentsReq6">*</span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="solvencyMetrics6comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="insolvencyCommentsID" name="cpaLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[6].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
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
        </div><!-- end of form form-mod -->
	