<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<c:if test="${param.includeScripts != false}">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
</c:if>

<s:set name="isEditMode" value="editMode"/>

	   		<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
				<a href="javascript:;"><s:text name="label.request.sbSectionBondDetails"/>
				</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel">

						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
			</div>
			
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="requestorMailingAddress" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionRequestorMailingAddress"/>
				</a></h2><hr class="h2-hr">
				<div id="requestorMailingAddressPanel" class="section_panel">
					
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.requestorMailingAddress" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
													
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
												
				</div>
			</div>
			<div class="clear"></div>

			<!-- Including Bond Information section   -->
			<jsp:include page="suretyBondReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.bondInformation" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
			
		   <!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.format" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param value="true" name="isTaxonomyView"/>
						</jsp:include>					
											
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
									
				</div>
		   </div>
			
