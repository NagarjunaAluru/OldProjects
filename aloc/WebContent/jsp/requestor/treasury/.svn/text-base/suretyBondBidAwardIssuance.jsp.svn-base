<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.bidAwardSurety"/></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/bidAward.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
</head>
<body>
  
<div class="container main">
	<%@include file="../../common/headerSection.jsp"%>
	  <div id="mainPage">
	  <h1 class="page-title span12"><s:text name="label.request.bidAwardSurety"/></h1>
	  <p class="span12 left clear dashdesc"><s:text name="label.request.treasuryBidAwardLine"/></p>
	  <hr class="page-title-hr">
	  <div class="clear"></div>
	   <s:hidden name="errorShow" id="errorShowId"/>
	   <div class="row hide" id="awardPageLevelErrorDivId">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:fielderror/>
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
		</div>	
			<c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>	
			</c:if>
	  <div class="form-mod">
		<div class="row graybg lastrow" style="margin-left: -10px;">
			<div class="span12">
				<div class="leftColRS">
	        	<h1><font color="black"><s:text name="label.request.replyDetails" /></font></h1>
	           </div>
				<div class="clear"></div>
				<div class="row">
					<div class="span12 whitebg">
						<div class="span4" style="margin-left: 10px!important;">
							<div class="marginT">
								<label><s:text name="label.request.suretyReplying"/></label>
								<div style="word-wrap: break-word;"><p><s:property value="requestDetails.feesDetails.surityName"/></p></div>
								<p><s:property value="requestDetails.bankContactLname"/>,<s:property value="requestDetails.bankContactFname"/></p>
							</div>
						</div> 
						<div class="span4">
								<div class="marginT">
									<label><s:text name="label.request.ALOCReferenceNumber" /></label>
									<p><s:property value="requestDetails.alocRecordId"/></p>
								</div>
					   </div>
					   <div class="span3 right">
								<div class="marginT">
									<div class="row">
										<div class="span3">
											<label><s:text name="label.request.validityDateAndTime" /></label>
											<p><s:property value="requestDetails.bidReplyDetails.bidExpirationDate"/></p>
											<p><s:property value="hours"/>:<s:property value="minutes"/>&nbsp;<s:property value="period"/>&nbsp; EST </p>
										</div>
									</div>
								</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			   <c:if test="${requestDetails.actionDetails.reasonForOptingOut != null && requestDetails.actionDetails.reasonForOptingOut!=''}">      
					<div class="row">
					     <div class="span12 whitebg">
					          	<div class="span4" style="margin-left: 10px!important;">
									<div class="marginT">
									     <label><s:text name="label.request.commentOrOptOut"/></label>
									     <p><s:property value="requestDetails.actionDetails.reasonForOptingOut"/></p>
									</div>
								</div>
						 </div> 
					</div>
				</c:if>
				<div class="row lastrow">	 
					<div class="span4" style="margin-left: 10px!important;">
								<div class="marginT">  </div>
					</div> 
					   <div class="span2">
								<label ><s:text name="label.request.bondType"/>:</label>
				      </div>
				       <div class="span2">
								 <s:property value="requestDetails.bondDetails.bondType"/>
				      </div>
			   </div> 
			  
			   <div class="row">	 
					<div class="span4" style="margin-left: 10px!important;">
								<div class="marginT">  </div>
					</div> 
					   <div class="span2">
								<label><s:text name="label.request.bondSubtype"/>:</label>
				      </div>
				       <div class="span3">
								 <s:property value="requestDetails.bondDetails.bondSubType"/>
				      </div>
			   </div> 
				
		</div>			
			</div>
		</div>
	</div><!-- end of form form-mod -->
	
	  <div class="clear"></div>
      <div class="form-mod">
				<h2 id="bidReply" class="section_flip"><a href="javascript:;"><s:text name="label.request.bidReplyDetailSection"/></a></h2><hr class="h2-hr">
				<div id="bidReplyPanel" class="section_panel">
						<jsp:include page="suretyBondBidAwardIssuanceSection.jsp">
							<jsp:param name="sectionId"  value="request.section.fees" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>							
				</div>
		 </div>
	
	  <div class="clear"></div>
      <div class="form-mod">
				<h2 id="principal" class="section_flip"><a href="javascript:;"><s:text name="label.request.sbSectionPrincipal"/>
			   </a></h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel">
						<jsp:include page="suretyBondBidAwardIssuanceSection.jsp">
							<jsp:param name="sectionId"  value="request.section.principal" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
		 </div>
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="obligee" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionObligee"/> </a>
				</h2><hr class="h2-hr">
				<div id="obligeePanel" class="section_panel">
						<jsp:include page="suretyBondBidAwardIssuanceSection.jsp">
							<jsp:param name="sectionId"  value="request.section.obligee" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
		  </div>	
		  
		  <div class="clear"></div>		
		  <div class="form-mod" id="projectDescDiv">
   		  <h2 id="projectDescription" class="section_flip">
			   <a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		 </h2><hr class="h2-hr">
		 <div id="projectDescriptionPanel" class="section_panel">
		     <div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.ProjectDescription"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40" style="word-wrap:break-word;"><s:property value="requestDetails.bondInfo.exactProjDesc"/></p>
					</div>
				</div>
			</div> 
		 
		</div>

		  
	       <div class="clear"></div>
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.sbSectionBondDetails"/>
					</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel">

						<jsp:include page="suretyBondBidAwardIssuanceSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
			</div>
			
	 <s:form id="awardSubmitForm" action="awardSubmit">	
	 	 <div class="row smallrow">
       <div class="span12">
  		   <h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
  		   <hr class="page-title-hr">
           <label><s:text name="label.request.commentsOptional" /></label>
				<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
					cssClass="autosize messageinput" id="tdcomments" required="false"/>
           <div class="clear"></div>
           <div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
           <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
       </div>
   </div>      
	 	
		  <input type="hidden" name= "actionType" id="actionTypeId" value="${actionType}" />
		   <div class="clear"></div>	
			<!-- Include Submit Section -->
		 <div id="submitDiv">
				<jsp:include page="/jsp/common/request/awardSubmit.jsp" />
		</div>
	 <!-- WINNER POPUP WINDOW -->
	<div class="modal hide fade" id="selectWinner">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.dashboard.modal.header.selectedWinner"/> <span></span></h3>
			</div>
			<div class="modal-body">
			<jsp:include page="/jsp/common/requestsForBidProcessModal.jsp" />
			</div>
			<div class="modal-footer">
				<s:submit key="label.dashboard.modal.body.selectAsWin" onclick="submitAction(13)"cssClass="left btn-primary"/>    
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.dashboard.bundle.cancel"/></a>
			</div>
	</div>
	<s:hidden name="requestId" value="%{requestId}"> </s:hidden>
		<s:hidden name="bidReplyId" value="%{bidReplyId}"> </s:hidden>
		<s:hidden name="stageName" value="%{requestDetails.WFDetails.WFStage}"> </s:hidden>
		<s:hidden name="wfid" value="%{requestDetails.WFDetails.WFID}"> </s:hidden>
		<s:hidden name="queueName" value="%{requestDetails.WFDetails.queueName}"> </s:hidden>
		<s:hidden name="procedureName" value="%{requestDetails.WFDetails.procedureName}"> </s:hidden>
		<s:hidden name="workFlowstageId" value="%{requestDetails.WFDetails.WFStageID}"> </s:hidden>
		<s:hidden name="selBidWinnerType" value="fromRequest"> </s:hidden>
</s:form>
</div>
  
	</div>

 <%@include file="../../common/footerSection.jsp"%>	
	<!-- EXIT REQUEST POPUP WINDOW -->
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</form>
		</div>
		<div class="modal-footer">
		    <s:url id="readysystemCancel" action="cancel" />
			<s:a href="%{readysystemCancel}" key="label.request.continue" cssClass="btn left">
						<s:text name="label.request.continue"></s:text>
			</s:a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>
		</div>
</div> 




	
</body>
</html>