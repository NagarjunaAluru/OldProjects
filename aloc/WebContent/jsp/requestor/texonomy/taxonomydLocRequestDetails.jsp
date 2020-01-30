<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<c:if test="${param.includeScripts != false}">
	<%@include file="../../common/includeCommonScripts.jsp" %>
</c:if>

<s:set name="isEditMode" value="editMode"/>

<hwfs:checkComponentPermission name="TaxonomyUpdateAccess" domainName="BusinessAccess">
	<div class="row">
		<div class="span12">
			<s:url action="cloneRequest.action" namespace="/int/requestor" var="cloneRequestURL">
				<s:param name="requestId">
					<s:property value="requestDetails.requestId" />
				</s:param>
			</s:url>
			<a href="<s:property value="#cloneRequestURL"/>" class="btn right">
				<s:text	name="label.request.clonethisRequest" />
			</a>
		</div>
	</div>
	<s:set name="pageName" value="%{'Taxonomy'}" />
</hwfs:checkComponentPermission>

	 
	<div class="form-mod" id="businessContactPersonSectionId">
		<h2 id="businessContactPerson" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.dlocbusinessContactPerson"/></a>
		</h2><hr class="h2-hr">
		<div id="businessContactPersonPanel" class="section_panel">
			<jsp:include page="/jsp/common/request/taxonomy/taxonomyBusinessContactPerson.jsp">
				<jsp:param name="page" value="${pageName}" />
			</jsp:include>					
		</div>
	</div>
   
    <div class="clear"></div>
	   
	<div class="form-mod">
		<h2 id="issuingBank" class="section_flip">
			<a name="second" href="javascript:;"><s:text name="label.request.issuingBank"/></a>
		</h2><hr class="h2-hr">
		<div id="issuingBankPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.issuingBank" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param value="true" name="isTaxonomy"/>
			</jsp:include>					
		</div>
	</div>
	   
	   
	<div class="clear"></div>
		
	<div class="form-mod">
		<h2 id="applicant" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.applicant"/> 
			<span class="ttip info"	data-original-title="This is an tooltip with more information"></span></a>
		</h2><hr class="h2-hr">
		<div id="applicantPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.applicant" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param value="true" name="isTaxonomy"/>
			</jsp:include>					
		</div>
	</div>			
						
	<div class="clear"></div>
			
	<div class="form-mod">
		<h2 id="beneficiary" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.beneficiary"/> 
			<span class="ttip info"	data-original-title="This is an tooltip with more information"></span></a>
		</h2><hr class="h2-hr">
		<div id="beneficiaryPanel" class="section_panel">			
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.beneficiary" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param value="true" name="isTaxonomy"/>
			</jsp:include>					
		</div>
	</div>	
								
	<div class="clear"></div>
			
	<div class="form-mod">
		<h2 id="instrumentTransactionDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.instrumentTransactionDetails"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentTransactionDetailsPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentTransactionDetails" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param value="true" name="isTaxonomy"/>
			</jsp:include>					
		</div>
	</div>			
	
	<div class="clear"></div>

	<div class="form-mod">
		<h2 id="paymentSchedule" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.paymentSchedule"/></a>
		</h2><hr class="h2-hr">
		<div id="paymentSchedulePanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.paymentSchedule" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param value="true" name="isTaxonomy"/>
			</jsp:include>					
		</div>
	</div>
	
	<!-- Including Format   -->
	<div class="form-mod" id="formatDiv">
		<h2 id="format" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
				<span id="formatSelectionH2"></span>
			</a>
		</h2><hr class="h2-hr">
		<div id="formatPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.format" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param name="isTaxonomyView" value="true" />
			</jsp:include>					
		</div>
	</div>
	
	<!-- Including Attachments   -->
	<div class="form-mod" id="attachmentsDiv">
		<h2 id="attachments" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
		</h2><hr class="h2-hr">
		<div id="attachmentsPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.attachments" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>
	