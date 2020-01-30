$(document).ready(function(){
	$('textarea').keyup(function() {
				  	  var len = this.value.length;
				  	  if (len >= 500) {
				  	  this.value = this.value.substring(0, 500);
				  	  }
				  	  });

       $('#saveLeg').click(function(e){
					  removeAmountShortcuts();
					 document.forms[0].action = contextURL + '/transferPricing/transferPricingLeg.do?command=saveAndReturnToDeal';
					 document.forms[0].submit();
				  });		
});				  		  	  