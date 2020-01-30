    
$(document).ready(function(){
	
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	
	if($('#newSuretyIndexId').val() != undefined && ($('#newSuretyIndexId').val() != "" && $('#newSuretyIndexId').val() != "0"))
	{
		$("#addNewSuretyDiv").show();
	}
	$("#suretyNamesTable tr:odd").addClass('odd');    
	/*
	* Add First Surety Row for SuretyCompanyName Management
	*/
	$("#addFirstSurety").click(function(){
		$("#suretyNamesTable").show();
		$(".siteMsg").hide();
		var curIndex = 0;
		if($('#newSuretyIndexId').val() != undefined && ($('#newSuretyIndexId').val() != "" && $('#newSuretyIndexId').val() != "0")){
			curIndex = parseInt($('#newSuretyIndexId').val());
		}
		var processImg = contextURL+"/img/loading.gif";
		$("table#suretyNamesTable").children('tbody').append('<tr class="shown surNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td></td><td><a href="javascript:;" class="btn-secondary saveSurNameRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelSuretyAdd">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveSuretyProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		var url = contextURL+'/int/admin/addSurety.action?curIndex=' + curIndex;
		$('.surNameRow').load(url).removeClass('surNameRow');
		curIndex = curIndex+1;
		$('#newSuretyIndexId').val(curIndex);
     });
	
	/*
	* Add New Surety Row for SuretyCompanyName Management
	*/
	$('.addNewSuretyName').each(function() {
		if(!$(this).attr('addSuretyRowRegistered')) {
		$(this).click(function() {
		var curIndex = 0;
		if($('#newSuretyIndexId').val() != undefined && ($('#newSuretyIndexId').val() != "" && $('#newSuretyIndexId').val() != "0")){
			curIndex = parseInt($('#newSuretyIndexId').val());
		}
		var processImg = contextURL+"/img/loading.gif";
		$('.addNewSuretyProcess').show();
		if( curIndex > 0 ){
			$("table#suretyNamesTable").children('tbody').children("tr:last").after('<tr class="shown surNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td></td><td><a href="javascript:;" class="btn-secondary saveSurNameRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelSuretyUpdate">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveSuretyProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		}
				else if(curIndex == 0)
				{
					$("table#suretyNamesTable").children('tbody').append('<tr class="shown surNameRow curRowVal"></tr><tr class="curRowVal"><td></td><td><a href="javascript:;" class="btn-secondary saveSurNameRow">Apply</a><a href="javascript:;" class=" btn-tertiarycancelSuretyUpdate">Cancel</a>'
							+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveSuretyProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
				}
				var url = contextURL+'/int/admin/addSurety.action?curIndex=' + curIndex;
				$('.surNameRow').load(url, function() {
					$('.surNameRow').removeClass('surNameRow');
					$('.addNewSuretyProcess').hide();
					curIndex = curIndex+1;
					$('#newSuretyIndexId').val(curIndex);
				});
			});
			$(this).attr('addSuretyRowRegistered', true);
			}
		});
		
		/*
		* Edit Surety Name for given SuretyCompanyName
		*/
		$('.editSuretyName').off('click').on('click',function(e){
			e.preventDefault();
			var curIndex = $(this).attr('alt');
			$(this).closest('tr.shown').addClass('surNameRow');
			var processImg = contextURL+"/img/loading.gif";
			$(this).parents('tr').find('.editSuretyProcess').show();
			var url = contextURL+'/int/admin/editSurety.action' + '?curIndex=' + curIndex;
			$('.surNameRow').after('<tr class="curRowVal"><td></td><td></td><td><a href="javascript:;" class="btn-secondary saveSurNameRow">Apply</a><a href="javascript:;" class="btn-tertiary cancelSuretyUpdate">Cancel</a>'
					+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveSuretyProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
			$('.surNameRow').load(url, function() {
				$('.surNameRow').removeClass('surNameRow');
				$(this).parents('tr').find('.editSuretyProcess').hide();
			});
		});
		
		/*
		* Add or Update Surety Row for given SuretyCompanyName
		*/
		$('.saveSurNameRow').off('click').on('click',function(e){
			e.preventDefault();
			var suretyId = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.suretyId').val();
			var suretyName = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.suretyName').val();
			var tempSuretyName = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.suretyName').val();
			var suretyStatus = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.suretyStatus:checked').val();
			var curIndex = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.curIndex').val();
			if(curIndex == undefined || curIndex == ""){curIndex = 0;}
			$(this).closest('tr').find('.saveSuretyProcess').show();
			if(suretyStatus == undefined){suretyStatus = '';}
			var	url = contextURL+'/int/admin/updateSurety.action';
			var data = {
					   	  'suretyMaster.suretyId' : suretyId,
					      'suretyMaster.suretyName' : suretyName,
					      'suretyMaster.suretyStatus' : suretyStatus,
					      'curIndex' : curIndex
			           };
				
			$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, data, function(){ 
					var errorSuretyShow = $.trim($(this).find('.suretyErrorId').text());
					if(errorSuretyShow == 'false')
					{
						$(this).next('tr').remove();
					}
					else if(errorSuretyShow == 'true')
					{
						$(this).find('.suretyName').val(tempSuretyName);
						if(suretyStatus == 'true')
							$(this).find('#suretyStatusId_true').attr('checked',true);
						else if(suretyStatus == 'false')
							$(this).find('#suretyStatusId_false').attr('checked',true);
						$(this).find('.suretyId').val(suretyId);
						$(this).find('.curIndex').val(curIndex);
						$(this).next('tr').find('.saveSuretyProcess').hide();
					}
					$("#addNewSuretyDiv").show();
				});
		});
		
		/*
		* Cancel selected Surety Row updates for SuretyCompanyName
		*/
		$('.cancelSuretyUpdate').off('click').on('click',function(e){
			e.preventDefault();	
			var suretyId = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.suretyId').val();
			var curIndex = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.curIndex').val();
			if(suretyId != undefined && suretyId != "")
			{
				var url = contextURL+'/int/admin/cancelSurety.action' + '?suretyId='+ suretyId +'&curIndex=' + curIndex;
				$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
					$(this).next('tr').remove();
				});
			}
			else
			{
				var url = contextURL+'/int/admin/cancelSurety.action' + '?suretyId='+ suretyId +'&curIndex=' + curIndex;
				$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
					$(this).next('tr').remove();
					$(this).remove();
					var suretySize = parseInt($('#newSuretyIndexId').val());
					var curSuretyIndex = suretySize - 1;
					$('#newSuretyIndexId').val(curSuretyIndex);
				});
			}
		});
		
}); // DOCUMENT READY FUNCTION ENDS HERE   
