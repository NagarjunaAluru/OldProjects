<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ page errorPage="../common/error.jsp" %>

<t:common/>
		
		<c:set var="legNumber" value="${requestScope.legNumber}" />
        <c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
        <c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
		<%-- <input type="hidden" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" /> --%>
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		<div class="form-mod">
			<%@ include file="../common/inc/newTransactionSummary.jsp"%>
			<h2 class="span12"><bean:message key="label.addLeg.details" /></h2>
			<h3><span class="conditional-lender"></span></h3>
			<c:if test="${legSummaryVO.entitySetupFlag != 'Y'}">
				<div id="1" class="tab-pane fade active in">
					  <div id="lenderGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCDR}">${legSummaryVO.lenderCDR}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLegalEntity}">${legSummaryVO.lenderLegalEntity}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<c:if test="${empty legSummaryVO.lenderLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderLEName}">${legSummaryVO.lenderLEName}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<c:if test="${empty legSummaryVO.lenderCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.lenderCountry}">${legSummaryVO.lenderCountry}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
							<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
										<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
										 a Regulated Entity?</b></p>
										 
									 <c:if test="${legSummaryVO.lenderRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                             </c:if>
		                            <c:if test="${legSummaryVO.lenderRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
									</c:if>
									
								</div>
							</div>
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Provider </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Purchaser </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Lender </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Lender </c:if>
									 a Principal Entity?</b></p>
									
									<c:if test="${legSummaryVO.lenderPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
									</c:if>
		                            <c:if test="${legSummaryVO.lenderPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                            </c:if>
									</div>
							</div><!-- end of block -->
						</div>
					</div> 
				</div>
				</c:if>
				
									
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<input type="text" disabled="disabled" value="${legSummaryVO.lenderMEName}"/>
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<c:if test="${empty legSummaryVO.lenderCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.lenderCapital}">${legSummaryVO.lenderCapital}</c:if>
					</div>
				</div> <!-- end of block -->
				
			</div>
			<div id="lenderTreasuryDetails">
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<c:if test="${empty legSummaryVO.lenderTCode}">-</c:if>
							<c:if test="${not empty legSummaryVO.lenderTCode}">${legSummaryVO.lenderTCode}</c:if>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
		</div><!-- end of form form-mod -->
		<div class="form-mod">
		<h3><bean:message key="label.addLeg.borrowerOrRecipient" /></h3>
			<%-- <ul class="nav nav-tabs tabs" >
				<li class="active"><a data-toggle="tab" href="#1a"><bean:message key="label.addLeg.search" /></a></li>
			</ul> --%>
			<div class="tab-content" id="">
				<div id="1a" class="tab-pane fade active in">
					<div id="borrowerGoldIdDetails" class="conditional-row">
					<c:if test="${legSummaryVO.borEntitySetupFlag != 'Y'}">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<c:if test="${empty legSummaryVO.borrowerCDR}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCDR}">${legSummaryVO.borrowerCDR}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<c:if test="${empty legSummaryVO.borrowerLegalEntity}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">${legSummaryVO.borrowerLegalEntity}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<c:if test="${empty legSummaryVO.borrowerLEName}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerLEName}">${legSummaryVO.borrowerLEName}</c:if>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<c:if test="${empty legSummaryVO.borrowerCountry}">-</c:if>
									<c:if test="${not empty legSummaryVO.borrowerCountry}">${legSummaryVO.borrowerCountry}</c:if>
								</div>
							</div><!-- end of block -->
						</div>
						</c:if>
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Regulated Entity?</b></p>

									<div class="radio-container">
										<c:if test="${legSummaryVO.borrowerRegulated eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.borrowerRegulated eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is 
									<c:if test="${legSummaryVO.legTypeId eq 1}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 2}"> Recipient </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 6}"> Issuer </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 5}"> Borrower </c:if>
									<c:if test="${legSummaryVO.legTypeId eq 4}"> Borrower </c:if>
									 a Principal Entity?</b></p>
									
									<div class="radio-container">
										<c:if test="${legSummaryVO.borrowerPrincipal eq 'Yes'}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.borrowerPrincipal eq 'No'}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					</div>
				</div>
				
			</div>
			
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /> &nbsp;	</label>
						<input type="text" disabled="disabled" value="${legSummaryVO.borrowerMEName}"/>
					</div>
				</div> <!-- end of block -->
				<div  id="borrowerCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="borrowerCapfailed" style="display:none;">Please select Capital or Industrial</span>
						<c:if test="${empty legSummaryVO.borrowerCapital}">-</c:if>
						<c:if test="${not empty legSummaryVO.borrowerCapital}">${legSummaryVO.borrowerCapital}</c:if>
					</div>
				</div> <!-- end of block -->
				
			</div>
			<div id="borrowerTreasuryDetails">
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
							<c:if test="${empty legSummaryVO.borrowerTCode}">-</c:if>
							<c:if test="${not empty legSummaryVO.borrowerTCode}">${legSummaryVO.borrowerTCode}</c:if>
						</div>
					</div><!-- end of block -->
				</div>
			</div>
			
		</div><!-- end of form form-mod -->
		<div class="form-mod">
		<h3 class="span12">Product Details</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.productType" /></label>
						<span  class="help-block error" id="productTypefailed" style="display:none;">Please select Product Type</span>
						
						<select disabled="disabled" class="span2">
							<option disabled="disabled"><c:if test="${empty legSummaryVO.productType}">Select..</c:if>
							<c:if test="${not empty legSummaryVO.productType}">${legSummaryVO.productType}</c:if>
							</option>
 						 </select> 
						<span id="productTypefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="formOfEquityDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label>Form of Equity</label>
						<select disabled="disabled" class="span2">
							<option disabled="disabled"><c:if test="${empty deal:getEquityFormId(param.id, pageContext.request)}">Select..</c:if>
							<c:if test="${not empty deal:getEquityFormId(param.id, pageContext.request)}">${deal:getEquityFormId(param.id, pageContext.request)}</c:if>
							</option>
 						 </select> 
						<span id="equityFormValidate" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
<%-- 			<c:choose>
				<c:when test="${deal:getEquityFormId(param.id, pageContext.request) != 4}">
					
			<div id="allProductTypeDiv" class="product-type-all">
				<h3 class="span12">Equity Details</h3>
				<div class="row">
					<div class="span12">
					 <table class="table table-striped table-bordered equity-validation">
						<thead>
						  <tr>
							<th class="header" style="width:35px;">Action</th>
							<th class="header">Share type</th>
							<th class="header">Number of shares</th>
							<th class="header">Par value per share</th>
						  </tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
							 <logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
				
						  <tr>
							<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:select name="equityDetails" property="shareTypeId" styleClass="span2 request-equity" styleId="shareTypeId" disabled="true">
										<html:option value="">Select..</html:option>
										<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
									</html:select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="numberOfShares" styleClass="span2 request-equity" styleId="numberOfShares" disabled="true"/>
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="shareValue" styleClass="span2 request-equity" styleId="shareValue" disabled="true"/>
								</div>
							</td>

						  </tr>
						 	</logic:iterate>
						</c:when>
						
						<c:otherwise>
						  <tr>
						  <td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<select name="shareTypeId" class="span2 request-equity" disabled="disabled">
										<option value="">Select...</option>
										<option value="1">Preferred</option>
										<option value="2">Cumulative Preferred</option>
										<option value="3">Common</option>
									</select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="numberOfShares" type="text" class="span2 request-equity" disabled="disabled">
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="shareValue" type="text" class="span2 request-equity" disabled="disabled">
								</div>
							</td>
						  </tr>
						</c:otherwise>
						</c:choose>
						</tbody>
					  </table>
					  <a class="left add" href="#">Add additional share type</a>
					</div>
				</div>
			</div>
			</c:when>
			<c:when test="${sessionScope.ICFPLegRequestForm.map['equityFormId'] == 4}">
			<div id="debtProductTypeDiv" class="product-type-debtfields">
				<h3 class="span12">Equity Details</h3>
				<div class="row">
					<div class="span12">
					 <table class="table table-striped table-bordered equity-validation">
						<thead>
						  <tr>
							<th class="header" style="width:35px;">Action</th>
							<th class="header">Debt terms</th>
							<th class="header">Share type</th>
							<th class="header">Number of shares</th>
							<th class="header">Par value per share</th>
						  </tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
						<logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
				
						  <tr>
							<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="debtTerms" styleClass="span2" styleId="numberOfShares" disabled="true"/>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:select name="equityDetails" property="shareTypeId" styleClass="span2" styleId="shareTypeId" disabled="true">
										<html:option value="">Select..</html:option>
										<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
									</html:select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="numberOfShares" styleClass="span2" styleId="numberOfShares" disabled="true" />
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<html:text name="equityDetails" property="shareValue" styleClass="span2" styleId="shareValue" disabled="true" />
								</div>
							</td>

						  </tr>
						  	</logic:iterate>
						</c:when>
						
						<c:otherwise>
						<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="debtTerms" type="text" class="span2" disabled="disabled">
								</div>
							</td>
							<td>
								<div class="form-row">
									<select name="shareTypeId" class="span2" disabled="disabled">
										<option value="">Select...</option>
										<option value="1">Preferred</option>
										<option value="2">Cumulative Preferred</option>
										<option value="3">Common</option>
									</select>
								</div>
							</td>
							<td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="numberOfShares" type="text" class="span2" disabled="disabled">
								</div>
							</td><td>
								<div class="form-row">
									<span class="required">*</span>
									<input name="shareValue" type="text" class="span2" disabled="disabled">
								</div>
							</td>
						</c:otherwise>
						</c:choose>
						</tbody>
					  </table>
					  <a class="left add" href="#">Add additional share type</a>
					</div>
				</div> 
			</div> 
			</c:when>
			</c:choose> --%>
			<div id="termDiv" class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.term" /> <span class="small"><bean:message key="label.addLeg.inMonths" /></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<input type="text" value="${legSummaryVO.termsInMths}" disabled="disabled" />
						<span id="termValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div id="commenstDiv" class="row comment-container product-type-comments" style="display:none;">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Description</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2" rows="1" data-max="500" disabled="disabled"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="row">
				<div id="subordinateDiv" style="display:none;">
						<div class="span5 conditional-select-rca">
							<div class="form-row">
								<span class="required">*</span>
								<label>Subordinated Debt</label>
								<span  class="help-block error" id="subordinatedfailed" style="display:none;">Please select Subordinated Debt</span>
								<div id ="subordinatedDiv" class="radio-container">
									<span id="subordinatedfailed"></span>
								<c:if test="${legSummaryVO.isSubordinatedDebt eq true}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                                 </c:if>
                                <c:if test="${legSummaryVO.isSubordinatedDebt eq false}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                                </c:if>
								</div>
							</div>
						</div> <!-- end of block -->
					</div>
					<div  class="span5 right">
					<div id="dealcurrencyDiv" class="form-row">
							<span class="required">*</span>
							<label><bean:message key="label.addLeg.dealCurrency" /></label>
							<span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select Deal currency </span>
							
							<input type="text" value="${legSummaryVO.originalCurrency}" disabled="disabled" />
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
					</div>
					</div>
			</div>
			<div class="row">
				<div id="amountDiv" class="span5 right">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.amount" />
							<span data-original-title="<bean:message key="tooltip.addLeg.amount" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Amount</span>
						<span  class="help-block error" id="originalCCYAmountValidateNumber" style="display:none;">Invalid value </span>
							<input type="text" value="${legSummaryVO.originalAmount}" disabled="disabled" />
					<%-- 	<html:text name="ICFPLegRequestForm" maxlength="9" property="legSummary.originalCCYAmount" styleClass="span2" styleId="originalCCYAmount" disabled="true"/> --%>
						<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			<div>
				<div class="row">
					<div id="existDiv" class="span5" style="display:none;">
						<%-- <div class="form-row">
							<span class="required">*</span>
							<label><bean:message key="label.addLeg.isThisAnExisting" /> <span class="conditional-type-variable"></span>?</label>
							<span  class="help-block error" id="existingfailed" style="display:none;">Please select Is this an existing</span>
							<div id="existingDiv" class="radio-container">
								<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="true" disabled="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.existingFlag" styleId="existingFlag" value="false" disabled="true"/>
								<bean:message key="label.addLeg.no" />
							</label>
							</div>
						</div> --%>
					</div> <!-- end of block -->
					<div class="span5 right" id="usdEquiDiv" style="display:none;">
					<div class="form-row">
							<p><b>USD equivalent</b></p>
							 	<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
								<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
						</div>
					</div><!-- end of block -->
				</div>
				<div id="derDiv" class="row" style="display:none;">
					<div id="derDivEquity" class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Are there Derivatives?</label>
							<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Are there Derivatives?</span>
							<%-- <c:if test="${legSummaryVO.derivatives eq true}">
						          <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
					               <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
					          </c:if>
					           <c:if test="${legSummaryVO.derivatives eq false}">
					                    <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
					                   	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
					          </c:if>   --%>
					          
					             <c:if test="${legSummaryVO.derivatives eq true}">
			                                <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
		                                <c:if test="${legSummaryVO.derivatives eq false}">
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                                	<label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                                </c:if>
						</div>
					</div> <!-- end of block -->
					<div id="doubleLeverageDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<span class="required">*</span>
							<label>Double Leverage</label>
							<div id="doubleLeverage" class="radio-container">
							<c:if test="${deal:getDoubleLeverageFlag(param.id, pageContext.request) eq true}">
			                    <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
		                    <c:if test="${deal:getDoubleLeverageFlag(param.id, pageContext.request) eq false}">
		                        <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>  
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row" id="derivatives-table" style="display:none;">
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<span id="derFlagValidate" class="req-error" style="display:none;">error</span>
								<input type="button" value="Add A Derivative" tabindex="18" class="btn" disabled="disabled">
								
							</div>
						</div> <!-- end of block -->
					</div>
					<c:set var="DerExistsFlag" value="0" />
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2" colspan="2">Action</th>
							<th rowspan="2">Item No.</th>
							<th rowspan="2">Derivatives</th>
							<th rowspan="2">Derivative Type</th>
							<th colspan="3" class="nosort">Currency 1</th>
							<th colspan="3" class="nosort">Currency 2</th>
							<th rowspan="2">Hedge Designation</th>
							<th rowspan="2">Tax Designation</th>
						  </tr>
						  <tr>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
						  </tr>
						</thead>
						<tbody>
						<c:set var="derivativeDetailsVOList" value="${deal:fetchDerivatives(legNumber, pageContext)}" />
						<c:choose>
							<c:when test="${not empty derivativeDetailsVOList}">
								<c:forEach var="derivative" items="${derivativeDetailsVOList}">
									<tr>
										<td></td>
										<td></td>
										<td id="itemNoId">${derivative.derivativeNumber}</td>
										<c:set var="DerExistsFlag" value="${derivative.derivativeNumber}" />
										<td>${derivative.internalOrExternal}</td>
										<td>${derivative.derivativeType}</td>
										<td>${derivative.currency1}</td>
										<td>${derivative.derivativeAmount1}</td>
										<td>${derivative.fixedOrFloat1}</td>
										<td>${derivative.currency2}</td>
										<td>${derivative.derivativeAmount2}</td>
										<td>${derivative.fixedOrFloat2}</td>
										<td>${derivative.hedgeDesigation}</td>
										<td>${derivative.taxDesigation}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>	
							</c:otherwise>
						</c:choose>
						
						</tbody>
					  </table>
					</div>
				</div> 
			</div> 
			<div class="conditional-type-equity">
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Are there Derivatives?</label>
							<div class="radio-container">
							<c:if test="${legSummaryVO.derivatives eq true}">
			                     <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                          <label class="radio" style="font-weight:normal;"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                      </c:if>
		                       <c:if test="${legSummaryVO.derivatives eq false}">
		                           <label class="radio" style="font-weight:normal;"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                            <label class="radio" style="font-weight:normal;"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                        </c:if>
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row" id="derivatives-table">
					<div class="span12">
					<table class="table table-striped table-bordered sortable no-bottom">
						<thead>
						  <tr>
							<th rowspan="2">Item No.</th>
							<th rowspan="2">Derivatives</th>
							<th rowspan="2">Derivatives Type</th>
							<th colspan="3" class="nosort">Currency 1</th>
							<th colspan="3" class="nosort">Currency 2</th>
							<th rowspan="2" class="nosort">Hedge Designation</th>
							<th rowspan="2" class="nosort">Tax Designation</th>
						  </tr>
						  <tr>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
							<th>Currency</th>
							<th>Amount</th>
							<th>Fixed/Float</th>
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>
							<td>[value]</td>						
						  </tr>
						</tbody>
					  </table>
					</div>
				</div> 
			</div> 
			
			 <div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Non-standard Legal Agreement(s)</label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
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
				<div id="eBoardEligibleDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<p><b>eBoardroom eligible</b></p>
							${deal:getEBoardApprovalRequiredFlag(param.id, pageContext.request)}
						</div>
					</div> <!-- end of block -->
			</div>
			 <div class="row">
			<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Cross border</label>
						<span  class="help-block error" id="crossBorderFailed" style="display:none;">Please select Cross border</span>
						<div id="crossBorderDiv" class="radio-container">
							<span id="crossBorderFailed"></span>
							<c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq true}">
	                                <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
                             </c:if>
                              <c:if test="${deal:getCrossBorderFlagValue(pageContext.request) eq false}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
                              </c:if>
						</div>

					</div>
				</div> <!-- end of block -->
				</div>
				
				 <c:if test="${legSummaryVO.isNonStandardAgreementsFlag eq true}">  
		<%@ include file="../common/inc/exceptionDetails.jsp"%>
	 </c:if>
		 
		    <!-- attachments rca start of block -->
		    <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
		    <!-- need to add param for the form to differentiate -->
		
		
		
		<div class="span8 right btn-container">
		
		
		<!-- <input disabled="disabled" type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal');">
		<input disabled="disabled" type="button" value="Save and add another Leg" class="btn right" onclick="javascript:validate('?command=saveAndAddAnotherLeg');">
		 -->
		
	<!--	<button type="submit" name="command" value="saveAndReturnToDeal"  class="btn right btn-success" >Save and return to Deal</button>
	 	<html:button styleClass="btn right" property="command" onclick="javascript:validate();">Save and add another Leg</html:button> 
		<button type="button" name="command" class="btn right" value="saveAndAddAnotherLeg" onclick="javascript:validate();">Save and add another Leg</button> 
	 -->	
		
		<!-- 	<html:submit property="command" styleClass="btn right btn-success" value="saveAndReturnToDeal" />
			<html:submit property="command" styleClass="btn right" value="saveAndAddAnotherLeg"/>  
			<a href="javascript:window.history.back();" class="btn-link right cancel">Cancel</a>
		-->
		
		<!-- <input disabled="disabled" type="button" value="Save as draft" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');"> -->
		<!-- <a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a> -->
		<!-- <a class="btn-link right cancel"  onclick="history.back();">Cancel</a> -->
			
		</div>
   <hr>
    
	
    <div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
		</div>
      </div>
  
  </body>
</html>

