
$(document).ready(function() {
	
	$
	.extend(
			$.ui.multiselect,
			{
				getter : 'selectedValues enabled isBusy',
				locale : {
					addAll : 'Add all',
					removeAll : 'Remove all',
					itemsCount : 'Selected Approvers - #{count}',
					itemsTotal : 'Available Approvers ',
					busy : 'please wait...',
					errorDataFormat : "Cannot add options, unknown data format",
					errorInsertNode : "There was a problem trying to add the item:\n\n\t[#{key}] => #{value}\n\nThe operation was aborted.",
					errorReadonly : "The option #{option} is readonly",
					errorRequest : "Sorry! There seemed to be a problem with the remote call. (Type: #{status})"
				},
				constants : {
					MESSAGE_WARNING : 0,
					MESSAGE_EXCEPTION : 1,
					MESSAGE_ERROR : 2
				}
			});
	var siteNameDeleg = $('#selectSiteNameDeleg').val();
	if(siteNameDeleg!=undefined && siteNameDeleg!=""){
		populateMultiSelect("#availableApp");
	}
	
	var selectedGroupName = $('#selectedGroupName').val();
	if(selectedGroupName!=undefined && selectedGroupName!=""){
		populateMultiSelect("#availableApp");
	}
	$('.saveDelApprovers').off('click').on('click',function(e){
		e.preventDefault();
		$('#saveProcess').show();
		$(".groupName-error").empty().addClass("hide").removeClass("show");
		$.ajax({
			type: 'POST',
			url: contextURL+'/int/siteadmin/saveBusinessDelegates.action',
			dataType: 'html',
			data: $("#createDelegateConfigForm").serialize(), // serializes the form's elements.
			processdata: true,
			success: function(data){
			
				if(siteNameDeleg!=undefined && siteNameDeleg!=""){
					$('#SelectedApp').hide();
					$('#approverGroups').find('option:eq(0)').attr('selected', true);
					$('#approversDivId').hide();
				}
				if(selectedGroupName!=undefined && selectedGroupName!=""){
					$('#SelectedApp').empty();
					$('#selectedGroupName').find('option:eq(0)').attr('selected', true);
					$('#saveApprovers').hide();
					$('#delDivID').empty().html(data);
					var dlgMsg = $("#dlgSuccessMsg").val();
					if(dlgMsg != undefined && dlgMsg !=""){
						$(".groupUpdate-success").removeClass("hide").addClass("show");
						$(".delegateSuccess").text(dlgMsg);
						$(".groupUpdate-success").show();
						$(".groupName-invalid").removeClass("show").addClass("hide");
						$(".groupInvalid").text("");
						$(".groupName-invalid").hide();
					}
				}
				$('#saveProcess').hide();
			},
			error: function (xhr, textStatus, errorThrown ) {				
				var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());				
				if(errorMsg!=undefined && errorMsg!=""){
					$('.curDelErrorDiv').show();
				}
				$('.curDelError').text(errorMsg).show();
				$('#saveProcess').hide();
		    }
		});

	});
	
	$('.inputBoxMS').attr('style', function(i, style) {
	    return style.replace(/width[^;]+;?/g, '');
	});
});
   

function populateMultiSelect(selectedRow){
	
	$(selectedRow).multiselect();
	
	// only if the function is available...
	if ($.fn.themeswitcher) {
		$('#switcher')
			.before('<h4>Use the themeroller to dynamically change look and feel</h4>')
			.themeswitcher();
	}
}
