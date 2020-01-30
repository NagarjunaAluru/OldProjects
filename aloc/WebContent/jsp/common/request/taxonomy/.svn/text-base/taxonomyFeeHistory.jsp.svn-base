<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>

<s:if test="%{feeHistLst.size>0}">
	<div class="row">
				<div class="span12">
				<h2><s:text name="label.request.feeHistory"/></h2><hr class="h2-hr">
				<table class="table table-striped table-bordered sortable" id="taxonomyFeeHistory">
					<thead>
					  <tr>
                      	<th colspan="1"><s:text name="label.request.paymentID"/></th>
						<th><s:text name="label.request.paymentDate"/></th>
						<th><s:text name="label.request.paymentCurrency"/></th>
						<th><s:text name="label.request.paymentAmount"/></th>
						<th><s:text name="label.request.ExpirationDate"/></th>
						<th><s:text name="label.request.EconomicexpirationDate"/></th>
						<th><s:text name="label.request.totalUSDEquivalent"/></th>
					  </tr>
					</thead>
					<tbody>
				<s:iterator value="feeHistLst" status="stat">
					<tr>
						<td><p><s:if test="%{paymentID==null}">-</s:if><s:else><s:property value="paymentID" /></s:else></p></td>
						<td><p><s:if test="%{paymentDate==null}">-</s:if><s:else><s:property value="paymentDate" /></s:else></p></td>
						<td><p><s:if test="%{paymentCurrencyName==null}">-</s:if><s:else><s:property value="paymentCurrencyName" /></s:else></p></td>
						<td><p><s:if test="%{paymentAmount==null}">-</s:if><s:else><s:property value="paymentAmount" /></s:else></p></td>
						<td><p><s:if test="%{expiryDt==null}">-</s:if><s:else><s:property value="expiryDt" /></s:else></p></td>
						<td><p><s:if test="%{economicExpiryDt==null}">-</s:if><s:else><s:property value="economicExpiryDt" /></s:else></p></td>
						<td><p><s:if test="%{USDPaymentAmount==null}">-</s:if><s:else><s:property value="USDPaymentAmount" /></s:else></p></td>
				  	</tr>
			  	</s:iterator>
			</tbody>
		  </table>
		</div>
	</div>
</s:if>
<s:else>
	<div class="row highlighted">
		<div class="span12">
		    <p><s:text name="label.request.feeHistoryDescription"/> <s:property value="requestDetails.alocRecordId"/></p>
		</div>
	</div>
</s:else>
