<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.includeScripts != false}">
<script type="text/javascript">
$(document).ready(function() {
	sendbackOnloadShow();
});
</script>
</c:if>
<s:set name="isEditMode" value="editMode"/>

	<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.paymentScheduleDetails.requiresEdits)}">
	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.paymentScheduleDetails.requiresEdits}">
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
										<p>
											<s:property value="requestDetails.paymentScheduleDetails.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
					 </s:if>
	  
		<a name="sixth"></a>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label>
					<c:choose>
						<c:when test="${param.page eq 'BidReply'}">
							<s:label key="label.request.numOfMonthsDLOCValid"/>
						</c:when>
						<c:otherwise>
							<s:label key="label.request.estimatedNumberofMonthsLCisValid"/>
						</c:otherwise>
					</c:choose>
					</label>
					 <s:textfield name="requestDetails.paymentScheduleDetails.validLCMonths" theme="aloc" cssClass="span1 mandatory bigInt" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.ApproximateIssueDate"/>
					<s:textfield name="requestDetails.paymentScheduleDetails.issueDt" theme="aloc" cssClass="span2 datePaymentSchedule mandatory"
					id="paymentScheduleIssueDate"/>
					<div><p class="guidance"><s:text name="label.request.ddmmmyyyy" /></p></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span10">
				<span style="color:red"><s:fielderror fieldName="requestDetails.paymentScheduleDetails.additionalPayments" /></span>
				<table class="table table-striped table-bordered  payment" id="paymentSchedule">
					<thead>
						<tr>
						    <th>Action</th>
							<th><s:text name="label.request.EstimatedPaymentAmount"/></th>
							<th><s:text name="label.request.EstimatedMonthsFromIssue"/></th>
							<th><s:text name="label.request.EstimatedPaymentDate"/></th>
							
						</tr>
					</thead>
					<tbody>
					 <s:if test="%{requestDetails.paymentScheduleDetails.additionalPayments != null && requestDetails.paymentScheduleDetails.additionalPayments.size>0}">
					 
               			 <s:iterator value="requestDetails.paymentScheduleDetails.additionalPayments" var="additionalPayments" status="additionalPaymentsStat">
               			 <s:if test="%{requestDetails.paymentScheduleDetails.additionalPayments[#additionalPaymentsStat.index].opCode != 'DELETE'}">
                		<tr class="additionalPaymentsRow">
                		<td>
                		<s:if test="%{#additionalPaymentsStat.index>0}">
		           			<a href="javascript:void(0);" class="delete-paymentSchedules delete-tr-hide" title="Delete this payment">Delete Payment</a> 
		           			</s:if>
		           		</td>
							<td><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].estAmt" theme="aloc" cssClass="span3 mandatory bigDecimal" maxlength="21"/></td>
							<td><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].estMonths" theme="aloc" cssClass="span3 mandatory estimatedMonths bigInt" maxlength="3"/></td>
							<td><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].estDt" theme="aloc" cssClass="span2 date mandatory"/>
							<s:if test="%{requestDetails.paymentScheduleDetails.additionalPayments[#additionalPaymentsStat.index].estPayId != null}">										
								<s:hidden cssClass="paymentOpcode" name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].opCode" value="UPDATE"/>
								<s:hidden cssClass="paymentId" name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].estPayId" /></s:if>
							<s:else>
								<s:hidden cssClass="paymentOpcode" name="requestDetails.paymentScheduleDetails.additionalPayments[%{#additionalPaymentsStat.index}].opCode" value="INSERT"/> 
							</s:else>	
							</td> 
                	</tr>            		
                       </s:if>
	                </s:iterator>
	                <s:hidden id="newAdditionalPaymentsIndex" name="newAdditionalPaymentsIndex" value="%{requestDetails.paymentScheduleDetails.additionalPayments.size}" />
					<s:hidden id="showIndex" name="showIndex" value="%{requestDetails.paymentScheduleDetails.additionalPayments.size}" />
                    </s:if>
                    <s:else>
                    <tr class="additionalPaymentsRow">
                         <td>
							<s:hidden cssClass="paymentOpcode" name="requestDetails.paymentScheduleDetails.additionalPayments[0].opCode" value="INSERT"/> 
							</td>
							<td><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[0].estAmt" theme="aloc" cssClass="span3 mandatory" maxlength="21"/></td>
							<td><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[0].estMonths" theme="aloc" cssClass="span3 mandatory estimatedMonths" maxlength="38"/></td>
							<td nowrap="nowrap"><div><s:textfield name="requestDetails.paymentScheduleDetails.additionalPayments[0].estDt" theme="aloc" cssClass="span2 date mandatory"/></div></td>
							
					</tr>
                     <s:hidden id="newAdditionalPaymentsIndex" name="newAdditionalPaymentsIndex" value="1" />
					 <s:hidden id="showIndex" name="showIndex" value="1" />
                    </s:else>                   
  				</tbody>
              </table> 	
              <a href="javascript:;" class="add add-paymentSchedule" id="addPayment"><s:text name="label.request.addPayment"/></a>				
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label><s:label key="label.request.SpInstructionsOptional" /></label>
					<div class="txtCnt3"></div>
					<s:textarea name="requestDetails.paymentScheduleDetails.splInstructions" onkeypress="return imposeMaxLength(this, 299);"
					cols="50" rows="1" required="false" cssClass="autosize3 messageinput" id="splInstructions"></s:textarea>
					<div class="clear"></div>
                     <div class="counter">300</div> <!-- fix positions -->
                     <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('paymentSchedulePanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
			<div class="row">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.estimatedNumberofMonthsLCisValid"/>:</label> 
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.paymentScheduleDetails.validLCMonths}"/></p>
						</div>
					</div>
			</div>
			<div class="row">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.ApproximateIssueDate"/>:</label> 
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="requestDetails.paymentScheduleDetails.issueDt"/></p>
						</div>
					</div>
			</div>
			<div class="row">
                <div class="span8">
			        <table class="table table-striped table-bordered sortable payment">
					    <thead>
					        <tr>
					        	<c:choose>
					        		<c:when test="${param.page eq 'BidReply'}">
					        			<th><s:text name="label.request.paymentAmount"/></th>
										<th><s:text name="label.request.monthsFromIssue"/></th>
										<th><s:text name="label.request.paymentDate"/></th>
					        		</c:when>
					        		<c:otherwise>
					        			<th><s:text name="label.request.EstimatedPaymentAmount"/></th>
										<th><s:text name="label.request.EstimatedMonthsFromIssue"/></th>
										<th><s:text name="label.request.EstimatedPaymentDate"/></th>
					        		</c:otherwise>
					        	</c:choose>								
							</tr>
					    </thead>
					    <tbody>
					    	<s:iterator value="requestDetails.paymentScheduleDetails.additionalPayments" status="goodsOrg">
						     <s:if test="%{opCode != 'DELETE'}">	
						    <tr>
							    <td><p><s:property value="estAmt"/></p></td>
								<td><p><c:out value="${estMonths}"/></p></td>
							    <td><p><s:property value="estDt"/></p></td>
						    </tr> 
						    </s:if>
						    </s:iterator>
					    </tbody>
				    </table>
				    
                </div>
		    </div>
			<div class="row">
					<div class="span33">
						<div class="form-row">
						<label><s:text name="label.request.specialInstructions"/>:</label>
					</div>
				</div>
				<div class="span5 left">
						<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.paymentScheduleDetails.splInstructions}"/></p>
					</div>
				</div>
			</div>
		
		</s:elseif>		
