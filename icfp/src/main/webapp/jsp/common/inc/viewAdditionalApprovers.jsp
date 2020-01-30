<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
<h2 class="span12 collapsible">Additional Approvers</h2>
			
<div class="row">
	<div class="span12">
	 <table class="table table-striped table-bordered sortable">
		<thead>
		  <tr>
			<th>Name</th>
			<th>Added By</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach var="additionalApprover" items="${currentAdditionalApprovers.userInfos}" >
				<tr>
					<td>${additionalApprover.lastName}, ${additionalApprover.firstName}</td>
					<td>${additionalApprover.assignerLastName}, ${additionalApprover.assignerFirstName}</td>
			    </tr>
			</c:forEach>
				 
		</tbody>
  		</table>
	</div>
	<c:choose>
	<c:when test="${not empty param.nonFourBlocker and param.nonFourBlocker eq 'Yes'}">
		<div class="span8">
		<div class="form-row">
			<label>The list of additional approvers for Treasury legal entities is complete.</label>
			<div class="radio-container">
			
			<c:set target="${sessionScope.dealRequestForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
				<label class="radio">
				<html:radio  name="dealRequestForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" disabled="true"></html:radio> Yes 
				</label>
				<label class="radio">
				<html:radio name="dealRequestForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" disabled="true"></html:radio> 	No
				</label>
			</div>
		</div>
		</div>
	</c:when>
	<c:when test="${not empty param.searchResult and param.searchResult eq 'Yes'}">
		<div class="span8">
		<div class="form-row">
			<label>The list of additional approvers for Treasury legal entities is complete.</label>
			<div class="radio-container">
			
			<c:set target="${sessionScope.searchResultsForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
				<label class="radio">
				<html:radio  name="searchResultsForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" disabled="true"></html:radio> Yes 
				</label>
				<label class="radio">
				<html:radio name="searchResultsForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" disabled="true"></html:radio> 	No
				</label>
			</div>
		</div>
		</div>
	</c:when>
	<c:otherwise>
	<div class="span8">
		<div class="form-row">
			<label>The list of additional approvers for Treasury legal entities is complete.</label>
			<div class="radio-container">
			<c:set target="${sessionScope.updateStatusForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
				<label class="radio">
				<html:radio  name="updateStatusForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" disabled="true"></html:radio> Yes 
				</label>
				<label class="radio">
				<html:radio name="updateStatusForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" disabled="true"></html:radio> 	No
				</label>
			</div>
		</div>
	</div>
	</c:otherwise>
	</c:choose>
</div>
</div><!-- end of form form-mod -->