$(document).ready(function(){
	$('.siteSelectionCls').off('click').on('click', function() {
		setRoles();
	});

	setRoles();
});    

/**
 * Set the roles based on the instrument type
 */
function setRoles(){

	var i=1;
	var bank = false;
	var finInd = false;
	var surety = false;
	var treasury = false;
	var k=1;

	$('.siteSelectionCls').each(function(){
		if ($(this).prop('checked')==true){
			if(k==1){bank = true;}
			if(k==2){finInd = true;}
			if(k==3 && finInd == false){finInd = true;}
			if(k==4){surety = true;}
			if(k==5){treasury = true;}
		}else{
			if(k==1){bank = false;}
			if(k==2){finInd = false;}
			if(k==3 && finInd == false){finInd = false;}
			if(k==4){surety = false;}
			if(k==5){treasury = false;}
		}
		k+=1;
	});
	$('.siteSelectionCls').each(function(){

		if ($(this).prop('checked')==true){
			if(i==1){
				var j=1;
				$('.roleSelectionCls').each(function(){
					if(j==2 || j==3){	
						$(this).show(); 
						$(this).next('.checkboxLabel').show(); 
					}
					if((finInd == false) && (j==1 || j==4 || j==5 || j==6)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((surety == false) && (j==7 || j==8)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((treasury == false) && (j==9 || j==10)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}
					j+=1;
				});
			}else if(i==2 || i==3){
				var j=1;
				$('.roleSelectionCls').each(function(){

					if(j==1 || j==4 || j==5 || j==6){	
						$(this).show(); 
						$(this).next('.checkboxLabel').show();
					}
					if((j==2 || j==3)){
						if(bank == true){
							$(this).show(); 
							$(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); 
							$(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					if((finInd == false) && (j==1 || j==4 || j==5 || j==6)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((surety == false) && (j==7 || j==8)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((treasury == false) && (j==9 || j==10)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}
					j+=1;

				});
			}else if(i==4){
				var j=1;
				$('.roleSelectionCls').each(function(){
					if(j==7 || j==8){	
						$(this).show(); 
						$(this).next('.checkboxLabel').show();
					}
					if((j==2 || j==3)){
						if(bank == true){
							$(this).show(); $(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); $(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					if((j==1 || j==4 || j==5 || j==6)){
						if(finInd == true){
							$(this).show(); $(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); $(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					if((finInd == false) && (j==1 || j==4 || j==5 || j==6)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((surety == false) && (j==7 || j==8)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}else if((treasury == false) && (j==9 || j==10)){
						$(this).hide(); 
						$(this).next('.checkboxLabel').hide(); 
						$(this).attr('checked', false);
					}
					j+=1;
				});
			}else if(i==5){
				var j=1;
				$('.roleSelectionCls').each(function(){
					if(j==9 || j==10){	
						$(this).show(); 
						$(this).next('.checkboxLabel').show();
					}
					if(j==2 || j==3){
						if(bank == true){
							$(this).show(); $(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); $(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					if(j==1 || j==4 || j==5 || j==6){
						if(finInd == true){
							$(this).show(); $(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); 
							$(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					if(j==7 || j==8){
						if(surety == true){
							$(this).show(); $(this).next('.checkboxLabel').show();
						}else{
							$(this).hide(); 
							$(this).next('.checkboxLabel').hide();
							$(this).attr('checked', false);
						}
					}
					j+=1;
				});
			}
		}
		if(bank == false && finInd == false && surety == false && treasury == false){
			$('.roleSelectionCls').each(function(){
				$(this).show(); 
				$(this).next('.checkboxLabel').show(); 
				$(this).attr('checked', false);
			});
		}
		i+=1;
	});
}