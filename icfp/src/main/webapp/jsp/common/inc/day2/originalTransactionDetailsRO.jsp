<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<h2 class="span12">Original Transaction Details</h2>
<div class="clear"></div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<label>Product Type</label>
			<div class="radio-container">Equity</div>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right ">
		<div class="form-row">
			<p>
				<b>Trade ID</b>
			</p>
			<p>
			<logic:empty name="ICFPLegRequestForm" property="legSummary.transactionId">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.transactionId">
				<bean:write name="ICFPLegRequestForm" property="legSummary.transactionId" />
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row">
	<div class="span5">

		<div class="form-row">
			<p>
				<b>Non Standard Legal Agreement(s)</b>
			</p>
			<logic:empty name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag">
				<logic:equal name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag" value="1">
		        	<p>Yes</p>
				</logic:equal>
	            <logic:equal name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag" value="0">
		             <p>No</p>
	            </logic:equal>
	            <logic:equal name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag" value="2">
		        	<p>N/A</p>
				</logic:equal>
			</logic:notEmpty>
		
		</div>
	</div>
	<div class="span5 right">
		<div class="form-row">
			<label>Currency</label>
			<logic:empty name="ICFPLegRequestForm" property="legSummary.dayOneCCY">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.dayOneCCY">
				<bean:write name="ICFPLegRequestForm" property="legSummary.dayOneCCY" />
			</logic:notEmpty>
		</div>
	</div>
</div>

<div class="row">
	<div class="span5 right">
		<div class="form-row">
			<label>Principal Amount</label>
			<logic:empty name="ICFPLegRequestForm" property="legSummary.dayOneCCYAmount">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.dayOneCCYAmount">
				<bean:write name="ICFPLegRequestForm" property="legSummary.dayOneCCYAmount" />
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->

</div>

<div class="row" id="transactionUsdEquiDiv">
	<div class="span5 right">
		<div class="form-row">
			<label>USD Equivalent</label>
			<logic:empty name="ICFPLegRequestForm" property="legSummary.dayOneUSDEquivalent">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.dayOneUSDEquivalent">
				<p>
					<bean:write name="ICFPLegRequestForm" property="legSummary.dayOneUSDEquivalent" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>


