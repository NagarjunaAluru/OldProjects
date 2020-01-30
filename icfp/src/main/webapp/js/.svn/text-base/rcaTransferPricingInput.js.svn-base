 //Load Solvency Calculation for RCA on screen Load 
$(document).ready(function(){
	 onLoadSolvencyCalc();
	
	 
	 $("#guaranteeFeeApplicableYesID").click( function(e){
		 guaranteeAggAttID();
	 });
	 
	 $("#guaranteeFeeApplicableNoID").click( function(e){
		 guaranteeAggAttID();
	 });
});

  function guaranteeAggAttID()
  {
	  var guaranteeFeeApplicableFlag = $('input[name=guaranteeFeeApplicableFlag]:checked').val();
	
	  if(guaranteeFeeApplicableFlag == "true"){
			 $('#guaranteeAggAttID').show();
		 }else{
			 $('#guaranteeAggAttID').hide();
		 }
  }
  function resetModelValues()
  {
		  var modelType = $("#me-conditional-select").val();
		  if(modelType != "Other" ){
			  $('#totalDebtUSDID').val("");
			  $('#totalDebtTotalCapitalID').val("");;
			  $('#totalCapitalUSDID').val("");
			  $('#netChangeOffID').val("");
			  $('#netIncomeUSDID').val("");
			  $('#netInterestMarginID').val("");
			  $('#returnOnAvgAssetsID').val("");
		  }
		  
  }
  function covertDataToCurrencyFormat()
  {
	       
		   $("#totalDebtUSDID").val(commaSeperateAmt($("#totalDebtUSDID").val()));
		   $("#totalCapitalUSDID").val(commaSeperateAmt($("#totalCapitalUSDID").val()));
	 	   $("#netIncomeUSDID").val(commaSeperateAmt($("#netIncomeUSDID").val()));
		   $("#derPreTransactionID").val(commaSeperateAmt($("#derPreTransactionID").val()));
		   $("#derPostTransactionID").val(commaSeperateAmt($("#derPostTransactionID").val()));
		   $("#drPreTransactionID").val(commaSeperateAmt($("#drPreTransactionID").val()));
		   $("#drPostTransactionID").val(commaSeperateAmt($("#drPostTransactionID").val()));
		   $("#icPreTransactionID").val(commaSeperateAmt($("#icPreTransactionID").val()));
		   $("#icPostTransactionID").val(commaSeperateAmt($("#icPostTransactionID").val()));
		   $("#acrPreTransactionID").val(commaSeperateAmt($("#acrPreTransactionID").val()));
		   $("#acrPostTransactionID").val(commaSeperateAmt($("#acrPostTransactionID").val()));
		   $("#pePreTransactionID").val(commaSeperateAmt($("#pePreTransactionID").val()));
		   $("#pePostTransactionID").val(commaSeperateAmt($("#pePostTransactionID").val()));
		   $("#pscPreTransactionID").val(commaSeperateAmt($("#pscPreTransactionID").val()));
		   $("#pscPostTransactionID").val(commaSeperateAmt($("#pscPostTransactionID").val()));
		   $("#floatMinSpreadBPSID").val(commaSeperateAmt($("#floatMinSpreadBPSID").val()));
		   $("#floatMaxSpreadBPSID").val(commaSeperateAmt($("#floatMaxSpreadBPSID").val()));
  }
  
 
  
  function removeAmountShortcuts(){
	  
	  $("#totalDebtUSDID").val(replaceCammaWithEmpty($("#totalDebtUSDID")));
	  $("#totalCapitalUSDID").val(replaceCammaWithEmpty($("#totalCapitalUSDID")));
	  $("#netIncomeUSDID").val(replaceCammaWithEmpty($("#netIncomeUSDID")));
	  $("#derPreTransactionID").val(replaceCammaWithEmpty($("#derPreTransactionID")));
      $("#derPostTransactionID").val(replaceCammaWithEmpty($("#derPostTransactionID")));	
	  $("#drPreTransactionID").val(replaceCammaWithEmpty($("#drPreTransactionID")));
	  $("#drPostTransactionID").val(replaceCammaWithEmpty($("#drPostTransactionID")));
	  $("#icPreTransactionID").val(replaceCammaWithEmpty($("#icPreTransactionID")));
	  $("#icPostTransactionID").val(replaceCammaWithEmpty($("#icPostTransactionID")));
	  $("#acrPreTransactionID").val(replaceCammaWithEmpty($("#acrPreTransactionID")));	
	  $("#acrPostTransactionID").val(replaceCammaWithEmpty($("#acrPostTransactionID")));
	  $("#pePreTransactionID").val(replaceCammaWithEmpty($("#pePreTransactionID")));
	  $("#pePostTransactionID").val(replaceCammaWithEmpty($("#pePostTransactionID")));
	  $("#pscPreTransactionID").val(replaceCammaWithEmpty($("#pscPreTransactionID")));
	  $("#pscPostTransactionID").val(replaceCammaWithEmpty($("#pscPostTransactionID")));	
	  $("#floatMinSpreadBPSID").val(replaceCammaWithEmpty($("#floatMinSpreadBPSID")));
	  $("#floatMaxSpreadBPSID").val(replaceCammaWithEmpty($("#floatMaxSpreadBPSID")));
	  $("#totalDebtTotalCapitalID").val(replaceCammaWithEmpty($("#totalDebtTotalCapitalID")));
	 
	}
  
  function replaceCammaWithEmpty(dataObject)
  {
	    var val = dataObject.val();
	    if(val){
	    	val = val.replace(/,/g,"");
	    }
	    return val;
  }
  
  function convertData(dataObject)
  {
	  var value = dataObject.val();
	  
	  if(value!=null && value!="" && isNumber(value) && value!='0.00'){
		 
	    $(dataObject).parseNumber({format:"#,###.00", locale:"us"});  
	    $(dataObject).formatNumber({format:"#,###.00", locale:"us"}); 
	  }

	  return dataObject.val();
  }
  
  /**
   * This method is used to check the given value contains expected characters.
   * @param val
   * @returns {Boolean}
   */
  function isNumber(val) {
  	var numericExpression = /^[0-9.]+$/;
     
  	if(val.match(numericExpression)) {
    	return true;
  	} else {

  	return false;

  	}
  }
  
   function  showAssessmentComment()
   {
	   $('#commentsReq0').hide();
	   $('#commentsReq1').hide();
	   $('#commentsReq2').hide();
	   $('#commentsReq3').hide();
	   $('#commentsReq4').hide();
	   $('#commentsReq5').hide();
	   
	   var smradioS6 = $('input[id=smradioS6]:checked').val();
	   
	   if(smradioS6 == "true")
	   {
		   $('#commentsReq6').hide();
	   }else{
		   $('#commentsReq6').show();
	   }
	 
   }

   function getIndexTermDetails(productType)
   {
	   var url = '';
	   var floatingRate = $('#floatingRateIndexID').val();
	   
	  
	   
	   if(productType!=null && productType=='RCA')
	   {
		 url = contextURL+"/transferPricing/transferPricingLeg.do?command=getIndexTermData"; 
	   }else if(productType!=null && productType=='CPA')
	   {
		 url = contextURL+"/transferPricing/cpatransferPricingLeg.do?command=getIndexTermData&productType=CPA";
	   }else if(productType!=null && productType=='OTHER')
	   {
		  url = contextURL+"/transferPricing/transferPricingOtherLeg.do?command=getIndexTermData&productType=OTHER";
	   }
	     var legNum =  $('#legNumberID').val() ;
	     var actionIDData = $('#actionId').val() ;
	   if(url!="")
	      {
	        
	    	  $.post( url, {floatingRateIndex:floatingRate,actionID:actionIDData,legNumber:legNum},
	                    function(data){
	    		        var content = $(data).find("#indexTermDivID");
	    		        
	                    $("#indexTermDivID").empty().append( content.html() );
	            });
	    	}
   }
   
   var passFlag=false;
   var adjustCurrentRatioPassFlag=false;
   var debtRatioPassFlag=false;
   var debtToEquityRatioPassFlag=false; 
   var interestCoveragePassFlag=false; 
   var positiveEquityPassFlag=false; 
   var shareCapitalPassFlag=false; 
   var beforeCalsmradioS6Value = false;
   var beforeCalsmradioH6Value = false;
 
   function solvencyCalc(row,pass,conditionalPass,weakPerformer,onloadFlag)
   {
	   passFlag=false;
	   var postTransactionVal=0;
	   var entityType=$('#fundHoldOperationId').val();
	   if(row!=null)
	   {
		   if(row==0){
			   postTransactionVal =  $('#derPostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics0TdID'),$('#smradioS0'),$('#smradioH0'),$('#commentsReq0'));
			   if(passFlag){
				   debtToEquityRatioPassFlag = true;
			   }else{
				   debtToEquityRatioPassFlag = false;
			   }
			  
		   }else if(row==1){
			   passFlag=false;
			   postTransactionVal =  $('#drPostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics1TdID'),$('#smradioS1'),$('#smradioH1'),$('#commentsReq1'));
			   if(passFlag){
				   debtRatioPassFlag = true;
			   }else{
				   debtRatioPassFlag = false; 
			   }
			  
		   }else if(row==2){
			   passFlag=false;
			   postTransactionVal =  $('#icPostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics2TdID'),$('#smradioS2'),$('#smradioH2'),$('#commentsReq2'));
			   if(passFlag){
				   interestCoveragePassFlag = true;
			   }else{
				   interestCoveragePassFlag = false; 
			   }
			  
		   }else if(row==3){
			   passFlag=false;
			   postTransactionVal =  $('#acrPostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics3TdID'),$('#smradioS3'),$('#smradioH3'),$('#commentsReq3'));
			   if(passFlag){
				   adjustCurrentRatioPassFlag = true;
			   }else{
				   adjustCurrentRatioPassFlag = false; 
			   }
			  
		   }else if(row==4){
			   passFlag=false;
			   postTransactionVal =  $('#pePostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics4TdID'),$('#smradioS4'),$('#smradioH4'),$('#commentsReq4'));
			   if(passFlag){
				   positiveEquityPassFlag = true;
			   }else{
				   positiveEquityPassFlag = false; 
			   }
			  
		   }else if(row==5){
			   passFlag=false;
			   postTransactionVal =  $('#pscPostTransactionID').val();
			   setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,$('#solvencyMetrics5TdID'),$('#smradioS5'),$('#smradioH5'),$('#commentsReq5'));
			   if(passFlag){
				   shareCapitalPassFlag = true;
			   }else{
				   shareCapitalPassFlag = false; 
			   }
			  
		   }
		  
		   if(onloadFlag){
			   if(row==5){
			      calculateBorrowerInsolvent(entityType,$("#smradioS6"),$("#smradioH6"),$('#commentsReq6'),postTransactionVal);
			   }
		   }else{
			   calculateBorrowerInsolvent(entityType,$("#smradioS6"),$("#smradioH6"),$('#commentsReq6'),postTransactionVal);   
		   }
		   
		   

		   if(onloadFlag){
		   
		   var afterCalsmradioS6Value = $('input[id=smradioS6]:checked').val();
		   var afterCalsmradioH6Value = $('input[id=smradioH6]:checked').val();
		   
		   if(beforeCalsmradioS6Value!=afterCalsmradioS6Value && beforeCalsmradioH6Value!=afterCalsmradioH6Value){
			 
			   $("#solvencyMetrics6TdID").removeClass("solvencyYellowClass");
			   $("#solvencyMetrics6TdID").removeClass("solvencyRedClass");
			   $("#solvencyMetrics6TdID").removeClass("solvencyGreenClass"); 
			   $('#commentsReq6').hide();
			  
			   if(beforeCalsmradioS6Value == 'true')
			   {
				   
				   $("#smradioS6").attr('checked', beforeCalsmradioS6Value);
				   $('#solvencyMetrics6TdID').addClass("solvencyRedClass");
				   $('#commentsReq6').show();
			   }else if(beforeCalsmradioH6Value == 'false'){
				   
				   $("#smradioH6").attr('checked', beforeCalsmradioH6Value);
				   $('#solvencyMetrics6TdID').addClass("solvencyGreenClass"); 
				   $('#commentsReq6').hide();
			   }
		   }else{
			   
			   var borrowerInsolvencyYesFlag = $('#smradioS6').val();
			 
			   if(borrowerInsolvencyYesFlag=="Yes"){
				   $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
				   $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
				   $('#solvencyMetrics6TdID').addClass("solvencyRedClass");
			   }else if (borrowerInsolvencyYesFlag=="No")
			   {
				   $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
				   $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
				   $('#solvencyMetrics6TdID').addClass("solvencyGreenClass");
			   }
			 }
		   }
		  
		   
	   }
    }
   
   function setTDColor(pass,conditionalPass,weakPerformer,postTransactionVal,tdID,yesRadioID,noRadioID,commentsReqID)
   {
	   tdID.removeClass("solvencyYellowClass");
	   tdID.removeClass("solvencyRedClass");
	   tdID.removeClass("solvencyGreenClass"); 
	   
	   var weakerFlag=false;
	   var conditionalPassFlag=false;
	   passFlag=false;
	   
       passFlag = calculation(pass,postTransactionVal);
      
       if(passFlag){
    	   tdID.addClass("solvencyGreenClass"); 
    	   yesRadioID.val("true"); 
    	   commentsReqID.hide();
    	   return;
       }else{
    	   conditionalPassFlag = conditionalPassCalc(conditionalPass,postTransactionVal); 
       }
      
       if(conditionalPassFlag){
    	   tdID.addClass("solvencyYellowClass"); 
    	   yesRadioID.val("false");
    	   commentsReqID.show();
    	   return;
	   }else{
		   weakerFlag = calculation(weakPerformer,postTransactionVal);
	   } 
      
       if (weakerFlag){
    	   tdID.addClass("solvencyRedClass");
    	   yesRadioID.val("false");
    	   noRadioID.attr('checked', true);
    	   commentsReqID.show();
	   }
   }
   
   var lessthan=false;
   var greaterthan= false;
   var equalto = false;
   
   function calculation(staticData,postTransactionVal)
   {
	   lessthan=false;
	   greaterthan=false;
	   equalto=false;
	   calculatedFlag=false;
	   
	   var staticDataFloatVal =  convertStrToNumber(staticData);
	 
	   postTransactionVal = parseFloat(postTransactionVal);
	   
	  if(lessthan && (postTransactionVal < staticDataFloatVal)){
		   calculatedFlag = true;
	   }
	   
	   if(greaterthan && (postTransactionVal > staticDataFloatVal)){
		   calculatedFlag = true;
	   }
	   
	   if(equalto && (postTransactionVal==staticDataFloatVal)){
		   calculatedFlag = true;
	   }
	   
	   return calculatedFlag;
	   
   }
   
   function conditionalPassCalc(staticData,postTransactionVal)
   {
	   var staticDataTokens=0;
	   if(staticData!=null && staticData!=undefined){
		   staticDataTokens = staticData.split( "-" );  
	   }
	   var data="";
	   var minValue=0;
	   var maxValue=0;
	   var conditionalPassFlag = false;
	   postTransactionVal = parseFloat(postTransactionVal);
	   
	   if(staticDataTokens!=null && staticDataTokens.length>0)
	   {
		   conditionalPassFlag = false;
		   for ( var i = 0; i < staticDataTokens.length; i++ ) 
		   {
			   data = staticDataTokens[i];
			   
			   data = data.replace(',','');
			   data = data.replace(',','');
			   data = data.replace(',','');
			   
			   floatData = parseFloat(data);
			   if(i==0){
				   minValue = parseFloat(data);
			   }else if (i==1){
				   maxValue = parseFloat(data);
			   }
		   }
		
		   if(postTransactionVal>=minValue && postTransactionVal<=maxValue)
		   {
			   conditionalPassFlag = true;
		   }
	   }
	   return conditionalPassFlag;
   }
   
 
   function convertStrToNumber(strValue)
   {
	   lessthan=false;
	   greaterthan=false;
	   equalto=false;
	 if(strValue==undefined || strValue==null){
		return; 
	 }
	   for(var i=0;i<strValue.length;i++)
	   {
		  
		   var modifiedFlag = false;
		   var str = strValue.substring(0,1);
		   
		   if(str=='<'){
		      lessthan = true;
		      modifiedFlag = true;
		   }else if(str=='>'){
		      greaterthan = true;
		      modifiedFlag = true;
		   }else if(str=='='){
		      equalto = true;
		      modifiedFlag = true;
		   }else if (str==" "){
			  modifiedFlag = true;
		   }
		    
		   if(modifiedFlag)
		   {
			   strValue = strValue.replace(strValue.substring(0,1),'');
			   
		   }else{
			   break;
		   }
		 
	   }
	   strValue = strValue.replace(',','');
	   strValue = strValue.replace(',','');
	   strValue = strValue.replace(',','');
	  
	   return parseFloat(strValue);
	  
   }
   
   function calculateBorrowerInsolvent(entityType,yesRadioID,noRadioID,commentsReqID,postTransactionVal)
   {
	   
	   $('#solvencyMetrics6TdID').removeClass("solvencyYellowClass");
	   $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
	   $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
	   commentsReqID.hide();
	   if(entityType!=null && entityType!="" && 
			   (entityType=="1" || entityType=="2") &&
			   shareCapitalPassFlag){
		   $('#solvencyMetrics6TdID').addClass("solvencyGreenClass"); 
		   noRadioID.attr('checked', true);
		   commentsReqID.hide();
	   }else if (entityType!=null && entityType!="" && entityType=="3" && 
			   positiveEquityPassFlag)
	   {
		   var count=0;
		   
		   if(adjustCurrentRatioPassFlag){
			   count++;
		   }
		   if(debtRatioPassFlag){
			   count++;
		   }
		   if(debtToEquityRatioPassFlag){
			   count++;
		   }
		   if(interestCoveragePassFlag){
			   count++;
		   }
		   if(shareCapitalPassFlag){
			   count++;
		   }
		   
		   if(count>=3){
			   $('#solvencyMetrics6TdID').addClass("solvencyGreenClass"); 
			   noRadioID.attr('checked', true);
			   commentsReqID.hide();
			   
		   }else{
			   $('#solvencyMetrics6TdID').addClass("solvencyRedClass");
			   yesRadioID.attr('checked', true);
			   commentsReqID.show();
			   
		   }
	   }else if (postTransactionVal!=null && postTransactionVal!=""){
		   $('#solvencyMetrics6TdID').addClass("solvencyRedClass"); 
		   yesRadioID.attr('checked', true);
		   commentsReqID.show();
	   }
   } 
   
   function onLoadSolvencyCalc()
   {
	   removeAmountShortcuts();
	   beforeCalsmradioS6Value = $('input[id=smradioS6]:checked').val();
	   beforeCalsmradioH6Value = $('input[id=smradioH6]:checked').val();
	 
	   solvencyCalc(0,$('#smpass0id').val(),$('#smconditionalPass0id').val(),$('#smweakPerformer0id').val(),true);
	   solvencyCalc(1,$('#smpass1id').val(),$('#smconditionalPass1id').val(),$('#smweakPerformer1id').val(),true);
	   solvencyCalc(2,$('#smpass2id').val(),$('#smconditionalPass2id').val(),$('#smweakPerformer2id').val(),true);
	   solvencyCalc(3,$('#smpass3id').val(),$('#smconditionalPass3id').val(),$('#smweakPerformer3id').val(),true);
	   solvencyCalc(4,$('#smpass4id').val(),$('#smconditionalPass4id').val(),$('#smweakPerformer4id').val(),true);
	   solvencyCalc(5,$('#smpass5id').val(),$('#smconditionalPass5id').val(),$('#smweakPerformer5id').val(),true);
	  
   }
   
   /**
    * Method to add the comma seperate for the mount & the USD Equivalent
    * @param originalCCYAmount
    */
   function commaSeperateAmt(amountValue){
   	value= amountValue;
	var negativeStr = "";
	if(value!=null && value!=""){
		negativeStr = value.charAt(0);
	  if(negativeStr=='-'){
	 		value = value.replace('-','');
	 	}
	}
	
	
   	if(value!=undefined && value!=null && value!=""){
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
   	}
   	if(negativeStr=='-'){
 		value='-'+value;
 	}
   	return value;
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
   
   function validateQualitativeAssesment()
   {
	   var qAssessment = $('input:radio[id=qualitativeFactor10]:checked').val();
		if(qAssessment==undefined){
			$('#qFIdErrorDiv10').addClass("req-error");
			return true;
		}else{
			$('#qFIdErrorDiv10').removeClass("req-error");
			if(qAssessment==1 || qAssessment==2){
				var commentValue = $('#qualitativeFactorComment10').val();
				if(commentValue==""){
					$('#commentErrorID').show();
					return true;
				}
			}else {
				$('#commentErrorID').hide();
				return false;
			}
		}
		
		return false;
		
   }
   