<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hydus.wff.core.session.SessionManager"%>
<%@ page import="com.hydus.wff.common.environment.EnvironmentConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hydus.wff.core.util.HWFUtilities"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<!-- <%@ taglib uri="/WEB-INF/conf/tld/displaytag.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/conf/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>
<%@ taglib uri="/WEB-INF/conf/tld/hwf-decoratortag.tld" prefix="decorators" %>
<%@ taglib uri="/WEB-INF/conf/tld/hwf-securitytag.tld" prefix="hwf" %>
<%@ taglib uri="/WEB-INF/conf/tld/hwf-rules.tld" prefix="rules" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>



<%
    String serverUrl = "http://"+request.getServerName()+":"+request.getServerPort();
    // request url path till the parent context
    String parentContextUrl = com.hydus.wff.core.environment.EnvironmentConstants.parentContext; 
    String servletContextUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 
    
	// request url path till the context
    
    // customization url path 
    String customizePage = servletContextUrl+"/customizepage.do";
    
    //url when switching the application
    String cleanupURL = servletContextUrl+"/cleanup.do";
    
    /* url for display tag after refreshing the sorted data.
     * here process param is set to false, which indicates not to hit again 
     * inconcert server.
    */
    String dispTagInboxSortURL = parentContextUrl +"/inbox.do?process=false";
    
    // url path for inbox page
	String inboxURL = parentContextUrl + "/requestAccess.do?cmd=redirectHomePage";
    		
	//url path for report page
	String reportsURL = parentContextUrl + "/reports.do?cmd=None";
	
	// url path for Under construction URL page
	String underconsURL = parentContextUrl + "/underconspage.do";
		
	// url path for logout page
	String logoutURL = request.getContextPath() + "/logout.do?logout=true";
	
   // url path for Administration URL page
   String adminURL = parentContextUrl + "/adminpage.do";
	
	// url path for Distribute URL page
	String distributeURL = parentContextUrl + "/distribute.do?cmd=None";
 	
	// url path for Refresh button on Distribute Tasks page	
	//String refreshDistributeURL = parentContextUrl + "/distribute.do?cmd=Distribute Tasks&process=false";
		
	// url path for Search URL page
	String searchURL = parentContextUrl + "/globalsearch.do?cmd=None";
	
 	String helpLinkURL = EnvironmentConstants.helpLinkURL;
 	
 	String customizeURL=parentContextUrl+ "/customize.do";
 	
 	String mdmAjaxURL = servletContextUrl + "/tradeprocess.do"; 
 	
 	// Set this way now in case the Ajax URL changes in the future; 
 	String tradeProcessURL = mdmAjaxURL;
 	
 	String supplementalURL = servletContextUrl + "/suppdetails.do"; 
 	
 	String domainvalue = servletContextUrl + "/domainValueMgmt.do?cmd=getDomainNames";
 	
 	String manageUser = servletContextUrl + "/manageUser.do?cmd=executeDefault";
 	
 	String jurisdictionURL = servletContextUrl + "/jurisdiction.do?cmd=getAllData";
 	
 	String manageLegal = servletContextUrl + "/manageLegal.do?cmd=executeDefault";
 	
 	String requestorURL = servletContextUrl + "/userSilos.do?cmd=loadSiloData&role=requestor";
 	String rulesEntityURL = servletContextUrl + "/userSilos.do?cmd=loadSiloData&page=rules&addUpdate=false";
 	String rulesEntityAddUpdateURL = servletContextUrl + "/userSilos.do?cmd=loadSiloData&page=rules&addUpdate=true";

 	String requestorCopyURL = servletContextUrl + "/requestAccess.do?cmd=loadSiloPopUpData&role=Requestor&entities=";
 	String approverCopyURL = servletContextUrl + "/requestAccess.do?cmd=loadSiloPopUpData&role=Approver&entities=";
 	String approverURL = servletContextUrl + "/userSilos.do?cmd=loadSiloData&role=approver";
 	String controllerURL = servletContextUrl + "/userSilos.do?cmd=loadSiloData&role=controller";
 	String userSearchURL=servletContextUrl + "/createUser.do?cmd=getUserSearchDetails";
 	
 	String currencyTradeURL=servletContextUrl + "/routingRules.do?cmd=loadCurrencies&curType=Trade&addUpdate=false";
 	String currencyTradeAddUpdateURL=servletContextUrl + "/routingRules.do?cmd=loadCurrencies&curType=Trade&addUpdate=true";
 	String settlementTradeURL=servletContextUrl + "/routingRules.do?cmd=loadCurrencies&curType=Settlement&addUpdate=false";
 	String settlementTradeAddUpdateURL=servletContextUrl + "/routingRules.do?cmd=loadCurrencies&curType=Settlement&addUpdate=true";
 	String loadAllEntitiesURL=servletContextUrl + "/routingRules.do?cmd=loadAllEntityData";
 	String loadAllCurrencyURL=servletContextUrl + "/routingRules.do?cmd=loadAllCurrencyData";
	
	String currencyDashboardURL=servletContextUrl + "/traderInbox.do?cmd=loadCurrencies";
	String settleCurrencyDashboardURL=servletContextUrl + "/traderInbox.do?cmd=loadSettleCurrencies";
	String entityDashboardURL = servletContextUrl + "/traderInbox.do?cmd=loadEntities";
	String entityAccessDashboardURL = servletContextUrl + "/accessControlInbox.do?cmd=loadEntities";
	String currencyAccessDashboardURL = servletContextUrl + "/accessControlInbox.do?cmd=loadCurrencies";
	String statusDashboardURL = servletContextUrl + "/traderInbox.do?cmd=loadStatusDtl";
	String reassignPopUpURL = servletContextUrl + "/traderInbox.do?cmd=loadDataToReAssign";
	String autoConfigureDashboardURL = servletContextUrl + "/traderInbox.do?cmd=getRefreshContent";
	String autoConfigureAcessDashboardURL = servletContextUrl + "/accessControlInbox.do?cmd=getRefreshContent";
	
	String resetURL = servletContextUrl + "/reset.do";
 	
 	String loadRoutingRulesDiagnostic=servletContextUrl + "/routingRules.do?cmd=loadRoutingRulesPage&diagnostics=true";

 	
 	String requestAccessCurrencyURL = servletContextUrl + "/requestAccess.do?cmd=loadCurrencies";
 	String rejectConfirmationURL = servletContextUrl + "/accessControlInbox.do?cmd=rejectConfirmation";
 	String approveConfirmationURL = servletContextUrl + "/accessControlInbox.do?cmd=approveConfirmation";
 	String reviewConfirmationURL = servletContextUrl + "/accessControlInbox.do?cmd=reviewConfirmation";
 	
 	boolean isAdmin = false;
%>
<script type="text/javascript" >
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>

