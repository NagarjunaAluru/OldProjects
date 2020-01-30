<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Administration - Data Maintenance</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
  var contextURL = '<%=servletContextUrl%>';
	</script>
	
	
  </head>

  <body>
	<div class="container main">
	<%@include file="../common/headerSection.jsp" %>
	 	<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.successMsg ? 'block' : 'none'}">
	         <a href="#" data-dismiss="alert" class="close">X</a>
	          <strong><font color="green">${requestScope.successMsg}</font></strong> 
	    </div>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Administration - Data Maintenance</li>
		</ul>
		<h1 class="page-title span12">Administration - Data Maintenance</h1>
		<p class="span12 left clear dashdesc">Select an element below to edit.
			<span class="required-fields"><span>*</span> = Required</span>
		</p>

		<html:form action="admin/admin.do" styleId="adminId" method="post">
	       
		<div class="form-mod">

			<div class="row">
				 
                 <div class="span6">
                 	<h3>Transfer Pricing</h3>
                    <ul>
                    	<li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_MODEL_TYPE&source=Model Type">Model Type</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_MODEL_SCORE&source=Model Score">Model Score</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_RANGE&source=Range">Range</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_SNP_RATING&source=S and P Rating">S&amp;P Rating</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_FINAL_RATING&source=Final Rating">Final Rating</a></li>
                        <li><a href="${context}/admin/admin.do?command=openTable&tableName=T_ICFP_SOLVENCY_METRICS_CALC&source=Solvency Metrics Threshold">Solvency Metrics Threshold</a></li>
                    </ul>
                    
                    <h3>Events</h3>
                    <ul>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_GENERAL_AMENDMENT_TYPE&source=General Amendment Type">General Amendment Type</a></li>
                    </ul>
                    

                    <h3>Derivatives/Hedge and Tax Designation</h3>
                    <ul>
                    	<li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_DAY_COUNT&source=Day Count">Day Count</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_HEDGE_DESIGNATION&source=Hedge Designation">Hedge Designation</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_HEDGE_PROGRAM&source=Hedge Program">Hedge Program</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_CONTRACT_CLASS&source=Contract Class">Contract Class</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_TAX_DESIGNATION&source=Tax Designation">Tax Designation</a></li>
                    </ul>                    
                 </div>
                 
                 <div class="span6 right">
                    <h3>Cash Pools</h3>
                    <ul>
                    	<li><a href="${context}/admin/admin.do?command=openTable&tableName=T_ICFP_COUNTRY_TAX_APPROVERS&source=Country Tax/Jurisdiction">Country Tax/Jurisdiction</a></li>
                    </ul> 
                    <h3>Equity</h3>
                    <ul>
                       <li><a href="${context}/admin/admin.do?command=openString&tableName=T_ICFP_REFERENCE_DATA&source=eBoardroom Approval Required Amount">eBoardroom Approval Required Amount</a></li>
                       <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_SHARE_TYPE&source=Share Type">Share Type</a></li>
                    </ul>

                    <h3>Other</h3>
                    <ul>
                    	<li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_DEAL_CATEGORY&source=Deal Category">Deal Category</a></li>
                        <li><a href="${context}/admin/admin.do?command=openTable&tableName=T_ICFP_PRINCPL_ENTITY_MSTR&source=Principal Legal Entity">Principal Legal Entity</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_RESPONSIBLE_REGION&source=Region Responsibility">Region Responsibility</a></li>
                        <li><a href="${context}/admin/admin.do?command=openTable&tableName=T_ICFP_LEG_EVENT&source=Request Approval Expiration Days Periods">Request Approval Expiration Days Periods</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_STNDRD_TERMS_CONDITIONS&source=Standard Terms and Conditions">Standard Terms &amp; Conditions</a></li>
                        <li><a href="${context}/admin/admin.do?command=openTable&tableName=T_ICFP_TCL_PRF&source=TCL (Transaction Classification Matrix)">TCL (Transaction Classification Matrix)</a></li>
                        <li><a href="${context}/admin/admin.do?command=openDropdown&tableName=T_ICFP_REFERENCE_DATA&source=Preferred File Types">Preferred File Types</a></li>
                  
                    </ul>                    
                                                
                 </div>
                 
                 <div class="clear"></div>

         	</div>       
        
		</div>
  	 <hr>
  	 </html:form>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	
    
</body>
</html>