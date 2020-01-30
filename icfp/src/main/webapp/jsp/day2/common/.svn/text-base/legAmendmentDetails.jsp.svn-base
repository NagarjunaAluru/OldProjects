<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el" %>	
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<% String servletContextUrl1 = request.getContextPath(); 
%>
		<div class="form-mod">
			<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
			<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
			<h2 class="span12 collapsible">Amendments - ${fn:length(day2legSummaryVO.amendments)}</h2>
			<div class="clear"></div>
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
				<%int k=0; %>
					<c:forEach var="exceptionRequest" items="${day2legSummaryVO.amendments}" varStatus="itemNo">
						
						
						<tr>
							<td>${legSummaryVO.legSeqId}  </td>
							<td><p><b>Term &amp; Conditions</b><br />
								<c:if test="${empty exceptionRequest.amendmentType}">
									--
								</c:if>
								<c:if test="${not empty exceptionRequest.amendmentType}">
									${exceptionRequest.amendmentType}
								</c:if>
								
								</p>
							</td>
							<td><p><b>Exception</b><br />
								<c:if test="${empty exceptionRequest.requestedException}">
									--
								</c:if>
								<c:if test="${not empty exceptionRequest.requestedException}">
									${exceptionRequest.requestedException}
								</c:if>	
								</p>
							</td>
							<td><p><b>Impact</b><br />
								<c:if test="${empty exceptionRequest.rationaleForExceptionImpact}">
									--
								</c:if>
								<c:if test="${not empty exceptionRequest.rationaleForExceptionImpact}">
									${exceptionRequest.rationaleForExceptionImpact}
								</c:if>	
								</p><br />
								<p><b>Potential alternatives</b><br />
									<c:if test="${empty exceptionRequest.rationaleForExceptionPotentialAlternatives}">
										--
									</c:if>
									<c:if test="${not empty exceptionRequest.rationaleForExceptionPotentialAlternatives}">
										${exceptionRequest.rationaleForExceptionPotentialAlternatives}
									</c:if>	
								</p>
							</td>
							<td><p><b>Timeline</b><br />
								<c:if test="${empty exceptionRequest.exceptionTimeline}">
									--
								</c:if>
								<c:if test="${not empty exceptionRequest.exceptionTimeline}">
									${exceptionRequest.exceptionTimeline}
								</c:if>	
								</p>
							</td>
							<td><p><b>Estimated Timeframe</b><br />
									<c:if test="${empty exceptionRequest.remediationTimelineTimeframe}">
									--
								</c:if>
								<c:if test="${not empty exceptionRequest.remediationTimelineTimeframe}">
									${exceptionRequest.remediationTimelineTimeframe}
								</c:if>	
								</p>
							</td>
							<td><p><b>Comments</b><br />
								<p>
									<c:if test="${empty exceptionRequest.remediationTimelineComments}">
										--
									</c:if>
									<c:if test="${not empty exceptionRequest.remediationTimelineComments}">
										${exceptionRequest.remediationTimelineComments}
									</c:if>
								</p>
							</td>
							<td><p><b>Attachments</b><br />
			
		 		
					
					
								</p>
							</td>							
						</tr> 
						</c:forEach>
					 </tbody>
				
				  </table>
				 
				</div>
			</div> 
        </div><!-- end of form form-mod -->
