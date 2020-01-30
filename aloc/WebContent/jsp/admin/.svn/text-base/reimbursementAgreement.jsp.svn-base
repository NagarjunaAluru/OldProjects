<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>

 <% String contextUrl = request.getContextPath();  %>
<script>
	  var contextURL = '<%=contextUrl%>';
</script>
   <div class="reimbusementMgmtPanel">    
     		<div style=color:red;>
					<s:actionmessage/>      				
		   </div>  
			<div id="addAgreementName" class="row">
			                 <div class="span12">
			                     <div class="textareaCounter"></div>
						<div class="form-row">							
							<label><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementName" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.reimbursementAgreementName"/>"></span></label>
							<s:textarea id="reimbursementAgrNameAdd" cssClass="autosize1 messageinput" theme="aloc" name="reimbursement.reimbursementAgreement.reimbursementAgreementName" col="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						    <div class="clear"></div>
			                        <div class="counter">100</div> <!-- fix positions -->
			                        <div class="counterTxt"><p class="guidance"><s:text name="label.reimbursementAgreementManagement.charleft" /></p></div>
							<div class="clear"></div>
						</div>
			        </div>
				</div>				
				<div id="editAgreementName" class="row">
			       <div class="span12">
						<div class="form-row">
					    	<label><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementName" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.reimbursementAgreementName"/>"></span></label> 
						     <s:select id="reimbursementAgreementLNamesId" name="reimbursement.reimbursementAgreement.reimbursementAgreementId" headerKey="-1" headerValue="Select..." listKey="ID" listValue="name" list="%{reimbursementList}" theme="aloc" />
							 <img alt="Loading..." id="reimbursementAgreementProcess0" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							 <span id="reimbursementAgreementErrorId" class="hide standardFormatError"><s:text name="label.agreementManagement.error.agreementName" /></span>							
						</div>
			        </div>
				</div>	
		   <div class="hide" id="editSectionDiv">  															 		
				<div class="row lastrow">
					<div class="span12">
						<div class="row lastrow">
							<div class="span3a">
								<div class="form-row">
									<label><s:text name="label.reimbursementAgreementManagement.isThisAgreementEnabledOrDisabled" />
										<span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.disabledOrEnabledreimbursementAgreement"/>"></span>
									</label>
									<div class="radio-container">
										<s:radio cssClass="radio" id="enableId" name="reimbursement.reimbursementAgreement.agreementEnabledDisabled"  list="#{'Enabled':'Enabled','Disabled':'Disabled'}" theme="aloc" />
									</div>
									<div class="left hide" id="siteMsg"><s:text name="label.reimbursementAgreementManagement.youCanNotDisable" /></div>
								</div>										
							</div>
						</div>
					</div>
				</div>	
				<div class="clear"></div>						
				<h3><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementContentTextFormat" />
				</h3>
				<p class="descriptivetext"><s:text name="label.reimbursementAgreementManagement.cutAndPasteDocumentationToTheAreaBelow" /></p>
				<hr class="hr3"/>				
				<div class="row">
				<div class="span12">
							<div class="form-row">
								<s:textarea            				
					               		id="agreementTextAddId" 
					               		cssClass="mceEditor"
					               		cssStyle="width: 940px; height: 250px;"
					               		name="reimbursement.reimbursementAgreement.agreementText"               							               		
					               		value="%{reimbursement.reimbursementAgreement.agreementText}" theme="aloc"
					               		 />          		                			
								<script >
								registerCommonTinyMCE('10000','agreementTextAddId');		                		
								</script>									
							</div>
						</div>
				</div>
			
				<div class="row lastrow">
					<div class="span12">
							<div class="form-row">
								<label><s:text name="label.reimbursementAgreementManagement.isThisToBeSetUpAsADefaultAgreement" />
	                            <span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.defaultReimbursementAgreement"/>"></span>
	                            </label>
	                            <s:radio cssClass="radio" name="reimbursement.reimbursementAgreement.deafultAgreement"  id="yes" list="#{'true':'Yes'}" theme="aloc" />
	                            <div class="row hide" id="one" style="margin-left:5px;">
									<div class="span12">
										<div class="form-row">
										    <s:radio id="DefaultAgrId"  cssClass="radio" name="reimbursement.reimbursementAgreement.deafultAgreementType" list="#{'Industrial Business':'Industrial','Financial Business':'Financial'}" theme="aloc" />
										</div>
									</div>
								</div>
								<s:radio cssClass="radio" name="reimbursement.reimbursementAgreement.deafultAgreement"  id="no" list="#{'false':'No'}" theme="aloc" />
					            </div>                                       
	                       </div>
					</div>									
				</div>
			</div>			