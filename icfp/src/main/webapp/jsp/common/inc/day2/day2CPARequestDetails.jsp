<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
<div class="form-mod">
	<h2 class="span12" id="legTable">${param.legSeqId}</h2>
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
					<%-- <th class="header" rowspan="2">Action</th> --%>
					<th class="header" rowspan="2">Leg <br>#</th>
					<th class="header" rowspan="2">Product Type</th>
					<th colspan="6" class="nosort header">Participant</th>
					<c:choose>
						<c:when test="${param.path == 'pipelineReviewCPALeg' or param.path == 'cpafrontOffice'}">
							<th colspan="7" class="nosort header">Pool Leader</th>
						</c:when>
						<c:otherwise>
							<th colspan="8" class="nosort header">Pool Leader</th>
						</c:otherwise>
					</c:choose>
					<th style="padding-right:20px!important;" class="header" nowrap="nowrap" rowspan="2">Bank Name</th>
				  </tr>
				  <tr>
				 	<th>Legal Entity GOLD ID</th>
					<th class="header">CDR</th>
					<th class="header">Name</th>
					<th class="header">Country</th>
					<th class="header">ME</th>
					<th class="header">Cap/Ind</th>
					<th>Legal Entity GOLD ID</th>
					<th class="header">CDR</th>
					<th class="header">Name</th>
					<th class="header">Country</th>
					<th class="header">Region</th>
					<th class="header">Currency</th>
					<c:if test="${param.path != 'pipelineReviewCPALeg' and param.path != 'cpafrontOffice'}">
						<th>ME</th>
					</c:if>
					<th class="header">Cap/Ind</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach var="legDetailsId" items="${deal:fetchLegs(pageContext.request)}" >
						<tr>
						<%-- <c:choose>
							<c:when test="${param.path == 'pipelineReviewCPALeg'}">
								<td><a title="View this leg" href="${context}/pipelineReview/${param.path}.do?command=openLeg&legNo=${legDetailsId.legNumber}" class="view-file"></a></td>
							</c:when>
							<c:when test="${param.path == 'cpafrontOffice'}">
							   <td><a href="javascript:void(0);" id="edit-legs" class="edit-leg ttip" data-original-title="Modify Request Details" onclick="javascript:modifyCPALeg(this);"></a></td>
				   		    </c:when>
							<c:when test="${param.path == 'riskUnderwriting' or param.path == 'idagEag' or param.path == 'tesg'}">
								<td><a title="View this leg" href="${context}/${param.path}.do?command=viewInputScreens&source=${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a></td>
							</c:when>
							<c:when test="${param.path == 'transactionCaptureFOCMFourBlocker' or param.path == 'transactionCaptureARFourBlocker' or param.path == 'transactionCaptureManagerFourBlocker'}">
								<td><a title="View this leg" href="${context}/transactionCapture/${param.path}.do?command=viewInputScreens&source=transactionCapture/${param.path}&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a></td>
							</c:when>
							<c:otherwise>
								<td><a title="View this leg" href="${context}/${param.path}.do?command=legDetails&id=${legDetailsId.legNumber}&pType=${legDetailsId.product}" class="view-file"></a>  </td>
							</c:otherwise>
						</c:choose> --%>
						<td>${legDetailsId.legSeqId}</td>
						<td>${legDetailsId.product}</td>
						<c:if test="${empty legDetailsId.participantGoldId}">
							<td>--</td>
						</c:if>
						<c:if test="${!empty legDetailsId.participantGoldId}"> 
							<td>${legDetailsId.participantGoldId}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.participant.CDRCd}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.CDRCd}">
							<td>${legDetailsId.participant.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.LEName}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.LEName}">
							<td>${legDetailsId.participant.LEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.country}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.country}">
							<td>${legDetailsId.participant.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.MEName}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.MEName}">
							<td>${legDetailsId.participant.MEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.participant.capitalIndustrial}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.participant.capitalIndustrial}">
							<td>${legDetailsId.participant.capitalIndustrial}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.poolGoldId}">
							<td>--</td>
						</c:if>
						<c:if test="${!empty legDetailsId.poolGoldId}"> 
							<td>${legDetailsId.poolGoldId}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.poolLeader.CDRCd}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.CDRCd}">
							<td>${legDetailsId.poolLeader.CDRCd}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.LEName}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.LEName}">
							<td>${legDetailsId.poolLeader.LEName}</td>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.country}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.country}">
							<td>${legDetailsId.poolLeader.country}</td>
						</c:if>
						<c:if test="${empty legDetailsId.cashPoolRegion}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.cashPoolRegion}">
							<td>${legDetailsId.cashPoolRegion}</td>
						</c:if>
						<c:if test="${empty legDetailsId.cashPoolCurrency}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.cashPoolCurrency}">
							<td>${legDetailsId.cashPoolCurrency}</td>
						</c:if>
						
						<c:if test="${param.path != 'pipelineReviewCPALeg' and param.path != 'cpafrontOffice'}">
							<c:if test="${empty legDetailsId.poolLeader.MEName}">
								<td>--</td>
							</c:if>
							<c:if test="${not empty legDetailsId.poolLeader.MEName}">
								<td>${legDetailsId.poolLeader.MEName}</td>
							</c:if>
						</c:if>
						<c:if test="${empty legDetailsId.poolLeader.capitalIndustrial}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeader.capitalIndustrial}">
							<td>${legDetailsId.poolLeader.capitalIndustrial}</td>
						</c:if>
						
						<c:if test="${empty legDetailsId.poolLeaderBankName}">
							<td>--</td>
						</c:if>
						<c:if test="${not empty legDetailsId.poolLeaderBankName}">
							<td style="padding-right:20px!important;">${legDetailsId.poolLeaderBankName}</td>
							
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>