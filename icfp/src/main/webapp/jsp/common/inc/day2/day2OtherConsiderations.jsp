<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod" style="width: 100%;">
	<h2>Other Considerations</h2>

	<div>
		<div>

			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span> <label>Cross border</label>
						<div class="radio-container">
							<span id="crossBorderFlagErrorBar">&nbsp;</span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlagId" value="true"/>
								Yes
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlagId" value="false"/>
								No
							</label>
						</div>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span> <label>Non-standard Legal
							Agreement(s)</label>
						<div class="radio-container exceptionsConditional">
							<span id="isNonStandardLegalAgreementErrorBar">&nbsp;</span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreementId" property="legSummary.nonStandardAgreementsFlag" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreementId" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
					</div>
				</div>
				<div class="span5 right ">
					<div class="form-row">
                       	<span class="required">*</span>
							<label>Subordinated Debt</label>
							<span id="subordinatedDebtErrorBar">&nbsp;</span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebtId" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebtId" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
					</div>
				</div>
				
				<!-- end of block -->
			</div>

		</div>
	</div>
</div>
		<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="edit" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
      
