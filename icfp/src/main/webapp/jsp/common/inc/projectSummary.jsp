<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<t:common/>


<div class="form-mod">
	<h2 class="span12">Project Summary</h2>

			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Transaction Owner</b><br>
							${sessionScope.deal.lastName},${sessionScope.deal.firstName}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right highlighted">
				<div class="form-row"></br></br>
				</div>
				</div>
			</div>
			<div class="row ">
				<div class="span5">
					<div class="form-row">
						<p>
							<c:choose>
							<c:when test="${param.page eq 'cpa'}">
							<b>Request ID</b>
							</c:when>
							<c:otherwise>
							<b>Deal ID</b>
							</c:otherwise>
							</c:choose>
							<br />
							${sessionScope.deal.uniqueId}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p style="word-wrap:break-word;">
							<c:choose>
							<c:when test="${param.page eq 'cpa'}">
							<b>Description</b>
							</c:when>
							<c:otherwise>
							<b>Deal Name</b>
							</c:otherwise>
							</c:choose>
							<br />
							${sessionScope.deal.dealName}
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<c:choose>
			<c:when test="${param.page eq 'cpa'}">
			<div class="row highlighted">
			<div class="span5">
					<div class="form-row">
						<p style="word-wrap: break-word">
							<b>Request Category</b>
							<br />
							${sessionScope.deal.dealCategory}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p style="word-wrap: break-word">
							<b>Request Rationale</b>
							<br />
							${sessionScope.deal.dealRationale}
						</p>
					</div>
				</div>
				<!-- end of block -->
				
			</div>
			</c:when>
			<c:otherwise>
			<div class="row highlighted">
			<div class="span5">
					<div class="form-row">
						<p style="word-wrap: break-word">
							<b>Deal Rationale</b>
							<br />
							${sessionScope.deal.dealRationale}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>Deal Category</b>
							<br />
							${sessionScope.deal.dealCategory}
						</p>
					</div>
				</div>
				<!-- end of block -->
				
			</div>
			</c:otherwise>
			
			</c:choose>
			
		<c:choose>
		<c:when test="${param.page eq 'cpa'}">
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p>
						<b>Vault Request ID</b><br />
					
					   <c:choose>
          					<c:when test="${empty sessionScope.deal.vaultId}">
								--
							</c:when>
							<c:otherwise>
								${sessionScope.deal.vaultId}
							</c:otherwise>
					   </c:choose>	
						
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			</c:when>
			</c:choose>	
</div>
<!-- end of form form-mod -->
