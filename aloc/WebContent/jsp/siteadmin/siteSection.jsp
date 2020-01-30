<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:url id="validateAndSaveSectionURL" action="validateAndSaveSection" namespace="/int/siteadmin" />
<s:url id="copySectionURL" action="copySite" namespace="/int/siteadmin" />
<s:url id="modifySiteSectionURL" action="modifySite" namespace="/int/siteadmin" />

<div id="site${param.crFlag}">
	<c:if test="${param.includeScripts != false}">
	<script src="${pageContext.request.contextPath}/js/common/section.js" type="text/javascript"></script>
	<!--[if IE]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/PIE.js"></script>
	<![endif]-->
	<script type="text/javascript">
		$(document).ready(function() {
			onloadTooltipsRoundedBut();
			autoTextarea();
			autoTextarea50();
			decCounter("specialInstructions", 400);
			onloadDeliveryTypeShow();
			onloadDelegateConfigRowEach();
		});
	</script>
	</c:if>

	<c:choose>
		<c:when test="${param.sectionId eq 'site.section.defaultDeliveryInstructions'}">
			<div id="defaultDeliverySection">
				<s:form id="defaultDeliveryForm">
					<jsp:include page="/jsp/siteadmin/common/defaultDeliveryInstructions.jsp" />
					<input type="hidden" name= "sectionId" value="${param.sectionId}" />
					<sj:submit 
						key="label.common.siteAdmin.save"
						cssClass="btn-primary"
						replaceTarget="true"
						targets="defaultDeliverySection"
						href="%{validateAndSaveSectionURL}" 
						indicator="defaultProcess"
						onBeforeTopics="ignoreParentSites"
					/>
					<a href="#" class="btn-tertiary cancel clearEntries"><s:text name="label.request.common.cancel"></s:text></a>
					<img alt="Loading..." id="defaultProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:form>
			</div>	
		</c:when>
		
		<c:when test="${param.sectionId eq 'site.section.customizedSiteReferences'}">
			<div id="customizedSiteSection">
				<s:form id="customizedSiteForm">
					<jsp:include page="/jsp/siteadmin/common/customizedSiteRereferences.jsp" />
					<input type="hidden" name= "sectionId" value="${param.sectionId}" />
					<sj:submit 
						key="label.common.siteAdmin.save"
						cssClass="btn-primary"
						replaceTarget="true"
						targets="customizedSiteSection"
						href="%{validateAndSaveSectionURL}" 
						indicator="customizedProcess"
						onBeforeTopics="ignoreParentSites"
					/>
					<a href="#" class="btn-tertiary cancel clearEntries"><s:text name="label.request.common.cancel"></s:text></a>
					<img alt="Loading..." id="customizedProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:form>
			</div>	
		</c:when>
		
		<c:when test="${param.sectionId eq 'site.section.createDelegateConfig'}">
			<div id="createDelegateConfigSection">
				<s:form id="createDelegateConfigForm">
					<div id="delegationSection">
						<jsp:include page="/jsp/siteadmin/common/createDelegateConfig.jsp">
							<jsp:param name="includeScripts" value="false" />
	       				</jsp:include>
       				</div>
					<input type="hidden" name= "sectionId" value="${param.sectionId}" />
					<s:hidden name="validationSuccess" id="validationSuccessId"/>          
					
				 		<sj:submit 
							key="label.common.siteAdmin.save"
							cssClass="btn-primary"
							replaceTarget="true"
							targets="createDelegateConfigSection"
							href="%{validateAndSaveSectionURL}" 
							indicator="createDelegateConfigProcess"
							onBeforeTopics="ignoreParentSites" 
							onCompleteTopics="redirectToPortalPage"
						/>
					<a href="#" class="btn-tertiary cancel clearEntries"><s:text name="label.request.common.cancel"></s:text></a>
					<img alt="Loading..." id="createDelegateConfigProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</s:form>
			</div>	
						
		</c:when>
		
		<c:when test="${param.sectionId eq 'site.section.copySelectBox'}">
			<div id="copySelectBoxSection">
				<s:form id="copySelectBoxForm">
					<div class="span12">
	                    <div class="form-row">
	                            <s:select list="#{}" 
									listKey="id" 
									listValue="name" 
									id="selectSiteName" 
									key="label.siteAdmin.siteNameToBeCopied"
									theme="aloc"
									cssStyle="width: 230px;"
								/>
								<img alt="Loading..." id="copySiteDetProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                    </div>
	                 </div>
					<input type="hidden" name= "sectionId" id="sectionIdCopy" value="${param.sectionId}" />
				</s:form>
			</div>	
		</c:when>
		
		<c:when test="${param.sectionId eq 'site.section.modifySelectBox'}">
			<div id="modifySelectBoxSection">
				<s:form id="modifySelectBoxForm">
		            <div class="form-row">
		                <s:select list="#{}" 
										listKey="name" 
										listValue="name" 
										id="modifySites" 
										name="siteAdmin.siteType.siteTypeId"
										cssClass="hide"
										key="label.siteAdmin.sitePrefixName"
										theme = "aloc"
										cssStyle="width: 270px;"
								/>
						<img alt="Loading..." id="modifySiteIdProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
		            </div>
				</s:form>
			</div>	
		</c:when>
	</c:choose>
</div>