
$(document).ready(function() {
   
   $('#siteSummaryTblId tbody tr:odd').addClass("odd");
   
   $('.ttip').tooltip({delay: { show: 300, hide: 1 }});
   $('.ttip.chart').tooltip();
   
   if (window.PIE) {
       $('.main,.btn,.modalSite').each(function() {
           PIE.attach(this);
       });
   }
   
   /**
	 * To show Cancel Pop-up
	 */
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","100px;"); 
	});
	
   if(!$('#approverGroups').attr('handlerRegistered')) {
	   	$('#approverGroups').on('change', function() {
	   		var groupId = $('#approverGroups').val();
	   		if(groupId != undefined && groupId != ""){
	   			$('#groupProcess').show();
	   			getCurrentApprovers(groupId);
	   		}else if(groupId == ""){
	   			$('#businessDelegates').hide();
	   			$('#SelectedApp').hide();
	   			$('#approversDivId').hide();
	   		}
	   	});
		$('#approverGroups').attr('handlerRegistered', true);
   }
	
	/**
     * Get the Delegation Details
     */
    if(!$('#selectSiteNameDeleg').attr('handlerRegistered')) {
    	$('#selectSiteNameDeleg').on('change', function() {
    		var siteId = $('#selectSiteNameDeleg').val();
     	   
    		$('#create').empty();
    		$('#create').hide();
    		if(siteId != undefined && siteId != ""){
	     	   $("#delegProcess").show();
		     	   url = contextURL+'/int/siteadmin/openBusinessAdmin.action?siteId=' + siteId;
		     	   $("#create").load(url, function(){
		     	   $("#delegProcess").hide();
	     	   });
	     	   $("#create").show();
    		}
     });
    	$('#selectSiteNameDeleg').attr('handlerRegistered', true);
    }
    
    var onloadVal = $('#selectSiteNameDeleg').val();
    if(onloadVal != undefined && onloadVal != ""){
    }else{
    	 getSitenames();
    }
});

/**
 * To Get All the Sites in Select box  
 */
function getSitenames(){
	$('#selectSiteNameDeleg').hide();
	$('#siteNameDiv').hide();
	$('#getSitesProcess').show();
	$.ajax({
		type: 'POST',
        url: contextURL+'/int/siteadmin/getSiteNames.action',
        dataType: 'json',
        data: {businessSite : "BusinessSite"},
        processdata: true,
        success: function(data) {
        	$("#selectSiteNameDeleg").empty().append("<option value=''>Select...</option>");
          	for (var i = 0; i < data.result.length; i++) {
          		$("#selectSiteNameDeleg").append("<option value='" + data.result[i].id + "'>" + data.result[i].prefix + " - " + data.result[i].name + "</option>");
             }
          	$('#selectSiteNameDeleg').show();
          	$('#siteNameDiv').show();
          	$('#getSitesProcess').hide();
        }
    });
}

/**
Get the Current Approvers
*/
function getCurrentApprovers(groupId) {
$.ajax({
	type: "POST",
   url: contextURL+'/int/siteadmin/getCurrentApprovers.action',
   dataType: 'html',
   data: { groupId : groupId },
   processdata: true,
   success: function(data) {
		$('#SelectedApp').empty().append(data);
		$('#SelectedApp').show();
		$('#groupProcess').hide();
		$('#approversDivId').show();
   		}
	});
}

