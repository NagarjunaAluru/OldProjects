<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.includeScripts != false}">
	<script src="${pageContext.request.contextPath}/js/requestor/apm.js" type="text/javascript"></script>
</c:if>
<s:hidden name="apmDetails.feePaymentRunDetails.creditsCarryOverFlag" id="creditsCarryOverHidden" />

<c:if test="${not empty errorMsg}">
		<div class="row" id="errorMsg">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon"><s:text name="label.request.error"></s:text> </p>
					</div>
					<div class="errorContent">
						<p>
							<s:property value="errorMsg" />
						</p>
						<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>	
</c:if>

<s:if test="%{apmDetails.feePaymentRunDetails.bankFeeDetails != null && apmDetails.feePaymentRunDetails.bankFeeDetails.size > 0}">
<s:if test="%{apmDetails.feePaymentRunDetails.totalInvalidBUCADNs != null && apmDetails.feePaymentRunDetails.totalInvalidBUCADNs > 0}">
	<div class="row" id="bucAdnValMesId">
		<div class="span12" id="bucADNDiv">
			<div class="errorbox">
			<div class="errorHead">
				<p class="erroricon">
					<s:text name="label.eas.common.error" />
				</p>
			</div>
			<div class="errorContent">
			&nbsp;&nbsp;&nbsp;&nbsp; 
			<s:text name="label.request.apm.bucadn.ibsFailMessage" />
			<s:url action="getAllBUCADNDetails.action" namespace="/int/apm" var="getBucAdnRequest" escapeAmp="false" encode="true">
			</s:url>
			<a href="<s:property value="getBucAdnRequest"/>"><s:text name="label.request.apm.bucadn.bucadnUpdate" /></a>
			<br>	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:text name="label.request.apm.bucadn.noOfFailTrans" /><s:property value="apmDetails.feePaymentRunDetails.totalInvalidBUCADNs"/>
			</div> 
		</div>
	</div>
	</div>
   </s:if>

	<div class="row" id="feetable" style="margin-left:5px;">
		<div style="span12">
	
	<div id="searchSort">
	   	<div class="leftColSort">
	       	<p id="itemsPerPage">
	       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
	       	</p>
	    </div>
	    <div class="rightColSort">
	         	Show&nbsp;&nbsp;
			<select class="pagination-rows">
			<option>10</option>
			<option>20</option>
			<option>30</option>
			<option>40</option>
			<option>50</option>
			</select>&nbsp;&nbsp;results
	    </div>	
		<div class="clear"></div>
	</div>	
		
	<table id="feeTableId" class="table table-striped table-bordered paginate">
	<colgroup width="30"></colgroup>
	<thead>
		<tr id="column_head">
	        <th colspan="2"><b><s:text name="label.request.bankCapsName" /></b></th>
            <th colspan="1"><b><s:text name="label.request.bucOradn" /></b></th>
            <th colspan="1"><b><s:text name="label.apm.paymentCurrency" /></b></th>
            <th colspan="1"><b><s:text name="label.request.totalPaymentAmount" /></b></th>
            <th colspan="1"><b><s:text name="label.request.totalUSDEquivalent" /></b></th>
            <th colspan="1"><b><s:text name="label.request.numberOfPayments" /></b></th>
	    </tr>
	</thead>
        <tbody>
        	<s:iterator value="apmDetails.feePaymentRunDetails.bankFeeDetails" status="stat">
        	<tr class="shown" id="tr<s:property value="#stat.count" />">
                 <td><div class="down" style="margin-left : -10px;" id="arrow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="expandProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 15px;width: 15px;">
                 <span class="hide"><c:out value="${bankMDMId}"/></span></div></td>
                 <td> 
				 <c:if test="${not empty bankName}">
				 <c:out value="${bankName}"/>
				 </c:if>
				 <c:if test="${empty bankName}">
				 <s:text name="label.request.hypen"/>
				 </c:if>
				 </td>
				<td> 
				<c:if test="${not empty BUCADNError}">
			 	 <c:out value="${BUCADNError}"/>
			 	</c:if>
				 <c:if test="${empty BUCADNError}">
				 	<s:text name="label.request.hypen"/>
				 </c:if>
				</td>
				<td> 
				 <c:if test="${not empty paymentCurrencyCode}">
				 <c:out value="${paymentCurrencyCode}"/>
				 </c:if>
				 <c:if test="${empty paymentCurrencyCode}">
				 <s:text name="label.request.hypen"/>
				 </c:if>
				</td>
				<td> 
				 <c:if test="${not empty totalPaymentAmount}">
				 <c:out value="${totalPaymentAmount}"/>
				 </c:if>
				 <c:if test="${empty totalPaymentAmount}">
				 <s:text name="label.request.hypen"/>
				 </c:if>
				</td>
				<td> 
				 <c:if test="${not empty totalUSDEquival}">
				  <c:out value="${totalUSDEquival}"/>
				 </c:if>
				 <c:if test="${empty totalUSDEquival}">
				 <s:text name="label.request.hypen"/>
				 </c:if>
				</td>
				<td> 
				 <c:if test="${not empty numberOfPayments}">
				 <c:out value="${numberOfPayments}"/>
				 </c:if>
				 <c:if test="${empty numberOfPayments}">
				 <s:text name="label.request.hypen"/>
				 </c:if>
				</td>
            </tr>
            <tr id="showDown">
	            <td colspan="7" class="trbg">
	            </td>
        	</tr>
        </s:iterator>
   	 </tbody>
	</table>	
	<s:hidden name="showCalculateFeeTable" value="%{showCalculateFeeTable}" id="showCalculateFeeTable"></s:hidden>
			<div class="clear"></div>
			<div id="searchSort">
			   	<div class="leftColSort">
					<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
				</div>
			</div>
			<div style="height:50px;"></div>				
	 	</div>
	</div> 
			<input type='hidden' id='current_page' />
			<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script> 	
</s:if> 
	
	        