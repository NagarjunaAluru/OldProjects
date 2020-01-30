<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
	<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified"/></p>
	<c:if test="${param.pageSection == 'Current'}">
	<div class="row lastrow">
		<div class="span12">
			<div class="form-row autosize-container">
				<s:textarea cssClass="autosize3 messageinput" name="requestDetails.amendment.otherChanges" theme="aloc" required="false" onkeypress="return imposeMaxLength(this, 299);"
					key="label.amendment.otherChanges" tooltip="%{getText('label.amendment.tooltip.otherChanges')}" id="amdotherChanges"/>
                <div class="clear"></div>
                <div class="counter">300</div> <!-- fix positions -->
                 <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize" /></p></div>
			</div>
		</div>
	</div> 
	</c:if>
	<c:if test="${param.pageSection == 'Previous'}">
	<div class="row">
		<div class="span2">
			<div class="form-row autosize-container">
				<label><s:text name="label.amendment.otherChanges"/>:</label>
				
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40" style="word-wrap:break-word;">
					<c:if test="${not empty requestDetails.previousAmendment.otherChanges}"><s:property value="requestDetails.previousAmendment.otherChanges"/></c:if>
					<c:if test="${empty requestDetails.previousAmendment.otherChanges}">-</c:if> 
				</p>
			</div>
		</div>
	</div> 
	</c:if>
</s:if>
<s:elseif test="%{#isEditMode==false}" >
	<div class="row">
		<div class="span2">
			<div class="form-row autosize-container">
				<label><s:text name="label.amendment.otherChanges"/>:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40" style="word-wrap:break-word;">
					<c:if test="${not empty requestDetails.amendment.otherChanges}"><s:property value="requestDetails.amendment.otherChanges"/></c:if>
					<c:if test="${empty requestDetails.amendment.otherChanges}">-</c:if> 
				</p>
			</div>
		</div>
	</div> 
</s:elseif>