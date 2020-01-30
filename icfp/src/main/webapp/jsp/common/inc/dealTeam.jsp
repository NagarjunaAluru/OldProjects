<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="form-mod">
			<h2 class="span12 collapsible">Deal Team</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Front Office </b><br />
							<c:if test="${not empty sessionScope.deal.frontOfficeAssignedSso}">
								${sessionScope.deal.frontOfficeAssignedSso}
							</c:if>
							<c:if test="${empty sessionScope.deal.frontOfficeAssignedSso}">
								--
							</c:if>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
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
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<c:set var="cmAvail" value="false"/>
						<p><b>Cash Management </b><br />
						<c:if test="${not empty sessionScope.deal.cashManagementAssignedSso}">
							${sessionScope.deal.cashManagementAssignedSso}
						</c:if>
						<c:if test="${empty sessionScope.deal.cashManagementAssignedSso}">
							--
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Treasury Tax</b><br />
						<c:if test="${not empty sessionScope.deal.treasuryTaxAssigned}">
							${sessionScope.deal.treasuryTaxAssigned}
						</c:if>
						<c:if test="${empty sessionScope.deal.treasuryTaxAssigned}">
							--
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
				
			</div>
		</div>