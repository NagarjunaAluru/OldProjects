<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<s:set name="isEditMode" value="editMode" />
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.SBLC.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	onclickSBLC();
	showSBLCOnload();
	sendbackOnloadShow();
});

</script>
</c:if>
 <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.SBLC.requiresEdits}">
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
							<c:out value="${requestDetails.SBLC.sendBackNotes}" />
						</p>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<div class="radio-container mandatory" id="sblc">
					<s:radio theme="aloc" cssClass="radio usIssuanceFlagRadio"
						key="label.request.IssuedinUS"
						tooltip="%{getText('label.request.tooltip.issuedinUS')}"
						id="usIssuanceFlag" name="requestDetails.SBLC.USIssuanceFlag"
						list="#{'true':'Yes','false':'No'}"
						value="%{requestDetails.SBLC.USIssuanceFlag}" />
					<s:hidden name="requestDetails.SBLC.USIssuanceFlag"
						id="uniqueUSIssuanceFlag" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<div class="radio-container mandatory intrest1">
					<s:radio theme="aloc" cssClass="radio confirmcount"
						key="label.request.sblcConfirmation"
						tooltip="%{getText('label.request.tooltip.sblcConfirmation')}"
						id="creditReqConfimFlag"
						name="requestDetails.SBLC.creditReqCnfmFlag"
						list="#{'true':'Yes','false':'No'}"
						value="%{requestDetails.SBLC.creditReqCnfmFlag}" />
				</div>
			</div>
		</div>
	</div>
	<div class="hide row sblcReqYesDiv">
		<div class="span12">
			<div class="form-row">
				<sj:autocompleter id="selectedConfirmedCountry"
					key="label.request.IssblcConfirmed" parentTheme="aloc"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="requestDetails.SBLC.creditCnfmCountryId" cssClass="span3"
					listKey="countryCode" listValue="countryName" selectable="false"
					onChangeTopics="getAutocompleterName" maxlength="100" />
				<s:hidden name="requestDetails.SBLC.creditCnfmCountry"
					id="creditCnfmCountry" cssClass="autoCompleterName"></s:hidden>
			</div>
		</div>
	</div>
	<div class="row hide sblcReqNoDiv">
		<div class="span12">
			<div class="form-row">
				<div class="radio-container sblcReq">
					<s:radio theme="aloc" id="creditReqAdviseFlag" cssClass="radio" tooltip="%{getText('label.request.tooltip.sblcAdv')}"
						name="requestDetails.SBLC.creditReqAdviseFlag" key="label.request.requireAdvertisement"
						list="#{'true':'Yes','false':'No'}"
						value="%{requestDetails.SBLC.creditReqAdviseFlag}" />
				</div>
			</div>
		</div>
	</div>
	<div class="row hide sblcReqAdviseDiv">
		<div class="span12">
			<div class="form-row">
				<sj:autocompleter id="selectedAdviseCountry" parentTheme="aloc"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="requestDetails.SBLC.creditAdviseCountryId"
					key="label.request.CoutrySBLC" cssClass="span3"
					listKey="countryCode" listValue="countryName" selectable="false"
					onChangeTopics="getAutocompleterName" maxlength="100" />
				<s:hidden name="requestDetails.SBLC.creditAdviseCountry"
					id="creditAdviseCountry" cssClass="autoCompleterName"></s:hidden>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		refreshSectionCount('locConditionsPanel');
	</script>
</s:if>
<s:elseif test="%{#isEditMode==false}">
	<div class="row">
		<div class="span3a">
			<div class="form-row">
				<s:label key="label.request.StandbyIssuedinUS" theme="aloc"></s:label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:if test="%{requestDetails.SBLC.USIssuanceFlag}">
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
		<div class="span12">
				<div class="row">
					<div class="span3a">
						<div class="form-row">
							<s:label key="label.request.StandbyConfirmation" theme="aloc"></s:label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="%{requestDetails.SBLC.creditReqCnfmFlag}">
									<s:text name="label.request.common.yes" />
								</s:if>
								<s:else>
									<s:text name="label.request.common.no" />
								</s:else>
							</p>
						</div>
					</div>
				</div>
				<s:if test="%{requestDetails.SBLC.creditCnfmCountry != null && requestDetails.SBLC.creditCnfmCountry != '' && requestDetails.SBLC.creditReqCnfmFlag}">
					<div class="row">
						<div class="span3a">
							<div class="form-row">
								<s:label key="label.request.StandbyConfirmedIn" theme="aloc"></s:label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${requestDetails.SBLC.creditCnfmCountry}" />
								</p>
							</div>
						</div>
					</div>
				</s:if>
				<s:else>
					<div class="row">
						<div class="span3a">
							<div class="form-row">
								<s:label key="label.request.StandbyAdvertisement" theme="aloc"></s:label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:if test="%{requestDetails.SBLC.creditReqAdviseFlag}">
										<s:text name="label.request.common.yes" />
									</s:if>
									<s:else>
										<s:text name="label.request.common.no" />
									</s:else>
								</p>
							</div>
						</div>
					</div>
				</s:else>
				 <s:if test="%{requestDetails.SBLC.creditAdviseCountry !=null && requestDetails.SBLC.creditAdviseCountry !='' && requestDetails.SBLC.creditReqAdviseFlag}">
					<div class="row">
						<div class="span3a">
							<div class="form-row">
								<s:label key="label.request.StandbyAdvisedIn" theme="aloc"></s:label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${requestDetails.SBLC.creditAdviseCountry}" />
								</p>
							</div>
						</div>
					</div>
				</s:if>
		</div>
	</div>
	<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
	<s:if test="%{requestDetails.SBLC.requiresEdits}">
						<div class="row">
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${requestDetails.SBLC.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</c:if>
</s:elseif>
