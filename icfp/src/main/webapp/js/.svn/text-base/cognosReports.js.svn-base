var childWindow = null;
try {
  var objXHR = new XMLHttpRequest();
} catch (e) {
try {
  var objXHR = new ActiveXObject('Msxml2.XMLHTTP');
} catch (e) {
try {
  var objXHR = new ActiveXObject('Microsoft.XMLHTTP');
} catch (e) {
  alert('XMLHttpRequest not supported'); }
}
}
var isIE8 = window.XDomainRequest ? true : false;
if (isIE8){
  var objXDR = new window.XDomainRequest();
}
function doLogon()
{
	childWindow=window.open("http://tre-cognos.treasury.corp.ge.com:9300/p2pd/servlet/dispatch" +"?b_action=xts.run&m=portal/close.xts&h_CAM_action=logonAs&CAMNamespace=CorporateAD","win",  "status=1, toolbar=0, menubar=0, height=480 width=640, resizeable=1" );
}
function doLogoff()
{
	window.open("http://tre-cognos.treasury.corp.ge.com:9300/p2pd/servlet/dispatch" + "?b_action=xts.run&m=portal/logoff.xts","win",  "status=1, toolbar=0, menubar=0, height=480 width=640, resizeable=1" );
}

function doReport()
{
	var isIE8 = window.XDomainRequest ? true : false;
    var reportSearchPathCMStest1 = "/content/folder[@name='CMS Testing']/report[@name='CMSTest1']";
	var gatewayURL = "http://tre-cognos.treasury.corp.ge.com:9300/p2pd/servlet/dispatch";
	var version = "LATEST";


	var url = gatewayURL + "/rds/reportData/searchPath" + reportSearchPathCMStest1 + "?fmt=HTMLFragment" + "&version=" + version;

	window.status = "Loading Report. Please wait....";
	var frag = document.getElementById("fragment");
	frag.innerHTML= "<HTML><BODY>Loading Report. Please wait....</BODY></HTML>";
	try
	{	
		if (isIE8){
			objXDR.onload = successMethod;
			objXDR.onerror = errorMethod;
			objXDR.onprogress = function() {};
			objXDR.open("GET", url);
			objXDR.send();
		}else{	
			objXHR.open("GET", url, true);
			objXHR.withCredentials = "true";
			objXHR.onreadystatechange = callBack;
			objXHR.send(null);
		}
	}
	catch (e)
	{
		alert("in try"+e);
	}
}
function successMethod(){
	var frag = document.getElementById("fragment");
	frag.innerHTML = objXDR.responseText;
	window.status = "Done";	
}
function errorMethod(){
	var frag = document.getElementById("fragment");
	frag.innerHTML= "<HTML><BODY>Waiting for authentication...</BODY></HTML>";
	doLogon();
	setTimeout('checkLoginStatus()', 10000);	
}
function callBack()
{
	if (objXHR.readyState == 4)
	{
		if (objXHR.status == 200)
		{
			var frag = document.getElementById("fragment");
			frag.innerHTML = objXHR.responseText;
			window.status = "Done";
		}
		else if (objXHR.status == 403)
		{
			var frag = document.getElementById("fragment");
			frag.innerHTML= "<HTML><BODY>Waiting for authentication...</BODY></HTML>";
			doLogon();
			setTimeout('checkLoginStatus()', 10000);
		}
		else
		{
			var frag = document.getElementById("fragment");
			frag.innerHTML = objXHR.responseText;
			alert("HTTP ERROR " + objXHR.status + ": " + objXHR.statusText);
			window.status = "Done";
		}
	}
}
function checkLoginStatus()
{
	if (!childWindow.closed)
		setTimeout('checkLoginStatus()', 10000);
	else
		doReport();
}
