$(document).ready(function() {


//replace .live with .on due to 1.7....


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
			})
			
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
			})
			
			//Move it down
			headerContainer.css({
				'position': 'absolute',
				'top': 0
			});
		});
	}
	
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
	}
	$.tablesorter.addParser({
        id: 'debtEquityNumber',
        is:function(s){return false;},
        format: function(s) {
        	s=s.replace('-','');
        	return s.replace(/[\,]/g,'');
        },
        type: 'numeric'
    });
	$.tablesorter.addParser({
        id: 'dealID',
        is:function(s){return false;},
        format: function(s) {
        	if(s.trim)
        		s=s.trim();
        	s=s.replace(/<A\b[^>]*>(.*?)/g,'');
        	s=s.replace(/<\/A>/g,'');
        	s=s.substring(s.lastIndexOf("-")+1,s.length);
        	return s;
        },
        type: 'numeric'
    });
	$.tablesorter.addParser({
        id: 'draftDealID',
        is:function(s){return false;},
        format: function(s) {
        	if(s.trim)
        		s=s.trim();
        	s=s.replace(/<A\b[^>]*>(.*?)/g,'');
        	s=s.replace(/<\/A>/g,'');
        	s=s.substring(s.indexOf("-")+1,s.lastIndexOf("-"));
        	return s;
        },
        type: 'numeric'
    });
	// TableSort parser for date format: Jan 6, 1978
	$.tablesorter.addParser({
	  id: 'monthDayYear',
	  is: function(s) {
	      return false;
	  },
	  format: function(s) {
	  	  if( s.trim )
	  	  	s = s.trim();
	  	  else
	  	  	s = s.replace(" ","");
	  	  if("--" === s)
    	  	  return '';		
	      var date = s.match(/^(\w{3})[ ]?(\d{1,2}),[ ](\d{4})[ ]?$/);
	      var m = monthNames[date[1]];
	      var d = String(date[2]);
	      if (d.length == 1) {d = "0" + d;}
	      var y = date[3];
	      return '' + y + m + d;
	  },
	  type: 'numeric'
	});

	var monthNames = {};
	monthNames["Jan"] = "01";
	monthNames["Feb"] = "02";
	monthNames["Mar"] = "03";
	monthNames["Apr"] = "04";
	monthNames["May"] = "05";
	monthNames["Jun"] = "06";
	monthNames["Jul"] = "07";
	monthNames["Aug"] = "08";
	monthNames["Sep"] = "09";
	monthNames["Oct"] = "10";
	monthNames["Nov"] = "11";
	monthNames["Dec"] = "12";
})(jQuery);



	/////////////////////////////////
	// settings
	/////////////////////////////////
	$('.nav .dropdown-menu').dropdown()
	//$("table.sortable").tablesorter();
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }})
	$('.ttip.chart').tooltip()
	$('.chartPopup').popover({placement: top, delay: { show: 300, hide: 1 }});

	$('.datepicker-inline').datepicker({
		changeMonth: true,
		changeYear: true
    });
	$('.datepicker-field').datepicker({
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: contextURL+"/img/calendar.gif",
		buttonImageOnly: true
    });
	$('.requestdatepicker-field').datepicker({
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: contextURL+"/img/calendar.gif",
		buttonImageOnly: true
    });
	$('.searchdatepicker-field').datepicker({
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: contextURL+"/img/calendar.gif",
		buttonImageOnly: true
    });
		
	$('.tabs').tab()
	//$('#sendToTESG').modal('show')
	$('#table-modal .table').fixedHeader({height: 300})
	
	if($('#demo2').html()){
		$("#demo2").paginate({
				count 		: 50,
				start 		: 5,
				display     : 8
			});  
	}
	
	/////////////////////////////////
	// Inline edit -- add span with class to the read only blocks value
	/////////////////////////////////
	function inlineEdit(){
		//var isVisible = false;
		//var clickedAway = false;

		$('.inline-edit').each(function() {
			obj = {
				html: true,
				placement: 'top',
				trigger: 'manual',
				title: function() { 
					return $(this).parent().parent().html().split(/<br[^>]*>/gi)[0].slice(3,-4) + "<a class='close'>X</a>" 
					},
				content: function(){
						currentValue = $(this).html()
						htmlStr = '';
						htmlStr += '<label>'+currentValue+'</label>';
						htmlStr += '<input type="text" class="span2">';
						htmlStr += '<a href="#" class="btn inline-save" >Update</a>';
						return htmlStr
					}
			}
			
			$(this).popover(obj).click(function(e) {
				$(this).popover('show');
				isVisible = true;
				link = $(this)
				
				
				$('h3 .close').click(function(){
					link.popover('hide')
					
					return false
					
					isVisible = false;
					clickedAway = false;
				})
				$('.inline-save').click(function(){
					input = $(this).prev()
					newValue = input.val()
					firstValue = link.text()
					
					if(newValue.length <= 0 ){
						link.popover('hide').text(firstValue)
					}else{
						link.popover('hide').text(newValue).addClass('edited').closest('div[class*="span"]').highlight()
					}
					
					//isVisible = clickedAway = false;
					
					return false
				})
			});
			
		});
		$('.inline-edit').click(function(e) {
		  if(isVisible & clickedAway){
			 $('.inline-edit').each(function() {
				  $(this).popover('hide');
			 });
			isVisible = clickedAway = false;
		  }else{
			clickedAway = true;
		  }
		}); 
	}
	inlineEdit()

	
	/////////////////////////////////
	//Date picker
	/////////////////////////////////
	$('.date').zdate({
		format: 'm/d/Y',
		offset:  [20, 25],
		first_day_of_week: '0'
	});
	
	/////////////////////////////////
	//Highlighter for bg color
	/////////////////////////////////
	$.fn.highlight = function(highlightColor, duration) {
		var highlightBg = highlightColor || "#FAFFA6";
		var animateMs = duration || 600;
		//var originalBg = this.css("backgroundColor"); //
		if(this.css("backgroundColor") == 'transparent'){ //incase the element dosen't have a bg color it goes to white
			var originalBg = '#fff';
		}else{
			var originalBg =  this.css("backgroundColor")
		}	
		this.stop().css("background-color", highlightBg).animate({backgroundColor: originalBg}, animateMs);
	}; 
	
	
	//////////////////////////////////
	//clear text on change of search criteria
	///////////////////////////////////
	$("select.cpa-search-id").change(function(){
		 $(this).parents('.form-row').find("input:text").val("");
	})
	
	/////////////////////////////////
	//collapsible rows
	/////////////////////////////////
	function collapsibleRows(el, ec){
		var rows = '.row:not(.comment-container),.sub,h3'
	
		el.live('click', function(){
			$(this).siblings(rows).slideToggle(150)
			$(this).toggleClass('collapsed')
		})
		
		ec.on('click', function(){
			$(this).nextAll('.form-mod').find('.collapsed').click()
			$(this).hide()
			return false
		})
		
		function collapsed(){
			$('.collapsed').siblings(rows).hide()
		} 
		collapsed()
	}
	collapsibleRows($('.collapsible'), $('.expand-collapsed'))
	
	
	/////////////////////////////////
	//zebra stripe IE
	/////////////////////////////////
	function zebraStripes(){
		if ($.browser.msie) {
			$("tbody tr:even").addClass("even");//dumb ie 
			 $('thead .header').live('click',function(){
				$(".even").removeClass("even")
				$("tbody tr:even").addClass("even")
			}) 	
		}
	}
	zebraStripes()

	/////////////////////////////////
	//Change the color of any decimal place on the table
	/////////////////////////////////
	$('.colordecimals td:contains(.)').each(function(){
		value = $(this).text()
		num = value.substr(0, value.length-3)
		des = value.slice(-3) //ie8 has heart attack when it sees a neg substr...
		$(this).html(num+'<span style="color: #B0C9DA">'+des+'</span>')
	})
	
	/////////////////////////////////
	//css nav width fix
	/////////////////////////////////
	function navExpand(){
		tabsWidth = 0
		tabs = $(".nav-collapse .nav").children().each(function(){
			tabsWidth += $(this).outerWidth();
		})
		$('.navbar').width(tabsWidth+12)
	}
	navExpand()
	
	/////////////////////////////
	//modal centering
	/////////////////////////////
	function mCenter(){
		$('.modal').each( function(){
			jmodal = $(this)
			new_width = jmodal.outerWidth() / 2;
			new_height = jmodal.outerHeight() / 2;
			jmodal.css("marginTop",'-'+new_height+"px").css("marginLeft", '-'+new_width+"px");
		})
	}
	mCenter()
	
//////////////////////////
	//auto expanding text area
	//////////////////////////
	function autoTextarea(){
		$('textarea.autosize,textarea.autosize1,textarea.autosize2').autoResize({
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
	autoTextarea()
	
	/////////////////////////////////
	//Counter for text area limit - - 
	//change the help-block span. EX: There is a hard limit of <span>NUMBER HERE</span> characters
	/////////////////////////////////
	function textareaCounter() {
		
		if($(this).data('max')>=0){
			var maxchar = $(this).data('max')
		}else{
			var maxchar = 500
		}
		//var maxchar = 500
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		var counter = $(this).prev()
		var help = $(this).siblings('.help-block')
		var left = $(this).outerWidth() -32
		counter.html(remainingchar);
		if(remainingchar > 0){
			counter.css('color', '#7FC47E');
			help.css('color', '#999999');
		}else{
			counter.html(0);
			counter.css('color', '#AE2C2C');
			help.css('color', '#AE2C2C');
		}
		if($(this).hasClass('small')){ //if its a small autosize in the table
			if(cnt > 25){
				counter.css('top','-2px')
			}else if(cnt < 25) {
				counter.css('top','29px')
			}
		}else{
			if(cnt > 50){
				counter.css('top','-4px')
			}else if(cnt < 50) {
				counter.css('top','29px')
			}
		}
	}
	$('.autosize').bind('keyup', textareaCounter).trigger("keyup");
	
	
	/////////////////////////////////
	//Counter for text area limit - - 
	//change the help-block span. EX: There is a hard limit of <span>NUMBER HERE</span> characters
	/////////////////////////////////
	function textareaCounterK() {
		
		if($(this).data('max')>=0){
			var maxchar = $(this).data('max')
		}else{
			var maxchar = 1000
		}
		//var maxchar = 500
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		var counter = $(this).prev()
		var help = $(this).siblings('.help-block')
		var left = $(this).outerWidth() -32
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
				counter.css('top','-2px')
			}else if(cnt < 25) {
				counter.css('top','29px')
			}
		}else{
			if(cnt > 50){
				counter.css('top','-4px')
			}else if(cnt < 50) {
				counter.css('top','29px')
			}
		}
	}
	$('#problemStatement,#correctionNeededComments,#otherDesc,#equityDescriptionID,#debtEquityOtherComments,#tpSummary,#settlementOtherDetailsId').bind('keyup', textareaCounterK);
	
	
function textareaCounter2K() {
		
		if($(this).data('max')>=0){
			var maxchar = $(this).data('max')
		}else{
			var maxchar = 2500
		}
		//var maxchar = 500
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		var counter = $(this).prev()
		var help = $(this).siblings('.help-block')
		var left = $(this).outerWidth() -32
		counter.html(remainingchar);
		if(remainingchar > 0){
			counter.css('color', '#7FC47E');
			help.css('color', '#999999');
		}else{
			counter.html(0);
			counter.css('color', '#AE2C2C');
			help.css('color', '#AE2C2C');
		}
		if($(this).hasClass('small')){ //if its a small autosize in the table
			if(cnt > 25){
				counter.css('top','-2px')
			}else if(cnt < 25) {
				counter.css('top','29px')
			}
		}else{
			if(cnt > 50){
				counter.css('top','-4px')
			}else if(cnt < 50) {
				counter.css('top','29px')
			}
		}
	}
$('#dealRationaleId').bind('keyup', textareaCounter2K);
	
	
	
	
		
		var strHTML = "- ";
		if($('#Ecept1').html() != null)
			{
				strHTML = $('#Ecept1').html();
			}
		var s = "<tr><td colspan=3 class=attachment-uploaded><div id='Ecept1'>"+strHTML+"</div></td><td colspan='4'><div id='field10'>	<form id='Ecept1' name='attachmentForm' action='/icfp/RCALegRequest.do' method='post' enctype='multipart/form-data'><input type='file' id='exceptionDocument' name='exceptionDocument'  class='input-file10' /></form></div></td></tr>"; 
		$('#staticUploadData').replaceWith(s);
	
	

		var strHTML1 = "- ";
		if($('#Amend1').html() != null)
			{
				strHTML1 = $('#Amend1').html();
			}
		var s1 = "<tr><td colspan=3 class=attachment-uploaded><div id='Amend1'>"+strHTML+"</div></td><td colspan='4'><div id='field12'>	<form id='Amend1' name='attachmentForm' action='/icfp/RCALegRequest.do' method='post' enctype='multipart/form-data'><input type='file' id='ameexceptionDocument' name='ameexceptionDocument'  class='input-file12' /></form></div></td></tr>"; 
		$('#gen-staticUploadData').replaceWith(s1);
	
	
	/////////////////////////////////
	//Add additional exception
	// text area and autosize dont work for new rows in FF and chrome, but does for IE...
	/////////////////////////////////
	$('.add-exception').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault();
			if($(this).prev('table').hasClass('exceptions-nested')){
				$('<tr class="added"></tr>').appendTo('.exceptions tbody');
				$('<tr class="attachment1"></tr>').appendTo('.exceptions tbody');
				$('<tr class="attachment2"  onclick="displayResult(this)"></tr>').appendTo('.exceptions tbody');
			}else{
				$('<tr class="added"></tr>').appendTo('.exceptions tbody');
			}
			
			var newExceptionIndex = $('#newExceptionIndex').val();
			var nextExceptionIndex = parseInt(newExceptionIndex) + 1;
			$('#newExceptionIndex').val(nextExceptionIndex);
			
			var legIndex = $('#exceptionLegIndex').val();
			
			if($(this).hasClass('non-required')){
				var addExpNonReqURL = context_url + '/lib/add-exception-non-required.jsp' + '?exceptionIndex=' + newExceptionIndex;
				$('.added').load(addExpNonReqURL).removeAttr('class');
			}else if($(this).prev('table').hasClass('exceptions-nested')){
				var addExpNested1URL = context_url + '/lib/add-exception-nested1.jsp' + '?exceptionIndex=' + newExceptionIndex;
				$('.added').load(addExpNested1URL).removeAttr('class');
				
				$('.attachment1').load(context_url +'/lib/add-exception-nested2.jsp').addClass('attachment-nested').removeClass('attachment1');
				
				var addExpNested3URL = context_url + '/lib/add-exception-nested3.jsp' + "?legIndex=" + legIndex + "&exceptionIndex=" + newExceptionIndex;
				$('.attachment2').load(addExpNested3URL).addClass('attachment-nested2').removeClass('attachment2');
			}else{
				var addExpURL = context_url+ '/lib/add-exception.jsp' + "?exceptionIndex=" + newExceptionIndex;
				$('.added').load(addExpURL).removeAttr('class');
			}
				
			zebraStripes();
			autoTextarea();
			
			$('.autosize').bind('keyup', textareaCounter);
		}
	})
	
	/////////////////////////////////
	//Add Amendment
	// text area and autosize dont work for new rows in FF and chrome, but does for IE...
	/////////////////////////////////
	$('.add-genAmendment').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault()
			if($(this).prev('table').hasClass('gen-exceptions-nested')){
				$('<tr class="added"></tr>').appendTo('.gen-exceptions tbody');
				$('<tr class="attachment1"></tr>').appendTo('.gen-exceptions tbody');
				$('<tr class="attachment2"  onclick="displayResult(this)"></tr>').appendTo('.gen-exceptions tbody');
			}else{
				$('<tr class="added"></tr>').appendTo('.gen-exceptions tbody');
			}
			
			var newAmendmentIndex = $('#newAmendmentIndex').val();
			var nextAmendmentIndex = parseInt(newAmendmentIndex) + 1;
			$('#newAmendmentIndex').val(nextAmendmentIndex);
			
			var legIndex = $('#amendmentLegIndex').val();
			
			if($(this).hasClass('non-required')){
				var addAmendmentNonReqURL = context_url + '/lib/gen-add-exception-non-required.jsp' + '?amendmentIndex=' + newAmendmentIndex;
				$('.added').load(addAmendmentNonReqURL).removeAttr('class');
			}else if($(this).prev('table').hasClass('gen-exceptions-nested')){
				var addAmendmentNested1URL = context_url + '/lib/gen-add-exception-nested1.jsp' + '?amendmentIndex=' + newAmendmentIndex;
				$('.added').load(addAmendmentNested1URL).removeAttr('class');
				
				$('.attachment1').load(context_url +'/lib/gen-add-exception-nested2.jsp').addClass('attachment-nested').removeClass('attachment1');
				
				var addAmendmentNested3URL = context_url + '/lib/gen-add-exception-nested3.jsp' + "?legIndex=" + legIndex + "&amendmentIndex=" + newAmendmentIndex;
				$('.attachment2').load(addAmendmentNested3URL).addClass('attachment-nested2').removeClass('attachment2');
			}else{
				var addAmendmentURL = context_url+ '/lib/gen-add-exception.jsp' + "?amendmentIndex=" + newAmendmentIndex;
				$('.added').load(addAmendmentURL).removeAttr('class');
			}
				
			zebraStripes();
			autoTextarea();
			
			$('.autosize').bind('keyup', textareaCounter);
		}
	})
	
	/////////////////////////////////
	//Add additional amendment
	// text area and autosize dont work for new rows in FF and chrome, but does for IE...
	/////////////////////////////////
	$('.add-amendment').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault();
			$('<tr class="added"></tr>').appendTo('.amendment tbody');
			$('.added').load('lib/add-amendment.html').removeAttr('class');
			zebraStripes();
			autoTextarea();
			
			$('.autosize').bind('keyup', textareaCounter);
		}
	})
	
	/////////////////////////////////
	//Conditional Buttons
	/////////////////////////////////
	/////////////////////////////////
	function conditionalBtn(){
		conditionalRow = $(this).closest('.row').next('.conditional-row')
		conditionalRow.slideDown("fast")
		clearResults = $(this).siblings('.clear-conditional-results:hidden')
		
			clearResults.show()

		return false
	}
	$('.conditional-btn').bind("click",conditionalBtn)
	
	$('.conditional-btn.treeview-btn').bind("click",function(){
		$(this).siblings('.treeview').hide().prev().find('.expandAll').hide().siblings('.clear-conditional-results').show().text('Browse Again')
		$(this).hide()
	})
	/*$('.nav-tabs').bind('click',function(){
		$(this).next().find('.clear-conditional-results').click()
	})*/
	
	function conditionalClear(){
		conditionalRow = $(this).closest('.row').next('.conditional-row')
		conditionalRow.slideUp("fast")		
		$(this).hide()
		$(this).siblings('input').val('')
		var isME = $(this).siblings('.me-lookup').length > 0;
		if( !isME )
			$(conditionalRow).find('input').val('');
		$(conditionalRow).find('p:not(:first)').remove()
		
		return false
	}
	$('.clear-conditional-results').bind("click",conditionalClear)
	
	$('.conditional-typeahead .active').bind("click",conditionalBtn)

	
	/////////////////////////// CLEAN UP
	//file uploader 
	///////////////////////////
	function fileUploader(){
		function uploader(){		
			var file = $(this).val().slice(-50)
			var error = $(this).next('.req-error')
			var fileLimit = $(this).attr('maxlength')-1
			var uploadedFiles = $(this).siblings('.uploaded-file').length 
			var file = '<div class="uploaded-file"><span>X</span> - <a href="#">...'+file+'</a></div>'
			var container = $(this).parent().prev()
			var error = $(this).siblings('.red')
			if (container.hasClass('multi')){//to add files
				var u = container.find('div').length
				if(u <= 0){
					container.html(file)
				}
				/* else if(u >= 2){
					container.append(file)
					//console.log('your maxed at 3')
					error.fadeIn(function(){
						error.siblings('input').attr('disabled','disabled')
					})
				} */
				else{
					container.append(file)
					//console.log(u)
				}
			}else if(container.hasClass('leg')){
					container.find('span:contains(" - - ")').remove()
					container.find('.uploaded-file').replaceWith(file)
			}else{//use this to replace
					container.html(file)
					
			}
			/* if(uploadedFiles >= fileLimit ){ //count uploaded files
				$(this).attr('disabled', true)
			}else{
				$(this).removeAttr('disabled')
			}  */
			
			$(this).val('')//clear input field
		}; 
		$(".input-file").live('change',uploader)
		
		function removeFile(uploader){
			count = $(this).parent().siblings().length

			if(count == 0){
				$(this).parents('.multi').text('-')
			}
			/* if(count == 0){
				$(this).parents('.multi').next().find('input').removeAttr('disabled')
				$(this).parents('.multi').next().find('.red').hide()
			} */
			
			$('.tooltip').hide()
			$(this).parent().remove()
		}
		$('.uploaded-file span').live('click',removeFile)
	}
	fileUploader()
	
	
	/////////////////////////////////
	//Delete table row
	/////////////////////////////////
/* 	 $('table').on('click','.delete-tr', function(){
		if ($.browser.msie) {
			tableBody = $(this).parents('tbody')
			$(this).parents('tr').remove()
			tableBody.find('.even').removeClass('even')
			tableBody.find('tr:even').addClass('even');//dumb ie 
		}else{
			$(this).parents('tr').remove()
		}
		return false
	}) */
	
	 $('table').on('click','.deleteException-tr', function(){
		 var rowIndex = $(this).closest('tr').prevAll().length;
		 var actualIndex = 0;
		 if(rowIndex==0){
			 actualIndex= 1;
		 }else{
			 actualIndex =  (parseInt(rowIndex)/3)+1;
		 }
		 //var actualIndex = parseInt(rowIndex)+1;
		// var l = $(this).prev('tr').rowIndex;
		// alert('<tr> count: ' + actualIndex);
		 //deleteExceptionDetails(actualIndex);
	})
	
	 $('table').on('click','.delete-tr', function(){
		if ($.browser.msie) {
			tableBody = $(this).parents('tbody')
			if($(this).parents('table').hasClass('exceptions-nested')){
				$(this).parents('tr').next().next().remove()
				$(this).parents('tr').next().remove()
				$(this).parents('tr').remove()
			}else{
				$(this).parents('tr').remove()
			}

			tableBody.find('.even').removeClass('even')
			tableBody.find('tr:even').addClass('even');//dumb ie 
		}else{
			if($(this).parents('table').hasClass('exceptions-nested')){
				$(this).parents('tr').next().next().remove()
				$(this).parents('tr').next().remove()
				$(this).parents('tr').remove()
			}else{
				$(this).parents('tr').remove()
			}
		}
		return false
	})
	
	 $('table').on('click','.deleteAmendment-tr', function(){
		 var rowIndex = $(this).closest('tr').prevAll().length;
		 var actualIndex = 0;
		 if(rowIndex==0){
			 actualIndex= 1;
		 }else{
			 actualIndex =  (parseInt(rowIndex)/3)+1;
		 }
		 //var actualIndex = parseInt(rowIndex)+1;
		// var l = $(this).prev('tr').rowIndex;
		// alert('<tr> count: ' + actualIndex);
		// deleteAmendmentDetails(actualIndex);
	})
	
	$('table').on('click','.delete-atr', function(){
		if ($.browser.msie) {
			tableBody = $(this).parents('tbody')
			if($(this).parents('table').hasClass('gen-exceptions-nested')){
				$(this).parents('tr').next().next().remove()
				$(this).parents('tr').next().remove()
				$(this).parents('tr').remove()
			}else{
				$(this).parents('tr').remove()
			}

			tableBody.find('.even').removeClass('even')
			tableBody.find('tr:even').addClass('even');//dumb ie 
		}else{
			if($(this).parents('table').hasClass('gen-exceptions-nested')){
				$(this).parents('tr').next().next().remove()
				$(this).parents('tr').next().remove()
				$(this).parents('tr').remove()
			}else{
				$(this).parents('tr').remove()
			}
		}
		return false
	})
	
	
	
	
	
	///////////////////////////////// CLEAN UP
	//browse legs
	/////////////////////////////////
	function legs(browseL ,browseB , addL, addB, previous, clearInput){
	
		var lenders = browseL.parents('.row').children('.lenders')
		var borrowers = browseB.parents('.row').children('.borrowers')
		var searchL = lenders.siblings()
		var searchB = borrowers.siblings()
		var lenderDetails = $('.lender-details')
		var borrowerDetails = $('.borrower-details')
		var footerL = $('.lender-footer')
		var footerB = $('.borrower-footer')
		var clear = $('.active .clear-results')
		var closeLink = $('*[data-dismiss=modal]')
	
		browseL.live('click', function(){
			lenders.siblings().hide()
			lenders.fadeIn()
			footerL.siblings('.modal-footer').hide()
			footerL.filter(':last').fadeIn()
			lenderDetails.hide()//hide dummy info if there
			return false
		})
		addL.live('click', function(){
			lenders.hide()
			searchL.fadeIn()
			footerL.siblings('.modal-footer').hide()
			footerL.filter(':first').fadeIn()
			lenderDetails.fadeIn()//show dummy info
			$('.active .clear-results').show()
			return false
		})
		
		browseB.live('click', function(){
			borrowers.siblings().hide()
			borrowers.fadeIn()
			footerB.siblings('.modal-footer').hide()
			footerB.filter(':last').fadeIn()
			borrowerDetails.hide()//hide dummy info if there
			
			return false
		})
		addB.live('click', function(){
			borrowers.hide()
			searchB.fadeIn()
			footerB.siblings('.modal-footer').hide()
			footerB.filter(':first').fadeIn()
			borrowerDetails.fadeIn()//show dummy info
			$('.active .clear-results').show()
			return false
		})

		previous.live('click', function(){			
			if ($('.step.active').find('.lender-details').html()){
				lenders.hide()
				searchL.fadeIn()
				footerL.siblings('.modal-footer').hide()
				footerL.siblings('.modal-footer:first').show()
			 }else{
				borrowers.hide()
				searchB.fadeIn()
				footerB.siblings('.modal-footer').hide()
				footerB.siblings('.modal-footer:first').show()
			} 
			return false
		})
		
		function nextStep(el){
			el.live('click', function(){
				$('.active').removeClass('active').next('.step').addClass('active')
				return false
			})
		}
		nextStep($('.continue'))
		
		
		
		function inputAdd(ia){
			ia.live('click',function(){
				$(this).parents('.row').siblings('.details').fadeIn()
				$('.active .clear-results').show()
				
				if ($('.step.active').find('.lender-details').html()){
					footerL.siblings('.modal-footer').hide()
					footerL.filter(':first').fadeIn()
				}else{
					footerB.siblings('.modal-footer').hide()
					footerB.filter(':first').fadeIn()
				}
				return false
			})
		}
		inputAdd($('.active .input-add'))
		
		function modalClosed(){
			$('.active').removeClass('active')
			$('.step:first').addClass('active')
			return false
		}
		
		$('#saveLeg').on('click', function(){
			$(".alert").hide().fadeIn()
			modalClosed()
			lenderDetails.hide()
			$('html, body').animate({scrollTop:0}, 'fast');
		})
		
		closeLink.live('click', modalClosed)
		
		clearInput.live('click',function(){
			$(this).parents('.row').siblings('.details').fadeOut()
			$(this).hide()
			return false
		})
	}
	legs($('#browseLenders'),$('#browseBorrowers'), $('#addLender'),$('#addBorrower'),$('.previous'), $('.clear-results') )
	

	///////////////////////////////// 
	//Conditional Radio TRI --- for radios with all conditions
	/////////////////////////////////
	$('.conditional-radio-tri input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked')
		var container = $(this).parent().next('[class*="conditional"]')
		var others = $(this).closest('.conditional-radio-tri').find('[class*="conditional"]')
		
		others.hide()
		container.show().highlight()
	})
	
	
	///////////////////////////////// 
	//Conditional Radio --- add the condition class to radio to show container upon selection
	/////////////////////////////////
	$('.conditional-radio input:radio').change(function(){
		var value = $(this).filter('[class*=condition]:checked')
		var container = $(this).parent().siblings('[class*="conditional"]')
		
		if(value.hasClass('condition') ){
			container.show()
			container.highlight();
		}else{
			container.hide()
		}
	})
	
	///////////////////////////////// 
	//Conditional required --- for Qualitative Assessment
	/////////////////////////////////
	$('.conditional-required input:radio').change(function(){
		assessmentValidation(this);
	})
	
	function assessmentValidation(saveObj)
	{
		var value = $(saveObj).filter('[class=condition]:checked')
		var container = $(saveObj).parents('td').next().find('span.required')
		
		if(value.hasClass('condition') ){
			container.show()
		}else{
			container.hide()
		}
	}
	assessmentValidation($('.conditional-required input:radio:checked'));
	
	$('.intrest-type-condition input:radio').change(function(){
		var value = $(this).filter('input:checked')
		
		if(value.hasClass('fixed-condition') ){
			//hide float
			$('.float-container').hide()
			$('.fixed-container').show()
		}else{
			//hide fixed
			$('.fixed-container').hide()
			$('.float-container').show()
		}
	})

	$('.immediate-Drawdown-condition input:radio').change(function(){
		var value = $(this).filter('input:checked')
		
		if(value.hasClass('immediate-Drawdown-yes-condition') ){
			
			$('.immdtDrdownAmt-container').show()
			
		}else{
			
			$('.immdtDrdownAmt-container').hide()
			
		}
	})

	
	$('.otherfees-condition input:radio').change(function(){
		var value = $(this).filter('input:checked')
		
		if(value.hasClass('otherfees-yes-condition') ){
			
			$('.otherfeesAmt-container').show()
			
		}else{
			
			$('.otherfeesAmt-container').hide()
			
		}
	})
	
	
	
	///////////////////////////////// 
	//RCA required
	/////////////////////////////////
	$('.conditional-select').change(function(){
		/* if($(this).val() == 'RCA'){
			$('.conditional-select-rca').show().highlight();
		}else */ 
		if($(this).val() == 'RCA'||$(this).val() == 'Term Loan'||$(this).val() == 'Bond'  ){
			//hide others
			val = $(this).val()
			$('.conditional-type-variable').text(val)
			$('.conditional-type-equity').hide()
			$('.conditional-type').show().highlight();
			$('.equity-conditional').hide()
		}else if($(this).val() == 'Equity'){
			//hide others
			$('.conditional-type').hide()
			$('.conditional-type-equity').show().highlight();
			$('.equity-conditional').show()
			$('.form-of-equity').val("")
		}else{
		$('.equity-conditional').hide()
			$('.conditional-type').hide()
			$('.conditional-type-equity').hide()
		}
		
		killNested()
		$('#derivatives-table,.product-type-debtfields,.product-type-all,.product-type-comments').hide()
	})
	
	
	
	
	/* $('.form-of-equity').change(function(){
		if($(this).val() == 'Debt to Equity' ){
			//hide others
			$('.product-type-all').hide()
			$('.product-type-debtfields').show()
		}else{
			$('.product-type-debtfields').hide()
			$('.product-type-all').show()
		}
		
		killNested()
	}) */
	
	$('.me-conditional-select').change(function(){
		if($(this).val() == 'Other' ){
			//hide others
			$(this).siblings('.me-conditional-input').show()
		}else{
			$(this).siblings('.me-conditional-input').hide()
		}
		
		killNested()
	})
	
	$(function() {    // Makes sure the code contained doesn't run until
    $('#me-conditional-select').change(function(){
    	if($(this).val() == '1' ){
			$('.mDrivers').show();
			$('#scoresO').show();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();
		
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($(this).val() == '2' ){
			$('.mDrivers').hide();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();	
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($(this).val() == '3' ){
			$('.mDrivers').hide();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}else if($(this).val() == ''){
    		$('.mDrivers').hide();
			$('#mDriversAlert').hide();
			$('#mDriversAttach').hide();
		}else{
			$('.mDrivers').hide();
			$('#mDriversAlert').show();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').hide();
			$('#scores2').hide();
			$('#scores3').hide();
			$('#scores4').hide();
			$('#scores5').hide();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
    });

	});
	
	function leaderSection(search,save,clear, edit){
		results = $('.leader-search-results')
		savedResults = $('.leader-saved-results')
		searchGroup = $('.search-group')
		searchGroup2 = $('.search-group2')
		
		search.live('click',function(){
			$('.leader-search-results').slideDown(150)//.highlight()
			$('.leader-saved-results').hide()
		return false
		})
		
		save.live('click',function(){
			$('.leader-search-results,.leader-initial').hide()
			$('.leader-saved-results').slideDown(150)//.highlight()
		return false
		})
		
		clear.live('click',function(){

			$('.leader-search-results').hide()
		return false
		})
		
		edit.live('click',function(){

			searchGroup.slideDown()
		return false
		})

		$('.clear-group').live('click',function(){
			searchGroup.hide()
			return false
		})
		
		$('.save-group').live('click',function(){
			searchGroup.hide()
			$('.initial-edit').find('.highlighted .span4,.highlighted .span5').highlight()
			return false
		})
		
		$('.edit-initial-info2 a').live('click',function(){

			searchGroup2.slideDown()
		return false
		})
		
		$('.clear-group2').live('click',function(){
			searchGroup2.hide()
			$('.leader-search-results,.leader-saved-results').hide()
			return false
		})
		
		$('.save-group2').live('click',function(){
			searchGroup2.hide()
			$('.leader-search-results,.leader-saved-results').hide()
			$('.initial-edit2').find('.highlighted .span4,.highlighted .span5').highlight()
			return false
		})
	}
	leaderSection($('.leader-search'),$('.leader-save-selection'),$('.leader-clear'),$('.edit-initial-info a'))
	
	
	$('.edit-initial-info a,.edit-initial-info2 a').hover(function(){
		rows = $(this).closest('[class^=initial]').find('.highlighted .span4,.highlighted .span5')
		rows.css('background','#E6F4FF')
	},function(){
		rows.removeAttr('style')
	})
	
	$('.derivative-select').change(function(){
		
		if($(this).val() == '3'||$(this).val() == '4'||$(this).val() == '5'  ){
			//hide others
			val = $(this).val()
			$('.conditional-type-variable').text(val)
			$('.hedgeDesignation,.contractClass,.hedgeProgram,.taxDesignation').hide()
			$('.hedgeDesignation,.contractClass').show().highlight();

		}else if($(this).val() == '1'||$(this).val() == '2'){
			//hide others
			$('.conditional-type').hide()
			$('.hedgeDesignation,.contractClass,.hedgeProgram,.taxDesignation').hide()
			$('.hedgeProgram').show().highlight();
			//hedgeDesignation
		}else{
			$('.hedgeDesignation,.contractClass,.hedgeProgram,.taxDesignation').hide()
		}
		if($(this).val() == '5'){
			$('.hedgeDesignation').hide()
		}
		
		if(($("#hedgeDesigationId").val() != '3'&& $("#hedgeDesigationId").val() != '1' && $("#hedgeDesigationId").val() != '2' && $("#hedgeDesigationId").val() != '5')){
			$('.hedgeProgram').hide()
		}
	})
	
	$('.hedgeDesignation-select').live('change',function(){
		if(($(this).val() == '3'||$(this).val() == '1'||$(this).val() == '2' ||$(this).val() == '5') && ($("#derivativeTypeId").val() == '1' || $("#derivativeTypeId").val() == '2')){
			$('.hedgeProgram').show().highlight();
		}else{
			$('.hedgeProgram').hide()
		}
	})
	

	
	$('.derivativesConditional input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked')
		if(value.hasClass('condition')){
			$('#derivatives-table').fadeIn()
		}else{
			$('#derivatives-table').hide()
		}
	})
	
	
	$('.exceptionsConditional input:radio').change(function(){
		var value = $(this).filter('[class=condition]:checked')
		var container = $(this).parent().next('[class*="conditional"]')
		
		if(value.hasClass('condition') ){
			$('.exceptions-conditional').show()
			//container.highlight();
		}else{
			$('.exceptions-conditional').hide()
		}
	})
	
	
	
	
	////////////////////////
	//attach modal
	////////////////////////
	function attachModal(att,save){
	
	/* $('.modal-backdrop ').one("mouseenter",function(){
		$('#attach table').fixedHeader({height: 280})
	}) */
	
		att.click(function(){
			//alert("test"+$(this).parent().prev().prev(':contains("Other")').html())
			
			if($(this).parent().prev().prev(':contains("Other")').html() == "Other Documents"){
				text = $(this).parent().prev().prev().text()
			//	alert("test1"+text)
			}else if($(this).parent().prev().prev(':has(".required")').html()){
				text = $(this).parent().prev().prev().text().slice(1)
					if(text=="Legal Agreements(s)" || text=="Consolidated Financial Statements" || text=="Corporate Governance Documents" || text=="Other Documents" || text=="Journal Entries") {
					//alert(legLen)
					if(legLen==1) {
					setDynamicRow(text);
					} 
				}
			}else{
				text = $(this).parent().prev().prev().text()
			}
		
			//text = $(this).parent().prev().prev().text().slice(1)
			$('#attach .modal-header h3 span').text(text)
			$('#attach .modal-body p span').text(text)
			$('.clicked').removeClass('clicked')
			$(this).addClass('clicked')
			$('.input-file-attach').val('')
			$('#attach table :checked').removeAttr('checked')
		})
		
		save.click(function(){
			var checked = $('#attach table :checked')
			var legNum = checked.parent().next().text()
			var file = $('.input-file-attach').val().slice(-50)
			var file = '<div class="uploaded-file"><span>X</span> - Leg '+legNum+' - <a href="#">...'+file+'</a></div>'
			var clicked = $('.clicked')
			var current = $('.clicked').parent().prev().find('div').length
			if(current <= 0){
					clicked.parent().prev().html(file)
				}else{
					clicked.parent().prev().append(file)
				}
			clicked.removeClass('clicked')
		})
		
		if ($.browser.msie) {
			$(".attach").css('marginLeft','+=18px');//dumb ie 
		}		
	}
	attachModal($('.attach'),$('#saveAttachment'))
	
	////////////////////////
	//add approvers modal
	////////////////////////
	function saveApprovers(){
		checked = $('#addApprover tbody :checked')
		group = checked.parent().next().text()
		name = checked.parent().next().next().text()
		
		
		htmlStr = ''
		htmlStr += '<tr>'
		htmlStr += '<td><a class="delete-tr" title="Delete this Approver" href="#">X</a></td>'
		htmlStr += '<td>'+name+'</td>'
		htmlStr += '<input type="hidden" name="aName" value="'+name+'">' 
		htmlStr += '<input type="hidden" name="group" value="'+group+'">' 
		htmlStr += '<td>Current User Name</td>'
		htmlStr += '</tr>'
			
		$(htmlStr).appendTo('.approver-table tbody')
	
		tableBody = $('.approver-table tbody')		
		tableBody.find('.even').removeClass('even')			
		tableBody.find('tr:even').addClass('even');//dumb ie 
	}
	$('#saveApprovers').live('click', saveApprovers)

	//pipeline managmenet tables
	////////////////////////////
	function pipline(){
		val = $(this).val()
		var command = "showNoChart";
		var url= contextURL+"/pipelineReview/pipelineReviewView.do?command=";
		
		switch(val){		
			case "Show below":
				command = "showBelowChart";
			break;
			case "Show to side":
				command = "showSideChart";
			break;
		}
		var param = "&pipelineType=FO";
		url = url + command + param;
		$("#pipelineInboxForm").attr("action",url);
		$("#pipelineInboxForm").submit();

		/*tableContainer = $('.pipeline-management-tables')
		tableContainer.find('.active').removeClass('active')
		tableContainer.find('table').addClass('inactive').removeAttr('style')
		$('.ledgend').removeAttr('style')
		$('.ledgend1').removeAttr('style')
		$('.ledgend2').removeAttr('style')
		
		$('table[data-toggle="'+val+'"]').fadeIn(100)
		$('div[data-toggle="'+val+'"]').fadeIn(100)

		if($('table[data-toggle="'+val+'"]')){
			$($('table[data-toggle="Show to side"]')).css('background','#fff')
		}*/
	}
	function pipeline(){
		val = $(this).val()
		var command = "showNoChart";
		var url= contextURL+"/pipelineReview/pipelineReviewView.do?command=";
		
		switch(val){		
			case "Show below":
				command = "showBelowChart";
			break;
			case "Show to side":
				command = "showSideChart";
			break;
		}
		var param = "&pipelineType=MO";
		url = url + command + param;
		$("#pipelineInboxForm").attr("action",url);
		$("#pipelineInboxForm").submit();
	}
	$('.chart-select').change(pipline)
	
	$('.chart-select-mo').change(pipeline)
	
	$('.submit-box .btn-large').click(function(){
		checked = $('.submit-box .radio-container input:checked')
		var isModal = false;
		if(checked.hasClass('make-modal')){
				$('#sendback').modal('show')
				isModal=true;
		}
		if(checked.hasClass('make-modal')){
			$('#approveOverride').modal('show')
			isModal=true;
		}
		if(checked.hasClass('sendforward')){ //approve with mod
				$('#sendforward').modal('show')
				isModal=true;
		}
		if(checked.hasClass('approveWithMod')){ //approve with mod
				$('#approveWithMod').modal('show')
				isModal=true;
		}
		if(checked.hasClass('rejectRequest')){ //reject
				$('#rejectRequest').modal('show')
				isModal=true;
		}
		if(checked.hasClass('assignReviewer')){ //assign
				$('#assignReviewer').modal('show')
				isModal=true;
		}
		if(checked.hasClass('approveOnBehalf')){ //assign
				$('#approveOnBehalf').modal('show')
				isModal=true;
		}
		if(checked.hasClass('rejectOnBehalf')){ //assign
				$('#rejectOnBehalf').modal('show')
				isModal=true;
		}
		if(checked.hasClass('sendToTESG')){ //assign
				$('#sendToTESG').modal('show')
				isModal=true;
		}
		if(checked.hasClass('sendToEboardroom')){ //assign
				$('#sendToEboardroom').modal('show')
				isModal=true;
		}
		if(checked.hasClass('certify')){ //assign
				$('#certify').modal('show')
				isModal=true;
		}
		if(checked.hasClass('sendDerivatives')){ //assign
				$('#sendDerivatives').modal('show')
				isModal=true;
		}
		if(checked.hasClass('closeOut')){ //assign
				$('#closeOut').modal('show')
				isModal=true;
		}
		if(checked.hasClass('override')){ //assign
				$('#override').modal('show')
				isModal=true;
		}
		if(checked.hasClass('sendToeBoardroom')){ //assign
			$('#sendToeBoardroom').modal('show')
			isModal=true;
		}
		if(checked.hasClass('sendbackToRiskUnderwriting')){ //assign
			$('#sendbackToRiskUnderwriting').modal('show')
			isModal=true;
		}
		if(checked.hasClass('approveRequest')){ //assign
			$('#approveRequest').modal('show')
			isModal=true;
		}
		if(checked.hasClass('sendForwardToTC')){ //sendForwardToTC
			$('#sendForwardToTC').modal('show')
			isModal=true;
		}

		return isModal?false:true;
	})
	
	
	$('.trade-ticket-expand').click(function(){
			$(this).toggleClass('expanded')
			$('.trade-ticket-container').fadeOut(150,function(){
			$(this).toggleClass('expanded').fadeIn(150)
			
		})
		return false
	})
	
	
	$('#applyToAllLegs input').change(function(){
		if($(this).hasClass('checked')){
			$(this).removeClass('checked')
		}else{
			$('#applyAssessment').modal('show')
			$(this).addClass('checked')
		}
	})
	
	$('.material-conditional input').live('change',function(){
		if($(this).hasClass('change-submitbox')){
			$('.material-condition').hide()
			
		}else{
			
			$('.material-condition').show()
			
		}
	})
	
	$('.check-all-behalf').change(function(){
		if($(this).hasClass('checked')){
		//remove all
			$(this).parent().next().find('input:checked').removeAttr('checked')
			$(this).removeClass('checked')
		}else{
		 //check all
			$(this).parent().next().find('input:not(:checked)').attr('checked','checked')
			$(this).addClass('checked')
		}
	})
	
	$('.check-all-draft').change(function(){
		if($(this).hasClass('checked')){
		//remove all
			$(this).parent().parent().parent().parent().next().find('input:checked').removeAttr('checked')
			$(this).removeClass('checked')
		}else{
		 //check all
			$(this).parent().parent().parent().parent().next().find('input:not(:checked)').attr('checked','checked')
			$(this).addClass('checked')
		}
	})
	
	$('.behalf-radio input:radio').live('change',function(){
		var value = $(this).filter(':checked')
		//var container = $(this).parent().siblings('[class*="conditional"]')
		
		if(value.hasClass('condition') ){
			$('.withmods-container').hide()
			$('.behalf-container').show().highlight();
			
		}else if(value.hasClass('withmods') ){
			$('.behalf-container,').hide()
			$('.withmods-container').show().highlight();
			
		}else{
			$('.behalf-container,.withmods-container').hide()
		}
	})
	
	$('.guarantee-conditional input:radio').live('change',function(){
		var value = $(this).filter(':checked')
		//var container = $(this).parent().siblings('[class*="conditional"]')
		if(value.hasClass('condition') ){
			//show guarantor container
			$('.guarantee-condition').show().highlight();
		}else{
			//hide guarantor container
			$('.guarantee-condition').hide()
		}
	})
	
	
	
	
	$('.approveRequest').click(function(){
		$('#approveRequest').modal('show')
	 return false
	})
	
	$('.reject-btn').click(function(){
		$('#rejectRequest').modal('show')
	 return false
	})
	
	$('.save-btn').click(function(){
		$('#rejectRequest').modal('show')
	 return false
	})
	
	$('.sendDerivatives').click(function(){
		$('#sendDerivatives').modal('show')
	 return false
	})
	
	$('.closeOut').click(function(){
		$('#closeOut').modal('show')
	 return false
	})
	
	$('.sendBack').click(function(){
		$('#sendback').modal('show')
	 return false
	})
	$('.approveOverride').click(function(){
		$('#approveOverride').modal('show')
	 return false
	})
	
	
	///////////////////////////
	//Nested table
	///////////////////////////	
	function nestedTables(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					/* nestedTable.css({position:'absolute',display: 'block',left: '20px',top: position}) */
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		
		$('.table-nested .header').click(function(){
			//nestedSiblings()
			$('.nested:visible').removeAttr('style')
			$('.table-nested tbody tr').removeAttr('style')
			$('.table-nested .expanded').removeClass('expanded')
		})
	}
	function nestedTables3(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested3 tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested3 tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested3 tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		$('.table-nested3 .header').click(function(){
			$('.nested:visible').removeAttr('style')
			$('.table-nested3 tbody tr').removeAttr('style')
			$('.table-nested3 .expanded').removeClass('expanded')
		})
	}
	function nestedTables4(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested4 tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested4 tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested4 tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		$('.table-nested4 .header').click(function(){
			$('.nested:visible').removeAttr('style')
			$('.table-nested4 tbody tr').removeAttr('style')
			$('.table-nested4 .expanded').removeClass('expanded')
		})
	}
	function nestedTables5(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested5 tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested5 tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested5 tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		$('.table-nested5 .header').click(function(){
			$('.nested:visible').removeAttr('style')
			$('.table-nested5 tbody tr').removeAttr('style')
			$('.table-nested5 .expanded').removeClass('expanded')
		})
	}
	function nestedTables6(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested6 tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested6 tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested6 tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		$('.table-nested6 .header').click(function(){
			$('.nested:visible').removeAttr('style')
			$('.table-nested6 tbody tr').removeAttr('style')
			$('.table-nested6 .expanded').removeClass('expanded')
		})
	}
	function nestedTables7(){
		function nestedSiblings(){
			$('.nested:visible').each(function(){
				id = $(this).attr('id')
				nestedHeight = $(this).outerHeight()
				relatedRow = $('.table-nested7 tbody').find('a[data-nested="'+id+'"]').closest('td') 
				relatedHeight = relatedRow.height() - nestedHeight+18
				relatedTop = relatedRow.position().top + relatedHeight 
				$(this).css({top: relatedTop })
			})
		}
		$('.table-nested7 tbody .exp').bind('click',function(){
			row = $(this).closest('tr')
			rowHeight = row.height()
			nestedId = $(this).data('nested')
			position = $(this).position().top + rowHeight - 11
			nestedTable = $(this).closest('div').siblings('#'+nestedId +'')
			nestedTableHeight = $(this).closest('div').siblings('#'+nestedId +'').outerHeight()
			
			if($(this).hasClass('expanded')){
				nestedTable.removeAttr('style')
				$(this).removeClass('expanded')
				row.stop().animate({height: '-='+nestedTableHeight+'px'},150, function(){
					nestedSiblings()
				})
			}else{
				$(this).addClass('expanded')
				function placeTable(){
					nestedTable.css({position:'absolute',display: 'table',top: position})
				}
				row.stop().animate({height: '+='+nestedTableHeight+'px'},250, function(){
						placeTable()
						nestedSiblings()
				})	
			}
			return false
		}) 
		$('.table-nested7 tbody .delete-tr').bind('click',function(){
			$('.nested:visible').removeAttr('style')
		})
		$('.table-nested7 .header').click(function(){
			$('.nested:visible').removeAttr('style')
			$('.table-nested7 tbody tr').removeAttr('style')
			$('.table-nested7 .expanded').removeClass('expanded')
		})
	}
	
	nestedTables()
	nestedTables3()
	nestedTables4()
	nestedTables5()
	nestedTables6()
	nestedTables7()
	
	
	function killNested(){
		$('.nested:visible').removeAttr('style')
			$('.table-nested tbody tr').removeAttr('style')
			$('.table-nested .expanded').removeClass('expanded')

	}
	
	///////////////////////////
	// Treeview
	///////////////////////////
	function tree(tree,exp){
		if(tree){
			var li = tree.find('li')
			li.each(function(){
				if($(this).children('ul').length > 0 ){
					$(this).append('<span class="collasped"></span>')
				}
				$(this).children('.collasped').click(function(){
					var ul = $(this).parent().children('ul')
					ul.slideToggle(100)
				})
			})
			exp.live('click', function(){
				$(this).parents('.row').find('.treeview').find('ul').show().next().addClass('expanded')
				return false
			})
		}  
		$(".treeview > li > ul > li:even").addClass('even')
		$(".treeview > li > ul > li > ul > li:odd").addClass('odd')	
	}
	tree($('.treeview'),$('.expandAll'))
	
	
	
	//////////////////////
	// LE Search
	/////////////////////
	$('.entity-filtervalue').keypress(function(e) {
    if (e.which === 13) {
      e.preventDefault();
      return $(this).siblings('.entity-lookup').click();
    }
	});

	function isentityValid(filterName, requestedEntity){
		
		var isvalid = true;
		
		var checkNoValidate = $(".entity-lookup.current");
		
		if($(checkNoValidate).hasClass("novalidate"))
			return isvalid;
		
		$(".entity-lookup").each( function(){
						
			if($(this).hasClass('current')){				
					return true;
			}
            var e = $(this).parents(".entitylookup");
			var goldId = $(e).find("input.leGoldId").val()			
    	    var cdr = $(e).find("input.cdrCd").val()		
                                                    
			if(filterName === 'CDR' && cdr === requestedEntity)
				isvalid = false;
			else if(filterName === 'Gold ID' && goldId === requestedEntity)
			    isValid = false;	

		})
		return isvalid;
	}
	
	$(".entity-lookup").click(function() {
	    var data, f_name, f_value, req_elem, url, dup_elem;
	    var s_container = $(this).closest('.search-container');
	    f_name = $(s_container).find('.entity-filtername').val();
	    f_element=$(s_container).find('.entity-filtervalue');
	    f_value = $(f_element).val();
	    
	    req_elem = $(this).prev('.req-error');
	    dup_elem = $(this).siblings('.duplicate');

	    $("#lookup .modal-body > .alert-danger").hide();
	    if (f_value === "") {
	      $(req_elem).show();
	      return;
	    }
	    $(req_elem).hide();
	    $(dup_elem).hide();
	    $(this).addClass('current');

	    var isvalid = isentityValid(f_name, f_value);
	    if(!isvalid){
	    	$(dup_elem).show();
	    	 $(req_elem).show();
	    	return;
	    } 
            
            $(f_element).addClass("loading");
	    url = contextURL + "/lookup.do?cmd=" + $(this).data("cmd");
	    data = {
	      "for": f_name,
	      q: f_value
	    };
	    $("#lookup .form-row").load(url, data, function(response, status, xhr) {
	      var el, ln;
	      ln = $(response).find('table tbody tr').length;
	      el = $(".entity-lookup.current").parents('.entitylookup').find(".notfound").hide();
	      $(".entity-lookup.current").siblings("input:text").removeClass("loading");
	     //kavitha fix reverted for Assignment Issue(Not able to create Leg)
		//$(".entity-lookup.current").siblings("input:text").val("");
	      
	      if (ln === 0) {
	        $(el).show();
	        $(".entity-lookup.current").prev('.req-error').show();
	      } else if (ln === 1) {
	        updateEntity($(response).find('.selectEntity').val());
	      } else {	    	
	        $("#lookup").modal('show');
	      }
	    });
	  });

	  updateEntity = function(obj) {
	    var fromObj, toObj;
	    fromObj = $.parseJSON(obj);
	    toObj = $(".entity-lookup.current").parents('.entitylookup');
	    $(toObj).find('.conditional-row:first, .clear-conditional-results:first').show();
	    $.each(fromObj, function(i, val) {
	      $(toObj).find('.' + i).each(function() {
	        if ($(this).hasClass("radio-container")) {
	          $(this).find(':radio').each(function() {
	            var curItem;
	            if ('true' === $(this).val()) {
	              curItem = true;
	            } else {
	              curItem = false;
	            }
	            if (curItem === val) {
	              $(this)[0].checked = true;
	            }
	          });
	        } else if ($(this).is("input")) {
	          $(this).val(val);
	        } else {
	          $(this).html(val != null ? getBooleanIfNeeded(val) : '-');
	        }
	      });
	    });
	    $(".entity-lookup.current").siblings("input:text").removeClass("loading");
	    var me_dom = $(toObj).find(".ME input");
	   	verifyME(fromObj.leGoldId, me_dom);		
	    $(".entity-lookup").removeClass('current');
	  };

	  function verifyME(le, me_dom){
	  	var empty = [null, "", "-"];
	  	var me = $(me_dom).val();

	  	if( $.inArray(me, empty) >= 0 )
	  		return false;

	  	var data, url;
	    url = contextURL + "/lookup.do?cmd=getME";
	    data = {
	      cmd: "getME",
	      LE: le,
	      q: me
	    };


	    $.get( url, data, function(response){
    		var meList = $(response).find('.selectEntity');
    		var isavailable = false;
    		$(meList).each( function (){
    			var jsonObj = $.parseJSON($(this).val());
    			if( jsonObj.meGoldId === me )
    				isavailable = true;   			

    		});
            
            var form_row = $(me_dom).parents(".ME").prev(".row").find(".form-row:first");
			var error_block = $(form_row).find(".help-block.error");
    		var error_bar = $(form_row).find(".req-error");
    			
    		if( !isavailable ){
    			$(error_block).empty().html("Invalid LE ME combination").show();
    			$(error_bar).show();
    		}else{
    		    $(error_block).hide();
    		    $(error_bar).hide();
    		}

	    });

	  }

	  $(".saveSelectEntity").click(function() {
	    var el, err;
	    el = $(".selectEntity:checked");
	    err = $(this).parents().filter(".modal").find(".modal-body > .alert-danger");
	    if ($(el).length < 1) {
	      $(err).show();
	      return;
	    }
	    var whichElement = $(el).attr("name");

	    if( whichElement === "selectMEEntity"){
	    	updateMEEntity( $(el).val() );		    	
	    }else if( whichElement === "selectTcode"){
	    	var activeTcode = $(".addtcode.active").data("tcode");
	    	activeTcode.update( $(el).val() );
	    	$(".addtcode.active").removeClass("active");
	    }else{	    	
	    	updateEntity($(el).val());
	    }
	    $("#lookup").modal('hide');
	  });
	  
	  getBooleanIfNeeded = function( val ){
		  
		  if ( typeof val === "boolean" ){
			  if( val === true)
				  return "Yes"
			  else
				  return "No"			  
		  }else
			  return val;
	  }


/////////////////
/////// Search ME
/////////////////
var ME_row, loadME, updateMEEntity;

  $(".me-lookup").click(function() {
    var le, le_val, query;
    query = $(this).siblings("input:text").addClass("loading").val();
    le = $(this).parents(".entitylookup").find("p.leGoldId");
    if ($(le).is(":visible")) {
      le_val = $(le).html();
    } else {
      le_val = "";
    }
    $(this).addClass("current");
    return loadME(le_val, query);
  });

  loadME = function(le, me) {
    var data, url;
    url = contextURL + "/lookup.do?cmd=getME";
    data = {
      cmd: "getME",
      LE: le,
      q: me
    };
    $("#lookup .form-row:first").load(url, data, function(response, status, xhr) {
      var ln;
      ln = $(response).find('table tbody tr').length;
      $(".me-lookup.current").siblings("input:text").removeClass("loading");
      $(".me-lookup.current").siblings("input:text").val("");
      if (ln === 1) {
        updateMEEntity($(response).find('.selectEntity').val());       
      } else {
        $("#lookup .me-entity").val(me);
        $("#lookup .le-goldid").html(le);
        $("#lookup").modal("show");
      }
    });
  };

  updateMEEntity = function(obj) {
    var bsElement, clearResults, des, entityBlock, fromObj, le, toObj;
    fromObj = $.parseJSON(obj);
    toObj = $(".me-lookup.current").closest(".row").next(".conditional-row");
    $(toObj).show();
    des = $(toObj).find(".form-row");
    $(des).find("p").html(fromObj.meGoldId);
    $(des).find("input").val(fromObj.meGoldId);
    entityBlock = $(".me-lookup.current").closest(".entitylookup");
    bsElement = $(entityBlock).find(".businessSegment");
    $(bsElement).each(function() {
      if ($(this).is(":input")) {
        return $(this).val(fromObj.businessSegment);
      } else {
        return $(this).html(fromObj.businessSegment);
      }
    });
    clearResults = $(".me-lookup.current").siblings(".clear-conditional-results:hidden");
    clearResults.show();
    le = $(entityBlock).find("p.leGoldId");
    //tcode = $(".me-lookup.current").closest(".row").next().next().find("input[data-provide=typeahead]");
    //getTcode($(le).html(), fromObj.meGoldId, tcode);
    $(".me-lookup.current").siblings(".req-error").hide();
    $(".me-lookup.current").siblings(".error").hide();
    return $(".me-lookup").removeClass("current");
  };

  $("#lookup .form-row").on("click", ".searchme", function() {
    var data, searchRow, url;
    searchRow = $(this).closest(".row").prev(".row");
    url = contextURL + "/lookup.do?cmd=getME #results";
    var leGoldID = $(searchRow).find(".le-goldid").html();
    if(leGoldID==null || leGoldID== undefined)
    {
    	leGoldID = 	$("#leGoldID").val();
    }
    
    var meEntity = $(searchRow).find(".me-entity").val();
    if(meEntity==null || meEntity == undefined)
    {
    	meEntity = 	$("#mEntityID").val();
    }
    
    var bsFilter = $(searchRow).find(".bs-filter").val();
    if(bsFilter==null || bsFilter == undefined)
    {
    	bsFilter = 	$("#bSegmentID").val();
    }   
    data = {
      LE: leGoldID,
      q: meEntity,
      BS: bsFilter
    };
   
    $("#lookup .form-row #results").load(url, data, function(response, status, xhr){
    	updateValues($(response).find('#meRecordCountID').val(),1); 
    });
     return true; 
  });
  
  function updateValues(recordCount,pageStart)
  {
		showNextButton(recordCount);
		showPreviousButton(pageStart);
		$("#results").removeClass("loading");  
  }

  function showPreviousButton(prevPageStart)
  {
		if(prevPageStart>300)
		{
			$("#mePreviousID").show();
		}else{
			$("#mePreviousID").hide();
		}
  }
     
 function showNextButton(recordCount)
 {
	 if(recordCount>=300){
			$("#meNextID").show();
		}else{
			$("#meNextID").hide();	
		}
 }
 

  ME_row = $(".entitylookup > .ME.conditional-row");

  $(ME_row).each(function() {
    if ($(this).find("p").html() !== "") {
      $(this).show();
      $(this).parents(".entitylookup").find(".me-lookup").next(".clear-conditional-results").show();
    }
  });
	$(".me-lookup").siblings("input").keypress(function(e){
  	if(e.which === 13){
  		e.preventDefault();
  		$(this).siblings(".me-lookup").click();
  	}
  });

  

  $(".tcode").each( function(){
  		var v = $(this).find("input").val();
  		if( typeof v != 'undefined' && v !== ""){  			
  			var t = $(this).parents(".conditional-row");
  			t.show();
  			t.prev(".row").find(".clear-conditional-results").show();
  		}
  });	

  $(".addtcode").siblings("input").keypress( function(e){
  	if(e.which === 13){
  		e.preventDefault();
  		$(this).siblings(".addtcode").click();	
  	}  	
  });
 	

  $("#clearCPALenderTreasury, #clearCPALenderTreasuryFO").click( function(){
  	//ajax call
  	var a = $(this);
  	
  	$.post( contextURL + "/lookup.do?cmd=clearCPATCode", function(data){
  	    conditionalRow = a.closest('.row').next('.conditional-row')
		conditionalRow.slideUp("fast")				
		a.hide()
		a.siblings('input').val('')		
		conditionalRow.find('input').remove()
		conditionalRow.find('.tcode p:not(:first)').remove()
		conditionalRow.find('.bankName p:not(:first)').remove()				
  	});
  	
  	
  	//clear-conditional-results
  });	

})
	
 		 

 	function checkMultiExtension(fileUrl) {
	    var validMultiExtensions = new Array("<",">",":","&","?","'","//","/\\","//|","%","+","=","#",".");
	    var filename =  fileUrl.substring(fileUrl.lastIndexOf("\\") + 1, fileUrl.length);
	    var allowSubmit = false;
	        for (var i = 0; i < validMultiExtensions.length; i++) 
	        {
	        	if(validMultiExtensions[i]==".") {
	        	var firstpos=filename.indexOf(validMultiExtensions[i]);
	        	var dotpos=filename.lastIndexOf(validMultiExtensions[i]);
	
	        	if (firstpos == dotpos) 
	            { 
	                allowSubmit = true;
	            }
	        	} else {
	        		if(filename.indexOf(validMultiExtensions[i])!=-1) {
	        			allowSubmit = false;
	        			break;
	        		}
	        	}
	        }
	        if(allowSubmit==false) {
	        	alert("Application does not support special characters like <>:/\|?*'%.+&=# in the file name.Please rename the file and try again.");
	        }
	       return allowSubmit;
		}
	

	function checkFileExt(mime) 
	{
    var type = "";
    var validExtensions = new Array(".doc", ".docx", ".docm",".xml",".html",".htm", ".dotx",".dotm",".dot",".rtf",".txt",".odt",".wpd",".wps",".zip",".xls",".xlsx",".ppt",".pptx",".pdf",".msg",".DOC", ".DOCX", ".DOCM",".XML",".HTML",".HTM", ".DOTX",".DOTM",".DOT",".RTF",".TXT",".ODT",".WPD",".WPS",".ZIP",".XLS",".XLSX",".PPT",".PPTX",".PDF",".MSG");
    var allowSubmit = false;
        for (var i = 0; i < validExtensions.length; i++) 
        {
            if (validExtensions[i] == mime) 
            { 
                allowSubmit = true;
            }
        }
        if(allowSubmit==false) {
        	alert("Wrong filetype, .doc, .docx, .docm , .xml, .html, .htm, .dotx, .dotm, .dot, .dotx, .rtf, .txt, .odt, .wpd, .wps, .zip, .xls, .xlsx, .ppt, .pptx, .msg, .pdf Extensions are valid. ");
        }
       return allowSubmit;
	}

	function checkFileExtForBoard(mime) 
	{
	var type = "";
	var validExtensions = new Array(".doc", ".docx", ".rtf",".xls",".xlsx",".ppt",".pptx",".pdf",".zip",".DOC", ".DOCX", ".DOTX",".RTF",".XLS",".XLSX",".PPT",".PPTX",".PDF",".ZIP");
	var allowSubmit = false;
	    for (var i = 0; i < validExtensions.length; i++) 
	    {
	        if (validExtensions[i] == mime) 
	        { 
	            allowSubmit = true;
	        }
	    }
	    if(allowSubmit==false) {
	    	alert("Wrong filetype, .doc, .docx, .docm , .xml, .html, .htm, .dotx, .dotm, .dot, .dotx, .rtf, .txt, .odt, .wpd, .wps, .zip, .xls, .xlsx, .ppt, .pptx, .msg, .pdf Extensions are valid. ");
	    }
	   return allowSubmit;
	}
$(function() {      
	// Code between here will only run when the document is ready
	$("a#addAdditional").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#additionalTable tr:last").after('<tr><td><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="request-admin" name="inputValue" value="" maxlength="20"></td></tr>');
		return false;
	});
 });
$(function() {      
	// Code between here will only run when the document is ready
	$("a#editAddAdditional").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#editTable tr:last").after('<tr><td width="5"><input type="hidden" name="rowId" value=""><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="span2 request-admin" name="columnValue1" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue2" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue3" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue4" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue5" value="" maxlength="20"></td></tr>');
		return false;
	});
	
	// Code between here will only run when the document is ready
	$("a#editAddAdditional1").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#editTable tr:last").after('<tr><td width="5"><input type="hidden" name="rowId" value=""><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="span2 request-admin" name="columnValue1" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue2" value="" maxlength="100"></td></tr>');
		return false;
	});
	
	// Code between here will only run when the document is ready
	$("a#editAddAdditional2").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#editTable tr:last").after('<tr><td width="5"><input type="hidden" name="rowId" value=""><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="span2 request-admin" name="columnValue1" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue2" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue3" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue4" value="" maxlength="20"></td></tr>');
		return false;
	});
	
	// Code between here will only run when the document is ready
	$("a#editAddAdditional3").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#editTable tr:last").after('<tr><td width="5"><input type="hidden" name="rowId" value=""><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="span2 request-admin" name="columnValue1" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue2" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue3" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue4" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue5" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue6" value="" maxlength="20"></td></tr>');
		return false;
	});
	
	// Code between here will only run when the document is ready
	$("a#editAddAdditional4").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("table#editTable tr:last").after('<tr><td width="5"><input type="hidden" name="rowId" value=""><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td><td><input type="text" class="span2 request-admin" name="columnValue1" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue2" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue3" value="" maxlength="20"></td><td><input type="text" class="span2 request-admin" name="columnValue4" value="" maxlength="20"></td></tr>');
		return false;
	});
 });
$(function() {      
	// Code between here will only run when the document is ready
	$("#searchAdminTable").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$("#displayAdminTable").show();
	});	
 });



function scriptInjection(target) {
	if(target.value.length>0) {
		var content = target.value.toUpperCase();
		if ((content.indexOf("<SCRIPT") !=-1) || (content.indexOf("<\/SCRIPT>") !=-1)) {
			alert("Keywords <script> and <\/script> are not allowed.");
			target.focus();
		 }
	 }
}


function limit(what,chars,counter) {
	if (what.value.length > chars) {
	what.value=what.value.substr(0,chars);
	}
	}



String.prototype.trimString = function() {
	return this.replace(/^\s+|\s+$/g,"");
}

String.prototype.ReplaceAllText = function(stringToFind,stringToReplace){
    var temp = this;
    var index = temp.indexOf(stringToFind);
        while(index != -1){
            temp = temp.replace(stringToFind,stringToReplace);
            index = temp.indexOf(stringToFind);
        }
        return temp;
    }



var pageTitle ='';
$(document).ready(function() {
	pageTitle = $('.page-title').html();
	
	 });



function printContent()
{	
var printPageBody = document.getElementById("printPage");
var html = '<html><head>'+
'<style type="text/css">body { margin:30px!important;}</style>'+
'<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />'+
'<link href="css/site.css" rel="stylesheet" type="text/css" />'+
'<script src="js/jquery-1.7.1_min.js" type="text/javascript"></script>'+
'<script src="js/bootstrap.js" type="text/javascript"></script>'+
'<script src="js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>'+
'<script src="js/jquery-zdate.js" type="text/javascript"></script>'+
'<script src="js/jquery.autoresize.js" type="text/javascript"></script>'+
'<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>'+
'<link href="css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />'+
'</head><body style="background:#ffffff;"><h1 class="page-title span12">'+pageTitle+"</h1><BR>"+
printPageBody.innerHTML+
'</body></html>';
html = html.ReplaceAll('document.write(months[month] + ", "+ day + " " + year);','');
html = html.ReplaceAll('overflow-x: auto;','');
html = html.ReplaceAll('display: none;','display: block;');
var WindowObject = window.open();
WindowObject.document.writeln(html);
WindowObject.document.close();
WindowObject.focus();
WindowObject.print(); 
WindowObject.close();

}


function printContentSO()
{	
var printPageBody = document.getElementById("printPage");
var html = '<html><head>'+
'<style type="text/css">body { margin:30px!important;}</style>'+
'<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />'+
'<link href="../css/site.css" rel="stylesheet" type="text/css" />'+
'<script src="../js/jquery-1.7.1_min.js" type="text/javascript"></script>'+
'<script src="../js/bootstrap.js" type="text/javascript"></script>'+
'<script src="../js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>'+
'<script src="../js/jquery-zdate.js" type="text/javascript"></script>'+
'<script src="../js/jquery.autoresize.js" type="text/javascript"></script>'+
'<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>'+
'<link href="../css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />'+
'</head><body style="background:#ffffff;"><h1 class="page-title span12">'+pageTitle+"</h1><BR>"+
printPageBody.innerHTML+
'</body></html>';
html = html.ReplaceAll('document.write(months[month] + ", "+ day + " " + year);','');
html = html.ReplaceAll('overflow-x: auto;','');
html = html.ReplaceAll('display: none;','display: block;');
var WindowObject = window.open();
WindowObject.document.writeln(html);
WindowObject.document.close();
WindowObject.focus();
WindowObject.print(); 
WindowObject.close();

}

function exportToPDF(){
	   isChanged = false;
	   var randomnumber=Math.floor(Math.random()*11);
	   url = contextURL +"/attachmentAction.do?command=downloadUnderWritingFile&random="+randomnumber;
	   window.open(url,'UnderWritingFile','height=100,width=100');
 }



function callContactUs() {
	window.location.href = contextURL+"/contactUs/contactUs.do?command=contactUs";
}
function callHelp() {
	window.location.href = contextURL+"/help.do?command=help";
}



function checkME(validateflag){
	$('.me-lookup').each( function(){
		var e = $(this).siblings(".error");
		if( $(e).is(":visible") ){
			validateflag = true;
		}
	})
	return validateflag;
}

 function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
		var timeframe = $(obj).parents("td").next().find("div.form-row:nth-child(2)");
		if(status === '1')
			$(timeframe).find(".required").hide();
		else
			$(timeframe).find(".required").show();

	}


/**
 * Method to validate the Exceptions
 * @returns {Boolean}
 */
function istimeframe(obj){

	var el = $(obj).attr("name");
	if(el === "remediationTimeline")
		return true;
	return false;
}

function gettimeline(obj){
	var td = $(obj).parents("td").prev();
	return $(td).find("input:radio:checked").val();
}
function exceptionValidation () {
	var isvalid =true;
	$(".exception-validation").find(".request-exp").each(function(){

		$(this).parent().find(".req-error").remove();

		if( istimeframe(this) && gettimeline(this) === '1')
			return true;

		if($(this).val() ===''){
			$("<span class='req-error'>error</span>").insertBefore($(this));
			isvalid = false;
		}
	} );
	$(".exception-validation .radio-container").each(function(){	
		if($(this).find("input[type='radio']").is(":checked") == false){
			$(this).addClass("req-error");
		}else{
			$(this).removeClass("req-error");
		}
	});
	return isvalid;
}	


!function($){

	var tcode = function(element){
		this.element = $(element);
		this.inTCode = $(element).siblings("input");

		this.inTCodeVal = function(){
			return $(element).siblings("input").val().toUpperCase();
		}
		this.reqError = $(element).siblings(".req-error");
		this.helpError = $(element).siblings(".help-block.error").text("");
		this.toTcode = $(element).parents(".row").next().find(".tcode");
		this.toBankName = $(element).parents(".row").next().find(".bankName");
		this.assigntCodeName = $(element).data("assign");
		this.assignBankName = $(element).data("bankassign");
		this.LE = function() {
			return $(element).parents(".entitylookup").find("p.leGoldId").html();
		}
	}

	
	tcode.prototype = {	

		checkError: function(){
			hideError.call(this);
			
			var leVal = this.LE();
			if( leVal === "" || leVal === "-"){
				showError.call(this, "CDR/GoldID required to search TCode")
				return true;
			}				
				
			if( checkDuplicate.call(this) ){
				showError.call(this, "Tcode already selected");
				return true;
			}		

			this.inTCode.on('change', $.proxy( function(){
				if( this.inTCodeVal() == "") hideError.call(this)
			}, this))		 
			return false;
		}

		,lookup: function(){

			var url = contextURL + "/lookup.do?cmd=getTCode", that=this;
			data = {
				LE: this.LE(),
				TCODE: this.inTCodeVal()
			};
			that.inTCode.addClass("loading");

			$.get( url, data, function(results){

				var ln = $(results).find('table tbody tr').length;
				if( ln === 0){
					 showError.call(that, "Invalid Value");
				}else if(ln ===1){			
					updateTCode.call(that, $(results).find(".selectEntity").val());
				}else{					
					 that.element.addClass("active");	
					 $("#lookup .form-row:first").html(results);
					 $("#lookup").modal("show");
				}
				that.inTCode.removeClass("loading");				
			});

		}

		,update: function(objString){
			updateTCode.call(this, objString);
		}	
	}
/*Private methods
*/	
	function showError(errMsg){
		this.helpError.empty().append(errMsg).show();
		this.reqError.show();
	}
    
	function hideError(){
		this.helpError.hide();
		this.reqError.hide();
	}
	function checkDuplicate(){

		var isDuplicate = false, curVal, that = this;
		that.toTcode.each( function(){
			curVal = $(this).val().toUpperCase();

			if( curVal && that.inTCodeVal() && curVal === that.inTCodeVal() ){
				isDuplicate = true;
				return true;
			}
		});
		return isDuplicate;
	}

	function updateTCode( objString ){

		var bankObj = $.parseJSON( objString );
		var tcode = bankObj.treasuryCode;
		var bankName = bankObj.bankName;

		if(this.element.hasClass('alwaysone')){
			var f = this.toTcode.find("p");
			if(f.length === 1){
				$("<p></p>").html(tcode).appendTo(this.toTcode);	
			}else{
				f[1].innerHTML = tcode;
			}	
			this.toTcode.find("input").val(tcode);
		}else{
			$("<p></p>").html(tcode).appendTo(this.toTcode);
			htmlStr = "<input type=hidden name=" + this.assigntCodeName + " value=" + tcode + " />";
			$(htmlStr).appendTo(this.toTcode);	
			
			if(this.assignBankName){
				$("<p></p>").html(bankName).appendTo(this.toBankName);
				var oldBankName = $('input[name="'+this.assignBankName+'"]');
				var oldBankVal = oldBankName.val();
				if(oldBankVal == undefined || oldBankVal === ''){
					oldBankName.val(bankName);
				}else{
					oldBankName.val(oldBankVal+";;"+bankName);
				}
			}
			
		}
		this.toTcode.parents(".conditional-row").show();
		this.element.siblings(".clear-conditional-results").show();
		$("#clearCPALenderTreasury, #clearCPALenderTreasuryFO").show();
		hideError.call(this);
	}


 /* TCODE PLUGIN DEFINITION
  * ============================== */

  $.fn.tcode = function ( option ) {
    return this.each(function () {
      var $this = $(this)
        , data = $this.data('tcode')
      if (!data) $this.data('tcode', (data = new tcode(this)))
     })
  }

  /* TCODE DATA-API
  * ==================== */

  $(function () {
    $('body').on('click.tcode.data-api', '.addtcode',  function ( e ) {
      var $this = $(this)
      $this.tcode();
      var el = $this.data('tcode')
      if( !el.checkError() )
      	el.lookup();
    })
  })

}(window.jQuery)

/* Disable Right click */
$(function (){
	$(document).bind("contextmenu", function(e){
		e.preventDefault();
		return false;
	})
})