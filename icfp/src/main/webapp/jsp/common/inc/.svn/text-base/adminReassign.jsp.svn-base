<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:form action="admin/admin.do" styleId="adminId" method="post">
<!-- Assign a Reviewer Popup -->
	<div class="modal hide fade" id="assignReviewerpopup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Reassign Approver</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Select a new approver for the <span class="roleDisplay"></span>&nbsp;role.</p>
				</div>
				
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Role: <span class="roleDisplay"></span> </label>
  							<html:select styleId="teamMemberId" property="teamMemberValue"  styleClass="span2">
								<html:option value="">Select</html:option>
								<c:forEach var="teamMembersList" items="${adminform.reasignList}" varStatus="listId">
								<option value="${teamMembersList.SSOID}">${teamMembersList.lastName}, ${teamMembersList.firstName}</option>
								</c:forEach>
							</html:select>
							<span id="teamMemberIdErrorSpan" class="req-error" style="display:none;">error</span>
					</div>
				</div>
				<!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="assignToTeamMember" data-dismiss="modal">Save selection</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	</html:form>