var validator;

$(function() {
    
    validator = $("#legSummary").validate({
        rules: {
            'qAssessment': 'required',
            'saveAction': 'required',
            'dealCategoryId': 'required',
            'transactionId': {
                required: {
                    depends: function() {
                    	var selectedTCIn = $('#selectedTransactionCapturedIn option:selected').text();
                    	if(selectedTCIn == 'Other'){
                    		return false;
                    	}else{
                    		return true;
                    	}
                    }
                }
            },
            'facilityId': {
                required: {
                    depends: function() {
                    	var selectedTCIn = $('#selectedTransactionCapturedIn option:selected').text();
                        var productType = $("input[name='pType']").val();
                        if( productType != 'RCA' )
                            return false;
                    	if(selectedTCIn == 'Loan Model' || selectedTCIn == 'Other'){
                    		return false;
                    	}else{
                    		return true;
                    	}
                    }
                }
            },
            'vaultId': {
            	required: {
                    depends: function() {
                    	var productType = $("input[name='pType']").val();
                    	if( productType == 'CPA' ){
                    		return true;
                    	}else{
                    		return false;
                    	}
                	}
            	}
            },
            'lenderTCode': 'required',
            'borrowerTCode': 'required',
            'selectedTransactionCapturedIn': 'required',
            'command':'required',
            'rationale': {
                required: {
                    depends: function() {
                        return $(this).prev().prev().prev().is(":visible");
                    }
                }
            },
            'qApplyAssessment': {
                required: {
                    depends: function() {
                        return $("#optionsCheckbox").is(":checked");
                    }
                }
            }
        },
        errorPlacement: function(error, element) {
            if ($(element).attr("name") == "qAssessment" 
            || $(element).attr("name") == "saveAction"
            || $(element).attr("name") == "command" ) {
                $(element).parents(".radio-container").addClass("req-error");
            } else if ($(element).attr("name") == "qApplyAssessment") {
                $("#optionsCheckbox").parents(".form-row").prepend("<span class='help-block error'>Missing selection</span>");
                $("#optionsCheckbox").parents(".form-row").prepend("<span class='req-error'>error</span>");
            } else {
                $(element).parent().append("<span class='req-error'>error</span>");
            }
        },
        errorContainer: ".alert-danger",
        ignore: ""
    });
    
    $("#saveLeg, #saveNextLeg").click(function(event) {        
    	 removeAllErrors();
         $(".alert-success").hide();
        var TCMOValid = true;
        TCMOValid = workFlowValidation();
        if(!TCMOValid){
        	return false;
        }
       
        $("#legSummary").validate();
    });

    $("#saveLegInput").click(function(){
       	 
       	 $("#legSummary").validate();
       	 var valid=$("#legSummary").valid(); 
         var b=$("input.leGoldId");
         $(b).each(function(){
         	if($(this).val()===""){
         		$(this).parents(".entitylookup").find(".search-container .req-error").show();
         		valid= false;
         	}            	
         });
         var c=$("input[name$=MEName]");
         $(c).each( function(){
         	if($(this).val() === ""){
         		$(this).parents(".ME").prev().find(".req-error").show();
         		valid= false;
         	}

         });
         
         if( !valid){
             $(".alert.alert-danger").show();
             $('html, body').animate({scrollTop:0}, 'fast');
         }         
                
         return valid;
    });
    function removeAllErrors() {
        $("span.req-error").remove();
        $(".radio-container.req-error").removeClass("req-error");
        $("span.label-error").remove();
        $("span.help-block .error").remove();
    
    }
    
    $('#sendBackCmd').click(function(e) {
        
        var comments = $(this).parent().prev().find('textarea');
        
        if ($(comments).val() == "") {
            $(comments).parents(".form-row").append("<span class='req-error'>error</span>");
        } else {
            $("#applyAssessment").modal("hide");
            $("#dealRequestForm").submit();
        }
    });
    $('.autosize').keyup(function() {
        var len = this.value.length;
        if (len >= 500) {
            this.value = this.value.substring(0, 500);
        }
    });
    
    $('.autosize1').keyup(function() {
        var len = this.value.length;
        if (len >= 1000) {
            this.value = this.value.substring(0, 1000);
        }
    });
    

    $('body').on('blur.currency.validate', '.currency', function(e){
        
        if( validAmount(this) )
            coverttoUSD(this);
    });

    $('body').on('blur.currencynoconversion.validate', '.currencynoconversion', function(e){
    	validAmount(this);
    });
    
    $('body').on('blur.currencynegnoconversion.validate', '.currencynegnoconversion', function(e){
    	validNegativeAmount(this);
    });
    
    $('body').on('blur.spreadFRateAmount.validate', '.spreadvalidate', function(e){
    	validSpreadFRateAmount(this);
    });
    
    $('body').on('blur.fRateAmount.validate', '.fixedRatevalidate', function(e){
    	fixedRatevalidate(this);
    });
    
 
    function validAmount(obj){
        
        var $this = $(obj);
        var val = $this.val();

        val = val.replace(/,/g,"");

        var isvalid = /^(\d{1,14})(\.\d{1,2})?$/.test(val);

        if(val!="" && !isvalid){            
            $this.siblings(".req-error").show();
            $this.siblings(".invalid").show().html("Amount can only be 14 + 2 decimals");
            return false;
        }else{
            $this.siblings(".error").hide();
            $this.siblings(".req-error").hide();
            var AmountCommaValue = commaSeperateAmt(val);
            $this.val(AmountCommaValue);
            return true;
        }


    }
    
  function validNegativeAmount(obj){
        var $this = $(obj);
        var val = $this.val();
        val = val.replace(/,/g,"");

        var isvalid = /^-?(\d{1,14})(\.\d{1,2})?$/.test(val);

        if(val!="" && !isvalid){            
            $this.siblings(".req-error").show();
            $this.siblings(".invalid").show().html("Amount can only be 14 + 2 decimals");
            return false;
        }else{
            $this.siblings(".error").hide();
            $this.siblings(".req-error").hide();
            var AmountCommaValue = commaSeperateAmt(val);
            $this.val(AmountCommaValue);
            return true;
        }


    }

    function coverttoUSD(obj){

        var $this = $(obj);
        var val = $this.val();
        
        if(val!=undefined){
    		val = val.replace(/,/g,"");
    	}
        
        var foramount = $this.data("for");
        var amount_val = $("."+foramount).val();
        var loadPos = $this.data("replace");
        
        var productType = $("#productType").val();
        var whichFacility = $this.data("whichfacility");
        var whichEvent = $this.data("whichEvent");

        $this.addClass("loading");
        url = contextURL +"/RCALegRequest.do?command=getUSDEquiDetails";
        var actionId = $('#actionId').val();
        var data ={
             originalCCYAmount: val,
             originalCCY:amount_val,
             productType:productType,
             actionId:actionId,
             amendedFacilityAmt: whichFacility,   
             transactionEventTypeId: whichEvent
        }
        
        $.post( url, data, function(data){
            
            loadPos =  loadPos ? "#"+loadPos : "#usdEquiDiv";

            var content = $(data).find(loadPos);
        
            $(loadPos).empty().append( content.html() );
            $(loadPos).show();
            
            AmountCommaValue = commaSeperateAmt(val);
            $this.val(AmountCommaValue);
           
            if(loadPos == "#usdEquiDiv"){
	            if(productType == "2"){
	                    var content = $(data).find('#eBoardEligibleDiv');
	                    if(content.html().search(/Yes/i)!='-1') {
	                        $('#eBoardEligibleDivAttach').show();
	                    } else {
	                        $('#eBoardEligibleDivAttach').hide();
	                    }
	                    //content
	                    $("#eBoardEligibleDiv").empty().append( content.html() );
	                    $('#eBoardEligibleDiv').show();
	            }else{
	                $('#eBoardEligibleDiv').hide();
	                $('#eBoardEligibleDivAttach').hide();
	            }
            }
            
            $this.removeClass("loading");
        });


    }   
    
    
 function validSpreadFRateAmount(obj){
        
        var $this = $(obj);
        var val = $this.val();

        val = val.replace(/,/g,"");

        var isvalid = /^(-?\d{1,4})(\.\d{1,1})?$/.test(val);

        if(val!="" && !isvalid){            
            $this.siblings(".req-error").show();
            $this.siblings(".invalid").show().html("Amount can only be 4 + 1 decimals");
            return false;
        }else{
            $this.siblings(".error").hide();
            $this.siblings(".req-error").hide();
            return true;
        }
    }
 
 function fixedRatevalidate(obj){
     
     var $this = $(obj);
     var val = $this.val();

     val = val.replace(/,/g,"");

     var isvalid = /^(\d{1,2})(\.\d{1,5})?$/.test(val);

     if(val!="" && !isvalid){            
         $this.siblings(".req-error").show();
         $this.siblings(".invalid").show().html("Amount can only be 2 + 5 decimals");
         return false;
     }else{
         $this.siblings(".error").hide();
         $this.siblings(".req-error").hide();
         return true;
     }
 }
 
     function workFlowValidation() {
 	
		var isvalid =true;
		$(".workflow-validation").find(".request-exp").each(function(){
			if($(this).val()!=''){
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		} );
		$(".exception-validation .radio-container").each(function(){
			if($(this).find("input[type='radio']").is(":checked") == false){
				$(this).addClass("req-error");
			}else{
				$(this).removeClass("req-error");
			}
		});
		return isvalid;
	}
     
     /**
      * Method to add the comma seperate for the mount & the USD Equivalent
      * @param originalCCYAmount
      */
     function commaSeperateAmt(amount){
     	value= amount;
     	
     	var negativeStr = value.charAt(0);
     	
     	if(value.charAt(0)=='-'){
     		value = value.replace('-','');
     	}
     	
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
     	if(negativeStr=='-'){
     		value='-'+value;
     	}
     	return value;
     }
});

