<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!-- Assign a Reviewer Popup -->
	<div class="modal hide fade" id="assignReviewer">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Assign Reviewer</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Select a team member to assign this deal to:</p>
				</div>
				
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Team member</label>
  							 <html:select name="dealRequestForm" styleId="teamMemberId" property="uniqueId"  styleClass="span2">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="teamMemberList" >
									<html:optionsCollection name="teamMemberList" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							<span id="teamMemberIdErrorSpan" class="req-error" style="display:none;">error</span>
					</div>
				</div>
				<!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="assignToTeamMember" data-dismiss="modal">Assign to team member</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>