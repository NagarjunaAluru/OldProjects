<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/ext/public/js/common/tablesorter.min.js" type="text/javascript"></script>
<div class="form-mod" id="transactionHistoryLogDiv">

	<s:set name="noOfTransactionLog" value="requestDetails.actionLogs.size"/>
	<div id="transactionHistoryLogPanel">
	<div class="row">
		<div class="span12">
		    <div id="searchSort">
						    <div class="leftColSort" style="width: 150px;">
								 <p id="itemsPerPage">
								       Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results
								 </p>
								 <p id="noItemsFound">
								    0 items found
								 </p>     	
							</div>
							<div class="rightColSort" style="width: 150px;">
								         	Show&nbsp;&nbsp;
										<select class="pagination-rows">
										<option selected="selected">10</option>
										<option>20</option>
										<option>30</option>
										<option>40</option>
										<option>50</option>
										</select>&nbsp;&nbsp;results
						 </div>
						<div class="clear"></div>
					</div>
			<table class="table table-striped table-bordered sortable no-bottom active paginate" id="fullTransactionTable">
				<thead>
					  <tr id="column_head">
						<th colspan="1"><s:text name="label.request.transactionHistoryLog.tableHeader.1"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.2"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.3"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.4"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.7"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.6"/></th>
					</tr>
				</thead>
	            <tbody>
	            	<s:if test="%{#noOfTransactionLog == 0}">
	            		<tr class="shown noRecord">
	            			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.request.noTransactionHistoryDetails" /> </td>
	            		</tr>
	            	</s:if>
	            	<s:if test="%{#noOfTransactionLog > 0}">
		            	<s:iterator value="requestDetails.actionLogs" status="rowStatus">
			            	<tr class="shown">
			                	<td><p><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></p></td>
								<td><p><s:property value="stageName"/></p></td>
								<td><p><s:property value="actionName"/></p></td>
								<td style="word-wrap: break-word;"><p><c:if test="${empty reasonForRejection}">-</c:if><c:if test="${not empty reasonForRejection}"><div style="width: 155px; overflow: auto;"><s:property value="reasonForRejection"/></div></c:if></p></td>
								<td style="word-wrap: break-word;"><p><c:if test="${empty comments}">-</c:if><c:if test="${not empty comments}"><div style="width: 155px; overflow: auto;"><s:property value="comments"/></div></c:if></p></td>
								<td><p><s:property value="approverLastName"/>, <s:property value="approverFirstName"/></p></td>
							</tr> 
						</s:iterator>
					 
					</s:if>
				</tbody>
			</table>
			 <div class="row">
					<div class="span12">
						<c:choose>
		                	<c:when test="${not empty taxonomyViewType}">
		                		<p class="left"><a class="closeFullScreen" href="#"><s:text name="label.request.auditLog.return"/></a></p>
		                	</c:when>
		                	<c:otherwise>
		                		<p class="left"><a class="closeFullScreen" href="#"><s:text name="label.request.auditLog.return"/></a></p>
		                	</c:otherwise>
                		</c:choose>
					</div>
	       </div>
		</div>
	</div>
	  
	</div>
</div>

<div class="clear"></div>
	<div style="height:50px;"></div>
	<div class="row" id="hideLessthan10">
	<!-- pagination pagination-right -->
	<div class="span right">
		   <div class="pagenavi left"></div>
		   <div class="span3 jump-page">Jump to<input type="text" class="span1 manual">
		       <a class="btn btn-success-blue" type="submit">Go</a>
		  </div>
	</div>
</div> 								
<input type='hidden' id='current_page' />
<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>  
<script>
	$("table.sortable").tablesorter();
</script>	  