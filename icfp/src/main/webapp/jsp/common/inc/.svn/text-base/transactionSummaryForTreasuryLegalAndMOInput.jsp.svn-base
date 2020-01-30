<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
<div class="form-mod">
			<h2 class="span12 collapsible  collapsed"><bean:message key="heading.fourBlocker.transactionSummary" /></h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.securityType"/></b><br />
							<bean:write name="dealRequestForm" property="securityCategory" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.financialStatementsDateYear"/></b><br />
						<bean:write name="dealRequestForm" property="finSttmntDtAboveOneYrFlag" /></p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.subordinatedDebt"/></b><br />
							<bean:write name="dealRequestForm" property="subordinatedDebtFlag" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.derivatives"/></b><br />
						<bean:write name="dealRequestForm" property="derivativesNeededFlag" /></p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.crossBorder"/></b><br />
						<bean:write name="dealRequestForm" property="crossBorderFlag" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.equityInfusion"/></b><br />
						<bean:write name="dealRequestForm" property="equityInfusionsDividendsFlag" /></p>
					</div>
				</div><!-- end of block -->
				
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key = "heading.fourBlocker.nonStandardLegalAgreement"/></b><br />
						<bean:write name="dealRequestForm" property="nonStandardDocsFlag" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.prudentiallyRegulatedLegalEntity"/></b><br />
						<bean:write name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" /></p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.impairmentHistory"/></b><br />
						<bean:write name="dealRequestForm" property="impairmentHistoryFlag" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key = "label.fourBlocker.principalLegalEntity"/></b><br />
						<bean:write name="dealRequestForm" property="principalLegalEntityFlag" /></p>
					</div>
				</div><!-- end of block -->
			</div>
		</div>