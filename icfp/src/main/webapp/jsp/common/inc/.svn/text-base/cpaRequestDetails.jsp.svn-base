<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<div class="form-mod">
	<h2 class="span12" id="legTable">Request Details</h2>
	<c:set var="fetchedlegs" value="${deal:fetchLegs(pageContext.request)}"></c:set>
	<c:if test="${param.formName eq 'fundingRequest'}">
	<div class="row">
				<div class="span9">
					<div class="table-btn">
						<span class="required">*</span>
						<button type="submit" name="command" value="addLeg" tabindex="18" class="btn">Add a leg...</button>
					</div>
				</div> <!-- end of block -->
	</div> 
	</c:if>	
	<div class="row">
		<div class="span12" style="overflow-x: auto;">
			<%-- <label><bean:message key="label.transactionLegs.noOfLegs" /> ${fourBlockerForm.deal.numberOfTransactions} 
				${fn:length(sessionScope.CpaLegDetails)} </label> --%>
			<table
				class="table table-striped table-bordered sortable no-bottom table-nested">
				<thead>
				  <tr>
				  	<th class="header" rowspan="2"></th>
					<th class="header" rowspan="2" colspan="2">Action</th>
					<th class="header" rowspan="2">Leg <br>#</th>
					<th class="header" rowspan="2">Product Type</th>
					<th class="header" rowspan="2">Inhouse Bank ID</th>
					<th colspan="4" class="nosort header">Participant</th>
					<th colspan="4" class="nosort header">Pool Leader</th>
					<th class="header" rowspan="2">Bank Name</th>
				  </tr>
				  <tr>
				    <th>Legal Entity<br>GOLD ID</th>
					<th>CDR</th>
					<th>Country</th>
					<th width="50px">ME</th>
					<th>Legal Entity<br>GOLD ID</th>
					<th>CDR</th>
					<th>Country</th>
					<th width="50px">ME</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach var="legDetailsId" items="${fetchedlegs}" >
						<tr>
						<td>-</td>
						<td>-</td>
						<c:choose>
							<c:when test="${param.path == 'pipelineReviewCPALeg'}">
								<td>
								<c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" onClick="javascript:submitFormAtViewLeg('${legDetailsId.legNumber}', '${legDetailsId.productType}')" class="view-file"></a>
								</c:if>
								<c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'cpafrontOffice'}">
							   <td>
							   <c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
							   <a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Modify Request Details" onclick="javascript:modifyCPALeg(this);"></a>
							   </c:if>
							   <c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
							   </td>
				   		    </c:when>
							<c:when test="${param.path == 'riskUnderwriting/riskUnderwriting' or param.path == 'idagEag/idagEag' or param.path == 'tesg/tesg'}">
								<td>
								<c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=viewInputScreens&source=${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a>
								</c:if>
								<c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'transactionCaptureFOCMFourBlocker' or param.path == 'transactionCaptureARFourBlocker' or param.path == 'transactionCaptureManagerFourBlocker'}">
								<td>
								<c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<%-- <a title="View this leg" href="${context}/transactionCapture/${param.path}.do?command=viewInputScreens&source=transactionCapture/${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a> --%>
								<a title="View this leg" onClick="javascript:submitFormAtViewLeg('${legDetailsId.legNumber}', '${legDetailsId.product}')" class="view-file"></a>
								</c:if>
								<c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:when test="${param.path == 'transactionCaptureMOFourBlocker'}">
								<td>
								<a title="View this leg" href="${context}/transactionCapture/${param.path}.do?command=legDetails&id=${legDetailsId.legNumber}&pType=${legDetailsId.productType}" class="view-file"></a>  
								</td>
							</c:when>
							<c:when test="${param.path == 'searchResults'}">
								<td>
								<c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=viewInputScreens&source=search/${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a>
								</c:if>
								<c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:when>
							<c:otherwise>
								<td>
								<c:if test="${not deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a title="View this leg" href="${context}/${param.path}.do?command=legDetails&source=${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a>  
								</c:if>
								<c:if test="${deal:hideLegView(legDetailsId.legNumber,pageContext.request)}">
								<a href="pop" class="view-file pop" data-toggle="modal"></a>
								</c:if>
								</td>
							</c:otherwise>
						</c:choose>
						<td>${legDetailsId.legSeqId}</td>
						<td>${legDetailsId.product}</td>
						<c:if test="${empty legDetailsId.subLedgerTransactionId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.subLedgerTransactionId}"> 
							<td>${legDetailsId.subLedgerTransactionId}</td>
						</c:if>		
						<c:if test="${empty legDetailsId.participantGoldId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.participantGoldId}"> 
							<td>${legDetailsId.participantGoldId}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.CDRCd}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.CDRCd}">
							<td>${legDetailsId.participant.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.country}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.country}">
							<td>${legDetailsId.participant.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.MEName}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.MEName}">
							<td>${legDetailsId.participant.MEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolGoldId}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.poolGoldId}"> 
							<td>${legDetailsId.poolGoldId}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.CDRCd}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.CDRCd}">
							<td>${legDetailsId.poolLeader.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.country}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.country}">
							<td>${legDetailsId.poolLeader.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.MEName}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.MEName}">
							<td>${legDetailsId.poolLeader.MEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeaderBankName}">
							<td>-</td>
						</c:if>
						<c:if test="${!empty legDetailsId.poolLeaderBankName}"> 
							<td>${legDetailsId.poolLeaderBankName}</td>
						</c:if>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<c:forEach var="eachLegDetail" items="${fetchedlegs}" >
<c:if test="${deal:hideLegView(eachLegDetail.legNumber,pageContext.request)}">
	<div id="pop" class="modal hide fade popmodal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>View Leg</h3>
		</div>
		<div class="modal-body" style="overflow-y: auto; height: 300px;">
		<table class="table table-bordered" >
			<tbody>
				<tr><td>Leg #</td><td>${eachLegDetail.legSeqId}</td></tr>
				<tr><td>Product Type</td><td>${eachLegDetail.product}</td></tr>
				<tr><td>Event</td><td>
				<c:choose>
						<c:when test="${empty eachLegDetail.transactionEventType}">
							-
						</c:when>
						<c:otherwise>
							<c:if test="${eachLegDetail.transactionEventTypeId eq 5}">
								<c:if test="${deal:getIncreaseOrDecrease(eachLegDetail.legNumber,pageContext.request) eq 1}">Amendment - Facility Increase</c:if>
								<c:if test="${deal:getIncreaseOrDecrease(eachLegDetail.legNumber,pageContext.request) eq 2}">Amendment - Facility Decrease</c:if>
							</c:if>
							<c:if test="${eachLegDetail.transactionEventTypeId != 5}">
								${eachLegDetail.transactionEventType}
							</c:if>
							<c:if test="${isImmediateDrawdown}">
								 for Leg #${eachLegDetail.drawDown}
							</c:if>
						</c:otherwise>
					</c:choose></td>
				</tr>
				<tr><td>Term <span class=small>in months</span></td><td>${not empty eachLegDetail.term ? eachLegDetail.term : '-'}</td></tr>
				<tr><td>Currency</td><td>${not empty eachLegDetail.dealCurrency ? eachLegDetail.dealCurrency : '-'}</td></tr>
				<tr><td>Inhouse Bank ID</td><td>${not empty eachLegDetail.subLedgerTransactionId ? eachLegDetail.subLedgerTransactionId : '-'}</td></tr>
				
				<tr><td>Participant Legal Entity GOLD ID</td><td>${not empty eachLegDetail.participantGoldId ? eachLegDetail.participantGoldId : '-'}</td></tr>
				<tr><td>Participant Legal Entity Name</td><td>${not empty eachLegDetail.participant.LEName ? eachLegDetail.participant.LEName : '-'}</td></tr>
				<tr><td>Participant CDR</td><td>${not empty eachLegDetail.participant.CDRCd ? eachLegDetail.participant.CDRCd : '-'}</td></tr>
				<tr><td>Participant Country</td><td>${not empty eachLegDetail.participant.country ? eachLegDetail.participant.country : '-'}</td></tr>
				<tr><td>Participant ME</td><td>${not empty eachLegDetail.participant.MEName ? eachLegDetail.participant.MEName : '-'}</td></tr>
				
				<tr><td>Pool Leader Legal Entity GOLD ID</td><td>${not empty eachLegDetail.poolGoldId ? eachLegDetail.poolGoldId : '-'}</td></tr>
				<tr><td>Pool Leader Legal Entity Name</td><td>${not empty eachLegDetail.poolLeader.LEName ? eachLegDetail.poolLeader.LEName : '-'}</td></tr>
				<tr><td>Pool Leader CDR</td><td>${not empty eachLegDetail.poolLeader.CDRCd ? eachLegDetail.poolLeader.CDRCd : '-'}</td></tr>
				<tr><td>Pool Leader Country</td><td>${not empty eachLegDetail.poolLeader.country ? eachLegDetail.poolLeader.country : '-'}</td></tr>
				<tr><td>Pool Leader ME</td><td>${not empty eachLegDetail.poolLeader.MEName ? eachLegDetail.poolLeader.MEName : '-'}</td></tr>
				
				<tr><td>Bank Name</td><td>${not empty eachLegDetail.poolLeaderBankName ? eachLegDetail.poolLeaderBankName : '-'}</td></tr>
			</tbody>
		</table>
		</div>
		<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">Close</a>
		</div>
	</div>
</c:if>
</c:forEach>
<script type="text/javascript" src="${context}/js/common/cpaRequestDetails.js">
</script>