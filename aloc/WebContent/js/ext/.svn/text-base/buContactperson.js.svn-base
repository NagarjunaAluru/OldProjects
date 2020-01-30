/**
 * @author arijit.biswas
 */

$(document).ready(function() {
	$('a.lookup').off('click').on('click',function(e){
		e.preventDefault();
		e.stopImmediatePropagation();
		var scrollTopValue = $(this).closest(".row").offset().top;
		var url = $(this).attr('href');
		var lookupError = $(this).siblings(".lookup-error");
		if(lookupError == undefined || $(this).siblings(".lookup-error").length == 0){
			lookupError = $(this).closest('div.row').find(".lookup-error");
		}
		$(lookupError).empty().addClass("hide").removeClass("show");
		var dataValue = $(this).siblings(".lookup-filterValue").val();
		var lookupField = $(this).siblings(".lookup-filterValue");
		var userDataLookup = $(e.target).siblings('.businessContactClass').val();
		if(dataValue == undefined && $(this).siblings(".lookup-filterValue").length == 0){
			dataValue = $(this).closest('.form-row').find('.lookup-filterValue').val();
			lookupField = $(this).closest('.form-row').find('.lookup-filterValue');
			userDataLookup = $(e.target).closest('.form-row').find('.businessContactClass').val();
		}
		if($.trim(dataValue) != ''){
			if(userDataLookup != undefined && userDataLookup != '' && userDataLookup == 'BUC') {
  				if(dataValue.indexOf(",") == -1)	{
  					if(dataValue.length < 7 )	{
  						$(lookupError).text("Please provide SSO(at least 7 digits)/FirstName , LastName (at least 2 characters each )").removeClass("hide").addClass("show");
  			  			return false;
  					}}
  				else {
  					var dataValueArray = dataValue.split(",");
  					if(dataValueArray.length == 2)	{
  						var nameLengthCheck = false;
  						$.each(dataValueArray, function(index, name) {
  							var nameTrim = $.trim(name);
  							if(nameTrim == '' || (nameTrim != '' && nameTrim.length < 2))	{
  								nameLengthCheck = true;
  							}
  						});
  						if(nameLengthCheck == true) {
  							$(lookupError).text("Please provide SSO(at least 7 digits)/FirstName , LastName (at least 2 characters each )").removeClass("hide").addClass("show");
  							return false;
  						}else {
  							bucLastName = dataValueArray[0];
  							bucFirstName = dataValueArray[1];
  							dataValue ='';
  						}}else {
  	  						$(lookupError).text("Please provide SSO(at least 7 digits)/FirstName , LastName (at least 2 characters each )").removeClass("hide").addClass("show");
  		  			  		return false;
  	  					}}}
			var indicator = $(this).siblings(".indicator");
			if(indicator == undefined || $(this).siblings(".indicator").length == 0){
				indicator = $(this).closest('div.row').find(".indicator");
			}
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
					$(lookupField).val('');
				},error: function (xhr, textStatus, errorThrown ) {
  					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
  					$(lookupError).text(errorReason).removeClass("hide").addClass("show");
  		  			return false;
  				}
			});
		}else{
			$(lookupError).text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
			return false;
		}
		return false;
	});
	if (window.PIE) {
		$('.btn').each(function() {
			PIE.attach(this);
		});
	}
});