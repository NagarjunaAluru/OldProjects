$(document).ready(function() {
	$('.section_flip:last').addClass('lastSection');
	/*Register handler for sections*/
	$('.section_flip').each(function() {
		if(!$(this).attr('toggleHandlerReg')) {
			$(this).on('click', sectionToggleHandler);
			$(this).attr('toggleHandlerReg', 'true');
		}
	});
	
	/*Enable sections if it is not a section wise save*/
	$('.section_flip').each(function() {
		if(!$(this).hasClass('save_section')) {
			enableSection(this);
		}
	});
	
	/*Open error sections*/
	$('.section_flip').each(function() {
		if(hasErrors(this)) {
			openSection(this);
		}
	});
	
	var activeSections = $('.section_flip.section_active');
	if(!activeSections || activeSections.length == 0) {
		if($('#formatOpen').val()!=undefined && $('#formatOpen').val()!=""){
			var formatSection = $('h2#format');
			var atmtSection = $('h2#attachments');
			enableSection(formatSection);
			openSection(formatSection);
			enableSection(atmtSection);
			openSection(atmtSection);
		}else if($('#openSection').val() == undefined || $('#openSection').val() == ""){
		var firstSection = $('.section_flip:first');
		enableSection(firstSection);
		openSection(firstSection);
		}
	}
	var workingSection = $("#sncWorkingSectionId").val();
	if(workingSection != undefined && workingSection != ''){
		toggleSectionExclusively($("#"+workingSection));
	}
	
	$.subscribe('moveToNextSection', function(event, data) {
		var respText = $(event.originalEvent.request.responseText);
		var isValidationSuccess = $(respText).filter("input#validationSuccess").val();
		if (isValidationSuccess == 'true') {
			var t = $('#' + data.id);
			if(t == data) {
			}
			var sectionPanel = t.parents(".section_panel");
			var sectionFlip = getSectionFlip(sectionPanel);
			moveToNextSection(sectionFlip);
		}
	});
	
	$("#tracksectionDiv").delegate('a', 'click', function() {
		var section = $(this).parent().attr('id');
		var newSectionFlip = $('#mainPage').find('h2#'+section);
		if(isSectionClosed(newSectionFlip)){
			toggleSectionExclusively(newSectionFlip);
		}
		$(newSectionFlip).parent('.form-mod').focus();
	});
	
	 $('.bigDecimal').each(function(){
		var val = $(this).val();
		if(val != undefined && val !="" && val == ".00"){
			$(this).val("0");
		}
	 });
	 
	 $('.negativeBigDecimal').each(function(){
		var val = $(this).val();
		if(val != undefined && val !="" && val == ".00"){
			$(this).val("0");
		}
	 });
	
});

/*
 * sectionToggleHandler
 */
function sectionToggleHandler() {
	if($(this).hasClass('.section_nodata') || hasErrors(this) || !$(this).hasClass('enable_section')) {
		return;
	}
	
	toggleSectionExclusively(this);
}

/*
 * moveToNextSection
 */
function moveToNextSection(sectionFlip) {
	if(!hasErrors(sectionFlip)) {
		var sectionIndex = null;
		$('.section_flip').each(function(index, flip) {
			if($(sectionFlip).attr('id') == $(flip).attr('id')) {
				sectionIndex = index;
				return false;
			}
		});
		
		var nextSectionFlip = $('.section_flip:eq(' + (sectionIndex + 1) + ')');
		if(nextSectionFlip) {
			enableSection(nextSectionFlip);
			if($(nextSectionFlip).hasClass('.section_nodata')) {
				$(nextSectionFlip).removeClass('.section_nodata');
			}
			toggleSectionExclusively(nextSectionFlip);
		}
	} 
}

/**
 * Add the enable_section class for enabling the section in the save section pages
 * @param section
 */
function enableSection(section) {
	if (section && !$(section).hasClass('enable_section')) {
		$(section).addClass('enable_section');
	}
}

/*
 * toggleSectionExclusively
 */
function toggleSectionExclusively(sectionFlip) {
	/*Close other sections if no errors.*/
	var sectionPosition=0;
	if(isSectionClosed(sectionFlip)) {
		$('.section_flip').each(function() {
			if(isSectionOpened(this)){
				sectionPosition = $(this).offset().top;
			}
			if(this != sectionFlip && !hasErrors(this) && !$(this).hasClass('section_noToggle')) {
				closeSection(this);
			}
			
		});
	}
	toggleSection(sectionFlip,sectionPosition);
}

/*
 * toggleSection
 */
function toggleSection(sectionFlip,sectionPosition) {
	if(isSectionOpened(sectionFlip)) {
		closeSection(sectionFlip);
	} else {
		openSection(sectionFlip);
	}
	var currSecPos = getSectionPanel(sectionFlip).offset().top;
	var scrollTopPosition=0;
	if(sectionPosition < currSecPos ){
		if(sectionPosition > 0){
			scrollTopPosition = sectionPosition;
		}else{
			if($(sectionFlip).hasClass('lastSection')){
				scrollTopPosition = currSecPos-150;
			}else{
				scrollTopPosition = currSecPos-150;
			}
		}
	}else{
		scrollTopPosition = currSecPos-150;
	}
	setTimeout(function() { $(window).scrollTop(scrollTopPosition); },1000);
	
}

/*
 * openSection
 */
function openSection(sectionFlip) {
	if(isSectionClosed(sectionFlip)) {
		$(sectionFlip).toggleClass('section_active');
		getSectionPanel(sectionFlip).slideDown();
	}
}

/*
 * closeSection
 */
function closeSection(sectionFlip) {
	if(isSectionOpened(sectionFlip)) {
		$(sectionFlip).toggleClass('section_active');
		getSectionPanel(sectionFlip).slideUp();
	}
}

/*
 * getSectionPanel
 */
function getSectionPanel(sectionFlip) {
	var flipId = $(sectionFlip).attr('id');
	var panelId = flipId + 'Panel';
	return $('#' + panelId);
}

/*
 * getSectionFlip
 */
function getSectionFlip(sectionPanel) {
	var panelId = $(sectionPanel).attr('id');
	var panelIdSuffix = 'Panel';
	var flipId = null;
	if(panelId.indexOf(panelIdSuffix, panelId.length - panelIdSuffix.length) != -1) {
		flipId = panelId.substring(0, panelId.length - panelIdSuffix.length);
	}
	return $('#' + flipId);
}

/*
 * isSectionOpened
 */
function isSectionOpened(sectionFlip) {
	var status = $(sectionFlip).hasClass('section_active');
	return status;
}

/*
 * isSectionClosed
 */
function isSectionClosed(sectionFlip) {
	var status = !isSectionOpened(sectionFlip);
	return status;
}

/* 
 * @param sectionFlip
 */
function hasErrors(sectionFlip) {
	var sectionPanel = getSectionPanel(sectionFlip);
	var errorFields = $(sectionPanel).find('.errorBlock');
	if(errorFields && errorFields.lenght > 0) {
		return true;
	}
	return false;
}

/*
 * preventDoubleSubmit
 */
jQuery.fn.preventDoubleSubmit = function() {
	  jQuery(this).submit(function() {
	    if (this.beenSubmitted) {
	    	//Added alert to remind the user while double click..
	    	alert("Your request has been processed already,Please wait for the redirection.");
	    	return false;
	    }
	    else
	      this.beenSubmitted = true;
	  });
};

/*To Do refactor the code*/ 

$(document).ready(function(){

	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
	window.onhashchange=function(){window.location.hash="no-back-button";};
	
	/*Set default open/close settings*/
	$('.acc_containerA').hide(); 
	$('.acc_containerB').hide(); 
	$('.acc_containerC').hide(); 
	$('.acc_containerD').hide(); 

	$('.acc_containerA').addClass('acc_active').next().show();

	/*On Click*/
	$('.acc_triggerA,.acc_triggerB,.acc_triggerC,.acc_triggerD').click(function(){
		if( $(this).hasClass('acc_active') ) { 
			$(this).removeClass('acc_active');	
			$(this).next().next().hide(); 
		} else {
			$(this).addClass('acc_active');
			$(this).next().next().show();
		}
		return false; 
	});

	$('#acc_second').click(function(){
	 
			$('.acc_triggerB').toggleClass('acc_active'); 

			$('.acc_containerB').hide();
			document.location.href='#second';
	});
	$('#acc_third').click(function(){
			$('.acc_triggerC').toggleClass('acc_active'); 

			$('.acc_containerC').hide();

	});
	$('#acc_fourth').click(function(){

			$('.acc_triggerD').toggleClass('acc_active'); 

			$('.acc_containerD').hide();

	});


	});

