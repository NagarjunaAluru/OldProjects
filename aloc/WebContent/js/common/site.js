// TEXTAREA MAX LENGHT
function imposeMaxLength(Object, MaxLen){
  return (Object.value.length <= MaxLen);
}

$(document).keypress(function(event){
	 
	var keycode = (event.keyCode ? event.keyCode : event.which);
	if(keycode == '13'){
		if ($(event.target).is('input, text')) {
	        return false;
	    }
		return true;
	}	
});

$(document).ready(function() {
	$('.checkboxSelectionDiv label').after('<div class="clear"></div>');
	
	 $('.labelList').hide();
	 $('.downloadDiv').hide();
	 $('.glanceDiv').hide();
	 $('.exit-container').hide();
	 $('.ReviewEdit').hide();
	 $('.ReviewBid').hide();
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
	
	
	$("#transactionTable").tablesorter();
	$("#treasuryAuditlogTable").tablesorter();
	$("#fullTransactionTable").tablesorter();
	$("#fullauditTable").tablesorter();
	
	$('body').off('blur', 'input[type="text"],textarea').on('blur', 'input[type="text"], textarea',function(e) {
	    if($(e.target).val().length>0) {
	           var content = $(e.target).val().toUpperCase();
	           if ((content.indexOf("<SCRIPT") !=-1) || (content.indexOf("<\/SCRIPT>") !=-1)) {
	                  alert("Keywords <script> and <\/script> are not allowed.");
	                  $(e.target).focus();
	           }
	    }
	});

	
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
	
	$('.autosize500').keyup(function() {
		if(this.value!=undefined){
			var len = this.value.length;
			var remainchar = 500 - len;
			if (len >= 500) {
			this.value = this.value.substring(0, 500);
			}
			$(this).parents('div.row').find('.counter').text(remainchar);
		}
	});
		

	$('.autosize1').keyup(function() {
		if(this.value!=undefined){
			var len = this.value.length;
			var remainchar = 100 - len;
			if (len >= 100) {
			this.value = this.value.substring(0, 100);
		}
			$(this).parents('div.row').find('.counter').text(remainchar);
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
			var remainchar = 300 - len;
			if (len >= 300) {
			this.value = this.value.substring(0, 300);
		}
			$(this).parents('div.row').find('.counter').text(remainchar);
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
    
    $('body').off('keypress', '.bigInt').on('keypress', '.bigInt', function(event) {
		if(this.value!=undefined){
			var charCode = (event.which) ? event.which : event.keyCode;
				    if (charCode < 48 || charCode > 57){
				    	return false;
				    }
				       return true;
		}
	});
    
    $('body').off('keypress', '.bigDecimal').on('keypress', '.bigDecimal', function(event) {
		if(this.value!=undefined){
			var keycode = (event.which) ? event.which : event.keyCode;
			 if (keycode < 48 || keycode > 57){
				 if(keycode!=46){
					 return false;}
			}
			return true;
		}
	});
    
    $('body').off('keypress', '.negativeBigDecimal').on('keypress', '.negativeBigDecimal', function(event) {
		if(this.value!=undefined){
			var keycode = (event.which) ? event.which : event.keyCode;
			 if (keycode < 48 || keycode > 57){
				 if(keycode!=46 && keycode!=45){
					 return false;}
			}
			return true;
		}
	});
   
	/* MODIFIED SELECT BOX */
	$("#modified").change(function(){
        $('option',this).each(function(){
            var opt = $(this),val = opt.val();            
            if (val == "indus" ) {            
                if(opt.is(":selected")){
					$(".industrialSelectBox").show();
					$(".siteId").show();
					$(".financialSelectBox").hide();
					$(".bankSelectBox").hide();
					$(".treasurySelectBox").hide();
                }
				else{
					//
				}
            }
			if (val == "finan" ) {            
                if(opt.is(":selected")){
					$(".industrialSelectBox").hide();
					$(".financialSelectBox").show();
					$(".siteId").show();
					$(".bankSelectBox").hide();
					$(".treasurySelectBox").hide();					
                }
				else{
					//
				}
            }
			if (val == "bankSite" ) {            
                if(opt.is(":selected")){
					$(".industrialSelectBox").hide();
					$(".financialSelectBox").hide();
					$(".bankSelectBox").show();
					$(".siteId").show();
					$(".treasurySelectBox").hide();					
                }
				else{
					//
				}
            }
			if (val == "trea" ) {            
                if(opt.is(":selected")){
					$(".industrialSelectBox").hide();
					$(".financialSelectBox").hide();
					$(".bankSelectBox").hide();
					$(".treasurySelectBox").show();	
					$(".siteId").show();
                }
				else{
					//
				}
            }			
        }); 
    });
	
	


$('#deliveryP').click(function(){
	   $('#pDelivery').slideDown('fast');
});
$('#deliveryPH').click(function(){
	   $('#pDelivery').slideUp('fast');
});




$('#sendElectronic').click(function() {
	if ($(this).is(':checked')) {
		$("#Recipient").show();
		$("#recipientSsoId").addClass("mandatory");
		$("#recipientEmail").addClass("mandatory");
		fieldsModified('#sendElectronic');
	}
	else {
		$("#Recipient").hide();
		$("#recipientShow").hide();
		$("#recipientShow").find('.form-row').find('p').text('');
		$("#recipientShow").find('.form-row').find('input[type=hidden]').val('');
		$('#recipientSelectionId').val('');
		$('#geRecipient').val('');
		$("#recipientSsoId").removeClass("mandatory");
		$("#recipientEmail").removeClass("mandatory");
		fieldsModified('#sendElectronic');
	}
});


// DELEGATION CONFIGURATION JAVASCRIPTS
$('#riderCB,#sbondCB,#confirmationCB').click(function() {      
    if($(this).is(':checked'))  {
        $('td:nth-child(3),th:nth-child(3)').hide();
		$('td:nth-child(4),th:nth-child(4)').hide();
		$('td:nth-child(5),th:nth-child(5)').hide();
		$('td:nth-child(6),th:nth-child(6)').hide();
		$('td:nth-child(7),th:nth-child(7)').hide();
    }
	else {
		$('td:nth-child(3),th:nth-child(3)').show();
		$('td:nth-child(4),th:nth-child(4)').show();
		$('td:nth-child(5),th:nth-child(5)').show();
		$('td:nth-child(6),th:nth-child(6)').show();
		$('td:nth-child(7),th:nth-child(7)').show();
	}	
});





/* BANK SWIFT CONFIGURATION */
$("#nc1c").hide();
$("#nc2c").hide();
$("#nc3c").hide();
$("#nc4c").hide();
$("#nc5c").hide();
$("#nc6c").hide();
$("#nc7c").hide();
$("#nc8c").hide();
$("#nc9c").hide();
$("#nc10c").hide();
$("#nc11c").hide();
$("#nc12c").hide();

$('#nc1a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc1c").show();
    }
	else {
		$("#nc1c").hide();
	}	
});
$('#nc1b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc1c").hide();
    }
	else {
		$("#nc1c").show();
	}	
});
$('#nc2a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc2c").show();
    }
	else {
		$("#nc2c").hide();
	}	
});
$('#nc2b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc2c").hide();
    }
	else {
		$("#nc2c").show();
	}	
});
$('#nc3a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc3c").show();
    }
	else {
		$("#nc1c").hide();
	}	
});
$('#nc3b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc3c").hide();
    }
	else {
		$("#nc3c").show();
	}	
});
$('#nc4a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc4c").show();
    }
	else {
		$("#nc4c").hide();
	}	
});
$('#nc4b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc4c").hide();
    }
	else {
		$("#nc4c").show();
	}	
});
$('#nc5a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc5c").show();
    }
	else {
		$("#nc5c").hide();
	}	
});
$('#nc5b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc5c").hide();
    }
	else {
		$("#nc5c").show();
	}	
});
$('#nc6a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc6c").show();
    }
	else {
		$("#nc6c").hide();
	}	
});
$('#nc6b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc6c").hide();
    }
	else {
		$("#nc6c").show();
	}	
});
$('#nc7a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc7c").show();
    }
	else {
		$("#nc7c").hide();
	}	
});
$('#nc7b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc7c").hide();
    }
	else {
		$("#nc7c").show();
	}	
});
$('#nc8a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc8c").show();
    }
	else {
		$("#nc8c").hide();
	}	
});
$('#nc8b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc8c").hide();
    }
	else {
		$("#nc8c").show();
	}	
});
$('#nc9a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc9c").show();
    }
	else {
		$("#nc9c").hide();
	}	
});
$('#nc9b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc9c").hide();
    }
	else {
		$("#nc9c").show();
	}	
});
$('#nc10a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc10c").show();
    }
	else {
		$("#nc10c").hide();
	}	
});
$('#nc10b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc10c").hide();
    }
	else {
		$("#nc10c").show();
	}	
});
$('#nc11a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc11c").show();
    }
	else {
		$("#nc11c").hide();
	}	
});
$('#nc11b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc11c").hide();
    }
	else {
		$("#nc11c").show();
	}	
});
$('#nc12a').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc12c").show();
    }
	else {
		$("#nc12c").hide();
	}	
});
$('#nc12b').click(function() {      
    if($(this).is(':checked'))  {
        $("#nc12c").hide();
    }
	else {
		$("#nc12c").show();
	}	
});



//replace .live with .on due to 1.7....
//
//

/*
 Color animation jQuery-plugin
 http://www.bitstorm.org/jquery/color-animation/
 Copyright 2011 Edwin Martin <edwin@bitstorm.org>
 Released under the MIT and GPL licenses.
*/
(function(d){function i(){var b=d("script:first"),a=b.css("color"),c=false;if(/^rgba/.test(a))c=true;else try{c=a!=b.css("color","rgba(0, 0, 0, 0.5)").css("color");b.css("color",a)}catch(e){}return c}function g(b,a,c){var e="rgb"+(d.support.rgba?"a":"")+"("+parseInt(b[0]+c*(a[0]-b[0]),10)+","+parseInt(b[1]+c*(a[1]-b[1]),10)+","+parseInt(b[2]+c*(a[2]-b[2]),10);if(d.support.rgba)e+=","+(b&&a?parseFloat(b[3]+c*(a[3]-b[3])):1);e+=")";return e}function f(b){var a,c;if(a=/#([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})/.exec(b))c=
[parseInt(a[1],16),parseInt(a[2],16),parseInt(a[3],16),1];else if(a=/#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])/.exec(b))c=[parseInt(a[1],16)*17,parseInt(a[2],16)*17,parseInt(a[3],16)*17,1];else if(a=/rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(b))c=[parseInt(a[1]),parseInt(a[2]),parseInt(a[3]),1];else if(a=/rgba\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9\.]*)\s*\)/.exec(b))c=[parseInt(a[1],10),parseInt(a[2],10),parseInt(a[3],10),parseFloat(a[4])];return c}
d.extend(true,d,{support:{rgba:i()}});var h=["color","backgroundColor","borderBottomColor","borderLeftColor","borderRightColor","borderTopColor","outlineColor"];d.each(h,function(b,a){d.fx.step[a]=function(c){if(!c.init){c.a=f(d(c.elem).css(a));c.end=f(c.end);c.init=true}c.elem.style[a]=g(c.a,c.end,c.pos)}});d.fx.step.borderColor=function(b){if(!b.init)b.end=f(b.end);var a=h.slice(2,6);d.each(a,function(c,e){b.init||(b[e]={a:f(d(b.elem).css(e))});b.elem.style[e]=g(b[e].a,b.end,b.pos)});b.init=true}})(jQuery);

(function($){
	
	/* created fixed headers , require jquery dimenions plugins*/
	$.fn.fixedHeader = function(o){
		var s = {adjustWidth: $.fixedHeader.calcWidth};
		if(o) $.extend(s,o);
		
		return this.each(function(){
			var table = $(this); //table
			var tId = this.id;
			
			var scrollBarWidth = $.fixedHeader.getScrollBarWidth();
			var IE6 = $.browser.msie && $.browser.version == '6.0';
			
			//wrap a body container
			var bodyContainer = table.wrap('<div></div>').parent()
				.attr('id', tId + "_body_container")
				.css({
					width: s.width,
					maxHeight: s.height, 
					/* height: s.height, */ //ORIGINAL SETTING
					overflow: 'auto'
				});
			
			//Wrap with an overall container
			var tableContainer = bodyContainer.wrap('<div></div>').parent()
				.attr('id', tId + '_table_container')
				.css('position','relative');

			//clone the header
			var position = table.position();
			var headerContainer = $(document.createElement('div'))
				.attr('id', tId + '_header_container')
				.css({
					width:  bodyContainer.innerWidth() - scrollBarWidth,
					height: table.find('thead').outerHeight(), 
					overflow: 'hidden',
					top: position.top, left:position.left
				})
				.prependTo(tableContainer);
			
			var headerTable = table.clone(true)
				.find('tbody').remove().end()
				.attr('id',tId + "_header")
				.addClass(s.tableClass || table[0].className)
				.css({
					//width: $.browser.msie? table.outerWidth():table.width(), 
					'table-layout':'fixed',
					position:'absolute',
					top:0, left:0
				})
				.append(table.find('thead').clone(true))
				.appendTo(headerContainer);
			
			//sync header width
			var headThs = headerTable.find('th');
			table.find('th').each(function(i){
				headThs.eq(i).css('width', s.adjustWidth(this));
			});
			
			//sync scroll
			var selects = IE6? table.find("select"): null;
			bodyContainer.scroll(function(){
				if(IE6 && selects.size()>0){
					selects.each(function(i){
						this.style.visibility =
							($(this).offset().top - bodyContainer.offset().top) <= table.find("thead").outerHeight() + 10
							? 'hidden':'visible';
					});
				}
				headerTable.css({
					left: '-' + $(this).scrollLeft() + 'px'
				});
			});
			
			//Move it down
			headerContainer.css({
				'position': 'absolute',
				'top': 0
			});
		});
	};
	
	$.fixedHeader = {
		calcWidth: function(th){
			var w = $(th).width();
			var paddingLeft = $.fixedHeader.getComputedStyleInPx(th,'paddingLeft');
			var paddingRight = $.fixedHeader.getComputedStyleInPx(th,'paddingRight');
			var borderWidth = $.fixedHeader.getComputedStyleInPx(th,'borderRightWidth');			
			if($.browser.msie) w = w+borderWidth;
			if($.browser.opera) w = w+borderWidth;
			if($.browser.safari) w = w+paddingLeft+paddingRight+borderWidth*2;
			if($.browser.mozilla && parseFloat($.browser.version) <= 1.8) w=w+borderWidth; //FF2 still got a border-left missing problem, this is the best I can do.
			return w;
		},
		getComputedStyleInPx: function(elem,style){
			var computedStyle = (typeof elem.currentStyle != 'undefined')
				?elem.currentStyle
				:document.defaultView.getComputedStyle(elem, null);
			var val = computedStyle[style];
			val = val? parseInt(val.replace("px","")):0;
			return (!val || val == 'NaN')?0:val;
		},
		getScrollBarWidth: function() { //calculate or get from global the scroll bar width
			if(!$.fixedHeader.scrollBarWidth){ 
				var inner = $(document.createElement('p')).css({width:'100%',height:'100%'});
				var outer = $(document.createElement('div'))
					.css({
						position:'absolute',
						top: '0px',
						left: '0px',
						visibility: 'hidden',
						width: '200px',
						height: '150px',
						overflow: 'hidden'
					})
					.append(inner)
					.appendTo(document.body);
				
				var w1 = inner[0].offsetWidth;
				outer[0].style.overflow = 'scroll';
				var w2 = inner[0].offsetWidth;
				if (w1 == w2) w2 = outer[0].clientWidth;
				document.body.removeChild (outer[0]);
				$.fixedHeader.scrollBarWidth = (w1 - w2);
			}
			return $.fixedHeader.scrollBarWidth;
		}
	};
	
})(jQuery);



	/////////////////////////////////
	// settings
	/////////////////////////////////
	$('.nav .dropdown-menu').dropdown();
	//$("table.sortable").tablesorter();
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	$('.ttip.chart').tooltip();

	$('.tabs').tab();
	$('#table-modal .table').fixedHeader({height: 300});
	
	
	///////////////////////////////// 
	//Create new group
	/////////////////////////////////
	if(!$("#Create").attr('clickEvent')) {
		$("#Create").click(function(){
	           $("#createNewGroup").show();
	     });
		$("#Create").attr('clickEvent', true);
	}
	
	 $(".ViewGrp").click(function(){
           $("#approvers").show();
     });
	 $("#addApp").click(function(){
			// $("#approvers").hide();
           $("#SelectedApp").show();
     });
	 
	 
	 	
	///////////////////////////////// 
	//On click hide/show header
	/////////////////////////////////
	
	
	$(".tripartyY").change(function(){
           $("#private").show();
		   $("#TriPartyApplicant").show();
     });
	 $(".tripartyN").change(function(){
           $("#private").hide();
		   $("#TriPartyApplicant").hide();
     });
	 
	$(".tripartyYCreate").change(function(){
	        $("#privateCreate").show();
	});
	 $(".tripartyNCreate").change(function(){
	        $("#privateCreate").hide();
	});
		 
	$(".tripartyYCopy").change(function(){
	        $("#privateCopy").show();
	});
	$(".tripartyNCopy").change(function(){
	       $("#privateCopy").hide();
	});
		 
	
	$("#req, #req1").click(function(){
		   $("#request").find(".reqdropdown").removeAttr('style');
           $("#request").show();
           if($(this).attr("id") == 'req1'){
        	   $("#request").find(".reqdropdown").css({"top":"100px","left":"70px"});
        	   $("#request").find("li#navTabLi2").addClass("active");
        	   $("#request").find("li#navTabLi1").removeClass("active");
        	   $("#request").find('#myTabContent').find('div#2').addClass('active in');
        	   $("#request").find('#myTabContent').find('div#1').removeClass('active in');
        	   $('#notSureAboutInstrumentID').val(true);
        	   
        	   $("#inside").find(".radio-container").show();
        	   $("#inside").find(".label-container").hide();
        	   $("#inside").hide();
        	   $("#outside").find(".radio-container").show();
        	   $("#outside").find(".label-container").hide();
        	   $("#outside").hide();
        	   $('#2').find('input[type=radio]').attr('checked',false);
        	   $("#ins").show();
           }else if($(this).attr("id") == 'req'){
        	   $("#request").find("li#navTabLi1").addClass("active");
        	   $("#request").find("li#navTabLi2").removeClass("active");
        	   $("#request").find('#myTabContent').find('div#1').addClass('active in');
        	   $("#request").find('#myTabContent').find('div#2').removeClass('active in');
        	   $('#notSureAboutInstrumentID').val(false);
           }
	});
	$(".reqclose").click(function(){
        $("#request").hide();
	});
	
	 
	 
	$(".sblcYes").click(function(){
           $(".sblcYesDiv").show();
		   $(".sblcNoDiv").hide();
     });
	 $(".sblcNo").click(function(){
           $(".sblcYesDiv").hide();
		   $(".sblcNoDiv").show();
     });
	 
	 $(".sblcReqYes").click(function(){
           $(".sblcReqYesDiv").show();
		   $(".sblcReqNoDiv").hide();
     });
	 $(".sblcReqNo").click(function(){
           $(".sblcReqYesDiv").hide();
		   $(".sblcReqNoDiv").show();
     });
	 
	$(".AppGrp").click(function(){
           $("#AvailableApp").show();
     });
	 
	/////////////////////////////////
	// Show hide conditional row
	/////////////////////////////////
	 
	$("#BankN").click(function(){
           $("#bankShow").show();
		   $("#bankClear").show();
     });
	 $("#bankClear").click(function(){
           $("#bankShow").hide();
		   $("#bankClear").hide();
     });
	 
	 $("#LegalG").click(function(){
           $("#LegalGShow").show();
		   $("#LegalGClear").show();
     });
	 $("#LegalGClear").click(function(){
           $("#LegalGShow").hide();
		   $("#LegalGClear").hide();
     });
	 
	 $("#Rec").click(function(){
           $("#RecipientShow").show();
		   $("#RecipientClear").show();
     });
	 $("#RecipientClear").click(function(){
           $("#RecipientShow").hide();
		   $("#RecipientClear").hide();
     });
	 
	 
	 $("#CopyBankN").click(function(){
           $("#CopybankShow").show();
		   $("#CopybankClear").show();
     });
	 $("#CopybankClear").click(function(){
           $("#CopybankShow").hide();
		   $("#CopybankClear").hide();
     });
	 
	 $("#CopyLegalG").click(function(){
           $("#CopyLegalGShow").show();
		   $("#CopyLegalGClear").show();
     });
	 $("#CopyLegalGClear").click(function(){
           $("#CopyLegalGShow").hide();
		   $("#CopyLegalGClear").hide();
     });
	 
	 $("#CopyRec").click(function(){
           $("#CopyRecipientShow").show();
		   $("#CopyRecipientClear").show();
     });
	 $("#CopyRecipientClear").click(function(){
           $("#CopyRecipientShow").hide();
		   $("#CopyRecipientClear").hide();
     });
	 
	 
	 $("#ModifyBankN").click(function(){
           $("#ModifybankShow").show();
		   $("#ModifybankClear").show();
     });
	 $("#ModifybankClear").click(function(){
           $("#ModifybankShow").hide();
		   $("#ModifybankClear").hide();
     });
	 
	 $("#ModifyLegalG").click(function(){
           $("#ModifyLegalGShow").show();
		   $("#ModifyLegalGClear").show();
     });
	 $("#ModifyLegalGClear").click(function(){
           $("#ModifyLegalGShow").hide();
		   $("#ModifyLegalGClear").hide();
     });
	 
	 $("#ModifyRec").click(function(){
           $("#ModifyRecipientShow").show();
		   $("#ModifyRecipientClear").show();
     });
	 $("#ModifyRecipientClear").click(function(){
           $("#ModifyRecipientShow").hide();
		   $("#ModifyRecipientClear").hide();
     });
	 
	 
	 
	 $("#Applicant").click(function(){
           $("#ApplicantShow").show();
		   $("#ApplicantClear").show();
     });
	 $("#ApplicantClear").click(function(){
           $("#ApplicantShow").hide();
		   $("#ApplicantClear").hide();
     });
	 
	 $("#TriParty").click(function(){
           $("#TriPartyShow").show();
		   $("#TriPartyClear").show();
     });
	 $("#TriPartyClear").click(function(){
           $("#TriPartyShow").hide();
		   $("#TriPartyClear").hide();
     });
	 
	  $("#CustomerBeneficiary").click(function(){
           $("#CustomerBeneficiaryShow").show();
		   $("#CustomerBeneficiaryClear").show();
     });
	 $("#CustomerBeneficiaryClear").click(function(){
           $("#CustomerBeneficiaryShow").hide();
		   $("#CustomerBeneficiaryClear").hide();
     });

//////////////////////////////////////////

	$("#geRef").click(function(){
           $("#geRefShow").show();
		   $("#geRefClear").show();
     });
	 $("#geRefClear").click(function(){
           $("#geRefShow").hide();
		   $("#geRefClear").hide();
     });
	 
	$("#cusRef").click(function(){
           $("#cusRefShow").show();
		   $("#cusRefClear").show();
     });
	 $("#cusRefClear").click(function(){
           $("#cusRefShow").hide();
		   $("#cusRefClear").hide();
     });

	/////////////////////////////////
	// Inline edit -- add span with class to the read only blocks value
	/////////////////////////////////
	
	/////////////////////////////////
	//Date picker
	/////////////////////////////////
	$('.date').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	
	
	/////////////////////////////////
	//Date picker - Future Only
	/////////////////////////////////
	$('.dateFutureOnly').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0',
				direction: true
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	$(".dateExpiry").each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0',
				direction: true,
				onSelect: function(format, elements) {
					var year = elements.split("-")[0];
					if(year != undefined && year != '' && year >='2050'){
						$('#econoExpiryDtDiv').show();
					}else{
						$('#econoExpiryDtDiv').hide();
						$('#econoExpiryDt').val('');
					}
				}
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	
	$(".datePaymentSchedule").each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0',
				onSelect: function(format, elements) {
					$('.estimatedMonths').each(function() {
						var issueDate = new Date(format);
						if($(this).val() != undefined && $(this).val() != ''){
							var monthsToAdd = parseInt($(this).val());
							issueDate.setMonth(issueDate.getMonth()+monthsToAdd);
							var estPayDate = issueDate.toDateString().split(' ')[2] + ' '+issueDate.toDateString().split(' ')[1] + ' '+issueDate.toDateString().split(' ')[3];
							$(this).closest('td').next().find('.date').val(estPayDate);
						}
					});
				}
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	
	$(".dateAmendmentExpiry").each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0',
				direction: true,
				onSelect: function(format, elements) {
					var revisedDate = new Date(format);
					var amendmentCurrentExpDate = new Date($.trim($('p#amendmentCurrentExpDate').text()));
					if($('p#amendmentCurrentExpDate').text() !='' && $('p#USCurrentExpiryDate').text() !=''){
					var USCurrentExpiryDate = new Date($.trim($('p#USCurrentExpiryDate').text()));
					var diff = USCurrentExpiryDate - amendmentCurrentExpDate;
					var dates=Math.floor(diff / 1000 / 60 / 60 / 24);
					var years;
					var finalDates;
					var months;
					var remainingdates;
					if(diff>=0){
						years=Math.floor(dates/365.242);
						remainingdates =Math.floor(dates%365.242);
						months=Math.floor(remainingdates/30.4368);
					    finalDates = Math.floor(remainingdates%30.4368);
					}else{
						years=Math.ceil(dates/365.242);
						remainingdates =Math.ceil(dates%365.242);
						months=Math.ceil(remainingdates/30.4368);
					    finalDates = Math.ceil(remainingdates%30.4368);
					}
					var usexpiryDt = new Date(format);
					usexpiryDt.setFullYear(usexpiryDt.getFullYear()+years, usexpiryDt.getMonth()+months, usexpiryDt.getDate()+finalDates);
					var newDate = usexpiryDt.toDateString().split(' ')[2] + ' '+usexpiryDt.toDateString().split(' ')[1] + ' '+usexpiryDt.toDateString().split(' ')[3];
					$('#usexpiryDt').val(newDate);
					}
					if(revisedDate < amendmentCurrentExpDate){
						$('.expDateNotification').show();
					}else{
						$('.expDateNotification').hide();
					}
				}
			});
			$(this).attr('zdateRegistered', 'true');

			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	 $('body').off("change",'.dateAmendmentExpiry').on("change",'.dateAmendmentExpiry',function(e){
						var revisedDate = new Date($(".dateAmendmentExpiry").val());
						var amendmentCurrentExpDate = new Date($.trim($('p#amendmentCurrentExpDate').text()));
						if($('p#amendmentCurrentExpDate').text() !='' && $('p#USCurrentExpiryDate').text() !=''){
						var USCurrentExpiryDate = new Date($.trim($('p#USCurrentExpiryDate').text()));
						var diff = USCurrentExpiryDate - amendmentCurrentExpDate;
						var dates=Math.floor(diff / 1000 / 60 / 60 / 24);
						var years;
						var finalDates;
						var months;
						var remainingdates;
						if(diff>=0){
							years=Math.floor(dates/365.242);
							remainingdates =Math.floor(dates%365.242);
							months=Math.floor(remainingdates/30.4368);
						    finalDates = Math.floor(remainingdates%30.4368);
						}else{
							years=Math.ceil(dates/365.242);
							remainingdates =Math.ceil(dates%365.242);
							months=Math.ceil(remainingdates/30.4368);
						    finalDates = Math.ceil(remainingdates%30.4368);
						}
						var usexpiryDt = new Date($(".dateAmendmentExpiry").val());
						if(usexpiryDt != "NaN"){
						usexpiryDt.setFullYear(usexpiryDt.getFullYear()+years, usexpiryDt.getMonth()+months, usexpiryDt.getDate()+finalDates);
						var newDate = usexpiryDt.toDateString().split(' ')[2] + ' '+usexpiryDt.toDateString().split(' ')[1] + ' '+usexpiryDt.toDateString().split(' ')[3];
						$('#usexpiryDt').val(newDate);
						}else{
							$('#usexpiryDt').val("");}
						}
						if(revisedDate < amendmentCurrentExpDate){
							$('.expDateNotification').show();
						}else{
							$('.expDateNotification').hide();
						}
				$(e.target).on('blur', function() {
					formatDate($(e.target), 'd M Y');
				});
			
	 });
	
/////////////////////////////////
	//Date picker
	/////////////////////////////////
	$('.dateReports').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'm/d/Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			
		}
	});
	/////////////////////////////////
	//Date Formating function
	/////////////////////////////////
	
	Date.prototype.isValid = function () {
	    // An invalid date object returns NaN for getTime() and NaN is the only
	    // object not strictly equal to itself.
	    return this.getTime() === this.getTime();
	}; 
	
	
	/*
	 * 
	 */
	function formatDate(element, format) {
		var strDate = $(element).val();
		
		if(strDate == null || strDate == '') {
			return;
		}
		
		var date = new Date(strDate);
		if(!date.isValid()) {
			$(element).val('');
			return;
		}
		
		var settings = {
				days: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
				months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
		};
		
		var str_pad = function(str, len) {

            // make sure argument is a string
            str += '';

            // pad with leading zeroes until we get to the desired length
            while (str.length < len) str = '0' + str;

            // return padded string
            return str;

        };
		
        var result = '',

        // extract parts of the date:
        // day number, 1 - 31
        j = date.getDate(),

        // day of the week, 0 - 6, Sunday - Saturday
        w = date.getDay(),

        // the name of the day of the week Sunday - Saturday
        l = settings.days[w],

        // the month number, 1 - 12
        n = date.getMonth() + 1,

        // the month name, January - December
        f = settings.months[n - 1],

        // the year (as a string)
        y = date.getFullYear() + '';
        
        // iterate through the characters in the format
        for (var i = 0; i < format.length; i++) {

            // extract the current character
            var chr = format.charAt(i);
            
            // see what character it is
            switch(chr) {

                // year as two digits
                case 'y': y = y.substr(2);

                // year as four digits
                case 'Y': result += y; break;

                // month number, prefixed with 0
                case 'm': n = str_pad(n, 2);

                // month number, not prefixed with 0
                case 'n': result += n; break;

                // month name, three letters
                case 'M': f = f.substr(0, 3);

                // full month name
                case 'F': result += f; break;

                // day number, prefixed with 0
                case 'd': j = str_pad(j, 2);

                // day number not prefixed with 0
                case 'j': result += j; break;

                // day name, three letters
                case 'D': l = l.substr(0, 3);

                // full day name
                case 'l': result += l; break;

                // ISO-8601 numeric representation of the day of the week, 1 - 7
                case 'N': w++;

                // day of the week, 0 - 6
                case 'w': result += w; break;

                // English ordinal suffix for the day of the month, 2 characters
                // (st, nd, rd or th (works well with j))
                case 'S':

                    if (j % 10 == 1 && j != '11') result += 'st';

                    else if (j % 10 == 2 && j != '12') result += 'nd';

                    else if (j % 10 == 3 && j != '13') result += 'rd';

                    else result += 'th';

                    break;

                // this is probably the separator
                default: result += chr;

            }

        }
        $(element).val(result);
	}
	
	/////////////////////////////////
	//Highlighter for bg color
	/////////////////////////////////
	$.fn.highlight = function(highlightColor, duration) {
		var highlightBg = highlightColor || "#FAFFA6";
		var animateMs = duration || 600;
		var originalBg; //
		if(this.css("backgroundColor") == 'transparent'){ //incase the element dosen't have a bg color it goes to white
			originalBg = '#fff';
		}else{
			originalBg =  this.css("backgroundColor");
		}	
		this.stop().css("background-color", highlightBg).animate({backgroundColor: originalBg}, animateMs);
	}; 
	
	
	/////////////////////////////////
	//collapsible rows
	/////////////////////////////////
	function collapsibleRows(el, ec){
		var rows = '.row:not(.comment-container),.sub,h3';
	
		el.live('click', function(){
			$(this).siblings(rows).slideToggle(150);
			$(this).toggleClass('collapsed');
		});
		
		ec.on('click', function(){
			$(this).nextAll('.form-mod').find('.collapsed').click();
			$(this).hide();
			return false;
		});
		
		function collapsed(){
			$('.collapsed').siblings(rows).hide();
		} 
		collapsed();
	}
	collapsibleRows($('.collapsible'), $('.expand-collapsed'));
	
	
	/////////////////////////////////
	//css nav width fix
	/////////////////////////////////
	function navExpand(){
		tabsWidth = 0;
		tabs = $(".nav-collapse .nav").children().each(function(){
			tabsWidth += $(this).outerWidth();
		});
		$('.navbar').width(tabsWidth);
		$('.navbar').find('ul.nav').width(tabsWidth);
	}
	navExpand();
	
	/////////////////////////////
	//modal centering
	/////////////////////////////
	function mCenter(){
		$('.modal').each( function(){
			jmodal = $(this);
			new_width = jmodal.outerWidth() / 2;
			new_height = jmodal.outerHeight() / 2;
			jmodal.css("marginTop",'-'+new_height+"px").css("marginLeft", '-'+new_width+"px");
		});
	}
	mCenter();
	
	//////////////////////////
	//auto expanding text area
	//////////////////////////
	function autoTextarea(){
		$('textarea.autosize').autoResize({
			onResize : function() {
				$(this).css({opacity:0.8});// On resize:
			},
			animateCallback : function() {
				$(this).css({opacity:1});// After resize:
			},
			animateDuration : 300, 
			minHeight: 28,		
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
	
	/////////////////////////////////
	//Counter for text area limit - - 
	//change the help-block span. EX: There is a hard limit of <span>NUMBER HERE</span> characters
	/////////////////////////////////
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
	
	
	function txtCnt500() {
		var mchar;
		if($(this).data('max')>=0){
			mchar = $(this).data('max');
		}else{
			mchar = 500;
		}
		var count = $(this).val().length;
		var remainingchar500 = mchar - count;
		var counter = $(this).next().next();
		if(remainingchar500 >= 0){
			counter.html(remainingchar500);
		}else{
			counter.html(0);
		}
	}
	$('.autosize500').bind('keyup', txtCnt500);
	
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
	
	/////////////////////////////////
	//Counter for text area limit - - 
	//change the help-block span. EX: There is a hard limit of <span>NUMBER HERE</span> characters
	/////////////////////////////////
	function textareaCounterK() {
		var maxchar;
		if($(this).data('max')>=0){
			maxchar = $(this).data('max');
		}else{
			maxchar = 1000;
		}
		//var maxchar = 500
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		var counter = $(this).next().next();
		var help = $(this).siblings('.help-block');
		counter.html(remainingchar);
		if(remainingchar > 0){
			counter.css('color', '#7FC47E');
			help.css('color', '#999999');
		}else{
			counter.css('color', '#AE2C2C');
			help.css('color', '#AE2C2C');
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
	$('#textK,#textKK').bind('keyup', textareaCounterK);
	
	/////////////////////////////////
	//Add additional exception
	// text area and autosize dont work for new rows in FF and chrome, but does for IE...
	/////////////////////////////////
	$('.add-exception').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault();
			$('<tr class="added"></tr>').appendTo('.exceptions tbody');
			$('.added').load('lib/add-exception.html').removeAttr('class');
			autoTextarea();
			
			$('.autosize').bind('keyup', textareaCounter);
		}
	});

	
	/////////////////////////////////
	//Add additional Auto increase / decrease
	// text area and autosize dont work for new rows in FF and chrome, but does for IE...
	/////////////////////////////////
	$('.add-auto').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault();
			$('<tr class="added"></tr>').appendTo('.auto tbody');
			$('.added').load('lib/add-auto.html').removeAttr('class');
			autoTextarea();
			
			$('.autosize').bind('keyup', textareaCounter);
		}
	});
   
	
	/////////////////////////////////
	//Conditional Buttons
	/////////////////////////////////
	/////////////////////////////////
	function conditionalBtn(){
		conditionalRow = $(this).closest('.row').next('.conditional-row');
		conditionalRow.slideDown();
		clearResults = $(this).siblings('.clear-conditional-results:hidden');
		
			clearResults.show();

		return false;
	}
	$('.conditional-btn').bind("click",conditionalBtn);
	
	$('.conditional-btn.treeview-btn').bind("click",function(){
		$(this).siblings('.treeview').hide().prev().find('.expandAll').hide().siblings('.clear-conditional-results').show().text('Browse Again');
		$(this).hide();
	});
	$('.nav-tabs').bind('click',function(){
		$(this).next().find('.clear-conditional-results').click();
	});
	
	function conditionalClear(){
		conditionalRow = $(this).closest('.row').next('.conditional-row');
		conditionalRow1 =  $(this).closest('.row').next().next('.conditional-row-manually');
		conditionalRow.slideUp();
		$(this).hide();
		$(this).siblings('input[type=text]').val('');
		$('#bicCodeOverride').val("");
		$('#bankBicCode').val("");
		$(conditionalRow).find('input[type=hidden]').val('');
		$(conditionalRow).find('.form-row').find('p').text('');
		$(conditionalRow1).find('input[type=text]').val('');
		$(conditionalRow1).find('input[type=hidden]').val('');
		return false;
	}
	$('.clear-conditional-results').bind("click",conditionalClear);
	
	$('.conditional-typeahead .active').bind("click",conditionalBtn);

	
	function geref() {  
   document.getElementById('geref2').value = "";
   }
	
	// toggles the hidden box on clicking the Lookup btn  
	$('.cond-row').hide();
  $('.cond-btn').click(function() {
    $('.cond-row').slideToggle(400);
    return false;
  });
	
	
	/////////////////////////// CLEAN UP
	//file uploader 
	///////////////////////////
	
	/////////////////////////////////
	//Delete table row
	/////////////////////////////////
	 $('table').on('click','.delete-tr', function(){
		if ($.browser.msie) {
			tableBody = $(this).parents('tbody');
			$(this).parents('tr').remove();
			tableBody.find('.even').removeClass('even');
			tableBody.find('tr:even').addClass('even');//dumb ie 
		}else{
			$(this).parents('tr').remove();
		}
		return false;
	});
			
	 $('.intrest-type-condition1 input:radio').change(function(){
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
$('.intrest1 input:radio').change(function(){
          
		var value = $(this).filter('input:checked');
		
		if(value.hasClass('condition2') ){
			//hide float
			$('.container3').hide();
			$('.container2').show();
		}else{
			//hide fixed
			$('.container2').hide();
			$('.container3').show();
		}
	});
	
					
	///////////////////////////////// 
	//Conditional Select
	/////////////////////////////////
	
    $("#instrument").change(function(){
        $('option',this).each(function(){
            var opt = $(this),val = opt.val();            
            if (val == "other" ) {            
                if(opt.is(":selected")){
                    $("#"+val).slideDown();
                }else {
                    $("#"+val).slideUp();
                } 
            }
        }); 
    });

	
	    $("#instrument2").change(function(){
        $('option',this).each(function(){
            var opt = $(this),val = opt.val();            
            if (val == "others" ) {            
                if(opt.is(":selected")){
                    $("#"+val).slideDown();
                }else {
                    $("#"+val).slideUp();
                } 
            }
        }); 
    });
	

	
	
	
	$('.sblcReq input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked');
		if(value.hasClass('condition')){
			$('#sblcReqDiv').fadeIn();
		}else{
			$('#sblcReqDiv').hide();
		}
	});
	
	
$('.derivativesConditional input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked');
		if(value.hasClass('condition')){
			$('#derivatives-table').fadeIn();
		}else{
			$('#derivatives-table').hide();
		}
	});
	$('.derivativesConditional1 input:radio').change(function(){
		var value = $(this).filter('[class=condition1]:checked');
		if(value.hasClass('condition1')){
			$('#derivatives-table1').fadeIn();
		}else{
			$('#derivatives-table1').hide();
		}
	});
	$('.derivativesConditional2 input:radio').change(function(){
		var value = $(this).filter('[class=condition2]:checked');
		if(value.hasClass('condition2')){
			$('#derivatives-table2').fadeIn();
		}else{
			$('#derivatives-table2').hide();
		}
	});
	$('.derivativesConditionald input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked');
		if(value.hasClass('condition')){
			$('#derivatives-tabled').fadeIn();
		}else{
			$('#derivatives-tabled').hide();
		}
	});	
	$('.derivativesConditional3 input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked');
		if(value.hasClass('condition')){
			$('#derivatives-table13').fadeIn();
		}else{
			$('#derivatives-table13').hide();
		}
	});
	$('.derivativesConditional4 input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked');
		if(value.hasClass('condition')){
			$('#derivatives-table4').fadeIn();
		}else{
			$('#derivatives-table4').hide();
		}
	});
$('.derivativesConditional5 input:radio').change(function(){
		var value = $(this).filter('[class=condition3]:checked');
		if(value.hasClass('condition3')){
			$('#derivatives-table5').fadeIn();
		}else{
			$('#derivatives-table5').hide();
		}
	});	
	
	

	$('#saveSelectionLB').click(function(){
		$('#searchlb').show();
	});
	
	
	$('a#saveSelectionlb').click(function () {
		$('#searchResultlb').show();
	});
	$('a#searchResultlbClear').click(function () {
		$('#searchResultlb').hide();
	});			

	
	$('a#searchResultblClear').click(function () {
		$('#searchResultbl').hide();
	});	
	
	$('a#viewUserReports').off('click').on('click', function(e) {
		var url = $(this).attr('href');
		window.location.href = url;
	});

	if (window.PIE) {
        $('.circle,.circle2,.circle1,.modal-header,.boxHead,.errorHead,.errorContent,.noteHead,.noteContent,#siteMsg,#infoMsg,.navLi,.btn').each(function() {
           PIE.attach(this);
        });
   }
	
	$('.nav-tabs > li > a').corner("round top 5px");
	//$(' > li a').corner("round top 5px");
	
});


// AUTO INCREASE / DECREASE 
$(document).ready(function() {      
	// Code between here will only run when the document is ready
	$("a#increaseDecreaseR").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#increaseDecrease tr:last").after('<tr><td>hello</td><td>hello</td><td>hello</td><td>hello</td>');
		return false;
	});
	
	
	$("#conditionA").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#increaseDecrease").find('thead tr').each(function(){
			$(this).append('<td>--/Auto-increase indicator</td>');
		 });
		$("table#increaseDecrease").find('tbody tr').each(function(){
			$(this).append('<td><div class="form-row"><label class="radio"><input type="radio" value="option1" name="optionsRadiosEE" id="conditionB">Increase</label><label class="radio"><input type="radio" value="option1" name="optionsRadiosEE" id="conditionC">Decrease</label></div></td>');
		 });
		return false;
	});
	
	$('#conditionB').live('click', function(){
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#increaseDecrease").find('thead tr').each(function(){
			$(this).append('<td>--/Auto-increase date</td>');
			$(this).append('<td>--/Auto-increase amount</td>');		
		 });
		$("table#increaseDecrease").find('tbody tr').each(function(){
			$(this).append('<td><div class="form-row autosize-container small"><input type="text" class="date"/></div></td>');
			$(this).append('<td><div class="form-row"><input type="text" value=""/></div></td>');
		 });
		return false;
	});
	
	$('#conditionC').live('click', function(){
	
	$('#increaseDecrease tbody tr th:first').remove();												
			

		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#increaseDecrease").find('thead tr').each(function(){
			$(this).append('<td>--/Auto-decrease date</td>');	
			$(this).append('<td>--/Auto-decrease amount</td>');
		 });
		$("table#increaseDecrease").find('tbody tr').each(function(){
			$(this).append('<td><div class="form-row autosize-container small"><input type="text" class="date"/></div></td>');
			$(this).append('<td><div class="form-row"><input type="text" value=""/></div></td>');
		 });
			
		return false;
	});	
	
 });
function decCounter(id,fullLength){
	var txtAreaVal = $('#'+id).val(); 
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.counter').text(txtAreaValLen);
		}
}

function validateIssuer()
{
	var uploadOrDownloadRadioVal=($('input:radio[name=issuerRadioOption]:checked').val());
	if(uploadOrDownloadRadioVal!=undefined){
		$('#issuerRadioOption').val(uploadOrDownloadRadioVal);
	}
	
		return true;
}
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


