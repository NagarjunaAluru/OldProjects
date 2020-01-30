$(document).ready(function() {
	$('#saveChanges').click(function() {
		manageRolesForm.action = manageRolesForm.action+"?command=saveDelegation";
		manageRolesForm.submit();
	});
	$('#adminSaveChanges').click(function() {
		manageRolesForm.action = manageRolesForm.action+"?command=saveDelegation&canDelegate=Y";
		manageRolesForm.submit();
	});
});
function revokeRole(userDelegateId) {
	manageRolesForm.action = manageRolesForm.action
			+ "?command=revokeDelegation&userDelegateId=" + userDelegateId;
	manageRolesForm.submit();
}

function adminRevokeRole(userDelegateId) {
	manageRolesForm.action = manageRolesForm.action
			+ "?command=revokeDelegation&canDelegate=Y&userDelegateId=" + userDelegateId;
	manageRolesForm.submit();
}

function showEditableFields(count) {
	$('#currentDelegateRO' + count).hide();
	$('#currentDelegate' + count).show();
	$('#delegateTimeFrameRO' + count).hide();
	$('#delegateTimeFrame' + count).show();
}
function populateDelegateNames(count) {
	var a = $('#delegateSSO' + count).children("option").filter(":selected")
			.text();
	var name = a.split(",");
	$('#delegateLastName' + count).val(name[0]);
	$('#delegateFirstName' + count).val(name[1]);
}
