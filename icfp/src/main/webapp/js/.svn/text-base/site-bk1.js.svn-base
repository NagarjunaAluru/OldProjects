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
	$('.file-wrapper input[type=file]').bind('change focus click', SITE.fileInputs);
	$('#topbar').dropdown()
	$('.tabs').tabs()
	$("table#sortTable").tablesorter({ sortList: [[1,0]] });
	$('#my-modal').modal('show')
	$('.tooltip').popover({trigger: 'focus',}) 
	$( "#datepicker" ).datepicker({ 
			dateFormat: 'dd-mm-yy',
			duration: 300,
			showAnim: 'drop',
			changeMonth: true,
			changeYear: true,
			altField: "#alternate",
			altFormat: "DD, d MM, yy"
			});
	
	$("tr:odd").addClass("odd");//dumb ie
	
	if ($.browser.msie){
		$('.nav .active > a').css('background','none');
		$('.dropdown a').hover(function() {
			$(this).addClass('iefix');
		}, function(){
			$(this).removeClass('iefix');
		})
	}//dumb ie - remove background color to use filter for opacity - UNDER CONSTRUCTION
	
	jmodal = $('.modal')	
	new_width = jmodal.outerWidth() / 2;
	new_height = jmodal.outerHeight() / 2;
	jmodal.css("marginTop",'-'+new_height+"px").css("marginLeft", '-'+new_width+"px");
	//absolute centering on page

	$('.modal-search').click(function() {
		$('.modal table').animate({
			opacity: 'show',
			height: 'show'             
			}, 200, function() {
				new_height = jmodal.outerHeight() / 2;
				jmodal.animate({marginTop: '-'+new_height+"px"});
			});
	return false
	})//corrects the top margin after results are added to modal table
	
	//Counter for text area limit
	$('#textarea-count').bind('keyup', function() {
		var maxchar = 4000;
		var cnt = $(this).val().length;
		var remainingchar = maxchar - cnt;
		$('#charCount').html(remainingchar);
		if(remainingchar > 0){
			$('#charCount').css('color', 'green');
		}else{
			$('#charCount').css('color', 'red');
		}
	});
	

	//changed the required field to gree once characters are entered
	$('.input-append').keyup( function() {
		var cnt = $(this).children('input').val().length;
		if(cnt > 6){
			var el = $(this).children('span');
			el.css('color', 'green');
		}else{
			var el = $(this).children('span');
			el.css('color', '#FF5959');
		}
	});
	
	

	
	var d = $(".ui-datepicker-month option")	
	var newDate = $(".ui-datepicker-month option:selected").text(); //grab initial date
	$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
	d.hide()
	$(".month-overlay").append('<span class="fakedate">' + newDate + '</span>');
	$('.month-overlay').live('click', function() {
		var el = $(".ui-datepicker-month")
		var options = $('option', el);
		var month = $("#monthpicker");
		$(this).removeAttr("selected")
		month.empty();
		
		month.animate({
			opacity: 'show',
            height: 'show' 
			},300)
			
		options.each(function(){  //clean up and make appened once, not on click
			month.append("<a class='cli' href='" + $(this).val() + "'>" + $(this).text() + "</a>"); 
		});
		$("a.cli").click(function(event){ //when anchor is clicked
			event.preventDefault();
			
			$("#monthpicker").animate({
			opacity: 'hide',
            height: 'hide' 
			},300)
			
			var fakeDate = $(".fakedate")
			fakeDate.empty()
			$(".ui-datepicker-month").val($(this).attr('href')).change();// .change() changes the dates for the calendar
			$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
			var newDate = $(".ui-datepicker-month option:selected").text();
			$(".month-overlay").append('<span class="fakedate">' + newDate + '</span>');
		});  
		});
		
		$('.ui-state-default').live('click', function() {
			$('.ui-datepicker-header').append("<div class='month-overlay'></div>");
			var newDate = $(".ui-datepicker-month option:selected").text();
			$(".month-overlay").append('<span class="fakedate">' + newDate + '</span>');
		
		})
		
});
