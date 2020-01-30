$(document).ready(function(){
		var recordCount = $("#leRecordCountID").val();
		var prevPageStart = $("#lePrevPageStart").val();
		showPreviousButton(prevPageStart);
		showNextButton(recordCount);
	});
	
	 function getNextLE(buttonName) {
		    var data, url,pageStart = 1;
		    $("#results").addClass("loading");
			if(buttonName=="prev"){
				pageStart = $("#lePrevPageStart").val();
				if(pageStart>300){
					pageStart = pageStart-300;
				}else{
					pageStart = 1;
				}
			}else if (buttonName=="next"){
				pageStart = $("#leNextPageStart").val();
			}
		    url = contextURL + "/lookup.do?cmd=getLE&pageNumberValue="+pageStart+" #results";
		    data = {
		      q: $("#queryID").val(),
		      forType: $("#forTypeID").val()
		    };
		   
		    $("#lookup .form-row #results").load(url, data, function(response, status, xhr){
		    	updateValues($(response).find('#leRecordCountID').val(),pageStart); 
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
				if(prevPageStart>300){
					$("#lePreviousID").show();
				}else{
					$("#lePreviousID").hide();
				}
	      }
		     
	     function showNextButton(recordCount)
	     {
	    	 if(recordCount>=300){
					$("#leNextID").show();
				}else{
					$("#leNextID").hide();	
				}
	     }