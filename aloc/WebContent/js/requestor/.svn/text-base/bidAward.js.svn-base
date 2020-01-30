/*
 * rich text editor plugin code
 */
function registerTinyMCE(elementId) { 
	tinymce.init({
        mode: "exact",
        elements: elementId,
        theme: "advanced",
        plugins: 'ice,icesearchreplace',
        theme_advanced_buttons1: "",
        theme_advanced_buttons2: "",
        theme_advanced_buttons3: "",
        theme_advanced_buttons4: "",
        theme_advanced_path : false,
        extended_valid_elements: "p,span[*],delete[*],insert[*]",
        ice: {
            user: { name: 'Geoffrey Jellineck', id: 11},
            preserveOnPaste: 'p,a[href],i,em,b,span'
        },
        height: '400'
    });
}

function registerStandardTinyMCE(elementId) {	
	tinymce.init({
        mode: 'exact',        
        elements: elementId,        
        readonly:'true',       
        theme_advanced_buttons1: "",
        theme_advanced_buttons2: "",
        theme_advanced_buttons3: "",
        theme_advanced_buttons4: "",
        theme_advanced_path : false,
        extended_valid_elements: "p,span[*]",      
        height: '400'        	
    });
}

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
				})
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
	}
	// initialize the function
	// as a parameter we are sending a selector. For this particular script we must select the unordered (or ordered) list item element 
	tabs('nav ul');

});


$(document).ready(function() {
       
		var awarderrorShow = $('#errorShowId').val();
		if(awarderrorShow!=undefined && awarderrorShow == 'true'){
			var actionType = $('#actionTypeId').val();
			if(actionType == 14) {
			 $("#nav-awardprepare").addClass('tabactive');
			 $('#li2').addClass('liactive');
			 $('#tab2').show();
			}
			if(actionType == 3) {
				 $("#bidAwardSendback").addClass('tabactive');
				 $('#li3').addClass('liactive');
			}
		}
		
		$("a#nav-awardprepare").click(function(e){
			 $(this).addClass('tabactive');
			 $('#li2').addClass('liactive');
			 $('#li1').removeClass('liactive');
			 $("#bidAwardSendback").removeClass('tabactive');
			 $('#bidAwardsendBackCounter').text('400');
			 $('#bidAwardSendBackId').val('');
			 $('#bidAwardBankEditCounter').text('400');
			 $('#bidAwardBankEditId').val('');
		});
		
		$("a#bidAwardSendback").click(function(e){
			 $(this).addClass('tabactive');
			 $("#nav-awardprepare").removeClass('tabactive');
	         $('.awardsub').removeClass('tabactive');
	         $('#li2').removeClass('liactive');
			 $('#li1').removeClass('liactive');
			 $('#bidAwardsendBackCounter').text('400');
			 $('#bidAwardSendBackId').val('');
			 $('#bidAwardBankEditCounter').text('400');
			 $('#bidAwardBankEditId').val('');
		});
		
		var awardpagelevelerror = $('#errorShowId').val();
		if(awardpagelevelerror!=undefined && awardpagelevelerror == 'true'){
			$('#awardPageLevelErrorDivId').show();
		}			
		$("a.selectWinner").click(function(){
			$('#selectWinner').modal({show: 'true'}).css("margin-top","-82px;"); 
		});
      
		amountTowords();
		bondamountTowords();
		
		$(".nav-hide").click(function(){
			$('li.navLi').removeClass('liactive');
			   $("a.navLink").removeClass('tabactive');
			   $(this).closest('.tab').hide();
		});
		
		$("a.clearEntries").click(function(){
			$('nav ul li.navLi').removeClass('liactive');
			$('nav ul li.navLi').find('.tabactive').removeClass('tabactive');
			$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;");
			
		});
		
		jQuery('#awardSubmitForm').preventDoubleSubmit();
		
    });	

        /**
         * Method to select winner from Treasury Bid Process
         * @param requestId
         * @param bundleId
         * @param instrumentTypeId
         */
        function popUpSelectWinner(requestId,bundleId,instrumentTypeId,bidReplyID,issuingBankName,sitePrefix,transmissionPlatform)
        {
        	$("#nav-awardprepare").removeClass('tabactive');
        	$("#bidAwardSendback").removeClass('tabactive');
        	$('.awardsub').addClass('tabactive');
        	$('#li2').removeClass('liactive');
        	$('#li3').removeClass('liactive');
        	n = window.open('#selectWinner', '_self');
        	$('#bundleId', n.document).val(bundleId);
        	$('#requestId', n.document).val(requestId);
        	$('#instrumentTypeId', n.document).val(instrumentTypeId);
        	$('#bidReplyID', n.document).val(bidReplyID);
        	$('#issuingBankName', n.document).val(issuingBankName);
        	$('#sitePrefix', n.document).val(sitePrefix);
        	var url = contextURL +"/int/dashboard/selectWinnerRequests.action";
        	var formData = {bundleId:bundleId,requestId:requestId,instrumentTypeId:instrumentTypeId,bidReplyId:bidReplyID,issuingBankName:issuingBankName,sitePrefix:sitePrefix,transmissionPlatform : transmissionPlatform};			
        	$.ajax({
        			type: "POST",
        			url: url,
        			dataType: 'html',
        			data: formData,
        			success: function(data) {					
        			    $("#selectWinner").find('.modal-body').empty().html(data);		
        			    $('#selectWinner').modal({		 
        					show: 'true'
        			});
        			    $('.awardsub').removeClass('tabactive');
        		 }
        	});		
        }
 
        function amountTowords(){
        	var ccyCode1 = $('#currencies').val();
        	var insAmount= $('#instrumentAmt').val();
        	if(insAmount!=undefined && insAmount!="" ){
        		var insAmtToword = toWords(insAmount);
        		$('#amountinWords').html(ccyCode1 + " - " +insAmtToword);
        	}
        }
	 
        function submitAction(actionType){
        	var instrumentTypeId = $('#instrumentId').val();
        	$('.transmissionPlatformError').hide();
        	if(instrumentTypeId != undefined && instrumentTypeId != '' && (instrumentTypeId == '1' || instrumentTypeId == '2'))
        	{
        		if(!($('#bidOptionID_SWIFT').is(':checked') || $('#bidOptionID_ALOC').is(':checked'))) {
        			$('.transmissionPlatformError').show();
        			return false;
        		}
        	}
        	$('#actionTypeId').val(actionType);
        }

        function bondamountTowords(){
        	var bondcur= $('.row').children('.subdiv').children('.suretybondCurrency').children(".bondCurrency").html();
        	var bondamount= $('.row').children('.suretyAmountDiv').children('.bondamountDiv').children(".bondAmount").html();
        	if(bondamount!=undefined && bondamount!="" ){
        		var bondAmtToword = toWords(bondamount);
        		$('#amountinWords').html(bondcur + " - " +bondAmtToword);
        	}
        }
        function submitAction(actionType){
        	$('#actionTypeId').val(actionType);
        }
        function sendBackBidAward(actionType){
        	$('#actionTypeId').val(actionType);
        }