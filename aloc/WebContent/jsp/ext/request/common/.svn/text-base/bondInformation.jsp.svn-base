<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/ext/public/js/common/section.js" type="text/javascript"></script>
	 <script>
	$('.date').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	</script>

			<c:choose>
				<c:when test="${param.bondTypeId eq '1'}">			
					<div class="form-mod">
						<h2 id="bondInformation" class="section_flip">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionBondInformation" /> </a>
						</h2><hr class="h2-hr">
						<div id="bondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/bidBondInfo.jsp"></jsp:include>
						</div>
					</div>
				</c:when>
			
				<c:when test="${param.bondTypeId eq '2'}">
					<div class="form-mod">
						<h2 id="bondInformation" class="section_flip">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionBondInformation" /> </a>
						</h2><hr class="h2-hr">
						<div id="bondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/contractBondInfo.jsp"></jsp:include>
						</div>
					</div>
				</c:when>
			
				<c:when test="${param.bondTypeId eq '3'}">
					<div class="form-mod">
						<h2 id="bondInformation" class="section_flip">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionBondInformation" /> </a>
						</h2><hr class="h2-hr">
						<div id="bondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/licensePermitBondInfo.jsp"></jsp:include>
						</div>
					</div>
				</c:when>			
			
				<c:when test="${param.bondTypeId eq '4'}">
					<div class="form-mod">
						<h2 id="bondInformation" class="section_flip">
							<a href="javascript:;"> <s:text
									name="label.request.sbSectionCourtBondDetails" /></a>
						</h2><hr class="h2-hr">
						<div id="bondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/courtBondDetails.jsp" />
						</div>
					</div>
					<div class="clear"></div>
					<div class="form-mod">
						<h2 id="attorneyBondInformation" class="section_flip">
							<a href="javascript:;"> <s:text
									name="label.request.sbSectionAttorneyInformation" /></a>
						</h2><hr class="h2-hr">
						<div id="attorneyBondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/attorneyInformation.jsp" />
						</div>
					</div>			
				</c:when>
				
				<c:when test="${param.bondTypeId eq '5'}">
					<div class="form-mod">
						<h2 id="bondInformation" class="section_flip">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionBondInformation" /> </a>
						</h2><hr class="h2-hr">
						<div id="bondInformationPanel" class="section_panel fieldcount_panel">
							<jsp:include page="/jsp/common/request/customsBondInfo.jsp"></jsp:include>
						</div>
					</div>
				</c:when>
			</c:choose>
