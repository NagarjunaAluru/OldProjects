<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>


	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
<div class="form-mod">

	<h3>Participant</h3>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p>
					<c:if test="${empty CPALegSummary.participant.CDRCd}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.CDRCd}">
						${CPALegSummary.participant.CDRCd}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p><c:if test="${empty CPALegSummary.participant.LEGoldId}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.LEGoldId}">
						${CPALegSummary.participant.LEGoldId}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Legal Entity Name</b>
				</p>
				<p>
					<c:if test="${empty CPALegSummary.participant.LEName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.LEName}">
						${CPALegSummary.participant.LEName}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p>
					<c:if test="${empty CPALegSummary.participant.country}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.country}">
						${CPALegSummary.participant.country}
					</c:if>
					</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Is Participant a regulated Entity?</b><br />
		
			
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							 <p> ${CPALegSummary.participantRegulatedEntity}</p>
				        </div>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Participant a principal Entity?</b>
				</p>
				<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<p>${CPALegSummary.participantPrincipalEntity}</p>
				        </div>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Management Entity</b><br>
					${CPALegSummary.participant.MEName}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br>
					${CPALegSummary.participant.capitalIndustrial}
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><br /> 
					<c:if test="${empty CPALegSummary.participant.treasuryCodes[0]}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.treasuryCodes[0]}">
						${CPALegSummary.participant.treasuryCodes[0]}
					</c:if>
				</p>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Business Segment</b>
				</p>
				<p>
					<c:if test="${empty CPALegSummary.participant.businessSegment}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.businessSegment}">
						${CPALegSummary.participant.businessSegment}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

		<div class="row">
		
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Fund Co./Hold Co./Op Co.</b>
				</p>
				<p><c:if test="${empty CPALegSummary.participant.fundHoldOperation}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.fundHoldOperation}">
						${CPALegSummary.participant.fundHoldOperation}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<h3>Pool Leader</h3>

	<div class="row highlighted">
		<div class="span5">
		<div class="form-row">
						<p><b>Cash Pool Name</b></p>
						<p>
						<c:choose>
						<c:when test="${!empty CPALegSummary.poolName}"> 
							<td>${CPALegSummary.poolName}</td>
						</c:when>
						<c:otherwise>
						<bean:message key="label.newRequests.data" />
						</c:otherwise>
						</c:choose>
						</p>
					</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p>				
				<c:choose>
						<c:when test="${!empty CPALegSummary.poolLeader.LEGoldId}"> 
							<td>${CPALegSummary.poolLeader.LEGoldId}</td>
						</c:when>
						<c:otherwise>
						<bean:message key="label.newRequests.data" />
						</c:otherwise>
						</c:choose>
						</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p><c:if test="${empty CPALegSummary.poolLeader.CDRCd}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.CDRCd}">
						${CPALegSummary.poolLeader.CDRCd}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p>${CPALegSummary.poolLeader.country}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
			 <div class="form-row">
				<p>
					<b>Legal Entity name</b>
				</p>
				<p>
				<c:if test="${empty CPALegSummary.poolLeader.LEName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.LEName}">
						${CPALegSummary.poolLeader.LEName}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Pool Leader a principal Entity?</b>
				</p>
				<p>${CPALegSummary.poolLeaderPrincipalEntity}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			
			<div class="form-row">
				<p>
					<b>Is Pool Leader a regulated Entity?</b><br />
					${CPALegSummary.poolLeaderRegulatedEntity}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br>
					<c:if test="${empty CPALegSummary.poolLeader.capitalIndustrial}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.capitalIndustrial}">
						${CPALegSummary.poolLeader.capitalIndustrial}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
		<div class="form-row">
				<p>
					<b>Management Entity</b><br>
					<c:if test="${empty CPALegSummary.poolLeader.MEName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.MEName}">
						${CPALegSummary.poolLeader.MEName}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Bank name</b><br /><c:if test="${empty CPALegSummary.poolLeaderBankName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderBankName}">
						${CPALegSummary.poolLeaderBankName}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
		<div class="form-row">
				<p>
					<b>Treasury code</b><br />
					<c:if test="${empty CPALegSummary.poolLeader.treasuryCodes[0]}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.treasuryCodes[0]}">
						${CPALegSummary.poolLeader.treasuryCodes[0]}
					</c:if>
				</p>
			</div>
			</div>
			<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Business Segment</b><br />
					<c:if test="${empty CPALegSummary.poolBusSegment}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolBusSegment}">
						${CPALegSummary.poolBusSegment}
					</c:if>
				</p>
			</div>
		</div>
			
			
	</div>
		<div class="row">
			<div class="span5">
				<div class="form-row">
					<p>
						<b>Fund Co./Hold Co./Op Co.</b><br />
						<c:if test="${empty CPALegSummary.poolFCHC}">
							-
						</c:if>
						<c:if test="${not empty CPALegSummary.poolFCHC}">
							${CPALegSummary.poolFCHC}
						</c:if>
					</p>
				</div>
			</div>
		</div>
	
	<h3>Rate Information</h3>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Interest Rate Index</b>
				</p>
				<c:if test="${empty CPALegSummary.rateInformation.floatingRateIndex }"><p>-</p></c:if>  
				<c:if test="${not empty CPALegSummary.rateInformation.floatingRateIndex }">
				   <p>${CPALegSummary.rateInformation.floatingRateIndex}</p>
				</c:if> 
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Index Term</b>
				</p>
				<c:if test="${empty CPALegSummary.rateInformation.floatingRateIndexTerm }"><p>-</p></c:if>  
				<c:if test="${not empty CPALegSummary.rateInformation.floatingRateIndexTerm }">
				   <p>${CPALegSummary.rateInformation.floatingRateIndexTerm}</p>
				</c:if>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Deposit Spread (bps)</b>
				</p>
				<c:if test="${empty CPALegSummary.rateInformation.maxSpread}"><p>-</p></c:if>  
				<c:if test="${not empty CPALegSummary.rateInformation.maxSpread }">
				   <p>${CPALegSummary.rateInformation.maxSpread}</p>
				</c:if>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Borrowing Spread (bps)</b>
				</p>
				<c:if test="${empty CPALegSummary.rateInformation.minSpread }"><p>-</p></c:if>  
				<c:if test="${not empty CPALegSummary.rateInformation.minSpread }">
				   <p>${CPALegSummary.rateInformation.minSpread}</p>
				</c:if>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>
