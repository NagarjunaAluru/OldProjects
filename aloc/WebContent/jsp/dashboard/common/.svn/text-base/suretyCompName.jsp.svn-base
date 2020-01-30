<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	<div class="span3">
    	<s:label key="label.request.suretyFeeName"/>
	    <sj:autocompleter id="issuingSuretyCd" list="%{suretyMasterCollection.suretyMasters}" listKey="suretyName"
		                listValue="suretyName"	name="searchCriteria.searchBankDetails.suretyName" onChangeTopics="getAutocompleterName"
						cssClass="span2" />
	</div>