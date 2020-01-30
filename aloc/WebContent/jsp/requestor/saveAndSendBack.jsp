<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="form-mod">
	<div class="row">
		<div class="span12">
			<nav>
				<ul>
        			<li class="navLi"><a class="navLink" href="#tab1" id="tra-nav-save" ><s:text name="label.request.common.save" /></a></li>
        			<c:if test="${not empty requestDetails.winningBankDetails.winnerDetails.winningBankName}">
	        			<li id="li22" class="navLi"><a class="navLink" href="#tab2" id="tra-nav-award">
	        			<c:if test="${requestDetails.instrumentTypeId eq '1' or requestDetails.instrumentTypeId eq '2' or requestDetails.instrumentTypeId eq '4'or requestDetails.instrumentTypeId eq '5'}">
	        				<s:text name="label.request.awardToBankBid" />
	        			</c:if>
	        			<c:if test="${requestDetails.instrumentTypeId eq '3' or requestDetails.instrumentTypeId eq '6'}">
	        				<s:text name="label.request.awardToSurety"/>
	        			</c:if></a></li>
        			</c:if>
        			<c:if test="${requestDetails.winningBankDetails.winnerDetails.winningBankName eq ''}">
        				<li id="li22" class="navLi"><a class="navLink" href="#tab2" id="tra-nav-award">
        				<s:text name="label.request.sendToBidAward"/>
        				</a>
        				</li>
        			</c:if>
        			<li id="li23" class="navLi"><a class="navLink" href="#tab3" id="tra-nav-sendBack"><s:text name="label.request.common.sendBack" /></a></li>
       				<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.exitRequest" /></a></li>	
				</ul>
			</nav>
			<div class="tab" id="tab2" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
				<div class="row">
					<div class="span12 btn-container">
						<div class="form-row">
						<c:if test="${not empty requestDetails.winningBankDetails.winnerDetails.winningBankName}">
							<s:submit key="label.request.Submit" onclick="submitAction(13)" cssClass="btn-primary" /> 
						</c:if>
						<c:if test="${requestDetails.winningBankDetails.winnerDetails.winningBankName eq ''}">
							<s:submit key="label.request.Submit" onclick="submitAction(38)" cssClass="btn-primary" /> 
						</c:if>
							<a class="nav-hide btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel" /></a>
						</div>
					</div>
				</div>
			</div>
			<div class="tab" id="tab3" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
					<c:if test="${requestDetails.instrumentTypeId ne '4'}">
					<div class="row">
					<div class="span11e">
					<div class="radio-container" id="ins">
						<s:radio cssClass="radio"
								name="requestDetails.businessReApprovalFlag" theme="aloc" id="businessReApprovalFlag" 
								list="#{'Y':'With business re-approval','N':'Without business re-approval'}" 
								value="%{requestDetails.businessReApprovalFlag}" />
					</div>
					</div>
					</div>
					</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '5' or requestDetails.instrumentTypeId eq '6'}">
				<div class="row">
					<div class="span11e">
						<div class="form-row">
							<s:textarea	name="requestDetails.actionDetails.reasonForRejection" onkeypress="return imposeMaxLength(this, 399);"
							 key="label.request.reasonToReturn" theme="aloc" cssClass="autosize messageinput" id="declineReason" />
							<div class="clear"></div>
							<div class="counter">
								<s:text name="label.request.fourHundred" />
							</div>
							<!-- fix positions -->
							<div class="counterTxt">
								<p class="guidance">
								<s:text name="label.request.textSize" />
								</p>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<div class="row">
					<div class="span12 btn-container">
						<div class="form-row">
							<s:submit key="label.request.common.sendBack" onclick="submitAction(3)" cssClass="btn-primary" />
							<a class="nav-hide btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel" /></a>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
	</div>



