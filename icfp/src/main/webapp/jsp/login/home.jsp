<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Home Page</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" >
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
<!-- Le styles -->
<link href="${context}/css/bootstrap.css" rel="stylesheet">
<link href="${context}/css/site.css" rel="stylesheet">
<link href="${context}/jquery-ui-1.8.16.custom.css" rel="stylesheet">
<script src="${context}/js/jquery-1.7.1_min.js" type="text/javascript"></script>
<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${context}/js/jquery-zdate.js" type="text/javascript"></script>
<script src="${context}/js/jquery.autoresize.js" type="text/javascript"></script>
<script src="${context}/js/tablesorter.min.js" type="text/javascript"></script>

<script src="js/site.js" type="text/javascript"></script>
</head>
 <%String msg = (String) request.getAttribute("UpdateMessage"); %> 
<body>
<%@include file="../common/headerSection.jsp" %>
	<html:form action="/homePage.do" >
		<div id="content-border">
		<table>
		<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</tr>
		<tr>
		 <td>&nbsp;</td>
		 <td>
		<p>
			<%if (msg != null) {%>
		 <font color="green"> <b><%=msg %></b> </font>
			<%} %>
		</p>
		 </td>
		 </tr>
		</table>
		
			<h1><b>ICFP</b></h1>
			<ul>
				
				<li>
					<a href="<%=servletContextUrl%>/fundingRequest/newFundingRequestView.do?command=newRequest">New Funding Request</a>
				</li>
				<li>
					<a href="<%=servletContextUrl%>/fundingRequest/newFundingRequestView.do?command=newRequest&productType=CPA">New CPA Funding Request</a>
				</li>
				
				<li>
					<a href="<%=servletContextUrl%>/pipelineReview/pipelineReviewView.do?command=executeInbox">Pipeline Review Management</a>
				</li>
				 <li>
					<a href="<%=servletContextUrl%>/inbox.do">Inbox</a>
				</li>
				 
           </ul>
           
       
		</div>
	</html:form>
</body>
</html>