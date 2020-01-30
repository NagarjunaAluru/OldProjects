<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
	<h2 class="span12 collapsible">Additional Approvers</h2>
	<span class="sub"><bean:message key="label.additionalApprover.treasuryLagalFourBlocker" /></span>
	<div class="row">
		<div class="span9">
		<div class="table-btn">
			 <a href="#addApprover" class="btn" data-toggle="modal">Add Approver...</a> 
			 <!-- <button type="submit" name="command" value="addLeg" tabindex="18" class="btn">Add a leg...</button> -->
			 <!--  <button type="submit" class="btn">Add Approver...</button> -->
		</div> <!-- end of block -->
		</div>
	</div>
	<div class="row">
		<div class="span12">
		 <table class="table table-striped table-bordered sortable approver-table">
			<thead>
			  <tr>
				<th class="nosort" style="width:20px;"></th>
				<th>Name</th>
				<th>Added By</th>
			  </tr>
			</thead>
			<tbody>
			
			<%-- <logic:notEmpty name="fourBlockerForm" property="roleInfos" >
			<logic:iterate name="fourBlockerForm" property="msgHeader" id="additionalApprover" indexId="itemNo">
			  <tr>
				<td><a class="delete-tr" title="Delete this exception" href="#">X</a></td>
				<td><bean:write name="userInfoDataId" property="roleInfos"/></td>
                <td><bean:write name="userInfoDataId" property="msgHeader"/></td>
              </tr>
				<!-- <td>additionalApprover</td>
				<td>Nagarjuna</td>
			  </tr> -->
			  </logic:iterate>
			  </logic:notEmpty> --%>
			</tbody>
		  </table>
		</div>
	</div> 
	<div class="row">
		<div class="span8">
			<div class="form-row">
				<span class="required">*</span>
				<label>Legal Entity Board of Director goverance has been met and is complete/accurate?</label>
				<div class="radio-container">
					<label class="radio">
						<input type="radio" name="optionsRadios" value="option1">
						Yes
					</label>
					<label class="radio">
						<input type="radio" name="optionsRadios" value="option1">
						No
					</label>
				</div>
			</div>
		</div> <!-- end of block -->
	</div>
</div><!-- end of form form-mod -->