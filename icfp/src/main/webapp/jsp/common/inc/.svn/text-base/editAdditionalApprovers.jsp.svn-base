<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<%
	String servletContextUrl1 = request.getContextPath();
%>
<script type="text/javascript">
var contextURL = '<%=servletContextUrl1%>';
</script>
<script type="text/javascript" src="<%=servletContextUrl1%>/js/common/editAdditionalApprovers.js"></script>

<div class="form-mod">
			<h2 class="span12 collapsible">Additional Approvers</h2>
			<span class="sub">Select approvers in addition to IDAG members. Additional approvers may be legal entity directors or officers, as appropriate.</span>
			<c:if test="${sessionScope.section eq 'myTasks'}">
			<div class="row">
				<div class="span9">
				<div class="table-btn">
					 <a href="#addApprover" class="btn" data-toggle="modal" onclick="javascript:clearSearchResults();">Add Approver</a> 
				</div> <!-- end of block -->
				</div>
			</div>
			</c:if>
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
					<tbody id="fillAdditionalApprovers">
								 
									 <c:forEach var="additionalApprover" items="${currentAdditionalApprovers.userInfos}" >
											<tr>
											<td>
											<c:if test="${sessionScope.section eq 'myTasks'}">
											<a href="javascript:void(0);" class="delete-tr" id="deleteApproverID" onclick="deleteAdditionalApprover('${additionalApprover.ssoId}')" title="Delete this Approver" >X</a>
											</c:if>
											</td>
											
												<td>${additionalApprover.lastName}, ${additionalApprover.firstName}</td>
												<td>${additionalApprover.assignerLastName}, ${additionalApprover.assignerFirstName}</td>
										    </tr>
								</c:forEach>
								 
								</tbody>
				  </table>
				</div>
			</div> 
			<c:choose>
			<c:when test="${param.path != 'frontOffice'}">
			<div class="row">
				<div class="span8">
					<div class="form-row">
						<span class="required">*</span>
						<label>The list of additional approvers for Treasury legal entities is complete.</label>
						<c:if test="${sessionScope.section eq 'myTasks'}">
						<c:set target="${sessionScope.updateStatusForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
						<div class="radio-container">
							<label class="radio">
								  <html:radio  name="updateStatusForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" ></html:radio> Yes 
							</label>
							<label class="radio">
								  <html:radio name="updateStatusForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" ></html:radio> 	No
							</label>

						</div>
						</c:if>
						<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
						<c:set target="${sessionScope.updateStatusForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
						<div class="radio-container">
							<label class="radio">
								  <html:radio  name="updateStatusForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" disabled="true"></html:radio> Yes 
							</label>
							<label class="radio">
								  <html:radio name="updateStatusForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" disabled="true"></html:radio> 	No
							</label>

						</div>
						</c:if>
					</div>
				</div> <!-- end of block -->
			 </div>
						
		   </c:when>
		   <c:otherwise>
		   	<div class="row">
			   	<div class="span8">
				<div class="form-row">
					<label>The list of additional approvers for Treasury legal entities is complete.</label>
					<div class="radio-container">
					<c:set target="${sessionScope.updateStatusForm.map}" property="leBodGovernanceFlag" value="${sessionScope.deal.leBodGovernanceFlag}" />
					<label class="radio">
					<html:radio  name="updateStatusForm" styleId="leBodGovernanceID"  property="leBodGovernanceFlag" value="1" disabled="true"></html:radio> Yes 
					</label>
					<label class="radio">
					<html:radio name="updateStatusForm"  styleId="leBodGovernanceID"   property="leBodGovernanceFlag" value="0" disabled="true"></html:radio> 	No
					</label>
					</div>
				</div>
				</div>
		   	</div>
		   </c:otherwise>
		 </c:choose>	
			
			
			
			<div class="modal hide fade" id="addApprover">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Assign Approver<span></span></h3>
			</div>
			<div class="modal-body">
		<!-- 	<form> -->
				<div class="row">
					<div class="span8">
						<p>Search and select a person to assign as an Approver</p>
					</div>
				</div>
			<div class="row">
					<div class="span3">
						<%-- <html:select name="dealRequestForm" property="selectApprover" styleClass="span2 conditional-select" styleId="selectApprover">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:options name="dealRequestForm" property="searchCriteria"></html:options>
 						</html:select> --%>
					</div> <!-- end of block -->
					<div class="span3" >
						<!-- <select class="span3" id="firstLastName">
							<option>Last name, First name</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							
						</select> -->
						
						<select id="searchCriteria">
							<option value="">Select...</option>
							<c:forEach var="approverSearch" items="${staticdata:getSearchCriteria(pageContext)}">
								<option value='<c:out value="${approverSearch.ID}"></c:out>'>
								${approverSearch.name}
								</option>
							</c:forEach>
						</select>
												
					</div> 
					<div class="span3">
					<span id="searchTextErrorSpan">&nbsp;</span>
						<input type="text" class="span2" placeholder="" id="searchText" name ="searchText" >
						<input type="submit" class="btn conditional-btn" id="additionalApproverSerachID" value="Search"> 
				   </div>
				</div>
				<div id="additionalApproverID" class="conditional-row">
					<div class="row">
						<div class="span9">
						
							<label>Results [${fn:length( additionalApprovers.userInfos)}]</label>
							<span id="teamMemberIdErrorSpan">&nbsp;</span>
							<table class="table table-striped table-bordered sortable no-bottom">
								<thead>
									<tr>
										<th class="nosort" style="width:20px;"></th>
										<th>Business Unit</th>
										<th>Name</th>
									</tr>
								</thead>

					  
								 <tbody id="additionalApproverIDs">
								 
									 <c:forEach var="additionalApprover" items="${additionalApprovers.userInfos}" >
											<tr>
										
												<td><input type='checkbox' name='optionsRadios' value="${additionalApprover.ssoId}"></td>
												<td>${additionalApprover.ssoId}</td>
												<td>${additionalApprover.lastName},${additionalApprover.firstName}</td>
																			
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
				 <a href="#derivatives-table" class="btn right btn-success" id="saveAddApprovers" data-dismiss="modal">Save selection</a>
				 <a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
		
	</div>
			
        </div><!-- end of form form-mod -->