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
<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="originalViewTransactionOptional.jsp">
			<jsp:param name="productType" value="${param.productType}"/>
		</jsp:include>
		
		<jsp:include page="originalViewLenderBorrower.jsp" />
                
		<div class="form-mod">
			<h2 class="span12">Description</h2>
			
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<label>Currency</label>
							<input type="text" disabled="disabled" value="${legSummaryVO.originalCurrency}"/>
						</div>
					</div> <!-- end of block --> 
					<div class="span5 right">
						<div class="form-row">
							<label>Amount</label>
							<input type="text" disabled="disabled" value="${legSummaryVO.originalAmount}" />
							</div>
					</div> <!-- end of block -->                                        
			</div>
			<div class="row">
					<div class="span5 right">
						<div class="form-row">
							<label>USD Equivalent</label>
							<c:if test="${empty legSummaryVO.usdEquivalent}">-</c:if>
							<c:if test="${not empty legSummaryVO.usdEquivalent}">${legSummaryVO.usdEquivalent}</c:if>
						</div>
					</div> <!-- end of block -->
			</div>
			<c:if test="${legSummaryVO.legTypeId eq 2}">
			 <div class="row">
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>eBoardroom Eligible</b><br />  ${deal:getEBoardApprovalRequiredFlag(requestScope.legNumber, pageContext.request)}
							</p>
						</div>
					</div>
			</div>
			</c:if>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<div class="form-row autosize-container">
                           		<label>&nbsp;</label>
                            	<div class="char-count" style="margin-left:-10px;">1000</div>
                            	<textarea disabled="disabled" >${day2legSummaryVO.debtEquityOtherComments}</textarea>
                        	</div>
						</div>
					</div> <!-- end of block -->
				</div>
			<c:if test="${legSummaryVO.legTypeId ne 2}">
				<div class="row">
					<div class="span5">
						<div class="form-row">
                            <span class="required">*</span>
							<label>Request Derivatives</label>
							<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
			                    <label class="radio"> <input type="radio" checked disabled=disabled/> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio"  disabled=disabled/> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>
		                    <c:if test="${legSummaryVO.derivatives eq 'No'}">
		                        <label class="radio"> <input type="radio" disabled=disabled /> <bean:message key="label.addLeg.yes" /> </label>
		                        <label class="radio"> <input type="radio" checked disabled=disabled /> <bean:message key="label.addLeg.no" /> </label>
		                    </c:if>                           
						</div>
					</div> <!-- end of block -->
				</div>
			</c:if>
				
		</div><!-- end of form form-mod -->
        
        <c:if test="${legSummaryVO.legTypeId ne 2}">
		<div class="form-mod" id="derivativesTableDiv">
        
			<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<span id="derFlagValidate" class="req-error" style="display:none;">error</span>
								<input type="button" disabled="disabled" value="Add a Derivative" tabindex="18" class="btn">
								
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
						<c:set var="derivativeDetailsVOList" value="${deal:fetchDerivatives(requestScope.legNumber, pageContext)}" />
						<c:choose>
							<c:when test="${not empty derivativeDetailsVOList}">
								<c:forEach var="derivative" items="${derivativeDetailsVOList}">
									<tr id='dealDeriv'${derivative.derivativeNumber}>
										<td id='dealDeriv'${derivative.deriativesSeqId}>
		   		                         <td><a title="View this leg" href="${pageContext.request.contextPath}/derivativeRequest.do?command=openDerivative&view=true&derivativeNumber=${derivative.derivativeNumber}&legNumber=${requestScope.legNumber}&actionId=${actionId}&source=${param.source}" class="view-file"></a>  </td>
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
									<div class="modal hide fade" id="derDeleteConfirm">
										<div class="modal-header" >
											<a class="close" data-dismiss="modal">X</a>
											<h3>Delete this Derivative</h3>
										</div>
										<div class="modal-body" style="margin-top:-15px;">
											<div class="row">
												<p><b>Are you sure you want to Delete?</b><br>
											</p>
											</div>
										</div>
										<div class="modal-footer">
											<a href="#" class="btn right btn-success" data-dismiss="modal" id="delete-legBtn" onclick="javascript:deleteDerivative(${derivative.derivativeNumber});">Yes, Delete this Derivative</a>
											<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
										</div>
									</div>
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
					  <input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
					</div>
				</c:if> 
        </div>
       </c:if>

    <c:if test="${param.productType ne '2'}">
		<jsp:include page="viewTermsAndConditions.jsp" />
		</c:if>
		<jsp:include page="otherViewConsiderations.jsp" />
                
						  <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="legIndex" value="${legNumber}" />
			<jsp:param name="mode" value="edit" />
		</jsp:include>  
		<!-- end uploads -->
	<jsp:include page="../../day2CancelReadOnlyTabs.jsp" />	

		

