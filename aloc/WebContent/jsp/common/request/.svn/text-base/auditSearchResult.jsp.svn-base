<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/common/tablesorter.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<div class="form-mod" id="auditLogDiv">
		<div id="auditLogPanel">		
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
					<table class="table table-striped table-bordered sortable no-bottom active paginate" id="fullauditTable">
						<thead>
						    <tr class="spantr1" id="column_head">
						        <th colspan="1"><s:text name="label.request.auditLog.tableHeader.1"/><span class="ttip info" data-original-title="<s:text name="label.request.auditLog.tooltip.initiationDate"/>"></span></th>
								<th colspan="1"><s:text name="label.request.auditLog.tableHeader.2"/><span class="ttip info" data-original-title="<s:text name="label.request.auditLog.tooltip.completionDate"/>"></span></th>
								<th colspan="1"><s:text name="label.request.auditLog.tableHeader.3"/></th>
							    <th colspan="1"><s:text name="label.request.auditLog.tableHeader.4"/></th>  
							    <th colspan="1"><s:text name="label.request.auditLog.tableHeader.5"/></th>
							    <th colspan="1"><s:text name="label.request.auditLog.tableHeader.7"/></th>
							    <th colspan="1"><s:text name="label.request.auditLog.tableHeader.8"/></th>
						    </tr>
						</thead>
						<tbody>
						
	            	
	            	<s:if test="%{requestDetails.auditLogs.size>0}">
						<s:iterator value="requestDetails.auditLogs" status="stat">
							<tr class="shown">
								<td><p><s:if test="%{auditCreatedDt==null}">-</s:if><s:else><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></s:else></p></td>
								<td><p><s:if test="%{transactionCompleteDt==null}">-</s:if><s:else><s:date name="transactionCompleteDt" format="dd MMM yyyy HH:mm aa zzz"/></s:else></p></td>
								<td><p><c:if test="${requestDetails.instrumentTypeId eq '5'|| requestDetails.instrumentTypeId eq '6'}"><s:property value="amendmentRiderId"/></c:if>
										<c:if test="${requestDetails.instrumentTypeId eq '1'|| requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '4'}">
										    <s:property value="alocRecordId"/></c:if>
								</p></td>
								<td><p><s:if test="%{fieldName==null}">-</s:if><s:else><s:property value="fieldName"/></s:else></p></td>
							   <td style="word-wrap: break-word;"><p><c:choose>
								       <c:when test="${empty oldValue}">-</c:when>
								       <c:when test="${oldValue eq 'Y'}">Yes</c:when>
								       <c:when test="${oldValue eq 'N'}">No</c:when>
								       <c:otherwise><div style="width: 155px; overflow: auto;"><s:property value="oldValue"/></div></c:otherwise>
								      </c:choose></p></td>
								<td style="word-wrap: break-word;"><p>
								     <c:choose>
								       <c:when test="${empty newValue}">-</c:when>
								       <c:when test="${newValue eq 'Y'}">Yes</c:when>
								       <c:when test="${newValue eq 'N'}">No</c:when>
								       <c:otherwise><div style="width: 155px; overflow: auto;"><s:property value="newValue"/></div></c:otherwise>
								    </c:choose></p></td>
								<td><p><s:if test="%{authorFirstName==null}">-</s:if><s:else><s:property value="authorLastName"/>,<s:property value="authorFirstName"/></s:else></p></td>
							</tr> 
						</s:iterator>
					</s:if>
					<s:else>
	            		<tr class="shown noRecord">
	            			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.request.auditLogDesc"/> <s:property value="requestDetails.alocRecordId"/> </td>
	            		</tr>
						
				   </s:else>
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
  </div>	
  
  <script>
  $('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	$('.ttip.chart').tooltip();
	$("table.sortable").tablesorter();
  </script>