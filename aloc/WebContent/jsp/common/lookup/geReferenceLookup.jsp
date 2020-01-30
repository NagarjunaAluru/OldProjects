<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<div class="form-mod">
	<s:set name="noOfRecps" value="geRecipientDetailList.size"/>
	<h1 class="page-title span12">GE Recipient Lookup Results - <s:property value="%{#noOfRecps}"/></h1>
	<p class="span12 left clear dashdesc">
	You search for: <s:property value="geRecipient"/>
	<s:hidden value="%{#parameters['scrollTopValue']}" id="scrollTopValueId" name="scrollTopValue"/>
	</p>
	<hr class="page-title-hr">
	<div class="clear"></div>
	<!-- If No Records Found from MDM when lookup from create request page. -->
	<s:if test="%{#noOfRecps == 0}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding:5px;">No results found. Try a different Search.</p>
		</div>
	</div>
	</s:if>
	<div class="row" style="margin-bottom: 0px!important;">
		<div class="span5">
			<div class="">
				<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p style="margin-bottom:5px;">GE Recipient</p>
				<s:textfield name="geRecipient" cssClass="span3 lookup-filterValue" id="geRecipient" />
				<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
				<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false">
				</s:url>
				<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>" ><s:text name="label.request.common.lookup"/></a>
				<img alt="Loading..." id="recipientIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none">			
				<br />
				<p class="guidance">Search using partial last name, first name or SSO</p>
				<span class="lookup-error hide" style="color: #AE2C2C;"></span>
			</div>
		</div>
	</div>
	<s:if test="#noOfRecps > 0">
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
		<table class="table table-striped table-bordered sortable no-bottom paginate lookupTableRes">
               <thead>
                   <tr>
                    <th colspan="1" width="50px"></th>
                    <th colspan="1" width="100px">Recipient Name</th>
                    <th>SSOID</th>
                    <th>Email</th>
                </tr>
               </thead>
               <tbody>
               	<s:iterator value="geRecipientDetailList" status="stat">
                <tr class="shown">
	                <td><input type="button" class="btn-secondary selectRecipient" id="selectRecipient<s:property value="#stat.index" />" value="Select">
					</td>
					<td><p><s:property value="lastName"/>, <s:property value="firstName"/></p></td>
					<td><s:property value="SSOID"/></td>
					<td><s:property value="emailAddress"/></td>
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
		