<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
 <h3><s:text name="label.request.treasuryDelegation"/></h3>
 <hr class="hr3">
	<div class="row lastrow">
		<div class="span4" id="budelegationShowDivId">
			<div class="row lastrow">
				<div class="span1ab"><div class="right"><label><s:text name="label.request.approveLevelsRequired"/>:</label></div></div>
				<div class="span1" id="showLevelsId"><s:property value="requestDetails.delegationApprovers.approvalLevelRequired" /></div>
			</div>
				<s:hidden name="selectedApproverSso" value="%{requestDetails.tresuryDelegation.approverSso}" id="selectedApproverSso" />
				<div class="row lastrow">
				    <div class="span1ab">
					    <div class="form-row">
						    <div class="right"><label><s:text name="label.request.treasuryApproverLevel" /> (Level <span class="approveLevelID"></span>):</label></div>
                            
					    </div>
				    </div>
					<div class="span4">
					    <div class="form-row">
						    <s:select  list="#{}" 
									listKey="ssoId" listValue="firstName" id="selectBuApprovers" name="requestDetails.tresuryDelegation.approverSso" theme="aloc">
						 		</s:select>
                            <img alt="Loading..." id="submitProcess"
													src="${pageContext.request.contextPath}/img/loading.gif"
													style="display: none; height: 20px; width: 20px;"> 
					    </div>
					    <s:hidden name="requestDetails.tresuryDelegation.approverFirstName" id="approverFirstName" value="%{requestDetails.tresuryDelegation.approverFirstName}"/> 
						<s:hidden name="requestDetails.tresuryDelegation.approverLastName" id="approverLastName" value="%{requestDetails.tresuryDelegation.approverLastName}"/> 
				    	 <s:hidden name="requestDetails.tresuryDelegation.approverLevel" id="approverLevel" value="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId}"/> 
				    	<s:hidden name="requestDetails.tresuryDelegation.groupName" id="groupName"/>
				    </div>
			    </div> <!-- end of block -->
		</div>
		<div class="span4 hide" id="noMatchingDelegation">
			<span style="color: red;"><s:text name="warning.delegation.noMatching"/></span>
		</div>
		<div class="span7bu right">
			<s:iterator value="requestDetails.delegationApprovers.approverLevels">
				<div class="row lastrow">
					<div class="span2ta"><label><s:text name="label.request.approvedByTL"/> <s:property value="levelId" />:</label></div>
					<div class="span5ta left"><s:property value="lastName" />, <s:property value="firstName" /> - <s:text name="label.request.sso"/> <s:property value="ssoId"/> - <s:date name="approvedDate" format="MMM dd, yyyy - HH:mm aa zzz"/></div>
				</div>
			</s:iterator> 
			
		</div>
		<div class="span5 hide" id="lastApproverSubmit">
			<span><s:text name="alert.delegation.finalApprover"/></span>
		</div>
		
	</div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
