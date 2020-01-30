	$(document).ready(function(){
		var recordCount = $("#tcRecordCountID").val();
		var prevPageStart = $("#tcPrevPageStart").val();
		showPreviousButton(prevPageStart);
		showNextButton(recordCount);
	});
	
	     function getNextTcodeList(buttonName) {
			 	var pageStart = 1;
			    $("#results").addClass("loading");
				if(buttonName=="prev"){
					pageStart = $("#tcPrevPageStart").val();
					if(pageStart>300){
						pageStart = pageStart-300;
					}else{
						pageStart = 1;
					}
				}else if (buttonName=="next"){
					pageStart = $("#tcNextPageStart").val();
				}
                data = {
          		      LE: $("#tcLEGoldID").val()
          		    };
                var url = contextURL + "/lookup.do?cmd=getTCode&pageNumberValue="+pageStart;
                $("#lookup .form-row #results").load(url, data, function(response, status, xhr){
    		    	updateValues($(response).find('#tcRecordCountID').val(),pageStart); 
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
					$("#tcPreviousID").show();
				}else{
					$("#tcPreviousID").hide();
				}
	      }
		     
	     function showNextButton(recordCount)
	     {
	    	 if(recordCount>=300){
					$("#tcNextID").show();
				}else{
					$("#tcNextID").hide();	
				}
	     }