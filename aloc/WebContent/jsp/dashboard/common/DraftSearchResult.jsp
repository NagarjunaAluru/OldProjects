<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<script	type="text/javascript">
$(document).ready(function() {
	draftSort();
});
</script>

<div id="searchSort">
   	<div class="leftColSort">
       	<p id="itemsPerPage">
       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
			<a class="btn-secondary resetDefaultOrdering" href="javascript:;"><s:text name="label.dashboard.resetDefaultOrdering"/></a>       	    
       	</p>
       	<p id="noItemsFound">
   			0 items found
		</p>
    </div>
    <div class="rightColSort">
         	Show&nbsp;&nbsp;
		<select class="pagination-rows">
		<option>10</option>
		<option>20</option>
		<option>30</option>
		<option>40</option>
		<option>50</option>
		</select>&nbsp;&nbsp;results
    </div>
	<div class="clear"></div>
</div>
<table id="tableDrafts" class="table table-striped table-bordered sortable paginate">
	<colgroup width="30"></colgroup>
	<thead>
	     <tr id="column_head" style="display: table-row;">
	         <th><s:text name="label.dashboard.tableHeader.lastActionDate"/></th>
	       	 <th><s:text name="label.dashboard.tableHeader.alocRecordNo"/></th>
	       	 <th><s:text name="label.dashboard.tableHeader.instrumentType"/></th>
	       	 <th><s:text name="label.dashboard.tableHeader.designatedForBundling"/></th> 
	       	 <th><s:text name="label.dashboard.tableHeader.currency"/></th>
	         <th><s:text name="label.dashboard.tableHeader.amount"/></th>
	         <th>
	         	<c:if test="${sessionScope.isIndustrialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.applicantPrincipal"/><br />
	        	</c:if>
	        	<c:if test="${sessionScope.isFinancialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.triPartyApplicant"></s:text>
	        	</c:if>
	        	<c:if test="${not sessionScope.isIndustrialBusiness and not sessionScope.isFinancialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.applicantPrincipalTriparty"></s:text>
	        	</c:if>
	         </th>
	         <th><s:text name="label.dashboard.tableHeader.beneObligee"/></th> 
	     </tr>
	</thead>
        <tbody>
        	<s:if test="%{searchResult.drafts == null || searchResult.drafts.dashBoards.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="searchResult.drafts.dashBoards">
        	
        	<tr class="shown" >
                <td style="width: 100px;" id="${cc:getRowId(instrumentID, instrumentPurposeId, bondTypeId, subBondTypeId)}">
                	<div class="down" id="arrow"></div><s:date name="lastActionDt" format="dd MMM yyyy HH:mm zzz"/><br />
                	<img style="margin-left: 0px; margin-top: -10px;" alt="Loading..." class="dashboardExpandViewProcess indicator" src="${pageContext.request.contextPath}/img/loading.gif">
                </td>
                <td>
                	<s:form name="draftRequestForm" id="draftRequestFormID" action="openRequest" namespace="/int">
	                	<input type="hidden" name="requestId" value="${ALOCRecordNumber}" class="requestId">
                		<input type="hidden" name="dashboardViewType" value="${dashboardViewType}" class="dashboardViewType">
                		<input type="hidden" name="stage" value="${WFDetails.WFStageID}" class="stage">
                		<input type="hidden" name="instrumentId" value="${instrumentID}" class="instrumentId">
                		<input type="hidden" name="wfid" value="${WFDetails.WFID}" class="wfid">
	                	<input type="hidden" name="queueName" value="${WFDetails.queueName}" class="queueName">
	                	<input type="hidden" name="procedureName" value="${WFDetails.procedureName}" class="procedureName">
	                	<input type="hidden" name="stageName" value="${WFDetails.WFStage}" class="stageName">
	        			<input type="hidden" name="designatedForBundling" value="${designatedForBundling}" class="designatedForBundling">
	        			<c:if test="${instrumentID eq 5}">
	        				<input type="hidden" name="amendmentId" value="${amendmentId}" class="amendmentId">
                		</c:if>
                		<c:if test="${instrumentID eq 6}">
                			<input type="hidden" name="amendmentId" value="${riderId}" class="riderId">
                		</c:if>	                	<c:if test="${instrumentID eq 5}">
	                		<s:submit cssClass="submitLink" value="%{amendmentId}" action="openRequest" namespace="/int" />                			
	                	</c:if>
	                	<c:if test="${instrumentID eq 6}">
	                		<s:submit cssClass="submitLink" value="%{riderId}" action="openRequest" namespace="/int" />
	                	</c:if>
	                	<c:if test="${instrumentID ne 5 and instrumentID ne 6}">
	                		<s:submit cssClass="submitLink" value="%{alocRecordId}" action="openRequest" namespace="/int" />
	                	</c:if>
               		 </s:form>
                </td>
                <td><s:property value="instrumentType"/></td>
                <td>
                   <c:choose>
                		<c:when test="${designatedForBundling == 'Y'}">
                			<s:text name="label.advanceSearch.yes" />
                		</c:when>
                		<c:when test="${designatedForBundling == 'N'}">
                			<s:text name="label.advanceSearch.no" />
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                	<c:if test="${empty currencyCd}">-</c:if>
                	<c:if test="${not empty currencyCd}"><s:property value="currencyCd"/></c:if>
                </td>
                	
                <td>
                	<c:choose>
                		<c:when test="${instrumentID ne 5 and instrumentID ne 6}">
                			<c:if test="${empty instrumentAmt}">-</c:if>
                			<c:if test="${not empty instrumentAmt}"><s:property value="instrumentAmt"/></c:if>
                		</c:when>
                		<c:when test="${instrumentID eq 5 or instrumentID eq 6}">
                			<c:choose>
                				<c:when test="${empty incDecAmt}">-</c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'N'}">-</c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'I'}"><s:property value="instrumentAmt"/></c:when>
                				<c:when test="${not empty incDecAmt and incDecAmt == 'D'}">(<s:property value="instrumentAmt"/>)</c:when>
                			</c:choose>
                		</c:when>
                	</c:choose>
                </td>
                <td>
					<c:if test="${sessionScope.isIndustrialBusiness}">
					<c:choose>
                		<c:when test="${not empty applicantName}">
                			<s:property value="applicantName"/>
                		</c:when>
                		<c:when test="${not empty principalName}">
                			<s:property value="principalName"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                	<br />
                	</c:if>
                	<c:if test="${sessionScope.isFinancialBusiness}">
                		<c:if test="${not empty triPartyApplicantName}">
                			<s:property value="triPartyApplicantName"/>
                		</c:if>
                		<c:if test="${empty triPartyApplicantName}">
                			-
                		</c:if>
                	</c:if>
                	<c:if test="${not sessionScope.isIndustrialBusiness and not sessionScope.isFinancialBusiness}">
                		<c:choose>
	                		<c:when test="${not empty applicantName}">
	                			<s:property value="applicantName"/>
	                		</c:when>
	                		<c:when test="${not empty principalName}">
	                			<s:property value="principalName"/>
	                		</c:when>
	                		<c:otherwise>
	                			-
	                		</c:otherwise>
	                	</c:choose>
	                	<br />
	                	<c:if test="${not empty triPartyApplicantName}">
                			<s:property value="triPartyApplicantName"/>
                		</c:if>
                		<c:if test="${empty triPartyApplicantName}">
                			-
                		</c:if>
                	</c:if>
				</td>
				
				<td>
                	<c:choose>
                		<c:when test="${not empty beneficiaryNAme}">
                			<s:property value="beneficiaryNAme"/>
                		</c:when>
                		<c:when test="${not empty obligeeName}">
                			<s:property value="obligeeName"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                </td>	
            </tr>
        </s:iterator>
        </s:else>
    </tbody>
</table>
<div class="clear"></div>
<div id="searchSort">
   	<div class="leftColSort">
		<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
		<p id="noItemsFound1">
    		0 items found
		</p>
	</div>
</div>
<div style="height:10px;"></div>
