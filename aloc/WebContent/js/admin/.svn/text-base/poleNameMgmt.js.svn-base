    
$(document).ready(function(){
	
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	
	if($('#newPoleIndexId').val() != undefined && ($('#newPoleIndexId').val() != "" && $('#newPoleIndexId').val() != "0"))
	{
		$("#addNewPoleDiv").show();
	}
	$("#poleNamesTable tr:odd").addClass('odd');
	/*
	* Add First Pole Row for Pole Management
	*/
	$("#addFirstPole").click(function(){
		$("#poleNamesTable").show();
		$(".siteMsg").hide();
		var curIndex = 0;
		if($('#newPoleIndexId').val() != undefined && ($('#newPoleIndexId').val() != "" && $('#newPoleIndexId').val() != "0")){
			curIndex = parseInt($('#newPoleIndexId').val());
		}
		var processImg = contextURL+"/img/loading.gif";
		$("table#poleNamesTable").children('tbody').append('<tr class="shown poleNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary savePoleRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelPoleAdd">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePoleProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		var url = contextURL+'/int/admin/addPole.action?curIndex=' + curIndex;
		$('.poleNameRow').load(url, function() {
			$(this).closest('tr').find('.savePoleProcess').show();
			populateMultiSelect(curIndex);
			curIndex = curIndex+1;
			$('#newPoleIndexId').val(curIndex);
			$('.poleNameRow').removeClass('poleNameRow');
		});
     });
	
	/*
	* Add New Pole Row for Pole Management
	*/
	$('.addNewPoleName').each(function() {
		if(!$(this).attr('addPoleRowRegistered')) {
		$(this).click(function() {
		var curIndex = 0;
		if($('#newPoleIndexId').val() != undefined && ($('#newPoleIndexId').val() != "" && $('#newPoleIndexId').val() != "0")){
			curIndex = parseInt($('#newPoleIndexId').val());
		}
		var processImg = contextURL+"/img/loading.gif";
		$('.addNewPoleProcess').show();
		if( curIndex > 0 ){
			$("table#poleNamesTable").children('tbody').children("tr:last").after('<tr class="shown poleNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td></td><td colspan="7"><a href="javascript:;" class="btn-secondary savePoleRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelPoleUpdate">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePoleProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		}
				else if(curIndex == 0)
				{
					$("table#poleNamesTable").children('tbody').append('<tr class="shown poleNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary savePoleRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelPoleUpdate">Cancel</a>'
							+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePoleProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
				}
				var url = contextURL+'/int/admin/addPole.action?curIndex=' + curIndex;
				$('.poleNameRow').load(url, function() {
					populateMultiSelect(curIndex);
					curIndex = curIndex+1;
					$('#newPoleIndexId').val(curIndex);
					$('.poleNameRow').removeClass('poleNameRow');
					$('.addNewPoleProcess').hide();
				});
			});
			$(this).attr('addPoleRowRegistered', true);
			}
		});
		
		/*
		* Edit Pole Name for given Pole
		*/
		$('.editPoleName').off('click').on('click',function(e){
			e.preventDefault();
			var a = $(this).attr('alt').split('_');
			var curIndex=a[0];
			var poleId=a[1];
			$(this).closest('tr.shown').addClass('poleNameRow');
			var processImg = contextURL+"/img/loading.gif";
			$(this).parents('tr').find('.editPoleProcess').show();
			var url = contextURL+'/int/admin/editPole.action' + '?poleId='+poleId+'&curIndex=' + curIndex;
			$('.poleNameRow').after('<tr class="curRowVal"><td></td><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary savePoleRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelPoleUpdate">Cancel</a>'
					+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePoleProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
			$('.poleNameRow').load(url, function() {
				$('.poleNameRow').removeClass('poleNameRow');
				populateMultiSelect(curIndex);
				$(this).parents('tr').find('.editPoleProcess').hide();
			});
		});
		
		/*
		* Add or Update Pole Row for given Pole
		*/
		$('.savePoleRow').off('click').on('click',function(e){
			e.preventDefault();
			var poleId = $.trim($(this).parents('tr.curRowVal').prev('.curRowVal').find('.poleId').val());
			var poleName = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.poleName').val();
			var tempPoleName = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.poleName').val();
			var poleStatus = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.poleStatus:checked').val();
			var curIndex = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.curIndex').val();
			var selectedCountriesCodesArray = $(this).parents('tr.curRowVal').prev('.curRowVal').find('select[name="selectedCountries"]').val();
			var selectedCountriesCodes = '';
			if(selectedCountriesCodesArray != undefined && selectedCountriesCodesArray != "")
			{
				for(var i=0;i < selectedCountriesCodesArray.length ; i++)
				{
					if(selectedCountriesCodes==''){selectedCountriesCodes = selectedCountriesCodesArray[i];}
					else{selectedCountriesCodes = selectedCountriesCodes.concat('_'+selectedCountriesCodesArray[i]);}
				}
			}
			
			if(curIndex == undefined || curIndex == ""){curIndex = 0;}
			$(this).closest('tr').find('.savePoleProcess').show();
			if(poleStatus == undefined){poleStatus = '';}
			if(selectedCountriesCodes == null){selectedCountriesCodes ='';};
			var	url = contextURL+'/int/admin/updatePole.action';
			var data = {
				   	  		'poleNameMgmt.poleId' : poleId,
				   	  		'poleNameMgmt.poleName' : poleName,
				   	  		'poleNameMgmt.poleStatus' : poleStatus,
				   	  		'curIndex' : curIndex,
				   	  		'selectedCountriesCodes' : selectedCountriesCodes
			           };	
			$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, data, function(){ 
				var errorPoleShow = $.trim($(this).find('.poleErrorId').text());
				if(errorPoleShow == 'false')
				{
					$(this).next('tr').remove();
				}
				else if(errorPoleShow == 'true')
				{
					$(this).find('.poleName').val(tempPoleName);
					if(poleStatus == 'Enabled')
						$(this).find('#poleStatusId_Enabled').attr('checked',true);
					else if(poleStatus == 'Disabled')
						$(this).find('#poleStatusId_Disabled').attr('checked',true);
					populateMultiSelect(curIndex);
					$(this).find('select[name="selectedCountries"]').val(selectedCountriesCodesArray);
					$(this).find('.poleId').val(poleId);
					$(this).find('.curIndex').val(curIndex);
					$(this).next('tr').find('.savePoleProcess').hide();
				}
				$("#addNewPoleDiv").show();
			});
		});
		
		/*
		* Cancel selected Pole Row updates for Pole
		*/
		$('.cancelPoleUpdate').off('click').on('click',function(e){
			e.preventDefault();	
			var poleId = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.poleId').val();
			var curIndex = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.curIndex').val();
			if(poleId != undefined && poleId != "")
			{
				var url = contextURL+'/int/admin/cancelPole.action' + '?poleId='+ poleId +'&curIndex=' + curIndex;
				$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
					$(this).next('tr').remove();
				});
			}
			else
			{
				var url = contextURL+'/int/admin/cancelPole.action' + '?curIndex=' + curIndex;
				$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
					$(this).next('tr').remove();
					$(this).remove();
					var poleSize = parseInt($('#newPoleIndexId').val());
					var curPoleIndex = poleSize - 1;
					$('#newPoleIndexId').val(curPoleIndex);
				});
			}
		});	
		
		$
		.extend(
				$.ui.multiselect,
				{
					getter : 'selectedValues enabled isBusy',
					locale : {
						addAll : 'Add all',
						removeAll : 'Remove all',
						itemsCount : 'Selected countries - #{count}',
						itemsTotal : 'Countries - #{count}',
						busy : '&nbsp;&nbsp;&nbsp;&nbsp;please wait...',
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
		
}); // DOCUMENT READY FUNCTION ENDS HERE   

function populateMultiSelect(selectedID){
	
	var poleNameId = "#countries"+selectedID;
	$(poleNameId).multiselect();
	// only if the function is available...
	if ($.fn.themeswitcher) {
		$('#switcher')
			.before('<h4>Use the themeroller to dynamically change look and feel</h4>')
			.themeswitcher();
	}
}
