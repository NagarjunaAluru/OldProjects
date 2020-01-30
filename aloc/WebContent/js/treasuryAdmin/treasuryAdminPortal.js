/**
 * 
 */

$(document).ready(function() {

		$("#exnav > li").each(function(){
			$(this).width($(this).width()+25);
		});
		$("#exnav > li > a.tt").click(function () { // binding onclick
			if ($(this).parent().hasClass('selected')) {
				$("#exnav .selected div div").slideUp(100); // hiding popups
				$("#exnav .selected").removeClass("selected");
			} else {
				$("#exnav .selected div div").slideUp(100); // hiding popups
				$("#exnav .selected").removeClass("selected");

				if ($(this).next(".subs").length) {
					$(this).parent().addClass("selected"); // display popup
					$(this).next(".subs").children().slideDown(200);
				}
			}
		});
		
		/**
		 * This is used to close Success message
		 */
		$(".successclose").click(function(){
		    $("#siteMsg").hide("fast");
		});	
	});