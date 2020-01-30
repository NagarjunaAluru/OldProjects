<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
	<h2 class="span12 collapsible collapsed">Business Approvers</h2>
	<div class="row">
		<div class="span12">
		 <table class="table table-striped table-bordered sortable">
			<thead>
			  <tr>
				<th>Name</th>
				<th>Added By</th>
			  </tr>
			</thead>
			<tbody>
				 <c:forEach var="businessApprover" items="${businessApproversList}" >
						<tr>
							<td>${businessApprover.lastName} ${businessApprover.firstName}</td>
							<td>${businessApprover.assignerLastName} ${businessApprover.assignerFirstName}</td>
					    </tr>
				</c:forEach>
			</tbody>
		  </table>
		</div>
	</div> 
</div><!-- end of form form-mod -->