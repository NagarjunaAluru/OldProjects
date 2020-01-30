<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legNumber, pageContext.request)}" scope="page"/>

<div class="form-mod">
	<h2 class="span12">Dividend Payment Details</h2>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<b>Currency</b><br>
					<logic:empty name="ICFPLegRequestForm" property="legSummary.originalCCY">
						<p>-</p>
					</logic:empty>
					<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.originalCCY">				
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/></p>
					</logic:notEmpty>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right ">
			<div class="form-row">
				<b>Amount</b><br>
					<logic:empty name="ICFPLegRequestForm" property="legSummary.originalCCYAmount">
						<p>-</p>
					</logic:empty>
					<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.originalCCYAmount">
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.originalCCYAmount"/></p>
					</logic:notEmpty>
			</div>
		</div>
		<!-- end of block -->

	</div>
	<div class="row">
		<div class="span5 right ">
			<div class="form-row">
				<p>
					<b>USD Equivalent</b><br>
				</p>
				<logic:empty name="ICFPLegRequestForm" property="legSummary.USDEquivalent">
					<p>-</p>
				</logic:empty>
				<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.USDEquivalent">
					<p><bean:write name="ICFPLegRequestForm" property="legSummary.USDEquivalent"/></p>
				</logic:notEmpty>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>
