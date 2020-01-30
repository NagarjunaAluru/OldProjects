<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el" %>	
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<% String servletContextUrl1 = request.getContextPath(); 
%>
		
		<div class="form-mod">
			<h2 class="span12 collapsible">Exceptions - [N]</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable exceptions">
					<thead>
					  <tr>
						<th colspan="2">Action</th>
						<th>Leg #</th>
						<th>Standard Terms</th>
						<th>Request Exception</th>
						<th>Rational for Exception</th>
						<th>Exception Timeline</th>
						<th>Remediation Timeline</th>
						<th>Comments</th>
						<th>Attachments</th>
					  </tr>
					</thead>
					<tbody>
					<logic:iterate  name="deal" scope="session" name="legDetails" id="leg" indexId="itemNo">
						<logic:iterate name="leg" property="exceptions" id="exceptionRequest" indexId="k">
						<tr>
							<td><a href="#" title="Delete this exception" class="delete-tr">X</a></td>
							<td><a class="edit-leg ttip" href="#" data-original-title="Edit this Exception"></a></td>
							<td>${itemNo+1}</td>
							<td><p><b>Term & Conditions</b><br />
									${exceptionRequest.standardTermsConditions}</p>
							</td>
							<td><p><b>Exception</b><br />
									${exceptionRequest.requestedException}</p>
							</td>
							<td><p><b>Impact</b><br />
									${exceptionRequest.rationaleForExceptionImpact}</p><br />
								<p><b>Potential alternatives</b><br />
									${exceptionRequest.rationaleForExceptionPotentialAlternatives}</p>
							</td>
							<td><p><b>Timeline</b><br />
									${exceptionRequest.exceptionTimelineId}</p>
							</td>
							<td><p><b>Timeframe</b><br />
									${exceptionRequest.remediationTimelineId}</p>
							</td>
							<td><p><b>Comments</b><br />
									[First Name], [Last Name] - [TIME] AM/PM EST</p><br />
									<p>${exceptionRequest.remediationTimelineComments}</p>
							</td>
							<td><p><b>Attachments</b><br />
					<c:set var="exptIndex" value="<%=String.valueOf(k+1)%>" />
					<%
					String exptIndex = (String)pageContext.getAttribute("exptIndex");
					
					%>
					
								</p>
							</td>							
						</tr> 
						</logic:iterate>
						</logic:iterate>
					 </tbody>
				  </table>
				</div>
			</div> 
        </div><!-- end of form form-mod -->
	