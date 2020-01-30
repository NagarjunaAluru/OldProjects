<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>


<div class="form-mod">
	<h2 class="span12">Cash Pool Termination Details</h2>

	<div class="row">
	<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Current Cash Pool Agreement Attached</label>
						<span  class="help-block error" id="currentCashPoolAgreementAttachedFailed" style="display:none;">Please select</span>
						<div id="currentCashPoolAgreementAttachedDiv" class="radio-container">
						<label class="radio">
										<html:radio name="cpaLegRequestForm" styleClass="condition" property="dayTwoOperations.CPATermination.currentCPAAttachedFlag" styleId="isCurrentCashPoolAgreementAttachedId" value="Y"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="cpaLegRequestForm" property="dayTwoOperations.CPATermination.currentCPAAttachedFlag" styleId="isCurrentCashPoolAgreementAttachedId" value="N"/>
										<bean:message key="label.addLeg.no" />
						</label>
						</div>
					</div>
				</div>

		<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Termination Notice Attached</label>
						<span  class="help-block error" id="terminationNoticeAttachedFailed" style="display:none;">Please select</span>
						<div id="terminationNoticeAttachedDiv" class="radio-container">
						<label class="radio">
										<html:radio name="cpaLegRequestForm" styleClass="condition" property="dayTwoOperations.CPATermination.terminationNoticeAttachedFlag" styleId="terminationNoticeAttachedId" value="Y"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="cpaLegRequestForm" property="dayTwoOperations.CPATermination.terminationNoticeAttachedFlag" styleId="terminationNoticeAttachedId" value="N"/>
										<bean:message key="label.addLeg.no" />
						</label>
						</div>
					</div>
				</div>
	</div>


</div>