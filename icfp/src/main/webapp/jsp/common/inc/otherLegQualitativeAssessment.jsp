<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hydus.wff.core.context.UserContext"%>
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
					  <c:forTokens items="${param.factors}" delims="," var="i" varStatus="status">
					  	<c:set var="factorID"><e:getQualitativeFactorID name="${i}"></e:getQualitativeFactorID> </c:set>
					  	<tr>
							<td>${i}</td>
							<html:hidden  name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].qualitativeFactorId"  value="${factorID}" />
							<html:hidden  name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].qualitativeFactor"  value="${i}" />
							<c:set var="userName" value="${userDetails:fullName(',','-')}" />
							<td>${userName}</td>
							<html:hidden  name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].ownerSso"  value="<%=UserContext.getCurrentUserContext().getId()%>" />
							<td>	
																
									<div class="form-row">
									<span class="required">*</span>
									<span  class="help-block error" id="qFIdErrorSpan${status.count-1}" style="display:none;">Please select</span>
									<div class="radio-container conditional-required" id="qFIdErrorDiv${status.count-1}">
									    <logic:messagesPresent property="legSummary.qualitativeFactors[0].assessmentId">
												<span class="req-error" >a</span>
						 				</logic:messagesPresent>
										<label class="radio">
											<html:radio name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].assessmentId" styleId="high${status.count-1}" value="1"/>
											High
										</label>
										<logic:messagesPresent property="legSummary.qualitativeFactors[0].assessmentId">
												<span class="req-error" >a</span>
						 				</logic:messagesPresent>
						 				
										<label class="radio">
											<html:radio name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].assessmentId" styleId="medium${status.count-1}" value="2"/>
											Medium
										</label>
										<logic:messagesPresent property="legSummary.qualitativeFactors[0].assessmentId">
												<span class="req-error" >a</span>
						 				</logic:messagesPresent>
										<label class="radio">
											<html:radio name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].assessmentId" styleId="low${status.count-1}" value="3"/>
											Low
										</label>
									</div>
									</div>
							</td>
							<td>
								<div class="form-row autosize-container">
									<span class="required conditional" id="commentsQualFacID">*</span>
									<label>Rationale</label>
									<div class="char-count">500</div>
										<logic:messagesPresent property="legSummary.qualitativeFactors[0].comment">
												<span class="req-error" >a</span>
						 				</logic:messagesPresent>
									<html:textarea name="ICFPLegRequestForm" property="legSummary.qualitativeFactors[${status.count-1}].comment" styleClass="autosize messageinput" styleId="qualitativeFactorComment${status.count-1}" onblur="scriptInjection(this);"></html:textarea>
									<span id="qualitativeFactorCommentFailedBar${status.count-1}" class="req-error" style="display:none;">error</span>
									<span style="color: red" id="errorComents"></span>
								</div>
							</td>
						</tr>
					  </c:forTokens>						
					 </tbody>
				  </table>
				  <div class="form-row">
					<label data-original-title="This is an tooltip with more information" class="checkbox apply-to-all-legs" id="applyToAllLegs">
						<html:checkbox name="ICFPLegRequestForm" property="legSummary.applyQA"  styleId="optionsCheckbox"/>
						Apply this Qualitative Assessment to all Legs<span class="ttip info" title="This is an tooltip with more information"></span>
					</label>
				  </div>	
				</div>
			</div> 
			
        </div><!-- end of form form-mod -->
        
        <div class="modal hide fade" id="applyAssessment">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Apply Assessment</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Please select how you would like to apply this assessment.</p>
				</div>
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Select one</label>
						<div class="radio-container">
							<label class="radio">
								<input type="radio" value="remaining" name="qApplyAssessment" id="qApplyAssessment1" class="condition">
								Apply to remaining Legs
							</label>
							<label class="radio">
								<input type="radio" value="all" name="qApplyAssessment" id="qApplyAssessment1" class="condition">
								Apply to all Legs
							</label>
						</div>
					</div>
				</div><!-- end of block -->
				<input type="hidden" name="radioValue" id="radioValueId">
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success">Apply</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/otherLegQualitativeAssessment.js">

</script>	