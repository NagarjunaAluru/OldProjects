<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:if test="%{ridersLst.size>0}">
	<div class="row">
			<div class="span12">
			<h2><s:text name="label.request.riders"/></h2><hr class="h2-hr">
			<table class="table table-striped table-bordered sortable">
			<thead>
			<tr>
                <th colspan="1"><s:text name="label.request.alocRecNo"/></th>
				<th><s:text name="label.request.requestor"/></th>
				<th><s:text name="label.request.amountOnly"/></th>
				<th><s:text name="label.request.ExpirationDate"/></th>
				<th><s:text name="label.request.requestDate"/></th>
			</tr>
			</thead>
			<tbody>
				<s:iterator value="ridersLst" status="stat">
					<tr>
						<td><p><s:if test="%{riderRequestId==null}">-</s:if><s:else><s:property value="riderRequestId" /></s:else></p></td>
						<td><p><s:if test="%{lastName==null && firstName==null}">-</s:if><s:else><s:property value="lastName" />,<s:property value="firstName" /></s:else></p></td>
						<td><p><c:choose>
                				<c:when test="${empty bondAmt}">-</c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'N'}">-</c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'I'}"><s:property value="bondAmt"/></c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'D'}">(<s:property value="bondAmt"/>)</c:when>
                			</c:choose>
						</p></td>
						<td><p><s:if test="%{expiryDate==null}">-</s:if><s:else><s:property value="expiryDate" /></s:else></p></td>
						<td><p><s:if test="%{requestDate==null}">-</s:if><s:else><s:property value="requestDate" /></s:else></p></td>						
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
		    <p><s:text name="label.request.riderDescription"/> <s:property value="requestDetails.alocRecordId"/></p>
		</div>
	</div>
</s:else>
