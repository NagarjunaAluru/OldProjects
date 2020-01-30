<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
<div class="row smallrow">
<div class="span12">
	<nav> 
	    <ul>
	        <li id="li1" class="navLi"><a href="#tab1" class="navLink" id="nav-approve" onclick="getApprovers()"><s:text name="label.request.Approve"/></a></li>
	        
	        	<li id="li2" class="navLi">
		        	<a href="#tab2" class="navLink" id="nav-reject">
			        	<c:if test="${workFlowStage eq 'TREAPROV'}">
			        		<s:text name="label.request.returnTreasuryAnalyst"/>
			        	</c:if>
			        	<c:if test="${workFlowStage eq 'BUSAPROV'}">
			        		<s:text name="label.request.Reject"/>
			        	</c:if>
		        	</a>
		        </li>
	        <li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text	name="label.request.exitRequest" /></a></li>	
	    </ul>
	</nav>
	<div class="tab" id="tab1" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
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
		<c:if test="${workFlowStage eq 'BUSAPROV'}">	
        	<jsp:include page="/jsp/common/request/buDelegation.jsp" />	
        </c:if>
        <c:if test="${workFlowStage eq 'TREAPROV'}">
	        	<div class="hide" id="insTransionPlatformDiv">
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
        	<jsp:include page="/jsp/common/request/treasuryDelegation.jsp" />	
        </c:if>
        
        <p class="clear">&nbsp;</p>  
        <s:submit key="label.request.Submit" onclick="submitAction(4)" cssClass="btn-secondary"/>
        <a class="nav-hide btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel"/></a>
	</div>
</div>

<div class="span12">
	<div class="tab" id="tab2" style="padding:10px;	background:#fff; border:Solid 3px #ccd7e5;">
	    <div class="row smallrow">
	        <div class="span11e btn-container">
	            <div class="form-row">
						<s:textarea name="requestDetails.actionDetails.reasonForRejection" onkeypress="return imposeMaxLength(this, 399);"
							key="label.request.reasonToReturn" theme="aloc" cssClass="autosize messageinput" id="declineReason"/>
	                    <div class="clear"></div>
	                    <div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
	                    <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/></p></div>
	                    
	                    <p class="clear">&nbsp;</p>  
	                    <s:submit key="label.request.Submit" onclick="submitAction(5)" cssClass="btn"/>
	                    <a class="nav-hide" href="#tab5"><s:text name="label.request.common.cancel"/></a>
	            </div>
	        </div>
	    </div>
	</div>
</div>

</div>