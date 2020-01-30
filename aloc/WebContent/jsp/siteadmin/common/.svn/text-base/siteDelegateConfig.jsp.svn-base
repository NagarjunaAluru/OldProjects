<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script type="text/javascript">
		$(document).ready(function() {
			$('.checkboxSelectionDiv label').after('<div class="clear"></div>');
			});
		</script>
	<div id="delDivID">
			<c:if test="${param.includeScripts != false}">
				<script type="text/javascript">
					onloadDelegateConfigRowEach();
					decimalAmountZero();
				</script>
			</c:if>
			<s:hidden value="%{siteAdmin.delegationConfiguration.comments}" id="dlgSuccessMsg"></s:hidden>
			<div class="row form-mod">
            <div class="span12">
            <h3><s:text  name="label.siteAdmin.delegationConfiguration"/></h3>
             <table class="table table-striped table-bordered sortable anotherRow" id="delegationConfigurations">
             		<colgroup width="10px"></colgroup>
                    <colgroup width="170px"></colgroup>
                    <colgroup width="60px"></colgroup>
                    <colgroup width="60px"></colgroup>
                    <colgroup width="60px"></colgroup>
                    <colgroup width="60px"></colgroup>
                    <colgroup width="60px"></colgroup>
                    <colgroup width="60px"></colgroup>  
               
                <thead>
                  <tr>
                  	<th colspan="1" ><s:label  key="label.siteAdmin.action"  cssStyle="color:#FFFFFF;"/></th>
                    <th colspan="1" ><s:label  key="label.siteAdmin.instrument"  cssStyle="color:#FFFFFF;"/></th>
                    <th colspan="1" ><s:label  key="label.siteAdmin.instrumentAmount" cssStyle="color:#FFFFFF;"/></th>
					<th colspan="1" ><s:label  key="label.siteAdmin.notificationClause" cssStyle="color:#FFFFFF;"/></th>
                    <th colspan="1" ><s:label  key="label.siteAdmin.curePeriodIndicator" cssStyle="color:#FFFFFF;"/></th> 
					<th><s:label  key="label.siteAdmin.geApprovalOfDraw" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label  key="label.siteAdmin.approverGroupAssignment" cssStyle="color:#FFFFFF;"/></th>                                                
				  </tr>
                </thead>
                <tbody>
                <s:if test="%{siteDetailsBO.delegationConfigurationBO != null && siteDetailsBO.delegationConfigurationBO.delegationConfigBOList.size>0}">
                <s:iterator value="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList" var="delegationConf" status="delegationConfStat">
                	<s:if test="%{siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[#delegationConfStat.index].model.opCode != 'DELETE'}">
	                	<tr class="delegateConfigRow">
	                		<td>
	                			<s:hidden cssClass="delegationIndex" name="delegationIndex" value="%{#delegationConfStat.index}" />
	                			<s:hidden cssClass="deleteConfig" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].deleted" />
	                			<a href="javascript:void(0);" class="delete-delegationconfig delete-tr-hide" id="deleteDelegation" title="Delete this Delegation">X</a> 
	                		</td>
	                		
	                        <td class="insChktd">
	                        	<s:set var="delegationConfigIndex" value="%{#delegationConfStat.index}" />
	                        	<label class="checkbox"><input type="checkbox" class="instrCheckBox"> </label>All
	                        	<div class="checkboxSelectionDiv">
	                        		<s:checkboxlist name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].instrumentIds" 
	                        		list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeDeleg}" listValue="Name" listKey="ID"
	                        		value="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[#delegationConfigIndex].instrumentIds" cssClass="instr checkBoxAlign"
	                        		/>
	                        	</div>
	                        </td>
	                        
	                         <td id="iA">
	                        	<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].model.instrBaseAmt" maxlength="21" id="instrBaseAmt" cssClass="bigDecimal" cssStyle="width:80px;"/><br>
	                        	<s:text name="label.common.siteAdmin.to" /> <br>
	                        	<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].model.instrEndAmt" maxlength="21" id="instrEndAmt" cssClass="bigDecimal" cssStyle="width:80px;"/>
	                        </td>
	                        
	                        <td>
	                        	<s:radio theme="aloc" cssClass="radio notificationCaluseFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].model.notificationCaluseFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" />
							</td>
							
							<td>
								<s:radio theme="aloc" cssClass="radio curePeriodIndicatorFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].model.curePeriodIndicatorFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" />
							</td>
							
							<td>
								<s:radio theme="aloc" cssClass="radio geAppDrawFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#delegationConfStat.index}].model.GEAppDrawFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" />
							</td>
							
							 <td>
	                            <table border="0" width="100%" cellpadding="6" cellspacing="0">
	                            <colgroup width="50px"></colgroup>
	                            <colgroup width="170px"></colgroup>
	                            	<s:if test="%{siteAdmin.delegationConfiguration.delegationConfigs[#delegationConfStat.index].groupAssignments != null && siteAdmin.delegationConfiguration.delegationConfigs[#delegationConfStat.index].groupAssignments.size>0}">
	                            		<s:hidden cssClass="newGroupLevel" name="newGroupLevel" value="%{siteAdmin.delegationConfiguration.delegationConfigs[#delegationConfStat.index].groupAssignments.size}" />
	                            		<s:iterator value="%{siteAdmin.delegationConfiguration.delegationConfigs[#delegationConfStat.index].groupAssignments}" var="group" status="grNames">
	                            		<s:if test="%{siteAdmin.delegationConfiguration.delegationConfigs[#delegationConfStat.index].groupAssignments[#grNames.index].opCode != 'DELETE'}">
		                            		 <tr class="groupAssignment">
		                            		 	<td height="1" class="noPadding">
		                            		 		<s:text name="label.siteAdmin.level" />&nbsp;<span class="groupLevelDisplayHolder"><s:property value="%{#grNames.index + 1}"/></span>
			                                		<s:hidden cssClass="groupOpcode" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[%{#grNames.index}].opCode" />
			                                		<s:hidden cssClass="groupLevel" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[%{#grNames.index}].groupLevel" />
		                            		 	</td>
		                            		 
		                            		 	<td>
		                            		 		<s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}"
														listKey="groupName" 
														listValue="groupName" 
														id="apprGroupName" 
														name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[%{#grNames.index}].groupName"
														headerKey=""
														headerValue="Select..."
														cssStyle="width:200px!important;"
													/>
		                            		 	</td>
		                            		 	<s:if test="%{#grNames.index > 0}">
		                            		 		<td><a href="javascript:;" class="remove-delegGroup">remove</a></td>
	                            		 		</s:if>
	                            		 		<s:else>
	                            		 			<td>&nbsp;</td>
	                            		 		</s:else>
		                            		 </tr>
		                            	</s:if>
		                            	</s:iterator>
	                            	</s:if>
	                            	
	                            	<s:else>
	                            		<s:hidden cssClass="newGroupLevel" name="newGroupLevel" value="1" />
	                            		<tr class="groupAssignment">
	                            			<td height="1" class="noPadding">
	                            		 		<s:text name="label.siteAdmin.level" />&nbsp;<span class="groupLevelDisplayHolder">1</span>
		                                		<s:hidden cssClass="groupOpcode" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[0].opCode" />
		                                		<s:hidden cssClass="groupLevel" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[0].groupLevel" value="1"/>
	                            		 	</td>
	                            		 	
	                            		 	<td>
	                            		 		<s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}"
													listKey="groupName" 
													listValue="groupName" 
													id="apprGroupName" 
													name="siteAdmin.delegationConfiguration.delegationConfigs[%{#delegationConfStat.index}].groupAssignments[0].groupName"
													headerKey=""
													headerValue="Select..."
													cssStyle="width:200px!important;"
												/>
	                            		 	</td>
	                            		 	<td>&nbsp;</td>
	                            		</tr>
	                            	</s:else>
	                          	</table>
	                            <a href="javascript:;" class="add add-delegationGroup"><s:text name="label.siteAdmin.addApprovalLevel" /></a>
	                        </td>
	                    </tr>
                	</s:if>
                </s:iterator>
                	<s:hidden id="newDelegationIndex" name="newDelegationIndex" value="%{siteDetailsBO.delegationConfigurationBO.delegationConfigBOList.size}" />
                </s:if>
                <s:else> 
                	
                	<tr class="delegateConfigRow">
                		<td>
                			<s:hidden cssClass="delegationIndex" name="delegationIndex" value="0" />
                			<s:hidden cssClass="deleteConfig" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].deleted" />
                			<a href="javascript:void(0);" class="delete-delegationconfig delete-tr-hide" id="deleteDelegation" title="Delete this Delegation">X</a> 
                		</td>
                		
                        <td class="insChktd">
                        	<label class="checkbox"><input type="checkbox" class="instrCheckBox"></label> All
                        	<div class="checkboxSelectionDiv">
                        		<s:checkboxlist name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].instrumentIds" list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeDeleg}" listValue="Name" listKey="ID"  cssClass="instr checkBoxAlign"/>
                        	</div>
                        </td>
                        
                         <td id="iA">
                        	<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].model.instrBaseAmt" id="instrBaseAmt" maxlength="20" cssClass="bigDecimal" cssStyle="width:80px;"/><br>
                        	<s:text name="label.common.siteAdmin.to" /> <br>
                        	<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].model.instrEndAmt" id="instrEndAmt" maxlength="20" cssClass="bigDecimal" cssStyle="width:80px;"/>
                        </td>
                        
                        <td>
                        	<s:radio theme="aloc" cssClass="radio notificationCaluseFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].model.notificationCaluseFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}"
							value="%{notificationCaluseFlag}" />
						</td>
						
						<td>
							<s:radio theme="aloc" cssClass="radio curePeriodIndicatorFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].model.curePeriodIndicatorFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}"
							value="%{curePeriodIndicatorFlag}"/>
						</td>
						
						<td>
							<s:radio theme="aloc" cssClass="radio geAppDrawFlag" name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[0].model.GEAppDrawFlag" list="#{'Yes':'Yes','No':'No','N/A':'N/A'}"
							value="%{geAppDrawFlag}" />
						</td>
						
						 <td>
                            <table border="0" width="100%" cellpadding="6" cellspacing="0" id="approverGroup">
                            <colgroup width="50px"></colgroup>
                            <colgroup width="170px"></colgroup>
                            
                            	<s:hidden cssClass="newGroupLevel" name="newGroupLevel" value="1" />
                                <tr class="groupAssignment">
                                	<td height="1" class="noPadding">
                                		<s:text name="label.siteAdmin.level" />&nbsp;<span class="groupLevelDisplayHolder">1</span>
	                                	<s:hidden cssClass="groupOpcode" name="siteAdmin.delegationConfiguration.delegationConfigs[0].groupAssignments[0].opCode" value="INSERT"/>
	                                	<s:hidden cssClass="groupLevel" name="siteAdmin.delegationConfiguration.delegationConfigs[0].groupAssignments[0].groupLevel" value="1" />
                                	</td>
                                	<td>
                                		<s:if test="%{siteAdmin == null || siteAdmin.delegationConfiguration == null || siteAdmin.delegationConfiguration.approvalGroupConfiguration == null}">
                                			<s:select list="{}"
												id="apprGroupName" 
												name="siteAdmin.delegationConfiguration.delegationConfigs[0].groupAssignments[0].groupName"
												headerKey=""
												headerValue="Select..."
												cssStyle="width:200px!important;"/> 
                                		</s:if>
                                		<s:else>
                                			<s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}"
												listKey="groupName" 
												listValue="groupName" 
												id="apprGroupName" 
												name="siteAdmin.delegationConfiguration.delegationConfigs[0].groupAssignments[0].groupName"
												headerKey=""
												headerValue="Select..."
												cssStyle="width:200px!important;"/> 
                                		</s:else>
                                	</td>
                                	<td>&nbsp;</td>
                                </tr>
                          	</table>
                          	
              				<s:if test="%{siteAdmin != null && siteAdmin.delegationConfiguration != null && siteAdmin.delegationConfiguration.approvalGroupConfiguration != null}">
                            	<a href="javascript:;" class="add add-delegationGroup" id="addApprovalLevel"><s:text name="label.siteAdmin.addApprovalLevel" /></a>
                            </s:if>
                            
                        </td>
                    </tr>
                    <s:hidden id="newDelegationIndex" name="newDelegationIndex" value="1" />
                </s:else>
                 </tbody>
              </table> 
              <s:if test="%{siteAdmin != null && siteAdmin.delegationConfiguration != null && siteAdmin.delegationConfiguration.approvalGroupConfiguration != null}">
              	<a href="javascript:;" class="add add-delegationconfig"><s:text name="label.common.siteAdmin.addAnotherRow" /></a>                  
              </s:if>
            </div>
            </div>
        </div> 
		<s:hidden name="ignoreParentSites" value="%{ignoreParentSites}" cssClass="ignoreParentSites"/>    