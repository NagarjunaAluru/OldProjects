<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin/changeRequestOwnership.js" type="text/javascript"></script>

<s:form id="newRequestOwnerForm" action="changeSelectedRequestsOwnership" namespace="/int/admin" >
			<s:if test="%{requestorTransactionList != null && requestorTransactionList.size > 0}">
				<h2><s:text name="label.changeRequestOwnership.step2"/></h2><hr class="h2-hr">
                    <div class="row">
                    <div class="span12">
                    	<br>
                    	<div style="color: red;" id="requestorTransactionValidate">
							<s:fielderror fieldName="requestorTransactionList"></s:fielderror>
            			 </div>
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
			            <table id="selRequestDetailTable" class="table table-striped table-bordered paginate">
					        <thead>
					            <tr>
						            <th colspan="1" width="50px"><s:checkbox name="checkAllRequestsName" id="checkallRequestsId"/></th>
						            <th colspan="1" width="150px"><s:text name="label.changeRequestOwnership.alocRecordNumber"/></th>
						            <th colspan="1" width="150px"><s:text name="label.changeRequestOwnership.businessSite"/></th>
						            <th colspan="2"><s:text name="label.changeRequestOwnership.currentRequestorName"/></th>
					            </tr>
					        </thead>
					        <tbody>
					        <s:iterator value="requestorTransactionList" status="requestorTransItrStatus">	
						        <tr class="shown" >
							        <td>
								        <s:checkbox name="requestorTransactionList[%{#requestorTransItrStatus.index}].selectedRequest" cssClass="checkRequestOwnershipUpdate" theme="aloc"/>
							        </td>
									<td>
								        <s:property value = "ALOCRecordNumber"/>
							        </td>
									<td>
								        <s:property value = "busineesSite"/>
							        </td>
									<td>
								        <s:property value = "requestorTrasactionsReply.currentRequestor.currentRequestorLastName"/>,<s:property value = "requestorTrasactionsReply.currentRequestor.currentRequestorFirstName"/><br>
								        <s:property value = "requestorTrasactionsReply.currentRequestor.currentRequestorSso"/>
							        </td>
							        <td class="hide"><s:textfield name="requestorTransactionList[%{#requestorTransItrStatus.index}].ALOCRecordNumber"/></td>
							        <td class="hide"><s:textfield name="requestorTransactionList[%{#requestorTransItrStatus.index}].ALOCSitePrefix"/></td>
							        <td class="hide"><s:textfield name="requestorTransactionList[%{#requestorTransItrStatus.index}].busineesSite"/></td>
							        <td class="hide"><s:textfield name="requestorTransactionList[%{#requestorTransItrStatus.index}].instrumentTypeId"/></td>
							        <td class="hide"><s:textfield name="requestorTransactionList[%{#requestorTransItrStatus.index}].instrumentTypeName"/></td>
        						</tr>
        					</s:iterator>								
					        </tbody>
				        </table>
				        <s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorLastName" id="currentRequestorLName"></s:hidden>
						<s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorFirstName" id="currentRequestorFName"></s:hidden>
						<s:hidden name="requestorTrasactionsReply.currentRequestor.currentRequestorSso" id="currentRequestorSSO"></s:hidden>
						<s:hidden name="requestorTrasactionsReply.requestorBusinessSite" id="businessSiteId" cssClass="autoCompleterName"></s:hidden>
						<s:hidden name="selBusinessSiteCd" id="businessSiteCodeId" value="%{selBusinessSiteCd}"></s:hidden>				
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
    
				<div class="row">
				<c:if test="${empty requestorTrasactionsReply.changeRequestor.changeRequestorSso}">
					<c:set var="BusinessShowClass" value="display: none;"/>
				</c:if>
				<c:if test="${not empty requestorTrasactionsReply.changeRequestor.changeRequestorSso}">
					<s:set var="personNameSelected" value="%{'Yes'}"></s:set>
					<c:set var="BusinessShowClass" value="display: block;"/>
				</c:if>	
					<div class="span12">
				<h2><s:text name="label.changeRequestOwnership.step3"/></h2><hr class="h2-hr">
	             
			<br>	
			<div class="row">
			<div class="form-row">
				<div class="span3">
					<s:label key="label.changeRequestOwnership.newRequestor"></s:label>
					<s:textfield name="newRequestorName" cssClass="span3 lookup-filterValue" id="newRequestorNameId" theme="aloc" 
					maxlength="50"/>
					<s:text name="label.changeRequestOwnership.lookupComment" />	
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="RequestorDetailsLookup" namespace="/int" var="getRequestorDetailsURL" escapeAmp="false" encode="true">
						<s:param name="requestorType">newRequestor</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getRequestorDetailsURL"/>" ><s:text name="label.request.common.lookup"/></a>
	            </div>
                <div class="span5">
                   	<label>&nbsp;</label>
                   	<img alt="Loading..." id="newRequestorSSOIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
                </div>
	         </div>
		</div>
		
			</div>
		</div>
		
		<div class="conditional-row" id="BusinessShow1" style="${BusinessShowClass}">
			<s:hidden name="personNameSelection" id="personNameSelectionId" value="%{#personNameSelected}" cssClass="requiredField"/>
			<s:hidden id="personNameReqCount" value="%{#personNameSelected}"/>
			<div class="row">
			<div class="span7">
			<div class="row">
				<div class="span1">
								<div class="form-row">
									<s:label key="label.changeRequestOwnership.Name"/>
								</div>
							</div>
							<div class="span5 left">	
								<div class="form-row">
									<p><s:property value="requestorTrasactionsReply.changeRequestor.changeRequestorLastName"/>, <s:property value="requestorTrasactionsReply.changeRequestor.changeRequestorFirstName"/></p>
									<s:hidden name="requestorTrasactionsReply.changeRequestor.changeRequestorLastName" id="newRequestorLName"></s:hidden>
									<s:hidden name="requestorTrasactionsReply.changeRequestor.changeRequestorFirstName" id="newRequestorFName"></s:hidden>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span1">
								<div class="form-row">
									<s:label key="label.changeRequestOwnership.SSO"/>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p><s:property value="requestorTrasactionsReply.changeRequestor.changeRequestorSso"/></p>
									<s:hidden name="requestorTrasactionsReply.changeRequestor.changeRequestorSso" id="newRequestorSSO"></s:hidden>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
					
				<div class="row">
                    <div class="span12">
			            <div class="form-row">
                            <s:submit key="label.changeRequestOwnership.changeRequestor" action="changeSelectedRequestsOwnership" cssClass="btn" />
			            </div>
			        </div> <!-- end of block -->
			    </div>
				</s:if>
				<s:else>
					<h2><s:text name="label.changeRequestOwnership.step2"/></h2><hr class="h2-hr">
					<div class="row">
	                    <div class="span12">
	                        <br>
							<p><s:text name="label.changeRequestOwnership.searchResult1"/></p>
							<p><br /></p>
							<p><s:text name="label.changeRequestOwnership.searchResult2"/></p>
						</div>
					</div>
				</s:else>
				<s:hidden name="errorShow" id="errorShowId"/>
	</s:form>
