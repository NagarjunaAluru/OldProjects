$(function() {
			
	$.fn.clearForm = function() {
		return this.each(function() {
		var type = this.type, tag = this.tagName.toLowerCase();
		if (tag == 'form')
		return $(':input',this).clearForm();
		if (type == 'text' || type == 'password' || tag == 'textarea')
		this.value = '';
		else if (type == 'checkbox' || type == 'radio')
		this.checked = false;
		else if (tag == 'select'){
		this.selectedIndex = -1;}
		});
	};
	$("#userDiv").hide();
	$(".numeric").keypress(function (e) { 
		if( e.which!=8 && e.which!=0 && (e.which<48 || e.which>57)){
			return false;
		 }
		return true;
	});

	$("#submitFilter").click( function(e){
		e.preventDefault();
		var fo = $("#filterOption").val();
		var fv = $("#filterValue").val();
		var url = contextURL + "/pipelineReview/pipelineReviewView.do?command=executeFilterMO&filterOption="+fo+"&filterValue="+fv;
		document.forms[0].action = url;
		document.forms[0].submit();
	});
	
	$("#pipeline, #pipeline2")
	.tablesorter({
		headers:{
			1:{sorter:"monthDayYear"},
			2:{sorter:"dealID"},
			4:{sorter:"debtEquityNumber"},
			5:{sorter:"debtEquityNumber"},
			10:{sorter:"monthDayYear"}
		}
	})
	.bind("sortEnd", function(){
			 gotoPage(1);
			});

	$("#pipeline1")
	.tablesorter({
		headers:{
			2:{sorter:"dealID"}			
		}
	})
	.bind("sortEnd", function(){
			 gotoPage(1);
			});

	$("#mopipeline, #mopipeline2")
	.tablesorter({
		headers:{
			1:{sorter:"monthDayYear"},
			2:{sorter:"dealID"},
			4:{sorter:"debtEquityNumber"},
			10:{sorter:"monthDayYear"}
		}
	})
	.bind("sortEnd", function(){
			 gotoPage(1);
			});

	$("#mopipeline1")
	.tablesorter({
		headers:{
			2:{sorter:"dealID"}			
		}
	})
	.bind("sortEnd", function(){
			 gotoPage(1);
			});

	$('#showChart1, #showChart2').click(function() {
		if($(this).is(':checked')){
			$('.chart-select option').eq(0).attr('disabled', 'disabled');
		}else{
			$('.chart-select option').eq(0).removeAttr('disabled');
		}
		
	});
	$('#searchAction').click(function(e){
		$('#dealIdErrorBar').removeClass("req-error");
		if(validateBeforeSearch()){
			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewView.do?command=executeFilter';
			document.forms[0].submit();
		}else{
			$('#dealIdErrorBar').addClass("req-error");
		}
	});
	
	$('#searchActionMO').click(function(e){
		$('#dealIdErrorBar').removeClass("req-error");
		if(validateBeforeSearch()){
			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewView.do?command=executeFilterMO';
			document.forms[0].submit();
		}else{
			$('#dealIdErrorBar').addClass("req-error");
		}
	});
	$("#lookupUserInfo").click(function(){ 
		var searchCriteria = $("#searchCriteria option:selected").text();
		var searchText = $("#searchText").val();
		var url= contextURL+"/pipelineReview/pipelineReviewView.do?command=searchUserInfo";
		$("#userDiv").hide();
		$("#userDiv").empty();
		$.post(url, {searchCriteria:searchCriteria,searchText:searchText},function(data){
			var content = $(data).find('#userDiv');
			$("#userDiv").empty().append( content.html() );
			$("#userDiv").show();
		});
		 
	}); 
	$("#clearForm").click(function(e){
		$('#pipelineInboxForm').clearForm();
	});
	
	$("table").on("click", "td.completed.popup", function(e){
	    var el = $(this);
	    $("#actionDetails").css({
	            left:el.offset().left, 
	            top: el.offset().top-100});
		
		var inputs = el.find("input");
		var inputData = {};

		$(inputs).each( function(){
			var curInput = $(this);
			var name = curInput.attr("name");
			switch(name){
				case "dealSeq":
					inputData.dealId = curInput.val();
					break;
				case "stageId":
					inputData.stageId = curInput.val();
					break;
				case "actionId":
					inputData.actionId = curInput.val();
					break;
			}
		});

		if( inputData.dealId && inputData.stageId && inputData.actionId ){
			//continue
		}else{
			$(".popover-content").empty();
			$("#actionDetails").hide();
			return;
		}
		var url= contextURL+"/pipelineReview/pipelineReviewView.do?command=getActionTaken";
	
		$("#actionDetails").show();
		$(".popover-content")
		.empty()
		.addClass("loading")
		.load( url, inputData, function(data){
		        $(".popover-content").removeClass("loading");        
		    });
	});
});

function validateBeforeSearch() {
	var dealId = $('#dealId').val();
	var valid = dealId.match(/^\d{4}-\d{1}-\d{4}/g);
	if(dealId != '' && valid != null){
		return true;
	}else if(dealId == ''){
		return true;
	}
	return false;
}
function selectUser(id) {
	var ssoid = $(id).val();
	var name = $(id).parent().next().next().text().split(",");
	$('#ssoId').val(ssoid);
	$('#firstNameId').val(name[1]);
	$('#lastNameId').val(name[0]);
}
function exportToExcel() {
	var tableType= $(".chart-select option:selected").text();
	var url=contextURL + "/pipelineReview/pipelineReviewView.do?command=exportToExcel&tableType="+tableType+"&pipelineType=FO";
	
	document.forms[0].action = url;
	document.forms[0].submit();
}
function exportToExcelMO() {
	var tableType= $(".chart-select-mo option:selected").text();
	var url=contextURL + "/pipelineReview/pipelineReviewView.do?command=exportToExcel&tableType="+tableType+"&pipelineType=MO";
	
	document.forms[0].action = url;
	document.forms[0].submit();
}

function printPipelineMgmt() {
	window.print();
	return false;
}

function openTransaction(i,sourcePage) {
	pipelineInboxForm.action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID='+i+"&source="+sourcePage;
	pipelineInboxForm.submit();
}