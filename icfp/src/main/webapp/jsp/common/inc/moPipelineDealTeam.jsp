<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
	<div class="form-mod">
			<h2 class="span12 collapsible">Deal Team</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Middle Office </b><br />
						<c:if test="${not empty sessionScope.deal.middleOfficeAssignedSso}">
							${sessionScope.deal.middleOfficeAssignedSso}
						</c:if>
						<c:if test="${empty sessionScope.deal.middleOfficeAssignedSso}">
							--
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			
		</div>