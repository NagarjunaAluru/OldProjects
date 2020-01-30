<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!-- Settlement/Other Details  Start -->
<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(1, pageContext.request)}" 	scope="page" />

<div class="display-row">
        
			<c:if test="${param.transactionEventTypeId eq '1'}"> <h2 class="span12">Settlement Details</h2> </c:if>
<c:if test="${param.transactionEventTypeId eq '2'}"> <h2 class="span12">Other Details</h2> </c:if>
            <div class="clear"></div>
            <div class="row highlighted">
                <div class="span12">
                    <div class="form-row">
                        
                         <c:if test="${param.transactionEventTypeId eq '1'}">
							<p>
							<c:if test="${empty day2legSummaryVO.settlementDetailsComments}">
							-
							</c:if>
							<c:if test="${not empty day2legSummaryVO.settlementDetailsComments}">
							${day2legSummaryVO.settlementDetailsComments}
							</c:if>
							</p>
		
						</c:if>
                         
						<c:if test="${param.transactionEventTypeId eq '2'}">
							<p>
							<c:if test="${empty day2legSummaryVO.otherDetailsComments}">
							-
							</c:if>
							<c:if test="${not empty day2legSummaryVO.otherDetailsComments}">
							${day2legSummaryVO.otherDetailsComments}
							</c:if>
							</p>
		
						</c:if>
                    </div>
                </div><!-- end of block -->
            </div>

        </div>
        
        