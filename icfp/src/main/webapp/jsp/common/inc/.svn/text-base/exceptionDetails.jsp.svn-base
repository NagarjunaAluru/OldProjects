<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el" %>	
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<c:set var="exceptionCount" value="0"></c:set>
<c:forEach var="leg" items="${deal:fetchLegs(pageContext.request)}" varStatus="itemNo">
	<c:set var="exceptionCount" value="${exceptionCount + fn:length(leg.exceptions)}"></c:set>
</c:forEach>

<div class="form-mod" style="overflow-x: auto;">
	<h2 class="span12 collapsible">Exceptions - ${exceptionCount}</h2>
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered sortable exceptions">
				<thead>
					<tr>
						<th>Leg #</th> 
						<th>Standard Terms & Conditions</th>
						<th>Exception Requested</th>
						<th>Rational for Exception</th>
						<th>Exception Timeline</th>
						<th>Remediation Timeline</th>
						<th>Comments</th>
						<th>Attachments</th>
					</tr>
				</thead>
					
				<tbody>
					<c:set var="termsAndConditionsMap" value="${applicationScope['com.ge.icfp.StaticData'].termsAndConditionsMap}" />
					<c:forEach var="leg" items="${deal:fetchLegs(pageContext.request)}" varStatus="itemNo">
						<c:forEach var="exceptionRequest" items="${deal:getExceptions(itemNo.count, pageContext.request)}">
							<tr>
								<td>${leg.legSeqId}</td>
								<td>
									<p>
										<b>Term &amp; Conditions</b><br />
										<c:if test="${empty exceptionRequest.standardTermsConditionsId}">
											--
										</c:if>
										<c:if test="${not empty exceptionRequest.standardTermsConditionsId}">
											<c:choose>
												<c:when test="${not empty exceptionRequest.standardTermsConditions}">
													${exceptionRequest.standardTermsConditions}
												</c:when>
												<c:otherwise>
													${termsAndConditionsMap[exceptionRequest.standardTermsConditionsId]}
												</c:otherwise>
											</c:choose>
										</c:if>	
									</p>
								</td>
								<td>
									<p>
										<b>Exception</b><br />
										<c:choose>
											<c:when test="${not empty exceptionRequest.requestedException}">
												${exceptionRequest.requestedException}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td>
									<p>
										<b>Impact</b><br />
										<c:choose>
											<c:when test="${not empty exceptionRequest.rationaleForExceptionImpact}">
												${exceptionRequest.rationaleForExceptionImpact}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
									<br />
									<p>
										<b>Potential alternatives</b><br />
										<c:choose>
											<c:when test="${not empty exceptionRequest.rationaleForExceptionPotentialAlternatives}">
												${exceptionRequest.rationaleForExceptionPotentialAlternatives}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td>
									<p>
										<b>Timeline</b><br />
										<c:choose>
											<c:when test="${not empty exceptionRequest.exceptionTimeline}">
												${exceptionRequest.exceptionTimeline}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td>
									<p>
										<b>Estimated Timeframe</b><br />
										<c:choose>
											<c:when test="${not empty exceptionRequest.remediationTimeline}">
												${exceptionRequest.remediationTimeline}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td>
									<p>
										<b>Comments</b><br />
										${exceptionRequest.actionBy}
									</p><br />
									<p>
										<c:choose>
											<c:when test="${not empty exceptionRequest.remediationTimelineComments}">
												${exceptionRequest.remediationTimelineComments}
											</c:when>
											<c:otherwise>
												--
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td>
									<p>
										<b>Attachments</b><br />
										<c:forEach var="attachment" items="${exceptionRequest.attachments}">
											<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${attachment.geFileId}' class='attachment-link'>${attachment.origAttachmentName} </a>
											<br />
										</c:forEach>
									</p>
								</td>							
							</tr> 
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div> 
</div><!-- end of form form-mod -->
