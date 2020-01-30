<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="user" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>


<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-fileupload-plugin/jquery.fileupload.js"></script>
 
<fmt:setLocale value="en-US"/>
<t:common/>

	<c:set var="requestFrmtDt" value="" />
	<c:if test="${not empty sessionScope.deal.requestDt}">
		<c:set var="requestFrmtDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.requestDt, 'MM/dd/yyyy')}" />
	</c:if>
	<div class="form-mod ${param.view eq 'modal' ? 'span8' : ''}">
			
			<c:if test="${param.view ne 'modal'}">
				<h2 class="span12 collapsible">eBoardroom</h2>
			</c:if>			
			<p><b>The following information will be sent to eBoardroom.
			
			<c:if test="${param.view eq 'modal'}">
				Please include your comments below.
			</c:if>
			</b></p><br />
			<div class="row highlighted">
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'}">
					<div class="form-row">
						<p><b>Deal ID </b><br />
							${sessionScope.deal.uniqueId}
						</p>
					</div>
				</div><!-- end of block -->
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} right">
					<div class="form-row">
						<p><b>Deal Name </b><br />
							${sessionScope.deal.dealName}
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'}">
					<div class="form-row">
						<p><b>Deal Category </b><br />
							${sessionScope.deal.dealCategory}
						</p>
					</div>
				</div><!-- end of block -->
				
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} right">
					<div class="form-row">
						<p><b>Date of Transaction</b><br />
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
				
			</div>
			<div class="row highlighted">
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'}">
					<div class="form-row">
						<p><b>Usd Equivalent of Highest Leg </b><br />
						 <fmt:formatNumber type="number">${sessionScope.deal.highestLegAmt}</fmt:formatNumber>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} right">
					<div class="form-row">
						<p><b>Transaction Classification Level</b><br />
							<c:choose>
							<c:when test="${deal:getRiskOverride(pageContext.request) eq 'Yes'}">
								${sessionScope.deal.ruAmendedTcl}
							</c:when>
							<c:otherwise>
								${sessionScope.deal.dealTcl}
							</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				
			</div>
			
			<div class="row">
				<div class="${param.view eq 'modal' ? 'span8' : 'span12'}">
				<table class="table table-striped table-bordered sortable active">
				<thead><tr>
					<th colspan="2">List of Prior Approvers</th>
				</tr></thead>
				<tbody>
					<c:if test="${not empty sessionScope.deal.EBRPriorApprs}">
					<c:set var="i" value="1"/>
					<tr>
					<c:forEach items="${sessionScope.deal.EBRPriorApprs}" var="eachApprovers">
					<td width="50%">${eachApprovers.lastName}, ${eachApprovers.firstName}</td>
					<c:if test="${(i mod 2) eq 0}"></tr><tr></c:if>
					<c:set var="i" value="${i+1}"/>
					</c:forEach>
					<c:if test="${(i mod 2) eq 0}"><td width="50%">&nbsp;</td></c:if>
					</tr>
					</c:if>
				</tbody>
				</table>
				</div>
			</div>
			<c:if test="${param.view ne 'modal'}" >
			<div class="row highlighted">
				<div class="${param.view eq 'modal' ? 'span8' : 'span12'}">
					<div class="form-row autosize-container">
						 <b>Summary of Transaction </b><br />	
						  <p style="word-wrap:break-word">${not empty deal:getEboardComments(pageContext.request) ? deal:getEboardComments(pageContext.request) :'-'}</p> 
					</div>
				</div><!-- end of block -->
				
			</div>
			</c:if>
		<h2 class="${param.view eq 'modal' ? 'span8' : 'span12'} "> Attachments</h2>		
			<div class="row highlighted">
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'}">
					<div class="form-row">
						<p><b>Underwriting File </b><br />
							<a href="${context}/underwriting.do?command=downloadUnderWritingFile">View/Download</a>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} right">
					<div class="form-row">
				<p>
					<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><br />  
				</p>
				
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 
				
					</div>
				</div><!-- end of block -->
				
			</div>
			
			
			<div class="row ">
				
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} left">
					<div class="form-row">
				<p>
					<b>Equity Approval Pitch File</b><br />  
				</p>
				
			
				<div id="Equity_Pitch" class="icfpAttachmentArea">
								<c:set var="equityPitchAttachmentsList" value="${atmtfunctions:getDealAttachments(11, pageContext.request)}" />
								<c:choose>
									<c:when test="${not empty equityPitchAttachmentsList}">
										<c:forEach var="equityPitchAttachment" items="${equityPitchAttachmentsList}">
											<div class="icfpAttachment">
												<c:if test="${(not empty mode) && mode == 'edit' && equityPitchAtmtPermissions.deletable}">
													<a href='javascript:void(0)' class='attachment-del-link' onclick="javascript:deleteAttachment('${equityPitchAttachment.geFileId}')">
														<img src='${pageContext.request.contextPath}/img/delete.gif' border='0' align='absmiddle'> 
													</a> &nbsp;
												</c:if>
												<a href='${pageContext.request.contextPath}/attachmentAction.do?command=download&geLibFileId=${equityPitchAttachment.geFileId}' class='attachment-link'>${equityPitchAttachment.origAttachmentName} </a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</div>
					
					</div> 
				 
				
				</div><!-- end of block -->
				
				<div class="${param.view eq 'modal' ? 'span4' : 'span5'} right">
					<div class="form-row">
				<p>
					<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><br />  
				</p>
				
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 
				
					</div>
				</div><!-- end of block -->
				
				
			</div>
			
			
		</div>