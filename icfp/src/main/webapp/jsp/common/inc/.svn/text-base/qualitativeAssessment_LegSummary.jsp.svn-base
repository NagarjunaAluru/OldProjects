<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="e" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/assessments" prefix="assessments" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
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
					  <c:forTokens items="${param.factors}" delims="," var="i">
					  	<c:set var="factorID"><e:getQualitativeFactorID name="${i}"></e:getQualitativeFactorID> </c:set>
					  	<c:choose>
							<c:when test="${ param.legType eq 'CPA' }">
					  			<c:set var="assessmentId" value="${assessments:isChecked(sessionScope.curLeg.CPASummary.qualitativeFactors, factorID)}"/>
					  		</c:when>
					  		<c:otherwise>
					  			<c:set var="assessmentId" value="${assessments:isChecked(sessionScope.curLeg.legSummary.qualitativeFactors, factorID)}"/>
					  		</c:otherwise>
					  	</c:choose>		
					  	<tr>
							<td>${i}<input type="hidden" name="qFactorId" value='${factorID}'/></td>
							<c:set var="userName" value="${userDetails:fullName(',','-')}" />
							<td>${userName}</td>
							<td>	
																
									<div class="form-row">
									<span class="required">*</span>
									<div id="qualitativeDiv" class="radio-container conditional-required">	
										<label class="radio">
											<input type="radio" name="qAssessment" value="1" class="condition"
											 ${assessmentId eq 1 ? "checked=checked" : "" } />High
											<%-- <e:isChecked label ="High" value="1" /> --%>
											<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="High"/>
										</label>
										<label class="radio">
											<input type="radio" name="qAssessment" value="2" class="condition"
											 ${assessmentId eq 2 ? "checked=checked" : "" } />Medium
											<%-- <e:isChecked label="Medium" value="2" /> --%>
											<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="Medium"/>
										</label>
										<label class="radio">
											<input type="radio" name="qAssessment" value="3" 
											 ${assessmentId eq 3 ? "checked=checked" : "" }/>Low
											<%-- <e:isChecked label="Low" value="3" /> --%>
											<e:qualitativeAssessmentTooltip factorId="${factorID}" priority="Low"/>
										</label>
									</div>
									</div>
							</td>
							<td>
								<div class="form-row autosize-container">
									<span class="required conditional">*</span>
									<label>Rationale</label>
									<div class="char-count">500</div>
									<c:choose>
										<c:when test="${ param.legType eq 'CPA' }">
											<textarea class="autosize messageinput " id="rationale" name="rationale" rows="1" onblur="scriptInjection(this);">${assessments:getComment(sessionScope.curLeg.CPASummary.qualitativeFactors, factorID)}</textarea>
										</c:when>
										<c:otherwise>
											<textarea class="autosize messageinput " id="rationale" name="rationale" rows="1" onblur="scriptInjection(this);">${assessments:getComment(sessionScope.curLeg.legSummary.qualitativeFactors, factorID)}</textarea>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
						</tr> 
					  </c:forTokens>						
					 </tbody>
				  </table>
				  <c:if test="${ param.legType ne 'CPA' }">
				  <div class="form-row">
					<label data-original-title="This is an tooltip with more information" class="checkbox apply-to-all-legs" id="applyToAllLegs">
						<input type="checkbox" value="option1" id="optionsCheckbox" class="" >
						Apply this Qualitative Assessment to all Legs<span class="ttip info" title="When this box is checked, the selected value (high; medium; low) for the qualitative assessment(s) will be applied to all the legs of this financing request."></span>
					</label>
				  </div>
				  </c:if>	
				</div>
			</div> 
			
        </div><!-- end of form form-mod -->
        
        <div class="modal hide fade" id="applyAssessment">
		<div class="modal-header">
			<a class="close" href="javascript:closeAapplyAssessmentModal()">X</a>
			<h3>Apply Assessment</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			
			<div class="row">
				<div class="span5"><p>Please select how you would like to apply this assessment.</p>
				</div>
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Select one</label>
						<div class="radio-container">
							<label class="radio">
								<input type="radio" value="remaining" name="qApplyAssessment" class="condition">
								Apply to remaining Legs
							</label>
							<label class="radio">
								<input type="radio" value="all" name="qApplyAssessment">
								Apply to all Legs
							</label>
						</div>
					</div>
				</div><!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success">Apply</a>
			<a class="btn-link right cancel" href="javascript:closeAapplyAssessmentModal()">Close window</a>
		</div>
	</div>
	
<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/common/qualitativeAsessmentLegSummary.js">
</script>	