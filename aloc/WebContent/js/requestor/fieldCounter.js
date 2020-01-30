$(document).ready(function() {
	
	// Registering Mandatory Count refresh listeners for form input types.
	$('body').off('focusin focusout', 'input[type="text"], div.mandatory input[type="text"]').on('focusin focusout', 'input[type="text"].mandatory, div.mandatory input[type="text"]', fieldModifiedListener);
	
	$('body').off('focusin focusout', 'textarea.mandatory, div.mandatory textarea').on('focusin focusout', 'textarea.mandatory, div.mandatory textarea', fieldModifiedListener);
	
	$('body').off('change', 'select.mandatory, div.mandatory select').on('change', 'select.mandatory, div.mandatory select', fieldModifiedListener);
	
	$('body').off('click checked', 'input[type="radio"].mandatory, div.mandatory input[type="radio"]').on('click checked', 'input[type="radio"].mandatory, div.mandatory input[type="radio"]', fieldModifiedListener);
	
	$('body').off('change', 'input[type="checkbox"].mandatory, div.mandatory input[type="checkbox"]').on('change', 'input[type="checkbox"].mandatory, div.mandatory input[type="checkbox"]', fieldModifiedListener);
	
	// Subscribe to the queue '/fieldCounter/refreshSection'; to accept section refresh requests
	$.subscribe('/fieldCounter/refreshSection', function(event, sectionId) {
		refreshSectionCount(sectionId);
	});
	
	// Subscribe to the queue '/fieldCounter/refreshParentSection'; to accept section refresh requests for specified fields
	$.subscribe('/fieldCounter/fieldsModified', function(event, selector) {
		fieldsModified(selector);
	});
	
	// Subscribe to queue '/fieldCounter/hideCount'; to clear the count display
	$.subscribe('/fieldCounter/hideCount', function(event, data) {
		var sectionId = $("#"+data.id).parents('.fieldcount_panel').attr('id');
		$('#' + sectionId).parent().find('.requiredCounter').remove();
	});
});

/*
 * The is listener method to refresh the mandatory count; if any field is changed.
 */
function fieldModifiedListener(e) {
	var sectionId = $(e.target).parents('.fieldcount_panel').attr('id');
	refreshSectionCount(sectionId);
}

/*
 * This method refreshes the mandatory count of sepecified section.
 */
function refreshSectionCount(sectionId) {
	if(sectionId == null || sectionId == undefined) {
		return;
	}
	var totalFieldCount = 0;
	var filledFieldCount = 0;
	$('#' + sectionId).find('.mandatory').each(function() {
		if($(this).parents('.fieldcount_panel').get(0).id  == sectionId) {
			totalFieldCount++;
			if(checkValue(this)) {
				filledFieldCount++;
			}
		} 
	});
	
	// Create Render area; if not existed
	if($('#' + sectionId).parent().find('.requiredCounter').length == 0) {
		$('#' + sectionId).before('<p class="requiredCounter"><strong>Required Fields</strong>&nbsp;&nbsp;<span class="filledMandatoryCount">' + filledFieldCount + '</span> / <span class="totalMandatoryCount">' + totalFieldCount + '</span></p>');
	} else {
		$('#' + sectionId).parent().find('.totalMandatoryCount').first().text(totalFieldCount);
		$('#' + sectionId).parent().find('.filledMandatoryCount').first().text(filledFieldCount);
	}
	if(totalFieldCount > 0 && filledFieldCount == totalFieldCount ){
		$('#' + sectionId).parent().find('.requiredCounter').css('color', '#4E7595');;
	}else{
		$('#' + sectionId).parent().find('.requiredCounter').css('color', '#AE2C2C');;
	}
}

/*
 */
function checkValue(field) {
	if($(field).is('div')) {
		var found = false;
		$(field).find(':input').each(function() {
			if(checkValue(this)) {
				found = true;
				return false;	// No need to check remaining elements
			}
		});
		return found;
	}
	
	// If field is radio button or checkbox
	if($(field).is('input[type="radio"], input[type="checkbox"]')) {
		return $(field).is(':checked');
	}
	
	if($(field).val() == '' || $(field).val() == undefined) {
		return false;
	}
	return true;
}
/*
 * This function makes the specified fields mandatory
 */
function makeMandatory(selector) {
	addRemoveMandatory(selector, true);
}

/*
 * This function removes the mandatory class from the specified fields
 */
function removeMandatory(selector) {
	addRemoveMandatory(selector, false);
}

/*
 */
function addRemoveMandatory(selector, add) {
	this.sections = [];
	var funRef = this;
	$(selector).each( 
		function() {
			if(add == true && !$(this).hasClass('mandatory')) {
				$(this).addClass('mandatory');
			} else if(add == false) {
				$(this).removeClass('mandatory');
			}
			
			var sectionId = $(this).parents('.fieldcount_panel').attr('id');
			if(sectionId != undefined && $.inArray(sectionId, funRef.sections) < 0) {
				funRef.sections.push(sectionId);
			}
		}
	);
	
	if(this.sections.length > 0){
		$.each(this.sections, function(index, sectionId) {
			refreshSectionCount(sectionId);
		});
	}
}

/*
 * 
 */
function fieldsModified(selector) {
	this.sections = [];
	var funRef = this;
	$(selector).each( 
		function() {
			var sectionId = $(this).parents('.fieldcount_panel').attr('id');
			if(sectionId != undefined && $.inArray(sectionId, funRef.sections) < 0) {
				funRef.sections.push(sectionId);
			}
		}
	);
	
	if(this.sections.length > 0){
		$.each(this.sections, function(index, sectionId) {
			refreshSectionCount(sectionId);
		});
	}
}