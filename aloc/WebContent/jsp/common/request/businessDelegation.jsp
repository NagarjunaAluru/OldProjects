<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:set name="isEditMode" value="editMode"/>

	  <s:if test="%{#isEditMode==true}">	
				<p class="required-fields"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/></p>
				<a name="first"></a>				
				<div class="row">
                <div class="span12">
					<div class="row">
						<div class="span22">
							<div class="form-row">
								<p><s:text name="label.request.approvalLevelsRequired"/>:</p> 
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40" id="levels"><span id="approvalLevelRequired"><s:property value="requestDetails.delegationApprovers.approvalLevelRequired"/></span></p> 
								<%-- <s:hidden name="requestDetails.delegationApprovers.approvalLevelRequired" id="approvalLevelRequired"/> --%>
								<s:hidden name="requestDetails.buDelegation.requiredApprLevels" id="requiredApprLevels"/>
							</div>
						</div>
					</div>
                </div> <!-- end of block -->
            </div>
                            
			<div class="row">
			        <div class="span12">
				        <div class="form-row">
					        <label><s:text name="label.request.businessApprover"/> (Level <s:property value="requestDetails.delegationApprovers.approverLevels.size+1"/>)</label>
							  <s:select  list="#{}" 
								listKey="ssoId" listValue="firstName" id="selectBuApprovers" name="requestDetails.buDelegation.buApprover.approverSso" theme="aloc">
					 		</s:select>
					    </div>
					    <s:hidden name="requestDetails.buDelegation.buApprover.approverFirstName" id="approverFirstName" value="%{requestDetails.buDelegation.buApprover.approverFirstName}"/> 
					    <s:hidden name="requestDetails.buDelegation.buApprover.approverLastName" id="approverLastName" value="%{requestDetails.buDelegation.buApprover.approverLastName}"/> 
				    </div>
			    </div>                
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.approvalLevelsRequired"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property value="requestDetails.delegationApprovers.approvalLevelRequired" />
						</p>
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.businessApprover"/> (Level <s:property value="requestDetails.delegationApprovers.approverLevels.size+1"/>):</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property value="requestDetails.buDelegation.buApprover.approverFirstName"/> <s:property value="requestDetails.buDelegation.buApprover.approverLastName"/>
						</p>
					</div>
				</div>
			</div>
			<!-- <div class="row" id="approver"> 
				<div class="span5 left">
					<div class="form-row">
						<p id="appfirstName">
						<span style="padding-left: 10px">
							<s:property value="requestDetails.buDelegation.buApprover.approverFirstName"/> <s:property value="requestDetails.buDelegation.buApprover.approverLastName"/>
						</span>
						</p>
					</div>
				</div>
			</div> -->
		
</s:elseif>
