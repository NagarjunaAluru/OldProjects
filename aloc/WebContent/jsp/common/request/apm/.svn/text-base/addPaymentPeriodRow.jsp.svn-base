<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
	<td> - </td>
	
	<td><s:textfield name="firstpaymentperiod.paymentPeriodStartDate" cssClass="date startDate" cssStyle="width:73px;" />
		<div style="color: red;" class="errormessage">
			<s:fielderror fieldName="firstpaymentperiod.paymentPeriodStartDate"></s:fielderror>
		</div>
	</td>
						
	<td><s:textfield name="firstpaymentperiod.paymentPeriodEndDate" cssClass="date endDate"  cssStyle="width:73px;"/>
		<div style="color: red;" class="errormessage">
			<s:fielderror fieldName="firstpaymentperiod.paymentPeriodEndDate"></s:fielderror>
		</div>
	</td>
	
	<td><s:textfield name="firstpaymentperiod.FXRateRevalueDate" cssClass="date reValueDate" cssStyle="width:73px;"/>
		<div style="color: red;" class="errormessage">
			<s:fielderror fieldName="firstpaymentperiod.FXRateRevalueDate"></s:fielderror>
		</div>
	</td>
	
	<td><s:textfield name="firstpaymentperiod.paymentPeriodCutoffDate"  cssClass="date cutOfDate" cssStyle="width:73px;"/>
		<div style="color: red;" class="errormessage">
			<s:fielderror fieldName="firstpaymentperiod.paymentPeriodCutoffDate"></s:fielderror>
		</div>
	</td>
	
	<td><s:textfield name="firstpaymentperiod.minPaymentAmountUSD" maxlength="20" cssClass="usdAmount" cssStyle="width:80px;" />
		<div style="color: red;" class="errormessage">
			<s:fielderror fieldName="firstpaymentperiod.minPaymentAmountUSD"></s:fielderror>
	    </div>
    </td>
	
	<td><s:textfield name="firstpaymentperiod.dayCount"  maxlength="20" cssClass="dayCount" cssStyle="width:80px;" />
		<div style="color: red;" class="errormessage">
	        <s:fielderror fieldName="firstpaymentperiod.dayCount"></s:fielderror>
	    </div>
    </td>
	<td>
		<c:set var="showCSVHypen" value="true"></c:set>
	 	<s:iterator value="firstpaymentperiod.attachments" status="attachmentsStatus">
			<c:if test="${attachmentTypeId eq '7'}">
			<c:set var="showCSVHypen" value="false"></c:set>
			<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
			 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
			 <s:param name="indexId"><s:property value="firstpaymentperiod.IBSFile"/></s:param>
		    </s:url>
			<a href="<s:property value="#downloadAPMAttachmentURL"/>" ><s:property  value="attachmentName"/></a>
			</c:if>								
		</s:iterator>
		<c:if test="${showCSVHypen}">
		 	 <p><s:text name="label.request.hypen"/></p>
		 </c:if>
	</td>
	
	<td>
		<c:set var="showIBSHypen" value="true"></c:set>
	 	<s:iterator value="firstpaymentperiod.attachments" status="attachmentsStatus">
			<c:if test="${attachmentTypeId eq '6'}">
			<c:set var="showIBSHypen" value="false"></c:set>
			<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
			 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
			 <s:param name="indexId"><s:property value="firstpaymentperiod.IBSFile"/></s:param>
		    </s:url>
			<a href="<s:property value="#downloadAPMAttachmentURL"/>" ><s:property  value="attachmentName"/></a>
			</c:if>								
		</s:iterator>
		 <c:if test="${showIBSHypen}">
		 	<p><s:text name="label.request.hypen"/></p>
		 </c:if>
	</td>
       
    <td>
    	<c:set var="showWebCashHypen" value="true"></c:set>
    	<s:iterator value="firstpaymentperiod.attachments" status="attachmentsStatus">
			<c:if test="${attachmentTypeId eq '5'}">
			<c:set var="showWebCashHypen" value="false"></c:set>  
			<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
			 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
			 <s:param name="indexId"><s:property value="firstpaymentperiod.IBSFile"/></s:param>
		    </s:url>
			<a href="<s:property value="#downloadAPMAttachmentURL"/>" ><s:property  value="attachmentName"/></a>
			</c:if>
		</s:iterator>
		 <c:if test="${showWebCashHypen}">
		 	<p><s:text name="label.request.hypen"/></p>
		 </c:if>
    </td>
    
    <td><c:if test="${firstpaymentperiod.runCompletionDate eq null}">  -</c:if>
		<s:property value="firstpaymentperiod.runCompletionDate"/><p>
	</td>
    
    <td><c:if test="${firstpaymentperiod.firstName eq null}">  -</c:if>
	   <s:property value="firstpaymentperiod.firstName"/>,<s:property value="firstpaymentperiod.lastName"/>
	</td>
	
    <td><c:if test="${firstpaymentperiod.equivalentUSDValue eq null}">  -</c:if>
	   <s:property value="firstpaymentperiod.equivalentUSDValue"/>
	</td>
    
	<td class="hide">
		<s:textfield name="firstpaymentperiod.APMConfigID" 
			cssClass="configId"/>
	</td>
	<td class="hide"> <s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
	<td class="hide paymentErrorId"> <s:property value="%{errorShow}"/></td>	
<script src="${pageContext.request.contextPath}/js/requestor/payment.js" type="text/javascript"></script>
	