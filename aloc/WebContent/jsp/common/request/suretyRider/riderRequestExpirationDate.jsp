<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="isEditMode" value="editMode" />
<p class="previous_del">
	<s:text name="label.request.previous" />
</p>
<div class="row">
	<div class="span6">
		<div class="form-row">
			<s:textfield key="label.request.revisedExpirationDate"	name="requestDetails.rider.expiryDate.revisedExpiryDate" theme="aloc" cssClass="span3 date" />
		</div>
	</div><br>
	<div class="span6 left">
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label><s:text name="label.request.originalExpirationDate" />:</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p class="padding40">
						<s:property value="requestDetails.bondInfo.expirationDt" />
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end of block -->

