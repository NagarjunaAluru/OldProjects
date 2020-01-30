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


<div class="form-mod" style="width:100%;">
		<h2>Other Considerations</h2>

			<div>
				<div>

				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Cross border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></label>
							<div class="radio-container">
                              <div id="crossborderDiv" class="radio-container">
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="crossBorderFlag" property="crossBorderFlag" value="true"/>
									<bean:message key="label.addLeg.yes" />
								</label>
								<label class="radio">
									<html:radio name="ICFPLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlag" value="false"/>
									<bean:message key="label.addLeg.no" />
								</label>
							</div>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right ">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Subordinated Debt</label>
								<div id ="subordinatedDiv" class="radio-container">
									<span id="subordinatedfailed"></span>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="false"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div>
						</div>
					</div> <!-- end of block -->
				</div>
                
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
                                <label>Non-standard Legal Agreement(s)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></label>
                                <div id="legalAgreementDiv" class="radio-container exceptionsConditional">
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="legSummary.nonStandardAgreementsFlag" value="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div>
						</div>
					</div> <!-- end of block -->
				</div>                
                
			</div>
        </div>
	</div>
        
        
		<!--  Exceptions -->
      <jsp:include page="/jsp/common/legPageExceptions.jsp">
		<jsp:param value="edit" name="mode"/>
		<jsp:param value="${legNumber}" name="legIndex"/>      	
      </jsp:include>