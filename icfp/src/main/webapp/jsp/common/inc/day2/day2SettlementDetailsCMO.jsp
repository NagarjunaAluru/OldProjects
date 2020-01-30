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
						<b>Gross Settlement amount</b><br>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.grossSettlementAmt" styleId="grossSettlementAmt" />
						<span class="grosssSet"></span>
						<br/><br/>
						<b>Payer</b>
						<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
							<p>-</p>
						</logic:empty>
						<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
							<p>
								<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" />
							</p>
						</logic:notEmpty>
					</div>
				</div>
				<!-- end of block -->
			</div>


			<div class="row">
				<div class="span12">
					<div class="form-row">
						<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.entitySetupFlag">				
								<logic:equal name="ICFPLegRequestForm" property="legSummary.lenderEntity.entitySetupFlag" value="Y">
							       	<p>
										<label>Legal Entity Setup Pending</label>
									</p>
							       	<p>Yes</p>
								</logic:equal>
							</logic:notEmpty>
						</logic:empty>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
	</div>
</div>
