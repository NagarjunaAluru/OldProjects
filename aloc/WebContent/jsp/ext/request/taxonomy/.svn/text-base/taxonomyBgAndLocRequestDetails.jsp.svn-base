<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
</c:if>

<s:set name="isEditMode" value="editMode"/>
	   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2><hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel">
		  
			<jsp:include page="taxonomyBgAndLocSection.jsp">
				<jsp:param name="sectionId"  value="request.section.transactionParties" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
    	 
		</div>
	</div>
   
	   <div class="clear"></div>
	   
	   <!-- Including Project Description  -->
	   <div class="form-mod" id="projectDescDiv">
	   		<h2 id="projectDescription" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
			</h2><hr class="h2-hr">
			<div id="projectDescriptionPanel" class="section_panel">
			     <jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.projectDescription" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
	   </div>
	   
	   
	   <!-- Including Instrument Details  -->
	   <div class="form-mod" >
	   		<h2 id="instrumentDetails" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
			</h2><hr class="h2-hr">
			<div id="instrumentDetailsPanel" class="section_panel">
				  <jsp:include page="taxonomyBgAndLocSection.jsp">
						<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
			</div>
	   </div>
	   
	   <!-- Including Instrument Risk  -->
	   <div class="form-mod" >
	   		<h2 id="instrumentRisk" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
			</h2><hr class="h2-hr">
			<div id="instrumentRiskPanel" class="section_panel">
				  <jsp:include page="taxonomyBgAndLocSection.jsp">
						<jsp:param name="sectionId"  value="request.section.instrumentRisk" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
			</div>
	   </div>
	   
	   <!-- Including Standby Letter of Credit Conditions  -->
	   <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
	   <div class="form-mod" >
	   		<h2 id="locConditions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
			</h2><hr class="h2-hr">
			<div id="locConditionsPanel" class="section_panel">
				<jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
					<jsp:param name="includeScripts" value="false" />
			 	 </jsp:include>
			</div>
	   </div>
	   </c:if>
	   
	    <!-- Instrument Reporting Attribute  -->
	   <div class="form-mod" >
	   		<h2 id="instrumentReporting" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.6"/></a>
			</h2><hr class="h2-hr">
			<div id="instrumentReportingPanel" class="section_panel">
				<jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.instrumentReporting" />
					<jsp:param name="includeScripts" value="false" />
			 	 </jsp:include>
			</div>
	   </div>
	   
	   <!-- Including Format   -->
	   <div class="form-mod" id="formatDiv">
	   		<h2 id="formatSectionFlip" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
					<span id="formatSelectionH2"></span>
				</a>
			</h2><hr class="h2-hr">
			<div id="formatSectionFlipPanel" class="section_panel">
			      <jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.format" />
					<jsp:param name="includeScripts" value="false" />
				  </jsp:include>
			</div>
	   </div>
	   
	   <!-- Delivery Instructions -->
	   <div class="form-mod">
	   		<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
			</h2><hr class="h2-hr">
			<div id="deliveryInstructionsPanel" class="section_panel">
			      <jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
					<jsp:param name="includeScripts" value="false" />
				  </jsp:include>
				
			</div>
	   </div>
	   
	   <!-- Delivery Instructions -->
	   <div class="form-mod">
	   		<h2 id="attachments" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
			</h2><hr class="h2-hr">
			<div id="attachmentsPanel" class="section_panel">
			      <jsp:include page="taxonomyBgAndLocSection.jsp">
					<jsp:param name="sectionId"  value="request.section.attachments" />
					<jsp:param name="includeScripts" value="false" />
				  </jsp:include>
				
			</div>
	   </div>
