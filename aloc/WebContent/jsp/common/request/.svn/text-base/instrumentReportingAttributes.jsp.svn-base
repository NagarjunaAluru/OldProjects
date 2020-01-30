<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.instrReporting.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	poleNameClick();
	sendbackOnloadShow();
});

</script>
</c:if>
	   <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.instrReporting.requiresEdits}">
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
								<c:out value="${requestDetails.instrReporting.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>	
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.poleName" />
					 <s:select headerKey="" list="%{#attr['com.ge.aloc.StaticDataFactory'].polesDetails}"
				            headerValue="Select..." listKey="ID" listValue="name" id="poleId"
				            name="requestDetails.instrReporting.poleId" theme="aloc" cssClass="mandatory"/>
				</div>
				<s:hidden name="requestDetails.instrReporting.poleName" id="poleName" value="%{requestDetails.instrReporting.poleName}"/>
			</div>
		</div>
		<div class="hide" id="instRptAttrDevId">
			<div class="row ">
				<div class="span12">
					<div class="row">
						<div class="span12">
							<div class="form-row">
									<s:textfield name="requestDetails.instrReporting.buProjId" key="label.request.BusinessProjectID" required="false" id="buProjId" theme="aloc" maxlength="38"/>			
									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
									<s:textfield name="requestDetails.instrReporting.billingRef" id="billingRef" key="label.request.Billingreference" required="false" theme="aloc" maxlength="100"/>			
							</div>
						</div>
					</div>
					<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 0)">
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:if test="%{requestDetails.instrReporting.siteRequiredFlag}">
										<label>
										<s:property value="requestDetails.instrReporting.siteCustoms[0].siteCustomField"/> <span class="ttip info" data-original-title="<s:text name="label.request.tooltip.siteCustom"/>"></span>
										</label>
										<s:textfield name="requestDetails.instrReporting.siteCustoms[0].siteCustomValue" id="customValueMandatory" theme="aloc" maxlength="100"/>
										<s:hidden name="requestDetails.instrReporting.siteRequiredFlag" id="siteRequiredFlag"/>
									</s:if>
									<s:else>
										<label class="optional">
										<s:property value="requestDetails.instrReporting.siteCustoms[0].siteCustomField"/> - optional<span class="ttip info" data-original-title="<s:text name="label.request.tooltip.siteCustom"/>"></span>
										</label>
										<s:textfield name="requestDetails.instrReporting.siteCustoms[0].siteCustomValue" id="siteCustomsIdOne" theme="aloc" maxlength="100"/>
									</s:else>
									
										 
								</div>
							</div>
						</div>
					</s:if>
					<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 1)">
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<label class="optional">
										<s:property value="requestDetails.instrReporting.siteCustoms[1].siteCustomField"/> - optional
									</label>
									<s:textfield name="requestDetails.instrReporting.siteCustoms[1].siteCustomValue" id="siteCustomsIdTwo" theme="aloc" maxlength="100"/>
								</div>
							</div>
						</div>
					</s:if>
					<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 2)">
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<label class="optional">
										<s:property value="requestDetails.instrReporting.siteCustoms[2].siteCustomField"/> - optional
									</label>
									<s:textfield name="requestDetails.instrReporting.siteCustoms[2].siteCustomValue" id="siteCustomsIdThree" theme="aloc" maxlength="100"/>
								</div>
							</div>
						</div>
					</s:if>
					
				</div>
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('instrumentReportingPanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
		 <div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.poleName" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.instrReporting.poleName}"/></p>
					</div>
					<input type="hidden" name="requestDetails.instrReporting.poleName" id="poleName" value="${requestDetails.instrReporting.poleName}">
					<input type="hidden" name="requestDetails.instrReporting.poleId" id="poleId" value="${requestDetails.instrReporting.poleId}">
				</div>
			</div>
			<div class="row">
			<div class="span12">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.BusinessProjectID" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.instrReporting.buProjId}"/></p>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.Billingreference" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.instrReporting.billingRef}" /></p>
					</div>
				</div>
			</div>
			
			<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 0)">
			
				<div class="row">
				<div class="span3">
					<div class="form-row">
						<label>
						 <c:out value="${requestDetails.instrReporting.siteCustoms[0].siteCustomField}"/>:
						</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.instrReporting.siteCustoms[0].siteCustomValue}"/></p>
					</div>
				</div>
			</div>
			</s:if>
			
			<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 1)">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label>
						 		<c:out value="${requestDetails.instrReporting.siteCustoms[1].siteCustomField}"/>:
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.instrReporting.siteCustoms[1].siteCustomValue}" /></p>
						</div>
					</div>
				</div>
			</s:if>
			<s:if test="(requestDetails.instrReporting != null && requestDetails.instrReporting.siteCustoms.size > 2)">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label>
						 		<c:out value="${requestDetails.instrReporting.siteCustoms[2].siteCustomField}"/>:
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.instrReporting.siteCustoms[2].siteCustomValue}" /></p>
						</div>
					</div>
				</div>
			</s:if>
			
			</div>
			</div>
		
		</s:elseif>
	