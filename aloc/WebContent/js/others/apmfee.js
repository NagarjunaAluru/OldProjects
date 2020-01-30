$(document).ready(function() {
	$("#edittr1").click(function(){
			$("#tr1Show").slideDown("fast");
			$("#tr1Save").slideDown("fast");
			$("#tr1").slideUp("fast");
        });
	$("#applytr1").click(function(){
			$("#tr1Show").slideUp("fast");
			$("#tr1Save").slideUp("fast");
			$("#tr1").slideDown("fast");
        });
	$("#canceltr1").click(function(){
			$("#tr1Show").slideUp("fast");
			$("#tr1Save").slideUp("fast");
			$("#tr1").slideDown("fast");
        });
	
	$("#edittr2").click(function(){
			$("#tr2Show").slideDown("fast");
			$("#tr2Save").slideDown("fast");
			$("#tr2").slideUp("fast");
        });
	$("#applytr2").click(function(){
			$("#tr2Show").slideUp("fast");
			$("#tr2Save").slideUp("fast");
			$("#tr2").slideDown("fast");
        });
	$("#canceltr2").click(function(){
			$("#tr2Show").slideUp("fast");
			$("#tr2Save").slideUp("fast");
			$("#tr2").slideDown("fast");
        });
		
	$("#edittr3").click(function(){
			$("#tr3Show").slideDown("fast");
			$("#tr3Save").slideDown("fast");
			$("#tr3").slideUp("fast");
        });
	$("#applytr3").click(function(){
			$("#tr3Show").slideUp("fast");
			$("#tr3Save").slideUp("fast");
			$("#tr3").slideDown("fast");
        });
	$("#canceltr3").click(function(){
			$("#tr3Show").slideUp("fast");
			$("#tr3Save").slideUp("fast");
			$("#tr3").slideDown("fast");
        });
	
	///////////////////////////////////
	
	// ADVANCED SEARCH
		$("a#searchMyTran").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgTran").slideDown();
		});	
		$("a#searchMyTranBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgTran").slideUp();
		});	
		
		$("a#searchRequest").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgRequest").slideDown();
		});	
		$("a#searchRequestBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgRequest").slideUp();
			$("#filterMsgTran").slideUp();
		});	
		
		$("a#searchDrafts").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgDrafts").slideDown();
		});	
		$("a#searchDraftsBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgDrafts").slideUp();
		});	
		
		$("a#searchModels").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgModels").slideDown();
		});	
		$("a#searchModelsBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgModels").slideUp();
		});	
		
		$("a#searchBPT").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBPT").slideDown();
		});	
		$("a#searchBPTBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBPT").slideUp();
		});	
		
		$("a#searchBPB").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBPB").slideDown();
		});	
		$("a#searchBPBBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBPB").slideUp();
		});	
		
		$("a#searchBundles").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBundles").slideDown();
		});	
		$("a#searchBundlesBtn").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("#filterMsgBundles").slideUp();
		});		

// Code between here will only run when the document is ready
		$("a#addInstrumentST").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#instrumentST tr:last").after('<tr><td><select><option selected>Select...</option><option>Value 1</option><option>Value 2</option><option>Value 3</option></select></td>');
			return false;
		});
		
		$("a#addInstrumentT").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#instrumentT tr:last").after('<tr><td><select><option selected>Select...</option><option>Value 1</option><option>Value 2</option><option>Value 3</option></select></td>');
			return false;
		});	
		
		$("a#addInstrumentSST").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#instrumentSST tr:last").after('<tr><td><select><option selected>Select...</option><option>Value 1</option><option>Value 2</option><option>Value 3</option></select></td>');
			return false;
		});		
		
		$("a#addInstrumentC").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#instrumentC tr:last").after('<tr><td><select><option selected>Select...</option><option>Value 1</option><option>Value 2</option><option>Value 3</option></select></td>');
			return false;
		});	
		
		$("a#addCountryI").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#countryI tr:last").after('<tr><td><input type="text" class="span2"></td>');
			return false;
		});	
		
		
		$("a#addPaymentC").click(function() {
			// Code between here will only run when the a link is clicked and has a name of addRow
			$("table#paymentC tr:last").after('<tr><td><input type="text" class="span2"></td>');
			return false;
		});		

//On Click
	$('#collapse').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse2').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse3').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse4').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse5').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse6').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});
	$('#collapse7').click(function(){
		$('.acc_trigger1').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger2').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger3').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger4').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger5').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$('.acc_trigger6').removeClass('acc_active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).removeClass('acc_active').next().slideUp(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		$('.acc_container2').slideUp();
		$('.acc_container3').slideUp();
		$('.acc_container4').slideUp();
		$('.acc_container5').slideUp();
		$('.acc_container6').slideUp();
	});	
	
 $("#toplevel").change(function(){
        $('option',this).each(function(){
            var opt = $(this),val = opt.val();            
            if (val == "level" ) {            
                if(opt.is(":selected")){
                    $("#level").slideDown("fast");
                }
				else{
					$("#level").slideUp("fast");
				}
            }
			if (val == "domestic") {            
                if(opt.is(":selected")){
                    $("#domestic").slideDown("fast");
                }
				else{
					$("#domestic").slideUp("fast");
				}
            }	
			if (val == "foreign" ) {            
                if(opt.is(":selected")){
                    $("#foreign").slideDown("fast");
                }
				else{
					$("#foreign").slideUp("fast");
				}
            }
			if (val == "full" ) {            
                if(opt.is(":selected")){
                    $("#full").slideDown("fast");
                }
				else{
					$("#full").slideUp("fast");
				}
            }			
        }); 
    });
 });
 
 

 