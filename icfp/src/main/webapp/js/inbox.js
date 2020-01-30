$(document).ready(function() {
	
	$("#myRequestData, #myCloseData, #assignedTask, #taskData")
	.tablesorter({headers:{
		0 : {sorter: "monthDayYear"},
		1 : {sorter: "dealID"},
		5 : {sorter: "debtEquityNumber"},
		6 : {sorter: "debtEquityNumber"},
		8 : {sorter: "monthDayYear"}
	}})
	.bind("sortEnd", function(){
			 gotoPage(1);
			});

	$("#myDraftData").tablesorter({
		headers:{
			1 : {sorter: "monthDayYear"},
			2 : {sorter: "draftDealID"},
			6 : {sorter: "debtEquityNumber"},
			7 : {sorter: "debtEquityNumber"},
			9 : {sorter: "monthDayYear"}

		}
	}).bind("sortEnd", function(){
			 gotoPage(1);
			});
	
	$('#myTask').click(function() {
		$('#typeId').val("MYTASKS");
		executeActionTask();
	});
	$('#unassignedTask').click(function() {
		$('#typeId').val("MYASSIGNEDTASKS");
		executeActionTask();
	});
	$('#myRequest').click(function() {
		$('#typeId').val("MYREQ");
		executeAction();
	});
	$('#closedRequest').click(function() {
		$('#typeId').val("MYCLOSE");
		executeAction();
	});
	$('#draftRequest').click(function() {
		$('#typeId').val("MYDRAFT");
		executeAction();
	});
	$('.right').click(function() {
		var isCollapsed = $(this).parent().hasClass('collapsed');
		if(!isCollapsed){
			$(this).text("Unhide this");
		}else{
			$(this).text("Hide this");
		}
	});
	
	setSelectedTab($('#typeId').val());
});
function executeAction() {
	inboxForm.action = inboxForm.action+"?command=executeInbox";
	inboxForm.submit();
}
function executeActionTask() {
	inboxForm.action = inboxForm.action+"?command=executeInboxTask";
	inboxForm.submit();
}
function disableTabs() {
	$(".nav li:has(a[href='#1'])").removeClass("active");
	$(".nav li:has(a[href='#2'])").removeClass("active");
	$(".nav li:has(a[href='#3'])").removeClass("active");
	$(".nav li:has(a[href='#4'])").removeClass("active");
	$(".nav li:has(a[href='#5'])").removeClass("active");
	$("div#1").removeClass("active");
	$("div#2").removeClass("active");
	$("div#3").removeClass("active");
	$("div#4").removeClass("active");
	$("div#5").removeClass("active");
	$("#taskData").removeClass("active");
	$("#assignedTask").removeClass("active");
	$("#myRequestData").removeClass("active");
	$("#myCloseData").removeClass("active");
	$("#myDraftData").removeClass("active");
}
function setSelectedTab(tabValue) {
	disableTabs();
	if(tabValue == 'MYTASKS'){
		$(".nav li:has(a[href='#1'])").addClass("active");
		$("div#1").addClass("active");
		$("#taskData").addClass("active");
	}else if(tabValue == 'MYASSIGNEDTASKS'){
		$(".nav li:has(a[href='#2'])").addClass("active");
		$("div#2").addClass("active");
		$("#assignedTask").addClass("active");
	}else if(tabValue == 'MYREQ'){
		$(".nav li:has(a[href='#3'])").addClass("active");
		$("div#3").addClass("active");
		$("#myRequestData").addClass("active");
	}else if(tabValue == 'MYCLOSE'){
		$(".nav li:has(a[href='#4'])").addClass("active");
		$("div#4").addClass("active");
		$("#myCloseData").addClass("active");
	}else if(tabValue == 'MYDRAFT'){
		$(".nav li:has(a[href='#5'])").addClass("active");
		$("div#5").addClass("active");
		$("#myDraftData").addClass("active");
	}
}
function deleteDeal() {
	var checkBoxes = $("input[name=deleteRequest]");
	var dealsToDelete = "";
	$.each(checkBoxes, function() {
    	if ($(this).attr('checked')){
    		var eachDeal = $(this).attr("value");
    		dealsToDelete += eachDeal + ",";
    	}
	});
	dealsToDelete=dealsToDelete.replace(/\,$/,"");
	if(dealsToDelete == ''){
		$('#deleteDealFlag').show();
	}else{
		$('#deleteDealFlag').hide();
		$('#deleteRequestListId').val(dealsToDelete);
		inboxForm.action = inboxForm.action+"?command=deleteDraftRequest";
		inboxForm.submit();
	}
}

