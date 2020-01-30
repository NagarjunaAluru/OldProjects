<%@taglib tagdir="/WEB-INF/tags" prefix="tc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>

<div class="form-mod">
	<h2 class="span12 collapsible">Closing Checklist</h2>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<span class="required">*</span> <label>Has any change taken
					place post approvals?</label>
				<div class="radio-container conditional-radio material-conditional">
					<label class="radio"> 
					<c:choose>
					<c:when test="${updateStatusForm.map.changeAfterApprovalFlag eq '1'}">
					<input type="radio" value="1" name="changeAfterApprovalFlag" class="condition change-submitbox" checked="checked"/> Yes
					</c:when>
					<c:otherwise>
					<input type="radio" value="1" name="changeAfterApprovalFlag" class="condition change-submitbox"/> Yes
					</c:otherwise>
					</c:choose>
					
					</label>
					<div class="conditional-container material-comments">
						<div class="form-row autosize-container">
							<span class="required">*</span> <label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput"
								name="changeTypeComments" rows="1" onblur="scriptInjection(this);">${updateStatusForm.map.changeTypeComments}</textarea>
							
							 <span class="req-error" id="changeTypeCommentsError">error</span>
							<!-- <span class='req-error' style="display: none;" id="changeTypeCommentsError">error</span> -->
						</div>
					</div>
					<div class="conditional-container material-immaterial">
						
						<div class="form-row">
							<span class="required">*</span> 
							<label>Are the changes Material or Immaterial? </label>
							<div class="radio-container conditional-radio material-conditional">
								<label class="radio"> 
								<c:choose>
								<c:when test="${updateStatusForm.map.changeTypeId eq '1'}">
								<input type="radio" value="1" name="changeTypeId" class="change-submitbox" checked="checked"/> Material
								</c:when>
								<c:otherwise>
								<input type="radio" value="1" name="changeTypeId" class="condition change-submitbox"/> Material
								</c:otherwise>
								</c:choose>
								</label> 
								
								<label class="radio"> 
								<c:choose>
								<c:when test="${updateStatusForm.map.changeTypeId eq '2'}">
								<input type="radio" value="2" name="changeTypeId" checked="checked"/> Immaterial
								</c:when>
								<c:otherwise>
								<input type="radio" value="2" name="changeTypeId"/> Immaterial
								</c:otherwise>
								</c:choose>
								</label>
							</div>
						</div>
					</div>
					<label class="radio"> 
					<c:choose>
					<c:when test="${updateStatusForm.map.changeAfterApprovalFlag eq '0'}">
					<input type="radio" value="0" name="changeAfterApprovalFlag" checked="checked"/> No
					</c:when>
					<c:otherwise>
					<input type="radio" value="0" name="changeAfterApprovalFlag"/> No
					</c:otherwise>
					</c:choose>
					</label>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<table
				class="table table-striped table-bordered no-bottom closing-checklist material-condition">
				<thead>
					<tr>
						<th class="header nosort" colspan="3">Certification<span class="ttip info" data-original-title="<bean:message key="label.fourBlocker.closingCheckList" />"></span></th>
						<th class="header nosort" rowspan="2" style="width: 316px;">Transactions Details</th>
						<th class="header nosort" rowspan="2">Comments</th>
					</tr>
					<tr>
						<th class="header colhead nosort" >Yes</th>
						<th class="header colhead nosort" >No</th>
						<th class="header colhead nosort" >Not Applicable</th>
					</tr>
				</thead>
			</table>
			<c:set var="certificateList" value="${staticdata:getCertificateList(pageContext)}" />
			<c:set var="closingCheckListMap" value="${deal:getClosingRequestMap(pageContext.request)}"/>
			<div style="overflow-y: auto; height: 360px;" class="material-condition closing-checklist">
			<table class="table table-striped table-bordered no-bottom closing-checklist material-condition">
				<tbody>
					<tr>
						<td colspan="5" class="exprow"><b>Transaction Description</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="10" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="20" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="25" certificateList="${certificateList}" 
							closingCheckListMap="${closingCheckListMap}" showError="${requestScope.isStructureDiagramMissing}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Underwriting</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="26" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="27" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="28" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Cash Operations</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios certificateList="${certificateList}" index="29" closingCheckListMap="${closingCheckListMap}" showError="${requestScope.isCashMapMissing}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="30" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Accounting/Controllership</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="0" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}" showError="${requestScope.isJournalMissing}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="1" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="2" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="3" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Legal/Corporate Governance (Debt)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="4" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}" showError="${requestScope.isLegalAgreeMissing}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="5" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="6" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="7" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="8" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios certificateList="${certificateList}" index="9" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios certificateList="${certificateList}" index="11" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios certificateList="${certificateList}" index="12" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Legal/Corporate Governance (Equity)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="13" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="14" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="15" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Legal/Corporate Governance (Internal Approvals)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="16" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="17" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="5" class="exprow"><b>Corporate Governance Documents</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="18" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}" showError="${requestScope.isCorporateGoveranceMissing}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="19" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="21" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="22" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="23" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="24" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr> 
				</tbody>
			</table>
			</div>
		</div>
	</div>
</div>
