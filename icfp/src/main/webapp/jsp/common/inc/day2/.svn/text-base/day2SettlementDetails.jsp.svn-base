<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
	<h2>Settlement Details</h2>
	<div class="clear"></div>

	<div>
		<div>

			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Gross Settlement amount</label>
						<input type="hidden"  name="legSummary.grossSettlementAmt" id="grossSettlementAmt"
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.grossSettlementAmt}" />"/>
						<span class="grosssSet"></span>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="span12">
					<div class="form-row">
						<b>Payer</b><br/>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId" styleId="payorGoldId" />
						<span class="payorId"></span>
						</div>
					</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<b>Legal Entity Setup Pending</b><br/>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.entitySetupFlag" styleId="payorEntitySetupFlag" />
						<span class="payorSetUpPending"></span>
						</div>
					</div>
				<!-- end of block -->
			</div>

		</div>
	</div>
</div>
