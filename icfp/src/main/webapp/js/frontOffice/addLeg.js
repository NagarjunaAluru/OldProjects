function addDerivative(){
		var legRequestForm = document.getElementById('ICFPLegRequestForm');
		action = legRequestForm.action;
		action = action + '?command=addDerivatives';
		legRequestForm.action = action;
		legRequestForm.submit();
	}
	function displayResult(x)
	{
	x.rowIndex/3;
	}