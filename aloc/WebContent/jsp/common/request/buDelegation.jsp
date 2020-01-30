<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<c:set var="isTreasury" value="N"/>
<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
	<c:set var="isTreasury" value="Y"/>
</hwfs:checkComponentPermission>

 <h3><s:text name="label.request.businessDelegation"/></h3> 
 <c:if test="${isTreasury =='Y'}">
	 <c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST' and  workFlowStage ne 'REREQUEST'}">
		 <div class="row">
				<div class="radio-container span5" id="ins">
					<s:radio cssClass="radio"
						name="requestDetails.businessReApprovalFlag" theme="aloc" id="tBusinessApprovalFlag" 
						list="#{'Y':'With business approval','N':'Without business approval'}"  
						 />
				</div>
		</div>
	</c:if>
</c:if>

<c:if test="${isTreasury =='Y'}">
        <c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST' and  workFlowStage ne 'REREQUEST'}">
	   	  	<c:set var="businessDelegationClass" value="hide"/>
		</c:if>
		<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST' or  workFlowStage eq 'REREQUEST'}">
			<c:choose>
				<c:when test="${requestDetails.sendbackbyBuApprover eq 'Y' or requestDetails.businessReApprovalFlag ne 'N'}">
					<c:set var="businessDelegationClass" value="show"/>
				</c:when>
				<c:otherwise>
					<c:set var="businessDelegationClass" value="hide"/>
				</c:otherwise>
			</c:choose>
 	   </c:if>
</c:if>
 <c:if test="${isTreasury =='N'}">
       <c:set var="businessDelegationClass" value="show"/>
       <s:hidden name="requestDetails.businessReApprovalFlag" value="Y" />
 </c:if>
 
<div class="${businessDelegationClass}" id="businessDelegationDiv">
	<div class="row lastrow">
		<div class="span4" id="budelegationShowDivId">
			<div class="row lastrow">
				<div class="span1ab"><div class="right"><label><s:text name="label.request.approveLevelsRequired"/>:</label></div></div>
				<div class="span1" id="showLevelsId"><s:property value="requestDetails.delegationApprovers.approvalLevelRequired"/></div>
			</div>
			 <s:hidden name="selBusinessApprovalFlag" value="%{requestDetails.businessReApprovalFlag}" id="selectedApproverFlag" />
			 <s:hidden name="selectedApproverSso" value="%{requestDetails.buDelegation.buApprover.approverSso}" id="selectedApproverSso" />
			
				<div class="row lastrow">
				    <div class="span1ab">
					    <div class="form-row">
						    <div class="right"><label><s:text name="label.request.businessApprover"/> (Level <span class="approveLevelID"></span>):</label></div>
                            
					    </div>
				    </div>
					<div class="span4">
					    <div class="form-row">
						    <s:select  list="#{}" 
									listKey="ssoId" listValue="firstName" id="selectBuApprovers" name="requestDetails.buDelegation.buApprover.approverSso" theme="aloc">
						 		</s:select> 
						 		<img alt="Loading..." id="submitProcess"
													src="${pageContext.request.contextPath}/img/loading.gif"
													style="display: none; height: 20px; width: 20px;">                           
					    </div>
					   <s:hidden name="requestDetails.buDelegation.buApprover.approverFirstName" id="approverFirstName" value="%{requestDetails.buDelegation.buApprover.approverFirstName}"/> 
						    <s:hidden name="requestDetails.buDelegation.buApprover.approverLastName" id="approverLastName" value="%{requestDetails.buDelegation.buApprover.approverLastName}"/>
						    <s:hidden name="requestDetails.buDelegation.buApprover.approverLevel" id="approverLevel" value="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId}"/> 
						    <s:hidden name="requestDetails.buDelegation.buApprover.groupName" id="groupName" />
				    </div>
			    </div> <!-- end of block -->
		</div>
		<div class="span4 hide" id="noMatchingDelegation">
			<span style="color: red;"><s:text name="warning.delegation.noMatching"/></span>
		</div>
		<div class="span7bu">
			<s:iterator value="requestDetails.delegationApprovers.approverLevels">
				<div class="row lastrow">
					<div class="span2"><label><s:text name="label.request.approvedByBL"/> <s:property value="levelId" />:</label></div>
					<div class="span5bu left"><s:property value="lastName" />, <s:property value="firstName" /> - <s:text name="label.request.sso"/> <s:property value="ssoId"/> - <s:date name="approvedDate" format="MMM dd, yyyy - HH:mm aa zzz"/></div>
				</div>
			</s:iterator> 
		</div>
		<div class="span5 hide" id="lastApproverSubmit">
			<span><s:text name="alert.delegation.finalApprover"/></span>
		</div>
	</div>
</div>
