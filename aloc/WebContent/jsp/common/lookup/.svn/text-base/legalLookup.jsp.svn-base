<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<div class="form-mod">
	<s:set name="noOfLEs" value="legalEntities.size"/>
	
	<input type="hidden" value="${param.siteLEType}" id="siteLEType">
	<input type="hidden" value="${param.escoListIndex}" id="ecsoReportId">
	
	<h1 class="page-title span12">Legal Entity - Lookup Results - <s:property value="%{#noOfLEs}"/></h1>
	<p class="span12 left clear dashdesc">
	You search for: Legal Entity: <s:property value="goldId"/>
	<s:hidden value="%{goldId}" id="legalEntityGoldId" name="legalEntityGoldId"/>
	<s:hidden value="%{#parameters['scrollTopValue']}" id="scrollTopValueId" name="scrollTopValue"/>
	</p>
	<hr class="page-title-hr">
	<div class="clear"></div>
		
	<!-- If No Records Found from MDM when lookup from create request page. -->
	<c:if test="${empty legalEntities}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding:5px;">No results found. Try a different Search.</p>
		</div>
	</div>
	</c:if>
	
	<div class="row" style="margin-bottom: 0px!important;">
		<div class="span5">
			<div class="">
				<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
				<!-- <p><a class="btn-tertiary" href="javascript:;" >&#60; Return to Report</a></p> -->
					
			</div>
		</div>
		<div class="span4a right">
			<div class="form-row">
				<s:form id="legalEntityLookupForm" cssStyle="margin: 0px!important;">
				<p style="margin-bottom:5px;">Legal Entity</p>
				<s:textfield name="goldId" cssClass="span3 lookup-filterValue goldId" id="leGoldId" />
				<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true">
					<s:param name="pageNumber">1</s:param>
				</s:url>
				<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>" ><s:text name="label.request.common.lookup"/></a>
				<img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
				<p class="guidance"><s:text name="label.request.partialEntity" /> </p>
				<span class="lookup-error hide" style="color: #AE2C2C;"></span>
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
			<table class="table table-striped table-bordered sortable no-bottom active paginate lookupTableRes" id="lelookupTabId">
                <thead>
                    <tr>
	                    <th colspan="1" width="50px"></th>
	                    <th colspan="1" width="160px">GOLD ID</th>
						<th>Name</th>
						<th>Address</th>
	                </tr>
                </thead>
                <tbody>
                	<s:iterator value="legalEntities" status="stat">
	                <tr class="shown">
		                <td>
		                	<input type="button" class="btn-secondary selectGoldId" id="selectGoldId<s:property value="#stat.index" />" value="Select">
		                </td>
						<td><p><s:property value="LEGoldId"/></p></td>
						<td><p><s:property value="LEName"/></p></td>
						<td style="display: none"><s:property value="LEMDMId"/></td>
						<td>
					<s:iterator value="LEAddress[0].address">
						<p><s:property /></p>
					</s:iterator>
					<p><s:property value="LEAddress[0].city"/> <s:property value="LEAddress[0].stateProvince"/> <s:property value="LEAddress[0].ZIPPostalCode"/></p>
					<p><s:property value="LEAddress[0].country"/></p>
					</td>
					<td style="display: none"><s:property value="LEAddress[0].address[0]"/></td>
					<td style="display: none"><s:property value="LEAddress[0].address[1]"/></td>
					<td style="display: none"><s:property value="LEAddress[0].address[2]"/></td>
					<td style="display: none"><s:property value="LEAddress[0].city"/></td>
					<td style="display: none"><s:property value="LEAddress[0].stateProvince"/></td>
					<td style="display: none"><s:property value="LEAddress[0].ZIPPostalCode"/></td>
					<td style="display: none"><s:property value="LEAddress[0].country"/></td>
					<td style="display: none"><s:property value="LEAddress[0].stateProvinceCd"/></td>
					<td style="display: none"><s:property value="LEAddress[0].countryCd"/></td>
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
				<div class="span33 right" id="pageDivID">
			    	<c:if test="${previousPageStart gt 0 }">
			    	<s:url action="LegalEntityLookup" namespace="/int" var="getPreviousLEURL" escapeAmp="false" encode="true">
			    		<s:param name="pageNumber"><s:property value="previousPageStart"/> </s:param>
			    		<s:param name="filterValue"><s:property value="goldId"/></s:param>
					</s:url>
		           	<a type="submit" id="previousID" href="<s:property value="#getPreviousLEURL"/>" class="btn btn-success left">&#60;Previous 100</a>
		           	</c:if>
		           	<c:if test="${recordCount ge 100 }">
		           	<s:url action="LegalEntityLookup" namespace="/int" var="getNextLEURL" escapeAmp="false" encode="true">
			    		<s:param name="pageNumber"><s:property value="nextPageStart"/></s:param>
			    		<s:param name="filterValue"><s:property value="goldId"/></s:param>
					</s:url>
		           	<a type="submit" id="nextID" href="<s:property value="#getNextLEURL"/>" class="btn btn-success left">Next 100&#62;</a>
		           	</c:if>
		           	<img alt="Loading..." id="next100LEIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
		        </div>
          		<div class="span right">
			       	<div class="pagenavi left">
			       		
			       	</div>
			    	<div class="span2bb jump-page">page: <input type="text" class="span1 manual">
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