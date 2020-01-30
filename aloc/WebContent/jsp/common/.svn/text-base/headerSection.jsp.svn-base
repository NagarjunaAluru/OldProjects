
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="userInfo"  uri="hwf-userInformation" %>
<script type="text/javascript">
var contextURL = "${pageContext.request.contextPath}";
</script>
<div class="top-container">
	<s:url action="logout.action" namespace="/int" var="logoutURL" />
	<s:url action="help.action" namespace="/int" encode="true" var="helpURL"/>
	<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="treasuryAdminPortalURL" />
	<div class="welcomebar">
		<a class="left" ><img src="${pageContext.request.contextPath}/img/top_treasury.gif"></a>
		<c:set var="userName" value="${userInfo:fullName(' ','-')}" />
		<p class="left"><c:out value="${userName}"></c:out>  	
		</p>
		<p class="right">
			<hwfs:checkComponentPermission name="AdminPortalView" domainName="BusinessAccess">
			<a href="<s:property value="#treasuryAdminPortalURL" />"><span style="cursor: pointer;"><s:text name="label.header.admin"/></span></a> <b>|</b>
			</hwfs:checkComponentPermission>
			<a href="<s:property value="#logoutURL" />" ><span style="cursor: pointer;"><s:text name="label.header.logout"/></span></a>
		</p>
	</div>
	<div class="header">
		<div class="logo"><s:text name="label.header.aloc"/></div>
		<div class="logo2">
			<span><s:text name="label.header.alocDesc"/></span>
		</div>
		<div class="navbar">
			<div class="navbar-inner">
				<div style="width: auto; height: 31px;" class="container">
					<a data-target=".nav-collapse" data-toggle="collapse"
						class="btn btn-navbar"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li>
							<s:url action="home.action" 
							namespace="/int"
							var="homePageURL">
							</s:url>
							<a href="<s:property value="#homePageURL" />"><s:text name="label.header.home"/></a></li>
							<hwfs:checkComponentPermission name="AllRolesView" domainName="BusinessAccess">
							<li>
							<s:url action="displayDashboard.action" 
							namespace="/int/dashboard"
							var="allRequestDashboardURL">
							</s:url>
							<a href="<s:property value="#allRequestDashboardURL" />"><s:text name="label.header.dashboard"/></a></li>
							</hwfs:checkComponentPermission>
							<hwfs:checkComponentPermission name="RequestCreation" domainName="BusinessAccess">
								<li class="dropdown active">
									<a data-toggle="dropdown" class="dropdown-toggle" id="req" href="#"><s:text name="label.header.request"/> <b class="caret"></b></a>
								</li>
							</hwfs:checkComponentPermission>
							<hwfs:checkComponentPermission name="RateHistoryView" domainName="BusinessAccess">
							<c:if test="${not empty sessionScope.reportsAccessFlag && sessionScope.reportsAccessFlag eq 'Y'}">
							<li class="dropdown active">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"><s:text name="label.header.report"/> <b class="caret"></b></a>
								<hwfs:checkComponentPermission name="DefaultViewTreasuryAccess" domainName="BusinessAccess">
									<ul class="dropdown-menu">
										<li>
											<s:url action="viewUserReports.action" namespace="/int/reports" var="viewUserReportsURL"></s:url>
											<a href="<s:property value="#viewUserReportsURL" />" id="viewUserReports">My Report</a>
										</li>
									</ul>
								</hwfs:checkComponentPermission>
							</li>
							</c:if>
							</hwfs:checkComponentPermission>
							<hwfs:checkComponentPermission name="AdminPortalView" domainName="BusinessAccess">
								<li>
									<a href="<s:property value="#treasuryAdminPortalURL" />"><s:text name="label.header.admin"/></a>
								</li>
							</hwfs:checkComponentPermission>
							<hwfs:checkComponentPermission name="RateHistoryView" domainName="BusinessAccess">
								<li>
									<s:url action="getYearlist.action" namespace="/int/apm" var="apmFXRateHistoryURL"></s:url>
									<a href="<s:property value="apmFXRateHistoryURL"/>"><s:text name="label.header.rateHistory"/></a>
								</li>
							</hwfs:checkComponentPermission>
						</ul>
					</div>
					<!-- /.nav-collapse -->
				</div>
			</div>
			<!-- /navbar-inner -->
		</div>
	</div>
	
	<c:set var="mystatus" value="${param.createReqPopup}" scope="page"/>
	<s:if test='%{#attr.mystatus == "Yes"}'>
		 <%@include file="../requestor/createRequestPopup.jsp" %>
	</s:if>
	
	
</div>