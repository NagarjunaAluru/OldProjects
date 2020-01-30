<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:form action="admin/admin.do" styleId="adminId" method="post">
<!-- Revoke Popup -->
	<div class="modal hide fade" id="removeReviewerpopup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Remove</h3>
		</div>
		<div class="modal-body">

			<div class="row">
				<div class="span5">
					<p>Are you sure you wish to remove this request from <span class="name"></span> queue? once removed, <span class="name"></span> will no longer be able to take any action on this request.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span> <label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="revokeComments" onblur="scriptInjection(this);"></textarea>
						<span class="req-error" id="sbCommentsError1">error</span> 
						<span style="color: red" id="errorComents"></span>
					</div>
				</div>
				<!-- end of block -->
				
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="removeTeamMember">Revoke</a> 
			<a href="#"	class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	</html:form>