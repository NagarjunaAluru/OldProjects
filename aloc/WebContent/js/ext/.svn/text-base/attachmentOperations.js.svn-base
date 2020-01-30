$(document).ready(function () { 
		$('.alocFileupload').fileupload(
				{
					dataType: 'json',
			        sequentialUploads: true,
			        method: 'POST',
			        done: function (e, data) {
			        	if(varifyResponse(data.result)) {
			        		if(data.result.typeId==3){
			        			if(data.result.index==0)
			        				$(".alocAttachment0").show();
			        			if(data.result.index==1)
			        				$(".alocAttachment1").show();
			        		}else
			        			{
			        				$(".alocAttachment").show();
			        			}
			        		var contentToRender = prepareHTMLForFile(data.result);			        		
			        		var renderArea = findRenderAreaForFile($(this),data.result);			        		
			        		if(renderArea) {
			        			renderArea.empty().html(contentToRender);
			        		}				        		
			        		if(data.result.typeId !=null && (data.result.typeId==2 || data.result.typeId==3 || data.result.typeId==4)){ 
				        		var contentToRenderForDelete = prepareHTMLForDelete(data.result);
				        		var renderDeleteArea;
				        		if(data.result.typeId==3)
				        		{
				        			renderDeleteArea = findIssuanceRenderAreaForDelete($(this),data.result.index);
				        		}else
				        		    renderDeleteArea = findRenderAreaForDelete($(this));				        		
				        		if(renderDeleteArea){				        			
				        			renderDeleteArea.html(contentToRenderForDelete);				        			
				        		}
				        		if(data.result.typeId==3){				        			
				        			if(data.result.index==0) { 
						        		$("#linkHideId0").show();  
						        		$(".copydoc0").hide();
						        		$("#copyPasteDocModalConditionId0").val('1');
				        			}else{
						        		$("#linkHideId1").show();  
						        		$(".copydoc1").hide();
						        		$("#copyPasteDocModalConditionId1").val('1');
				        			}
				        		} 
				        		if(data.result.typeId==4){ 
					        		$("#linkHideId").show();  
					        		$(".copydoc").hide();
				        		}	
			        		}
			        				        		
				        }
			        },
			        error: function(xhr, textStatus, errorThrown) {
	    	        	var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
	    	        	showError(errorMsg);
	    		    }
		      });
			//for check functionality
			$('.bankOrSuretyAtmtPermission').off('change').on('change', function() {
	            var val =$(this).is(':checked');
	            if(val != undefined && val == true){
				$(this).parents('div.form-row').find(".treasuryAtmtPermission").attr("checked",true);
				}
			});
			//for uncheck functionality 
			$('.treasuryAtmtPermission').off('change').on('change', function() {
	            var val =$(this).is(':checked');		            
	            if(val != undefined && val == false){
	            	$(this).parents('div.form-row').find(".bankOrSuretyAtmtPermission").attr("checked",false);
	            }
	        });
	
			//Issuance Screen 
			$(document).on('click', '.need0', function(){	
				var conditionalModal = $('#copyPasteDocModalConditionId0').val();				
				if(conditionalModal==1)
				{
					n = window.open('#completeIssuanceRequest','_self');
					var conditionalId = $('#copyPasteDocModalConditionId0').val();
					var issuanceGeLibFileId = $('#copyPasteGeLibFileId0').val();
					var copyPasteTypeId = $('#copyPasteTypeId0').val();						
					$('#completeIssuanceTextAreaId', n.document).val(conditionalId);
					$('#issuanceGeLibFileId', n.document).val(issuanceGeLibFileId);
					$('#issuanceTypeId', n.document).val(copyPasteTypeId);
					$('#issuanceIndexId', n.document).val(0); 									
					$('#completeIssuanceRequest').modal({	 	 
				        show: 'true'	        
					});					 
				}else {			
					$('.alocDeleteAttachment0').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(0)'>clear</a></p>");	
					$('.alocDeleteAttachment0').show();
					$("#linkHideId0").hide();   
					$(".copydoc0").show();
				}			 	
			});
	
			$(document).on('click', '.need1', function(){				
				var conditionalModal = $('#copyPasteDocModalConditionId1').val();			
				if(conditionalModal==1)
				{
					n = window.open('#completeIssuanceRequest','_self');
					var conditionalId = $('#copyPasteDocModalConditionId1').val();
					var issuanceGeLibFileId = $('#copyPasteGeLibFileId1').val();
					var copyPasteTypeId = $('#copyPasteTypeId1').val();					
					$('#completeIssuanceTextAreaId', n.document).val(conditionalId);
					$('#issuanceGeLibFileId', n.document).val(issuanceGeLibFileId); 
					$('#issuanceTypeId', n.document).val(copyPasteTypeId);
					$('#issuanceIndexId', n.document).val(1);					
					$('#completeIssuanceRequest').modal({		 
				        show: 'true'	        
					});					 
				}else {
					$('.alocDeleteAttachment1').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(1)'>clear</a></p>");	
					$('.alocDeleteAttachment1').show();
					$("#linkHideId1").hide();   
					$(".copydoc1").show();
				}		
			});	
			
			$(".closure0").click(function(){					
				var conditionalModal = $('#copyPasteDocModalConditionId').val();				
				if(conditionalModal==1)
				{
					n = window.open('#completeClosureRequest','_self');
					var conditionalId = $('#copyPasteDocModalConditionId').val();
					var closureGeLibFileId = $('#copyPasteGeLibFileId').val();
					var copyPasteTypeId = $('#copyPasteTypeId').val();
					$('#closureTextAreaId', n.document).val(conditionalId);
					$('#closureGeLibFileId', n.document).val(closureGeLibFileId);
					$('#closureTypeId', n.document).val(copyPasteTypeId);
					$("#linkHideId").hide();  
					$('#completeClosureRequest').modal({		 
				        show: 'true'	        
					});					 
				}else {
					$('.alocDeleteAttachment').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearClosureData()'>clear</a></p>");	
					$('.alocDeleteAttachment').show();
					$("#linkHideId").hide();   
					$(".copydoc").show();
				}
			});	
			
//			add new row for attachments
			$('.add-attachment').each(function() {			
				if(!$(this).attr('addAnotherAtmtRow')) {
				$(this).click(function() {
				var newAdditionalAttachmentIndex = parseInt($('#newAttachmentIndex').val());
				var instrumentTypeId = parseInt($('#instrumentTypeId').val());
				var atmtTypeId = parseInt($('#atmtTypeId').val());				
				$("table#attachmentsTableId").children('tbody').children("tr:last").after('<tr class="newAdditionalAttachment"></tr>');
				var url = contextURL+'/ext/addAttachment.action?newAttachmentIndex=' + newAdditionalAttachmentIndex+'&atmtTypeId='+atmtTypeId+'&instrumentTypeId='+instrumentTypeId;			
				$('.newAdditionalAttachment').load(url).removeClass('newAdditionalAttachment');				
				$('#newAttachmentIndex').val(newAdditionalAttachmentIndex + 1);			
				if($('#newAttachmentIndex').val() == "5" && $('#newAttachmentIndex').val() !=""){
					$('#addAttachment').hide();
				}
				}); 
				$(this).attr('addAnotherAtmtRow', true);
				}
			});		
			
			decCounter("closureComments", 500);
			decCounter("closureUploadDescription", 100);	
			
			var closurePagelevelerror = $('#closureErrorShowId').val();
			if(closurePagelevelerror!=undefined && closurePagelevelerror == 'true'){				
				$('#closurePageLevelErrorDivId').show();
			}
			// Code to show the copy paste area
			var copyPasteGeLibFileId0 = $('#copyPasteGeLibFileId0').val();
			var copyPasteGeLibFileId1 = $('#copyPasteGeLibFileId1').val();						
			if(copyPasteGeLibFileId0!= undefined && copyPasteGeLibFileId0!= null && copyPasteGeLibFileId0!= ""){
				var conditionalModalId = $('#copyPasteDocModalConditionId0').val();
				if(conditionalModalId!= undefined && conditionalModalId!=1){
					$("#linkHideId0").hide();   				
					$(".copydoc0").show();
				}
			}else
				{
				var conditionalCopyPasteId0 = $('#issuanceDocument0').val();				
				if(conditionalCopyPasteId0!= undefined && conditionalCopyPasteId0!=""){
					$("#linkHideId0").hide();   				
					$(".copydoc0").show();
				}else
					{
						$("#linkHideId0").show();   				
						$(".copydoc0").hide();
					}
				}
			
			if(copyPasteGeLibFileId1!= undefined && copyPasteGeLibFileId1!= null && copyPasteGeLibFileId1!= ""){
				var conditionalModalId = $('#copyPasteDocModalConditionId1').val(); 
				if(conditionalModalId!= undefined && conditionalModalId!=1){
				$("#linkHideId1").hide();   
				$(".copydoc1").show();
			  }else
				{
					$("#linkHideId1").show();   				
					$(".copydoc1").hide();
				}	
			}else
			{
				var conditionalCopyPasteId1 = $('#issuanceDocument1').val();				
				if(conditionalCopyPasteId1!= undefined && conditionalCopyPasteId1!=""){
					$("#linkHideId1").hide();   				
					$(".copydoc1").show();
				}else
					{
						$("#linkHideId1").show();   				
						$(".copydoc1").hide();
					}
			}	
					
			var copyPasteGeLibFileId = $('#copyPasteGeLibFileId').val();
			if(copyPasteGeLibFileId!= undefined && copyPasteGeLibFileId!= null && copyPasteGeLibFileId!= ""){
				var conditionalModalId = $('#copyPasteDocModalConditionId').val(); 
				if(conditionalModalId!= undefined && conditionalModalId!=1){
				$("#linkHideId").hide();   
				$(".copydoc").show();
			  }else
				{
					$("#linkHideId").show();   				
					$(".copydoc").hide();
				}	
			}else
			{
				var conditionalCopyPasteId = $('#closureDocument').val();							
				if(conditionalCopyPasteId!= undefined && conditionalCopyPasteId!=""){
					$("#linkHideId").hide();   				
					$(".copydoc").show();
				}else
					{
						$("#linkHideId").show();   				
						$(".copydoc").hide();
					}
			}
});

/*
 * 
 */
function varifyResponse(responseData) {
	if(responseData.status != null && (responseData.status == 'SUCCESS' || responseData.status == 'otherAttachmentSuccess'
		|| responseData.status == 'issuerAttachmentSuccess' 
			|| responseData.status == 'closureAttachmentSuccess' )) {
		return true;
	} else if(responseData.status != null && (responseData.status == 'ERROR' || responseData.status == 'error')) {		
		showError(responseData);
		return false;
	}	
	handleUnknownError();
	return false;
}

/*
 * 
 */
function getXmlHttpObject() {
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		return new XMLHttpRequest();
	}
	if (window.ActiveXObject) {
		// code for IE6, IE5
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
	return null;
}

/*
 * 
 */
function findRenderAreaForFile(target,responseData) {
	var alocAtmtDiv = target.parents(".alocAttachmentContainer");
	var renderArea
	if(responseData.typeId==3){	
		if(responseData.index==0){
			renderArea = alocAtmtDiv.find(".alocAttachment0");
		}else if(responseData.index==1){
			renderArea = alocAtmtDiv.find(".alocAttachment1");
		}
	}else
		renderArea = alocAtmtDiv.find(".alocAttachment");
	return renderArea;
}

/*
 * 
 */
function prepareHTMLForFile(responseData) {	
	if(responseData.typeId==3 || responseData.typeId==4){			
		if(responseData.index==0){
			$('#copyPasteDocModalConditionId0').val("1");
			$('#copyPasteDocModalConditionId1').val("0");
			$('#copyPasteGeLibFileId0').val(responseData.attachment.geFileId);
		}
		else if(responseData.index==1){
			$('#copyPasteDocModalConditionId0').val("0");
			$('#copyPasteDocModalConditionId1').val("1");
			$('#copyPasteGeLibFileId1').val(responseData.attachment.geFileId);
		} 
		$('#copyPasteTypeId').val(responseData.typeId);		
	} 
	var downloadURL = contextURL + "/ext/atmt/download.action?geLibFileId=" + responseData.attachment.geFileId + "&typeId=" + responseData.typeId + "&formatId=" + responseData.formatId;
	var fileDiv = "<a href='" + downloadURL + "'>";
	fileDiv += responseData.attachment.attachmentOriginalName + "</a>";
	return fileDiv;
}



/*
 * 
 */
function findRenderAreaForDelete(target) {	
	var renderArea  = $(target).closest('tr').children('td:nth-child(1)').find('div.alocDeleteAttachment').find('p');			
	return renderArea;
}

function findIssuanceRenderAreaForDelete(target,indexId) {	
	var renderArea;
	if(indexId==0)
		renderArea  = $(target).closest('tr').children('td:nth-child(1)').find('div.alocDeleteAttachment0').find('p');
	else
		renderArea  = $(target).closest('tr').children('td:nth-child(1)').find('div.alocDeleteAttachment1').find('p');
	return renderArea;
}

/*
 * 
 */
function prepareHTMLForDelete(responseData) {		
	var fileDeleteDiv = "";	
	if(responseData.typeId==2 || responseData.typeId==4){		
		var linkLabel;
		if(responseData.typeId==2){
			fileDeleteDiv ="<a href='javascript:void(0)' class=\"delete-tr-hide\" onclick=\"javascript:deleteAttachment("+responseData.attachment.geFileId+","+responseData.typeId+","+responseData.index+")\">";
			linkLabel="";
		}
		else{
			linkLabel = " clear ";
			fileDeleteDiv ="<a href='javascript:void(0)' onclick=\"javascript:deleteAttachment("+responseData.attachment.geFileId+","+responseData.typeId+","+responseData.index+")\">";
		}
		fileDeleteDiv +=linkLabel+"</a>";
	}	
	else if(responseData.typeId==3){
			fileDeleteDiv = "<a href='javascript:void(0)' onclick=\"javascript:deleteIssuanceAttachment("+responseData.attachment.geFileId+","+responseData.typeId+","+responseData.index+")\">";	
			fileDeleteDiv +=" clear </a>";
		}
	return fileDeleteDiv;
}



/*
 * 
 */
function handleUnknownError(e) {
	showError('Error while performing desired operation ');
}


/*
 * 
 */
function showError(responseData) {
	var errorModal="";
	if(responseData.typeId==1)
		errorModal = $('#formatAtmtErrorModal');
	else if(responseData.typeId==2 || responseData.typeId==3 || responseData.typeId==4)
		errorModal = $('#attachmentErrorModal');		
    $(errorModal).find('.modal-body P').html(responseData.errorMsg);
    $(errorModal).modal('show');
}

/*
 * 
 */
function deleteAttachment(geLibFileId,typeId,index) {	
	n = window.open('#atmtConfirmModal','_self');
	$('#modelGeLibFileId', n.document).val(geLibFileId);	
	$('#modelTypeId', n.document).val(typeId);	
	$('#modelIndex', n.document).val(index);		
	$('#atmtConfirmModal').modal({		 
	        show: 'true'	        
	 }); 	
  }	


/**
 * 
 */
function deleteConfirm(){	
var geLibFileId = $('#modelGeLibFileId').val();	
var typeId = $('#modelTypeId').val();	
var index = $('#modelIndex').val();	
var url = contextURL +"/ext/atmt/delete.action?";
var parameters = "&geLibFileId=" + geLibFileId+"&typeId="+typeId+"&index="+index;	
$.ajax({
    type:'POST',
	url: url,
	dataType: 'html',
	data: parameters, 
	success: function(data) {			
		$("#attachmnetRefresh").empty().append(data);									  		   				  
	},
	 error: function(xhr, textStatus, errorThrown) {
     	var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
     	showError(errorMsg);
	    }
});	
};
 

function deleteIssuanceAttachment(GeLibFileId,typeId,indexId,evt) {	
	n = window.open('#atmtConfirmModal','_self');
	$('#modelGeLibFileId', n.document).val(GeLibFileId);	
	$('#modelTypeId', n.document).val(typeId);	
	$('#modalIndexId', n.document).val(indexId);		
	$('#atmtConfirmModal').modal({		 
	        show: 'true'	        
	 });  	
  }	

/**
 * 
 */
function issuanceAtmtdeleteConfirm(){		
	var geLibFileId = $('#modelGeLibFileId').val();	
	var typeId = $('#modelTypeId').val();	
	var errorMsg;
	var indexId = $('#modalIndexId').val();		
	var url = contextURL +"/ext/atmt/delete.action?";
	var parameters = "&geLibFileId=" + geLibFileId+"&typeId="+typeId+"&index="+indexId+"&copyPasteFlag=true";	
	$.ajax({
		    type:'POST',
			url: url,
			dataType: 'html',
			data: parameters, 
			success: function(data) {	   	  	    
	    		if(indexId==0){
					$('.alocDeleteAttachment0').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(0)'>clear</a></p>");	
					$('.alocDeleteAttachment0').show();
		    		$(".alocAttachment0").hide(); 
					$('#copyPasteDocModalConditionId0').val("0"); 
					$('#copyPasteTypeId').val("");
					$('#copyPasteGeLibFileId0').val("");
					$('#issuanceBankRefNo0').val("");
					$('#issuanceDate0').val(null);
					$('#issuanceDesc0').val("");	
					$('.counter0').html(100);
					$('.counter10K0').html("10,000"); 
					$('#issuanceDocument0').val("");
	    			$("#linkHideId0").hide();    			
	    			$(".copydoc0").show();    			
	    		}
	    		else{
					$('.alocDeleteAttachment1').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(1)'>clear</a></p>");	
					$('.alocDeleteAttachment1').show();
		    		$(".alocAttachment1").hide();  
					$('#copyPasteDocModalConditionId1').val("0"); 
					$('#copyPasteTypeId').val("");
					$('#copyPasteGeLibFileId1').val(""); 
					$('#issuanceBankRefNo1').val("");
					$('#issuanceDate1').val(null);
					$('#issuanceDesc1').val("");		
					$('.counter1').html(100);
					$('.counter10K1').html("10,000"); 
					$('#issuanceDocument1').val("");
	    			$("#linkHideId1").hide();   
	    			$(".copydoc1").show();    			
	    		}    												  		   			
			},
			error: function(xhr, textStatus, errorThrown) {
	        	errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
	        	showError(errorMsg);
		    }
	});	
};

/*
 *
 */
function openTextareaSection(){	
	var geLibFileId = $('#issuanceGeLibFileId').val();	
	var typeId = $('#issuanceTypeId').val();		
	var indexTypeId = $('#issuanceIndexId').val();	
	var url = contextURL +"/ext/atmt/closureDelete.action?";
	var parameters = "&geLibFileId=" + geLibFileId+"&typeId="+typeId+"&copyPasteFlag=true";
	$.ajax({
	    type:'POST',
		url: url,
		dataType: 'html',
		data: parameters, 
		success: function(data) {	   	  	    
    		if(indexTypeId==0){
    			$('.alocDeleteAttachment0').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(0)'>clear</a></p>");	
    			$('.alocDeleteAttachment0').show();    
        		$(".alocAttachment0").hide();
				$('#copyPasteDocModalConditionId0').val("0"); 
				$('#copyPasteTypeId').val("");
				$('#copyPasteGeLibFileId0').val("");
				$('.counter0').html(100);
				$('.counter10K0').html("10,000"); 
				$('#issuanceDocument0').val("");
    			$("#linkHideId0").hide();    			
    			$(".copydoc0").show();    			
    		}
    		else{
    			$('.alocDeleteAttachment1').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearAllData(1)'>clear</a></p>");	
    			$('.alocDeleteAttachment1').show();
        		$(".alocAttachment1").hide();
				$('#copyPasteDocModalConditionId1').val("0"); 
				$('#copyPasteTypeId').val("");
				$('#copyPasteGeLibFileId1').val(""); 
				$('.counter1').html(100);
				$('.counter10K1').html("10,000"); 
				$('#issuanceDocument1').val("");
    			$("#linkHideId1").hide();   
    			$(".copydoc1").show();    			
    		}

		},
		error: function(xhr, textStatus, errorThrown) {
        	errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
        	showError(errorMsg);
	    }
	});	
};

//to clear the data in the upload section of issuer screen
function clearAllData(indexId){	
	if(indexId==0){
		$('#issuanceBankRefNo0').val("");
		$('#issuanceDate0').val(null);
		$('#issuanceDesc0').val("");		
		$('#issuanceDocument0').val("");		
		$('.counter0').html(100);		
		$('.counter10K0').html("10,000"); 
		$("#linkHideId0").show();  
		$(".copydoc0").hide();
		
	}
	else
	{
		$('#issuanceBankRefNo1').val("");
		$('#issuanceDate1').val(null);
		$('#issuanceDesc1').val("");
		$('#issuanceDocument1').val("");		
		$('.counter1').html(100);
		$('.counter10K1').html("10,000"); 
		$("#linkHideId1").show();  
		$(".copydoc1").hide();
	}		
}

//clear all the upload section of the closure screen
function clearClosureData(){			
		$('#closureUploadDescription').val("");
		$(".bankOrSuretyAtmtPermission").attr("checked",false);
		$(".treasuryAtmtPermission").attr("checked",false);		
		$('.closureCounter').html(100);
		
}	

/*
 *
 */
function openClosureDocSection(){
	var geLibFileId = $('#closureGeLibFileId').val();	
	var typeId = $('#closureTypeId').val();			
	var url = contextURL +"/ext/atmt/closureDelete.action?";
	var parameters = "&geLibFileId=" + geLibFileId+"&typeId="+typeId+"&copyPasteFlag=true";		
	$.ajax({
	    type:'POST',
		url: url,
		dataType: 'html',
		data: parameters, 
		success: function(data) {				
			$('#copyPasteDocModalConditionId').val("0");
			$('#copyPasteTypeId').val("");
			$('#copyPasteGeLibFileId').val("");   
			$('.alocDeleteAttachment').empty().append("<p style=\"padding: 10px 0 0 10px;\"><a href='javascript:clearClosureData()'>clear</a></p>");	
    		$(".alocAttachment").hide();
    		$(".linkHideId").hide();
    		$(".copydoc").show();	 										  		   				 
		},
		error: function(xhr, textStatus, errorThrown) { 
        	errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
        	showError(errorMsg);
	    }
	});	
	
};