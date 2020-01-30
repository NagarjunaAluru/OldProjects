<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="span2c">
			<s:label key="label.advanceSearch.field.issuingBankBranchName"/>
            <sj:autocompleter id="issuingBanksCd" list="%{issuingBanks.bankNames}" 
				name="searchCriteria.searchBankDetails.issuingBankBranchName" onChangeTopics="getAutocompleterName"
				cssClass="span2"/>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.relationshipBankName"/>
            <sj:autocompleter id="relationShipBanksCd" list="%{issuingBanks.bankNames}" 
				name="searchCriteria.searchBankDetails.relationshipBankName" onChangeTopics="getAutocompleterName"
				cssClass="span2"/>
		</div>
		