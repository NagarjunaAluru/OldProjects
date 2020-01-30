<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>

<div class="display-row">

	<h2 class="span12">Other Considerations</h2>
	<div class="clear"></div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Non-Standard Legal Agreement<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></b>
				</p>
				<p>${deal:getNonStandardDocsFlag(pageContext.request)}</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Cross border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></b>
				</p>
				<p>${deal:getCrossBorderFlagValue(pageContext.request)}</p>
			</div>
		</div>
		<!-- end of block -->
	</div>


</div>
<!-- display role ends here -->


<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
<c:choose>
	<c:when test="${nonStandardDocsFlag eq 'Yes'}">
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="view" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
