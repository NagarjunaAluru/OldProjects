function setDynamicRow(type)
	{
		var product = $('#productType option:selected').text();
		var productValue ="";
		if(product.length>0) {
			if(product=='Select...') {
				productValue = "--";
			} else {
				productValue = ""+product+"";
			}
		} else {
			productValue = "--"; 
		}
	
		var termInMonths = $("#termInMonths").val();
		if(termInMonths.length>0) {
			termInMonths = ""+termInMonths+"";
		} else {
			termInMonths =  "--";
		}
		var lenderGoldId = $("#lenderOrProvider").val();
		if(lenderGoldId.length>0) {
			lenderGoldId = ""+lenderGoldId+"";
		} else {
			lenderGoldId =  "--";
		}
		 
		 var borrowerGoldId = $("#borrowerOrRecipient").val();
		if(borrowerGoldId.length>0) {
			borrowerGoldId =  ""+borrowerGoldId+"";
		} else {
			borrowerGoldId =  "--";
		}
		
		 var guarantorGoldId = $("#guarantorInfo").val();
		 if(guarantorGoldId!=undefined) { 
			if(guarantorGoldId.length>0) {
				guarantorGoldId = ""+guarantorGoldId+"";
			} else {
				guarantorGoldId =  "--";
			}
		 }
		var originalCCY = $("#originalCCY").val();
			if(originalCCY.length>0) {
				originalCCY =  ""+originalCCY+"";
			} else {
				originalCCY = "--";
			}
		
			
		 var originalCCYAmount = $("#originalCCYAmount").val();
			if(originalCCYAmount.length>0) {
				if(originalCCYAmount!='null') {
				originalCCYAmount =  ""+originalCCYAmount+"";
				} else {
					originalCCYAmount = "--";
				}
			} else {
				originalCCYAmount = "--"; 
			}
		 var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
		 if(derivativesFlag==undefined) {
				 derivativesFlag ="--";
			 } else {	
			 if(derivativesFlag=="true") {
				 derivativesFlag ="Yes";
			 }	
			 else {
				 derivativesFlag ="No";
			 }
		 }
		 var existingFlag = $('input[id=existingFlag]:checked').val();
		 if(existingFlag==undefined) {
			 existingFlag ="--";
		 } else {	
		 if(existingFlag=="true") {
			 existingFlag ="Yes";
		 }	
		 else {
			 existingFlag ="No";
		 }
		 }
		 if(type=='Legal Agreements(s)') {
				document.getElementById('td1').innerHTML = productValue; 
				document.getElementById('td2').innerHTML = termInMonths; 
				document.getElementById('td3').innerHTML = lenderGoldId; 
				document.getElementById('td4').innerHTML = "--";
				document.getElementById('td5').innerHTML = borrowerGoldId;
				document.getElementById('td6').innerHTML = "--";
				document.getElementById('td7').innerHTML = originalCCY;
				document.getElementById('td8').innerHTML = originalCCYAmount;
				document.getElementById('td9').innerHTML = "--";
				document.getElementById('td10').innerHTML = derivativesFlag;
				document.getElementById('td11').innerHTML = existingFlag;
		 }
		 if(type=='Consolidated Financial Statements') {
				document.getElementById('td18').innerHTML = productValue; 
				document.getElementById('td19').innerHTML = termInMonths; 
				document.getElementById('td20').innerHTML = lenderGoldId; 
				document.getElementById('td21').innerHTML = "--";
				document.getElementById('td22').innerHTML = borrowerGoldId;
				document.getElementById('td23').innerHTML = "--";
				document.getElementById('td24').innerHTML = originalCCY;
				document.getElementById('td25').innerHTML = originalCCYAmount;
				document.getElementById('td26').innerHTML = "--";
				document.getElementById('td27').innerHTML = derivativesFlag;
				document.getElementById('td28').innerHTML = existingFlag;
		 }
		 if(type=='Corporate Governance Documents') {
				document.getElementById('td29').innerHTML = productValue; 
				document.getElementById('td30').innerHTML = termInMonths; 
				document.getElementById('td31').innerHTML = lenderGoldId; 
				document.getElementById('td32').innerHTML = "--";
				document.getElementById('td33').innerHTML = borrowerGoldId;
				document.getElementById('td34').innerHTML = "--";
				document.getElementById('td35').innerHTML = originalCCY;
				document.getElementById('td36').innerHTML = originalCCYAmount;
				document.getElementById('td37').innerHTML = "--";
				document.getElementById('td38').innerHTML = derivativesFlag;
				document.getElementById('td39').innerHTML = existingFlag;
		 }
		 if(type=='Other Documents') {
				document.getElementById('td40').innerHTML = productValue; 
				document.getElementById('td41').innerHTML = termInMonths; 
				document.getElementById('td42').innerHTML = lenderGoldId; 
				document.getElementById('td43').innerHTML = "--";
				document.getElementById('td44').innerHTML = borrowerGoldId;
				document.getElementById('td45').innerHTML = "--";
				document.getElementById('td46').innerHTML = originalCCY;
				document.getElementById('td47').innerHTML = originalCCYAmount;
				document.getElementById('td48').innerHTML = "--";
				document.getElementById('td49').innerHTML = derivativesFlag;
				document.getElementById('td50').innerHTML = existingFlag;
		 }
		 if(type=='Journal Entries') {
				document.getElementById('td51').innerHTML = productValue; 
				document.getElementById('td52').innerHTML = termInMonths; 
				document.getElementById('td53').innerHTML = lenderGoldId; 
				document.getElementById('td54').innerHTML = "--";
				document.getElementById('td55').innerHTML = borrowerGoldId;
				document.getElementById('td56').innerHTML = "--";
				document.getElementById('td57').innerHTML = originalCCY;
				document.getElementById('td58').innerHTML = originalCCYAmount;
				document.getElementById('td59').innerHTML = "--";
				document.getElementById('td60').innerHTML = derivativesFlag;
				document.getElementById('td61').innerHTML = existingFlag;
		 }
	}

/**
 * Method to show the fields based on the Equity form Id On change
 * @param equityFormId
 */
function equityFormIdOnChange(equityFormId){
	if(equityFormId == '1'||equityFormId == '2'||equityFormId == '3'  ){
		$('.product-type-debtfields, .product-type-comments').hide();
		$('.product-type-all').show();
		$('#allProductTypeDiv').show();
		$('#debtProductTypeDiv').hide();
		$('#commenstDiv').hide();
	}else if(equityFormId == '5'){
		$('.product-type-debtfields').hide();
		$('.product-type-all, .product-type-comments').show();
		$('#allProductTypeDiv').show();
		$('#debtProductTypeDiv').hide();
		$('#commenstDiv').show();
	}else if(equityFormId == '4'){
		$('.product-type-all, .product-type-comments').hide();
		$('.product-type-debtfields').show();
		$('#allProductTypeDiv').hide();
		$('#debtProductTypeDiv').show();
		$('#commenstDiv').hide();
	}else{
		$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
		$('#allProductTypeDiv').hide();
		$('#debtProductTypeDiv').hide();
		$('#commenstDiv').hide();
	}
	$(".otherEquityChar").text(1000);
	killNested();
	$('#derivatives-table').hide();
}


/**
 * Method to killNested for the Equity
 */
function killNested(){
	$('.nested:visible').removeAttr('style')
		$('.table-nested tbody tr').removeAttr('style')
		$('.table-nested .expanded').removeClass('expanded')

}

/**
 * Method to format the money
 * @param val
 * @param c
 * @param d
 * @param t
 * @returns
 */
function formatMoney(val, c, d, t){
	var i = val, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t,  j = (j = i.length) > 3 ? j % 3 : 0;
   return  (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t);
};

/**
 * Mehtod to Add the Error message for validations
 * @param id
 * @param msg
 */
function addErrorMessage(id, msg){
	$(id).find("span.errmsg").remove();
	var a = document.createElement("span");
	$(a).addClass('errmsg');
	$(a).css({'color':'#bf2f24', 'font-family':'Arial', 'font-weight':'bold', 'font-size':'11px', 'margin-left':'10px'});
	$(a).text( msg );
	$(id).prepend(a);
}

/**
 * Method to remove the validations for validations
 * @param id
 */
function removeErrorMessage(id){
	$(id).find("span.errmsg").remove();
}

/**
 * Clear the fieds for the Lender or Issuer or Provider for the Gold Id
 */
function clearLenderDetails(){
	$('#lenderOrProvider').val("");
	$("#lenderOrProviderSetupPending").removeAttr("checked");
	$("#lenderInfofailed").val("");
	$("#lenderInfofailed").hide();
	$("#lenderInfofailedBar").hide();
	$("#lenderInfoInvalid").hide();
	
	$("#LenderSetUpFlagTDiv").show();
	$("#LenderSetUpFlagFDiv").hide();
	$("#lenBusSegTDiv").show();
	$("#lenBusSegFDiv").hide();
	
	$("#regulatedEntityFlag1").removeAttr("checked");
	$("#regulatedEntityFlag2").removeAttr("checked");
	$("#princplEntityFlag1").removeAttr("checked");
	$("#princplEntityFlag2").removeAttr("checked");
	$("#regulatedEntityFlag1").attr("disabled", "disabled");
	$("#regulatedEntityFlag2").attr("disabled", "disabled");
	$("#princplEntityFlag1").attr("disabled", "disabled");
	$("#princplEntityFlag2").attr("disabled", "disabled");
	
}

/**
 * Clear the fields for Purchaser or Borrower Or Recipient for the Gold Id
 */
function clearBorrowerDetails(){
	$('#borrowerOrRecipient').val("");
	$("#borrowerOrRecipientSetupPending").removeAttr("checked");
	$("#borrowerInfofailed").val("");
	$("#borrowerInfofailed").hide();
	$("#borrowerInfofailedBar").hide();
	$("#borrowerInfoInvalid").hide();
	
	$("#BorrowerSetUpFlagTDiv").show();
	$("#BorrowerSetUpFlagFDiv").hide();
	$("#borBusSegTDiv").show();
	$("#borBusSegFDiv").hide();
	
	$("#borRegulatedEntityFlag1").removeAttr("checked");
	$("#borRegulatedEntityFlag2").removeAttr("checked");
	$("#borPrincplEntityFlag1").removeAttr("checked");
	$("#borPrincplEntityFlag2").removeAttr("checked");
	$("#borRegulatedEntityFlag1").attr("disabled", "disabled");
	$("#borRegulatedEntityFlag2").attr("disabled", "disabled");
	$("#borPrincplEntityFlag1").attr("disabled", "disabled");
	$("#borPrincplEntityFlag2").attr("disabled", "disabled");
}

/**
 * Clear the fields for the Lender or Issuer or Provider for the TreasuryDetails
 */
function clearTreasuryDetails(){
	$('#lenderTreasuryDetails').hide();
	$("#lenderTreasuryfailed").hide();
	$("#lenderTreasuryfailedBar").hide();
	$("#lenderTreasuryInvalid").hide();
}

/**
 * lear the fields for Purchaser or Borrower Or Recipient for the BorrowerDetails
 */
function clearBorrowerTreasuryDetails(){
	$('#borrowerTreasuryDetails').hide();
	$("#borrowerTreasuryfailed").hide();
	$("#borrowerTreasuryfailedBar").hide();
	$("#borrowerTreasuryInvalid").hide();
}

/**
 * Hide the validation error Message
 */
function closeMessage(){
	$('#validateFlag').hide();
}

/**
 * Validations on click of the save as draft 
 * @param cmd
 */
function saveAsDraft(cmd){
	$("#lenderInfofailedBar").hide();
	$("#lenderMgmtfailedBar").hide();
	$("#lenderCap").removeClass("req-error");
	$("#borrowerInfofailedBar").hide();
	$("#borrowerMgmtfailedBar").hide();
	$("#borrowerCap").removeClass("req-error");
	$("#productTypefailedBar").hide();
	$("#legalAgreementDiv").removeClass("req-error");
	$("#subordinatedDiv").removeClass("req-error");
	$("#existingDiv").removeClass("req-error");
	$("#derivativDiv").removeClass("req-error");
	$("#exceptionCommentsBar").hide();
	$("#termValidateBar").hide();
	$("#originalCCYValidateBar").hide();
	$("#originalCCYAmountValidateBar").hide();
	
	
	
	$("#borRegulatedEntityFlag1").removeAttr("disabled");
	$("#borRegulatedEntityFlag2").removeAttr("disabled");
	$("#borPrincplEntityFlag1").removeAttr("disabled");
	$("#borPrincplEntityFlag2").removeAttr("disabled");
	
	$("#regulatedEntityFlag1").removeAttr("disabled");
	$("#regulatedEntityFlag2").removeAttr("disabled");
	$("#princplEntityFlag1").removeAttr("disabled");
	$("#princplEntityFlag2").removeAttr("disabled");
	
	var val = $( "#otherFeeAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#otherFeeAmt" ).val(val);
	}
		
	var validateflag  =false;
	var productType = $("#productType").val();
	if(productType == ""){
		$("#productTypefailedBar").show();
		validateflag = true;
	}else {
		$("#productTypefailedBar").hide();
	}
	
	if(productType == "2"){
				
		//equityDataValidation
		var equityFormId = $('#equityFormId').val();
		if(equityFormId==1 || equityFormId==2 || equityFormId==3 || equityFormId==5){
			if( equityDataValidation() ){
			}else{
				validateflag = true;
			}
		}
		if(equityFormId==4){
			if( equityDebtDataValidation() ){
			}else{
				validateflag = true;
			}
		}
	}
	
	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	if(validateflag == false && !isVisible){
		removeAmountShortcuts();
		removeUsdShortcuts();
		
		var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
		if(fixedOrFloat!=undefined && fixedOrFloat == "2"){
			var floatSpreadID = $('#floatSpreadID').val();
			if(floatSpreadID!=undefined && floatSpreadID!=""){
				$('#fixedSpreadID').val(floatSpreadID);
			}
		}
		
		document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
		document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
		
		var productType = $("#productType").val();
		if(productType == "2"){
			var equityFormId = $('#equityFormId').val();
			
			var  equityDescriptionValue = $('#equityDescriptionID').val();
			if(equityDescriptionValue!=null && equityDescriptionValue!='undefined' && equityDescriptionValue!='')
				{
				$('#equityDescriptionCommentsId').val(equityDescriptionValue);
				}
			
			if(equityFormId==1 || equityFormId==2 || equityFormId==3 || equityFormId==5){
				$('.product-type-debtfields').remove();
			}
			if(equityFormId==4){
				$('.product-type-all').remove();
			}
		}
		
		var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
		if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
		{
			$('input[id=lenderEntitySetupFlag]').attr('checked', true);
			$("#lenderEntitySetupFlag").val("N");
		}
		
		var borrowerEntitySetupFlag = $('input[id=borrowerEntitySetupFlag]:checked').val();
		if(borrowerEntitySetupFlag==null || borrowerEntitySetupFlag == "" || borrowerEntitySetupFlag == undefined)
		{
			$('input[id=borrowerEntitySetupFlag]').attr('checked', true);
			$("#borrowerEntitySetupFlag").val("N");
		}
		
		var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
		var action = RCALegRequestForm.action;
		action = action+cmd; 
		RCALegRequestForm.action = action;
		RCALegRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

/**
 * Method to add the Exception Row
 */
function addExceptionRow() {
	
	if($(this).prev('table').hasClass('exceptions-nested')){
		$('<tr class="added"></tr>').appendTo('.exceptions tbody')
		$('<tr class="attachment1"></tr>').appendTo('.exceptions tbody')
		$('<tr class="attachment2"  onclick="displayResult(this)"></tr>').appendTo('.exceptions tbody')
	}else{
		$('<tr class="added"></tr>').appendTo('.exceptions tbody')
	}
	
	if($(this).hasClass('non-required')){
		$('.added').load('lib/add-exception-non-required.html').removeAttr('class');

	}else if($(this).prev('table').hasClass('exceptions-nested')){
		$('.added').load('lib/add-exception-nested1.html');
		var l = $(this).prev('table tbody').find('tr').length;
		//alert(l); 
		$('.added input:radio').attr("name", "exceptionDetails[" + (Math.floor(l/3)) + "].exceptionTimelineId");
		$('.added').removeAttr('class');
		$('.attachment1').load('lib/add-exception-nested2.html').addClass('attachment-nested').removeClass('attachment1')
		$('.attachment2').load('lib/add-exception-nested3.html').addClass('attachment-nested2').removeClass('attachment2')

	}else{
		$('.added').load('lib/add-exception.html').removeAttr('class');
	}
		
	zebraStripes();
	autoTextarea();
	
	$('.autosize').bind('keyup', textareaCounter);
}


/**
 * Method to add the zebra stripes for Exceptions
 */
function zebraStripes(){
if ($.browser.msie) {
	$("tbody tr:even").addClass("even");//dumb ie 
	 $('thead .header').live('click',function(){
		$(".even").removeClass("even")
		$("tbody tr:even").addClass("even")
	}) 	
}
}

/**
 * Method to add the autoTextarea for Exceptions
 */
function autoTextarea(){
$('textarea.autosize').autoResize({
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

/**
 * Method to increase text area counter
 */
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
$('.autosize').bind('keyup', textareaCounter);



/**
 * Method to add the exception details
 * @param rowNumber
 */
function addExceptionDetails(rowNumber) {
var cmd="?command=addExceptionDetails";
isChanged = false;
var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');

var action = RCALegRequestForm.action;
var legNumber = RCALegRequestForm.legNumber.value;
action = action+cmd+"&legNumber="+legNumber+"&sid="+Math.random(); 
if (window.XMLHttpRequest) {
	req = new XMLHttpRequest();
	req.onreadystatechange = reportStatusExceptionAdd;
	try {
		req.open("GET", action, false);
	} catch (e) {
		alert(e);
		uploading = false;
	}
	req.send();
} else if (window.ActiveXObject) {
	req = new ActiveXObject("Microsoft.XMLHTTP");

	if (req) {
		req.onreadystatechange = reportStatusExceptionAdd;
		req.open("GET", action, false);
		req.send();
	} else {
		uploading = false;
	}
}
}

/**
 * Method to report Status Exception Add
 */
function reportStatusExceptionAdd() {
if (req.readyState == 4) {
	if (req.status == 200) { 
		var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
		var exceptionIndexElementList = RCALegRequestForm.elements["exceptionIndex"];
		/*if(exceptionIndexElementList == undefined){
			exceptionIndexElementList = RCALegRequestForm.elements["exceptionIndex1"];
		}*/
		
		exceptionCount = exceptionIndexElementList.length;
		
		var str = req.responseText;
		if(exceptionCount == undefined || exceptionCount==0) {
			RCALegRequestForm.exceptionIndex1.value = str;
		} else{
			exceptionIndexElementList[exceptionCount - 1].value = str;
		}
		
		//var l = $(this).prev('table').find('tr').length;
		//alert('Row Count: ' + l);
		//alert("Test");
		//var str = req.responseText;
		//if(document.getElementById("exceptionIndex").length ==undefined) {
			// $("#exceptionIndex").val(str);
		//} else {
			// $("#exceptionIndex")[rowNumber].val(str);
		//} 
		//alert("Madhu 1111>>" + $("#exceptionIndex")[rowNumber].val(str));
	}
}
}

/**Method to delete the exception details
 * 
 * @param rowNumber
 */
function deleteExceptionDetails(rowNumber) {
//alert('Row Number: ' + rowNumber);
var cmd="?command=deleteExceptionDetails";
isChanged = false;
var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
var action = RCALegRequestForm.action;
var legNumber = RCALegRequestForm.legNumber.value;
var exceptionNumber = rowNumber;
//var exceptionNumber = RCALegRequestForm.exceptionIndex.value;
//alert("exceptionIndex :::"+ exceptionNumber + "Leg Number::::"+ legNumber);
action = action+cmd+"&legNumber="+legNumber+"&exceptionNumber="+rowNumber+"&sid="+Math.random(); 
if (window.XMLHttpRequest) {
	req = new XMLHttpRequest();
	req.onreadystatechange = reportStatusException;
	try {
		req.open("GET", action, false);
	} catch (e) {
		//alert(e);
		uploading = false;
	}
	req.send();
} else if (window.ActiveXObject) {
	req = new ActiveXObject("Microsoft.XMLHTTP");

	if (req) {
		req.onreadystatechange = reportStatusException;
		req.open("GET", action, false);
		req.send();
	} else {
		uploading = false;
	}
}
}


function reportStatusException() {
	if (req.readyState == 4) {
		if (req.status == 200) { 
			var str = req.responseText;
			
			if(document.getElementById("exceptionIndex").length ==undefined) {
				 $("#exceptionIndex").val(str);
			} else {
				 $("#exceptionIndex")[str - 1].val(str);
			} 
			}
		
	}
}

/**
 * Method to redirect to home page
 * @param cmd
 */
function redirectFundingRequest(cmd){
	removeAmountShortcuts();
	removeUsdShortcuts();
	
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd; 
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

/**
 * Method tovalidate the middle office input
 * @param cmd
 */
function validateMiddleOfficeInput(cmd){
  var validateflag = false;
	
	var lComments = $("#lComments").val();
	
	if(lComments == ""){
		addErrorMessage( $("#commentsFailed"), "Please enter comments");
		validateflag = true;
	}else {
		removeErrorMessage( $("#commentsFailed"));
	}	
	if(validateflag == false){
		
		var fourBlockerForm = document.getElementById('fourBlockerForm');
		var action = fourBlockerForm.action;
		action = action+cmd; 
		fourBlockerForm.action = action;
		fourBlockerForm.submit();
	}
	else {
			$('#validateFlag').show();
	}
}

/**
 * This method is used to check whether inputer parameter is number or string.
 * @param val
 * @returns {Boolean}
 */
function IsNumeric(val) {
	if (isNaN(val)) {
	      return false;
	 }
	 return true;
}

/**
 * This method is used to check the given value contains expected characters.
 * @param val
 * @returns {Boolean}
 */
function isNumber(val) {
	var numericExpression = /^\d*(\.\d{2})?$/;
	if(val.match(numericExpression)) {
		return true;
	} else {
		return false;
	}
}

/**
 * Method to validate the Equity validation for the form of equity
 * @returns {Boolean}
 */
function equityValidation () {
	var isvalid =true;
	$(".equity-validation").find(".request-equity").each(function(){
		if($(this).val()!=''){
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	
	$(".equity-validation").find(".request-noOfShares").each(function(){
		var noofShares = $(this).val();
		var val = noofShares;
		val = val.replace(/,/g,"");
		noofShares = val;
		if(noofShares!="" && IsNumeric(noofShares) && isIntegerValue(noofShares)) {
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	$(".equity-validation").find(".request-sharevalue").each(function(){
		var sharevalue = $(this).val();
		var val = sharevalue;
		val = val.replace(/,/g,"");
		sharevalue = val;
		if(IsNumeric(sharevalue) && sharevalue!= ""){
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	return isvalid;
}


/**
 * Method to validate the Equity debt validation for the form of equity
 * @returns {Boolean}
 */
function equityDebtValidation () {
	var isvalid =true;
	$(".equityDebt-validation").find(".requestDebt-equity").each(function(){
		if($(this).val()!='' && isNumber($(this).val())){
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	
	$(".equityDebt-validation").find(".requestDebt-noOfShares").each(function(){
		var noofShares = $(this).val();
		
		if(noofShares!="" && IsNumeric(noofShares) && isIntegerValue(noofShares)) {
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	$(".equityDebt-validation").find(".requestDebt-sharevalue").each(function(){
		var sharevalue = $(this).val();
		if(IsNumeric(sharevalue) && sharevalue!= ""){
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	return isvalid;
}

/**
 * Method to validate the Equity data validation for the form of equity while save
 * @returns {Boolean}
 */
function equityDataValidation () {
	var isvalid =true;
		
	$(".equity-validation").find(".request-noOfShares").each(function(){
		var noofShares = $(this).val();
		if(noofShares!=undefined && noofShares!=""){
			var val = noofShares;
			val = val.replace(/,/g,"");
			noofShares = val;
			if(noofShares!="" && IsNumeric(noofShares) && isIntegerValue(noofShares)) {
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		}
	} );
	$(".equity-validation").find(".request-sharevalue").each(function(){
		var sharevalue = $(this).val();
		if(sharevalue!=undefined && sharevalue!=""){
			var val = sharevalue;
			val = val.replace(/,/g,"");
			sharevalue = val;
			if(IsNumeric(sharevalue)){
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		}
	} );
	return isvalid;
}

/**
 * Method to validate the Equity debt data validation for the form of equity while save
 * @returns {Boolean}
 */
function equityDebtDataValidation () {
	var isvalid =true;
	$(".equityDebt-validation").find(".requestDebt-equity").each(function(){
		if($(this).val()!=''){
			if(isNumber($(this).val())){
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		}
	} );
	
	$(".equityDebt-validation").find(".requestDebt-noOfShares").each(function(){
		var noofShares = $(this).val();
		if(noofShares!=undefined && noofShares!=""){
			var val = noofShares;
			val = val.replace(/,/g,"");
			noofShares = val;
		
			if(noofShares!="" && IsNumeric(noofShares) && isIntegerValue(noofShares)) {	
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		}
	} );
	$(".equityDebt-validation").find(".requestDebt-sharevalue").each(function(){
		var sharevalue = $(this).val();
		if(sharevalue!=undefined && sharevalue!=""){
			var val = sharevalue;
			val = val.replace(/,/g,"");
			sharevalue = val;
			if(IsNumeric(sharevalue)){
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		}
	} );
	return isvalid;
}





/**
 * Method to add the comma seperate for the mount & the USD Equivalent
 * @param originalCCYAmount
 */
function commaSeperate(originalCCYAmount){
	value= originalCCYAmount;
	value = value.replace(/,/g,"").toUpperCase();
	value = $.trim(value);
	
	if( value.match(/K/i) )
		value = value.replace(/K/i,"000");
	else if( value.match(/M/i))
		value = value.replace(/M/i,"000000");
	else if( value.match(/B/i) )
		value = value.replace(/B/i,"000000000");
	
	if( !isNaN(value) && Number(value) > 0 ){
		is_valid = true;
	}
	var arr = value.split('.');
	var res = formatMoney(arr[0], 2, ".", ",");
	if( res != 0){
		var s = res.split('.');			
		value = "" + s[0] + (arr.length > 1 ? '.' + arr[1] : '');			
	}
	$("#originalCCYAmount").val( value );
}


/**
 * This method is used for count left in text areas.
 * @param field
 * @param count
 * @param max
 */
function CountLeft(field, count, max) {
	if (field.value!=null && field.value.length > max)
		field.value = field.value.substring(0, max);
	else
		count.value = max - field.value.length;
}

/**
 * This method is used to handle count in text areas.
 * @param field
 * @param countfield
 * @param maxlimit
 */
function textCounter(field, countfield, maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
	field.value = field.value.substring(0, maxlimit);
	else 
	countfield.value = maxlimit - field.value.length;
}

/**
 * Method to remove the USD Euivalent commas
 */
function removeUsdShortcuts(){
	var val = $( "#USDEquivalent" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#USDEquivalent" ).val(val);
	}
}

/**
 * Method to remove the amount commas 
 */
function removeAmountShortcuts(){
	var val = $( "#originalCCYAmount" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#originalCCYAmount" ).val(val);
	}
}

/**
 * Method to add the comma seperate for the amount
 * @param amount
 */
function commaSeperateAmt(amount){
	value= amount;
	value = value.replace(/,/g,"").toUpperCase();
	value = $.trim(value);
	
	if( value.match(/K/i) )
		value = value.replace(/K/i,"000");
	else if( value.match(/M/i))
		value = value.replace(/M/i,"000000");
	else if( value.match(/B/i) )
		value = value.replace(/B/i,"000000000");
	
	if( !isNaN(value) && Number(value) > 0 ){
		is_valid = true;
	}
	var arr = value.split('.');
	var res = formatMoney(arr[0], 2, ".", ",");
	if( res != 0){
		var s = res.split('.');			
		value = "" + s[0] + (arr.length > 1 ? '.' + arr[1] : '');			
	}
	return value;
}
function getFOIndexTermDetails()
{
	
	   url = '';
	   floatingRate = $('#floatRateIndexId').val();
	   legNum =  $('#legNumberID').val();
	   actionIDData = $('#actionId').val();
	  
		   if(actionIDData!=null && actionIDData==2){
			   url = contextURL+"/frontoffice/RCALegRequest.do?command=getIndexTermData"; 
		   }else if(actionIDData!=null && actionIDData==1){
			   url = contextURL+"/RCALegRequest.do?command=getIndexTermData"; 
		   }
	   if(url!="")
	      {
	        
	    	  $.post( url, {floatingRateIndex:floatingRate,actionID:actionIDData,legNumber:legNum},
	                    function(data){
	    		        var content = $(data).find("#indexTermDivID");
	                    $("#indexTermDivID").empty().append( content.html() );
	            });
	    	}
	   
}
/**
 * This method is used to check the given value contains expected characters.
 * @param val
 * @returns {Boolean}
 */
function isIntegerValue(val) {
	var numericExpression = /^[0-9]+$/;

	if(val.match(numericExpression)) {

	return true;

	} else {

	return false;

	}
}

