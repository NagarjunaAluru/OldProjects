<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<label><s:text name="label.request.bankBranch" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.name" />
						<br />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address[0]" />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address[1]" />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address[2]" />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.city" />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.stateProvince" />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.country" />
					</p>
		
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<label><s:text name="label.request.bankIdentifierCode" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.proposedBankBranchConfirmDetails.bankIdentifierCode" />
					</p>
				</div>
			</div>
		</div>
			<div class="clear"></div>
			<s:if test="%{requestDetails.bundleDetails.bundleId != null && requestDetails.bundleDetails.bundleId!=''}">
				<div class="row highlighted">
				<div class="span12">
					<p style="padding:10px;"><s:text name="label.request.validtransaction" />&nbsp; <s:property
								value="requestDetails.bundleDetails.bundleId" /></p>
				</div>
			 </div>
		  </s:if> 
		
		
		
		
		
		
