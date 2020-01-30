/**
 * @author arijit.biswas
 */

$(document).ready(function() {
	$('a.lookup').off('click').on('click',function(e){
		e.preventDefault();
		e.stopImmediatePropagation();
		e.stopImmediatePropagation();
		var scrollTopValue = $(this).closest(".row").offset().top;
		var url = $(this).attr('href');
		$(this).siblings(".lookup-error").empty().addClass("hide").removeClass("show");
		var dataValue = $(this).siblings(".lookup-filterValue").val();
		if(dataValue == undefined && $(this).siblings(".lookup-filterValue").length == 0){
			dataValue = $(this).closest('.form-row').find('.lookup-filterValue').val();
		}
		if($.trim(dataValue) != ''){
			var indicator = $(this).siblings(".indicator");
			$(indicator).show();
			$.ajax({
				type: 'POST',
				url: url,
				dataType: 'html',
				data: {filterValue : $.trim(dataValue), scrollTopValue:scrollTopValue},
				success: function(response){
					$('#lookupDiv').empty().append(response);
					$(indicator).hide();
				},
				complete : function(jqXHR, status){
					if(status == "success"){
						$('#mainPage').hide();
						$('#lookupDiv').show();
						$(window).scrollTop(0);
					}else{
						$(indicator).hide();
					}
				},error: function (xhr, textStatus, errorThrown ) {
  					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
  					$(lookupError).text(errorReason).removeClass("hide").addClass("show");
  		  			return false;
  				}
			});
		}else{
			$(this).siblings(".lookup-error").text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
			return false;
		}
		return false;
	});

});