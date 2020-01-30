<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="/jsp/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.paymentPeriod" />  </title>
	<script src="${pageContext.request.contextPath}/js/requestor/payment.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

</head>

<body>
	
	<div class="container main">
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<h1 class="page-title span12"><s:text name="label.request.paymentPeriod" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.apmPaymentPeriod" /></p>
		<hr class="page-title-hr">
	<div class="clear"></div>
   
	<div class="form-mod">
		<div class="row">
			<div class="span12">
				<a href="javascript:;" class="left addpayment add"><s:text name="label.request.addPaymentPeriod" /></a>
			</div>
		</div>
			    
		<s:if test="%{apmDetails.paymentPeriodDetails.isEmpty()}">
					<s:text name="label.request.atLeastTwo" />	        	
		</s:if>
		
		<div class="row">
		<div class="span12" id="paymentPeriodDiv">
		<table class="table table-striped table-bordered no-bottom paginate" id="paymentPeriod">
			<thead>
	            <tr>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.action" /></span></th>
		            <th colspan="1" style="padding-right:50px;"><span style="font-weight: bold;"><s:text name="label.request.paymentPeriodStartDate" /></span></th>
		            <th colspan="1" style="padding-right:50px;"><span style="font-weight: bold;"><s:text name="label.request.paymentPeriodEndDate" /></span></th>
		            <th colspan="1" style="padding-right:50px;"><span style="font-weight: bold;"><s:text name="label.request.fxRateRevalueDate" /></span></th>
		            <th colspan="1" style="padding-right:50px;"><span style="font-weight: bold;"><s:text name="label.request.paymentPeriodCutoffDate" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.minPaymentAmountUSDEquivalent" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.dayCount" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.feeHistoryCSV" /> </span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.ibsFile" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.webCashFile" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.runCompletionDate" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.completedBy" /></span></th>
		            <th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.equivalentUSDValue" /></span></th>
		        </tr>
	        </thead>
			 <tbody>
			 	<s:iterator value="apmDetails.paymentPeriodDetails" status="paymentPeriodStart">				
					
						<tr class="shown addRowpayment" >
			                <td>
			                  <s:if test="%{runCompletionDate == null}">
							      <img class="actionImg editPayment" src="${pageContext.request.contextPath}/img/edit-leg.gif" alt="<s:property value="#paymentPeriodStart.index"/>_<s:property value="APMConfigID" />" >
							  </s:if>
							  <s:else>
							    <s:text name="label.request.hypen"/>
							  </s:else>
			                </td>
							<td>
							 <s:if test="%{paymentPeriodStartDate != null}">
							 <p><s:property value="paymentPeriodStartDate"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{paymentPeriodEndDate != null}">
							 <p><s:property value="paymentPeriodEndDate"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{FXRateRevalueDate != null}">
							 <p><s:property value="FXRateRevalueDate"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{paymentPeriodCutoffDate != null}">
							 <p><s:property value="paymentPeriodCutoffDate"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{minPaymentAmountUSD != '' && minPaymentAmountUSD != null}">
							 <p><s:property value="minPaymentAmountUSD"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{dayCount != '' && dayCount != null}">
							 <p><s:property value="dayCount"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
								<c:set var="showCSVHypen" value="true"></c:set>
								<s:iterator value="attachments" status="attachmentsStatus">
								<c:if test="${attachmentTypeId eq '7'}">
									<c:set var="showCSVHypen" value="false"></c:set>
									<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
									 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
									 <s:param name="indexId"><s:property value="%{#paymentPeriodStart.index}" /></s:param>
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
							<s:iterator value="attachments" status="attachmentsStatus">
								<c:if test="${attachmentTypeId eq '6'}"> 
								<c:set var="showIBSHypen" value="false"></c:set>
								<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
								 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
								 <s:param name="indexId"><s:property value="%{#paymentPeriodStart.index}" /></s:param>
							    </s:url>
								<a href="<s:property value="#downloadAPMAttachmentURL"/>" target="_blank"><s:property  value="attachmentName"/></a>
								</c:if>
							</s:iterator>
							 <c:if test="${showIBSHypen}">
							 <p><s:text name="label.request.hypen"/></p>
							 </c:if>
							</td>
							<td>
							<c:set var="showWebCashHypen" value="true"></c:set>
							<s:iterator value="attachments" status="attachmentsStatus">
								<c:if test="${attachmentTypeId eq '5'}">
								<c:set var="showWebCashHypen" value="false"></c:set> 
								<s:url action="downloadAPMAttachment.action" namespace="/int/apm" var="downloadAPMAttachmentURL" escapeAmp="false" encode="true">
								 <s:param name="geLibFileId"><s:property value="geFileId" /></s:param>
								 <s:param name="indexId"><s:property value="%{#paymentPeriodStart.index}" /></s:param>
							    </s:url>
								<a href="<s:property value="#downloadAPMAttachmentURL"/>" target="_blank"><s:property  value="attachmentName"/></a>
								</c:if>
							</s:iterator>
							 <c:if test="${showWebCashHypen}">
							 	<p><s:text name="label.request.hypen"/></p>
							 </c:if>
							</td>
							<td>
							 <s:if test="%{runCompletionDate != null}">
							 <p><s:property value="runCompletionDate"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{(firstName != '' && firstName != null) || (lastName != '' && lastName != null)}">
							 <p><s:property value="lastName"/>,<br /><s:property value="firstName"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td>
							 <s:if test="%{equivalentUSDValue != '' && equivalentUSDValue != null}">
							 <p><s:property value="equivalentUSDValue"/></p>
							 </s:if>
							 <s:else>
							 <p><s:text name="label.request.hypen"/></p>
							 </s:else>
							</td>
							<td class="hide configId"> <s:property value="APMConfigID" /></td>
							<td class="hide paymentErrorId"> <s:property value="%{errorShow}"/></td>
						</tr>		
				</s:iterator>
					<s:hidden name="curPaymentSize" value="%{apmDetails.paymentPeriodDetails.size}" id="curPaymentSize"/>
				
			</tbody>
		</table>		
		</div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="span12">
				<a href="javascript:;" class="left addpayment add"><s:text name="label.request.addPaymentPeriod" /></a>
			</div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="span right">
				<div class="pagenavi left">	
			    </div>
				<div class="span3 jump-page">
						 Jump to
						<input type="text" class="span1 manual">
						<a class="btn btn-success-blue" type="submit">Go</a>
				</div>
			</div>
	  </div>
	  <input type='hidden' id='current_page' />
	  <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
	</div>
    </div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
	
</body>
</html>