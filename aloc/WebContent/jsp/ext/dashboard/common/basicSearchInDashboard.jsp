<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<div class="row">
	<div class="span12">
		<div class="form-row" style="text-align:right!important;" id="basicSearch">
			<s:form name="basicSearchForm" id="basicSearchFormID" action="basicSearch.action" namespace="/ext/dashboard">
			
			<div class="right">
				<div class="left span7">
				
				<c:choose>
        		<c:when test="${param.dashboardType eq 'BidProcessBank'}">
        			<select name="searchCriteriaType" id="searchCriteriaType">
							<option value="1">ALOC record number</option>
							<option value="2">Instrument amount greater than</option>
							<option value="10">Tri-Party Applicant name</option>
							<option value="3">Applicant Name</option>
							<option value="4">Beneficiary Name</option>
							<option value="6">Instrument purpose</option>
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
					</select> 
        		</c:when>
        	</c:choose>
			
				<s:textfield name="searchCriteriaText" id="searchCriteriaText"
					onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
					onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
					value="Search...">
				</s:textfield>
				<c:set var="dashboardType" value=""></c:set>
				<c:choose>
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
				<s:url action="basicSearch.action" var="basicSearchDashboardURL" namespace="/ext/dashboard" encode="true" escapeAmp="false"/>
				<a style="margin-left:10px;" class="btn-secondary lookup conditional-btn" href="<s:property value="#basicSearchDashboardURL" />" id="basicSearch">
					<s:text name="label.dashboard.search"/>
				</a>
				<img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" 
					style="height: 20px; display:none">
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