$(document).ready(function(){

//Set default open/close settings
$('.acc_containerA').hide(); //Hide/close all containers
$('.acc_containerB').hide(); //Hide/close all containers
$('.acc_containerC').hide(); //Hide/close all containers
$('.acc_containerD').hide(); //Hide/close all containers
$('.acc_containerE').show(); //Hide/close all containers


//On Click
$('.acc_triggerA').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_triggerA').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerB').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerC').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerD').removeClass('acc_active').next().slideUp(); 	
		$('.acc_triggerE').removeClass('acc_active').next().slideUp(); 	
		$(this).toggleClass('acc_active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideUp();	
		$('.acc_containerE').slideUp();	
	} else {
		$(this).toggleClass('acc_active').next().slideUp();
	}
	return false; //Prevent the browser jump to the link anchor
});
//On Click
$('.acc_triggerB').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_triggerA').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerB').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerC').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerD').removeClass('acc_active').next().slideUp(); 	
		$('.acc_triggerE').removeClass('acc_active').next().slideUp(); 	
		$(this).toggleClass('acc_active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_containerA').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideUp();
		$('.acc_containerE').slideUp();
	} else {
		$(this).toggleClass('acc_active').next().slideUp();
	}
	return false; //Prevent the browser jump to the link anchor
});
$('.acc_triggerC').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_triggerA').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerB').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerC').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerD').removeClass('acc_active').next().slideUp(); 	
		$('.acc_triggerE').removeClass('acc_active').next().slideUp(); 	
		$(this).toggleClass('acc_active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerD').slideUp();
		$('.acc_containerE').slideUp();
	} else {
		$(this).toggleClass('acc_active').next().slideUp();
	}
	return false; //Prevent the browser jump to the link anchor
});
$('.acc_triggerD').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_triggerA').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerB').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerC').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerD').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerE').removeClass('acc_active').next().slideUp(); 
	
		$(this).toggleClass('acc_active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerE').slideUp();
	} else {
		$(this).toggleClass('acc_active').next().slideUp();
	}
	return false; //Prevent the browser jump to the link anchor
});
$('.acc_triggerE').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_triggerA').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerB').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerC').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerD').removeClass('acc_active').next().slideUp(); 
		$('.acc_triggerE').removeClass('acc_active').next().slideUp(); 
	
		$(this).toggleClass('acc_active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideUp();
	} else {
		$(this).toggleClass('acc_active').next().slideUp();
	}
	return false; //Prevent the browser jump to the link anchor
});


$('#acc_second').click(function(){
		$('.acc_triggerA').removeClass('acc_active'); 
		$('.acc_triggerB').toggleClass('acc_active'); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_triggerC').removeClass('acc_active'); 
		$('.acc_triggerD').removeClass('acc_active'); 
		$('.acc_triggerE').removeClass('acc_active'); 
		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideDown();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideUp();
		$('.acc_containerE').slideUp();
});
$('#acc_third').click(function(){
		$('.acc_triggerA').removeClass('acc_active'); 
		$('.acc_triggerB').removeClass('acc_active'); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_triggerC').toggleClass('acc_active'); 
		$('.acc_triggerD').removeClass('acc_active'); 
		$('.acc_triggerE').removeClass('acc_active'); 

		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideDown();
		$('.acc_containerD').slideUp();
		$('.acc_containerE').slideUp();
});
$('#acc_fourth').click(function(){
		$('.acc_triggerA').removeClass('acc_active'); 
		$('.acc_triggerB').removeClass('acc_active'); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_triggerC').removeClass('acc_active'); 
		$('.acc_triggerD').toggleClass('acc_active'); 
		$('.acc_triggerE').removeClass('acc_active'); 

		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideDown();
		$('.acc_containerE').slideUp();

});
$('#acc_fifth').click(function(){
		$('.acc_triggerA').removeClass('acc_active'); 
		$('.acc_triggerB').removeClass('acc_active'); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_triggerC').removeClass('acc_active'); 
		$('.acc_triggerD').removeClass('acc_active'); 
		$('.acc_triggerE').toggleClass('acc_active'); 

		$('.acc_containerA').slideUp();
		$('.acc_containerB').slideUp();
		$('.acc_containerC').slideUp();
		$('.acc_containerD').slideUp();
		$('.acc_containerE').slideDown();
});

});
