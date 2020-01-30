
    var $E = YAHOO.util.Event;
    
    function setChangedFlag(){
    	isChanged=false;
    } 
    
    
    
    function initUpload1() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Cash Map";
    		
    		var filePath= formObj.documentName1.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
    			return false;
    		} 
    		var realPath = formObj.real1.value;
    		if(realPath=='' && filePath!='') {
    			alert("Please select file for Attachment");
    			return false;
    		}
    		
    		
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName1.value='';
    				formObj.real1.value='';
    				u = document.getElementById('field1');
    				u.innerHTML="<input type='file' class='file' id='documentName1' name='documentName1' onchange='ajax_res_table1()' />";
    		
    				if(o.responseText =='File Already Exist, please upload another file') {
                        alert(o.responseText);
                    else{
        				document.getElementById("Cash_Map").style.display = 'block';
        				document.getElementById("Cash_Map").innerHTML  =  o.responseText;
    				}
    			}
    		};
    	
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO1&showType=RowList&attachmentTypeValue='+attachmentTypeValue, uploadHandler);

    	};
    	$E.on('uploadButton1', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload1);
    
    
    function initUpload2() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Structured Diagram";
    		
    		var filePath= formObj.documentName2.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
    			return false;
    		} 
    		var realPath = formObj.real2.value;
    		if(realPath=='' && filePath!='') {
    			alert("Please select file for Attachment");
    			return false;
    		}
    		
    		
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName2.value='';
    				formObj.real2.value='';
    				u = document.getElementById('field2');
    				u.innerHTML="<input type='file' class='file' id='documentName2' name='documentName2' onchange='ajax_res_table2()' />";
    		
    				if(o.responseText =='File Already Exist, please upload another file') {
                        alert(o.responseText);
                    }else{
    				    document.getElementById("Structured_Diagram").style.display = 'block';
    				    document.getElementById("Structured_Diagram").innerHTML  =  o.responseText;
    				}
    			}
    		};
    	
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO2&showType=RowList&attachmentTypeValue='+attachmentTypeValue, uploadHandler);

    	};
    	$E.on('uploadButton2', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload2);
    
    
    function initUpload3() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Legal Agreements";
    		u1 = document.getElementById('errorPopup1');
    		var filePath= formObj.documentName3.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
				u1.innerHTML="Please select file for Attachment";
				return false;


    		} 
    		
    		
    			var len=formObj.optionsRadios.length;
    			var selectedLeg="";
    			var allLegs="";
    			for(var j=0;j<len;j++) {
    			if(formObj.optionsRadios[j].checked==true) {
    				selectedLeg = formObj.optionsRadios[j].value;
    				allLegs = allLegs +","+selectedLeg;
    			}
    			}
    			if(selectedLeg=='') {
    				alert("Please select leg for Attachment");
    				var u2 = u1.innerHTML;
    				u1.innerHTML=u2+"<BR/>Please select leg for Attachment";
    				allLegs="";
    				return false;

    			}
    			//}
    			
    			if(u1.innerHTML=="") {
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName3.value='';
    				u = document.getElementById('field3');
    				u.innerHTML="<input type='file' id='documentName3' name='documentName3'  class='input-file3'  />";
    		
    				if(o.responseText=='File Already Exist, please upload another file') {
    					alert(o.responseText);
    				} else {
    					
    				document.getElementById("Legal_Agreements").style.display = 'block';
    				document.getElementById("Legal_Agreements").innerHTML  =  o.responseText;
    				for(var j=0;j<len;j++) {
        				if(formObj.optionsRadios[j].checked==true) {
        					formObj.optionsRadios[j].checked=false;
            			}
        				}
    				}
    			}
    		};
    			}
    			if(u1.innerHTML=="") {
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO3&showType=TableList&attachmentTypeValue='+attachmentTypeValue+"&selectedLeg="+selectedLeg, uploadHandler);
    		}

    	};
    	$E.on('saveLegalAttachment', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload3);
    

    function initUpload4() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Consolidated Financial Statements";
    		u1 = document.getElementById('errorPopup2');
    		var filePath= formObj.documentName4.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
				u1.innerHTML="Please select file for Attachment";
				return false;


    		} 
    		
    		
    			var len=formObj.optionsRadios.length;
    			var selectedLeg="";
    			var allLegs="";
    			for(var j=0;j<len;j++) {
    			if(formObj.optionsRadios[j].checked==true) {
    				selectedLeg = formObj.optionsRadios[j].value;
    				allLegs = allLegs +","+selectedLeg;
    			}
    			}

    			if(selectedLeg=='') {
    				alert("Please select leg for Attachment");
    				var u2 = u1.innerHTML;
    				u1.innerHTML=u2+"<BR/>Please select leg for Attachment";
    				allLegs="";
    				return false;

    			}
    			
    			if(u1.innerHTML=="") {
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName4.value='';
    				u = document.getElementById('field4');
    				u.innerHTML="<input type='file' id='documentName4' name='documentName4'  class='input-file4'  />";
    		
    				if(o.responseText!='File Already Exist, please upload another file') {    					
    					
    				document.getElementById("Consolidated_Financial_Statements").style.display = 'block';
    				document.getElementById("Consolidated_Financial_Statements").innerHTML  =  o.responseText;
    				for(var j=0;j<len;j++) {
        				if(formObj.optionsRadios[j].checked==true) {
        					formObj.optionsRadios[j].checked=false;
            			}
        				}
    				}
    			}
    		};
    			}
    			if(u1.innerHTML=="") {
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO4&showType=TableList&attachmentTypeValue='+attachmentTypeValue+"&selectedLeg="+selectedLeg, uploadHandler);
    		}

    	};
    	$E.on('saveConsolidatedAttachment', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload4);
    
    
    function initUpload5() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Corporate Governance Documents";
    		u1 = document.getElementById('errorPopup3');
    		var filePath= formObj.documentName5.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
				u1.innerHTML="Please select file for Attachment";
				return false;


    		} 
    		
    		
    			var len=formObj.optionsRadios.length;
    			var selectedLeg="";
    			var allLegs="";
    			for(var j=0;j<len;j++) {
    			if(formObj.optionsRadios[j].checked==true) {
    				selectedLeg = formObj.optionsRadios[j].value;
    				allLegs = allLegs +","+selectedLeg;
    			}
    			}
    			if(selectedLeg=='') {
    				alert("Please select leg for Attachment");
    				var u2 = u1.innerHTML;
    				u1.innerHTML=u2+"<BR/>Please select leg for Attachment";
    				allLegs="";
    				return false;

    			}
    			
    			if(u1.innerHTML=="") {
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName5.value='';
    				u = document.getElementById('field5');
    				u.innerHTML="<input type='file' id='documentName5' name='documentName5'  class='input-file5'  />";
    		
    				if(o.responseText=='File Already Exist, please upload another file') {
    					alert(o.responseText);
    				} else {    					
    				document.getElementById("Corporate_Governance_Documents").style.display = 'block';
    				document.getElementById("Corporate_Governance_Documents").innerHTML  =  o.responseText;
    				for(var j=0;j<len;j++) {
        				if(formObj.optionsRadios[j].checked==true) {
        					formObj.optionsRadios[j].checked=false;
            			}
        				}
    				}
    			}
    		};
    			}
    			if(u1.innerHTML=="") {
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO5&showType=TableList&attachmentTypeValue='+attachmentTypeValue+"&selectedLeg="+selectedLeg, uploadHandler);
    		}

    	};
    	$E.on('saveCorporateAttachment', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload5);
    
    
    
    function initUpload6() {
    	formName = YAHOO.util.Dom.get("formName").value;
    	formObj = document.getElementById(formName);
    	var $  = YAHOO.util.Dom.get;
    	var $D = YAHOO.util.Dom;
    	var onUploadButtonClick = function(e) {
    		var attachmentTypeValue= "Other Documents";
    		u1 = document.getElementById('errorPopup4');
    		var filePath= formObj.documentName6.value;
    		if(filePath=='') {
    			alert("Please select file for Attachment");
				u1.innerHTML="Please select file for Attachment";
				return false;

    		} 
    		
    		
    			var len=formObj.optionsRadios.length;
    			var selectedLeg="";
    			var allLegs="";
    			for(var j=0;j<len;j++) {
    			if(formObj.optionsRadios[j].checked==true) {
    				selectedLeg = formObj.optionsRadios[j].value;
    				allLegs = allLegs +","+selectedLeg;
    			}
    			}
    			if(selectedLeg=='') {
    				alert("Please select leg for Attachment");
    				var u2 = u1.innerHTML;
    				u1.innerHTML=u2+"<BR/>Please select leg for Attachment";
    				allLegs="";
    				return false;
    			}
    			
    			if(u1.innerHTML=="") {
    		var uploadHandler = {
    			upload: function(o) {
    				formObj.documentName6.value='';
    				u = document.getElementById('field6');
    				u.innerHTML="<input type='file' id='documentName6' name='documentName6'  class='input-file6'  />";
    		
    				if(o.responseText=='File Already Exist, please upload another file') {
    					alert(o.responseText);
    				} else {
    					
    				document.getElementById("Other_Documents").style.display = 'block';
    				document.getElementById("Other_Documents").innerHTML  =  o.responseText;
    				for(var j=0;j<len;j++) {
    				if(formObj.optionsRadios[j].checked==true) {
    					formObj.optionsRadios[j].checked=false;
        			}
    				}
    				
    				}
    			}
    		};
    			}
    			if(u1.innerHTML=="") {
    		YAHOO.util.Connect.setForm(formObj, true);
    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO6&showType=TableList&attachmentTypeValue='+attachmentTypeValue+"&selectedLeg="+selectedLeg, uploadHandler);
    		}

    	};
    	$E.on('otherDocuments', 'click', onUploadButtonClick);
    	
    }

    $E.on(window, 'load', initUpload6);
    
    
  
    
    function clearCacheAttachment()
    {
    	$('#documentName')[0].value='';
    }

    
    function ajax_res_table()
    {
     var e1 = document.getElementById('documentName');
     var e2 = document.getElementById('real');
     e2.value = e1.value;
    }

    function ajax_res_table1()
    {
     var e1 = document.getElementById('documentName1');
     var e2 = document.getElementById('real1');
     e2.value = e1.value;
    }

    function ajax_res_table2()
    {
     var e1 = document.getElementById('documentName2');
     var e2 = document.getElementById('real2');
     e2.value = e1.value;
    }

    function ajax_res_table3()
    {
     var e1 = document.getElementById('documentName3');
     var e2 = document.getElementById('real3');
     e2.value = e1.value;
    }

    function ajax_res_table4()
    {
     var e1 = document.getElementById('documentName4');
     var e2 = document.getElementById('real4');
     e2.value = e1.value;
    }
    
    function ajax_res_table5()
    {
     var e1 = document.getElementById('documentName5');
     var e2 = document.getElementById('real5');
     e2.value = e1.value;
    }
    function ajax_res_table6()
    {
     var e1 = document.getElementById('documentName6');
     var e2 = document.getElementById('real6');
     e2.value = e1.value;
    }


    function ajaxTableDeleteFunction(divArea,key,filePath) {
    	filePath = filePath.ReplaceAll("~^", " ");
    	isChanged = false;
        var ran = Math.random();
        url = contextURL +"/fundingRequest/newFundingRequestView.do?command=deleteAttachment&filePath="+filePath+"&key="+key+"&divArea="+divArea+"&random="+ran;
        if (window.XMLHttpRequest) {
    		req = new XMLHttpRequest();
    		req.onreadystatechange = reportStatus;
    		try {
    			req.open("GET", url, false);
    		} catch (e) {
    			alert(e);
    			uploading = false;
    		}
    		req.send();
    	} else if (window.ActiveXObject) {
    		req = new ActiveXObject("Microsoft.XMLHTTP");
    	
    		if (req) {
    			req.onreadystatechange = reportStatus;
    			req.open("GET", url, false);
    			req.send();
    		} else {
    			uploading = false;
    		}
    	}
     }

    function reportStatus() {
    	if (req.readyState == 4) {
    		if (req.status == 200) {
    			
    			var str = req.responseText;
    			responsearr = str.split("#$#");
    			var divArea = responsearr[0];
    			var strHTML = responsearr[1];
    			document.getElementById(divArea).style.display = 'block';
    			document.getElementById(divArea).innerHTML  =  strHTML;
    		    			
    		
    	}
    }
    }
    
    String.prototype.ReplaceAll = function(stringToFind,stringToReplace){
        var temp = this;
        var index = temp.indexOf(stringToFind);
            while(index != -1){
                temp = temp.replace(stringToFind,stringToReplace);
                index = temp.indexOf(stringToFind);
            }
            return temp;
       };
       function fileDownloadFunctionNew(url){
    	  // alert(url);
    	   isChanged = false;
    	   window.open(url,'fileDownload','height=100,width=100');
       }
       
       
       

   	
   	
   	function fileUploader1(){
   		function uploader1(){		
   			var file = $(this).val();
   				//alert("file selected"+file)
   				formName = YAHOO.util.Dom.get("formName").value;
   				formObj = document.getElementById(formName);
   				attachmentTypeValue ="Cash Map";
   				var uploadHandler = {
   	    			upload: function(o) {
   	    				u = document.getElementById('field1');
   	    				u.innerHTML="<input type='file' id='documentName1' name='documentName1' class='input-file1' />"; 
   	    				if(o.responseText=='File Already Exist, please upload another file') {
   	    					alert(o.responseText);
   	    				} else {
   	    				document.getElementById("Cash_Map").style.display = 'block';
   	    				document.getElementById("Cash_Map").innerHTML  =  o.responseText;
   	    				formObj.documentName1.value='';
   	    				$('#documentName1').value='';
   	    				fileUploader1()
   	    				}
   	    			}
   	    		};
   	    	
   	    		YAHOO.util.Connect.setForm(formObj, true);
   	    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO1&showType=RowList&attachmentTypeValue='+attachmentTypeValue+"&sid="+Math.random(), uploadHandler);
   	    		$('#documentName1').value='';
   	    		
   		}; 
   		$(".input-file1").change(uploader1)
   	}
   	
   	
   	fileUploader1()
   	
   	function fileUploader3(){
   		function uploader3(){		
   			var file = $(this).val();
   				formName = YAHOO.util.Dom.get("formName").value;
   				formObj = document.getElementById(formName);
   				attachmentTypeValue ="Exceptions Type";
   				var uploadHandler = {
   	    			upload: function(o) {
   	    				u = document.getElementById('field1');
   	    				u.innerHTML="<input type='file' id='documentName1' name='documentName1' class='input-fileE' />"; 
   	    				if(o.responseText=='File Already Exist, please upload another file') {
   	    					alert(o.responseText);
   	    				} else {
   	    				document.getElementById("Exceptions_Type").style.display = 'block';
   	    				document.getElementById("Exceptions_Type").innerHTML  =  o.responseText;
   	    				formObj.documentName1.value='';
   	    				$('#documentName1').value='';
   	    				fileUploader3()
   	    				}
   	    			}
   	    		};
   	    	
   	    		YAHOO.util.Connect.setForm(formObj, true);
   	    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO1&showType=RowList&attachmentTypeValue='+attachmentTypeValue+"&sid="+Math.random(), uploadHandler);
   	    		$('#documentName1').value='';
   	    		
   		}; 
   		$(".input-fileE").change(uploader3)
   	}
   	
   	
   	fileUploader3()
   	
   	
   	function fileUploader2(){
   		function uploader2(){		
   			var file = $(this).val();
   				formName = YAHOO.util.Dom.get("formName").value;
   				formObj = document.getElementById(formName);
   				attachmentTypeValue= "Structured Diagram";
   				var uploadHandler = {
   	    			upload: function(o) {
   	    				u = document.getElementById('field2');
   	    				u.innerHTML="<input type='file' id='documentName2' name='documentName2' class='input-file2' />"; 
   	    				if(o.responseText=='File Already Exist, please upload another file') {
   	    					alert(o.responseText);
   	    				} else {
   	    					document.getElementById("Structured_Diagram").style.display = 'block';
   	        				document.getElementById("Structured_Diagram").innerHTML  =  o.responseText;
   	    				formObj.documentName2.value='';
   	    				$('#documentName2').value='';
   	    				fileUploader2()
   	    				}
   	    			}
   	    		};
   	    	
   	    		YAHOO.util.Connect.setForm(formObj, true);
   	    		YAHOO.util.Connect.asyncRequest('POST', contextURL +'/attachmentAction.do?command=saveUpload&type=typeForm&voObject=attachmentVO2&showType=RowList&attachmentTypeValue='+attachmentTypeValue+"&sid="+Math.random(), uploadHandler);
   	    		$('#documentName2').value='';
   	    		
   		}; 
   		$(".input-file2").change(uploader2)
   	}
   	
   	
   	fileUploader2()
   	