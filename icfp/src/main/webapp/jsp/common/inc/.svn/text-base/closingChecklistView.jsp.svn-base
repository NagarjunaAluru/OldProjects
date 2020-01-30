<%@taglib tagdir="/WEB-INF/tags" prefix="tc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>

<div class="form-mod">
			<h2 class="span12 collapsible">Closing Checklist</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Has any change taken place post approvals?</b><br>
						${deal:getChangeAfterApprovalFlag(pageContext.request)}
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Are the changes Material or Immaterial? </b><br>
						<c:if test="${empty sessionScope.deal.changeTypeId}">
							--
						</c:if>
						<c:if test="${not empty sessionScope.deal.changeTypeId}">
							<c:if test="${sessionScope.deal.changeTypeId eq 1}">
								Material
							</c:if>
							<c:if test="${sessionScope.deal.changeTypeId eq 2}">
								Immaterial
							</c:if>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<c:set var="certificateList" value="${staticdata:getCertificateList(pageContext)}" />
			<c:set var="closingCheckListMap" value="${deal:getClosingRequestMap(pageContext.request)}"/>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered no-bottom closing-checklist">
					<thead>
					  <tr>
						<th class="header" >Certification<span class="ttip info" data-original-title="<bean:message key="label.fourBlocker.closingCheckList" />"></span></th>
						<th class="header" >Transactions Details</th>
						<th class="header">Comments</th>
					  </tr>
					</thead>
					<tbody>
					<tr>
						<td colspan="4" class="exprow"><b>Transaction Description</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="10" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="20" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="25" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Underwriting</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="26" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="27" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="28" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Cash Operations</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="29" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="30" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Accounting/Controllership</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="0" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="1" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="2" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="3" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Legal/Corporate Goverance (Debt)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="4" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="5" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="6" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="7" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="8" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="9" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="11" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="12" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Legal/Corporate Goverance (Equity)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="13" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="14" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="15" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Legal/Corporate Goverance (Internal Approvals)</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="16" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="17" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<td colspan="4" class="exprow"><b>Corporate Governance Documents</b></td>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="18" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="19" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="21" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="22" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="23" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
					<tr>
						<tc:transactionCaptureRadios index="24" view="readOnly" certificateList="${certificateList}" closingCheckListMap="${closingCheckListMap}"/>
					</tr>
				</tbody>
				  </table>
				</div>		
			</div>

		</div>