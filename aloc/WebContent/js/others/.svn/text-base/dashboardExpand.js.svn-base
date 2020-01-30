    
$(document).ready(function(){
		$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
		$("a.linkto").off("click").on("click", function(e){
			 $(this).parents("div.linkDiv").find('.linkShow').toggle();
			 var bundleIdVal = $(this).closest('.innerBS').find('#bundleId').val();
			 if(bundleIdVal == undefined || bundleIdVal == ''){
				 $(this).parents("div.linkDiv").find('.linkShow').addClass('linkShowWOB').css({'margin-top':'-125px'});
			 }else{
				 $(this).parents("div.linkDiv").find('.linkShow').addClass('linkShowWB').css({'margin-top':'-125px'});
			 }
			 $(this).parents("div.linkDiv").find('.linkShow').find(".alocRecordError").hide();
			 var scrollTopValue = $(this).closest("tr").offset().top;
			 $(window).scrollTop(scrollTopValue-100);
		 });
		
		$("a.btn_linkTo").off("click").on("click", function(e){
			var reqNoToLink = $(this).closest(".linkShow").find("#recordNumber").val();
			var currentReqNo = $(this).attr('id');
			var linkDiv = $(this).closest(".linkShow");
			var linkedTransNumberDiv = $(this).closest("td").find("div.linkedTransactionNumber");
			$(this).closest("#report").find('tbody tr').each(function() {
				if($(this).hasClass('innerRow')){
					var requestId = $(this).prev('tr').find('.requestId').val();
					if(requestId != currentReqNo) {
						$(this).prev('tr').find('#arrow').removeClass("up");
						$(this).prev('tr').find('#arrow').addClass("down");
						$(this).remove();
					}
				}
				if($(this).hasClass('odd')){
					$(this).removeClass("odd");
				}
			});
			popUpForLink(reqNoToLink,currentReqNo,linkDiv,linkedTransNumberDiv);
		});
			
		$(".deleteRequest").off("click").on("click", function(e){
			e.preventDefault();
			var a = $(this).attr('id').split('_');
			var requestId=a[0];
			var bundleId=a[1];
			n = window.open('#deleteRequestModal', '_self');
			
			$('#delBundleID', n.document).val(bundleId);
			$('#delReqID', n.document).val(requestId);
			
			$('#deleteRequestModal').modal({show: 'true'});
		});
		
		$("a.managebundleLink").each(function(){
			if(!$(this).attr('addmanagebundleLink')) {
				$(this).click(function(e) {
					e.preventDefault();
					var url = $(this).attr('href');
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'html',
						success: function(data){
							$('#dashboardMain').empty().html(data);
						},
						error: function (xhr, textStatus, errorThrown ) {
							$('#searchIndicator').hide();
					    }
					});
				});
				$(this).attr('addmanagebundleLink', true);
			}
		});
		
		
}); // DOCUMENT READY FUNCTION ENDS HERE   

//bundle functionality 
	function popUpRemoveRequestFromBundle(requestId,bundleId,alocRecordId) {	 		 
		  n = window.open('#removeBundle', '_self');
		  $('#modalHiddenBundleId', n.document).val(bundleId);
		  $('#modalHiddenRequestId', n.document).val(requestId);
		  $('#displayBundleId', n.document).text(bundleId);
		  $('#modalRequestId', n.document).text(alocRecordId);	 	 
		  $('#removeBundle').modal({		 
			        show: 'true'
			        
		  }); 
		};	
	function popUpRemoveEntireBundle(bundleId) {			
		  n = window.open('#deleteEntireBundle', '_self');
		  $('#deleteBundleId', n.document).text(bundleId);	  	 
		  $('#modalHiddenBundleId', n.document).val(bundleId);		  
		  $('#deleteEntireBundle').modal({		 
			        show: 'true'
			        
		  }); 
		  
		};						
		function popUpSubmitBundle(bundleId,beneficiaryName) {					
			n = window.open('#submitBundle', '_self');
			$('#popupBundleId', n.document).text(bundleId);	
			$('#modalHiddenBundleId', n.document).val(bundleId);	
			$('#popupBeneficiaryName', n.document).text(beneficiaryName);		
			$('#modalHiddenBeneficiaryName', n.document).val(beneficiaryName);					
			var url = contextURL +"/int/bundle/requestsForBundle.action";
			var formData = {bundleId:bundleId, beneficiaryName : beneficiaryName};			
			$.ajax({	
				type: "POST",
				url: url,
				dataType: 'html',
				data: formData,
				success: function(data) {					
				    $("#submitBundle").find('.modal-body').empty().html(data);		
				    $('#submitBundle').modal({		 
						show: 'true'
					});
				}
			});			  
			 
		};	
	function removeBundle(){
		var bundleId = $('#modalHiddenBundleId').val();		
		document.forms[0].method="Post";
		document.forms[0].action = contextURL + '/int/bundle/removeBundle.action?bundleId='+bundleId;
		document.forms[0].submit();
	};			
	
	function removeRequestFromBundle(){
		var bundleId = $('#modalHiddenBundleId').val();
		var requestId = $('#modalHiddenRequestId').val();	
		document.forms[0].method="Post"; 
		document.forms[0].action = contextURL + '/int/bundle/removeRequestFromBundle.action?bundleId='+bundleId+'&requestId='+requestId;
		document.forms[0].submit();
	};	
	
	function submitBundle(){
		var bundleId = $('#modalHiddenBundleId').val();	
		document.forms[0].method="Post";
		document.forms[0].action = contextURL + '/int/bundle/submitBundle.action?bundleId='+bundleId;		
		document.forms[0].submit();
	};	
     


	// for linking
function popUpForLink(reqNoToLink,currentReqNo,linkDiv,linkedTransNumberDiv) {

	$(linkDiv).find(".alocRecordError").hide();
	var parentDiv = $(this).parent('div');
	$(parentDiv).removeClass('errorinLanding');
	if (reqNoToLink != undefined && reqNoToLink != "") {	
		$(linkDiv).find(".alocRecordError").hide();		
		var url = contextURL +"/int/linkto/addlinkTransactions.action?requestId="+currentReqNo+'&alocrecordNumber='+reqNoToLink;
		var formData = {reqNoToLink:reqNoToLink};			
		$.ajax({	
			type: "POST",
			url: url,
			dataType: 'html',
			data: formData,
			success: function(data) {
				var reqContactURL = contextURL +"/int/dashboard/getLinkedTransactionsCount.action";
				$.ajax({	
					type: "POST",
					url: reqContactURL,
					dataType: 'html',
					data: {requestId : currentReqNo},
					success: function(data) {
						$(linkedTransNumberDiv).empty().html(data);
					}
				});
			    $("#linkTransaction").find('.modal-body').empty().html(data);		
			    $('#linkTransaction').modal({		 
					show: 'true'
				});
			    $(linkDiv).toggle();
			},
			error: function (xhr, textStatus, errorThrown ) {				
				var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());				
				$(linkDiv).find('.alocRecordError').text(errorMsg).show();
				$(linkDiv).css({'margin-top':'-145px'});
		    }			
		});			  
		 
	} else {		
		$(linkDiv).find(".alocRecordError").show();
		$(linkDiv).css({'margin-top':'-145px'});
	}

};	


// for Open Linked Transactions 
function linkTransactionsPopUp(requestId) {
if (requestId != undefined && requestId != "") {	
	var url = contextURL +"/int/linkto/loadlinkTransactions.action";
	var popBoxId = "ltPopBox"+requestId;
	var formData = {requestId:requestId};			
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'html',
		data: formData,
		success: function(data) {		
			$("#"+popBoxId).empty().html(data);		
			$("#"+popBoxId).slideToggle();
		    /*$('#linkTransaction').modal({		 
				show: 'true'
			});*/
		}
	});			  
	 
  } 

};	




