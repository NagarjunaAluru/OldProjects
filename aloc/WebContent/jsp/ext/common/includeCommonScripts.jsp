<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:url var="strutsResURL" includeParams="none" value="/ext/public/struts/" />  
<sj:head scriptPath="%{strutsResURL}"/>

<!-- Including Stylesheets -->
<link href="${pageContext.request.contextPath}/ext/public/css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/ext/public/css/common/site.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/ext/public/css/common/section.css" rel="stylesheet">
	
<!-- INTELLIGENCE SEARCH JAVASCRIPT AND JQUERY HERE -->
<link href="${pageContext.request.contextPath}/ext/public/css/others/jsonSuggest.css" rel="stylesheet">

<!-- Including JavaScripts -->
<script src="${pageContext.request.contextPath}/ext/public/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/common/tablesorter.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/common/section.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/common/site.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.corner.js" type="text/javascript"></script>
<!-- TOGGLE CSS AND JAVA SCRIPT ATTACHED -->
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/others/animatedcollapse.js"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/others/jquery.jsonSuggest.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/others/json2.js" type="text/javascript"></script>

<!-- Including Attachments plugin -->
<script src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery-fileupload-plugin/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery-fileupload-plugin/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery-fileupload-plugin/jquery.fileupload.js"></script> 
 
<!--[if IE]>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/PIE.js"></script>
<![endif]-->

<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/ext/public/js/others/jquery-zdate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/others/jquery.autoresize.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/ext/public/js/tiny_mce/plugins/ice/js/ice.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ext/public/js/tiny_mce/tiny_mce.js" type="text/javascript"></script>