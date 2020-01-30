$(document).ready(function(){
	
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	
	decCounter("bucBlockReason", 150);
	decCounter("adnBlockReason", 150);
	
	$('.autosize150').off('keyup').on('keyup', function() {
		if(this.value!=undefined){
			var cnt = $(this).val().length;
			var remainingchar150 = 150 - cnt;
			if (cnt > 150) {
				this.value = this.value.substring(0,150);
			}
			$(this).parents('div.txtCnt').find('.counter').text(remainingchar150);
		}
	});
	
	$('#blockBUCSelectedId_BUC').bind("click",function(){
		onclickBlockBUCOption();
	});
	
	$('#blockBUCSelectedId_BUCADN').bind("click",function(){
		onclickBlockBUCOption();
    });
	
	$('#cancelbtn').click(function(){
		$(".simple_overlay").hide();
	});	
	
	if($("#errorBUCId").val() == "true")
	{
		var leftPos = $('.addBUCBlock').position().left;
		$(".simple_overlay").css("left",leftPos+375).show();
		var blockBUCSelectedVal = $.trim($('#blockBUCHiddenId').val());
		
		if(blockBUCSelectedVal == "BUCADN")
		{
			$('#ADNShow').show();
			$('#BUCShow').hide();
		}
		if(blockBUCSelectedVal == "BUC")
		{
			$('#BUCShow').show();
			$('#ADNShow').hide();
		}
	}
	
	$(".addBUCBlock").off("click").on("click", function(e){
		e.preventDefault();
		var leftPos = $(this).position().left;
		var url = contextURL +"/int/admin/addBlockBUC.action";
		$("#addBUCBlockIndicator").show();
		var formData = {};			
		$.ajax({	
			type: "POST",
			url: url,
			dataType: 'html',
			data: formData,
			success: function(data) {					
			    $('.blockBUCRecord').empty().html(data);
			    $("#addBUCBlockIndicator").hide();
			    $(".simple_overlay").css("left",leftPos+375).show();
			}
		});	
	});
	
	$(".validateBUC").off("click").on("click", function(e){
		e.preventDefault();
		var url = contextURL+"/int/admin/validateBUC.action";
		var bucValue = $.trim($('#searchBUCTextId').val());
		$('.bucvalidate-error').empty().addClass("hide").removeClass("show");
		$('.bucadnvalidate-error').empty().addClass("hide").removeClass("show");
		if(bucValue != undefined && bucValue != '' )
		{
			$("#bucValidateIndicator").show();
			var formData = {
					bucValue : bucValue};
			$.ajax({
				type: "POST",
		        url: url,
		        dataType: 'json',
		        data: formData,
		        processdata: true,
		        success: function(data) {
		        	var bucMes = data.result[0].name;
	        		if($.trim(bucMes) == "INVALID BUC")
	        		{
	        			$('#blockBUCValDiv').empty();
	        			$('.bucvalidate-error').text(bucMes).removeClass("hide").addClass("show");
	        		}
	        		else
	        		{
	        			$('#blockBUCValDiv').text(bucValue);
			    		$('#blockNewBUCValDiv').empty().html("This BUC "+bucValue+" will be blocked");
			    		$('.bucvalidate-error').empty().addClass("hide").removeClass("show");
	        		}
	        		$("#bucValidateIndicator").hide();
		        }
			});
		}
		else
		{
			$('.bucvalidate-error').text("BUC is mandatory").removeClass("hide").addClass("show");
		}
	});
	
	$(".validateBUCADN").off("click").on("click", function(e){
		e.preventDefault();
		var url = contextURL+"/int/BUCADNLookup.action";
		var bucValue = $.trim($('#searchBUCTextId').val());
		var adnValue = $.trim($('#searchADNTextId').val());
		$('.bucvalidate-error').empty().addClass("hide").removeClass("show");
		$('.bucadnvalidate-error').empty().addClass("hide").removeClass("show");
		var formData = {
			bucValue : bucValue,
			adnValue : adnValue	};
		if(bucValue != undefined && bucValue != '' && adnValue != undefined && adnValue != ''){
			$("#bucadnValidateIndicator").show();
			$.ajax({
				type: "POST",
		        url: url,
		        dataType: 'json',
		        data: formData,
		        processdata: true,
		        success: function(data) {
		        	if(data.result[0].IBSMessageId != ''){
		        			$('#blockADNValDiv').text(adnValue);
		        			$('.bucadnvalidate-error').empty().addClass("hide").removeClass("show");
		        	}else{
			        		 var ibsMes = data.result[0].IBSMessage;
			        		if($.trim(ibsMes) == "INVALID BUC")
			        		{
			        			$('#blockBUCValDiv').empty();
				        		$('#blockNewBUCValDiv').empty().html("This BUC will be blocked");
				        		$('.bucvalidate-error').text(ibsMes).removeClass("hide").addClass("show");
			        		}
			        		else
			        		{
			        			$('#blockBUCValDiv').text(bucValue);
			        			$('.bucadnvalidate-error').text(ibsMes).removeClass("hide").addClass("show");
			        			$('.bucvalidate-error').empty().addClass("hide").removeClass("show");
			        		}
		        	}
		        	$("#bucadnValidateIndicator").hide();
		        }
		    });
		}
		else
		{
			if(bucValue == undefined || bucValue == '')
			{
				$('.bucvalidate-error').text("BUC is mandatory").removeClass("hide").addClass("show");
			}
			if(adnValue == undefined || adnValue == '')
			{
				$('.bucadnvalidate-error').text("ADN is mandatory").removeClass("hide").addClass("show");
			}
		}
	});
	$('table.table tr:odd').addClass('odd');
});

/**
 * Method to open the popup to select BUC and ADN to be unblocked
 * @param unBlockbucVal
 * @param unBlockadnVal
 */
function popUpUnBlockSelectedBUC(unBlockbucVal,unBlockadnVal)
{
	n = window.open('#unblockSelBUCADN', '_self');
	var url = contextURL +"/int/admin/unBlockSelBUC.action";
	var formData = {unBlockbucVal:unBlockbucVal,unBlockadnVal:unBlockadnVal};			
	$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: formData,
			success: function(data) {					
			    $("#unblockSelBUCADN").find('.modal-body').empty().html(data);	
			    $('#unBlockbucVal', n.document).val(unBlockbucVal);
				$('#unBlockadnVal', n.document).val(unBlockadnVal);
			    $('#unblockSelBUCADN').modal({show: 'true'});
		 }
	});		
}

function onclickBlockBUCOption(){
	if($('#blockBUCSelectedId_BUC').is(':checked')) {
		$('#BUCShow').show();
		$('#ADNShow').hide();
		$('#adnBlockReason').val('');
		$('.counter').text('150');
		$('#searchADNTextId').val('');
		$('.bucadnvalidate-error').empty().addClass("hide").removeClass("show");
	}
	else if($('#blockBUCSelectedId_BUCADN').is(':checked')) {
		$('#ADNShow').show();
		$('#BUCShow').hide();
		$('#bucBlockReason').val('');
	}
}

function searchBlockBUC()
{
	$("#bucSearchIndicator").show();
}

function resetBlockBUC()
{
	$("#bucSearchIndicator").show();
	$("#searchBUCText").val('');
	$("#searchADNText").val('');
}