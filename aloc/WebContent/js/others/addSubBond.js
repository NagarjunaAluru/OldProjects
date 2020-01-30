/**
 * @author arijit.biswas
 */

$(document).ready(function(){
	$(".selectBondType").off('change').on('change',function (e) {
		e.stopImmediatePropagation();
		var selectedSubBond = $(this).closest('td').find('.selectSubBondType');
		var indicator = $(this).siblings('.indicator');
		var selectedBondValue = $(this).val();
		if ((selectedBondValue == "2") || (selectedBondValue == "3") || (selectedBondValue == "4")) {
			$(indicator).show();
			$.ajax({
				type: 'POST',
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
		}
	});
	
	$(".selectSubBondType").off('change').on('change',function (e) {
		$(this).siblings('.selectedSubBondType').val($(this).val());
	});
	
});