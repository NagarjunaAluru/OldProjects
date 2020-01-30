<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%String servletContextUrl = request.getContextPath();%>

<script type="text/javascript">
	servletContextUrl = '<%=servletContextUrl%>';
</script>

<script src="<%=servletContextUrl%>/js/day2/day2Equity.js" type="text/javascript"></script>
	
	
			
<c:choose>
	<c:when test="${param.actionId eq 1}">
	
	

		<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" id = "legNumber" value="${requestScope.legNumber}" />	
  		<%@ include file="../../common/inc/day2/day2PayerReceiver.jsp"%>
		<%@ include file="../../common/inc/day2/day2DividendPaymentDetails.jsp"%>	
		<%@ include file="../../common/inc/day2/day2SettlementDetails.jsp"%>
		<%@ include file="../../common/inc/day2/day2OtherConsiderations.jsp"%>
		

				<!-- starts uploads-->
				<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
					<jsp:param name="legIndex" value="${legNumber}" />
				</jsp:include>  
				<!-- end uploads -->
        		<div class="span12 right btn-container" style="margin-left: -20px;">
			<input type="button" value="Save and return to Deal"
				class="btn right btn-success"
				onclick="javascript:validateLegDividends('');">
			<input type="button" value="Save" class="btn right"
				onclick="javascript:saveLeg();"> <a
				href="#confirm" class="btn-link right cancel modal-confirm"
				data-toggle="modal">Cancel</a>
		</div>

		<div class="modal hide fade" id="confirm">
			<div class="modal-header">
				<a class="close" href="javascript:closeConfirmModal()">X</a>
				<h3>Cancel Leg</h3>
			</div>
			<div class="modal-body" style="margin-top:-16px;">
				<div class="row">
					<p>
						<b>Are you sure you want to cancel?</b><br> Any changes you
						have made will be lost
					</p>
				</div>
			</div>
			<div class="modal-footer">
				<a href="javascript:cancel();" class="btn right btn-success">Yes, cancel the leg</a> 
				<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the leg</a>
			</div>
		</div>
		</html:form>
        
        
	</c:when>
	<c:otherwise>
	
		<jsp:include page="/jsp/day2/common/originalTPLenderBorrower.jsp">
		 	<jsp:param value="${param.id}" name="id" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2DividendPaymentDetailsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2SettlementDetailsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2OtherConsiderationsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>
		<div class="form-mod">
			<jsp:include page="../../common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="ICFPLegRequestForm"/>			
			</jsp:include>
		</div>
		
<!-- attachments rca start of block -->
		    <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		    <jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        </jsp:include>  
		   
		   <jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="ICFPLegRequestForm"/>
		   </jsp:include>
		    <!-- need to add param for the form to differentiate -->
		<a class="btn-link right cancel"  onclick="history.back();">Cancel</a>

	</c:otherwise>
</c:choose>


<input type="hidden" id="actionId" value="${actionId}">
</body>