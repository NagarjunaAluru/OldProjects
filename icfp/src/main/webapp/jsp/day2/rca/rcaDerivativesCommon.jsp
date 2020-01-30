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
<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/rcaRequestor.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

<div id="derivatives-table" style="display:none;">
           <h2 class="span12 collapsible">Add a Derivatives</h2>  
           <div class="row">  
					<div class="span12">
					<div class="row">
						<div class="span9">
							<div class="table-btn">
								<span class="required">*</span>
								
								<span id="derFlagValidate" class="req-error" style="display:none;">error</span>
								<input type="button" value="Add a Derivative" tabindex="18" class="btn" onclick="javascript:addDerivatives('?command=addDerivatives');">
								
							</div>
						</div> <!-- end of block -->
					</div>
					<c:set var="DerExistsFlag" value="0" />
					 <%int count = 0; %>
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
									<%count++; %>
									<tr id='dealDeriv'${derivative.derivativeNumber}>
										<td>
										<a href="#derDeleteConfirm${derivative.derivativeNumber}" class="delete-leg modal-confirm" title="Delete this Derivative" data-toggle="modal">Delete</a> </td>
										<td><a href="javascript:void(0);" id="edit-derivative" class="edit-leg ttip" data-original-title="Edit this derivative" onclick="javascript:modifyDerivative(this);"></a>
										</td>
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
									<div class="modal hide fade deleteConfirm" id="derDeleteConfirm${derivative.derivativeNumber}">
										<div class="modal-header" >
											<a class="close" href="javascript:closeDerConfirm('derDeleteConfirm${derivative.derivativeNumber}')">X</a>
											<h3>Delete this Derivative</h3>
										</div>
										<div class="modal-body" style="margin-top:-15px;">
											<div class="row">
												<p><b>Are you sure you want to Delete?</b><br>
											</p>
											</div>
										</div>
										<div class="modal-footer">
											<a href="#" class="btn right btn-success" id="delete-legBtn"  data-dismiss="modal"  onclick="javascript:deleteDerivative(${derivative.derivativeNumber});">Yes, Delete this Derivative</a>
											<a href="javascript:closeDerConfirm('derDeleteConfirm${derivative.derivativeNumber}')"  class="btn-link right cancel">No, take me back to the Leg</a>
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
					  <input type="hidden" name="derivativeCount" id="derivativeCountID" value="<%=count%>"/>
					</div>
				</div> 
				</div>
                          