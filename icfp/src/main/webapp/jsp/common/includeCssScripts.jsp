<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/> 	

 	
<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
  <script src="${context}/js/html-min.js"></script>
<![endif]-->

<!-- Le styles -->
<link href="${context}/css/bootstrap.css" rel="stylesheet">
<link href="${context}/css/site.css" rel="stylesheet">
<link href="${context}/css/jquery-ui-1.8.16.custom.css" rel="stylesheet">
   
<script src="${context}/js/jquery-1.7.1_min.js" type="text/javascript"></script>
<script src="${context}/js/bootstrap.js" type="text/javascript"></script>
<script src="${context}/js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="${context}/js/jquery-zdate.js" type="text/javascript"></script>
<script src="${context}/js/jquery.autoresize.js" type="text/javascript"></script>
<script src="${context}/js/tablesorter.min.js" type="text/javascript"></script>


<script src="${context}/js/site.js" type="text/javascript"></script>

<script src="${context}/js/inputValidate.js" type="text/javascript"></script>
<script src="${context}/js/jquery.validate.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/closeModalPopUps.js" type="text/javascript"></script>


<% String appURL = request.getContextPath();%>
<script type="text/javascript">
var context_url = '<%=appURL%>';
</script>