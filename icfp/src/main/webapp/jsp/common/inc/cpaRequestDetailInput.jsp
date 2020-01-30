<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common />
<div class="form-mod">
	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
    <h2 class="span12 collapsible">Transaction Summary</h2>
	<div class="clear"></div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Product Type</b>
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
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Term (in months)</b>
				</p>
				<p>${CPALegSummary.term}</p>
			</div>
		</div>
		<c:if test="${param.page eq 'transactionCapture'}">
		<c:set var="vaultDet" value="${deal:getVaultID(pageContext.request)}" scope="page"/>
		<div class="span5 right" id="vaultDivID">
			<div class="form-row">
				<p>
					<c:if test="${requestScope.details eq 'falseData'}">
			       		<span id="errorMessageID"  class="help-block invalid error">Participant and Pool Leader information entered does not match the Vault Request</span>
			       	</c:if>
			       	<span class="required">*</span>
					<b>Vault Request ID</b><br />
					<html:text property="vaultId" maxlength="50" tabindex="1" styleClass="span3" styleId="vaultTextID" value='${vaultDet}'  />
					<span class="req-error" style="display:none;">error</span>
					<a href="#vaultRequestScreenID" id="valultReqIDLookupID"  class="initiate btn right cancel" style="float:right; margin-right: 75px;"> Lookup</a>
				</p>
			</div>
		</div>
		</c:if>
	</div>
	
	<h3>Participant</h3>
	<div class="row">
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

	<div class="row highlighted">
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
	<div class="row">
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
	<div class="row highlighted">
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
	<c:choose>
	<c:when test="${param.page eq 'transactionCapture'}">
	<div class="row">
	 <div class="span5">
			 <div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.TCode.TCFOLeg" />"></span><br />
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
	</div>
	</c:when>
	<c:otherwise>	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.TCode.TCFOLeg" />"></span><br /> 
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
	</div>
	</c:otherwise>
	</c:choose>
	<%-- <c:choose>
	<c:when test="${param.page eq 'countryTax'}">
	<jsp:include page="countryTaxPoolLeaderInput.jsp"/>
	</c:when>
	<c:otherwise> --%>
	<h3>Pool Leader</h3>

	<div class="row highlighted">
	   <div class="span5">
			<div class="form-row">
				<p>
					<b>Cash Pool Name</b>
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
		<!-- end of block -->
	</div>
	<div class="row">
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
	

	<div class="row highlighted">
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
	<div class="row">
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
	<div class="row highlighted">
		
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br>
					<c:if test="${empty CPALegSummary.poolLeader.capitalIndustrial}">
						&nbsp;
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeader.capitalIndustrial}">
						${CPALegSummary.poolLeader.capitalIndustrial}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>&nbsp;</b><br>&nbsp;
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
					<span class="required">*</span><b>Bank name</b><br /> 
					<html:text property="bankName" tabindex="3" styleClass="span3" style="text-transform:uppercase" styleId="poolLeaderBankNameId" 
						value="${CPALegSummary.poolLeaderBankName}"/>
				</p>
			</div>
		</div>
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.TCode.TCFOLeg" />"></span><br />
					<html:text property="borrowerCPATCode" maxlength="20" tabindex="2" styleClass="span3" style="text-transform:uppercase" styleId="borrowerTCodeId" 
						value="${CPALegSummary.poolLeader.treasuryCodes[0]}"/>
				</p>
			</div>
		</div>
	</div>
	</c:when>
	<c:otherwise>
	<div class="row">
		<!-- end of block -->
		<div class="span5">
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
					<b>Treasury code</b><span class="ttip info" data-original-title="<bean:message key="label.TCode.TCFOLeg" />"></span><br /> 
					<c:if test="${empty CPALegSummary.poolLeaderTCode}">
						--
					</c:if>
					<c:if test="${not empty CPALegSummary.poolLeaderTCode}">
						 ${CPALegSummary.poolLeaderTCode}
                    </c:if>
				</p>
			</div>
		</div>
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
	
	
	
	
	<%-- </c:otherwise>
	</c:choose> --%>
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
				<c:if test="${empty CPALegSummary.rateInformation.maxSpread }"><p>-</p></c:if>  
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

<div class="form-mod">
	<h2 class="span12">Cash Pool Details</h2>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Cash Pool name</b>
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
<div class="form-mod">
	<h2 class="span12">Other Considerations</h2>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Cross Border</b>
				</p>
				<p>${deal:getCrossBorderFlagValue(pageContext.request)}</p>
			</div>
		</div>
		
	</div>
	
</div>