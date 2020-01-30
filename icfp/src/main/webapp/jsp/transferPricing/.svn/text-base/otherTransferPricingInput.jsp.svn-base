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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
    <script type="text/javascript" >
       //Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
    </script>
   
    <title>ICF | Other Leg - Transfer Pricing</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <%String nextLegNumber = (String) request.getAttribute("nextLegNumber");%>
	<script src="<%=servletContextUrl%>/js/otherDay1TransferPricing.js" type="text/javascript"></script>
   	<script src="<%=servletContextUrl%>/js/rcaTransferPricingInput.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/tablesorter.min.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jshashtable-2.1_src.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.numberformatter-1.2.3.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.formatCurrency-1.0.0.min.js" type="text/javascript"></script>
	
	
	<script>
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	
	
	<script>
			$(document).ready(function(){
				
				covertDataToCurrencyFormat();
				guaranteeAggAttID();
				/*
		           Here we are using ${param.id} . This script can not be moved to seperate js file.
		       */
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
				  	
				  
				  $('#saveLeg').click(function(e){
					 removeAmountShortcuts();
					 document.forms[0].action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndReturnToDeal';
					 document.forms[0].submit();
				  });
				  
				  $('#saveLegID').click(function(e){
					     removeAmountShortcuts();
						 document.forms[0].action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=save&id=' + ${param.id}+'&actionValue=save';
						 document.forms[0].submit();
					  });
				  
				  	$('#submitID').click(function() {
				  		var validate = validateQualitativeAssesment();
				  		if(validate==false) {
				  		document.forms[0].elements("page").value=4;
				  		removeAmountShortcuts();
						var actionType = $('input[name=saveRCALeg]:radio:checked').val();
						if(actionType == 'savegotonextleg'){
							 document.forms[0].action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndGoToNextLeg&id=' + ${param.id};
							 document.forms[0].submit();
						}else if (actionType == 'saveandreturntodeal'){
							 document.forms[0].action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndReturnToDeal&id=' + ${param.id};
							 document.forms[0].submit();
						}else{
							$("#saveSpanID1").show();
							$("#saveSpanID2").show();
							$(window).scrollTop(100); 
							$('#validateFlag').show(); 
							return ;
						}
				  		}else{
				  			$(window).scrollTop(100); 
							$('#validateFlag').show(); 
							return ;
				  		}
				  		
				  });		
			});
	</script>
	
		 <logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
        	   </div>
         </logic:messagesPresent>
		        
		<html:form action="/transferPricing/transferPricingOtherLeg.do"  styleId="ICFPLegRequestForm" method="post"  enctype="multipart/form-data">
	      
		  <html:hidden property="page" value="2"/>
		<input type="hidden" name="legNumber"    id="legNumberID"   value="${param.id}">
		 <html:hidden name="ICFPLegRequestForm" property="nextLegNumber" />
		 <html:hidden  name="ICFPLegRequestForm" property="legSummary.borrowerEntity.fundHoldOperationId"  styleId="fundHoldOperationId" />
		<input type="hidden" name="isCPA" id="isCPA" value="no" />
			<h2 class="span12 collapsible">Transaction Summary</h2>
			<div class="clear"></div>
			<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Deal Id</b><br />
						${sessionScope.deal.uniqueId}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Deal Name</b><br />
						${sessionScope.deal.dealName}</p>
					</div>
				</div><!-- end of block -->                
        	</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Deal Category</b><br />
						${sessionScope.deal.dealCategory}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Leg Id</b><br />
						 <label id="legIDLabel">${legSummaryVO.legSeqId}</label>
						 </p>
					</div>
				</div><!-- end of block -->
			</div>                
            
		<jsp:include page="../common/inc/detailSummary.jsp" >
				<jsp:param value="transferPricing" name="page"/>
			</jsp:include>
			
		<c:choose>
			<c:when test="${legSummaryVO.legTypeId eq 4}">
			<h2 class="span12">Description</h2>
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
		
		<jsp:include page="../common/inc/transactionLegDetails.jsp">
		   <jsp:param value="transferPricing" name="path"/>
		   <jsp:param value="${param.id}" name="id" />
		</jsp:include>	
		
		<div class="form-mod">
			<h2 class="span12">Fees</h2>
			<div class="row" >
				<div class="span5" id="commitmentFeeDiv">
					<div class="form-row">
						
						<label>Commitment Fee Applicable</label>
	               			<logic:messagesPresent property="commitmentFeeApplicableFlag">
							<div class="radio-container conditional-radio req-error">
							</logic:messagesPresent>
							<logic:messagesNotPresent property="commitmentFeeApplicableFlag">
	               			<div class="radio-container conditional-radio">
	                    	</logic:messagesNotPresent>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" property="commitmentFeeApplicableFlag"  styleId="commitmentFeeApplicableYesID" value="true" ></html:radio> Yes
							</label>
							<div class="form-row conditional-container input-append" id="commitmentFeeRateDivID">
								<div class="form-row" >
									
									<label>Commitment Fee Rate</label>
									<logic:messagesPresent property="commitmentFeeRate">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
									 <html:text name="ICFPLegRequestForm" styleClass="span1"   property="commitmentFeeRate"  styleId="commitmentFeeRateID"  maxlength="9"   />
									<span class="add-on">%</span>
								</div>
								
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="commitmentFeeApplicableFlag"  styleId="commitmentFeeApplicableNoID" value="false" ></html:radio> No
							</label>
						</div>
						
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						
						<label>Guarantee  Fee Applicable?</label>
						<logic:messagesPresent property="guaranteeFeeApplicableFlag">
							<div class="radio-container conditional-radio req-error">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="guaranteeFeeApplicableFlag">
	               			<div class="radio-container conditional-radio">
	                    </logic:messagesNotPresent>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" property="guaranteeFeeApplicableFlag"  styleId="guaranteeFeeApplicableYesID"  value="true" ></html:radio> Yes
							</label>
							<div class="form-row conditional-container input-append" id="guaranteeFeeRateDivID">
								<div class="form-row" >
									
									<label>Guarantee  fee rate</label>
									<logic:messagesPresent property="guaranteeFeeRate">
										<span class="req-error" >a</span>
						  			</logic:messagesPresent>
									 <html:text name="ICFPLegRequestForm" styleClass="span1"   property="guaranteeFeeRate"  styleId="guaranteeFeeRateID"  maxlength="9"   />
									<span class="add-on">%</span>
								</div>
								
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="guaranteeFeeApplicableFlag" styleId="guaranteeFeeApplicableNoID" value="false" ></html:radio> No
							</label>
						</div>
						
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required" style="display: none" id="guaranteeAggAttID">*</span>
						<label>Guarantee Agreement Attached?</label>
						<logic:messagesPresent property="guaranteeAgreementFlag">
							<div class="radio-container conditional-radio req-error">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="guaranteeAgreementFlag">
	               				 <div class="radio-container conditional-radio">
	                    </logic:messagesNotPresent>
							<label class="radio">
							 <html:radio name="ICFPLegRequestForm" property="guaranteeAgreementFlag"  value="true" ></html:radio> Yes
							</label>
							
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="guaranteeAgreementFlag"  value="false" ></html:radio> No							
							</label>
						</div>
					
						
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			
		</div><!-- end of form form-mod -->
		<div class="form-mod">
			<h3 class="span12">Model Type</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						
						<label>Model Type</label> 
						 <logic:messagesPresent property="TPLegRequest.modelTypeId">
							<span class="req-error" >a</span>
						   </logic:messagesPresent>
						<html:select name="ICFPLegRequestForm" styleId="me-conditional-select"  property="TPLegRequest.modelTypeId"  onchange="resetModelValues()" styleClass="check">
	   							<html:option value="">Select...</html:option>
	   							<html:optionsCollection name="com.ge.icfp.StaticData" property="modelTypes" value="ID" label="name"/>
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
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
						<logic:messagesPresent property="TPLegRequest.totalDebt">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:text  name="ICFPLegRequestForm" styleClass="span2 currencynoconversion"   property="TPLegRequest.totalDebt"  styleId="totalDebtUSDID"  maxlength="25"   />
						  <span class="req-error" style="display:none;">error</span>  
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Total Debt/Total Capital</label>
						<span  class="help-block invalid error" style="display:none;">Invalid value </span>
						<logic:messagesPresent property="TPLegRequest.totalDebtCaptialRatio">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.totalDebtCaptialRatio"  styleId="totalDebtTotalCapitalID"  maxlength="6"   />
						<span class="req-error" style="display:none;">error</span>  
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
						<html:text name="ICFPLegRequestForm" styleClass="span2 currencynoconversion"   property="TPLegRequest.totalCapital"  styleId="totalCapitalUSDID"  maxlength="25"   />
						<span class="req-error" style="display:none;">error</span>   
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Charge-off/Receivables</label>
						<logic:messagesPresent property="TPLegRequest.netChargeOffReceivables">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.netChargeOffReceivables"  styleId="netChangeOffID"  maxlength="6"   />
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
						<html:text name="ICFPLegRequestForm" styleClass="span2 currencynegnoconversion"   property="TPLegRequest.netIncome"  styleId="netIncomeUSDID"  maxlength="25"    />
						<span class="req-error" style="display:none;">error</span>  
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row input-append">
						
						<label>Net Interest Margin</label>
						<logic:messagesPresent property="TPLegRequest.netInterestMargin">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.netInterestMargin"  styleId="netInterestMarginID"  maxlength="6"   />
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
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.returnOnAvgAssets"  styleId="returnOnAvgAssetsID"  maxlength="6"   />
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
						<span id="scores1"></span>
						<label>Model Score</label>
						<logic:messagesPresent property="TPLegRequest.modelScoreId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="TPLegRequest.modelScoreId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="modelScores" value="ID" label="name"/>
						</html:select>
					</div>
						
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span   id="scores2"></span>
						<label>S&P Rating</label>
						<logic:messagesPresent property="TPLegRequest.SPRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						 <html:select name="ICFPLegRequestForm"  property="TPLegRequest.SPRatingId"  styleClass="span2">
						    <html:option value="">Select...</html:option>
   							<html:optionsCollection name="com.ge.icfp.StaticData" property="SNPRatings" value="ID" label="name"/>
						 </html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span id="scoresO"></span>
						<label>Range</label>
						  <logic:messagesPresent property="TPLegRequest.rangeId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="TPLegRequest.rangeId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="ranges" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span id="scores3"></span>
						<label>Final Rating</label>
						<logic:messagesPresent property="TPLegRequest.finalRatingId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						  <html:select name="ICFPLegRequestForm"  property="TPLegRequest.finalRatingId"  styleClass="span2">
						     <html:option value="">Select...</html:option>
   							 <html:optionsCollection name="com.ge.icfp.StaticData" property="finalRating" value="ID" label="name"/>
						</html:select>
					</div>
					
				</div>  <!-- end of block -->
			</div>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span id="scores4"></span>
						<label>Sovereign Constraint</label>
						<logic:messagesPresent property="TPLegRequest.sovereignConstraintFlag">
							<div class="radio-container req-error">
						</logic:messagesPresent>
						<logic:messagesNotPresent property="TPLegRequest.sovereignConstraintFlag">
	               				 <div class="radio-container">
	                    </logic:messagesNotPresent>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="TPLegRequest.sovereignConstraintFlag"  value="true" ></html:radio> Yes
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  property="TPLegRequest.sovereignConstraintFlag"  value="false" ></html:radio> No
							</label>
						</div>
					</div>
					
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<span id="scores5"></span>
						<label>Qualitative Notches</label>
						<logic:messagesPresent property="TPLegRequest.qualitativeNotches">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.qualitativeNotches"  styleId="qualitativeNotchesID"  maxlength="20"   />
					</div>
					
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span id="scoresOO"></span>
						<label>S&P Numerical Rating</label>
						<logic:messagesPresent property="TPLegRequest.SPNumericalRating">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="ICFPLegRequestForm" styleClass="span1"   property="TPLegRequest.SPNumericalRating"  styleId="spNumericalRatingID"  maxlength="6"   />
					</div>
					
				</div> <!-- end of block -->
			</div>
			
        </div><!-- end of form form-mod -->
		
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
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[0].preTransaction"  styleId="derPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[0].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[0].postTransaction"  onchange="solvencyCalc(0,'${solvencyMatrixList[0].pass}','${solvencyMatrixList[0].conditionalPass}','${solvencyMatrixList[0].weakPerformer}',false)"   styleId="derPostTransactionID"  maxlength="10"   />  
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[0].fundThreshold"  value="7"   />
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
						 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].assessmentFlag"  styleId="smradioS0" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span  id="commentsReq0"></span>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[0].comment">
									<span class="req-error" >a</span>
								</logic:messagesPresent>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<html:textarea styleId="derCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[0].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].solvencyMetricId"    value="1"   />	
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[0].solvencyMetricOpcode"     />
					</tr> <tr>
						<td>Debt&nbsp;Ratio&nbsp;(Gearing&nbsp;Ratio)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.debtRatio" />"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[1].preTransaction">
									<span class="req-error" >a</span>
								</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[1].preTransaction"  styleId="drPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
							    <logic:messagesPresent property="TPLegRequest.solvencyMetrics[1].postTransaction">
								   <span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[1].postTransaction"  onchange="solvencyCalc(1,'${solvencyMatrixList[1].pass}','${solvencyMatrixList[1].conditionalPass}','${solvencyMatrixList[1].weakPerformer}',false)"   styleId="drPostTransactionID"  maxlength="10"   />
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[1].fundThreshold"  value="7"   />
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
						<td id="solvencyMetrics1TdID">
							 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].assessmentFlag"  styleId="smradioS1" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span  id="commentsReq1"></span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[1].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="drCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[1].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].solvencyMetricId"    value="2"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[1].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Interest Coverage<span class="ttip info" data-original-title="<bean:message key="label.tooltip.interestCoverage"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[2].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[2].preTransaction"  styleId="icPreTransactionID"  maxlength="10"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[2].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[2].postTransaction"  onchange="solvencyCalc(2,'${solvencyMatrixList[2].pass}','${solvencyMatrixList[2].conditionalPass}','${solvencyMatrixList[2].weakPerformer}',false)" styleId="icPostTransactionID"  maxlength="10"   />
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[2].fundThreshold"  value="7"   />
						</td>  
						<td id="solvencyMetrics2TdID">
						 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].assessmentFlag"  styleId="smradioS2" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span  id="commentsReq2"></span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[2].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="icCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[2].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>		
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].solvencyMetricId"    value="3"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[2].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Adjusted Current Ratio<span class="ttip info" data-original-title="<bean:message key="label.tooltip.adjustedCurrentRatio"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[3].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[3].preTransaction"  styleId="acrPreTransactionID"  maxlength="10"   /> 
							</div>
						</td>
						<td>
							<div class="form-row">
									
									<logic:messagesPresent property="TPLegRequest.solvencyMetrics[3].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[3].postTransaction"  onchange="solvencyCalc(3,'${solvencyMatrixList[3].pass}','${solvencyMatrixList[3].conditionalPass}','${solvencyMatrixList[3].weakPerformer}',false)"   styleId="acrPostTransactionID"  maxlength="10"   /> 
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[3].fundThreshold"  value="7"   />
						</td>  
						<td id="solvencyMetrics3TdID">
							 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].assessmentFlag"  styleId="smradioS3" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span id="commentsReq3"></span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[3].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="acrCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[3].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].solvencyMetricId"    value="4"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[3].solvencyMetricOpcode"     />			
					  </tr> <tr>
						<td>Positive&nbsp;Equity(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveEquity"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[4].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
						  		<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[4].preTransaction"  styleId="pePreTransactionID"  maxlength="25"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[4].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
						  		<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[4].postTransaction"  onchange="solvencyCalc(4,'${solvencyMatrixList[4].pass}','${solvencyMatrixList[4].conditionalPass}','${solvencyMatrixList[4].weakPerformer}',false)"   styleId="pePostTransactionID"  maxlength="25"   /> 
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[4].fundThreshold"  value="7"   />
						</td>  
						<td id="solvencyMetrics4TdID">
							 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].assessmentFlag"  styleId="smradioS4" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span  id="commentsReq4"></span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[4].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="peCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[4].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].solvencyMetricId"    value="5"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[4].solvencyMetricOpcode"     />		
					  </tr> <tr>
						<td>Positive&nbsp;Share&nbsp;Capital&nbsp;(USD)&nbsp;<span class="ttip info" data-original-title="<bean:message key="label.tooltip.positiveShareCapital"/>"></span></td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[5].preTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
						  		<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[5].preTransaction"  styleId="pscPreTransactionID"  maxlength="25"   />
							</div>
						</td>
						<td>
							<div class="form-row">
								
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[5].postTransaction">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
						  		<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								<html:text name="ICFPLegRequestForm" styleClass="span1 currencynegnoconversion"   property="TPLegRequest.solvencyMetrics[5].postTransaction"  onchange="solvencyCalc(5,'${solvencyMatrixList[5].pass}','${solvencyMatrixList[5].conditionalPass}','${solvencyMatrixList[5].weakPerformer}',false)"   styleId="pscPostTransactionID"  maxlength="25"   />
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
							<html:hidden name="ICFPLegRequestForm"    property="TPLegRequest.solvencyMetrics[5].fundThreshold"  value="7"   />
							
						</td>  
						<td id="solvencyMetrics5TdID">
							 <html:hidden  name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].assessmentFlag"  styleId="smradioS5" />
						</td>
						<td>
							<div class="form-row autosize-container">
								<span id="commentsReq5"></span>
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[5].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								 <html:textarea styleId="pscCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[5].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
							</div>
						</td>	
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].solvencyMetricId"    value="6"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[5].solvencyMetricOpcode"     />
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
									<html:radio name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].assessmentFlag"  value="true" styleId="smradioS6"></html:radio> Yes
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].assessmentFlag"  value="false" styleId="smradioH6"></html:radio> No
								</label>
							</div>
						</td>
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].preTransaction"   value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].postTransaction"  value="7"  />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].fundThreshold"    value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].solvencyMetricId"    value="7"   />
						<html:hidden name="ICFPLegRequestForm"  property="TPLegRequest.solvencyMetrics[6].solvencyMetricOpcode"     />
						
						<td>
							<div class="form-row autosize-container">
							  
								<div class="char-count" style="margin-top:-20px; margin-left:-90px;">500</div>
								<logic:messagesPresent property="TPLegRequest.solvencyMetrics[6].comment">
									<span class="req-error" >a</span>
						  		</logic:messagesPresent>
								<html:textarea styleId="insolvencyCommentsID" name="ICFPLegRequestForm" tabindex="20" styleClass="span3 xlarge autosize messageinput" property="TPLegRequest.solvencyMetrics[6].comment" cols="100" rows="5" onblur="scriptInjection(this);"></html:textarea>
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
							
							<label>Floating Rate Index</label>
							<logic:messagesPresent property="rateInformation.floatingRateIndex">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							  <html:select name="ICFPLegRequestForm"  property="rateInformation.floatingRateIndex"   onchange="getIndexTermDetails('OTHER')"  styleId="floatingRateIndexID" styleClass="span2">
							        <html:option  value="">Select...</html:option>
							       <logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
									<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
									</logic:notEmpty> 
							 </html:select>
							  
						</div>
						
					</div>  <!-- end of block -->
						<div class="span5 right" id="indexTermDivID">
						<div class="form-row">
							
							<label>Index Term</label>
							
							<logic:messagesPresent property="rateInformation.floatingRateIndexTerm">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							    <html:select name="ICFPLegRequestForm"  property="rateInformation.floatingRateIndexTerm"  styleId="floatingRateIndexTermID" styleClass="span2">
							       <html:option  value="">Select...</html:option>
							       <html:optionsCollection name="ICFPLegRequestForm" property="indexTermMap" label="value" value="key"/> 
							</html:select>
						</div>
						
					</div>  <!-- end of block -->
					
				</div>
			</div>
			 <div  id="maxSpreadDivID">
			   <div class="row">
					<div class="span5 right">
						<div class="form-row">
							
							<label>Maximum Spread (bps)</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<logic:messagesPresent property="rateInformation.maxSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="ICFPLegRequestForm" styleClass="span2 spreadvalidate"   property="rateInformation.maxSpread"  styleId="floatMaxSpreadBPSID"  maxlength="10"   />
							<span class="req-error" style="display:none;">error</span>
							
						</div>
						
					</div> <!-- end of block -->
					<div class="span5">
						<div class="form-row">
							
							<label>Minimum Spread (bps)</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<logic:messagesPresent property="rateInformation.minSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="ICFPLegRequestForm" styleClass="span2 spreadvalidate"   property="rateInformation.minSpread"  styleId="floatMinSpreadBPSID"  maxlength="10"   />
							<span class="req-error" style="display:none;">error</span>
						</div>
						
					</div> <!-- end of block -->
				</div>
			 </div>
			
			<div class="row">
					<div class="span5">
						<div class="form-row autosize-container1">
							
							<label>Transfer Pricing Summary</label>
							<div class="char-count">1000</div> 
							<logic:messagesPresent property="TPLegRequest.TPSummary">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:textarea name="ICFPLegRequestForm" styleClass="xlarge autosize1 messageinput" property="TPLegRequest.TPSummary" styleId="tpSummary"  rows="1" onblur="scriptInjection(this);" ></html:textarea>						
						</div>
					</div> <!-- end of block -->
				</div>
	   </div><!-- end of form form-mod -->
	   <c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" /> 
	   <c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<c:if test="${fn:length(legSummaryVO.exceptions) >0 }">
						<jsp:include page="/jsp/common/legPageExceptions.jsp">
							<jsp:param value="view" name="mode"/>
							<jsp:param value="${legNumber}" name="legIndex"/>      	
				     	</jsp:include>
					</c:if>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
	
	  <jsp:include page="../frontOffice/qualitativeAssessment.jsp" >
				<jsp:param name="factors" value="Transfer Pricing Risk"/>			
		</jsp:include>
		
		<div class="form-mod">
				<jsp:include page="../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/> 
					<jsp:param value="transferPricing/transferPricing" name="path"/>
				    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
				    <jsp:param value="legDetails" name="method"/>
				    <jsp:param value="Transfer Pricing" name="origin"/>
				    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>	
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
		
	 		<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
				<jsp:param name="legIndex" value="${legNumber}" />
			</jsp:include>  
			<!-- end uploads -->
				
		  
		 <jsp:include page="../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param value="transferPricing/transferPricing" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Transfer Pricing" name="origin"/>
			    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
			</jsp:include>
       	 	<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
			<c:if test="${sessionScope.section eq 'myTasks'}">
			<div class="span12 btn-container" style="margin-left:-10px!important;">
			<div class="span3 right submit-box">
				<div class="form-row">
				 <span  class="req-error" id="saveSpanID1" style="display:none;">a </span>
					<div class="radio-container">
					<label class="radio" id="savegotonextlegid">
						<input type="radio" value="savegotonextleg" id="savegotonextlegradioID" name="saveRCALeg">
						Save and go to next Leg
					</label>
					<span id="saveSpanID2" class="req-error" style="display:none;">a</span>
					<label class="radio">
					<span id="saveSpanID" class="req-error" style="display:none;">a</span>
						<input type="radio" value="saveandreturntodeal" id="savereturndealradioID"  name="saveRCALeg">
						Save and return to deal
					</label>
					</div>
				</div>
				
				<div id="actionButton">
				
				<button  type="button" name="command" value="saveLeg"  id="submitID" class="btn btn-success btn-large" style="display: block;width: 100%;">Submit
				</button>
				</div>
			 </div>	
			 
			  <a  class="btn right save-btn single" id="saveLegID" style="margin-top: 80px;" href="#" >Save</a>
			 <a style="margin-top:90px" href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" class="right cancel single">Cancel</a>
				
				</div>
			 </c:if>
			 <c:if test="${sessionScope.section eq 'myAssignedTasks'}">
			    <div class="span12 right btn-container">
				  <a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" class="right cancel single">Cancel</a>
				</div>
			</c:if>
			
			<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the Leg</a>
		</div>
      </div>
      <input type="hidden" id="actionId" value="${requestScope.actionId}">
      <input type="hidden" id="productType" value="${legSummaryVO.productType}" />
		   </html:form>
   <hr>

