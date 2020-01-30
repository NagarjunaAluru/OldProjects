<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	  <h2><s:text name="label.request.transactionHistory"/>-<s:property value="%{requestDetails.actionLogs.size}"/>
	  <p><s:text name="label.request.transactionHistoryLog.sectionDescription" /> <s:property value="requestDetails.alocRecordId"/></p></h2><hr class="h2-hr">
	   <div class="clear"></div>
	         <div class="row">
	            <div class="span12">
                	 <s:url action="openRequest.action" var="openTaxonomyRequestURL" namespace="/ext" escapeAmp="false" encode="true">
                		<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
                		<s:param name="dashboardViewType">ALLREQUESTS</s:param>
                		<s:param name="stage"><s:property value="requestDetails.WFDetails.WFStageID"/></s:param>
                		<s:param name="stageName"><s:property value="requestDetails.WFDetails.WFStage"/></s:param>
                		<s:param name="instrumentId"><s:property value="requestDetails.instrumentID"/></s:param>
                		<c:if test="${instrumentID eq 5}">
                			<s:param name="amendmentId"><s:property value="amendmentId"/></s:param>
                		</c:if>
                		<c:if test="${instrumentID eq 6}">
                			<s:param name="amendmentId"><s:property value="riderId"/></s:param>
                		</c:if>
                	</s:url>
                	<c:choose>
	                	<c:when test="${not empty taxonomyViewType}">
	                		<p class="left"><a href="<s:property value="openTaxonomyRequestURL"/>"><s:text name="label.request.auditLog.return"/></a></p>
	                	</c:when>
	                	<c:otherwise>
	                	     <s:url action="openRequest.action" var="openRequestURL" namespace="/ext" escapeAmp="false" encode="true">
		                		<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
		                		<s:param name="stageName"><s:property value="requestDetails.WFDetails.WFStage"/></s:param>	
                	        </s:url>
	                		<p class="left"><a class="closeFullScreen" href="#"><s:text name="label.request.auditLog.return"/></a></p>
	                	</c:otherwise>
                	</c:choose>
				</div>
		    </div> <br/>    
		     <div class="row">
		       <div class="span12">
		       <div id="searchError" class="searchError" style="display: none;">
				 <div class="errorbox">
					<div class="errorHead">
						<a href="#" class="right errorClose">X</a>
						<img src='${pageContext.request.contextPath}/ext/public/img/error.png' style="padding-left: 5px;"/>
						<p class="erroricon" style="margin-top: -45px;"><s:text name="label.common.error"/></p>						
					</div>
                 <div class="errorContent"></div>
             </div>
            </div>	
          </div>
          </div> 
		   <jsp:include page="/jsp/ext/request/common/searchInActionLog.jsp"/><br/>
		   <jsp:include page="/jsp/ext/request/common/ActionLogSearchResult.jsp" />

			<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
			<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
 