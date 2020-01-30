<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:set name="isEditMode" value="editMode"/>
	 
				<p class="required-fields"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified" /></p>
				<div class="row">
                		<div class="span12">
							<div class="form-row">
								<p><label><s:text name="label.request.approveLevelsRequired" />:<span style="padding-left:30px;" id="levels"><s:property value="requestDetails.delegationApprovers.approvalLevelRequired" /></span></label></p> 
								
							</div>
						</div>
								
					</div>
            	<s:if test="requestDetails.delegationApprovers.approverLevels.size  > 0">
            	 <div class="row">
            		<div class="span12"><label><s:text name="label.request.approved" />:</label></div>
           		 </div>
           		 </s:if>
            <s:iterator value="requestDetails.delegationApprovers.approverLevels">
            <div class="row">
            
                <div class="span12">
					<div class="row">
						<div class="span22">
							<div class="form-row">
								<p><s:text name="label.request.level" /> <s:property value="levelId" />:</p> 
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><s:property value="firstName" /> <s:property value="lastName" /></p> 
							</div>
						</div>
					</div>
                </div> <!-- end of block -->
            </div>            
             </s:iterator>       
            <s:if test="requestDetails.delegationApprovers.delegationGroups[0].groupApprovers.size  > 0">
			<div class="row">
			        <div class="span12">
				        <div class="form-row">
					        <label><s:text name="label.request.businessApprover"/> (Level <s:property value="requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId"/>)</label>
					        
					        <s:select list="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers}"
													listKey="sssoId" 
													listValue="appFirstName" 
													id="selectBuApprovers" 
													name="requestDetails.buDelegation.buApprover.approverSso"
													headerKey=""
													headerValue="Select..."
													theme="aloc"
							/>
												
							<s:hidden name="requestDetails.buDelegation.buApprover.approverLevel"  value="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers[0].approverLevelId}" />
					    </div>
				    </div>
			    </div>  
			   </s:if>              

	