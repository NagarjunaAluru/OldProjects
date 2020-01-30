<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="span12">
		<div class="form-row" id="basicSearchFH" style="text-align:right!important;">
		   <s:form name="basicSearchForm" id="basicSearchFormID" action="basicFHSearch.action" namespace="/int/admin">
		   <div class="left">
		     <s:if test="%{userSpecificSitesList!=null && userSpecificSitesList.size > 1}">
				<s:select headerKey="-1" headerValue="All my sites" list="userSpecificSitesList" 
				listKey="ID" listValue="name" name="siteId" id="siteId"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			</s:if>
			</div>
			<div class="right">
				<div class="left span7">
			<select name="searchCriteriaType" id="searchCriteriaType">
			            <option value="1">ADN</option>
				        <option selected value="2">ALOC Record Number</option>
						<option value="3">Applicant Name</option>
						<option value="4">Bank Reference number</option>
						<option value="5">Beneficiary Name</option>
						<option value="6">BUC</option>
						<option value="7">Currency</option>
						<option value="8">Foriegn expiry date</option>
						<option value="9">Instrument Amount</option>
						<option value="10">Payment amount greater than</option>
						<option value="11">Payment bank</option>
						<option value="12">Payment currency</option>
						<option value="13">Payment date</option>
			</select> 
			
			<s:textfield name="searchCriteriaText" id="searchCriteriaText"
				onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
				onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
				value="Search...">
			</s:textfield>
			
			<s:url action="basicFHSearch.action" var="basicSearchDashboardURL" namespace="/int/admin" encode="true" escapeAmp="false"/>
			<a style="margin-left:10px;" class="btn-secondary lookup conditional-btn" href="<s:property value="#basicSearchDashboardURL" />" id="basicFHSearch">
				<s:text name="label.dashboard.search"/>
			</a>
			<img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
			</div>
			<div class="down left" id="arrow" ></div>
			<a href="javascript:;" class="advanceSearch">Advanced Search</a>
			
			</div>
			</s:form>
		</div>
		<div class="clear"></div>
		<jsp:include page="/jsp/dashboard/common/advanceSearchInFeeHistory.jsp"> 
			<jsp:param value="FeeHistory" name="forPage"/>
		</jsp:include>
		
	</div>

</div>