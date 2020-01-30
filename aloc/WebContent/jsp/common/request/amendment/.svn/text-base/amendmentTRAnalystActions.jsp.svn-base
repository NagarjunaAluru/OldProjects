<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>

<div class="row">
	<div class="span12">
		<nav> 
	    	<ul>
	    		<li id="li1" class="navLi"><a href="#tab1" class="navLink" id="nav-ta-amdapprove">Approve</a></li>
	    		<li id="li2" class="navLi"><a href="#tab2" class="navLink" id="nav-ta-amdreturnToBusiness">Return to business</a></li>
	    		<li id="li3" class="navLi"><a href="#tab3" class="navLink" id="nav-ta-amdsave">Save  </a></li>
	    		<li id="li4" class="navLi"><a href="#tab4" class="navLink" id="nav-ta-amddeleteAmendment">Delete amendment</a></li>
	    		<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.exitRequest"/></a>  </li>
	    	</ul>
	    </nav>
	    <div class="tab" id="tab1" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
	    	<div class=" row approversErrorDiv" style="display: none;">
            		<div class="span11">
               		 <div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="approversError"></p>
               					</div>
               		</div>
           	 		</div>
       			</div>	
	    	<div class="hide" id="infoTransmissionDiv">
		    	<h2 class="summary">Information Transmission Platform</h2><hr class="h2-hr">
				<p>Select the method by which the above transaction will be sent to the issuing bank.  </p>
				<p><b>NOTE</b>: The choice you make for this transaction will not determine how you will send future transmissions.</p>
				<div class="radio-container">
				 <c:if test="${requestDetails.amendment.infoTransPlatFormSelection eq 'ALOC'}" >
						<s:radio theme="aloc" cssClass="radio"
							name="requestDetails.amendment.infoTransPlatFormSelection"
							list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}"
							value="%{requestDetails.amendment.infoTransPlatFormSelection}"
							disabled="true" />
						<s:hidden name="requestDetails.amendment.infoTransPlatFormSelection" value="%{requestDetails.amendment.infoTransPlatFormSelection}" id="infoTransPlatFormSelection"/>
	            </c:if>
	             <c:if test="${requestDetails.amendment.infoTransPlatFormSelection eq 'SWIFT'}">
						<s:radio theme="aloc" cssClass="radio"
							name="requestDetails.amendment.infoTransPlatFormSelection"
							list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}"
							value="%{requestDetails.amendment.infoTransPlatFormSelection}" />
					</c:if> 
				</div>
			</div>
			<div class="hide" id="amdtreasuryDelegationDiv">
	    	<h2 class="summary"><s:text name="label.request.treasuryDelegation"/></h2><hr class="h2-hr">
				<div class="row lastrow">
					<div class="span4">
						<div class="row lastrow">
							<div class="span1ab"><div class="right"><label><s:text name="label.request.approveLevelsRequired"/>:</label></div></div>
							<div class="span1"  id="showLevelsId"><s:property value="requestDetails.delegationApprovers.approvalLevelRequired" /></div>
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
									 		<img alt="Loading..." id="submitProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
								    </div>
								    <s:hidden name="requestDetails.tresuryDelegation.approverFirstName" id="approverFirstName" value="%{requestDetails.tresuryDelegation.approverFirstName}"/> 
									<s:hidden name="requestDetails.tresuryDelegation.approverLastName" id="approverLastName" value="%{requestDetails.tresuryDelegation.approverLastName}"/> 
							    	<s:hidden name="requestDetails.tresuryDelegation.approverLevel" id="approverLevel" value="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId}"/> 
							    	<s:hidden name="requestDetails.tresuryDelegation.groupName" id="groupName"/>
							    </div>
						    </div> <!-- end of block -->
					</div>
				</div>
			</div>
				<br>
			<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
						<s:submit key="label.request.Submit" onclick="submitAction(4)" cssClass="btn" /> 
						<a class="nav-hide" href="#tab5"><s:text name="label.request.common.cancel" /></a>
					</div>
				</div>
			</div>
	    </div>
	    <div class="tab" id="tab2" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
	    	<div class="row smallrow">
		    	<div class="span12">
			    	<div class="radio-container" id="ins">
						<s:radio cssClass="radio"
								name="requestDetails.businessReApprovalFlag" theme="aloc" id="businessReApprovalFlag" 
								list="#{'Y':'With business re-approval','N':'Without business re-approval'}" 
								value="%{requestDetails.businessReApprovalFlag}" />
					</div>
				</div>
			</div>
			<div class="row">
		        <div class="span12">
		            <div class="form-row">
						<label><s:text name="label.request.reasonToReturn"/></label>
						<s:textarea name="requestDetails.actionDetails.reasonForRejection" onkeypress="return imposeMaxLength(this, 399);"
						theme="aloc" cssClass="autosize messageinput" id="declineReason"/>
	                    <div class="clear"></div>
	                    <div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
	                    <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/></p></div>
		            </div>
		        </div>
		    </div>
        	<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
						<s:submit key="label.request.common.sendBack" onclick="submitAction(3)" cssClass="btn" />
						<a class="nav-hide" href="#tab5"><s:text name="label.request.common.cancel" /></a>
					</div>
				</div>
			</div>
	    </div>
	    
	</div>
</div>	

		