<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		 
			<div class="row">
				<div class="span12">
					<div class="form-row">
					     <c:if test="${(requestDetails.instrumentTypeId eq '4')}">
							<label><s:text name="label.request.youAreRequiredEitherUploadOrCopy" /></label>
		                </c:if>
		                
						<div class="radio-container intrest-type-condition1">
							<s:radio id="addcondId" cssClass="radio fixed-condition"
								name="optionsRadiosp" list="#{'upload':'Yes, upload documentation'}" theme="aloc" />
							<s:radio id="editcondId" cssClass="radio float-condition" 
								name="optionsRadiosp" list="#{'copyPaste':'No, opt out'}"
								theme="aloc" />
						    <s:radio id="exitcondId" cssClass="radio exit-condition"
								name="optionsRadiosp" list="#{'Exit and Revisit':'No, exit and revisit later'}"
								theme="aloc" />
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="/jsp/ext/request/common/instrumentDocumentation.jsp"/>				
			
			
