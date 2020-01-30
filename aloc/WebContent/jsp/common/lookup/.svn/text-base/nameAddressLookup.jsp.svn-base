<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<div class="form-mod">
	<s:set name="noOfLEs" value="addressDetailsList.size"/>
	<c:set var="addressType" value="${fn:replace(addressTypeName,' ', '')}"></c:set>
	<h1 class="page-title span12"> ${addressType} Lookup Results - <s:property value="%{#noOfLEs}"/></h1>
	<p class="span12 left clear dashdesc">
	You search for: <s:property value="addressTypeName"/> Name/Address: <s:property value="nameForAddress"/>
	<s:hidden value="%{#parameters['scrollTopValue']}" id="scrollTopValueId" name="scrollTopValue"/>
	</p>
	<hr class="page-title-hr">
	<div class="clear"></div>
	<!-- If No Records Found from MDM when lookup from create request page. -->
	<s:if test="%{#noOfLEs == null || #noOfLEs == 0}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding:5px;">If the address you are looking for is not available, you can
			<a class="selectNameAddressManually" title="${addressType}"> manually enter</a> the details.</p>
		</div>
	</div>
	</s:if>
	<div class="row" style="margin-bottom: 0px!important;">
		<div class="span5">
			<div class="">
				<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
			</div>
		</div>
		<div class="span4a right">
			<div class="form-row">
				<s:form id="nameAddressLookupForm" cssStyle="margin: 0px!important;">
				<p style="margin-bottom:5px;"><s:property value="addressTypeName"/></p>
				<c:choose>
					<c:when test="${addressType eq 'Applicant'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="nameAddressId"/>
					</c:when>
					<c:when test="${addressType eq 'Tri-PartyApplicant'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="triPartyApplicantNameAddressId"/>
					</c:when>
					<c:when test="${addressType eq 'Customer'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="customerNameAddressId"/>
					</c:when>
					<c:when test="${addressType eq 'Principal'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="principalNameAddressId"/>
					</c:when>
					<c:when test="${addressType eq 'Obligee'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="obligeeNameAddressId"/>
					</c:when>
					<c:when test="${addressType eq 'Beneficiary'}">
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="beneficiaryNameAddressId"/>
					</c:when>
					<c:otherwise>
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" />
					</c:otherwise>
				</c:choose>
				<s:hidden name="nameAddressLookUpValue" value="yes" cssClass="nameAddressClass"></s:hidden>
				<s:url action="NameAddressLookup" namespace="/int" var="getNameAddressURL" escapeAmp="false" encode="true">
					<s:param name="addressTypeId"><s:property value="addressTypeId"/></s:param>
					<s:param name="dlocAddressType"><s:property value="dlocAddressType"/></s:param>
				</s:url>
				<a class="btn-secondary lookup" href="<s:property value="#getNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
				<img alt="Loading..." id="nameAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
				<br />
				<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
				<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				
				<p class="right" style="margin-top: 10px;"> <a class="add selectNameAddressManually" title="${addressType}" href="javascript:;">Add ${addressType} Address</a> </p>
				</s:form>
			</div>
		</div>
	</div>

	<s:if test="#noOfLEs > 0">
	<div class="active">
		<div id="searchSort">
		   	<div class="leftColSort">
		       	<p id="itemsPerPage">
		       		Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results
		       	</p>
		    </div>
		    <div class="rightColSort">
		         	Show&nbsp;&nbsp;
				<select class="pagination-rows">
				<option>10</option>
				<option selected="selected">20</option>
				<option>30</option>
				<option>40</option>
				<option>50</option>
				</select>&nbsp;&nbsp;results
		    </div>
			<div class="clear"></div>
		</div>
		<table class="table table-striped table-bordered sortable no-bottom active paginate lookupTableRes">
               <thead>
                   <tr>
                    <th colspan="1" width="50px"></th>
					<th>Name</th>
                    <th>Address</th>
                </tr>
               </thead>
               <tbody>
               	<s:iterator value="addressDetailsList" status="stat">
                <tr class="shown">
	                <td>
	                <input type="button" class="btn-secondary selectNameAddress" id="${addressType}_<s:property value="#stat.index" />" value="Select">
	                </td>
					<td><p><s:property value="name"/></p></td>
					<td>
					<s:iterator value="address">
						<p><s:property /></p>
					</s:iterator>
					<p><s:property value="city"/> <s:property value="stateProvince"/> <s:property value="ZIPPostalCode"/></p>
					<p><s:property value="country"/></p>
					</td>
					<td style="display: none"><s:property value="address[0]"/></td>
					<td style="display: none"><s:property value="address[1]"/></td>
					<td style="display: none"><s:property value="address[2]"/></td>
					<td style="display: none"><s:property value="city"/></td>
					<td style="display: none"><s:property value="stateProvince"/></td>
					<td style="display: none"><s:property value="stateProvinceCd"/></td>
					<td style="display: none"><s:property value="ZIPPostalCode"/></td>
					<td style="display: none"><s:property value="country"/></td>
					<td style="display: none"><s:property value="countryCd"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="clear"></div>
		<div id="searchSort">
		   	<div class="leftColSort">
				<p id="itemsPerPage1">Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results</p>
			</div>
		</div>
		<div class="clear"></div>
		<div class="row" id="hideLessthan10">
			<input type='hidden' id='current_page' />
         		<div class="span right">
		       	<div class="pagenavi left">
		       		
		       	</div>
		    	<div class="span3 jump-page">
					page:
					<input type="text" class="span1 manual">
					<a class="btn btn-success-blue" type="submit">Go</a>
				</div>
			</div>
     	</div>
	</div>
	<div class="row">
		<div class="span5">
			<div class="">
				<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
			</div>
		</div>
	</div>
	</s:if>
</div>
		