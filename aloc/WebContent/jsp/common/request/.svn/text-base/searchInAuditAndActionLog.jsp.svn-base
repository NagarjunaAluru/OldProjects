<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<div class="row">
	       <div class="span2">
				<label><s:text name="label.request.transactionHistoryLog.tableHeader.1"/></label>
				 <s:textfield name="date" cssClass="date startDate"/>
				<p><s:text name="label.request.searchDateFormat"/></p>
			</div>
			<div class="span1">
			  <label>&nbsp;</label>
				to
			</div>
		    <div class="span2">
				<label>&nbsp;</label>
				 <s:textfield name="date" cssClass="date startDate"/>
				<p><s:text name="label.request.searchDateFormat"/></p>
			</div>
			<c:choose>
					<c:when test="${param.logType eq 'auditLog'}">
						 <div class="span2">
						     <label><s:text name="label.request.auditLog.tableHeader.4"/></label>
							 <select name="searchCriteriaType" id="searchCriteriaType" class="span2">
							      <option value="-1">All attributes</option>
							</select> 
						</div>
					</c:when>
					<c:when test="${param.logType eq 'actionLog'}">
						 <div class="span2">
						     <label><s:text name="label.request.transactionHistoryLog.tableHeader.3"/></label>
							 <select name="searchCriteriaType" id="searchCriteriaType" class="span2">
							      <option value="-1">All actions</option>
							</select> 
						</div>
				  </c:when>
		  </c:choose>
			
		  <div class="span4">
				 <label><s:text name="label.request.auditLog.tableHeader.8"/></label>
				 <s:textfield name="searchCriteriaText" id="searchCriteriaText"
						onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
						onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
						value="Search...">
				</s:textfield>&nbsp;
				 <input type="submit" value="<s:text name="label.dashboard.search"/>" class="btn" />
				 <img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
				style="height: 20px; display:none">
			</div>	
 </div>
		    
			
	