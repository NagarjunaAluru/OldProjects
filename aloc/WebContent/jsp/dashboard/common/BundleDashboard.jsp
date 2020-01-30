<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<table id="tableBundles" class="table table-striped sortable table-bordered paginate">
	<colgroup width="30"></colgroup>
	<thead>
		<tr id="column_head">
			<th><s:text name="label.dashboard.tableHeader.bundleIDNumber"/></th>
			<th><s:text name="label.dashboard.tableHeader.bundleStatus"/><span class="ttip info" data-original-title='<s:text name="label.request.tooltip.bundleStatus"/>'></span></th>
			<th><s:text name="label.dashboard.tableHeader.beneficiaryName"/></th>
			<th><s:text name="label.dashboard.tableHeader.applicantName"/></th>
			<th><s:text name="label.dashboard.tableHeader.bundleCreationDate"/></th>
			<th><s:text name="label.dashboard.tableHeader.bundleTotalUSD"/></th>
			<th><s:text name="label.dashboard.tableHeader.nunmberOfRequestsInBundle"/></th>
		</tr>
	</thead>
	<tbody>
		<s:if test="%{results.bundle == null || results.bundle.requestDetails.isEmpty()}">
        	<tr class="shown noRecord">
       	 			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    		</tr>
        </s:if>
        <s:else>
        <s:iterator value="results.bundle.requestDetails">
		<tr class="shown">
			<td style="width: 70px;">
				<div class="down" id="arrow"></div><s:if test="%{bundleDetails.bundleId==null}">-</s:if><s:else><c:out value="${bundleDetails.bundleId}"/></s:else>
				<br><img alt="Loading..." class="dashboardExpandViewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
			</td>		
			<td>
				<s:if test="%{bundleDetails.transactionState==null}">-</s:if><s:else><c:out value="${bundleDetails.transactionState}"/></s:else></td>
			<td>
                	<c:choose>
                		<c:when test="${not empty beneficiaryDetails.addressDtls.name}">
                			<c:out value="${beneficiaryDetails.addressDtls.name}"/>
                		</c:when>                	
                		<c:when test="${not empty transactionParties.customer.addressDtls.name}">
                			<c:out value="${transactionParties.customer.addressDtls.name}"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
            </td>              
			<td>
                	<c:choose>
                		<c:when test="${not empty applicantDetails.addressDtls.name}">
                			<c:out value="${applicantDetails.addressDtls.name}"/><br />
                		</c:when>                		
                		<c:when test="${not empty transactionParties.tpApplicantDetails.addressDtls.name}">
                			<c:out value="${transactionParties.tpApplicantDetails.addressDtls.name}"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
            </td>          
			<td><s:if test="%{bundleDetails.bundleCreationDt==null}">-</s:if><s:else><s:property value="bundleDetails.bundleCreationDt"/></s:else></td>
			<td><s:if test="%{instrumentDetails.USDEquivalent==null}">-</s:if><s:else><s:property value="instrumentDetails.USDEquivalent"/></s:else></td>
			<td><s:hidden id="bundleId" name="bundleId" value="%{bundleDetails.bundleId}" cssClass="bundleId"/>
			<s:hidden id="reqCount" name="bundleReqCount" value="%{bundleDetails.reqCount}"/><s:if test="%{bundleDetails.reqCount==null}">-</s:if><s:else><c:out value="${bundleDetails.reqCount}"/></s:else></td>
		</tr>
		</s:iterator>
		</s:else>
	</tbody>
</table>


<!-- REMOVE BUNDLE POPUP WINDOW STARTS HERE -->

	<div class="modal hide fade" id="removeBundle">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.dashboard.bundle.removeRequestFromBundle"/> <span></span></h3>
			</div>
				<s:hidden id="modalHiddenBundleId" name="bundleId" value="" />  
				<s:hidden id="modalHiddenRequestId" name="requestId" value="" /> 
			
			<div class="modal-body">
			
			<p><s:text name="label.dashboard.bundle.bundleSelection"/></p><br/>
            
            <p><s:text name="label.dashboard.bundle.alocRecordNumber"/>&nbsp; <span id="modalRequestId"></span></p>
            
            <p><s:text name="label.dashboard.bundle.bundleIDNumber"/>:&nbsp; <span id="displayBundleId"></span></p><br/>
            
            <h3 class="bundelpopup"><s:text name="label.dashboard.bundle.bundleAction"/></h3>

			
			</div>
			<div class="modal-footer">
			 	<a data-toggle="modal" href="#" onclick="removeRequestFromBundle()" class="left btn-primary"  id="saveSelectionlb">
					<s:text name="label.dashboard.bundle.remove"/>		
				</a>	
				<a href="<s:property value="#bundleDashboardURL" />" class="btn-tertiary left cancel"><s:text name="label.dashboard.bundle.cancel"/></a>						
			</div>	
			
	</div> 
	
	<!-- DELETE BUNDLE POPUP WINDOW STARTS HERE-->
	
	<div class="modal hide fade" id="deleteEntireBundle">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.dashboard.bundle.deleteBundle"/><span></span></h3>
			</div>
			<div class="modal-body" >
			<s:hidden id="modalHiddenBundleId" name="bundleId" value="" />  
			<form>
				<p><s:text name="label.dashboard.bundle.bundleSelection"/> </p><br/>
	            
	            <p><s:text name="label.dashboard.bundle.bundleIDNumber"/>:&nbsp; <span id="deleteBundleId"></span>.</p><br/>	          
	            
	            <h3 class="bundelpopup"><s:text name="label.dashboard.bundle.bundleAction"/></h3>
			</form>
			</div>
			<div class="modal-footer">
			 	<a data-toggle="modal" href="#" onclick="removeBundle();" class="left btn-primary"  id="saveSelectionlb">
					<s:text name="label.dashboard.bundle.delete"/>			
				</a>							
				<a href="<s:property value="#bundleDashboardURL" />" class="btn-tertiary left cancel"><s:text name="label.dashboard.bundle.cancel"/></a>					
			</div>
	</div> 
	
	<!-- SUBMIT BUNDLE POPUP WINDOW STARTS HERE-->
	<div class="modal hide" id="submitBundle" style="left: 450px;">
		<s:hidden id="modalHiddenBundleId" name="bundleId" value="" />
		<s:hidden id="modalHiddenBeneficiaryName" name="beneficiaryName" value="%{beneficiaryName}" />			
			<div class="modal-header" >
				<a class="close" data-dismiss="modal">X</a>
				<h3 class="bundelpopup"><s:text name="label.dashboard.bundle.submitBundle"/> <span id="popupBundleId"></span>
				for <span id="popupBeneficiaryName"></span>  
				</h3>
			</div>			
			<div class="modal-body" >				
				<jsp:include page="requestsForBundleModal.jsp" />
			</div>
			<div class="modal-footer">
				<a data-dismiss="modal" href="#" onclick="submitBundle();" class="left btn-primary"  id="saveSelectionlb">
					<s:text name="label.dashboard.bundle.submitBundle"/>			
				</a>				
				<a data-dismiss="modal" href="<s:property value="#bundleDashboardURL" />" class="btn-tertiary left cancel"><s:text name="label.dashboard.bundle.modifyBundle"/></a>
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
<div style="height: 50px;"></div>
