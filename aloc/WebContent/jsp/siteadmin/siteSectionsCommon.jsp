<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <% String contextUrl = request.getContextPath();  %>
<script>
	  var contextURL = '<%=contextUrl%>';
</script>

<c:if test="${param.includeScripts != false}">
	<script src="${pageContext.request.contextPath}/js/common/section.js" type="text/javascript"></script>
	<!--[if IE]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/PIE.js"></script>
	<![endif]-->
	<script type="text/javascript">
		$(document).ready(function() {
			onloadTooltipsRoundedBut();
			onloadSiteTypeScripts();
			onloadBankSite();
			onloadParentSiteService();
			onloadDeliveryTypeShow();
			SiteTypeCreate();
			decCounter("siteName", 50);
			decCounter("description", 50);
			decCounter("specialInstructions", 400);
			onloadDelegateConfigRowEach();
		});
	</script>
</c:if>

        <!-- Create Site TOGGLE STARTS HERE -->
        <div id="create">
        	  <jsp:include page="createSite.jsp">
				<jsp:param name="sectionId"  value="site.section.createNewSite" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		</div>
		
		<!-- Customized Site References TOGGLE STARTS HERE -->
        <h2 id="customizedSiteReferences" class="section_flip section_blue acc_trigger3 hide">
				<a href="javascript:;"><s:text name="label.common.siteAdmin.customizedSiteReferences" />
				<span class="ttip info" data-original-title="<s:text name="label.siteAdmin.tooltip.customizeSiteReferences"/>"></span></a>
		</h2><hr class="h2-hr hide">
		<div id="customizedSiteReferencesPanel" class="section_panel acc_container3">
	        <jsp:include page="siteSection.jsp">
				<jsp:param name="sectionId"  value="site.section.customizedSiteReferences" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		</div>
		
        <!-- Default Delivery Instructions STARTS HERE -->
        <h2 id="defaultDeliveryInstructions" class="section_flip section_blue acc_trigger2 hide">
				<a href="javascript:;"><s:text  name="label.siteAdmin.defaultDeliveryInstructions"/>
				<span class="ttip info" data-original-title="<s:text name="label.siteAdmin.tooltip.deliveryInstructions"/>"></span></a>
		</h2><hr class="h2-hr hide">
		<div id="defaultDeliveryInstructionsPanel" class="section_panel acc_container2">
	        <jsp:include page="siteSection.jsp">
				<jsp:param name="sectionId"  value="site.section.defaultDeliveryInstructions" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		</div>
		
        <!-- Delegation Configuration TOGGLE STARTS HERE -->
        <h2 id="delegationConfiguration" class="section_flip section_blue acc_trigger5 hide">
				<a href="javascript:;"><s:text  name="label.siteAdmin.delegationConfiguration"/>
				<span class="ttip info" data-original-title="<s:text name="label.siteAdmin.tooltip.delegationConfiguration"/>"></span></a>
		</h2><hr class="h2-hr hide">
		<div id="delegationConfigurationPanel" class="section_panel acc_container5">
	        <jsp:include page="siteSection.jsp">
				<jsp:param name="sectionId"  value="site.section.createDelegateConfig" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		</div>
		          
        
