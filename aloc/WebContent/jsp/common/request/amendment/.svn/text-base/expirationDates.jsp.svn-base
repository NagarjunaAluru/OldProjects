<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
	<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified"/></p>
	<div class="row expDateNotification" style="display: none;">
    	<div class="span12">
			<div class="errorbox">
				<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
				<div class="noteContent">
					<p><s:text name="warning.amendment.expirationDate"/></p>
				</div>
			</div>
		</div>
    </div>

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<s:label key="label.amendment.currExpDate"/>
				<s:textfield name="requestDetails.amendment.expiryDate.revisedExpiryDate"
					cssClass="dateAmendmentExpiry" id="expiryDt" theme="aloc"/>
				<p>DD MMM YYYY</p>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<s:label key="label.amendment.origExpDate"/>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p id="amendmentCurrentExpDate"><s:property value="requestDetails.amendment.expiryDate.currentExpiryDate"/></p>
				
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<s:label key="label.amendment.currUSExpDate" theme="aloc" tooltip="%{getText('label.amendment.tooltip.revUSExpDate')}"/>
				<s:textfield name="requestDetails.amendment.expiryDate.USRevisedExpiryDate"
					cssClass="date" id="usexpiryDt" theme="aloc"/>
				<p>DD MMM YYYY</p>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<s:label key="label.amendment.origUSExpDate"/>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p id="USCurrentExpiryDate"><s:property value="requestDetails.amendment.expiryDate.USCurrentExpiryDate"/></p>
				<s:hidden name="requestDetails.amendment.expiryDate.USOriginalExpiryDate"  />
				<s:hidden name="requestDetails.amendment.expiryDate.USCurrentExpiryDate"  />
			</div>
		</div>
	</div>
	
	 
</s:if>
<s:elseif test="%{#isEditMode==false}" >
	<c:if test="${param.pageSection == 'Current'}">
	<div class="row">
    	<div class="clear"></div>
    	<div class="span2c">
			<div class="form-row">
				<s:label key="label.amendment.revisedExpDateTA"/>
			</div>
		</div> <!-- end of block -->
		<div class="span2 left">
			<div class="form-row">
				<p><s:property value="requestDetails.amendment.expiryDate.revisedExpiryDate"/></p>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${param.pageSection == 'Previous'}">
	<div class="row">
		<div class="clear"></div>
		<div class="span2">
			<div class="form-row">
				<s:label key="label.amendment.currExpDate"/>
			</div>
		</div>
		<div class="span2 left">
			<div class="form-row">
				<p><s:property value="requestDetails.previousAmendment.expiryDate.revisedExpiryDate"/></p>
			</div>
		</div>
	</div>
    
	</c:if>
	
	
	<c:if test="${param.pageSection == 'Current'}">
	<div class="row">
		<div class="clear"></div>
		<div class="span2">
			<div class="form-row">
				<s:label key="label.amendment.currUSExpDate"/>
			</div>
		</div>
		<div class="span2 left">
			<div class="form-row">
				<p><s:property value="requestDetails.amendment.expiryDate.USRevisedExpiryDate"/></p>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${param.pageSection == 'Previous'}">
    <div class="row">
    	<div class="clear"></div>
    	<div class="span2c">
			<div class="form-row">
				<s:label key="label.amendment.origUSExpDate"/>
			</div>
		</div> <!-- end of block -->
		<div class="span2 left">
			<div class="form-row">
				<p><s:property value="requestDetails.previousAmendment.expiryDate.USRevisedExpiryDate"/></p>
			</div>
		</div>
	</div>
	</c:if>
	
</s:elseif>