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
	<%-- <c:set var="legSummary" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/> --%>
	<c:set var="legSummary" value="${deal:fetchLegSummary(1, pageContext.request)}" scope="page"/>
	<h3>Lender</h3>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p>${legSummary.lenderEntity.CDRCd}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p>${legSummary.lenderEntity.LEGoldId}</p>
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
				<p>${legSummary.lenderEntity.LEName}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p>${legSummary.lenderEntity.country}</p>
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
				<p>${legSummary.participantRegulatedEntity}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Participant a principal Entity?</b>
				</p>
				<p>${legSummary.participantPrincipalEntity}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Management Entity</b><br> ${legSummary.lenderEntity.MEName}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br> ${legSummary.lenderEntity.capitalIndustrial}
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
					<c:if test="${empty legSummary.lenderEntity.treasuryCode}">
						--
					</c:if>
					<c:if test="${not empty legSummary.lenderEntity.treasuryCode}">
						${legSummary.lenderEntity.treasuryCode}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<h3>Borrower</h3>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>CDR code</b>
				</p>
				<p>${legSummary.lenderEntity.CDRCd}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Legal Entity GOLD ID</b>
				</p>
				<p>${legSummary.lenderEntity.LEGoldId}</p>
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
				<p>${legSummary.lenderEntity.LEName}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Country</b>
				</p>
				<p>${legSummary.lenderEntity.country}</p>
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
				<p>${legSummary.participantRegulatedEntity}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Is Participant a principal Entity?</b>
				</p>
				<p>${legSummary.participantPrincipalEntity}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Management Entity</b><br> ${legSummary.lenderEntity.MEName}
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Capital or Industrial</b><br> ${legSummary.lenderEntity.capitalIndustrial}
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
					<c:if test="${empty legSummary.lenderEntity.treasuryCode}">
						--
					</c:if>
					<c:if test="${not empty legSummary.lenderEntity.treasuryCode}">
						${legSummary.lenderEntity.treasuryCode}
					</c:if>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>


