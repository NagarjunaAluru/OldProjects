<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.reimbursementAgreementManagement.title" /></title>
<%@include file="../common/includeCommonScripts.jsp" %>	
	<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script>
</head>
<body> 
	<div class="container main" id="reimbursementAgreemenMgmtDivId">
			<jsp:include page="../common/headerSection.jsp">
				<jsp:param name="createReqPopup" value="Yes"></jsp:param>
			</jsp:include>		
		<h1 class="page-title span12"><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementManagement" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.reimbursementAgreementManagement.optionalShortGrammaticallyCorrectSupportingSentence" /></p>	
		<hr class="page-title-hr">
		<div class="form-mod">
										
	     <div class="row">
	      <div class="span12">	    
	      <span class="required-fields-para2" style="margin-top: 15px!important;"><s:text name="label.standardFormatMgmt.allFieldsRequiredUnlessSpecified" /></span>   	      
		   	<s:form id="reimbursementAgreementMgmtFormId" namespace="/int/admin" action="createOrUpdateAgreement"> 
		   	<%--<s:hidden  name="reimbursementAgreementName" value="%{reimbursement.reimbursementAgreement.reimbursementAgreementName}" />	 --%>	
		   	 <s:hidden id="reimbursementValidationId"  name="errorMessageData" value="%{errorMessageData}" />
		   	 <s:hidden id="includePageId"  name="includePageId" value="%{includeNoPage}" />		
		   	 <s:hidden id="previousConditionId"  name="previousCondition" value="%{addOrEditSelection}" />	    	 				  	  		   	
           		<div class="form-mod" id="reimbursementId">
           			
					<h2 id="reimbursementAgreementMgt" class="section_flip">
						<a href="javascript:;"><s:text name="label.reimbursementAgreementManagement.iWouldLikeTo" /></a>
					</h2><hr class="h2-hr">					            			
					<div id="reimbursementAgreementMgtPanel">  					       	
		                <div class="row lastrow">
		                    <div class="span12">
								<div class="form-row"> 
											<br>					
										<div class="radio-container">
											 <s:radio id="addcondId" cssClass="radio" name="addOrEditSelection"  list="#{'add':'Add a new reimbursement agreement','edit':'Edit an exisiting reimbursement agreement'}" theme="aloc" />											
								    </div>
								</div>
							</div>
						</div>
					</div>
              </div>
              
      		<!-- Add Section of the Reimbursement Agreement  Starts Here-->
			                    
			<div class="form-mod hide" id="showReimbursement">         
			     <h2 id="addANewReimbusementMgmt" class="section_flip ">
	                  <a href="javascript:;"><s:text name="label.reimbursementAgreementManagement.addANewReimbursementAgreementLabel" /></a>
	             </h2>
	             <h2 id="editANewReimbusementMgmt" class="section_flip">
		            <a href="javascript:;"><s:text name="label.reimbursementAgreementManagement.editAnExisitingReimbursementAgreement" /></a>
		         </h2>
		         <hr class="h2-hr"> 	
		         <div id="includepageDivId">	               	   					       
		             <jsp:include page="/jsp/admin/reimbursementAgreement.jsp" />		       					       		
	       		</div>
	       		  <div class="hide" id="auditlogDiv">  
	       		     <h2 id="auditlog" class="section_flip">
					     <a href="javascript:;"><s:text name="label.request.bglocSectionName.16"/>-<s:property value="%{reimbursement.auditLogs.size}"/></a>
				    </h2><hr class="h2-hr">  
				        <div class="clear"></div>
				   <div>    	   					       
		             <jsp:include page="/jsp/admin/ReimbursementAuditLog.jsp" />	
		            </div> 	       					       		
	       		</div>
	       		<br>
		       	   <div class="clear"></div>
				      <div class="hide highlighted" id="submitBtnDiv">
					    <sj:submit key="label.treasuryAdminPortal.save" cssClass="btn-primary"></sj:submit>	
					    	   	<a class="btn-tertiary cancel" data-toggle="modal" id="#confirmReimbursementAgreement" href="javascript:;" onclick="javascript:popUpReimbursementWindow('<s:property value="%{reimbursement.reimbursementAgreement.reimbursementAgreementName}"/>')">
									<s:text name="label.treasuryAdminPortal.cancel" /></a>									
				  </div><!-- end of form form-mod -->
				    	
	        </div>       
   		 </s:form>  
       </div>        
   </div>
</div>
</div>
	 <div class="clear"></div>
		<div class="modal hide fade" id="reimbursementAgreementModel">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			 <h3><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementManagement"/></h3>		
		</div>
		<div class="modal-body" style="font-size:15px;">
			<s:form id="submitReimbursementMgmtFormId" action="submitReimbursementAgreement" namespace="/int/admin" escapeAmp="false" encode="true" >										
				<%-- <p>
					<s:property default=" "  value="%{siteNamesList}"/>
				<s:textfield cssStyle="border:0px solid red!important;" id="reimbursementAgreementMessage"  name="reimbursementAgreementMessage" value="%{errorMessageData}"/>
				</p>	 --%>
				<s:set var="siteNameSize" value="(siteNamesList.size)-1"/>
				<p>
			 	<s:iterator value="%{siteNamesList}" begin="0" end="#siteNameSize-1">
			 		<s:property/>,
			 		<br>
			 	</s:iterator>
				<s:property value="%{siteNamesList[#siteNameSize]}"/> ]
				</p>
			</s:form>			
		</div>				
		 <div class="clear"></div>
		<div class="modal-footer">	
				<sj:submit formIds="submitReimbursementMgmtFormId" value="Continue With Save"  cssClass="btn left" />				
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.standardFormatMgmt.returnToScreenOptions"/></a>																					                      
		</div>
	</div>

	<div class="modal hide fade" id="confirmReimbursementAgreement" style="width:800px;">	
		<s:hidden id="modalAgreementName" name="agreementName" value="" />		
				<div class="modal-header">
					<a class="close" data-dismiss="modal">X</a>
					<h3><s:text name="label.reimbursementAgreementManagement.confirmMessageLabel1" /></h3>
				</div>
				<div class="modal-bodyCancel" style="padding-left:10px;">					
					<p><s:text name="label.reimbursementAgreementManagement.confirmMessageLabel2" /></p>						
					<br>				
					<p><s:text name="label.reimbursementAgreementManagement.reimbursementAgreementNameLabel"/> : <s:textfield cssStyle="width:200px;border:0px solid red!important;" id="agreementName"  name="agreementName" value=""></s:textfield></p>
					<br>	
					<p ><span class="box3" style="text-decoration:none;color:#666666;"><s:text name="label.reimbursementAgreementManagement.confirmMessageLabel3"/></span></p>
					<br>	
					<a class="btn left" data-dismiss="modal" href="javascript:void(0);" onclick="cancelReimbursementAgreement()">
					<s:text name="label.reimbursementAgreementManagement.confirmMessageLabel4" /></a>								
					<a href="#" class="btn-tertiary cancel" data-dismiss="modal"><s:text name="label.reimbursementAgreementManagement.closeWindow" /></a>				
				</div>
	</div>  		
	</body>	  
   <div id="ReimAgrfooterDiv">
 	<%@include file="../common/footerSection.jsp"%>
 	</div>	
</html>