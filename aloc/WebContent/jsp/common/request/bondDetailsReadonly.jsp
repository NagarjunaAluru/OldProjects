<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:set name="isEditMode" value="editMode" />
<script type="text/javascript">
				$(document).ready(function() {
					showSubBondOnload();
				});
			</script>
	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.principal.requiresEdits}">
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
								<s:property value="requestDetails.principal.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	<div id="suretyBondDetailsForm">
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label><s:text name="label.request.bondType" /> :</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out value="${requestDetails.bondDetails.bondType}" />
					</p>
					<s:hidden name="requestDetails.bondDetails.bondTypeId"
						id="selectBond" value="%{requestDetails.bondDetails.bondTypeId}" />
				</div>
			</div>
		</div>
	
		<c:if
			test="${requestDetails.bondDetails.bondTypeId eq '2' || requestDetails.bondDetails.bondTypeId eq '3' || requestDetails.bondDetails.bondTypeId eq '4'}">
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.bondSubtype" /> :</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<c:out value="${requestDetails.bondDetails.bondSubType}" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</c:if>
		<h3 id="principalHeader">
			<s:text name="label.request.sbSectionPrincipal" />
		</h3>
		<hr class="hr3">
		<jsp:include page="../../common/request/principalDetails.jsp" />
		<h3 id="obligeeHeader">
			<s:text name="label.request.sbSectionObligee" />
		</h3>
		<hr class="hr3">
		<jsp:include page="../../common/request/obligeeDetails.jsp" />
	</div>
 <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.principal.requiresEdits == true)}">
	<script type="text/javascript">
					refreshSectionCount("bondDetailsPanel");
			</script>
</s:if> 