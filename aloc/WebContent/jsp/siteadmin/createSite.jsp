<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<% String contextUrl = request.getContextPath();  %>
<script>var contextURL = '<%=contextUrl%>';</script>
	
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
			SiteTypeCreate();
			autoTextarea();
			autoTextarea50();
			decCounter("siteName", 50);
			decCounter("description", 50);
		});
	</script>
</c:if>

<s:url id="createBankSiteURL" action="createBankSite" namespace="/int/siteadmin" />
<s:url id="createSiteSectionURL" action="createSite" namespace="/int/siteadmin" />

	<!-- Create Site TOGGLE STARTS HERE -->
	<s:form id="createNewSiteForm">
        <input type="hidden" name= "sectionId" value="${param.sectionId}" />
        <s:hidden name="createSiteValidate" id="createSiteValidateId"/>   
        
        
        <h2 id="createNewSite" class="section_flip section_blue acc_trigger1">
			<a href="javascript:;">
				<c:choose>
		        	<c:when test="${modifySite eq true}">
						<span><s:text name="label.siteAdmin.modifyExistingSite" /></span>
					</c:when>
					<c:when test="${copySite eq true}">
						<span><s:text name="label.siteAdmin.copyExistingSite" /></span>
					</c:when>
					<c:otherwise>
						<span><s:text name="label.common.siteAdmin.createNewSite" /></span>
					</c:otherwise>
				</c:choose>
			</a>
		</h2><hr class="h2-hr">
		<div id="createNewSitePanel" class="section_panel acc_container1">
			<jsp:include page="/jsp/siteadmin/common/createCopyCommon.jsp">
			   	<jsp:param value="Create" name="crFlag"/>
			</jsp:include>
			
			<sj:submit 
				key="label.common.siteAdmin.save"
				cssClass="btn-primary"
				replaceTarget="true"
				targets="createNewSiteForm"
				href="%{createSiteSectionURL}" 
				indicator="createSiteProcess"
				id="createSiteSaveBut"
				onCompleteTopics="enableToggles"
			/>
			<a href="#" class="btn-tertiary cancel clearEntries" id="createSiteCancel"  data-toggle="modal"><s:text name="label.request.common.cancel"></s:text></a>
			<img alt="Loading..." id="createSiteProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
		</div>		
			
		<h2 id="bankFeePaymentSetup" style="display: none" class="section_flip section_blue acc_trigger4 hide">
			<a href="javascript:;"><s:text name="label.common.siteAdmin.bankFeePaymentSetup" />
				<span class="ttip info" data-original-title="<s:text name="label.siteAdmin.tooltip.bankFeePaymentSetup"/>"></span>
			</a>
		</h2><hr class="h2-hr hide">
		<div id="bankFeePaymentSetupPanel" style="display: none" class="section_panel acc_container4">
			<div id="bankFeePaymentSetupSection">
				<jsp:include page="/jsp/siteadmin/common/bankFeePaymentSetup.jsp" />
			</div>	
		</div>
			
		<h2 id="bankSwiftConfig" style="display: none" class="section_flip section_blue acc_trigger6 hide">
			<a href="javascript:;"><s:text  name="label.siteAdmin.bankSWIFTConfiguration"/>
				<span class="ttip info" data-original-title="<s:text name="label.siteAdmin.tooltip.bankSWIFTConfiguration"/>"></span>
			</a>
		</h2><hr class="h2-hr hide">
		<div id="bankSwiftConfigPanel" style="display: none" class="section_panel acc_container6">
			<div id="bankSwiftConfigSection">
				<jsp:include page="/jsp/siteadmin/common/bankSwiftConfig.jsp" />
				<sj:submit 
					key="label.common.siteAdmin.save"
					cssClass="btn-primary"
					replaceTarget="true"
					targets="createNewSiteForm"
					href="%{createBankSiteURL}"
					indicator="bankSwiftProcess"
					onCompleteTopics="redirectToPortalPageBankSite"
				/>
				<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.common.cancel"></s:text></a>
				<img alt="Loading..." id="bankSwiftProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
			</div>
		</div>
  </s:form>