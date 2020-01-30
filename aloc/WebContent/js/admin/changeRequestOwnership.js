$(document).ready(function(){
	
	var errorShow = $('#errorShowId').val();
	if(errorShow!=undefined && errorShow == 'true'){
		$('#bidReplyPageLevelErrorDivId').show();
		$(".searchSelOwnerRequestsDiv").removeClass("hide").addClass("show");
	}
	
	$("table#selRequestDetailTable tbody tr:odd").addClass("odd");
	
	$(".searchSelOwnerRequests").off("click").on("click", function(e){
		 e.preventDefault();
    	 var url = $(this).attr('href');
    	 var indicator = $(this).siblings(".indicator");
    	 $(indicator).show();
    	 $.ajax({
	           type: "POST",
	           url: url,
	           dataType: 'html',
	           data: $("#currentRequestorSearchForm").serialize(), // serializes the form's elements.
	           success: function(response)
	           {
	        	   $(".searchSelOwnerRequestsDiv").empty().html(response).removeClass("hide").addClass("show");
				   $("#searchSelOwnerRequestsIndicator").hide();
	           }
    	 });
	});
	
	/**
	* select or unselect all Requests for changing ownership
	*/
	$('#checkallRequestsId').off('click').on('click',function(e){
		  var checked_status = this.checked;
		  $(this).closest('table').find('input:checkbox').each(function(){
		    this.checked = checked_status;
		  });
	});

	/**
	* unselect all check if any of check is clicked
	*/
	$('.checkRequestOwnershipUpdate').off('click').on('click',function(e){
		$('#checkallRequestsId').attr('checked',false);
	});
});