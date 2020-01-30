<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.transactionParties.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	loadSiteSpecificfields();
	instrumentPurposeClick();
	hideInsPurposeOther();
	sendbackOnloadShow();
});

</script>
</c:if>
       	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.transactionParties.requiresEdits}">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p>
								<c:out value="${requestDetails.transactionParties.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	  	<div class="row">
				<div class="span12">
				<div class="form-row">
					<p style="padding: 2px 0;" class="defaultFont">
						<b><s:text name="label.request.selectedSite"/></b> 
						<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
						<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
						<s:hidden name="requestDetails.siteId" value="%{requestDetails.siteId}" id="reqsiteID"></s:hidden>
						<s:hidden name="requestDetails.siteTypeName" value="%{requestDetails.siteTypeName}" id="siteTypeNameId"></s:hidden>
					</p>
				</div>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${param.page eq 'TreasuryAnalyst'}">
				<div class="row">
					<div class="span12">
						<div class="row lastrow">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.instrumentPurpose" /></label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding30">
										<c:out value="${requestDetails.transactionParties.instrumentPurpose}" />
										<s:hidden name="requestDetails.transactionParties.instrumentPurpose" />
									</p>
								  </div>
								</div>
							</div>
						</div>
					<!-- end of block -->
				</div>
				
				<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
				<div class="row">
					<div class="span12">
						<div class="row lastrow">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.otherFees.other" /></label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding30">
										<c:out value="${requestDetails.transactionParties.instrumentPurposeOther}" />
										<s:hidden name="requestDetails.transactionParties.instrumentPurposeOther" />
									</p>
								  </div>
								</div>
							</div>
						</div>
					</div>
			 </c:if>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:select theme="aloc" cssClass="mandatory"
								name="requestDetails.transactionParties.instrumentPurposeId"
								list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
								headerKey="" headerValue="Select..." listKey="ID" listValue="name"
								id="instrumentPurposeId" key="label.request.Instrumentpurpose"
								tooltip="%{getText('label.request.tooltip.Instrumentpurpose')}" />
							<s:hidden name="requestDetails.transactionParties.instrumentPurpose"
								id="instrumentPurpose"
								value="%{requestDetails.transactionParties.instrumentPurpose}" />
						</div>
						<div class="hide" id="instumrntDeatilsOtherDiv">
							<div class="row lastrow" style="margin-top: 20px !important;">
								<div class="span12">
									<div class="form-row">
										<s:textfield theme="aloc" id="instumrntDeatilsOther"
											name="requestDetails.transactionParties.instrumentPurposeOther" key="label.request.other" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	  
		<div class="row hide" style="margin-bottom: 15px !important;" id="triPartyRequest">
			<div class="span12">
				
				<div class="form-row countTriparty">
					<s:radio cssClass="radio" id="tripartyFlag"
					key="label.request.isTriPartyRequest"
					name="requestDetails.transactionParties.triPartyRequestFlag" 
					theme="aloc" 
					tooltip="%{getText('label.request.tooltip.triparty')}"
					list="#{'true':'Yes','false':'No'}" />
				</div>
			</div>
		</div>
		
		<div class="row hide" id="private">
			<div class="span12">
				
				<div class="form-row countPrivate">
					<s:radio cssClass="radio" id="privateLabel"
					key="label.request.privateLabel"
					name="requestDetails.transactionParties.privateLabelFlag" 
					theme="aloc" 
					tooltip="%{getText('label.request.tooltip.private')}"
					list="#{'true':'Yes','false':'No'}" />
				</div>
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('tripartyFlagSection');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}" >
			
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.selectedSite" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<c:out value="${requestDetails.siteName}" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.instrumentPurpose" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<c:out value="${requestDetails.transactionParties.instrumentPurpose}" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.otherFees.other" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<c:out value="${requestDetails.transactionParties.instrumentPurposeOther}" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
	 </c:if>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.isTriPartyRequest" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.privateLabel" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.privateLabelFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
		</c:if>
	
</s:elseif>
