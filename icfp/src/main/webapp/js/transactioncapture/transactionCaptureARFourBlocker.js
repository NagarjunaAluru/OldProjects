function submitFormAtViewLeg(legNumber, productType) {
	var form = document.forms[0];
	var oldPath = form.action;
	var path = oldPath;
	path = path + "?command=viewInputScreens&source=transactionCapture/transactionCaptureARFourBlocker&id=" + legNumber + "&pType=" + productType;
	form.action = path;
	form.submit();
}