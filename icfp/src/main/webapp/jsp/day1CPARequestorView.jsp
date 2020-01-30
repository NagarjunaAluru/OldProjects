<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%
	String servletContextUrl = request.getContextPath();
%>
<script>
var servletContextUrl = '<%=servletContextUrl%>';
</script>


		<%@ include file="/jsp/pipelineReview/CPAOriginalTranscationDetailsRO.jsp"%>
		<jsp:include page="/jsp/common/inc/cpaRequestDetailInput.jsp">
			<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
		</jsp:include>
<!-- Read Only Mode End -->


