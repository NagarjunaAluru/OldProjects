<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<input type="hidden" name="actionType" id="actionTypeId" value="${actionType}">
	<div class="row">
		<div class="span12">
			<nav>
				<ul>
					<li class="navLi"><a class="navLink" href="#tab1" id="tr-nav-save"><s:text name="label.request.common.save" /></a></li>
					<li id="li7" class="navLi hide"><a class="navLink" href="#tab2" id="tr-nav-approve" onclick="getApprovers()"><s:text name="label.request.Approve" /></a></li>
					<li id="li8" class="navLi hide"><a class="navLink" href="#tab3" id="tr-nav-sendBack"><s:text name="label.request.common.sendBack" /></a></li>
					<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.exitRequest" /></a></li>
					
				</ul>
			</nav>


			<div class="tab" id="tab2" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
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
				<jsp:include page="/jsp/common/request/treasuryDelegation.jsp" />
				<div class="row">
					<div class="span12 btn-container">
						<div class="form-row">
							<s:submit key="label.request.Submit" onclick="submitAction(4)" cssClass="btn" /> 
							<a class="nav-hide" href="#tab5"><s:text name="label.request.common.cancel" /></a>
						</div>
					</div>
				</div>
			</div>

			<div class="tab" id="tab3" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
				<div class="radio-container" id="ins">
					<s:radio cssClass="radio"
							name="requestDetails.businessReApprovalFlag" theme="aloc" id="businessReApprovalFlag" 
							list="#{'Y':'With business re-approval','N':'Without business re-approval'}" 
							value="%{requestDetails.businessReApprovalFlag}" />
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





