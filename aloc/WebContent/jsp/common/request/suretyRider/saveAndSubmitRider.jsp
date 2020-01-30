<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<c:set var="isTreasury" value="N"/>
<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
	<c:set var="isTreasury" value="Y"/>
</hwfs:checkComponentPermission>
<input type="hidden" name="actionType" id="actionTypeId">
<s:url action="cancel.action" namespace="/int/requestor"
	var="cancelBtnlURL" />
	<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
<div class="row">
	<div class="span12">
		<nav>
			<ul>
				<c:if test="${requestDetails.instrumentTypeId eq 5}">
					<li id="li24" class="navLi"><a class="navLink" href="#tab24"
						id="nav-submitAmendment">
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
			        		<s:text name="label.amendment.submitRequest" />
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
			        		<s:text name="label.amendment.reSubmitAmendment"/>
			        	</c:if>
						</a></li>
					<li id="li25" class="navLi"><a class="navLink" href="#tab25"
						id="nav-saveasDraftAmend">
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
			        		<s:text name="label.amendment.saveDraft" />
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
			        		<s:text name="label.request.common.save" />
			        	</c:if>
						</a></li>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq 6}">
					<li id="li22" class="navLi"><a class="navLink" href="#tab24"
						id="nav-submitRider">
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
			        		<s:text name="label.request.submitRider" />
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
			        		<s:text name="label.request.reSubmitRider"/>
			        	</c:if>						
						</a></li>
					<li id="li23" class="navLi"><a class="navLink" href="#tab25"
						id="nav-saveasDraft">
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
			        		<s:text name="label.request.saveAsDraft" />
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
			        		<s:text name="label.request.common.save" />
			        	</c:if>
						</a></li>
				</c:if>
				<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.common.cancel" /></a></li>
			</ul>
		</nav>
		<div class="tab" id="tab24"
			style="padding: 10px; background: #fff; border: Solid 3px #ccd7e5;">
			<div class="row approversErrorDiv" style="display: none;">
            		<div class="span11">
               		 <div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="approversError"></p>
               					</div>
               		</div>
           	 		</div>
       			</div>	
			<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
					  <h2 class="summary">
								<s:text name="label.request.businessDelegation" />
							</h2><hr class="h2-hr">
					  <c:if test="${isTreasury =='Y'}">
					  	<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
	 					  	<div class="row">
								<div class="radio-container span5" id="ins">
									<s:radio cssClass="radio"
										name="requestDetails.businessReApprovalFlag" theme="aloc" id="arBusinessApprovalFlag" 
										list="#{'Y':'With business approval','N':'Without business approval'}"  
										 />
								</div>
							</div>
						</c:if>
					 </c:if>
					 
					<c:if test="${isTreasury =='Y'}">
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
							<c:set var="arBusinessDelegationClass" value="hide"/>
						</c:if>
						<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
						<c:choose>
							<c:when test="${requestDetails.sendbackbyBuApprover eq 'Y' or requestDetails.businessReApprovalFlag ne 'N'}">
								<c:set var="arBusinessDelegationClass" value="show"/>
							</c:when>
							<c:otherwise>
								<c:set var="arBusinessDelegationClass" value="hide"/>
							</c:otherwise>
						</c:choose>
						</c:if>
       					
 					</c:if>
 					<c:if test="${isTreasury =='N'}">
 						<c:if test="${requestDetails.sendbackbyBuApprover eq 'Y' or requestDetails.businessReApprovalFlag ne 'N'}">
	       					<c:set var="arBusinessDelegationClass" value="show"/>
	       					<s:hidden name="requestDetails.businessReApprovalFlag" value="Y" />
       					</c:if>
 					</c:if>
 					
						<div id="tab2DelegationID" class="${arBusinessDelegationClass}">
							
							<div class="row lastrow">
								<div class="span4">
									<div class="row lastrow">
										<div class="span1ab">
											<div class="right">
												<label><s:text
														name="label.request.approveLevelsRequired" />:</label>
											</div>
										</div>
										<div class="span1" id="showLevelsId">
											<s:property
												value="requestDetails.delegationApprovers.approvalLevelRequired" />
										</div>
									</div>
									<s:hidden name="selectedApproverSso"
										value="%{requestDetails.buDelegation.buApprover.approverSso}"
										id="selectedApproverSso" />
									<div class="row lastrow">
										<div class="span1ab">
											<div class="form-row">
												<div class="right">
													<label><s:text name="label.request.businessApprover" /> (Level <span class="approveLevelID"></span>):</label>
												</div>

											</div>
										</div>
										<div class="span4">
											<div class="form-row">
												<s:select list="#{}" listKey="ssoId" listValue="firstName"
													id="selectBuApprovers"
													name="requestDetails.buDelegation.buApprover.approverSso"
													theme="aloc" />

												<img alt="Loading..." id="submitProcess"
													src="${pageContext.request.contextPath}/img/loading.gif"
													style="display: none; height: 20px; width: 20px;">
											</div>
											<s:hidden
												name="requestDetails.buDelegation.buApprover.approverFirstName"
												id="approverFirstName"
												value="%{requestDetails.buDelegation.buApprover.approverFirstName}" />
											<s:hidden
												name="requestDetails.buDelegation.buApprover.approverLastName"
												id="approverLastName"
												value="%{requestDetails.buDelegation.buApprover.approverLastName}" />
											<s:hidden
												name="requestDetails.buDelegation.buApprover.approverLevel"
												id="approverLevel"
												value="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId}" />
											 <s:hidden name="requestDetails.buDelegation.buApprover.groupName" id="groupName" />
										</div>
									</div>
									<!-- end of block -->
								</div>
							</div>
						</div>
						
						<br> 
						<c:if test="${workFlowStage ne 'REQEST' and workFlowStage ne 'BUSAPROV' and workFlowStage ne 'REQUEST'}">
			        		<s:submit key="label.request.Submit" cssClass="btn" onclick="submitAction(2)" />
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
			        		<s:submit key="label.request.Submit" cssClass="btn" onclick="submitAction(32)" />
			        	</c:if>
							<a class="nav-hide" href="#"><s:text name="label.request.common.cancel" /></a>
					</div>
				</div>
			</div>
		</div>


	</div>
</div>



