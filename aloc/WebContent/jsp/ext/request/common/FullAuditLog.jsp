<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

     
      	<h2><s:text name="label.request.bglocSectionName.16"/>-<s:property value="%{requestDetails.auditLogs.size}"/>
      	<p><s:text name="label.request.auditLog.sectionDescription" /><s:property value="requestDetails.alocRecordId"/></p></h2><hr class="h2-hr">
	   <div class="clear"></div>
	         <div class="row">
	            <div class="span12">
                		<c:choose>
		                	<c:when test="${not empty taxonomyViewType}">
		                		<p class="left"><a class="closeFullScreen" href="#"><s:text name="label.request.auditLog.return"/></a></p>
		                	</c:when>
		                	<c:otherwise>
		                	   
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
		      <jsp:include page="/jsp/ext/request/common/searchInAuditLog.jsp"/><br/>
	              <jsp:include page="/jsp/ext/request/common/auditSearchResult.jsp" />
	              <script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
		       	  <script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
	     
 


