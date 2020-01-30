<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<c:set var="isTreasury" value="N"/>
<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
	<c:set var="isTreasury" value="Y"/>
</hwfs:checkComponentPermission>
<div class="row">
	<div class="span12">
		<div id="searchError" class="searchError" style="display: none; margin-top: 5px;">
		<div class="errorbox">
			<div class="errorHead">
				<a href="#" class="right errorClose">X</a>
				<img src='${pageContext.request.contextPath}/img/error.png' style="padding-left: 5px;"/>
				<p class="erroricon" style="margin-top: -45px;"><s:text name="label.common.error"/></p>
			</div>
			<div class="errorContent"></div>
		</div>
		</div>
		<div class="form-row" style="text-align:right!important;" id="basicSearch">
			<s:form name="basicSearchForm" id="basicSearchFormID" action="basicSearch.action" namespace="/int/dashboard">
			<div class="left">
			    <s:if test="%{userSpecificSitesList!=null && userSpecificSitesList.size > 1}">
					<s:select headerKey="-1" headerValue="All my sites" list="userSpecificSitesList" 
					listKey="ID" listValue="name" name="siteId" id="siteId"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				</s:if>
			</div>
			<div class="right">
				<div class="left span7">
				
				<c:choose>
        		<c:when test="${param.dashboardType eq 'MyTransaction' 
        		or param.dashboardType eq 'AllRequest'
        		or param.dashboardType eq 'Draft'}">
		        		<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<%-- <c:if test="${sessionScope.isIndustrialBusiness}"> --%>
								<option value="3">Applicant/Principal Name</option>
							<%-- </c:if> --%>
							<option value="4">Beneficiary/Obligee Name</option>
							<option value="5">Requestor Name</option>
							<option value="6">Purpose</option>
							<c:if test="${param.dashboardType eq 'MyTransaction' or param.dashboardType eq 'AllRequest'}">
								<option value="7">State</option>
							</c:if>
							<c:if test="${isTreasury =='N'}">
							<hwfs:checkComponentPermission name="BusinessDashboardAccess" domainName="BusinessAccess">
							<option value="8">Bundle ID</option>
							</hwfs:checkComponentPermission>
							</c:if>
							<c:if test="${param.dashboardType eq 'AllRequest'}">
								<option value="11">Bank reference number</option>
								<option value="12">Surety Reference Number</option>
							</c:if>
						</select> 
				</c:when>
        		<c:when test="${param.dashboardType eq 'Model'}">
	        		<select name="searchCriteriaType" id="searchCriteriaType">
	        			<option value="14">Model Name</option>
						<option value="3">Applicant/Principal Name</option>
						<option value="4">Beneficiary/Obligee Name</option>
						<option value="5">Creator</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'Bundle'}">
		        	<select name="searchCriteriaType" id="searchCriteriaType">
						<option value="1">ALOC record number</option>
						<option value="3">Applicant/Principal Name</option>
						<option value="4">Beneficiary/Obligee Name</option>
						<option value="5">Requestor Name</option>
						<option value="7">State</option>
						<c:if test="${isTreasury =='N'}">
						<hwfs:checkComponentPermission name="BusinessDashboardAccess" domainName="BusinessAccess">
							<option value="8">Bundle ID</option>
						</hwfs:checkComponentPermission>
						</c:if>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BidProcessTreasury'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="3">Applicant/Principal Name</option>
							<option value="4">Beneficiary/Obligee Name</option>
							<option value="5">Requestor Name</option>
							<option value="6">Purpose</option>
							<option value="7">State</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BidProcessBank'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="10">Tri-Party Applicant name</option>
							<option value="3">Applicant Name</option>
							<option value="4">Beneficiary Name</option>
							<option value="6">Instrument purpose</option>
							<option value="7">State</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BankPendingInce'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="10">Tri-Party Applicant name</option>
							<option value="3">Applicant Name</option>
							<option value="4">Beneficiary Name</option>
							<option value="6">Instrument purpose</option>
							<option value="7">State</option>
							<option value="11">Bank reference number</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BankHistoricTrans'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="10">Tri-Party Applicant name</option>
							<option value="3">Applicant Name</option>
							<option value="4">Beneficiary Name</option>
							<option value="6">Instrument purpose</option>
							<option value="7">State</option>
							<option value="11">Bank reference number</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BidProcessBroker'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="3">Principal Name</option>
							<option value="4">Obligee Name</option>
							<option value="6">Instrument purpose</option>
							<option value="7">State</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BrokerPendingInce'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="12">Surety Reference Number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="3">Principal Name</option>
							<option value="4">Obligee Name</option>
							<option value="6">Instrument Purpose</option>
							<option value="7">State</option>
					</select> 
        		</c:when>
        		<c:when test="${param.dashboardType eq 'BrokerHistoricTrans'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="12">Surety Reference Number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="3">Principal Name</option>
							<option value="4">Obligee Name</option>
							<option value="6">Instrument Purpose</option>
							<option value="7">State</option>
					</select> 
        		</c:when>
        	</c:choose>
			
				<s:textfield name="searchCriteriaText" id="searchCriteriaText"
					onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
					onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
					value="Search..." cssStyle="margin-left:10px!important;">
				</s:textfield>
				<c:set var="dashboardType" value=""></c:set>
				<c:choose>
					<c:when test="${param.dashboardType eq 'MyTransaction'}">
						<c:set var="dashboardType" value="MYTRANSACTIONS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'AllRequest'}">
						<c:set var="dashboardType" value="ALLREQUESTS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'Draft'}">
						<c:set var="dashboardType" value="DRAFTS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'Model'}">
						<c:set var="dashboardType" value="MODEL"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'Bundle'}">
						<c:set var="dashboardType" value="BUNDLES"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BidProcessTreasury'}">
						<c:set var="dashboardType" value="TREASURYBIDPROCESS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BidProcessBank'}">
						<c:set var="dashboardType" value="BANKBIDPROCESS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BankPendingInce'}">
						<c:set var="dashboardType" value="TREASURYBANKPENDINGINCE"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BankHistoricTrans'}">
						<c:set var="dashboardType" value="TREASURYBANKHIST"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BidProcessBroker'}">
						<c:set var="dashboardType" value="TREASURYBROKERBIDPROCESS"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BrokerPendingInce'}">
						<c:set var="dashboardType" value="TREASURYBROKERPENDINGINCE"></c:set>
					</c:when>
					<c:when test="${param.dashboardType eq 'BrokerHistoricTrans'}">
						<c:set var="dashboardType" value="TREASURYBROKERHIST"></c:set>
					</c:when>
				</c:choose>
				<input type="hidden" name="dashboardViewType" value="${dashboardType}" id="dashboardViewTypeId"/>
				<s:url action="basicSearch.action" var="basicSearchDashboardURL" namespace="/int/dashboard" encode="true" escapeAmp="false"/>
				<a style="margin-left:10px;" class="btn-secondary lookup conditional-btn" href="<s:property value="#basicSearchDashboardURL" />" id="basicSearch">
					<s:text name="label.dashboard.search"/>
				</a>
				<img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
					style="margin-left: 0px!important; position: relative;margin-top: -5px!important;">
				</div>
				<div class="down left" id="arrow" ></div>
			
				<a href="javascript:;" class="advanceSearch" id="${dashboardType}">Advanced Search</a>
			</div>
			</s:form>
		</div>
		<div class="clear"></div>
		<jsp:include page="advanceSearchInDashboard.jsp" >
			<jsp:param value="Dashboard" name="forPage"/>
		</jsp:include>
			
	</div>

</div>