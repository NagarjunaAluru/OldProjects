function logout() {
	window.location.href = contextURL + "/logout.do?logout";
}
function callMyRequest(productType){
	if(productType == 'CPA'){
		window.location.href = contextURL + "/fundingRequest/newFundingRequestView.do?command=newRequest&productType=CPA";
	}else{
		window.location.href = contextURL + "/fundingRequest/newFundingRequestView.do?command=newRequest";
	}
}
function callPipeline(type) {
	if(type == 'IDAG'){
		window.location.href = contextURL + "/pipelineReview/pipelineReviewView.do?command=executeInbox&source=header";
	}else if(type == 'MO'){
		window.location.href = contextURL + "/pipelineReview/pipelineReviewView.do?command=executeInboxMO&source=header";
	}
	
}
function callDataMaintenance() {
	window.location.href = contextURL + "/admin/admin.do?command=loadStaticData";
}
function callApprovalAccess() {
	window.location.href = contextURL + "/admin/admin.do?command=loadAccessApprovals";
}
function cognosReportsHome(cognosHomeURL){
	var cognosWindow=window.open(cognosHomeURL,"win",  "status=1, toolbar=0,location=0,directories=0, menubar=0,resizable=1");
	if (cognosWindow.focus) {
		cognosWindow.focus();
    }
}

function callSearchForm() {
	window.location.href = contextURL + "/searchResults.do?command=searchForm";
}

function callManageDelagation() {
	window.location.href = contextURL + "/admin/admin.do?command=manageDelegation";
}