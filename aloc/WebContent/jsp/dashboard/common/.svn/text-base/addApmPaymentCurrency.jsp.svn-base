<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="form-row">
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
		name="apmSearch.paymentCurrencies[%{#parameters['newPaymentCurrency']}]"
		cssClass="span2" listKey="currencyCode" listValue="currencyName" onChangeTopics="getAutocompleterName"/>
	<br>
	<em> <s:text name="label.advanceSearch.em.currency"/> </em>
</div>

<script>
$(document).ready(function() {
	
	$.subscribe('getAutocompleterName', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var textField = $("#"+data.id).parents('div.form-row').find(".autoCompleterName").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			text = ui.item.value;
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		$('#'+textField).val($.trim(text));
		event.stopPropagation();
	});
});
</script>