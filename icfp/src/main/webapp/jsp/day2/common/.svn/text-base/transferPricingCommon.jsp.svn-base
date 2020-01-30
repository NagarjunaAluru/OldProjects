<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script type="text/javascript" >
       //Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
    </script>
   
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | RCA - Transfer Pricing</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <%String nextLegNumber = (String) request.getAttribute("nextLegNumber");%>
    
    <%@include file="../../common/includeCssScripts.jsp" %>
    <script src="<%=servletContextUrl%>/js/cpaDay2TransferPricing.js" type="text/javascript"></script>
   	<script src="<%=servletContextUrl%>/js/rcaTransferPricingInput.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/tablesorter.min.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jshashtable-2.1_src.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.numberformatter-1.2.3.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.formatCurrency-1.0.0.min.js" type="text/javascript"></script>
	
	
<script>

//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	
  </head>
	
	<script>	
			$(document).ready(function(){
				//Show next leg navigation based on lastLeg value
				 var nextLegNumberVar = '<%=nextLegNumber%>';
				  if(nextLegNumberVar!=null && nextLegNumberVar!="" && nextLegNumberVar!="null"){
				     document.forms[0].elements("nextLegNumber").value=nextLegNumberVar;
				  }else{
					  nextLegNumberVar =  document.forms[0].elements("nextLegNumber").value;
				  }
				  
				  if(nextLegNumberVar<=0 )
				  {
					  $("#savegotonextlegid").hide(); 
				   }else{
					   $("#savegotonextlegid").show(); 
				  }
					
				  //Embed the Leg Seq Id in Save Leg Action
				  $('#saveLegID').click(function(e){
					     removeAmountShortcuts();
						 document.forms[0].action = contextURL + '/transferPricing/transferPricingLeg.do?command=save&id=' + ${param.id}+'&actionValue=save';
						 document.forms[0].submit();
					  });
				  
				  	$('#submitID').click(function() {
				  		
				  		document.forms[0].elements("page").value=4;
				  		removeAmountShortcuts();
						var actionType = $('input[name=saveRCALeg]:radio:checked').val();
						if(actionType == 'savegotonextleg'){
							 document.forms[0].action = contextURL + '/transferPricing/transferPricingLeg.do?command=saveAndGoToNextLeg&id=' + ${param.id};
							 document.forms[0].submit();
						}else if (actionType == 'saveandreturntodeal'){
							 document.forms[0].action = contextURL + '/transferPricing/transferPricingLeg.do?command=saveAndReturnToDeal&id=' + ${param.id};
							 document.forms[0].submit();
						}else{
							$("#saveSpanID1").show();
							$("#saveSpanID2").show();
							return ;
						}							
				  });						
			});
	</script>
  <script type="text/javascript" src="<%=servletContextUrl%>/js/common/transferPricingCommon.js"/>
		<div class="form-mod">
			<h3 class="span12">Model Type</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Model Type</label> 
						 <logic:messagesPresent property="tpLegRequest.modelTypeId">
							<span class="req-error" >a</span>
						   </logic:messagesPresent>
						<html:select name="ICFPLegRequestForm" styleId="me-conditional-select"  property="tpLegRequest.modelTypeId"  onchange="resetModelValues()" styleClass="check">
	   							<html:option value="">Select...</html:option>
	   							<html:option styleId="Other" value="1"  >S &amp; P FCCM</html:option>
                            	<html:option value="2">S &amp; P Commercial &amp; Savings Bank Model</html:option>
                            	<html:option value="3">S &amp; P Industrial Model</html:option>
                            	<html:option value="4">Other</html:option>
   						   </html:select>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
        
        <div class="form-mod mDrivers" id="Other">
			<h3 class="span12">Model Drivers - Statutory Financials</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Total Debt (USD)</label>
						<logic:messagesPresent property="tpLegRequest.totalDebt">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text  name="ICFPLegRequestForm" styleClass="span3"   property="tpLegRequest.totalDebt"  styleId="totalDebtUSDID"  maxlength="14"   />
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Total Debt/Total Capital</label>
						<logic:messagesPresent property="tpLegRequest.totalDebtCaptialRatio">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.totalDebtCaptialRatio"  styleId="totalDebtTotalCapitalID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Total Capital (USD)</label>
						<logic:messagesPresent property="tpLegRequest.totalCapital">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span3"   property="tpLegRequest.totalCapital"  styleId="totalCapitalUSDID"  maxlength="14"   /> 
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Charge-off/Receivables</label>
						<logic:messagesPresent property="tpLegRequest.netChargeOffReceivables">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.netChargeOffReceivables"  styleId="netChangeOffID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Net Income (USD)</label>
						<logic:messagesPresent property="tpLegRequest.netIncome">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <!-- value="value="${deal:convertAmountToCurrencyFormat(this)}" -->
						<html:text name="ICFPLegRequestForm" styleClass="span3"   property="tpLegRequest.netIncome"  styleId="netIncomeUSDID"  maxlength="14"    />
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Interest Margin</label>
						<logic:messagesPresent property="tpLegRequest.netInterestMargin">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.netInterestMargin"  styleId="netInterestMarginID"  maxlength="6"   />
						<span class="add-on">%</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row input-append">
						
						<label>Return on Avg. Assets</label>
						<logic:messagesPresent property="tpLegRequest.returnOnAvgAssets">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.returnOnAvgAssets"  styleId="returnOnAvgAssetsID"  maxlength="6"   />
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
						<span class="required" id="scores1">*</span>
						<label>Model Score</label>
						<logic:messagesPresent property="tpLegRequest.modelScoreId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="tpLegRequest.modelScoreId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="modelScores" value="ID" label="name"/>
						</html:select>
					</div>
						
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required"  id="scores2">*</span>
						<label>S&P Rating</label>
						<logic:messagesPresent property="tpLegRequest.SPRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <html:select name="ICFPLegRequestForm"  property="tpLegRequest.SPRatingId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="SNPRatings" value="ID" label="name"/>
						 </html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required"  id="scoresO">*</span>
						<label>Range</label>
						  <logic:messagesPresent property="tpLegRequest.rangeId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="tpLegRequest.rangeId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="ranges" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required" id="scores3">*</span>
						<label>Final Rating</label>
						<logic:messagesPresent property="tpLegRequest.finalRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="tpLegRequest.finalRatingId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="finalRating" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required" id="scores4">*</span>
						<label>Sovereign Constraint</label>
						<logic:messagesPresent property="tpLegRequest.sovereignConstraintFlag">
							<div class="radio-container req-error">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="tpLegRequest.sovereignConstraintFlag">
	               				 <div class="radio-container">
	                    </logic:messagesNotPresent>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.sovereignConstraintFlag"  value="true" ></html:radio> Yes
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.sovereignConstraintFlag"  value="false" ></html:radio> No
							</label>
						</div>
					</div>
					
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span class="required" id="scores5">*</span>
						<label>Qualitative Notches</label>
						<logic:messagesPresent property="tpLegRequest.qualitativeNotches">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.qualitativeNotches"  styleId="qualitativeNotchesID"  maxlength="20"   />
					</div>
					
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required" id="scoresOO">*</span>
						<label>S&P Numerical Rating</label>
						<logic:messagesPresent property="tpLegRequest.SPNumericalRating">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.SPNumericalRating"  styleId="spNumericalRatingID"  maxlength="6"   />
					</div>
					
				</div> <!-- end of block -->
			</div>
			
        </div><!-- end of form form-mod -->
		
		<div class="form-mod">
		<c:set var="solvencyMatrixList" value="${staticdata:getSolvencyMatrixList(pageContext)}" />
			<h2 class="span12 collapsible">Solvency Metrics</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
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
						<td>Debt to Equity Ratio<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtToEquityRatio" />"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[0].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[0].preTransaction"  styleId="derPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[0].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[0].postTransaction"  styleId="derPostTransactionID"  maxlength="10"   />  
							</div>
						</td>
						
						<td>
							<div class="form-row">
							<c:choose>
							<c:when test="${not empty solvencyMatrixList}">
							  ${solvencyMatrixList[0].pass}
							 </c:when>
							 </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
							  <c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	  ${solvencyMatrixList[0].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[0].fundThreshold"  value="7"   />
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[0].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
						</td>                                             
						<td>
						<logic:messagesPresent property="tpLegRequest.solvencyMetrics[0].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[0].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							
							<span class="required" >*</span>
							
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[0].assessmentFlag"  value="true" styleId="smradioS0" ></html:radio> Yes
									
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[0].assessmentFlag"  value="false" styleId="smradioH0" ></html:radio> No
								</label>
							</div>
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq0">*</span>
								<label>Comments </label>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[0].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<div class="char-count">500</div>
								<html:textarea styleId="derCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[0].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[0].solvencyMetricId"    value="1"   />	
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[0].solvencyMetricOpcode"     />
					  </tr> <tr>
						<td>Debt Ratio (Gearing Ratio)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtRatio" />"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[1].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[1].preTransaction"  styleId="drPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[1].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[1].postTransaction"  styleId="drPostTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].pass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[1].fundThreshold"  value="7"   />
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[1].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
						</td>  
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[1].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[1].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[1].assessmentFlag"  value="true" styleId="smradioS1" ></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[1].assessmentFlag"  value="false" styleId="smradioH1" ></html:radio> No
								</label>
							</div>
						</td>
						<td>
						
						
				
				
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq1">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[1].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="drCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[1].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[1].solvencyMetricId"    value="2"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[1].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Interest Coverage<span class="ttip info" data-original-title="<bean:message key="label.tooltip.interestCoverage"/>"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[2].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[2].preTransaction"  styleId="icPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[2].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[2].postTransaction"  styleId="icPostTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].pass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[2].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[2].fundThreshold"  value="7"   />
						</td>  
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[2].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[2].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[2].assessmentFlag"  value="true" styleId="smradioS2"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[2].assessmentFlag"  value="false" styleId="smradioH2"></html:radio> No
								</label>
							</div>
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq2">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[2].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="icCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[2].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[2].solvencyMetricId"    value="3"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[2].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Adjusted Current Ratio<span class="ttip info" data-original-title="<bean:message key="label.tooltip.adjustedCurrentRatio"/>"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[3].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[3].preTransaction"  styleId="acrPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
									<span class="required">*</span>
									<logic:messagesPresent property="tpLegRequest.solvencyMetrics[3].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[3].postTransaction"  styleId="acrPostTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].pass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[3].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[3].fundThreshold"  value="7"   />
						</td>  
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[3].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[3].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[3].assessmentFlag"  value="true" styleId="smradioS3"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[3].assessmentFlag"  value="false" styleId="smradioH3"></html:radio> No
								</label>
							 </div>
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq3">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[3].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="acrCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[3].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[3].solvencyMetricId"    value="4"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[3].solvencyMetricOpcode"     />			
					  </tr> <tr>
						<td>Positive Equity (USD)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveEquity"/>"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[4].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[4].preTransaction"  styleId="pePreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[4].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[4].postTransaction"  styleId="pePostTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].pass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[4].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[4].fundThreshold"  value="7"   />
						</td>  
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[4].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[4].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[4].assessmentFlag"  value="true" styleId="smradioS4"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[4].assessmentFlag"  value="false" styleId="smradioH4" ></html:radio> No
								</label>
							</div>
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq4">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[4].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="peCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[4].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[4].solvencyMetricId"    value="5"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[4].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Positive Share Capital (USD)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveShareCapital"/>"></span></td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[5].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[5].preTransaction"  styleId="pscPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<span class="required">*</span>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[5].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1"   property="tpLegRequest.solvencyMetrics[5].postTransaction"  styleId="pscPostTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].pass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].conditionalPass}
							    </c:when>
							  </c:choose> 
							</div>
						</td>   
						<td>
							<div class="form-row">
								<c:choose>
							     <c:when test="${not empty solvencyMatrixList}">
							 	    ${solvencyMatrixList[5].weakPerformer}
							    </c:when>
							  </c:choose> 
							</div>
							<html:hidden name="ICFPLegRequestForm"    property="tpLegRequest.solvencyMetrics[5].fundThreshold"  value="7"   />
							
						</td>  
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[5].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[5].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[5].assessmentFlag"  value="true" styleId="smradioS5"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[5].assessmentFlag"  value="false" styleId="smradioH5"></html:radio> No
								</label>
							</div>
						</td>
						<td>
							<div class="form-row autosize-container">
								<span class="required" id="commentsReq5">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[5].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:textarea styleId="pscCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[5].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[5].solvencyMetricId"    value="6"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[5].solvencyMetricOpcode"     />
					  </tr> <tr>
						<td colspan="6">Borrower Insolvent</td>
						<td>
							<logic:messagesPresent property="tpLegRequest.solvencyMetrics[6].assessmentFlag">
									<span class="radio-container req-error" >a</span>
						  </logic:messagesPresent>
						  <logic:messagesNotPresent property="tpLegRequest.solvencyMetrics[6].assessmentFlag">
	               				 <div class="radio-container">
	                       </logic:messagesNotPresent>
							<span class="required" >*</span>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].assessmentFlag"  value="true" styleId="smradioS6"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].assessmentFlag"  value="false" styleId="smradioH6"></html:radio> No
								</label>
							</div>
						</td>
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].preTransaction"   value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].postTransaction"  value="7"  />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].fundThreshold"    value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].solvencyMetricId"    value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="tpLegRequest.solvencyMetrics[6].solvencyMetricOpcode"     />
						
						<td>
							<div class="form-row autosize-container">
							   <span class="required" id="commentsReq6">*</span>
								<label>Comments</label>
								<div class="char-count">500</div>
								<logic:messagesPresent property="tpLegRequest.solvencyMetrics[6].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="insolvencyCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="xlarge autosize messageinput" property="tpLegRequest.solvencyMetrics[6].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
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
		
		<div class="form-mod">
			<h2 class="span12">Pricing Information</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Interest Type</label>
						    <logic:messagesNotPresent property="rateInformation.interestTypeId">
							  <div class="radio-container intrest-type-condition">
						 	</logic:messagesNotPresent>
						 	<logic:messagesPresent property="rateInformation.interestTypeId">
							  <div class="radio-container intrest-type-condition req-error">
						 	</logic:messagesPresent>
						
							<label class="radio">
							     <html:radio name="ICFPLegRequestForm" styleClass="fixed-condition"  styleId="fixedRateID"  property="rateInformation.interestTypeId"  value="1" ></html:radio> Fixed
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="float-condition" styleId="floatRateID"  property="rateInformation.interestTypeId"  value="2" ></html:radio> Float
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
				
			</div>
			<div  class="fixed-container">
				<h3 class="span12">Fixed</h3>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Base Fixed Rate</label>
							<logic:messagesPresent property="rateInformation.baseFixedRate">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="ICFPLegRequestForm" styleClass="span2"   property="rateInformation.baseFixedRate"  styleId="baseFixedRateID"  maxlength="10"   />
							
						</div>
						  
					</div> <!-- end of block -->
				</div>
				
			</div>
			
			<div class="float-container">
				<h3 class="span12">Float</h3>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Floating Rate Index</label>
							<logic:messagesPresent property="rateInformation.floatingRateIndex">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							  <html:select name="ICFPLegRequestForm"  property="rateInformation.floatingRateIndex"  styleId="floatingRateIndexID" styleClass="span2">
							        <html:option  value="">Select...</html:option>
							      <logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
								<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="ID" label="name"/>
							</logic:notEmpty>
							 </html:select>
							  
						</div>
						
					</div>  <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Index Term</label>
							
							<logic:messagesPresent property="rateInformation.floatingRateIndexTerm">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							    <html:select name="ICFPLegRequestForm"  property="rateInformation.floatingRateIndexTerm"  styleId="floatingRateIndexTermID" styleClass="span2">
							       <html:option  value="">Select...</html:option>
							      <logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
									<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="ID" label="name"/>
								</logic:notEmpty>
							  			
							</html:select>
						</div>
						
					</div>  <!-- end of block -->
					
				</div>
			</div>
			 <div  id="maxSpreadDivID">
			   <div class="row">
			   	   <div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Minimum Spread (bps)</label>
							<logic:messagesPresent property="rateInformation.minSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="ICFPLegRequestForm" styleClass="span2"   property="rateInformation.minSpread"  styleId="floatMinSpreadBPSID"  maxlength="6"   />
						</div>
						
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Maximum Spread (bps)</label>
							<logic:messagesPresent property="rateInformation.maxSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="ICFPLegRequestForm" styleClass="span2"   property="rateInformation.maxSpread"  styleId="floatMaxSpreadBPSID"  maxlength="6"   />
							
						</div>
						
					</div> <!-- end of block -->
					
				</div>
			 </div>
			
			<div class="row">
					<div class="span5">
						<div class="form-row autosize-container">
							<span class="required">*</span>
							<label>Transfer Pricing Summary</label>
							<div class="char-count">1000</div> 
							<logic:messagesPresent property="tpLegRequest.TPSummary">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:textarea name="ICFPLegRequestForm" styleClass="xlarge autosize messageinput ttt" property="tpLegRequest.TPSummary" cols="100" rows="10" onblur="scriptInjection(this);"></html:textarea>						
						</div>
					</div> <!-- end of block -->
				</div>
	   </div><!-- end of form form-mod -->
	   <c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" /> 
	   <c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<%@ include file="../../common/inc/legexceptionDetails.jsp" %>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
	
	   
		
 		<jsp:include page="../../frontOffice/qualitativeAssessment.jsp" >
				<jsp:param name="factors" value="Transfer Pricing Risk"/>			
		</jsp:include>
		
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        	</jsp:include>  
      	
				
		<div class="form-mod">
				<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/> 
					<jsp:param value="transferPricing/transferPricing" name="path"/>
			        <jsp:param value="Leg ${ param.id }: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Transfer Pricing" name="origin"/>
				</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							 <label><bean:message key="treasuryLegal.comments" /></label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
		
		 <jsp:include page="../../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="ICFPLegRequestForm"/>
				<jsp:param value="transferPricing/transferPricing" name="path"/>
			    <jsp:param value="Leg ${ param.id }: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Transfer Pricing" name="origin"/>			
			</jsp:include>
        

