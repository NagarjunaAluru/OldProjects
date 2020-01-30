registerStandardTinyMCE('formatReadOnly');
registerStandardTinyMCE('standardFormatReadOnlyView');
registerStandardTinyMCE('modifiedFormatReadOnlyView');
registerStandardTinyMCE('standardFormatTextArea'); 
registerTinyMCE('modifiedFormatTextArea'); 
function synchTinyMce(){
	var elementId ="";
	var formatType = $('#pole2').val();
	if(formatType==1){
		elementId = "standardFormatTextArea";
		tinymce.get(elementId).save();
	}
	if(formatType==2)	{
		elementId = "modifiedFormatTextArea";
		tinymce.get(elementId).save(); 
	}		
}
