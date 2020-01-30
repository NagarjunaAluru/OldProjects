<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ALOC | Login Page</title>
    <meta name="description" content="">
    <meta name="author" content="">
		<link href="${pageContext.request.contextPath}/css/jquery/bootstrap.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/common/site.css" rel="stylesheet" />
	<s:head/>
	<script type="text/javascript">
		function setGeoraclehrid() {
			document.getElementById("georaclehrid").value = document.loginForm.userName.value; 
			document.getElementById("SM_USER").value = document.loginForm.userName.value; 
		}
	</script>

</head>
<body>
<s:form name="loginForm" action="home" namespace="/int">
	<s:hidden name="georaclehrid" id="georaclehrid" />
	<s:hidden name="SM_USER" id="SM_USER" />
<table width="100%" height="100%" >
  <tr valign="top">
    <td width="26%" >
	<br/><br/><br/>
	   <table width="192" height="132" align="right" class="tmiwflogin-body">
          <tr class="header">
            <td height="23" colspan="2"><div align="center" class="tmiwflogin-head">ALOC Login Page</div></td>
          </tr>
          <tr>
            <td width="63" height="33" valign="bottom">
             <div align="center">
             	<b>
             		<s:label key="label.login.userName" />
               </b>
             </div></td>
            <td width="117" valign="bottom" >   
            <s:textfield name="userName" size="16" maxlength="16" onblur="javascript:setGeoraclehrid()" />          
			 </td>
          </tr>
          <tr>
            <td height="34" valign="middle">
              <div align="center">
              	<b>
              		<s:label key="label.login.password" />
              	</b>
              </div>
             </td>
            <td valign="middle">      
            	<s:password name="password" size="16" maxlength="16" redisplay="false" id="lastid"/>      
	        </td>
          </tr>
          <tr>
          <td height="30" colspan="2">
              <div align="center">
              	<s:submit key="label.login.submit" />
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
</s:form>
</body>

