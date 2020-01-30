/**
 * @author arijit.biswas
 */ 
$(document).ready(function(){	
	
	$(document).keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			return false;
		}	
	});
	
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
	
	tableParser();
	myTransactionSort();
	allRequestSort();
	draftSort();
	modelSort();
	bundleSort();
	treasuryBidSort();
	bankBidSort();
	bankIssuanceSort();
	brokerIssuanceSort();
	historicalSort();	
	basicSearchInDashboard();
	advanceSearchInDashboard();
	
	$('body').off('change', '#financial, #industrial').on('change','#financial, #industrial', function(e) {
		e.stopImmediatePropagation();
		 var financialCheck=$('#financial').is(":checked");
		 var industrialCheck = $('#industrial').is(":checked");
		 var selSiteList = "";
			 $.ajax({
				 	type: "POST",
		            url: contextURL+'/int/admin/getSites.action',
		            dataType: 'html',
		            data: {financialCheck : financialCheck, industrialCheck: industrialCheck, selSiteList : selSiteList},
		            processdata: true,
		            success: function(data) {
		            	$("#siteSelection").empty().append(data);
		            }
		        });
	});
	
	$('body').off('click', '.resetDefaultOrdering').on('click','.resetDefaultOrdering', function(e) {
		var sorting = [[0,1]];
		$(e.currentTarget).closest('div#searchSort').next('table.sortable').find('tbody tr').each(function() {
			if($(e.currentTarget).hasClass('innerRow')){
				$(e.currentTarget).prev('tr').find('#arrow').removeClass("up");
				$(e.currentTarget).prev('tr').find('#arrow').addClass("down");
				$(e.currentTarget).remove();
			}
		});
		$(e.currentTarget).closest('div#searchSort').next('table.sortable').trigger("sorton",[sorting]);
	});
	
	$('body').off('click', '.tBPResetDefaultOrdering').on('click','.tBPResetDefaultOrdering', function(e) {
		var sorting = [[1,1]];
		$(e.currentTarget).closest('div#searchSort').next('table.sortable').find('tbody tr').each(function() {
			if($(e.currentTarget).hasClass('innerRow')){
				$(e.currentTarget).prev('tr').find('#arrow').removeClass("up");
				$(e.currentTarget).prev('tr').find('#arrow').addClass("down");
				$(e.currentTarget).remove();
			}
		});
		$(e.currentTarget).closest('div#searchSort').next('table.sortable').trigger("sorton",[sorting]);
	});
	
	$('body').off('change', '#defaultView').on('change','#defaultView', function(e) {
		var defaultViewValue = $('#defaultView :selected').val();
		var url = contextURL +"/int/dashboard/saveDefaultView.action";
		var formData = {defaultView:defaultViewValue};
		$(".expandViewError").hide();
		$(".defaultViewIndicator").show();
		$.ajax({
			type: "POST",
            url: url,
            dataType: 'text',
            data: formData,
            success: function(response) {
            	$(".defaultViewMsg").removeClass("hide").addClass("show");
            	$(".defaultViewSuccessMsg").removeClass("hide").addClass("show");
            	$(".defaultViewTextSuccess").text(response).removeClass("hide").addClass("show");
            	$(".defaultViewIndicator").hide();
            },
            error: function (xhr, textStatus, errorThrown ) {
				var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
				$(".expandViewError").find('div.errorContent').html(errorReason);
				$(".expandViewError").show().focus();
				$(".defaultViewIndicator").hide();
		    }
		});
	});
	
	$('body').off('click', '#report tr.shown td:first-child div#arrow').on('click','#report tr.shown td:first-child div#arrow', function(e) {
		e.stopImmediatePropagation();
		var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
		var workFlowstageId = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
		var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
		var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
		var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
		var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
		var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
		var sitePrefix = $.trim($(e.currentTarget).closest('tr').find('.sitePrefix').val());
		var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
		if(amendmentId == undefined || amendmentId =='')
			amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
		var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
		var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
		var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
		var arrow = $(e.currentTarget);
		$(".expandViewError").hide();
		if($(arrow).hasClass('down')){
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
			$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
			$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'MYTRANSACTIONS',workFlowstageId : workFlowstageId, wfid :wfid, 
				                                   queueName : queueName, procedureName : procedureName, stageName : stageName,instrumentTypeId : instrumentTypeId,
				                                   sitePrefix : sitePrefix,amendmentId : amendmentId}, function(response, status, xhr) {
				if (status == "error") {
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".expandViewError").find('div.errorContent').html(errorReason);
					$(".expandViewError").show().focus();
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				    $(arrow).removeClass("up");
					$(arrow).addClass("down");
					$(e.currentTarget).parent('tr').remove();
				}else if(status == "success"){
					$(this).html(response);
				}
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			});
			$(arrow).removeClass("down");
			$(arrow).addClass("up");
			
		}else if($(arrow).hasClass('up')){
			$(e.currentTarget).closest('tr').next('tr').remove();
			$(arrow).removeClass("up");
			$(arrow).addClass("down");
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
		}
	});

	$('body').off('click', '#allRequests tr.shown td:first-child div#arrow').on('click','#allRequests tr.shown td:first-child div#arrow', function(e) {
		e.stopImmediatePropagation();
		var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
		var workFlowstageId = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
		var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
		var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
		var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
		var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
		var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
		var sitePrefix = $.trim($(e.currentTarget).closest('tr').find('.sitePrefix').val());
		var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
		if(amendmentId == undefined || amendmentId =='')
			amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
		var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
		var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
		var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
		var arrow = $(e.currentTarget);
		$(".expandViewError").hide();
		if($(arrow).hasClass('down')){
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
			$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
			$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'ALLREQUESTS',workFlowstageId : workFlowstageId, wfid :wfid, 
                                                   queueName : queueName, procedureName : procedureName, stageName : stageName,instrumentTypeId : instrumentTypeId,
                                                   sitePrefix : sitePrefix, amendmentId : amendmentId}, function(response, status, xhr) {
				if (status == "error") {
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".expandViewError").find('div.errorContent').html(errorReason);
					$(".expandViewError").show().focus();
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				    $(arrow).removeClass("up");
					$(arrow).addClass("down");
					$(e.currentTarget).parent('tr').remove();
				}else if(status == "success"){
					$(this).html(response);
				}
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			});
			$(arrow).removeClass("down");
			$(arrow).addClass("up");
		}else if($(arrow).hasClass('up')){
			$(e.currentTarget).closest('tr').next('tr').remove();
			$(arrow).removeClass("up");
			$(arrow).addClass("down");
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
		}
	});
	
	$('body').off('click', '#tableDrafts tr.shown td:first-child div#arrow').on('click','#tableDrafts tr.shown td:first-child div#arrow', function(e) {
		e.stopImmediatePropagation();
		var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
		var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
		var designatedForBundling =  $.trim($(e.currentTarget).closest('tr').find('.designatedForBundling').val());
		var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
		var workFlowstageId = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
		var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
		var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
		var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
		var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
		var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
		var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
		if(amendmentId == undefined || amendmentId =='')
			amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
		var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
		var arrow = $(e.currentTarget);
		$(".expandViewError").hide();
		if($(arrow).hasClass('down')){
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
			$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
			$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'DRAFTS',instrumentTypeId : instrumentTypeId, designatedForBundlingFlag : designatedForBundling,
												   workFlowstageId : workFlowstageId, wfid :wfid,queueName : queueName, procedureName : procedureName, stageName : stageName,
												   amendmentId : amendmentId},
			  function(response, status, xhr) {
				if (status == "error") {
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".expandViewError").find('div.errorContent').html(errorReason);
					$(".expandViewError").show().focus();
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				    $(arrow).removeClass("up");
					$(arrow).addClass("down");
					$(e.currentTarget).parent('tr').remove();
				}else if(status == "success"){
					$(this).html(response);
				}
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			});
			$(arrow).removeClass("down");
			$(arrow).addClass("up");
		}else if($(arrow).hasClass('up')){
			$(e.currentTarget).closest('tr').next('tr').remove();
			$(arrow).removeClass("up");
			$(arrow).addClass("down");
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
		}
	});
	
	/*
	* This Method is used to retrieve all requests information for selected Bundle
	*/
	$('body').off('click', '#tableBundles tr.shown td:first-child div#arrow').on('click','#tableBundles tr.shown td:first-child div#arrow', function(e) {
		e.stopImmediatePropagation();
		var bundleId = $.trim($(e.currentTarget).closest('tr').find('.bundleId').val());
		var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
		var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
		var arrow = $(e.currentTarget);
		var url = contextURL +"/int/dashboard/getAllRequestInfoForSelBundle.action?rowIdValue="+rowIdValue;
		$(".expandViewError").hide();
		if($(arrow).hasClass('down')){
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
			$(e.currentTarget).closest('tr').after('<tr class="innerRow"><td colspan="8" id="innerRow'+rowIndexValue+'"></td></tr>');
			$("#innerRow"+rowIndexValue).load(url,{bundleId : bundleId}, function(response, status, xhr) {
				if (status == "error") {
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".expandViewError").find('div.errorContent').html(errorReason);
					$(".expandViewError").show().focus();
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				    $(arrow).removeClass("up");
					$(arrow).addClass("down");
					$(e.currentTarget).parent('tr').remove();
				}else if(status == "success"){
					$(this).html(response);
				}
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			});
			$(arrow).removeClass("down");
			$(arrow).addClass("up");
		}else if($(arrow).hasClass('up')){
			$(e.currentTarget).closest('tr').next('tr').remove();
			$(arrow).removeClass("up");
			$(arrow).addClass("down");
			$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
		}
	});	
	
	/*
	* This Method is used to retrieve Treasury Bid Process details for selected request
	*/
	$('body').off('click', '#tableBidProcessT tr.shown td:first-child div#arrow').on('click','#tableBidProcessT tr.shown td:first-child div#arrow', function(e) {
			e.stopImmediatePropagation();
			var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
			var stage = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
			var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
			var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
			var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
			var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
			var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
			var bankBidId = $.trim($(e.currentTarget).closest('tr').find('.bankBidId').val());;
			var bidFlag = $.trim($(e.currentTarget).closest('tr').find('.bidFlag').val());
			var url = contextURL +"/int/dashboard/getTreasuryBidRequestContactInfo.action";
			var arrow = $(e.currentTarget);
			var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
			var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
			$(".expandViewError").hide();
			if($(arrow).hasClass('down')){
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
				$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
				$("#innerRow"+rowIndexValue).load(url,{requestId : requestId,dashboardType : 'TREASURYBIDPROCESS',stage : stage,wfid : wfid,queueName : queueName,
					   procedureName : procedureName,stageName : stageName,instrumentTypeId : instrumentTypeId,
					   bankBidId : bankBidId,bidFlag : bidFlag}, function(response, status, xhr) {
					if (status == "error") {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".expandViewError").find('div.errorContent').html(errorReason);
						$(".expandViewError").show().focus();
						$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
					    $(arrow).removeClass("up");
						$(arrow).addClass("down");
						$(e.currentTarget).parent('tr').remove();
					}else if(status == "success"){
						$(this).html(response);
					}
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				});
				$(arrow).removeClass("down");
				$(arrow).addClass("up");
			}else if($(arrow).hasClass('up')){
				$(e.currentTarget).closest('tr').next('tr').remove();
				$(arrow).removeClass("up");
				$(arrow).addClass("down");
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			}
	});	
	
		$('body').off('click', '#tableBidProcessB tr.shown td:first-child div#arrow').on('click','#tableBidProcessB tr.shown td:first-child div#arrow', function(e) {
			e.stopImmediatePropagation();
			var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
			var stage = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
			var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
			var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
			var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
			var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
			var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
			var bankBidId = $.trim($(e.currentTarget).closest('tr').find('.bankBidId').val());;
			var bidFlag = $.trim($(e.currentTarget).closest('tr').find('.bidFlag').val());
			var bankName = $.trim($(e.currentTarget).closest('tr').find('.bankName').val());
			var bankCountryName=$.trim($(e.currentTarget).closest('tr').find('.bankCountryName').val());
			var bidReplyId = $.trim($(e.currentTarget).closest('tr').find('.bidReplyId').val());
			var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
			var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
			var arrow = $(e.currentTarget);
			var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
			$(".expandViewError").hide();
			if($(arrow).hasClass('down')){
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
				$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
				$("#innerRow"+rowIndexValue).load(url,{requestId : requestId,dashboardType : 'BANKBIDPROCESS',stage : stage,wfid : wfid,queueName : queueName,
					   procedureName : procedureName,stageName : stageName,instrumentTypeId : instrumentTypeId,bidReplyId : bidReplyId,
					   bankBidId : bankBidId,bidFlag : bidFlag ,bankName : bankName,bankCountryName : bankCountryName}, function(response, status, xhr) {
					if (status == "error") {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".expandViewError").find('div.errorContent').html(errorReason);
						$(".expandViewError").show().focus();
						$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
					    $(arrow).removeClass("up");
						$(arrow).addClass("down");
						$(e.currentTarget).parent('tr').remove();
					}else if(status == "success"){
						$(this).html(response);
					}
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				});
				$(arrow).removeClass("down");
				$(arrow).addClass("up");
			}else if($(arrow).hasClass('up')){
				$(e.currentTarget).closest('tr').next('tr').remove();
				$(arrow).removeClass("up");
				$(arrow).addClass("down");
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			}
	});	
	
		$('body').off('click', '#tableBankPendingIssuance tr.shown td:first-child div#arrow').on('click','#tableBankPendingIssuance tr.shown td:first-child div#arrow', function(e) {
		    e.stopImmediatePropagation();
		    var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
			var stage = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
			var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
			var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
			var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
			var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
			var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
			var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
			if(amendmentId == undefined || amendmentId =='')
				amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
			var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
			var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
			var arrow = $(e.currentTarget);
			var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
			$(".expandViewError").hide();
			if($(arrow).hasClass('down')){
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
				$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
				$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'TREASURYBANKPENDINGINCE',stage : stage,wfid : wfid,queueName : queueName,
					   procedureName : procedureName,stageName : stageName,instrumentTypeId : instrumentTypeId,
					   amendmentId : amendmentId}, function(response, status, xhr) {
					if (status == "error") {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".expandViewError").find('div.errorContent').html(errorReason);
						$(".expandViewError").show().focus();
						$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
					    $(arrow).removeClass("up");
						$(arrow).addClass("down");
						$(e.currentTarget).parent('tr').remove();
					}else if(status == "success"){
						$(this).html(response);
					}
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				});
				$(arrow).removeClass("down");
				$(arrow).addClass("up");
			}else if($(arrow).hasClass('up')){
				$(e.currentTarget).closest('tr').next('tr').remove();
				$(arrow).removeClass("up");
				$(arrow).addClass("down");
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			}
	});	
	
		$('body').off('click', '#tableBankHistoricalTrans tr.shown td:first-child div#arrow').on('click','#tableBankHistoricalTrans tr.shown td:first-child div#arrow', function(e) {
		    e.stopImmediatePropagation();
		    var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
			var stage = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
			var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
			var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
			var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
			var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
			var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
			var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
			if(amendmentId == undefined || amendmentId =='')
				amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
			var state = $.trim($(e.currentTarget).closest('tr').find('.state').val());
			var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
			var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
			var arrow = $(e.currentTarget);
			var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
			$(".expandViewError").hide();
			if($(arrow).hasClass('down')){
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
				$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
				$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'TREASURYBANKHIST',stage : stage,wfid : wfid,queueName : queueName,
					   procedureName : procedureName,stageName : stageName,instrumentTypeId : instrumentTypeId,
					   amendmentId : amendmentId,state : state}, function(response, status, xhr) {
					if (status == "error") {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".expandViewError").find('div.errorContent').html(errorReason);
						$(".expandViewError").show().focus();
						$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
					    $(arrow).removeClass("up");
						$(arrow).addClass("down");
						$(e.currentTarget).parent('tr').remove();
					}else if(status == "success"){
						$(this).html(response);
					}
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				});
				$(arrow).removeClass("down");
				$(arrow).addClass("up");
			}else if($(arrow).hasClass('up')){
				$(e.currentTarget).closest('tr').next('tr').remove();
				$(arrow).removeClass("up");
				$(arrow).addClass("down");
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			}
	});	
	
		$('body').off('click', '#tableBrokerPendingIssuance tr.shown td:first-child div#arrow').on('click','#tableBrokerPendingIssuance tr.shown td:first-child div#arrow', function(e) {
		    e.stopImmediatePropagation();
			var requestId = $.trim($(e.currentTarget).closest('tr').find('.requestId').val());
			var stage = $.trim($(e.currentTarget).closest('tr').find('.stage').val());
			var wfid = $.trim($(e.currentTarget).closest('tr').find('.wfid').val());
			var queueName = $.trim($(e.currentTarget).closest('tr').find('.queueName').val());
			var procedureName = $.trim($(e.currentTarget).closest('tr').find('.procedureName').val());
			var stageName = $.trim($(e.currentTarget).closest('tr').find('.stageName').val());
			var instrumentTypeId = $.trim($(e.currentTarget).closest('tr').find('.instrumentId').val());
			var amendmentId = $.trim($(e.currentTarget).closest('tr').find('.amendmentId').val());
			if(amendmentId == undefined || amendmentId =='')
				amendmentId = $.trim($(e.currentTarget).closest('tr').find('.riderId').val());
			var rowIdValue = $.trim($(e.currentTarget).parent('td').attr("id"));
			var rowIndexValue = $(e.currentTarget).closest('tr')[0].rowIndex;
			var arrow = $(e.currentTarget);
			var url = contextURL +"/int/RequestContactInfoDashboardRefData.action?rowIdValue="+rowIdValue;
			$(".expandViewError").hide();
			if($(arrow).hasClass('down')){
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').show();
				$(e.currentTarget).closest('tr').after('<tr class="'+rowIdValue+'Inner innerRow"><td colspan="10" class="'+rowIdValue+'Color" id="innerRow'+rowIndexValue+'"></td></tr>');
				$("#innerRow"+rowIndexValue).load(url,{requestId : requestId, dashboardType : 'TREASURYBANKPENDINGINCE',stage : stage,wfid : wfid,queueName : queueName,
					   procedureName : procedureName,stageName : stageName,instrumentTypeId : instrumentTypeId,
					   amendmentId : amendmentId}, function(response, status, xhr) {
					if (status == "error") {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".expandViewError").find('div.errorContent').html(errorReason);
						$(".expandViewError").show().focus();
						$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
					    $(arrow).removeClass("up");
						$(arrow).addClass("down");
						$(e.currentTarget).parent('tr').remove();
					}else if(status == "success"){
						$(this).html(response);
					}
					$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
				});
				$(arrow).removeClass("down");
				$(arrow).addClass("up");
			}else if($(arrow).hasClass('up')){
				$(e.currentTarget).closest('tr').next('tr').remove();
				$(arrow).removeClass("up");
				$(arrow).addClass("down");
				$(e.currentTarget).closest('tr').find('.dashboardExpandViewProcess').hide();
			}
	});	
	
	/*On Click*/
	$('body').off('click', '.collapse').on('click','.collapse', function(e) {
		$(e.currentTarget).parent().find('.section_flip').removeClass('section_active');
		$(e.currentTarget).parent().find('.section_panel').slideUp();
		$(window).scrollTop($(e.currentTarget).parent().position().top-10);
	});
	
		/*Code between here will only run when the document is ready*/
	$('body').off('click', 'a#addInstrumentST').on('click','a#addInstrumentST', function(e) {
			var newInstrumentPurpose = parseInt($('#newInstrumentPurpose').val());
			$("table#instrumentST tr:last").after('<tr class="newInstrumentPurpose"></tr>');
			var url = contextURL+'/int/dashboard/addInstrumentPurpose.action?newInstrumentPurpose='+(newInstrumentPurpose+1);
			$('.newInstrumentPurpose').load(url).removeClass('newInstrumentPurpose');
			$('#newInstrumentPurpose').val(newInstrumentPurpose + 1);
			return false;
		});
		
	$('body').off('click', 'a#addPole').on('click','a#addPole', function(e) {
			var newPole = parseInt($('#newPole').val());
			$("table#pole tr:last").after('<tr class="newPole"></tr>');
			var url = contextURL+'/int/dashboard/addPole.action?newPole='+(newPole+1);
			$('.newPole').load(url).removeClass('newPole');
			$('#newPole').val(newPole + 1);
			return false;
		});

	$('body').off('click', 'a#addInstrumentC').on('click','a#addInstrumentC', function(e) {
			var newInstrumentCurrency = parseInt($('#newInstrumentCurrency').val());
			$("div#instrumentC").children("div.form-row").last().after('<div class="form-row newInstrumentCurrency"></div>');
			var url = contextURL+'/int/dashboard/addInstrumentCurrency.action?newInstrumentCurrency='+(newInstrumentCurrency+1);
			$('div.newInstrumentCurrency').load(url).removeClass('newInstrumentCurrency');
			$('#newInstrumentCurrency').val(newInstrumentCurrency + 1);
			return false;
		});
		
	$('body').off('click', 'a#addCountryI').on('click','a#addCountryI', function(e) {
			var newIssuanceCountry = parseInt($('#newIssuanceCountry').val());
			$("div#countryI").children("div.form-row").last().after('<div class="form-row newIssuanceCountry"></div>');
			var url = contextURL+'/int/dashboard/addIssuanceCountry.action';
			var data = {newIssuanceCountry:(newIssuanceCountry+1)};
			$('div.newIssuanceCountry').load(url,data).removeClass('newIssuanceCountry');
			$('#newIssuanceCountry').val(newIssuanceCountry + 1);
			return false;
		});	
		
	$('body').off('click', 'a#addBondSub-Bond').on('click','a#addBondSub-Bond', function(e) {
			var newSubBond = parseInt($('#newSubBond').val());
			$("table#bondSubBondTable tr:last").after('<tr class="newSubBond"></tr>');
			var url = contextURL+'/int/dashboard/addSubBond.action';
			var data = {newSubBond:(newSubBond+1)};
			$('tr.newSubBond').load(url,data).removeClass('newSubBond');
			$('#newSubBond').val(newSubBond + 1);
			return false;
		});	
	
		/*ADVANCED SEARCH*/ 
	$('body').off('click', 'a.advanceSearch').on('click','a.advanceSearch', function(e) {
			e.stopImmediatePropagation();
			var dashboardType = $(e.currentTarget).attr('id');
			if(dashboardType == 'MYTRANSACTIONS' || dashboardType == 'ALLREQUESTS' || dashboardType == 'DRAFTS'){
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('div.mtard').removeClass('hide');
			}
			if(dashboardType == 'MODEL'){
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('div.model').removeClass('hide');
			}
			if(dashboardType == 'BUNDLES'){
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('div.bundles').removeClass('hide');
			}
			if(dashboardType == 'MYTRANSACTIONS' || dashboardType == 'ALLREQUESTS' || dashboardType == 'DRAFTS' || dashboardType == 'BUNDLES' || dashboardType.search('BIDPROCESS') != -1 || dashboardType.search('PENDINGINCE') != -1 || 
					dashboardType.search('HIST') != -1){
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('div.bidProcess').removeClass('hide');
			}
			$('#applicantCountryCd_widget,#beneficiaryCountryCd_widget').next('input').addClass('span2');
			if($(e.currentTarget).siblings('div#arrow').hasClass('down')){
				$(e.currentTarget).siblings('div#arrow').removeClass('down').addClass('up');
				var financialCheck=$('#financial').is(":checked");
				if(financialCheck!=undefined && financialCheck==false){
					financialCheck=null;
				 }	
				var industrialCheck = $('#industrial').is(":checked");
				if(industrialCheck!=undefined && industrialCheck==false){
					industrialCheck=null;
				}
				var selSiteList = $('#rightSelSitesId').val();
				$.ajax({
					type: "POST",
		            url: contextURL+'/int/admin/getSites.action',
		            dataType: 'html',
		            data: {financialCheck : financialCheck, industrialCheck: industrialCheck, selSiteList : selSiteList},
		            processdata: true,
		            success: function(data) {
		            	$("#siteSelection").empty().append(data);
		            }
		        });
				var issuingBankName = $('#issuingBanksCd').val();
				var relationshipBankName = $('#relationShipBanksCd').val();
				$.ajax({
					type: "POST",
		            url: contextURL+'/int/dashboard/getAllIssuingBanks.action',
		            dataType: 'html',
		            data: {},
		            processdata: true,
		            success: function(data) {
		            	$("#issuingBankPanel").empty().append(data);
		            	$('#issuingBanksCd_widget').val(issuingBankName);
		            	$("#issuingBanksCd").val(issuingBankName);
		            	$('#relationShipBanksCd_widget').val(relationshipBankName);
		            	$("#relationShipBanksCd").val(relationshipBankName);
		            }
		        });
				var issuingSuretyName = $("#issuingSuretyCd").val();
				$.ajax({
					type: "POST",
		            url: contextURL+'/int/dashboard/getAllSuretyNames.action',
		            dataType: 'html',
		            data: {},
		            processdata: true,
		            success: function(data) {
		            	$("#suretyFeeNamesDiv").empty().append(data);
		            	$('#issuingSuretyCd').siblings('input').val(issuingSuretyName);
		            	$("#issuingSuretyCd").val(issuingSuretyName);
		            }
		        });
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").slideDown();
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_flip').addClass('section_active');
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_flip').next('hr.h2-hr').show();
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_panel').slideDown();
				showHideinAdvanceSearch();
			}else if($(e.currentTarget).siblings('div#arrow').hasClass('up')){
				$(e.currentTarget).siblings('div#arrow').removeClass('up').addClass('down');
				$("#siteSelection").empty();
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").slideUp();
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_flip').removeClass('section_active');
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_flip').next('hr.h2-hr').hide();
				$(e.currentTarget).parents('.form-row').siblings("div.filterMsg").find('.section_panel').slideUp();
			}
		});	
		
	$('body').off('click', 'h3#atAGlance').on('click','h3#atAGlance', function(e) {
			if($(e.currentTarget).siblings('div#atAGlanceArrow').hasClass('down')){
				$(e.currentTarget).siblings('div#atAGlanceArrow').removeClass('down').addClass('up');
				$(e.currentTarget).parent('#glance').children("div.boxGlance").slideDown();
			}else if($(e.currentTarget).siblings('div#atAGlanceArrow').hasClass('up')){
				$(e.currentTarget).siblings('div#atAGlanceArrow').removeClass('up').addClass('down');
				$(e.currentTarget).parent('#glance').children("div.boxGlance").slideUp();
			}
		});
	$('body').off('click', '#atAGlanceArrow').on('click','#atAGlanceArrow', function(e) {
			if($(e.currentTarget).hasClass('down')){
				$(e.currentTarget).removeClass('down').addClass('up');
				$(e.currentTarget).parent('#glance').children("div.boxGlance").slideDown();
			}else if($(e.currentTarget).hasClass('up')){
				$(e.currentTarget).removeClass('up').addClass('down');
				$(e.currentTarget).parent('#glance').children("div.boxGlance").slideUp();
			}
		});
				
		$('body').off('click', '.instrTypes').on('click','.instrTypes', function(e) {
			if($(".instrTypes").length == $(".instrTypes:checked").length) {
				$(".checkall").attr("checked", "checked");
			} else {
				$(".checkall").removeAttr("checked");
			}
			showHideinAdvanceSearch();
			
		});
		
		$('body').off('click', '.checkall').on('click','.checkall', function(e) {
			$('.instrTypes').attr('checked', e.currentTarget.checked);
			showHideinAdvanceSearch();
		});
		 
		$('body').off('keydown', '#searchCriteriaText').on('keydown','#searchCriteriaText', function(e) {
			if (e.which === 13) {
				e.preventDefault();
				if($(e.currentTarget).val() != undefined && $.trim($(e.currentTarget).val()) != ''){
					$("a#basicSearch").click();
				}
			}
		});
		
		$('body').off('click', '.popBtn').on('click','.popBtn', function(e) {
			/*Code between here will only run when the a link is clicked and has a name of addRow*/
			$('.popBox').each(function() {
				$(this).hide();
			});
			var popBoxId = $(this).parent().find('.popBox').attr('id');
			var requestId = $.trim($(this).closest("tr").find(".requestId").val());
			var instrumentTypeId = $.trim($(this).closest("tr").find(".instrumentId").val());
			var alocrecordNumber = "";
			if(instrumentTypeId != undefined && instrumentTypeId == '5'){
				alocrecordNumber = $.trim($(this).closest("tr").find(".amendmentId").val());
			}else if(instrumentTypeId != undefined && instrumentTypeId == '6'){
				alocrecordNumber = $.trim($(this).closest("tr").find(".riderId").val());
			}
			
			var url = contextURL +"/int/ActionLogDashboardRefData.action";
			$.ajax({
				type: "POST",
				url: url,
				dataType: 'html',
				data: {requestId : requestId,InstrumentTypeId : instrumentTypeId,alocrecordNumber : alocrecordNumber},
				success: function(data){
					if ($("#"+popBoxId).find('table').length>0){
						$("#"+popBoxId).find('table').remove();
						$("#"+popBoxId).append(data);
					}else{
						$("#"+popBoxId).append(data);
					}
					$("#"+popBoxId).slideToggle();
				}
			});
		});
		
		$('body').off('click', 'a.popupClose').on('click','a.popupClose', function(e) {
			e.preventDefault();
			$(e.currentTarget).parent(".popBox").slideToggle();
			$(e.currentTarget).parent(".ltPopBox").slideToggle();
		});
		
		$('body').off('click', '.deleteModel').on('click','.deleteModel', function(e) {
			e.preventDefault();
			$(e.currentTarget).closest('ul#nav').children('li').removeClass("selected");
			var a = $(e.currentTarget).attr('id').split('_');
			var requestId=a[0];
			var modelName=a[1];
			n = window.open('#deleteModelModal', '_self');
			
			$('#modelNameID', n.document).val(modelName);
			$('#delModID', n.document).val(requestId);
			
			$('#deleteModelModal').modal({show: 'true'});
		});
		
		$('body').off('click', '#nav > li > a').on('click','#nav > li > a', function(e) {
	        if ($(e.currentTarget).parent().hasClass('selected')) {
	            $("#nav .selected div div").slideUp(100); /*hiding popups*/
	            $("#nav .selected").removeClass("selected");
	        } else {
	            $("#nav .selected div div").slideUp(100); /* hiding popups*/
	            $("#nav .selected").removeClass("selected");

	            if ($(e.currentTarget).next(".subs").length) {
	                $(e.currentTarget).parent().addClass("selected"); /*display popup*/
	                $(e.currentTarget).next(".subs").children().slideDown(200);
	            }
	        }
	    }); 
		
		$('body').off('click', '.isTPA').on('click','.isTPA', function(e) {
			var value = $(e.currentTarget).val();
			if(value == 'Yes'){
				$('#triPartyApplicantDiv').show();
			}else{
				$('#triPartyApplicantDiv').hide();
			}
		});
		
		$('body').off('click', '.infoclose').on('click','.infoclose', function(e) {
		    $("#infoMsg").hide("fast");
		});	
		
		$('body').off('click', '.successclose').on('click','.successclose', function(e) {
		    $("#siteMsg").hide("fast");
		    $(".defaultViewMsg").removeClass("show").addClass("hide");
		});	
		
		$('body').off('click', '.errorClose').on('click','.errorClose', function(e) {
		    $("#searchError").hide("fast");
		    $("#expandViewError").hide("fast");
		});
		
		$('body').off('click', '#req').on('click','#req', function(e) {
			$("#request").find(".reqdropdown").removeAttr('style');
			$("#request").show();
			$("#request").find("li#navTabLi1").addClass("active");
			$("#request").find("li#navTabLi2").removeClass("active");
			$("#request").find('#myTabContent').find('div#1').addClass('active in');
			$("#request").find('#myTabContent').find('div#2').removeClass('active in');
			$('#notSureAboutInstrumentID').val(false);
		});
		
		$('body').off('click', '.reqclose').on('click','.reqclose', function(e) {
	        $("#request").hide();
		});
		
		$('body').off('change', '.selectBondType').on('change','.selectBondType', function(e) {
			e.stopImmediatePropagation();
			var selectedSubBond = $(e.currentTarget).closest('td').find('.selectSubBondType');
			var subBondHiddenVal = $(e.currentTarget).closest('td').find('.selectedSubBondType');
			var indicator = $(e.currentTarget).siblings('.indicator');
			var selectedBondValue = $(e.currentTarget).val();
			if ((selectedBondValue == "2") || (selectedBondValue == "3") || (selectedBondValue == "4")) {
				$(indicator).show();
				$.ajax({
					type: "POST",
		            url: contextURL +'/int/requestor/getBondSubTypes.action',
		            dataType: 'json',
		            data: { bondType : selectedBondValue},
		            processdata: true,
		            success: function(data) {
		            	$(selectedSubBond).empty().append("<option value=''>Select...</option>");
		            	for (var i = 0; i < data.result.length; i++) {
		            		$(selectedSubBond).append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
		                }
		            	$(indicator).hide();
		            }
		        });
			}else{
				$(selectedSubBond).empty();
				subBondHiddenVal.val("");
			}
		});
		$('body').off('change', '.selectSubBondType').on('change','.selectSubBondType', function(e) {
			$(this).siblings('.selectedSubBondType').val($(this).val());
		});
		
		navExpand();
		
		if (window.PIE) {
	        $('.modal-header,.boxHead,.errorHead,.errorContent,#infoMsg,#siteMsg,.defaultViewMsg,.btn,.nav-tabs > li > a').each(function() {
	            PIE.attach(this);
	        });
	    }
		
		$('body').off('click', '.selectWinnerInExpView').on('click','.selectWinnerInExpView', function(e) {
			n = window.open('#selectWinner', '_self');

			var bidReplyId = $(e.currentTarget).closest('tr').find('.bidReplyId').val();
			var stage = $(e.currentTarget).closest('tr').find('.stageId').val();
			var wfId = $(e.currentTarget).closest('tr').find('.wfId').val();
			var queueName = $(e.currentTarget).closest('tr').find('.queueNameId').val();
			var procedureName = $(e.currentTarget).closest('tr').find('.procedureNameId').val();
			var stageName = $(e.currentTarget).closest('tr').find('.stageNameId').val();
			var requestId = $(e.currentTarget).closest('tr').find('.requestId').val();
			var instrumentTypeId = $(e.currentTarget).closest('tr').find('.instrumentId').val();
			var bundleId = $(e.currentTarget).closest('tr').find('.bundleId').val();
			var issuingBankName = $(e.currentTarget).closest('tr').find('.issuingBankName').val();
			var transmissionPlatform = $(e.currentTarget).closest('tr').find('.swfitFlag').val();
			
			var formData = {bundleId:bundleId,requestId:requestId,instrumentTypeId:instrumentTypeId,issuingBankName:issuingBankName,stage:stage,
			        wfid : wfId, queueName:queueName, procedureName:procedureName ,stageName : stageName,bidReplyId : bidReplyId,transmissionPlatform : transmissionPlatform};
			
			popUpSelectWinner(formData);
		});
		
		$('body').off('click', '.clearFilters').on('click','.clearFilters', function(e) {
			e.stopImmediatePropagation();
			$('.filterMsg').children().find('input[type=text]').val('');
			$('.filterMsg').children().find('input[type=select]').val('');
			$('.filterMsg').children().find('.checkall').attr('checked',false);
			$('.filterMsg').children().find('.instrTypes').attr('checked',false);
			$('.filterMsg').children().find('.triParty').attr('checked',false);
			$('.filterMsg').children().find('.businessSite').attr('checked',false);
			$('.filterMsg').children().find('.RequestStatusCls').val('');
			$('.filterMsg').children().find('.poleSelectCls').val('');
			$('.filterMsg').children().find('.selectSubBondType').empty();
			$('#newPole').val(0);
			$('table#pole tr').each(function()	{
				 if($(this).index() != 0) {
					 $(this).remove();
				 }
  			});
			$('#newInstrumentPurpose').val(0);
			$('table#instrumentST tr').each(function()	{
				 if($(this).index() != 0) {
					 $(this).remove();
				 }
 			});
			$('#newSubBond').val(0);
			$('table#bondSubBondTable tr').each(function()	{
				 if($(this).index() != 0) {
					 $(this).remove();
				 }
 			});
			$('#newInstrumentCurrency').val(0);
			$('#instrCurrencyCd').val('');
			$('#instrCurrencyCd_widget').val('');
			$("div#instrumentC").children("div.form-row").each(function()	{
				$(this).find("div").each(function()	{
					if($(this).index() != 0) {
						$(this).remove();
					}
				});
				if($(this).index() > 2) {
					 $(this).remove();
				 }
			});
			$('#newIssuanceCountry').val(0);
			$('#instrCountryCd').val('');
			$('#instrCountryCd_widget').val('');
			$("div#countryI").children("div.form-row").each(function()	{
				$(this).find("div").each(function()	{
					if($(this).index() != 0) {
						$(this).remove();
					}
				});
				if($(this).index() > 2) {
					 $(this).remove();
				 }
			});
			$('#issuingBanksCd').val('');
			$('#issuingBanksCd_widget').val('');
			$('#relationShipBanksCd').val('');
			$('#relationShipBanksCd_widget').val('');
			$('#issuingSuretyCd').siblings('input').val('');
        	$("#issuingSuretyCd").val('');
			$("div#siteSelection").find("li.ui-state-default").each(function(index) {
				$(this).remove();
			});
			$("div#siteSelection").find("#availableSites").val('');
			$("div#siteSelection").find("div.available").find("div.ui-helper-clearfix").find("span.total").html('Available - 0');
			$("div#siteSelection").find("div.selected").find("div.ui-helper-clearfix").find("span.count").html('Selected - 0');
			showHideinAdvanceSearch();
		});
		
		 $('body').off('keypress', '.bigInt').on('keypress', '.bigInt', function(event) {
				if(this.value!=undefined){
					var charCode = (event.which) ? event.which : event.keyCode;
						    if (charCode < 48 || charCode > 57){
						    	return false;
						    }
						       return true;
				}
			});
		    
		    $('body').off('keypress', '.bigDecimal').on('keypress', '.bigDecimal', function(event) {
				if(this.value!=undefined){
					var keycode = (event.which) ? event.which : event.keyCode;
					 if (keycode < 48 || keycode > 57){
						 if(keycode!=46){
							 return false;}
					}
					return true;
				}
			});
		    
		    $('body').off('keyup', '.autosize').on('keyup', '.autosize', function() {
				if(this.value!=undefined){
					var len = $(this).val().length;
					var remainchar = 400 - len;
					if (len > 400) {
					this.value = this.value.substring(0, 400);
					}
					$(this).parents('div.modal-body').find('.counter').text(remainchar);
				}
			});
		    
		    $('body').off('click', '.deleteExpRequest').on('click','.deleteExpRequest', function(e) {
				var bundleId = $(e.currentTarget).closest('tr').find('.bundleId').val();
				var requestId = $(e.currentTarget).closest('tr').find('.requestId').val();
				var workFlowstageId = $(e.currentTarget).closest('tr').find('.stageId').val();
				var wfid = $(e.currentTarget).closest('tr').find('.wfId').val();
				var queueName = $(e.currentTarget).closest('tr').find('.queueNameId').val();
				var procedureName = $(e.currentTarget).closest('tr').find('.procedureNameId').val();
				var stageName = $(e.currentTarget).closest('tr').find('.stageNameId').val();
				var alocRecordId = $(e.currentTarget).closest('tr').find('.alocRecordId').val();
				var amendmentId = $(e.currentTarget).closest('tr').find('.amendmentId').val();
				var instrumentTypeId = $(e.currentTarget).closest('tr').find('.instrumentTypeId').val();
				var amdRiderExist = $(e.currentTarget).closest('tr').find('.amdRiderExistId').val();
				var paymentsPaid = $(e.currentTarget).closest('tr').find('.paymentsPaidId').val();
				
				var formData = {instrumentTypeId : instrumentTypeId,requestId : requestId, workFlowstageId : workFlowstageId, wfid : wfid,
    			        queueName:queueName, procedureName:procedureName ,stageName : stageName,bundleId:bundleId,alocRecordId:alocRecordId,amendmentId:amendmentId,
    			        amdRiderExist : amdRiderExist,paymentsPaid : paymentsPaid};	
				$(e.currentTarget).closest('tr').find(".expandViewError").hide();
				popUpDeleteRequest(formData);
			});
		   
}); /*DOCUMENT READY FUNCTION ENDS HERE*/   

	function navExpand(){
		tabsWidth = 0;
		tabs = $(".nav-collapse .nav").children().each(function(){
			tabsWidth += $(this).outerWidth();
		});
		$('.navbar').outerWidth(tabsWidth);
		$('.navbar').find('ul.nav').outerWidth(tabsWidth);
	}
/* Advance Search Show Hide Functionality*/
	function showHideinAdvanceSearch() {
		var dashboardType = $('#dashboardViewTypeId').val();
		var checkedValue = new Array();
		var i = 0;
		$(".instrTypes").each(function(){
			if($(this).is(":checked")){
				checkedValue[i] = $(this).val();
			}else if(!$(this).is(":checked")){
				checkedValue.splice(i,1);
			}
			i++;
		});
		showHideInstrumentPurpose(dashboardType,checkedValue);
		showHideBondSub_Bond(dashboardType,checkedValue);
		if(dashboardType == 'MYTRANSACTIONS' || dashboardType == 'ALLREQUESTS' || dashboardType == 'DRAFTS' || dashboardType == 'BUNDLES' || dashboardType.search('BIDPROCESS') != -1 || dashboardType.search('PENDINGINCE') != -1 || 
				dashboardType.search('HIST') != -1){
			if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("4",checkedValue) != -1){
				$('#bundleIdDiv').show();
			}else{
				$("#bundleIdDiv :input").val('');
				$('#bundleIdDiv').hide();
			}
		}else{
			$("#bundleIdDiv :input").val('');
			$('#bundleIdDiv').hide();
		}
		
		if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("5",checkedValue) != -1){
			$("#triP_PL_Flag").show();
			$("#triP_Name").show();
		}else{
			$("#triP_PL_Flag input[type=checkbox]").attr('checked',false);
			$("#triP_Name :input").val('');
			$("#triP_PL_Flag").hide();
			$("#triP_Name").hide();
		}
		if($.inArray("4",checkedValue) != -1){
			$("#conatct_Person").show();
		}
		else{
			$("#conatct_Person :input").val('');
			$("#conatct_Person").hide();
		}
		if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("5",checkedValue) != -1){
			$("#applicantReferenceId").show();
			$("#customerReferenceId").show();
		}
		else{
			$("#applicantReferenceId :input").val('');
			$("#applicantReferenceId").hide();
			$("#customerReferenceId :input").val('');
			$("#customerReferenceId").hide();
		}
		if(dashboardType != 'DRAFTS'){
			if($.inArray("4",checkedValue) != -1){
				$("#paymentDetails").show().addClass('section_active');
				$("#paymentDetails").next('hr.h2-hr').show();
				$("#paymentDetailsPanel").slideDown();
			}else{
				$("#paymentDetails").hide().removeClass('section_active');
				$("#paymentDetails").next('hr.h2-hr').hide();
				$("#paymentDetailsPanel :input").val('');
				$("#paymentDetailsPanel").slideUp();
			}
		}else{
			$("#paymentDetails").hide().removeClass('section_active');
			$("#paymentDetails").next('hr.h2-hr').hide();
			$("#paymentDetailsPanel :input").val('');
			$("#paymentDetailsPanel").slideUp();
		}
		if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("4",checkedValue) != -1 || $.inArray("5",checkedValue) != -1){
			$("#bankDetails").show().addClass('section_active');
			$("#bankDetails").next('hr.h2-hr').show();
			$("#bankDetailsPanel").slideDown();
		}else{
			$("#bankDetails").hide().removeClass('section_active');
			$("#bankDetails").next('hr.h2-hr').hide();
			$("#bankDetailsPanel :input").val('');
			$("#bankDetailsPanel").slideUp();
		}
		if($.inArray("3",checkedValue) != -1 || $.inArray("6",checkedValue) != -1){
			$("#brokerDetails").show().addClass('section_active');
			$("#brokerDetails").next('hr.h2-hr').show();
			$("#brokerDetailsPanel").slideDown();
		}else{
			$("#brokerDetails").hide().removeClass('section_active');
			$("#brokerDetails").next('hr.h2-hr').hide();
			$("#brokerDetailsPanel :input").val('');
			$("#brokerDetailsPanel").slideUp();
		}
		if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("5",checkedValue) != -1){
			$("#econominExpDateDiv").show();
		}else{
			$("#econominExpDateDiv :input").val('');
			$("#econominExpDateDiv").hide();
		}
	}

	function showHideInstrumentPurpose(dashboardType,checkedValue) {
		if(dashboardType == 'MYTRANSACTIONS' || dashboardType == 'ALLREQUESTS' || dashboardType == 'DRAFTS' || 
			dashboardType.search('BIDPROCESS') != -1 || dashboardType.search('PENDINGINCE') != -1 || 
			dashboardType.search('HIST') != -1){
			if($.inArray("1",checkedValue) != -1 || $.inArray("2",checkedValue) != -1 || $.inArray("5",checkedValue) != -1){
				$("#instrPurposeDiv").show();
			}else{
				$("#instrPurposeDiv select").prop('selectedIndex',0);
				$("#instrPurposeDiv").hide();
			}
		}else{
			$("#instrPurposeDiv select").prop('selectedIndex',0);
			$("#instrPurposeDiv").hide();
		}
	}
	function showHideBondSub_Bond(dashboardType,checkedValue) {
		if(dashboardType == 'MYTRANSACTIONS' || dashboardType == 'ALLREQUESTS' || dashboardType == 'DRAFTS' || 
				dashboardType.search('BIDPROCESS') != -1 || dashboardType.search('PENDINGINCE') != -1 || 
				dashboardType.search('HIST') != -1){
				if($.inArray("3",checkedValue) != -1 || $.inArray("6",checkedValue) != -1){
					$("#bondSubBondDiv").show();
					showSubBond();
				}else{
					$("#bondSubBondDiv select").prop('selectedIndex',0);
					$("#bondSubBondDiv").hide();
				}
			}else{
				$("#bondSubBondDiv select").prop('selectedIndex',0);
				$("#bondSubBondDiv").hide();
			}
	}
/*bundle functionality*/ 
	function popUpRemoveRequestFromBundle(requestId,bundleId,alocRecordId) {	 
		  n = window.open('#removeBundle', '_self');
		  $('#modalHiddenBundleId', n.document).val(bundleId);
		  $('#modalHiddenRequestId', n.document).val(requestId);
		  $('#displayBundleId', n.document).text(bundleId);
		  $('#modalRequestId', n.document).text(alocRecordId);	 	
		  $('#removeBundle').modal({		 
			        show: 'true'
		  }); 
		};	
	function popUpRemoveEntireBundle(bundleId) {			
		  n = window.open('#deleteEntireBundle', '_self');
		  $('#deleteBundleId', n.document).text(bundleId);	  	 
		  $('#modalHiddenBundleId', n.document).val(bundleId);		  
		  $('#deleteEntireBundle').modal({		 
			        show: 'true'
			        
		  }); 
		  
		};						
		function popUpSubmitBundle(bundleId,beneficiaryName) {				
			n = window.open('#submitBundle', '_self');
			$('#popupBundleId', n.document).text(bundleId);	
			$('#modalHiddenBundleId', n.document).val(bundleId);	
			$('#popupBeneficiaryName', n.document).text(beneficiaryName);		
			$('#modalHiddenBeneficiaryName', n.document).val(beneficiaryName);				
			var url = contextURL +"/int/bundle/requestsForBundle.action";
			var formData = {bundleId:bundleId, beneficiaryName : beneficiaryName};			
			$.ajax({	
				type: "POST",
				url: url,
				dataType: 'html',
				data: formData,
				success: function(data) {					
				    $("#submitBundle").find('.modal-body').empty().html(data);		
				    $('#submitBundle').modal({		 
						show: 'true'
					});
				}
			});			  
			 
		};	
	function removeBundle(){
		var bundleId = $('#modalHiddenBundleId').val();		
		document.forms[0].method="Post";
		document.forms[0].action = contextURL + '/int/bundle/removeBundle.action?bundleId='+bundleId;
		document.forms[0].submit();
	};			
	
	function removeRequestFromBundle(){
		var bundleId = $('#modalHiddenBundleId').val();
		var requestId = $('#modalHiddenRequestId').val();	
		document.forms[0].method="Post"; 
		document.forms[0].action = contextURL + '/int/bundle/removeRequestFromBundle.action?bundleId='+bundleId+'&requestId='+requestId;
		document.forms[0].submit();
	};	
	
	function submitBundle(){
		var bundleId = $('#modalHiddenBundleId').val();	
		document.forms[0].method="Post";
		document.forms[0].action = contextURL + '/int/bundle/submitBundle.action?bundleId='+bundleId;		
		document.forms[0].submit();
	};	
 

/**
 * Method to select winner from Treasury Bid Process
 * @param requestId
 * @param bundleId
 * @param instrumentTypeId
 */
function popUpSelectWinner(formData){
	$(".expandViewError").hide();	
	var url = contextURL +"/int/dashboard/selectWinnerFromBidprocess.action";
	$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: formData,
			success: function(data) {					
			    $("#selectWinner").find('.modal-body').empty().html(data);	    
			    $('#selectWinner').modal({		 
					show: 'true'
			});
		 },
         error: function (xhr, textStatus, errorThrown ) {
				var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
				$(".expandViewError").find('div.errorContent').html(errorReason);
				$(".expandViewError").show().focus();
		    }
	});		
};

function submitAction(actionType){
	var instrumentTypeId = $('#instrumentId').val();
	$('.transmissionPlatformError').hide();
	if(instrumentTypeId != undefined && instrumentTypeId != '' && (instrumentTypeId == '1' || instrumentTypeId == '2'))
	{
		if(!($('#bidOptionID_SWIFT').is(':checked') || $('#bidOptionID_ALOC').is(':checked'))) {
			$('.transmissionPlatformError').show();
			return false;
		}
	}
	$('#actionTypeId').val(actionType);
}

function popUpDeleteRequest(formData)
{
	var url = contextURL +"/int/dashboard/deleteRequestModel.action";
	$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: formData,
			success: function(data) {
			    $("#deleteRequestModal").empty().html(data);
			    windowOpened = window.open('#deleteRequestModal', '_self');
			    $('#deleteRequestModal').modal({		 
					show: 'true'
			});
		 },
         error: function (xhr, textStatus, errorThrown ) {
				var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
				$(".expandViewError").find('div.errorContent').html(errorReason);
				$(".expandViewError").show().focus();
		 }
	});		
}

function closePopUpDeleteRequest() {
	$("#deleteRequestModal").empty().html('');
	$('#deleteRequestModal').modal('hide');
}

function popUpDeleteRequestWithAmdRider()  {
	var url = contextURL +"/int/dashboard/deleteRequestModel.action";
	$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: $("#deleteRequestForm").serialize(),
			success: function(data) {
				$("#deleteRequestModal").empty().html(data);
				n = window.open('#deleteRequestModal', '_self');
			    $('#deleteRequestModal').modal({		 
					show: 'true'
			});
		 },
         error: function (xhr, textStatus, errorThrown ) {
				var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
				$(".expandViewError").find('div.errorContent').html(errorReason);
				$(".expandViewError").show().focus();
		 }
	});		
}

function showSubBond() {
	var bondTypeCounter= $('#newSubBond').val();
	  if(bondTypeCounter >= 0){
		 
		  $(".selectBondType").each(function(){
				var selectedSubBond = $(this).closest('td').find('.selectSubBondType');
				var selectedSubBondValue = $(this).closest('td').find('.selectedSubBondType').val();
				var selectedBondValue = $(this).val();
				if ((selectedBondValue == "2") || (selectedBondValue == "3") || (selectedBondValue == "4")) {
					$.ajax({
						type: "POST",
						url: contextURL +'/int/requestor/getBondSubTypes.action',
						dataType: 'json',
						data: {  bondType : selectedBondValue},
						processdata: true,
						success: function(data) {
							$(selectedSubBond).empty().append("<option value=''>Select...</option>");
				        	for (var i = 0; i < data.result.length; i++) {
				        		$(selectedSubBond).append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
				            }
				        	 $(selectedSubBond).find('option[value="'+selectedSubBondValue+'"]').attr("selected",true);

						}
				    });
				}
		  });

	  }

}





/////////////////////////////////
//Date Formating function
/////////////////////////////////

Date.prototype.isValid = function () {
    // An invalid date object returns NaN for getTime() and NaN is the only
    // object not strictly equal to itself.
    return this.getTime() === this.getTime();
}; 

function formatDate(element, format) {
	var strDate = $(element).val();
	
	if(strDate == null || strDate == '') {
		return;
	}
	
	var date = new Date(strDate);
	if(!date.isValid()) {
		$(element).val('');
		return;
	}
	
	var settings = {
			days: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
			months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
	};
	
	var str_pad = function(str, len) {

        // make sure argument is a string
        str += '';

        // pad with leading zeroes until we get to the desired length
        while (str.length < len) str = '0' + str;

        // return padded string
        return str;

    };
	
    var result = '',

    // extract parts of the date:
    // day number, 1 - 31
    j = date.getDate(),

    // day of the week, 0 - 6, Sunday - Saturday
    w = date.getDay(),

    // the name of the day of the week Sunday - Saturday
    l = settings.days[w],

    // the month number, 1 - 12
    n = date.getMonth() + 1,

    // the month name, January - December
    f = settings.months[n - 1],

    // the year (as a string)
    y = date.getFullYear() + '';
    
    // iterate through the characters in the format
    for (var i = 0; i < format.length; i++) {

        // extract the current character
        var chr = format.charAt(i);
        
        // see what character it is
        switch(chr) {

            // year as two digits
            case 'y': y = y.substr(2);

            // year as four digits
            case 'Y': result += y; break;

            // month number, prefixed with 0
            case 'm': n = str_pad(n, 2);

            // month number, not prefixed with 0
            case 'n': result += n; break;

            // month name, three letters
            case 'M': f = f.substr(0, 3);

            // full month name
            case 'F': result += f; break;

            // day number, prefixed with 0
            case 'd': j = str_pad(j, 2);

            // day number not prefixed with 0
            case 'j': result += j; break;

            // day name, three letters
            case 'D': l = l.substr(0, 3);

            // full day name
            case 'l': result += l; break;

            // ISO-8601 numeric representation of the day of the week, 1 - 7
            case 'N': w++;

            // day of the week, 0 - 6
            case 'w': result += w; break;

            // English ordinal suffix for the day of the month, 2 characters
            // (st, nd, rd or th (works well with j))
            case 'S':

                if (j % 10 == 1 && j != '11') result += 'st';

                else if (j % 10 == 2 && j != '12') result += 'nd';

                else if (j % 10 == 3 && j != '13') result += 'rd';

                else result += 'th';

                break;

            // This is probably the separator
            default: result += chr;

        }

    }
    $(element).val(result);
}

function tableParser(){
	$.tablesorter.addParser({
        id: 'alocRecNo',
        is:function(s){return false;},
        format: function(s, table, cell) {
        	s= $(cell).find('input[name=requestId]').val();
        	if(s.trim)
        		s=s.trim();
        	s=s.replace(/<A\b[^>]*>(.*?)/g,'');
        	s=s.replace(/<\/A>/g,'');
        	s=s.substring(s.lastIndexOf("-")+1,s.length);
        	return s;
        },
        type: 'numeric'
    });
	
	/* TableSort parser for Bundle Request Count*/
	$.tablesorter.addParser({
        id: 'bundleReq',
        is:function(s){return false;},
        format: function(s, table, cell) {
        	s= $(cell).find('input[name=bundleReqCount]').val();
        	if(s.trim){
        		s=s.trim();}
        	else{
        		s = s.replace(" ","");}
        	if("" === s || "-" === s){
       	  	  return '';}
        	return s;
        },
        type: 'numeric'
    });
	
	/* TableSort parser for Bundle Applicant*/
	$.tablesorter.addParser({
        id: 'bundleAppl',
        is:function(s){return false;},
        format: function(s, table, cell) {
        	if(s.trim){
     	  	  	s = s.trim();}
    		s = s.replace(/[^a-zA-Z]/gi,'');
        	if("" === s || "-" === s){
       	  	  return '';}
        	return s.toLowerCase();
        },
        type: 'text'
    });
	
	/* TableSort parser for amount format: 9,999,999.99*/
	$.tablesorter.addParser({
        id: 'amount',
        is:function(s){return false;},
        format: function(s) {
        	 if( s.trim )
     	  	  	s = s.trim();
     	  	  else
     	  	  	s = s.replace(" ","");
     	  	  if("" === s || "-" === s)
         	  	  return '';	
     	  	  s = s.replace(/[\,]()/g,'');
     	  	  s = s.replace("(", "").replace(")", "");
     	  	  s = Math.round(s);
     	  	  return s;
        },
        type: 'numeric'
    });
	
	/* TableSort parser for state*/
	$.tablesorter.addParser({
        id: 'state',
        is:function(s){return false;},
        format: function(s) {return s.replace('-','');},
        type: 'numeric'
    });
	
	/* TableSort parser for date format: Jan 6, 1978*/	
	$.tablesorter.addParser({
	  id: 'dayMonthYear',
	  is: function(s) {
	      return false;
	  },
	  format: function(s) {
	  	  if( s.trim )
	  	  	s = s.trim();
	  	  else
	  	  	s = s.replace(" ","");
	  	  if("" === s || "--" === s || "-" === s)
    	  	  return '';		
	  	  s=s.replace('<DIVid=arrow class=down></DIV>','');
	  	  s=s.replace(/<IMG\b[^>]*>/g,'');
	  	  s=s.replace('<BR>','');
	  	  var date = s.split(' ');
	      var m = monthNames[date[1]];
	      var d = String(date[0]);
	      if (d.length == 1) {d = "0" + d;}
	      var y = date[2];
	      return '' + y + m + d;
	  },
	  type: 'numeric'
	});
	
	/* TableSort parser added only for Day Month Year format*/
	$.tablesorter.addParser({
		  id: 'dayMonthYearOnly',
		  is: function(s) {
		      return false;
		  },
		  format: function(s) {
		  	  if(s.trim)
		  	  	s = s.trim();
		  	  
		  	  if("" === s || "--" === s || "-" === s)
	    	  	  return '';		
		  	  var date = s.split(' ');
		      var m = monthNames[date[1]];
		      var d = String(date[0]);
		      if (d.length == 1) {d = "0" + d;}
		      var y = date[2];
		      return '' + y + m + d;
		  },
		  type: 'numeric'
		});
	var monthNames = {};
	monthNames["Jan"] = "01";
	monthNames["Feb"] = "02";
	monthNames["Mar"] = "03";
	monthNames["Apr"] = "04";
	monthNames["May"] = "05";
	monthNames["Jun"] = "06";
	monthNames["Jul"] = "07";
	monthNames["Aug"] = "08";
	monthNames["Sep"] = "09";
	monthNames["Oct"] = "10";
	monthNames["Nov"] = "11";
	monthNames["Dec"] = "12";

	$('.date').each(function() {
		// this checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	
	//For default ordering show
	$("a.resetDefaultOrdering").hide();
	$("a.tBPResetDefaultOrdering").hide();
	
	//For tooltip Info
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
}

function myTransactionSort(){
	var defaultSorting = [[0,1]];
	var initialSorting = false;
	
	if($('#report').find('tbody tr').length > 1){
	$("#report").tablesorter({
		headers:{
			0:{sorter:"dayMonthYear"},
			1:{sorter:"alocRecNo"},
			4:{sorter:"amount"}
		}
	}).bind("sortStart", function(e){
		$(this).find('tbody tr').each(function() {
			if($(this).hasClass('innerRow')){
				$(this).prev('tr').find('#arrow').removeClass("up");
				$(this).prev('tr').find('#arrow').addClass("down");
				$(this).remove();
			}
			if($(this).hasClass('odd')){
				$(this).removeClass("odd");
			}
		});
	}).bind("sortEnd", function(e){
		if(initialSorting != false){
			$("a.resetDefaultOrdering").show();
			$(".jump-page").find('.btn-goto-FirstPage').click();
			$(this).find("tr:odd").addClass("odd");
		}
		initialSorting = true;
	});
	
   	//$('#dashboardMain').find('table#report').trigger("sorton",[defaultSorting]);
	}
	
	$("#report tr:odd").addClass("odd");
}
function allRequestSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#allRequests').find('tbody tr').length > 1){
		$("#allRequests").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				1:{sorter:"alocRecNo"},
				4:{sorter:"amount"},
				7:{sorter:"bundleAppl"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
		//$('#dashboardMain').find('table#allRequests').trigger("sorton",[defaultSorting]);
	}
	
	$("#allRequests tr:odd").addClass("odd");
}

function draftSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableDrafts').find('tbody tr').length > 1){
		$("#tableDrafts").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				1:{sorter:"alocRecNo"},
				4:{sorter:"bundleAppl"},
				5:{sorter:"amount"},
				6:{sorter:"bundleAppl"},
				7:{sorter:"bundleAppl"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
		
	   		//$('#dashboardMain').find('table#tableDrafts').trigger("sorton",[defaultSorting]);
		}
	$("#tableDrafts tr:odd").addClass("odd");
}

function modelSort(){
	if($("table#tableModel").find('tbody tr').length > 2){
		$("table#tableModel").tablesorter({
			headers:{
				4:{sorter:"bundleAppl"},
				5:{sorter:"bundleAppl"},
				7:{sorter:"dayMonthYearOnly"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
		});
		}
	$("table#tableModel tr:odd").addClass("odd");
}

function bundleSort(){
	if($('#expandBundle').val() == 'Yes'){
		$("#tableBundles tr.odd td:first-child").click();
	}
	
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableBundles').find('tbody tr').length > 1){
		$("#tableBundles").tablesorter({
			headers:{
				3:{sorter:"bundleAppl"},
				4:{sorter:"dayMonthYearOnly"},
				5:{sorter:"amount"},
				6:{sorter:"bundleReq"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});

	   		//$('#dashboardMain').find('table#tableBundles').trigger("sorton",[defaultSorting]);
		}
	$("#tableBundles tr:odd").addClass("odd");
}

function treasuryBidSort(){
	//var tBPdefaultSorting = [[1,1]];
	var initialSorting = false;
	if($('#tableBidProcessT').find('tbody tr').length > 1){
		$("#tableBidProcessT").tablesorter({
			headers:{
				2:{sorter:"alocRecNo"},
				5:{sorter:"amount"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.tBPResetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
			//$('#dashboardMain').find('table#tableBidProcessT').trigger("sorton",[tBPdefaultSorting]);
	      }
	$("#tableBidProcessT tr:odd").addClass("odd");
	
}
function bankBidSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableBidProcessB').find('tbody tr').length > 1){
		$("#tableBidProcessB").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				2:{sorter:"alocRecNo"},
				5:{sorter:"amount"},
				6:{sorter:"dayMonthYearOnly"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
	   		//$('#dashboardMain').find('table#tableBidProcessB').trigger("sorton",[defaultSorting]);
		}
	$("#tableBidProcessB tr:odd").addClass("odd");
}

function bankIssuanceSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableBankPendingIssuance').find('tbody tr').length > 1){
		$("#tableBankPendingIssuance").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				1:{sorter:"alocRecNo"},
				4:{sorter:"amount"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
	   		//$('#dashboardMain').find('table#tableBankPendingIssuance').trigger("sorton",[defaultSorting]);
		}
	$("#tableBankPendingIssuance tr:odd").addClass("odd");
}
function historicalSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableBankHistoricalTrans').find('tbody tr').length > 1){
		$("#tableBankHistoricalTrans").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				2:{sorter:"alocRecNo"},
				5:{sorter:"amount"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
	   		//$('#dashboardMain').find('table#tableBankHistoricalTrans').trigger("sorton",[defaultSorting]);
		}
	$("#tableBankHistoricalTrans tr:odd").addClass("odd");
}
function brokerIssuanceSort(){
	//var defaultSorting = [[0,1]];
	var initialSorting = false;
	if($('#tableBrokerPendingIssuance').find('tbody tr').length > 1){
		$("#tableBrokerPendingIssuance").tablesorter({
			headers:{
				0:{sorter:"dayMonthYear"},
				1:{sorter:"alocRecNo"},
				5:{sorter:"amount"}
			}
		}).bind("sortStart", function(e){
			$(this).find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					$(this).prev('tr').find('#arrow').removeClass("up");
					$(this).prev('tr').find('#arrow').addClass("down");
					$(this).remove();
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
		}).bind("sortEnd", function(e){
			if(initialSorting != false){
				$("a.resetDefaultOrdering").show();
				$(".jump-page").find('.btn-goto-FirstPage').click();
				$(this).find("tr:odd").addClass("odd");
			}
			initialSorting = true;
		});
	   		//$('#dashboardMain').find('table#tableBrokerPendingIssuance').trigger("sorton",[defaultSorting]);
		}
	$("#tableBrokerPendingIssuance tr:odd").addClass("odd");
}

function advanceSearchInDashboard()
{
	$("a.advanceSearchBtn").each(function() {
		if(!$(this).attr('addAdvanceSearch')) {
			$(this).click(function(e) {
			e.preventDefault();
			$(".searchError").hide();
			var url = $(this).attr('href');
			var dashboardType = $('#dashboardViewTypeId').val();
			$('#advSearchIndicator').show();
			$.ajax({
				   type: "POST",
		           url: url,
		           dataType: 'html',
		           data: $("#advanceSearchFormID").serialize(), // serializes the form's elements.
		           success: function(data)
		           {
		        	   	$('#dashboardMain').empty().html(data);
		        	   	if(dashboardType == 'ALLREQUESTS'){
		        	   		if($('#dashboardMain').find('table#allRequests').find('tbody tr').length > 1){
		        	   			allRequestSort();
		        	   		}
		        	   	}
						$('#advSearchIndicator').hide();
		           },
		           error: function (xhr, textStatus, errorThrown ) {
						$('#advSearchIndicator').hide();
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						/*$(errorReason).find('td').css("border-top","");*/
						$(".searchError").find('div.errorContent').html(errorReason);
						$(".searchError").show().focus();
				    }
		         });
		});
		$(this).attr('addAdvanceSearch', true);
		}
	});
}

function basicSearchInDashboard()
{
	$("a#basicSearch").each(function(){
		if(!$(this).attr('addBasicSearch')) {
			$(this).click(function(e) {
				e.preventDefault();
				$(".searchError").hide();
				var url = $(this).attr('href');
				var dashboardType = $('#dashboardViewTypeId').val();
				$('#searchIndicator').show();
				$.ajax({
					type: "POST",
					url: url,
					dataType: 'html',
					data: $("#basicSearchFormID").serialize(),// serializes the form's elements.
					success: function(data){
						$('#dashboardMain').empty().html(data);
						if(dashboardType == 'ALLREQUESTS'){
		        	   		if($('#dashboardMain').find('table#allRequests').find('tbody tr').length > 1){
		        	   			allRequestSort();
		        	   		}
		        	   	}
						$('#searchIndicator').hide();
					},
					error: function (xhr, textStatus, errorThrown ) {
						$('#searchIndicator').hide();
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						/*$(errorReason).find('td').css("border-top","");*/
						$(".searchError").find('div.errorContent').html(errorReason);
						$(".searchError").show().focus();
				    }
				});
			});
			$(this).attr('addBasicSearch', true);
		}
	});
}

function decCounter(id,fullLength){
	var txtAreaVal = $('#'+id).val(); 
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.counter').text(txtAreaValLen);
	}
}

function imposeMaxLength(Object, MaxLen){
	  return (Object.value.length <= MaxLen);
}

function deleteSelRequestBtn(){
	$('.deleteReasonError').hide();
	var errorFlag = 0;
	if($('#deleteReasonId').val() == undefined || $('#deleteReasonId').val() == ''){
		$('.deleteReasonError').show();
		$('.deleteReasonError').parent('div').addClass('errorBlock');
		errorFlag = 1;
	}
	if(errorFlag == 1){
		return false;
	}else {
		return true;
	}
}