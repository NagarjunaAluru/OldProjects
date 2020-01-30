<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<script	type="text/javascript">
$(document).ready(function() {
	bankBidSort();
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

<table id="tableBidProcessB" class="table table-striped sortable table-bordered paginate">
	<colgroup width="30"></colgroup>
	<thead>
		<tr id="column_head">
	        <th><s:text name="label.dashboard.tableHeader.dateReceived"/></th>
	        <th><s:text name="label.dashboard.tableHeader.bidState"/><span class="ttip info" data-original-title="This is an tooltip with more information"></span></th>
	        <th><s:text name="label.dashboard.tableHeader.alocRecordNo"/></th>
	        <c:choose>
        		<c:when test="${dashboardViewType eq 'BANKBIDPROCESS'}">
        			<th><s:text name="label.dashboard.tableHeader.instrumentType"/></th>
        		</c:when>
        		<c:otherwise>
        			<th><s:text name="label.dashboard.tableHeader.bondAndSubType"/></th>
        		</c:otherwise>
        	</c:choose>	        
	        <th><s:text name="label.dashboard.tableHeader.currency"/></th>
	        <th><s:text name="label.dashboard.tableHeader.amount"/></th>
	        <th><s:text name="label.dashboard.tableHeader.expirationDate"/></th>
	        <c:choose>
        		<c:when test="${dashboardViewType eq 'BANKBIDPROCESS'}">
        			 <th><s:text name="label.dashboard.tableHeader.beneficiaryName"/></th>
        		</c:when>
        		<c:otherwise>
        			<th><s:text name="label.dashboard.tableHeader.obligeeName"/></th>
        		</c:otherwise>
        	</c:choose>	  
	    </tr>
	</thead>
        <tbody>
        	<s:if test="%{searchResult.bankBidProcess == null || searchResult.bankBidProcess.bidProcess.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="searchResult.bankBidProcess.bidProcess" status="stat">
               	<tr class="shown">
                <td id="${cc:getRowId(instrumentTypeId, instrumentPurposeId, bondTypeId, subBondTypeId)}" style="width: 100px;">
                	<div class="down" id="arrow"></div><c:if test="${empty dateReceived}">-</c:if>
                	<c:if test="${not empty dateReceived}"><s:date name="dateReceived" format="dd MMM yyyy HH:mm zzz"/></c:if>
                	<img alt="Loading..." class="dashboardExpandViewProcess" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" style="display:none;height: 20px;width: 20px; margin-left: 0px; margin-top: -10px;">
                </td>
                <td>
                	<c:if test="${empty state}">-</c:if>
                	<c:if test="${not empty state}"><c:out value="${state}"/></c:if>
                </td>
                <td>
                	<s:form name="bidBankForm" id="bidBankFormID" action="openRequest" namespace="/ext">
	                	<input type="hidden" name="requestId" value="${requestId}" class="requestId">
                		<input type="hidden" name="dashboardViewType" value="${dashboardViewType}" class="dashboardViewType">
                		<input type="hidden" name="stage" value="${WFDetails.WFStageID}" class="stage">
                		<input type="hidden" name="instrumentId" value="${instrumentTypeId}" class="instrumentId">
                		<input type="hidden" name="wfid" value="${WFDetails.WFID}" class="wfid">
	                	<input type="hidden" name="queueName" value="${WFDetails.queueName}" class="queueName">
	                	<input type="hidden" name="procedureName" value="${WFDetails.procedureName}" class="procedureName">
	                	<input type="hidden" name="stageName" value="${WFDetails.WFStage}" class="stageName">
	                	<input type="hidden" name="bankBidId" value="${bankBidId}" class="bankBidId">
	                	<input type="hidden" name="bidFlag" value="${bidFlag}" class="bidFlag">
	                	<input type="hidden" name="bankName" value="${bankName}" class="bankName">
	                	<input type="hidden" name="bankCountryName" value="${bankCountryName}" class="countryName">
	                	<input type="hidden" name="bidReplyId" value="${bidReplyId}" class="bidReplyId">
	                	<s:submit cssClass="submitLink" value="%{alocRecordId}" action="openRequest" namespace="/ext" />
                	</s:form>
                </td>
                <c:choose>
	        		<c:when test="${dashboardViewType eq 'BANKBIDPROCESS'}">
	        			<td>
                			<c:if test="${empty instrumentType}">-</c:if>
                			<c:if test="${not empty instrumentType}"><c:out value="${instrumentType}"/></c:if>
              			</td>
	        		</c:when>
	        		<c:otherwise>
	        			<td>
	        				<c:if test="${empty bondType}">-</c:if>
                			<c:if test="${not empty bondType}"><c:out value="${bondType}"/></c:if><br>
                			<c:if test="${empty bondSubType}">-</c:if>
                			<c:if test="${not empty bondSubType}"><c:out value="${bondSubType}"/></c:if>
	        			</td>
	        		</c:otherwise>
        		</c:choose>	     
                <td>
                	<c:if test="${empty currencyCd}">-</c:if>
                	<c:if test="${not empty currencyCd}"><c:out value="${currencyCd}"/></c:if>
                </td>
                 <td>
                	<c:if test="${empty amt}">-</c:if>
                	<c:if test="${not empty amt}"><s:property value="amt"/></c:if>
                </td>
                <td style="width: 75px;">
                	<c:if test="${empty expirationDt}">-</c:if>
                	<c:if test="${not empty expirationDt}"><s:property value="expirationDt"/></c:if>
                </td>
                <td style="width: 90px;"><c:out value="${beneficiaryOrObligee}"/></td>               
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
