<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@include file="../../common/includeCssScripts.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="alert fade in alert-danger hide">
    <a href="#" data-dismiss="alert" class="close">X</a>
    <strong>Please select atleast one member for reaffirmation.</strong> 
</div>
<div>
select the individuals to affirm this deal.
</div>
<div class="row">
	<div class="span9">
		 <table class="table table-striped table-bordered sortable no-bottom">
			<thead>
			  <tr>
				<th><input type="checkbox" id="select-all-checkbox" onclick="javascript:selectAllClicked()"></th>
				<th>Group</th>
				<th>Name</th>
			  </tr>
			</thead>
			<tbody>
				<logic:present name="reaffirmApprovers" scope="request" >
					<logic:iterate id="reaffirmApprover" name="reaffirmApprovers" scope="request" indexId="i">
						<tr>
							<td id="select-checkbox" width="10%"><input type="checkbox" name="reaffirmApproverList" id="optionsCheckboxID+${i}" value="${reaffirmApprover.group}" onclick="javascript:individualClicked()"></td>
							<td width="45%">${reaffirmApprover.group}</td>
							<td width="45%">${reaffirmApprover.firstName},${reaffirmApprover.lastName}</td>
						</tr>
					</logic:iterate>
				</logic:present>
				</tbody>
		  </table>
 	</div><!-- end of block -->
</div>
<div class="row comment-container">
	<div class="span5" id="reaffirmCommentError">
		<div class="form-row autosize-container">
		 	<span class="required">*</span>
			<label>Comments</label>
			<span class="help-block error" id="reaffromErrorMess" style="display:none;">Please enter comment</span>
			<div class="char-count">500</div>
			<textarea class="xlarge autosize messageinput" name="textarea2"	rows="4" id="reaffirmCommentsID" onblur="scriptInjection(this);"></textarea>
			<span class="req-error" id="reaffirmCommentsRedStrip" style="display:none;">error</span> 
		</div>
	</div>
	<!-- end of block -->
</div>
