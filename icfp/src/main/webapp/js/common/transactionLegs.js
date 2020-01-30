$(document).ready(function() {
		$('.pop').click(function(){
			var id = $(this).attr('href');
			$('#'+id).modal('show');
		 	return false;
		});
	});