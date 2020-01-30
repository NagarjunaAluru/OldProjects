<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<c:if test="${param.includeScripts != false}">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
</c:if>
		<s:set name="isEdit" value="editMode" />
		<div class="form-mod">
			<h2 id="principal" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionPrincipal" /></a>
			</h2><hr class="h2-hr">
			<div id="principalPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId" value="request.section.riderPrincipal" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
		</div>

		<div class="clear"></div>

		<div class="form-mod">
			<h2 id="obligee" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionObligee" /> </a>
			</h2><hr class="h2-hr">
			<div id="obligeePanel" class="section_panel">
				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId" value="request.section.riderObligee" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
		</div>

		<div class="clear"></div>

		<!-- Including Expiration Dates -->
		<div class="form-mod">
			<h2 id="expirationDates" class="section_flip">
				<a href="javascript:;"> <s:text
						name="label.request.bglocSectionName.14" />
				</a>
			</h2><hr class="h2-hr">
			<div id="expirationDatesPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId"
						value="request.section.riderExpirationDates" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
		</div>
	<div class="clear"></div>
		<div class="form-mod">
			<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;"><s:text
						name="label.request.sbSectionBondInformation" /></a>
			</h2><hr class="h2-hr">
			<div id="bondInformationPanel" class="section_panel">

				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId"
						value="request.section.riderBondInformation" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>

			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text
						name="label.request.sbSectionDeliveryInstructions" /></a>
			</h2><hr class="h2-hr">
			<div id="deliveryInstructionsPanel" class="section_panel">

				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId"
						value="request.section.riderDeliveryInstructions" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>

			</div>
		</div>
		<div class="clear"></div>
		<!-- Including Attachments   -->
		<div class="form-mod" id="attachmentsDiv">
			<h2 id="attachments" class="section_flip">
				<a href="javascript:;"><s:text
						name="label.request.sbSectionAttachments" /></a>
			</h2><hr class="h2-hr">
			<div id="attachmentsPanel" class="section_panel">

				<jsp:include page="/jsp/common/request/suretyRider/suretyRiderReadonlyRequestSection.jsp">
					<jsp:param name="sectionId" value="request.section.attachments" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>

			</div>
		</div>
		<div class="clear"></div>
		   <div class="form-mod">
			        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
		   </div>
		   
		   <s:url action="cancelTaxonomy.action" namespace="/int" var="cancelBtnlURL"/>
		<div class="clear"></div>
