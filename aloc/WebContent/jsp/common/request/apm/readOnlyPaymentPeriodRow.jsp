<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<td>
		 <s:if test="%{firstpaymentperiod.runCompletionDate eq null}">
		      <img class="actionImg editPayment" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="%{#parameters['curIndex']}"/>_<s:property value="firstpaymentperiod.APMConfigID" />">
		    
		</s:if>
		<s:else>
			<s:text name="label.request.hypen"/>
		</s:else>
	</td>
	
	<td><s:property value="firstpaymentperiod.paymentPeriodStartDate"/></td>
						
	<td><s:property value="firstpaymentperiod.paymentPeriodEndDate"/></td>
	
	<td><s:property value="firstpaymentperiod.FXRateRevalueDate"/></td>
	
	<td><s:property value="firstpaymentperiod.paymentPeriodCutoffDate"/></td>
	
	<td><s:property value="firstpaymentperiod.minPaymentAmountUSD"/></td>

	<td><s:property value="firstpaymentperiod.dayCount"/></td>
	
	
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
	
	<td><p><c:if test="${firstpaymentperiod.runCompletionDate eq null}">  -</c:if>
	<s:property value="firstpaymentperiod.runCompletionDate"/><p></td>
       
	<td><p><c:if test="${firstpaymentperiod.firstName eq null}">  -</c:if>
	      <s:property value="firstpaymentperiod.firstName"/>,<s:property value="firstpaymentperiod.lastName"/><p></td>
	      
	<td><p><c:if test="${firstpaymentperiod.equivalentUSDValue eq null}">  -</c:if>
	   <s:property value="firstpaymentperiod.equivalentUSDValue"/><p></td>
       	
	<td class="hide"><s:textfield name="firstpaymentperiod.apmConfigID" cssClass="configId"/></td>
	<td class="hide"> <s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
	<td class="hide paymentErrorId"> <s:property value="%{errorShow}"/></td>
	
	<script src="${pageContext.request.contextPath}/js/requestor/payment.js" type="text/javascript"></script>