// REQUIRED COUNTER 
$(document).ready(function() {
		//var suretyBondDetailsForm = document.suretyBondDetailsForm;

		//Bond Details
		onloadBonddetilsCount();
		//Principal  
		onloadPrincipalCount();
		$('body').off('change keyup paste click', ':input.requiredPrincipal').on('change keyup paste click', ':input.requiredPrincipal', function() {
		  $("#pendingRequiredPrincipal").text($(":input[value!=''].requiredPrincipal").length);
		});
				
		
		//Obligee
		onloadObligeeCount();
		$('body').off('change keyup paste click', ':input.requiredObligee').on('change keyup paste click', ':input.requiredObligee', function() {
		  $("#pendingRequiredobligee").text($(":input[value!=''].requiredObligee").length);
		});
		
		//Bond Requestor
		onloadBonReqCount();
		$('body').off('change keyup paste click', ':input.bcpReqCount').on('change keyup paste click', ':input.bcpReqCount', function() {
			$("#pendingRequiredBondRequestor").text($(":input[value!=''].bcpReqCount").length);
		});
		
		
		//Mailing Address
		onloadMalingCount();
		$('body').off('change keyup paste click', ':input.requiredMailingAddress').on('change keyup paste click', ':input.requiredMailingAddress', function() {
		  $("#pendingRequiredMailing").text($(":input[value!=''].requiredMailingAddress").length);
		});
		
	//delivery instructions
		deliveryInstruc();

		$('body').off('change keyup paste click', ':radio.requiredRadioDelivery,:input.requiredFieldDelivery').on('change keyup paste click', ':radio.requiredRadioDelivery,:input.requiredFieldDelivery', function() {
			//$(':radio.requiredRadioDelivery,:input.requiredFieldDelivery', deliveryInstructionsForm).on("change keyup paste click checked", function() {
			  $("#pendingReqDelivery").text($(':input:checked.requiredRadioDelivery').length+
					  $(":input[value!=''].requiredFieldDelivery").length);
			});
		
	//Bond Information
		bondInfoSection();
		
		
		$('body').off('change keyup paste click', ':input.requiredBidBond').on('change keyup paste click', ':input.requiredBidBond', function() {
			//$(':input.requiredBidBond').on("change keyup paste click", function() {
				$("#pendingRequiredBidBond").text($(":input[value!=''].requiredBidBond").length);
			});
		$('body').off('change keyup paste click', ':input.requiredContractBond').on('change keyup paste click', ':input.requiredContractBond', function() {
			//$(':input.requiredContractBond').on("change keyup paste click", function() {
			$("#pendingRequiredContractBond").text($(":input[value!=''].requiredContractBond").length);
			});
		$('body').off('change keyup paste click', ':input.requiredLicenseBond').on('change keyup paste click', ':input.requiredLicenseBond', function() {
			//$(':input.requiredLicenseBond').on("change keyup paste click", function() {
			$("#pendingRequiredLicenseBond").text($(":input[value!=''].requiredLicenseBond").length);
			});
		$('body').off('change keyup paste click', ':input.requiredCourtBond').on('change keyup paste click', ':input.requiredCourtBond', function() {
			//$(':input.requiredCourtBond').on("change keyup paste click", function() {
			$("#pendingRequiredCourtBond").text($(":input[value!=''].requiredCourtBond").length);
			});
		$('body').off('change keyup paste click', ':input.requiredAttorney').on('change keyup paste click', ':input.requiredAttorney', function() {
			//$(':input.requiredAttorney').on("change keyup paste click", function() {
			$("#pendingRequiredAttorney").text($(":input[value!=''].requiredAttorney").length);
			});
		$('body').off('change keyup paste click', ':input.requiredCustomBond').on('change keyup paste click', ':input.requiredCustomBond', function() {	
			//$(':input.requiredCustomBond').on("change keyup paste click", function() {
			$("#pendingRequiredCustomBond").text($(":input[value!=''].requiredCustomBond").length);
			});
		
		
		
});

function onloadBonddetilsCount(){
	if($('#selectBond :selected').val() ==''){
		bondInfoSection();
	$("#totalRequiredBond").text($(":input.sbRequiredBondDet").length);
	$("#pendingRequiredBond").text($(":input[value !=''].sbRequiredBondDet").length);
	
	$('body').off('change keyup paste click', ':input.sbRequiredBondDet').on('change keyup paste click', ':input.sbRequiredBondDet', function() {
		onChangeSite();
	if($('#selectBond :selected').val() ==2 || $('#selectBond :selected').val() ==3 || $('#selectBond :selected').val() ==4)
	{
		$("#totalRequiredBond").text($(":input.sbReqSubInclude").length);	
		$("#pendingRequiredBond").text($(":input[value !=''].sbReqSubInclude").length);
	}
	else{
		$("#totalRequiredBond").text($(":input.sbRequiredBondDet").length);
		$("#pendingRequiredBond").text($(":input[value !=''].sbRequiredBondDet").length);
	}
	});
	}
	else
		{
			bondInfoSection();
			var bondType = $('#selectBond :selected').val();
			var subBondType = $('#bondSubType').val();
			
			if(bondType ==2 || bondType == 3 || bondType == 4 && subBondType !=''){
					$("#totalRequiredBond").text($(":input.sbReqSection").length);
					$("#pendingRequiredBond").text($(":input[value !=''].sbReqSection").length );
					
					$('body').off('change keyup paste click', ':input.sbReqSubInclude').on('change keyup paste click', ':input.sbReqSubInclude', function() {
						onChangeBond(bondType);
					});
				}
			else{
					$("#totalRequiredBond").text($(":input.sbRequiredBondDet").length);
					$("#pendingRequiredBond").text($(":input[value !=''].sbRequiredBondDet").length);
					onChangeBond(bondType);
				}
		}
	
}

function onloadPrincipalCount(){
	$("#totalRequiredPrincipal").text($(":input.requiredPrincipal").length);
	$("#pendingRequiredPrincipal").text($(":input[value!=''].requiredPrincipal").length);
}
function onloadObligeeCount(){
	$("#totalRequiredobligee").text($(":input.requiredObligee").length);
	$("#pendingRequiredobligee").text($(":input[value!=''].requiredObligee").length);
}
function onloadBonReqCount(){
	$("#totalRequiredBondRequestor").text($(":input.bcpReqCount").length);
	$("#pendingRequiredBondRequestor").text($(":input[value!=''].bcpReqCount").length);
}
function onloadMalingCount(){
	$("#totalRequiredMailing").text($(":input.requiredMailingAddress").length);
	$("#pendingRequiredMailing").text($(":input[value!=''].requiredMailingAddress").length);
}
function onloadBidBondCount(){
	$("#totalRequiredBidBond").text($(":input.requiredBidBond").length);
	$("#pendingRequiredBidBond").text($(":input[value!=''].requiredBidBond").length);
}
function onloadContractBondCount(){
	$("#totalRequiredContractBond").text($(":input.requiredContractBond").length);
	$("#pendingRequiredContractBond").text($(":input[value!=''].requiredContractBond").length);
}
function onloadLicenseBondCount(){
	$("#totalRequiredLicenseBond").text($(":input.requiredLicenseBond").length);
	$("#pendingRequiredLicenseBond").text($(":input[value!=''].requiredLicenseBond").length);
}
function onloadCourtBondCount(){
	$("#totalRequiredCourtBond").text($(":input.requiredCourtBond").length);
	$("#pendingRequiredCourtBond").text($(":input[value!=''].requiredCourtBond").length);
}
function onloadAttorneyBondCount(){
	$("#totalRequiredAttorney").text($(":input.requiredAttorney").length);
	$("#pendingRequiredAttorney").text($(":input[value!=''].requiredAttorney").length);
}
function onloadCustomBondCount(){
	$("#totalRequiredCustomBond").text($(":input.requiredCustomBond").length);
	$("#pendingRequiredCustomBond").text($(":input[value!=''].requiredCustomBond").length);
}


function bondInfoSection(){
	var selectedBond=$('#selectBond').val();
	//Bid Bond Information
	if(selectedBond!= undefined && selectedBond==1){
		onloadBidBondCount();		
	}
	
	//Contract Bond Information
	if(selectedBond!= undefined && selectedBond==2){
		onloadContractBondCount();		
	}
	
	//License/Permit Bond Information
	if(selectedBond!= undefined && selectedBond==3){
		onloadLicenseBondCount();		
	}
	
	//Court Bond Information & Attorney Information
	if(selectedBond!= undefined && selectedBond==4){
		onloadCourtBondCount();	
		onloadAttorneyBondCount();	
	}
	
	//Customs Bond Information
	if(selectedBond!= undefined && selectedBond==5){
		onloadCustomBondCount();		
	}
}
function radioChk(classname){
	var temp='';
	var count=0;
	 $(classname).each(function(){
		 var name = $(this).attr('name');
		 if(temp!=name){ ++count; }
		 temp=name;
	 });
	 return count;
}

function onChangeSite()
{
	$('body').off('change', '#selectedSiteId').on('change', '#selectedSiteId', function() {
		$("#totalRequiredBond").text($(":input.sbRequiredBondDet").length);
		$("#pendingRequiredBond").text($(":input[value !=''].sbRequiredBondDet").length);
	});
	
}

function onChangeBond(bondType)
{
	var bond = bondType;
	var bondchangeType = '';
		bondchangeType = $('#selectBond :selected').val();
		if(bondchangeType == 2 || bondchangeType == 3 || bondchangeType == 4){
			if(bondchangeType == bond){
				$("#totalRequiredBond").text($(":input.sbReqSubInclude").length);
				$("#pendingRequiredBond").text($(":input[value !=''].sbReqSubInclude").length +1);
				}
			else{
					$("#totalRequiredBond").text($(":input.sbReqSubInclude").length);	
					$("#pendingRequiredBond").text($(":input[value !=''].sbReqSubInclude").length);
				}
		}
		else{
			$("#totalRequiredBond").text($(":input.sbRequiredBondDet").length);
			$("#pendingRequiredBond").text($(":input[value !=''].sbRequiredBondDet").length);
		}	
}
		
function deliveryInstruc(){
	//var deliveryInstructionsForm = document.deliveryInstructions;
	$("#totalReqDelivery").text($(":input.requiredFieldDelivery").length+radioChk(':radio.requiredRadioDelivery'));
	$("#pendingReqDelivery").text($(':input:checked.requiredRadioDelivery').length+
			$(":input[value!=''].requiredFieldDelivery").length); 
}
function deliveryTypeTrueChk()
{
	$('#sbAddress1').removeClass("requiredFieldDelivery");
	$('#sbCity').removeClass("requiredFieldDelivery");
	$('#stateProvince2_widget').removeClass("requiredFieldDelivery");
	$('#zipPostalcode').removeClass("requiredFieldDelivery");
	$('#sbCountryCode_widget').removeClass("requiredFieldDelivery");
	deliveryInstruc();
}

function deliveryTypeFalseChk()
{
	$('#sbAddress1').addClass("requiredFieldDelivery");
	$('#sbCity').addClass("requiredFieldDelivery");
	$('#stateProvince2_widget').addClass("requiredFieldDelivery");
	$('#zipPostalcode').addClass("requiredFieldDelivery");
	$('#sbCountryCode_widget').addClass("requiredFieldDelivery");
	deliveryInstruc();
}

function malingUSCount(){
	$('#mailingstateOfIncCd_widget').addClass("requiredMailingAddress");
	onloadMalingCount();
	}
function malingNotUSCount(){
	$('#mailingstateOfIncCd_widget').removeClass("requiredMailingAddress");
	onloadMalingCount();
	}
function onLoadSubBondCount(){
	$("#totalRequiredBond").text($(":input.sbReqSubInclude").length);    
	$("#pendingRequiredBond").text($(":input[value !=''].sbReqSubInclude").length);
	}