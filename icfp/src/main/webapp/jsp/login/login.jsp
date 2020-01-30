<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICFP | Login Page</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script language="JavaScript" src="${pageContext.request.contextPath}/js/login/login.js">
</script>

</head>
<body>
<html:form action="/login.do?login" focus="userName" >
<input type='hidden' name="georaclehrid" id="georaclehrid" />
<input type='hidden' name="SM_USER" id="SM_USER" />
<table width="100%" height="100%" >
  <tr valign="top">
    <td width="26%" >
	<br/><br/><br/>
	   <table width="192" height="132" align="right" class="tmiwflogin-body">
          <tr class="header">
            <td height="23" colspan="2"><div align="center" class="tmiwflogin-head">Login</div></td>
          </tr>
          <tr>
            <td width="63" height="33" valign="bottom">
             <div align="center"><b>
               Sso Id
              </b>
             </div></td>
            <td width="117" valign="bottom">             
			 <html:text property="userName" size="16" maxlength="16" onblur="javascript:setGeoraclehrid()" />           
			 </td>
          </tr>
          <tr>
            <td height="34" valign="middle">
              <div align="center"><b>Password</b>
              </div></td>
            <td valign="middle">            
			  <html:password property="password" size="16" maxlength="16" redisplay="false" styleId="lastid"/>        
	        </td>
          </tr>
          <tr>
          <td height="30" colspan="2">
              <div align="center">
                <html:submit property="submit" value="Login"/><html:reset/>
            </div>       
          </td>
          </tr>
       <tr><td colspan="2" class="tmiwflogin-error">
        <!-- <div align="center">
        <logic:present name="loginForm" property="errorMessage">
        	Please Enter User Name
        </logic:present>
         
        <html:errors bundle="exception"/>
        
        </div> -->
          </td></tr>   
       </table></td><td width="6%">&nbsp;</td>
    <td width="68%">
	<br>
	<!-- <table width="500" class="tmiwflogin-body">
      <tr class="header">
        <td height="23" width="503"><div align="center" class="tmiwflogin-head"><b>ICFP</b></div></td>
      </tr>
      <tr>
        <td height="177"></td>
      </tr>
    </table> --></td>
  </tr>
</table>
</html:form>
</body>

