$(document).ready(function () {
        $('.alocFileupload').fileupload(
    		{
    			dataType: 'json',
    	        sequentialUploads: true,
    	        method: 'POST',
    	        done: function (e, data) {
    	        	if(varifyResponse(data.result)) {
    	        		var contentToRender = prepareHTMLForFile(data.result);	 
    	        		var contentToRenderForPreview = prepareHTMLForPreviewFile(data.result);
    	        		var renderArea = findRenderAreaForFile();	        	
    	        		var renderPreviewArea = findRenderAreaForPreviewFile();
    	        		if(renderArea) {	        			
    	        			$('#uploadUserAnnouncementModel').modal('hide');		        		
    		        		renderArea.empty().html(contentToRender);	
    		        		renderPreviewArea.empty().html(contentToRenderForPreview);
    	        		}			        		        	
    		        }
    	        },
    	        error: function(xhr, textStatus, errorThrown) {
    	        	var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
    	        	showError(errorMsg);
    		    }
          });
        $('.ttip').tooltip({delay: { show: 300, hide: 1 }});
    	$('.ttip.chart').tooltip();
});  

/**
 * This method is used to popup a window for upload the document
 */
function uploadUserAnnouncementAtmt() {	 		  
	  n = window.open('#uploadUserAnnouncementModel', '_self'); 	 
	  $('#uploadUserAnnouncementModel').modal({		 
		        show: 'true'
		        
	  }); 
	}	


/*
 * Attachment Upload related defects
 */
function varifyResponse(responseData) {
	if(responseData.status == 'userAnnouncement') {	
		return true;
	} else if(responseData.status == 'ERROR' || responseData.status == 'error') {		
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
function findRenderAreaForFile() {	
	var alocAtmtDiv = $(".userAnnouncementAttachment");
	var renderArea = alocAtmtDiv.find(".alocAttachment");	
	return renderArea;
}

/*
 * 
 */
function findRenderAreaForPreviewFile() {	
	var alocAtmtDiv = $(".userAnnouncementAttachmentPreview");
	var renderArea = alocAtmtDiv.find(".alocAttachment");	
	return renderArea;
}


/*
 * 
 */
function prepareHTMLForFile(responseData) {
	var downloadURL = contextURL + "/int/admin/downloadAttachment.action?geLibFileId=" + responseData.attachment.geFileId + "&announcementType=userAnnouncement";
	var fileDiv = " <a href='javascript:void(0)' id=\"previewDeleteIcon\" class=\"deleteIcon\" onclick=\"javascript:deleteUserannouncementAttachment("+responseData.attachment.geFileId+")\"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='" + downloadURL + "' class=\"userDownload\" >"+ responseData.attachment.attachmentOriginalName + "</a>";
	return fileDiv;
}

/*
 * 
 */
function prepareHTMLForPreviewFile(responseData) {
	var downloadURL = contextURL + "/int/admin/downloadAttachment.action?geLibFileId=" + responseData.attachment.geFileId + "&announcementType=userAnnouncement";
	var fileDiv = "<a href='" + downloadURL + "' class=\"userDownload\" >"+ responseData.attachment.attachmentOriginalName + "</a>";
	return fileDiv;
}


/*
 * 
 */
function handleUnknownError(e) {
	showError('Error while performing desired operation ');
}

/*
 * method to throw the attachment related error messages
 */
function showError(responseData) {	
	var errorModal= $('#uploadUserAnnouncementModel');	
    $(errorModal).find('.modal-body P.errorMessage').html(responseData.errorMsg);
    $(errorModal).modal('show');
}

/*
 * 
 */
function deleteUserannouncementAttachment(geLibFileId,index) {	
	n = window.open('#atmtConfirmModal','_self');
	$('#userAnnouncementAtmtGeLibFileId', n.document).val(geLibFileId);		
	$('#userAnnouncementAtmtIndex', n.document).val(index);		
	$('#atmtConfirmModal').modal({		 
	        show: 'true'	        
	 }); 	
  }	


/**
 * 
 */
function deleteAtmtConfirm(){	
var geLibFileId = $('#userAnnouncementAtmtGeLibFileId').val();		
var url = contextURL +"/int/admin/deleteUserAnnouncementAtmt.action?";
var parameters = "&geLibFileId=" + geLibFileId;	
$.ajax({
    type:'POST',
	url: url,
	dataType: 'html',
	data: $('#saveUserAnnouncementFormId').serialize() + parameters, 
	success: function(data) {				
		$("#userannouncementAttachmentId").empty().append(data);	
		$('#uploadUserAnnouncementModel').modal('hide');
	}, 
	 error: function(xhr, textStatus, errorThrown) {
     	 //var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());			        	
     	 showError(data); 
	    }
});	
}