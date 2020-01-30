<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
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
<table id="tableBankHistoricalTrans" class="table table-striped sortable table-bordered paginate">
	<colgroup width="30"></colgroup>
	<thead>
		<tr id="column_head">
	        <th><s:text name="label.dashboard.tableHeader.issuanceDate"/></th>
	        <c:choose>
        		<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			 <th><s:text name="label.dashboard.tableHeader.bankReferenceNumber"/></th>
        		</c:when>
        		<c:otherwise>
        			<th><s:text name="label.dashboard.tableHeader.suretyReferenceNumber"/></th>
        		</c:otherwise>
        	</c:choose>	
	        <th><s:text name="label.dashboard.tableHeader.alocRecordNo"/></th>
	          <c:choose>
        		<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			<th><s:text name="label.dashboard.tableHeader.instrumentType"/></th>
        		</c:when>
        		<c:otherwise>
        			<th><s:text name="label.dashboard.tableHeader.bondAndSubType"/></th>
        		</c:otherwise>
        	</c:choose>	 
	        <th><s:text name="label.dashboard.tableHeader.currency"/></th>
	        <th><s:text name="label.dashboard.tableHeader.amount"/></th>
	        <th><s:text name="label.dashboard.tableHeader.state"/><span class="ttip info" data-original-title="This is an tooltip with more information"></span></th>
	        <c:choose>
        		<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			 <th><s:text name="label.dashboard.tableHeader.beneficiaryName"/></th>
        		</c:when>
        		<c:otherwise>
        			<th><s:text name="label.dashboard.tableHeader.obligeeName"/></th>
        		</c:otherwise>
        	</c:choose>	
	    </tr>
	</thead>
        <tbody>
        	<s:if test="%{results.histroricalTransactions == null || results.histroricalTransactions.dashBoards.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="results.histroricalTransactions.dashBoards" status="stat">
                	
        	<tr class="shown">
                <td id="${cc:getRowId(instrumentID, instrumentPurposeId, bondTypeId, subBondTypeId)}" style="width: 100px;">
                	<div class="down" id="arrow"></div><c:if test="${empty issuanceDate}">-</c:if>
        			<c:if test="${not empty issuanceDate}"><s:date name="issuanceDate" format="dd MMM yyyy"/></c:if>
                	<img alt="Loading..." class="dashboardExpandViewProcess" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" style="display:none;height: 20px;width: 20px; margin-left: 0px; margin-top: -10px;">
                </td>
                <td>
                 <c:choose>
        			<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        				 <c:if test="${empty bankRefNumber}">-</c:if>
	                	 <c:if test="${not empty bankRefNumber}"><c:out value="${bankRefNumber}"/></c:if>
        			</c:when>
        			<c:otherwise>
        				 <c:if test="${empty suretyRefNum}">-</c:if>
	                	 <c:if test="${not empty suretyRefNum}"><c:out value="${suretyRefNum}"/></c:if>
        			</c:otherwise>
        			</c:choose>
                </td>
                <td>
                	<s:form name="bankHistoricalTransForm" id="bankHistoricalTransFormID" action="openRequest" namespace="/ext">
	                	<input type="hidden" name="requestId" value="${ALOCRecordNumber}" class="requestId">
                		<input type="hidden" name="dashboardViewType" value="ALLREQUESTS" class="dashboardViewType">
                		<input type="hidden" name="stage" value="${WFDetails.WFStageID}" class="stage">
                		<input type="hidden" name="instrumentId" value="${instrumentID}" class="instrumentId">
                		<input type="hidden" name="wfid" value="${WFDetails.WFID}" class="wfid">
	                	<input type="hidden" name="queueName" value="${WFDetails.queueName}" class="queueName">
	                	<input type="hidden" name="procedureName" value="${WFDetails.procedureName}" class="procedureName">
	                	<input type="hidden" name="stageName" value="${WFDetails.WFStage}" class="stageName">
	                	<input type="hidden" name="state" value="${state}" class="state">
	        			<c:if test="${instrumentID eq 5}">
	        				<input type="hidden" name="amendmentId" value="${amendmentId}" class="amendmentId">
                		</c:if>
                		<c:if test="${instrumentID eq 6}">
                			<input type="hidden" name="amendmentId" value="${riderId}" class="riderId">
                		</c:if>	                	
	                	<c:if test="${instrumentID eq 5}">
	                		<s:submit cssClass="submitLink" value="%{amendmentId}" action="openRequest" namespace="/ext" />              			
	                	</c:if>
	                	<c:if test="${instrumentID eq 6}">
	                		<s:submit cssClass="submitLink" value="%{riderId}" action="openRequest" namespace="/ext" /> 
	                	</c:if>
	                	<c:if test="${instrumentID ne 5 and instrumentID ne 6}">
	                		<s:submit cssClass="submitLink" value="%{alocRecordId}" action="openRequest" namespace="/ext" />
	                	</c:if>
                	</s:form>
                </td>
                <td>
	                <c:choose>
		        		<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
	                			<c:if test="${empty instrumentType}">-</c:if>
	                			<c:if test="${not empty instrumentType}"><c:out value="${instrumentType}"/></c:if>
		        		</c:when>
		        		<c:otherwise>
		        			<c:if test="${empty bondType}">-</c:if>
                			<c:if test="${not empty bondType}"><c:out value="${bondType}"/></c:if><br>
                			<c:if test="${empty bondSubType}">-</c:if>
                			<c:if test="${not empty bondSubType}"><c:out value="${bondSubType}"/></c:if>
		        		</c:otherwise>
	        		</c:choose>	
        		</td>
                <td>
                	<c:if test="${empty currencyCd}">-</c:if>
                	<c:if test="${not empty currencyCd}"><c:out value="${currencyCd}"/></c:if>
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
                <td style="width: 65px;">
                	<c:if test="${empty state}">-</c:if>
                	<c:if test="${not empty state}"><c:out value="${state}"/></c:if>
                </td>
                <td>
                	<c:choose>
        			<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        				 <c:if test="${empty beneficiaryNAme}">-</c:if>
	                	 <c:if test="${not empty beneficiaryNAme}"><c:out value="${beneficiaryNAme}"/></c:if>
        			</c:when>
        			<c:otherwise>
        				 <c:if test="${empty obligeeName}">-</c:if>
	                	 <c:if test="${not empty obligeeName}"><c:out value="${obligeeName}"/></c:if>
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
