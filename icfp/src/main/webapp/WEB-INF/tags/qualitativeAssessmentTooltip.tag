<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="factorId" required="true" rtexprvalue="true" %>
<%@attribute name="priority" required="true" rtexprvalue="true" %>

<c:choose>
	<c:when test="${factorId eq '1'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Transaction includes Prudentially Regulated Entities."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="Transaction does not include any Prudentially Regulated Entities."></span>
		</c:if>
	</c:when>
	<c:when test="${factorId eq '2'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Transaction includes insolvent entities OR entities without clear ownership."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="Default to low risk."></span>
		</c:if>
	</c:when>
	<c:when test="${factorId eq '3'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Transactions in countries with Obligor Ratings greater than or equal to 13."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="Default to low risk."></span>
		</c:if>
	</c:when>
	<c:when test="${factorId eq '4'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Requires external financial statement disclosure, involves GEFM, or includes Prudentially Regulated Entities."></span>
		</c:if>
		<c:if test="${priority eq 'Medium'}">
			<span class="ttip info" title="Cross border transactions."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="No cross border transactions."></span>
		</c:if>
	</c:when>
	<c:when test="${factorId eq '5'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Transaction utilizes derivatives AND contains 5 or more ME's; OR transaction includes insolvent entities."></span>
		</c:if>
		<c:if test="${priority eq 'Medium'}">
			<span class="ttip info" title="Transaction utilizes derivatives OR contains 5 or more ME's."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="Transaction does not include derivatives and has fewer than 5 ME's."></span>
		</c:if>
	</c:when>
	<c:when test="${factorId eq '7'}">
		<c:if test="${priority eq 'High'}">
			<span class="ttip info" title="Transaction contains non-standard T's & C's requiring on-going manual intervention to operationalize."></span>
		</c:if>
		<c:if test="${priority eq 'Medium'}">
			<span class="ttip info" title="Transaction not managed on Wall Street Systems OR contains non-standard T's & C's."></span>
		</c:if>
		<c:if test="${priority eq 'Low'}">
			<span class="ttip info" title="Transaction managed on Wall Street Systems with standard T's & C's."></span>
		</c:if>
	</c:when>
</c:choose>
