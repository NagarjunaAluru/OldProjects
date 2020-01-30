/**
 * @author arijit.biswas
 */

$(document).ready(function() {
	
	/*Applicant GE Reference*/
	$('body').off('click', 'a#addAdditionalGERef').on('click', 'a#addAdditionalGERef', function(e) {
		var bgGeReferenceFieldAddIndex = parseInt($('#bgGeReferenceFieldAddIndexId').val());
		if(bgGeReferenceFieldAddIndex <2){
			$("table#additionalGERef tbody tr:last").after('<tr class="bgGeReferenceField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?bgGeReferenceFieldAddIndex='+(bgGeReferenceFieldAddIndex+1);
			$('.bgGeReferenceField').load(url).removeClass('bgGeReferenceField');
			bgGeReferenceFieldAddIndex++;
			$('#bgGeReferenceFieldAddIndexId').val(bgGeReferenceFieldAddIndex);
		}
		if(bgGeReferenceFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*Customer GE Reference*/
	$('body').off('click', 'a#addAdditionalCustRef').on('click', 'a#addAdditionalCustRef', function(e) {
		var customerFieldAddIndex = parseInt($('#customerFieldAddIndexId').val());
		if(customerFieldAddIndex <2){
			$("table#additionalCustRef tbody tr:last").after('<tr class="customerField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?customerFieldAddIndex='+(customerFieldAddIndex+1);
			$('.customerField').load(url).removeClass('customerField');
			customerFieldAddIndex++;
			$('#customerFieldAddIndexId').val(customerFieldAddIndex);
		}
		if(customerFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*Obligee Reference*/
	$('body').off('click', 'a#addAdditionalOblRef').on('click', 'a#addAdditionalOblRef', function(e) {
		var oblreferenceFieldAddIndex = parseInt($('#oblreferenceFieldAddIndexId').val());
		if(oblreferenceFieldAddIndex <2){
			$("table#additionalOblRef tbody tr:last").after('<tr class="oblReferenceField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?oblreferenceFieldAddIndex='+(oblreferenceFieldAddIndex+1);
			$('.oblReferenceField').load(url).removeClass('oblReferenceField');
			oblreferenceFieldAddIndex++;
			$('#oblreferenceFieldAddIndexId').val(oblreferenceFieldAddIndex);
		}
		if(oblreferenceFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*Principal Reference*/
	$('body').off('click', 'a#addAdditionalPrincipalRef').on('click', 'a#addAdditionalPrincipalRef', function(e) {
		var gereferenceFieldAddIndex = parseInt($('#gereferenceFieldAddIndexId').val());
		if(gereferenceFieldAddIndex <2){
			$("table#additionalPrincipalRef tbody tr:last").after('<tr class="principalReferenceField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?gereferenceFieldAddIndex='+(gereferenceFieldAddIndex+1);
			$('.principalReferenceField').load(url).removeClass('principalReferenceField');
			gereferenceFieldAddIndex++;
			$('#gereferenceFieldAddIndexId').val(gereferenceFieldAddIndex);
		}
		if(gereferenceFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*Applicant Reference DLOC*/
	$('body').off('click', 'a#addAdditionalAppRef').on('click', 'a#addAdditionalAppRef', function(e) {
		var geregferenceFieldAddIndex = parseInt($('#geregferenceFieldAddIndexId').val());
		if(geregferenceFieldAddIndex <2){
			$("table#additionalAppRef tbody tr:last").after('<tr class="geregferenceField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?geregferenceFieldAddIndex='+(geregferenceFieldAddIndex+1);
			$('.geregferenceField').load(url).removeClass('geregferenceField');
			geregferenceFieldAddIndex++;
			$('#geregferenceFieldAddIndexId').val(geregferenceFieldAddIndex);
		}
		if(geregferenceFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*Customer GE Reference DLOC*/
	$('body').off('click', 'a#addAdditionalBenRef').on('click', 'a#addAdditionalBenRef', function(e) {
		var geBenificiaryFieldAddIndex = parseInt($('#geBenificiaryFieldAddIndexId').val());
		if(geBenificiaryFieldAddIndex <2){
			$("table#additionalBenRef tbody tr:last").after('<tr class="geBenificiaryField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?geBenificiaryFieldAddIndex='+(geBenificiaryFieldAddIndex+1);
			$('.geBenificiaryField').load(url).removeClass('geBenificiaryField');
			geBenificiaryFieldAddIndex++;
			$('#geBenificiaryFieldAddIndexId').val(geBenificiaryFieldAddIndex);
		}
		if(geBenificiaryFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*shipping country DLOC*/
	$('body').off('click', 'a#addadditionalCountryRef').on('click', 'a#addadditionalCountryRef', function(e) {
		var shipOrgCtryFieldAddIndex = parseInt($('#shipOrgCtryFieldAddIndexId').val());
		if(shipOrgCtryFieldAddIndex <2){
			$("table#additionalCountryRef tbody tr:last").after('<tr class="shipOrgCtryField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?shipOrgCtryFieldAddIndex='+(shipOrgCtryFieldAddIndex+1);
			$('.shipOrgCtryField').load(url).removeClass('shipOrgCtryField');
			shipOrgCtryFieldAddIndex++;
			$('#shipOrgCtryFieldAddIndexId').val(shipOrgCtryFieldAddIndex);
		}
		if(shipOrgCtryFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	/*goods of origin DLOC*/
	$('body').off('click', 'a#addadditionalGoodsRef').on('click', 'a#addadditionalGoodsRef', function(e) {
		var originGoodsFieldAddIndex = parseInt($('#originGoodsFieldAddIndexId').val());
		if(originGoodsFieldAddIndex <2){
			$("table#additionalGoodsRef tbody tr:last").after('<tr class="originGoodsField optional"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalField.action?originGoodsFieldAddIndex='+(originGoodsFieldAddIndex+1);
			$('.originGoodsField').load(url).removeClass('originGoodsField');
			originGoodsFieldAddIndex++;
			$('#originGoodsFieldAddIndexId').val(originGoodsFieldAddIndex);
		}
		if(originGoodsFieldAddIndex == 2){
			$(e.target).hide();
		}
		return false;
	});
	
	$.subscribe('getAutocompleterName1', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).closest('td').children("input:first").attr("id");
		var textField = $("#"+data.id).closest('td').find(".autoCompleterName").attr("id");
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
	
	$('body').off('click', 'a.delete-ce').on('click', 'a.delete-ce', function(e) {		
		e.preventDefault();
		e.stopPropagation();
		var table = $(e.target).parents('tbody');
		var rowIndex = $(e.target).parents('tr').index();
		var tableLength = $(table).children('tr').length;
		if(rowIndex == 1 && tableLength > 2){
			if($(e.target).siblings('.referenceTextValue').prop("type") == "select-one"){
				var id = $(table).children('tr:last').find('.referenceTextValue').prev("input[type=hidden]").val();
				var name = $(table).children('tr:last').find('.referenceTextValue').siblings(".autoCompleterName").val();
				$(e.target).siblings('.referenceTextValue').prev("input[type=hidden]").val(id);
				$(e.target).siblings('.referenceTextValue').next("input").val(name);
				$(e.target).siblings('.referenceTextValue').siblings(".autoCompleterName").val(name);
			}else if($(e.target).siblings('.referenceTextValue').prop("type") == "text"){
				$(e.target).siblings('.referenceTextValue').val($(table).children('tr:last').find('.referenceTextValue').val());
			}
		}
		var divFormRow = $(e.target).parents('div.form-row');
		$(table).children('tr:last').remove();
		var referenceIndexValue = parseInt($(divFormRow).find('.referenceIndex ').val());
		var sectionName = $(divFormRow).find('.sectionName ').val();
		$(divFormRow).find('.referenceIndex').val(referenceIndexValue-1);
		$(divFormRow).find('.add-exception').show();
		var referenceIndexName = $(divFormRow).find('.referenceIndex ').attr('name');
		var url = contextURL+'/int/requestor/removeAdditionalField.action';
		var formData=getFormData(referenceIndexName,referenceIndexValue,sectionName);
		$.post(url,formData);
		return false;
	});
	
	
	
	if (window.PIE) {
        $('.btn').each(function() {
            PIE.attach(this);
        });
    }
});



function getFormData(referenceIndexName,referenceIndexValue,sectionNameValue){
	var formData = {};
	if(referenceIndexName == 'gereferenceFieldAddIndex'){
		formData={
				gereferenceFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'oblreferenceFieldAddIndex'){
		formData={
				oblreferenceFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'geregferenceFieldAddIndex'){
		formData={
				geregferenceFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'geBenificiaryFieldAddIndex'){
		formData={
				geBenificiaryFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'shipOrgCtryFieldAddIndex'){
		formData={
				shipOrgCtryFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'originGoodsFieldAddIndex'){
		formData={
				originGoodsFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
		if($('#originGoodsFieldAddIndexId').parents('div.form-row').find("#originOfGoodsCd").val()=="US" 
			|| $('#originGoodsFieldAddIndexId').parents('div.form-row').find("#originOfGoodsCd1").val()=="US"
			|| $('#originGoodsFieldAddIndexId').parents('div.form-row').find("#originOfGoodsCd2").val()=="US"){				
  		   $("#usPercentID").show();
  		   makeMandatory('#usPercentID');
  	   }else{	
  		   $("#usPercentID").hide();
  		   removeMandatory('#usPercentID');
  	   } 
	}
	else if(referenceIndexName == 'buContactPersonFieldAddIndex'){
		formData={
				buContactPersonFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}else if(referenceIndexName == 'customerFieldAddIndex'){
		formData={
				customerFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	else if(referenceIndexName == 'bgGeReferenceFieldAddIndex'){
		formData={
				bgGeReferenceFieldAddIndex : referenceIndexValue,
				sectionName: sectionNameValue
		};
	}
	return formData;
}