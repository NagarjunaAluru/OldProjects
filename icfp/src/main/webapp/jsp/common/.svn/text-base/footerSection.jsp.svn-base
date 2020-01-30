<%@ taglib prefix="security"  uri="hwf-securitytag" %>

<footer>
    <p class="application left">This Application is: GE Restricted</p>
    
	<ul class="footer-menu right ">
		<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="NotAdminActions">
		<li><a class="first" href="${context}/inbox.do?command=executeInbox">Dashboard</a></li>
		</security:hasRoles>
		<li><a href="javascript:void(0);" onclick="javascript:callContactUs();">Contact Us</a></li>
		<li class="last">
			<a href="http://in.treasury.corp.ge.com/pps/tibco/in_treasury/Pages/Intercompany+Financing/Overview" target="_blank">Help</a>
		</li>
     </ul><br/>
     <div class="span12">
	     <p class="application left">
	     <div class="footer-logo"></div>&nbsp;&nbsp; imagination at work</p>
	     <p class="footer-menu right ">@ General Electric Company</p>
 	 </div>
</footer>

<!-- Needed this second header for IE to avoid caching  -->
<HEAD>
	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
	<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>