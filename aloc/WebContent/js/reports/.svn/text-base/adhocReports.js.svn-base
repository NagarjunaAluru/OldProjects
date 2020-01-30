jQuery(function($){
	tabs = function(options) {
		
		var defaults = {  
			selector: '.tabs',
			selectedClass: 'selected'
		};  
		
		if(typeof options == 'string') defaults.selector = options;
		var options = $.extend(defaults, options); 
	
		return $(options.selector).each(function(){
									
			var obj = this;	
			var targets = Array();
	
			function show(i){
				$.each(targets,function(index,value){
					$(value).hide();
				});
				$(targets[i]).fadeIn('fast');
				$(obj).children().removeClass(options.selectedClass);
				selected = $(obj).children().get(i);
				$(selected).addClass(options.selectedClass);
			};
	
			$('a',this).each(function(i){	
				targets.push($(this).attr('href'));
				$(this).click(function(e){
					e.preventDefault();
					show(i);
				});
			});
			
			show();
	
		});			
	};
	// initialize the function
	// as a parameter we are sending a selector. For this particular script we must select the unordered (or ordered) list item element 
	tabs('nav ul');
});
var app;
$(document).ready( function() {
	var customization = new spotfire.webPlayer.Customization();
    customization.showTopHeader = false;
     customization.showToolBar = false;
     customization.showCustomizableHeader = false;
     customization.showTopHeader = false;
     customization.showClose = false;
     customization.showAnalysisInfo = false;
     customization.showToolBar = false;
     customization.showExportFile = false;
     customization.showExportVisualization = false;
     customization.showUndoRedo = false;
     customization.showDodPanel = false;
     customization.showFilterPanel = false;
     customization.showPageNavigation = false;
     customization.showStatusBar = false;
     app = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
     // Open an analysis.
     app.open($("#adhocPathId").val(),"webPlayer",'');
     
	var sortPriorityMap = {'1':'1','2':'2','3':'3','4':'4','5':'5'};
	$('#availableSortPriority').val(JSON.stringify(sortPriorityMap));
	
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	
	var instrumentTypes = new Array();
	var fieldName = "";
	var instrIncrement = 0;
	$("#browser").treeview({
		animated:"fast"
	});
	$('span.draggable').draggable({ helper: "clone" });
	$('.case').each(function() {
		if($(this).attr('checked')){
			instrumentTypes[instrIncrement] = $(this).val();
			instrIncrement++;
		}
	});
	
	if(instrIncrement == 0){
		$("#selectall").attr('checked', true);
		$('.case').attr('checked', true);
	}
	treeData($('#instrIndicator'), instrumentTypes, fieldName);
	
	$("#filterDropbox").droppable({
		drop: function(event, ui) {
			var draggable = ui.draggable;
			var fieldId = draggable.attr('id');
			if($(this).find("div#"+fieldId).length == 0){
				var url = contextURL + "/int/reports/customReportRenderFilter.action";
				var dropBoxDiv = this;
				$.ajax({
					type : "POST",
					url: url,
					data : {fieldId : fieldId},
					dataType: "html",
					success: function(data) {
						$(dropBoxDiv).append('<div class="droppable home divcd" id="'+fieldId+'">'+data+'</div>');
					}
				});
			}
		}
	});
	
	$("#orderPriorityDropBox").droppable({
		drop: function(event, ui) {
			var draggable = ui.draggable;
			var fieldId = draggable.attr('id');
			
			var isFieldThere = 0;
			$('table#orderNPriority thead tr th').each(function() {
				if($(this).find('.columnFieldId').val() === fieldId){
					isFieldThere++;
				}
			});
			if(isFieldThere == 0){
				var url = contextURL + "/int/reports/customReportRenderColumn.action";
				$.ajax({
					type : "POST",
					url: url,
					data : {fieldId : fieldId},
					dataType: "html",
					success: function(data) {
						$('table#orderNPriority thead tr th:last').after(data);
					}
				});
				
			}else{
				alert("This field has been already added as column");
			}
		}
	});

	if($('.sortPriorityValue').length > 0){
		$('.sortPriorityValue').each(function() {
			var sortPriorityValue = $(this).val();
			if(sortPriorityValue != undefined && sortPriorityValue != '' && sortPriorityValue != '0'){
				$(this).siblings('.sortPriority').val(sortPriorityValue);
				$(this).siblings('.sortPriority').prop('disabled',true);
			}
		});
	}
	$('#orderPriorityDropBox').off('click','.settings').on('click','.settings',function (e) {
		$('div.columnOrderPriority').hide();
		$('.sortPriorityValue').each(function() {
			var sortPriorityValue = $(this).val();
			if(sortPriorityValue != undefined && sortPriorityValue != '' && sortPriorityValue != '0'){
				sortPriorityMap = $.parseJSON($('#availableSortPriority').val());
				$.each(sortPriorityMap, function(index, result) {
				     if(result === sortPriorityValue){
				    	 delete sortPriorityMap[index];
				     }
				   });
				$('#availableSortPriority').val(JSON.stringify(sortPriorityMap));
			}
		});
		var sortPriority = $(e.currentTarget).closest('th').find('.sortPriority');
		var sortPriorityValue = $(sortPriority).val(); 
		if(sortPriorityValue == '0'){
			$(sortPriority).children().filter(function(index, option) {
			    return option.value !== '0';
			}).remove();
			$.each(sortPriorityMap, function(key, value) {   
			     $(sortPriority)
			         .append($("<option></option>")
			         .attr("value",key)
			         .text(value)); 
			});
		}
		var leftPos = $(e.currentTarget).closest('th').position().left;
		var topPos = $(e.currentTarget).closest('th').position().top;
		$(e.currentTarget).parent('div').next('div.columnOrderPriority').css({"top":topPos+90,"left":leftPos+10}).show();
	});
	
	$('#orderPriorityDropBox').off('change','.sortPriority').on('change','.sortPriority',function (e) {
		var sortPriorityValue = $(e.currentTarget).val();
		sortPriorityMap = $.parseJSON($('#availableSortPriority').val());
		$.each(sortPriorityMap, function(index, result) {
		     if(result === sortPriorityValue){
		    	 delete sortPriorityMap[index];
		     }
		   });
		$('#availableSortPriority').val(JSON.stringify(sortPriorityMap));
		$(e.currentTarget).prop('disabled',true);
		$(e.currentTarget).siblings('.sortPriorityValue').val(sortPriorityValue);
	});
	
	$('#orderPriorityDropBox').off('click','.orderPriorityClose').on('click','.orderPriorityClose',function (e) {
		$(e.currentTarget).parent('div.columnOrderPriority').hide();
	});
	
	$('#filterDropbox').off('click','.addAsColumn').on('click','.addAsColumn',function (e) {
		var fieldId = $(e.currentTarget).closest('div.divcd').find('.fieldId').val();
		var isFieldThere = 0;
		$('table#orderNPriority thead tr th').each(function() {
			if($(this).find('.columnFieldId').val() === fieldId){
				isFieldThere++;
			}
		});
		if(isFieldThere == 0){
			var url = contextURL + "/int/reports/customReportRenderColumn.action";
			$.ajax({
				type : "POST",
				url: url,
				data : {fieldId : fieldId},
				dataType: "html",
				success: function(data) {
					$('table#orderNPriority thead tr th:last').after(data);
				}
			});
			
		}else{
			alert("This field has been already added as column");
		}
	});
	
	$('#filterDropbox').off('click','.deleteFilters').on('click','.deleteFilters',function (e) {
		$(e.currentTarget).closest('div.divcd').remove();
	});
	
	$('#filterDropbox .operator').each(function() {
		var operatorValue = $(this).val();
		if(operatorValue == 'in between') {
			$(this).closest('div.firstOperand').next('div.secondOperand').show();
		}
	});
	
	$('#filterDropbox').off('change','.operator').on('change','.operator',function (e) {
		var operatorValue = $(this).val();
		if(operatorValue == 'in between'){
			$(e.currentTarget).closest('div.firstOperand').next('div.secondOperand').show();
		}else{
			$(e.currentTarget).closest('div.firstOperand').next('div.secondOperand').hide();
		}
	});
	
	$("#selectall").off('click').on('click',function () {
		$('.case').attr('checked', this.checked);
		instrumentTypes.length = 0;
		var i = 0;
		$("input:checkbox[name='template.instrumentTypes']").each(function() {    
			if($(this).is(':checked')){
				instrumentTypes[i] = $(this).val();
				i++;
			}
		});
		if($("#search-term").val() != ''){
			fieldName = $("#search-term").val();
		}
		$('.optOutval-error1').removeClass("show").addClass("hide");
		treeData($('#instrIndicator'), instrumentTypes, fieldName);
	});

	// if all checkbox are selected, check the selectall checkbox
	// and viceversa
	$(".case").off('click').on('click',function () {
		instrumentTypes.length = 0;
		if($(".case:checked").length > 1){
			var i = 0;
			$("input:checkbox[name='template.instrumentTypes']").each(function() {    
				if($(this).is(':checked')){
					instrumentTypes[i] = $(this).val();
					i++;
				}
			});
		}
		else if($(".case:checked").length == 1){
			instrumentTypes[0] = $(".case:checked").val();
		}

		if($("#search-term").val() !=''){
			fieldName = $("#search-term").val();
		}
		
		if($(".case").length == $(".case:checked").length) {
			$("#selectall").attr("checked", "checked");
		} else {
			$("#selectall").removeAttr("checked");
		}
		$('.optOutval-error1').removeClass("show").addClass("hide");
		treeData($('#instrIndicator'), instrumentTypes, fieldName);
	});
	
	$("#fieldSearch").off('click').on('click',function () {
		if(jQuery.trim($("#search-term").val()).length == 0){
			fieldName = "";
			$('.optOutval-error1').text("Please enter Field Name").removeClass("hide").addClass("show");
			return false;
		}
		$('.optOutval-error1').removeClass("show").addClass("hide");
		fieldName = $("#search-term").val();
		var indicator=$(this).siblings('.indicator');
		treeData(indicator, instrumentTypes, fieldName);
	});
	
	$('#search-term').off('change').on('change', function() {
		var indicator=$(this).siblings('.indicator');
		fieldName = $(this).val();
		if(jQuery.trim($(this).val()).length === 0){
			treeData(indicator, instrumentTypes, $(this).val());
		}
	});

	$('#generateReport').off('click').on('click',function () {
	   	var indicator=$(this).siblings('.indicator');
	   	var data = $("#adhocReportForm").serialize();
	   	var url = contextURL + "/int/reports/runReport.action";
	   	var fromDate = $('#fromDate').val();
	   	var toDate = $('#toDate').val();
	   	$("#dateDescId").find('.optOutval-error').hide();
	   	$("#dateDescId").css("border","0px solid red");
		$("#siteMsg").hide();
	   	if(fromDate != undefined && fromDate != '' && toDate != undefined && toDate != ''){
	   		$(indicator).show();
	   		$.ajax({
				type : "POST",
				url: url,
				data : data,
				dataType:'json',
				success: function(response) {
					$("#reportGridId").css({visibility:"visible"});
					$("#reportId").val(response.data);
					if($("#reportId").val() != undefined && !jQuery.trim($("#reportId").val()).length == 0)
						app.analysisDocument.setDocumentProperty("INREPORTID",$('#reportId').val().toString());
					else
			    	    app.analysisDocument.setDocumentProperty("INREPORTID",'');
					$(indicator).hide();
				},
		   		error: function (jqXHR, textStatus, errorThrown ) {
					alert("Inside error : "+ $(jqXHR.responseText).find('table').find('td.errorReason').text());
					$(indicator).hide();
			}
			});
	   	}else{
	   		$("#dateDescId").find('.optOutval-error').show();
	   		$("#dateDescId").css("border","1px solid red");
	   		$(window).scrollTop(0);
	   	}
		
	});
	
	if($('h3#reportName').text() === ''){
		$('h3#reportName').text($('input#reportName').val());
	}
   $("#nave-save-template").click(function(){
		$(this).addClass('tabactive');
		$('#li77').addClass('liactive');
		$('.optOutval-error').hide();
   		$("#descriptionId,#reportId").css("border","0px solid red");
   		//showHideBankList($("#BankPP"));
   		//showHideBusinessList($("#BusPP"));
	});
   $(".nav-hide").click(function(){
	   	$('#li77').removeClass('liactive');
		$("a.navLink").removeClass('tabactive');
		$(this).closest('.tab').hide();
	});

   decCounter("templateDesc", 200);
   
   if($('#BankPP').is(':checked')) {
	   $("#PublishBank").show();
   }
   
   if($('#BusPP').is(':checked')) {
	   $("#PublishBusiness").show();
   }
   
   $("#BankPP").off('click').on('click',function () {
	   if(!$(this).is(':checked')) {
		   $.ajax({
		   		type: "POST",
	            url: contextURL+'/int/reports/resetBanks.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#bankSelection").empty().append(data);
	            }
	        });
		   $("#PublishBank").hide();
	   } else {
		   $("#PublishBank").show();
	   }
   });
   $("#BusPP").off('click').on('click',function () {
	   if(!$(this).is(':checked')){
		   $.ajax({
		   		type: "POST",
	            url: contextURL+'/int/reports/resetSites.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#siteSelection").empty().append(data);
	            }
		   });
		   $("#PublishBusiness").hide();
	   } else {
		   $("#PublishBusiness").show();
	   }
   });
   	$(".nav-template").off('click').on('click', function(){
   		$('.optOutval-error').hide();
   		$("#descriptionId,#reportId,#dateDescId").css("border","0px solid red");
		if(validateAdhoc()){
			var indicator=$(this).siblings('.indicator');
			$(indicator).show();
			var data = $("#adhocReportForm").serialize();
			var url = contextURL + "/int/reports/customReportSaveTemplate.action";
			$.ajax({
				type : "POST",
				url: url,
				data : data,
				dataType:'json',
				success: function(response) {
					$(indicator).hide();
					if(response.status === 'SUCCESS'){
						$("#siteMsg").show();
						$('#templateId').val(response.data);
					}else if(response.status === 'FAIL'){
						$('.curDelError').text(response.errorMsg);
						$('.curDelErrorDiv').show();
						$("#siteMsg").hide();
					}
					$(window).scrollTop(0);
				},
				error: function (xhr, textStatus, errorThrown ) {
					$(indicator).hide();
					var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());				
					if(errorMsg!=undefined && errorMsg!=""){
						$('.curDelErrorDiv').show();
					}
					$('.curDelError').text(errorMsg).show();
					$("#siteMsg").hide();
			    }
			});
		}
   	});
   
   	$(".successclose").off('click').on('click',function () {
	    $("#siteMsg").removeClass("show").addClass("hide");
	});
   	$("#reportGridId").css({visibility:"hidden"});
   	
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
   	$('.acc_triggerA').addClass('acc_active').next().next().show();
});

function validateAdhoc(){
	var desc = true;
	var report = true;
	var dateFilter = true;
	
	if(($.trim($("#templateDesc").val()).length == 0)){
		$("#templateDesc").closest('tr').find('.optOutval-error').show();
		$("#descriptionId").css("border","1px solid red");
		desc = false;
	}
	if(($.trim($("input#reportName").val()).length == 0)){
		$("input#reportName").closest('tr').find('.optOutval-error').show();
		$("#reportId").css("border","1px solid red");
		report = false;
	}
	if($('#fromDate').val() == undefined || $('#fromDate').val() == '' || $('#toDate').val() == undefined || $('#toDate').val() == ''){
		$("#dateDescId").find('.optOutval-error').show();
   		$("#dateDescId").css("border","1px solid red");
   		dateFilter = false;
	}
  
	if(desc == false || report == false || dateFilter == false){
		$(window).scrollTop(0);
		return false;
	}
	else{
		return true;
	}
}


function treeData(indicator, instrumentTypes, fieldName) {
	$(indicator).show();
	var url = contextURL + "/int/reports/customReportSearchFields.action";
	$.ajax({
		type : "POST",
		url: url,
		data : {instrumentTypes : instrumentTypes, fieldName : fieldName},
		dataType: "xml",
		success: function(data) {
			$("ul#browser").children().remove();
			$(data).find("section").each( function() {
				var info = '<li><span class="folder">'+$(this).attr('name')+'</span>'+
				'<ul>';
				$(this).find('field').each(function(){
					info = info+'<li>'+
					'<span class="file draggable" id='+$(this).attr('id')+'>'+$(this).attr('name')+'</span></li>';
				});
				info = info+'</ul></li>';
				$("ul#browser").append(info);
			});
			$("#browser").treeview({
				animated:"fast"
			});
			$( 'span.draggable' ).draggable({ helper: "clone", cursor: "pointer"});
			$(indicator).hide();
		},
		error: function(jqXHR, textStatus, errorThrown ) { 
			$("ul#browser").children().remove(); 
			$("ul#browser").append("<li>There was an error baby!</li>");
			$(indicator).hide();
		}
	});
}
