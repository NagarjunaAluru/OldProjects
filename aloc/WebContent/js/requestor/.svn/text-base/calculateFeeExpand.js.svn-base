$(document).ready(function() {
	 
	/**
	* Fee Payment Run Eye-Icon Quick View Pop-up
	*/
	$(".quickViewIcon").off('click').on('click',function(e) {
		e.stopImmediatePropagation();
		$('.newboxes').each(function() {
			$(this).hide();
		});
		var process = $(this).parent('td').find('.feeQuickViewProcess');
		process.show();
		var popupBoxId = $(this).siblings('.newboxes').attr('id');
		var ALOCRecordNumber = $.trim($(this).text());
		var url = contextURL +"/int/apm/getFeeSummaryQuickView.action";
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: {ALOCRecordNumber : ALOCRecordNumber},
			success: function(data){
				if ($("#"+popupBoxId).find('#feeSummaryQuickView').length>0){
					$("#"+popupBoxId).find('#feeSummaryQuickView').remove();
					$("#"+popupBoxId).append(data);
				}else{
					$("#"+popupBoxId).append(data);
				}
				$("#"+popupBoxId).slideToggle();
				process.hide();
			},
			complete : function(){
				process.hide();
			}
		});
		
	});
	
	$("a.popClose").off("click").on("click", function(e) {
		e.preventDefault();
		$(this).parent(".newboxes").slideToggle();
	});

});

 