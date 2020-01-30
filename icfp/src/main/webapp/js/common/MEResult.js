$(document).ready(function(){
		var recordCount = $("#meRecordCountID").val();
		var prevPageStart = $("#mePrevPageStart").val();
		showPreviousButton(prevPageStart);
		showNextButton(recordCount);
	});
	
	 function getNextME(buttonName) {
		    var data, url,pageStart = 1;
		    $("#results").addClass("loading");
			if(buttonName=="prev"){
				pageStart = $("#mePrevPageStart").val();
				if(pageStart>300){
					pageStart = pageStart-300;
				}else{
					pageStart = 1;
				}
			}else if (buttonName=="next"){
				pageStart = $("#meNextPageStart").val();
			}
		    url = contextURL + "/lookup.do?cmd=getME&pageNumberValue="+pageStart+" #results";
		    data = {
		      LE: $("#leGoldID").val(),
		      q: $("#mEntityID").val(),
		      BS: $("#bSegmentID").val()
		    };
		   
		    $("#lookup .form-row #results").load(url, data, function(response, status, xhr){
		    
		    	updateValues($(response).find('#meRecordCountID').val(),pageStart); 
		    });
	 } 
		  function updateValues(recordCount,pageStart)
		  {
			    showNextButton(recordCount);
				showPreviousButton(pageStart);
				$("#results").removeClass("loading");  
		  }
	
		  function showPreviousButton(prevPageStart)
	      {
				if(prevPageStart>300)
				{
					$("#mePreviousID").show();
				}else{
					$("#mePreviousID").hide();
				}
	      }
		     
	     function showNextButton(recordCount)
	     {
	    	 if(recordCount>=300){
					$("#meNextID").show();
				}else{
					$("#meNextID").hide();	
				}
	     }