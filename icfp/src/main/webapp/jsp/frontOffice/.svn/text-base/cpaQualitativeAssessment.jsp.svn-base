<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="e" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<fmt:setLocale value="en-US"/>
<div class="form-mod">
			<h2 class="span12">Qualitative Assessment</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
						<th>Qualitative Factors</th>
						<th>Owner</th>
						<th>Assessment</th>
						<th>Rationale</th>
					  </tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.cpaLegRequestForm.map['cpaSummary'].map['qualitativeFactors']}" var="eachQualitativeFactor" varStatus="status" >
							<c:forTokens items="${param.factors}" delims="," var="factorName">
								<c:set var="factorID"><e:getQualitativeFactorID name="${factorName}"></e:getQualitativeFactorID> </c:set>
									<c:if test="${eachQualitativeFactor.map['qualitativeFactor'] eq factorName}">
										<tr>
											<td>${factorName}</td>
											<html:hidden  name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].qualitativeFactorId"  value="${factorID}" />
											<html:hidden  name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].qualitativeFactor"  value="${factorName}" />
											
											<html:hidden name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].ownerSso"  value="<%=UserContext.getCurrentUserContext().getId()%>" />
											
											<c:set var="userName" value="${userDetails:fullName(',','-')}" />
											<td>${userName}</td>
											<html:hidden  name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].ownerSso"  value="<%=UserContext.getCurrentUserContext().getId()%>" />
											<td>	
																				
													<div class="form-row">
													<span class="required">*</span>
													<span  class="help-block error" id="qFIdErrorSpan${eachQualitativeFactor.map['qualitativeFactorId']}" style="display:none;">Please select</span>
													<div class="radio-container conditional-required" id="qFIdErrorDiv${eachQualitativeFactor.map['qualitativeFactorId']}">
													    <logic:messagesPresent property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId">
																<span class="req-error" >a</span>
										 				</logic:messagesPresent>
														<label class="radio">
															<html:radio name="cpaLegRequestForm"
																 property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId"
																  onclick="" styleId="qualitativeFactor${eachQualitativeFactor.map['qualitativeFactorId']}" value="1" styleClass="condition"/>
															High
															<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="High"/>
														</label>
														<logic:messagesPresent property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId">
																<span class="req-error" >a</span>
										 				</logic:messagesPresent>
										 				
														<label class="radio">
															<html:radio name="cpaLegRequestForm" 
															property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId"
															 styleId="qualitativeFactor${eachQualitativeFactor.map['qualitativeFactorId']}" value="2" styleClass="condition"/>
															Medium
															<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="Medium"/>
														</label>
														<logic:messagesPresent property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId">
																<span class="req-error" >a</span>
										 				</logic:messagesPresent>
														<label class="radio">
															<html:radio name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].assessmentId" styleId="qualitativeFactor${eachQualitativeFactor.map['qualitativeFactorId']}" value="3"/>
															Low
															<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="Low"/>
														</label>
													</div>
													</div>
											</td>
											<td>
												<div class="form-row autosize-container">
													<span class="required conditional" id="commentsQualFacID" >*</span>
													<label>Rationale</label>
													<div class="char-count">500</div>
														<logic:messagesPresent property="cpaSummary.qualitativeFactors[${status.count-1}].comment">
																<span class="req-error" >a</span>
										 				</logic:messagesPresent>
													<html:textarea name="cpaLegRequestForm" property="cpaSummary.qualitativeFactors[${status.count-1}].comment" styleClass="autosize messageinput" styleId="qualitativeFactorComment${eachQualitativeFactor.map['qualitativeFactorId']}" onblur="scriptInjection(this);"></html:textarea>
													<span id="qualitativeFactorCommentFailedBar${eachQualitativeFactor.map['qualitativeFactorId']}" class="req-error" style="display:none;">error</span>
													<span id="commentErrorID" class="req-error" style="display:none;">error</span>
													<span style="color: red" id="errorComents"></span>
												</div>
											</td>
										</tr>
									</c:if>
							</c:forTokens>
						</c:forEach>
					 </tbody>
				  </table>
				  	
				</div>
			</div> 
			
        </div><!-- end of form form-mod -->
        
       
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontOffice/cpaQualitativeAssessment.js">

</script>	