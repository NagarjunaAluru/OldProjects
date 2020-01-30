<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<t:common />
<div class="form-mod">
	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
	<h2 class="span12 collapsible">Transaction Summary</h2>
	<div class="clear"></div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Product</b>
				</p>
				<p>${CPALegSummary.product}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Deal Currency</b>
				</p>
				<p>${CPALegSummary.dealCurrency}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
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
					<c:if test="${empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
						--
					</c:if>
					<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
						<logic:iterate id="lenderTreasuryCode" name="cpaLegRequestForm" property="cpaSummary.participantTCodeEntities">
							<input type="hidden" name="participantTCodeEntities" value="${lenderTreasuryCode}">
	                        ${lenderTreasuryCode}<br>
	                     </logic:iterate>
	                     <input type="hidden" id="showTreasuryCode" value="true"/>
                    </c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
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
					<c:if test="${empty CPALegSummary.poolLeader.treasuryCodes[0]}">
						--
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
		<!-- end of block -->
		
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
	
	
</div>


