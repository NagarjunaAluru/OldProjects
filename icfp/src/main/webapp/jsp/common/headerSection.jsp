<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%
	UserContext.reInitializeUserContext(request);
%>
<t:common/>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
var contextURL = "${context}";
</script>
<script type="text/javascript" src="${context}/js/common/headerSection.js"></script>
<div class="top-container">
			<div class="welcomebar">
				<a class="left" href="#"><img src="${pageContext.request.contextPath}/img/top_treasury.gif"></a>
				<c:set var="userName" value="${userDetails:fullName(',','-')}" />
				<p class="left">Welcome <c:out value="${userName}" /> | <span onclick="javascript:logout();" style="cursor: pointer;">Logout</span></p>
			</div>
			<div class="header">
				<div class="logo">ICF</div>
				<div class="logo2"><span>Intercompany Financing</span></div>
				<div class="navbar">
					<div class="navbar-inner">
					  <div style="width: auto;" class="container">
						<a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						</a>
						<div class="nav-collapse">
						  <ul class="nav">
							<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="NotAdminActions">
							<li><a href="${context}/inbox.do?command=executeInbox">Dashboard</a></li>
							</security:hasRoles>
							<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="CreateRequestActions">
							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">New requests<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="javascript:void(0);" onclick="javascript:callMyRequest('debt');">Debt/Equity</a></li>
									<li class="divider"></li>
									<li><a href="javascript:void(0);" onclick="javascript:callMyRequest('CPA');">Cash Pool</a></li>
							  	</ul>
							</li>
							</security:hasRoles>
							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">Pipeline<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="javascript:void(0);" onclick="javascript:callPipeline('IDAG');">Front Office pipeline</a></li>
									<li class="divider"></li>
									<li><a href="javascript:void(0);" onclick="javascript:callPipeline('MO');">Middle Office pipeline</a></li>
							  	</ul>
							</li>
							<c:set var="eachReport" value="${staticdata:getReportsURLS(pageContext)}"/>
							<li><a href="javascript:void(0);" onclick="javascript:cognosReportsHome('<c:out value="${eachReport[0].name}"></c:out>');">Reports</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:callSearchForm();">Search</a></li>
							<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AdminActions">
							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">Admin<b class="caret"></b></a>
								<ul class="dropdown-menu">
										<li><a href="javascript:void(0);" onclick="javascript:callDataMaintenance();">Data Maintenance</a></li>
										<li class="divider"></li>
										<li><a href="javascript:void(0);" onclick="javascript:callManageDelagation();">Manage Delegations</a></li>
							  	</ul>
							</li>
							</security:hasRoles>
						  </ul>
						  
						</div><!-- /.nav-collapse -->
					  </div>
					</div><!-- /navbar-inner -->
				</div>
			</div>
		</div>
		
		
		
	<!-- Attachment Error Modal -->
	<div class="modal hide fade" style="width:400px;" id="attachmentErrorModal">
		<div class="modal-header">
			<a class="close" href="#" onclick="javascript:closeErrorModal()">X</a>
			<h3>Error</h3>
		</div>
		<div class="modal-body" style="min-height:100px !important;">
			<p></p>
		</div>
		<div class="modal-footer">
			<a class="btn-link right cancel" href="#" onclick="javascript:closeErrorModal()">Close</a>
		</div>
	</div>
