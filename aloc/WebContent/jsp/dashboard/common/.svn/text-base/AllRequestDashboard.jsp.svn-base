<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<c:set var="isTreasury" value="N"/>
<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
	<c:set var="isTreasury" value="Y"/>
</hwfs:checkComponentPermission>	
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
<table id="allRequests" class="table table-striped sortable table-bordered paginate">
	<colgroup width="30"></colgroup>
	<thead>
		<tr id="column_head">
	        <th><s:text name="label.dashboard.tableHeader.dateReceived"/></th>
	        <th><s:text name="label.dashboard.tableHeader.alocRecordNo"/></th>
	        <th><s:text name="label.dashboard.tableHeader.instrumentType"/></th>
	        <th><s:text name="label.dashboard.tableHeader.currency"/></th>
	        <th><s:text name="label.dashboard.tableHeader.amount"/></th>
	        <th style="word-wrap: break-word; width: 65px;">
	        	<s:text name="label.dashboard.tableHeader.state"/>
	        	<span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.state"/>"></span>
	        </th>
		    <th><s:text name="label.dashboard.tableHeader.pendingActionBy"/></th>
	        <th>
	        	<c:if test="${sessionScope.isIndustrialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.applicantPrincipal"/><br />
	        	</c:if>
	        	<c:if test="${sessionScope.isFinancialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.triPartyApplicant"/>
	        	</c:if>
	        	<c:if test="${not sessionScope.isIndustrialBusiness and not sessionScope.isFinancialBusiness}">
	        		<s:text name="label.dashboard.tableHeader.applicantPrincipalTriparty"></s:text>
	        	</c:if>
	        </th>
	        <th><s:text name="label.dashboard.tableHeader.beneObligee"/></th>
	    </tr>
	</thead>
        <tbody>
        	<s:if test="%{results == null || results.allRequests == null || results.allRequests.dashBoards.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="results.allRequests.dashBoards" status="stat">
        	<tr class="shown" >
                	<td style="width: 100px;" id="${cc:getRowId(instrumentID, instrumentPurposeId, bondTypeId, subBondTypeId)}"> 
	                	<div class="down" id="arrow"></div><s:date name="dateReceived" format="dd MMM yyyy HH:mm zzz"/><br />
	                	<img style="margin-left: 0px; margin-top: -10px;" alt="Loading..." class="dashboardExpandViewProcess indicator" src="${pageContext.request.contextPath}/img/loading.gif">
	                </td>
                <td>
                	<s:form name="allRequestForm" id="allRequestFormID" action="openRequest" namespace="/int">
	                	<input type="hidden" name="requestId" value="${ALOCRecordNumber}" class="requestId">
                		<input type="hidden" name="dashboardViewType" value="${dashboardViewType}" class="dashboardViewType">
                		<input type="hidden" name="stage" value="${WFDetails.WFStageID}" class="stage">
                		<input type="hidden" name="instrumentId" value="${instrumentID}" class="instrumentId">
                		<input type="hidden" name="wfid" value="${WFDetails.WFID}" class="wfid">
	                	<input type="hidden" name="queueName" value="${WFDetails.queueName}" class="queueName">
	                	<input type="hidden" name="procedureName" value="${WFDetails.procedureName}" class="procedureName">
	                	<input type="hidden" name="stageName" value="${WFDetails.WFStage}" class="stageName">
	        			<c:if test="${instrumentID eq 5}">
	        				<input type="hidden" name="amendmentId" value="${amendmentId}" class="amendmentId">
                		</c:if>
                		<c:if test="${instrumentID eq 6}">
                			<input type="hidden" name="amendmentId" value="${riderId}" class="riderId">
                		</c:if>
	                	<c:if test="${instrumentID eq 5}">
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
                <td>
                	<c:out value="${instrumentType}"/>
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
                <td style="word-wrap: break-word; width: 65px;">
                <a href="javascript:;" id="popBtn<s:property value="#stat.count" />" class="popBtn"><c:out value="${state}"/></a>
                <div id="popBox<s:property value="#stat.count" />" class="hide popBox">
                	<a href="#" class="right popupClose">X</a>
                </div>
                </td>
			    	<td style="word-wrap: break-word;">
			        	<c:if test="${empty pendingActionBy}">-</c:if>
			            <c:if test="${not empty pendingActionBy}"><div style="width: 75px; overflow: auto;"><c:out value="${pendingActionBy}" /></div></c:if>
			        </td>
                <td>
					<c:if test="${sessionScope.isIndustrialBusiness}">
						<c:choose>
	                		<c:when test="${not empty applicantName}">
	                			<c:out value="${applicantName}"/>
	                		</c:when>
	                		<c:when test="${not empty principalName}">
	                			<c:out value="${principalName}"/>
	                		</c:when>
	                		<c:otherwise>
	                			-
	                		</c:otherwise>
	                	</c:choose>
	                	<br />
                	</c:if>
                	<c:if test="${sessionScope.isFinancialBusiness}">
                		<c:if test="${not empty triPartyApplicantName}">
                			<c:out value="${triPartyApplicantName}"/>
                		</c:if>
                		<c:if test="${empty triPartyApplicantName}">
                			-
                		</c:if>
                	</c:if>
                	<c:if test="${not sessionScope.isIndustrialBusiness and not sessionScope.isFinancialBusiness}">
                		<c:choose>
	                		<c:when test="${not empty applicantName}">
	                			<c:out value="${applicantName}"/>
	                		</c:when>
	                		<c:when test="${not empty principalName}">
	                			<c:out value="${principalName}"/>
	                		</c:when>
	                		<c:otherwise>
	                			-
	                		</c:otherwise>
	                	</c:choose>
	                	<br />
	                	<c:if test="${not empty triPartyApplicantName}">
                			<c:out value="${triPartyApplicantName}"/>
                		</c:if>
                		<c:if test="${empty triPartyApplicantName}">
                			-
                		</c:if>
                	</c:if>
				</td>
                
                <td>
                	<c:choose>
                		<c:when test="${not empty beneficiaryNAme}">
                			<c:out value="${beneficiaryNAme}"/>
                		</c:when>
                		<c:when test="${not empty obligeeName}">
                			<c:out value="${obligeeName}"/>
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
	 <!-- Link Transactions POPUP WINDOW -->
	<div class="modal hide fade" id="linkTransaction">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.dashboard.link.linkedTransactions"/><span></span></h3>
			</div>
			<div class="modal-body">
			<jsp:include page="requestForLinkTransaction.jsp" />
			</div>
	</div>
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
