<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!-- Other Considerations  Start -->
<div class="form-mod">
		<h3 class="span12">Other Considerations</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Cross Border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></label>
						<span  class="help-block error" id="crossBorderFlagFailed" style="display:none;">Please select</span>
						<div id="crossBoarderDiv" class="radio-container">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="crossBorderFlagId" property="crossBorderFlag" value="true"/>
								Yes
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlagId" value="false"/>
								No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
				<div id="termDiv" class="span5 right">
					<div class="form-row">
						<div id="termMandatoryDiv"><span class="required">*</span></div>
						<label>
							<bean:message key="label.addLeg.term" /> 
							<span class="small"><bean:message key="label.addLeg.inMonths" /></span>
							<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<html:text name="cpaLegRequestForm" property="cpaSummary.term" maxlength="9" styleClass="span1" styleId="termInMonths" />
						<span id="termValidateBar" class="req-error" style="display:none;">error</span>
					</div>
	 			</div>
			</div>
			<div class="row">
				 
	 			<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Non-standard Legal Agreement(s)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="nonStandardAgreementsFlag" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
						</div>
					</div>
			</div>
			</div>
		
<!-- Other Considerations  End -->