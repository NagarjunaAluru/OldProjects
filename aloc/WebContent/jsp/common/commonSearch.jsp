<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/common/site.js" type="text/javascript"></script>

<div class="row">
	<div class="span12">
		<div class="form-row">
			
			<s:select headerKey="-1" headerValue="All my sites" list="%{#attr['com.ge.aloc.StaticDataFactory'].userSites}" 
			listKey="ID" listValue="name" name="siteId" id="siteId"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			
			<select name="searchCriteriaType" id="searchCriteriaType">
				<option value="1">ALOC Record No</option>
				<option value="2">Applicant/Principal Name</option>
				<option value="3">Beneficiaty/Obligee Name</option>
				<option value="4">Currency and Amount</option>
				<option value="5">Requestor Name</option>
			</select> 
			
			<s:textfield name="searchCriteriaText" id="searchCriteriaText"
				onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
				onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
				value="Search...">
			</s:textfield>
			
			<s:url action="basicSearch.action" var="basicSearchDashboardURL" namespace="/int/dashboard" encode="true" escapeAmp="false"/>
			<a style="margin-left:10px;" class="btn-secondary lookup conditional-btn" href="<s:property value="#basicSearchDashboardURL" />" id="basicSearch">
				<s:text name="label.dashboard.search"/>
			</a>
			<a href="javascript:;" class="advanceSearch">Advanced Search</a>
			
			<jsp:include page="advanceCommonSearch.jsp"/>
			
			
			
		</div>
	</div>

</div>