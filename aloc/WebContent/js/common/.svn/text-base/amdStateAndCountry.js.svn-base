$(document).ready(function() {
	var amdsiteType = $('#siteTypeNameId').val();
	var triPartyRequestFlag = $('#triPartyRequestFlag').val();
	if(amdsiteType != undefined && amdsiteType == 'Financial Business'){
		if(triPartyRequestFlag != undefined && triPartyRequestFlag == 'true'){
			var amdtriPartyAddState =$("#triPartyAddressState").val();
			var amdtriPartyAddCountry =$("#triPartyAddressCountry").val();
			var amdtriPartyAddStateCd =$("#amdtriPartyAddStateCd").val();
			var amdtriPartyAddcountryCd =$("#amdtriPartyAddcountryCd").val();
			
			if((amdtriPartyAddStateCd == '' || amdtriPartyAddStateCd == undefined) && (amdtriPartyAddState !="" && amdtriPartyAddState != undefined)){
				$('#triPartyAddressState').closest('div.form-row').find('input.ui-widget').val(amdtriPartyAddState);
				addStateCountryCode('#triPartyAddressStateCd_widget option',amdtriPartyAddState,'#triPartyAddressStateCd');
			}
			if((amdtriPartyAddcountryCd == '' || amdtriPartyAddcountryCd == undefined) && (amdtriPartyAddCountry !="" && amdtriPartyAddCountry != undefined)){
				$('#triPartyAddressCountry').closest('div.form-row').find('input.ui-widget').val(amdtriPartyAddCountry);
				addStateCountryCode('#triPartyAddressCountryCd_widget option',amdtriPartyAddCountry,'#triPartyAddressCountryCd');
			}
		}
		
	}
	var amdCustomerAddState =$("#customerAddressState").val();
	var amdCustomerAddCountry =$("#customerAddressCountry").val();
	var amdCustomerAddStateCd =$('#amdCustomerAddStateCd').val();
	var amdCustomerAddCountryCd =$('#amdCustomerAddCountryCd').val();
	if((amdCustomerAddStateCd == '' || amdCustomerAddStateCd == undefined) && (amdCustomerAddState !="" && amdCustomerAddState != undefined)){
		$('#customerAddressState').closest('div.form-row').find('input.ui-widget').val(amdCustomerAddState);
		addStateCountryCode('#customerAddressStateCd_widget option',amdCustomerAddState,'#customerAddressStateCd');
	}
	if((amdCustomerAddCountryCd == '' || amdCustomerAddCountryCd == undefined) && (amdCustomerAddCountry !="" && amdCustomerAddCountry != undefined)){
		$('#customerAddressCountry').closest('div.form-row').find('input.ui-widget').val(amdCustomerAddCountry);
		addStateCountryCode('#customerAddressCountryCd_widget option',amdCustomerAddCountry,'#customerAddressCountryCd');
	}
	var amdapplicantAddState =$("#applicantAddressState").val();
	var amdapplicantAddCountry =$("#applicantAddressCountry").val();
	var amdApplicantAddStateCd =$('#amdApplicantAddStateCd').val();
	var amdApplicantAddCountryCd =$('#amdApplicantAddCountryCd').val();
	if((amdApplicantAddStateCd == '' || amdApplicantAddStateCd == undefined) && (amdapplicantAddState !="" && amdapplicantAddState != undefined)){
		$('#applicantAddressState').closest('div.form-row').find("input.ui-widget").val(amdapplicantAddState);
		addStateCountryCode('#applicantAddressStateCd_widget option',amdapplicantAddState,'#applicantAddressStateCd');
	}
	if((amdApplicantAddCountryCd == '' || amdApplicantAddCountryCd == undefined) && (amdapplicantAddCountry !="" && amdapplicantAddCountry != undefined)){
		$('#applicantAddressCountry').closest('div.form-row').find("input.ui-widget").val(amdapplicantAddCountry);
		addStateCountryCode('#applicantAddressCountryCd_widget option',amdapplicantAddCountry,'#applicantAddressCountryCd');
	}
	
	
});

function addStateCountryCode(widget, country, targetId) {
	$(widget).each(function(){
		var text = $(this).text();
		if(text == country){
			$(targetId).val($(this).val());
		}
	});
}