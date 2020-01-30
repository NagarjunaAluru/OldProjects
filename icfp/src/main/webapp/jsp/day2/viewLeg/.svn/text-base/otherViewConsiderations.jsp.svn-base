<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

<div class="form-mod" style="width:100%;">
		<h2>Other Considerations</h2>

			<div>
				<div>

				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Cross border</label>
								<c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq 'Yes'}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq 'No'}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right ">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Subordinated Debt</label>
			                    <c:if test="${legSummaryVO.isSubordinatedDebt eq true}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
						</div>
					</div> <!-- end of block -->
				</div>
                
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
                                <label>Non-standard Legal Agreement(s)</label>
                                <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">
									 <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
                                <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq false}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
						</div>
					</div>
				</div>                
                
			</div>
        </div>
	</div>
        
<c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">  
			<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="view" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>
	 </c:if>