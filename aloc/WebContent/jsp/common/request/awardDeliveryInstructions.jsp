<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="row">
			<div class="span3b">
				<div class="form-row">
					<label><s:text name="label.request.deliverType" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40"> 
					 <s:if test="%{requestDetails.deliveryInstructions.deliveryType != null && requestDetails.deliveryInstructions.deliveryType!=''}"> 
						  <s:if test="%{requestDetails.deliveryInstructions.deliveryType == 'true'}">
						         <s:text name="label.request.inPerson" />
						  </s:if>
						  <s:if test="%{requestDetails.deliveryInstructions.deliveryType == 'false'}">
						         <s:text name="label.request.delivery" />
						  </s:if>
					 </s:if>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span3b">
				<div class="form-row">
					<label><s:text name="label.request.SpecialInstructionsOptional" />:</label>
				</div>
			</div>
			<div class="span7 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.deliveryInstructions.specialInstructions" /></p>
				</div>
			</div>
		</div>
    <c:if test="${requestDetails.deliveryInstructions.deliveryDesignationFlag != null && requestDetails.deliveryInstructions.deliveryDesignationFlag!=''}">  
		<div class="row">
			<div class="span3b">
				<div class="form-row">
					<label><s:text name="label.request.deliveryDesignationSWIFT" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.deliveryInstructions.deliveryDesignationFlag" /></p>
				</div>
			</div>
		</div>
	</c:if>