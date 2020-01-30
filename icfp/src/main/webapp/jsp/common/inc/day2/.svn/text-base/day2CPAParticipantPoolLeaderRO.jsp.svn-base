<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common />
<div class="form-mod">
	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(legNumber, pageContext.request)}" scope="page" />
	<c:set var="rateInfoVO" value="${deal:fetchRateInfo(legNumber, pageContext.request)}" scope="page"/>


	<h3>Participant</h3>
	<div class="row">
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
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Legal Entity name</b>
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
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Is Participant a regulated Entity?</b>
				</p>
				<p>
				<c:if test="${empty CPALegSummary.participantRegulatedEntity}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participantRegulatedEntity}">
						${CPALegSummary.participantRegulatedEntity}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Participant a principal Entity?</b>
				</p>
				<p>
				<c:if test="${empty CPALegSummary.participantPrincipalEntity}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participantPrincipalEntity}">
						${CPALegSummary.participantPrincipalEntity}
					</c:if>
				
				
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b>Management Entity</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></p>
				
				<p><c:if test="${empty CPALegSummary.participant.MEName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.MEName}">
						${CPALegSummary.participant.MEName}
					</c:if></p>
				
				
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p><b>Capital or Industrial</b></p>
				<p><c:if test="${empty CPALegSummary.participant.capitalIndustrial}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.capitalIndustrial}">
						${CPALegSummary.participant.capitalIndustrial}
					</c:if></p>
				
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">

	<c:choose>
	<c:when test="${param.page eq 'transactionCapture'}">
	<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span><br />
					<c:if test="${fn:length(CPALegSummary.participantTCode) eq 0}">
						<div class="entitylookup">
							<p style="display:none" class="leGoldId">${CPALegSummary.participant.LEGoldId}</p>	
							<div class="ME conditional-row">
								<p style="display:none">${CPALegSummary.participant.MEName}</p>
							</div>
							<span  class="help-block error" style="display:none;"></span>
							<input type="text" maxlength="20"  class="span3" name="lenderCPATCode"
									data-provide="typeahead" style="text-transform:uppercase"
									data-source="" value="${treasuryCode}" id="lenderTCodeId"/>
							<span class="req-error" style="display:none;">error</span>
						</div>
					</c:if>
					<c:forEach var="treasuryCode" items="${CPALegSummary.participantTCode}" >
					<div class="entitylookup">
						<p style="display:none" class="leGoldId">${CPALegSummary.participant.LEGoldId}</p>	
						<div class="ME conditional-row">
							<p style="display:none">${CPALegSummary.participant.MEName}</p>
						</div>
						<span  class="help-block error" style="display:none;"></span>
						<input type="text" maxlength="20"  class="span3" name="lenderCPATCode"
								data-provide="typeahead" style="text-transform:uppercase"
								data-source="" value="${treasuryCode}" id="lenderTCodeId"/>
						<span class="req-error" style="display:none;">error</span>
					</div>
					</c:forEach>
				</p>
			</div>
		</div>
	
	</c:when>
	<c:otherwise>	
	
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span><br /> 
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
		<!-- end of block -->
	</div>
	</c:otherwise>
	</c:choose>
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Business Segment</b>
				</p>
				<p>
					<c:if test="${empty CPALegSummary.participantBusSegment}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participantBusSegment}">
						${CPALegSummary.participantBusSegment}
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
					<b>Fund Co./Hold Co./Op Co.</b>
				</p>
				<p><c:if test="${empty CPALegSummary.participantFCHC}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.participantFCHC}">
						${CPALegSummary.participantFCHC}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>


	<h3>Pool Leader</h3>

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
					<b>Legal Entity GOLD ID</b>
				</p>
				<p><c:if test="${empty CPALegSummary.poolLeader.LEGoldId}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.LEGoldId}">
						${CPALegSummary.poolLeader.LEGoldId}
					</c:if></p>
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
				<p><c:if test="${empty CPALegSummary.poolLeader.LEName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.LEName}">
						${CPALegSummary.poolLeader.LEName}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p><c:if test="${empty CPALegSummary.poolLeader.country}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.country}">
						${CPALegSummary.poolLeader.country}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
					<p>
					<b>Is Pool Leader a regulated Entity?</b>
					</p>
					<p><c:if test="${empty CPALegSummary.poolLeaderRegulatedEntity}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderRegulatedEntity}">
						${CPALegSummary.poolLeaderRegulatedEntity}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Pool Leader a principal Entity?</b>
				</p>
				<p><c:if test="${empty CPALegSummary.poolLeaderPrincipalEntity}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderPrincipalEntity}">
						${CPALegSummary.poolLeaderPrincipalEntity}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Management Entity</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span><br>
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
	<c:choose>
	<c:when test="${param.page eq 'transactionCapture'}">
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span><br /> 
					
					<div class="entitylookup">
						<p style="display:none" class="leGoldId">${CPALegSummary.poolLeader.LEGoldId}</p>	
						<div class="ME conditional-row">
							<p style="display:none">${CPALegSummary.poolLeader.MEName}</p>
						</div>
						<span  class="help-block error" style="display:none;"></span>
						<input id="borrowerTCodeId" type="text" maxlength="20"  class="span3" name="borrowerCPATCode"
								data-provide="typeahead" style="text-transform:uppercase"
								data-source="" value="${CPALegSummary.poolLeader.treasuryCodes[0]}"/>
						<span class="req-error" style="display:none;">error</span>
					</div>
				</p>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Bank name</b><br /> 
					<html:text property="bankName" tabindex="3" styleClass="span3" style="text-transform:uppercase" styleId="poolLeaderBankNameId" 
						value="${CPALegSummary.poolLeaderBankName}"/>
				</p>
			</div>
		</div>
	</div>
	</c:when>
	<c:otherwise>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
			<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span><br /> 
					<c:if test="${empty CPALegSummary.poolLeaderTCode}">
						--
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderTCode}">
						 ${CPALegSummary.poolLeaderTCode}
                    </c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Bank name</b>
				</p>
				<p><c:if test="${empty CPALegSummary.poolLeaderBankName}">
						-
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderBankName}">
						${CPALegSummary.poolLeaderBankName}
					</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	</c:otherwise>
	</c:choose>
	
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
	
	<h3>Rate Information</h3>
	<div class="row highlighted">
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
	<div class="row">
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
<div class="display-row">

	<h2 class="span12">Cash Pool Details</h2>
	<div class="clear"></div>


	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Cash Pool Name</b>
				</p>
				<p>${CPALegSummary.cashPoolName}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Cash Pool Country</b>
				</p>
				<p>${CPALegSummary.cashPoolCountry}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Cash Pool Region</b>
				</p>
				<p>${CPALegSummary.cashPoolRegion}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Cash Pool Currency</b>
				</p>
				<p>${CPALegSummary.cashPoolCurrency}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

</div>