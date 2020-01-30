<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

<h2 class="span12">Other Considerations</h2>
<div class="clear"></div>
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Cross border</b>
			</p>
			${deal:getCrossBorderFlagValue(pageContext.request)}
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Subordinated Debt</b>
			</p>
			<c:if test="${empty legSummaryVO.isSubordinatedDebt}">
				<td>-</td>
			</c:if>
			<c:if test="${legSummaryVO.isSubordinatedDebt eq true}">
				Yes
			</c:if>
            <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">
            	No
            </c:if>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Non-Standard Legal Agreement</b>
			</p>
				<c:if test="${empty legSummaryVO.isNonStandardAgreementsFlag}">
					<td>-</td>
				</c:if>
				<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">
					Yes
				</c:if>
                <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq false}">
                	No
                </c:if>
		</div>
	</div>
	<!-- end of block -->
</div>

<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">  
	<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="view" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
</c:if>