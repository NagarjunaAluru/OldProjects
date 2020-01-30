<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common />
<div class="form-mod">
	<%-- <c:set var="CPALegSummary" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/> --%>
	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(1, pageContext.request)}" scope="page"/>
	<c:set var="rateInfoVO" value="${deal:fetchRateInfo(legNumber, pageContext.request)}" scope="page"/>
	<h3>Participant</h3>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p>${CPALegSummary.participant.CDRCd}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p>${CPALegSummary.participant.LEGoldId}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Legal Entity name</b>
				</p>
				<p>${CPALegSummary.participant.LEName}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p>${CPALegSummary.participant.country}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Is Participant a regulated Entity?</b>
				</p>
				<p>${CPALegSummary.participantRegulatedEntity}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Participant a principal Entity?</b>
				</p>
				<p>${CPALegSummary.participantPrincipalEntity}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Management Entity</b><br> ${CPALegSummary.participant.MEName}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br> ${CPALegSummary.participant.capitalIndustrial}
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
					<c:if test="${empty CPALegSummary.participantTCode}">
						--
					</c:if>
					<c:if test="${not empty CPALegSummary.participantTCode}">
						<c:forEach var="treasuryCode" items="${CPALegSummary.participantTCode}" >
						 ${treasuryCode}
						</c:forEach>
                    </c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		 
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
         
	</div>
	 <div class="row">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Fund Co./Hold Co./Op Co.</b></p>
                       <p><c:if test="${empty CPALegSummary.participant.fundHoldOperation}">
						-
						</c:if>
						<c:if test="${not empty CPALegSummary.participant.fundHoldOperation}">
							${CPALegSummary.participant.fundHoldOperation}
						</c:if></p>
                    </div>
                </div><!-- end of block -->
     </div>            
	
	<h3>Pool Leader</h3>

	<div class="row highlighted">
	<div class="span5">
			<div class="form-row">
				<p>
					<b>Cash Pool name</b>
				</p>
				<p>${CPALegSummary.cashPoolName}</p>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p>${CPALegSummary.poolLeader.LEGoldId}</p>
			</div>
		</div>
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p>${CPALegSummary.poolLeader.CDRCd}</p>
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

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Legal Entity name</b>
				</p>
				<p>${CPALegSummary.poolLeader.LEName}</p>
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
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Is Pool Leader a regulated Entity?</b><br /> ${CPALegSummary.poolLeaderRegulatedEntity} 
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Management Entity</b><br> ${CPALegSummary.poolLeader.MEName}
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br> ${CPALegSummary.poolLeader.capitalIndustrial}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Bank name</b><br /> ${CPALegSummary.poolLeaderBankName}
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
					<c:if test="${empty CPALegSummary.poolLeaderTCode}">
						--
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderTCode}">
						 ${CPALegSummary.poolLeaderTCode}
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
		<!-- end of block -->
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
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Interest Rate Index</b>
				</p>
				<p>
					<c:if test="${empty rateInfoVO.floatingRateIndex}">
						-
					</c:if>
					<c:if test="${not empty rateInfoVO.floatingRateIndex}">
						${rateInfoVO.floatingRateIndex}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Index Term</b>
				</p>
				<p>
					<c:if test="${empty rateInfoVO.floatingRateIndexTerm}">
						-
					</c:if>
					<c:if test="${not empty rateInfoVO.floatingRateIndexTerm}">
						${rateInfoVO.floatingRateIndexTerm}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted" >
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Deposit Spread (bps)</b>
				</p>
				<p>
					<c:if test="${empty rateInfoVO.maxSpread}">
						-
					</c:if>
					<c:if test="${not empty rateInfoVO.maxSpread}">
						${rateInfoVO.maxSpread}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Borrowing Spread (bps)</b>
				</p>
				<p>
					<c:if test="${empty rateInfoVO.minSpread}">
						-
					</c:if>
					<c:if test="${not empty rateInfoVO.minSpread}">
						${rateInfoVO.minSpread}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	
</div>


