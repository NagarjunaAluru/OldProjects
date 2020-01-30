// TEXTAREA MAX LENGHT
function imposeMaxLength(Object, MaxLen){
  return (Object.value.length <= MaxLen);
}

$(document).ready(function() {
	 $('.labelList').hide();
	 $('.downloadDiv').hide();
	 $('.glanceDiv').hide();
	 $('.exit-container').hide();
	 $('.ReviewEdit').hide();

	 decCounterDocument("issuanceDocument0", 80000);
	 decCounterDocument("issuanceDocument1", 80000);
	 decCounter("issuanceDesc0", 100);
	 decCounter("issuanceDesc1", 100);
	 
		var selFirstRadioVal=($('input:radio[name=issuerRadioOption]:checked').val());
		var selRadioVal=($('input:radio[name=optionsRadiosp]:checked').val());
		if((selFirstRadioVal!=undefined && selFirstRadioVal=='download')||(selFirstRadioVal!=undefined && selFirstRadioVal=='uploaddoc')){
			 $('.labelList').show();
			 $('.downloadDiv').show();
			 $('.glanceDiv').show();
			if(selRadioVal!=undefined && selRadioVal=='upload'){
				$('.fixed-container').show();
			}
			if(selRadioVal!=undefined && selRadioVal=='copyPaste'){
				$('.float-container').show();	
			}
			
		}
	  
	    $('.reviewOrRestart input:radio').change(function(){
	 	   var value = $(this).filter('input:checked');
	 		if(value.hasClass('review-condition') ){
	 			 $('.ReviewEdit').hide();
	 			 $('.ReviewBid').show();
	 			
	 		}else{
	 			 $('.ReviewBid').hide();
	 			 $('.ReviewEdit').show();
	 		}		
	 	});
	 		 
	    $('.uploadOrDownLoad input:radio').change(function(){
	 		var value = $(this).filter('input:checked');
	 		if(value.hasClass('download-condition') ){
	 			 $('.labelList').show();
	 			 $('.downloadDiv').show();
	 			 $('.glanceDiv').show();
	 		}else{
	 			 $('#issuerPageLevelErrorDivId').hide();
	 			 $('.labelList').show();
	 			 $('.downloadDiv').hide();
	 			 $('.glanceDiv').show();
	 		}
	 	});	
	    

		 $('.intrest-type-condition1 input:radio').change(function(){
			 	$("#issuerCommentsId").show();
				var value = $(this).filter('input:checked');
					$('.container3').hide();
					$('.container2').hide();
				if(value.hasClass('fixed-condition') ){
					$('#issuerPageLevelErrorDivId').hide();
					$('.exit-container').hide();
					$('.float-container').hide();
					$('.fixed-container').show();
				}else if(value.hasClass('float-condition') )
				{
					$('#issuerPageLevelErrorDivId').hide();
					$('.exit-container').hide();
					$('.fixed-container').hide();
					$('.float-container').show();
				}
				else{
					$('#issuerPageLevelErrorDivId').hide();
					$('.exit-container').show();
					$('.float-container').hide();
					$('.fixed-container').hide();
				}
			});
		
		 $('#suretyFeeNameId').bind('change', function(event) {
				var suretyName=$('#suretyFeeNameId :selected').text();
				$('#suretyFeeName').val(suretyName);
			});
		 
	    $("#selectall").click(function () {
	 	   $('.case').attr('checked', this.checked);
	   });
	    $(".case").click(function(){
	 		 
	 		  if($(".case").length == $(".case:checked").length) {
	 		        $("#selectall").attr("checked", "checked");
	 		   } else {
	 		        $("#selectall").removeAttr("checked");
	 		   }
	 		 
	 	 });	  
	    
	    var pagelevelerror = $('#errorShowId').val();
		if(pagelevelerror!=undefined && pagelevelerror == 'true'){
			$('#issuerPageLevelErrorDivId').show();
		}
		

		$('.autosize').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				var remainchar = 400 - len;
				if (len >= 400) {
				this.value = this.value.substring(0, 400);
				}
				$(this).parents('div.row').find('.counter').text(remainchar);
			}
		});
		
		$('.autosize1').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 100) {
				this.value = this.value.substring(0, 100);
			}
			}
		});
		
		$('.autosize2').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				var remainchar = 200 - len;
				if (len >= 200) {
				this.value = this.value.substring(0, 200);
			}
				$(this).parents('div').find('.counter').text(remainchar);
			}
		});
		
		$('.autosize25').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 250) {
				this.value = this.value.substring(0, 250);
			}
			}
		});
		
		$('.autosize5').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 50) {
				this.value = this.value.substring(0, 50);
			}
			}
		});
		$('.autosize3').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 300) {
				this.value = this.value.substring(0, 300);
			}
			}
		});
		
	    $('.autosize100').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 10000) {
				this.value = this.value.substring(0, 10000);
			}
			}
		});
	    
	    $('.autosize10K').keyup(function() {
			if(this.value!=undefined){
				var len = this.value.length;
				if (len >= 80000) {
				this.value = this.value.substring(0, 80000);
			}
			}
		});
	    
	    
	    
	    function autoTextarea(){
	    	$('textarea.autosize').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea();

	    function autoTextarea1(){
	    	$('textarea.autosize1').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea1();
	    function autoTextarea4(){
	    	$('textarea.autosize10K').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea4();


	    function autoTextarea3(){
	    	$('textarea.autosize3').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea3();

	    function autoTextarea2(){
	    	$('textarea.autosize2').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea2();

	    function autoTextarea5(){
	    	$('textarea.autosize5').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea5();

	    function autoTextarea30(){
	    	$('textarea.autosize30').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea30();

	    function autoTextarea10(){
	    	$('textarea.autosize10').autoResize({
	    		onResize : function() {
	    			$(this).css({opacity:0.8});// On resize:
	    		},
	    		animateCallback : function() {
	    			$(this).css({opacity:1});// After resize:
	    		},
	    		animateDuration : 300, 
	    		minHeight: 30,		
	    		extraSpace : 40 // More extra space:
	    	});
	    }
	    autoTextarea10();



	    function textareaCounter() {
	    	var maxchar;
	    	if($(this).data('max')>=0){
	    		maxchar = $(this).data('max');
	    	}else{
	    		maxchar = 400;
	    	}
	    	//var maxchar = 500
	    	var cnt = $(this).val().length;
	    	var remainingchar = maxchar - cnt;
	    	var counter = $(this).next().next();
	    	var help = $(this).siblings('.help-block');
	    	counter.html(remainingchar);
	    	if(remainingchar > 0){
	    		counter.css('color', '#999999');
	    		help.css('color', '#999999');
	    	}else{
	    		counter.css('color', '#999999');
	    		help.css('color', '#999999');
	    	}
	    	if($(this).hasClass('small')){ //if its a small autosize in the table
	    		if(cnt > 25){
	    			counter.css('top','-2px');
	    		}else if(cnt < 25) {
	    			counter.css('top','29px');
	    		}
	    	}else{
	    		if(cnt > 50){
	    			counter.css('top','-4px');
	    		}else if(cnt < 50) {
	    			counter.css('top','29px');
	    		}
	    	}
	    }
	    $('.autosize').bind('keyup', textareaCounter);


	    function txtCnt3() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 300;
	    	}
	    	var count = $(this).val().length;
	    	var remainingchar3 = mchar - count;
	    	var counter = $(this).next().next();
	    	if(remainingchar3 >= 0){
	    		counter.html(remainingchar3);
	    	}else{
	    		counter.html(0);
	    	}
	    }
	    $('.autosize3').bind('keyup', txtCnt3);



	    function textareaCounter1() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 100;
	    	}
	    	var count = $(this).val().length;
	    	var remainingchar3 = mchar - count;
	    	var counter = $(this).next().next();
	    	if(remainingchar3 >= 0){
	    		counter.html(remainingchar3);
	    	}else{
	    		counter.html(0);
	    	}
	    }
	    $('.autosize1').bind('keyup', textareaCounter1);

	    function textareaCounter100() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 10000;
	    	}
	    	var count = $(this).val().length;
	    	var remainingchar3 = mchar - count;
	    	var counter = $(this).next().next();
	    	if(remainingchar3 >= 0){
	    		counter.html(remainingchar3);
	    	}else{
	    		counter.html(0);
	    	}
	    }
	    $('.autosize100').bind('keyup', textareaCounter100);

	    function txtCnt2() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 200;
	    	}
	    	var cnt = $(this).val().length;
	    	var remainingchar2 = mchar - cnt;
	    	var counter = $(this).next().next();
	    	counter.html(remainingchar2);
	    }
	    $('.autosize2').bind('keyup', txtCnt2);

	    function txtCnt5() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 50;
	    	}
	    	var cnt = $(this).val().length;
	    	var remainingchar5 = mchar - cnt;
	    	var counter = $(this).next().next();
	    	counter.html(remainingchar5);
	    }
	    $('.autosize5').bind('keyup', txtCnt5);

	    function txtCnt10() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 10000;
	    	}
	    	var cnt = $(this).val().length;
	    	var remainingchar10t = mchar - cnt;
	    	var counter = $(this).next().next();
	    	counter.html(remainingchar10t);
	    }
	    $('.autosize10').bind('keyup', txtCnt10);

	    function txtCnt30() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 30;
	    	}
	    	var cnt = $(this).val().length;
	    	var remainingchar30 = mchar - cnt;
	    	var counter = $(this).next().next();
	    	counter.html(remainingchar30);
	    }
	    $('.autosize30').live('keyup', txtCnt30);


	    function txtCnt25() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 250;
	    	}
	    	var cnt = $(this).val().length;
	    	var remainingchar25 = mchar - cnt;
	    	var counter = $(this).next().next();
	    	counter.html(remainingchar25);
	    }
	    $('.autosize25').bind('keyup', txtCnt25);




	    function textareaCounter10K() {
	    	var mchar;
	    	if($(this).data('max')>=0){
	    		mchar = $(this).data('max');
	    	}else{
	    		mchar = 80000;
	    	}
	    	var count = $(this).val().length;
	    	var remainingchar3 = mchar - count;
	    	var counter = $(this).next().next();
	    	if(remainingchar3 >= 0){
	    		counter.html(remainingchar3);
	    	}else{
	    		counter.html(0);
	    	}
	    }
	    $('.autosize10K').bind('keyup', textareaCounter10K);
	     
	    $("a.clearEntries").click(function(){
			$('nav ul li.navLi').removeClass('liactive');
			$('nav ul li.navLi').find('.tabactive').removeClass('tabactive');
			$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;");
			
		});
});



function validateAttachment()
{
	var uploadOrDownloadRadioVal=($('input:radio[name=issuerRadioOption]:checked').val());
	if(uploadOrDownloadRadioVal!=undefined){
		$('#issuerRadioOptionId').val(uploadOrDownloadRadioVal);
	}
	var optOutOrSubmit=($('input:radio[name=optionsRadiosp]:checked').val());
	if(optOutOrSubmit!=undefined){
		$('#optionsRadiospId').val(optOutOrSubmit);
	}
    var atLeastOneIsChecked = $('input:checkbox').is(':checked');
    if(atLeastOneIsChecked!=undefined && atLeastOneIsChecked){
    	$('#issuerPageLevelErrorDivId').hide();
    }
    	return true;
}
	 
function submitAction(actionType){
		$('#actionTypeId').val(actionType);
}

function validateIssuer()
{
	var uploadOrDownloadRadioVal=($('input:radio[name=issuerRadioOption]:checked').val());
	if(uploadOrDownloadRadioVal!=undefined){
		$('#issuerRadioOption').val(uploadOrDownloadRadioVal);
	}
		return true;
}


function decCounter(id,fullLength){
	var txtAreaVal = $('#'+id).val();
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.textareaCounter1').text(txtAreaValLen);
		}
}


function decCounterDocument(id,fullLength){
	var txtAreaVal = $('#'+id).val(); 
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.textareaCounter10K').text(txtAreaValLen);
		}
}



