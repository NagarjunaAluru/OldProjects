<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:common/>		
		<div class="form-mod">
			<h2 class="span12 collapsible">Transaction Summary</h2>
			<c:choose>
		<c:when test="${param.page eq 'cpa'}">
		<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.crossBorder" /></b><br />		
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
							  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="1" />
							  </c:when>
							   <c:when test="${getCrossBorderFlagValue eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="0" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>						
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.nonStandardLegalAgreement" /></b><br />	
						<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${nonStandardDocsFlag eq 'Yes'}">
						   <bean:message key="label.addLeg.yes" />
						    <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="1" />
						  </c:when>
						  <c:when test="${nonStandardDocsFlag eq 'No'}">
						    <bean:message key="label.addLeg.no" />
						     <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="0" />
						  </c:when>
						  <c:otherwise>
						  <bean:message key="label.newRequests.data" />
						  </c:otherwise>
						</c:choose>
						
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.impairmentHistory" /></b><br />
						<c:set var="getImpairmentHistoryFlag" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getImpairmentHistoryFlag eq 'Yes'}">
							  <bean:message key="label.addLeg.yes" />
							  </c:when>
							  <c:when test="${getImpairmentHistoryFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
								
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.prudentiallyRegulatedLegalEntity" /></b><br />
						
						<c:set var="getPrudentialEntityFlag" value="${deal:getPrudentialEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrudentialEntityFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="1" />
							  </c:when>
							  <c:when test="${getPrudentialEntityFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="0" />
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
					<p style="word-wrap: break-word">
						<c:set var="getImpairmentHistoryFlag" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
						<b><bean:message key="label.pipelineReviewDeal.impairmentComment" /></b><br />
						<c:choose>
							<c:when test="${getImpairmentHistoryFlag eq 'Yes'}">
								${sessionScope.deal.impairmentComment}
							</c:when>
							<c:otherwise>
								<bean:message key="label.newRequests.data" />
							</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.principalLegalEntity" /></b><br />
						<c:set var="getPrincipalEntityFlag" value="${deal:getPrincipalEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrincipalEntityFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="1"/>
							  </c:when>
							  <c:when test="${getPrincipalEntityFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="0"/>
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>						
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.financialStatementsDateYear" /></b><br />
						<c:set var="getFinalStatementFlag" value="${deal:getFinalStatementFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getFinalStatementFlag eq 'Yes'}">
							  <bean:message key="label.addLeg.yes" />
							  </c:when>
							  <c:when test="${getFinalStatementFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
				
						</p>
					</div>
				</div><!-- end of block -->
				<c:if test="${param.formName ne 'pipeline' }">
	 			<div class="span5 right">
					<div class="form-row">
		 			<p><b>Cash Pool Participant Insolvent</b><br />
					<c:set var="getBorrowerInsolvencyFlag" value="${deal:getBorrowerInsolvencyFlag(pageContext.request)}" />
					<c:choose>
					  <c:when test="${getBorrowerInsolvencyFlag eq 'Yes'}">
					  <bean:message key="label.addLeg.yes" />
					  </c:when>
					  <c:when test="${getBorrowerInsolvencyFlag eq 'No'}">
					    <bean:message key="label.addLeg.no" />
					  </c:when>
					  <c:otherwise>
					<bean:message key="label.newRequests.data" />
					  </c:otherwise>
					</c:choose>
					</p>
					</div>
				</div>
				</c:if>
	 	 	</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<c:set var="getFinalStatementFlag" value="${deal:getFinalStatementFlag(pageContext.request)}" />
						<p><b><bean:message key="label.pipelineReviewDeal.latestDateFinancialStatement" /></b><br />
						<c:choose>
							<c:when test="${getFinalStatementFlag eq 'Yes'}">
						    	${deal:formatXMLGregorianCalendar(sessionScope.deal.latestDtOfFinSttmnt, 'MM/dd/yyyy')}
							</c:when>
							<c:otherwise>
								<bean:message key="label.newRequests.data" />
							</c:otherwise>
						</c:choose></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
				<div class="form-row"><br><br>
				</div>
				</div>
			</div>
	</c:when>
		<c:otherwise>
	
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.securityType" /></b><br />	
						<c:set var="getSecurityTypeFlag" value="${deal:getSecurityTypeFlag(pageContext.request)}" />
						<c:choose>
							  <c:when test="${getSecurityTypeFlag eq 'Yes'}">
							    <bean:message key="label.secured" />
							    <html:hidden  name="dealRequestForm" property="securityCategoryId"  value="1" />
							  </c:when>
							  <c:when test="${getSecurityTypeFlag eq 'No'}">
							    <bean:message key="label.unsecured" />
							    <html:hidden  name="dealRequestForm" property="securityCategoryId"  value="2" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
							</p>
					</div>
				</div><!-- end of block -->
				
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.equityInfusion" /></b><br/>
						
						<c:set var="getEquityInfusionsDividendsFlag" value="${deal:getEquityInfusionsDividendsFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getEquityInfusionsDividendsFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden styleId="equityInfusionsDividendsFlagID" name="dealRequestForm"  property="equityInfusionsDividendsFlag" value="1" />
							  </c:when>
							  <c:when test="${getEquityInfusionsDividendsFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden styleId="equityInfusionsDividendsFlagID" name="dealRequestForm"  property="equityInfusionsDividendsFlag" value="0" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
					</div>
				</div><!-- end of block -->
			</div>
			
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.impairmentHistory" /></b><br />
						
						<c:set var="getImpairmentHistoryFlag" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getImpairmentHistoryFlag eq 'Yes'}">
							  <bean:message key="label.addLeg.yes" />
							  </c:when>
							  <c:when test="${getImpairmentHistoryFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
							</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.prudentiallyRegulatedLegalEntity" /></b><br />
						<c:set var="getPrudentialEntityFlag" value="${deal:getPrudentialEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrudentialEntityFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="1" />
							  </c:when>
							  <c:when test="${getPrudentialEntityFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden styleId="prudentiallyID" name="dealRequestForm" property="prudentiallyRegulatedEntityFlag" value="0" />
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
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
						<c:set var="getImpairmentHistoryFlag" value="${deal:getImpairmentHistoryFlag(pageContext.request)}" />
						<b><bean:message key="label.pipelineReviewDeal.impairmentComment" /></b><br />
						<c:choose>
							<c:when test="${getImpairmentHistoryFlag eq 'Yes'}">
								${sessionScope.deal.impairmentComment}
							</c:when>
							<c:otherwise>
								<bean:message key="label.newRequests.data" />
							</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.principalLegalEntity" /></b><br />
						<c:set var="getPrincipalEntityFlag" value="${deal:getPrincipalEntityFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getPrincipalEntityFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="1"/>
							  </c:when>
							  <c:when test="${getPrincipalEntityFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden styleId="principalID" name="dealRequestForm" property="principalLegalEntityFlag"  value="0"/>
							  </c:when>
							  <c:otherwise>
							  <bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
                     </p>
					</div>
				</div><!-- end of block -->
	 	 		</div>
	 	 		
	 	 		<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.financialStatementsDateYear" /></b><br />
						
						<c:set var="getFinalStatementFlag" value="${deal:getFinalStatementFlag(pageContext.request)}" />
							<c:choose>
							  <c:when test="${getFinalStatementFlag eq 'Yes'}">
							  <bean:message key="label.addLeg.yes" />
							  </c:when>
							  <c:when test="${getFinalStatementFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
				
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.subordinatedDebt" /></b><br />
						<c:set var="subOrdinateDebtFlag" value="${deal:getSubOrdinateDebtFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${subOrdinateDebtFlag eq 'Yes'}">
						   <bean:message key="label.addLeg.yes" />
						    <html:hidden styleId="isSubOrdinateDebtID" name="dealRequestForm" property="subordinatedDebtFlag" value="1"/>
						  </c:when>
						  <c:when test="${subOrdinateDebtFlag eq 'No'}">
						    <bean:message key="label.addLeg.no" />
						    <html:hidden styleId="isSubOrdinateDebtID" name="dealRequestForm" property="subordinatedDebtFlag" value="0"/>
						  </c:when>
						  <c:otherwise>
						 <bean:message key="label.newRequests.data" />
						 				  </c:otherwise>
						</c:choose>
					</div>
				</div><!-- end of block -->
	 	 		</div>
	 	 		
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
						<c:set var="getFinalStatementFlag" value="${deal:getFinalStatementFlag(pageContext.request)}" />
						<b><bean:message key="label.pipelineReviewDeal.latestDateFinancialStatement" /></b><br />
						<c:choose>
							<c:when test="${getFinalStatementFlag eq 'Yes'}">
								${deal:formatXMLGregorianCalendar(sessionScope.deal.latestDtOfFinSttmnt, 'MM/dd/yyyy')}
							</c:when>
							<c:otherwise>
								<bean:message key="label.newRequests.data" />
							</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
					<c:if test="${param.formName ne 'pipeline' }">
	 			<div class="span5 right">
					<div class="form-row">
		 			<p><b>Borrower Insolvent</b><br />
					<c:set var="getBorrowerInsolvencyFlag" value="${deal:getBorrowerInsolvencyFlag(pageContext.request)}" />
					<c:choose>
					  <c:when test="${getBorrowerInsolvencyFlag eq 'Yes'}">
					  <bean:message key="label.addLeg.yes" />
					  </c:when>
					  <c:when test="${getBorrowerInsolvencyFlag eq 'No'}">
					    <bean:message key="label.addLeg.no" />
					  </c:when>
					  <c:otherwise>
					<bean:message key="label.newRequests.data" />
					  </c:otherwise>
					</c:choose>
		
					</div>
				</div>
				</c:if>
			</div>
			
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.nonStandardLegalAgreement" /></b><br />
						
						<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
						<c:choose>
						  <c:when test="${nonStandardDocsFlag eq 'Yes'}">
						   <bean:message key="label.addLeg.yes" />
						    <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="1" />
						  </c:when>
						  <c:when test="${nonStandardDocsFlag eq 'No'}">
						    <bean:message key="label.addLeg.no" />
						     <html:hidden styleId="nonStandardDocsFlagID" name="dealRequestForm" property="nonStandardDocsFlag" value="0" />
						  </c:when>
						  <c:otherwise>
						  <bean:message key="label.newRequests.data" />
						  </c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<c:choose>
				<c:when test="${param.formName ne 'pipeline' }">
	 			<div class="span5 right">
					<div class="form-row">
		 			<p><b>Qualitative Notching</b><br />
		 			${not empty deal:getQualitativeNotching(pageContext.request) ? deal:getQualitativeNotching(pageContext.request) : '-'}
					</p>
					</div>
				</div>
				</c:when>
				<c:otherwise>
				<div class="span5 right">
				<div class="form-row"><br><br>
				</div>
				</div>
				</c:otherwise>
				</c:choose>
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.derivatives" /></b><br />
						<c:set var="getDerivativesRequestsFlag" value="${deal:getDerivativesRequestsFlag(pageContext.request)}" />
						<c:choose>
							  <c:when test="${getDerivativesRequestsFlag eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="derivativesNeededFlag"  value="1" />
							  </c:when>
							  <c:when test="${getDerivativesRequestsFlag eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="derivativesNeededFlag"  value="0" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
						
	                     </p>
					</div>
					
				</div><!-- end of block -->
				
				<div class="span5 right">
					<div class="form-row">
						<p><b><bean:message key="label.pipelineReviewDeal.crossBorder" /></b><br />
						<c:set var="getCrossBorderFlagValue" value="${deal:getCrossBorderFlagValue(pageContext.request)}" />
						<c:choose>
							  <c:when test="${getCrossBorderFlagValue eq 'Yes'}">
							    <bean:message key="label.addLeg.yes" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="1" />
							  </c:when>
							   <c:when test="${getCrossBorderFlagValue eq 'No'}">
							    <bean:message key="label.addLeg.no" />
							    <html:hidden  name="dealRequestForm" styleId="derivativesFlagID" property="crossBorderFlag"  value="0" />
							  </c:when>
							  <c:otherwise>
							<bean:message key="label.newRequests.data" />
							  </c:otherwise>
							</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				
			</div>
			</c:otherwise>
	</c:choose>
		</div>		
