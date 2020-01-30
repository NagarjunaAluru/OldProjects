$(document).ready(function () {
		// Register FileUpload
		registerFileUpload();
		
		$('#multiLegAttachmentSubmit').bind('click', function(e) {
			var renderStyle = $('#multiLegAttachmentFile').attr('renderStyle');
			$('#multiLegAttachmentFile').fileupload(
					{
						dataType: 'json',
					    sequentialUploads: true,
					    method: 'POST',
						done: function(e, data) {
							var attachments = fetchAttachments(data.result);
							if(attachments) {
								$.each(attachments, function(index, attachment) {
									var newFileHTML = prepareHTMLForMultiLegFile(attachment);
									var renderArea = findRenderAreaForMultiLegFile(attachment);
									if(renderArea) {
					        			if(renderStyle == 'replace') {
					        				renderArea.html(newFileHTML);
					        			} else {
					        				renderArea.append(newFileHTML);
					        			}
					        			refreshAttachmentCount();
					        		}
								});
							}
						},
					    onError: function(event, files, index, xhr, handler) {
					    	handleUnknownError();
					    }
					}
			);
			$('#multiLegAttachmentFile').trigger('change');
			closeMultiLegAttachmentModal();
		});
	}
);

/*
 * 
 */
function registerFileUpload() {
	$('.icfpFileupload').fileupload(
			{
				dataType: 'json',
		        sequentialUploads: true,
		        method: 'POST',
		        done: function (e, data) {
		        	var attachments = fetchAttachments(data.result);
		        	if(attachments) {
		        		var newFileHTML = prepareHTMLForFile(attachments[0]);
		        		var renderArea = findRenderAreaForFile($(this));
		        		if(renderArea) {
		        			if($(this).attr('renderStyle') == 'replace') {
		        				renderArea.html(newFileHTML);
		        			} else {
		        				renderArea.append(newFileHTML);
		        			}
		        			refreshAttachmentCount();
		        		}
		        	}
		        },
		        onError: function(event, files, index, xhr, handler) {
		        	alert('In Error Section');
		        	handleUnknownError();
			    }
	    }
	);
}


/*
 * 
 */
function deleteAttachment(geLibFileId, evt) {
	var agree=confirm("Are you sure want to delete this attachment?");
	if (agree) {
	var event = evt || window.event;
	var target = event.target || event.srcElement;
	var ajaxGetrequest = new getXmlHttpObject();
	var url = contextURL +"/attachmentAction.do?command=delete";
	var parameters = "&geLibFileId=" + geLibFileId;
	url += parameters;
	ajaxGetrequest.open("GET", url, false);
	ajaxGetrequest.onreadystatechange = function() {
		if(ajaxGetrequest.readyState==4 && ajaxGetrequest.status==200){
			var responseObj = JSON.parse(ajaxGetrequest.responseText);
			var attachment = fetchAttachments(responseObj);
			if(attachment) {
				$(target).parents(".icfpAttachment").remove();
				refreshAttachmentCount();
			}
		} 
	};
	ajaxGetrequest.send();
	} else {
		return false;
	}
}


/*
 * 
 */
function showMultiLegAttachmentModal(type, evt) {
	var event = evt || window.event;
	var target = event.target || event.srcElement;
	var multiLegAttachmentModal = $('#multiLegAttachmentModal');
	
	// Setting Attachment type name to modal before displaying
	var attachmentTypeName = $(target).parents('tr').find('.attachmentTypeName');
	$(multiLegAttachmentModal).find('.attachmentTypeName').each(
			function(index, element) {
				$(element).html(attachmentTypeName.text());
			}
		);
	
	// Set attributes for fileupload
	var fileInputField = $(multiLegAttachmentModal).find('#multiLegAttachmentFile');
	
	var url = contextURL + "/attachmentAction.do?command=upload" + "&type=" + type;
	$(fileInputField).attr('data-url', url);
	
	$(fileInputField).attr('renderStyle', $(target).attr('renderStyle'));

	$(multiLegAttachmentModal).modal('show');
}


/*
 * 
 */
function closeMultiLegAttachmentModal() {
	var multiLegAttachmentModal = $('#multiLegAttachmentModal');
	
	// Uncheck all checkboxes
	$(multiLegAttachmentModal).find('input[type=checkbox]:checked').each(
			function(index, element) {
				$(element).removeAttr('checked');
			}
	);
	
	// Clear content of file field
	var fileInput = $(multiLegAttachmentModal).find('input[type=file][name=attachmentFile]');
	if ($.browser.msie) {
		$(fileInput).replaceWith($(fileInput).clone());
	} else {
		$(fileInput).val('');
	}
	
	$(multiLegAttachmentModal).modal('hide');
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
function fetchAttachments(responseObj) {
	if(responseObj.status == 'SUCCESS') {
		return responseObj.attachments;
	} else if(responseObj.status == 'FAILURE'){
		showError(responseObj.errorMessage);
	} else {
		handleUnknownError();
	}
	return null;
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
function prepareHTMLForFile(attachment) {
	var fileDiv = "<div class='icfpAttachment'>";
	fileDiv += "<a href='javascript:void(0)' class='attachment-del-link' onclick='javascript:deleteAttachment(\"" + attachment.geLibFileId + "\")'>";
	fileDiv += "<img src='" + contextURL + "/img/delete.gif' border='0' onclick='setChangedFlag()' align='absmiddle'>";
	fileDiv += "</a>&nbsp;";
	fileDiv += "<a href='" + contextURL + "/attachmentAction.do?command=download&geLibFileId=" + attachment.geLibFileId + "' class='attachment-link'>";
	fileDiv += attachment.name + "</a>";
	fileDiv += "</div>";
	return fileDiv;
}

/*
 * 
 */
function prepareHTMLForMultiLegFile(attachment) {
	var fileDiv = "<div class='icfpAttachment'>";
	fileDiv += "<a href='javascript:void(0)' class='attachment-del-link' onclick='javascript:deleteAttachment(\"" + attachment.geLibFileId + "\")'>";
	fileDiv += "<img src='" + contextURL + "/img/delete.gif' border='0' onclick='setChangedFlag()' align='absmiddle'>";
	fileDiv += "</a>&nbsp;";
	fileDiv += 'Leg ' + attachment.legSeqId + ' - ';
	fileDiv += "<a href='" + contextURL + "/attachmentAction.do?command=download&geLibFileId=" + attachment.geLibFileId + "' class='attachment-link'>";
	fileDiv += attachment.name + "</a>";
	fileDiv += "</div>";
	return fileDiv;
}


/*
 * 
 */
function findRenderAreaForFile(target) {
	var parentTR = target.parents("tr");
	var renderArea = parentTR.find(".icfpAttachmentArea");
	return renderArea;
}


/*
 * 
 */
function findRenderAreaForMultiLegFile(attachment) {
	var attachmentTypeArea = $('#icfpMultiLegAttachmentArea' + attachment.typeId);
	var legAreaId = '#icfpLegAttachmentArea' + attachment.legIndex;
	var attachmentLegArea = $(attachmentTypeArea).find(legAreaId);
	return attachmentLegArea;
}

/*
 * 
 */
function showError(msg) {
	var errorModal = $('#attachmentErrorModal');
	$(errorModal).find('.modal-body P').html(msg);
	$(errorModal).modal('show');
}

/*
 * 
 */
function closeErrorModal() {
	var errorModal = $('#attachmentErrorModal');
	$(errorModal).modal('hide');
}

/*
 * 
 */
function refreshAttachmentCount() {
	var countSpan = $('#icfpAttachmentCount');
	if(countSpan) {
		var url = $(countSpan).attr('refreshURL');
		var ajaxGetrequest = new getXmlHttpObject();
		ajaxGetrequest.open("GET", url, false);
		ajaxGetrequest.onreadystatechange = function() {
			if(ajaxGetrequest.readyState==4 && ajaxGetrequest.status==200){
				var responseObj = JSON.parse(ajaxGetrequest.responseText);
				if(responseObj.status == 'SUCCESS') {
					$(countSpan).html(responseObj.attachmentCount);
				}
			} 
		};
		ajaxGetrequest.send();
	}
}
