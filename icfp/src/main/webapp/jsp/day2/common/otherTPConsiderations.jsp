<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>

<div class="form-mod" style="width:100%;">
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<h2>Other Considerations</h2>
			<div>
			<div class="clear"></div>
				<div>

				<div class="row highlighted">
					<div class="span5">
							<label>Cross border</label>
							${deal:getCrossBorderFlagValue(pageContext.request)}
					</div> 
					<div class="span5 right ">
							<label>Subordinated Debt</label>
								 <c:if test="${legSummaryVO.isSubordinatedDebt eq true}">Yes</c:if>
                                 <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">No</c:if>
							
					</div> 
				</div>
                
				<div class="row">
					<div class="span5">
                                <label>Non-standard Legal Agreement(s)</label>
                                 <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">Yes</c:if>
                                 <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq false}">No</c:if>
						</div>
				</div>                
                
			</div>
        </div>
	</div>
        
      <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">  
	      <jsp:include page="/jsp/common/legPageExceptions.jsp">
			<jsp:param value="view" name="mode"/>
			<jsp:param value="${legNumber}" name="legIndex"/>      	
	      </jsp:include>
	 </c:if>