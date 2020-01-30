
$(document).ready(function() {

$('#instrumentAmt').bind("change",function(){
		var targetId = $(this).closest('.row').next().next().find('p').attr('id');
		var currCodeid = $(this).closest('.row').prev().find('input[type=hidden]').attr('id');
		var currCode=$("#"+currCodeid).val();
		var originalCCYAmount= $(this).val();
		var targetControl = $(this).closest('.row').next().next().find('input[type=hidden]').attr('id');
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					var instrumentdata = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					var url = contextURL +"/USDEquivalentRefData.action";
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: instrumentdata,
						success: function(data){
						$("#"+targetId).find('span').text(data.data);
						$('#'+targetControl).val(data.data);
						bidValuepercent(data.data);
						}
						});
					
					
				}else{
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
					bidValuepercent(originalCCYAmount);
				}
			}
		}
		
	});


function bidValuepercent(usdAmount){
	var bidPercent="";
	var USDInstrumentAmount = usdAmount;
	var USDBidAmount = $('#bidUSDEquivalentAmount').val();
	if(USDBidAmount!="" && USDInstrumentAmount!=""){
		if(USDBidAmount!=undefined && USDInstrumentAmount!=undefined){
			if(USDBidAmount!="0"){
				bidPercent=(USDInstrumentAmount/USDBidAmount)*100;
				
			}
			if(bidPercent!="" && bidPercent!=undefined){
				$('#percent').text(bidPercent);
				$('#percentValueOfBid').val(bidPercent);
				
			}
			
		}
		
	}
}

	
	$('.currencyAmt').bind("change",function(){
		var targetId = $(this).closest('.row').next().find('p').attr('id');
		var currCodeid = $(this).closest('.row').prev().find('input[type=hidden]').attr('id');
		var currCode=$("#"+currCodeid).val();
		var originalCCYAmount= $(this).val();
		var targetControl = $(this).closest('.row').next().find('input[type=hidden]').attr('id');
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					usdConversion(data,targetId,targetControl);
				}else{
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
				}
				
				
			}
			
		}
	
	});
	
	function usdConversion(data,targetId,targetControl){
		
		var url = contextURL +"/USDEquivalentRefData.action";
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'json',
			data: data,
			success: function(data){
			$("#"+targetId).find('span').text(data.data);
			$('#'+targetControl).val(data.data);
		
			}
			});
		
	}
	
	          
   

	
});