<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
&nbsp;
<s:set name="isEditMode" value="editMode" />
	<s:if test="%{#isEditMode==true}">
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="clear"></div>
				<div class="span6">
					<div class="form-row">
						<s:textfield name="requestDetails.rider.expiryDate.revisedExpiryDate" key="label.request.revisedExpirationDate"
						theme="aloc" cssClass="span2 date"/>
						<p>DD MMM YYYY</p>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="clear"></div>
				<div class="span2c">
					<div class="form-row">
						<label><s:text name="label.request.originalExpirationDate" />:</label>
					</div>
				</div>
				
				<div class="span2 left">
					<div class="form-row">
					<c:if test="${empty requestDetails.previousRider.expiryDate.revisedExpiryDate}">
						<p><s:property value="requestDetails.rider.expiryDate.currentExpiryDate" /></p>
					</c:if>
					<c:if test="${not empty requestDetails.previousRider.expiryDate.revisedExpiryDate}">
						<p><s:property value="requestDetails.previousRider.expiryDate.revisedExpiryDate" /></p>
					</c:if>
					</div>
				</div>
				
			</div>
		</c:if>
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="clear"></div>
				<div class="span160">
					<div class="form-row">
						<label><s:text name="label.request.revisedExpirationDate" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.rider.expiryDate.revisedExpiryDate" /></p>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="clear"></div>
				<div class="span160">
					<div class="form-row">
						<label><s:text name="label.request.originalExpirationDate" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<c:if test="${empty requestDetails.previousRider.expiryDate.revisedExpiryDate}">
						<p><s:property value="requestDetails.rider.expiryDate.currentExpiryDate" /></p>
					</c:if>
					<c:if test="${not empty requestDetails.previousRider.expiryDate.revisedExpiryDate}">
						<p><s:property value="requestDetails.previousRider.expiryDate.revisedExpiryDate" /></p>
					</c:if>
					</div>
				</div>
			</div>
		</c:if>
	</s:elseif>