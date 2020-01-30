<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<script	type="text/javascript">
$(document).ready(function() {
	treasuryBidSort();
});
</script>

<div id="searchSort">
   	<div class="leftColSort">
       	<p id="itemsPerPage">
       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
			<a class="btn-secondary tBPResetDefaultOrdering" href="javascript:;"><s:text name="label.dashboard.resetDefaultOrdering"/></a>       	    
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

<table id="tableBidProcessT" class="table table-striped sortable table-bordered paginate">
	<thead>
		<tr id="column_head">
	        
	        <th><s:text name="label.dashboard.tableHeader.bidReceived"/></th>
	        <th style="word-wrap: break-word; width: 65px;"><s:text name="label.dashboard.tableHeader.state"/>
	            <span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.state"/>"></span></th>
	        <th><s:text name="label.dashboard.tableHeader.alocRecordNo"/></th>
	        <th><s:text name="label.dashboard.tableHeader.instrumentType"/></th>
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
	        <th><s:text name="label.dashboard.tableHeader.beneficiaryObligee"/></th>
	        <th><s:text name="label.dashboard.tableHeader.countryOfIssuance"/></th>
	    </tr>
	</thead>
        <tbody>
        	<s:if test="%{searchResult.treasuryBidProcess == null || searchResult.treasuryBidProcess.bidProcess.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="12" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="searchResult.treasuryBidProcess.bidProcess" status="stat">
              	<tr class="shown" >
                <td style="width: 60px;" id="${cc:getRowId(instrumentTypeId, instrumentPurposeId, bondTypeId, subBondTypeId)}">
                	<div class="down" id="arrow"></div>
                	<c:if test="${empty bidReceived}">-</c:if>
                	<c:if test="${not empty bidReceived}"><c:out value="${bidReceived}"/></c:if><br />
                	<img alt="Loading..." class="dashboardExpandViewProcess indicator" src="${pageContext.request.contextPath}/img/loading.gif">
                </td>
                <td>
                	<c:out value="${state}"/>
                </td>
                <td>
                	<s:form name="treasuryBidBankForm" id="treasuryBidBankFormID" action="openRequest" namespace="/int">
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
	                	<s:submit cssClass="submitLink" value="%{alocRecordId}" action="openRequest" namespace="/int" />
                    </s:form>
                </td>
                <td>
                	<c:out value="${instrumentType}"/>
                </td>
                <td>
                	<c:if test="${empty currencyCd}">-</c:if>
                	<c:if test="${not empty currencyCd}"><c:out value="${currencyCd}"/></c:if>
                </td>
                <td><c:if test="${empty amt}">-</c:if>
                	<c:if test="${not empty amt}"><s:property value="amt"/></c:if>
                </td>
                <td>
                	<c:if test="${sessionScope.isIndustrialBusiness}">
					<c:choose>
                		<c:when test="${not empty applicantOrPrincipal}">
                			<c:out value="${applicantOrPrincipal}"/>
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
	                		<c:when test="${not empty applicantOrPrincipal}">
	                			<c:out value="${applicantOrPrincipal}"/>
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
                	<c:if test="${empty beneficiaryOrObligee}">-</c:if>
                	<c:if test="${not empty beneficiaryOrObligee}"><c:out value="${beneficiaryOrObligee}"/></c:if>
                </td>			
                <td>
                	<c:if test="${empty countryOfIssuance}">-</c:if>
                	<c:if test="${not empty countryOfIssuance}"><c:out value="${countryOfIssuance}"/></c:if>
				</td>
            </tr>          
        </s:iterator>
        </s:else>
    </tbody>
</table>
	
	<!-- WINNER POPUP WINDOW -->
		<div class="modal hide fade" id="selectWinner">
		<s:form id="bidProcessWinnerForm" action="selectWinnerForBidAward" namespace="/int/approver">
				<div class="modal-header">
					<a class="close" data-dismiss="modal">X</a>
					<h3><s:text name="label.dashboard.modal.header.selectedWinner"/> <span></span></h3>
				</div>
				<div class="modal-body">
					<jsp:include page="selectWinnerFromBidProcess.jsp" />
				</div>
				<div class="modal-footer">					
	        		<s:submit key="label.dashboard.modal.body.selectAsWin" onclick="return submitAction(13)"cssClass="left btn-primary"/>
					<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.dashboard.bundle.cancel"/></a>
					<input type="hidden" name= "actionType" id="actionTypeId" />
				</div>
		 </s:form>
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