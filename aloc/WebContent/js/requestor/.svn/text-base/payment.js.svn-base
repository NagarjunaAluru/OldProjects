$(document).ready(function() {
	/**
	* Payment Period row dynamic addition
	*/
	$('.addpayment').each(function() {
		if(!$(this).attr('addPaymentRow')) {
		$(this).click(function() {
			var curIndex = 0;
			var processImg = contextURL+"/img/loading.gif";
			if($('#curPaymentSize').val() != undefined && ($('#curPaymentSize').val() != "" && $('#curPaymentSize').val() != "0")){
				curIndex = parseInt($('#curPaymentSize').val());
			}
			if( curIndex > 0 ){
				$("table#paymentPeriod").children('tbody').children("tr:last").after('<tr class="shown paymentRow addRowpayment"></tr><tr class="addRowpayment"><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary addPaymentPeriod">Save</a><a href="javascript:;" class="btn-tertiary cancelPayment">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePaymentProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
				var url = contextURL+'/int/apm/addPaymentPeriodRow.action' + '?curIndex=' + curIndex;
				$('.paymentRow').load(url).removeClass('paymentRow');
				$('#curPaymentSize').val(curIndex + 1);
			}else if( curIndex == 0){
				$("table#paymentPeriod").children('tbody').append('<tr class="shown paymentRow addRowpayment"></tr><tr class="shown paymentRow addRowpayment"></tr><tr  class="addRowpayment"><td></td><td colspan="12"><a href="javascript:;" class="btn addTwoRowPaymentPeriod">Save</a><a href="javascript:;" class="cancelTwoRowPayment">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePaymentProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
				$('.paymentRow').each(function(){
					var url = contextURL+'/int/apm/addPaymentPeriodRow.action' + '?curIndex=' + curIndex;
					$(this).load(url).removeClass('paymentRow');
					curIndex = curIndex + 1;
					
				});
				
				$('#curPaymentSize').val(curIndex);		
			}
			
		});
		$(this).attr('addPaymentRow', true);
		}
	});

	/**
	* Payment Period single row save
	*/

	$('.addPaymentPeriod').off('click').on('click',function(e){	
		e.preventDefault();
		var parentPaymentRow = $(this).parents('tr.addRowpayment').prev('.addRowpayment');
	    var configID = $(parentPaymentRow).find('.configId').val();
	    var startdate = $(parentPaymentRow).find('.startDate').val();
	    var enddate = $(parentPaymentRow).find('.endDate').val();
	    var reValuedate = $(parentPaymentRow).find('.reValueDate').val();
	    var cutOfdate = $(parentPaymentRow).find('.cutOfDate').val();
	    var usdamount = $(parentPaymentRow).find('.usdAmount').val();
	    var dayCount = $(parentPaymentRow).find('.dayCount').val();
	    var curIndex = $(this).parents('tr.addRowpayment').prev('.addRowpayment').find('.curIndex').val();
		if(curIndex == undefined || curIndex == "")
		{
			curIndex = 0;
		}
			$(this).closest('tr').find('.savePaymentProcess').show();
			var url = contextURL+'/int/apm/savePaymentPeriod.action'; 
			var data = {'firstpaymentperiod.APMConfigID': configID, 
						'firstpaymentperiod.paymentPeriodStartDate' : startdate, 
						'firstpaymentperiod.paymentPeriodEndDate' : enddate, 
						'firstpaymentperiod.FXRateRevalueDate' : reValuedate, 
						'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdate, 
						'firstpaymentperiod.minPaymentAmountUSD' : usdamount, 
						'firstpaymentperiod.dayCount' : dayCount, 
						'curIndex' : curIndex
						};
			$('#advSearchIndicator').show();
			
			$(this).parents('tr.addRowpayment').prev('.addRowpayment').load(url, data, function(){ 
				var errorpaymentShow = $.trim($(this).find('.paymentErrorId').text());
				if(errorpaymentShow == 'false')
				{ 
					$(this).next('tr').remove();
				}
				else if(errorpaymentShow == 'true')
				{
					$(this).next('tr').find('.savePaymentProcess').hide();
				}
				
	   });
			
	});	

	/**
	* Payment Period double row save
	*/
	$('.addTwoRowPaymentPeriod').off('click').on('click',function(e){        
	    e.preventDefault();
	    var parentPaymentone =$(this).parents('tr.addRowpayment').prev('tr.addRowpayment').prev('tr.addRowpayment');
		var parentPaymenttwo =$(this).parents('tr.addRowpayment').prev('tr.addRowpayment');
		var startdate = $(parentPaymentone).find('.startDate').val();
		var enddate = $(parentPaymentone).find('.endDate').val();
		var reValuedate = $(parentPaymentone).find('.reValueDate').val();
		var cutOfdate = $(parentPaymentone).find('.cutOfDate').val();
		var usdamount = $(parentPaymentone).find('.usdAmount').val();
		var dayCount = $(parentPaymentone).find('.dayCount').val();
	    var startdateTwo = $(parentPaymenttwo).find('.startDate').val();
	    var enddateTwo = $(parentPaymenttwo).find('.endDate').val();
	    var reValuedateTwo = $(parentPaymenttwo).find('.reValueDate').val();
	    var cutOfdateTwo = $(parentPaymenttwo).find('.cutOfDate').val();
	    var usdamountTwo = $(parentPaymenttwo).find('.usdAmount').val();
	    var dayCountTwo = $(parentPaymenttwo).find('.dayCount').val();
	    var val=nullCheck(startdate,enddate,reValuedate,cutOfdate,usdamount,dayCount);
	    var secondcheck=nullCheck(startdateTwo,enddateTwo,reValuedateTwo,cutOfdateTwo,usdamountTwo,dayCountTwo);
	    var StartDateCheck=checkDate(enddate,startdateTwo); 
	    if(val=="true" && secondcheck=="true" && StartDateCheck=="true"){
	    	$(this).closest('tr').find('.savePaymentProcess').show();
	  		 var url = contextURL+'/int/apm/savePaymentPeriodTwo.action';
			 var data = {'startdate':startdate,
					  'enddate':enddate,
					  'reValuedate':reValuedate,
					  'cutOfdate':cutOfdate,
					  'usdamount':usdamount,
					  'dayCount':dayCount,
					  'startdateTwo':startdateTwo,
					  'enddateTwo':enddateTwo,
					  'reValuedateTwo':reValuedateTwo,
					  'cutOfdateTwo':cutOfdateTwo,
					  'usdamountTwo':usdamountTwo,
					  'dayCountTwo':dayCountTwo};			
	  		 $(this).load(url, data,function(e){ 
			 $(this).parents('tr.addRowpayment').prev('tr.addRowpayment').prev('tr.addRowpayment').remove();
			 $(this).parents('tr.addRowpayment').prev('tr.addRowpayment').remove();
			 $(this).parents('tr.addRowpayment').remove();
			 
			 $("table#paymentPeriod").children('tbody').append('<tr class="shown paymentRow addRowpayment"></tr><tr class="shown paymentRow addRowpayment"></tr>');
				var curIndex=0;
				$('.paymentRow').each(function(){
					var url = contextURL+'/int/apm/cancelPaymentPeriodTwoRow.action' + '?curIndex=' + curIndex;
					$(this).load(url).removeClass('paymentRow');
					curIndex= curIndex + 1 ;
				});		 
		}); 
     }
	    if(val=="false" && secondcheck=="false"){
			var url = contextURL+'/int/apm/savePaymentPeriod.action';
			var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdate, 
					'firstpaymentperiod.paymentPeriodEndDate' : enddate, 
					'firstpaymentperiod.FXRateRevalueDate' : reValuedate, 
					'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdate, 
					'firstpaymentperiod.minPaymentAmountUSD' : usdamount, 
					'firstpaymentperiod.dayCount' : dayCount, 
					'curIndex' : 0
					};
			$(this).parents('tr.addRowpayment').prev('.addRowpayment').prev('.addRowpayment').load(url, data, function(){ 				   });
				var urlOne = contextURL+'/int/apm/savePaymentPeriod.action';
				var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdateTwo, 
						'firstpaymentperiod.paymentPeriodEndDate' : enddateTwo, 
						'firstpaymentperiod.FXRateRevalueDate' : reValuedateTwo, 
						'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdateTwo, 
						'firstpaymentperiod.minPaymentAmountUSD' : usdamountTwo, 
						'firstpaymentperiod.dayCount' : dayCountTwo, 
						'enddate':enddate,
						'curIndex' : 1
						};
				$(this).parents('tr.addRowpayment').prev('.addRowpayment').load(urlOne,data, function(){ 
					$(this).next('tr').find('.savePaymentProcess').hide();
				   });   }
	   if(val=="true" && secondcheck=="false"){	
		      $(this).parents('tr.addRowpayment').prev('.addRowpayment').prev('.addRowpayment').find('.errormessage').hide();
				var url = contextURL+'/int/apm/savePaymentPeriod.action';
				var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdateTwo, 
						'firstpaymentperiod.paymentPeriodEndDate' : enddateTwo, 
						'firstpaymentperiod.FXRateRevalueDate' : reValuedateTwo, 
						'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdateTwo, 
						'firstpaymentperiod.minPaymentAmountUSD' : usdamountTwo, 
						'firstpaymentperiod.dayCount' : dayCountTwo, 
						'enddate':enddate,
						'curIndex' : 1
						};
				$(this).parents('tr.addRowpayment').prev('.addRowpayment').load(url,data, function(){ 
					$(this).next('tr').find('.savePaymentProcess').hide();
				   });	  }
	   if(val=="true" && secondcheck=="true" && StartDateCheck=="false"){	
		   $(this).parents('tr.addRowpayment').prev('.addRowpayment').prev('.addRowpayment').find('.errormessage').hide();
			var url = contextURL+'/int/apm/savePaymentPeriod.action';
			var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdateTwo, 
					'firstpaymentperiod.paymentPeriodEndDate' : enddateTwo, 
					'firstpaymentperiod.FXRateRevalueDate' : reValuedateTwo, 
					'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdateTwo, 
					'firstpaymentperiod.minPaymentAmountUSD' : usdamountTwo, 
					'firstpaymentperiod.dayCount' : dayCountTwo, 
					'enddate':enddate,
					'curIndex' : 1
					};
			$(this).parents('tr.addRowpayment').prev('.addRowpayment').load(url,data, function(){ 
				$(this).next('tr').find('.savePaymentProcess').hide();
			   });	  }
	   if(val=="false" && secondcheck=="true" && StartDateCheck=="true"){
		   $(this).parents('tr.addRowpayment').prev('.addRowpayment').find('.errormessage').hide();
	    	var url = contextURL+'/int/apm/savePaymentPeriod.action';
	    	var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdate, 
					'firstpaymentperiod.paymentPeriodEndDate' : enddate, 
					'firstpaymentperiod.FXRateRevalueDate' : reValuedate, 
					'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdate, 
					'firstpaymentperiod.minPaymentAmountUSD' : usdamount, 
					'firstpaymentperiod.dayCount' : dayCount, 
					'curIndex' : 0
					};	
	    	$(this).parents('tr.addRowpayment').prev('.addRowpayment').prev('.addRowpayment').load(url,data, function(){ 
					$(this).next('tr').next('tr').find('.savePaymentProcess').hide();
		   });  }
	   if(val=="false" && secondcheck=="true" && StartDateCheck=="false"){
		   var url = contextURL+'/int/apm/savePaymentPeriod.action';
		   var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdate, 
					'firstpaymentperiod.paymentPeriodEndDate' : enddate, 
					'firstpaymentperiod.FXRateRevalueDate' : reValuedate, 
					'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdate, 
					'firstpaymentperiod.minPaymentAmountUSD' : usdamount, 
					'firstpaymentperiod.dayCount' : dayCount, 
					'curIndex' : 0
					};	
		   $(this).parents('tr.addRowpayment').prev('.addRowpayment').prev('.addRowpayment').load(url,data, function(){ 				   });
			var url = contextURL+'/int/apm/savePaymentPeriod.action';
			var data = {'firstpaymentperiod.paymentPeriodStartDate' : startdateTwo, 
					'firstpaymentperiod.paymentPeriodEndDate' : enddateTwo, 
					'firstpaymentperiod.FXRateRevalueDate' : reValuedateTwo, 
					'firstpaymentperiod.paymentPeriodCutoffDate' : cutOfdateTwo, 
					'firstpaymentperiod.minPaymentAmountUSD' : usdamountTwo, 
					'firstpaymentperiod.dayCount' : dayCountTwo, 
					'enddate':enddate,
					'curIndex' : 1
					};
			$(this).parents('tr.addRowpayment').prev('.addRowpayment').load(url,data, function(){ 
				$(this).next('tr').find('.savePaymentProcess').hide();
		   });  }
	});

	/**
	* Payment Period edit row
	*/
	$('.editPayment').off('click').on('click',function(e){
		e.preventDefault();
		var a = $(this).attr('alt').split('_');
		var curIndex=a[0];
		var apmConfigID=a[1];
		var processImg = contextURL+"/img/loading.gif";
		$(this).closest('tr').addClass('paymentRow');
		var url = contextURL+'/int/apm/editPaymentPeriodRow.action' + '?curIndex=' + curIndex+'&apmConfigID=' + apmConfigID;
		$('.paymentRow').after('<tr class="addRowpayment"><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary addPaymentPeriod">Save</a><a href="javascript:;" class="btn-tertiary cancelPayment">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="savePaymentProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		$('.paymentRow').load(url).removeClass('paymentRow');
	});


	/**
	* Payment Period cancel row
	*/
	$('.cancelPayment').off('click').on('click',function(e){
	    e.preventDefault();
	    var curIndex = $(this).parents('tr.addRowpayment').prev('.addRowpayment').find('.curIndex').val();
	    var apmConfigId = $(this).parents('tr.addRowpayment').prev('.addRowpayment').find('.configId').val();
	    if(apmConfigId != undefined && apmConfigId != "")
	    {    
	            var url = contextURL+'/int/apm/cancelPaymentPeriod.action' + '?curIndex=' + curIndex+'&apmConfigID=' + apmConfigId;
	            $(this).parents('tr.addRowpayment').prev('.addRowpayment').load(url, function(){ 
	                    $(this).next('tr').remove();
	            });
	           
	    }else{
	    	var curPaymentIndex = parseInt($('#curPaymentSize').val());
	    	 curPaymentIndex = curPaymentIndex - 1;
			$('#curPaymentSize').val(curPaymentIndex);
	            $(this).parents('tr.addRowpayment').prev('.addRowpayment').remove();
	            $(this).parents('tr.addRowpayment').remove();
	    }        
			
		});
	$("#paymentPeriod tr:odd").addClass("odd");

});

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
/**
* Payment Period dates null checks
*/
function nullCheck(startdate,enddate,reValuedate,cutOfdate,usdamount,dayCount){
    var value="false";
    if((startdate != undefined && startdate !='') && (enddate != undefined && enddate !='') && (reValuedate != undefined && reValuedate !='') && (cutOfdate != undefined && cutOfdate !='') && (usdamount != undefined && usdamount !='') && (dayCount != undefined && dayCount !='')){
            if((customParse(startdate)<customParse(reValuedate)) && (customParse(enddate)>customParse(reValuedate))){
            	  if(customParse(startdate)<customParse(enddate)){
                 	 value="true";
                 }
               }
          
    }    
    return value;
}

/**
* Payment Period satrt date Check
*/
function checkDate(enddate,startdateTwo){
	var flag="false";
	 if((enddate != undefined && enddate !='') && (startdateTwo != undefined && startdateTwo !='')){
		 var dt1=new Date();
		 dt1=customParse(enddate);
         dt1.setDate(dt1.getDate()+1);
         var dt2=new Date();
         dt2=customParse(startdateTwo);
		 if((dt1-dt2)==0){flag="true"; }
		 else{ flag="false"; } }
	 return flag;
}

/**
* method to convert string to date
*/
function customParse(str) {
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    n = months.length;
    re = /(\d{2})\s([a-z]{3})\s(\d{4})/i;
    var matches;    while (n--) { months[months[n]] = n; }
     matches = str.match(re);
return new Date(matches[3], months[matches[2]], matches[1]);
}




 

 

 