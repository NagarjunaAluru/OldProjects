var SITE = SITE || {};

SITE.fileInputs = function() {
  var $this = $(this),
	  $val = $this.val(),
	  valArray = $val.split('\\'),
	  newVal = valArray[valArray.length-1],
	  $button = $this.siblings('.file-btn'),
	  $fakeFile = $this.siblings('.file-holder');
  if(newVal !== '') {
	$button.text('File Attached');
	if($fakeFile.length === 0) {
	  $button.before('<span class="file-holder">' + newVal + '</span>');
	} else {
	  $fakeFile.text(newVal);
	}
  }
};

$(document).ready(function() {
	$(".file-wrapper input[type=file]").bind('change focus click', SITE.fileInputs);
	$("#topbar").dropdown()
	$(".tabs").tabs()
	$("table#sortTable").tablesorter({ sortList: [[1,0]] });
	$("#my-modal").modal('show')
	$(".tooltip").popover({trigger: 'focus',}) 
	
		if ($.browser.msie) {
			$('#searchBags')
		}

	$('.close-btn').click(function() {
		 $('a.close').click()
	});
	 $('.makealert').click(function() {
		 $('a.close').click()
		 $(".alert-message").alert().fadeIn(1500);
		});
	$('.meter-wrapper .progress').hide();
		$(".meter > span").each(function() {
		var w = ( 100 * parseFloat($(this).css('width')) / parseFloat($(this).parent().css('width')) ) + '%';
		$(this).width('0%').animate({width: w}, 2000, 'easeInOutCirc', function() { $('.meter-wrapper .progress').fadeIn(); } );
		});
	
	$( "#progressbar" ).progressbar({
			value: 50
		});
	$("#datepicker" ).datepicker({ 
		dateFormat: 'dd-mm-yy',
		duration: 300,
		showAnim: 'drop',
		changeMonth: true,
		changeYear: true,
		showOtherMonths: true,
		altField: "#alternate",
		altFormat: "mm-dd-yy"
	});
	
	//auto expanding text area
	$('textarea.autosize').autoResize({
		onResize : function() {
			$(this).css({opacity:0.8});// On resize:
		},
		animateCallback : function() {
			$(this).css({opacity:1});// After resize:
		},
		animateDuration : 300,  
		extraSpace : 40 // More extra space:
	});
	$("tr:odd").addClass("odd");//dumb ie
	
	//absolute centering on page
	$('.modal').each( function(){
		jmodal = $(this)
		new_width = jmodal.outerWidth() / 2;
		new_height = jmodal.outerHeight() / 2;
		jmodal.css("marginTop",'-'+new_height+"px").css("marginLeft", '-'+new_width+"px");
	})
	
	//corrects the top margin after results are added to modal table
	$('.modal-search').click(function() {
		$('.modal table').animate({
			opacity: 'show',
			height: 'show'             
			}, 200, function() {
				new_height = jmodal.outerHeight() / 2;
				jmodal.animate({marginTop: '-'+new_height+"px"});
			});
	return false
	})
	
	//Counter for text area limit
	function textareaCounter() {
		var maxchar = 400;
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		var counter = $(this).parent().prev()
		counter.html(remainingchar);
		if(remainingchar > 0){
			counter.css('color', '#7FC47E');
		}else{
			counter.css('color', '#8E0000');
		}
		if(cnt > 50){
			counter.css('top','-20px')
		}else if(cnt < 50) {
			counter.css('top','0px')
		}
	}
	
	$('#textarea-count1').bind('keyup', textareaCounter);
	$('#textarea-count2').bind('keyup', textareaCounter);
	
	
	
	//counter for BAG search results
	function countChecked() {
		var checked = $("table :checkbox:checked")
		var n = checked.length;
		$(".count").text(n);
if($('.count').text() == 0){
			$('#savebags').addClass('disabled');
		} if($('.count').text() > 0){
			$('#savebags').removeClass('disabled');
		}
		
	}
	countChecked();	
	$("table :checkbox, #searchBags").click(countChecked);
	
	//add classes to the checked groups
	function selectBags(){
	var bagSelected = 'bag-selected'
	var businessGrp = $(this).parent().next()
		if(businessGrp.hasClass(bagSelected)){
			businessGrp.removeClass(bagSelected);
		}else{
			businessGrp.addClass(bagSelected);
			}
		}
	$("table#select-bags :checkbox").change(selectBags)
	
	//remove checks on load for refreshes
	$("table :checkbox:checked").removeAttr("checked")
	function appendBags() {
		$('a.close').click()
		$(".alert-message").alert().fadeIn(1500);
	}	
	
	
	//push results to table
	$('#savebags').click( function() {// change to SAVE BAGS buttons when finished
		if ($('.noresults').length > 0){$('.noresults').remove();}
		
		$('.bag-selected').each( function(){
			var bagName = $(this).text()	
			$('.results-table tbody').prepend('<tr><td class="bin"><a href="#"><img src="img/bin.gif"/></a></td><td> '+ bagName +' </td></tr>');
		})

		if ($('.results-table').length > 0){ //put table in if not there
				$('.results-table').fadeIn();
		}
		$('table :checkbox:checked').removeAttr("checked").parent().next().removeClass("bag-selected");

		
		//check to see if alert is there and add the amount added to the table
		//$(".alert-message").alert().is(":visible")
		
		//
	});
	$('#savebags').click(appendBags);
	


	var newDate = $(".ui-datepicker-month option:selected").text(); //grab initial date
	var month = $("#monthpicker");
	var monthOverlay = $(".month-overlay");

	$('.ui-datepicker-header').append("<div class='month-overlay'></div>")
	.die().find(".month-overlay").append('<span class="fakemonth">' + newDate + '</span>').live('click', function() {
		var el = $(".ui-datepicker-month")
		var options = $('option', el);
		var jshow = 
		month.animate({opacity: 'show', height: 'show'},300)
		//	$('#datepicker .ui-datepicker table').animate({opacity: 0.5}, 'fast')
		
		var links = month.children()
		if (links.length == 0){	
			options.each(function(){  //clean up and make appened once, not on click
				month.append("<a class='cli' href='" + $(this).val() + "'>" + $(this).text() + "</a>"); 
			});
		}
		
		$("a.cli").click(function(event){ //when anchor is clicked
			event.preventDefault();
			
			month.animate({opacity: 'hide',height: 'hide' },300)
			

			
		var fakeDate = $(".fakemonth")
			$(".ui-datepicker-month").val($(this).attr('href')).change();// .change() changes the dates for the calendar
			$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
			var newDate = $(".ui-datepicker-month option:selected").text();
			$(".month-overlay").append('<span class="fakemonth">' + newDate + '</span>');
			
			$('.ui-datepicker-header').append("<div class='year-overlay'></div>");
			var newYear = $(".ui-datepicker-year option:selected").text();
			$(".year-overlay").append('<span class="fakeyear">' + newYear + '</span>');
			$("tr:odd").addClass("odd");//dumb ie 
		});  
	});
	
	var newYear = $(".ui-datepicker-year option:selected").text(); //grab initial date
	var year = $("#yearpicker");
	var yearOverlay = $(".year-overlay");
	$('.ui-datepicker-header').append("<div class='year-overlay'></div>")
	.die().find(".year-overlay").append('<span class="fakeyear">' + newYear + '</span>').live('click', function() {
		var el = $(".ui-datepicker-year")
		var options = $('option', el);
		year.animate({opacity: 'show',height: 'show'},300)
			
		var links = year.children()
		if (links.length == 0){		
			options.each(function(){  //clean up and make appened once, not on click
				year.append("<a class='cli' href='" + $(this).val() + "'>" + $(this).text() + "</a>"); 
			});
		}
		$("a.cli").click(function(event){ //when anchor is clicked
			event.preventDefault();
			
			year.animate({opacity: 'hide',height: 'hide'},300)
			
			var fakeYear = $(".fakeyear")
			$(".ui-datepicker-year").val($(this).attr('href')).change();// .change() changes the dates for the calendar
			$('.ui-datepicker-header').append("<div class='year-overlay'></div>");
			var newYear = $(".ui-datepicker-year option:selected").text();
			$(".year-overlay").append('<span class="fakeyear">' + newYear + '</span>');
			
			$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
			var newDate = $(".ui-datepicker-month option:selected").text();
			$(".month-overlay").append('<span class="fakemonth">' + newDate + '</span>');
			$("tr:odd").addClass("odd");//dumb ie
		});  
	});	
	
	
	$('.ui-state-default').live('click', function() {
		if (!$(".month-overlay").length){
			$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
		}
		if (!$(".year-overlay").length){
			$('.ui-datepicker-header').append("<div class='year-overlay'></div>");
		}
		
		var newDate = $(".ui-datepicker-month option:selected").text(); //to keep the current month consistent
		$(".month-overlay").append('<span class="fakemonth">' + newDate + '</span>');
		var newYear = $(".ui-datepicker-year option:selected").text(); //to keep the current year consistent
		$(".year-overlay").append('<span class="fakeyear">' + newYear + '</span>');
	})	
});
