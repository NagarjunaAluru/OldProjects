<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
<div class="form-mod">
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
          		<h2 class="span12">
						<bean:message key = "columnHeader.transactionLegs.details" />
				</h2>
				<div class="clear"></div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p>
								<b><bean:message key = "label.addLeg.productType" /></b><br /> ${legSummaryVO.productType}
							</p>
						</div>
					</div>
					<!-- end of block -->
					
						<div class="span5 right">
							<div class="form-row">
								<p>
									<b>Deal Currency</b><br /> 
									<c:if test="${empty legSummaryVO.originalCurrency}">-</c:if>
									<c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
								</p>
							</div>
						</div>
					<!-- end of block -->
				</div>
				<div class="row">
				<c:choose>
						  <c:when test="${legSummaryVO.productType eq 'EQUITY'}">
				<div class="span5">
						<div class="form-row">
							<p>
								<b>Form of Equity</b><br />  ${deal:getEquityFormId(param.id, pageContext.request)}
							</p>
						</div>
					</div>
					</c:when>
					 <c:otherwise>
					<div class="span5">
						<div class="form-row">
							<p>
								<b><bean:message key = "label.addLeg.term" /></b><br />  
									<c:if test="${empty legSummaryVO.termsInMths}">-</c:if>
									<c:if test="${not empty legSummaryVO.termsInMths}">${legSummaryVO.termsInMths}</c:if>
							</p>
						</div>
					</div>
                </c:otherwise>
					</c:choose>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b><bean:message key = "label.addLeg.amount" /></b><br />  
									<c:if test="${empty legSummaryVO.originalAmount}">-</c:if>
									<c:if test="${not empty legSummaryVO.originalAmount}">${legSummaryVO.originalAmount}</c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p>
								<b><c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}">  Purchaser </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if><br />  </b>
									<c:if test="${empty legSummaryVO.lenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLegalEntity}">${legSummaryVO.lenderLegalEntity}</c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b><bean:message key = "label.addLeg.usdEquivalent" /></b><br />  
									<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
									<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p>
								<b><c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
								<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if></b><br />
									<c:if test="${empty legSummaryVO.borrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">${legSummaryVO.borrowerLegalEntity}</c:if>
							</p>
						</div>
					</div>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b><bean:message key = "label.addLeg.areDerivatives" /></b><br />  ${legSummaryVO.derivatives}
							</p>
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div class="row highlighted">
				<c:choose>
				 <c:when test="${legSummaryVO.productType eq 'EQUITY'}">
					<div class="span5 left">
						<div class="form-row">
							<p><b>Is this an existing Equity?</b><br />
							${legSummaryVO.existing}</p>
						</div>
				    </div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>Double Leverage</b><br />  ${deal:getDoubleLeverageFlag(param.id, pageContext.request)}
							</p>
						</div>
					</div>
					</c:when>
					<c:otherwise>
				  </c:otherwise>
				  </c:choose>
				  </div>
					<!-- end of block -->
					<!-- end of block -->
					<c:choose>
						  <c:when test="${legSummaryVO.productType eq 'EQUITY'}">
				   <div class="row">
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>eBoardroom Eligible</b><br />  ${deal:getEBoardApprovalRequiredFlag(param.id, pageContext.request)}
							</p>
						</div>
					</div>
					</div>
					</c:when>
					<c:otherwise>
				  </c:otherwise>
				  </c:choose>
					
					<!-- end of block -->
				
				<c:if test="${param.page eq 'transactionCapture'}">		
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<div class="entitylookup">
							<p style="display:none" class="leGoldId">${legSummaryVO.lenderLegalEntity}</p>	
							<div class="ME conditional-row">
								<p style="display:none">${legSummaryVO.lenderMEName}</p>
							</div>

							<p><span class="required">*</span><b>Lender/Provider Treasury Code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span></p>
							<br />							
							<span  class="help-block error" style="display:none;"></span>			
							<input type="text" maxlength="20"  class="span3" name="lenderTCode"
								data-provide="typeahead" style="text-transform:uppercase"
								data-source="" value="${legSummaryVO.lenderTCode}"/>
							<span class="req-error" style="display:none;">error</span>

							</div>
						</div>
					</div>
					<!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<div class="entitylookup">
							<p style="display:none" class="leGoldId">${legSummaryVO.borrowerLegalEntity}</p>	
							<div class="ME conditional-row">
								<p style="display:none">${legSummaryVO.borrowerMEName}</p>
							</div>

							<p><span class="required">*</span><b>Borrower/Recipient Treasury Code</b><span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span></p>
							<br />							
							<span  class="help-block error" style="display:none;"></span>			
							<input type="text" maxlength="20"  class="span3" 
								data-provide="typeahead" style="text-transform:uppercase" name="borrowerTCode"
								data-source="" value="${legSummaryVO.borrowerTCode}"/>
							<span class="req-error" style="display:none;">error</span>							
							
							</div>
							
						</div>
					</div>					
				</div>

				</c:if>
				<c:if test="${param.page ne 'transactionCapture'}">
					<html:hidden property="lenderTCode" styleId="lenderTCodeId" value="${not empty legSummaryVO.lenderTCode ? legSummaryVO.lenderTCode : '-'}"/>
					<html:hidden property="borrowerTCode" styleId="borrowerTCodeId" value="${not empty legSummaryVO.borrowerTCode ? legSummaryVO.borrowerTCode : '-'}"/>
				</c:if>
				</div>
				
		