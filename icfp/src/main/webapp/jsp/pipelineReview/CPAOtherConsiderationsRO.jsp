<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="CPALegSummary" value="${deal:fetchLegSummary(1, pageContext.request)}" scope="page"/>
<div class="display-row">

	<h2 class="span12">Other Considerations</h2>
	<div class="clear"></div>
	<div class="row">
			
		<div class="span5 left">
			<div class="form-row">
				<p>
					<b>Cross border</b>
				</p>				
				<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq 'Yes'}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/>
	                                 <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/>
                                	 <bean:message key="label.addLeg.no" /> </label>
                             </c:if>
                              <c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq 'No'}">
                                	<label class="radio"> <input type="radio" disabled=disabled />
                                	 <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled />
                                	<bean:message key="label.addLeg.no" /> </label>
                              </c:if> 
				</div>
			</div>
		</div>
		
		<div id="termDiv" class="span5 right">
					<div class="form-row">
						<div id="termMandatoryDiv"><span class="required">*</span></div>
						<label>
							<bean:message key="label.addLeg.term" /> 
							<span class="small"><bean:message key="label.addLeg.inMonths" /></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<input type="text" value="${CPALegSummary.term}" disabled="disabled"/>
						
					</div>
	 			</div>
		</div>
		
		<div class="row">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Non-Standard Legal Agreement</b>
				</p>
				
				<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<c:if test="${deal:getNonStandardDocsFlag(pageContext.request) eq 'Yes'}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/>
	                                 <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/>
                                	 <bean:message key="label.addLeg.no" /> </label>
                             </c:if>
                              <c:if test="${deal:getNonStandardDocsFlag(pageContext.request) eq 'No'}">
                                	<label class="radio"> <input type="radio" disabled=disabled />
                                	 <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled />
                                	<bean:message key="label.addLeg.no" /> </label>
                              </c:if> 
				</div>
			</div>
		</div>
		</div>
		<!-- end of block -->
		
		<!-- end of block -->
	</div>

<!-- display role ends here -->


<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
<c:choose>
	<c:when test="${nonStandardDocsFlag eq 'Yes'}">
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="view" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
