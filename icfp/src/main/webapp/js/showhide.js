function divHideShow(divToHideOrShow) 
{
	var div = document.getElementById(divToHideOrShow);
	
	if (div.style.display == "block") 
	{
		div.style.display = "block";
    }
	else 
	{
		div.style.display = "block";
    }
	      
} 
function setData()
{
	document.forms[0].elements("expDealName").value = document.forms[0].elements("dealName").value;
	document.forms[0].elements("expDealRationale").value = document.forms[0].elements("dealRationale").value;
	document.forms[0].elements("expDealCategoryID").value = document.forms[0].elements("dealCategoryID").value;
		
}
function divShowHide(divToHideOrShow) 
{
	var div = document.getElementById(divToHideOrShow);
	
	if (div.style.display == "block") 
	{
		div.style.display = "none";
    }
	else 
	{
		div.style.display = "none";
    }
	      
} 

function divHideShowHide(divToHideOrShow) 
{
	var div = document.getElementById(divToHideOrShow);
	
	if (div.style.display == "none") 
	{
		div.style.display = "block";
    }
	else 
	{
		div.style.display = "none";
    }
	      
} 