<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<div class="form-mod">
	<s:set name="noOfLEs" value="requestorLookupDetailsList.size"/>
	
	<c:set var="selectBtnClass" value="selectRequestorLookup"></c:set>
	<s:url action="RequestorDetailsLookup" namespace="/int" var="getRequestorDetailsURL" escapeAmp="false" encode="true">
		<s:param name="requestorType"><s:property value="requestorType"/></s:param>
	</s:url>
	<h1 class="page-title span12"> Contact Name Lookup Results - <s:property value="%{#noOfLEs}"/></h1>
	<p class="span12 left clear dashdesc">
	<s:hidden value="%{#parameters['scrollTopValue']}" id="scrollTopValueId" name="scrollTopValue"/>
	</p>
	<hr class="page-title-hr">
	<div class="clear"></div>
	<c:if test="${empty requestorLookupDetailsList}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding:5px;">No results found. Try a different Search.</p>
		</div>
	</div>
	</c:if>
	<div class="row" style="margin-bottom: 0px!important;">
		<div class="span5">
			<div class="">
				<c:choose>
					<c:when test="${param.pageOrigin eq 'Report'}">
						<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Report</a></p>
					</c:when>
					<c:otherwise>
						<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="span4a right">
			<div class="form-row">
				<s:form id="requestorSSOLookupForm" cssStyle="margin: 0px!important;">
				<p style="margin-bottom:5px;">Contact name</p>
				<s:textfield name="requestorName" cssClass="span3 lookup-filterValue" id="requestorNameId" />
				<a class="btn-secondary lookup" href="<s:property value="#getRequestorDetailsURL"/>" ><s:text name="label.request.common.lookup"/></a>
				<img alt="Loading..." id="requestorSSOIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
				<p class="guidance"><s:text name="label.changeRequestOwnership.lookupComment" /></p>
				<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				<s:hidden name="requestorType" id="requestorTypeId" value="%{requestorType}"></s:hidden>
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
                    <th width="50px"></th>
                    <th>Name</th>
					<th>Email</th>
                    <th>SSO ID</th>
                </tr>
               </thead>
               <tbody>
               	<s:iterator value="requestorLookupDetailsList" status="stat">
                <tr class="shown">
	                <td>
	                	<input type="button" class="btn-secondary ${selectBtnClass}" id="selectBCPId<s:property value="#stat.index" />" value="Select">
	                </td>
					<td><p><s:property value="requestorLookupLastName"/>, <s:property value="RequestorLookupFirstName"/></p></td>
					<td><p><s:property value="requestorLookupEmailAddress"/></p></td>
					<td><p><s:property value="requestorLookupSso"/></p></td>
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
					<c:choose>
						<c:when test="${param.pageOrigin eq 'Report'}">
							<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Report</a></p>
						</c:when>
						<c:otherwise>
							<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</s:if>
</div>
