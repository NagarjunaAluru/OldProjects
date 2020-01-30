<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.include == 'Yes'}">
<script src="${pageContext.request.contextPath}/js/common/section.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/section.css" rel="stylesheet">
</c:if>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<div class="form-mod" id="auditLogDiv">
		<h2 id="auditlog" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.auditLog"/></a>
				</h2><hr class="h2-hr">
				<div id="auditlogPanel" class="section_panel">
				     <ul class="nav nav-tabs tabs" >
						<li class="active"><a data-toggle="tab" href="#18"><s:text name="label.request.bglocSectionName.16"/></a></li>
						<li><a data-toggle="tab" href="#19"><s:text name="label.request.transactionHistory"/></a></li>
					</ul>
					
					<div class="tab-content" id="myTabContent">
						<div id="18" class="tab-pane fade active in">
						   <s:if test="%{requestDetails.auditLogs.size>5}">
						    <s:url action="getFullAuditAndActionLog.action" namespace="/int/approver" var="showFullAuditLog" escapeAmp="false">
						       <s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
						       <s:param name="logType">audit</s:param>
						       <s:param name="stageName"><s:property value="requestDetails.WFDetails.WFStage"/></s:param>
					       </s:url>
						     <p class="right"><a class="fullScreen" href="<s:property value="#showFullAuditLog"/>"><s:text name="label.request.auditLog.fullAuditLog"/></a></p>
						   </s:if>
			               <jsp:include page="/jsp/common/request/AuditLog.jsp" />
			            </div>
			            <div id="19" class="tab-pane fade">
			                 <s:if test="%{requestDetails.actionLogs.size>5}">
			                    <s:url action="getFullAuditAndActionLog.action" namespace="/int/approver" var="showFullActionLog" escapeAmp="false">
							        <s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
							        <s:param name="logType">action</s:param>
							        <s:param name="stageName"><s:property value="requestDetails.WFDetails.WFStage"/></s:param>
							    </s:url>
			                   <p class="right"><a class="fullScreen" href="<s:property value="#showFullActionLog"/>"><s:text name="label.request.transactionFullHistoryLog"/></a></p>
			                 </s:if>
			                  <jsp:include page="/jsp/common/request/TransactionHistoryLog.jsp"/>
			            </div>
			        </div>
			  </div>
</div>		