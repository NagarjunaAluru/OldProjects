<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
	<c:set var="valueFrmtDt" value="" />
	<c:set var="requestFrmtDt" value="" />
	<c:if test="${not empty sessionScope.deal.valueDt}">
		<c:set var="valueFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.valueDt, 'MM/dd/yyyy')}" />
	</c:if>
	<c:if test="${not empty sessionScope.deal.requestDt}">
		<c:set var="requestFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.requestDt, 'MM/dd/yyyy')}" />
	</c:if>

		<div class="form-mod">
		<h2 class="span12 collapsible">Transaction Priority and Timing</h2>
		<div class="clear"></div>
		<c:choose>
		<c:when test="${param.page eq 'valueDateEntered'}">
		<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.priority" /></b><br />
							${ sessionScope.deal.priority }
							</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.regionResponsibility" /></b><br />
						${ sessionScope.deal.responsibleRegion }
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p style="word-wrap: break-word">
						<b><bean:message key="label.pipelineReviewDeal.priorityComments" /></b><br />
							<c:choose>
								<c:when test="${empty sessionScope.deal.priorityComment}">
									<bean:message key="label.newRequests.data" />
								</c:when>
								<c:otherwise>
									${ sessionScope.deal.priorityComment }
								</c:otherwise>
							</c:choose>
							</p>
					</div>
				</div><!-- end of block -->

				<div class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.pipelineReviewDeal.valueDate" /></label>
					
					<logic:messagesPresent property="valueDateInPipeLineReview">
							<span id="serverValueDateValidationID" class="help-block error"><bean:message key="valueDateInPipeLineReview" /></span>
						</logic:messagesPresent>
						<logic:messagesPresent property="dayOfTheWeek">
							<span  class="help-block error"><bean:message key="dayOfTheWeek" /></span>
						</logic:messagesPresent> 
					<span  class="help-block error" id="valueDateValidationID" style="display:none" ><bean:message key="valueDateInPipeLineReview" /></span>	
				 <input type="text" name="valueDt"  readonly="readonly" value="${valueFrmtDt}" class="span3 date" maxlength="10"  id="valueDt" />   
				  <span class="req-error" id="errorDate">error</span> 
						<span class="help-block clear">MM/DD/YYYY</span>
						
						
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Request Date</b><br />
							<c:choose>
							<c:when test="${requestFrmtDt eq '//'}">
								-
							</c:when>
							<c:otherwise>
								${requestFrmtDt}
							</c:otherwise>
						</c:choose></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p>&nbsp;<br />&nbsp;
						</p>
					</div>
				</div><!-- end of block -->
			</div>			
			</c:when>
		<c:otherwise>
		<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.priority" /></b><br />
							<c:choose>
								<c:when test="${empty sessionScope.deal.priority}">
									<bean:message key="label.newRequests.data" />
								</c:when>
								<c:otherwise>
									${ sessionScope.deal.priority }
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.regionResponsibility" /></b><br />
							<c:choose>
								<c:when test="${empty sessionScope.deal.responsibleRegion}">
									<bean:message key="label.newRequests.data" />
								</c:when>
								<c:otherwise>
									${ sessionScope.deal.responsibleRegion }
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p style="word-wrap: break-word">
						<b><bean:message key="label.pipelineReviewDeal.priorityComments" /></b><br />
							<c:choose>
								<c:when test="${empty sessionScope.deal.priorityComment}">
									<bean:message key="label.newRequests.data" />
								</c:when>
								<c:otherwise>
									${ sessionScope.deal.priorityComment }
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.valueDate" /></b><br />
						<c:choose>
							<c:when test="${valueFrmtDt eq '//'}">
								-
							</c:when>
							<c:otherwise>
								${valueFrmtDt}
							</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Request Date</b><br />
							<c:choose>
							<c:when test="${requestFrmtDt eq '//'}">
								-
							</c:when>
							<c:otherwise>
								${requestFrmtDt}
							</c:otherwise>
						</c:choose></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p>&nbsp;<br />&nbsp;
						</p>
					</div>
				</div><!-- end of block -->
			</div>			
		</c:otherwise>
		</c:choose>
				</div>
