<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

			<c:if test="${param.includeScripts != false}">
               	  <%@include file="../../common/siteIncludeScripts.jsp" %>
	    	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/siteAdmin/businessSiteAdmin.js"></script>
           </c:if>

			<div class="form-mod">
				
		        	<!-- FIRST TOGGLE STARTS HERE -->
		        	<h2 id="siteSummary" class="section_flip section_blue acc_trigger1">
						<a href="javascript:;"><s:text name="label.siteAdmin.siteSummary" /></a>
					</h2><hr class="h2-hr">
					<div id="siteSummaryPanel" class="section_panel acc_container1">
				       <div id="siteSummarySection">
							<jsp:include page="/jsp/siteadmin/common/siteSummary.jsp"></jsp:include>
					   </div>	
					</div>
					
					<s:if test="(siteAdmin.headerSiteOnly != null && siteAdmin.headerSiteOnly != true)">
							<!-- SECOND TOGGLE STARTS HERE -->
						<h2 id="delegates" class="section_flip section_blue acc_trigger2">
							<a href="javascript:;"><s:text name="label.siteAdmin.delegates" />
							<span class="ttip info" data-original-title="<s:text name="label.businessAdmin.tooltip.delegates"/>"></span></a>
						</h2><hr class="h2-hr">
						<div id="delegatesPanel" class="section_panel acc_container2">
							<jsp:include page="/jsp/siteadmin/common/delegates.jsp">
								<jsp:param name="includeScripts" value="false" />
							</jsp:include>
						</div>
						
						<!-- THIRD TOGGLE STARTS HERE -->
						<h2 id="delegationConfig" class="section_flip section_blue acc_trigger3">
							<a href="javascript:;"><s:text name="label.siteAdmin.delegationConfiguration" /></a>
						</h2><hr class="h2-hr">
						<div id="delegationConfigPanel" class="section_panel acc_container3">
					       <div id="delegationConfigSection">
								<jsp:include page="/jsp/siteadmin/common/delegationConfig.jsp"></jsp:include>
						   </div>	
						</div>
					</s:if>
					
				</div>
