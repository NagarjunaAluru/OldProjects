<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%-- Bank selection section --%>
<div class="form-mod">
	<h3>
		<s:text name="label.request.bglocSectionName.12" />
	</h3>
	<p class="required-fields">
		<s:text name="label.request.common.allFieldsRequiredUnlessSpecified" />
	</p>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<div class="radio-container">
					<s:radio cssClass="radio"
							name="requestDetails.issuingBankSelectionFlag" theme="aloc"
							key="label.request.issuingBankSelectionFlag"
							id="issuingBankSelectionFlag"
							list="#{'Y':'Yes','N':'No'}"
							value="%{requestDetails.issuingBankSelectionFlag}" />
					
				</div>
			</div>
		</div>
	</div>
	<!-- end of block -->
	<div class="hide bankShowDiv" id="bankShowDiv">
		<div class="row">
			<div class="span12">
				<s:label key="label.request.Banklist" />
				<sj:autocompleter id="treasurySelectedBankId" list="%{requestDetails.bankDetails}" listKey="name" listValue="name" 
				name="requestDetails.treasurySelectedBankName" value="%{requestDetails.treasurySelectedBankName}" cssClass="span3" parentTheme="aloc" onChangeTopics="getBankAutocompleterName"/>
			</div>
		</div>
	</div> 
	<%-- Reimbursement Agreement section --%>
	<h3 id="reimbersementAgreement">
	<s:text name="label.request.reimbermentAgreementSectionTitle" />
	</h3>
		<div class="row">
			<div class="span12">
				<div class="form-row">
						<s:select list="#{}" listKey="reimbursementAgreementId" listValue="reimbursementAgreementName" id="selectAgreemet"
						name="requestDetails.reimbursementAgreementId" key="label.request.agreementlist" theme="aloc"/>
						<s:hidden name="abc" value="%{requestDetails.reimbursementAgreementId}" id="reimbursementAgreementId" />
				</div>
			</div>
		</div>
	
<%-- U.S.Expiration Date Requirement section --%>
	<h3 id="dateExpiration">
		<s:text name="label.request.expirationDateSectionTitle"/>
			<span class="ttip info" data-original-title="<s:text name="label.request.usexpirationDateinfo"/>"></span>
	</h3>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label class="checkbox optional"> 
							<s:checkbox	name="requestDetails.USExpirationDateRequired" /> 
					</label>
					<s:text	name="label.request.expirationDateSelection"/>
				</div>
			</div>
		</div>

<%-- Stand by letter of credit transferable section --%>
<c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">

	<h3 id="standbyLOC">
		<s:text name="label.request.standbyLOCSectionTitle"></s:text>
	</h3>
	<div id="standbyLOCPanel">
		<div class="row">
			<div class="span12">
				<s:radio cssClass="radio" name="requestDetails.LOCTransferable"
					key="label.request.standbyLOCDescription" theme="aloc"
					list="#{'true':'Yes','false':'No'}"
					value="%{requestDetails.LOCTransferable}" />
			</div>
		</div>
	</div>

</c:if>
<%-- Webcash section --%>

	<h3 id="webcash">
		<s:text name="label.request.webcashSectionTitle" />
	</h3>
	<div id="webcashPanel">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:radio cssClass="radio" name="requestDetails.suppressWebcash"
						key="label.request.suppressWebcash" theme="aloc"
						id="webcashFlag"
						list="#{'true':'Yes','false':'No'}"
						value="%{requestDetails.suppressWebcash}" />
					<s:hidden name="suppressWebcash" value="%{requestDetails.suppressWebcash}" id="suppressWebcashId" />
				</div>
			</div>
		</div>
		<!-- end of block -->
	</div>


<%-- Transfer fees section --%>
	<h3 id="transferFees">
		<s:text name="label.request.transferFeesSectionTitle" />
	</h3>
	<div id="transferFeesPanel">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<div class="radio-container derivativesConditional">
						<s:radio cssClass="radio"
							name="requestDetails.transferFeesRequiredFlag" theme="aloc"
							key="label.request.transferFeesRequired"
							id="transferFeesFlag"
							list="#{'true':'Yes','false':'No'}"
							value="%{requestDetails.transferFeesRequiredFlag}" />
					</div>
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="hide transferFeesDiv" id="transferFeesDiv">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield theme="aloc"
							name="requestDetails.transferFees.transferCostBPS"
							cssClass="span1a bigDecimal" key="label.request.transferCostBPS"
							id="transferCostBPS" required="false"/>
							<p style="padding-top:5px;"><i>##,###.##</i></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
					<s:label key="label.request.currencyOptional" cssClass="optional"/>
						<sj:autocompleter id="bpsCurrId" list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
							name="requestDetails.transferFees.currencyBPSId" cssClass="span3"
							listKey="currencyCode" listValue="currencyName" parentTheme="aloc" onChangeTopics="getCurrencyAutocompleterName"/>
							<s:hidden name="requestDetails.transferFees.currencyBPSName" id="currencyBPS" cssClass="autoCompleterName"></s:hidden>
						<p class="guidance">
							 <s:text name="label.request.searchForCurrency"></s:text>
						</p>
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:radio cssClass="radio perAnnumQuarterBPS"
							name="requestDetails.transferFees.perAnnumQuarterBPS"
							theme="aloc" key="label.request.preannumOrPQ"
							list="#{'1':'P.A.','2':'P.Q.'}"
							value="%{requestDetails.transferFees.perAnnumQuarterBPS}" required="false" id="perAnnumQuarterBPS" />
					</div>
				</div>

			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield theme="aloc"
							name="requestDetails.transferFees.transferCostNumeric"
							cssClass="span1a bigDecimal" key="label.request.transferCostNumericAmount"
							id="transferCostNumeric" required="false" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
					<s:label key="label.request.currencyOptional" cssClass="optional"/>
						<sj:autocompleter id="numericCurrId"
							list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
							name="requestDetails.transferFees.currencyNumericId"
							cssClass="span3" listKey="currencyCode" listValue="currencyName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
							<s:hidden name="requestDetails.transferFees.currencyNumericName" id="currencyNumeric" cssClass="autoCompleterName"></s:hidden>
						<p class="guidance">
							<s:text name="label.request.searchForCurrency" />
						</p>
						
					</div>
				</div>
			</div>
			<div class="row">

				<div class="span12">
					<div class="form-row">
						<s:radio cssClass="radio perAnnumQuarterNumeric"
							name="requestDetails.transferFees.perAnnumQuarterNumeric"
							theme="aloc" key="label.request.preannumOrPQ"
							list="#{'1':'P.A.','2':'P.Q.'}"
							value="%{requestDetails.transferFees.perAnnumQuarterNumeric}" required="false" id="perAnnumQuarterNumeric"/>
					</div>
				</div>

			</div>
			<div class="row lastrow">
				<div class="span12">
					<div class="form-row">
						<s:textarea name="requestDetails.transferFees.comments" onkeypress="return imposeMaxLength(this, 399);"
							theme="aloc" key="label.request.transferFeesComments"
							cssClass="autosize messageinput" required="false" id="transferFeesComments" />
						<div class="clear"></div>
						<div class="counter">400</div> <!-- fix positions -->
                     	<div class="counterTxt"><p class="guidance"><s:text name="label.request.transferFeesCommentsSize" /></p></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
