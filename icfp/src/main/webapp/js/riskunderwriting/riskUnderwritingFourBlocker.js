function submitFormAtViewLeg(legNumber, productType) {
	var form = document.forms[0];
	var oldPath = form.action;
	var path = oldPath;
	path = path + "?command=viewInputScreens&source=riskUnderwriting/riskUnderwriting&id=" + legNumber + "&pType=" + productType;
	form.action = path;
	form.submit();
}

$(document).ready(function() {
	if($("#riskReviewOverviewNeededErrorBar input:radio:checked").val() == '1') {
		$("#revisedTransactionClassificationLevelDiv").show();
	}
});