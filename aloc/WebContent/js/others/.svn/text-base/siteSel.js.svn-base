
$(document).ready(function(){
	
	$
	.extend(
			$.ui.multiselect,
			{
				getter : 'selectedValues enabled isBusy',
				locale : {
					addAll : 'Add all',
					removeAll : 'Remove all',
					itemsCount : 'Selected - #{count}',
					itemsTotal : 'Available - #{count}',
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
	
	populateMultiSelect("#availableSites");
}); // DOCUMENT READY FUNCTION ENDS HERE   

function populateMultiSelect(selectedRow){
	
	$(selectedRow).multiselect();
	
	// only if the function is available...
	if ($.fn.themeswitcher) {
		$('#switcher')
			.before('<h4>Use the themeroller to dynamically change look and feel</h4>')
			.themeswitcher();
	}
}