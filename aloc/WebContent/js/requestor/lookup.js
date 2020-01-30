$(document).ready(function() {
	
	/*
	 * Pagination for Lookup Start Here
	 */
	var buildNavigation, gotoPage ;
    var showPerPage = 20;
    var totalRows = gettableRow().length;
    var numberOfPages = Math.ceil(totalRows / showPerPage);
    
    if(totalRows <=10){
    	$('div#searchSort').children('.rightColSort').hide();
    	$('div#hideLessthan10').find(".span").hide();
	}
    
    $("#current_page").val(1);
    function paginationSize(){
    	return parseInt($("select.pagination-rows").val());
    }

    $("select.pagination-rows").change(function(){
    	var v = parseInt($("#current_page").val()); 
        showPerPage=paginationSize();
        numberOfPages = Math.ceil(totalRows / showPerPage);
        if(totalRows <= showPerPage){
        	return gotoPage(1);
        }else{
        	if(numberOfPages < v){
        		return gotoPage(numberOfPages);
        	}else{
        		return gotoPage(v);
        	}
        }
    });
    function gettableRow(){
    	var table = $("table.paginate");
    	 if($(table).length > 1)
             table = $(table).filter(".active");  
         return $(table).find("tbody tr.shown");
    }
    buildNavigation = function(currentPage) {
        var dummy, item, middle, next, pageNo, previous;     
        pageNo = 1;
        totalRows = gettableRow().length;
        numberOfPages = Math.ceil(totalRows / showPerPage);
        middle = Math.ceil(numberOfPages / 2);
        previous = $('<a class="page larger" href="#">&#60;prev</a>');
        next = $('<a class="page larger" href="#">next&#62;</a>');
        $('.pagenavi').empty();
        $('.pagenavi ').append(previous);
        while (numberOfPages >= pageNo) {
          item = $('<a class="page larger" href="#">' + pageNo + '</a>');
          if (numberOfPages <= 9 || (pageNo === 1 || pageNo === 2 || pageNo === (numberOfPages - 1) || pageNo === numberOfPages)) {
            $('.pagenavi').append(item);
          } else if (currentPage === 2 && (pageNo === 3 || pageNo === 4 || pageNo === 5)) {
            $('.pagenavi').append(item);
          } else if (currentPage === numberOfPages - 1 && (pageNo === (numberOfPages - 4) || pageNo === (numberOfPages - 3) || pageNo === (numberOfPages - 2))) {
            $('.pagenavi').append(item);
          } else if ((pageNo === (middle - 1) || pageNo === middle || pageNo === (middle + 1)) && (currentPage === 1 || currentPage === numberOfPages)) {
            $('.pagenavi').append(item);
          } else if (currentPage === (pageNo - 1) || currentPage === pageNo || currentPage === (pageNo + 1)) {
            $('.pagenavi').append(item);
          } else {
            if ($('.pagenavi a:last-child').html() !== '----') {
              dummy = $('<a class="page larger" href="#">----</a>');
              $('.pagenavi').append(dummy);
            }
          }
          $(item).click(function() {
            return gotoPage(parseInt($(this).html()));
          });
          pageNo++;
        }
        $('.pagenavi').append(next);
        if (numberOfPages < 2) {
          $(next).addClass('disabled');
        }
      };
      
      gotoPage = function(page) {
          var el, end, start;
          el = gettableRow();     
          start = (page - 1) * showPerPage;
          end = start + showPerPage;      
          $(el).hide();
          $(el).slice(start, end).show();
          buildNavigation(page);
         
		  $("#itemsPerPage,#itemsPerPage1").find("span#start").text(start+1);
	      if(end > totalRows){
	    	  end = totalRows;
	      }
	      $("#itemsPerPage,#itemsPerPage1").find("span#end").text(end);
	      $("#itemsPerPage,#itemsPerPage1").find("span#total").text(totalRows);
          
          $('.pagenavi a').each(function() {
            if ($(this).html() === page.toString()) {
              return $(this).replaceWith('<span class="current">'+page+'</span>');
            }
          });
          $("#current_page").val(page);
          switch (page) {
            case 1:
              $(".pagenavi a:first-child").addClass('disabled');
              $(".pagenavi a:last-child").removeClass('disabled');
              break;
            case numberOfPages:
              $(".pagenavi a:last-child").addClass('disabled');
              $(".pagenavi a:first-child").removeClass('disabled');
              break;
            default:
              $(".pagenavi a:first-child").removeClass('disabled');
              $(".pagenavi a:last-child").removeClass('disabled');
          }
        };

        window.gotoPage = gotoPage(1);
        
        $('.pagenavi').off('click.pagination', 'a:first-child');
        $('.pagenavi').on('click.pagination', 'a:first-child', function() {
            if(!$(this).hasClass('disabled')){
          	  var i;
                i = parseInt($("#current_page").val());
                if (i !== 1) {
                  return gotoPage(i - 1);
                }
            }
          });
        
        $('.pagenavi').off('click.pagination', 'a:last-child');
        $('.pagenavi').on('click.pagination', 'a:last-child', function() {
        	if(!$(this).hasClass('disabled')){
    	    	var i;
    	      i = parseInt($("#current_page").val());
    	      if (i !== numberOfPages) {
    	        return gotoPage(i + 1);
    	      }
        	}
        });
        buildNavigation(1);
        $(".pagenavi a:first-child").addClass('disabled');
        $('.pagenavi a:nth-child(2)').replaceWith('<span class="current">1</span>');
        $(".table.active tbody tr").hide();
        $(".table.active tbody tr").slice(0, showPerPage).show();
        
        $(".jump-page").find('.btn-success-blue').click(function() {
        	var val = 0;
            if ($(this).siblings('.manual').val()) {
              val = parseInt($(this).siblings('.manual').val());
            }
            if (val >= 1 && val <= numberOfPages) {
              return gotoPage(val);
            }
          });
          $(".jump-page").find('.manual').keyup(function(e) {
            if (e.which === 13) {
              return $(".jump-page").find('.btn-success-blue').click();
            }
          });
     /*
     * Pagination for Lookup Ends Here
     */

     if (window.PIE) {
    	 $('.btn').each(function() {
    		 PIE.attach(this);
    	 });
     }
     
     $.subscribe('getAutocompleterName', function(event,data) {
    	var ui = event.originalEvent.ui;
 		var codeTextField = data.previousSibling.previousSibling.id;
 		var textField = data.parentElement.lastChild.previousSibling.id;
 		var text;
 		if(ui.item != undefined && ui.item != null){
 			text = ui.item.value;
 		}else{
 			text = '';
 			$('#'+codeTextField).val($.trim(text));
 		}
 		
 		$('#'+textField).val($.trim(text));
 		event.stopPropagation();
     });
     
     $('a.lookup').off('click').on('click',function(e){
    	e.preventDefault();
    	e.stopImmediatePropagation();
    	var scrollTopValue = $(this).closest(".row").offset().top;
  		var url = $(this).attr('href');
  		var lookupError = $(this).siblings(".lookup-error");
  		if(lookupError == undefined || $(this).siblings(".lookup-error").length == 0){
  			lookupError = $(this).closest('div.row').find(".lookup-error");
  		}
  		$(lookupError).empty().addClass("hide").removeClass("show");
  		var dataValue = $(this).siblings(".lookup-filterValue").val();
  		var bankCountryCd  = $(this).siblings(".bankCountryCode").val();
  		var bankCountryName = '';
  		var bankCity  = $(this).siblings(".bankCityName").val();
  		var userDataLookup = $(e.target).siblings('.businessContactClass').val();
  		var userReportLookup = $(e.target).siblings('.userReportClass').val();
  		var nameAddressLookupValue = $(e.target).siblings(".nameAddressClass").val();
  		var bucFirstName = '';
  		var bucLastName = '';

  		if(dataValue == undefined && $(this).siblings(".lookup-filterValue").length == 0){
  			dataValue = $(this).closest('.form-row').find('.lookup-filterValue').val();
  			lookupField = $(this).closest('.form-row').find('.lookup-filterValue');
  			userDataLookup = $(e.target).closest('.form-row').find('.businessContactClass').val();
  			userReportLookup = $(e.target).closest('.form-row').find('.userReportClass').val();
  			nameAddressLookupValue= $(e.target).closest('.form-row').find('.nameAddressClass').val();
  		}
  		if(bankCountryCd == undefined && $(this).siblings(".bankCountryCode").length == 0){
  			bankCountryCd = $(this).closest('.form-row').find('.bankCountryCode').val();
  			bankCountryName = $(this).closest('.form-row').find('#bankCountryNameId').val();
  			bankCountryCodeField = $(this).closest('.form-row').find('.bankCountryCode');
  			bankCountryNameField = $(this).closest('.form-row').find('#bankCountryNameId');
  		}
  		if(bankCountryCd == undefined && $(this).closest('.form-row').find('.bankCountryCode').length == 0){
  			bankCountryCd = $(this).closest('.form-row').find('.bankDetailCountryCode').val();
  			bankCountryName = $(this).closest('.form-row').find('#bankDetailCountryNameId').val();
  		}
  		if(bankCity == undefined && $(this).siblings(".bankCityName").length == 0){
  			bankCity = $(this).closest('.form-row').find('.bankCityName').val();
  			bankCityField = $(this).closest('.form-row').find('.bankCityName');
  		}
  		if($.trim(dataValue) != '' && (bankCountryCd != '' ||  (bankCountryName != '' && bankCountryName!= undefined ))&& ($.trim(bankCity) != '' || bankCity == undefined)){
  			if(userReportLookup != undefined && userReportLookup != '' && userReportLookup == 'userReportType'){
  				if (dataValue.indexOf(',') > -1) {
	  				$(this).parents('div.row').find(".lookup-error").text("Please enter valid SSO/User name").removeClass("hide").addClass("show");
	  				return false;		  			
	  			}
  			}
  			if(userDataLookup != undefined && userDataLookup != '' && userDataLookup == 'BUC') {
  				if(dataValue.indexOf(",") == -1)	{
  					if(dataValue.length < 7 )	{
  						$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  			  			return false;
  					}}
  				else {
  					var dataValueArray = dataValue.split(",");
  					if(dataValueArray.length == 2)	{
  						var nameLengthCheck = false;
  						$.each(dataValueArray, function(index, name) {
  							var nameTrim = $.trim(name);
  							if(nameTrim == '' || (nameTrim != '' && nameTrim.length < 2))	{
  								nameLengthCheck = true;
  							}
  						});
  						if(nameLengthCheck == true) {
  							$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  							return false;
  						}else {
  							bucLastName = dataValueArray[0];
  							bucFirstName = dataValueArray[1];
  						}}else {
  	  						$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  		  			  		return false;
  	  					}}}
  			if(nameAddressLookupValue != undefined && nameAddressLookupValue != '' && nameAddressLookupValue == 'yes'){
  				if($.trim(dataValue).length < 5){
  					$(lookupError).text("Please enter at least 5 characters for Lookup Search").removeClass("hide").addClass("show");
	  			  		return false;
  				}
  			}
  			var indicator = $(this).siblings(".indicator");
  			if(indicator == undefined || $(this).siblings(".indicator").length == 0){
  				indicator = $(this).closest('div.row').find(".indicator");
  			}
  			$(indicator).show();
  			$.ajax({
  				type: "POST",
  				url: url,
  				dataType: 'html',
  				data: {filterValue : $.trim(dataValue), bankCountryCd : bankCountryCd, bankCountry : bankCountryName, bankCity : $.trim(bankCity), scrollTopValue:scrollTopValue,
  					   bucFirstName : bucFirstName, bucLastName : bucLastName},
  				success: function(response){
  					$('#lookupDiv').empty().append(response);
  					$(indicator).hide();
  				},
  				complete : function(jqXHR, status){
  					if(status == "success"){
  						$('#mainPage').hide();
  						$('#lookupDiv').show();
  						$(window).scrollTop(0);
  					}else{
  						$(indicator).hide();
  					}
  				},error: function (xhr, textStatus, errorThrown ) {
  					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
  					$(lookupError).text(errorReason).removeClass("hide").addClass("show");
  		  			return false;
  				}
  			});
  		}else{
	  			$(lookupError).text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
	  			return false;
  		      }
  		return false;
     });
     $('a.bankAdvanceSearchBtn').off('click').on('click',function(e){
    	 e.preventDefault();
    	 var url = $(this).attr('href');
    	 var indicator = $(this).siblings(".indicator");
    	 $(indicator).show();
    	 $.ajax({
	           type: "POST",
	           url: url,
	           dataType: 'html',
	           data: $("#bankAdvanceSearchForm").serialize(), // serializes the form's elements.
	           success: function(response)
	           {
	        	   $('#lookupDiv').empty().append(response);
	        	   $(indicator).hide();
	           },
  				complete : function(jqXHR, status){
  					if(status == "success"){
  						$('#mainPage').hide();
  						$('#lookupDiv').show();
  						$(window).scrollTop(0);
  					}else{
  						$(indicator).hide();
  					}
  				}
    	 });
    	 return false;
     });
     /*- Previous Next LE Pagination -*/
     $('#pageDivID').delegate('a','click',function(event) {
    	 event.preventDefault();
    	 var url = $(this).attr('href');
    	 var indicator = $(this).siblings(".indicator");
    	 $(indicator).show();
    	 $.ajax({
    		 type: "POST",
    		 url: url,
    		 dataType: 'html',
    		 success: function(response){
    			 $(indicator).hide();
    			 $('#lookupDiv').empty().append(response);
    		 },
    		 complete : function(jqXHR, status){
				if(status == "success"){
					$('#mainPage').hide();
					$('#lookupDiv').show();
					$(window).scrollTop(0);
				}else{
					$(indicator).hide();
				}
			}
    	 });
     });
     /*- Previous Next Bank Pagination -*/
     $('#bankPageDivID').delegate('a','click',function(event) {
    	 event.preventDefault();
    	 var url = $(this).attr('href');
    	 var id = $(this).attr('id');
    	 var indicator = $(this).siblings(".indicator");
    	 $(indicator).show();
    	 if(id == 'previousIDSearch' || id == 'nextIDSearch'){
    		 $.ajax({
    			 type: "POST",
        		 url: url,
        		 dataType: 'html',
        		 data: $("#bankAdvanceSearchForm").serialize(),
        		 success: function(response){
        			 $(indicator).hide();
        			 $('#lookupDiv').empty().append(response);
        		 },
        		 complete : function(jqXHR, status){
     				if(status == "success"){
     					$('#mainPage').hide();
     					$('#lookupDiv').show();
     					$(window).scrollTop(0);
     				}else{
     					$(indicator).hide();
     				}
     			}
        	 });
    	 }else{
    		 $.ajax({
    			 type: "POST",
        		 url: url,
        		 dataType: 'html',
        		 success: function(response){
        			 $(indicator).hide();
        			 $('#lookupDiv').empty().append(response);
        		 },
        		 complete : function(jqXHR, status){
     				if(status == "success"){
     					$('#mainPage').hide();
     					$('#lookupDiv').show();
     					$(window).scrollTop(0);
     				}else{
     					$(indicator).hide();
     				}
     			}
        	 });
    	 }
     });
     /*-- Clear Results--*/
     $('.clear-conditional-results').off('click').on('click', function() {
		$(this).closest('.row').next('.active').hide();
		$(this).hide();
     });
     
     $("#advSear").click(function(){
    	 if($(this).parent('p').siblings('div#arrow').hasClass('down')){
    		 $(this).parent('p').siblings('div#arrow').removeClass('down').addClass('up');
    		 $("#advSearShow").show("fast");
    	 }else if($(this).parent('p').siblings('div#arrow').hasClass('up')){
    		 $(this).parent('p').siblings('div#arrow').removeClass('up').addClass('down');
    		 $("#advSearShow").hide("fast");
    	 }
     });
     
     $('table.lookupTableRes tr:odd').addClass("odd");
     
     /*-- To remove Site Delegation Table colors --*/
     $('#delegationConfigurations tbody tr').removeClass("odd");
     
     $('.selectGoldId').click(function(e){
		e.preventDefault();
		var id = $(this).attr('id');
		var siteLEType = $('#siteLEType').val();
		var ecsoReport = parseInt($('#ecsoReportId').val());
		var scrollTopValue = $("#scrollTopValueId").val();
		var goldId = $('#'+id).parent().next().text();
		
		var name = $('#'+id).parent().next().next().text();
		var mdmId = $('#'+id).parent().next().next().next().text();
		
		var add1=$('#'+id).parent().next().next().next().next().next().text();
		var add2=$('#'+id).parent().next().next().next().next().next().next().text();
		var city=$('#'+id).parent().next().next().next().next().next().next().next().next().text();
		var state=$('#'+id).parent().next().next().next().next().next().next().next().next().next().text();
		var zip=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().text();
		var country=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().next().text();
		var stateCode=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().next().next().text();
		var countryCode=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().next().next().next().text();
		if(siteLEType!=undefined && siteLEType == "Copy"){
			$('#tpApplicantLEGoldIDCopy').val(goldId);
			$('#tpApplicantLEGoldIDCopy').closest('.form-row').find('p').text(goldId);
			$('#tpApplicantLENameCopy').val(name);
			$('#tpApplicantLENameCopy').closest('.form-row').find('p').text(name);
			$('#leMDMIdCopy').val(mdmId);
			
			$('#goldidShowCopy').show('fast');
			$('#goldidClearCopy').show('fast');
		}else if(ecsoReport!=undefined && ecsoReport >= 0){
			$('#tpApplicantLEGoldID'+ecsoReport).val(goldId);
			$('#tpApplicantLEGoldID'+ecsoReport).closest('.form-row').find('p').text(goldId);
			$('#tpApplicantLEName'+ecsoReport).val(name);
			$('#tpApplicantLEName'+ecsoReport).closest('.form-row').find('p').text(name);
			var goldidShow = "goldidShow"+ecsoReport;
			$('#'+goldidShow).show('fast');
			$('#'+goldidShow).find('.span7').addClass("greenDiv");
			setLookupTimeout(goldidShow);
		}	
		else{
			$('#tpApplicantLEGoldID').val(goldId);
			$('#tpApplicantLEGoldID').closest('.form-row').find('p').text(goldId);
			$('#tpApplicantLEGoldID').change();
			$('#tpApplicantLEName').val(name);
			$('#tpApplicantLEName').closest('.form-row').find('p').text(name);
			$('#leMDMId').val(mdmId);
			
			$('#principleInfoFlag').attr('checked', false);
			$('#lename').val(name);
			$('#Address1').val(add1);
			$('#Address2').val(add2);
			$('#AddressCity').val(city);
			$('#AddressState').val(state);
			$('#AddressZip').val(zip);
			$('#AddressCountry').val(country);
			$('#stateCode').val(stateCode);
			$('#countryCode').val(countryCode);
			
			$('#goldIdSelectionId').val("Yes");
			$('#principalGoldIdSelectionID').val("Yes");
			$('#beneficiaryGoldIdSelectionID').val("Yes");			

			$('#businessContactName').val("Yes");
			$('#goldidShow').show('fast');
			$('#goldidShow').find('.span7').addClass("greenDiv");
			$('#goldidShow').fadeIn('fast');
			$('#goldidClear').show('fast');
			setLookupTimeout("goldidShow");
			$.publish('/fieldCounter/fieldsModified','#tpApplicantLEGoldID');
		}
		
		returnToMainPage();
		$('#lookupDiv').empty();
		$(window).scrollTop(scrollTopValue-50);
	});
	
	$('.selectBCP').click(function(e){
		e.preventDefault();
		var id = $(this).attr('id');
		var scrollTopValue = $("#scrollTopValueId").val();
		var name = $('#'+id).parent().next().text();
		var fName = $.trim(name.split(",")[1]);
		var lName = $.trim(name.split(",")[0]);
		var ssoId = $('#'+id).parent().next().next().next().text();
		
		var requestorType= $('#requestorTypeId').val();
		if(requestorType!=undefined && requestorType == 'currentRequestor')	{
			$(".pendingRequired1").text(parseInt($(".pendingRequired1").text())+1);
			$('#tpApplicantBCPLName').val(lName);
			$('#tpApplicantBCPSSO').val(ssoId);
			$('#tpApplicantBCPLName').closest('.form-row').find('p').text(name);
			$('#tpApplicantBCPSSO').closest('.form-row').find('p').text(ssoId);
			$.publish('/fieldCounter/fieldsModified','#tpApplicantBCPSSO');
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessShow').find('.span7').addClass("greenDiv");
			$('#BusinessShow').fadeIn('fast');
			setLookupTimeout("BusinessShow");
			$(window).scrollTop(scrollTopValue);
		}else if(requestorType!=undefined && requestorType == 'currentContact')	{
			$(".pendingRequired1").text(parseInt($(".pendingRequired1").text())+1);
			$('#contactBCPLName').val(lName);
			$('#contactBCPSSO').val(ssoId);
			$('#contactBCPLName').closest('.form-row').find('p').text(name);
			$('#contactBCPSSO').closest('.form-row').find('p').text(ssoId);
			$.publish('/fieldCounter/fieldsModified','#contactBCPSSO');
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessContactShow1').find('.span7').addClass("greenDiv");
			$('#BusinessContactShow1').fadeIn('fast');
			setLookupTimeout("BusinessContactShow1");
			$(window).scrollTop(scrollTopValue);
		}
		else {
			$(".pendingRequired1").text(parseInt($(".pendingRequired1").text())+1);
			$('#tpApplicantBCPLName').val(lName);
			$('#tpApplicantBCPFName').val(fName);
			$('#tpApplicantBCPSSO').val(ssoId);
			$('#tpApplicantBCPLName').closest('.form-row').find('p').text(name);
			$('#tpApplicantBCPSSO').closest('.form-row').find('p').text(ssoId);
			$('#personNameSelectionId').val("Yes");
			$.publish('/fieldCounter/fieldsModified','#tpApplicantBCPSSO');
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessShow').find('.span7').addClass("greenDiv");
			$('#BusinessShow').fadeIn('fast');
			$('#BusinessClear').fadeIn('fast');
			setLookupTimeout("BusinessShow");
			$(window).scrollTop(scrollTopValue);
		}
	});
	
	$('.selectRequestorLookup').click(function(e){
		e.preventDefault();
		var id = $(this).attr('id');
		var scrollTopValue = $("#scrollTopValueId").val();
		var name = $('#'+id).parent().next().text();
		var fName = $.trim(name.split(",")[1]);
		var lName = $.trim(name.split(",")[0]);
		var ssoId = $('#'+id).parent().next().next().next().text();
		
		
		var requestorType= $('#requestorTypeId').val();
		
		if(requestorType == 'currentRequestor')
		{
			$('#currentRequestorLName').val(lName);
			$('#currentRequestorFName').val(fName);
			$('#currentRequestorSSO').val(ssoId);
			$('#currentRequestorLName').closest('.form-row').find('p').text(name);
			$('#currentRequestorSSO').closest('.form-row').find('p').text(ssoId);
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessShow').find('.span7').addClass("greenDiv");
			$('#BusinessShow').fadeIn('fast');
			$('#BusinessClear').fadeIn('fast');
			setLookupTimeout("BusinessShow");
			$(window).scrollTop(scrollTopValue);
		}
		else
		{
			$('#newRequestorLName').val(lName);
			$('#newRequestorFName').val(fName);
			$('#newRequestorSSO').val(ssoId);
			$('#newRequestorLName').closest('.form-row').find('p').text(name);
			$('#newRequestorSSO').closest('.form-row').find('p').text(ssoId);
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessShow1').find('.span7').addClass("greenDiv");
			$('#BusinessShow1').fadeIn('fast');
			$('#BusinessClear1').fadeIn('fast');
			setLookupTimeout("BusinessShow1");
			$(window).scrollTop(scrollTopValue);
		}
			$('#personNameSelectionId').val("Yes");
	});
	
	$('.selectDocBCP').click(function(e){
		e.preventDefault();
		var id = $(this).attr('id');
		var scrollTopValue = $("#scrollTopValueId").val();
		var name = $('#'+id).parent().next().text();
		var email = $('#'+id).parent().next().next().text();
		var ssoId = $('#'+id).parent().next().next().next().text();
		var phone = $('#'+id).parent().next().next().next().next().text();
		var fax = $('#'+id).parent().next().next().next().next().next().text();
		var lookUpNoID = $("#lookUpNoID").val();
		if(lookUpNoID=="1"){
			$('#tpApplicantBCPSSO').val(ssoId);
			$('#bcpName').val(name);
			$('#bondReqName').val(name);
			$('#emailAddr').val(email);
			$('#phoneNumber').val(phone);
			$('#faxNumber').val(fax);
			$('#BondRequestorShow').find('.highlighted').find('.form-row');
			$('#BondRequestorShow').fadeIn('fast');
			$('#bondReqPhoneNumber').val(phone);
			makeMandatory('#bondReqPhoneNumber,#bondReqName,#emailAddr');
			$.publish('/fieldCounter/fieldsModified', '#bondReqName');
			returnToMainPage();
			$('#lookupDiv').empty();
			$.publish('/fieldCounter/fieldsModified','#tpApplicantBCPSSO');
			$('#BusinessClear').show('fast');
			$('#BondReqNameSelectionID').val("Selected");
			$('#bcpName').closest('.form-row').find('p').text(name+" - SSO "+ssoId);
			$('#emailAddr').closest('.form-row').find('p').text(email);
			$('#phoneNumber').closest('.form-row').find('p').text(phone);
			$('#businessShow').show('fast');
			$('#businessShow').find('.span7').addClass("greenDiv");
			$('#businessShow').fadeIn('fast');
			$('#BusinessClear').show('fast');
			$('#businessSelectionId').val("Yes");
			setLookupTimeout("businessShow");
		}
		if(lookUpNoID=="2"){
			$('#tpApplicantBCPSSO1').val(ssoId);
			$('#bcpName1').val(name);
			$('#emailAddr1').val(email);
			$('#phoneNumber1').val(phone);
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessClear1').show('fast');
			$('#bcpName1').closest('.form-row').find('p').text(name+" - SSO "+ssoId);
			$('#emailAddr1').closest('.form-row').find('p').text(email);
			$('#phoneNumber1').closest('.form-row').find('p').text(phone);
			$('#businessShow1').show('fast');
			$('#businessShow1').find('.span7').addClass("greenDiv");
			$('#businessShow1').fadeIn('fast');
			$('#BusinessClear1').show('fast');
			setLookupTimeout("businessShow1");
		}
		if(lookUpNoID=="3"){
			$('#tpApplicantBCPSSO2').val(ssoId);
			$('#bcpName2').val(name);
			$('#emailAddr2').val(email);
			$('#phoneNumber2').val(phone);
			returnToMainPage();
			$('#lookupDiv').empty();
			$('#BusinessClear2').show('fast');
			$('#bcpName2').closest('.form-row').find('p').text(name+" - SSO "+ssoId);
			$('#emailAddr2').closest('.form-row').find('p').text(email);
			$('#phoneNumber2').closest('.form-row').find('p').text(phone);
			$('#businessShow2').show('fast');
			$('#businessShow2').find('.span7').addClass("greenDiv");
			$('#businessShow2').fadeIn('fast');
			$('#BusinessClear2').show('fast');
			setLookupTimeout("businessShow2");
		}
		$(window).scrollTop(scrollTopValue);
	});
	
	$('.bank').click(function(e) {
		e.preventDefault();$('#bankId0').parents('tr.shown').children('td:nth-child(3)').text();
		var id = $(this).attr('id');
		var tableRow = $('#'+id).parents('tr.shown');
		var bName = $(tableRow).children('td:nth-child(2)').text();
		var country = $(tableRow).children('td:nth-child(3)').text();
		var city = $(tableRow).children('td:nth-child(4)').text();
		var addr = $(tableRow).children('td:nth-child(5)').html();
		var bicCode = $(tableRow).children('td:nth-child(6)').text();
				
		var add1 = $(tableRow).children('td:nth-child(7)').text();
		var add2 = $(tableRow).children('td:nth-child(8)').text();
		var state = $(tableRow).children('td:nth-child(9)').text();
		var zip = $(tableRow).children('td:nth-child(10)').text();
		
		var mdmId = $(tableRow).children('td:nth-child(11)').text();
		
		var bankDetails = bName + "<br />" + addr+city+" "+state+" "+zip+"<br />"+country;
		var scrollTopValue = $("#scrollTopValueId").val();
		
		$('#bankDetails').find('.firstrow').find('.form-row').html(bankDetails);
		$('#bankDetails').find('.lastrow').find('.span4').find('p').text(bicCode);
		
		returnToMainPage();
		$('#lookupDiv').empty();
		$('#bankDetails').fadeIn('fast');
		$('#bankDetailsClear').fadeIn('fast');
		$('#bankBICOverride').show();		
		$('#bankName').val(bName);
		$('#bankAddress1').val(add1);
		$('#bankAddress2').val(add2);
		$('#bankAddressCity').val(city);
		$('#bankAddressState').val(state);
		$('#bankAddressZip').val(zip);
		$('#bankAddressCountry').val(country);
		$('#bankBicCode').val(bicCode);
		$('#bMDMId').val(mdmId);
		$('#bankSelectionId').val("Selected");
		$('#issuingBankSelectionId').val("Selected");
		$('#BankDetailsShowManually').fadeOut('fast');
		$('#bankDetails').find('.span7').addClass("greenDiv");
		//$('#issuingBankNameId').val(bName);
		$('#bankDetails').show('fast');
		$.publish('/fieldCounter/fieldsModified', '#bankName');
		setLookupTimeout("bankDetails");
		$(window).scrollTop(scrollTopValue);
	});
	$('.selectRecipient').click(function(e) {
		e.preventDefault();
		var id = $(this).attr('id');
		var recipientName = $('#'+id).parent().next().text();
		var fname= recipientName.split(",")[1];
		var lname= recipientName.split(",")[0];
		var ssoId = $('#'+id).parent().next().next().text();
		var email = $('#'+id).parent().next().next().next().text();
		var recipient = recipientName + " - "+ssoId;
		var scrollTopValue = $("#scrollTopValueId").val();
		$('#recipientShow').find('p').text(recipient);
		$('#recipientEmail').closest('.form-row').find('p').text(email);		
		$('#recipientLastName').val(lname);
		$('#recipientFirstName').val(fname);
		$('#recipientSsoId').val(ssoId);
		$('#recipientEmail').val(email);
		$('#recipientSelectionId').val("Selected");
		$('#recipientShow').fadeIn('fast');
		$('#recipientClear').fadeIn('fast');
		returnToMainPage();
		$('#lookupDiv').empty();
		$('#recipientShow').find('.span7').addClass("greenDiv");
		$('#recipientShow').fadeIn('fast');
		setLookupTimeout("recipientShow");
		$.publish('/fieldCounter/fieldsModified','#recipientSsoId');
		$(window).scrollTop(scrollTopValue);
	});
	$('.selectNameAddress').click(function(e){
		e.preventDefault();
		var id = $(this).attr('id');
		var addressType = id.split("_");
		var name = $('#'+id).parent().next().text();
		var address = $('#'+id).parent().next().next().html();
		var add1=$('#'+id).parent().next().next().next().text();
		var add2=$('#'+id).parent().next().next().next().next().text();
		var city=$('#'+id).parent().next().next().next().next().next().next().text();
		var state=$('#'+id).parent().next().next().next().next().next().next().next().text();
		var stateCd=$('#'+id).parent().next().next().next().next().next().next().next().next().text();
		var zip=$('#'+id).parent().next().next().next().next().next().next().next().next().next().text();
		var country=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().text();
		var countryCd=$('#'+id).parent().next().next().next().next().next().next().next().next().next().next().next().text();
		var scrollTopValue = $("#scrollTopValueId").val();
		if(addressType[0] == 'Applicant'){
			$('#ApplicantShow').find('#applicantName').find('p').text(name);
			$('#ApplicantShow').find('#applicantAddress').html(address);
			$('#ApplicantShow').find('.span7').addClass("greenDiv");
			$('#ApplicantShow').fadeIn('fast');
			$('#ApplicantClear').fadeIn('fast');
			$('#ApplicantShowManually').fadeOut('fast');
			$('#tpApplicantAddressSelectionId').val("Selected");
			$('#applicantSelectionId').val("Selected");	
			addAddressToApplicant(name,add1,add2,city,state,zip,country);
			setLookupTimeout("ApplicantShow");
		}else if(addressType[0] == 'Customer'){
			$('#CustomerBeneficiaryShow').find('#customerBeneficiaryName').find('p').text(name);
			$('#CustomerBeneficiaryShow').find('#customerBeneficiaryAddress').html(address);
			$('#CustomerBeneficiaryShow').find('.span7').addClass("greenDiv");
			$('#CustomerBeneficiaryShow').fadeIn('fast');
			$('#CustomerBeneficiaryClear').fadeIn('fast');
			$('#CustomerBeneficiaryShowManually').fadeOut('fast');
			$('#tpCustomerAddressSelectionId').val("Selected");
			addAddressToCustomer(name,add1,add2,city,state,zip,country);
			setLookupTimeout("CustomerBeneficiaryShow");
		}else if(addressType[0] == 'Tri-PartyApplicant'){
			$('#TriPartyShow').find('#tripartyName').find('p').text(name);
			$('#TriPartyShow').find('#tripartyAddress').html(address);
			$('#TriPartyShow').find('.span7').addClass("greenDiv");
			$('#TriPartyShow').fadeIn('fast');
			$('#TriPartyClear').fadeIn('fast');
			$('#TriPartyShowManually').fadeOut('fast');
			$('#triPartyAddressSelectionId').val("Selected");
			addAddressToTriParty(name,add1,add2,city,state,zip,country);
			setLookupTimeout("TriPartyShow");
		}else if(addressType[0] == 'Beneficiary'){
			$('#BeneficiaryShow').find('#beneficiaryName').find('p').text(name);
			$('#BeneficiaryShow').find('#beneficiaryAddress').html(address);
			$('#BeneficiaryShow').find('.span7').addClass("greenDiv");
			$('#BeneficiaryShow').fadeIn('fast');
			$('#BeneficiaryClear').fadeIn('fast');
			$('#BeneficiaryShowManually').fadeOut('fast');
			$('#beneficiaryAddressSelectionID').val("Selected");
			addAddressToBeneficiary(name,add1,add2,city,state,zip,country);
			setLookupTimeout("BeneficiaryShow");
		}else if(addressType[0] == 'Principal'){
			$('#PrincipalShow').find('#principalName').find('p').text(name);
			$('#PrincipalShow').find('#principalAddress').html(address);
			$('#PrincipalShow').find('.span7').addClass("greenDiv");
			$('#PrincipalShow').fadeIn('fast');
			$('#PrincipalShow').fadeIn('fast');
			$('#PrincipalClear').fadeIn('fast');
			$('#PrincipalShowManually').fadeOut('fast');
			$('#principlaAddressSelectionId').val("Selected");
			addAddressToPrincipal(name,add1,add2,city,state,stateCd,zip,country,countryCd);
			setLookupTimeout("PrincipalShow");
		}else if(addressType[0] == 'Obligee'){
			$('#ObligeeShow').find('#obligeeName').find('p').text(name);
			$('#ObligeeShow').find('#obligeeAddress').html(address);
			$('#ObligeeShow').find('.span7').addClass("greenDiv");
			$('#ObligeeShow').fadeIn('fast');
			$('#ObligeeShow').fadeIn('fast');
			$('#ObligeeClear').fadeIn('fast');
			$('#ObligeeShowManually').fadeOut('fast');
			$('#obligeeAddressSelectionId').val("Selected");
			addAddressToObligee(name,add1,add2,city,state,stateCd,zip,country,countryCd);
			setLookupTimeout("ObligeeShow");
		}
		returnToMainPage();
		$('#lookupDiv').empty();
		$(window).scrollTop(scrollTopValue);
	});
	$('.selectNameAddressManually').click(function(e){
		var addressType = $(this).attr("title");
		var scrollTopValue = $("#scrollTopValueId").val();
		if(addressType == 'Applicant'){
			$('#ApplicantShow').fadeOut('fast');
			$('#ApplicantShowManually').fadeIn('fast');
			$('#ApplicantShow').find('p').empty();
			$('#ApplicantShowManually').find('input[type=text]').val('');
			$('#ApplicantShowManually').find('input[type=hidden]').val('');
			$('#ApplicantShowManually').find('select').val(-1);
			$('#tpApplicantAddressSelectionId').val("New");
			$('#applicantSelectionId').val("New");	
			$.publish('/fieldCounter/fieldsModified','#ApplicantShowManually');
		}else if(addressType == 'Customer'){
			$('#CustomerBeneficiaryShow').fadeOut('fast');
			$('#CustomerBeneficiaryShowManually').fadeIn('fast');
			$('#CustomerBeneficiaryShow').find('p').empty();
			$('#CustomerBeneficiaryShowManually').find('input[type=text]').val('');
			$('#CustomerBeneficiaryShowManually').find('input[type=hidden]').val('');
			$('#CustomerBeneficiaryShowManually').find('select').val(-1);
			$('#tpCustomerAddressSelectionId').val("New");		
			$.publish('/fieldCounter/fieldsModified','#CustomerBeneficiaryShowManually');
		}else if(addressType == 'Tri-PartyApplicant'){
			$('#TriPartyShow').fadeOut('fast');
			$('#TriPartyShowManually').fadeIn('fast');
			$('#TriPartyShow').find('p').empty();
			$('#TriPartyShowManually').find('input[type=text]').val('');
			$('#TriPartyShowManually').find('input[type=hidden]').val('');
			$('#TriPartyShowManually').find('select').val(-1);
			$('#triPartyAddressSelectionId').val("New");
			$.publish('/fieldCounter/fieldsModified','#TriPartyShowManually');
		}else if(addressType == 'Beneficiary'){
			$('#BeneficiaryShow').fadeOut('fast');
			$('#BeneficiaryShowManually').fadeIn('fast');
			$('#BeneficiaryShow').find('p').empty();
			$('#BeneficiaryShowManually').find('input[type=text]').val('');
			$('#BeneficiaryShowManually').find('input[type=hidden]').val('');
			$('#BeneficiaryShowManually').find('select').val(-1);
			$('#beneficiaryAddressSelectionID').val("New");
			$.publish('/fieldCounter/fieldsModified','#BeneficiaryShowManually');
		}else if(addressType == 'Bank Details'){
			$('#bankDetails').fadeOut('fast');
			$('#BankDetailsShowManually').fadeIn('fast');
			$('#bankDetails').find('p').empty();
			$('#BankDetailsShowManually').find('input[type=text]').val('');
			$('#BankDetailsShowManually').find('input[type=hidden]').val('');
			$('#BankDetailsShowManually').find('select').val(-1);
			$('#bankBicCode').val('');
			$('#bicCodeOverride').val('');
			$('#bankSelectionId').val("New");
			$('#issuingBankSelectionId').val("New");
			$('#bankDetails').hide();
			$('#bankBICOverride').hide();
			$('#bicCodeOverride').val('');
			$('#bMDMId').val('');
			$.publish('/fieldCounter/fieldsModified','#BankDetailsShowManually');
		}else if(addressType == 'Obligee'){
			$('#ObligeeShow').fadeOut('fast');
			$('#ObligeeShowManually').fadeIn('fast');
			$('#ObligeeShow').find('p').empty();
			$('#ObligeeShowManually').find('input[type=text]').val('');
			$('#ObligeeShowManually').find('input[type=hidden]').val('');
			$('#ObligeeShowManually').find('select').val(-1);
			$('#obligeeAddressSelectionId').val("New");
			$.publish('/fieldCounter/fieldsModified','#ObligeeShowManually');
		}else if(addressType == 'Principal'){
			$('#PrincipalShow').fadeOut('fast');
			$('#PrincipalShowManually').fadeIn('fast');
			$('#PrincipalShow').find('p').empty();
			$('#PrincipalShowManually').find('input[type=text]').val('');
			$('#PrincipalShowManually').find('input[type=hidden]').val('');
			$('#PrincipalShowManually').find('select').val(-1);
			$('#principlaAddressSelectionId').val("New");
			$('#principalStateDivId').hide();
			$.publish('/fieldCounter/fieldsModified','#PrincipalShowManually');
		}
		returnToMainPage();
		$(window).scrollTop(scrollTopValue);
	});
	
	
	
});
function returnToMainPage() {
	//$('#issuingBankNameId').val($('#bankLookupName').val());
	var id = $('#lookupDiv').find('.lookup-filterValue').attr('id');
	var value = $('#lookupDiv').find('.lookup-filterValue').val();
	var requestorType= $('#requestorTypeId').val();
	if(requestorType!=undefined && requestorType == 'currentContact')	{
	$(".businessContactPersonClass").val(value);}
	else{
	$('#mainPage').find('#'+id).val(value);
	}
	if($("#bankDetailCountryCodeId").val()!=undefined && $("#bankDetailCountryCodeId").val()!=""){
	$("#issuingBankNameId").val($("#bankName").val());
	$('#mainPage').find('.bankCountryCode').val($("#bankDetailCountryCodeId").val());
	$("#bankCountryNameId").val($("#bankDetailCountryNameId").val());
	$("#bankCountryNameId").siblings('.ui-autocomplete-input').val($("#bankDetailCountryNameId").val());
	$('#mainPage').find(".bankCityName").val($('#lookupDiv').find(".bankCityName").val());
	}
	$('#mainPage').fadeIn('fast');
	$('#lookupDiv').fadeOut('fast');
}

function addAddressToApplicant(name,add1,add2,city,state,zip,country) {
	$('#applicantAddressName').val(name);
	$('#applicantAddress1').val(add1);
	$('#applicantAddress2').val(add2);
	$('#applicantAddressCity').val(city);
	$('#applicantAddressState').val(state);
	$('#applicantAddressZip').val(zip);
	$('#applicantAddressCountry').val(country);
	addStateCountryCode('#applicantAddressCountryCd_widget option',country,'#applicantAddressCountryCd');
	addStateCountryCode('#applicantAddressStateCd_widget option',state,'#applicantAddressStateCd');
	$.publish('/fieldCounter/fieldsModified','#applicantAddressName');
}
function addStateCountryCode(widget, country, targetId) {
	$(widget).each(function(){
		var text = $(this).text();
		if(text == country){
			$(targetId).val($(this).val());
		}
	});
}
function addAddressToCustomer(name,add1,add2,city,state,zip,country) {
	$('#customerAddressName').val(name);
	$('#customerAddress1').val(add1);
	$('#customerAddress2').val(add2);
	$('#customerAddressCity').val(city);
	$('#customerAddressState').val(state);
	$('#customerAddressZip').val(zip);
	$('#customerAddressCountry').val(country);
	addStateCountryCode('#customerAddressCountryCd_widget option',country,'#customerAddressCountryCd');
	addStateCountryCode('#customerAddressStateCd_widget option',state,'#customerAddressStateCd');
	$.publish('/fieldCounter/fieldsModified','#customerAddressName');
}
function addAddressToTriParty(name,add1,add2,city,state,zip,country) {
	$('#triPartyAddressName').val(name);
	$('#triPartyAddress1').val(add1);
	$('#triPartyAddress2').val(add2);
	$('#triPartyAddressCity').val(city);
	$('#triPartyAddressState').val(state);
	$('#triPartyAddressZip').val(zip);
	$('#triPartyAddressCountry').val(country);
	addStateCountryCode('#triPartyAddressCountryCd_widget option',country,'#triPartyAddressCountryCd');
	addStateCountryCode('#triPartyAddressStateCd_widget option',state,'#triPartyAddressStateCd');
	$.publish('/fieldCounter/fieldsModified','#triPartyAddressName');
}

function addAddressToBeneficiary(name,add1,add2,city,state,zip,country) {
	$('#beneficiaryAddressName').val(name);
	$('#beneficiaryAddress1').val(add1);
	$('#beneficiaryAddress2').val(add2);
	$('#beneficiaryAddressCity').val(city);
	$('#beneficiaryAddressState').val(state);
	$('#beneficiaryAddressZip').val(zip);
	$('#beneficiaryAddressCountry').val(country);
	$.publish('/fieldCounter/fieldsModified','#beneficiaryAddressName');
}

function addAddressToPrincipal(name,add1,add2,city,state,stateCd,zip,country,countryCd) {
	$('#principalAddressName').val(name);
	$('#principalAddress1').val(add1);
	$('#principalAddress2').val(add2);
	$('#principalAddressCity').val(city);
	$('#principalAddressState').val(state);
	$('#principalAddressStatecode').val(stateCd);
	$('#principalAddressZip').val(zip);
	$('#principalAddressCountry').val(country);
	$('#principalCountryCd').val(countryCd);
	$.publish('/fieldCounter/fieldsModified','#principalAddressName');
	
	//for mailing address address set up based on principal selection
	$('#companyName').val(name);
	$('#mailingAddress1').val(add1);
	$('#mailingAddress2').val(add2);
	$('#mailingCity').val(city);
	$('#mailingState').val(state);
	$('select.comboMailingState option[value="-1"]').attr("selected",true);
	$('#mailingzipPostalCode').val(zip);
	$('#mailingcountryCd').val(countryCd);
	$('#mailingCountry').val(country);
	$('#mailingCountry').siblings("input.ui-widget").val(country);
	$('#mailingCountry').closest('div.form-row').find('div.errorBlock').find("input.ui-widget").val(country);
	$.publish('/fieldCounter/fieldsModified', '#companyName');
	
}

function addAddressToObligee(name,add1,add2,city,state,stateCd,zip,country,countryCd) {
	$('#obligeeAddressName').val(name);
	$('#obligeeAddress1').val(add1);
	$('#obligeeAddress2').val(add2);
	$('#obligeeAddressCity').val(city);
	$('#obligeeAddressState').val(state);
	$('#obligeeAddressStateCd').val(stateCd);
	$('#obligeeAddressZip').val(zip);
	$('#obligeeAddressCountry').val(country);
	$('#obligeeAddressCountryCd').val(countryCd);
	$.publish('/fieldCounter/fieldsModified','#obligeeAddressName');
}

function setLookupTimeout(id) {
	setTimeout(	function(){
		   $('#'+id).find('.span7').removeClass('greenDiv').addClass('greenDivNone');
		}, 5000);
}
