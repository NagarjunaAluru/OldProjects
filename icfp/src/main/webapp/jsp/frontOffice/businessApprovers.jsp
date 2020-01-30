<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<%
	String servletContextUrl1 = request.getContextPath();
%>
<script type="text/javascript">
var contextURL = '<%=servletContextUrl1%>';
</script>
<script src="<%=servletContextUrl1%>/js/businessApprovers.js" type="text/javascript"></script>

<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Business Approvers</h2>
			<span class="sub">Select additional Business approvers (e.g., Business Controller, Business Tax) in addition to the Business CFO</span>
			<div class="row">
				<div class="span9">
				<div class="table-btn">
					 <a href="#addBusinessApprover" class="btn" data-toggle="modal" onclick="javascript:clearBusinessSearchResults();">Add Approver</a> 
				</div> <!-- end of block -->
				</div>
			</div>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
						<th class="nosort"></th>
						<th>Name</th>
						<th>Added By</th>
					  </tr>
					</thead>
					<tbody id="fillBusinessApprovers">
						 <c:forEach var="businessApprover" items="${businessApproversList}" >
						 		<c:if test="${businessApprover.opCode ne 'DELETE'}">
								<tr>
								<td><a href="#" class="delete-tr" id="deleteApproverID" onclick="javascript:deleteApprover('${businessApprover.SSOID}','${businessApprover.group}');" title="Delete this Approver" >X</a></td>
									<td>${businessApprover.lastName} ${businessApprover.firstName}</td>
									<td>${businessApprover.assignerLastName} ${businessApprover.assignerFirstName}</td>
							    </tr>
							    </c:if>
						</c:forEach>
					</tbody>
				  </table>
				</div>
			</div> 
			
		<div class="modal hide fade" id="addBusinessApprover">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Assign an Approver<span></span></h3>
			</div>
			<div class="modal-body">
			<!-- 	<form> -->
				<div class="row">
					<div class="span8">
						<p>Search and select a person to assign as an Approver</p>
					</div>
				</div>
				<div class="row">
					<div class="span3" >
						<select id="businessSearchCriteria">
							<option value="">Select...</option>
							<c:forEach var="businessApproverSearch" items="${staticdata:getSearchCriteria(pageContext)}">
								<option value='<c:out value="${businessApproverSearch.ID}"></c:out>'>
								${businessApproverSearch.name}
								</option>
							</c:forEach>
						</select>
					</div> 
					<div class="span3">
					<span id="searchTextErrorSpan">&nbsp;</span>
						<input type="text" class="span2" placeholder="" id="businessSearchText" name ="businessSearchText" >
						<input type="submit" class="btn conditional-btn" id="businessApproverSerachID" value="Search"> 
				   </div>
				</div>
				<div id="businessApproverID" class="conditional-row">
					<div class="row">
						<div class="span9">
							<label>Results [${fn:length(requestScope.businessApprovers)}]</label>
							<span id="teamMemberIdErrorSpan">&nbsp;</span>
							<table class="table table-striped table-bordered sortable no-bottom">
								<thead>
									<tr>
										<th class="nosort" style="width:20px;"></th>
										<th>Business Unit</th>
										<th>Name</th>
									</tr>
								</thead>
								 <tbody id="businessApproverIDs">
									 <c:forEach var="businessApprover" items="${requestScope.businessApprovers}" >
											<tr>
												<td><input type='radio' name='optionsRadios' value="${businessApprover.SSOID}"></td>
												<td>${businessApprover.group}</td>
												<td>${businessApprover.lastName},${businessApprover.firstName}</td>
										    </tr>
									</c:forEach>
								</tbody> 
							</table>
						</div><!-- end of block -->
					</div>
				</div> 
			<!-- </form> -->
			</div>
			<div class="modal-footer">
				 <a href="#" class="btn right btn-success" id="saveBusinessApprovers" data-dismiss="modal">Save selection</a>
				 <a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
</div><!-- end of form form-mod -->