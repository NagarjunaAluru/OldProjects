<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
		name="searchCriteria.searchInstrDetails.issuanceCountries[%{#parameters['newIssuanceCountry']}]" onChangeTopics="getAutocompleterName"
		cssClass="span2" listKey="countryCode" listValue="countryName" 
		cssStyle="font-size: 11px;" parentTheme="aloc"/>
	<br>
	<em> <s:text name="label.advanceSearch.em.country"/> </em>
</div>

<script type="text/javascript" >
$(document).ready(function(){
	$.subscribe('getAutocompleterName', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parent('div').children("input:first").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			text = ui.item.value;
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		event.stopPropagation();
	});
});
</script>