/**
 * @author arijit.biswas
 */

$(document).ready(function() {



	/*bucontact person lookup DLOC*/
	$('body').off('click', 'a#addadditionalBUContactRef').on('click', 'a#addadditionalBUContactRef', function(e) {
	//$("a#addadditionalBUContactRef").off('click').on('click', function() {
		var buContactPersonFieldAddIndex = parseInt($('#buContactPersonFieldAddIndexId').val());
		if(buContactPersonFieldAddIndex <2){
			$("table#additionalBUContactRef tbody tr:last").after('<tr class="buContactPersonField optional2"></tr>');
			var url = contextURL+'/int/requestor/addAdditionalBcpField.action?buContactPersonFieldAddIndex='+(buContactPersonFieldAddIndex+1);
			$('.buContactPersonField').load(url).removeClass('buContactPersonField');
			buContactPersonFieldAddIndex++;
			$('#buContactPersonFieldAddIndexId').val(buContactPersonFieldAddIndex);
		}
		if(buContactPersonFieldAddIndex == 2){
			$(this).hide();
		}
		return false;
	});

	$('body').off('click', 'a.deleteBCP-ce').on('click', 'a.deleteBCP-ce', function(e) {
	//$('a.deleteBCP-ce').off('click').on('click', function(e) {
		e.stopImmediatePropagation();
		var table = $(this).parents('tbody');
		var rowIndex = $(this).parents('tr').index();
		var tableLength = $(table).children('tr').length;
		var divFormRow = $(this).parents('table.additionalTable');
		var referenceIndexValue = parseInt($(divFormRow).siblings('.referenceIndex ').val());
		var sectionName = $(divFormRow).siblings('.sectionName ').val();
		if(rowIndex == 1 && tableLength > 2){
			var trToReplace = $(this).parents('tr');
			var trReplaced = $(table).children('tr:last');
			$(trReplaced).find('label#label_request_contactName3').attr('id','label_request_contactName2').text('Contact Name 2 - optional');
			$(trReplaced).find('input.name').attr('name',$(trToReplace).find('input.name').attr('name')).attr('id',$(trToReplace).find('input.name').attr('id'));
			$(trReplaced).find('input.phone').attr('name',$(trToReplace).find('input.phone').attr('name')).attr('id',$(trToReplace).find('input.phone').attr('id'));
			$(trReplaced).find('input.email').attr('name',$(trToReplace).find('input.email').attr('name')).attr('id',$(trToReplace).find('input.email').attr('id'));
			$(trReplaced).find('input.ssoId').attr('name',$(trToReplace).find('input.ssoId').attr('name')).attr('id',$(trToReplace).find('input.ssoId').attr('id'));
			$(trReplaced).find('input.businessSelection').attr('name',$(trToReplace).find('input.businessSelection').attr('name')).attr('id',$(trToReplace).find('input.businessSelection').attr('id'));
			$(trReplaced).find('div#businessShow2').attr('id','businessShow1');
			$(trReplaced).find('a.lookup').attr('href',$(trToReplace).find('a.lookup').attr('href'));
			trToReplace.html(trReplaced.html());
		}
		$(table).children('tr:last').remove();
		$(divFormRow).siblings('.referenceIndex').val(referenceIndexValue-1);
		$(divFormRow).siblings('.add-exception').show();
		var referenceIndexName = $(divFormRow).siblings('.referenceIndex ').attr('name');
		var url = contextURL+'/int/requestor/removeAdditionalField.action';
		var formData=getFormData(referenceIndexName,referenceIndexValue,sectionName);
		$.post(url,formData);
	});

	function getFormData(referenceIndexName,referenceIndexValue,sectionNameValue){
		var formData = {};
		if(referenceIndexName == 'buContactPersonFieldAddIndex'){
			formData={
					buContactPersonFieldAddIndex : referenceIndexValue,
					sectionName: sectionNameValue
			};
		}
		return formData;
	}

	if (window.PIE) {
		$('.btn').each(function() {
			PIE.attach(this);
		});
	}
});